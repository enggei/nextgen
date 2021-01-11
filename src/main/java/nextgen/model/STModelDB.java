package nextgen.model;

import org.neo4j.graphdb.Relationship;

import static nextgen.model.STValueType.*;

public class STModelDB extends STModelNeoFactory {

   private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STModel.class);

   public STModelDB(String dbDir) {
      super(dbDir);
      getDatabaseService().registerTransactionEventHandler(getTransactionEventHandler());
      cleanup();
   }

   private org.neo4j.graphdb.event.TransactionEventHandler.Adapter<Object> getTransactionEventHandler() {
      return new org.neo4j.graphdb.event.TransactionEventHandler.Adapter<>() {
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
      if (stParameter == null || stValue == null) return null;
      return newSTArgument()
            .setStParameter(stParameter)
            .setValue(stValue);
   }

   public STValue newSTValue(STModel stModel) {
      if (stModel == null) return null;
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
            .setValue(value.getLexical() == null || value.getLexical().trim().length() == 0 ? value.getName() : value.getLexical())
            .setStEnumValue(value);
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
               log.info("statements " + stGroupAction.getNode().getProperty("statements"));
               stGroupAction.setStatements(newSTValue(stGroupAction.getNode().getProperty("statements").toString()));
               stGroupAction.getNode().removeProperty("statements");
            }

            if (stGroupAction.getNode().hasProperty("methods")) {
               log.info("methods " + stGroupAction.getNode().getProperty("methods"));
               stGroupAction.setMethods(newSTValue(stGroupAction.getNode().getProperty("methods").toString()));
               stGroupAction.getNode().removeProperty("methods");
            }

         });

         findAllSTParameter().forEach(stParameter -> {
            if (stParameter.getArgumentType() != null) return;
            log.info(stParameter.getUuid() + " " + stParameter.getName() + " adding Object argument type");
            stParameter.setArgumentType("Object");
         });

         findAllSTParameterKey().forEach(stParameterKey -> {
            if (stParameterKey.getArgumentType() != null) return;
            log.info("ParameterKey " + stParameterKey.getUuid() + " " + stParameterKey.getName() + " adding Object argument type");
            stParameterKey.setArgumentType("Object");
         });

         findAllSTModel().forEach(stModel -> {
            if (stModel.getStTemplate() == null) {
               log.error(stModel.toString());
               stModel.delete();
            }
         });


         deleteUnnusedNodes();
         deleteUnnusedFiles();


         findAllSTGroupModel().filter(stGroupModel -> stGroupModel.getDelimiter()==null).forEach(stGroupModel -> {
            System.out.println(stGroupModel.getUuid() + " " + stGroupModel.getName() + " missing delimiter");
            stGroupModel.setDelimiter(nextgen.st.STGenerator.DELIMITER);
         });

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