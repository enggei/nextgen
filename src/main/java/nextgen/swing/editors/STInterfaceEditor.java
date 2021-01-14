package nextgen.swing.editors;

import java.awt.*;

import nextgen.events.*;

public class STInterfaceEditor extends nextgen.swing.BaseEditor<nextgen.model.STInterface> {

	private final javax.swing.JTabbedPane editors = nextgen.swing.ComponentFactory.newJTabbedPane();
	private final nextgen.swing.forms.STInterfaceForm form = new nextgen.swing.forms.STInterfaceForm();

	public STInterfaceEditor() {
		super();
	}

	public STInterfaceEditor(nextgen.model.STInterface model) {
		super(model, model.getUuid());
		setModel(model);
	}

	@Override
	public void setModel(nextgen.model.STInterface model) {
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