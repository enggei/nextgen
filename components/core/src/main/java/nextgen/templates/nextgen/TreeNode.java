package nextgen.templates.nextgen;

public class TreeNode {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private String _name;
	private Object _modelType;
	private Boolean _hasUuid;
	private Object _icon;
	private Object _labelExpression;
	private Object _tooltipExpression;
	private java.util.List<Object> _constructorStatements = new java.util.ArrayList<>();
	private java.util.List<Object> _getActionsStatements = new java.util.ArrayList<>();
	private java.util.List<Object> _actions = new java.util.ArrayList<>();
	private java.util.List<Object> _methods = new java.util.ArrayList<>();
	private java.util.List<Object> _selectionStatements = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _fields = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _privateFields = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _parameters = new java.util.ArrayList<>();

	TreeNode(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("TreeNode");
		st.add("name", _name);
		st.add("modelType", _modelType);
		st.add("hasUuid", _hasUuid);
		st.add("icon", _icon);
		st.add("labelExpression", _labelExpression);
		st.add("tooltipExpression", _tooltipExpression);
		for (Object o : _constructorStatements) st.add("constructorStatements", o);
		for (Object o : _getActionsStatements) st.add("getActionsStatements", o);
		for (Object o : _actions) st.add("actions", o);
		for (Object o : _methods) st.add("methods", o);
		for (Object o : _selectionStatements) st.add("selectionStatements", o);
		for (java.util.Map<String, Object> map : _fields) st.addAggr("fields.{type,name}", map.get("type"), map.get("name"));
		for (java.util.Map<String, Object> map : _privateFields) st.addAggr("privateFields.{type,name,init}", map.get("type"), map.get("name"), map.get("init"));
		for (java.util.Map<String, Object> map : _parameters) st.addAggr("parameters.{type,name}", map.get("type"), map.get("name"));
		return st.render().trim();
	}

