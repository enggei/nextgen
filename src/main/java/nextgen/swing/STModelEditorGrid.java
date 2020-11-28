package nextgen.swing;

import nextgen.model.STModel;

public class STModelEditorGrid extends SearchReplaceEditor {

   private STModel model;

   public STModelEditorGrid(nextgen.model.STModel model) {
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