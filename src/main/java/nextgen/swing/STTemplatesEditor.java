package nextgen.swing;

import java.awt.*;

public class STTemplatesEditor extends BaseEditor<nextgen.model.STTemplate> {

   private final String uuid;

   public STTemplatesEditor(nextgen.model.STTemplate model) {
      super(model);
      this.uuid = model.getUuid();

      final javax.swing.JTabbedPane editors = nextgen.swing.ComponentFactory.newJTabbedPane();
      editors.add("Search", new STTemplatesSearchReplaceEditor(model));
      add(editors, BorderLayout.CENTER);
   }


   public String getUuid() {
      return uuid;
   }
}