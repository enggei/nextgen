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
	private final STModelNavigatorTreeModel treeModel;

	private STWorkspace workspace;

	public STModelNavigator(STWorkspace workspace) {
		super(new BorderLayout());

		this.workspace = workspace;

		treeModel = new STModelNavigatorTreeModel(new RootNode("Projects"));
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

					if (isSTModelTreeNode(lastPathComponent)) {
						final STModelTreeNode selectedNode = (STModelTreeNode) lastPathComponent;
						appModel().doLaterInTransaction(transaction -> nextgen.events.STModelTreeNodeClicked.post(selectedNode.getModel()));
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

		setPreferredSize(new Dimension(600, 1200));
		add(new JScrollPane(tree), BorderLayout.CENTER);

		org.greenrobot.eventbus.EventBus.getDefault().register(this);
	}

	public class BaseTreeNode<T> extends DefaultMutableTreeNode {

		protected String label;
		protected ImageIcon icon;
		protected String tooltip;

		public BaseTreeNode(T model, ImageIcon icon) {
			setUserObject(model);
			setLabel(model.toString());
			this.icon = icon;
			this.tooltip = "";
		}

		@SuppressWarnings("unchecked")
		public T getModel() {
			return (T) getUserObject();
		}

		protected void setLabel(String label) {
			this.label = label;
			if (this.label == null || this.label.trim().length() == 0) this.label = "[EMPTY]";
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

	// STProjectTreeNode
	public class STProjectTreeNode extends BaseTreeNode<nextgen.st.model.STProject> {

		STProjectTreeNode(nextgen.st.model.STProject model) {
			super(model, appModel().loadIcon("sq-white"));

			setLabel(getModel().getName());
			this.tooltip = getModel().getName();

			final Map<nextgen.st.domain.STGroupModel, STModelNavigator.STGroupModelTreeNode> stGroupTreeNodeMap = new java.util.LinkedHashMap<>();
			final Map<nextgen.st.domain.STTemplate, STModelNavigator.STTemplateTreeNode> stTemplateTreeNodeMap = new java.util.LinkedHashMap<>();
			model.getModelsSorted().forEach(stModel -> {

				final nextgen.st.domain.STTemplate stTemplate = appModel().findSTTemplateByUuid(stModel.getStTemplate());
				final nextgen.st.domain.STGroupModel stGroup = appModel().findSTGroup(stTemplate);

				if (!stGroupTreeNodeMap.containsKey(stGroup)) {
					final nextgen.st.STModelNavigator.STGroupModelTreeNode stGroupModelTreeNode = new nextgen.st.STModelNavigator.STGroupModelTreeNode(stGroup);
					add(stGroupModelTreeNode);
					stGroupTreeNodeMap.put(stGroup, stGroupModelTreeNode);
				}

				if (!stTemplateTreeNodeMap.containsKey(stTemplate)) {
					final STModelNavigator.STTemplateTreeNode stTemplateTreeNode = new nextgen.st.STModelNavigator.STTemplateTreeNode(stTemplate);
					stGroupTreeNodeMap.get(stGroup).add(stTemplateTreeNode);
					stTemplateTreeNodeMap.put(stTemplate, stTemplateTreeNode);
				}

				stTemplateTreeNodeMap.get(stTemplate).add(new nextgen.st.STModelNavigator.STModelTreeNode(stModel, stTemplate, null));
			});
		}

		STProjectTreeNode thisNode() {
			return this;
		}

		@Override
		public void nodeChanged() {
			setLabel(getModel().getName());
			this.tooltip = getModel().getName();
			super.nodeChanged();
		}

		@Override
		protected List<Action> getActions() {
			final List<Action> actions = super.getActions();
			getSelectedNodes()
					.filter(STModelNavigator.this::isSTModelTreeNode)
					.map(treeNode -> (STModelTreeNode) treeNode)
					.forEach(stModelTreeNode -> actions.add(newTransactionAction("Add " + stModelTreeNode.getLabel(), actionEvent -> {
						getModel().addModels(stModelTreeNode.getModel());
						treeModel.addNodeInSortedOrder(thisNode(), new nextgen.st.STModelNavigator.STModelTreeNode(stModelTreeNode.getModel(), appModel().findSTTemplateByUuid(stModelTreeNode.getModel().getStTemplate()), null));
					})));
			actions.add(newTransactionAction("Generate All", actionEvent -> {
				getChildren(STModelTreeNode.class).forEach(stModelTreeNode -> appModel().writeToFile(stModelTreeNode.getModel()));
			}));
			return actions;
		}

	}

	private boolean isSTProjectTreeNode(Object treeNode) {
		return treeNode instanceof STProjectTreeNode;
	}

	// ModelsTreeNode
	public class ModelsTreeNode extends BaseTreeNode<String> {

		ModelsTreeNode(String model) {
			super(model, appModel().loadIcon("sq-teal"));

			setLabel(model.toString());
			this.tooltip = "";

			appModel().doInTransaction(transaction -> {
				appModel().getGroupModels().forEach(stGroupModel -> {
					final nextgen.st.STModelNavigator.STGroupModelTreeNode stGroupModelTreeNode = new nextgen.st.STModelNavigator.STGroupModelTreeNode(stGroupModel);
					add(stGroupModelTreeNode);
					stGroupModel.getTemplates().forEach(stTemplate -> addSTTemplateChild(stTemplate, stGroupModelTreeNode));
				});
			});
		}

		ModelsTreeNode thisNode() {
			return this;
		}

		@Override
		public void nodeChanged() {
			setLabel(getModel().toString());
			this.tooltip = "";
			super.nodeChanged();
		}

		@Override
		protected List<Action> getActions() {
			final List<Action> actions = super.getActions();
			return actions;
		}

		private void addSTTemplateChild(nextgen.st.domain.STTemplate stTemplate, BaseTreeNode<?> parent) {
			final nextgen.st.STModelNavigator.STTemplateTreeNode stTemplateTreeNode = new nextgen.st.STModelNavigator.STTemplateTreeNode(stTemplate);
			parent.add(stTemplateTreeNode);

			appModel().db.findAllSTModelByStTemplate(stTemplate.getUuid()).forEach(stModel -> stTemplateTreeNode.add(new STModelTreeNode(stModel, stTemplate, null)));
			stTemplate.getChildren().forEach(stTemplateChild -> addSTTemplateChild(stTemplateChild, stTemplateTreeNode));
		}
	}

	private boolean isModelsTreeNode(Object treeNode) {
		return treeNode instanceof ModelsTreeNode;
	}

	// STValueTreeNode
	public class STValueTreeNode extends BaseTreeNode<nextgen.st.model.STValue> {

		private String uuid;
		private nextgen.st.model.STArgument stArgument;

		STValueTreeNode(nextgen.st.model.STValue model, nextgen.st.model.STArgument stArgument) {
			super(model, appModel().loadIcon("sq-orange"));

			this.stArgument = stArgument;
			setLabel(getModel().getValue() == null || getModel().getValue().trim().length() == 0 ? "[EMPTY]" : getModel().getValue());
			this.tooltip = appModel().tooltip(getModel());
			this.uuid = model.getUuid();

		}

		STValueTreeNode thisNode() {
			return this;
		}

		@Override
		public void nodeChanged() {
			setLabel(getModel().getValue() == null || getModel().getValue().trim().length() == 0 ? "[EMPTY]" : getModel().getValue());
			this.tooltip = appModel().tooltip(getModel());
			super.nodeChanged();
		}

		@Override
		protected List<Action> getActions() {
			final List<Action> actions = super.getActions();
			actions.add(newTransactionAction("To Clipboard", actionEvent -> {
				appModel().renderToClipboard(getModel());
			}));
			actions.add(newTransactionAction("Set from Clipboard", actionEvent -> {
				getModel().setValue(SwingUtil.fromClipboard().trim());
			}));
			actions.add(newTransactionAction("Open", actionEvent -> {
				nextgen.events.OpenSTValue.post(getModel());
			}));
			actions.add(newTransactionAction("Delete", actionEvent -> {
				appModel().remove(getModel());
			}));
			return actions;
		}

	}

	private boolean isSTValueTreeNode(Object treeNode) {
		return treeNode instanceof STValueTreeNode;
	}

	// RootNode
	public class RootNode extends BaseTreeNode<String> {

		RootNode(String model) {
			super(model, null);

			setLabel(getModel());
			this.tooltip = "";

			appModel().doInTransaction(transaction -> {
				appModel().getProjects().forEach(stProject -> add(new STProjectTreeNode(stProject)));
				add(new nextgen.st.STModelNavigator.ModelsTreeNode("Models"));
			});
		}

		RootNode thisNode() {
			return this;
		}

		@Override
		public void nodeChanged() {
			setLabel(getModel());
			this.tooltip = "";
			super.nodeChanged();
		}

		@Override
		protected List<Action> getActions() {
			final List<Action> actions = super.getActions();
			actions.add(newAction("New Project", actionEvent -> {
				SwingUtil.getInputFromUser(tree, "Name").ifPresent(name -> appModel().doLaterInTransaction(t -> appModel().newSTProject(name)));
			}));
			actions.add(newAction("Undo", actionEvent -> {
				appModel().undoLast();
			}));
			return actions;
		}

	}

	private boolean isRootNode(Object treeNode) {
		return treeNode instanceof RootNode;
	}

	// STGroupModelTreeNode
	public class STGroupModelTreeNode extends BaseTreeNode<nextgen.st.domain.STGroupModel> {

		private String uuid;

		STGroupModelTreeNode(nextgen.st.domain.STGroupModel model) {
			super(model, appModel().loadIcon(model.getIcon()));

			setLabel(getModel().getName());
			this.tooltip = "";
			this.uuid = model.getUuid();

		}

		STGroupModelTreeNode thisNode() {
			return this;
		}

		@Override
		public void nodeChanged() {
			setLabel(getModel().getName());
			this.tooltip = "";
			super.nodeChanged();
		}

		@Override
		protected List<Action> getActions() {
			final List<Action> actions = super.getActions();
			return actions;
		}

		private boolean countChildren(nextgen.st.domain.STTemplate stTemplate) {
			long count = appModel().findAllSTModelByStTemplate(stTemplate.getUuid()).count();
			if (count != 0L) return true;
			Iterator<nextgen.st.domain.STTemplate> iterator = stTemplate.getChildren().iterator();
			while (iterator.hasNext())
				if (countChildren(iterator.next())) return true;
			return false;
		}
	}

	private boolean isSTGroupModelTreeNode(Object treeNode) {
		return treeNode instanceof STGroupModelTreeNode;
	}

	// STTemplateTreeNode
	public class STTemplateTreeNode extends BaseTreeNode<nextgen.st.domain.STTemplate> {

		private String uuid;

		STTemplateTreeNode(nextgen.st.domain.STTemplate model) {
			super(model, null);

			setLabel(getModel().getName());
			this.tooltip = "";
			this.uuid = model.getUuid();

		}

		STTemplateTreeNode thisNode() {
			return this;
		}

		@Override
		public void nodeChanged() {
			setLabel(getModel().getName());
			this.tooltip = "";
			super.nodeChanged();
		}

		@Override
		protected List<Action> getActions() {
			final List<Action> actions = super.getActions();
			actions.add(newTransactionAction("New instance", actionEvent -> {
				appModel().newSTModel(getModel().getUuid(), getModel());
			}));
			actions.add(newTransactionAction("Edit Models", actionEvent -> {
				final STModelGrid stModelGrid = workspace.getModelGrid(getModel());
				workspace.setSelectedComponent(stModelGrid);
				stModelGrid.requestFocusInWindow();
			}));
			return actions;
		}

	}

	private boolean isSTTemplateTreeNode(Object treeNode) {
		return treeNode instanceof STTemplateTreeNode;
	}

	// STModelTreeNode
	public class STModelTreeNode extends BaseTreeNode<nextgen.st.model.STModel> {

		private String uuid;
		private nextgen.st.domain.STTemplate stTemplate;
		private nextgen.st.model.STArgument stArgument;

		STModelTreeNode(nextgen.st.model.STModel model, nextgen.st.domain.STTemplate stTemplate, nextgen.st.model.STArgument stArgument) {
			super(model, appModel().loadIcon("sq-teal"));

			this.stTemplate = stTemplate;
			this.stArgument = stArgument;
			setLabel(appModel().tryToFindArgument(getModel(), "name", () -> appModel().render(getModel(), 10)));
			this.tooltip = appModel().tooltip(getModel());
			this.uuid = model.getUuid();

			stTemplate.getParameters()
					.sorted((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName()))
					.forEach(stParameter -> add(new STParameterTreeNode(stParameter, model)));
		}

		STModelTreeNode thisNode() {
			return this;
		}

		@Override
		public void nodeChanged() {
			setLabel(appModel().tryToFindArgument(getModel(), "name", () -> appModel().render(getModel(), 10)));
			this.tooltip = appModel().tooltip(getModel());
			super.nodeChanged();
		}

		@Override
		protected List<Action> getActions() {
			final List<Action> actions = super.getActions();
			actions.add(newTransactionAction("Open", actionEvent -> {
				nextgen.events.OpenSTModel.post(getModel());
			}));
			actions.add(newAction("As STRenderer", actionEvent -> {
				appModel().generateSource(getModel());
			}));
			actions.add(newAction("Write To File", actionEvent -> {
				appModel().writeToFile(getModel());
			}));
			actions.add(newAction("Delete", actionEvent -> {
				SwingUtil.confirm(tree, "Delete ?").ifPresent(aBoolean -> appModel().doLaterInTransaction(transaction -> appModel().db.remove(getModel())));
			}));
			return actions;
		}

	}

	private boolean isSTModelTreeNode(Object treeNode) {
		return treeNode instanceof STModelTreeNode;
	}

	// STParameterTreeNode
	public class STParameterTreeNode extends BaseTreeNode<nextgen.st.domain.STParameter> {
		private nextgen.st.model.STModel stModel;

		STParameterTreeNode(nextgen.st.domain.STParameter model, nextgen.st.model.STModel stModel) {
			super(model, null);

			this.stModel = stModel;
			setLabel(getModel().getName());
			this.tooltip = "";

			stModel.getArgumentsSorted()
				.filter(stArgument -> stArgument.getStParameter().equals(model.getUuid()))
				.forEach(appModel().stArgumentConsumer(model)
						.onSingleSTValue((stArgument, stValue) -> add(new STValueTreeNode(stValue, stArgument)))
						.onSingleSTModel((stArgument, stValue) -> add(new STModelTreeNode(stValue.getStModel(), appModel().findSTTemplateByUuid(stValue.getStModel().getStTemplate()), stArgument)))
						.onListSTValue((stArgument, stValue) -> add(new STValueTreeNode(stValue, stArgument)))
						.onListSTModel((stArgument, stValue) -> add(new STModelTreeNode(stValue.getStModel(), appModel().findSTTemplateByUuid(stValue.getStModel().getStTemplate()), stArgument)))
						.onKVListConsumer((stArgument, stKVValues) -> add(new STKVArgumentTreeNode(stArgument, model))));
		}

		STParameterTreeNode thisNode() {
			return this;
		}

		@Override
		public void nodeChanged() {
			setLabel(getModel().getName());
			this.tooltip = "";
			super.nodeChanged();
		}

		@Override
		protected List<Action> getActions() {
			final List<Action> actions = super.getActions();
			return actions;
		}

	}

	private boolean isSTParameterTreeNode(Object treeNode) {
		return treeNode instanceof STParameterTreeNode;
	}

	// STKVArgumentTreeNode
	public class STKVArgumentTreeNode extends BaseTreeNode<nextgen.st.model.STArgument> {
		private nextgen.st.domain.STParameter stParameter;

		STKVArgumentTreeNode(nextgen.st.model.STArgument model, nextgen.st.domain.STParameter stParameter) {
			super(model, null);

			this.stParameter = stParameter;
			setLabel(model.toString());
			this.tooltip = "";

		}

		STKVArgumentTreeNode thisNode() {
			return this;
		}

		@Override
		public void nodeChanged() {
			setLabel(getModel().toString());
			this.tooltip = "";
			super.nodeChanged();
		}

		@Override
		protected List<Action> getActions() {
			final List<Action> actions = super.getActions();
			return actions;
		}

	}

	private boolean isSTKVArgumentTreeNode(Object treeNode) {
		return treeNode instanceof STKVArgumentTreeNode;
	}	

	private Action newAction(String name, Consumer<ActionEvent> actionEventConsumer) {
		return new AbstractAction(name) {
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(() -> actionEventConsumer.accept(e));
			}
		};
	}

	private Action newTransactionAction(String name, Consumer<ActionEvent> actionEventConsumer) {
		return new AbstractAction(name) {
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(() -> appModel().doInTransaction(transaction -> actionEventConsumer.accept(e)));
			}
		};
	}

	private void showPopup(BaseTreeNode<?> lastPathComponent, int x, int y) {
		final List<Action> actions = lastPathComponent.getActions();
		if (actions.isEmpty()) return;

		final JPopupMenu pop = new JPopupMenu();
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

	public <T> java.util.stream.Stream<T> getSelectedNodes() {
		final TreePath[] selectionPaths = tree.getSelectionPaths();
		if (selectionPaths == null || selectionPaths.length == 0) return java.util.stream.Stream.empty();
		return Arrays.stream(selectionPaths)
				.filter(treePath -> treePath.getLastPathComponent() != null)
				.map(treePath -> (T) treePath.getLastPathComponent());
	}

	private STAppPresentationModel appModel() {
		return nextgen.swing.AppModel.getInstance().getSTAppPresentationModel();
	}

	@org.greenrobot.eventbus.Subscribe()
	public void onNewSTProject(nextgen.events.NewSTProject event) {
		treeModel
				.find(RootNode.class)
				.ifPresent(rootNode -> treeModel.addNodeInSortedOrder(rootNode, new nextgen.st.STModelNavigator.STProjectTreeNode(event.model)));
	}

	@org.greenrobot.eventbus.Subscribe()
	public void onSTArgumentAdded(nextgen.events.NewSTArgument event) {
		treeModel
				.find(STModelTreeNode.class, treeNode -> treeNode.getModel().equals(event.stModel))
				.flatMap(stModelTreeNode -> treeModel.find(stModelTreeNode, STParameterTreeNode.class, baseTreeNode -> ((STParameterTreeNode) baseTreeNode)
						.getModel()
						.getUuid()
						.equals(event.stArgument.getStParameter())))
				.ifPresent(stParameterTreeNode -> {
					final nextgen.st.model.STValue stValue = event.stArgument.getValue();
					switch (stValue.getType()) {
						case STMODEL:
							treeModel.addNodeInSortedOrder(stParameterTreeNode, new STModelTreeNode(stValue.getStModel(), appModel()
									.findSTTemplateByUuid(stValue.getStModel().getStTemplate()), event.stArgument));
							break;
						case PRIMITIVE:
							treeModel.addNodeInSortedOrder(stParameterTreeNode, new STValueTreeNode(stValue, event.stArgument));
							break;
						case ENUM:
							break;
					}
				});
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
	public void onSTModelCanvasNodeClicked(nextgen.events.CanvasSTModelClicked event) {
		SwingUtilities.invokeLater(() -> {
			final RootNode rootNode = (RootNode) treeModel.getRoot();
			final TreePath path = rootNode.find(baseTreeNode -> isSTModelTreeNode(baseTreeNode) && ((STModelTreeNode) baseTreeNode).getModel().equals(event.model));
			if (path != null) {
				tree.scrollPathToVisible(path);
				tree.setSelectionPath(path);
			}
		});
	}

	class STModelNavigatorTreeModel extends DefaultTreeModel {

		public STModelNavigatorTreeModel(BaseTreeNode root) {
			super(root);
		}

		protected Optional<BaseTreeNode<?>> find(java.util.function.Predicate<BaseTreeNode<?>> predicate) {
			return find((BaseTreeNode<?>) getRoot(), predicate);
		}

		protected <T extends BaseTreeNode<?>> Optional<T> find(Class<T> nodeType) {
			final BaseTreeNode<?> root = (BaseTreeNode<?>) getRoot();
			if (root.getClass().isAssignableFrom(nodeType)) return Optional.of((T) root);
			return find((BaseTreeNode<?>) getRoot(), navigatorTreeNode ->
					navigatorTreeNode.getClass().isAssignableFrom(nodeType));
		}

		protected <T extends BaseTreeNode<?>> Optional<T> find(Class<T> nodeType, java.util.function.Predicate<T> predicate) {
			final BaseTreeNode<?> root = (BaseTreeNode<?>) getRoot();
			if (root.getClass().isAssignableFrom(nodeType) && predicate.test((T) root)) return Optional.of((T) root);
			return find((BaseTreeNode<?>) getRoot(), navigatorTreeNode -> navigatorTreeNode.getClass()
					.isAssignableFrom(nodeType) && predicate.test((T) navigatorTreeNode));
		}

		protected <T extends BaseTreeNode<?>> Optional<T> find(BaseTreeNode<?> parent, java.util.function.Predicate<BaseTreeNode<?>> predicate) {
			final int childCount = parent.getChildCount();
			for (int i = 0; i < childCount; i++) {
				final BaseTreeNode<?> childAt = (BaseTreeNode<?>) parent.getChildAt(i);
				if (predicate.test(childAt))
					return Optional.of((T) new TreePath(childAt.getPath()).getLastPathComponent());
				else {
					final Optional<T> node = find(childAt, predicate);
					if (node.isPresent()) return node;
				}
			}
			return Optional.empty();
		}

		protected <T extends BaseTreeNode<?>> Optional<T> find(BaseTreeNode<?> parent, Class<T> nodeType, java.util.function.Predicate<BaseTreeNode<?>> predicate) {
			return find(parent, navigatorTreeNode -> navigatorTreeNode.getClass()
					.isAssignableFrom(nodeType) && predicate.test((T) navigatorTreeNode));
		}

		private void addNodeInSortedOrderAndSelect(BaseTreeNode<?> parent, BaseTreeNode<?> child) {
			addNodeInSortedOrder(parent, child);
			tree.scrollPathToVisible(child.getThisPath());
			tree.setSelectionPath(child.getThisPath());
		}

		private void addNodeInSortedOrder(BaseTreeNode<?> parent, BaseTreeNode<?> child) {

			int n = parent.getChildCount();
			if (n == 0) {
				parent.add(child);
				nodesWereInserted(parent, new int[]{n});
				return;
			}

			for (int i = 0; i < n; i++) {
				final BaseTreeNode<?> node = (BaseTreeNode<?>) parent.getChildAt(i);
				if (node.getLabel().compareTo(child.getLabel()) > 0) {
					parent.insert(child, i);
					nodesWereInserted(parent, new int[]{i});
					return;
				}
			}

			parent.add(child);
			nodesWereInserted(parent, new int[]{n});
		}
	}
}