package nextgen.swing.editors;

import java.awt.*;

import nextgen.events.*;

public class STEnumEditor extends nextgen.swing.BaseEditor<nextgen.model.STEnum> {

	private final javax.swing.JTabbedPane editors = nextgen.swing.ComponentFactory.newJTabbedPane();
	private final nextgen.swing.forms.STEnumForm form = new nextgen.swing.forms.STEnumForm();

	public STEnumEditor() {
		super();
	}

	public STEnumEditor(nextgen.model.STEnum model) {
		super(model, model.getUuid());
		setModel(model);
	}

	@Override
	public void setModel(nextgen.model.STEnum model) {
		super.setModel(model);

		this.uuid = model.getUuid();
		form.modelToView(model);

		if (getComponentCount() == 0) {
			editors.add("Form", nextgen.swing.ComponentFactory.newJScrollPane(form));
			form.getNameJTextField().addKeyListener(newSaveListener(txt -> appModel().doLaterInTransaction(tx -> tryToSave())));

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