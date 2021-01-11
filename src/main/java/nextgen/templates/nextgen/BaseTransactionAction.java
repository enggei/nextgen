package nextgen.templates.nextgen;

public class BaseTransactionAction {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private String _name;
	private Object _packageName;

	BaseTransactionAction(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("BaseTransactionAction");
		st.add("name", _name);
		st.add("packageName", _packageName);
		return st.render().trim();
	}

	public BaseTransactionAction setName(String value) {
		this._name = value;
		return this;
	}

	public String getName() {
		return this._name;
	}

	public String getName(String defaultValue) {
		return this._name == null ? defaultValue : this._name;
	}

	public boolean hasName() {
		return this._name != null;
	}

	public BaseTransactionAction removeName() {
		this._name = null;
		return this;
	} 

	public BaseTransactionAction setPackageName(Object value) {
		this._packageName = value;
		return this;
	}

	public Object getPackageName() {
		return this._packageName;
	}

	public Object getPackageName(Object defaultValue) {
		return this._packageName == null ? defaultValue : this._packageName;
	}

	public boolean hasPackageName() {
		return this._packageName != null;
	}

	public BaseTransactionAction removePackageName() {
		this._packageName = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		BaseTransactionAction that = (BaseTransactionAction) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "BaseTransactionAction(name,packageName) ::= <<package ~packageName~;\n" + 
				"\n" + 
				"import javax.swing.*;\n" + 
				"\n" + 
				"import static nextgen.utils.SwingUtil.printStackTrace;\n" + 
				"\n" + 
				"public abstract class ~name~ extends javax.swing.AbstractAction {\n" + 
				"\n" + 
				"   protected final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(~name~.class);\n" + 
				"\n" + 
				"   protected ~name~(String name) {\n" + 
				"      super(name);\n" + 
				"   }\n" + 
				"\n" + 
				"   public ~name~ setIcon(String icon) {\n" + 
				"      putValue(Action.SMALL_ICON,appModel().loadIcon(icon));\n" + 
				"      return this;\n" + 
				"   }\n" + 
				"\n" + 
				"   public ~name~ setName(String name) {\n" + 
				"      putValue(Action.NAME, name);\n" + 
				"      return this;\n" + 
				"   }\n" + 
				"\n" + 
				"   @Override\n" + 
				"   public void actionPerformed(java.awt.event.ActionEvent e) {\n" + 
				"      javax.swing.SwingUtilities.invokeLater(() -> appModel().doInTransaction(transaction -> actionPerformed(e, transaction)));\n" + 
				"   }\n" + 
				"\n" + 
				"   protected abstract void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction);\n" + 
				"\n" + 
				"   protected nextgen.swing.STAppPresentationModel appModel() {\n" + 
				"      return nextgen.swing.AppModel.getInstance().getSTAppPresentationModel();\n" + 
				"   }\n" + 
				"\n" + 
				"   protected void confirm(javax.swing.JComponent owner, String description, java.util.function.Consumer<Void> onConfirm) {\n" + 
				"      nextgen.utils.SwingUtil.confirm(owner, description).ifPresent(aBoolean -> onConfirm.accept(null));\n" + 
				"   }\n" + 
				"\n" + 
				"   protected void input(javax.swing.JComponent owner, String message, java.util.function.Consumer<String> consumer) {\n" + 
				"      nextgen.utils.SwingUtil.showInputDialog(message, owner, inputValue -> appModel().doLaterInTransaction(transaction1 -> consumer.accept(inputValue)));\n" + 
				"   }\n" + 
				"\n" + 
				"   protected void input(javax.swing.JComponent owner, String message, String defaultValue, java.util.function.Consumer<String> consumer) {\n" + 
				"      nextgen.utils.SwingUtil.showInputDialog(message, owner, defaultValue, inputValue -> appModel().doLaterInTransaction(transaction1 -> consumer.accept(inputValue)));\n" + 
				"   }\n" + 
				"\n" + 
				"   protected void inputName(javax.swing.JComponent owner, String defaultValue, java.util.function.Consumer<String> consumer) {\n" + 
				"      nextgen.utils.SwingUtil.showInputDialog(\"Name\", owner, defaultValue, inputValue -> appModel().doLaterInTransaction(transaction1 -> consumer.accept(inputValue)));\n" + 
				"   }\n" + 
				"\n" + 
				"   protected <T> void select(javax.swing.JComponent owner, java.util.Collection<T> values, java.util.function.Consumer<T> consumer) {\n" + 
				"      nextgen.utils.SwingUtil.showSelectDialog(\"Select\", owner, values, selected -> appModel().doLaterInTransaction(transaction1 -> consumer.accept(selected)));\n" + 
				"   }\n" + 
				"\n" + 
				"   protected <T> void selectAndRender(javax.swing.JComponent owner, java.util.Collection<T> values, java.util.function.Function<T, String> renderer, T defaultValue, java.util.function.Consumer<T> consumer) {\n" + 
				"      nextgen.utils.SwingUtil.showSelectDialog(\"Select\", owner, values, renderer, defaultValue, selected -> appModel().doLaterInTransaction(transaction1 -> consumer.accept(selected)));\n" + 
				"   }\n" + 
				"\n" + 
				"   protected void openFile(javax.swing.JComponent owner, java.util.function.Consumer<java.io.File> consumer) {\n" + 
				"      nextgen.utils.SwingUtil.showOpenFile(owner, appModel().getLastDir()).ifPresent(consumer);\n" + 
				"   }\n" + 
				"\n" + 
				"   protected javax.swing.JDialog newDialog(javax.swing.JComponent owner, String title) {\n" + 
				"      return new javax.swing.JDialog((java.awt.Frame) javax.swing.SwingUtilities.getAncestorOfClass(javax.swing.JFrame.class, owner), title, true);\n" + 
				"   }\n" + 
				"\n" + 
				"   protected javax.swing.JTextField newTextField() {\n" + 
				"      return newTextField(\"\", 30);\n" + 
				"   }\n" + 
				"\n" + 
				"   protected javax.swing.JTextField newTextField(int columns) {\n" + 
				"      return newTextField(\"\", columns);\n" + 
				"   }\n" + 
				"\n" + 
				"   protected javax.swing.JTextField newTextField(String text, int columns) {\n" + 
				"      return newTextField(text, columns, new String[0], -1);\n" + 
				"   }\n" + 
				"\n" + 
				"   protected javax.swing.JTextField newTextField(int columns, String[] options) {\n" + 
				"      return newTextField(\"\", columns, options, 0);\n" + 
				"   }\n" + 
				"\n" + 
				"   protected javax.swing.JTextField newTextField(String text, int columns, java.util.List<String> options, int startIndex) {\n" + 
				"      return newTextField(text, columns, options.toArray(new String[options.size()]), startIndex);\n" + 
				"   }\n" + 
				"\n" + 
				"   protected javax.swing.JTextField newTextField(String text, int columns, String[] options, int startIndex) {\n" + 
				"      return nextgen.utils.SwingUtil.newTextField(text, columns, options, startIndex);\n" + 
				"   }\n" + 
				"\n" + 
				"   protected javax.swing.JLabel newLabel(String name) {\n" + 
				"      return nextgen.swing.ComponentFactory.newJLabel(name);\n" + 
				"   }\n" + 
				"\n" + 
				"   protected javax.swing.JButton newButton(String name, java.util.function.Consumer<org.neo4j.graphdb.Transaction> onClick) {\n" + 
				"      return nextgen.swing.ComponentFactory.newJButton(appModel().new~name~(name, onClick));\n" + 
				"   }\n" + 
				"\n" + 
				"   protected void showDialog(javax.swing.JComponent owner, javax.swing.JComponent component, String title, java.util.function.Consumer<javax.swing.JDialog> saveAction) {\n" + 
				"      final javax.swing.JDialog dialog = newDialog(owner, title);\n" + 
				"      dialog.add(component, java.awt.BorderLayout.CENTER);\n" + 
				"      nextgen.utils.SwingUtil.showDialog(owner, dialog, newButton(\"Save\", transaction -> saveAction.accept(dialog)));\n" + 
				"   }\n" + 
				"\n" + 
				"   protected nextgen.swing.SelectOrAddSTModelValue getSelectOrAddSTModelValue(nextgen.model.STTemplate stTemplate, java.util.List<nextgen.model.STModel> stModelList) {\n" + 
				"      return new nextgen.swing.SelectOrAddSTModelValue(stTemplate, stModelList);\n" + 
				"   }\n" + 
				"\n" + 
				"   protected <T> void showEditor(javax.swing.JComponent owner, nextgen.swing.BaseEditor<T> baseEditor, java.util.function.BiConsumer<javax.swing.JDialog, T> saveAction) {\n" + 
				"      final javax.swing.JDialog dialog = newDialog(owner, baseEditor.title());\n" + 
				"      dialog.add(baseEditor, java.awt.BorderLayout.CENTER);\n" + 
				"      nextgen.utils.SwingUtil.showDialog(owner, dialog, newButton(\"Save\", transaction -> saveAction.accept(dialog, baseEditor.getModel())));\n" + 
				"   }\n" + 
				"\n" + 
				"   protected void showError(javax.swing.JComponent owner, Throwable throwable) {\n" + 
				"      showError(owner, printStackTrace(throwable));\n" + 
				"   }\n" + 
				"\n" + 
				"   protected void showError(javax.swing.JComponent owner, String errors) {\n" + 
				"      final javax.swing.JPanel panel = nextgen.swing.ComponentFactory.newJPanel(new java.awt.BorderLayout());\n" + 
				"      final javax.swing.JTextArea textArea = nextgen.swing.ComponentFactory.newJTextArea(errors);\n" + 
				"      textArea.setEditable(false);\n" + 
				"      final javax.swing.JScrollPane content = nextgen.swing.ComponentFactory.newJScrollPane(textArea);\n" + 
				"      final java.awt.Dimension dimension = new java.awt.Dimension(1024, 800);\n" + 
				"      content.setMaximumSize(dimension);\n" + 
				"      content.setPreferredSize(dimension);\n" + 
				"      content.setMinimumSize(dimension);\n" + 
				"      content.setSize(dimension);\n" + 
				"      panel.add(content, java.awt.BorderLayout.CENTER);\n" + 
				"      javax.swing.JOptionPane.showMessageDialog(owner, panel, \"Errors\", javax.swing.JOptionPane.ERROR_MESSAGE);\n" + 
				"   }\n" + 
				"\n" + 
				"   protected void close(javax.swing.JDialog dialog) {\n" + 
				"      javax.swing.SwingUtilities.invokeLater(dialog::dispose);\n" + 
				"   }\n" + 
				"\n" + 
				"   protected void toClipboard(Object value) {\n" + 
				"      nextgen.utils.SwingUtil.toClipboard(value.toString());\n" + 
				"   }\n" + 
				"\n" + 
				"   protected String fromClipboard() {\n" + 
				"      return nextgen.utils.SwingUtil.fromClipboard();\n" + 
				"   }\n" + 
				"} >>";
}  