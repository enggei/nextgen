package nextgen.st;

import nextgen.utils.Neo4JUtil;
import nextgen.utils.SwingUtil;
import org.neo4j.graphdb.Direction;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;

import javax.swing.*;
import javax.swing.tree.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import java.util.List;
import java.util.*;
import java.util.function.Consumer;

public class STModelNavigator extends JPanel {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STModelNavigator.class);

	private final JTree tree = new JTree();
	private final STWorkspace workspace;
	private final STAppPresentationModel presentationModel;
	private final DefaultTreeModel treeModel;

	public STModelNavigator(STAppPresentationModel presentationModel, STWorkspace workspace) {
		super(new BorderLayout());

		this.presentationModel = presentationModel;
		this.workspace = workspace;

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

		setPreferredSize(new Dimension(300, 600));
		add(new JScrollPane(tree), BorderLayout.CENTER);
	}

	public Set<nextgen.st.model.STValue> getSelectedValues() {
		final Set<nextgen.st.model.STValue> values = new TreeSet<>((o1, o2) -> o1.getValue().compareToIgnoreCase(o2.getValue()));

		final TreePath[] selectionPaths = tree.getSelectionPaths();
		if (selectionPaths == null) return values;
		for (TreePath selectionPath : selectionPaths) {
				if (selectionPath.getLastPathComponent() instanceof STValueTreeNode) {
					final STValueTreeNode stValuesRootNode = (STValueTreeNode) selectionPath.getLastPathComponent();
					values.add(stValuesRootNode.getModel());
				}
		}
		return values;
	}

	public class BaseTreeNode<T> extends DefaultMutableTreeNode {

		protected ImageIcon icon;
		protected String tooltip;

		public BaseTreeNode(T model, String icon) {
			setUserObject(model);
			this.icon = loadIcon(icon);
			this.tooltip = "";
		}

		@SuppressWarnings("unchecked")
		public T getModel() {
			return (T) getUserObject();
		}

		public String getLabel() {
			return getUserObject().toString();
		}

		public ImageIcon getIcon() {
			return icon;
		}

		protected java.util.List<Action> getActions() {
			return new ArrayList<>();
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
	}

	// STValueTreeNode
	public class STValueTreeNode extends BaseTreeNode<nextgen.st.model.STValue> {

		private String label;
		private String uuid;

		STValueTreeNode(nextgen.st.model.STValue model) {
			super(model, null);
			this.label = model.getValue() == null || model.getValue().trim().length() == 0 ? "[EMPTY]" : model.getValue();
			this.uuid = model.getUuid();
			org.greenrobot.eventbus.EventBus.getDefault().register(this);
		}

		@Override
		public String getLabel() {
			return this.label;
		}

		@Override
		protected List<Action> getActions() {
			final List<Action> actions = super.getActions();
			actions.add(newAction("To Clipboard", actionEvent -> {
				presentationModel.db.doInTransaction(transaction -> SwingUtil.toClipboard(presentationModel.render(getModel()).trim()));
			}));
			actions.add(newAction("Set from Clipboard", actionEvent -> {
				presentationModel.db.doInTransaction(transaction -> getModel().setValue(SwingUtil.fromClipboard().trim()));
			}));
			actions.add(newAction("Open", actionEvent -> {
				workspace.findCanvas().ifPresent(stCanvas -> SwingUtilities.invokeLater(() -> presentationModel.db.doInTransaction(transaction -> {
					final nextgen.st.canvas.STValueNode node = new nextgen.st.canvas.STValueNode(stCanvas, getModel());
					stCanvas.addNode(node);

					workspace.setSelectedComponent(stCanvas);
					stCanvas.requestFocusInWindow();
					stCanvas.centerNode(node);
				})));
			}));
			actions.add(newAction("Delete", actionEvent -> {
				presentationModel.doLaterInTransaction(transaction -> presentationModel.db.remove(getModel()));
			}));
			return actions;
		}

		@org.greenrobot.eventbus.Subscribe()
		public void onRemovedSTValue(nextgen.st.STAppEvents.RemovedSTValue event) {
			presentationModel.doLaterInTransaction(transaction -> {
				if (event.uuid.equals(uuid)) treeModel.removeNodeFromParent(this);
			});
		}
	}

	// ProjectTreeNode
	public class ProjectTreeNode extends BaseTreeNode<nextgen.st.model.Project> {

		private String label;
		private String uuid;

		ProjectTreeNode(nextgen.st.model.Project model) {
			super(model, null);
			this.label = model.getName();;
			this.uuid = model.getUuid();
		}

		@Override
		public String getLabel() {
			return this.label;
		}

		@Override
		protected List<Action> getActions() {
			final List<Action> actions = super.getActions();
			return actions;
		}

	}

	// ProjectsRootNode
	public class ProjectsRootNode extends BaseTreeNode<String> {

		private String label;

		ProjectsRootNode(String model) {
			super(model, null);
			this.label = model;
			presentationModel.db.findAllProject().forEach(project -> add(new ProjectTreeNode(project)));
			org.greenrobot.eventbus.EventBus.getDefault().register(this);
		}

		@Override
		public String getLabel() {
			return this.label;
		}

		@Override
		protected List<Action> getActions() {
			final List<Action> actions = super.getActions();
			return actions;
		}

		@org.greenrobot.eventbus.Subscribe()
		public void onNewProject(nextgen.st.STAppEvents.NewProject event) {
			presentationModel.doLaterInTransaction(transaction -> 
				addAndSelectChild(new ProjectTreeNode(event.project))
			);
		}
	}

	// RootNode
	public class RootNode extends BaseTreeNode<String> {

		private String label;

		RootNode(String model) {
			super(model, null);
			this.label = model;
			presentationModel.db.doInTransaction(transaction -> {
				add(new ProjectsRootNode("Projects"));
				presentationModel.db.getGroupModels().forEach(stGroupModel -> add(new STGroupModelTreeNode(stGroupModel)));
				add(new ScriptsRootNode("Scripts"));
				add(new STValuesRootNode("Values"));
			});
		}

		@Override
		public String getLabel() {
			return this.label;
		}

		@Override
		protected List<Action> getActions() {
			final List<Action> actions = super.getActions();
			return actions;
		}

	}

	// ScriptsRootNode
	public class ScriptsRootNode extends BaseTreeNode<String> {

		private String label;

		ScriptsRootNode(String model) {
			super(model, null);
			this.label = model;
			presentationModel.db.findAllScript().forEach(script -> add(new ScriptTreeNode(script)));
			org.greenrobot.eventbus.EventBus.getDefault().register(this);
		}

		@Override
		public String getLabel() {
			return this.label;
		}

		@Override
		protected List<Action> getActions() {
			final List<Action> actions = super.getActions();
			return actions;
		}

		@org.greenrobot.eventbus.Subscribe()
		public void onNewScript(nextgen.st.STAppEvents.NewScript event) {
			presentationModel.doLaterInTransaction(transaction -> 
				addAndSelectChild(new ScriptTreeNode(event.script))
			);
		}
	}

	// ScriptTreeNode
	public class ScriptTreeNode extends BaseTreeNode<nextgen.st.model.Script> {

		private String label;
		private String uuid;

		ScriptTreeNode(nextgen.st.model.Script model) {
			super(model, null);
			this.label = model.getName();;
			this.uuid = model.getUuid();
		}

		@Override
		public String getLabel() {
			return this.label;
		}

		@Override
		protected List<Action> getActions() {
			final List<Action> actions = super.getActions();
			actions.add(newAction("Open", actionEvent -> {
				workspace.findCanvas()
					.ifPresent(stCanvas -> presentationModel.doLaterInTransaction(transaction -> {
								final nextgen.st.canvas.ScriptNode node = new nextgen.st.canvas.ScriptNode(stCanvas, getModel());
								stCanvas.addNode(node);

								workspace.setSelectedComponent(stCanvas);
								stCanvas.requestFocusInWindow();
								stCanvas.centerNode(node);
							})
					);
			}));
			actions.add(newAction("Run Script", actionEvent -> {
				presentationModel.runScript(tree, getModel());
			}));
			return actions;
		}

	}

	// STValuesRootNode
	public class STValuesRootNode extends BaseTreeNode<String> {

		private String label;

		STValuesRootNode(String model) {
			super(model, null);
			this.label = model;
			presentationModel.db.findAllSTValue()
				.filter(stValue -> stValue.getType() != null)
				.filter(stValue -> stValue.getType().equals(nextgen.st.model.STValueType.PRIMITIVE))
				.sorted((o1, o2) -> o1.getValue().compareToIgnoreCase(o2.getValue()))
				.forEach(stValue -> add(new STValueTreeNode(stValue)));
			org.greenrobot.eventbus.EventBus.getDefault().register(this);
		}

		@Override
		public String getLabel() {
			return this.label;
		}

		@Override
		protected List<Action> getActions() {
			final List<Action> actions = super.getActions();
			actions.add(newAction("Edit Values", actionEvent -> {
				SwingUtilities.invokeLater(() -> presentationModel.db.doInTransaction(transaction -> {
					final STValueGrid valueGrid = workspace.getValueGrid();
					workspace.setSelectedComponent(valueGrid);
					valueGrid.requestFocusInWindow();
				}));
			}));
			actions.add(newAction("Reconcile", actionEvent -> {
				SwingUtilities.invokeLater(() -> {

					final Set<Node> delete = new LinkedHashSet<>();

					presentationModel.db.doInTransaction(transaction -> presentationModel.db.findAllSTValue()
						.filter(stValue -> stValue.getType() != null)
						.filter(stValue -> stValue.getValue() != null)
						.filter(stValue -> stValue.getType().equals(nextgen.st.model.STValueType.PRIMITIVE))
						.forEach(stValue -> {
							presentationModel.db.findAllSTValueByValue(stValue.getValue())
								.filter(stValue1 -> !stValue1.getUuid().equals(stValue.getUuid()))
								.filter(stValue1 -> stValue1.getType() != null)
								.filter(stValue1 -> stValue1.getType().equals(nextgen.st.model.STValueType.PRIMITIVE))
								.forEach(stValue1 -> {
									log.info("\t duplicate " + stValue1.getValue());

									final Node node = stValue1.getNode();
									node.getRelationships(Direction.INCOMING).forEach(relationship -> {
										if (relationship.getType().equals(org.neo4j.graphdb.RelationshipType.withName("ref")))
											relationship.delete();

										final Node src = relationship.getOtherNode(node);
										final Relationship newRelation = src.createRelationshipTo(stValue.getNode(), relationship.getType());
										relationship.getPropertyKeys().forEach(s -> newRelation.setProperty(s, relationship.getProperty(s)));
										relationship.delete();
									});

									delete.add(node);
							});
					}));

					presentationModel.db.doInTransaction(transaction -> {
						for (Node node : delete) {
							if (node.getRelationships().iterator().hasNext()) continue;
							log.info("deleting node ");
							log.info(Neo4JUtil.toString(node));
							node.delete();
						}

						treeModel.nodeStructureChanged(STValuesRootNode.this);
					});
				});
			}));
			return actions;
		}

		@org.greenrobot.eventbus.Subscribe()
		public void onNewSTValue(nextgen.st.STAppEvents.NewSTValue event) {
			presentationModel.doLaterInTransaction(transaction -> 
				addChild(new STValueTreeNode(event.sTValue))
			);
		}
	}

	// STGroupModelTreeNode
	public class STGroupModelTreeNode extends BaseTreeNode<nextgen.st.domain.STGroupModel> {

		private String label;
		private String uuid;

		STGroupModelTreeNode(nextgen.st.domain.STGroupModel model) {
			super(model, model.getIcon());
			this.label = model.getName();
			this.uuid = model.getUuid();
			model.getTemplates().forEach(stTemplate -> add(new STTemplateTreeNode(stTemplate)));
		}

		@Override
		public String getLabel() {
			return this.label;
		}

		@Override
		protected List<Action> getActions() {
			final List<Action> actions = super.getActions();
			return actions;
		}

	}

	// STTemplateTreeNode
	public class STTemplateTreeNode extends BaseTreeNode<nextgen.st.domain.STTemplate> {

		private String label;
		private String uuid;

		STTemplateTreeNode(nextgen.st.domain.STTemplate model) {
			super(model, null);
			this.label = model.getName();
			this.uuid = model.getUuid();
			presentationModel.db.findAllSTModelByStTemplate(model.uuid()).forEach(stModel -> add(new STModelTreeNode(stModel)));
			model.getChildren().forEach(stTemplate -> add(new STTemplateTreeNode(stTemplate)));
			org.greenrobot.eventbus.EventBus.getDefault().register(this);
		}

		@Override
		public String getLabel() {
			return this.label;
		}

		@Override
		protected List<Action> getActions() {
			final List<Action> actions = super.getActions();
			actions.add(newAction("New instance", actionEvent -> {
				workspace.findCanvas().ifPresent(stCanvas -> SwingUtilities.invokeLater(() -> presentationModel.db.doInTransaction(transaction -> {
					final nextgen.st.canvas.STModelNode node = new nextgen.st.canvas.STModelNode(stCanvas, getModel(), presentationModel.db.newSTModel(getModel().uuid(), getModel()));
					stCanvas.addNode(node);
					workspace.setSelectedComponent(stCanvas);
					stCanvas.requestFocusInWindow();
					stCanvas.centerNode(node);
				})));
			}));
			actions.add(newAction("Edit Models", actionEvent -> {
				SwingUtilities.invokeLater(() -> presentationModel.db.doInTransaction(transaction -> {
					final STModelGrid stModelGrid = workspace.getModelGrid(getModel());
					workspace.setSelectedComponent(stModelGrid);
					stModelGrid.requestFocusInWindow();
				}));
			}));
			return actions;
		}

		@org.greenrobot.eventbus.Subscribe()
		public void onNewSTModel(nextgen.st.STAppEvents.NewSTModel event) {
			presentationModel.doLaterInTransaction(transaction -> {
				if (getModel().getUuid().equals(event.sTModel.getStTemplate())) 
					addAndSelectChild(new STModelTreeNode(event.sTModel));
			});
		}
	}

	// STModelTreeNode
	public class STModelTreeNode extends BaseTreeNode<nextgen.st.model.STModel> {

		private String label;
		private String uuid;

		STModelTreeNode(nextgen.st.model.STModel model) {
			super(model, "STGDirectory");
			this.label = presentationModel.tryToFindArgument(model, "name", () -> cut(tooltip));;
			this.uuid = model.getUuid();
			org.greenrobot.eventbus.EventBus.getDefault().register(this);
		}

		@Override
		public String getLabel() {
			return this.label;
		}

		@Override
		protected List<Action> getActions() {
			final List<Action> actions = super.getActions();
			actions.add(newAction("Open", actionEvent -> {
				getParentNode(STTemplateTreeNode.class)
					.ifPresent(stTemplateTreeNode -> workspace.findCanvas()
						.ifPresent(stCanvas -> SwingUtilities.invokeLater(() -> presentationModel.db.doInTransaction(transaction -> {
							final nextgen.st.canvas.STModelNode node = new nextgen.st.canvas.STModelNode(stCanvas, stTemplateTreeNode.getModel(), getModel());
							stCanvas.addNode(node);

							workspace.setSelectedComponent(stCanvas);
							stCanvas.requestFocusInWindow();
							stCanvas.centerNode(node);
						})))
				);
			}));
			actions.add(newAction("Edit", actionEvent -> {
				getParentNode(STTemplateTreeNode.class)
					.ifPresent(stTemplateTreeNode -> SwingUtilities.invokeLater(() -> presentationModel.db.doInTransaction(transaction -> {
						final STModelEditor modelEditor = workspace.getModelEditor(stTemplateTreeNode.getModel(), getModel());
						modelEditor.setModelNavigator(STModelNavigator.this);
						workspace.setSelectedComponent(modelEditor);
					})));
			}));
			actions.add(newAction("Generate", actionEvent -> {
				SwingUtilities.invokeLater(() -> {
					presentationModel.doLaterInTransaction(tx -> getModel().getFiles().forEach(stFile -> {
						if (stFile.getPath() == null) return;
						nextgen.st.STGenerator.writeToFile(presentationModel.render(getModel()), stFile.getPackageName().getValue(), stFile.getName().getValue(), stFile.getType().getValue(), new java.io.File(stFile.getPath().getValue()));
					}));
				});
			}));
			actions.add(newAction("Write To File", actionEvent -> {
				presentationModel.writeToFile(getModel());
			}));
			return actions;
		}

		@org.greenrobot.eventbus.Subscribe()
		public void onRemovedSTModel(nextgen.st.STAppEvents.RemovedSTModel event) {
			presentationModel.doLaterInTransaction(transaction -> {
				if (event.uuid.equals(uuid)) treeModel.removeNodeFromParent(this);
			});
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

	private static final Map<String, ImageIcon> cache = new LinkedHashMap<>();

	private ImageIcon loadIcon(String iconName) {

		if (iconName == null) return null;

		if (cache.containsKey(iconName)) return cache.get(iconName);

		URL resource = getClass().getClassLoader().getResource("icons/" + iconName + "16x16.png");
		if (resource == null) resource = getClass().getClassLoader().getResource("icons/STGroup16x16.png");

		cache.put(iconName, new ImageIcon(Objects.requireNonNull(resource)));
		return cache.get(iconName);
	}

	private void showPopup(BaseTreeNode<?> lastPathComponent, int x, int y) {
		final List<Action> actions = lastPathComponent.getActions();
		if (actions.isEmpty()) return;

		final JPopupMenu pop = new JPopupMenu();
		pop.add("With " + cut(lastPathComponent.getLabel()) + " :");
		for (Action action : actions)
			pop.add(action);

		SwingUtilities.invokeLater(() -> pop.show(tree, x, y));
	}

	public static String cut(String text) {
		return text.substring(0, Math.min(text.length(), 20));
	}

}