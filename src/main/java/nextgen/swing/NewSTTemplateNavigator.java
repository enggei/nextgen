package nextgen.swing;

import nextgen.actions.*;

import javax.swing.*;
import javax.swing.tree.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.*;
import java.util.function.Consumer;

public class NewSTTemplateNavigator extends JPanel {

	private final JTree tree = new JTree();
	private final NewSTTemplateNavigatorTreeModel treeModel;


	public NewSTTemplateNavigator() {
		super(new BorderLayout());


		treeModel = new NewSTTemplateNavigatorTreeModel(new RootNode("[]"));
		tree.setModel(treeModel);
		ToolTipManager.sharedInstance().registerComponent(tree);

		tree.setCellRenderer(new NewSTTemplateNavigatorCellRenderer());
		tree.addKeyListener(new NewSTTemplateNavigatorKeyListener());
		tree.addMouseListener(new NewSTTemplateNavigatorMouseListener());

		setPreferredSize(new Dimension(400, 600));
		add(new JScrollPane(tree), BorderLayout.CENTER);

		org.greenrobot.eventbus.EventBus.getDefault().register(this);
	}

	private final class NewSTTemplateNavigatorCellRenderer extends DefaultTreeCellRenderer {
		@Override
		public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {

			final BaseTreeNode<?> node = (BaseTreeNode<?>) value;
			final ImageIcon icon = node.getIcon();
			setIcon(icon);
			setOpenIcon(icon);
			setClosedIcon(icon);
			setLeafIcon(icon);
			setToolTipText(node.getTooltip());
			return ComponentFactory.decorate(super.getTreeCellRendererComponent(tree, node.getLabel(), sel, expanded, leaf, row, hasFocus));
		}
	}

	private final class NewSTTemplateNavigatorKeyListener extends KeyAdapter {
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

