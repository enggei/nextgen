package nextgen.templates.javaswing;

public class TreeModel {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _packageName;
	private Object _nodeType;
	private Object _name;
	private java.util.List<Object> _imports = new java.util.ArrayList<>();
	private java.util.List<Object> _methods = new java.util.ArrayList<>();
	private java.util.List<Object> _constructorStatements = new java.util.ArrayList<>();

	TreeModel(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("TreeModel");
		st.add("packageName", _packageName);
		st.add("nodeType", _nodeType);
		st.add("name", _name);
		for (Object o : _imports) st.add("imports", o);
		for (Object o : _methods) st.add("methods", o);
		for (Object o : _constructorStatements) st.add("constructorStatements", o);
		return st.render().trim();
	}

	public TreeModel setPackageName(Object value) {
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

	public TreeModel removePackageName() {
		this._packageName = null;
		return this;
	} 

	public TreeModel setNodeType(Object value) {
		this._nodeType = value;
		return this;
	}

	public Object getNodeType() {
		return this._nodeType;
	}

	public Object getNodeType(Object defaultValue) {
		return this._nodeType == null ? defaultValue : this._nodeType;
	}

	public boolean hasNodeType() {
		return this._nodeType != null;
	}

	public TreeModel removeNodeType() {
		this._nodeType = null;
		return this;
	} 

	public TreeModel setName(Object value) {
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

	public TreeModel removeName() {
		this._name = null;
		return this;
	} 

	public TreeModel addImports(Object value) {
		this._imports.add(value);
		return this;
	}

	public TreeModel setImports(Object[] value) {
		this._imports.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public TreeModel setImports(java.util.Collection<Object> values) {
		this._imports.addAll(values);
		return this;
	}

	public TreeModel removeImports(Object value) {
		this._imports.remove(value);
		return this;
	}

	public TreeModel removeImports(int index) {
		this._imports.remove(index);
		return this;
	}

	public java.util.List<Object> getImports() {
		return this._imports;
	} 

	public TreeModel addMethods(Object value) {
		this._methods.add(value);
		return this;
	}

	public TreeModel setMethods(Object[] value) {
		this._methods.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public TreeModel setMethods(java.util.Collection<Object> values) {
		this._methods.addAll(values);
		return this;
	}

	public TreeModel removeMethods(Object value) {
		this._methods.remove(value);
		return this;
	}

	public TreeModel removeMethods(int index) {
		this._methods.remove(index);
		return this;
	}

	public java.util.List<Object> getMethods() {
		return this._methods;
	} 

	public TreeModel addConstructorStatements(Object value) {
		this._constructorStatements.add(value);
		return this;
	}

	public TreeModel setConstructorStatements(Object[] value) {
		this._constructorStatements.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public TreeModel setConstructorStatements(java.util.Collection<Object> values) {
		this._constructorStatements.addAll(values);
		return this;
	}

	public TreeModel removeConstructorStatements(Object value) {
		this._constructorStatements.remove(value);
		return this;
	}

	public TreeModel removeConstructorStatements(int index) {
		this._constructorStatements.remove(index);
		return this;
	}

	public java.util.List<Object> getConstructorStatements() {
		return this._constructorStatements;
	} 


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		TreeModel that = (TreeModel) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "TreeModel(packageName,imports,methods,constructorStatements,nodeType,name) ::= <<package ~packageName~;\n" + 
				"\n" + 
				"import javax.swing.tree.*;\n" + 
				"import java.util.Optional;\n" + 
				"\n" + 
				"~imports:{it|~it~};separator=\"\\n\"~\n" + 
				"\n" + 
				"public class ~name~ extends DefaultTreeModel {\n" + 
				"\n" + 
				"	public ~name~(~nodeType~ root) {\n" + 
				"		super(root);\n" + 
				"		~constructorStatements:{it|~it~};separator=\"\\n\"~\n" + 
				"	}\n" + 
				"\n" + 
				"	~methods:{it|~it~};separator=\"\\n\\n\"~\n" + 
				"\n" + 
				"	protected Optional<NavigatorTreeNode<?>~gt()~ find(java.util.function.Predicate<NavigatorTreeNode<?>~gt()~ predicate) {\n" + 
				"		return find((NavigatorTreeNode<?>) getRoot(), predicate);\n" + 
				"	}\n" + 
				"\n" + 
				"	protected <T extends NavigatorTreeNode<?>~gt()~ Optional<T> find(Class<T> nodeType) {\n" + 
				"		return find((NavigatorTreeNode<?>) getRoot(), navigatorTreeNode ->\n" + 
				"				navigatorTreeNode.getClass().isAssignableFrom(nodeType));\n" + 
				"	}\n" + 
				"\n" + 
				"	protected <T extends NavigatorTreeNode<?>~gt()~ Optional<T> find(Class<T> nodeType, java.util.function.Predicate<T> predicate) {\n" + 
				"		return find((NavigatorTreeNode<?>) getRoot(), navigatorTreeNode -> navigatorTreeNode.getClass()\n" + 
				"				.isAssignableFrom(nodeType) && predicate.test((T) navigatorTreeNode));\n" + 
				"	}\n" + 
				"\n" + 
				"	protected <T extends NavigatorTreeNode<?>~gt()~ Optional<T> find(NavigatorTreeNode<?> parent, java.util.function.Predicate<NavigatorTreeNode<?>~gt()~ predicate) {\n" + 
				"		final int childCount = parent.getChildCount();\n" + 
				"		for (int i = 0; i < childCount; i++) {\n" + 
				"			final NavigatorTreeNode<?> childAt = (NavigatorTreeNode<?>) parent.getChildAt(i);\n" + 
				"			if (predicate.test(childAt))\n" + 
				"				return Optional.of((T) new TreePath(childAt.getPath()).getLastPathComponent());\n" + 
				"			else {\n" + 
				"				final Optional<T> node = find(childAt, predicate);\n" + 
				"				if (node.isPresent()) return node;\n" + 
				"			}\n" + 
				"		}\n" + 
				"		return Optional.empty();\n" + 
				"	}\n" + 
				"\n" + 
				"	private void addNodeInSortedOrder(NavigatorTreeNode<?> parent, NavigatorTreeNode<?> child) {\n" + 
				"\n" + 
				"		int n = parent.getChildCount();\n" + 
				"		if (n == 0) {\n" + 
				"			parent.add(child);\n" + 
				"			nodesWereInserted(parent, new int[]{n});\n" + 
				"			return;\n" + 
				"		}\n" + 
				"\n" + 
				"		for (int i = 0; i < n; i++) {\n" + 
				"			final NavigatorTreeNode<?> node = (NavigatorTreeNode<?>) parent.getChildAt(i);\n" + 
				"			if (node.getLabel().compareTo(child.getLabel()) > 0) {\n" + 
				"				parent.insert(child, i);\n" + 
				"				nodesWereInserted(parent, new int[]{i});\n" + 
				"				return;\n" + 
				"			}\n" + 
				"		}\n" + 
				"\n" + 
				"		parent.add(child);\n" + 
				"		nodesWereInserted(parent, new int[]{n});\n" + 
				"	}\n" + 
				"} >>";
}  