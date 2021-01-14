package nextgen.swing.editors;

import java.awt.*;

import nextgen.events.*;

public class STValueEditor extends nextgen.swing.BaseEditor<nextgen.model.STValue> {

	private final javax.swing.JTabbedPane editors = nextgen.swing.ComponentFactory.newJTabbedPane();
	private final nextgen.swing.forms.STValueForm form = new nextgen.swing.forms.STValueForm();

	public STValueEditor() {
		super();
	}

	public STValueEditor(nextgen.model.STValue model) {
		super(model, model.getUuid());
		setModel(model);
	}

	@Override
	public void setModel(nextgen.model.STValue model) {
		super.setModel(model);

		this.uuid = model.getUuid();
		form.modelToView(model);

		if (getComponentCount() == 0) {
			editors.add("Form", nextgen.swing.ComponentFactory.newJScrollPane(form));
			form.getValueRSyntaxTextArea().addKeyListener(newSaveListener(txt -> appModel().doLaterInTransaction(tx -> tryToSave())));

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