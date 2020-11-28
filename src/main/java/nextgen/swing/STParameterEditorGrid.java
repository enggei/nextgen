package nextgen.swing;

public class STParameterEditorGrid extends SearchReplaceEditor {

   private final String uuid;
   private final nextgen.model.STParameter model;

   public STParameterEditorGrid(nextgen.model.STParameter model) {
      super();

      this.model = model;
      this.uuid = model.getUuid();
   }

   @Override
   protected java.util.stream.Stream<nextgen.model.STModel> getSTModels() {
      return java.util.stream.Stream.empty(); // ignored - overrides getSearchAction
   }

   @Override
   protected javax.swing.Action getSearchAction(javax.swing.JTextField txtSearch) {
      return appModel().newTransactionAction("Search", transaction -> {
         reset();

         final java.util.List<nextgen.swing.SearchReplaceEditor.STValueElement> stValues = model.getIncomingStParameterSTArgument()
               .filter(stArgument -> stArgument.getValue() != null)
               .map(nextgen.model.STArgument::getValue)
               .filter(stValue -> stValue.getType() != null)
               .filter(stValue -> stValue.getType().equals(nextgen.model.STValueType.PRIMITIVE))
               .filter(nextgen.model.STValue::hasValue)
               .filter(stValue -> stValue.getValue().contains(txtSearch.getText()))
               .map(nextgen.swing.SearchReplaceEditor.STValueElement::new)
               .collect(java.util.stream.Collectors.toList());

         model.getIncomingStParameterSTArgument()
               .forEach(stArgument -> stValues.addAll(stArgument.getKeyValues()
                     .filter(stArgumentKV -> stArgumentKV.getValue() != null)
                     .map(nextgen.model.STArgumentKV::getValue)
                     .filter(stValue -> stValue.getType() != null)
                     .filter(stValue -> stValue.getType().equals(nextgen.model.STValueType.PRIMITIVE))
                     .filter(nextgen.model.STValue::hasValue)
                     .filter(stValue -> stValue.getValue().contains(txtSearch.getText()))
                     .map(STValueElement::new)
                     .collect(java.util.stream.Collectors.toList())));

         model.getIncomingStParameterSTArgument()
               .forEach(stArgument -> stArgument.getKeyValues()
                     .filter(stArgumentKV -> stArgumentKV.getValue() != null)
                     .map(nextgen.model.STArgumentKV::getValue)
                     .filter(stValue -> stValue.getType() != null)
                     .filter(stValue -> stValue.getType().equals(nextgen.model.STValueType.STMODEL))
                     .filter(stValue -> stValue.getStModel() != null)
                     .forEach(stValue -> addSTValues(stValue.getStModel(), stValues)));

         model.getIncomingStParameterSTArgument()
               .filter(stArgument -> stArgument.getValue() != null)
               .map(nextgen.model.STArgument::getValue)
               .filter(stValue -> stValue.getType() != null)
               .filter(stValue -> stValue.getType().equals(nextgen.model.STValueType.STMODEL))
               .filter(stValue -> stValue.getStModel() != null)
               .forEach(stValue -> addSTValues(stValue.getStModel(), stValues));

         resultsModel.setResult(stValues);
      });
   }

   private void addSTValues(nextgen.model.STModel stModel, java.util.List<STValueElement> stValues) {
      stValues.addAll(stModel.getArguments()
            .filter(stArgument -> stArgument.getValue() != null)
            .map(nextgen.model.STArgument::getValue)
            .filter(stValue -> stValue.getType() != null)
            .filter(stValue -> stValue.getType().equals(nextgen.model.STValueType.PRIMITIVE))
            .filter(nextgen.model.STValue::hasValue)
            .filter(stValue -> stValue.getValue().contains(txtSearch.getText()))
            .map(STValueElement::new)
            .collect(java.util.stream.Collectors.toList()));

      stModel.getArguments()
            .forEach(stArgument -> stValues.addAll(stArgument.getKeyValues()
                  .filter(stArgumentKV -> stArgumentKV.getValue() != null)
                  .map(nextgen.model.STArgumentKV::getValue)
                  .filter(stValue -> stValue.getType() != null)
                  .filter(stValue -> stValue.getType().equals(nextgen.model.STValueType.PRIMITIVE))
                  .filter(nextgen.model.STValue::hasValue)
                  .filter(stValue -> stValue.getValue().contains(txtSearch.getText()))
                  .map(STValueElement::new)
                  .collect(java.util.stream.Collectors.toList())));

      stModel.getArguments()
            .forEach(stArgument -> stArgument.getKeyValues()
                  .filter(stArgumentKV -> stArgumentKV.getValue() != null)
                  .map(nextgen.model.STArgumentKV::getValue)
                  .filter(stValue -> stValue.getType() != null)
                  .filter(stValue -> stValue.getType().equals(nextgen.model.STValueType.STMODEL))
                  .filter(stValue -> stValue.getStModel() != null)
                  .forEach(stValue -> addSTValues(stValue.getStModel(), stValues)));

      stModel.getArguments()
            .filter(stArgument -> stArgument.getValue() != null)
            .map(nextgen.model.STArgument::getValue)
            .filter(stValue -> stValue.getType() != null)
            .filter(stValue -> stValue.getType().equals(nextgen.model.STValueType.STMODEL))
            .filter(stValue -> stValue.getStModel() != null)
            .forEach(stValue -> addSTValues(stValue.getStModel(), stValues));
   }

   public String getUuid() {
      return uuid;
   }

   public nextgen.model.STParameter getModel() {
      return model;
   }
}