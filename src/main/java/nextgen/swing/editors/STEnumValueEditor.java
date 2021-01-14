package nextgen.swing.editors;

import java.awt.*;

import nextgen.events.*;

public class STEnumValueEditor extends nextgen.swing.BaseEditor<nextgen.model.STEnumValue> {

	private final javax.swing.JTabbedPane editors = nextgen.swing.ComponentFactory.newJTabbedPane();
	private final nextgen.swing.forms.STEnumValueForm form = new nextgen.swing.forms.STEnumValueForm();

	public STEnumValueEditor() {
		super();
	}

	public STEnumValueEditor(nextgen.model.STEnumValue model) {
		super(model, model.getUuid());
		setModel(model);
	}

	@Override
	public void setModel(nextgen.model.STEnumValue model) {
		super.setModel(model);

		this.uuid = model.getUuid();
		form.modelToView(model);

		if (getComponentCount() == 0) {
			editors.add("Form", form);
			form.getNameJTextField().addKeyListener(newSaveListener(txt -> appModel().doLaterInTransaction(tx -> tryToSave())));
			form.getLexicalJTextField().addKeyListener(newSaveListener(txt -> appModel().doLaterInTransaction(tx -> tryToSave())));

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