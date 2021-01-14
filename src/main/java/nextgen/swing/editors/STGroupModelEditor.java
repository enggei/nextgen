package nextgen.swing.editors;

import java.awt.*;

import nextgen.events.*;

public class STGroupModelEditor extends nextgen.swing.BaseEditor<nextgen.model.STGroupModel> {

	private final javax.swing.JTabbedPane editors = nextgen.swing.ComponentFactory.newJTabbedPane();
	private final nextgen.swing.forms.STGroupModelForm form = new nextgen.swing.forms.STGroupModelForm();

	public STGroupModelEditor() {
		super();
	}

	public STGroupModelEditor(nextgen.model.STGroupModel model) {
		super(model, model.getUuid());
		setModel(model);
	}

	@Override
	public void setModel(nextgen.model.STGroupModel model) {
		super.setModel(model);

		this.uuid = model.getUuid();
		form.modelToView(model);

		if (getComponentCount() == 0) {
			editors.add("Form", form);
			form.getLanguageJTextField().addKeyListener(newSaveListener(txt -> appModel().doLaterInTransaction(tx -> tryToSave())));
			form.getNameJTextField().addKeyListener(newSaveListener(txt -> appModel().doLaterInTransaction(tx -> tryToSave())));
			form.getDelimiterJTextField().addKeyListener(newSaveListener(txt -> appModel().doLaterInTransaction(tx -> tryToSave())));
			form.getIconJTextField().addKeyListener(newSaveListener(txt -> appModel().doLaterInTransaction(tx -> tryToSave())));

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