package nextgen.swing;


import javax.swing.*;
import javax.swing.tree.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.*;
import java.util.function.Consumer;

public class STTemplateNavigator extends JPanel {

	private final JTree tree = new JTree();
	private final STTemplateNavigatorTreeModel treeModel;

	private STWorkspace workspace;

	public STTemplateNavigator(STWorkspace workspace) {
		super(new BorderLayout());

		this.workspace = workspace;

		treeModel = new STTemplateNavigatorTreeModel(new RootNode("Templates"));
		tree.setModel(treeModel);
		ToolTipManager.sharedInstance().registerComponent(tree);

		tree.setCellRenderer(new STTemplateNavigator.STTemplateNavigatorCellRenderer());
		tree.addKeyListener(new STTemplateNavigator.STTemplateNavigatorKeyListener());
		tree.addMouseListener(new STTemplateNavigator.STTemplateNavigatorMouseListener());

		setPreferredSize(new Dimension(600, 500));
		add(new JScrollPane(tree), BorderLayout.CENTER);

		org.greenrobot.eventbus.EventBus.getDefault().register(this);
	}

	private final class STTemplateNavigatorCellRenderer extends DefaultTreeCellRenderer {
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

	private final class STTemplateNavigatorKeyListener extends KeyAdapter {
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

