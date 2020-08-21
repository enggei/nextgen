package nextgen.st;

import nextgen.utils.SwingUtil;
import nextgen.domains.meta.*;

import javax.swing.*;
import javax.swing.tree.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.*;
import java.util.function.Consumer;

public class DomainVisitorEditorNavigator extends JPanel {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(DomainVisitorEditorNavigator.class);

	private final JTree tree = new JTree();
	private final STAppPresentationModel presentationModel;
	private final DefaultTreeModel treeModel;

	private nextgen.domains.meta.DomainVisitor domainVisitor;
	private DomainVisitorEditor editor;

	public DomainVisitorEditorNavigator(STAppPresentationModel presentationModel, nextgen.domains.meta.DomainVisitor domainVisitor, DomainVisitorEditor editor) {
		super(new BorderLayout());

		this.domainVisitor = domainVisitor;
		this.editor = editor;

		this.presentationModel = presentationModel;

		treeModel = new DefaultTreeModel(new DomainVisitorTreeNode(domainVisitor));
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

					editor.setSelected((BaseTreeNode<?>) lastPathComponent);
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

	// EntityVisitorTreeNode
	public class EntityVisitorTreeNode extends BaseTreeNode<nextgen.domains.meta.EntityVisitorMethod> {

		EntityVisitorTreeNode(nextgen.domains.meta.EntityVisitorMethod model) {
			super(model, null);

			this.label = "Entity " + getModel().get_meta().getName();
			this.tooltip = "";

		}

		@Override
		public void nodeChanged() {
			this.label = "Entity " + getModel().get_meta().getName();
			this.tooltip = "";
			super.nodeChanged();
		}

		@Override
		protected List<Action> getActions() {
			final List<Action> actions = super.getActions();
			return actions;
		}

	}

	// RelationVisitorTreeNode
	public class RelationVisitorTreeNode extends BaseTreeNode<nextgen.domains.meta.RelationVisitorMethod> {

		RelationVisitorTreeNode(nextgen.domains.meta.RelationVisitorMethod model) {
			super(model, null);

			this.label = "Relation " + getModel().get_meta().getName();
			this.tooltip = "";

		}

		@Override
		public void nodeChanged() {
			this.label = "Relation " + getModel().get_meta().getName();
			this.tooltip = "";
			super.nodeChanged();
		}

		@Override
		protected List<Action> getActions() {
			final List<Action> actions = super.getActions();
			return actions;
		}

	}

	// DomainVisitorTreeNode
	public class DomainVisitorTreeNode extends BaseTreeNode<nextgen.domains.meta.DomainVisitor> {

		DomainVisitorTreeNode(nextgen.domains.meta.DomainVisitor model) {
			super(model, null);

			this.label = getModel().getName();
			this.tooltip = "";

			model.getIncomingVisitorsMetaDomain().forEach(metaDomain -> {
				final MetaDomainVisitor metaDomainVisitor = new MetaDomainVisitor();
				metaDomainVisitor.visit(metaDomain);

				metaDomainVisitor.getVisitedEntities().forEach(metaEntity -> {
					final EntityVisitorMethod visitorMethod = getModel().getEntityVisitors()
							.filter(entityVisitorMethod -> entityVisitorMethod.get_meta().equals(metaEntity))
							.findAny()
							.orElseGet(() -> presentationModel.newEntityVisitorMethod(getModel(), metaEntity));

					add(new EntityVisitorTreeNode(visitorMethod));
				});

				metaDomainVisitor.getVisitedRelations().forEach(metaRelation -> {
					final RelationVisitorMethod visitorMethod = getModel().getRelationVisitors()
							.filter(relationVisitorMethod -> relationVisitorMethod.get_meta().equals(metaRelation))
							.findAny()
							.orElseGet(() -> presentationModel.newRelationVisitorMethod(getModel(), metaRelation));
					add(new RelationVisitorTreeNode(visitorMethod));
				});
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

	// VisitorFieldTreeNode
	public class VisitorFieldTreeNode extends BaseTreeNode<nextgen.domains.meta.VisitorField> {

		VisitorFieldTreeNode(nextgen.domains.meta.VisitorField model) {
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