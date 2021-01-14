package nextgen.swing.editors;

import java.awt.*;

import nextgen.events.*;

public class DomainRelationEditor extends nextgen.swing.BaseEditor<nextgen.model.DomainRelation> {

	private final javax.swing.JTabbedPane editors = nextgen.swing.ComponentFactory.newJTabbedPane();
	private final nextgen.swing.forms.DomainRelationForm form = new nextgen.swing.forms.DomainRelationForm();

	public DomainRelationEditor() {
		super();
	}

	public DomainRelationEditor(nextgen.model.DomainRelation model) {
		super(model, model.getUuid());
		setModel(model);
	}

	@Override
	public void setModel(nextgen.model.DomainRelation model) {
		super.setModel(model);

		this.uuid = model.getUuid();
		form.modelToView(model);

		if (getComponentCount() == 0) {
			editors.add("Form", form);
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