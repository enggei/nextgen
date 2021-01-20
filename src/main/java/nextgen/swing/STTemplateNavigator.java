package nextgen.swing;

import nextgen.actions.*;

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

		treeModel = new STTemplateNavigatorTreeModel(new RootNode("[]"));
		tree.setModel(treeModel);
		ToolTipManager.sharedInstance().registerComponent(tree);

		tree.setCellRenderer(new STTemplateNavigatorCellRenderer());
		tree.addKeyListener(new STTemplateNavigatorKeyListener());
		tree.addMouseListener(new STTemplateNavigatorMouseListener());

		setPreferredSize(new Dimension(300, 500));
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
			return ComponentFactory.decorate(super.getTreeCellRendererComponent(tree, node.getLabel(), sel, expanded, leaf, row, hasFocus));
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
					if (isSTGroupActionTreeNode(lastPathComponent)) 
						onSTGroupActionTreeNodeSelected((STGroupActionTreeNode) lastPathComponent);
					else if (isDomainEntityTreeNode(lastPathComponent)) 
						onDomainEntityTreeNodeSelected((DomainEntityTreeNode) lastPathComponent);
					else if (isDomainRelationTreeNode(lastPathComponent)) 
						onDomainRelationTreeNodeSelected((DomainRelationTreeNode) lastPathComponent);
					else if (isDomainTreeNode(lastPathComponent)) 
						onDomainTreeNodeSelected((DomainTreeNode) lastPathComponent);
					else if (isDomainVisitorTreeNode(lastPathComponent)) 
						onDomainVisitorTreeNodeSelected((DomainVisitorTreeNode) lastPathComponent);
					else if (isSTGroupTreeNode(lastPathComponent)) 
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
	public void onNewDomainVisitor(nextgen.events.NewDomainVisitor event) {
		findAllDomainTreeNode(treeNode -> treeNode.getModel().equals(event.domain))
							.forEach(treeNode -> treeModel.addNodeInSortedOrderAndSelect(treeNode, new DomainVisitorTreeNode(event.visitor)));
	}

	@org.greenrobot.eventbus.Subscribe()
	public void onNewDomain(nextgen.events.NewDomain event) {
		findAllDomainsTreeNode().forEach(treeNode -> treeModel.addNodeInSortedOrderAndSelect(treeNode, new DomainTreeNode(event.domain)));
	}

	@org.greenrobot.eventbus.Subscribe()
	public void onNewSTAction(nextgen.events.NewSTAction event) {
		findAllSTGroupTreeNode(treeNode -> treeNode.getModel().equals(event.stGroup))
				.forEach(treeNode -> treeModel.addNodeInSortedOrderAndSelect(treeNode, new STTemplateNavigator.STGroupActionTreeNode(event.action)));
	}

	@org.greenrobot.eventbus.Subscribe()
	public void onSTGroupActionDeleted(nextgen.events.STGroupActionDeleted event) {
		findAllSTGroupActionTreeNode(treeNode -> treeNode.uuid.equals(event.uuid)).forEach(treeModel::removeNodeFromParent);
	}

	@org.greenrobot.eventbus.Subscribe()
	public void onSTGroupActionChanged(nextgen.events.STGroupActionChanged event) {
		findAllSTGroupActionTreeNode(treeNode -> treeNode.getModel().equals(event.sTGroupAction)).forEach(STTemplateNavigator.STGroupActionTreeNode::nodeChanged);
	}

	@org.greenrobot.eventbus.Subscribe()
	public void onNewDomainEntityDomainRelation(nextgen.events.NewDomainEntityDomainRelation event) {
		findAllDomainEntityTreeNode(treeNode -> treeNode.getModel().equals(event.domainEntity))
			.forEach(treeNode -> treeModel.addNodeInSortedOrderAndSelect(treeNode, new DomainRelationTreeNode(event.domainRelation)));
	}

	@org.greenrobot.eventbus.Subscribe()
	public void onDomainEntityChanged(nextgen.events.DomainEntityChanged event) {
		findAllDomainEntityTreeNode(treeNode -> treeNode.getModel().equals(event.domainEntity))
		      .forEach(treeNode -> {
		         treeNode.removeAllChildren();
		         event.domainEntity.getIncomingEntitiesDomain().findFirst()
		               .ifPresent(domain -> domain.getRelationsSorted()
		                     .filter(domainRelation -> domainRelation.getSrc().equals(event.domainEntity))
		                     .forEach(domainRelation -> treeNode.add(new DomainRelationTreeNode(domainRelation))));
		         treeNode.nodeChanged();
		      });
	}

	@org.greenrobot.eventbus.Subscribe()
	public void onSTGroupFileChanged(nextgen.events.STGroupFileChanged event) {
		findAllSTGroupFileTreeNode(treeNode -> treeNode.getModel().equals(event.sTGroupFile)).forEach(STGroupFileTreeNode::nodeChanged);
	}

	@org.greenrobot.eventbus.Subscribe()
	public void onNewDomainDomainEntity(nextgen.events.NewDomainDomainEntity event) {
		findAllDomainTreeNode(treeNode -> treeNode.getModel().equals(event.domain)).forEach(treeNode -> treeModel.addNodeInSortedOrderAndSelect(treeNode, new DomainEntityTreeNode(event.domainEntity)));
	}

	@org.greenrobot.eventbus.Subscribe()
	public void onDomainVisitorDeleted(nextgen.events.DomainVisitorDeleted event) {
		findAllDomainVisitorTreeNode(treeNode -> treeNode.uuid.equals(event.uuid)).forEach(treeModel::removeNodeFromParent);
	}

	@org.greenrobot.eventbus.Subscribe()
	public void onSTModelTreeNodeClicked(nextgen.events.STModelTreeNodeClicked event) {
		findAllSTTemplateTreeNode(treeNode -> treeNode.getModel().equals(event.stModel.getStTemplate())).forEach(treeModel::select);
	}

	@org.greenrobot.eventbus.Subscribe()
	public void onSTGroupDeleted(nextgen.events.STGroupDeleted event) {
		findAllSTGroupTreeNode(treeNode -> treeNode.uuid.equals(event.uuid)).forEach(treeModel::removeNodeFromParent);
	}

	@org.greenrobot.eventbus.Subscribe()
	public void onSTEnumDeleted(nextgen.events.STEnumDeleted event) {
		findAllSTEnumTreeNode(treeNode -> treeNode.uuid.equals(event.uuid)).forEach(treeModel::removeNodeFromParent);
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
	public void onNewSTGroup(nextgen.events.NewSTGroup event) {
		findTemplatesTreeNode().ifPresent(treeNode -> treeModel.addNodeInSortedOrderAndSelect(treeNode, new nextgen.swing.STTemplateNavigator.STGroupTreeNode(event.group)));
	}

	@org.greenrobot.eventbus.Subscribe()
	public void onNewSTEnum(nextgen.events.NewSTEnum event) {
		findAllSTGroupTreeNode(treeNode -> treeNode.getModel().equals(event.stGroup))
							.forEach(treeNode -> treeModel.addNodeInSortedOrderAndSelect(treeNode, new STTemplateNavigator.STEnumTreeNode(event.stEnum)));
	}

	@org.greenrobot.eventbus.Subscribe()
	public void onNewSTInterface(nextgen.events.NewSTInterface event) {
		findAllSTGroupTreeNode(treeNode -> treeNode.getModel().equals(event.stGroup))
							.forEach(treeNode -> treeModel.addNodeInSortedOrderAndSelect(treeNode, new STTemplateNavigator.STInterfaceTreeNode(event.stInterface)));
	}

	@org.greenrobot.eventbus.Subscribe()
	public void onNewSTGroupTemplate(nextgen.events.NewSTGroupTemplate event) {
		findAllSTGroupTreeNode(treeNode -> treeNode.getModel().equals(event.parent))
							.forEach(treeNode -> treeModel.addNodeInSortedOrderAndSelect(treeNode, new STTemplateNavigator.STTemplateTreeNode(event.template)));
	}

	@org.greenrobot.eventbus.Subscribe()
	public void onNewSTTemplateChild(nextgen.events.NewSTTemplateChild event) {
		findAllSTTemplateTreeNode(treeNode -> treeNode.getModel().equals(event.parent))
							.forEach(treeNode -> treeModel.addNodeInSortedOrderAndSelect(treeNode, new STTemplateNavigator.STTemplateTreeNode(event.template)));
	}

	@org.greenrobot.eventbus.Subscribe()
	public void onSTGroupNameChanged(nextgen.events.STGroupNameChanged event) {
		findAllSTGroupTreeNode(treeNode -> treeNode.getModel().equals(event.stGroup)).forEach(STGroupTreeNode::nodeChanged);
	}

	@org.greenrobot.eventbus.Subscribe()
	public void onSTTemplateNameChanged(nextgen.events.STTemplateNameChanged event) {
		findAllSTTemplateTreeNode(treeNode -> treeNode.getModel().equals(event.stTemplate)).forEach(STTemplateTreeNode::nodeChanged);
	}

	@org.greenrobot.eventbus.Subscribe()
	public void onSTInterfaceNameChanged(nextgen.events.STInterfaceNameChanged event) {
		findAllSTInterfaceTreeNode(treeNode -> treeNode.getModel().equals(event.stInterface)).forEach(STInterfaceTreeNode::nodeChanged);
	}

	@org.greenrobot.eventbus.Subscribe()
	public void onSTEnumNameChanged(nextgen.events.STEnumNameChanged event) {
		findAllSTEnumTreeNode(treeNode -> treeNode.getModel().equals(event.stEnum))
							.forEach(STTemplateNavigator.STEnumTreeNode::nodeChanged);
	}

	@org.greenrobot.eventbus.Subscribe()
	public void onSTGroupTreeNodeClicked(nextgen.events.STGroupTreeNodeClicked event) {
		findAllSTGroupTreeNode(treeNode -> treeNode.getModel().equals(event.stGroup)).forEach(treeModel::select);
	}

	@org.greenrobot.eventbus.Subscribe()
	public void onCanvasSTModelNodeClicked(nextgen.events.CanvasSTModelNodeClicked event) {
		final nextgen.model.STTemplate stTemplate = event.stModel.getStTemplate();
		findAllSTTemplateTreeNode(stTemplateTreeNode -> stTemplateTreeNode.getModel().equals(stTemplate)).forEach(treeModel::select);
	}

	@org.greenrobot.eventbus.Subscribe()
	public void onNewSTGroupFile(nextgen.events.NewSTGroupFile event) {
		findAllSTGroupTreeNode(stGroupTreeNode -> stGroupTreeNode.getModel().equals(event.stGroupModel))
				.forEach(stGroupTreeNode -> treeModel.addNodeInSortedOrderAndSelect(stGroupTreeNode, new STTemplateNavigator.STGroupFileTreeNode(event.stGroupFile)));
	}

	@org.greenrobot.eventbus.Subscribe()
	public void onSTGroupFileDeleted(nextgen.events.STGroupFileDeleted event) {
		findAllSTGroupFileTreeNode(treeNode -> treeNode.uuid.equals(event.uuid)).forEach(treeModel::removeNodeFromParent);
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

	// DomainTreeNode
	public class DomainTreeNode extends BaseTreeNode<nextgen.model.Domain> {

		DomainTreeNode(nextgen.model.Domain model) {
			super(model, appModel().loadIcon("nextgen.model.Domain"));


			setLabel(getModel().getName());
			this.tooltip = "";

			model.getEntities().sorted((e1, e2) -> e1.getName().compareToIgnoreCase(e2.getName())).forEach(domainEntity -> add(new DomainEntityTreeNode(domainEntity)));
			model.getVisitorsSorted().forEach(domainVisitor -> add(new DomainVisitorTreeNode(domainVisitor)));
		}

		DomainTreeNode thisNode() {
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
				actions.add(new AddDomainEntities(getModel(), workspace));
				actions.add(new AddDomainVisitor(getModel(), workspace));
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

	// TemplatesTreeNode
	public class TemplatesTreeNode extends BaseTreeNode<String> {

		TemplatesTreeNode(String model) {
			super(model, appModel().loadIcon("String"));


			setLabel(model.toString());
			this.tooltip = "";

			appModel().db.findAllSTGroupModel().sorted((g1,g2) -> g1.getName().compareToIgnoreCase(g2.getName())).forEach(stGroup -> add(new STGroupTreeNode(stGroup)));
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

			appModel().db.findAllDomain().sorted((g1,g2) -> g1.getName().compareToIgnoreCase(g2.getName())).forEach(domain -> add(new DomainTreeNode(domain)));
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

	// DomainEntityTreeNode
	public class DomainEntityTreeNode extends BaseTreeNode<nextgen.model.DomainEntity> {

		private String uuid;

		DomainEntityTreeNode(nextgen.model.DomainEntity model) {
			super(model, appModel().loadIcon("nextgen.model.DomainEntity"));


			setLabel(getModel().getName());
			this.tooltip = "";
			this.uuid = model.getUuid();

			if (model.hasType() && model.hasEnums() && model.getType().equals(nextgen.model.DomainEntityType.ENUM)) add(new StringTreeNode(model.getEnums()));
			model.getIncomingEntitiesDomain().forEach(domain -> domain.getRelations()
					.filter(domainRelation -> domainRelation.getSrc().equals(getModel()))
					.forEach(domainRelation -> add(new DomainRelationTreeNode(domainRelation))));
		}

		DomainEntityTreeNode thisNode() {
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
				actions.add(new DeleteDomainEntity(getModel(), workspace));
				actions.add(new AddDomainRelation(getModel(), workspace));
				actions.add(new EditDomainEntity(getModel(), workspace));
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
		nextgen.events.DomainEntityTreeNodeClicked.post(selectedNode.getModel());
	}

	// DomainRelationTreeNode
	public class DomainRelationTreeNode extends BaseTreeNode<nextgen.model.DomainRelation> {

		private String uuid;

		DomainRelationTreeNode(nextgen.model.DomainRelation model) {
			super(model, appModel().loadIcon("nextgen.model.DomainRelation"));


			setLabel(getModel().getName());
			this.tooltip = "";
			this.uuid = model.getUuid();

			add(new StringTreeNode(getModel().getDst().getName()));
		}

		DomainRelationTreeNode thisNode() {
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
				actions.add(new SetDomainRelationType(getModel(), workspace));
				actions.add(new DeleteDomainRelation(getModel(), workspace));
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
		nextgen.events.DomainRelationTreeNodeClicked.post(selectedNode.getModel());
	}

	// DomainVisitorTreeNode
	public class DomainVisitorTreeNode extends BaseTreeNode<nextgen.model.DomainVisitor> {

		private String uuid;

		DomainVisitorTreeNode(nextgen.model.DomainVisitor model) {
			super(model, appModel().loadIcon("nextgen.model.DomainVisitor"));


			setLabel(getModel().getName());
			this.tooltip = "";
			this.uuid = model.getUuid();

		}

		DomainVisitorTreeNode thisNode() {
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
				actions.add(new RunDomainVisitor(getModel(), workspace));
				actions.add(new DeleteDomainVisitor(getModel(), workspace));
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
		nextgen.events.DomainVisitorTreeNodeClicked.post(selectedNode.getModel());
	}

	// STGroupActionTreeNode
	public class STGroupActionTreeNode extends BaseTreeNode<nextgen.model.STGroupAction> {

		private String uuid;

		STGroupActionTreeNode(nextgen.model.STGroupAction model) {
			super(model, appModel().loadIcon("nextgen.model.STGroupAction"));


			setLabel(getModel().getName());
			this.tooltip = "";
			this.uuid = model.getUuid();

		}

		STGroupActionTreeNode thisNode() {
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
				getParentNode(STGroupTreeNode.class).ifPresent(parent -> actions.add(new DeleteAction(getModel(), workspace, parent.getModel())));
				actions.add(new RunAction(getModel(), workspace));
				actions.add(new WriteSTGroupAction(getModel()));
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
		nextgen.events.STGroupActionTreeNodeClicked.post(selectedNode.getModel());
	}

	// StringTreeNode
	public class StringTreeNode extends BaseTreeNode<String> {

		StringTreeNode(String model) {
			super(model, appModel().loadIcon("String"));


			setLabel(getModel());
			this.tooltip = "";

		}

		StringTreeNode thisNode() {
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

	}

	private boolean isStringTreeNode(Object treeNode) {
		return treeNode instanceof StringTreeNode;
	}

	private Optional<StringTreeNode> findStringTreeNode() {
		return treeModel.find(StringTreeNode.class, treeNode -> true);
	}

	private java.util.Collection<StringTreeNode> findAllStringTreeNode() {
		return treeModel.findAll(StringTreeNode.class, treeNode -> true);
	}

	private java.util.Collection<StringTreeNode> findAllStringTreeNode(BaseTreeNode<?> parent) {
		return parent.getChildren(StringTreeNode.class).collect(java.util.stream.Collectors.toList());
	}

	private Optional<StringTreeNode> findStringTreeNode(java.util.function.Predicate<StringTreeNode> predicate) {
		return treeModel.find(StringTreeNode.class, predicate);
	}

	private java.util.Collection<StringTreeNode> findAllStringTreeNode(java.util.function.Predicate<StringTreeNode> predicate) {
		return treeModel.findAll(StringTreeNode.class, predicate);
	}

	private Optional<StringTreeNode> findStringTreeNode(BaseTreeNode<?> parent, java.util.function.Predicate<StringTreeNode> predicate) {
		return treeModel.find(parent, StringTreeNode.class, predicate);
	}

	private java.util.stream.Stream<StringTreeNode> getSelectedStringTreeNodes() {
		return getSelectedNodes(StringTreeNode.class);
	}

	private void onStringTreeNodeSelected(StringTreeNode selectedNode) {
	}

	// RootNode
	public class RootNode extends BaseTreeNode<String> {

		RootNode(String model) {
			super(model, appModel().loadIcon("String"));


			setLabel(getModel());
			this.tooltip = "";

			add(new DomainsTreeNode("Domains"));
			add(new TemplatesTreeNode("Templates"));
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
				actions.add(new NewSTGroupAction(tree));
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

	// STGroupTreeNode
	public class STGroupTreeNode extends BaseTreeNode<nextgen.model.STGroupModel> {

		private String uuid;

		STGroupTreeNode(nextgen.model.STGroupModel model) {
			super(model, appModel().loadIcon("nextgen.model.STGroupModel"));


			setLabel(getModel().getName());
			this.tooltip = "";
			this.uuid = model.getUuid();

			model.getFilesSorted().forEach(file -> add(new STGroupFileTreeNode(file)));
			model.getEnums().sorted((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName())).forEach(stEnum -> add(new STEnumTreeNode(stEnum)));
			model.getTemplates().sorted((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName())).forEach(stTemplate -> add(new STTemplateTreeNode(stTemplate)));
			model.getInterfaces().sorted((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName())).forEach(stInterface -> add(new STInterfaceTreeNode(stInterface)));
			model.getActions().sorted((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName())).forEach(stAction -> add(new STGroupActionTreeNode(stAction)));
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
				actions.add(new NewAction(getModel(), workspace));
				actions.add(new ImportSTTemplate(getModel(), workspace));
				actions.add(new GenerateSTGroup(workspace, getModel()));
				actions.add(new NewSTTemplate(getModel(), workspace));
				actions.add(new NewEnum(getModel(), workspace));
				actions.add(new NewInterface(getModel(), workspace));
				actions.add(new RenameSTGroup(getModel(), workspace));
				actions.add(new DeleteSTGroup(getModel(), workspace));
				actions.add(new AddFileSinkToGroup(getModel()));
				actions.add(new SetSTGroupLanguage(workspace, getModel()));
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

	private java.util.Collection<STGroupTreeNode> findAllSTGroupTreeNode() {
		return treeModel.findAll(STGroupTreeNode.class, treeNode -> true);
	}

	private java.util.Collection<STGroupTreeNode> findAllSTGroupTreeNode(BaseTreeNode<?> parent) {
		return parent.getChildren(STGroupTreeNode.class).collect(java.util.stream.Collectors.toList());
	}

	private Optional<STGroupTreeNode> findSTGroupTreeNode(java.util.function.Predicate<STGroupTreeNode> predicate) {
		return treeModel.find(STGroupTreeNode.class, predicate);
	}

	private java.util.Collection<STGroupTreeNode> findAllSTGroupTreeNode(java.util.function.Predicate<STGroupTreeNode> predicate) {
		return treeModel.findAll(STGroupTreeNode.class, predicate);
	}

	private Optional<STGroupTreeNode> findSTGroupTreeNode(BaseTreeNode<?> parent, java.util.function.Predicate<STGroupTreeNode> predicate) {
		return treeModel.find(parent, STGroupTreeNode.class, predicate);
	}

	private java.util.stream.Stream<STGroupTreeNode> getSelectedSTGroupTreeNodes() {
		return getSelectedNodes(STGroupTreeNode.class);
	}

	private void onSTGroupTreeNodeSelected(STGroupTreeNode selectedNode) {
		nextgen.events.STGroupTreeNodeClicked.post(selectedNode.getModel());
	}

	// STEnumTreeNode
	public class STEnumTreeNode extends BaseTreeNode<nextgen.model.STEnum> {

		private String uuid;

		STEnumTreeNode(nextgen.model.STEnum model) {
			super(model, appModel().loadIcon("nextgen.model.STEnum"));


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
				getParentNode(STGroupTreeNode.class).ifPresent(parent -> actions.add(new RenameEnum(getModel(), parent.getModel(), workspace)));
				getParentNode(STGroupTreeNode.class).ifPresent(parent -> actions.add(new DeleteEnum(getModel(), parent.getModel(), workspace)));
				actions.add(new EditEnum(getModel(), workspace));
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
		selectedNode.getParentNode(STGroupTreeNode.class).ifPresent(stGroupTreeNode -> { nextgen.events.STEnumTreeNodeClicked.post(stGroupTreeNode.getModel(), selectedNode.getModel()); });
	}

	// STTemplateTreeNode
	public class STTemplateTreeNode extends BaseTreeNode<nextgen.model.STTemplate> {

		private String uuid;

		STTemplateTreeNode(nextgen.model.STTemplate model) {
			super(model, appModel().loadIcon("nextgen.model.STTemplate"));


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
				final java.util.Set<nextgen.model.STTemplate> candidateChildren = getSelectedTemplates();
				final Set<nextgen.model.STTemplate> childTemplates = getModel().getChildren().collect(java.util.stream.Collectors.toSet());
				actions.add(new NewSTModelAction(getModel()));
				getParentNode(STGroupTreeNode.class).ifPresent(parent -> { 
					actions.add(new AddChildToTemplate(getModel(), parent.getModel(), workspace));
					actions.add(new SetTemplateParameterTypes(parent.getModel(), getModel(), workspace));
					if (!candidateChildren.isEmpty()) actions.add(new AddChildrenToTemplate("Add " + candidateChildren.size() + " templates as children", parent.getModel(), getModel(), candidateChildren, workspace));
					appModel().db.findAllSTProject().sorted(java.util.Comparator.comparing(nextgen.model.STProject::getName)).forEach(stProject -> actions.add(new AddTemplateModelToProject("Add to " + stProject.getName(), getModel(), stProject)));
					if (!childTemplates.isEmpty()) actions.add(new AddInterface("Add interfaces to children", childTemplates, workspace));
					actions.add(new SetInterfaces(parent.getModel(), getModel(), workspace));
					getModel().getImplements().forEach(implement -> actions.add(new RemoveInterfaceFromSTTemplate("Remove " + implement, parent.getModel(), getModel(), implement, workspace)));
					actions.add(new RenameSTTemplate(getModel(), parent.getModel(), workspace));
				});
				actions.add(new DeleteSTTemplate(getModel(), workspace));
				actions.add(new GetSTTemplateUUID(getModel()));
				actions.add(new CopyTemplate(getModel()));
			});

			return actions;
		}

		private java.util.Set<nextgen.model.STTemplate> getSelectedTemplates() {
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
		nextgen.events.STTemplateTreeNodeClicked.post(selectedNode.getModel());
	}

	// STInterfaceTreeNode
	public class STInterfaceTreeNode extends BaseTreeNode<nextgen.model.STInterface> {

		private String uuid;

		STInterfaceTreeNode(nextgen.model.STInterface model) {
			super(model, appModel().loadIcon("nextgen.model.STInterface"));


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
				getParentNode(STGroupTreeNode.class).ifPresent(parent -> actions.add(new RenameSTInterface(getModel(), parent.getModel(), workspace)));
				getParentNode(STGroupTreeNode.class).ifPresent(parent -> actions.add(new DeleteSTInterface(getModel(), parent.getModel(), workspace)));
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

	// STGroupFileTreeNode
	public class STGroupFileTreeNode extends BaseTreeNode<nextgen.model.STGroupFile> {

		private String uuid;

		STGroupFileTreeNode(nextgen.model.STGroupFile model) {
			super(model, appModel().loadIcon("nextgen.model.STGroupFile"));


			setLabel(appModel().render(getModel().getPath()));
			this.tooltip = "";
			this.uuid = model.getUuid();

		}

		STGroupFileTreeNode thisNode() {
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
				actions.add(new GenerateSTGroupFromFile(getModel(), workspace));
				actions.add(new DeleteSTGroupFile(getModel(), workspace));
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
		nextgen.events.STGroupFileClicked.post(selectedNode.getModel());
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

	public java.util.stream.Stream<nextgen.model.STTemplate> getSelectedSTTemplates() {
		return getSelectedNodes()
				.filter(baseTreeNode -> baseTreeNode.getModel() instanceof nextgen.model.STTemplate)
				.map(baseTreeNode -> (nextgen.model.STTemplate) baseTreeNode.getModel());
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