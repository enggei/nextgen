package nextgen.swing.editors;

import java.awt.*;

import nextgen.events.*;

public class DomainVisitorEditor extends nextgen.swing.BaseEditor<nextgen.model.DomainVisitor> {

	private final javax.swing.JTabbedPane editors = nextgen.swing.ComponentFactory.newJTabbedPane();
	private final nextgen.swing.forms.DomainVisitorForm form = new nextgen.swing.forms.DomainVisitorForm();

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
		form.modelToView(model);

		if (getComponentCount() == 0) {
			editors.add("Form", nextgen.swing.ComponentFactory.newJScrollPane(form));
			form.getNameJTextField().addKeyListener(newSaveListener(txt -> appModel().doLaterInTransaction(tx -> tryToSave())));
			decorate(form.getOnDomainRSyntaxTextArea()).addKeyListener(newSaveListener(txt -> appModel().doLaterInTransaction(tx -> tryToSave())));
			decorate(form.getOnEntityRSyntaxTextArea()).addKeyListener(newSaveListener(txt -> appModel().doLaterInTransaction(tx -> tryToSave())));
			decorate(form.getOnRelationRSyntaxTextArea()).addKeyListener(newSaveListener(txt -> appModel().doLaterInTransaction(tx -> tryToSave())));
			decorate(form.getOnCompleteRSyntaxTextArea()).addKeyListener(newSaveListener(txt -> appModel().doLaterInTransaction(tx -> tryToSave())));
			decorate(form.getOnEntityEntityRSyntaxTextArea()).addKeyListener(newSaveListener(txt -> appModel().doLaterInTransaction(tx -> tryToSave())));
			decorate(form.getOnEnumEntityRSyntaxTextArea()).addKeyListener(newSaveListener(txt -> appModel().doLaterInTransaction(tx -> tryToSave())));
			decorate(form.getOnPrimitiveEntityRSyntaxTextArea()).addKeyListener(newSaveListener(txt -> appModel().doLaterInTransaction(tx -> tryToSave())));
			decorate(form.getOnOneEntityRelationRSyntaxTextArea()).addKeyListener(newSaveListener(txt -> appModel().doLaterInTransaction(tx -> tryToSave())));
			decorate(form.getOnOneEnumRelationRSyntaxTextArea()).addKeyListener(newSaveListener(txt -> appModel().doLaterInTransaction(tx -> tryToSave())));
			decorate(form.getOnOnePrimitiveRelationRSyntaxTextArea()).addKeyListener(newSaveListener(txt -> appModel().doLaterInTransaction(tx -> tryToSave())));
			decorate(form.getOnManyEntityRelationRSyntaxTextArea()).addKeyListener(newSaveListener(txt -> appModel().doLaterInTransaction(tx -> tryToSave())));
			decorate(form.getOnManyEnumRelationRSyntaxTextArea()).addKeyListener(newSaveListener(txt -> appModel().doLaterInTransaction(tx -> tryToSave())));
			decorate(form.getOnManyPrimitiveRelationRSyntaxTextArea()).addKeyListener(newSaveListener(txt -> appModel().doLaterInTransaction(tx -> tryToSave())));
			decorate(form.getOnOptionalEntityRelationRSyntaxTextArea()).addKeyListener(newSaveListener(txt -> appModel().doLaterInTransaction(tx -> tryToSave())));
			decorate(form.getOnOptionalEnumRelationRSyntaxTextArea()).addKeyListener(newSaveListener(txt -> appModel().doLaterInTransaction(tx -> tryToSave())));
			decorate(form.getOnOptionalPrimitiveRelationRSyntaxTextArea()).addKeyListener(newSaveListener(txt -> appModel().doLaterInTransaction(tx -> tryToSave())));

			add(editors, BorderLayout.CENTER);
			invalidate();
		}
	}

	@Override
	protected void tryToSave() {
		if (model == null) return;
		form.viewToModel();
	}

	
	@org.greenrobot.eventbus.Subscribe()
	public void onDomainVisitorSTTemplateAdded(DomainVisitorSTTemplateAdded event) {
		if (event.domainVisitor.equals(getModel())) {
			form.modelToView();
		}
	}


	private org.fife.ui.rsyntaxtextarea.RSyntaxTextArea decorate(org.fife.ui.rsyntaxtextarea.RSyntaxTextArea textArea) {
	      textArea.setSyntaxEditingStyle("text/java");

	      textArea.addKeyListener(newSaveListener(txt -> appModel().doLaterInTransaction(tx -> tryToSave())));
	      textArea.getPopupMenu().removeAll();
	      textArea.getPopupMenu().add(newAction("To Clipboard", actionEvent -> toClipboard(textArea)));

	      // A BasicCompletion is just a straightforward word completion.
	      // ShorthandCompletion  don't require the input text to be the same thing as the replacement text.

	      org.fife.ui.autocomplete.DefaultCompletionProvider provider = new org.fife.ui.autocomplete.DefaultCompletionProvider();
	      org.fife.ui.rsyntaxtextarea.CodeTemplateManager ctm = org.fife.ui.rsyntaxtextarea.RSyntaxTextArea.getCodeTemplateManager();

	      provider.addCompletion(new org.fife.ui.autocomplete.BasicCompletion(provider, "domainName"));
	      provider.addCompletion(new org.fife.ui.autocomplete.BasicCompletion(provider, "entityType"));
	      provider.addCompletion(new org.fife.ui.autocomplete.BasicCompletion(provider, "entityEnums"));
	      provider.addCompletion(new org.fife.ui.autocomplete.BasicCompletion(provider, "entityName"));
	      provider.addCompletion(new org.fife.ui.autocomplete.BasicCompletion(provider, "relationName"));
	      provider.addCompletion(new org.fife.ui.autocomplete.BasicCompletion(provider, "srcName"));
	      provider.addCompletion(new org.fife.ui.autocomplete.BasicCompletion(provider, "dstName"));
	      provider.addCompletion(new org.fife.ui.autocomplete.BasicCompletion(provider, "relationType"));

	      addCodeTemplate(true, provider, textArea, "swrl", "switch (relationType) {\n" +
	            "\tcase ONE:\n" +
	            "\t\tbreak;\n" +
	            "\tcase MANY:\n" +
	            "\t\tbreak;\n" +
	            "\tcase OPTIONAL:\n" +
	            "\t\tbreak;\n" +
	            "}", "");
	      addCodeTemplate(true, provider, textArea, "isEnum", "if (isEnum(entity)) { ", " }");
	      addCodeTemplate(true, provider, textArea, "isNotEnum", "if (!isEnum(entity)) { ", " }");
	      addCodeTemplate(false, provider, textArea, "isSrcEnum", "if (isEnum(src)) { ", " } else { }");
	      addCodeTemplate(false, provider, textArea, "isDstEnum", "if (isEnum(dst)) { ", " } else { }");

	      getModel().getIncomingVisitorsDomain().forEach(domain -> domain.getEntities().forEach(domainEntity -> {
	         final String capFirst = nextgen.utils.StringUtil.capitalize(domainEntity.getName());
	         addCodeTemplate(false, provider, textArea, "isDst" + capFirst, "if (dstName.equals(\"" + domainEntity.getName() + "\")) {\n\t", "\n}");
	         addCodeTemplate(false, provider, textArea, "isSrc" + capFirst, "if (srcName.equals(\"" + domainEntity.getName() + "\")) {\n\t", "\n}");
	      }));

	      getModel().getTemplates().forEach(stTemplate -> {
	         final String lowFirst = nextgen.utils.StringUtil.lowFirst(stTemplate.getName());
	         final String capFirst = nextgen.utils.StringUtil.capitalize(stTemplate.getName());

	         addCodeTemplate(true, provider, textArea, "new" + capFirst, "STBuilder ", " = new" + capFirst + "();");
	         addCodeTemplate(true, provider, textArea, "new" + capFirst + "Entity", "STBuilder ", " = new" + capFirst + "(entity, \"" + lowFirst + "\");");
	         addCodeTemplate(false, provider, textArea, "get" + capFirst, "get(\"" + lowFirst, "\")");
	         addCodeTemplate(false, provider, textArea, "get" + capFirst + "Entity", "get(entity, \"" + lowFirst, "\")");

	         stTemplate.getParameters().sorted((p1, p2) -> p1.getName().compareToIgnoreCase(p2.getName())).forEach(stParameter -> {
	            addCodeTemplate(true, provider, textArea, "set" + stTemplate.getName() + stParameter.getName(), "set(\"" + stParameter.getName() + "\", ", ");");
	         });
	      });

	      org.fife.ui.autocomplete.AutoCompletion ac = new org.fife.ui.autocomplete.AutoCompletion(provider);
	      javax.swing.KeyStroke key = javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_SPACE, java.awt.event.InputEvent.CTRL_DOWN_MASK);
	      ac.setTriggerKey(key);
	      ac.install(textArea);

	      return textArea;
	   }
}  