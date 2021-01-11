package nextgen.swing.editors;

import java.awt.*;

public class STProjectEditor extends nextgen.swing.BaseEditor<nextgen.model.STProject> {

	private final javax.swing.JTabbedPane editors = nextgen.swing.ComponentFactory.newJTabbedPane();
	private final nextgen.swing.forms.STProjectForm form = new nextgen.swing.forms.STProjectForm();

	public STProjectEditor() {
		super();
	}

	public STProjectEditor(nextgen.model.STProject model) {
		super(model, model.getUuid());
		setModel(model);
	}

	@Override
	public void setModel(nextgen.model.STProject model) {
		super.setModel(model);

		this.uuid = model.getUuid();

		if (getComponentCount() == 0) {
		   editors.add("Form", form);
			add(editors, BorderLayout.CENTER);
		   invalidate();
		}

		form.setModel(model, newSaveListener(txt -> appModel().doLaterInTransaction(tx -> tryToSave())));
	}

	@Override
	protected void tryToSave() {
		if (model == null) return;
		appModel().doInTransaction(transaction -> form.onSave(model));
	}
}