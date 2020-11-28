package nextgen.templates.javaswing;

public class SwingUtil {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _packageName;
	private Object _name;

	SwingUtil(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("SwingUtil");
		st.add("packageName", _packageName);
		st.add("name", _name);
		return st.render().trim();
	}

	public SwingUtil setPackageName(Object value) {
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

	public SwingUtil removePackageName() {
		this._packageName = null;
		return this;
	} 

	public SwingUtil setName(Object value) {
		this._name = value;
		return this;
	}

	public Object getName() {
		return this._name;
	}

	public Object getName(Object defaultValue) {
		return this._name == null ? defaultValue : this._name;
	}

	public boolean hasName() {
		return this._name != null;
	}

	public SwingUtil removeName() {
		this._name = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		SwingUtil that = (SwingUtil) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "SwingUtil(packageName,name) ::= <<package ~packageName~;\n" + 
				"\n" + 
				"import com.jgoodies.forms.builder.FormBuilder;\n" + 
				"import com.jgoodies.forms.debug.FormDebugPanel;\n" + 
				"import com.jgoodies.forms.layout.CellConstraints;\n" + 
				"import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;\n" + 
				"import org.fife.ui.rtextarea.RTextScrollPane;\n" + 
				"import org.jetbrains.annotations.NotNull;\n" + 
				"\n" + 
				"import javax.swing.*;\n" + 
				"import javax.swing.text.BadLocationException;\n" + 
				"import javax.swing.text.DefaultHighlighter;\n" + 
				"import javax.swing.text.Highlighter;\n" + 
				"import javax.swing.text.JTextComponent;\n" + 
				"import java.awt.*;\n" + 
				"import java.awt.datatransfer.Clipboard;\n" + 
				"import java.awt.datatransfer.DataFlavor;\n" + 
				"import java.awt.datatransfer.StringSelection;\n" + 
				"import java.awt.datatransfer.Transferable;\n" + 
				"import java.awt.event.*;\n" + 
				"import java.io.File;\n" + 
				"import java.io.PrintStream;\n" + 
				"import java.io.PrintWriter;\n" + 
				"import java.io.StringWriter;\n" + 
				"import java.util.List;\n" + 
				"import java.util.*;\n" + 
				"import java.util.function.Consumer;\n" + 
				"import java.util.regex.Matcher;\n" + 
				"import java.util.regex.Pattern;\n" + 
				"\n" + 
				"import static javax.swing.JOptionPane.*;\n" + 
				"\n" + 
				"public class ~name~ {\n" + 
				"\n" + 
				"	public static Font getDefaultFont() {\n" + 
				"		return new Font(\"Hack\", Font.PLAIN, 20);\n" + 
				"	}\n" + 
				"\n" + 
				"	public static JTextField newTextField() {\n" + 
				"		return new JTextField();\n" + 
				"	}\n" + 
				"\n" + 
				"	public static String fromClipboard() {\n" + 
				"		final Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();\n" + 
				"		final Transferable contents = clipboard.getContents(null);\n" + 
				"		if ((contents != null) && contents.isDataFlavorSupported(DataFlavor.stringFlavor)) {\n" + 
				"			try {\n" + 
				"				return (String) contents.getTransferData(DataFlavor.stringFlavor);\n" + 
				"			} catch (Exception e) {\n" + 
				"				e.printStackTrace();\n" + 
				"				return e.getMessage();\n" + 
				"			}\n" + 
				"		}\n" + 
				"		return \"\";\n" + 
				"	}\n" + 
				"\n" + 
				"	public static void toClipboard(String content) {\n" + 
				"		StringSelection stringSelection = new StringSelection(content);\n" + 
				"		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();\n" + 
				"		clipboard.setContents(stringSelection, (clipboard1, contents) -> {\n" + 
				"			// don't care ?\n" + 
				"		});\n" + 
				"	}\n" + 
				"\n" + 
				"	public static void showPanel(final JComponent component) {\n" + 
				"		SwingUtil.setLookAndFeel_Nimbus();\n" + 
				"\n" + 
				"		final JFrame frame = new JFrame();\n" + 
				"		frame.getContentPane().add(component, BorderLayout.CENTER);\n" + 
				"		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);\n" + 
				"		show(frame);\n" + 
				"	}\n" + 
				"\n" + 
				"	public static File showOpenDir(Component parent, String dir) {\n" + 
				"		final JFileChooser fc = dir == null || (!new File(dir).isDirectory()) ? new JFileChooser() : new JFileChooser(dir);\n" + 
				"		fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);\n" + 
				"		final int result = fc.showOpenDialog(parent);\n" + 
				"		return JFileChooser.APPROVE_OPTION == result ? fc.getSelectedFile() : null;\n" + 
				"	}\n" + 
				"\n" + 
				"	public static Optional<File> showOpenFile(Component parent, String dir) {\n" + 
				"		final JFileChooser fc = dir == null ? new JFileChooser() : new JFileChooser(new File(dir).isDirectory() ? new File(dir) : new File(dir)\n" + 
				"				.getParentFile());\n" + 
				"		final int result = fc.showOpenDialog(parent);\n" + 
				"		return Optional.ofNullable(JFileChooser.APPROVE_OPTION == result ? fc.getSelectedFile() : null);\n" + 
				"	}\n" + 
				"\n" + 
				"	public static void showTextResult(String title, String text, Component parentComponent) {\n" + 
				"		showTextResult(title, text, parentComponent, true);\n" + 
				"	}\n" + 
				"\n" + 
				"	public static void showTextResult(String title, String text, Component parentComponent, boolean modal) {\n" + 
				"		showTextResult(title, text, parentComponent, new Dimension(800, 600), modal);\n" + 
				"	}\n" + 
				"\n" + 
				"	public static void showTextResult(String title, String text, Component parentComponent, Dimension defaultSize, boolean modal) {\n" + 
				"		final JPanel panel = new JPanel(new BorderLayout());\n" + 
				"		panel.add(new JLabel(title + \" : \"), BorderLayout.NORTH);\n" + 
				"\n" + 
				"		final JTextArea txtEditor = new JTextArea(text);\n" + 
				"		txtEditor.setBackground(UIManager.getColor(\"Panel.background\"));\n" + 
				"		txtEditor.setTabSize(3);\n" + 
				"		txtEditor.setCaretPosition(0);\n" + 
				"\n" + 
				"		final JScrollPane content = new JScrollPane(txtEditor);\n" + 
				"		content.setBackground(Color.getColor(\"Panel.background\"));\n" + 
				"		if (defaultSize != null) {\n" + 
				"			content.setMaximumSize(defaultSize);\n" + 
				"			content.setPreferredSize(defaultSize);\n" + 
				"			content.setMinimumSize(defaultSize);\n" + 
				"			content.setSize(defaultSize);\n" + 
				"		}\n" + 
				"		panel.add(content, BorderLayout.CENTER);\n" + 
				"\n" + 
				"		if (modal)\n" + 
				"			showDialog(content, parentComponent, \"Text\", null, true);\n" + 
				"		else\n" + 
				"			JOptionPane.showMessageDialog(parentComponent, panel, \"Text\", INFORMATION_MESSAGE);\n" + 
				"	}\n" + 
				"\n" + 
				"	public static void showTextInput(String title, JTextArea textArea, Component component, ConfirmAction onSave) {\n" + 
				"		final JPanel panel = new JPanel(new BorderLayout(5, 5));\n" + 
				"		panel.add(new JLabel(title + \" : \"), BorderLayout.NORTH);\n" + 
				"		final JScrollPane content = new JScrollPane(textArea);\n" + 
				"		content.setMaximumSize(new Dimension(800, 600));\n" + 
				"		content.setPreferredSize(new Dimension(800, 600));\n" + 
				"		content.setMinimumSize(new Dimension(800, 600));\n" + 
				"		content.setSize(new Dimension(800, 600));\n" + 
				"		panel.add(content, BorderLayout.CENTER);\n" + 
				"\n" + 
				"		showDialog(panel, component, title, onSave);\n" + 
				"	}\n" + 
				"\n" + 
				"	public static void showException(String message, Throwable throwable, Component component) {\n" + 
				"\n" + 
				"		final String stacktrace = printStackTrace(throwable);\n" + 
				"\n" + 
				"		if (component != null) {\n" + 
				"			final JPanel panel = new JPanel(new BorderLayout());\n" + 
				"			panel.add(new JLabel(message + \" : \"), BorderLayout.NORTH);\n" + 
				"			final JScrollPane content = new JScrollPane(new JTextArea(stacktrace));\n" + 
				"			content.setMaximumSize(new Dimension(800, 600));\n" + 
				"			content.setPreferredSize(new Dimension(800, 600));\n" + 
				"			content.setMinimumSize(new Dimension(800, 600));\n" + 
				"			content.setSize(new Dimension(800, 600));\n" + 
				"			panel.add(content, BorderLayout.CENTER);\n" + 
				"			JOptionPane.showMessageDialog(component, panel, \"Exception\", JOptionPane.ERROR_MESSAGE);\n" + 
				"		} \n" + 
				"	}\n" + 
				"\n" + 
				"	@NotNull\n" + 
				"	public static String printStackTrace(Throwable throwable) {\n" + 
				"		final StringWriter stacktrace = new StringWriter();\n" + 
				"		throwable.printStackTrace(new PrintWriter(stacktrace));\n" + 
				"		return stacktrace.toString();\n" + 
				"	}\n" + 
				"\n" + 
				"	public static void showException(Throwable throwable, Component component) {\n" + 
				"		showException(\"\", throwable, component);\n" + 
				"	}\n" + 
				"\n" + 
				"	public static void showMessage(String message, Component component) {\n" + 
				"		JOptionPane.showMessageDialog(component, message);\n" + 
				"	}\n" + 
				"\n" + 
				"	private static JFrame getFrame(Component child) {\n" + 
				"		return (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, child);\n" + 
				"	}\n" + 
				"\n" + 
				"	public static void showDialog(final Component content, final Component owner, String title) {\n" + 
				"		showDialog(content, owner, title, null);\n" + 
				"	}\n" + 
				"\n" + 
				"	// todo: combine showDialog and showDialogNoDefaultButton\n" + 
				"\n" + 
				"	public static void showDialog(final Component content, final Component owner, String title, final ConfirmAction onSave) {\n" + 
				"		showDialog(content, owner, title, onSave, true);\n" + 
				"	}\n" + 
				"\n" + 
				"	public static void showDialog(final Component content, final Component owner, String title, final ConfirmAction onSave, boolean modal) {\n" + 
				"		final JDialog dialog = new JDialog(SwingUtil.getFrame(owner), title, modal);\n" + 
				"		final Component component = content instanceof FormPanel ? ((FormPanel) content).build() : (content instanceof DebugFormPanel ? ((DebugFormPanel) content)\n" + 
				"				.build() : content);\n" + 
				"		dialog.add(component, BorderLayout.CENTER);\n" + 
				"		final JPanel commandPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));\n" + 
				"\n" + 
				"		if (onSave != null) {\n" + 
				"			JButton btnSave;\n" + 
				"			commandPanel.add(btnSave = new JButton(new AbstractAction(onSave.getConfirmTitle()) {\n" + 
				"				@Override\n" + 
				"				public void actionPerformed(ActionEvent e) {\n" + 
				"					try {\n" + 
				"						onSave.verifyAndCommit();\n" + 
				"						dialog.dispose();\n" + 
				"					} catch (Exception e1) {\n" + 
				"						SwingUtil.showExceptionNoStack(content, e1);\n" + 
				"					}\n" + 
				"				}\n" + 
				"			}));\n" + 
				"			dialog.getRootPane().setDefaultButton(btnSave);\n" + 
				"		}\n" + 
				"\n" + 
				"		commandPanel.add(new JButton(new AbstractAction(onSave == null ? \"Close\" : onSave.getCancelTitle()) {\n" + 
				"			@Override\n" + 
				"			public void actionPerformed(ActionEvent e) {\n" + 
				"				SwingUtilities.invokeLater(dialog::dispose);\n" + 
				"			}\n" + 
				"		}));\n" + 
				"		dialog.add(commandPanel, BorderLayout.SOUTH);\n" + 
				"\n" + 
				"		showDialog(dialog, owner);\n" + 
				"	}\n" + 
				"\n" + 
				"	public static void showDialog(final JDialog dialog, final Component owner) {\n" + 
				"		SwingUtilities.invokeLater(() -> {\n" + 
				"			dialog.pack();\n" + 
				"			dialog.setLocationRelativeTo(owner);\n" + 
				"			dialog.setVisible(true);\n" + 
				"		});\n" + 
				"	}\n" + 
				"\n" + 
				"	public static String showInputDialog(String message, Component owner) {\n" + 
				"		final String s = JOptionPane.showInputDialog(owner, message);\n" + 
				"		return s == null ? null : s.trim();\n" + 
				"	}\n" + 
				"\n" + 
				"	public static void showNameDialog(String message, Component owner, Consumer<String> onConfirm) {\n" + 
				"		showInputDialog(message, owner, new Dimension(800, 600), onConfirm);\n" + 
				"	}\n" + 
				"\n" + 
				"	public static void showInputDialog(String message, Component owner, Consumer<String> onConfirm) {\n" + 
				"		showInputDialog(message, owner, new Dimension(800, 600), onConfirm);\n" + 
				"	}\n" + 
				"\n" + 
				"	public static void showInputDialog(String message, Component owner, String startValue, Consumer<String> onConfirm) {\n" + 
				"		showInputDialog(message, owner, new Dimension(800, 600), startValue, onConfirm);\n" + 
				"	}\n" + 
				"\n" + 
				"	public static void showInputDialog(String message, Component owner, Dimension dimension, Consumer<String> onConfirm) {\n" + 
				"		showInputDialog(message, owner, dimension, null, onConfirm);\n" + 
				"	}\n" + 
				"\n" + 
				"	public static void showInputDialog(String message, Component owner, Dimension dimension, String startValue, Consumer<String> onConfirm) {\n" + 
				"\n" + 
				"		final RSyntaxTextArea rSyntaxTextArea = newRSyntaxTextArea();\n" + 
				"		rSyntaxTextArea.setText(startValue == null ? \"\" : startValue);\n" + 
				"\n" + 
				"		final JPanel content = new JPanel(new BorderLayout());\n" + 
				"		content.add(new org.fife.ui.rtextarea.RTextScrollPane(rSyntaxTextArea), BorderLayout.CENTER);\n" + 
				"		content.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));\n" + 
				"		content.setPreferredSize(dimension);\n" + 
				"\n" + 
				"		final JDialog dialog = new JDialog(SwingUtil.getFrame(owner), message, true);\n" + 
				"		dialog.add(content, BorderLayout.CENTER);\n" + 
				"		final JPanel commandPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));\n" + 
				"\n" + 
				"		final ConfirmAction onSave = new ConfirmAction() {\n" + 
				"			@Override\n" + 
				"			public void verifyAndCommit() throws Exception {\n" + 
				"				final String s = rSyntaxTextArea.getText().trim();\n" + 
				"				if (s.trim().length() == 0) {\n" + 
				"					dialog.dispose();\n" + 
				"					return;\n" + 
				"				}\n" + 
				"				onConfirm.accept(s.trim());\n" + 
				"			}\n" + 
				"		};\n" + 
				"\n" + 
				"		rSyntaxTextArea.addKeyListener(new KeyAdapter() {\n" + 
				"			@Override\n" + 
				"			public void keyPressed(KeyEvent e) {\n" + 
				"				if (e.isControlDown() && KeyEvent.VK_S == e.getKeyCode()) {\n" + 
				"					try {\n" + 
				"						onSave.verifyAndCommit();\n" + 
				"						dialog.dispose();\n" + 
				"					} catch (Exception ex) {\n" + 
				"						ex.printStackTrace();\n" + 
				"					}\n" + 
				"				}\n" + 
				"			}\n" + 
				"		});\n" + 
				"		JButton btnSave;\n" + 
				"		commandPanel.add(btnSave = new JButton(new AbstractAction(onSave.getConfirmTitle()) {\n" + 
				"			@Override\n" + 
				"			public void actionPerformed(ActionEvent e) {\n" + 
				"				try {\n" + 
				"					onSave.verifyAndCommit();\n" + 
				"					dialog.dispose();\n" + 
				"				} catch (Exception e1) {\n" + 
				"					SwingUtil.showExceptionNoStack(content, e1);\n" + 
				"				}\n" + 
				"			}\n" + 
				"		}));\n" + 
				"		dialog.getRootPane().setDefaultButton(btnSave);\n" + 
				"\n" + 
				"		commandPanel.add(new JButton(new AbstractAction(onSave.getCancelTitle()) {\n" + 
				"			@Override\n" + 
				"			public void actionPerformed(ActionEvent e) {\n" + 
				"				SwingUtilities.invokeLater(dialog::dispose);\n" + 
				"			}\n" + 
				"		}));\n" + 
				"		dialog.add(commandPanel, BorderLayout.SOUTH);\n" + 
				"\n" + 
				"		showDialog(dialog, owner);\n" + 
				"\n" + 
				"\n" + 
				"	}\n" + 
				"\n" + 
				"	public static void showException(Component parent, Throwable t) {\n" + 
				"		t.printStackTrace();\n" + 
				"		final StringWriter stackTrace = new StringWriter();\n" + 
				"		t.printStackTrace(new PrintWriter(stackTrace));\n" + 
				"		JOptionPane.showMessageDialog(parent, t.getMessage() + \"\\n\" + stackTrace, \"Exception\", JOptionPane.ERROR_MESSAGE);\n" + 
				"	}\n" + 
				"\n" + 
				"	public static void showExceptionNoStack(Component parent, Throwable t) {\n" + 
				"		JOptionPane.showMessageDialog(parent, t.getMessage(), \"Exception\", JOptionPane.ERROR_MESSAGE);\n" + 
				"	}\n" + 
				"\n" + 
				"	public static void setLookAndFeel_Nimbus() {\n" + 
				"		setLookAndFeel();\n" + 
				"	}\n" + 
				"\n" + 
				"	private static void setLookAndFeel() {\n" + 
				"		for (UIManager.LookAndFeelInfo laf : UIManager.getInstalledLookAndFeels()) {\n" + 
				"			if (\"Nimbus\".equals(laf.getName())) {\n" + 
				"				try {\n" + 
				"					UIManager.setLookAndFeel(laf.getClassName());\n" + 
				"				} catch (Exception e) {\n" + 
				"					System.err.println(\"Could not set look and feel '\" + \"Nimbus\" + \"': \" + e.getMessage());\n" + 
				"				}\n" + 
				"			}\n" + 
				"		}\n" + 
				"	}\n" + 
				"\n" + 
				"	public static void printSwingDefaults(PrintStream out) {\n" + 
				"\n" + 
				"		final UIDefaults uid = UIManager.getDefaults();\n" + 
				"		final Enumeration<Object> uidKeys = uid.keys();\n" + 
				"		final String cr = System.getProperty(\"line.separator\");\n" + 
				"		final TreeMap<Object, Object> sortedMap = new TreeMap<>();\n" + 
				"\n" + 
				"		Object uidKey;\n" + 
				"		while (uidKeys.hasMoreElements()) {\n" + 
				"			uidKey = uidKeys.nextElement();\n" + 
				"			sortedMap.put(uidKey.toString(), uid.get(uidKey));\n" + 
				"		}\n" + 
				"\n" + 
				"		for (Object key : sortedMap.keySet()) out.print(key + \"=\" + sortedMap.get(key) + cr);\n" + 
				"\n" + 
				"//		UIManager.put(\"OptionPane.cancelButtonText\", \"Cancel\");\n" + 
				"//		UIManager.put(\"OptionPane.noButtonText\", \"No\");\n" + 
				"//		UIManager.put(\"OptionPane.okButtonText\", \"Confirm\");\n" + 
				"//		UIManager.put(\"OptionPane.yesButtonText\", \"Yes\");\n" + 
				"	}\n" + 
				"\n" + 
				"	public static void showDialog(final JDialog dialog, final Component relativeTo, final Component contentPane, final JButton confirmAction, final JButton cancelAction, final JButton defaultAction) {\n" + 
				"		dialog.add(contentPane, BorderLayout.CENTER);\n" + 
				"		final JPanel commandPane = new JPanel(new FlowLayout(FlowLayout.RIGHT));\n" + 
				"		commandPane.add(confirmAction);\n" + 
				"		commandPane.add(cancelAction);\n" + 
				"		dialog.add(commandPane, BorderLayout.SOUTH);\n" + 
				"		dialog.getRootPane().setDefaultButton(defaultAction);\n" + 
				"		SwingUtilities.invokeLater(() -> {\n" + 
				"			dialog.pack();\n" + 
				"			if (relativeTo != null) dialog.setLocationRelativeTo(relativeTo);\n" + 
				"			dialog.setVisible(true);\n" + 
				"		});\n" + 
				"	}\n" + 
				"\n" + 
				"	public static void main(String[] args) {\n" + 
				"		printSwingDefaults(System.out);\n" + 
				"	}\n" + 
				"\n" + 
				"	public static void show(final JFrame frame) {\n" + 
				"		SwingUtilities.invokeLater(() -> {\n" + 
				"			frame.pack();\n" + 
				"			frame.setLocationByPlatform(true);\n" + 
				"			frame.setVisible(true);\n" + 
				"		});\n" + 
				"	}\n" + 
				"\n" + 
				"	public static void showPopup(final JPopupMenu pop, final Component invoker, final MouseEvent e) {\n" + 
				"		SwingUtilities.invokeLater(() -> {\n" + 
				"			pop.setInvoker(invoker);\n" + 
				"			pop.show(invoker, e.getX(), e.getY());\n" + 
				"		});\n" + 
				"	}\n" + 
				"\n" + 
				"	public static boolean showConfirmDialog(Component parent, String message) {\n" + 
				"		return JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(parent, message + \" ?\");\n" + 
				"	}\n" + 
				"\n" + 
				"	public static void showDialog(final JDialog dialog, final Dimension size, final Component owner) {\n" + 
				"		SwingUtilities.invokeLater(() -> {\n" + 
				"			try {\n" + 
				"				if (size == null) dialog.pack();\n" + 
				"				else dialog.setSize(size);\n" + 
				"				dialog.setLocationRelativeTo(owner);\n" + 
				"				dialog.setVisible(true);\n" + 
				"			} catch (Exception e) {\n" + 
				"				e.printStackTrace();\n" + 
				"			}\n" + 
				"		});\n" + 
				"	}\n" + 
				"\n" + 
				"	public static <T> JComboBox<T> newComboBox(T[] enumValues, T selected) {\n" + 
				"		return newComboBox(new LinkedHashSet<>(Arrays.asList(enumValues)), selected);\n" + 
				"	}\n" + 
				"\n" + 
				"	@SuppressWarnings(\"unchecked\")\n" + 
				"	public static <T> JComboBox<T> newComboBox(Set<T> enumValues, T selected) {\n" + 
				"		final T[] values = (T[]) new Object[enumValues.size()];\n" + 
				"		int index = 0;\n" + 
				"		for (T enumValue : enumValues)\n" + 
				"			values[index++] = enumValue;\n" + 
				"		final JComboBox<T> comboBox = new JComboBox<>(values);\n" + 
				"		if (selected != null) comboBox.setSelectedItem(selected);\n" + 
				"		return comboBox;\n" + 
				"	}\n" + 
				"\n" + 
				"	public static abstract class ConfirmAction {\n" + 
				"\n" + 
				"		private final String confirmTitle;\n" + 
				"		private final String cancelTitle;\n" + 
				"\n" + 
				"		public ConfirmAction() {\n" + 
				"			this(\"Save\", \"Cancel\");\n" + 
				"		}\n" + 
				"\n" + 
				"		public ConfirmAction(String confirmTitle, String cancelTitle) {\n" + 
				"			this.confirmTitle = confirmTitle;\n" + 
				"			this.cancelTitle = cancelTitle;\n" + 
				"		}\n" + 
				"\n" + 
				"		public abstract void verifyAndCommit() throws Exception;\n" + 
				"\n" + 
				"		String getConfirmTitle() {\n" + 
				"			return confirmTitle;\n" + 
				"		}\n" + 
				"\n" + 
				"		String getCancelTitle() {\n" + 
				"			return cancelTitle;\n" + 
				"		}\n" + 
				"	}\n" + 
				"\n" + 
				"	public static class DebugFormPanel extends FormDebugPanel {\n" + 
				"\n" + 
				"		private final FormBuilder builder;\n" + 
				"		private final CellConstraints cc;\n" + 
				"		private final CellConstraints.Alignment colAlign;\n" + 
				"		private final CellConstraints.Alignment rowAlign;\n" + 
				"\n" + 
				"		DebugFormPanel(String columns, String rows, CellConstraints.Alignment colAlign, CellConstraints.Alignment rowAlign) {\n" + 
				"			this.cc = new CellConstraints();\n" + 
				"			this.builder = FormBuilder.create().debug(true).columns(columns).rows(rows);\n" + 
				"			this.colAlign = colAlign;\n" + 
				"			this.rowAlign = rowAlign;\n" + 
				"		}\n" + 
				"\n" + 
				"		public void add(Component component, int column, int row) {\n" + 
				"			this.add(component, column, row, 1, 1);\n" + 
				"		}\n" + 
				"\n" + 
				"		public void add(Component component, int column, int row, CellConstraints.Alignment colAlign, CellConstraints.Alignment rowAlign) {\n" + 
				"			this.add(component, column, row, 1, 1, colAlign, rowAlign);\n" + 
				"		}\n" + 
				"\n" + 
				"		public void add(Component component, int column, int row, int colSpan, int rowSpan) {\n" + 
				"			this.add(component, column, row, colSpan, rowSpan, this.colAlign, this.rowAlign);\n" + 
				"		}\n" + 
				"\n" + 
				"		public void addLabel(String text, int column, int row) {\n" + 
				"			this.addLabel(text, column, row, this.colAlign, this.rowAlign);\n" + 
				"		}\n" + 
				"\n" + 
				"		public void addLabel(String text, int column, int row, CellConstraints.Alignment colAlign, CellConstraints.Alignment rowAlign) {\n" + 
				"			this.addLabel(text, column, row, 1, 1, colAlign, rowAlign);\n" + 
				"		}\n" + 
				"\n" + 
				"		public void addLabel(String text, int column, int row, int colSpan, int rowSpan) {\n" + 
				"			this.add(new JLabel(text), column, row, colSpan, rowSpan, this.colAlign, this.rowAlign);\n" + 
				"		}\n" + 
				"\n" + 
				"		public void addLabel(String text, int column, int row, int colSpan, int rowSpan, CellConstraints.Alignment colAlign, CellConstraints.Alignment rowAlign) {\n" + 
				"			final JLabel label = new JLabel(text);\n" + 
				"			label.setFont(label.getFont().deriveFont(Font.BOLD));\n" + 
				"			this.add(label, column, row, colSpan, rowSpan, colAlign, rowAlign);\n" + 
				"		}\n" + 
				"\n" + 
				"		public void addSeparator(String text, int column, int row, int colSpan, int rowSpan) {\n" + 
				"			this.builder.addSeparator(text, this.cc.xywh(column, row, colSpan, rowSpan));\n" + 
				"		}\n" + 
				"\n" + 
				"		public void add(Component component, int column, int row, int colSpan, int rowSpan, CellConstraints.Alignment colAlign, CellConstraints.Alignment rowAlign) {\n" + 
				"			this.builder.add(component).at(this.cc.xywh(column, row, colSpan, rowSpan, colAlign, rowAlign));\n" + 
				"		}\n" + 
				"\n" + 
				"		protected void setTitledBorder(String title) {\n" + 
				"			this.setBorder(BorderFactory.createTitledBorder(\" \" + title + \" \"));\n" + 
				"		}\n" + 
				"\n" + 
				"		public JPanel build() {\n" + 
				"			return builder.build();\n" + 
				"		}\n" + 
				"	}\n" + 
				"\n" + 
				"	public static class FormPanel extends JPanel {\n" + 
				"		private final FormBuilder builder;\n" + 
				"		private final CellConstraints cc;\n" + 
				"		private final CellConstraints.Alignment colAlign;\n" + 
				"		private final CellConstraints.Alignment rowAlign;\n" + 
				"\n" + 
				"		public FormPanel() {\n" + 
				"			this(\"\", \"\");\n" + 
				"		}\n" + 
				"\n" + 
				"		public FormPanel(String columns, String rows) {\n" + 
				"			this(columns, rows, CellConstraints.FILL, CellConstraints.FILL);\n" + 
				"		}\n" + 
				"\n" + 
				"		public FormPanel(String columns, String rows, Component... components) {\n" + 
				"			this(columns, rows, CellConstraints.FILL, CellConstraints.FILL);\n" + 
				"\n" + 
				"			final int columnCount = rows.split(\",\").length;\n" + 
				"			int column = 1;\n" + 
				"			int row = 1;\n" + 
				"			for (Component component : components) {\n" + 
				"				add(component, column, row);\n" + 
				"				column += 2;\n" + 
				"				if (column > columnCount) {\n" + 
				"					column = 1;\n" + 
				"					row += 2;\n" + 
				"				}\n" + 
				"			}\n" + 
				"\n" + 
				"			setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));\n" + 
				"		}\n" + 
				"\n" + 
				"		public JPanel build() {\n" + 
				"			return builder.getPanel();\n" + 
				"		}\n" + 
				"\n" + 
				"		public FormPanel(String columns, String rows, CellConstraints.Alignment colAlign, CellConstraints.Alignment rowAlign) {\n" + 
				"			this.cc = new CellConstraints();\n" + 
				"			this.builder = FormBuilder.create().columns(columns).rows(rows);\n" + 
				"			this.colAlign = colAlign;\n" + 
				"			this.rowAlign = rowAlign;\n" + 
				"		}\n" + 
				"\n" + 
				"		public void add(Component component, int column, int row) {\n" + 
				"			this.add(component, column, row, 1, 1);\n" + 
				"		}\n" + 
				"\n" + 
				"		public void add(Component component, int column, int row, CellConstraints.Alignment colAlign, CellConstraints.Alignment rowAlign) {\n" + 
				"			this.add(component, column, row, 1, 1, colAlign, rowAlign);\n" + 
				"		}\n" + 
				"\n" + 
				"		public void add(Component component, int column, int row, int colSpan, int rowSpan) {\n" + 
				"			this.add(component, column, row, colSpan, rowSpan, this.colAlign, this.rowAlign);\n" + 
				"		}\n" + 
				"\n" + 
				"		public JLabel addLabel(String text, int column, int row) {\n" + 
				"			return this.addLabel(text, column, row, this.colAlign, this.rowAlign);\n" + 
				"		}\n" + 
				"\n" + 
				"		public JLabel addLabel(String text, int column, int row, CellConstraints.Alignment colAlign, CellConstraints.Alignment rowAlign) {\n" + 
				"			return this.addLabel(text, column, row, 1, 1, colAlign, rowAlign);\n" + 
				"		}\n" + 
				"\n" + 
				"		public JLabel addLabel(String text, int column, int row, int colSpan, int rowSpan, CellConstraints.Alignment colAlign, CellConstraints.Alignment rowAlign) {\n" + 
				"			final JLabel label = new JLabel(text);\n" + 
				"			this.add(label, column, row, colSpan, rowSpan, colAlign, rowAlign);\n" + 
				"			return label;\n" + 
				"		}\n" + 
				"\n" + 
				"		public void addSeparator(String text, int column, int row, int colSpan, int rowSpan) {\n" + 
				"			this.builder.addSeparator(text, this.cc.xywh(column, row, colSpan, rowSpan));\n" + 
				"		}\n" + 
				"\n" + 
				"		public void add(Component component, int column, int row, int colSpan, int rowSpan, CellConstraints.Alignment colAlign, CellConstraints.Alignment rowAlign) {\n" + 
				"			this.builder.add(component).at(this.cc.xywh(column, row, colSpan, rowSpan, colAlign, rowAlign));\n" + 
				"		}\n" + 
				"\n" + 
				"		protected void setTitledBorder(String title) {\n" + 
				"			this.setBorder(BorderFactory.createTitledBorder(\" \" + title + \" \"));\n" + 
				"		}\n" + 
				"	}\n" + 
				"\n" + 
				"	public static void tryToHighlight(JTextComponent txtEditor, final List<String> selectedText, final Highlighter.HighlightPainter highlightPainter) {\n" + 
				"		SwingUtilities.invokeLater(() -> highLight(txtEditor, selectedText, highlightPainter));\n" + 
				"	}\n" + 
				"\n" + 
				"	private static void highLight(JTextComponent textComp, Iterable<String> pattern, Highlighter.HighlightPainter highlightPainter) {\n" + 
				"\n" + 
				"		removeHighlights(textComp);\n" + 
				"\n" + 
				"		try {\n" + 
				"\n" + 
				"			// escape '$' if its used in patterns:\n" + 
				"			final StringBuilder out = new StringBuilder();\n" + 
				"			boolean first = true;\n" + 
				"			for (String item : pattern) {\n" + 
				"				if (!first) out.append(\"|\");\n" + 
				"				first = false;\n" + 
				"				out.append(item.replaceAll(\"\\\\\\$\", \"\\\\\\\\\\\\\\\\\\\\\\\\$\").replaceAll(\"\\\\\\(\", \"\\\\\\\\\\\\\\\\\\\\\\\\(\").replaceAll(\"\\\\\\)\", \"\\\\\\\\\\\\\\\\\\\\\\\\)\"));\n" + 
				"			}\n" + 
				"\n" + 
				"			final Pattern r = Pattern.compile(out.toString());\n" + 
				"			final Matcher matcher = r.matcher(textComp.getText());\n" + 
				"			final Highlighter highlighter = textComp.getHighlighter();\n" + 
				"			while (matcher.find()) {\n" + 
				"				highlighter.addHighlight(matcher.start(), matcher.end(), highlightPainter);\n" + 
				"			}\n" + 
				"\n" + 
				"		} catch (BadLocationException ble) {\n" + 
				"			ble.printStackTrace();\n" + 
				"		}\n" + 
				"	}\n" + 
				"\n" + 
				"	private static void removeHighlights(JTextComponent textComp) {\n" + 
				"		final Highlighter highlighter = textComp.getHighlighter();\n" + 
				"		final Highlighter.Highlight[] highlights = highlighter.getHighlights();\n" + 
				"		for (Highlighter.Highlight highlight : highlights) {\n" + 
				"			if (highlight.getPainter() instanceof DefaultHighlighter.DefaultHighlightPainter) {\n" + 
				"				highlighter.removeHighlight(highlight);\n" + 
				"			}\n" + 
				"		}\n" + 
				"	}\n" + 
				"\n" + 
				"	public static org.fife.ui.rsyntaxtextarea.RSyntaxTextArea newRSyntaxTextArea() {\n" + 
				"		return newRSyntaxTextArea(10, 80);\n" + 
				"	}\n" + 
				"\n" + 
				"	public static org.fife.ui.rsyntaxtextarea.RSyntaxTextArea newRSyntaxTextArea(int rows, int cols) {\n" + 
				"		return decorate(new org.fife.ui.rsyntaxtextarea.RSyntaxTextArea(rows, cols));\n" + 
				"	}\n" + 
				"\n" + 
				"	public static org.fife.ui.rsyntaxtextarea.RSyntaxTextArea decorate(org.fife.ui.rsyntaxtextarea.RSyntaxTextArea rSyntaxTextArea) {\n" + 
				"\n" + 
				"		rSyntaxTextArea.setTabSize(3);\n" + 
				"		rSyntaxTextArea.setHighlightCurrentLine(false);\n" + 
				"		rSyntaxTextArea.setSelectionColor(Color.decode(\"#2b8cbe\"));\n" + 
				"		rSyntaxTextArea.setBackground(UIManager.getColor(\"Panel.background\"));\n" + 
				"		rSyntaxTextArea.setForeground(UIManager.getColor(\"Tree.foreground\"));\n" + 
				"		rSyntaxTextArea.setFont(UIManager.getFont(\"TextField.font\"));\n" + 
				"		rSyntaxTextArea.addKeyListener(new java.awt.event.KeyAdapter() {\n" + 
				"\n" + 
				"			@Override\n" + 
				"			public void keyPressed(java.awt.event.KeyEvent keyEvent) {\n" + 
				"				if (keyEvent.getModifiers() == java.awt.event.KeyEvent.CTRL_MASK && keyEvent.getKeyCode() == java.awt.event.KeyEvent.VK_F) {\n" + 
				"					format(rSyntaxTextArea);\n" + 
				"				}\n" + 
				"			}\n" + 
				"		});\n" + 
				"\n" + 
				"		return rSyntaxTextArea;\n" + 
				"	}\n" + 
				"\n" + 
				"	public static RTextScrollPane newRTextScrollPane(RSyntaxTextArea rSyntaxTextArea) {\n" + 
				"		final RTextScrollPane scrollPane = new RTextScrollPane(rSyntaxTextArea);\n" + 
				"		scrollPane.setBackground(UIManager.getColor(\"Panel.background\"));\n" + 
				"		scrollPane.getGutter().setBackground(scrollPane.getBackground());\n" + 
				"		scrollPane.getGutter().setForeground(UIManager.getColor(\"TextField.foreground\"));\n" + 
				"		scrollPane.getGutter().setFont(UIManager.getFont(\"TextField.font\").deriveFont(29f));\n" + 
				"		return scrollPane;\n" + 
				"	}\n" + 
				"\n" + 
				"	public static void format(JTextArea txtEditor) {\n" + 
				"		final int caretPosition = txtEditor.getCaretPosition();\n" + 
				"		final StringBuilder spaces = new StringBuilder();\n" + 
				"		for (int i = 0; i < txtEditor.getTabSize(); i++) spaces.append(\" \");\n" + 
				"\n" + 
				"		String[] split = txtEditor.getText().split(\"\\n\");\n" + 
				"		final StringBuilder formatted = new StringBuilder();\n" + 
				"		for (String s : split) formatted.append(s.replace(spaces, \"\\t\")).append(\"\\n\");\n" + 
				"		split = formatted.toString().split(\"\\n\");\n" + 
				"\n" + 
				"		final StringBuilder formatted2 = new StringBuilder();\n" + 
				"		for (String s : split) {\n" + 
				"			if (s.trim().length() == 0) {\n" + 
				"				formatted2.append(\"\\n\");\n" + 
				"				continue;\n" + 
				"			}\n" + 
				"\n" + 
				"			final char[] c = s.toCharArray();\n" + 
				"			for (int i = 0; i < c.length; i++) {\n" + 
				"				if (c[i] == '\\t') {\n" + 
				"					formatted2.append(c[i]);\n" + 
				"					continue;\n" + 
				"				}\n" + 
				"				if (c[i] == ' ') continue;\n" + 
				"				formatted2.append(s.substring(i));\n" + 
				"				break;\n" + 
				"			}\n" + 
				"\n" + 
				"			formatted2.append(\"\\n\");\n" + 
				"		}\n" + 
				"		txtEditor.setText(formatted2.toString().trim());\n" + 
				"		txtEditor.setCaretPosition(Math.min(formatted2.toString().trim().length(), caretPosition));\n" + 
				"	}\n" + 
				"\n" + 
				"	public static javax.swing.JTextField newTextField(int columns) {\n" + 
				"		return newTextField(\"\", columns);\n" + 
				"	}\n" + 
				"\n" + 
				"	public static javax.swing.JTextField newTextField(String content, int columns) {\n" + 
				"		javax.swing.JTextField textField = new javax.swing.JTextField(content, columns);\n" + 
				"		textField.addMouseListener(new java.awt.event.MouseAdapter() {\n" + 
				"			@Override\n" + 
				"			public void mouseClicked(java.awt.event.MouseEvent e) {\n" + 
				"				if (javax.swing.SwingUtilities.isRightMouseButton(e))\n" + 
				"					javax.swing.SwingUtilities.invokeLater(() -> {\n" + 
				"						final javax.swing.JPopupMenu pop = new javax.swing.JPopupMenu();\n" + 
				"						pop.add(new AbstractAction(\"Set from clipboard\") {\n" + 
				"							@Override\n" + 
				"							public void actionPerformed(ActionEvent e) {\n" + 
				"								textField.setText(fromClipboard());\n" + 
				"							}\n" + 
				"						});\n" + 
				"						pop.show(textField, e.getX(), e.getY());\n" + 
				"					});\n" + 
				"			}\n" + 
				"		});\n" + 
				"		textField.addFocusListener(new java.awt.event.FocusAdapter() {\n" + 
				"			@Override\n" + 
				"			public void focusGained(java.awt.event.FocusEvent evt) {\n" + 
				"				javax.swing.SwingUtilities.invokeLater(() -> ((javax.swing.JTextField) evt.getSource()).selectAll());\n" + 
				"			}\n" + 
				"\n" + 
				"			@Override\n" + 
				"			public void focusLost(java.awt.event.FocusEvent evt) {\n" + 
				"				javax.swing.SwingUtilities.invokeLater(() -> {\n" + 
				"					((javax.swing.JTextField) evt.getSource()).setSelectionStart(0);\n" + 
				"					((javax.swing.JTextField) evt.getSource()).setSelectionEnd(0);\n" + 
				"				});\n" + 
				"			}\n" + 
				"		});\n" + 
				"		return textField;\n" + 
				"	}\n" + 
				"\n" + 
				"	public static void showDialog(JComponent parent, JDialog dialog, JButton btnSave) {\n" + 
				"\n" + 
				"		dialog.getRootPane().setDefaultButton(btnSave);\n" + 
				"\n" + 
				"		final JPanel commandPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));\n" + 
				"		commandPanel.add(btnSave);\n" + 
				"		commandPanel.add(new JButton(new AbstractAction(\"Cancel\") {\n" + 
				"			@Override\n" + 
				"			public void actionPerformed(ActionEvent e) {\n" + 
				"				SwingUtilities.invokeLater(dialog::dispose);\n" + 
				"			}\n" + 
				"		}));\n" + 
				"		dialog.add(commandPanel, BorderLayout.SOUTH);\n" + 
				"\n" + 
				"		SwingUtilities.invokeLater(() -> {\n" + 
				"			dialog.pack();\n" + 
				"			dialog.setLocationRelativeTo(parent);\n" + 
				"			dialog.setVisible(true);\n" + 
				"		});\n" + 
				"	}\n" + 
				"\n" + 
				"	public static Optional<String> getInputFromUser(JComponent parent, String message) {\n" + 
				"		final String s = SwingUtil.showInputDialog(message, parent);\n" + 
				"		return Optional.ofNullable(s == null || s.trim().length() == 0 ? null : s);\n" + 
				"	}\n" + 
				"\n" + 
				"	public static Optional<Boolean> confirm(JComponent parent, String description) {\n" + 
				"		final boolean b = SwingUtil.showConfirmDialog(parent, description);\n" + 
				"		return Optional.ofNullable(b ? Boolean.TRUE : null);\n" + 
				"	}\n" + 
				"\n" + 
				"	private static class SelectFocusAdapter extends FocusAdapter {\n" + 
				"\n" + 
				"		@Override\n" + 
				"		public void focusGained(java.awt.event.FocusEvent evt) {\n" + 
				"			SwingUtilities.invokeLater(() -> ((JTextField) evt.getSource()).selectAll());\n" + 
				"		}\n" + 
				"\n" + 
				"		@Override\n" + 
				"		public void focusLost(FocusEvent evt) {\n" + 
				"			SwingUtilities.invokeLater(() -> {\n" + 
				"				((JTextField) evt.getSource()).setSelectionStart(0);\n" + 
				"				((JTextField) evt.getSource()).setSelectionEnd(0);\n" + 
				"			});\n" + 
				"		}\n" + 
				"	}\n" + 
				"} >>";
}  