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
         decorate(domainVisitorForm.getOnDomainJComponent());
         decorate(domainVisitorForm.getOnEntityJComponent());
         decorate(domainVisitorForm.getOnRelationJComponent());
         decorate(domainVisitorForm.getOnCompleteJComponent());

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


   private void decorate(org.fife.ui.rsyntaxtextarea.RSyntaxTextArea textArea) {
      textArea.setSyntaxEditingStyle("text/java");

      textArea.addKeyListener(newSaveListener(txt -> appModel().doLaterInTransaction(tx -> tryToSave())));
      textArea.getPopupMenu().removeAll();
      textArea.getPopupMenu().add(newAction("To Clipboard", actionEvent -> toClipboard(textArea)));
      textArea.getPopupMenu().add(new nextgen.actions.DomainVisitorAssistant(getModel(), textArea));

      // A BasicCompletion is just a straightforward word completion.
      // ShorthandCompletion  don't require the input text to be the same thing as the replacement text.

      org.fife.ui.autocomplete.DefaultCompletionProvider provider = new org.fife.ui.autocomplete.DefaultCompletionProvider();
      provider.addCompletion(new org.fife.ui.autocomplete.BasicCompletion(provider, "itar"));

      org.fife.ui.rsyntaxtextarea.CodeTemplateManager ctm = org.fife.ui.rsyntaxtextarea.RSyntaxTextArea.getCodeTemplateManager();

      ctm.addTemplate(new org.fife.ui.rsyntaxtextarea.templates.StaticCodeTemplate("itar", "for (int i=0; i<", "; i++) {\n\t\n}\n"));
      provider.addCompletion(new org.fife.ui.autocomplete.ShorthandCompletion(provider, "sysout", "log.info();", "log.info("));

      provider.addCompletion(new org.fife.ui.autocomplete.BasicCompletion(provider, "domainName"));
      provider.addCompletion(new org.fife.ui.autocomplete.BasicCompletion(provider, "entityName"));
      provider.addCompletion(new org.fife.ui.autocomplete.BasicCompletion(provider, "relationName"));
      provider.addCompletion(new org.fife.ui.autocomplete.BasicCompletion(provider, "srcName"));
      provider.addCompletion(new org.fife.ui.autocomplete.BasicCompletion(provider, "dstName"));
      provider.addCompletion(new org.fife.ui.autocomplete.BasicCompletion(provider, "relationType"));

      getModel().getIncomingDomain().getEntities().forEach(domainEntity -> {
         final String lowFirst = nextgen.utils.StringUtil.lowFirst(domainEntity.getName());
         final String capFirst = nextgen.utils.StringUtil.capitalize(domainEntity.getName());

         provider.addCompletion(new org.fife.ui.autocomplete.BasicCompletion(provider, "is" + capFirst));
         ctm.addTemplate(new org.fife.ui.rsyntaxtextarea.templates.StaticCodeTemplate("is" + capFirst, "if (entityName.equals(\"" + domainEntity.getName() + "\") {\n\t", "\n}"));

         provider.addCompletion(new org.fife.ui.autocomplete.BasicCompletion(provider, "isSrc" + capFirst));
         ctm.addTemplate(new org.fife.ui.rsyntaxtextarea.templates.StaticCodeTemplate("isSrc" + capFirst, "if (srcName.equals(\"" + domainEntity.getName() + "\") {\n\t", "\n}"));

         provider.addCompletion(new org.fife.ui.autocomplete.BasicCompletion(provider, "isDst" + capFirst));
         ctm.addTemplate(new org.fife.ui.rsyntaxtextarea.templates.StaticCodeTemplate("isDst" + capFirst, "if (dstName.equals(\"" + domainEntity.getName() + "\") {\n\t", "\n}"));

      });

      getModel().getTemplates().forEach(stTemplate -> {
         final String lowFirst = nextgen.utils.StringUtil.lowFirst(stTemplate.getName());
         final String capFirst = nextgen.utils.StringUtil.capitalize(stTemplate.getName());

         provider.addCompletion(new org.fife.ui.autocomplete.BasicCompletion(provider, lowFirst));
         provider.addCompletion(new org.fife.ui.autocomplete.BasicCompletion(provider, "\"" + lowFirst + "\""));

         provider.addCompletion(new org.fife.ui.autocomplete.BasicCompletion(provider, "new" + capFirst));
         ctm.addTemplate(new org.fife.ui.rsyntaxtextarea.templates.StaticCodeTemplate("new" + capFirst, "STBuilder ", " = new" + capFirst + "(\"" + lowFirst + "\");"));
         provider.addCompletion(new org.fife.ui.autocomplete.BasicCompletion(provider, "newEntity" + capFirst));
         ctm.addTemplate(new org.fife.ui.rsyntaxtextarea.templates.StaticCodeTemplate("newEntity" + capFirst, "STBuilder ", " = new" + capFirst + "(entity, \"" + lowFirst + "\");"));

         provider.addCompletion(new org.fife.ui.autocomplete.BasicCompletion(provider, "get" + capFirst));
         ctm.addTemplate(new org.fife.ui.rsyntaxtextarea.templates.StaticCodeTemplate("get" + capFirst, "get(\"" + lowFirst, "\")"));

         provider.addCompletion(new org.fife.ui.autocomplete.BasicCompletion(provider, "get" + capFirst + "Entity"));
         ctm.addTemplate(new org.fife.ui.rsyntaxtextarea.templates.StaticCodeTemplate("get" + capFirst + "Entity", "get(entity, \"" + lowFirst, "\")"));

         provider.addCompletion(new org.fife.ui.autocomplete.BasicCompletion(provider, "writeModel(\"" + lowFirst + "\");"));

         stTemplate.getParameters().sorted((p1, p2) -> p1.getName().compareToIgnoreCase(p2.getName())).forEach(stParameter -> {
            final String parameterLowFirst = nextgen.utils.StringUtil.lowFirst(stParameter.getName());
            final String paramCap = nextgen.utils.StringUtil.capitalize(stParameter.getName());

            provider.addCompletion(new org.fife.ui.autocomplete.BasicCompletion(provider, "\"" + stParameter.getName() + "\""));
            provider.addCompletion(new org.fife.ui.autocomplete.BasicCompletion(provider, "set" + paramCap));
            ctm.addTemplate(new org.fife.ui.rsyntaxtextarea.templates.StaticCodeTemplate("set" + paramCap, lowFirst + ".set(\"" + parameterLowFirst + "\", ", ");"));
         });
      });

      org.fife.ui.autocomplete.AutoCompletion ac = new org.fife.ui.autocomplete.AutoCompletion(provider);
      javax.swing.KeyStroke key = javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_SPACE, java.awt.event.InputEvent.CTRL_DOWN_MASK);
      ac.setTriggerKey(key);
      ac.install(textArea);
   }
}