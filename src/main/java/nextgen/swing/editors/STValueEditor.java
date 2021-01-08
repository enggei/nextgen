package nextgen.swing.editors;

import java.awt.*;

public class STValueEditor extends nextgen.swing.BaseEditor<nextgen.model.STValue> {

	private String uuid = java.util.UUID.randomUUID().toString();

	private final javax.swing.JTabbedPane editors = nextgen.swing.ComponentFactory.newJTabbedPane();
	private final nextgen.swing.forms.TextAreaCrudForm editor = new nextgen.swing.forms.TextAreaCrudForm();

	public STValueEditor() {
		super();
	}

	public STValueEditor(nextgen.model.STValue model) {
		super(model);
		setModel(model);
	}

	@Override
	public void setModel(nextgen.model.STValue model) {
		super.setModel(model);

		this.uuid = model.getUuid();

		if (getComponentCount() == 0) {
		   editors.add("Editor", editor);
			add(editors, BorderLayout.CENTER);
		   invalidate();
		}

		editor.setModel(model, newSaveListener(txt -> appModel().doLaterInTransaction(tx -> tryToSave())));
	}

	@Override
	protected void tryToSave() {
		if (model == null) return;
		appModel().doInTransaction(transaction -> editor.onSave(model));
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		STValueEditor that = (STValueEditor) o;
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