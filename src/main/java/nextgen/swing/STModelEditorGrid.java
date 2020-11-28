package nextgen.swing;

import nextgen.st.model.STModel;

public class STModelEditorGrid extends SearchReplaceEditor {

   private STModel model;

   public STModelEditorGrid(nextgen.st.model.STModel model) {
      super();
      this.model = model;
   }

   @Override
   protected java.util.stream.Stream<nextgen.st.model.STModel> getSTModels() {
      return java.util.stream.Stream.of(model);
   }

   public nextgen.st.model.STModel getModel() {
      return model;
   }
}