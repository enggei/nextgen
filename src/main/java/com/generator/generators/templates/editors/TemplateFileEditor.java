package com.generator.generators.templates.editors;

import com.generator.domain.BaseEntity;
import com.generator.editors.domain.NeoModel;
import com.generator.generators.junit.JunitGroup;
import com.generator.generators.templateGroup.TemplateGroupGenerator;
import com.generator.generators.templates.TemplateVisitor;
import com.generator.generators.templates.domain.*;
import com.generator.generators.templates.parser.TemplateFileParser;
import com.generator.generators.templatesNeo.TemplateNeoGenerator;
import com.generator.generators.templatesSwing.TemplateSwingGenerator;
import com.generator.generators.templatesVertx.TemplatesVertxGenerator;
import com.generator.util.FileUtil;
import com.generator.util.StringUtil;
import com.generator.util.SwingUtil;

import javax.swing.*;
import javax.swing.text.DefaultHighlighter;
import javax.swing.tree.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.List;

import static com.generator.generators.templates.domain.GeneratedFile.pathToPackage;
import static com.generator.util.FileUtil.readIntact;
import static com.generator.util.FileUtil.writeFile;

/**
 * goe on 12/17/15.
 */
public class TemplateFileEditor extends JPanel {

	private final JTree tree = new JTree(new DefaultMutableTreeNode(""));
	private final JTextArea txtEditor = new JTextArea();

	// todo always generate all classes, remove options :
	private final JCheckBox chkCreateGroup = new JCheckBox("Generate Group", true);
	private final JCheckBox chkCreateVerticles = new JCheckBox("Generate Verticles", false);
	private final JCheckBox chkCreateSwing = new JCheckBox("Generate Swing UI", false);
	private final JCheckBox chkCreateNeoDomain = new JCheckBox("Generate Neo", false);

	private final JTextField txtRoot = new JTextField(System.getProperty("generator.root"));
	private final TemplateRenderer templateRenderer = new TemplateRenderer();

	private final List<File> currentFiles = new ArrayList<>();

	private TemplateFile currentTemplateFile;
	private TemplateStatement currentStatement;

