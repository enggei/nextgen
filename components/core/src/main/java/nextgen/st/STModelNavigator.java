package nextgen.st;

import nextgen.utils.SwingUtil;

import javax.swing.*;
import javax.swing.tree.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.*;
import java.util.function.Consumer;

public class STModelNavigator extends JPanel {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STModelNavigator.class);

	private final JTree tree = new JTree();
	private final STAppPresentationModel presentationModel;
	private final DefaultTreeModel treeModel;

	private STWorkspace workspace;

	public STModelNavigator(STAppPresentationModel presentationModel, STWorkspace workspace) {
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

				} else {

					final TreePath selectionPath = tree.getPathForLocation(e.getX(), e.getY());
					if (selectionPath == null) return;
					final Object lastPathComponent = selectionPath.getLastPathComponent();
					if (!(lastPathComponent instanceof BaseTreeNode<?>)) return;

					if (lastPathComponent instanceof STModelTreeNode) {
						final STModelTreeNode selectedNode = (STModelTreeNode) lastPathComponent;
						STAppEvents.postSTModelTreeNodeClicked(selectedNode.getModel());
					}
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

		org.greenrobot.eventbus.EventBus.getDefault().register(this);
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

		protected TreePath find(java.util.function.Predicate<BaseTreeNode<?>> predicate) {
			final int childCount = getChildCount();
			for (int i = 0; i < childCount; i++) {
				final BaseTreeNode<?> childAt = (BaseTreeNode<?>) getChildAt(i);
				if (predicate.test(childAt))
					return (childAt).getThisPath();
				else {
					final TreePath treePath = childAt.find(predicate);
					if (treePath != null) return treePath;
				}
			}
			return null;
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

	// STValueTreeNode
	public class STValueTreeNode extends BaseTreeNode<nextgen.st.model.STValue> {

		private String uuid;

		STValueTreeNode(nextgen.st.model.STValue model) {
			super(model, null);

			this.label = getModel().getValue() == null || getModel().getValue().trim().length() == 0 ? "[EMPTY]" : getModel().getValue();
			this.tooltip = presentationModel.cut(presentationModel.render(getModel()), 300);
			this.uuid = model.getUuid();

			org.greenrobot.eventbus.EventBus.getDefault().register(this);
		}

		@Override
		public void nodeChanged() {
			this.label = getModel().getValue() == null || getModel().getValue().trim().length() == 0 ? "[EMPTY]" : getModel().getValue();
			this.tooltip = presentationModel.cut(presentationModel.render(getModel()), 300);
			super.nodeChanged();
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
				workspace.findCanvas().ifPresent(stCanvas -> SwingUtilities.invokeLater(() -> presentationModel.db.doInTransaction(transaction -> STAppEvents.postOpenSTValue(getModel()))));
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

		private String uuid;

		ProjectTreeNode(nextgen.st.model.Project model) {
			super(model, null);

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
			return actions;
		}

	}

	// ProjectsRootNode
	public class ProjectsRootNode extends BaseTreeNode<String> {

		ProjectsRootNode(String model) {
			super(model, null);

			this.label = getModel();
			this.tooltip = "";

			presentationModel.db.findAllProject().forEach(project -> add(new ProjectTreeNode(project)));
			org.greenrobot.eventbus.EventBus.getDefault().register(this);
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

		@org.greenrobot.eventbus.Subscribe()
		public void onNewProject(nextgen.st.STAppEvents.NewProject event) {
			presentationModel.doLaterInTransaction(transaction -> 
				addAndSelectChild(new ProjectTreeNode(event.project))
			);
		}
	}

	// RootNode
	public class RootNode extends BaseTreeNode<String> {

		RootNode(String model) {
			super(model, null);

			this.label = getModel();
			this.tooltip = "";

			presentationModel.db.doInTransaction(transaction -> {
				add(new DomainsTreeNode("Domains"));
				add(new ProjectsRootNode("Projects"));
				presentationModel.db.getGroupModels().forEach(stGroupModel -> add(new STGroupModelTreeNode(stGroupModel)));
				add(new ScriptsRootNode("Scripts"));
				add(new STValuesRootNode("Values"));
			});
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

	// ScriptsRootNode
	public class ScriptsRootNode extends BaseTreeNode<String> {

		ScriptsRootNode(String model) {
			super(model, null);

			this.label = getModel();
			this.tooltip = "";

			presentationModel.db.findAllScript().forEach(script -> add(new ScriptTreeNode(script)));
			org.greenrobot.eventbus.EventBus.getDefault().register(this);
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

		@org.greenrobot.eventbus.Subscribe()
		public void onNewScript(nextgen.st.STAppEvents.NewScript event) {
			presentationModel.doLaterInTransaction(transaction -> 
				addAndSelectChild(new ScriptTreeNode(event.script))
			);
		}
	}

	// ScriptTreeNode
	public class ScriptTreeNode extends BaseTreeNode<nextgen.st.model.Script> {

		private String uuid;

		ScriptTreeNode(nextgen.st.model.Script model) {
			super(model, null);

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
			actions.add(newAction("Open", actionEvent -> {
				workspace.findCanvas().ifPresent(stCanvas -> presentationModel.doLaterInTransaction(transaction -> STAppEvents.postOpenScript(getModel())));
			}));
			actions.add(newAction("Run Script", actionEvent -> {
				presentationModel.runScript(tree, getModel());
			}));
			return actions;
		}

	}

	// STValuesRootNode
	public class STValuesRootNode extends BaseTreeNode<String> {

		STValuesRootNode(String model) {
			super(model, null);

			this.label = getModel();
			this.tooltip = "";

			presentationModel.db.findAllSTValue()
				.filter(stValue -> stValue.getType() != null)
				.filter(stValue -> stValue.getType().equals(nextgen.st.model.STValueType.PRIMITIVE))
				.sorted((o1, o2) -> o1.getValue().compareToIgnoreCase(o2.getValue()))
				.forEach(stValue -> add(new STValueTreeNode(stValue)));
			org.greenrobot.eventbus.EventBus.getDefault().register(this);
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
			actions.add(newAction("Edit Values", actionEvent -> {
				presentationModel.doLaterInTransaction(transaction -> {
					final STValueGrid valueGrid = workspace.getValueGrid();
					workspace.setSelectedComponent(valueGrid);
					valueGrid.requestFocusInWindow();
				});
			}));
			actions.add(newAction("Reconcile", actionEvent -> {
				presentationModel.doLaterInTransaction(transaction -> {
					presentationModel.reconcileValues();
					nodeChanged();
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

		private String uuid;

		STGroupModelTreeNode(nextgen.st.domain.STGroupModel model) {
			super(model, model.getIcon());

			this.label = getModel().getName();
			this.tooltip = "";
			this.uuid = model.getUuid();

			model.getTemplates().forEach(stTemplate -> add(new STTemplateTreeNode(stTemplate)));
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
			return actions;
		}

	}

	// STTemplateTreeNode
	public class STTemplateTreeNode extends BaseTreeNode<nextgen.st.domain.STTemplate> {

		private String uuid;

		STTemplateTreeNode(nextgen.st.domain.STTemplate model) {
			super(model, null);

			this.label = getModel().getName();
			this.tooltip = "";
			this.uuid = model.getUuid();

			presentationModel.db.findAllSTModelByStTemplate(model.uuid()).forEach(stModel -> add(new STModelTreeNode(stModel)));
			model.getChildren().forEach(stTemplate -> add(new STTemplateTreeNode(stTemplate)));
			org.greenrobot.eventbus.EventBus.getDefault().register(this);
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
			actions.add(newAction("New instance", actionEvent -> {
				workspace.findCanvas().ifPresent(stCanvas -> presentationModel.doLaterInTransaction(transaction -> {
					presentationModel.db.newSTModel(getModel().getUuid(), getModel());
				}));
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

		private String uuid;

		STModelTreeNode(nextgen.st.model.STModel model) {
			super(model, "STGDirectory");

			this.label = presentationModel.tryToFindArgument(getModel(), "name", () -> getModel().getUuid());
			this.tooltip = presentationModel.cut(presentationModel.render(getModel()), 100);
			this.uuid = model.getUuid();

			org.greenrobot.eventbus.EventBus.getDefault().register(this);
		}

		@Override
		public void nodeChanged() {
			this.label = presentationModel.tryToFindArgument(getModel(), "name", () -> getModel().getUuid());
			this.tooltip = presentationModel.cut(presentationModel.render(getModel()), 100);
			super.nodeChanged();
		}

		@Override
		protected List<Action> getActions() {
			final List<Action> actions = super.getActions();
			actions.add(newAction("Open", actionEvent -> {
				getParentNode(STTemplateTreeNode.class)
					.ifPresent(stTemplateTreeNode -> workspace.findCanvas()
						.ifPresent(stCanvas -> presentationModel.doLaterInTransaction(transaction -> STAppEvents.postOpenSTModel(getModel()))));
			}));
			actions.add(newAction("Edit", actionEvent -> {
				getParentNode(STTemplateTreeNode.class)
					.ifPresent(stTemplateTreeNode -> SwingUtilities.invokeLater(() -> presentationModel.db.doInTransaction(transaction -> {
						final STModelEditor modelEditor = workspace.getModelEditor(stTemplateTreeNode.getModel(), getModel());
						//modelEditor.setModelNavigator(STModelNavigator.this);
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

	// DomainsTreeNode
	public class DomainsTreeNode extends BaseTreeNode<String> {

		DomainsTreeNode(String model) {
			super(model, null);

			this.label = model.toString();
			this.tooltip = "";

			presentationModel.metaDb.findAllMetaDomain().forEach(metaDomain -> add(new MetaDomainTreeNode(metaDomain)));
		}

		@Override
		public void nodeChanged() {
			this.label = getModel().toString();
			this.tooltip = "";
			super.nodeChanged();
		}

		@Override
		protected List<Action> getActions() {
			final List<Action> actions = super.getActions();
			return actions;
		}

	}

	// MetaDomainTreeNode
	public class MetaDomainTreeNode extends BaseTreeNode<nextgen.domains.meta.MetaDomain> {

		MetaDomainTreeNode(nextgen.domains.meta.MetaDomain model) {
			super(model, null);

			this.label = getModel().getName();
			this.tooltip = "";

			getModel().getRoots().forEach(metaEntity -> add(new MetaEntityTreeNode(metaEntity)));
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
			actions.add(newAction("Open", actionEvent -> {
				workspace.findCanvas()
						.ifPresent(stCanvas -> presentationModel.doLaterInTransaction(transaction -> STAppEvents.postOpenMetaDomain(getModel())));
			}));
			return actions;
		}

	}

	// MetaEntityTreeNode
	public class MetaEntityTreeNode extends BaseTreeNode<nextgen.domains.meta.MetaEntity> {

		MetaEntityTreeNode(nextgen.domains.meta.MetaEntity model) {
			super(model, null);

			this.label = getModel().getName();
			this.tooltip = "";

			getModel().getProperties().forEach(metaProperty -> add(new MetaPropertyTreeNode(metaProperty)));
			getModel().getRelations().forEach(metaRelation -> add(new MetaRelationTreeNode(metaRelation)));

			getModel().getNode().getRelationships(org.neo4j.graphdb.Direction.INCOMING, org.neo4j.graphdb.RelationshipType.withName("_meta")).forEach(relationship -> {
				add(new DomainEntityTreeNode(new nextgen.domains.meta.DomainEntity(relationship.getStartNode())));
			});
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
			return actions;
		}

	}

	// MetaRelationTreeNode
	public class MetaRelationTreeNode extends BaseTreeNode<nextgen.domains.meta.MetaRelation> {

		MetaRelationTreeNode(nextgen.domains.meta.MetaRelation model) {
			super(model, null);

			this.label = getModel().getName();
			this.tooltip = "";

			getModel().getProperties().forEach(metaProperty -> add(new MetaPropertyTreeNode(metaProperty)));
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
			return actions;
		}

	}

	// DomainEntityTreeNode
	public class DomainEntityTreeNode extends BaseTreeNode<nextgen.domains.meta.DomainEntity> {

		DomainEntityTreeNode(nextgen.domains.meta.DomainEntity model) {
			super(model, null);

			this.label = model.toString();
			this.tooltip = "";

		}

		@Override
		public void nodeChanged() {
			this.label = getModel().toString();
			this.tooltip = "";
			super.nodeChanged();
		}

		@Override
		protected List<Action> getActions() {
			final List<Action> actions = super.getActions();
			return actions;
		}

	}

	// MetaPropertyTreeNode
	public class MetaPropertyTreeNode extends BaseTreeNode<nextgen.domains.meta.MetaProperty> {

		MetaPropertyTreeNode(nextgen.domains.meta.MetaProperty model) {
			super(model, null);

			this.label = getModel().getName();
			this.tooltip = "";

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

	@org.greenrobot.eventbus.Subscribe()
	public void onSTModelTreeNodeClicked(nextgen.st.STAppEvents.CanvasSTModelClicked event) {
		SwingUtilities.invokeLater(() -> {
			final RootNode rootNode = (RootNode) treeModel.getRoot();
			final TreePath path = rootNode.find(baseTreeNode -> (baseTreeNode instanceof STModelTreeNode) && ((STModelTreeNode) baseTreeNode).getModel().equals(event.stModel));
			if (path != null) {
				tree.scrollPathToVisible(path);
				tree.setSelectionPath(path);
			}
		});
	}
}