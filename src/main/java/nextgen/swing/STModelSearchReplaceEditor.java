package nextgen.swing;

import nextgen.model.STModel;

public class STModelSearchReplaceEditor extends SearchReplaceEditor {

   private STModel model;

   public STModelSearchReplaceEditor(nextgen.model.STModel model) {
      super();
      this.model = model;
   }

   @Override
   protected java.util.stream.Stream<nextgen.model.STModel> getSTModels() {
      return java.util.stream.Stream.of(model);
   }

   public nextgen.model.STModel getModel() {
      return model;
   }
}