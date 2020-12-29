package nextgen.swing;

import nextgen.model.*;

import java.awt.*;

public class STParameterEditor extends BaseEditor<STParameter> {

   private final String uuid;

   public STParameterEditor(nextgen.model.STParameter model) {
      super(model);
      this.uuid = model.getUuid();

      final javax.swing.JTabbedPane editors = nextgen.swing.ComponentFactory.newJTabbedPane();
      editors.add("Search", new STParameterSearchReplaceEditor(model));
      add(editors, BorderLayout.CENTER);

//      org.greenrobot.eventbus.EventBus.getDefault().register(this);
   }


   public String getUuid() {
      return uuid;
   }

   public nextgen.model.STParameter getModel() {
      return model;
   }
}