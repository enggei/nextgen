package nextgen.templates.nextgen;

public class TreeNavigator {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private String _packageName;
	private String _name;
	private Object _rootNodeExpression;
	private String _preferredWidth;
	private String _preferredHeight;
	private BaseTreeNode _baseTreeNode;
	private java.util.List<Object> _imports = new java.util.ArrayList<>();
	private java.util.List<Object> _constructorStatements = new java.util.ArrayList<>();
	private java.util.List<Object> _treeNodesSelected = new java.util.ArrayList<>();
	private java.util.List<Object> _unhandledNodeSelectedStatements = new java.util.ArrayList<>();
	private java.util.List<EventSubscription> _events = new java.util.ArrayList<>();
	private java.util.List<TreeNode> _treeNodes = new java.util.ArrayList<>();
	private java.util.List<Object> _methods = new java.util.ArrayList<>();
	private java.util.List<Object> _treeModelConstructorStatements = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _fields = new java.util.ArrayList<>();

	TreeNavigator(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("TreeNavigator");
		st.add("packageName", _packageName);
		st.add("name", _name);
		st.add("rootNodeExpression", _rootNodeExpression);
		st.add("preferredWidth", _preferredWidth);
		st.add("preferredHeight", _preferredHeight);
		st.add("baseTreeNode", _baseTreeNode);
		for (Object o : _imports) st.add("imports", o);
		for (Object o : _constructorStatements) st.add("constructorStatements", o);
		for (Object o : _treeNodesSelected) st.add("treeNodesSelected", o);
		for (Object o : _unhandledNodeSelectedStatements) st.add("unhandledNodeSelectedStatements", o);
		for (Object o : _events) st.add("events", o);
		for (Object o : _treeNodes) st.add("treeNodes", o);
		for (Object o : _methods) st.add("methods", o);
		for (Object o : _treeModelConstructorStatements) st.add("treeModelConstructorStatements", o);
		for (java.util.Map<String, Object> map : _fields) st.addAggr("fields.{type,name}", map.get("type"), map.get("name"));
		return st.render().trim();
	}

	public TreeNavigator setPackageName(String value) {
		this._packageName = value;
		return this;
	}

	public String getPackageName() {
		return this._packageName;
	}

	public String getPackageName(String defaultValue) {
		return this._packageName == null ? defaultValue : this._packageName;
	}

	public boolean hasPackageName() {
		return this._packageName != null;
	}

	public TreeNavigator removePackageName() {
		this._packageName = null;
		return this;
	} 

	public TreeNavigator setName(String value) {
		this._name = value;
		return this;
	}

	public String getName() {
		return this._name;
	}

	public String getName(String defaultValue) {
		return this._name == null ? defaultValue : this._name;
	}

	public boolean hasName() {
		return this._name != null;
	}

	public TreeNavigator removeName() {
		this._name = null;
		return this;
	} 

	public TreeNavigator setRootNodeExpression(Object value) {
		this._rootNodeExpression = value;
		return this;
	}

	public Object getRootNodeExpression() {
		return this._rootNodeExpression;
	}

	public Object getRootNodeExpression(Object defaultValue) {
		return this._rootNodeExpression == null ? defaultValue : this._rootNodeExpression;
	}

	public boolean hasRootNodeExpression() {
		return this._rootNodeExpression != null;
	}

	public TreeNavigator removeRootNodeExpression() {
		this._rootNodeExpression = null;
		return this;
	} 

	public TreeNavigator setPreferredWidth(String value) {
		this._preferredWidth = value;
		return this;
	}

	public String getPreferredWidth() {
		return this._preferredWidth;
	}

	public String getPreferredWidth(String defaultValue) {
		return this._preferredWidth == null ? defaultValue : this._preferredWidth;
	}

	public boolean hasPreferredWidth() {
		return this._preferredWidth != null;
	}

	public TreeNavigator removePreferredWidth() {
		this._preferredWidth = null;
		return this;
	} 

	public TreeNavigator setPreferredHeight(String value) {
		this._preferredHeight = value;
		return this;
	}

	public String getPreferredHeight() {
		return this._preferredHeight;
	}

	public String getPreferredHeight(String defaultValue) {
		return this._preferredHeight == null ? defaultValue : this._preferredHeight;
	}

	public boolean hasPreferredHeight() {
		return this._preferredHeight != null;
	}

	public TreeNavigator removePreferredHeight() {
		this._preferredHeight = null;
		return this;
	} 

