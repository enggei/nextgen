package nextgen.swing.editors;

import java.awt.*;

import nextgen.events.*;

public class STArgumentKVEditor extends nextgen.swing.BaseEditor<nextgen.model.STArgumentKV> {

	private final javax.swing.JTabbedPane editors = nextgen.swing.ComponentFactory.newJTabbedPane();
	private final nextgen.swing.forms.STArgumentKVForm form = new nextgen.swing.forms.STArgumentKVForm();

	public STArgumentKVEditor() {
		super();
		init();
	}

	public STArgumentKVEditor(nextgen.model.STArgumentKV model) {
		super(model, model.getUuid());
		init();
		setModel(model);
	}

	private void init() {
		editors.add("Form", nextgen.swing.ComponentFactory.newJScrollPane(form));
		add(editors, BorderLayout.CENTER);
	}

	@Override
	public void setModel(nextgen.model.STArgumentKV model) {
		super.setModel(model);
		this.uuid = model.getUuid();
		form.modelToView(model);
	}

	@Override
	protected void tryToSave() {
		if (model == null) return;
		appModel().doLaterInTransaction(tx -> {
			form.viewToModel(getModel());
		});
	}

	

}  