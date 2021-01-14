package nextgen.swing.editors;

import java.awt.*;

import nextgen.events.*;

public class STParameterKeyEditor extends nextgen.swing.BaseEditor<nextgen.model.STParameterKey> {

	private final javax.swing.JTabbedPane editors = nextgen.swing.ComponentFactory.newJTabbedPane();
	private final nextgen.swing.forms.STParameterKeyForm form = new nextgen.swing.forms.STParameterKeyForm();

	public STParameterKeyEditor() {
		super();
	}

	public STParameterKeyEditor(nextgen.model.STParameterKey model) {
		super(model, model.getUuid());
		setModel(model);
	}

	@Override
	public void setModel(nextgen.model.STParameterKey model) {
		super.setModel(model);

		this.uuid = model.getUuid();
		form.modelToView(model);

		if (getComponentCount() == 0) {
			editors.add("Form", form);
			form.getNameJTextField().addKeyListener(newSaveListener(txt -> appModel().doLaterInTransaction(tx -> tryToSave())));
			form.getArgumentTypeJTextField().addKeyListener(newSaveListener(txt -> appModel().doLaterInTransaction(tx -> tryToSave())));

			add(editors, BorderLayout.CENTER);
			invalidate();
		}
	}

	@Override
	protected void tryToSave() {
		if (model == null) return;
		form.viewToModel();
	}

	

}  