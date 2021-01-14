package nextgen.swing.editors;

import java.awt.*;

import nextgen.events.*;

public class STTemplateEditor extends nextgen.swing.BaseEditor<nextgen.model.STTemplate> {

	private final javax.swing.JTabbedPane editors = nextgen.swing.ComponentFactory.newJTabbedPane();
	private final nextgen.swing.forms.STTemplateForm form = new nextgen.swing.forms.STTemplateForm();

	public STTemplateEditor() {
		super();
	}

	public STTemplateEditor(nextgen.model.STTemplate model) {
		super(model, model.getUuid());
		setModel(model);
	}

	@Override
	public void setModel(nextgen.model.STTemplate model) {
		super.setModel(model);

		this.uuid = model.getUuid();
		form.modelToView(model);

		if (getComponentCount() == 0) {
			editors.add("Form", form);
			form.getNameJTextField().addKeyListener(newSaveListener(txt -> appModel().doLaterInTransaction(tx -> tryToSave())));
			form.getTextJTextField().addKeyListener(newSaveListener(txt -> appModel().doLaterInTransaction(tx -> tryToSave())));

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