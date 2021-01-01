package nextgen.swing.editors;

import java.awt.*;

public class STProjectEditor extends nextgen.swing.BaseEditor<nextgen.model.STProject> {

	public final String uuid;

	private final javax.swing.JTabbedPane editors = nextgen.swing.ComponentFactory.newJTabbedPane();
	private final nextgen.swing.forms.STProjectForm form = new nextgen.swing.forms.STProjectForm();

	public STProjectEditor(nextgen.model.STProject model) {
		super(model);
		this.uuid = model.getUuid();

		editors.add("Form", form);
		add(editors, BorderLayout.CENTER);

		form.setModel(model, newSaveListener(txt -> appModel().doLaterInTransaction(tx -> tryToSave())));

	}

	@Override
   protected void tryToSave() {
      form.onSave(model);
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