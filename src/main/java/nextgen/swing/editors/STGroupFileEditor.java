package nextgen.swing.editors;

import java.awt.*;

import nextgen.events.*;

public class STGroupFileEditor extends nextgen.swing.BaseEditor<nextgen.model.STGroupFile> {

	private final javax.swing.JTabbedPane editors = nextgen.swing.ComponentFactory.newJTabbedPane();
	private final nextgen.swing.forms.STGroupFileForm form = new nextgen.swing.forms.STGroupFileForm();

	public STGroupFileEditor() {
		super();
	}

	public STGroupFileEditor(nextgen.model.STGroupFile model) {
		super(model, model.getUuid());
		setModel(model);
	}

	@Override
	public void setModel(nextgen.model.STGroupFile model) {
		super.setModel(model);

		this.uuid = model.getUuid();
		form.modelToView(model);

		if (getComponentCount() == 0) {
			editors.add("Form", form);
			add(editors, BorderLayout.CENTER);
			invalidate();
		}
	}

	@Override
	protected void tryToSave() {
		if (model == null) return;
		form.viewToModel();
	}

	

}  