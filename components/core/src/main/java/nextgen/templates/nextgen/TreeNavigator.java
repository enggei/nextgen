package nextgen.templates.nextgen;

public class TreeNavigator {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _packageName;
	private Object _name;
	private Object _rootNodeExpression;
	private Object _baseTreeNode;
	private java.util.List<Object> _imports = new java.util.ArrayList<>();
	private java.util.List<Object> _constructorStatements = new java.util.ArrayList<>();
	private java.util.List<Object> _onSelectionStatements = new java.util.ArrayList<>();
	private java.util.List<Object> _treeNodes = new java.util.ArrayList<>();
	private java.util.List<Object> _methods = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _fields = new java.util.ArrayList<>();

	TreeNavigator(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Deprecated
	public java.util.UUID uuid() {
		return uuid;
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
		st.add("baseTreeNode", _baseTreeNode);
		for (Object o : _imports) st.add("imports", o);
		for (Object o : _constructorStatements) st.add("constructorStatements", o);
		for (Object o : _onSelectionStatements) st.add("onSelectionStatements", o);
		for (Object o : _treeNodes) st.add("treeNodes", o);
		for (Object o : _methods) st.add("methods", o);
		for (java.util.Map<String, Object> map : _fields) st.addAggr("fields.{type,name}", map.get("type"), map.get("name"));
		return st.render().trim();
	}

	public TreeNavigator setPackageName(Object value) {
		this._packageName = value;
		return this;
	}

	public Object getPackageName() {
		return this._packageName;
	}

	public Object getPackageName(Object defaultValue) {
		return this._packageName == null ? defaultValue : this._packageName;
	}

	public boolean hasPackageName() {
		return this._packageName != null;
	}

	public TreeNavigator removePackageName() {
		this._packageName = null;
		return this;
	} 

	public TreeNavigator setName(Object value) {
		this._name = value;
		return this;
	}

	public Object getName() {
		return this._name;
	}

	public Object getName(Object defaultValue) {
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

	public TreeNavigator setBaseTreeNode(Object value) {
		this._baseTreeNode = value;
		return this;
	}

	public Object getBaseTreeNode() {
		return this._baseTreeNode;
	}

	public Object getBaseTreeNode(Object defaultValue) {
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

	public TreeNavigator addOnSelectionStatements(Object value) {
		this._onSelectionStatements.add(value);
		return this;
	}

	public TreeNavigator setOnSelectionStatements(Object[] value) {
		this._onSelectionStatements.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public TreeNavigator setOnSelectionStatements(java.util.Collection<Object> values) {
		this._onSelectionStatements.addAll(values);
		return this;
	}

	public TreeNavigator removeOnSelectionStatements(Object value) {
		this._onSelectionStatements.remove(value);
		return this;
	}

	public TreeNavigator removeOnSelectionStatements(int index) {
		this._onSelectionStatements.remove(index);
		return this;
	}

	public java.util.List<Object> getOnSelectionStatements() {
		return this._onSelectionStatements;
	} 

	public TreeNavigator addTreeNodes(Object value) {
		this._treeNodes.add(value);
		return this;
	}

	public TreeNavigator setTreeNodes(Object[] value) {
		this._treeNodes.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public TreeNavigator setTreeNodes(java.util.Collection<Object> values) {
		this._treeNodes.addAll(values);
		return this;
	}

	public TreeNavigator removeTreeNodes(Object value) {
		this._treeNodes.remove(value);
		return this;
	}

	public TreeNavigator removeTreeNodes(int index) {
		this._treeNodes.remove(index);
		return this;
	}

	public java.util.List<Object> getTreeNodes() {
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

	public TreeNavigator addFields(Object _type, Object _name) {
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

	public static final class TreeNavigator_Fields {

		Object _type;
		Object _name;

		public TreeNavigator_Fields(Object _type, Object _name) {
			this._type = _type;
			this._name = _name;
		}

		private TreeNavigator_Fields(java.util.Map<String, Object> map) {
			this._type = (Object) map.get("type");
			this._name = (Object) map.get("name");
		}

		public Object getType() {
			return this._type;
		}

		public Object getName() {
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

	static final String st = "TreeNavigator(packageName,imports,name,fields,constructorStatements,rootNodeExpression,onSelectionStatements,baseTreeNode,treeNodes,methods) ::= <<package ~packageName~;\n" + 
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
				"	private final STAppPresentationModel presentationModel;\n" + 
				"	private final DefaultTreeModel treeModel;\n" + 
				"\n" + 
				"	~fields:{it|private ~it.type~ ~it.name~;};separator=\"\\n\"~\n" + 
				"\n" + 
				"	public ~name~(STAppPresentationModel presentationModel~if(fields)~, ~fields:{it|~it.type~ ~it.name~};separator=\", \"~~endif~) {\n" + 
				"		super(new BorderLayout());\n" + 
				"\n" + 
				"		~fields:{it|this.~it.name~ = ~it.name~;};separator=\"\\n\"~\n" + 
				"		~constructorStatements:{it|~it~};separator=\"\\n\"~\n" + 
				"\n" + 
				"		this.presentationModel = presentationModel;\n" + 
				"\n" + 
				"		treeModel = new DefaultTreeModel(~rootNodeExpression~);\n" + 
				"		tree.setModel(treeModel);\n" + 
				"		ToolTipManager.sharedInstance().registerComponent(tree);\n" + 
				"\n" + 
				"		tree.setCellRenderer(new DefaultTreeCellRenderer() {\n" + 
				"\n" + 
				"			@Override\n" + 
				"			public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {\n" + 
				"				final boolean isBaseTreeNode = value instanceof BaseTreeNode;\n" + 
				"				if (isBaseTreeNode) {\n" + 
				"					final BaseTreeNode<?> baseTreeNode = (BaseTreeNode<?>) value;\n" + 
				"					final ImageIcon icon = baseTreeNode.getIcon();\n" + 
				"					setIcon(icon);\n" + 
				"					setOpenIcon(icon);\n" + 
				"					setClosedIcon(icon);\n" + 
				"					setLeafIcon(icon);\n" + 
				"					setToolTipText(baseTreeNode.getTooltip());\n" + 
				"					return super.getTreeCellRendererComponent(tree, baseTreeNode.getLabel(), sel, expanded, leaf, row, hasFocus);\n" + 
				"				}\n" + 
				"				return super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);\n" + 
				"			}\n" + 
				"		});\n" + 
				"\n" + 
				"		tree.addMouseListener(new MouseAdapter() {\n" + 
				"			@Override\n" + 
				"			public void mouseClicked(MouseEvent e) {\n" + 
				"				if (SwingUtilities.isRightMouseButton(e)) {\n" + 
				"\n" + 
				"					final TreePath selectionPath = tree.getPathForLocation(e.getX(), e.getY());\n" + 
				"					if (selectionPath == null) return;\n" + 
				"					final Object lastPathComponent = selectionPath.getLastPathComponent();\n" + 
				"					if (!(lastPathComponent instanceof BaseTreeNode<?>)) return;\n" + 
				"\n" + 
				"					showPopup((BaseTreeNode<?>) lastPathComponent, e.getX(), e.getY());\n" + 
				"				}\n" + 
				"			}\n" + 
				"		});\n" + 
				"\n" + 
				"		tree.addKeyListener(new KeyAdapter() {\n" + 
				"			@Override\n" + 
				"			public void keyPressed(KeyEvent e) {\n" + 
				"\n" + 
				"				if (e.getKeyCode() == KeyEvent.VK_SPACE) {\n" + 
				"					final TreePath selectionPath = tree.getSelectionPath();\n" + 
				"					if (selectionPath == null) return;\n" + 
				"					final Object lastPathComponent = selectionPath.getLastPathComponent();\n" + 
				"					if (!(lastPathComponent instanceof BaseTreeNode<?>)) return;\n" + 
				"\n" + 
				"					final Rectangle bounds = tree.getPathBounds(selectionPath);\n" + 
				"					if (bounds == null) return;\n" + 
				"\n" + 
				"					showPopup((BaseTreeNode<?>) lastPathComponent, (int) bounds.getX(), (int) bounds.getY());\n" + 
				"				}\n" + 
				"			}\n" + 
				"		});\n" + 
				"\n" + 
				"		tree.addTreeSelectionListener(e -> {\n" + 
				"			if (e.getNewLeadSelectionPath() == null) return;\n" + 
				"\n" + 
				"			if (tree.getSelectionCount() == 1) {\n" + 
				"				final TreePath path = e.getPath();\n" + 
				"				final Object lastPathComponent = path.getLastPathComponent();\n" + 
				"\n" + 
				"				~onSelectionStatements:{it|~it~};separator=\"\\n\"~\n" + 
				"			}\n" + 
				"		});\n" + 
				"\n" + 
				"		setPreferredSize(new Dimension(300, 600));\n" + 
				"		add(new JScrollPane(tree), BorderLayout.CENTER);\n" + 
				"	}\n" + 
				"\n" + 
				"	~baseTreeNode~\n" + 
				"\n" + 
				"	~treeNodes:{it|~it~};separator=\"\\n\\n\"~	\n" + 
				"\n" + 
				"	private Action newAction(String name, Consumer<ActionEvent> actionEventConsumer) {\n" + 
				"		return new AbstractAction(name) {\n" + 
				"			@Override\n" + 
				"			public void actionPerformed(ActionEvent e) {\n" + 
				"				actionEventConsumer.accept(e);\n" + 
				"			}\n" + 
				"		};\n" + 
				"	}\n" + 
				"\n" + 
				"	private void showPopup(BaseTreeNode<?> lastPathComponent, int x, int y) {\n" + 
				"		final List<Action> actions = lastPathComponent.getActions();\n" + 
				"		if (actions.isEmpty()) return;\n" + 
				"\n" + 
				"		final JPopupMenu pop = new JPopupMenu();\n" + 
				"		pop.add(\"With \" + presentationModel.cut(lastPathComponent.getLabel()) + \" :\");\n" + 
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
				"	~methods:{it|~it~};separator=\"\\n\\n\"~\n" + 
				"} >>";
}  