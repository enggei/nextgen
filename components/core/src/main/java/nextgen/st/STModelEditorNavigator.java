package nextgen.st;

import nextgen.utils.SwingUtil;
import nextgen.st.model.*;;
import nextgen.st.domain.*;;

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

		treeModel = new STModelEditorNavigatorTreeModel(new STModelTreeNode(model));
		tree.setModel(treeModel);
		ToolTipManager.sharedInstance().registerComponent(tree);

		tree.setCellRenderer(new STModelEditorNavigator.STModelEditorNavigatorCellRenderer());
		tree.addKeyListener(new STModelEditorNavigator.STModelEditorNavigatorKeyListener());
		tree.addMouseListener(new STModelEditorNavigator.STModelEditorNavigatorMouseListener());

		setPreferredSize(new Dimension(600, 600));
		add(new JScrollPane(tree), BorderLayout.CENTER);

		org.greenrobot.eventbus.EventBus.getDefault().register(this);
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
					if (isSTModelTreeNode(lastPathComponent)) 
						onSTModelTreeNodeSelected((STModelTreeNode) lastPathComponent);
					else if (isSTKVArgumentTreeNode(lastPathComponent)) 
						onSTKVArgumentTreeNodeSelected((STKVArgumentTreeNode) lastPathComponent);
					else if (isSTKVTreeNode(lastPathComponent)) 
						onSTKVTreeNodeSelected((STKVTreeNode) lastPathComponent);
					else if (isSTParameterTreeNode(lastPathComponent)) 
						onSTParameterTreeNodeSelected((STParameterTreeNode) lastPathComponent);
					else if (isSTModelArgumentTreeNode(lastPathComponent)) 
						onSTModelArgumentTreeNodeSelected((STModelArgumentTreeNode) lastPathComponent);
					else if (isSTValueArgumentTreeNode(lastPathComponent)) 
						onSTValueArgumentTreeNodeSelected((STValueArgumentTreeNode) lastPathComponent);
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
	public void onModelEditorSTModelTreeNodeClicked(nextgen.events.ModelEditorSTModelTreeNodeClicked event) {
		System.out.println("ModelEditorSTModelTreeNodeClicked");

	}

	@org.greenrobot.eventbus.Subscribe()
	public void onModelEditorSTValueTreeNodeClicked(nextgen.events.ModelEditorSTValueTreeNodeClicked event) {
		System.out.println("ModelEditorSTValueTreeNodeClicked");

	}

	@org.greenrobot.eventbus.Subscribe()
	public void onKVDeleted(nextgen.events.KVDeleted event) {
		System.out.println("KVDeleted");
		findSTKVTreeNode(treeNode -> treeNode.uuid.equals(event.uuid)).ifPresent(treeModel::removeNodeFromParent);
	}

	@org.greenrobot.eventbus.Subscribe()
	public void onSTArgumentDeleted(nextgen.events.STArgumentDeleted event) {
		System.out.println("STArgumentDeleted");
		findSTValueArgumentTreeNode(treeNode -> treeNode.stArgumentUuid.equals(event.uuid)).ifPresent(treeModel::removeNodeFromParent);
		findSTModelArgumentTreeNode(treeNode -> treeNode.stArgumentUuid.equals(event.uuid)).ifPresent(treeModel::removeNodeFromParent);
	}

	@org.greenrobot.eventbus.Subscribe()
	public void onSTValueDeleted(nextgen.events.STValueDeleted event) {
		System.out.println("STValueDeleted");
		findSTValueArgumentTreeNode(treeNode -> treeNode.uuid.equals(event.uuid)).ifPresent(treeModel::removeNodeFromParent);
		findSTValueKVArgumentTreeNode(treeNode -> treeNode.uuid.equals(event.uuid)).ifPresent(treeModel::removeNodeFromParent);
	}

	@org.greenrobot.eventbus.Subscribe()
	public void onNewSTArgument(nextgen.events.NewSTArgument event) {
		System.out.println("NewSTArgument");
		findSTParameterTreeNode(stParameterTreeNode -> stParameterTreeNode.getModel().equals(event.parameter))
		      .ifPresent(stParameterTreeNode -> {
		         switch (event.value.getType()) {
		            case STMODEL:
		               treeModel.addNodeInSortedOrderAndSelect(stParameterTreeNode, new nextgen.st.STModelEditorNavigator.STModelArgumentTreeNode(event.value.getStModel(), event.argument));
		               break;
		            case PRIMITIVE:
		               treeModel.addNodeInSortedOrderAndSelect(stParameterTreeNode, new STModelEditorNavigator.STValueArgumentTreeNode(event.value, event.argument));
		               break;
		            case ENUM:
		               break;
		         }
		      });
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

		STModelTreeNode(nextgen.st.model.STModel model) {
			super(model, appModel().loadIcon("sq-teal"));

			this.stTemplate = appModel().findSTTemplateByUuid(model.getStTemplate());;

			setLabel(appModel().tryToFindArgument(getModel(), "name", () -> "[" + stTemplate.getName() + "]"));
			this.tooltip = "";
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
			setLabel(appModel().tryToFindArgument(getModel(), "name", () -> "[" + stTemplate.getName() + "]"));
			this.tooltip = "";
			super.nodeChanged();
		}

		@Override
		protected List<Action> getActions() {
			final List<Action> actions = super.getActions();

			appModel().doInTransaction(tx -> {
				actions.add(new nextgen.actions.CopyModel(getModel()));
				actions.add(new nextgen.actions.OpenSTModel(getModel()));
				actions.add(new nextgen.actions.VisitSTModel(getModel()));
				actions.add(new nextgen.actions.WriteSTModelToFile(getModel()));
				actions.add(new nextgen.actions.EditSTModel(getModel()));
			});

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
		nextgen.events.ModelEditorSTModelTreeNodeClicked.post(selectedNode.stTemplate, selectedNode.getModel());
	}

	// STKVArgumentTreeNode
	public class STKVArgumentTreeNode extends BaseTreeNode<nextgen.st.model.STArgument> {
		private nextgen.st.domain.STParameter stParameter;

		STKVArgumentTreeNode(nextgen.st.model.STArgument model, nextgen.st.domain.STParameter stParameter) {
			super(model, null);

			this.stParameter = stParameter;

			setLabel(appModel().tryToFindArgument(getModel().getKeyValues(), stParameter, "name", stParameter::getName));
			this.tooltip = "";

			stParameter.getKeys().forEach(stParameterKey -> getModel().getKeyValues()
					.filter(stArgumentKV -> stArgumentKV.getStParameterKey().equals(stParameterKey.getUuid()))
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
			});

			return actions;
		}

	}

	private boolean isSTKVArgumentTreeNode(Object treeNode) {
		return treeNode instanceof STKVArgumentTreeNode;
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
		private nextgen.st.domain.STParameterKey stParameterKey;

		STKVTreeNode(nextgen.st.model.STArgumentKV model, nextgen.st.model.STArgument stArgument, nextgen.st.domain.STParameterKey stParameterKey) {
			super(model, null);

			this.stArgument = stArgument;
			this.stParameterKey = stParameterKey;

			setLabel(stParameterKey.getName());
			this.tooltip = "";
			this.uuid = model.getUuid();

			final STValue stValue = model.getValue();
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
					actions.add(new nextgen.actions.SetKVArgumentFromInput(parent.getModel(), stArgument, stParameterKey, tree));
				} );
			});

			return actions;
		}

	}

	private boolean isSTKVTreeNode(Object treeNode) {
		return treeNode instanceof STKVTreeNode;
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

	// STParameterTreeNode
	public class STParameterTreeNode extends BaseTreeNode<nextgen.st.domain.STParameter> {

		private String uuid;
		private STModel stModel;

		STParameterTreeNode(nextgen.st.domain.STParameter model, STModel stModel) {
			super(model, null);

			this.stModel = stModel;

			setLabel(getModel().getName());
			this.tooltip = "";
			this.uuid = model.getUuid();

			stModel.getArgumentsSorted()
				.filter(stArgument -> stArgument.getStParameter().equals(model.getUuid()))
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
				final String fromClipboard = nextgen.utils.SwingUtil.fromClipboard();
				switch (getModel().getType()) {
					case SINGLE:
						actions.add(new nextgen.actions.SetArgumentFromInput(stModel, getModel(), tree));
						actions.add(new nextgen.actions.SetArgumentFromClipboard(stModel, getModel()));
						if (appModel().isBoolean(getModel())) actions.add(new nextgen.actions.SetArgumentToTrue(stModel, getModel()));
						break;
					case LIST:
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
		selectedNode.getParentNode(STModelTreeNode.class).ifPresent(parent -> nextgen.events.ModelEditorSTParameterTreeNodeClicked.post(selectedNode.getModel(), parent.getModel()));
	}

	// STModelArgumentTreeNode
	public class STModelArgumentTreeNode extends BaseTreeNode<nextgen.st.model.STModel> {

		private String uuid;
		private nextgen.st.model.STArgument stArgument;
		private String stArgumentUuid;
		private nextgen.st.domain.STTemplate stTemplate;

		STModelArgumentTreeNode(nextgen.st.model.STModel model, nextgen.st.model.STArgument stArgument) {
			super(model, appModel().loadIcon("sq-teal"));

			this.stArgument = stArgument;
			this.stArgumentUuid = stArgument.getUuid();
			this.stTemplate = appModel().findSTTemplateByUuid(model.getStTemplate());

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
				actions.add(new nextgen.actions.DeleteSTArgument(stArgument, tree));
			});

			return actions;
		}

	}

	private boolean isSTModelArgumentTreeNode(Object treeNode) {
		return treeNode instanceof STModelArgumentTreeNode;
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
		nextgen.events.ModelEditorSTModelTreeNodeClicked.post(selectedNode.stTemplate, selectedNode.getModel());
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

			setLabel(getModel().getValue() == null || getModel().getValue().trim().length() == 0 ? "[EMPTY]" : getModel().getValue());
			this.tooltip = "";
			this.uuid = model.getUuid();

		}

		STValueArgumentTreeNode thisNode() {
			return this;
		}

		@Override
		public void nodeChanged() {
			setLabel(getModel().getValue() == null || getModel().getValue().trim().length() == 0 ? "[EMPTY]" : getModel().getValue());
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
		nextgen.events.ModelEditorSTValueTreeNodeClicked.post(selectedNode.getModel());
	}

	// STModelKVArgumentTreeNode
	public class STModelKVArgumentTreeNode extends BaseTreeNode<nextgen.st.model.STModel> {

		private String uuid;
		private nextgen.st.model.STArgument stArgument;
		private nextgen.st.domain.STParameterKey stParameterKey;
		private String stArgumentUuid;
		private nextgen.st.domain.STTemplate stTemplate;

		STModelKVArgumentTreeNode(nextgen.st.model.STModel model, nextgen.st.model.STArgument stArgument, nextgen.st.domain.STParameterKey stParameterKey) {
			super(model, appModel().loadIcon("sq-teal"));

			this.stArgument = stArgument;
			this.stParameterKey = stParameterKey;
			this.stArgumentUuid = stArgument.getUuid();
			this.stTemplate = appModel().findSTTemplateByUuid(model.getStTemplate());

			setLabel(appModel().tryToFindArgument(getModel(), "name", () -> "[" + stParameterKey.getName() + "]"));
			this.tooltip = "";
			this.uuid = model.getUuid();

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
			});

			return actions;
		}

	}

	private boolean isSTModelKVArgumentTreeNode(Object treeNode) {
		return treeNode instanceof STModelKVArgumentTreeNode;
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
		nextgen.events.ModelEditorSTModelTreeNodeClicked.post(selectedNode.stTemplate, selectedNode.getModel());
	}

	// STValueKVArgumentTreeNode
	public class STValueKVArgumentTreeNode extends BaseTreeNode<nextgen.st.model.STValue> {

		private String uuid;
		private nextgen.st.model.STArgument stArgument;
		private nextgen.st.domain.STParameterKey stParameterKey;

		STValueKVArgumentTreeNode(nextgen.st.model.STValue model, nextgen.st.model.STArgument stArgument, nextgen.st.domain.STParameterKey stParameterKey) {
			super(model, appModel().loadIcon("sq-orange"));

			this.stArgument = stArgument;
			this.stParameterKey = stParameterKey;

			setLabel(getModel().getValue() == null || getModel().getValue().trim().length() == 0 ? "[EMPTY]" : getModel().getValue());
			this.tooltip = "";
			this.uuid = model.getUuid();

		}

		STValueKVArgumentTreeNode thisNode() {
			return this;
		}

		@Override
		public void nodeChanged() {
			setLabel(getModel().getValue() == null || getModel().getValue().trim().length() == 0 ? "[EMPTY]" : getModel().getValue());
			this.tooltip = "";
			super.nodeChanged();
		}

		@Override
		protected List<Action> getActions() {
			final List<Action> actions = super.getActions();

			appModel().doInTransaction(tx -> {
				actions.add(new nextgen.actions.DeleteSTArgument(stArgument, tree));
			});

			return actions;
		}

	}

	private boolean isSTValueKVArgumentTreeNode(Object treeNode) {
		return treeNode instanceof STValueKVArgumentTreeNode;
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