package nextgen.swing;


import javax.swing.*;
import javax.swing.tree.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.*;
import java.util.function.Consumer;

public class STModelNavigator extends JPanel {

	private final JTree tree = new JTree();
	private final STModelNavigatorTreeModel treeModel;

	private STWorkspace workspace;

	public STModelNavigator(STWorkspace workspace) {
		super(new BorderLayout());

		this.workspace = workspace;

		treeModel = new STModelNavigatorTreeModel(new RootNode("Projects"));
		tree.setModel(treeModel);
		ToolTipManager.sharedInstance().registerComponent(tree);

		tree.setCellRenderer(new STModelNavigator.STModelNavigatorCellRenderer());
		tree.addKeyListener(new STModelNavigator.STModelNavigatorKeyListener());
		tree.addMouseListener(new STModelNavigator.STModelNavigatorMouseListener());

		setPreferredSize(new Dimension(800, 600));
		add(new JScrollPane(tree), BorderLayout.CENTER);

		org.greenrobot.eventbus.EventBus.getDefault().register(this);
	}

	private final class STModelNavigatorCellRenderer extends DefaultTreeCellRenderer {
		@Override
		public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {
			final BaseTreeNode<?> node = (BaseTreeNode<?>) value;
			final ImageIcon icon = node.getIcon();
			setIcon(icon);
			setOpenIcon(icon);
			setClosedIcon(icon);
			setLeafIcon(icon);
			setToolTipText(node.getTooltip());
			return super.getTreeCellRendererComponent(tree, node.getLabel(), sel, expanded, leaf, row, hasFocus);
		}
	}

	private final class STModelNavigatorKeyListener extends KeyAdapter {
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
	}

	private final class STModelNavigatorMouseListener extends MouseAdapter {
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

