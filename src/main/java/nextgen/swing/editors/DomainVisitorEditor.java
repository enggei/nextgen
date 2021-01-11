package nextgen.swing.editors;

import java.awt.*;

import nextgen.events.*;

public class DomainVisitorEditor extends nextgen.swing.BaseEditor<nextgen.model.DomainVisitor> {

	private final javax.swing.JTabbedPane editors = nextgen.swing.ComponentFactory.newJTabbedPane();
	private final nextgen.swing.forms.DomainVisitorForm domainVisitorForm = new nextgen.swing.forms.DomainVisitorForm();

	public DomainVisitorEditor() {
		super();
		org.greenrobot.eventbus.EventBus.getDefault().register(this);
	}

	public DomainVisitorEditor(nextgen.model.DomainVisitor model) {
		super(model, model.getUuid());
		setModel(model);
		org.greenrobot.eventbus.EventBus.getDefault().register(this);
	}

	@Override
	public void setModel(nextgen.model.DomainVisitor model) {
		super.setModel(model);

		this.uuid = model.getUuid();
		domainVisitorForm.setModel(model);

		if (getComponentCount() == 0) {
		   editors.add("DomainVisitorForm", domainVisitorForm);
		   domainVisitorForm.getOnDomainJComponent().addKeyListener(newSaveListener(txt -> appModel().doLaterInTransaction(tx -> tryToSave())));
		   domainVisitorForm.getOnEntityJComponent().addKeyListener(newSaveListener(txt -> appModel().doLaterInTransaction(tx -> tryToSave())));
		   domainVisitorForm.getOnRelationJComponent().addKeyListener(newSaveListener(txt -> appModel().doLaterInTransaction(tx -> tryToSave())));
		   domainVisitorForm.getOnCompleteJComponent().addKeyListener(newSaveListener(txt -> appModel().doLaterInTransaction(tx -> tryToSave())));

		   final org.fife.ui.rsyntaxtextarea.RSyntaxTextArea txtTemplates = domainVisitorForm.getTemplatesJComponent();
		   txtTemplates.setEditable(false);
		   txtTemplates.addKeyListener(newSaveListener(txt -> appModel().doLaterInTransaction(tx -> tryToSave())));

		   final javax.swing.JPopupMenu pop = txtTemplates.getPopupMenu();
		   pop.removeAll();
		   pop.add(newAction("To Clipboard", actionEvent -> toClipboard(txtTemplates)));
		   pop.add(new nextgen.actions.AddSTTemplateToDomainVisitor(model, editors));

			add(editors, BorderLayout.CENTER);
		   invalidate();
		}
	}

	@Override
	protected void tryToSave() {
		if (model == null) return;
		appModel().doInTransaction(transaction -> domainVisitorForm.onSave(model));
	}

	@org.greenrobot.eventbus.Subscribe()
	public void onDomainVisitorSTTemplateAdded(DomainVisitorSTTemplateAdded event) {
		if (event.domainVisitor.equals(getModel())) {
			domainVisitorForm.setModel(event.domainVisitor);
		}
	}

}