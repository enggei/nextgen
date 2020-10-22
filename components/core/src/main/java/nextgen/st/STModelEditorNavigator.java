package nextgen.st;

import nextgen.utils.SwingUtil;
import nextgen.st.model.*;
import nextgen.st.domain.*;

import javax.swing.*;
import javax.swing.tree.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.*;
import java.util.function.Consumer;

public class STModelEditorNavigator extends JPanel {

	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(STModelEditorNavigator.class);

	private final JTree tree = new JTree();
	private final STModelEditorNavigatorTreeModel treeModel;

	private nextgen.st.model.STModel model;
	private STModelEditor editor;

	public STModelEditorNavigator(nextgen.st.model.STModel model, STModelEditor editor) {
		super(new BorderLayout());

		this.model = model;
		this.editor = editor;

		treeModel = new STModelEditorNavigatorTreeModel(new STModelTreeNode(model, appModel().findSTTemplateByUuid(model.getStTemplate()), null));
		tree.setModel(treeModel);
		ToolTipManager.sharedInstance().registerComponent(tree);

		tree.setCellRenderer(new STModelEditorNavigator.STModelEditorNavigatorCellRenderer());
		tree.addKeyListener(new STModelEditorNavigator.STModelEditorNavigatorKeyListener());
		tree.addMouseListener(new STModelEditorNavigator.STModelEditorNavigatorMouseListener());

		setPreferredSize(new Dimension(600, 600));
		add(new JScrollPane(tree), BorderLayout.CENTER);

	}

	private final class STModelEditorNavigatorCellRenderer extends DefaultTreeCellRenderer {
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

	private final class STModelEditorNavigatorKeyListener extends KeyAdapter {
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

	private final class STModelEditorNavigatorMouseListener extends MouseAdapter {
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

	// STModelTreeNode
	public class STModelTreeNode extends BaseTreeNode<nextgen.st.model.STModel> {

		private String uuid;
		private nextgen.st.domain.STTemplate stTemplate;
		private Object stArgument;

		STModelTreeNode(nextgen.st.model.STModel model, nextgen.st.domain.STTemplate stTemplate, Object stArgument) {
			super(model, appModel().loadIcon("sq-teal"));

			this.stTemplate = stTemplate;
			this.stArgument = stArgument;
			setLabel(appModel().tryToFindArgument(getModel(), "name", () -> "[" + stTemplate.getName() + "]"));
			this.tooltip = "";
			this.uuid = model.getUuid();

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
			actions.add(new nextgen.actions.CopyModel(getModel()));
			actions.add(new nextgen.actions.OpenSTModel(getModel()));
			actions.add(new nextgen.actions.VisitModel(getModel()));
			actions.add(new nextgen.actions.WriteSTModelToFile(getModel()));
			//actions.add(new nextgen.actions.DeleteSTArgument(stArgument, tree));
			actions.add(new nextgen.actions.EditSTModel(getModel()));
			return actions;
		}

	}

	private boolean isSTModelTreeNode(Object treeNode) {
		return treeNode instanceof STModelTreeNode;
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
		nextgen.events.STModelEditorTreeNodeClicked.post(selectedNode.getModel());
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


	class STModelEditorNavigatorTreeModel extends DefaultTreeModel {

		public STModelEditorNavigatorTreeModel(BaseTreeNode root) {
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