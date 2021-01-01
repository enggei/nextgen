package nextgen.swing;

import nextgen.model.*;

import java.util.Objects;


public class STParameterSearchReplaceEditor extends SearchReplaceEditor {

   private final nextgen.model.STParameter model;

   public STParameterSearchReplaceEditor(STParameter model) {
      this.model = model;
   }

   @Override
   protected java.util.stream.Stream<nextgen.model.STModel> getSTModels() {
      return java.util.stream.Stream.empty(); // ignored - overrides getSearchAction
   }

   @Override
   protected javax.swing.Action getSearchAction(javax.swing.JTextField txtSearch) {
      return appModel().newTransactionAction("Search", transaction -> {
         reset();

         final java.util.List<STValue> stValues = model.getIncomingStParameterSTArgument()
               .map(STArgument::getValue)
               .filter(Objects::nonNull)
               .filter(stValue -> stValue.getType() != null)
               .filter(stValue -> stValue.getType().equals(nextgen.model.STValueType.PRIMITIVE))
               .filter(nextgen.model.STValue::hasValue)
               .filter(stValue -> stValue.getValue().contains(txtSearch.getText()))
               .collect(java.util.stream.Collectors.toList());

         model.getIncomingStParameterSTArgument()
               .forEach(stArgument -> stValues.addAll(stArgument.getKeyValues()
                     .map(STArgumentKV::getValue)
                     .filter(Objects::nonNull)
                     .filter(stValue -> stValue.getType() != null)
                     .filter(stValue -> stValue.getType().equals(nextgen.model.STValueType.PRIMITIVE))
                     .filter(nextgen.model.STValue::hasValue)
                     .filter(stValue -> stValue.getValue().contains(txtSearch.getText()))
                     .collect(java.util.stream.Collectors.toList())));

         model.getIncomingStParameterSTArgument()
               .forEach(stArgument -> stArgument.getKeyValues()
                     .map(STArgumentKV::getValue)
                     .filter(Objects::nonNull)
                     .filter(stValue -> stValue.getType() != null)
                     .filter(stValue -> stValue.getType().equals(nextgen.model.STValueType.STMODEL))
                     .filter(stValue -> stValue.getStModel() != null)
                     .forEach(stValue -> addSTValues(stValue.getStModel(), stValues)));

         model.getIncomingStParameterSTArgument()
               .map(STArgument::getValue)
               .filter(Objects::nonNull)
               .filter(stValue -> stValue.getType() != null)
               .filter(stValue -> stValue.getType().equals(nextgen.model.STValueType.STMODEL))
               .filter(stValue -> stValue.getStModel() != null)
               .forEach(stValue -> addSTValues(stValue.getStModel(), stValues));

         results.setContent(stValues);
      });
   }

   private void addSTValues(nextgen.model.STModel stModel, java.util.List<STValue> stValues) {
      stValues.addAll(stModel.getArguments()
            .map(STArgument::getValue)
            .filter(Objects::nonNull)
            .filter(stValue -> stValue.getType() != null)
            .filter(stValue -> stValue.getType().equals(nextgen.model.STValueType.PRIMITIVE))
            .filter(nextgen.model.STValue::hasValue)
            .filter(stValue -> stValue.getValue().contains(txtSearch.getText()))
            .collect(java.util.stream.Collectors.toList()));

      stModel.getArguments()
            .forEach(stArgument -> stValues.addAll(stArgument.getKeyValues()
                  .map(STArgumentKV::getValue)
                  .filter(Objects::nonNull)
                  .filter(stValue -> stValue.getType() != null)
                  .filter(stValue -> stValue.getType().equals(nextgen.model.STValueType.PRIMITIVE))
                  .filter(nextgen.model.STValue::hasValue)
                  .filter(stValue -> stValue.getValue().contains(txtSearch.getText()))
                  .collect(java.util.stream.Collectors.toList())));

      stModel.getArguments()
            .forEach(stArgument -> stArgument.getKeyValues()
                  .map(STArgumentKV::getValue)
                  .filter(Objects::nonNull)
                  .filter(stValue -> stValue.getType() != null)
                  .filter(stValue -> stValue.getType().equals(nextgen.model.STValueType.STMODEL))
                  .filter(stValue -> stValue.getStModel() != null)
                  .forEach(stValue -> addSTValues(stValue.getStModel(), stValues)));

      stModel.getArguments()
            .map(STArgument::getValue)
            .filter(Objects::nonNull)
            .filter(stValue -> stValue.getType() != null)
            .filter(stValue -> stValue.getType().equals(nextgen.model.STValueType.STMODEL))
            .filter(stValue -> stValue.getStModel() != null)
            .forEach(stValue -> addSTValues(stValue.getStModel(), stValues));
   }
}