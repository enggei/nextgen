package nextgen.swing;

public class STTemplatesSearchReplaceEditor extends SearchReplaceEditor {

   private nextgen.model.STTemplate model;

   public STTemplatesSearchReplaceEditor(nextgen.model.STTemplate model) {
      super();
      this.model = model;
   }

   @Override
   protected java.util.stream.Stream<nextgen.model.STModel> getSTModels() {
      return model.getIncomingStTemplateSTModel();
   }

   public nextgen.model.STTemplate getModel() {
      return model;
   }
}