package nextgen.swing.editors;

import java.awt.*;

import nextgen.events.*;

public class DomainVisitorEditor extends nextgen.swing.BaseEditor<nextgen.model.DomainVisitor> {

	private final javax.swing.JTabbedPane editors = nextgen.swing.ComponentFactory.newJTabbedPane();
	private final nextgen.swing.forms.DomainVisitorForm form = new nextgen.swing.forms.DomainVisitorForm();

	public DomainVisitorEditor() {
		super();
		init();
	}

	public DomainVisitorEditor(nextgen.model.DomainVisitor model) {
		super(model, model.getUuid());
		init();
		setModel(model);
	}

	private void init() {
		form.getTxtName().addKeyListener(newSaveListener(textComponent -> tryToSave()));
		form.getTxtOnDomain().addKeyListener(newSaveListener(textComponent -> tryToSave()));
		form.getTxtOnEntity().addKeyListener(newSaveListener(textComponent -> tryToSave()));
		form.getTxtOnRelation().addKeyListener(newSaveListener(textComponent -> tryToSave()));
		form.getTxtOnComplete().addKeyListener(newSaveListener(textComponent -> tryToSave()));
		form.getTxtOnEntityEntity().addKeyListener(newSaveListener(textComponent -> tryToSave()));
		form.getTxtOnEnumEntity().addKeyListener(newSaveListener(textComponent -> tryToSave()));
		form.getTxtOnPrimitiveEntity().addKeyListener(newSaveListener(textComponent -> tryToSave()));
		form.getTxtOnOneEntityRelation().addKeyListener(newSaveListener(textComponent -> tryToSave()));
		form.getTxtOnOneEnumRelation().addKeyListener(newSaveListener(textComponent -> tryToSave()));
		form.getTxtOnOnePrimitiveRelation().addKeyListener(newSaveListener(textComponent -> tryToSave()));
		form.getTxtOnManyEntityRelation().addKeyListener(newSaveListener(textComponent -> tryToSave()));
		form.getTxtOnManyEnumRelation().addKeyListener(newSaveListener(textComponent -> tryToSave()));
		form.getTxtOnManyPrimitiveRelation().addKeyListener(newSaveListener(textComponent -> tryToSave()));
		form.getTxtOnOptionalEntityRelation().addKeyListener(newSaveListener(textComponent -> tryToSave()));
		form.getTxtOnOptionalEnumRelation().addKeyListener(newSaveListener(textComponent -> tryToSave()));
		form.getTxtOnOptionalPrimitiveRelation().addKeyListener(newSaveListener(textComponent -> tryToSave()));
		editors.add("Form", nextgen.swing.ComponentFactory.newJScrollPane(form));
		add(editors, BorderLayout.CENTER);
		org.greenrobot.eventbus.EventBus.getDefault().register(this);
	}

	@Override
	public void setModel(nextgen.model.DomainVisitor model) {
		super.setModel(model);
		this.uuid = model.getUuid();
		form.modelToView(model);
	}

	@Override
	protected void tryToSave() {
		if (model == null) return;
		appModel().doLaterInTransaction(tx -> {
			form.viewToModel(getModel());
		});
	}

	
	@org.greenrobot.eventbus.Subscribe()
	public void onDomainVisitorSTTemplateAdded(DomainVisitorSTTemplateAdded event) {
		if (event.domainVisitor.equals(getModel())) {
			form.modelToView(getModel());
		}
	}


}  