package nextgen.swing;

public class STGroupActionEditor extends AbstractEditor {

   private final nextgen.st.model.STGroupAction model;
   private final String uuid;

   public STGroupActionEditor(nextgen.st.model.STGroupAction model) {
      this.model = model;
      this.uuid = model.getUuid();



   }

   public nextgen.st.model.STGroupAction getModel() {
      return model;
   }

   public String getUuid() {
      return uuid;
   }
}