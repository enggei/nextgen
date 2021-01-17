package nextgen.swing.editors;

import java.awt.*;

import nextgen.events.*;

public class STGroupFileEditor extends nextgen.swing.BaseEditor<nextgen.model.STGroupFile> {

	private final javax.swing.JTabbedPane editors = nextgen.swing.ComponentFactory.newJTabbedPane();
	private final nextgen.swing.forms.STGroupFileForm form = new nextgen.swing.forms.STGroupFileForm();

	public STGroupFileEditor() {
		super();
		init();
	}

	public STGroupFileEditor(nextgen.model.STGroupFile model) {
		super(model, model.getUuid());
		init();
		setModel(model);
	}

	private void init() {
		editors.add("Form", nextgen.swing.ComponentFactory.newJScrollPane(form));
		add(editors, BorderLayout.CENTER);
	}

	@Override
	public void setModel(nextgen.model.STGroupFile model) {
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