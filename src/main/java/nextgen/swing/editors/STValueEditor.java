package nextgen.swing.editors;

import java.awt.*;

import nextgen.events.*;

public class STValueEditor extends nextgen.swing.BaseEditor<nextgen.model.STValue> {

	private final javax.swing.JTabbedPane editors = nextgen.swing.ComponentFactory.newJTabbedPane();
	private final nextgen.swing.forms.TextAreaCrudForm editor = new nextgen.swing.forms.TextAreaCrudForm();

	public STValueEditor() {
		super();
	}

	public STValueEditor(nextgen.model.STValue model) {
		super(model, model.getUuid());
		setModel(model);
	}

	@Override
	public void setModel(nextgen.model.STValue model) {
		super.setModel(model);

		this.uuid = model.getUuid();
		editor.setModel(model);

		if (getComponentCount() == 0) {
		   editors.add("Editor", editor);
		   decorate((org.fife.ui.rsyntaxtextarea.RSyntaxTextArea) ((org.fife.ui.rtextarea.RTextScrollPane) editor.getTextAreaJScrollPane()).getTextArea());

			add(editors, BorderLayout.CENTER);
		   invalidate();
		}
	}

	@Override
	protected void tryToSave() {
		if (model == null) return;
		appModel().doInTransaction(transaction -> editor.onSave(model));
	}


	private void decorate(org.fife.ui.rsyntaxtextarea.RSyntaxTextArea textArea) {
	   textArea.setSyntaxEditingStyle("text/java");

	   textArea.addKeyListener(newSaveListener(txt -> appModel().doLaterInTransaction(tx -> tryToSave())));
	   textArea.getPopupMenu().removeAll();
	   textArea.getPopupMenu().add(newAction("Replace with Clipboard", actionEvent -> replaceWithClipboard(textArea)));
		textArea.getPopupMenu().add(newAction("Append Clipboard", actionEvent -> appendFromClipboard(textArea)));
		textArea.getPopupMenu().add(newAction("Prepend Clipboard", actionEvent -> prependFromClipboard(textArea)));
		textArea.getPopupMenu().add(newAction("To Clipboard", actionEvent -> toClipboard(textArea)));
			
	   org.fife.ui.autocomplete.DefaultCompletionProvider provider = new org.fife.ui.autocomplete.DefaultCompletionProvider();
	   org.fife.ui.rsyntaxtextarea.CodeTemplateManager ctm = org.fife.ui.rsyntaxtextarea.RSyntaxTextArea.getCodeTemplateManager();

	   provider.addCompletion(new org.fife.ui.autocomplete.BasicCompletion(provider, "sout"));
	   ctm.addTemplate(new org.fife.ui.rsyntaxtextarea.templates.StaticCodeTemplate("sout", "System.out.println(", ");"));

	   org.fife.ui.autocomplete.AutoCompletion ac = new org.fife.ui.autocomplete.AutoCompletion(provider);
	   javax.swing.KeyStroke key = javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_SPACE, java.awt.event.InputEvent.CTRL_DOWN_MASK);
	   ac.setTriggerKey(key);
	   ac.install(textArea);
	}
}