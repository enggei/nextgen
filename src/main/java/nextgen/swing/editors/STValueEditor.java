package nextgen.swing.editors;

import nextgen.model.STValue;

import java.awt.*;

public class STValueEditor extends nextgen.swing.BaseEditor<nextgen.model.STValue> {

	public String uuid;

	private final javax.swing.JTabbedPane editors = nextgen.swing.ComponentFactory.newJTabbedPane();
	private final nextgen.swing.forms.STValueForm form = new nextgen.swing.forms.STValueForm();
	private final nextgen.swing.forms.TextAreaCrudForm editor = new nextgen.swing.forms.TextAreaCrudForm();

	public STValueEditor() {
		super();
	}

	public STValueEditor(nextgen.model.STValue model) {
		super();
		setModel(model);
	}

	@Override
	public void setModel(STValue model) {
		super.setModel(model);

		this.uuid = model.getUuid();

		editors.add("Form", form);
		editors.add("Editor", editor);
		add(editors, BorderLayout.CENTER);

		form.setModel(model, newSaveListener(txt -> appModel().doLaterInTransaction(tx -> tryToSave())));
		editor.setModel(model, newSaveListener(txt -> appModel().doLaterInTransaction(tx -> tryToSave())));
	}

	@Override
	protected void tryToSave() {

		if (model == null) return;

		appModel().doInTransaction(transaction -> {
			if (!model.getType().equals(nextgen.model.STValueType.PRIMITIVE)) return;

			form.onSave(model);
			editor.onSave(model);

			nextgen.events.STValueChanged.post(model);

			model.getIncomingValueSTArgument().findFirst().ifPresent(stArgument -> stArgument.getIncomingArgumentsSTModel().findAny().ifPresent(stModel -> {
				final nextgen.model.STParameter stParameter = stArgument.getStParameter();
				if ("name".equals(stParameter.getName())) nextgen.events.STModelChanged.post(stModel);
			}));
		});


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