	public TemplateFileEditor(NeoModel model) {
		super(new BorderLayout());

		final JButton btnNewTemplate = new JButton(new AbstractAction("New") {
			@Override
			public void actionPerformed(ActionEvent e) {

				final String name = SwingUtil.showInputDialog("package", txtEditor, "com.generator.generators.[name]");
				if (name == null) return;

				final File newDirectory = new File(txtRoot.getText(), GeneratedFile.packageToPath(name));
				if (newDirectory.exists()) {
					SwingUtil.showMessage("Directory '" + name + "' already exists.", txtEditor);
					return;
				}

				try {

					final File newTemplateFile = FileUtil.tryToCreateFileIfNotExists(new File(newDirectory, StringUtil.lowFirst(name.substring(name.lastIndexOf(".") + 1) + ".stg")));
					writeFile("delimiters \"~\", \"~\"", newTemplateFile);

					// insert node as first child of root:
					final DefaultMutableTreeNode root = (DefaultMutableTreeNode) tree.getModel().getRoot();
					root.insert(createNodesFor(new TemplateFile(newTemplateFile)), 0);
					setFile(newTemplateFile);

				} catch (Throwable e1) {
					SwingUtil.showExceptionNoStack(txtEditor, e1);
				}
			}
		});

		final JButton btnOpenFile = new JButton(new AbstractAction("Open") {
			@Override
			public void actionPerformed(ActionEvent e) {

				SwingUtilities.invokeLater(() -> {

					setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));

					currentFiles.clear();
					currentFiles.addAll(FileUtil.findAllFilesWhichEndsWith(txtRoot.getText(), ".stg"));

					Collections.sort(currentFiles, new Comparator<File>() {
						@Override
						public int compare(File o1, File o2) {
							final int nameComp = o1.getName().compareToIgnoreCase(o2.getName());
							return nameComp != 0 ? nameComp : o1.getAbsolutePath().compareTo(o2.getAbsolutePath());
						}
					});

					setTemplateRoot(currentFiles);
				});
			}
		});

		txtEditor.setFont(new Font("Hack", Font.PLAIN, 10));
		txtEditor.setTabSize(3);
		txtEditor.setEditable(false);
		txtEditor.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent ke) {

				if (currentStatement == null) return;

				if (ke.getKeyCode() == KeyEvent.VK_ENTER && ke.getModifiers() == KeyEvent.CTRL_MASK) {
					tryToSaveStatement();

				} else if (ke.getKeyCode() == KeyEvent.VK_L && ke.getModifiers() == KeyEvent.CTRL_MASK) {
					insertListProperty();

				} else if (ke.getKeyCode() == KeyEvent.VK_I && ke.getModifiers() == KeyEvent.CTRL_MASK) {
					insertIf();

				} else if (ke.getKeyCode() == KeyEvent.VK_SPACE && ke.getModifiers() == KeyEvent.CTRL_MASK) {
					insertSimpleProperty();

				} else if (ke.getKeyCode() == KeyEvent.VK_R && ke.getModifiers() == KeyEvent.CTRL_MASK) {
					replaceAndInsertProperty();

				} else if (ke.getKeyCode() == KeyEvent.VK_M && ke.getModifiers() == KeyEvent.CTRL_MASK) {
					makeMethod();

				} else if (ke.getKeyCode() == KeyEvent.VK_DELETE && ke.getModifiers() == KeyEvent.SHIFT_MASK) {
					deleteCurrentLine();

				}
			}

			private void makeMethod() {
				final String selected = txtEditor.getSelectedText();
				if (selected == null || selected.length() < 1) return;

				tryToCreateNewStatement(selected);
			}

			private void replaceAndInsertProperty() {
				final String selected = txtEditor.getSelectedText();
				if (selected == null || selected.length() < 1) return;

				final String propertyName = SwingUtil.showInputDialog("propertyName", txtEditor);
				if (propertyName == null) return;

				final String replacement = currentTemplateFile.getDelimiter() + propertyName + currentTemplateFile.getDelimiter();
				txtEditor.setText(txtEditor.getText().replaceAll(selected, (currentTemplateFile.getDelimiter() == '$' ? replacement.replaceAll("\\$", "\\\\\\$") : replacement)));
				SwingUtil.tryToHighlight(txtEditor, Arrays.asList(replacement), new ParamsHighlighter());
			}

			private void insertSimpleProperty() {
				SwingUtilities.invokeLater(() -> {

					removeSelectedTextIfAny();

					final int caretPosition = txtEditor.getCaretPosition();
					txtEditor.insert(currentTemplateFile.getDelimiter() + "" + currentTemplateFile.getDelimiter(), caretPosition);
					txtEditor.setCaretPosition(caretPosition + 1);
				});
			}

			private void tryToSaveStatement() {

				try {

					final int oldCaret = txtEditor.getCaretPosition();

					final TemplateStatement parsed = new TemplateFileParser().parse(currentTemplateFile.getDelimiter() + "", currentStatement.getName(), txtEditor.getText());
					if (parsed == null)
						throw new Exception("Unparseable template. Check properties and try again.");

					currentTemplateFile.removeStatement(currentStatement.getName());
					currentTemplateFile.addStatement(parsed);

					saveModel();

					// select parsed statement
					SwingUtilities.invokeLater(() -> {
						final TreePath path = findStatementByName((DefaultMutableTreeNode) tree.getModel().getRoot(), currentTemplateFile.getName(), currentStatement.getName());
						tree.expandPath(path);
						tree.setSelectionPath(path);
						tree.scrollPathToVisible(path);

						currentStatement = parsed;

						txtEditor.setEditable(true);
						txtEditor.setText(parsed.getText().trim());
						txtEditor.setCaretPosition(Math.min(txtEditor.getText().length(), Math.max(0, oldCaret)));
					});

				} catch (Exception e) {
					SwingUtil.showExceptionNoStack(txtEditor, e);
				}
			}

			private void insertListProperty() {

				final String input = SwingUtil.showInputDialog("name", txtEditor);
				if (input == null) return;

				final String name = input.contains(" ") ? input.split(" ")[0] : input.trim();
				final String separator = input.contains(" ") ? input.split(" ")[1] : null;

				SwingUtilities.invokeLater(() -> {

					removeSelectedTextIfAny();

					final int caretPosition = txtEditor.getCaretPosition();
					final String pre = currentTemplateFile.getDelimiter() + name + ":{it|";
					final String sep = separator == null ? "" : ";separator=\"" + separator + "\"";
					final String list = pre + "}" + sep + currentTemplateFile.getDelimiter();
					txtEditor.insert(list, caretPosition);
					txtEditor.setCaretPosition(caretPosition + pre.length());
				});
			}

			private void removeSelectedTextIfAny() {
				if (txtEditor.getSelectedText() != null) {
					final int selectionStart = txtEditor.getSelectionStart();
					txtEditor.replaceRange("", selectionStart, txtEditor.getSelectionEnd());
					txtEditor.setCaretPosition(selectionStart);
				}
			}

			private void insertIf() {

				final String input = SwingUtil.showInputDialog("condition", txtEditor);
				if (input == null) return;

				final String name = input.trim();

				SwingUtilities.invokeLater(() -> {

					removeSelectedTextIfAny();

					final int caretPosition = txtEditor.getCaretPosition();
					final String pre = currentTemplateFile.getDelimiter() + "if(" + name + ")" + currentTemplateFile.getDelimiter();
					final String list = pre + currentTemplateFile.getDelimiter() + "endif" + currentTemplateFile.getDelimiter();
					txtEditor.insert(list, caretPosition);
					txtEditor.setCaretPosition(caretPosition + pre.length());
				});
			}

			private void deleteCurrentLine() {
				final String txt = txtEditor.getText();
				int startOfLine = txtEditor.getCaretPosition();
				while (startOfLine > 0) {

					startOfLine--;

					if (startOfLine < 0) {
						startOfLine++;
						break;
					}

					if (txt.charAt(startOfLine) == '\n') {
						startOfLine++;
						break;
					}
				}

				int endOfLine = startOfLine;
				while (endOfLine < txt.length()) {

					if (endOfLine >= txt.length()) {
						endOfLine = txt.length() - 1;
						break;
					}

					if (txt.charAt(endOfLine) == '\n') {
						break;
					}

					endOfLine++;
				}

				if (endOfLine == startOfLine) {
					endOfLine++;
					if (endOfLine >= txt.length())
						endOfLine = txt.length() - 1;
				}

				if (endOfLine <= startOfLine) return;

				txtEditor.replaceRange("", startOfLine, endOfLine);
			}
		});

		tree.setModel(null);
		tree.setCellRenderer(new DefaultTreeCellRenderer() {
			@Override
			public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {
				final Object userObject = ((DefaultMutableTreeNode) value).getUserObject();

				final String text = txtRoot.getText();

				if (!(userObject instanceof BaseEntity)) {
					String s = userObject.toString();
					return super.getTreeCellRendererComponent(tree, s.startsWith(text) ? (s.equals(text) ? s : s.substring(text.length())) : s, sel, expanded, leaf, row, hasFocus);
				}

				final BaseEntity<TemplateEntities> entity = (BaseEntity<TemplateEntities>) userObject;

				JLabel component;
				switch (entity.getDomainType()) {
					case TEMPLATESTATEMENT:
						component = (JLabel) super.getTreeCellRendererComponent(tree, ((TemplateStatement) entity).getName(), sel, expanded, leaf, row, hasFocus);
						break;
					case TEMPLATEPARAMETER:
						component = (JLabel) super.getTreeCellRendererComponent(tree, ((TemplateParameter) entity).getPropertyName(), sel, expanded, leaf, row, hasFocus);
						break;
					case TEMPLATEFILE:
						final String s = ((TemplateFile) entity).getName();
						component = (JLabel) super.getTreeCellRendererComponent(tree, s.startsWith(text) ? (s.equals(text) ? s : s.substring(text.length())) : s, sel, expanded, leaf, row, hasFocus);
						break;
					case TEMPLATEIMPORT:
						component = (JLabel) super.getTreeCellRendererComponent(tree, ((TemplateImport) entity).getName(), sel, expanded, leaf, row, hasFocus);
						break;
					case STRINGPROPERTY:
						component = (JLabel) super.getTreeCellRendererComponent(tree, ((StringProperty) entity).getValue(), sel, expanded, leaf, row, hasFocus);
						break;
					default:
						System.out.println("Unsupported entity in tree: " + entity.getClass());
						component = (JLabel) super.getTreeCellRendererComponent(tree, entity, sel, expanded, leaf, row, hasFocus);
						break;
				}

//				if (component != null)
//					component.setIcon(IconManager.getIcon(entity.getType().name()));

				return component;

			}
		});

		tree.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				final TreePath selectionPath = tree.getSelectionPath();
				if (selectionPath == null) return;

				final DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) selectionPath.getLastPathComponent();

				if (SwingUtilities.isRightMouseButton(e)) {

					final JPopupMenu menu = new JPopupMenu();

					final BaseEntity<TemplateEntities> entity = (BaseEntity<TemplateEntities>) selectedNode.getUserObject();
					switch (entity.getDomainType()) {

						case TEMPLATESTATEMENT:

							menu.add(new AbstractAction("Del") {
								@Override
								public void actionPerformed(ActionEvent e) {
									currentTemplateFile.removeStatement(currentStatement.getName());
									saveModel();
								}
							});

							menu.add(new AbstractAction("As template") {
								@Override
								public void actionPerformed(ActionEvent e) {
									SwingUtil.toClipboard(currentStatement.toString());
								}
							});

							break;

						case TEMPLATEPARAMETER:
							// todo rename the parameter (replace all in statement)
							break;

						case TEMPLATEFILE:

							menu.add(new AbstractAction("New statement") {
								@Override
								public void actionPerformed(ActionEvent e) {

									final String name = SwingUtil.showInputDialog("Statement name", txtEditor);
									if (name == null) return;

									tryToCreateNewStatement(name);
								}
							});

							menu.add(new AbstractAction("Create Domain") {
								@Override
								public void actionPerformed(ActionEvent e) {
									final TemplateFile templateFile = (TemplateFile) entity;
									final DomainFromTemplatePanel domainFromTemplatePanel = new DomainFromTemplatePanel(templateFile, txtRoot.getText());
									SwingUtil.showDialog(domainFromTemplatePanel, tree, templateFile.getName() + " Domain", domainFromTemplatePanel::generateDomain);
								}
							});
							break;
					}

					SwingUtil.showPopup(menu, tree, e);

				} else {

					final BaseEntity<TemplateEntities> entity = (BaseEntity<TemplateEntities>) selectedNode.getUserObject();
					switch (entity.getDomainType()) {

						case TEMPLATESTATEMENT:

							final DefaultMutableTreeNode parent = (DefaultMutableTreeNode) selectedNode.getParent();
							final TemplateFile templateFile = (TemplateFile) parent.getUserObject();
							if (currentTemplateFile == null || !currentTemplateFile.getFile().equals(templateFile.getFile()))
								currentTemplateFile = templateFile;
							currentStatement = (TemplateStatement) entity;

							setText(currentStatement.getText().trim());
							templateRenderer.setStatement(currentStatement);
							break;

						case TEMPLATEPARAMETER:
							final TemplateParameter templateParameter = (TemplateParameter) entity;
							final String name = templateParameter.getPropertyName();
							final String simple = currentTemplateFile.getDelimiter() + name + currentTemplateFile.getDelimiter();
							final String formatted = currentTemplateFile.getDelimiter() + name + ";";
							final String list = currentTemplateFile.getDelimiter() + name + ":";
							final String methodCall = currentTemplateFile.getDelimiter() + name + "(";
							final String methodParam = "=" + name;
							final String ifName = currentTemplateFile.getDelimiter() + "if(" + name + ")" + currentTemplateFile.getDelimiter();
							SwingUtil.tryToHighlight(txtEditor, Arrays.asList(name, simple, formatted, list, methodCall, methodParam, ifName), new ParamsHighlighter());
							break;

						case TEMPLATEFILE:

							currentStatement = null;
							templateRenderer.setStatement(null);
							currentTemplateFile = (TemplateFile) entity;

							setText(readIntact(currentTemplateFile.getFile()));
							txtEditor.setEditable(false);
							break;
					}
				}
			}


		});

		chkCreateGroup.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				txtRoot.setEditable(chkCreateGroup.isSelected());
				chkCreateNeoDomain.setEnabled(chkCreateGroup.isSelected());
				chkCreateVerticles.setEnabled(chkCreateGroup.isSelected());
				chkCreateSwing.setEnabled(chkCreateGroup.isSelected());
			}
		});

		// layout:
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

		final JPanel commandPanel = new JPanel();
		final BoxLayout layout = new BoxLayout(commandPanel, BoxLayout.LINE_AXIS);
		commandPanel.setLayout(layout);
		commandPanel.add(btnOpenFile);
		commandPanel.add(btnNewTemplate);
		commandPanel.add(chkCreateGroup);
		commandPanel.add(txtRoot);
		commandPanel.add(chkCreateNeoDomain);
		commandPanel.add(chkCreateVerticles);
		commandPanel.add(chkCreateSwing);

		final JScrollPane treeScroller = new JScrollPane(tree);
		final JScrollPane editorScroller = new JScrollPane(txtEditor);

		final Dimension preferredSize = new Dimension(1024, 786);
		setPreferredSize(preferredSize);
		setMinimumSize(preferredSize);
		setMinimumSize(preferredSize);

		treeScroller.setPreferredSize(new Dimension(320, 480));
		treeScroller.setMinimumSize(new Dimension(320, 480));
		treeScroller.setMaximumSize(new Dimension(600, 786));

		editorScroller.setPreferredSize(new Dimension(320, 480));
		editorScroller.setMinimumSize(new Dimension(320, 480));
		editorScroller.setSize(new Dimension(320, 480));

		templateRenderer.setPreferredSize(new Dimension(800, 600));
		templateRenderer.setMinimumSize(new Dimension(600, 480));

		add(commandPanel, BorderLayout.NORTH);
		add(treeScroller, BorderLayout.WEST);
		add(editorScroller, BorderLayout.CENTER);
		//add(templateRenderer, BorderLayout.EAST);
	}

	private void tryToCreateNewStatement(String name) {
		for (TemplateStatement statement : currentTemplateFile.getStatements()) {
			if (name.equals(statement.getName())) {
				SwingUtil.showMessage("'" + name + "' is taken in this group. Please use another name.", txtEditor);
				return;
			}
		}

		final TemplateStatementType type = SwingUtil.showSelectDialog(txtEditor, TemplateStatementType.values());
		if (type == null) return;

		final TemplateStatement newStatement = new TemplateStatement(UUID.randomUUID(), name, type, "", currentTemplateFile.getDelimiter());
		currentTemplateFile.addStatement(newStatement);

		saveModel();

		// select parsed statement
		SwingUtilities.invokeLater(() -> {
			final TreePath path = findStatementByName((DefaultMutableTreeNode) tree.getModel().getRoot(), currentTemplateFile.getName(), newStatement.getName());
			tree.expandPath(path);
			tree.setSelectionPath(path);
			tree.scrollPathToVisible(path);

			currentStatement = newStatement;
			setText(newStatement.getText());

		});
	}

	private void setText(String text) {
		txtEditor.setEditable(true);
		txtEditor.setText(text);
		txtEditor.setCaretPosition(0);
	}

	private void saveModel() {

		currentTemplateFile.save();
		setFile(currentTemplateFile.getFile());

		if (chkCreateGroup.isSelected()) {

			final String subPath = currentTemplateFile.getFile().getAbsolutePath().substring(new File(txtRoot.getText()).getAbsolutePath().length() + 1);
			final String builderPackage = pathToPackage(subPath.substring(0, subPath.lastIndexOf("/")));

			TemplateVisitor.visit(currentTemplateFile.getFile(), new TemplateGroupGenerator(txtRoot.getText(), builderPackage));
			createGroupTestIfNotExists(builderPackage);

			if (chkCreateNeoDomain.isSelected())
				TemplateVisitor.visit(currentTemplateFile.getFile(), new TemplateNeoGenerator(txtRoot.getText(), builderPackage));

			if (chkCreateVerticles.isSelected())
				TemplateVisitor.visit(currentTemplateFile.getFile(), new TemplatesVertxGenerator(txtRoot.getText(), builderPackage));

			if (chkCreateSwing.isSelected())
				TemplateVisitor.visit(currentTemplateFile.getFile(), new TemplateSwingGenerator(txtRoot.getText(), builderPackage));
		}
	}

	private void createGroupTestIfNotExists(String builderPackage) {
		final String model = StringUtil.capitalize(this.currentTemplateFile.getName().substring(0, this.currentTemplateFile.getName().indexOf(".")));
		final String groupName = model + "Group";
		final String testName = model + "Tests";
		final File groupTestFile = new File(this.currentTemplateFile.getFile().getParent(), testName + ".java");

		if (groupTestFile.exists()) return;  // do not create if it already exists

		final JunitGroup junitGroup = new JunitGroup();
		try {
			writeFile(junitGroup.newtests().
					setName(testName).
					setPackage(builderPackage).
					addTestsValue(junitGroup.newtemplateGroupTest().
						setGroupName(groupName).
						setName(model)).
					addTestsValue(junitGroup.newtemplateNeoTest().
						setName(model).
						setDbPath("src/test/tests/db")),
				groupTestFile);

		} catch (IOException e) {
			SwingUtil.showExceptionNoStack(txtEditor, e);
		}
	}

	private TreePath findStatementByName(DefaultMutableTreeNode root, String templateFile, String template) {
		@SuppressWarnings("unchecked")
		Enumeration<DefaultMutableTreeNode> e = root.depthFirstEnumeration();

		while (e.hasMoreElements()) {
			DefaultMutableTreeNode node = e.nextElement();
			System.out.println(node.getUserObject());

			if ((node.getUserObject() instanceof TemplateStatement) && ((TemplateStatement) node.getUserObject()).getName().equals(template)) {
				final DefaultMutableTreeNode parent = (DefaultMutableTreeNode) node.getParent();

				if ((parent.getUserObject() instanceof TemplateFile) && ((TemplateFile) parent.getUserObject()).getFile().getAbsolutePath().endsWith(templateFile))
					return new TreePath(node.getPath());
			}
		}

		return null;
	}

	private void setTemplateRoot(final List<File> files) {
		SwingUtilities.invokeLater(() -> {

			final DefaultMutableTreeNode root = new DefaultMutableTreeNode(new StringProperty(txtRoot.getText()));

			for (File file : files) {
				TemplateFile templateFile = new TemplateFileParser().parse(file);
				if (templateFile == null) {
					System.err.println(file.getAbsolutePath() + " is unparseable");
					continue;
				}

				// populate tree
				root.add(createNodesFor(templateFile));
			}

			tree.setModel(new DefaultTreeModel(root));

			setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		});
	}

	private void setFile(final File file) {
		SwingUtilities.invokeLater(() -> {

			currentTemplateFile = new TemplateFileParser().parse(file);

			txtEditor.setText(readIntact(currentTemplateFile.getFile()));
			txtEditor.setCaretPosition(0);
			txtEditor.setEditable(false);

			// create new node:
			final DefaultMutableTreeNode newNode = createNodesFor(currentTemplateFile);

			// find templateNode in tree, and replace it if it already exist:
			final DefaultMutableTreeNode rootNode = (DefaultMutableTreeNode) tree.getModel().getRoot();
			final DefaultMutableTreeNode existingNode = searchNode(rootNode, currentTemplateFile.getFile());
			final DefaultTreeModel treeModel = (DefaultTreeModel) tree.getModel();
			final int index = treeModel.getIndexOfChild(existingNode.getParent(), existingNode);
			treeModel.insertNodeInto(newNode, (MutableTreeNode) existingNode.getParent(), index);
			treeModel.removeNodeFromParent(existingNode);

			final TreeNode[] pathToRoot = treeModel.getPathToRoot(newNode);
			tree.setSelectionPath(new TreePath(pathToRoot));

			// if node is TemplateFile, expand it
		});
	}

	private DefaultMutableTreeNode createNodesFor(TemplateFile templateFile) {

		final DefaultMutableTreeNode templateRoot = new DefaultMutableTreeNode(templateFile);

		for (TemplateImport anImport : templateFile.getImports())
			templateRoot.add(new DefaultMutableTreeNode(anImport));

		for (TemplateStatement templateStatement : templateFile.getStatements()) {
			final DefaultMutableTreeNode templateNode = new DefaultMutableTreeNode(templateStatement);
			templateRoot.add(templateNode);
			for (String params : templateStatement.getParameterNames())
				templateNode.add(new DefaultMutableTreeNode(templateStatement.getParameter(params)));
		}

		return templateRoot;
	}

	public DefaultMutableTreeNode searchNode(DefaultMutableTreeNode rootNode, File file) {
		final Enumeration e = rootNode.breadthFirstEnumeration();
		while (e.hasMoreElements()) {
			final DefaultMutableTreeNode node = (DefaultMutableTreeNode) e.nextElement();
			if (node.getUserObject() instanceof BaseEntity) {
				final BaseEntity entity = (BaseEntity) node.getUserObject();
				if (entity.getDomainType().equals(TemplateEntities.TEMPLATEFILE) && ((TemplateFile) entity).getFile().equals(file))
					return node;
			}
		}
		return null;
	}


	private class ParamsHighlighter extends DefaultHighlighter.DefaultHighlightPainter {
		public ParamsHighlighter() {
			super(new Color(255, 127, 0));
		}
	}
}