	public TreeNavigator setBaseTreeNode(BaseTreeNode value) {
		this._baseTreeNode = value;
		return this;
	}

	public BaseTreeNode getBaseTreeNode() {
		return this._baseTreeNode;
	}

	public BaseTreeNode getBaseTreeNode(BaseTreeNode defaultValue) {
		return this._baseTreeNode == null ? defaultValue : this._baseTreeNode;
	}

	public boolean hasBaseTreeNode() {
		return this._baseTreeNode != null;
	}

	public TreeNavigator removeBaseTreeNode() {
		this._baseTreeNode = null;
		return this;
	} 

	public TreeNavigator addImports(Object value) {
		this._imports.add(value);
		return this;
	}

	public TreeNavigator setImports(Object[] value) {
		this._imports.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public TreeNavigator setImports(java.util.Collection<Object> values) {
		this._imports.addAll(values);
		return this;
	}

	public TreeNavigator removeImports(Object value) {
		this._imports.remove(value);
		return this;
	}

	public TreeNavigator removeImports(int index) {
		this._imports.remove(index);
		return this;
	}

	public java.util.List<Object> getImports() {
		return this._imports;
	} 

	public TreeNavigator addConstructorStatements(Object value) {
		this._constructorStatements.add(value);
		return this;
	}

	public TreeNavigator setConstructorStatements(Object[] value) {
		this._constructorStatements.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public TreeNavigator setConstructorStatements(java.util.Collection<Object> values) {
		this._constructorStatements.addAll(values);
		return this;
	}

	public TreeNavigator removeConstructorStatements(Object value) {
		this._constructorStatements.remove(value);
		return this;
	}

	public TreeNavigator removeConstructorStatements(int index) {
		this._constructorStatements.remove(index);
		return this;
	}

	public java.util.List<Object> getConstructorStatements() {
		return this._constructorStatements;
	} 

	public TreeNavigator addTreeNodesSelected(Object value) {
		this._treeNodesSelected.add(value);
		return this;
	}

	public TreeNavigator setTreeNodesSelected(Object[] value) {
		this._treeNodesSelected.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public TreeNavigator setTreeNodesSelected(java.util.Collection<Object> values) {
		this._treeNodesSelected.addAll(values);
		return this;
	}

	public TreeNavigator removeTreeNodesSelected(Object value) {
		this._treeNodesSelected.remove(value);
		return this;
	}

	public TreeNavigator removeTreeNodesSelected(int index) {
		this._treeNodesSelected.remove(index);
		return this;
	}

	public java.util.List<Object> getTreeNodesSelected() {
		return this._treeNodesSelected;
	} 

	public TreeNavigator addUnhandledNodeSelectedStatements(Object value) {
		this._unhandledNodeSelectedStatements.add(value);
		return this;
	}

	public TreeNavigator setUnhandledNodeSelectedStatements(Object[] value) {
		this._unhandledNodeSelectedStatements.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public TreeNavigator setUnhandledNodeSelectedStatements(java.util.Collection<Object> values) {
		this._unhandledNodeSelectedStatements.addAll(values);
		return this;
	}

	public TreeNavigator removeUnhandledNodeSelectedStatements(Object value) {
		this._unhandledNodeSelectedStatements.remove(value);
		return this;
	}

	public TreeNavigator removeUnhandledNodeSelectedStatements(int index) {
		this._unhandledNodeSelectedStatements.remove(index);
		return this;
	}

	public java.util.List<Object> getUnhandledNodeSelectedStatements() {
		return this._unhandledNodeSelectedStatements;
	} 

	public TreeNavigator addEvents(EventSubscription value) {
		this._events.add(value);
		return this;
	}

	public TreeNavigator setEvents(EventSubscription[] value) {
		this._events.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public TreeNavigator setEvents(java.util.Collection<EventSubscription> values) {
		this._events.addAll(values);
		return this;
	}

	public TreeNavigator removeEvents(EventSubscription value) {
		this._events.remove(value);
		return this;
	}

	public TreeNavigator removeEvents(int index) {
		this._events.remove(index);
		return this;
	}

	public java.util.List<EventSubscription> getEvents() {
		return this._events;
	} 

	public TreeNavigator addTreeNodes(TreeNode value) {
		this._treeNodes.add(value);
		return this;
	}

	public TreeNavigator setTreeNodes(TreeNode[] value) {
		this._treeNodes.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public TreeNavigator setTreeNodes(java.util.Collection<TreeNode> values) {
		this._treeNodes.addAll(values);
		return this;
	}

	public TreeNavigator removeTreeNodes(TreeNode value) {
		this._treeNodes.remove(value);
		return this;
	}

	public TreeNavigator removeTreeNodes(int index) {
		this._treeNodes.remove(index);
		return this;
	}

	public java.util.List<TreeNode> getTreeNodes() {
		return this._treeNodes;
	} 

	public TreeNavigator addMethods(Object value) {
		this._methods.add(value);
		return this;
	}

	public TreeNavigator setMethods(Object[] value) {
		this._methods.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public TreeNavigator setMethods(java.util.Collection<Object> values) {
		this._methods.addAll(values);
		return this;
	}

	public TreeNavigator removeMethods(Object value) {
		this._methods.remove(value);
		return this;
	}

	public TreeNavigator removeMethods(int index) {
		this._methods.remove(index);
		return this;
	}

	public java.util.List<Object> getMethods() {
		return this._methods;
	} 

	public TreeNavigator addTreeModelConstructorStatements(Object value) {
		this._treeModelConstructorStatements.add(value);
		return this;
	}

	public TreeNavigator setTreeModelConstructorStatements(Object[] value) {
		this._treeModelConstructorStatements.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public TreeNavigator setTreeModelConstructorStatements(java.util.Collection<Object> values) {
		this._treeModelConstructorStatements.addAll(values);
		return this;
	}

	public TreeNavigator removeTreeModelConstructorStatements(Object value) {
		this._treeModelConstructorStatements.remove(value);
		return this;
	}

	public TreeNavigator removeTreeModelConstructorStatements(int index) {
		this._treeModelConstructorStatements.remove(index);
		return this;
	}

	public java.util.List<Object> getTreeModelConstructorStatements() {
		return this._treeModelConstructorStatements;
	} 

	public TreeNavigator addFields(Object _type, String _name) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("type", _type);
		map.put("name", _name);
		this._fields.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getFields() {
		return this._fields;
	}

	public TreeNavigator addFields(TreeNavigator_Fields value) {
		return addFields(value._type, value._name);
	}

	public java.util.stream.Stream<TreeNavigator_Fields> streamFields() {
		return this._fields.stream().map(TreeNavigator_Fields::new);
	}

	public java.util.List<Object> getFields_Type() {
		return streamFields().map(TreeNavigator_Fields::getType).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<String> getFields_Name() {
		return streamFields().map(TreeNavigator_Fields::getName).collect(java.util.stream.Collectors.toList());
	}


	public static final class TreeNavigator_Fields {

		Object _type;
		String _name;

		public TreeNavigator_Fields(Object _type, String _name) {
			this._type = _type;
			this._name = _name;
		}

		private TreeNavigator_Fields(java.util.Map<String, Object> map) {
			this._type = (Object) map.get("type");
			this._name = (String) map.get("name");
		}

		public Object getType() {
			return this._type;
		}

		public String getName() {
			return this._name;
		}

	}  

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		TreeNavigator that = (TreeNavigator) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "TreeNavigator(packageName,imports,name,fields,rootNodeExpression,preferredWidth,preferredHeight,constructorStatements,treeNodesSelected,unhandledNodeSelectedStatements,events,baseTreeNode,treeNodes,methods,treeModelConstructorStatements) ::= <<package ~packageName~;\n" + 
				"\n" + 
				"import nextgen.utils.SwingUtil;\n" + 
				"~imports:{it|import ~it~;};separator=\"\\n\"~\n" + 
				"\n" + 
				"import javax.swing.*;\n" + 
				"import javax.swing.tree.*;\n" + 
				"import java.awt.*;\n" + 
				"import java.awt.event.*;\n" + 
				"import java.util.List;\n" + 
				"import java.util.*;\n" + 
				"import java.util.function.Consumer;\n" + 
				"\n" + 
				"public class ~name~ extends JPanel {\n" + 
				"\n" + 
				"	private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(~name~.class);\n" + 
				"\n" + 
				"	private final JTree tree = new JTree();\n" + 
				"	private final ~name~TreeModel treeModel;\n" + 
				"\n" + 
				"	~fields:{it|private ~it.type~ ~it.name~;};separator=\"\\n\"~\n" + 
				"\n" + 
				"	public ~name~(~fields:{it|~it.type~ ~it.name~};separator=\", \"~) {\n" + 
				"		super(new BorderLayout());\n" + 
				"\n" + 
				"		~fields:{it|this.~it.name~ = ~it.name~;};separator=\"\\n\"~\n" + 
				"\n" + 
				"		treeModel = new ~name~TreeModel(~rootNodeExpression~);\n" + 
				"		tree.setModel(treeModel);\n" + 
				"		ToolTipManager.sharedInstance().registerComponent(tree);\n" + 
				"\n" + 
				"		tree.setCellRenderer(new ~name~.~name~CellRenderer());\n" + 
				"		tree.addKeyListener(new ~name~.~name~KeyListener());\n" + 
				"		tree.addMouseListener(new ~name~.~name~MouseListener());\n" + 
				"\n" + 
				"		setPreferredSize(new Dimension(~if(preferredWidth)~~preferredWidth~~else~400~endif~, ~if(preferredHeight)~~preferredHeight~~else~600~endif~));\n" + 
				"		add(new JScrollPane(tree), BorderLayout.CENTER);\n" + 
				"\n" + 
				"		~constructorStatements:{it|~it~};separator=\"\\n\"~\n" + 
				"	}\n" + 
				"\n" + 
				"	private final class ~name~CellRenderer extends DefaultTreeCellRenderer {\n" + 
				"		@Override\n" + 
				"		public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {\n" + 
				"			final BaseTreeNode<?> node = (BaseTreeNode<?>) value;\n" + 
				"			final ImageIcon icon = node.getIcon();\n" + 
				"			setIcon(icon);\n" + 
				"			setOpenIcon(icon);\n" + 
				"			setClosedIcon(icon);\n" + 
				"			setLeafIcon(icon);\n" + 
				"			setToolTipText(node.getTooltip());\n" + 
				"			return super.getTreeCellRendererComponent(tree, node.getLabel(), sel, expanded, leaf, row, hasFocus);\n" + 
				"		}\n" + 
				"	}\n" + 
				"\n" + 
				"	private final class ~name~KeyListener extends KeyAdapter {\n" + 
				"		@Override\n" + 
				"		public void keyPressed(KeyEvent e) {\n" + 
				"			if (e.getKeyCode() == KeyEvent.VK_SPACE) {\n" + 
				"				final TreePath selectionPath = tree.getSelectionPath();\n" + 
				"				if (selectionPath == null) return;\n" + 
				"				final Object lastPathComponent = selectionPath.getLastPathComponent();\n" + 
				"				if (!(lastPathComponent instanceof BaseTreeNode<?>)) return;\n" + 
				"				final Rectangle bounds = tree.getPathBounds(selectionPath);\n" + 
				"				if (bounds == null) return;\n" + 
				"\n" + 
				"				showPopup((BaseTreeNode<?>) lastPathComponent, (int) bounds.getX(), (int) bounds.getY());\n" + 
				"			}\n" + 
				"		}\n" + 
				"	}\n" + 
				"\n" + 
				"	private final class ~name~MouseListener extends MouseAdapter {\n" + 
				"      @Override\n" + 
				"      public void mouseClicked(MouseEvent e) {\n" + 
				"         if (SwingUtilities.isRightMouseButton(e)) {\n" + 
				"\n" + 
				"            final TreePath selectionPath = tree.getPathForLocation(e.getX(), e.getY());\n" + 
				"            if (selectionPath == null) return;\n" + 
				"            final Object lastPathComponent = selectionPath.getLastPathComponent();\n" + 
				"            if (!(lastPathComponent instanceof BaseTreeNode<?>)) return;\n" + 
				"\n" + 
				"            showPopup((BaseTreeNode<?>) lastPathComponent, e.getX(), e.getY());\n" + 
				"\n" + 
				"         } else {\n" + 
				"\n" + 
				"            final TreePath selectionPath = tree.getPathForLocation(e.getX(), e.getY());\n" + 
				"            if (selectionPath == null) return;\n" + 
				"            final Object lastPathComponent = selectionPath.getLastPathComponent();\n" + 
				"            if (!(lastPathComponent instanceof BaseTreeNode<?>)) return;\n" + 
				"\n" + 
				"            appModel().doLaterInTransaction(transaction -> {\n" + 
				"					~treeNodesSelected:{it|if (is~it~(lastPathComponent)) \n" + 
				"	on~it~Selected((~it~) lastPathComponent);\n" + 
				"};separator=\"else \"~~if(treeNodesSelected)~					else \n" + 
				"		~endif~						onUnhandledNodeSelected((BaseTreeNode<?>) lastPathComponent);\n" + 
				"            });\n" + 
				"         }\n" + 
				"      }\n" + 
				"   }\n" + 
				"\n" + 
				"   private void onUnhandledNodeSelected(BaseTreeNode<?> selectedNode) {\n" + 
				"   	~unhandledNodeSelectedStatements:{it|~it~};separator=\"\\n\"~\n" + 
				"   }\n" + 
				"\n" + 
				"	~events:{it|~it~};separator=\"\\n\\n\"~\n" + 
				"   \n" + 
				"	~baseTreeNode~\n" + 
				"\n" + 
				"	~treeNodes:{it|~it~};separator=\"\\n\\n\"~	\n" + 
				"\n" + 
				"	private Action newAction(String name, Consumer<ActionEvent> actionEventConsumer) {\n" + 
				"		return new AbstractAction(name) {\n" + 
				"			@Override\n" + 
				"			public void actionPerformed(ActionEvent e) {\n" + 
				"				SwingUtilities.invokeLater(() -> actionEventConsumer.accept(e));\n" + 
				"			}\n" + 
				"		};\n" + 
				"	}\n" + 
				"\n" + 
				"	private Action newTransactionAction(String name, Consumer<ActionEvent> actionEventConsumer) {\n" + 
				"		return new AbstractAction(name) {\n" + 
				"			@Override\n" + 
				"			public void actionPerformed(ActionEvent e) {\n" + 
				"				SwingUtilities.invokeLater(() -> appModel().doInTransaction(transaction -> actionEventConsumer.accept(e)));\n" + 
				"			}\n" + 
				"		};\n" + 
				"	}\n" + 
				"\n" + 
				"	private void showPopup(BaseTreeNode<?> lastPathComponent, int x, int y) {\n" + 
				"		final List<Action> actions = lastPathComponent.getActions();\n" + 
				"		if (actions.isEmpty()) return;\n" + 
				"\n" + 
				"		final JPopupMenu pop = new JPopupMenu();\n" + 
				"		for (Action action : actions)\n" + 
				"			pop.add(action);\n" + 
				"\n" + 
				"		SwingUtilities.invokeLater(() -> pop.show(tree, x, y));\n" + 
				"	}\n" + 
				"\n" + 
				"	public <T> java.util.stream.Stream<T> getSelectedNodes(Class<T> type) {\n" + 
				"		final TreePath[] selectionPaths = tree.getSelectionPaths();\n" + 
				"		if (selectionPaths == null || selectionPaths.length == 0) return java.util.stream.Stream.empty();\n" + 
				"		return Arrays.stream(selectionPaths)\n" + 
				"				.filter(treePath -> treePath.getLastPathComponent() != null)\n" + 
				"				.filter(treePath -> treePath.getLastPathComponent().getClass().isAssignableFrom(type))\n" + 
				"				.map(treePath -> (T) treePath.getLastPathComponent());\n" + 
				"	}\n" + 
				"\n" + 
				"	public <T> java.util.stream.Stream<T> getSelectedNodes() {\n" + 
				"		final TreePath[] selectionPaths = tree.getSelectionPaths();\n" + 
				"		if (selectionPaths == null || selectionPaths.length == 0) return java.util.stream.Stream.empty();\n" + 
				"		return Arrays.stream(selectionPaths)\n" + 
				"				.filter(treePath -> treePath.getLastPathComponent() != null)\n" + 
				"				.map(treePath -> (T) treePath.getLastPathComponent());\n" + 
				"	}\n" + 
				"\n" + 
				"	private STAppPresentationModel appModel() {\n" + 
				"		return nextgen.swing.AppModel.getInstance().getSTAppPresentationModel();\n" + 
				"	}\n" + 
				"\n" + 
				"	~methods:{it|~it~};separator=\"\\n\\n\"~\n" + 
				"\n" + 
				"	class ~name~TreeModel extends DefaultTreeModel {\n" + 
				"\n" + 
				"		public ~name~TreeModel(BaseTreeNode root) {\n" + 
				"			super(root);\n" + 
				"			~treeModelConstructorStatements:{it|~it~};separator=\"\\n\"~\n" + 
				"		}\n" + 
				"\n" + 
				"		protected Optional<BaseTreeNode<?>~gt()~ find(java.util.function.Predicate<BaseTreeNode<?>~gt()~ predicate) {\n" + 
				"			return find((BaseTreeNode<?>) getRoot(), predicate);\n" + 
				"		}\n" + 
				"\n" + 
				"		protected <T extends BaseTreeNode<?>~gt()~ Optional<T> find(Class<T> nodeType) {\n" + 
				"			final BaseTreeNode<?> root = (BaseTreeNode<?>) getRoot();\n" + 
				"			if (root.getClass().isAssignableFrom(nodeType)) return Optional.of((T) root);\n" + 
				"			return find((BaseTreeNode<?>) getRoot(), navigatorTreeNode ->\n" + 
				"					navigatorTreeNode.getClass().isAssignableFrom(nodeType));\n" + 
				"		}\n" + 
				"\n" + 
				"		protected <T extends BaseTreeNode<?>~gt()~ Optional<T> find(Class<T> nodeType, java.util.function.Predicate<T> predicate) {\n" + 
				"			final BaseTreeNode<?> root = (BaseTreeNode<?>) getRoot();\n" + 
				"			if (root.getClass().isAssignableFrom(nodeType) && predicate.test((T) root)) return Optional.of((T) root);\n" + 
				"			return find((BaseTreeNode<?>) getRoot(), navigatorTreeNode -> navigatorTreeNode.getClass()\n" + 
				"					.isAssignableFrom(nodeType) && predicate.test((T) navigatorTreeNode));\n" + 
				"		}\n" + 
				"\n" + 
				"		protected <T extends BaseTreeNode<?>~gt()~ Optional<T> find(BaseTreeNode<?> parent, java.util.function.Predicate<BaseTreeNode<?>~gt()~ predicate) {\n" + 
				"			final int childCount = parent.getChildCount();\n" + 
				"			for (int i = 0; i < childCount; i++) {\n" + 
				"				final BaseTreeNode<?> childAt = (BaseTreeNode<?>) parent.getChildAt(i);\n" + 
				"				if (predicate.test(childAt))\n" + 
				"					return Optional.of((T) new TreePath(childAt.getPath()).getLastPathComponent());\n" + 
				"				else {\n" + 
				"					final Optional<T> node = find(childAt, predicate);\n" + 
				"					if (node.isPresent()) return node;\n" + 
				"				}\n" + 
				"			}\n" + 
				"			return Optional.empty();\n" + 
				"		}\n" + 
				"\n" + 
				"		protected <T extends BaseTreeNode<?>~gt()~ Optional<T> find(BaseTreeNode<?> parent, Class<T> nodeType, java.util.function.Predicate<T> predicate) {\n" + 
				"			return find(parent, navigatorTreeNode -> navigatorTreeNode.getClass()\n" + 
				"					.isAssignableFrom(nodeType) && predicate.test((T) navigatorTreeNode));\n" + 
				"		}\n" + 
				"\n" + 
				"		private void addNodeInSortedOrderAndSelect(BaseTreeNode<?> parent, BaseTreeNode<?> child) {\n" + 
				"			addNodeInSortedOrder(parent, child);\n" + 
				"			select(child);\n" + 
				"		}\n" + 
				"\n" + 
				"		private void addNodeInSortedOrder(BaseTreeNode<?> parent, BaseTreeNode<?> child) {\n" + 
				"\n" + 
				"			int n = parent.getChildCount();\n" + 
				"			if (n == 0) {\n" + 
				"				parent.add(child);\n" + 
				"				nodesWereInserted(parent, new int[]{n});\n" + 
				"				return;\n" + 
				"			}\n" + 
				"\n" + 
				"			for (int i = 0; i < n; i++) {\n" + 
				"				final BaseTreeNode<?> node = (BaseTreeNode<?>) parent.getChildAt(i);\n" + 
				"				if (node.getLabel().compareTo(child.getLabel()) > 0) {\n" + 
				"					parent.insert(child, i);\n" + 
				"					nodesWereInserted(parent, new int[]{i});\n" + 
				"					return;\n" + 
				"				}\n" + 
				"			}\n" + 
				"\n" + 
				"			parent.add(child);\n" + 
				"			nodesWereInserted(parent, new int[]{n});\n" + 
				"		}\n" + 
				"\n" + 
				"		public void select(BaseTreeNode<?> treeNode) {\n" + 
				"			tree.scrollPathToVisible(treeNode.getThisPath());\n" + 
				"			tree.setSelectionPath(treeNode.getThisPath());\n" + 
				"		}\n" + 
				"	}\n" + 
				"} >>";
}  