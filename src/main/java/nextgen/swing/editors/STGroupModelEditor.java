package nextgen.swing.editors;

import java.awt.*;

import nextgen.events.*;

public class STGroupModelEditor extends nextgen.swing.BaseEditor<nextgen.model.STGroupModel> {

	private final javax.swing.JTabbedPane editors = nextgen.swing.ComponentFactory.newJTabbedPane();
	private final nextgen.swing.forms.STGroupModelForm form = new nextgen.swing.forms.STGroupModelForm();

	public STGroupModelEditor() {
		super();
		init();
	}

	public STGroupModelEditor(nextgen.model.STGroupModel model) {
		super(model, model.getUuid());
		init();
		setModel(model);
	}

	private void init() {
		form.getTxtLanguage().addKeyListener(newSaveListener(textComponent -> tryToSave()));
		form.getTxtName().addKeyListener(newSaveListener(textComponent -> tryToSave()));
		form.getTxtDelimiter().addKeyListener(newSaveListener(textComponent -> tryToSave()));
		form.getTxtIcon().addKeyListener(newSaveListener(textComponent -> tryToSave()));
		editors.add("Form", nextgen.swing.ComponentFactory.newJScrollPane(form));
		add(editors, BorderLayout.CENTER);
	}

	@Override
	public void setModel(nextgen.model.STGroupModel model) {
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