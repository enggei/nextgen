package nextgen.model;

import static nextgen.model.STValueType.*;

public class STModelDB extends NextgenDB {

   private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STModelDB.class);

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

   @Override
   protected void cleanup() {
      doInTransaction(transaction -> {

         findAllSTParameter().filter(node -> node.getArgumentType() == null).forEach(stParameter -> stParameter.setArgumentType("Object"));
         findAllSTParameterKey().filter(node -> node.getArgumentType() == null).forEach(stParameter -> stParameter.setArgumentType("Object"));

         findAllSTValue().filter(node -> node.getType().equals(PRIMITIVE)).filter(node -> node.getValue() == null).forEach(nextgen.model.STValue::delete);
         findAllSTValue().filter(node -> node.getType().equals(STMODEL)).filter(node -> node.getStModel() == null).forEach(nextgen.model.STValue::delete);
         findAllSTValue().filter(node -> node.getType().equals(ENUM)).filter(node -> node.getStEnumValue() == null).forEach(nextgen.model.STValue::delete);

         findAllSTGroupModel().filter(node -> node.getTemplates().count() == 0L).forEach(nextgen.model.STGroupModel::delete);

         findAllSTTemplate().filter(node -> nextgen.swing.STAppPresentationModel.getSTGroup(node) == null).forEach(nextgen.model.STTemplate::delete);

         findAllSTModel().filter(node -> node.getStTemplate() == null).forEach(nextgen.model.STModel::delete);
         findAllSTModel().filter(node -> nextgen.swing.STAppPresentationModel.findSTProjectFor(node).isEmpty()).forEach(nextgen.model.STModel::delete);

         findAllSTArgument().filter(node -> node.getStParameter() == null).forEach(nextgen.model.STArgument::delete);
         findAllSTArgument().filter(node-> !node.getStParameter().getType().equals(STParameterType.KVLIST)).filter(node -> node.getValue() == null).forEach(nextgen.model.STArgument::delete);

         findAllSTArgumentKV().filter(node -> node.getStParameterKey() == null).forEach(nextgen.model.STArgumentKV::delete);
         findAllSTArgumentKV().filter(node -> node.getValue() == null).forEach(nextgen.model.STArgumentKV::delete);

         findAllSTFile().filter(node -> !node.getIncomingFilesSTModel().iterator().hasNext()).forEach(nextgen.model.STFile::delete);

         findAllSTGroupFile().filter(node -> !node.getIncomingFilesSTGroupModel().iterator().hasNext()).forEach(nextgen.model.STGroupFile::delete);

         getDatabaseService().getAllNodes().stream().filter(node -> !node.getRelationships().iterator().hasNext()).forEach(org.neo4j.graphdb.Node::delete);

      });
   }
}