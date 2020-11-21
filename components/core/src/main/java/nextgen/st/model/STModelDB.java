package nextgen.st.model;

import nextgen.utils.Neo4JUtil;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.event.TransactionData;
import org.neo4j.graphdb.event.TransactionEventHandler;

import java.util.*;

import static nextgen.st.model.STValueType.*;

public class STModelDB extends STModelNeoFactory {

   private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STModel.class);

   public STModelDB(String dbDir) {
      super(dbDir);

      getDatabaseService().registerTransactionEventHandler(new TransactionEventHandler.Adapter<>() {
         @Override
         public Object beforeCommit(TransactionData data) throws Exception {

//                System.out.println("deletedNodes");
//                data.deletedNodes().forEach(node -> System.out.println(Neo4JUtil.toString(node)));
//                System.out.println("deletedRelationships");
//                data.deletedRelationships().forEach(relationship -> System.out.println(Neo4JUtil.toString(relationship)));
//
//                System.out.println("createdNodes");
//                data.createdNodes().forEach(node -> System.out.println(Neo4JUtil.toString(node)));
//                System.out.println("createdRelationships");
//                data.createdRelationships().forEach(relationship -> System.out.println(Neo4JUtil.toString(relationship)));

            return super.beforeCommit(data);
         }

         @Override
         public void afterCommit(TransactionData data, Object state) {
            super.afterCommit(data, state);
         }

         @Override
         public void afterRollback(TransactionData data, Object state) {
            super.afterRollback(data, state);
         }
      });

      cleanup();
   }

   @Override
   public STValue findOrCreateSTValueByValue(String value) {
      return super.findOrCreateSTValueByValue(value)
            .setType(PRIMITIVE);
   }

   public String getSTModelValue(STModel stModel, String parameterName, String defaultValue) {

      final STTemplate stTemplate = stModel.getStTemplate();

      final Optional<STParameter> foundParameter = stTemplate
            .getParameters()
            .filter(stParameter -> stParameter.getName()
                  .equals(parameterName))
            .findAny();
      if (!foundParameter.isPresent()) return defaultValue;

      return stModel
            .getArguments()
            .filter(stArgument -> stArgument.getStParameter().equals(foundParameter.get()))
            .map(stArgument -> stArgument.getValue()
                  .getValue())
            .findFirst()
            .orElse(defaultValue);
   }

   public String getSTModelName(STModel stModel, String defaultValue) {
      return getSTModelValue(stModel, "name", defaultValue);
   }

   public String getSTModelPackage(STModel stModel, String defaultValue) {
      final String found = getSTModelValue(stModel, "package", null);
      if (found != null) return found;
      return getSTModelValue(stModel, "packageName", defaultValue);
   }


   public STFile newSTFile(String name, String type, String path, String packageName) {
      return newSTFile()
            .setUuid(UUID.randomUUID()
                  .toString())
            .setName(newSTValue(name))
            .setType(findOrCreateSTValueByValue(type))
            .setPath(newSTValue(path))
            .setPackageName(newSTValue(packageName));
   }


   public STArgument newSTArgument(STParameter stParameter, final Collection<STArgumentKV> kvs) {
      final STArgument stArgument = newSTArgument().setStParameter(stParameter);
      for (STArgumentKV kv : kvs) stArgument.addKeyValues(kv);
      return stArgument;
   }

   public STArgument newSTArgument(STParameter stParameter, STValue stValue) {
      return newSTArgument()
            .setStParameter(stParameter)
            .setValue(stValue);
   }

   public STValue newSTValue(STModel stModel) {
      return newSTValue()
            .setType(STMODEL)
            .setStModel(stModel);
   }

   public STValue newSTValue(String value) {
      if (value == null || value.trim()
            .length() == 0) return null;
      return newSTValue()
            .setType(PRIMITIVE)
            .setValue(value);
   }

   public STValue newSTValue(STEnumValue stEnumValue) {
      return newSTValue()
            .setType(ENUM)
            .setValue(stEnumValue.getLexical() == null || stEnumValue.getLexical()
                  .trim()
                  .length() == 0 ? stEnumValue.getName() : stEnumValue.getLexical());
   }

   public void cleanup() {
      doInTransaction(transaction -> {

         findAllSTTemplate().filter(stTemplate -> !stTemplate.hasUuid()).forEach(stTemplate -> stTemplate.setUuid(UUID.randomUUID().toString()));
         findAllSTParameter().filter(node -> !node.hasUuid()).forEach(node -> node.setUuid(UUID.randomUUID().toString()));
         findAllSTParameterKey().filter(node -> !node.hasUuid()).forEach(node -> node.setUuid(UUID.randomUUID().toString()));

         deleteUnnusedNodes();
         deleteUnnusedFiles();
      });
   }

   public void deleteUnnusedFiles() {
      findAllSTFile().forEach(stFile -> {
         if (stFile.getIncomingFilesSTModel().iterator().hasNext()) return;
         log.info("deleting unnused stFile-" + stFile.getUuid());
         log.info(Neo4JUtil.toString(stFile.getNode()));
         stFile.getNode().getRelationships().forEach(Relationship::delete);
         stFile.getNode().delete();
      });

      findAllSTGroupFile().forEach(stGroupFile -> {
         if (stGroupFile.hasUuid()) return;
         stGroupFile.delete();
      });
   }

   public void deleteUnnusedNodes() {
      getDatabaseService().getAllNodes()
            .forEach(node -> {
               if (node.getRelationships().iterator().hasNext()) return;
               if (isSTProject(node)) return;
               log.info("deleting unnused node");
               log.info(Neo4JUtil.toString(node));
               node.delete();
            });
   }

   public STModel cloneSTModel(String stModelUuid) {
      return clone(findSTModelByUuid(stModelUuid));
   }

   public STModel clone(STModel stModel) {

      final STTemplate stTemplate = stModel.getStTemplate();
      final STModel clone = newSTModel().setStTemplate(stTemplate);

      // ensure cloned-arguments are in same order as stModel-arguments:
      stModel
            .getArgumentsSorted()
            .forEach(stArgument -> stTemplate
                  .getParameters()
                  .filter(stParameter -> stArgument.getStParameter().equals(stParameter))
                  .findFirst()
                  .ifPresent(stParameter -> {
                     switch (stParameter.getType()) {
                        case SINGLE:
                        case LIST:
                           clone.addArguments(newSTArgument(stParameter, stArgument.getValue()));
                           break;
                        case KVLIST:
                           final Collection<STArgumentKV> kvs = new ArrayList<>();
                           stParameter
                                 .getKeys()
                                 .forEach(stParameterKey -> stArgument
                                       .getKeyValues()
                                       .filter(stArgumentKV -> stArgumentKV.getStParameterKey().equals(stParameterKey))
                                       .findAny()
                                       .ifPresent(stArgumentKV -> kvs.add(newSTArgumentKV().setStParameterKey(stParameterKey).setValue(stArgumentKV.getValue()))));
                           clone.addArguments(newSTArgument(stParameter, kvs));
                           break;
                     }

                  }));

      return clone;
   }
}