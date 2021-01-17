package nextgen.swing.editors;

import java.awt.*;

import nextgen.events.*;

public class STInterfaceEditor extends nextgen.swing.BaseEditor<nextgen.model.STInterface> {

	private final javax.swing.JTabbedPane editors = nextgen.swing.ComponentFactory.newJTabbedPane();
	private final nextgen.swing.forms.STInterfaceForm form = new nextgen.swing.forms.STInterfaceForm();

	public STInterfaceEditor() {
		super();
		init();
	}

	public STInterfaceEditor(nextgen.model.STInterface model) {
		super(model, model.getUuid());
		init();
		setModel(model);
	}

	private void init() {
		form.getTxtName().addKeyListener(newSaveListener(textComponent -> tryToSave()));
		editors.add("Form", nextgen.swing.ComponentFactory.newJScrollPane(form));
		add(editors, BorderLayout.CENTER);
	}

	@Override
	public void setModel(nextgen.model.STInterface model) {
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