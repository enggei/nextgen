package nextgen.swing.editors;

import nextgen.swing.ComponentFactory;

import java.awt.*;
import java.util.UUID;

public class STValueEditor extends nextgen.swing.BaseEditor<nextgen.model.STValue> {

	private String uuid = UUID.randomUUID().toString();

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

		editors.add("Editor", ComponentFactory.newJScrollPane(editor));
		add(editors, BorderLayout.CENTER);

		editor.setModel(model, newSaveListener(txt -> appModel().doLaterInTransaction(tx -> tryToSave())));

	}

	@Override
	protected void tryToSave() {

		if (model == null) return;

		appModel().doInTransaction(transaction -> {
			if (!model.getType().equals(nextgen.model.STValueType.PRIMITIVE)) return;

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