package nextgen.swing.editors;

import java.awt.*;

import nextgen.events.*;

public class STArgumentEditor extends nextgen.swing.BaseEditor<nextgen.model.STArgument> {

	private final javax.swing.JTabbedPane editors = nextgen.swing.ComponentFactory.newJTabbedPane();
	private final nextgen.swing.forms.STArgumentForm form = new nextgen.swing.forms.STArgumentForm();

	public STArgumentEditor() {
		super();
		init();
	}

	public STArgumentEditor(nextgen.model.STArgument model) {
		super(model, model.getUuid());
		init();
		setModel(model);
	}

	private void init() {
		editors.add("Form", nextgen.swing.ComponentFactory.newJScrollPane(form));
		add(editors, BorderLayout.CENTER);
	}

	@Override
	public void setModel(nextgen.model.STArgument model) {
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