package nextgen.swing.editors;

import java.awt.*;

public class DomainVisitorEditor extends nextgen.swing.BaseEditor<nextgen.model.DomainVisitor> {

	private final javax.swing.JTabbedPane editors = nextgen.swing.ComponentFactory.newJTabbedPane();
	private final nextgen.swing.forms.DomainVisitorForm domainVisitorForm = new nextgen.swing.forms.DomainVisitorForm();

	public DomainVisitorEditor() {
		super();
	}

	public DomainVisitorEditor(nextgen.model.DomainVisitor model) {
		super(model, model.getUuid());
		setModel(model);
	}

	@Override
	public void setModel(nextgen.model.DomainVisitor model) {
		super.setModel(model);

		this.uuid = model.getUuid();

		if (getComponentCount() == 0) {
		   editors.add("DomainVisitorForm", domainVisitorForm);
			add(editors, BorderLayout.CENTER);
		   invalidate();
		}

		domainVisitorForm.setModel(model, newSaveListener(txt -> appModel().doLaterInTransaction(tx -> tryToSave())));
	}

	@Override
	protected void tryToSave() {
		if (model == null) return;
		appModel().doInTransaction(transaction -> domainVisitorForm.onSave(model));
	}
}