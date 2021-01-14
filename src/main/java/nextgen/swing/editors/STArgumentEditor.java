package nextgen.swing.editors;

import java.awt.*;

import nextgen.events.*;

public class STArgumentEditor extends nextgen.swing.BaseEditor<nextgen.model.STArgument> {

	private final javax.swing.JTabbedPane editors = nextgen.swing.ComponentFactory.newJTabbedPane();
	private final nextgen.swing.forms.STArgumentForm form = new nextgen.swing.forms.STArgumentForm();

	public STArgumentEditor() {
		super();
	}

	public STArgumentEditor(nextgen.model.STArgument model) {
		super(model, model.getUuid());
		setModel(model);
	}

	@Override
	public void setModel(nextgen.model.STArgument model) {
		super.setModel(model);

		this.uuid = model.getUuid();
		form.modelToView(model);

		if (getComponentCount() == 0) {
			editors.add("Form", nextgen.swing.ComponentFactory.newJScrollPane(form));
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