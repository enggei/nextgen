package nextgen.swing.editors;

import java.awt.*;

import nextgen.events.*;

public class STEnumValueEditor extends nextgen.swing.BaseEditor<nextgen.model.STEnumValue> {

	private final javax.swing.JTabbedPane editors = nextgen.swing.ComponentFactory.newJTabbedPane();
	private final nextgen.swing.forms.STEnumValueForm form = new nextgen.swing.forms.STEnumValueForm();

	public STEnumValueEditor() {
		super();
		init();
	}

	public STEnumValueEditor(nextgen.model.STEnumValue model) {
		super(model, model.getUuid());
		init();
		setModel(model);
	}

	private void init() {
		form.getTxtName().addKeyListener(newSaveListener(textComponent -> tryToSave()));
		form.getTxtLexical().addKeyListener(newSaveListener(textComponent -> tryToSave()));
		editors.add("Form", nextgen.swing.ComponentFactory.newJScrollPane(form));
		add(editors, BorderLayout.CENTER);
	}

	@Override
	public void setModel(nextgen.model.STEnumValue model) {
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