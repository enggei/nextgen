package nextgen.swing;

public class STTemplatesEditor extends SearchReplaceEditor {

   private final String uuid;
   private final nextgen.model.STTemplate model;

   public STTemplatesEditor(nextgen.model.STTemplate model) {
      super();

      this.model = model;
      this.uuid = model.getUuid();
   }

   @Override
   protected java.util.stream.Stream<nextgen.model.STModel> getSTModels() {
      return model.getIncomingStTemplateSTModel();
   }

   public String getUuid() {
      return uuid;
   }

   public nextgen.model.STTemplate getModel() {
      return model;
   }
}