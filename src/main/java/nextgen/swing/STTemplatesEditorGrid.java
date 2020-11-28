package nextgen.swing;

public class STTemplatesEditorGrid extends SearchReplaceEditor {

   private final String uuid;
   private final nextgen.st.model.STTemplate model;

   public STTemplatesEditorGrid(nextgen.st.model.STTemplate model) {
      super();

      this.model = model;
      this.uuid = model.getUuid();
   }

   @Override
   protected java.util.stream.Stream<nextgen.st.model.STModel> getSTModels() {
      return model.getIncomingStTemplateSTModel();
   }

   public String getUuid() {
      return uuid;
   }

   public nextgen.st.model.STTemplate getModel() {
      return model;
   }
}