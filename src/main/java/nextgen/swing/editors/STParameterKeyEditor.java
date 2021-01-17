package nextgen.swing.editors;

import java.awt.*;

import nextgen.events.*;

public class STParameterKeyEditor extends nextgen.swing.BaseEditor<nextgen.model.STParameterKey> {

	private final javax.swing.JTabbedPane editors = nextgen.swing.ComponentFactory.newJTabbedPane();
	private final nextgen.swing.forms.STParameterKeyForm form = new nextgen.swing.forms.STParameterKeyForm();

	public STParameterKeyEditor() {
		super();
		init();
	}

	public STParameterKeyEditor(nextgen.model.STParameterKey model) {
		super(model, model.getUuid());
		init();
		setModel(model);
	}

	private void init() {
		form.getTxtName().addKeyListener(newSaveListener(textComponent -> tryToSave()));
		form.getTxtArgumentType().addKeyListener(newSaveListener(textComponent -> tryToSave()));
		editors.add("Form", nextgen.swing.ComponentFactory.newJScrollPane(form));
		add(editors, BorderLayout.CENTER);
	}

	@Override
	public void setModel(nextgen.model.STParameterKey model) {
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