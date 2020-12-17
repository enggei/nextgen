package nextgen.model;

import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.event.TransactionData;
import org.neo4j.graphdb.event.TransactionEventHandler;

import static nextgen.model.STValueType.*;

public class STModelDB extends STModelNeoFactory {

   private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STModel.class);

   public STModelDB(String dbDir) {
      super(dbDir);
      getDatabaseService().registerTransactionEventHandler(getTransactionEventHandler());
      cleanup();
   }

   private org.neo4j.graphdb.event.TransactionEventHandler.Adapter<Object> getTransactionEventHandler() {
      return new org.neo4j.graphdb.event.TransactionEventHandler.Adapter<Object>() {
         @Override
         public Object beforeCommit(org.neo4j.graphdb.event.TransactionData data) throws Exception {
            return super.beforeCommit(data);
         }

         @Override
         public void afterCommit(org.neo4j.graphdb.event.TransactionData data, Object state) {
            super.afterCommit(data, state);
         }

         @Override
         public void afterRollback(org.neo4j.graphdb.event.TransactionData data, Object state) {
            super.afterRollback(data, state);
         }
      };
   }

   @Override
   public STValue findOrCreateSTValueByValue(String value) {
      return super.findOrCreateSTValueByValue(value)
            .setType(PRIMITIVE);
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
      if (value == null || value.trim().length() == 0) return null;
      return newSTValue()
            .setType(PRIMITIVE)
            .setValue(value);
   }

   public STValue newSTValue(STEnumValue value) {
      if (value == null) return null;
      return newSTValue()
            .setType(ENUM)
            .setStEnumValue(value);
   }

   public nextgen.model.STValue newSTValue(nextgen.model.STValue existing) {
      switch (existing.getType()) {
         case STMODEL:
            return newSTValue(existing.getStModel());
         case PRIMITIVE:
            return newSTValue(existing.getValue());
         case ENUM:
            return newSTValue(existing.getStEnumValue());
         default:
            return null;
      }
   }

   public nextgen.model.STFile newSTFile(nextgen.model.STFile otherFile) {
      return newSTFile()
            .setName(newSTValue(otherFile.getName()))
            .setType(findOrCreateSTValueByValue(otherFile.getType().getValue()))
            .setPath(newSTValue(otherFile.getPath()))
            .setPackageName(newSTValue(otherFile.getPackageName()));
   }

   public void cleanup() {
      doInTransaction(transaction -> {

         findAllSTGroupFile().forEach(stGroupFile -> {

            if (stGroupFile.getNode().hasProperty("path")) {
               stGroupFile.setPath(findOrCreateSTValueByValue(stGroupFile.getNode().getProperty("path").toString()));
               stGroupFile.getNode().removeProperty("path");
            }

            if (stGroupFile.getNode().hasProperty("packageName")) {
               stGroupFile.setPackageName(findOrCreateSTValueByValue(stGroupFile.getNode().getProperty("packageName").toString()));
               stGroupFile.getNode().removeProperty("packageName");
            }

         });

         findAllSTGroupAction().forEach(stGroupAction -> {

            if (stGroupAction.getNode().hasProperty("statements")) {
               System.out.println(stGroupAction.getNode().getProperty("statements"));
               stGroupAction.setStatements(newSTValue(stGroupAction.getNode().getProperty("statements").toString()));
               stGroupAction.getNode().removeProperty("statements");
            }

            if (stGroupAction.getNode().hasProperty("methods")) {
               System.out.println(stGroupAction.getNode().getProperty("methods"));
               stGroupAction.setMethods(newSTValue(stGroupAction.getNode().getProperty("methods").toString()));
               stGroupAction.getNode().removeProperty("methods");
            }

         });

         findAllSTParameter().forEach(stParameter -> {
            if (stParameter.getArgumentType() != null) return;
            System.out.println(stParameter.getUuid() + " " + stParameter.getName() + " adding Object argument type");
            stParameter.setArgumentType("Object");
         });

         findAllSTParameterKey().forEach(stParameterKey -> {
            if (stParameterKey.getArgumentType() != null) return;
            System.out.println("ParameterKey " + stParameterKey.getUuid() + " " + stParameterKey.getName() + " adding Object argument type");
            stParameterKey.setArgumentType("Object");
         });

         deleteUnnusedNodes();
         deleteUnnusedFiles();
      });
   }

   public void deleteUnnusedFiles() {
      findAllSTFile().forEach(stFile -> {
         if (stFile.getIncomingFilesSTModel().iterator().hasNext()) return;
         log.info("deleting unnused stFile-" + stFile.getUuid());
         log.info(toString(stFile.getNode()));
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
               log.info(toString(node));
               node.delete();
            });
   }
}