	private final class STTemplateNavigatorMouseListener extends MouseAdapter {
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
					if (isSTGroupTreeNode(lastPathComponent)) 
						onSTGroupTreeNodeSelected((STGroupTreeNode) lastPathComponent);
					else if (isSTEnumTreeNode(lastPathComponent)) 
						onSTEnumTreeNodeSelected((STEnumTreeNode) lastPathComponent);
					else if (isSTTemplateTreeNode(lastPathComponent)) 
						onSTTemplateTreeNodeSelected((STTemplateTreeNode) lastPathComponent);
					else if (isSTInterfaceTreeNode(lastPathComponent)) 
						onSTInterfaceTreeNodeSelected((STInterfaceTreeNode) lastPathComponent);
					else if (isSTGroupFileTreeNode(lastPathComponent)) 
						onSTGroupFileTreeNodeSelected((STGroupFileTreeNode) lastPathComponent);
					else 
						onUnhandledNodeSelected((BaseTreeNode<?>) lastPathComponent);
            });
         }
      }
   }

   private void onUnhandledNodeSelected(BaseTreeNode<?> selectedNode) {
   }

	@org.greenrobot.eventbus.Subscribe()
	public void onSTGroupFileChanged(nextgen.events.STGroupFileChanged event) {
		findSTGroupFileTreeNode(treeNode -> treeNode.getModel().equals(event.stGroupFile))
				.ifPresent(STTemplateNavigator.STGroupFileTreeNode::nodeChanged);
	}

	@org.greenrobot.eventbus.Subscribe()
	public void onModelNavigatorSTModelTreeNodeClicked(nextgen.events.ModelNavigatorSTModelTreeNodeClicked event) {
		findSTTemplateTreeNode(treeNode -> treeNode.getModel().equals(event.stTemplate))
				.ifPresent(treeModel::select);
	}

	@org.greenrobot.eventbus.Subscribe()
	public void onSTGroupDeleted(nextgen.events.STGroupDeleted event) {
		findSTGroupTreeNode(treeNode -> treeNode.uuid.equals(event.uuid))
				.ifPresent(treeModel::removeNodeFromParent);
	}

	@org.greenrobot.eventbus.Subscribe()
	public void onSTEnumDeleted(nextgen.events.STEnumDeleted event) {
		findSTEnumTreeNode(treeNode -> treeNode.uuid.equals(event.uuid))
				.ifPresent(treeModel::removeNodeFromParent);
	}

	@org.greenrobot.eventbus.Subscribe()
	public void onSTTemplateDeleted(nextgen.events.STTemplateDeleted event) {
		findSTTemplateTreeNode(treeNode -> treeNode.uuid.equals(event.uuid))
				.ifPresent(treeModel::removeNodeFromParent);
	}

	@org.greenrobot.eventbus.Subscribe()
	public void onSTInterfaceDeleted(nextgen.events.STInterfaceDeleted event) {
		findSTInterfaceTreeNode(treeNode -> treeNode.uuid.equals(event.uuid))
				.ifPresent(treeModel::removeNodeFromParent);
	}

	@org.greenrobot.eventbus.Subscribe()
	public void onNewSTGroup(nextgen.events.NewSTGroup event) {
		treeModel.addNodeInSortedOrderAndSelect((RootNode) treeModel.getRoot(), new STTemplateNavigator.STGroupTreeNode(event.group));
	}

	@org.greenrobot.eventbus.Subscribe()
	public void onNewSTEnum(nextgen.events.NewSTEnum event) {
		findSTGroupTreeNode(treeNode -> treeNode.getModel().equals(event.stGroup))
							.ifPresent(treeNode -> treeModel.addNodeInSortedOrderAndSelect(treeNode, new STTemplateNavigator.STEnumTreeNode(event.stEnum)));
	}

	@org.greenrobot.eventbus.Subscribe()
	public void onNewSTInterface(nextgen.events.NewSTInterface event) {
		findSTGroupTreeNode(treeNode -> treeNode.getModel().equals(event.stGroup))
							.ifPresent(treeNode -> treeModel.addNodeInSortedOrderAndSelect(treeNode, new STTemplateNavigator.STInterfaceTreeNode(event.stInterface)));
	}

	@org.greenrobot.eventbus.Subscribe()
	public void onNewSTGroupTemplate(nextgen.events.NewSTGroupTemplate event) {
		findSTGroupTreeNode(treeNode -> treeNode.getModel().equals(event.parent))
							.ifPresent(treeNode -> treeModel.addNodeInSortedOrderAndSelect(treeNode, new STTemplateNavigator.STTemplateTreeNode(event.template)));
	}

	@org.greenrobot.eventbus.Subscribe()
	public void onNewSTTemplateChild(nextgen.events.NewSTTemplateChild event) {
		findSTTemplateTreeNode(treeNode -> treeNode.getModel().equals(event.parent))
							.ifPresent(treeNode -> treeModel.addNodeInSortedOrderAndSelect(treeNode, new STTemplateNavigator.STTemplateTreeNode(event.template)));
	}

	@org.greenrobot.eventbus.Subscribe()
	public void onSTGroupNameChanged(nextgen.events.STGroupNameChanged event) {
		findSTGroupTreeNode(treeNode -> treeNode.getModel().equals(event.stGroup))
							.ifPresent(STTemplateNavigator.STGroupTreeNode::nodeChanged);
	}

	@org.greenrobot.eventbus.Subscribe()
	public void onSTTemplateNameChanged(nextgen.events.STTemplateNameChanged event) {
		findSTTemplateTreeNode(treeNode -> treeNode.getModel().equals(event.stTemplate))
							.ifPresent(STTemplateNavigator.STTemplateTreeNode::nodeChanged);
	}

	@org.greenrobot.eventbus.Subscribe()
	public void onSTInterfaceNameChanged(nextgen.events.STInterfaceNameChanged event) {
		findSTInterfaceTreeNode(treeNode -> treeNode.getModel().equals(event.stInterface))
							.ifPresent(STTemplateNavigator.STInterfaceTreeNode::nodeChanged);
	}

	@org.greenrobot.eventbus.Subscribe()
	public void onSTEnumNameChanged(nextgen.events.STEnumNameChanged event) {
		findSTEnumTreeNode(treeNode -> treeNode.getModel().equals(event.stEnum))
							.ifPresent(STTemplateNavigator.STEnumTreeNode::nodeChanged);
	}

	@org.greenrobot.eventbus.Subscribe()
	public void onNewSTGroupFile(nextgen.events.NewSTGroupFile event) {
		findSTGroupTreeNode(stGroupTreeNode -> stGroupTreeNode.getModel().equals(event.stGroupModel))
				.ifPresent(stGroupTreeNode -> treeModel.addNodeInSortedOrderAndSelect(stGroupTreeNode, new STTemplateNavigator.STGroupFileTreeNode(event.stGroupFile)));
	}

	@org.greenrobot.eventbus.Subscribe()
	public void onSTGroupFileDeleted(nextgen.events.STGroupFileDeleted event) {
		findSTGroupFileTreeNode(treeNode -> treeNode.uuid.equals(event.uuid)).ifPresent(treeModel::removeNodeFromParent);
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

			appModel().db.findAllSTGroupModel().sorted((g1,g2) -> g1.getName().compareToIgnoreCase(g2.getName())).forEach(stGroup -> add(new STGroupTreeNode(stGroup)));
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
				actions.add(new nextgen.actions.NewSTGroupAction(tree));
				actions.add(new nextgen.actions.GenerateAllSTGroups());
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

	// STGroupTreeNode
	public class STGroupTreeNode extends BaseTreeNode<nextgen.st.model.STGroupModel> {

		private String uuid;

		STGroupTreeNode(nextgen.st.model.STGroupModel model) {
			super(model, null);


			setLabel(getModel().getName());
			this.tooltip = "";
			this.uuid = model.getUuid();

			model.getFilesSorted().forEach(file -> add(new STGroupFileTreeNode(file)));
			model.getEnums().sorted((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName())).forEach(stEnum -> add(new STEnumTreeNode(stEnum)));
			model.getTemplates().sorted((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName())).forEach(stTemplate -> add(new STTemplateTreeNode(stTemplate)));
			model.getInterfaces().sorted((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName())).forEach(stInterface -> add(new STInterfaceTreeNode(stInterface)));
		}

		STGroupTreeNode thisNode() {
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
				actions.add(new nextgen.actions.EditSTGroupTags(getModel(), tree));
				actions.add(new nextgen.actions.ImportSTTemplate(getModel(), tree));
				actions.add(new nextgen.actions.GenerateSTGroup(getModel()));
				actions.add(new nextgen.actions.GenerateSTGroupAndNeo(getModel()));
				actions.add(new nextgen.actions.NewSTTemplate(getModel(), tree));
				actions.add(new nextgen.actions.NewEnum(getModel(), tree));
				actions.add(new nextgen.actions.NewInterface(getModel(), tree));
				actions.add(new nextgen.actions.RenameSTGroup(getModel(), tree));
				actions.add(new nextgen.actions.DeleteSTGroup(getModel(), tree));
				actions.add(new nextgen.actions.AddFileSinkToGroup(getModel()));
			});

			return actions;
		}

	}

	private boolean isSTGroupTreeNode(Object treeNode) {
		return treeNode instanceof STGroupTreeNode;
	}

	private Optional<STGroupTreeNode> findSTGroupTreeNode() {
		return treeModel.find(STGroupTreeNode.class, treeNode -> true);
	}

	private Optional<STGroupTreeNode> findSTGroupTreeNode(java.util.function.Predicate<STGroupTreeNode> predicate) {
		return treeModel.find(STGroupTreeNode.class, predicate);
	}

	private Optional<STGroupTreeNode> findSTGroupTreeNode(BaseTreeNode<?> parent, java.util.function.Predicate<STGroupTreeNode> predicate) {
		return treeModel.find(parent, STGroupTreeNode.class, predicate);
	}

	private java.util.stream.Stream<STGroupTreeNode> getSelectedSTGroupTreeNodes() {
		return getSelectedNodes(STGroupTreeNode.class);
	}

	private void onSTGroupTreeNodeSelected(STGroupTreeNode selectedNode) {
		nextgen.events.TemplateNavigatorSTGroupTreeNodeClicked.post(selectedNode.getModel());
	}

	// STEnumTreeNode
	public class STEnumTreeNode extends BaseTreeNode<nextgen.st.model.STEnum> {

		private String uuid;

		STEnumTreeNode(nextgen.st.model.STEnum model) {
			super(model, appModel().loadIcon("sq-green"));


			setLabel(getModel().getName());
			this.tooltip = "";
			this.uuid = model.getUuid();

		}

		STEnumTreeNode thisNode() {
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
				getParentNode(STGroupTreeNode.class).ifPresent(parent -> actions.add(new nextgen.actions.RenameEnum(getModel(), parent.getModel(), tree)));
				getParentNode(STGroupTreeNode.class).ifPresent(parent -> actions.add(new nextgen.actions.DeleteEnum(getModel(), parent.getModel(), tree)));
				actions.add(new nextgen.actions.EditEnum(getModel(), tree));
			});

			return actions;
		}

	}

	private boolean isSTEnumTreeNode(Object treeNode) {
		return treeNode instanceof STEnumTreeNode;
	}

	private Optional<STEnumTreeNode> findSTEnumTreeNode() {
		return treeModel.find(STEnumTreeNode.class, treeNode -> true);
	}

	private Optional<STEnumTreeNode> findSTEnumTreeNode(java.util.function.Predicate<STEnumTreeNode> predicate) {
		return treeModel.find(STEnumTreeNode.class, predicate);
	}

	private Optional<STEnumTreeNode> findSTEnumTreeNode(BaseTreeNode<?> parent, java.util.function.Predicate<STEnumTreeNode> predicate) {
		return treeModel.find(parent, STEnumTreeNode.class, predicate);
	}

	private java.util.stream.Stream<STEnumTreeNode> getSelectedSTEnumTreeNodes() {
		return getSelectedNodes(STEnumTreeNode.class);
	}

	private void onSTEnumTreeNodeSelected(STEnumTreeNode selectedNode) {
		selectedNode.getParentNode(STGroupTreeNode.class).ifPresent(stGroupTreeNode -> { nextgen.events.TemplateNavigatorSTEnumTreeNodeClicked.post(stGroupTreeNode.getModel(), selectedNode.getModel()); });
	}

	// STTemplateTreeNode
	public class STTemplateTreeNode extends BaseTreeNode<nextgen.st.model.STTemplate> {

		private String uuid;

		STTemplateTreeNode(nextgen.st.model.STTemplate model) {
			super(model, appModel().loadIcon("sq-teal"));


			setLabel(getModel().getName());
			this.tooltip = "";
			this.uuid = model.getUuid();

			model.getChildren().sorted((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName())).forEach(stTemplate -> add(new STTemplateTreeNode(stTemplate)));
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
				final java.util.Set<nextgen.st.model.STTemplate> candidateChildren = getSelectedTemplates();
				final Set<nextgen.st.model.STTemplate> childTemplates = getModel().getChildren().collect(java.util.stream.Collectors.toSet());
				actions.add(new nextgen.actions.NewSTModelAction(getModel()));
				getParentNode(STGroupTreeNode.class).ifPresent(parent -> { 
					actions.add(new nextgen.actions.AddChildToTemplate(getModel(), parent.getModel(), tree));
					actions.add(new nextgen.actions.SetTemplateParameterTypes(parent.getModel(), getModel(), tree));
					if (!candidateChildren.isEmpty()) actions.add(new nextgen.actions.AddChildrenToTemplate("Add " + candidateChildren.size() + " templates as children", parent.getModel(), getModel(), candidateChildren, tree));
					appModel().getProjects().forEach(stProject -> actions.add(new nextgen.actions.AddTemplateModelToProject("Add to " + stProject.getName(), getModel(), stProject)));
					if (!childTemplates.isEmpty()) actions.add(new nextgen.actions.AddInterface("Add interfaces to children", childTemplates, tree));
					actions.add(new nextgen.actions.SetInterfaces(parent.getModel(), getModel(), tree));
					getModel().getImplements().forEach(implement -> actions.add(new nextgen.actions.RemoveInterfaceFromSTTemplate("Remove " + implement, parent.getModel(), getModel(), implement, tree)));
					actions.add(new nextgen.actions.RenameSTTemplate(getModel(), parent.getModel(), tree));
				});
				actions.add(new nextgen.actions.DeleteSTTemplate(getModel(), tree));
			});

			return actions;
		}

		private java.util.Set<nextgen.st.model.STTemplate> getSelectedTemplates() {
					return getSelectedSTTemplateTreeNodes()
							.filter(stTemplateTreeNode -> !stTemplateTreeNode.equals(this))
							.map(STTemplateNavigator.BaseTreeNode::getModel)
							.collect(java.util.stream.Collectors.toSet());
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
		selectedNode.getParentNode(STGroupTreeNode.class).ifPresent(parent -> { 
			final STTemplateNavigator.STTemplateTreeNode stTemplateTreeNode = selectedNode.getParentNode(STTemplateNavigator.STTemplateTreeNode.class).orElse(null);
			nextgen.events.TemplateNavigatorSTTemplateTreeNodeClicked.post(parent.getModel(), stTemplateTreeNode == null ? null : stTemplateTreeNode.getModel(), selectedNode.getModel());
		});
	}

	// STInterfaceTreeNode
	public class STInterfaceTreeNode extends BaseTreeNode<nextgen.st.model.STInterface> {

		private String uuid;

		STInterfaceTreeNode(nextgen.st.model.STInterface model) {
			super(model, appModel().loadIcon("sq-purple"));


			setLabel(getModel().getName());
			this.tooltip = "";
			this.uuid = model.getUuid();

		}

		STInterfaceTreeNode thisNode() {
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
				getParentNode(STGroupTreeNode.class).ifPresent(parent -> actions.add(new nextgen.actions.RenameSTInterface(getModel(), parent.getModel(), tree)));
				getParentNode(STGroupTreeNode.class).ifPresent(parent -> actions.add(new nextgen.actions.DeleteSTInterface(getModel(), parent.getModel(), tree)));
			});

			return actions;
		}

	}

	private boolean isSTInterfaceTreeNode(Object treeNode) {
		return treeNode instanceof STInterfaceTreeNode;
	}

	private Optional<STInterfaceTreeNode> findSTInterfaceTreeNode() {
		return treeModel.find(STInterfaceTreeNode.class, treeNode -> true);
	}

	private Optional<STInterfaceTreeNode> findSTInterfaceTreeNode(java.util.function.Predicate<STInterfaceTreeNode> predicate) {
		return treeModel.find(STInterfaceTreeNode.class, predicate);
	}

	private Optional<STInterfaceTreeNode> findSTInterfaceTreeNode(BaseTreeNode<?> parent, java.util.function.Predicate<STInterfaceTreeNode> predicate) {
		return treeModel.find(parent, STInterfaceTreeNode.class, predicate);
	}

	private java.util.stream.Stream<STInterfaceTreeNode> getSelectedSTInterfaceTreeNodes() {
		return getSelectedNodes(STInterfaceTreeNode.class);
	}

	private void onSTInterfaceTreeNodeSelected(STInterfaceTreeNode selectedNode) {
	}

	// STGroupFileTreeNode
	public class STGroupFileTreeNode extends BaseTreeNode<nextgen.st.model.STGroupFile> {

		private String uuid;

		STGroupFileTreeNode(nextgen.st.model.STGroupFile model) {
			super(model, null);


			setLabel(getModel().getPath());
			this.tooltip = "";
			this.uuid = model.getUuid();

		}

		STGroupFileTreeNode thisNode() {
			return this;
		}

		@Override
		public void nodeChanged() {
			setLabel(getModel().getPath());
			this.tooltip = "";
			super.nodeChanged();
		}

		@Override
		protected List<Action> getActions() {
			final List<Action> actions = super.getActions();

			appModel().doInTransaction(tx -> {
				getParentNode(STGroupTreeNode.class).ifPresent(parent -> actions.add(new nextgen.actions.GenerateSTGroupFromFile(parent.getModel(), getModel(), tree)));
				actions.add(new nextgen.actions.DeleteSTGroupFile(getModel(), tree));
			});

			return actions;
		}

	}

	private boolean isSTGroupFileTreeNode(Object treeNode) {
		return treeNode instanceof STGroupFileTreeNode;
	}

	private Optional<STGroupFileTreeNode> findSTGroupFileTreeNode() {
		return treeModel.find(STGroupFileTreeNode.class, treeNode -> true);
	}

	private Optional<STGroupFileTreeNode> findSTGroupFileTreeNode(java.util.function.Predicate<STGroupFileTreeNode> predicate) {
		return treeModel.find(STGroupFileTreeNode.class, predicate);
	}

	private Optional<STGroupFileTreeNode> findSTGroupFileTreeNode(BaseTreeNode<?> parent, java.util.function.Predicate<STGroupFileTreeNode> predicate) {
		return treeModel.find(parent, STGroupFileTreeNode.class, predicate);
	}

	private java.util.stream.Stream<STGroupFileTreeNode> getSelectedSTGroupFileTreeNodes() {
		return getSelectedNodes(STGroupFileTreeNode.class);
	}

	private void onSTGroupFileTreeNodeSelected(STGroupFileTreeNode selectedNode) {
		nextgen.events.TemplateNavigatorSTGroupFileClicked.post(selectedNode.getModel());
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

	public java.util.stream.Stream<nextgen.st.model.STTemplate> getSelectedSTTemplates() {
		return getSelectedNodes()
				.filter(baseTreeNode -> baseTreeNode.getModel() instanceof nextgen.st.model.STTemplate)
				.map(baseTreeNode -> (nextgen.st.model.STTemplate) baseTreeNode.getModel());
	}

	class STTemplateNavigatorTreeModel extends DefaultTreeModel {

		public STTemplateNavigatorTreeModel(BaseTreeNode root) {
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