	public TreeNode setName(String value) {
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

	public TreeNode removeName() {
		this._name = null;
		return this;
	} 

	public TreeNode setModelType(Object value) {
		this._modelType = value;
		return this;
	}

	public Object getModelType() {
		return this._modelType;
	}

	public Object getModelType(Object defaultValue) {
		return this._modelType == null ? defaultValue : this._modelType;
	}

	public boolean hasModelType() {
		return this._modelType != null;
	}

	public TreeNode removeModelType() {
		this._modelType = null;
		return this;
	} 

	public TreeNode setHasUuid(Boolean value) {
		this._hasUuid = value;
		return this;
	}

	public Boolean getHasUuid() {
		return this._hasUuid;
	}

	public Boolean getHasUuid(Boolean defaultValue) {
		return this._hasUuid == null ? defaultValue : this._hasUuid;
	}

	public boolean hasHasUuid() {
		return this._hasUuid != null;
	}

	public TreeNode removeHasUuid() {
		this._hasUuid = null;
		return this;
	} 

	public TreeNode setIcon(Object value) {
		this._icon = value;
		return this;
	}

	public Object getIcon() {
		return this._icon;
	}

	public Object getIcon(Object defaultValue) {
		return this._icon == null ? defaultValue : this._icon;
	}

	public boolean hasIcon() {
		return this._icon != null;
	}

	public TreeNode removeIcon() {
		this._icon = null;
		return this;
	} 

	public TreeNode setLabelExpression(Object value) {
		this._labelExpression = value;
		return this;
	}

	public Object getLabelExpression() {
		return this._labelExpression;
	}

	public Object getLabelExpression(Object defaultValue) {
		return this._labelExpression == null ? defaultValue : this._labelExpression;
	}

	public boolean hasLabelExpression() {
		return this._labelExpression != null;
	}

	public TreeNode removeLabelExpression() {
		this._labelExpression = null;
		return this;
	} 

	public TreeNode setTooltipExpression(Object value) {
		this._tooltipExpression = value;
		return this;
	}

	public Object getTooltipExpression() {
		return this._tooltipExpression;
	}

	public Object getTooltipExpression(Object defaultValue) {
		return this._tooltipExpression == null ? defaultValue : this._tooltipExpression;
	}

	public boolean hasTooltipExpression() {
		return this._tooltipExpression != null;
	}

	public TreeNode removeTooltipExpression() {
		this._tooltipExpression = null;
		return this;
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

	public TreeNode addGetActionsStatements(Object value) {
		this._getActionsStatements.add(value);
		return this;
	}

	public TreeNode setGetActionsStatements(Object[] value) {
		this._getActionsStatements.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public TreeNode setGetActionsStatements(java.util.Collection<Object> values) {
		this._getActionsStatements.addAll(values);
		return this;
	}

	public TreeNode removeGetActionsStatements(Object value) {
		this._getActionsStatements.remove(value);
		return this;
	}

	public TreeNode removeGetActionsStatements(int index) {
		this._getActionsStatements.remove(index);
		return this;
	}

	public java.util.List<Object> getGetActionsStatements() {
		return this._getActionsStatements;
	} 

	public TreeNode addActions(Object value) {
		this._actions.add(value);
		return this;
	}

	public TreeNode setActions(Object[] value) {
		this._actions.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public TreeNode setActions(java.util.Collection<Object> values) {
		this._actions.addAll(values);
		return this;
	}

	public TreeNode removeActions(Object value) {
		this._actions.remove(value);
		return this;
	}

	public TreeNode removeActions(int index) {
		this._actions.remove(index);
		return this;
	}

	public java.util.List<Object> getActions() {
		return this._actions;
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

	public TreeNode addSelectionStatements(Object value) {
		this._selectionStatements.add(value);
		return this;
	}

	public TreeNode setSelectionStatements(Object[] value) {
		this._selectionStatements.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public TreeNode setSelectionStatements(java.util.Collection<Object> values) {
		this._selectionStatements.addAll(values);
		return this;
	}

	public TreeNode removeSelectionStatements(Object value) {
		this._selectionStatements.remove(value);
		return this;
	}

	public TreeNode removeSelectionStatements(int index) {
		this._selectionStatements.remove(index);
		return this;
	}

	public java.util.List<Object> getSelectionStatements() {
		return this._selectionStatements;
	} 

	public TreeNode addFields(Object _type, Object _name) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("type", _type);
		map.put("name", _name);
		this._fields.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getFields() {
		return this._fields;
	}

	public TreeNode addFields(TreeNode_Fields value) {
		return addFields(value._type, value._name);
	}

	public java.util.stream.Stream<TreeNode_Fields> streamFields() {
		return this._fields.stream().map(TreeNode_Fields::new);
	}

	public java.util.List<Object> getFields_Type() {
		return streamFields().map(TreeNode_Fields::getType).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getFields_Name() {
		return streamFields().map(TreeNode_Fields::getName).collect(java.util.stream.Collectors.toList());
	}


	public static final class TreeNode_Fields {

		Object _type;
		Object _name;

		public TreeNode_Fields(Object _type, Object _name) {
			this._type = _type;
			this._name = _name;
		}

		private TreeNode_Fields(java.util.Map<String, Object> map) {
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

	public TreeNode addPrivateFields(Object _type, Object _name, Object _init) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("type", _type);
		map.put("name", _name);
		map.put("init", _init);
		this._privateFields.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getPrivateFields() {
		return this._privateFields;
	}

	public TreeNode addPrivateFields(TreeNode_PrivateFields value) {
		return addPrivateFields(value._type, value._name, value._init);
	}

	public java.util.stream.Stream<TreeNode_PrivateFields> streamPrivateFields() {
		return this._privateFields.stream().map(TreeNode_PrivateFields::new);
	}

	public java.util.List<Object> getPrivateFields_Type() {
		return streamPrivateFields().map(TreeNode_PrivateFields::getType).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getPrivateFields_Name() {
		return streamPrivateFields().map(TreeNode_PrivateFields::getName).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getPrivateFields_Init() {
		return streamPrivateFields().map(TreeNode_PrivateFields::getInit).collect(java.util.stream.Collectors.toList());
	}


	public static final class TreeNode_PrivateFields {

		Object _type;
		Object _name;
		Object _init;

		public TreeNode_PrivateFields(Object _type, Object _name, Object _init) {
			this._type = _type;
			this._name = _name;
			this._init = _init;
		}

		private TreeNode_PrivateFields(java.util.Map<String, Object> map) {
			this._type = (Object) map.get("type");
			this._name = (Object) map.get("name");
			this._init = (Object) map.get("init");
		}

		public Object getType() {
			return this._type;
		}

		public Object getName() {
			return this._name;
		}

		public Object getInit() {
			return this._init;
		}

	}  

	public TreeNode addParameters(Object _type, String _name) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("type", _type);
		map.put("name", _name);
		this._parameters.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getParameters() {
		return this._parameters;
	}

	public TreeNode addParameters(TreeNode_Parameters value) {
		return addParameters(value._type, value._name);
	}

	public java.util.stream.Stream<TreeNode_Parameters> streamParameters() {
		return this._parameters.stream().map(TreeNode_Parameters::new);
	}

	public java.util.List<Object> getParameters_Type() {
		return streamParameters().map(TreeNode_Parameters::getType).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<String> getParameters_Name() {
		return streamParameters().map(TreeNode_Parameters::getName).collect(java.util.stream.Collectors.toList());
	}


	public static final class TreeNode_Parameters {

		Object _type;
		String _name;

		public TreeNode_Parameters(Object _type, String _name) {
			this._type = _type;
			this._name = _name;
		}

		private TreeNode_Parameters(java.util.Map<String, Object> map) {
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
		TreeNode that = (TreeNode) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "TreeNode(name,modelType,hasUuid,fields,privateFields,parameters,icon,labelExpression,tooltipExpression,constructorStatements,getActionsStatements,actions,methods,selectionStatements) ::= <<// ~name~\n" + 
				"public class ~name~ extends BaseTreeNode<~modelType~> {\n" + 
				"~if(hasUuid)~\n" + 
				"\n" + 
				"	private String uuid;\n" + 
				"~endif~\n" + 
				"	~fields:{it|private ~it.type~ ~it.name~;};separator=\"\\n\"~\n" + 
				"	~privateFields:{it|private ~it.type~ ~it.name~;};separator=\"\\n\"~\n" + 
				"	\n" + 
				"	~name~(~modelType~ model~if(fields)~, ~fields:{it|~it.type~ ~it.name~};separator=\", \"~~endif~~if(parameters)~, ~parameters:{it|~it.type~ ~it.name~};separator=\", \"~~endif~) {\n" + 
				"		super(model, ~if(icon)~~icon~~else~null~endif~);\n" + 
				"\n" + 
				"		~fields:{it|this.~it.name~ = ~it.name~;};separator=\"\\n\"~\n" + 
				"		~privateFields:{it|this.~it.name~ = ~it.init~;};separator=\"\\n\"~\n" + 
				"		\n" + 
				"		setLabel(~if(labelExpression)~~labelExpression~~else~model.toString()~endif~);\n" + 
				"		this.tooltip = ~if(tooltipExpression)~~tooltipExpression~~else~\"\";~endif~\n" + 
				"		~if(hasUuid)~this.uuid = model.getUuid();~endif~\n" + 
				"\n" + 
				"		~constructorStatements:{it|~it~};separator=\"\\n\"~\n" + 
				"	}\n" + 
				"\n" + 
				"	~name~ thisNode() {\n" + 
				"		return this;\n" + 
				"	}\n" + 
				"\n" + 
				"	@Override\n" + 
				"	public void nodeChanged() {\n" + 
				"		setLabel(~if(labelExpression)~~labelExpression~~else~getModel().toString()~endif~);\n" + 
				"		this.tooltip = ~if(tooltipExpression)~~tooltipExpression~~else~\"\";~endif~\n" + 
				"		super.nodeChanged();\n" + 
				"	}\n" + 
				"\n" + 
				"	@Override\n" + 
				"	protected List<Action> getActions() {\n" + 
				"		final List<Action> actions = super.getActions();\n" + 
				"		\n" + 
				"		appModel().doInTransaction(tx -> {\n" + 
				"			~getActionsStatements:{it|~it~};separator=\"\\n\"~\n" + 
				"			~actions:{it|actions.add(~it~);};separator=\"\\n\"~\n" + 
				"		});\n" + 
				"		\n" + 
				"		return actions;\n" + 
				"	}\n" + 
				"\n" + 
				"	~methods:{it|~it~};separator=\"\\n\\n\"~\n" + 
				"}\n" + 
				"\n" + 
				"private boolean is~name;format=\"capitalize\"~(Object treeNode) {\n" + 
				"	return treeNode instanceof ~name~;\n" + 
				"}\n" + 
				"\n" + 
				"private Optional<~name~> find~name;format=\"capitalize\"~(java.util.function.Predicate<~name~> predicate) {\n" + 
				"	return treeModel.find(~name~.class, predicate);\n" + 
				"}\n" + 
				"\n" + 
				"private Optional<~name~> find~name;format=\"capitalize\"~(BaseTreeNode<?> parent, java.util.function.Predicate<~name~> predicate) {\n" + 
				"	return treeModel.find(parent, ~name~.class, predicate);\n" + 
				"}\n" + 
				"\n" + 
				"private java.util.stream.Stream<~name~> getSelected~name~s() {\n" + 
				"	return getSelectedNodes(~name~.class);\n" + 
				"}\n" + 
				"\n" + 
				"private void on~name~Selected(~name~ selectedNode) {\n" + 
				"	~selectionStatements:{it|~it~};separator=\"\\n\"~\n" + 
				"} >>";
}  