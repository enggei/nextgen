package nextgen.swing.editors;

import java.awt.*;

public class STProjectEditor extends nextgen.swing.BaseEditor<nextgen.model.STProject> {

	private String uuid;

	private final javax.swing.JTabbedPane editors = nextgen.swing.ComponentFactory.newJTabbedPane();
	private final nextgen.swing.forms.STProjectForm form = new nextgen.swing.forms.STProjectForm();

	public STProjectEditor() {
		super();
	}

	public STProjectEditor(nextgen.model.STProject model) {
		super(model);
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

		appModel().doInTransaction(transaction -> {
			form.onSave(model);
		});
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		STProjectEditor that = (STProjectEditor) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	@Override
	public String toString() {
		return uuid;
	}

	public String getUuid() {
		return uuid;
	}
}