            appModel().doLaterInTransaction(transaction -> {
					if (isRootNode(lastPathComponent)) 
						onRootNodeSelected((RootNode) lastPathComponent);
					else if (isSTProjectTreeNode(lastPathComponent)) 
						onSTProjectTreeNodeSelected((STProjectTreeNode) lastPathComponent);
					else if (isModelsTreeNode(lastPathComponent)) 
						onModelsTreeNodeSelected((ModelsTreeNode) lastPathComponent);
					else if (isSTGroupModelTreeNode(lastPathComponent)) 
						onSTGroupModelTreeNodeSelected((STGroupModelTreeNode) lastPathComponent);
					else if (isSTTemplateTreeNode(lastPathComponent)) 
						onSTTemplateTreeNodeSelected((STTemplateTreeNode) lastPathComponent);
					else if (isSTModelTreeNode(lastPathComponent)) 
						onSTModelTreeNodeSelected((STModelTreeNode) lastPathComponent);
					else if (isSTFileSinkTreeNode(lastPathComponent)) 
						onSTFileSinkTreeNodeSelected((STFileSinkTreeNode) lastPathComponent);
					else if (isSTParameterTreeNode(lastPathComponent)) 
						onSTParameterTreeNodeSelected((STParameterTreeNode) lastPathComponent);
					else if (isSTModelArgumentTreeNode(lastPathComponent)) 
						onSTModelArgumentTreeNodeSelected((STModelArgumentTreeNode) lastPathComponent);
					else if (isSTValueTreeNode(lastPathComponent)) 
						onSTValueTreeNodeSelected((STValueTreeNode) lastPathComponent);
					else if (isSTValueArgumentTreeNode(lastPathComponent)) 
						onSTValueArgumentTreeNodeSelected((STValueArgumentTreeNode) lastPathComponent);
					else if (isSTKVArgumentTreeNode(lastPathComponent)) 
						onSTKVArgumentTreeNodeSelected((STKVArgumentTreeNode) lastPathComponent);
					else if (isSTKVTreeNode(lastPathComponent)) 
						onSTKVTreeNodeSelected((STKVTreeNode) lastPathComponent);
					else if (isSTModelKVArgumentTreeNode(lastPathComponent)) 
						onSTModelKVArgumentTreeNodeSelected((STModelKVArgumentTreeNode) lastPathComponent);
					else if (isSTValueKVArgumentTreeNode(lastPathComponent)) 
						onSTValueKVArgumentTreeNodeSelected((STValueKVArgumentTreeNode) lastPathComponent);
					else 
						onUnhandledNodeSelected((BaseTreeNode<?>) lastPathComponent);
            });
         }
      }
   }

   private void onUnhandledNodeSelected(BaseTreeNode<?> selectedNode) {
   }

	@org.greenrobot.eventbus.Subscribe()
	public void onSTFileChanged(nextgen.events.STFileChanged event) {
		findSTFileSinkTreeNode(treeNode -> treeNode.getModel().equals(event.stFile)).ifPresent(STModelNavigator.STFileSinkTreeNode::nodeChanged);
	}

	@org.greenrobot.eventbus.Subscribe()
	public void onNewSTProject(nextgen.events.NewSTProject event) {
		findRootNode().ifPresent(treeNode -> treeModel.addNodeInSortedOrder(treeNode, new STProjectTreeNode(event.project)));
	}

	@org.greenrobot.eventbus.Subscribe()
	public void onNewFileSink(nextgen.events.NewFileSink event) {
		findSTModelTreeNode(treeNode -> treeNode.getModel().equals(event.stModel)).ifPresent(treeNode -> treeModel.addNodeInSortedOrder(treeNode, new STFileSinkTreeNode(event.stFile)));
	}

	@org.greenrobot.eventbus.Subscribe()
	public void onNewSTArgument(nextgen.events.NewSTArgument event) {
		treeModel.find(treeNode -> treeNode.getModel().equals(event.model))
				.flatMap(treeNode -> findSTParameterTreeNode(treeNode, stParameterTreeNode -> stParameterTreeNode.getModel().equals(event.parameter)))
				.ifPresent(stParameterTreeNode -> appModel().stArgumentConsumer(event.parameter)
						.onSingleSTValue((stArgument, stValue) -> treeModel.addNodeInSortedOrderAndSelect(stParameterTreeNode, new STModelNavigator.STValueArgumentTreeNode(stValue, stArgument)))
						.onSingleSTModel((stArgument, stValue) -> treeModel.addNodeInSortedOrderAndSelect(stParameterTreeNode, new STModelNavigator.STModelArgumentTreeNode(stValue.getStModel(), stArgument)))
						.onListSTValue((stArgument, stValue) -> treeModel.addNodeInSortedOrderAndSelect(stParameterTreeNode, new STModelNavigator.STValueArgumentTreeNode(stValue, stArgument)))
						.onListSTModel((stArgument, stValue) -> treeModel.addNodeInSortedOrderAndSelect(stParameterTreeNode, new STModelNavigator.STModelArgumentTreeNode(stValue.getStModel(), stArgument)))
						.onKVListConsumer((stArgument, stKVValues) -> treeModel.addNodeInSortedOrderAndSelect(stParameterTreeNode, new STModelNavigator.STKVArgumentTreeNode(stArgument, event.parameter)))
						.accept(event.argument));
	}

	@org.greenrobot.eventbus.Subscribe()
	public void onNewSTKVArgument(nextgen.events.NewSTKVArgument event) {
		treeModel.find(treeNode -> treeNode.getModel().equals(event.model))
				.flatMap(treeNode -> findSTParameterTreeNode(treeNode, stParameterTreeNode -> stParameterTreeNode.getModel().equals(event.stParameter)))
				.ifPresent(treeNode -> treeModel.addNodeInSortedOrder(treeNode, new STModelNavigator.STKVArgumentTreeNode(event.argument, event.stParameter)));
	}

	@org.greenrobot.eventbus.Subscribe()
	public void onNewKV(nextgen.events.NewKV event) {
		findSTKVArgumentTreeNode(treeNode -> treeNode.uuid.equals(event.argument.getUuid()))
				.ifPresent(treeNode -> {
					treeModel.addNodeInSortedOrderAndSelect(treeNode, new STModelNavigator.STKVTreeNode(event.kv, treeNode.getModel(), event.stParameterKey));
				});
	}

	@org.greenrobot.eventbus.Subscribe()
	public void onNewSTModel(nextgen.events.NewSTModel event) {
		findModelsTreeNode()
				.flatMap(modelsTreeNode -> findSTGroupModelTreeNode(modelsTreeNode, treeNode -> treeNode.getModel().equals(event.stGroup))
						.flatMap(treeNode -> findSTTemplateTreeNode(treeNode, stTemplateTreeNode -> stTemplateTreeNode.getModel().equals(event.template))))
				.ifPresent(stTemplateTreeNode -> treeModel.addNodeInSortedOrderAndSelect(stTemplateTreeNode, new STModelNavigator.STModelTreeNode(event.model, event.template)));
	}

	@org.greenrobot.eventbus.Subscribe()
	public void onNewSTProjectSTModel(nextgen.events.NewSTProjectSTModel event) {
		findSTProjectTreeNode(stProjectTreeNode -> stProjectTreeNode.getModel().equals(event.project))
				.ifPresent(stProjectTreeNode -> {
					final nextgen.st.model.STGroupModel stGroup = appModel().findSTGroup(event.template);
					final java.util.Optional<STModelNavigator.STGroupModelTreeNode> groupModelTreeNode = findSTGroupModelTreeNode(stProjectTreeNode, stGroupModelTreeNode -> stGroupModelTreeNode.getModel().equals(stGroup));
					if (groupModelTreeNode.isPresent()) {
						final java.util.Optional<STModelNavigator.STTemplateTreeNode> stTemplateTreeNode = findSTTemplateTreeNode(groupModelTreeNode.get(), stTemplateTreeNode1 -> stTemplateTreeNode1.getModel().equals(event.template));
						if (stTemplateTreeNode.isPresent()) {
							treeModel.addNodeInSortedOrderAndSelect(stTemplateTreeNode.get(), new STModelNavigator.STModelTreeNode(event.model, event.template));
						} else {
							final STModelNavigator.STTemplateTreeNode newSTTemplateTreeNode = new STModelNavigator.STTemplateTreeNode(event.template);
							treeModel.addNodeInSortedOrder(groupModelTreeNode.get(), newSTTemplateTreeNode);
							treeModel.addNodeInSortedOrderAndSelect(newSTTemplateTreeNode, new STModelNavigator.STModelTreeNode(event.model, event.template));
						}

					} else {
						final STModelNavigator.STGroupModelTreeNode stGroupModelTreeNode = new STModelNavigator.STGroupModelTreeNode(stGroup);
						treeModel.addNodeInSortedOrder(stProjectTreeNode, stGroupModelTreeNode);
						final STModelNavigator.STTemplateTreeNode stTemplateTreeNode = new STModelNavigator.STTemplateTreeNode(event.template);
						treeModel.addNodeInSortedOrder(stGroupModelTreeNode, stTemplateTreeNode);
						treeModel.addNodeInSortedOrderAndSelect(stTemplateTreeNode, new STModelNavigator.STModelTreeNode(event.model, event.template));
					}
				});
	}

	@org.greenrobot.eventbus.Subscribe()
	public void onNewSTProjectSTValue(nextgen.events.NewSTProjectSTValue event) {
		findSTProjectTreeNode(treeNode -> treeNode.getModel().equals(event.project))
				.ifPresent(treeNode -> treeModel.addNodeInSortedOrderAndSelect(treeNode, new STModelNavigator.STValueTreeNode(event.value)));
	}

	@org.greenrobot.eventbus.Subscribe()
	public void onSTValueChanged(nextgen.events.STValueChanged event) {
		treeModel.find(treeNode -> treeNode.getModel().equals(event.value)).ifPresent(STModelNavigator.BaseTreeNode::nodeChanged);
	}

	@org.greenrobot.eventbus.Subscribe()
	public void onSTArgumentChanged(nextgen.events.STArgumentChanged event) {
		findSTModelArgumentTreeNode(stModelArgumentTreeNode -> stModelArgumentTreeNode.stArgument.equals(event.stArgument)).ifPresent(treeModel::nodeChanged);
		findSTValueArgumentTreeNode(stModelArgumentTreeNode -> stModelArgumentTreeNode.stArgument.equals(event.stArgument)).ifPresent(treeModel::nodeChanged);
	}

	@org.greenrobot.eventbus.Subscribe()
	public void onSTModelChanged(nextgen.events.STModelChanged event) {
		treeModel.find(treeNode -> treeNode.getModel().equals(event.model)).ifPresent(STModelNavigator.BaseTreeNode::nodeChanged);
	}

	@org.greenrobot.eventbus.Subscribe()
	public void onSTModelDeleted(nextgen.events.STModelDeleted event) {
		SwingUtilities.invokeLater(() -> findSTModelTreeNode(treeNode -> treeNode.uuid.equals(event.uuid)).ifPresent(treeModel::removeNodeFromParent));
	}

	@org.greenrobot.eventbus.Subscribe()
	public void onSTValueDeleted(nextgen.events.STValueDeleted event) {
		SwingUtilities.invokeLater(() -> {
			findSTValueTreeNode(treeNode -> treeNode.uuid.equals(event.uuid)).ifPresent(treeModel::removeNodeFromParent);
			findSTValueArgumentTreeNode(treeNode -> treeNode.uuid.equals(event.uuid)).ifPresent(treeModel::removeNodeFromParent);
			findSTValueKVArgumentTreeNode(treeNode -> treeNode.uuid.equals(event.uuid)).ifPresent(treeModel::removeNodeFromParent);
		});
	}

	@org.greenrobot.eventbus.Subscribe()
	public void onSTGroupDeleted(nextgen.events.STGroupDeleted event) {
		SwingUtilities.invokeLater(() -> findSTGroupModelTreeNode(treeNode -> treeNode.uuid.equals(event.uuid)).ifPresent(treeModel::removeNodeFromParent));
	}

	@org.greenrobot.eventbus.Subscribe()
	public void onSTFileDeleted(nextgen.events.STFileDeleted event) {
		findSTFileSinkTreeNode(treeNode -> treeNode.uuid.equals(event.uuid)).ifPresent(treeModel::removeNodeFromParent);
	}

	@org.greenrobot.eventbus.Subscribe()
	public void onKVDeleted(nextgen.events.KVDeleted event) {
		findSTKVTreeNode(treeNode -> treeNode.uuid.equals(event.uuid)).ifPresent(treeModel::removeNodeFromParent);
	}

	@org.greenrobot.eventbus.Subscribe()
	public void onSTArgumentDeleted(nextgen.events.STArgumentDeleted event) {
		findSTValueArgumentTreeNode(treeNode -> treeNode.stArgumentUuid.equals(event.uuid)).ifPresent(treeModel::removeNodeFromParent);
		findSTKVArgumentTreeNode(treeNode -> treeNode.uuid.equals(event.uuid)).ifPresent(treeModel::removeNodeFromParent);
		findSTModelArgumentTreeNode(treeNode -> treeNode.stArgumentUuid.equals(event.uuid)).ifPresent(treeModel::removeNodeFromParent);
		findSTKVArgumentTreeNode(treeNode -> treeNode.uuid.equals(event.uuid)).ifPresent(treeModel::removeNodeFromParent);
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

			int n = getChildCount();
			if (n == 0) {
				add(child);
				return new javax.swing.tree.TreePath(child.getPath());
			}

			for (int i = 0; i < n; i++) {
				final BaseTreeNode<?> node = (BaseTreeNode<?>) getChildAt(i);
				if (node.getLabel().compareTo(child.getLabel()) > 0) {
					insert(child, i);
					return new javax.swing.tree.TreePath(child.getPath());
				}
			}

			add(child);

			return new javax.swing.tree.TreePath(child.getPath());
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

	// RootNode
	public class RootNode extends BaseTreeNode<String> {

		RootNode(String model) {
			super(model, null);


			setLabel(getModel());
			this.tooltip = "";

			appModel().doInTransaction(transaction -> {
				appModel().getProjects().forEach(stProject -> add(new STProjectTreeNode(stProject)));
				add(new ModelsTreeNode("Models"));
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

			appModel().doInTransaction(tx -> {
				actions.add(new nextgen.actions.NewProject(tree));
				actions.add(new nextgen.actions.UndoDBTransaction());
			});

			return actions;
		}

	}

	private boolean isRootNode(Object treeNode) {
		return treeNode instanceof RootNode;
	}

	private Optional<RootNode> findRootNode() {
		return treeModel.find(RootNode.class, treeNode -> true);
	}

	private Optional<RootNode> findRootNode(java.util.function.Predicate<RootNode> predicate) {
		return treeModel.find(RootNode.class, predicate);
	}

	private Optional<RootNode> findRootNode(BaseTreeNode<?> parent, java.util.function.Predicate<RootNode> predicate) {
		return treeModel.find(parent, RootNode.class, predicate);
	}

	private java.util.stream.Stream<RootNode> getSelectedRootNodes() {
		return getSelectedNodes(RootNode.class);
	}

	private void onRootNodeSelected(RootNode selectedNode) {
	}

	// STProjectTreeNode
	public class STProjectTreeNode extends BaseTreeNode<nextgen.st.model.STProject> {

		STProjectTreeNode(nextgen.st.model.STProject model) {
			super(model, appModel().loadIcon("sq-white"));


			setLabel(getModel().getName());
			this.tooltip = "";

			final Map<nextgen.st.model.STGroupModel, STModelNavigator.STGroupModelTreeNode> stGroupTreeNodeMap = new java.util.LinkedHashMap<>();
			final Map<nextgen.st.model.STTemplate, STModelNavigator.STTemplateTreeNode> stTemplateTreeNodeMap = new java.util.LinkedHashMap<>();
			model.getModelsSorted().forEach(stModel -> {

				final nextgen.st.model.STTemplate stTemplate = stModel.getStTemplate();
				final nextgen.st.model.STGroupModel stGroup = appModel().findSTGroup(stTemplate);

				if (!stGroupTreeNodeMap.containsKey(stGroup)) {
					final STModelNavigator.STGroupModelTreeNode stGroupModelTreeNode = new STModelNavigator.STGroupModelTreeNode(stGroup);
					add(stGroupModelTreeNode);
					stGroupTreeNodeMap.put(stGroup, stGroupModelTreeNode);
				}

				if (!stTemplateTreeNodeMap.containsKey(stTemplate)) {
					final STModelNavigator.STTemplateTreeNode stTemplateTreeNode = new STModelNavigator.STTemplateTreeNode(stTemplate);
					stGroupTreeNodeMap.get(stGroup).add(stTemplateTreeNode);
					stTemplateTreeNodeMap.put(stTemplate, stTemplateTreeNode);
				}

				stTemplateTreeNodeMap.get(stTemplate).add(new STModelNavigator.STModelTreeNode(stModel, stTemplate));
			});

			model.getValuesSorted().forEach(stValue -> add(new STModelNavigator.STValueTreeNode(stValue)));
		}

		STProjectTreeNode thisNode() {
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

			appModel().doInTransaction(tx -> {
				final java.util.Set<nextgen.st.model.STModel> selectedSTModels = getSelectedSTModels().collect(java.util.stream.Collectors.toSet());
				final java.util.Set<nextgen.st.model.STModel> projectSTModels = nextgen.utils.STModelUtil.aggregateModels(getModel());
				selectedSTModels.removeAll(projectSTModels);

				final java.util.Set<nextgen.st.model.STValue> selectedSTValues = getSelectedSTValues().collect(java.util.stream.Collectors.toSet());
				final java.util.Set<nextgen.st.model.STValue> projectSTValues = getModel().getValues().collect(java.util.stream.Collectors.toSet());
				selectedSTValues.removeAll(projectSTValues);

				for (nextgen.st.model.STModel selected : selectedSTModels) 
					actions.add(new nextgen.actions.AddModelToProject(getModel(), selected));

				for (nextgen.st.model.STValue selected : selectedSTValues) 
					actions.add(new nextgen.actions.AddValueToProject(getModel(), selected));
				actions.add(new nextgen.actions.AddValueToProjectFromInput(getModel(), tree));
				actions.add(new nextgen.actions.AddMultipleValuesToProject(getModel(), tree));
				actions.add(new nextgen.actions.GenerateAllProjectModels(getModel()));
			});

			return actions;
		}

	}

	private boolean isSTProjectTreeNode(Object treeNode) {
		return treeNode instanceof STProjectTreeNode;
	}

	private Optional<STProjectTreeNode> findSTProjectTreeNode() {
		return treeModel.find(STProjectTreeNode.class, treeNode -> true);
	}

	private Optional<STProjectTreeNode> findSTProjectTreeNode(java.util.function.Predicate<STProjectTreeNode> predicate) {
		return treeModel.find(STProjectTreeNode.class, predicate);
	}

	private Optional<STProjectTreeNode> findSTProjectTreeNode(BaseTreeNode<?> parent, java.util.function.Predicate<STProjectTreeNode> predicate) {
		return treeModel.find(parent, STProjectTreeNode.class, predicate);
	}

	private java.util.stream.Stream<STProjectTreeNode> getSelectedSTProjectTreeNodes() {
		return getSelectedNodes(STProjectTreeNode.class);
	}

	private void onSTProjectTreeNodeSelected(STProjectTreeNode selectedNode) {
		nextgen.events.ModelNavigatorSTProjectTreeNodeClicked.post(selectedNode.getModel());
	}

	// ModelsTreeNode
	public class ModelsTreeNode extends BaseTreeNode<String> {

		ModelsTreeNode(String model) {
			super(model, appModel().loadIcon("sq-teal"));


			setLabel(getModel());
			this.tooltip = "";

			appModel().doInTransaction(transaction -> {
				appModel().getGroupModels().forEach(stGroupModel -> {
					final STModelNavigator.STGroupModelTreeNode stGroupModelTreeNode = new STModelNavigator.STGroupModelTreeNode(stGroupModel);
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
			setLabel(getModel());
			this.tooltip = "";
			super.nodeChanged();
		}

		@Override
		protected List<Action> getActions() {
			final List<Action> actions = super.getActions();

			appModel().doInTransaction(tx -> {
			});

			return actions;
		}

		private void addSTTemplateChild(nextgen.st.model.STTemplate stTemplate, BaseTreeNode<?> parent) {
			final STModelNavigator.STTemplateTreeNode stTemplateTreeNode = new STModelNavigator.STTemplateTreeNode(stTemplate);
			parent.add(stTemplateTreeNode);

			stTemplate.getIncomingStTemplateSTModel().forEach(stModel -> stTemplateTreeNode.add(new STModelTreeNode(stModel, stTemplate)));
			stTemplate.getChildren().forEach(stTemplateChild -> addSTTemplateChild(stTemplateChild, stTemplateTreeNode));
		}
	}

	private boolean isModelsTreeNode(Object treeNode) {
		return treeNode instanceof ModelsTreeNode;
	}

	private Optional<ModelsTreeNode> findModelsTreeNode() {
		return treeModel.find(ModelsTreeNode.class, treeNode -> true);
	}

	private Optional<ModelsTreeNode> findModelsTreeNode(java.util.function.Predicate<ModelsTreeNode> predicate) {
		return treeModel.find(ModelsTreeNode.class, predicate);
	}

	private Optional<ModelsTreeNode> findModelsTreeNode(BaseTreeNode<?> parent, java.util.function.Predicate<ModelsTreeNode> predicate) {
		return treeModel.find(parent, ModelsTreeNode.class, predicate);
	}

	private java.util.stream.Stream<ModelsTreeNode> getSelectedModelsTreeNodes() {
		return getSelectedNodes(ModelsTreeNode.class);
	}

	private void onModelsTreeNodeSelected(ModelsTreeNode selectedNode) {
	}

	// STGroupModelTreeNode
	public class STGroupModelTreeNode extends BaseTreeNode<nextgen.st.model.STGroupModel> {

		private String uuid;

		STGroupModelTreeNode(nextgen.st.model.STGroupModel model) {
			super(model, null);


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

			appModel().doInTransaction(tx -> {
			});

			return actions;
		}

	}

	private boolean isSTGroupModelTreeNode(Object treeNode) {
		return treeNode instanceof STGroupModelTreeNode;
	}

	private Optional<STGroupModelTreeNode> findSTGroupModelTreeNode() {
		return treeModel.find(STGroupModelTreeNode.class, treeNode -> true);
	}

	private Optional<STGroupModelTreeNode> findSTGroupModelTreeNode(java.util.function.Predicate<STGroupModelTreeNode> predicate) {
		return treeModel.find(STGroupModelTreeNode.class, predicate);
	}

	private Optional<STGroupModelTreeNode> findSTGroupModelTreeNode(BaseTreeNode<?> parent, java.util.function.Predicate<STGroupModelTreeNode> predicate) {
		return treeModel.find(parent, STGroupModelTreeNode.class, predicate);
	}

	private java.util.stream.Stream<STGroupModelTreeNode> getSelectedSTGroupModelTreeNodes() {
		return getSelectedNodes(STGroupModelTreeNode.class);
	}

	private void onSTGroupModelTreeNodeSelected(STGroupModelTreeNode selectedNode) {
		nextgen.events.ModelNavigatorSTGroupTreeNodeClicked.post(selectedNode.getModel());
	}

	// STTemplateTreeNode
	public class STTemplateTreeNode extends BaseTreeNode<nextgen.st.model.STTemplate> {

		private String uuid;

		STTemplateTreeNode(nextgen.st.model.STTemplate model) {
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

			appModel().doInTransaction(tx -> {
				final java.util.List<nextgen.st.model.STModel> stModels = getChildren(STModelNavigator.STModelTreeNode.class)
												.map(STModelNavigator.BaseTreeNode::getModel)
												.collect(java.util.stream.Collectors.toList());
				getParentNode(STProjectTreeNode.class).ifPresent(parent -> actions.add(new nextgen.actions.AddTemplateModelToProject("New instance", getModel(), parent.getModel())));
				getParentNode(ModelsTreeNode.class).ifPresent(parent -> actions.add(new nextgen.actions.NewSTModelAction(getModel())));
				actions.add(new nextgen.actions.EditModels(getModel()));
				actions.add(new nextgen.actions.WriteAllSTModelsToFile(stModels));
				actions.add(new nextgen.actions.GenerateSources(getModel(), stModels));
				actions.add(new nextgen.actions.AddFileSinkToSTModels(getModel(), stModels, tree));
				actions.add(new nextgen.actions.DeleteSTFileFromSTModels(stModels, tree));
			});

			return actions;
		}

	}

	private boolean isSTTemplateTreeNode(Object treeNode) {
		return treeNode instanceof STTemplateTreeNode;
	}

	private Optional<STTemplateTreeNode> findSTTemplateTreeNode() {
		return treeModel.find(STTemplateTreeNode.class, treeNode -> true);
	}

	private Optional<STTemplateTreeNode> findSTTemplateTreeNode(java.util.function.Predicate<STTemplateTreeNode> predicate) {
		return treeModel.find(STTemplateTreeNode.class, predicate);
	}

	private Optional<STTemplateTreeNode> findSTTemplateTreeNode(BaseTreeNode<?> parent, java.util.function.Predicate<STTemplateTreeNode> predicate) {
		return treeModel.find(parent, STTemplateTreeNode.class, predicate);
	}

	private java.util.stream.Stream<STTemplateTreeNode> getSelectedSTTemplateTreeNodes() {
		return getSelectedNodes(STTemplateTreeNode.class);
	}

	private void onSTTemplateTreeNodeSelected(STTemplateTreeNode selectedNode) {
	}

	// STModelTreeNode
	public class STModelTreeNode extends BaseTreeNode<nextgen.st.model.STModel> {

		private String uuid;
		private nextgen.st.model.STTemplate stTemplate;

		STModelTreeNode(nextgen.st.model.STModel model, nextgen.st.model.STTemplate stTemplate) {
			super(model, appModel().loadIcon("sq-teal"));

			this.stTemplate = stTemplate;

			setLabel(appModel().tryToFindArgument(getModel(), "name", () -> "[" + stTemplate.getName() + "]"));
			this.tooltip = "";
			this.uuid = model.getUuid();

			getModel().getFiles()
					.forEach(stFile -> add(new STFileSinkTreeNode(stFile)));
			stTemplate.getParameters()
					.sorted((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName()))
					.forEach(stParameter -> add(new STParameterTreeNode(stParameter, model)));
		}

		STModelTreeNode thisNode() {
			return this;
		}

		@Override
		public void nodeChanged() {
			setLabel(appModel().tryToFindArgument(getModel(), "name", () -> "[" + stTemplate.getName() + "]"));
			this.tooltip = "";
			super.nodeChanged();
		}

		@Override
		protected List<Action> getActions() {
			final List<Action> actions = super.getActions();

			appModel().doInTransaction(tx -> {
				actions.add(new nextgen.actions.STModelToClipboard(getModel()));
				actions.add(new nextgen.actions.WriteSTModelToFile(getModel()));
				actions.add(new nextgen.actions.AddFileSink(getModel()));
				actions.add(new nextgen.actions.CopyModel(getModel()));
				actions.add(new nextgen.actions.GenerateSource(getModel()));
				actions.add(new nextgen.actions.OpenSTModelAction(getModel()));
				actions.add(new nextgen.actions.VisitSTModel(getModel()));
				actions.add(new nextgen.actions.EditSTModel(getModel()));
				actions.add(new nextgen.actions.DeleteSTModel(getModel(), tree));
			});

			return actions;
		}

	}

	private boolean isSTModelTreeNode(Object treeNode) {
		return treeNode instanceof STModelTreeNode;
	}

	private Optional<STModelTreeNode> findSTModelTreeNode() {
		return treeModel.find(STModelTreeNode.class, treeNode -> true);
	}

	private Optional<STModelTreeNode> findSTModelTreeNode(java.util.function.Predicate<STModelTreeNode> predicate) {
		return treeModel.find(STModelTreeNode.class, predicate);
	}

	private Optional<STModelTreeNode> findSTModelTreeNode(BaseTreeNode<?> parent, java.util.function.Predicate<STModelTreeNode> predicate) {
		return treeModel.find(parent, STModelTreeNode.class, predicate);
	}

	private java.util.stream.Stream<STModelTreeNode> getSelectedSTModelTreeNodes() {
		return getSelectedNodes(STModelTreeNode.class);
	}

	private void onSTModelTreeNodeSelected(STModelTreeNode selectedNode) {
		nextgen.events.ModelNavigatorSTModelTreeNodeClicked.post(selectedNode.stTemplate, selectedNode.getModel());
	}

	// STFileSinkTreeNode
	public class STFileSinkTreeNode extends BaseTreeNode<nextgen.st.model.STFile> {

		private String uuid;

		STFileSinkTreeNode(nextgen.st.model.STFile model) {
			super(model, appModel().loadIcon("sq-white"));


			setLabel(appModel().render(getModel().getPath()));
			this.tooltip = "";
			this.uuid = model.getUuid();

		}

		STFileSinkTreeNode thisNode() {
			return this;
		}

		@Override
		public void nodeChanged() {
			setLabel(appModel().render(getModel().getPath()));
			this.tooltip = "";
			super.nodeChanged();
		}

		@Override
		protected List<Action> getActions() {
			final List<Action> actions = super.getActions();

			appModel().doInTransaction(tx -> {
				actions.add(new nextgen.actions.DeleteSTFile(getModel(), tree));
			});

			return actions;
		}

	}

	private boolean isSTFileSinkTreeNode(Object treeNode) {
		return treeNode instanceof STFileSinkTreeNode;
	}

	private Optional<STFileSinkTreeNode> findSTFileSinkTreeNode() {
		return treeModel.find(STFileSinkTreeNode.class, treeNode -> true);
	}

	private Optional<STFileSinkTreeNode> findSTFileSinkTreeNode(java.util.function.Predicate<STFileSinkTreeNode> predicate) {
		return treeModel.find(STFileSinkTreeNode.class, predicate);
	}

	private Optional<STFileSinkTreeNode> findSTFileSinkTreeNode(BaseTreeNode<?> parent, java.util.function.Predicate<STFileSinkTreeNode> predicate) {
		return treeModel.find(parent, STFileSinkTreeNode.class, predicate);
	}

	private java.util.stream.Stream<STFileSinkTreeNode> getSelectedSTFileSinkTreeNodes() {
		return getSelectedNodes(STFileSinkTreeNode.class);
	}

	private void onSTFileSinkTreeNodeSelected(STFileSinkTreeNode selectedNode) {
		nextgen.events.ModelNavigatorSTFileTreeNodeClicked.post(selectedNode.getModel());
	}

	// STParameterTreeNode
	public class STParameterTreeNode extends BaseTreeNode<nextgen.st.model.STParameter> {

		private String uuid;
		private nextgen.st.model.STModel stModel;

		STParameterTreeNode(nextgen.st.model.STParameter model, nextgen.st.model.STModel stModel) {
			super(model, null);

			this.stModel = stModel;

			setLabel(getModel().getName());
			this.tooltip = "";
			this.uuid = model.getUuid();

			stModel.getArgumentsSorted()
				.filter(stArgument -> stArgument.getStParameter().equals(model))
				.forEach(appModel().stArgumentConsumer(model)
						.onSingleSTValue((stArgument, stValue) -> addChild(new STValueArgumentTreeNode(stValue, stArgument)))
						.onSingleSTModel((stArgument, stValue) -> addChild(new STModelArgumentTreeNode(stValue.getStModel(), stArgument)))
						.onListSTValue((stArgument, stValue) -> addChild(new STValueArgumentTreeNode(stValue, stArgument)))
						.onListSTModel((stArgument, stValue) -> addChild(new STModelArgumentTreeNode(stValue.getStModel(),  stArgument)))
						.onKVListConsumer((stArgument, stKVValues) -> addChild(new STKVArgumentTreeNode(stArgument, model))));
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

			appModel().doInTransaction(tx -> {
				final java.util.Optional<STModelNavigator.STModelTreeNode> parentNode = getParentNode(STModelNavigator.STModelTreeNode.class);

				final String clipboard = nextgen.utils.SwingUtil.fromClipboard();
				final String stModelUuid = clipboard.startsWith("stmodel-") ? clipboard.replaceAll("stmodel-","").trim() : null;

				final java.util.List<nextgen.st.model.STValue> selectedSTValues = getSelectedSTValues().collect(java.util.stream.Collectors.toList());

				final java.util.List<nextgen.st.model.STModel> selectedSTModels = getSelectedSTModels()
										.filter(stModel1 -> parentNode.isPresent())
										.filter(stModel1 -> !stModel1.equals(parentNode.get().getModel()))
										.collect(java.util.stream.Collectors.toList());

				final java.util.List<nextgen.st.model.STTemplate> stTemplates = nextgen.swing.AppModel.getInstance().getWorkspace().getSelectedSTTemplates().getSelectedSTTemplates().collect(java.util.stream.Collectors.toList());

				switch (getModel().getType()) {
					case SINGLE:
						if (stModelUuid != null) actions.add(new nextgen.actions.SetArgumentFromSTModelUuid("Set " + stModelUuid, stModel, getModel(), stModelUuid));
						selectedSTModels.forEach(stNode -> actions.add(new nextgen.actions.SetArgumentFromSTModel("Set " + nextgen.utils.STModelUtil.getSTModelName(stNode, appModel().render(stNode, 30)), stModel, getModel(), stNode)));
						selectedSTValues.forEach(stNode -> actions.add(new nextgen.actions.SetArgumentFromSTValue("Set " + appModel().render(stNode, 30), stModel, getModel(), stNode)));
						stTemplates.forEach(stNode -> actions.add(new nextgen.actions.SetArgumentFromSTTemplate("Set New " + stNode.getName(), stModel, getModel(), stNode)));
						actions.add(new nextgen.actions.SetArgumentFromArgumentType(stModel, getModel(), tree));
						actions.add(new nextgen.actions.SetArgumentFromInput(stModel, getModel(), tree));
						actions.add(new nextgen.actions.SetArgumentFromClipboard(stModel, getModel()));
						if (appModel().isBoolean(getModel())) actions.add(new nextgen.actions.SetArgumentToTrue(stModel, getModel()));
						break;
					case LIST:
						if (stModelUuid != null) actions.add(new nextgen.actions.AddArgumentFromSTModelUuid("Add " + stModelUuid, stModel, getModel(), stModelUuid));
						selectedSTModels.forEach(stNode -> actions.add(new nextgen.actions.AddArgumentFromSTModel("Add " + nextgen.utils.STModelUtil.getSTModelName(stNode, appModel().render(stNode, 30)), stModel, getModel(), stNode)));
						selectedSTValues.forEach(stNode -> actions.add(new nextgen.actions.AddArgumentFromSTValue("Add " + appModel().render(stNode, 30), stModel, getModel(), stNode)));
						stTemplates.forEach(stNode -> actions.add(new nextgen.actions.AddArgumentFromSTTemplate("Add New " + stNode.getName(), stModel, getModel(), stNode)));
						actions.add(new nextgen.actions.AddArgumentFromInput(stModel, getModel(), tree));
						actions.add(new nextgen.actions.AddArgumentFromClipboard(stModel, getModel()));
						actions.add(new nextgen.actions.AddArgumentFromArgumentType(stModel, getModel(), tree));
						break;
					case KVLIST:
						actions.add(new nextgen.actions.AddKVArgument(stModel, getModel(), tree));
						break;
				}
			});

			return actions;
		}

	}

	private boolean isSTParameterTreeNode(Object treeNode) {
		return treeNode instanceof STParameterTreeNode;
	}

	private Optional<STParameterTreeNode> findSTParameterTreeNode() {
		return treeModel.find(STParameterTreeNode.class, treeNode -> true);
	}

	private Optional<STParameterTreeNode> findSTParameterTreeNode(java.util.function.Predicate<STParameterTreeNode> predicate) {
		return treeModel.find(STParameterTreeNode.class, predicate);
	}

	private Optional<STParameterTreeNode> findSTParameterTreeNode(BaseTreeNode<?> parent, java.util.function.Predicate<STParameterTreeNode> predicate) {
		return treeModel.find(parent, STParameterTreeNode.class, predicate);
	}

	private java.util.stream.Stream<STParameterTreeNode> getSelectedSTParameterTreeNodes() {
		return getSelectedNodes(STParameterTreeNode.class);
	}

	private void onSTParameterTreeNodeSelected(STParameterTreeNode selectedNode) {
		nextgen.events.ModelNavigatorSTParameterTreeNodeClicked.post(selectedNode.getModel());
	}

	// STModelArgumentTreeNode
	public class STModelArgumentTreeNode extends BaseTreeNode<nextgen.st.model.STModel> {

		private String uuid;
		private nextgen.st.model.STArgument stArgument;
		private String stArgumentUuid;
		private nextgen.st.model.STTemplate stTemplate;

		STModelArgumentTreeNode(nextgen.st.model.STModel model, nextgen.st.model.STArgument stArgument) {
			super(model, appModel().loadIcon("sq-teal"));

			this.stArgument = stArgument;
			this.stArgumentUuid = stArgument.getUuid();
			this.stTemplate = model.getStTemplate();

			setLabel(appModel().tryToFindArgument(getModel(), "name", () -> "[" + stTemplate.getName() + "]"));
			this.tooltip = "";
			this.uuid = model.getUuid();

			stTemplate.getParameters()
					.sorted((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName()))
					.forEach(stParameter -> add(new STParameterTreeNode(stParameter, model)));
		}

		STModelArgumentTreeNode thisNode() {
			return this;
		}

		@Override
		public void nodeChanged() {
			setLabel(appModel().tryToFindArgument(getModel(), "name", () -> "[" + stTemplate.getName() + "]"));
			this.tooltip = "";
			super.nodeChanged();
		}

		@Override
		protected List<Action> getActions() {
			final List<Action> actions = super.getActions();

			appModel().doInTransaction(tx -> {
				actions.add(new nextgen.actions.GenerateSource(getModel()));
				actions.add(new nextgen.actions.CopyModel(getModel()));
				actions.add(new nextgen.actions.DeleteSTArgument(stArgument, tree));
			});

			return actions;
		}

	}

	private boolean isSTModelArgumentTreeNode(Object treeNode) {
		return treeNode instanceof STModelArgumentTreeNode;
	}

	private Optional<STModelArgumentTreeNode> findSTModelArgumentTreeNode() {
		return treeModel.find(STModelArgumentTreeNode.class, treeNode -> true);
	}

	private Optional<STModelArgumentTreeNode> findSTModelArgumentTreeNode(java.util.function.Predicate<STModelArgumentTreeNode> predicate) {
		return treeModel.find(STModelArgumentTreeNode.class, predicate);
	}

	private Optional<STModelArgumentTreeNode> findSTModelArgumentTreeNode(BaseTreeNode<?> parent, java.util.function.Predicate<STModelArgumentTreeNode> predicate) {
		return treeModel.find(parent, STModelArgumentTreeNode.class, predicate);
	}

	private java.util.stream.Stream<STModelArgumentTreeNode> getSelectedSTModelArgumentTreeNodes() {
		return getSelectedNodes(STModelArgumentTreeNode.class);
	}

	private void onSTModelArgumentTreeNodeSelected(STModelArgumentTreeNode selectedNode) {
		nextgen.events.ModelNavigatorSTModelTreeNodeClicked.post(selectedNode.stTemplate, selectedNode.getModel());
	}

	// STValueTreeNode
	public class STValueTreeNode extends BaseTreeNode<nextgen.st.model.STValue> {

		private String uuid;

		STValueTreeNode(nextgen.st.model.STValue model) {
			super(model, appModel().loadIcon("sq-orange"));


			setLabel(appModel().render(getModel(), 30) + "...");
			this.tooltip = "";
			this.uuid = model.getUuid();

		}

		STValueTreeNode thisNode() {
			return this;
		}

		@Override
		public void nodeChanged() {
			setLabel(appModel().render(getModel(), 30) + "...");
			this.tooltip = "";
			super.nodeChanged();
		}

		@Override
		protected List<Action> getActions() {
			final List<Action> actions = super.getActions();

			appModel().doInTransaction(tx -> {
				actions.add(new nextgen.actions.SetSTValueFromInput(getModel(), tree));
				actions.add(new nextgen.actions.SetSTValueFromClipboard(getModel()));
				actions.add(new nextgen.actions.STValueToClipboard(getModel()));
				actions.add(new nextgen.actions.DeleteSTValue(getModel(), tree));
			});

			return actions;
		}

	}

	private boolean isSTValueTreeNode(Object treeNode) {
		return treeNode instanceof STValueTreeNode;
	}

	private Optional<STValueTreeNode> findSTValueTreeNode() {
		return treeModel.find(STValueTreeNode.class, treeNode -> true);
	}

	private Optional<STValueTreeNode> findSTValueTreeNode(java.util.function.Predicate<STValueTreeNode> predicate) {
		return treeModel.find(STValueTreeNode.class, predicate);
	}

	private Optional<STValueTreeNode> findSTValueTreeNode(BaseTreeNode<?> parent, java.util.function.Predicate<STValueTreeNode> predicate) {
		return treeModel.find(parent, STValueTreeNode.class, predicate);
	}

	private java.util.stream.Stream<STValueTreeNode> getSelectedSTValueTreeNodes() {
		return getSelectedNodes(STValueTreeNode.class);
	}

	private void onSTValueTreeNodeSelected(STValueTreeNode selectedNode) {
		nextgen.events.ModelNavigatorSTValueTreeNodeClicked.post(selectedNode.getModel());
	}

	// STValueArgumentTreeNode
	public class STValueArgumentTreeNode extends BaseTreeNode<nextgen.st.model.STValue> {

		private String uuid;
		private nextgen.st.model.STArgument stArgument;
		private String stArgumentUuid;

		STValueArgumentTreeNode(nextgen.st.model.STValue model, nextgen.st.model.STArgument stArgument) {
			super(model, appModel().loadIcon("sq-orange"));

			this.stArgument = stArgument;
			this.stArgumentUuid = stArgument.getUuid();

			setLabel(appModel().render(getModel(), 30) + "...");
			this.tooltip = "";
			this.uuid = model.getUuid();

		}

		STValueArgumentTreeNode thisNode() {
			return this;
		}

		@Override
		public void nodeChanged() {
			setLabel(appModel().render(getModel(), 30) + "...");
			this.tooltip = "";
			super.nodeChanged();
		}

		@Override
		protected List<Action> getActions() {
			final List<Action> actions = super.getActions();

			appModel().doInTransaction(tx -> {
				actions.add(new nextgen.actions.STValueToClipboard(getModel()));
				actions.add(new nextgen.actions.DeleteSTArgument(stArgument, tree));
			});

			return actions;
		}

	}

	private boolean isSTValueArgumentTreeNode(Object treeNode) {
		return treeNode instanceof STValueArgumentTreeNode;
	}

	private Optional<STValueArgumentTreeNode> findSTValueArgumentTreeNode() {
		return treeModel.find(STValueArgumentTreeNode.class, treeNode -> true);
	}

	private Optional<STValueArgumentTreeNode> findSTValueArgumentTreeNode(java.util.function.Predicate<STValueArgumentTreeNode> predicate) {
		return treeModel.find(STValueArgumentTreeNode.class, predicate);
	}

	private Optional<STValueArgumentTreeNode> findSTValueArgumentTreeNode(BaseTreeNode<?> parent, java.util.function.Predicate<STValueArgumentTreeNode> predicate) {
		return treeModel.find(parent, STValueArgumentTreeNode.class, predicate);
	}

	private java.util.stream.Stream<STValueArgumentTreeNode> getSelectedSTValueArgumentTreeNodes() {
		return getSelectedNodes(STValueArgumentTreeNode.class);
	}

	private void onSTValueArgumentTreeNodeSelected(STValueArgumentTreeNode selectedNode) {
		nextgen.events.ModelNavigatorSTValueTreeNodeClicked.post(selectedNode.getModel());
	}

	// STKVArgumentTreeNode
	public class STKVArgumentTreeNode extends BaseTreeNode<nextgen.st.model.STArgument> {

		private String uuid;
		private nextgen.st.model.STParameter stParameter;

		STKVArgumentTreeNode(nextgen.st.model.STArgument model, nextgen.st.model.STParameter stParameter) {
			super(model, appModel().loadIcon("sq-yellow"));

			this.stParameter = stParameter;

			setLabel(appModel().tryToFindArgument(getModel().getKeyValues(), stParameter, "name", stParameter::getName));
			this.tooltip = "";
			this.uuid = model.getUuid();

			stParameter.getKeys().forEach(stParameterKey -> getModel().getKeyValues()
					.filter(stArgumentKV -> stArgumentKV.getStParameterKey().equals(stParameterKey))
					.findFirst()
					.ifPresent(stArgumentKV -> add(new STKVTreeNode(stArgumentKV, getModel(), stParameterKey))));
		}

		STKVArgumentTreeNode thisNode() {
			return this;
		}

		@Override
		public void nodeChanged() {
			setLabel(appModel().tryToFindArgument(getModel().getKeyValues(), stParameter, "name", stParameter::getName));
			this.tooltip = "";
			super.nodeChanged();
		}

		@Override
		protected List<Action> getActions() {
			final List<Action> actions = super.getActions();

			appModel().doInTransaction(tx -> {
				getParentNode(STModelTreeNode.class).ifPresent(parent -> {
					stParameter.getKeys().forEach(stParameterKey -> {
					actions.add(new nextgen.actions.SetKVArgumentFromArgumentType(parent.getModel(), getModel(), stParameterKey, tree));
					actions.add(new nextgen.actions.SetKVArgumentFromInput(parent.getModel(), getModel(), stParameterKey, tree));
					actions.add(new nextgen.actions.SetKVArgumentFromClipboard(parent.getModel(), getModel(), stParameterKey));
					});
				} );
				actions.add(new nextgen.actions.DeleteSTArgument(getModel(), tree));
			});

			return actions;
		}

	}

	private boolean isSTKVArgumentTreeNode(Object treeNode) {
		return treeNode instanceof STKVArgumentTreeNode;
	}

	private Optional<STKVArgumentTreeNode> findSTKVArgumentTreeNode() {
		return treeModel.find(STKVArgumentTreeNode.class, treeNode -> true);
	}

	private Optional<STKVArgumentTreeNode> findSTKVArgumentTreeNode(java.util.function.Predicate<STKVArgumentTreeNode> predicate) {
		return treeModel.find(STKVArgumentTreeNode.class, predicate);
	}

	private Optional<STKVArgumentTreeNode> findSTKVArgumentTreeNode(BaseTreeNode<?> parent, java.util.function.Predicate<STKVArgumentTreeNode> predicate) {
		return treeModel.find(parent, STKVArgumentTreeNode.class, predicate);
	}

	private java.util.stream.Stream<STKVArgumentTreeNode> getSelectedSTKVArgumentTreeNodes() {
		return getSelectedNodes(STKVArgumentTreeNode.class);
	}

	private void onSTKVArgumentTreeNodeSelected(STKVArgumentTreeNode selectedNode) {
	}

	// STKVTreeNode
	public class STKVTreeNode extends BaseTreeNode<nextgen.st.model.STArgumentKV> {

		private String uuid;
		private nextgen.st.model.STArgument stArgument;
		private nextgen.st.model.STParameterKey stParameterKey;

		STKVTreeNode(nextgen.st.model.STArgumentKV model, nextgen.st.model.STArgument stArgument, nextgen.st.model.STParameterKey stParameterKey) {
			super(model, null);

			this.stArgument = stArgument;
			this.stParameterKey = stParameterKey;

			setLabel(stParameterKey.getName());
			this.tooltip = "";
			this.uuid = model.getUuid();

			final nextgen.st.model.STValue stValue = model.getValue();
			if (stValue != null)
				switch (stValue.getType()) {
					case STMODEL:
						add(new STModelKVArgumentTreeNode(stValue.getStModel(), stArgument, stParameterKey));
						break;
					case PRIMITIVE:
						add(new STValueKVArgumentTreeNode(stValue, stArgument, stParameterKey));
						break;
					case ENUM:
						break;
				}
		}

		STKVTreeNode thisNode() {
			return this;
		}

		@Override
		public void nodeChanged() {
			setLabel(stParameterKey.getName());
			this.tooltip = "";
			super.nodeChanged();
		}

		@Override
		protected List<Action> getActions() {
			final List<Action> actions = super.getActions();

			appModel().doInTransaction(tx -> {
				getParentNode(STModelTreeNode.class).ifPresent(parent -> {
					getSelectedSTModels().forEach(stModel -> actions.add(new nextgen.actions.SetKVArgumentFromSTModel(parent.getModel(), stArgument, stParameterKey, stModel)));
					getSelectedSTValues().forEach(stValue -> actions.add(new nextgen.actions.SetKVArgumentFromSTValue(parent.getModel(), stArgument, stParameterKey, stValue)));
					actions.add(new nextgen.actions.SetKVArgumentFromInput(parent.getModel(), stArgument, stParameterKey, tree));
					actions.add(new nextgen.actions.SetKVArgumentFromClipboard(parent.getModel(), stArgument, stParameterKey));
				});
				actions.add(new nextgen.actions.DeleteKV(getModel(), tree));
			});

			return actions;
		}

	}

	private boolean isSTKVTreeNode(Object treeNode) {
		return treeNode instanceof STKVTreeNode;
	}

	private Optional<STKVTreeNode> findSTKVTreeNode() {
		return treeModel.find(STKVTreeNode.class, treeNode -> true);
	}

	private Optional<STKVTreeNode> findSTKVTreeNode(java.util.function.Predicate<STKVTreeNode> predicate) {
		return treeModel.find(STKVTreeNode.class, predicate);
	}

	private Optional<STKVTreeNode> findSTKVTreeNode(BaseTreeNode<?> parent, java.util.function.Predicate<STKVTreeNode> predicate) {
		return treeModel.find(parent, STKVTreeNode.class, predicate);
	}

	private java.util.stream.Stream<STKVTreeNode> getSelectedSTKVTreeNodes() {
		return getSelectedNodes(STKVTreeNode.class);
	}

	private void onSTKVTreeNodeSelected(STKVTreeNode selectedNode) {
	}

	// STModelKVArgumentTreeNode
	public class STModelKVArgumentTreeNode extends BaseTreeNode<nextgen.st.model.STModel> {

		private String uuid;
		private nextgen.st.model.STArgument stArgument;
		private nextgen.st.model.STParameterKey stParameterKey;
		private String stArgumentUuid;
		private nextgen.st.model.STTemplate stTemplate;

		STModelKVArgumentTreeNode(nextgen.st.model.STModel model, nextgen.st.model.STArgument stArgument, nextgen.st.model.STParameterKey stParameterKey) {
			super(model, appModel().loadIcon("sq-teal"));

			this.stArgument = stArgument;
			this.stParameterKey = stParameterKey;
			this.stArgumentUuid = stArgument.getUuid();
			this.stTemplate = model.getStTemplate();

			setLabel(appModel().tryToFindArgument(getModel(), "name", () -> "[" + stParameterKey.getName() + "]"));
			this.tooltip = "";
			this.uuid = model.getUuid();

			stTemplate.getParameters()
					.sorted((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName()))
					.forEach(stParameter -> add(new STParameterTreeNode(stParameter, model)));
		}

		STModelKVArgumentTreeNode thisNode() {
			return this;
		}

		@Override
		public void nodeChanged() {
			setLabel(appModel().tryToFindArgument(getModel(), "name", () -> "[" + stParameterKey.getName() + "]"));
			this.tooltip = "";
			super.nodeChanged();
		}

		@Override
		protected List<Action> getActions() {
			final List<Action> actions = super.getActions();

			appModel().doInTransaction(tx -> {
				getParentNode(STKVTreeNode.class).ifPresent(parent -> actions.add(new nextgen.actions.DeleteKV(parent.getModel(), tree)));
			});

			return actions;
		}

	}

	private boolean isSTModelKVArgumentTreeNode(Object treeNode) {
		return treeNode instanceof STModelKVArgumentTreeNode;
	}

	private Optional<STModelKVArgumentTreeNode> findSTModelKVArgumentTreeNode() {
		return treeModel.find(STModelKVArgumentTreeNode.class, treeNode -> true);
	}

	private Optional<STModelKVArgumentTreeNode> findSTModelKVArgumentTreeNode(java.util.function.Predicate<STModelKVArgumentTreeNode> predicate) {
		return treeModel.find(STModelKVArgumentTreeNode.class, predicate);
	}

	private Optional<STModelKVArgumentTreeNode> findSTModelKVArgumentTreeNode(BaseTreeNode<?> parent, java.util.function.Predicate<STModelKVArgumentTreeNode> predicate) {
		return treeModel.find(parent, STModelKVArgumentTreeNode.class, predicate);
	}

	private java.util.stream.Stream<STModelKVArgumentTreeNode> getSelectedSTModelKVArgumentTreeNodes() {
		return getSelectedNodes(STModelKVArgumentTreeNode.class);
	}

	private void onSTModelKVArgumentTreeNodeSelected(STModelKVArgumentTreeNode selectedNode) {
		nextgen.events.ModelNavigatorSTModelTreeNodeClicked.post(selectedNode.stTemplate, selectedNode.getModel());
	}

	// STValueKVArgumentTreeNode
	public class STValueKVArgumentTreeNode extends BaseTreeNode<nextgen.st.model.STValue> {

		private String uuid;
		private nextgen.st.model.STArgument stArgument;
		private nextgen.st.model.STParameterKey stParameterKey;

		STValueKVArgumentTreeNode(nextgen.st.model.STValue model, nextgen.st.model.STArgument stArgument, nextgen.st.model.STParameterKey stParameterKey) {
			super(model, appModel().loadIcon("sq-orange"));

			this.stArgument = stArgument;
			this.stParameterKey = stParameterKey;

			setLabel(appModel().render(getModel(), 30));
			this.tooltip = "";
			this.uuid = model.getUuid();

		}

		STValueKVArgumentTreeNode thisNode() {
			return this;
		}

		@Override
		public void nodeChanged() {
			setLabel(appModel().render(getModel(), 30));
			this.tooltip = "";
			super.nodeChanged();
		}

		@Override
		protected List<Action> getActions() {
			final List<Action> actions = super.getActions();

			appModel().doInTransaction(tx -> {
				getParentNode(STKVTreeNode.class).ifPresent(parent -> actions.add(new nextgen.actions.DeleteKV(parent.getModel(), tree)));
			});

			return actions;
		}

	}

	private boolean isSTValueKVArgumentTreeNode(Object treeNode) {
		return treeNode instanceof STValueKVArgumentTreeNode;
	}

	private Optional<STValueKVArgumentTreeNode> findSTValueKVArgumentTreeNode() {
		return treeModel.find(STValueKVArgumentTreeNode.class, treeNode -> true);
	}

	private Optional<STValueKVArgumentTreeNode> findSTValueKVArgumentTreeNode(java.util.function.Predicate<STValueKVArgumentTreeNode> predicate) {
		return treeModel.find(STValueKVArgumentTreeNode.class, predicate);
	}

	private Optional<STValueKVArgumentTreeNode> findSTValueKVArgumentTreeNode(BaseTreeNode<?> parent, java.util.function.Predicate<STValueKVArgumentTreeNode> predicate) {
		return treeModel.find(parent, STValueKVArgumentTreeNode.class, predicate);
	}

	private java.util.stream.Stream<STValueKVArgumentTreeNode> getSelectedSTValueKVArgumentTreeNodes() {
		return getSelectedNodes(STValueKVArgumentTreeNode.class);
	}

	private void onSTValueKVArgumentTreeNodeSelected(STValueKVArgumentTreeNode selectedNode) {
		nextgen.events.ModelNavigatorSTValueTreeNodeClicked.post(selectedNode.getModel());
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

	public java.util.stream.Stream<BaseTreeNode> getSelectedNodes() {
		final TreePath[] selectionPaths = tree.getSelectionPaths();
		if (selectionPaths == null || selectionPaths.length == 0) return java.util.stream.Stream.empty();
		return Arrays.stream(selectionPaths)
				.filter(treePath -> treePath.getLastPathComponent() != null)
				.map(treePath -> (BaseTreeNode) treePath.getLastPathComponent());
	}

	private STAppPresentationModel appModel() {
		return nextgen.swing.AppModel.getInstance().getSTAppPresentationModel();
	}

	public java.util.stream.Stream<nextgen.st.model.STModel> getSelectedSTModels() {
		return getSelectedNodes()
				.filter(baseTreeNode -> baseTreeNode.getModel() instanceof nextgen.st.model.STModel)
				.map(baseTreeNode -> (nextgen.st.model.STModel) baseTreeNode.getModel());
	}

	public java.util.stream.Stream<nextgen.st.model.STValue> getSelectedSTValues() {
			return getSelectedNodes()
					.filter(baseTreeNode -> baseTreeNode.getModel() instanceof nextgen.st.model.STValue)
					.map(baseTreeNode -> (nextgen.st.model.STValue) baseTreeNode.getModel());
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

		protected <T extends BaseTreeNode<?>> Optional<T> find(BaseTreeNode<?> parent, Class<T> nodeType, java.util.function.Predicate<T> predicate) {
			return find(parent, navigatorTreeNode -> navigatorTreeNode.getClass()
					.isAssignableFrom(nodeType) && predicate.test((T) navigatorTreeNode));
		}

		private void addNodeInSortedOrderAndSelect(BaseTreeNode<?> parent, BaseTreeNode<?> child) {
			addNodeInSortedOrder(parent, child);
			select(child);
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

		public void select(BaseTreeNode<?> treeNode) {
			tree.scrollPathToVisible(treeNode.getThisPath());
			tree.setSelectionPath(treeNode.getThisPath());
		}
	}
}