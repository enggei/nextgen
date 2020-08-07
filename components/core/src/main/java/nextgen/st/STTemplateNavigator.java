package nextgen.st;

import nextgen.utils.SwingUtil;
import nextgen.st.domain.*;
import nextgen.st.canvas.*;

import javax.swing.*;
import javax.swing.tree.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.*;
import java.util.function.Consumer;

public class STTemplateNavigator extends JPanel {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STTemplateNavigator.class);

	private final JTree tree = new JTree();
	private final STAppPresentationModel presentationModel;
	private final DefaultTreeModel treeModel;

	private STWorkspace workspace;

	public STTemplateNavigator(STAppPresentationModel presentationModel, STWorkspace workspace) {
		super(new BorderLayout());

		this.workspace = workspace;

		this.presentationModel = presentationModel;

		treeModel = new DefaultTreeModel(new RootNode("Models"));
		tree.setModel(treeModel);
		ToolTipManager.sharedInstance().registerComponent(tree);

		tree.setCellRenderer(new DefaultTreeCellRenderer() {

			@Override
			public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {
				final boolean isBaseTreeNode = value instanceof BaseTreeNode;
				if (isBaseTreeNode) {
					final BaseTreeNode<?> baseTreeNode = (BaseTreeNode<?>) value;
					final ImageIcon icon = baseTreeNode.getIcon();
					setIcon(icon);
					setOpenIcon(icon);
					setClosedIcon(icon);
					setLeafIcon(icon);
					setToolTipText(baseTreeNode.getTooltip());
					return super.getTreeCellRendererComponent(tree, baseTreeNode.getLabel(), sel, expanded, leaf, row, hasFocus);
				}
				return super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);
			}
		});

		tree.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (SwingUtilities.isRightMouseButton(e)) {

					final TreePath selectionPath = tree.getPathForLocation(e.getX(), e.getY());
					if (selectionPath == null) return;
					final Object lastPathComponent = selectionPath.getLastPathComponent();
					if (!(lastPathComponent instanceof BaseTreeNode<?>)) return;

					showPopup((BaseTreeNode<?>) lastPathComponent, e.getX(), e.getY());
				}
			}
		});

		tree.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_SPACE) {
					final TreePath selectionPath = tree.getSelectionPath();
					if (selectionPath == null) return;
					final Object lastPathComponent = selectionPath.getLastPathComponent();
					if (!(lastPathComponent instanceof BaseTreeNode<?>)) return;

					final Rectangle bounds = tree.getPathBounds(selectionPath);
					if (bounds == null) return;

					showPopup((BaseTreeNode<?>) lastPathComponent, (int) bounds.getX(), (int) bounds.getY());
				}
			}
		});

		tree.addTreeSelectionListener(e -> {
			if (e.getNewLeadSelectionPath() == null) return;

			if (tree.getSelectionCount() == 1) {
				final TreePath path = e.getPath();
				final Object lastPathComponent = path.getLastPathComponent();

				if (lastPathComponent instanceof STGroupTreeNode) {
					final STGroupTreeNode selectedNode = (STGroupTreeNode) lastPathComponent;
					workspace.getSTEditor(selectedNode.getModel());
				} else if (lastPathComponent instanceof STTemplateTreeNode) {
					final STTemplateTreeNode selectedNode = (STTemplateTreeNode) lastPathComponent;
					selectedNode.getParentNode(STGroupTreeNode.class).ifPresent(stGroupTreeNode -> workspace.getSTEditor(stGroupTreeNode.getModel()).setSTTemplate(selectedNode.getModel()));
				} else if (lastPathComponent instanceof STEnumTreeNode) {
					final STEnumTreeNode selectedNode = (STEnumTreeNode) lastPathComponent;
					selectedNode.getParentNode(STGroupTreeNode.class).ifPresent(stGroupTreeNode -> workspace.getSTEditor(stGroupTreeNode.getModel()).setSTEnum(selectedNode.getModel()));
				} else if (lastPathComponent instanceof STInterfaceTreeNode) {
					final STInterfaceTreeNode selectedNode = (STInterfaceTreeNode) lastPathComponent;
					selectedNode.getParentNode(STGroupTreeNode.class).ifPresent(stGroupTreeNode -> workspace.getSTEditor(stGroupTreeNode.getModel()).setSTInterface(selectedNode.getModel()));
				}
			}
		});

		setPreferredSize(new Dimension(300, 600));
		add(new JScrollPane(tree), BorderLayout.CENTER);
	}

	public class BaseTreeNode<T> extends DefaultMutableTreeNode {

		protected String label;
		protected ImageIcon icon;
		protected String tooltip;

		public BaseTreeNode(T model, String icon) {
			setUserObject(model);
			this.label = model.toString();
			this.icon = presentationModel.loadIcon(icon);
			this.tooltip = "";
		}

		@SuppressWarnings("unchecked")
		public T getModel() {
			return (T) getUserObject();
		}

		public String getLabel() {
			return label;
		}

		public ImageIcon getIcon() {
			return icon;
		}

		protected java.util.List<Action> getActions() {
			java.util.List<Action> actions = new ArrayList<>();
			actions.add(newAction("Expand", actionEvent -> {
				SwingUtilities.invokeLater(() -> expandTreeNodesRecursive(getThisPath(), true));
			}));
			actions.add(newAction("Collapse", actionEvent -> {
				SwingUtilities.invokeLater(() -> expandTreeNodesRecursive(getThisPath(), false));
			}));
			return actions;
		}

		@Override
		public boolean equals(Object obj) {
			if (!(obj instanceof BaseTreeNode)) return false;
			return getModel().equals(((BaseTreeNode<?>) obj).getModel());
		}

		@Override
		public int hashCode() {
			return getModel().hashCode();
		}

		@SuppressWarnings("unchecked")
		public <T> Optional<T> getParentNode(Class<T> type) {
			if (getClass().equals(type)) return (Optional<T>) Optional.of(this);

			final TreeNode parent = getParent();
			if (!(parent instanceof BaseTreeNode)) return Optional.empty();

			return ((BaseTreeNode<?>) parent).getParentNode(type);
		}

		public String getTooltip() {
			return tooltip;
		}

		public void nodeChanged() {
			treeModel.nodeChanged(this);
		}

		protected TreePath addChild(BaseTreeNode<?> child) {
			add(child);
			final TreePath path = new TreePath(child.getPath());
			treeModel.nodesWereInserted(BaseTreeNode.this, new int[]{getIndex(child)});
			return path;
		}

		protected void addAndSelectChild(BaseTreeNode<?> child) {
			final TreePath path = addChild(child);
			tree.scrollPathToVisible(path);
			tree.setSelectionPath(path);
		}

		protected <T> java.util.stream.Stream<T> getChildren(Class<T> type) {
			final java.util.Set<T> set = new java.util.LinkedHashSet<>();
			final int childCount = getChildCount();
			for (int i = 0; i < childCount; i++) {
				if (getChildAt(i).getClass().isAssignableFrom(type))
					set.add((T) getChildAt(i));
			}

			return set.stream();
		}

		protected TreePath getThisPath() {
			return new TreePath(getPath());
		}

		protected void expandTreeNodesRecursive(TreePath parent, boolean expand) {
			TreeModel model = tree.getModel();

			Object node = parent.getLastPathComponent();
			int childCount = model.getChildCount(node);
			for (int j = 0; j < childCount; j++) 
				expandTreeNodesRecursive(parent.pathByAddingChild(model.getChild(node, j)), expand);

			if (expand) 
				tree.expandPath(parent);
			else 
				tree.collapsePath(parent);
		}
	}

	// RootNode
	public class RootNode extends BaseTreeNode<String> {

		RootNode(String model) {
			super(model, "RootNode");

			this.label = getModel();
			this.tooltip = "";

			add(new STGDirectoryTreeNode(presentationModel.generatorSTGDirectory));
			presentationModel.stgDirectories.forEach(stgDirectory -> add(new STGDirectoryTreeNode(stgDirectory)));
		}

		@Override
		public void nodeChanged() {
			this.label = getModel();
			this.tooltip = "";
			super.nodeChanged();
		}

		@Override
		protected List<Action> getActions() {
			final List<Action> actions = super.getActions();
			return actions;
		}

	}

	// STGDirectoryTreeNode
	public class STGDirectoryTreeNode extends BaseTreeNode<nextgen.st.domain.STGDirectory> {

		private String uuid;

		STGDirectoryTreeNode(nextgen.st.domain.STGDirectory model) {
			super(model, "STGDirectory");

			this.label = getModel().getPath();
			this.tooltip = "";
			this.uuid = model.getUuid();

			model.getGroups()
				.sorted((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName()))
				.forEach(stGroupModel -> add(new STGroupTreeNode(stGroupModel)));
		}

		@Override
		public void nodeChanged() {
			this.label = getModel().getPath();
			this.tooltip = "";
			super.nodeChanged();
		}

		@Override
		protected List<Action> getActions() {
			final List<Action> actions = super.getActions();
			actions.add(newAction("New STGroup", actionEvent -> {
				SwingUtil.getInputFromUser(tree, "Name").ifPresent(name -> {

					final Optional<nextgen.st.domain.STGroupModel> existing = getModel().getGroups().filter(groupModel -> groupModel.getName().toLowerCase().equals(name)).findAny();
					if (existing.isPresent()) {
						SwingUtil.showMessage(name + " group already exists in this directory", tree);
						return;
					}

					if (!javax.lang.model.SourceVersion.isIdentifier(name)) {
						SwingUtil.showMessage(name + " is a reserved java keyword", tree);
						return;
					}

					final nextgen.st.domain.STGroupModel stGroupModel = presentationModel.newSTGroupModel(name);
					getModel().addGroups(stGroupModel);

					SwingUtilities.invokeLater(() -> {
						final STGroupTreeNode stGroupTreeNode = new STGroupTreeNode(stGroupModel);
						stGroupTreeNode.save();
						addAndSelectChild(stGroupTreeNode);
						workspace.getSTEditor(stGroupTreeNode.getModel());
					});
				});
			}));
			actions.add(newAction("Generate All", actionEvent -> {
				SwingUtilities.invokeLater(() -> getChildren(STGroupTreeNode.class).forEach(stGroupTreeNode -> presentationModel.generateSTGroup(stGroupTreeNode.getModel())));
			}));
			actions.add(newAction("Expand", actionEvent -> {
				SwingUtilities.invokeLater(() -> expandTreeNodesRecursive(getThisPath(), true));
			}));
			actions.add(newAction("Collapse", actionEvent -> {
				SwingUtilities.invokeLater(() -> expandTreeNodesRecursive(getThisPath(), false));
			}));
			return actions;
		}

		public void save(nextgen.st.domain.STGroupModel model) {
			final java.io.File dir = new java.io.File(getModel().getPath());
			STGenerator.write(new java.io.File(dir, model.getName() + ".json"), model.getJsonObject().encodePrettily());
		}
	}

	// STGroupTreeNode
	public class STGroupTreeNode extends BaseTreeNode<nextgen.st.domain.STGroupModel> {

		private String uuid;

		STGroupTreeNode(nextgen.st.domain.STGroupModel model) {
			super(model, model.getIcon());

			this.label = getModel().getName();
			this.tooltip = "";
			this.uuid = model.getUuid();

			model.getEnums().sorted((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName())).forEach(stEnum -> add(new STEnumTreeNode(stEnum)));
			model.getTemplates().sorted((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName())).forEach(stTemplate -> add(new STTemplateTreeNode(stTemplate)));
			model.getInterfaces().sorted((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName())).forEach(stInterface -> add(new STInterfaceTreeNode(stInterface)));
		}

		@Override
		public void nodeChanged() {
			this.label = getModel().getName();
			this.tooltip = "";
			super.nodeChanged();
		}

		@Override
		protected List<Action> getActions() {
			final List<Action> actions = super.getActions();
			actions.add(newAction("Generate", actionEvent -> {
				presentationModel.generateSTGroup(getModel());
			}));
			actions.add(newAction("New template", actionEvent -> {
				SwingUtil.getInputFromUser(tree, "Name").ifPresent(name ->
						STAppPresentationModel.isValidTemplateName(tree, getModel(), name).ifPresent(s -> {

							final STTemplate stTemplate = presentationModel.newSTTemplate(name);
							getModel().addTemplates(stTemplate);
							save();

							SwingUtilities.invokeLater(() -> {
								addAndSelectChild(new STTemplateTreeNode(stTemplate));
								workspace.getSTEditor(getModel()).setSTTemplate(stTemplate);
							});
						}));
			}));
			actions.add(newAction("New enum", actionEvent -> {
				SwingUtil.getInputFromUser(tree, "Name").ifPresent(name ->
					STAppPresentationModel.isValidTemplateName(tree, getModel(), name).ifPresent(s -> {

						final STEnum stEnum = presentationModel.newSTEnum(name);
						getModel().addEnums(stEnum);
						save();

						SwingUtilities.invokeLater(() -> addAndSelectChild(new STEnumTreeNode(stEnum)));
					}));
			}));
			actions.add(newAction("New interface", actionEvent -> {
				SwingUtil.getInputFromUser(tree, "Name").ifPresent(name ->
					STAppPresentationModel.isValidTemplateName(tree, getModel(), name).ifPresent(s -> {

						final STInterface stInterface = presentationModel.newSTInterface(name);
						getModel().addInterfaces(stInterface);
						save();

						SwingUtilities.invokeLater(() -> addAndSelectChild(new STInterfaceTreeNode(stInterface)));
					}));
			}));
			actions.add(newAction("Rename", actionEvent -> {
				SwingUtil.getInputFromUser(tree, "Name").ifPresent(name ->
					getParentNode(STGDirectoryTreeNode.class)
						.ifPresent(parent -> {
					
								final Optional<STGroupModel> existing = parent.getModel()
									.getGroups()
									.filter(groupModel -> !groupModel.equals(getModel()))
									.filter(groupModel -> groupModel.getName().toLowerCase().equals(name))
									.findAny();
					
								if (existing.isPresent()) {
									SwingUtil.showMessage(name + " group already exists", tree);
									return;
								}
					
								final String oldName = getModel().getName();
								getModel().setName(name);
								save();
					
								SwingUtilities.invokeLater(() -> {
									this.label = getModel().getName();
									treeModel.nodeChanged(STGroupTreeNode.this);
									STAppPresentationModel.deleteSTGFile(parent.getModel(), oldName);
								});
					}));
			}));
			actions.add(newAction("Expand", actionEvent -> {
				SwingUtilities.invokeLater(() -> expandTreeNodesRecursive(getThisPath(), true));
			}));
			actions.add(newAction("Delete", actionEvent -> {
				SwingUtil.confirm(tree,"Delete " + getModel().getName())
					.flatMap(aBoolean -> getParentNode(STGDirectoryTreeNode.class))
					.ifPresent(parent -> SwingUtilities.invokeLater(() -> {
						treeModel.removeNodeFromParent(STGroupTreeNode.this);
						workspace.removeSTEditor(getModel());
						parent.getModel().removeGroups(getModel());
						STAppPresentationModel.deleteSTGFile(parent.getModel(), getModel().getName());
					}));
			}));
			actions.add(newAction("Set Icon name", actionEvent -> {
				SwingUtil.getInputFromUser(tree, "Icon name").ifPresent(iconName -> {

					getModel().setIcon(iconName);
					save();

					SwingUtilities.invokeLater(() -> {
							this.icon = presentationModel.loadIcon(iconName);
							treeModel.nodeChanged(STGroupTreeNode.this);
					});
				});
			}));
			actions.add(newAction("Collapse", actionEvent -> {
				SwingUtilities.invokeLater(() -> expandTreeNodesRecursive(getThisPath(), false));
			}));
			return actions;
		}

		public void save() {
			getParentNode(STGDirectoryTreeNode.class).ifPresent(stGroupTreeNode -> stGroupTreeNode.save(getModel()));
		}
	}

	// STEnumTreeNode
	public class STEnumTreeNode extends BaseTreeNode<nextgen.st.domain.STEnum> {

		private String uuid;

		STEnumTreeNode(nextgen.st.domain.STEnum model) {
			super(model, "STEnum");

			this.label = getModel().getName();
			this.tooltip = "";
			this.uuid = model.getUuid();

		}

		@Override
		public void nodeChanged() {
			this.label = getModel().getName();
			this.tooltip = "";
			super.nodeChanged();
		}

		@Override
		protected List<Action> getActions() {
			final List<Action> actions = super.getActions();
			getModel().getValues().forEach(stEnumValue -> {
				actions.add(newAction("New " + stEnumValue.getName() + " instance", actionEvent -> {
					workspace.findCanvas().ifPresent(stCanvas -> {
							SwingUtilities.invokeLater(() -> {
								presentationModel.db.doInTransaction(transaction -> stCanvas.addNode(new STValueNode(stCanvas, presentationModel.db.newSTValue(stEnumValue))));
								workspace.setSelectedComponent(stCanvas);
								stCanvas.requestFocusInWindow();
							});
					});
				}));
			});
			actions.add(newAction("Edit", actionEvent -> {
				final int newFields = 5;

				final JPanel contentPanel = new JPanel(new GridLayout((int) getModel().getValues().count() + newFields + 1, 2));
				contentPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 0, 5));
				contentPanel.add(new JLabel("Name"));
				contentPanel.add(new JLabel("Lexical"));

				// existing values:
				final Map<STEnumValue, JTextField> txtEnumValuesName = new LinkedHashMap<>();
				final Map<STEnumValue, JTextField> txtEnumLexical = new LinkedHashMap<>();
				getModel().getValues().forEach(stEnumValue -> {
					txtEnumValuesName.put(stEnumValue, SwingUtil.newTextField(stEnumValue.getName(), 10));
					txtEnumLexical.put(stEnumValue, SwingUtil.newTextField(stEnumValue.getLexical(), 10));
					contentPanel.add(txtEnumValuesName.get(stEnumValue));
					contentPanel.add(txtEnumLexical.get(stEnumValue));
				});

				// allow adding new values:
				final Map<Integer, JTextField> newTxtEnumValuesName = new LinkedHashMap<>();
				final Map<Integer, JTextField> newTxtEnumLexical = new LinkedHashMap<>();
				for (int i = 0; i < newFields; i++) {
					newTxtEnumValuesName.put(i, SwingUtil.newTextField("", 10));
					newTxtEnumLexical.put(i, SwingUtil.newTextField("", 10));

					contentPanel.add(newTxtEnumValuesName.get(i));
					contentPanel.add(newTxtEnumLexical.get(i));
				}

				final JDialog dialog = new JDialog((Frame) SwingUtilities.getAncestorOfClass(JFrame.class, tree), "Edit Enum", true);
				dialog.add(contentPanel, BorderLayout.CENTER);

				final JButton btnSave = new JButton(newAction("Save", actionEvent1 -> {

					for (STEnumValue stEnumValue : txtEnumValuesName.keySet()) {
							final String txtEnumValueName = txtEnumValuesName.get(stEnumValue).getText().trim();
							final String txtEnumValueLexical = txtEnumLexical.get(stEnumValue).getText().trim();

							stEnumValue.setName(txtEnumValueName);
							stEnumValue.setLexical(txtEnumValueLexical.length() == 0 ? null : txtEnumValueLexical);
					}

					for (int i = 0; i < newFields; i++) {
							final String newEnumValue = newTxtEnumValuesName.get(i).getText().trim();
							final String newEnumLexical = newTxtEnumLexical.get(i).getText().trim();
							if (newEnumValue.length() == 0) continue;

							getModel().addValues(STJsonFactory.newSTEnumValue()
									.setName(newEnumValue)
									.setLexical(newEnumLexical.length() == 0 ? null : newEnumLexical));
					}

					getParentNode(STGroupTreeNode.class).ifPresent(STGroupTreeNode::save);

					SwingUtilities.invokeLater(dialog::dispose);
				}));

				SwingUtil.showDialog(tree, dialog, btnSave);
			}));
			actions.add(newAction("Rename", actionEvent -> {
				SwingUtil.getInputFromUser(tree, "Name")
					.ifPresent(candidateName -> getParentNode(STGroupTreeNode.class)
					.ifPresent(stGroupTreeNode -> STAppPresentationModel.isValidTemplateName(tree, stGroupTreeNode.getModel(), candidateName)
						.ifPresent(name -> {
							getModel().setName(name);
							stGroupTreeNode.save();
							SwingUtilities.invokeLater(() -> {
									this.label = getModel().getName();
									treeModel.nodeChanged(STEnumTreeNode.this);
							});
					})));
			}));
			actions.add(newAction("Remove", actionEvent -> {
				SwingUtil.confirm(tree, "Delete " + getModel().getName())
					.flatMap(aBoolean -> getParentNode(STGroupTreeNode.class))
					.ifPresent(stGroupTreeNode -> {
						stGroupTreeNode.getModel().removeEnums(getModel());
						SwingUtilities.invokeLater(() -> treeModel.removeNodeFromParent(STEnumTreeNode.this));
					});
			}));
			return actions;
		}

	}

	// STTemplateTreeNode
	public class STTemplateTreeNode extends BaseTreeNode<nextgen.st.domain.STTemplate> {

		private String uuid;

		STTemplateTreeNode(nextgen.st.domain.STTemplate model) {
			super(model, "STTemplate");

			this.label = getModel().getName();
			this.tooltip = "";
			this.uuid = model.getUuid();

			model.getChildren().sorted((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName())).forEach(stTemplate -> add(new STTemplateTreeNode(stTemplate)));
		}

		@Override
		public void nodeChanged() {
			this.label = getModel().getName();
			this.tooltip = "";
			super.nodeChanged();
		}

		@Override
		protected List<Action> getActions() {
			final List<Action> actions = super.getActions();
			final Set<STTemplateTreeNode> candidateChildren = getSelectedNodes(STTemplateTreeNode.class).filter(stTemplateTreeNode -> !stTemplateTreeNode.equals(this)).collect(java.util.stream.Collectors.toSet());
			if (!candidateChildren.isEmpty())
				actions.add(newAction("Add " + candidateChildren.size() + " nodes as children", actionEvent -> {

					if (!SwingUtil.showConfirmDialog(tree, "Sure to move ?")) return;

					SwingUtilities.invokeLater(() -> {
						for (STTemplateTreeNode stTemplateTreeNode : candidateChildren) {

								final TreeNode parent = stTemplateTreeNode.getParent();
								if (parent instanceof STGroupTreeNode)
									((STGroupTreeNode) parent).getModel().removeTemplates(stTemplateTreeNode.getModel());
								else if (parent instanceof STTemplateTreeNode)
									((STTemplateTreeNode) parent).getModel().removeChildren(stTemplateTreeNode.getModel());
								getModel().addChildren(stTemplateTreeNode.getModel());

								treeModel.removeNodeFromParent(stTemplateTreeNode);
								treeModel.insertNodeInto(stTemplateTreeNode, STTemplateTreeNode.this, getChildCount());
						}

						getParentNode(STGroupTreeNode.class).ifPresent(STGroupTreeNode::save);
						treeModel.nodeStructureChanged(getParent());
					});
				}));
			final List<nextgen.st.domain.STTemplate> childTemplates = getModel().getChildren().collect(java.util.stream.Collectors.toList());
			if (!childTemplates.isEmpty())
				actions.add(newAction("Set interfaces on " + childTemplates.size() + " children", actionEvent -> {

					final JTextField txtImplements = new JTextField("", 15);

					final JDialog dialog = new JDialog((Frame) SwingUtilities.getAncestorOfClass(JFrame.class, tree), "Edit interfaces", true);
					final JPanel contentPanel = new JPanel(new GridLayout(1, 1));
					contentPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 0, 5));
					contentPanel.add(txtImplements);
					dialog.add(contentPanel, BorderLayout.CENTER);

					final JButton btnSave = new JButton(newAction("Save", actionEvent1 -> {

						final String interfaceName = txtImplements.getText().trim();

						childTemplates.forEach(stTemplate -> stTemplate.getImplements()
									.filter(s -> s.equalsIgnoreCase(interfaceName))
									.findAny()
									.orElseGet(() -> {
										stTemplate.addImplements(interfaceName);
										return interfaceName;
									}));

						getParentNode(STGroupTreeNode.class).ifPresent(STGroupTreeNode::save);

						SwingUtilities.invokeLater(dialog::dispose);
					}));

					nextgen.utils.SwingUtil.showDialog(tree, dialog, btnSave);
				}));
			getModel().getImplements().forEach(implement -> actions.add(newAction("Remove interface '" + implement + "'", actionEvent -> {
				getModel().removeImplements(implement);
				getParentNode(STGroupTreeNode.class).ifPresent(STGroupTreeNode::save);
			})));
			actions.add(newAction("New Instance", actionEvent -> {
				getParentNode(STGroupTreeNode.class)
					.ifPresent(stGroupTreeNode -> workspace.findCanvas()
							.ifPresent(stCanvas -> presentationModel.doLaterInTransaction(transaction -> {
									final STModelNode node = new STModelNode(stCanvas, getModel(), presentationModel.db.newSTModel(stGroupTreeNode.getModel().getUuid(), getModel()));
									stCanvas.addNode(node);
									workspace.setSelectedComponent(stCanvas);
									stCanvas.requestFocusInWindow();
									stCanvas.centerNode(node);
					})));
			}));
			actions.add(newAction("New Child-template", actionEvent -> {
				SwingUtil.getInputFromUser(tree, "Name")
					.ifPresent(candidateName -> getParentNode(STGroupTreeNode.class)
							.ifPresent(stGroupTreeNode -> STAppPresentationModel.isValidTemplateName(tree, stGroupTreeNode.getModel(), candidateName)
									.ifPresent(name -> {
										final STTemplate stTemplate = presentationModel.newSTTemplate(name);
					
										getModel().addChildren(stTemplate);
										stGroupTreeNode.save();
					
										SwingUtilities.invokeLater(() -> {
												addAndSelectChild(new STTemplateTreeNode(stTemplate));
												workspace.getSTEditor(stGroupTreeNode.getModel()).setSTTemplate(stTemplate);
										});
					})));
			}));
			actions.add(newAction("Set parameter types", actionEvent -> {
				final Map<String, JTextField> txtParameterMap = new TreeMap<>();
				getModel().getParameters().forEach(stParameter -> {

					switch (stParameter.getType()) {

						case SINGLE:
						case LIST:
							final String key = stParameter.getName();
							txtParameterMap.put(key, SwingUtil.newTextField(stParameter.getArgumentType("Object"), 15));

							break;
						case KVLIST:
							stParameter.getKeys().forEach(stParameterKey -> {
								final String kvListKey = stParameter.getName() + "." + stParameterKey.getName();
								txtParameterMap.put(kvListKey, SwingUtil.newTextField(stParameterKey.getArgumentType("Object"), 15));
							});
							break;
					}
				});

				final JDialog dialog = new JDialog((Frame) SwingUtilities.getAncestorOfClass(JFrame.class, tree), "Set Parameter types", true);
				final JPanel contentPanel = new JPanel(new GridLayout(txtParameterMap.size(), 2));
				contentPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 0, 5));
				txtParameterMap.forEach((key, value) -> {
					contentPanel.add(new JLabel(key));
					contentPanel.add(value);
				});
				dialog.add(contentPanel, BorderLayout.CENTER);

				final JButton btnSave = new JButton(newAction("Save", actionEvent1 -> {
					getModel().getParameters().forEach(stParameter -> {

						switch (stParameter.getType()) {

							case SINGLE:
							case LIST:
								final JTextField txtTypes = txtParameterMap.get(stParameter.getName());
								final String types = txtTypes.getText().trim();
								stParameter.setArgumentType(types.length() == 0 ? (stParameter.getName().startsWith("is") ? "Boolean" : "Object") : types);
								break;

							case KVLIST:
								stParameter.getKeys().forEach(stParameterKey -> {
										final JTextField txtKVTypes = txtParameterMap.get(stParameter.getName() + "." + stParameterKey.getName());
										final String kvTypes = txtKVTypes.getText().trim();
										stParameterKey.setArgumentType(kvTypes.length() == 0 ? (stParameterKey.getName().startsWith("is") ? "Boolean" : "Object") : kvTypes);
								});
								break;
						}
					});

					getParentNode(STGroupTreeNode.class).ifPresent(STGroupTreeNode::save);

					SwingUtilities.invokeLater(dialog::dispose);
				}));

				SwingUtil.showDialog(tree, dialog, btnSave);
			}));
			actions.add(newAction("Set interfaces", actionEvent -> {
				final List<JTextField> txtImplements = new ArrayList<>();
				getModel().getImplements().forEach(implement -> {
					final JTextField textField = SwingUtil.newTextField(implement, 15);
					txtImplements.add(textField);
				});
				txtImplements.add(SwingUtil.newTextField("", 15));
				txtImplements.add(SwingUtil.newTextField("", 15));

				final JDialog dialog = new JDialog((Frame) SwingUtilities.getAncestorOfClass(JFrame.class, tree), "Edit interfaces", true);
				final JPanel contentPanel = new JPanel(new GridLayout(txtImplements.size(), 1));
				contentPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 0, 5));
				for (JTextField txtImplement : txtImplements) {
					contentPanel.add(txtImplement);
				}
				dialog.add(contentPanel, BorderLayout.CENTER);

				final JButton btnSave = new JButton(newAction("Save", actionEvent1 -> {

					getModel().clearImplements();
					for (JTextField txtImplement : txtImplements) {
						final String trim = txtImplement.getText().trim();
						if (trim.length() == 0) continue;
						getModel().addImplements(trim);
					}
					getParentNode(STGroupTreeNode.class).ifPresent(STGroupTreeNode::save);

					SwingUtilities.invokeLater(dialog::dispose);
				}));

				SwingUtil.showDialog(tree, dialog, btnSave);
			}));
			actions.add(newAction("Rename", actionEvent -> {
				SwingUtil.getInputFromUser(tree, "Name")
					.ifPresent(candidateName -> getParentNode(STGroupTreeNode.class)
						.ifPresent(stGroupTreeNode -> STAppPresentationModel.isValidTemplateName(tree, stGroupTreeNode.getModel(), candidateName)
								.ifPresent(name -> {
									getModel().setName(name);
									stGroupTreeNode.save();
									SwingUtilities.invokeLater(() -> {
											this.label = getModel().getName();
											treeModel.nodeChanged(STTemplateTreeNode.this);
									});
					})));
			}));
			actions.add(newAction("Remove", actionEvent -> {
				SwingUtil.confirm(tree, "Delete " + getModel().getName())
						.ifPresent(aBoolean -> {
							if (getParent() instanceof STGroupTreeNode) {
								final STGroupTreeNode parent = (STGroupTreeNode) getParent();
								parent.getModel().removeTemplates(getModel());
							} else if (getParent() instanceof STTemplateTreeNode) {
								final STTemplateTreeNode parent = (STTemplateTreeNode) getParent();
								parent.getModel().removeChildren(getModel());
							}

							getParentNode(STGroupTreeNode.class).ifPresent(STGroupTreeNode::save);

							SwingUtilities.invokeLater(() -> {
								treeModel.removeNodeFromParent(STTemplateTreeNode.this);
								getParentNode(STGroupTreeNode.class).ifPresent(stGroupTreeNode -> workspace.getSTEditor(stGroupTreeNode.getModel()).setSTTemplate(null));
							});
						});
			}));
			return actions;
		}

	}

	// STInterfaceTreeNode
	public class STInterfaceTreeNode extends BaseTreeNode<nextgen.st.domain.STInterface> {

		private String uuid;

		STInterfaceTreeNode(nextgen.st.domain.STInterface model) {
			super(model, "STInterface");

			this.label = getModel().getName();
			this.tooltip = "";
			this.uuid = model.getUuid();

		}

		@Override
		public void nodeChanged() {
			this.label = getModel().getName();
			this.tooltip = "";
			super.nodeChanged();
		}

		@Override
		protected List<Action> getActions() {
			final List<Action> actions = super.getActions();
			actions.add(newAction("Rename", actionEvent -> {
				SwingUtil.getInputFromUser(tree, "Name")
					.ifPresent(candidateName -> getParentNode(STGroupTreeNode.class)
						.ifPresent(stGroupTreeNode -> STAppPresentationModel.isValidTemplateName(tree, stGroupTreeNode.getModel(), candidateName)
									.ifPresent(name -> {
										getModel().setName(name);
										stGroupTreeNode.save();
										SwingUtilities.invokeLater(() -> {
											this.label = getModel().getName();
											treeModel.nodeChanged(STInterfaceTreeNode.this);
										});
					})));
			}));
			actions.add(newAction("Remove", actionEvent -> {
				SwingUtil.confirm(tree, "Delete " + getModel().getName())
					.flatMap(aBoolean -> getParentNode(STGroupTreeNode.class))
					.ifPresent(stGroupTreeNode -> {
						stGroupTreeNode.getModel().removeInterfaces(getModel());
						SwingUtilities.invokeLater(() -> treeModel.removeNodeFromParent(STInterfaceTreeNode.this));
					});
			}));
			return actions;
		}

	}	

	private Action newAction(String name, Consumer<ActionEvent> actionEventConsumer) {
		return new AbstractAction(name) {
			@Override
			public void actionPerformed(ActionEvent e) {
				actionEventConsumer.accept(e);
			}
		};
	}

	private void showPopup(BaseTreeNode<?> lastPathComponent, int x, int y) {
		final List<Action> actions = lastPathComponent.getActions();
		if (actions.isEmpty()) return;

		final JPopupMenu pop = new JPopupMenu();
		pop.add("With " + presentationModel.cut(lastPathComponent.getLabel()) + " :");
		for (Action action : actions)
			pop.add(action);

		SwingUtilities.invokeLater(() -> pop.show(tree, x, y));
	}

	public <T> java.util.stream.Stream<T> getSelectedNodes(Class<T> type) {
		final TreePath[] selectionPaths = tree.getSelectionPaths();
		if (selectionPaths == null || selectionPaths.length == 0) return java.util.stream.Stream.empty();
		return Arrays.stream(selectionPaths)
				.filter(treePath -> treePath.getLastPathComponent() != null)
				.filter(treePath -> treePath.getLastPathComponent().getClass().isAssignableFrom(type))
				.map(treePath -> (T) treePath.getLastPathComponent());
	}

}