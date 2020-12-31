package nextgen.swing;

import nextgen.model.*;

import java.awt.*;

public class STParameterEditor extends BaseEditor<STParameter> {

   private final String uuid;
   private final STModelEditorForm modelEditorForm = new STModelEditorForm();

   public STParameterEditor(nextgen.model.STParameter model,STModel stModel) {
      super(model);
      this.uuid = model.getUuid();

      final javax.swing.JTabbedPane editors = nextgen.swing.ComponentFactory.newJTabbedPane();
      editors.add("Search", new STParameterSearchReplaceEditor(model));
      editors.add("Form", modelEditorForm);
      add(editors, BorderLayout.CENTER);

      modelEditorForm.setModel(stModel);
//      org.greenrobot.eventbus.EventBus.getDefault().register(this);
   }


   public String getUuid() {
      return uuid;
   }

   public nextgen.model.STParameter getModel() {
      return model;
   }
}