	private final class NewSTTemplateNavigatorMouseListener extends MouseAdapter {
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
						onUnhandledNodeSelected((BaseTreeNode<?>) lastPathComponent);
				});
			}
		}
	}

	private void onUnhandledNodeSelected(BaseTreeNode<?> selectedNode) {
	}

	@org.greenrobot.eventbus.Subscribe()
	public void onSTGroupModelDeleted(nextgen.events.STGroupModelDeleted event) {
		findAllSTGroupModelTreeNode(treeNode -> treeNode.uuid.equals(event.uuid)).forEach(treeModel::removeNodeFromParent);
	}  

	@org.greenrobot.eventbus.Subscribe()
	public void onSTGroupFileDeleted(nextgen.events.STGroupFileDeleted event) {
		findAllSTGroupFileTreeNode(treeNode -> treeNode.uuid.equals(event.uuid)).forEach(treeModel::removeNodeFromParent);
	}  

	@org.greenrobot.eventbus.Subscribe()
	public void onSTTemplateDeleted(nextgen.events.STTemplateDeleted event) {
		findAllSTTemplateTreeNode(treeNode -> treeNode.uuid.equals(event.uuid)).forEach(treeModel::removeNodeFromParent);
	}  

	@org.greenrobot.eventbus.Subscribe()
	public void onSTInterfaceDeleted(nextgen.events.STInterfaceDeleted event) {
		findAllSTInterfaceTreeNode(treeNode -> treeNode.uuid.equals(event.uuid)).forEach(treeModel::removeNodeFromParent);
	}  

	@org.greenrobot.eventbus.Subscribe()
	public void onSTEnumDeleted(nextgen.events.STEnumDeleted event) {
		findAllSTEnumTreeNode(treeNode -> treeNode.uuid.equals(event.uuid)).forEach(treeModel::removeNodeFromParent);
	}  

	@org.greenrobot.eventbus.Subscribe()
	public void onSTGroupActionDeleted(nextgen.events.STGroupActionDeleted event) {
		findAllSTGroupActionTreeNode(treeNode -> treeNode.uuid.equals(event.uuid)).forEach(treeModel::removeNodeFromParent);
	}  

	@org.greenrobot.eventbus.Subscribe()
	public void onSTParameterDeleted(nextgen.events.STParameterDeleted event) {
		findAllSTParameterTreeNode(treeNode -> treeNode.uuid.equals(event.uuid)).forEach(treeModel::removeNodeFromParent);
	}  

	@org.greenrobot.eventbus.Subscribe()
	public void onSTEnumValueDeleted(nextgen.events.STEnumValueDeleted event) {
		findAllSTEnumValueTreeNode(treeNode -> treeNode.uuid.equals(event.uuid)).forEach(treeModel::removeNodeFromParent);
	}  

	@org.greenrobot.eventbus.Subscribe()
	public void onSTParameterKeyDeleted(nextgen.events.STParameterKeyDeleted event) {
		findAllSTParameterKeyTreeNode(treeNode -> treeNode.uuid.equals(event.uuid)).forEach(treeModel::removeNodeFromParent);
	}  

	@org.greenrobot.eventbus.Subscribe()
	public void onDomainDeleted(nextgen.events.DomainDeleted event) {
		findAllDomainTreeNode(treeNode -> treeNode.uuid.equals(event.uuid)).forEach(treeModel::removeNodeFromParent);
	}  

	@org.greenrobot.eventbus.Subscribe()
	public void onDomainEntityDeleted(nextgen.events.DomainEntityDeleted event) {
		findAllDomainEntityTreeNode(treeNode -> treeNode.uuid.equals(event.uuid)).forEach(treeModel::removeNodeFromParent);
	}  

	@org.greenrobot.eventbus.Subscribe()
	public void onDomainRelationDeleted(nextgen.events.DomainRelationDeleted event) {
		findAllDomainRelationTreeNode(treeNode -> treeNode.uuid.equals(event.uuid)).forEach(treeModel::removeNodeFromParent);
	}  

	@org.greenrobot.eventbus.Subscribe()
	public void onDomainVisitorDeleted(nextgen.events.DomainVisitorDeleted event) {
		findAllDomainVisitorTreeNode(treeNode -> treeNode.uuid.equals(event.uuid)).forEach(treeModel::removeNodeFromParent);
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

		public <T> T getParentModel() {

			final TreeNode parent = getParent();
			if (!(parent instanceof BaseTreeNode)) return null;

			return (T) ((BaseTreeNode<T>) parent).getModel();
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
			System.out.println("nodeChanged");
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
			super(model, appModel().loadIcon("String"));


			setLabel(model.toString());
			this.tooltip = "";

		}

		RootNode thisNode() {
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

			appModel().doInTransaction(tx -> {
				actions.add(new GenerateAllSTGroups(tree));
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

	private java.util.Collection<RootNode> findAllRootNode() {
		return treeModel.findAll(RootNode.class, treeNode -> true);
	}

	private java.util.Collection<RootNode> findAllRootNode(BaseTreeNode<?> parent) {
		return parent.getChildren(RootNode.class).collect(java.util.stream.Collectors.toList());
	}

	private Optional<RootNode> findRootNode(java.util.function.Predicate<RootNode> predicate) {
		return treeModel.find(RootNode.class, predicate);
	}

	private java.util.Collection<RootNode> findAllRootNode(java.util.function.Predicate<RootNode> predicate) {
		return treeModel.findAll(RootNode.class, predicate);
	}

	private Optional<RootNode> findRootNode(BaseTreeNode<?> parent, java.util.function.Predicate<RootNode> predicate) {
		return treeModel.find(parent, RootNode.class, predicate);
	}

	private java.util.stream.Stream<RootNode> getSelectedRootNodes() {
		return getSelectedNodes(RootNode.class);
	}

	private void onRootNodeSelected(RootNode selectedNode) {
	}  

	// TemplatesTreeNode
	public class TemplatesTreeNode extends BaseTreeNode<String> {

		TemplatesTreeNode(String model) {
			super(model, appModel().loadIcon("String"));


			setLabel(model.toString());
			this.tooltip = "";

		}

		TemplatesTreeNode thisNode() {
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

			appModel().doInTransaction(tx -> {
				actions.add(new NewSTGroupAction(tree));
				actions.add(new GenerateAllSTGroups(tree));
			});

			return actions;
		}

	}

	private boolean isTemplatesTreeNode(Object treeNode) {
		return treeNode instanceof TemplatesTreeNode;
	}

	private Optional<TemplatesTreeNode> findTemplatesTreeNode() {
		return treeModel.find(TemplatesTreeNode.class, treeNode -> true);
	}

	private java.util.Collection<TemplatesTreeNode> findAllTemplatesTreeNode() {
		return treeModel.findAll(TemplatesTreeNode.class, treeNode -> true);
	}

	private java.util.Collection<TemplatesTreeNode> findAllTemplatesTreeNode(BaseTreeNode<?> parent) {
		return parent.getChildren(TemplatesTreeNode.class).collect(java.util.stream.Collectors.toList());
	}

	private Optional<TemplatesTreeNode> findTemplatesTreeNode(java.util.function.Predicate<TemplatesTreeNode> predicate) {
		return treeModel.find(TemplatesTreeNode.class, predicate);
	}

	private java.util.Collection<TemplatesTreeNode> findAllTemplatesTreeNode(java.util.function.Predicate<TemplatesTreeNode> predicate) {
		return treeModel.findAll(TemplatesTreeNode.class, predicate);
	}

	private Optional<TemplatesTreeNode> findTemplatesTreeNode(BaseTreeNode<?> parent, java.util.function.Predicate<TemplatesTreeNode> predicate) {
		return treeModel.find(parent, TemplatesTreeNode.class, predicate);
	}

	private java.util.stream.Stream<TemplatesTreeNode> getSelectedTemplatesTreeNodes() {
		return getSelectedNodes(TemplatesTreeNode.class);
	}

	private void onTemplatesTreeNodeSelected(TemplatesTreeNode selectedNode) {
	}  

	// DomainsTreeNode
	public class DomainsTreeNode extends BaseTreeNode<String> {

		DomainsTreeNode(String model) {
			super(model, appModel().loadIcon("String"));


			setLabel(model.toString());
			this.tooltip = "";

		}

		DomainsTreeNode thisNode() {
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

			appModel().doInTransaction(tx -> {
			});

			return actions;
		}

	}

	private boolean isDomainsTreeNode(Object treeNode) {
		return treeNode instanceof DomainsTreeNode;
	}

	private Optional<DomainsTreeNode> findDomainsTreeNode() {
		return treeModel.find(DomainsTreeNode.class, treeNode -> true);
	}

	private java.util.Collection<DomainsTreeNode> findAllDomainsTreeNode() {
		return treeModel.findAll(DomainsTreeNode.class, treeNode -> true);
	}

	private java.util.Collection<DomainsTreeNode> findAllDomainsTreeNode(BaseTreeNode<?> parent) {
		return parent.getChildren(DomainsTreeNode.class).collect(java.util.stream.Collectors.toList());
	}

	private Optional<DomainsTreeNode> findDomainsTreeNode(java.util.function.Predicate<DomainsTreeNode> predicate) {
		return treeModel.find(DomainsTreeNode.class, predicate);
	}

	private java.util.Collection<DomainsTreeNode> findAllDomainsTreeNode(java.util.function.Predicate<DomainsTreeNode> predicate) {
		return treeModel.findAll(DomainsTreeNode.class, predicate);
	}

	private Optional<DomainsTreeNode> findDomainsTreeNode(BaseTreeNode<?> parent, java.util.function.Predicate<DomainsTreeNode> predicate) {
		return treeModel.find(parent, DomainsTreeNode.class, predicate);
	}

	private java.util.stream.Stream<DomainsTreeNode> getSelectedDomainsTreeNodes() {
		return getSelectedNodes(DomainsTreeNode.class);
	}

	private void onDomainsTreeNodeSelected(DomainsTreeNode selectedNode) {
	}  

	// STGroupModelTreeNode
	public class STGroupModelTreeNode extends BaseTreeNode<nextgen.model.STGroupModel> {

		private String uuid;

		STGroupModelTreeNode(nextgen.model.STGroupModel model) {
			super(model, appModel().loadIcon("nextgen.model.STGroupModel"));


			setLabel(model.toString());
			this.tooltip = "";
			this.uuid = model.getUuid();

		}

		STGroupModelTreeNode thisNode() {
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

	private java.util.Collection<STGroupModelTreeNode> findAllSTGroupModelTreeNode() {
		return treeModel.findAll(STGroupModelTreeNode.class, treeNode -> true);
	}

	private java.util.Collection<STGroupModelTreeNode> findAllSTGroupModelTreeNode(BaseTreeNode<?> parent) {
		return parent.getChildren(STGroupModelTreeNode.class).collect(java.util.stream.Collectors.toList());
	}

	private Optional<STGroupModelTreeNode> findSTGroupModelTreeNode(java.util.function.Predicate<STGroupModelTreeNode> predicate) {
		return treeModel.find(STGroupModelTreeNode.class, predicate);
	}

	private java.util.Collection<STGroupModelTreeNode> findAllSTGroupModelTreeNode(java.util.function.Predicate<STGroupModelTreeNode> predicate) {
		return treeModel.findAll(STGroupModelTreeNode.class, predicate);
	}

	private Optional<STGroupModelTreeNode> findSTGroupModelTreeNode(BaseTreeNode<?> parent, java.util.function.Predicate<STGroupModelTreeNode> predicate) {
		return treeModel.find(parent, STGroupModelTreeNode.class, predicate);
	}

	private java.util.stream.Stream<STGroupModelTreeNode> getSelectedSTGroupModelTreeNodes() {
		return getSelectedNodes(STGroupModelTreeNode.class);
	}

	private void onSTGroupModelTreeNodeSelected(STGroupModelTreeNode selectedNode) {
	}  

	// STGroupFileTreeNode
	public class STGroupFileTreeNode extends BaseTreeNode<nextgen.model.STGroupFile> {

		private String uuid;

		STGroupFileTreeNode(nextgen.model.STGroupFile model) {
			super(model, appModel().loadIcon("nextgen.model.STGroupFile"));


			setLabel(model.toString());
			this.tooltip = "";
			this.uuid = model.getUuid();

		}

		STGroupFileTreeNode thisNode() {
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

			appModel().doInTransaction(tx -> {
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

	private java.util.Collection<STGroupFileTreeNode> findAllSTGroupFileTreeNode() {
		return treeModel.findAll(STGroupFileTreeNode.class, treeNode -> true);
	}

	private java.util.Collection<STGroupFileTreeNode> findAllSTGroupFileTreeNode(BaseTreeNode<?> parent) {
		return parent.getChildren(STGroupFileTreeNode.class).collect(java.util.stream.Collectors.toList());
	}

	private Optional<STGroupFileTreeNode> findSTGroupFileTreeNode(java.util.function.Predicate<STGroupFileTreeNode> predicate) {
		return treeModel.find(STGroupFileTreeNode.class, predicate);
	}

	private java.util.Collection<STGroupFileTreeNode> findAllSTGroupFileTreeNode(java.util.function.Predicate<STGroupFileTreeNode> predicate) {
		return treeModel.findAll(STGroupFileTreeNode.class, predicate);
	}

	private Optional<STGroupFileTreeNode> findSTGroupFileTreeNode(BaseTreeNode<?> parent, java.util.function.Predicate<STGroupFileTreeNode> predicate) {
		return treeModel.find(parent, STGroupFileTreeNode.class, predicate);
	}

	private java.util.stream.Stream<STGroupFileTreeNode> getSelectedSTGroupFileTreeNodes() {
		return getSelectedNodes(STGroupFileTreeNode.class);
	}

	private void onSTGroupFileTreeNodeSelected(STGroupFileTreeNode selectedNode) {
	}  

	// STTemplateTreeNode
	public class STTemplateTreeNode extends BaseTreeNode<nextgen.model.STTemplate> {

		private String uuid;

		STTemplateTreeNode(nextgen.model.STTemplate model) {
			super(model, appModel().loadIcon("nextgen.model.STTemplate"));


			setLabel(model.toString());
			this.tooltip = "";
			this.uuid = model.getUuid();

		}

		STTemplateTreeNode thisNode() {
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

			appModel().doInTransaction(tx -> {
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

	private java.util.Collection<STTemplateTreeNode> findAllSTTemplateTreeNode() {
		return treeModel.findAll(STTemplateTreeNode.class, treeNode -> true);
	}

	private java.util.Collection<STTemplateTreeNode> findAllSTTemplateTreeNode(BaseTreeNode<?> parent) {
		return parent.getChildren(STTemplateTreeNode.class).collect(java.util.stream.Collectors.toList());
	}

	private Optional<STTemplateTreeNode> findSTTemplateTreeNode(java.util.function.Predicate<STTemplateTreeNode> predicate) {
		return treeModel.find(STTemplateTreeNode.class, predicate);
	}

	private java.util.Collection<STTemplateTreeNode> findAllSTTemplateTreeNode(java.util.function.Predicate<STTemplateTreeNode> predicate) {
		return treeModel.findAll(STTemplateTreeNode.class, predicate);
	}

	private Optional<STTemplateTreeNode> findSTTemplateTreeNode(BaseTreeNode<?> parent, java.util.function.Predicate<STTemplateTreeNode> predicate) {
		return treeModel.find(parent, STTemplateTreeNode.class, predicate);
	}

	private java.util.stream.Stream<STTemplateTreeNode> getSelectedSTTemplateTreeNodes() {
		return getSelectedNodes(STTemplateTreeNode.class);
	}

	private void onSTTemplateTreeNodeSelected(STTemplateTreeNode selectedNode) {
	}  

	// STInterfaceTreeNode
	public class STInterfaceTreeNode extends BaseTreeNode<nextgen.model.STInterface> {

		private String uuid;

		STInterfaceTreeNode(nextgen.model.STInterface model) {
			super(model, appModel().loadIcon("nextgen.model.STInterface"));


			setLabel(model.toString());
			this.tooltip = "";
			this.uuid = model.getUuid();

		}

		STInterfaceTreeNode thisNode() {
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

			appModel().doInTransaction(tx -> {
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

	private java.util.Collection<STInterfaceTreeNode> findAllSTInterfaceTreeNode() {
		return treeModel.findAll(STInterfaceTreeNode.class, treeNode -> true);
	}

	private java.util.Collection<STInterfaceTreeNode> findAllSTInterfaceTreeNode(BaseTreeNode<?> parent) {
		return parent.getChildren(STInterfaceTreeNode.class).collect(java.util.stream.Collectors.toList());
	}

	private Optional<STInterfaceTreeNode> findSTInterfaceTreeNode(java.util.function.Predicate<STInterfaceTreeNode> predicate) {
		return treeModel.find(STInterfaceTreeNode.class, predicate);
	}

	private java.util.Collection<STInterfaceTreeNode> findAllSTInterfaceTreeNode(java.util.function.Predicate<STInterfaceTreeNode> predicate) {
		return treeModel.findAll(STInterfaceTreeNode.class, predicate);
	}

	private Optional<STInterfaceTreeNode> findSTInterfaceTreeNode(BaseTreeNode<?> parent, java.util.function.Predicate<STInterfaceTreeNode> predicate) {
		return treeModel.find(parent, STInterfaceTreeNode.class, predicate);
	}

	private java.util.stream.Stream<STInterfaceTreeNode> getSelectedSTInterfaceTreeNodes() {
		return getSelectedNodes(STInterfaceTreeNode.class);
	}

	private void onSTInterfaceTreeNodeSelected(STInterfaceTreeNode selectedNode) {
	}  

	// STEnumTreeNode
	public class STEnumTreeNode extends BaseTreeNode<nextgen.model.STEnum> {

		private String uuid;

		STEnumTreeNode(nextgen.model.STEnum model) {
			super(model, appModel().loadIcon("nextgen.model.STEnum"));


			setLabel(model.toString());
			this.tooltip = "";
			this.uuid = model.getUuid();

		}

		STEnumTreeNode thisNode() {
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

			appModel().doInTransaction(tx -> {
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

	private java.util.Collection<STEnumTreeNode> findAllSTEnumTreeNode() {
		return treeModel.findAll(STEnumTreeNode.class, treeNode -> true);
	}

	private java.util.Collection<STEnumTreeNode> findAllSTEnumTreeNode(BaseTreeNode<?> parent) {
		return parent.getChildren(STEnumTreeNode.class).collect(java.util.stream.Collectors.toList());
	}

	private Optional<STEnumTreeNode> findSTEnumTreeNode(java.util.function.Predicate<STEnumTreeNode> predicate) {
		return treeModel.find(STEnumTreeNode.class, predicate);
	}

	private java.util.Collection<STEnumTreeNode> findAllSTEnumTreeNode(java.util.function.Predicate<STEnumTreeNode> predicate) {
		return treeModel.findAll(STEnumTreeNode.class, predicate);
	}

	private Optional<STEnumTreeNode> findSTEnumTreeNode(BaseTreeNode<?> parent, java.util.function.Predicate<STEnumTreeNode> predicate) {
		return treeModel.find(parent, STEnumTreeNode.class, predicate);
	}

	private java.util.stream.Stream<STEnumTreeNode> getSelectedSTEnumTreeNodes() {
		return getSelectedNodes(STEnumTreeNode.class);
	}

	private void onSTEnumTreeNodeSelected(STEnumTreeNode selectedNode) {
	}  

	// STGroupActionTreeNode
	public class STGroupActionTreeNode extends BaseTreeNode<nextgen.model.STGroupAction> {

		private String uuid;

		STGroupActionTreeNode(nextgen.model.STGroupAction model) {
			super(model, appModel().loadIcon("nextgen.model.STGroupAction"));


			setLabel(model.toString());
			this.tooltip = "";
			this.uuid = model.getUuid();

		}

		STGroupActionTreeNode thisNode() {
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

			appModel().doInTransaction(tx -> {
			});

			return actions;
		}

	}

	private boolean isSTGroupActionTreeNode(Object treeNode) {
		return treeNode instanceof STGroupActionTreeNode;
	}

	private Optional<STGroupActionTreeNode> findSTGroupActionTreeNode() {
		return treeModel.find(STGroupActionTreeNode.class, treeNode -> true);
	}

	private java.util.Collection<STGroupActionTreeNode> findAllSTGroupActionTreeNode() {
		return treeModel.findAll(STGroupActionTreeNode.class, treeNode -> true);
	}

	private java.util.Collection<STGroupActionTreeNode> findAllSTGroupActionTreeNode(BaseTreeNode<?> parent) {
		return parent.getChildren(STGroupActionTreeNode.class).collect(java.util.stream.Collectors.toList());
	}

	private Optional<STGroupActionTreeNode> findSTGroupActionTreeNode(java.util.function.Predicate<STGroupActionTreeNode> predicate) {
		return treeModel.find(STGroupActionTreeNode.class, predicate);
	}

	private java.util.Collection<STGroupActionTreeNode> findAllSTGroupActionTreeNode(java.util.function.Predicate<STGroupActionTreeNode> predicate) {
		return treeModel.findAll(STGroupActionTreeNode.class, predicate);
	}

	private Optional<STGroupActionTreeNode> findSTGroupActionTreeNode(BaseTreeNode<?> parent, java.util.function.Predicate<STGroupActionTreeNode> predicate) {
		return treeModel.find(parent, STGroupActionTreeNode.class, predicate);
	}

	private java.util.stream.Stream<STGroupActionTreeNode> getSelectedSTGroupActionTreeNodes() {
		return getSelectedNodes(STGroupActionTreeNode.class);
	}

	private void onSTGroupActionTreeNodeSelected(STGroupActionTreeNode selectedNode) {
	}  

	// STParameterTreeNode
	public class STParameterTreeNode extends BaseTreeNode<nextgen.model.STParameter> {

		private String uuid;

		STParameterTreeNode(nextgen.model.STParameter model) {
			super(model, appModel().loadIcon("nextgen.model.STParameter"));


			setLabel(model.toString());
			this.tooltip = "";
			this.uuid = model.getUuid();

		}

		STParameterTreeNode thisNode() {
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

			appModel().doInTransaction(tx -> {
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

	private java.util.Collection<STParameterTreeNode> findAllSTParameterTreeNode() {
		return treeModel.findAll(STParameterTreeNode.class, treeNode -> true);
	}

	private java.util.Collection<STParameterTreeNode> findAllSTParameterTreeNode(BaseTreeNode<?> parent) {
		return parent.getChildren(STParameterTreeNode.class).collect(java.util.stream.Collectors.toList());
	}

	private Optional<STParameterTreeNode> findSTParameterTreeNode(java.util.function.Predicate<STParameterTreeNode> predicate) {
		return treeModel.find(STParameterTreeNode.class, predicate);
	}

	private java.util.Collection<STParameterTreeNode> findAllSTParameterTreeNode(java.util.function.Predicate<STParameterTreeNode> predicate) {
		return treeModel.findAll(STParameterTreeNode.class, predicate);
	}

	private Optional<STParameterTreeNode> findSTParameterTreeNode(BaseTreeNode<?> parent, java.util.function.Predicate<STParameterTreeNode> predicate) {
		return treeModel.find(parent, STParameterTreeNode.class, predicate);
	}

	private java.util.stream.Stream<STParameterTreeNode> getSelectedSTParameterTreeNodes() {
		return getSelectedNodes(STParameterTreeNode.class);
	}

	private void onSTParameterTreeNodeSelected(STParameterTreeNode selectedNode) {
	}  

	// STEnumValueTreeNode
	public class STEnumValueTreeNode extends BaseTreeNode<nextgen.model.STEnumValue> {

		private String uuid;

		STEnumValueTreeNode(nextgen.model.STEnumValue model) {
			super(model, appModel().loadIcon("nextgen.model.STEnumValue"));


			setLabel(model.toString());
			this.tooltip = "";
			this.uuid = model.getUuid();

		}

		STEnumValueTreeNode thisNode() {
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

			appModel().doInTransaction(tx -> {
			});

			return actions;
		}

	}

	private boolean isSTEnumValueTreeNode(Object treeNode) {
		return treeNode instanceof STEnumValueTreeNode;
	}

	private Optional<STEnumValueTreeNode> findSTEnumValueTreeNode() {
		return treeModel.find(STEnumValueTreeNode.class, treeNode -> true);
	}

	private java.util.Collection<STEnumValueTreeNode> findAllSTEnumValueTreeNode() {
		return treeModel.findAll(STEnumValueTreeNode.class, treeNode -> true);
	}

	private java.util.Collection<STEnumValueTreeNode> findAllSTEnumValueTreeNode(BaseTreeNode<?> parent) {
		return parent.getChildren(STEnumValueTreeNode.class).collect(java.util.stream.Collectors.toList());
	}

	private Optional<STEnumValueTreeNode> findSTEnumValueTreeNode(java.util.function.Predicate<STEnumValueTreeNode> predicate) {
		return treeModel.find(STEnumValueTreeNode.class, predicate);
	}

	private java.util.Collection<STEnumValueTreeNode> findAllSTEnumValueTreeNode(java.util.function.Predicate<STEnumValueTreeNode> predicate) {
		return treeModel.findAll(STEnumValueTreeNode.class, predicate);
	}

	private Optional<STEnumValueTreeNode> findSTEnumValueTreeNode(BaseTreeNode<?> parent, java.util.function.Predicate<STEnumValueTreeNode> predicate) {
		return treeModel.find(parent, STEnumValueTreeNode.class, predicate);
	}

	private java.util.stream.Stream<STEnumValueTreeNode> getSelectedSTEnumValueTreeNodes() {
		return getSelectedNodes(STEnumValueTreeNode.class);
	}

	private void onSTEnumValueTreeNodeSelected(STEnumValueTreeNode selectedNode) {
	}  

	// STParameterKeyTreeNode
	public class STParameterKeyTreeNode extends BaseTreeNode<nextgen.model.STParameterKey> {

		private String uuid;

		STParameterKeyTreeNode(nextgen.model.STParameterKey model) {
			super(model, appModel().loadIcon("nextgen.model.STParameterKey"));


			setLabel(model.toString());
			this.tooltip = "";
			this.uuid = model.getUuid();

		}

		STParameterKeyTreeNode thisNode() {
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

			appModel().doInTransaction(tx -> {
			});

			return actions;
		}

	}

	private boolean isSTParameterKeyTreeNode(Object treeNode) {
		return treeNode instanceof STParameterKeyTreeNode;
	}

	private Optional<STParameterKeyTreeNode> findSTParameterKeyTreeNode() {
		return treeModel.find(STParameterKeyTreeNode.class, treeNode -> true);
	}

	private java.util.Collection<STParameterKeyTreeNode> findAllSTParameterKeyTreeNode() {
		return treeModel.findAll(STParameterKeyTreeNode.class, treeNode -> true);
	}

	private java.util.Collection<STParameterKeyTreeNode> findAllSTParameterKeyTreeNode(BaseTreeNode<?> parent) {
		return parent.getChildren(STParameterKeyTreeNode.class).collect(java.util.stream.Collectors.toList());
	}

	private Optional<STParameterKeyTreeNode> findSTParameterKeyTreeNode(java.util.function.Predicate<STParameterKeyTreeNode> predicate) {
		return treeModel.find(STParameterKeyTreeNode.class, predicate);
	}

	private java.util.Collection<STParameterKeyTreeNode> findAllSTParameterKeyTreeNode(java.util.function.Predicate<STParameterKeyTreeNode> predicate) {
		return treeModel.findAll(STParameterKeyTreeNode.class, predicate);
	}

	private Optional<STParameterKeyTreeNode> findSTParameterKeyTreeNode(BaseTreeNode<?> parent, java.util.function.Predicate<STParameterKeyTreeNode> predicate) {
		return treeModel.find(parent, STParameterKeyTreeNode.class, predicate);
	}

	private java.util.stream.Stream<STParameterKeyTreeNode> getSelectedSTParameterKeyTreeNodes() {
		return getSelectedNodes(STParameterKeyTreeNode.class);
	}

	private void onSTParameterKeyTreeNodeSelected(STParameterKeyTreeNode selectedNode) {
	}  

	// DomainTreeNode
	public class DomainTreeNode extends BaseTreeNode<nextgen.model.Domain> {

		private String uuid;

		DomainTreeNode(nextgen.model.Domain model) {
			super(model, appModel().loadIcon("nextgen.model.Domain"));


			setLabel(model.toString());
			this.tooltip = "";
			this.uuid = model.getUuid();

		}

		DomainTreeNode thisNode() {
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

			appModel().doInTransaction(tx -> {
			});

			return actions;
		}

	}

	private boolean isDomainTreeNode(Object treeNode) {
		return treeNode instanceof DomainTreeNode;
	}

	private Optional<DomainTreeNode> findDomainTreeNode() {
		return treeModel.find(DomainTreeNode.class, treeNode -> true);
	}

	private java.util.Collection<DomainTreeNode> findAllDomainTreeNode() {
		return treeModel.findAll(DomainTreeNode.class, treeNode -> true);
	}

	private java.util.Collection<DomainTreeNode> findAllDomainTreeNode(BaseTreeNode<?> parent) {
		return parent.getChildren(DomainTreeNode.class).collect(java.util.stream.Collectors.toList());
	}

	private Optional<DomainTreeNode> findDomainTreeNode(java.util.function.Predicate<DomainTreeNode> predicate) {
		return treeModel.find(DomainTreeNode.class, predicate);
	}

	private java.util.Collection<DomainTreeNode> findAllDomainTreeNode(java.util.function.Predicate<DomainTreeNode> predicate) {
		return treeModel.findAll(DomainTreeNode.class, predicate);
	}

	private Optional<DomainTreeNode> findDomainTreeNode(BaseTreeNode<?> parent, java.util.function.Predicate<DomainTreeNode> predicate) {
		return treeModel.find(parent, DomainTreeNode.class, predicate);
	}

	private java.util.stream.Stream<DomainTreeNode> getSelectedDomainTreeNodes() {
		return getSelectedNodes(DomainTreeNode.class);
	}

	private void onDomainTreeNodeSelected(DomainTreeNode selectedNode) {
	}  

	// DomainEntityTreeNode
	public class DomainEntityTreeNode extends BaseTreeNode<nextgen.model.DomainEntity> {

		private String uuid;

		DomainEntityTreeNode(nextgen.model.DomainEntity model) {
			super(model, appModel().loadIcon("nextgen.model.DomainEntity"));


			setLabel(model.toString());
			this.tooltip = "";
			this.uuid = model.getUuid();

		}

		DomainEntityTreeNode thisNode() {
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

			appModel().doInTransaction(tx -> {
			});

			return actions;
		}

	}

	private boolean isDomainEntityTreeNode(Object treeNode) {
		return treeNode instanceof DomainEntityTreeNode;
	}

	private Optional<DomainEntityTreeNode> findDomainEntityTreeNode() {
		return treeModel.find(DomainEntityTreeNode.class, treeNode -> true);
	}

	private java.util.Collection<DomainEntityTreeNode> findAllDomainEntityTreeNode() {
		return treeModel.findAll(DomainEntityTreeNode.class, treeNode -> true);
	}

	private java.util.Collection<DomainEntityTreeNode> findAllDomainEntityTreeNode(BaseTreeNode<?> parent) {
		return parent.getChildren(DomainEntityTreeNode.class).collect(java.util.stream.Collectors.toList());
	}

	private Optional<DomainEntityTreeNode> findDomainEntityTreeNode(java.util.function.Predicate<DomainEntityTreeNode> predicate) {
		return treeModel.find(DomainEntityTreeNode.class, predicate);
	}

	private java.util.Collection<DomainEntityTreeNode> findAllDomainEntityTreeNode(java.util.function.Predicate<DomainEntityTreeNode> predicate) {
		return treeModel.findAll(DomainEntityTreeNode.class, predicate);
	}

	private Optional<DomainEntityTreeNode> findDomainEntityTreeNode(BaseTreeNode<?> parent, java.util.function.Predicate<DomainEntityTreeNode> predicate) {
		return treeModel.find(parent, DomainEntityTreeNode.class, predicate);
	}

	private java.util.stream.Stream<DomainEntityTreeNode> getSelectedDomainEntityTreeNodes() {
		return getSelectedNodes(DomainEntityTreeNode.class);
	}

	private void onDomainEntityTreeNodeSelected(DomainEntityTreeNode selectedNode) {
	}  

	// DomainRelationTreeNode
	public class DomainRelationTreeNode extends BaseTreeNode<nextgen.model.DomainRelation> {

		private String uuid;

		DomainRelationTreeNode(nextgen.model.DomainRelation model) {
			super(model, appModel().loadIcon("nextgen.model.DomainRelation"));


			setLabel(model.toString());
			this.tooltip = "";
			this.uuid = model.getUuid();

		}

		DomainRelationTreeNode thisNode() {
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

			appModel().doInTransaction(tx -> {
			});

			return actions;
		}

	}

	private boolean isDomainRelationTreeNode(Object treeNode) {
		return treeNode instanceof DomainRelationTreeNode;
	}

	private Optional<DomainRelationTreeNode> findDomainRelationTreeNode() {
		return treeModel.find(DomainRelationTreeNode.class, treeNode -> true);
	}

	private java.util.Collection<DomainRelationTreeNode> findAllDomainRelationTreeNode() {
		return treeModel.findAll(DomainRelationTreeNode.class, treeNode -> true);
	}

	private java.util.Collection<DomainRelationTreeNode> findAllDomainRelationTreeNode(BaseTreeNode<?> parent) {
		return parent.getChildren(DomainRelationTreeNode.class).collect(java.util.stream.Collectors.toList());
	}

	private Optional<DomainRelationTreeNode> findDomainRelationTreeNode(java.util.function.Predicate<DomainRelationTreeNode> predicate) {
		return treeModel.find(DomainRelationTreeNode.class, predicate);
	}

	private java.util.Collection<DomainRelationTreeNode> findAllDomainRelationTreeNode(java.util.function.Predicate<DomainRelationTreeNode> predicate) {
		return treeModel.findAll(DomainRelationTreeNode.class, predicate);
	}

	private Optional<DomainRelationTreeNode> findDomainRelationTreeNode(BaseTreeNode<?> parent, java.util.function.Predicate<DomainRelationTreeNode> predicate) {
		return treeModel.find(parent, DomainRelationTreeNode.class, predicate);
	}

	private java.util.stream.Stream<DomainRelationTreeNode> getSelectedDomainRelationTreeNodes() {
		return getSelectedNodes(DomainRelationTreeNode.class);
	}

	private void onDomainRelationTreeNodeSelected(DomainRelationTreeNode selectedNode) {
	}  

	// DomainVisitorTreeNode
	public class DomainVisitorTreeNode extends BaseTreeNode<nextgen.model.DomainVisitor> {

		private String uuid;

		DomainVisitorTreeNode(nextgen.model.DomainVisitor model) {
			super(model, appModel().loadIcon("nextgen.model.DomainVisitor"));


			setLabel(model.toString());
			this.tooltip = "";
			this.uuid = model.getUuid();

		}

		DomainVisitorTreeNode thisNode() {
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

			appModel().doInTransaction(tx -> {
			});

			return actions;
		}

	}

	private boolean isDomainVisitorTreeNode(Object treeNode) {
		return treeNode instanceof DomainVisitorTreeNode;
	}

	private Optional<DomainVisitorTreeNode> findDomainVisitorTreeNode() {
		return treeModel.find(DomainVisitorTreeNode.class, treeNode -> true);
	}

	private java.util.Collection<DomainVisitorTreeNode> findAllDomainVisitorTreeNode() {
		return treeModel.findAll(DomainVisitorTreeNode.class, treeNode -> true);
	}

	private java.util.Collection<DomainVisitorTreeNode> findAllDomainVisitorTreeNode(BaseTreeNode<?> parent) {
		return parent.getChildren(DomainVisitorTreeNode.class).collect(java.util.stream.Collectors.toList());
	}

	private Optional<DomainVisitorTreeNode> findDomainVisitorTreeNode(java.util.function.Predicate<DomainVisitorTreeNode> predicate) {
		return treeModel.find(DomainVisitorTreeNode.class, predicate);
	}

	private java.util.Collection<DomainVisitorTreeNode> findAllDomainVisitorTreeNode(java.util.function.Predicate<DomainVisitorTreeNode> predicate) {
		return treeModel.findAll(DomainVisitorTreeNode.class, predicate);
	}

	private Optional<DomainVisitorTreeNode> findDomainVisitorTreeNode(BaseTreeNode<?> parent, java.util.function.Predicate<DomainVisitorTreeNode> predicate) {
		return treeModel.find(parent, DomainVisitorTreeNode.class, predicate);
	}

	private java.util.stream.Stream<DomainVisitorTreeNode> getSelectedDomainVisitorTreeNodes() {
		return getSelectedNodes(DomainVisitorTreeNode.class);
	}

	private void onDomainVisitorTreeNodeSelected(DomainVisitorTreeNode selectedNode) {
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


	class NewSTTemplateNavigatorTreeModel extends DefaultTreeModel {

		public NewSTTemplateNavigatorTreeModel(BaseTreeNode root) {
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

			final List<BaseTreeNode<?>> children = new java.util.ArrayList<>();
			for (int i = 0; i < childCount; i++) {
				final BaseTreeNode<?> childAt = (BaseTreeNode<?>) parent.getChildAt(i);
				if (predicate.test(childAt))
					return Optional.of((T) new TreePath(childAt.getPath()).getLastPathComponent());
				else {
					children.add(childAt);
				}
			}

			for (BaseTreeNode<?> childAt : children) {
				final Optional<T> node = find(childAt, predicate);
				if (node.isPresent()) return node;
			}

			return Optional.empty();
		}

		protected <T extends BaseTreeNode<?>> Optional<T> find(BaseTreeNode<?> parent, Class<T> nodeType, java.util.function.Predicate<T> predicate) {
			return find(parent, navigatorTreeNode -> navigatorTreeNode.getClass()
					.isAssignableFrom(nodeType) && predicate.test((T) navigatorTreeNode));
		}

		protected <T extends BaseTreeNode<?>> java.util.Collection<T> findAll(Class<T> nodeType, java.util.function.Predicate<T> predicate) {
			final BaseTreeNode<?> root = (BaseTreeNode<?>) getRoot();
			final Collection<T> children = new java.util.ArrayList<>();
			if (root.getClass().isAssignableFrom(nodeType) && predicate.test((T) root)) 
				children.add((T) root);
			children.addAll(findAll((BaseTreeNode<?>) getRoot(), navigatorTreeNode -> navigatorTreeNode.getClass()
					.isAssignableFrom(nodeType) && predicate.test((T) navigatorTreeNode)));
			return children;
		}

		protected <T extends BaseTreeNode<?>> java.util.Collection<T> findAll(BaseTreeNode<?> parent, Class<T> nodeType, java.util.function.Predicate<T> predicate) {
			return findAll(parent, navigatorTreeNode -> navigatorTreeNode.getClass()
					.isAssignableFrom(nodeType) && predicate.test((T) navigatorTreeNode));
		}

		protected <T extends BaseTreeNode<?>> java.util.Collection<T> findAll(BaseTreeNode<?> parent, java.util.function.Predicate<BaseTreeNode<?>> predicate) {
			final Collection<T> children = new java.util.ArrayList<>();
			final int childCount = parent.getChildCount();
			for (int i = 0; i < childCount; i++) {
				final BaseTreeNode<?> childAt = (BaseTreeNode<?>) parent.getChildAt(i);
				if (predicate.test(childAt))
					children.add((T) new TreePath(childAt.getPath()).getLastPathComponent());
				else {
					children.addAll(findAll(childAt, predicate));
				}
			}
			return children;
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