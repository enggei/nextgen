package nextgen.templates.javaswing;

public class TreeNode {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _packageName;
	private Object _name;
	private Object _baseTreeNode;
	private Object _type;
	private Object _uuidExpression;
	private java.util.List<Object> _imports = new java.util.ArrayList<>();
	private java.util.List<Object> _constructorStatements = new java.util.ArrayList<>();
	private java.util.List<GetTreeNodeAction> _actions = new java.util.ArrayList<>();
	private java.util.List<Object> _selectedStatements = new java.util.ArrayList<>();
	private java.util.List<Object> _methods = new java.util.ArrayList<>();

	TreeNode(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("TreeNode");
		st.add("packageName", _packageName);
		st.add("name", _name);
		st.add("baseTreeNode", _baseTreeNode);
		st.add("type", _type);
		st.add("uuidExpression", _uuidExpression);
		for (Object o : _imports) st.add("imports", o);
		for (Object o : _constructorStatements) st.add("constructorStatements", o);
		for (Object o : _actions) st.add("actions", o);
		for (Object o : _selectedStatements) st.add("selectedStatements", o);
		for (Object o : _methods) st.add("methods", o);
		return st.render().trim();
	}

	public TreeNode setPackageName(Object value) {
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

	public TreeNode removePackageName() {
		this._packageName = null;
		return this;
	} 

	public TreeNode setName(Object value) {
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

	public TreeNode removeName() {
		this._name = null;
		return this;
	} 

	public TreeNode setBaseTreeNode(Object value) {
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

	public TreeNode removeBaseTreeNode() {
		this._baseTreeNode = null;
		return this;
	} 

	public TreeNode setType(Object value) {
		this._type = value;
		return this;
	}

	public Object getType() {
		return this._type;
	}

	public Object getType(Object defaultValue) {
		return this._type == null ? defaultValue : this._type;
	}

	public boolean hasType() {
		return this._type != null;
	}

	public TreeNode removeType() {
		this._type = null;
		return this;
	} 

	public TreeNode setUuidExpression(Object value) {
		this._uuidExpression = value;
		return this;
	}

	public Object getUuidExpression() {
		return this._uuidExpression;
	}

	public Object getUuidExpression(Object defaultValue) {
		return this._uuidExpression == null ? defaultValue : this._uuidExpression;
	}

	public boolean hasUuidExpression() {
		return this._uuidExpression != null;
	}

	public TreeNode removeUuidExpression() {
		this._uuidExpression = null;
		return this;
	} 

	public TreeNode addImports(Object value) {
		this._imports.add(value);
		return this;
	}

	public TreeNode setImports(Object[] value) {
		this._imports.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public TreeNode setImports(java.util.Collection<Object> values) {
		this._imports.addAll(values);
		return this;
	}

	public TreeNode removeImports(Object value) {
		this._imports.remove(value);
		return this;
	}

	public TreeNode removeImports(int index) {
		this._imports.remove(index);
		return this;
	}

	public java.util.List<Object> getImports() {
		return this._imports;
	} 

	public TreeNode addConstructorStatements(Object value) {
		this._constructorStatements.add(value);
		return this;
	}

	public TreeNode setConstructorStatements(Object[] value) {
		this._constructorStatements.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public TreeNode setConstructorStatements(java.util.Collection<Object> values) {
		this._constructorStatements.addAll(values);
		return this;
	}

	public TreeNode removeConstructorStatements(Object value) {
		this._constructorStatements.remove(value);
		return this;
	}

	public TreeNode removeConstructorStatements(int index) {
		this._constructorStatements.remove(index);
		return this;
	}

	public java.util.List<Object> getConstructorStatements() {
		return this._constructorStatements;
	} 

	public TreeNode addActions(GetTreeNodeAction value) {
		this._actions.add(value);
		return this;
	}

	public TreeNode setActions(GetTreeNodeAction[] value) {
		this._actions.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public TreeNode setActions(java.util.Collection<GetTreeNodeAction> values) {
		this._actions.addAll(values);
		return this;
	}

	public TreeNode removeActions(GetTreeNodeAction value) {
		this._actions.remove(value);
		return this;
	}

	public TreeNode removeActions(int index) {
		this._actions.remove(index);
		return this;
	}

	public java.util.List<GetTreeNodeAction> getActions() {
		return this._actions;
	} 

	public TreeNode addSelectedStatements(Object value) {
		this._selectedStatements.add(value);
		return this;
	}

	public TreeNode setSelectedStatements(Object[] value) {
		this._selectedStatements.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public TreeNode setSelectedStatements(java.util.Collection<Object> values) {
		this._selectedStatements.addAll(values);
		return this;
	}

	public TreeNode removeSelectedStatements(Object value) {
		this._selectedStatements.remove(value);
		return this;
	}

	public TreeNode removeSelectedStatements(int index) {
		this._selectedStatements.remove(index);
		return this;
	}

	public java.util.List<Object> getSelectedStatements() {
		return this._selectedStatements;
	} 

	public TreeNode addMethods(Object value) {
		this._methods.add(value);
		return this;
	}

	public TreeNode setMethods(Object[] value) {
		this._methods.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public TreeNode setMethods(java.util.Collection<Object> values) {
		this._methods.addAll(values);
		return this;
	}

	public TreeNode removeMethods(Object value) {
		this._methods.remove(value);
		return this;
	}

	public TreeNode removeMethods(int index) {
		this._methods.remove(index);
		return this;
	}

	public java.util.List<Object> getMethods() {
		return this._methods;
	} 


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		TreeNode that = (TreeNode) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "TreeNode(packageName,imports,name,baseTreeNode,type,uuidExpression,constructorStatements,actions,selectedStatements,methods) ::= <<package ~packageName~;\n" + 
				"\n" + 
				"import javax.swing.*;\n" + 
				"import javax.swing.tree.*;\n" + 
				"\n" + 
				"~imports:{it|~it~};separator=\"\\n\"~\n" + 
				"\n" + 
				"public class ~name~ extends ~baseTreeNode~<~type~> {\n" + 
				"\n" + 
				"	public ~name~(~type~ model) {\n" + 
				"		super(model~if(uuidExpression)~, ~uuidExpression~~endif~);\n" + 
				"		~constructorStatements:{it|~it~};separator=\"\\n\"~\n" + 
				"	}\n" + 
				"\n" + 
				"	@Override\n" + 
				"	java.util.List<Action> getActions() {\n" + 
				"		final java.util.List<Action> actions = super.getActions();\n" + 
				"		~actions:{it|~it~};separator=\"\\n\"~\n" + 
				"		return actions;\n" + 
				"	}\n" + 
				"\n" + 
				"	@Override\n" + 
				"	public void setSelected() {\n" + 
				"		~selectedStatements:{it|~it~};separator=\"\\n\"~\n" + 
				"	}\n" + 
				"\n" + 
				"	~methods:{it|~it~};separator=\"\\n\\n\"~\n" + 
				"} >>";
}  