package nextgen.templates.nextgen;

public class CanvasNode {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _modelType;
	private String _name;
	private Object _labelExpression;
	private Object _uuidExpression;
	private java.util.List<Object> _newNodeAddedStatements = new java.util.ArrayList<>();
	private java.util.List<Object> _rightClickStatements = new java.util.ArrayList<>();
	private java.util.List<Object> _leftClickStatements = new java.util.ArrayList<>();
	private java.util.List<CanvasNodeAction> _actions = new java.util.ArrayList<>();
	private java.util.List<Object> _methods = new java.util.ArrayList<>();
	private java.util.List<Object> _addedToCanvasStatements = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _rightClickActions = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _keyPressActions = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _fields = new java.util.ArrayList<>();

	CanvasNode(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("CanvasNode");
		st.add("modelType", _modelType);
		st.add("name", _name);
		st.add("labelExpression", _labelExpression);
		st.add("uuidExpression", _uuidExpression);
		for (Object o : _newNodeAddedStatements) st.add("newNodeAddedStatements", o);
		for (Object o : _rightClickStatements) st.add("rightClickStatements", o);
		for (Object o : _leftClickStatements) st.add("leftClickStatements", o);
		for (Object o : _actions) st.add("actions", o);
		for (Object o : _methods) st.add("methods", o);
		for (Object o : _addedToCanvasStatements) st.add("addedToCanvasStatements", o);
		for (java.util.Map<String, Object> map : _rightClickActions) st.addAggr("rightClickActions.{name}", map.get("name"));
		for (java.util.Map<String, Object> map : _keyPressActions) st.addAggr("keyPressActions.{key,name}", map.get("key"), map.get("name"));
		for (java.util.Map<String, Object> map : _fields) st.addAggr("fields.{type,name}", map.get("type"), map.get("name"));
		return st.render().trim();
	}

	public CanvasNode setModelType(Object value) {
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

	public CanvasNode removeModelType() {
		this._modelType = null;
		return this;
	} 

	public CanvasNode setName(String value) {
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

	public CanvasNode removeName() {
		this._name = null;
		return this;
	} 

	public CanvasNode setLabelExpression(Object value) {
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

	public CanvasNode removeLabelExpression() {
		this._labelExpression = null;
		return this;
	} 

	public CanvasNode setUuidExpression(Object value) {
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

	public CanvasNode removeUuidExpression() {
		this._uuidExpression = null;
		return this;
	} 

	public CanvasNode addNewNodeAddedStatements(Object value) {
		this._newNodeAddedStatements.add(value);
		return this;
	}

	public CanvasNode setNewNodeAddedStatements(Object[] value) {
		this._newNodeAddedStatements.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public CanvasNode setNewNodeAddedStatements(java.util.Collection<Object> values) {
		this._newNodeAddedStatements.addAll(values);
		return this;
	}

	public CanvasNode removeNewNodeAddedStatements(Object value) {
		this._newNodeAddedStatements.remove(value);
		return this;
	}

	public CanvasNode removeNewNodeAddedStatements(int index) {
		this._newNodeAddedStatements.remove(index);
		return this;
	}

	public java.util.List<Object> getNewNodeAddedStatements() {
		return this._newNodeAddedStatements;
	} 

	public CanvasNode addRightClickStatements(Object value) {
		this._rightClickStatements.add(value);
		return this;
	}

	public CanvasNode setRightClickStatements(Object[] value) {
		this._rightClickStatements.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public CanvasNode setRightClickStatements(java.util.Collection<Object> values) {
		this._rightClickStatements.addAll(values);
		return this;
	}

	public CanvasNode removeRightClickStatements(Object value) {
		this._rightClickStatements.remove(value);
		return this;
	}

	public CanvasNode removeRightClickStatements(int index) {
		this._rightClickStatements.remove(index);
		return this;
	}

	public java.util.List<Object> getRightClickStatements() {
		return this._rightClickStatements;
	} 

	public CanvasNode addLeftClickStatements(Object value) {
		this._leftClickStatements.add(value);
		return this;
	}

	public CanvasNode setLeftClickStatements(Object[] value) {
		this._leftClickStatements.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public CanvasNode setLeftClickStatements(java.util.Collection<Object> values) {
		this._leftClickStatements.addAll(values);
		return this;
	}

	public CanvasNode removeLeftClickStatements(Object value) {
		this._leftClickStatements.remove(value);
		return this;
	}

	public CanvasNode removeLeftClickStatements(int index) {
		this._leftClickStatements.remove(index);
		return this;
	}

	public java.util.List<Object> getLeftClickStatements() {
		return this._leftClickStatements;
	} 

	public CanvasNode addActions(CanvasNodeAction value) {
		this._actions.add(value);
		return this;
	}

	public CanvasNode setActions(CanvasNodeAction[] value) {
		this._actions.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public CanvasNode setActions(java.util.Collection<CanvasNodeAction> values) {
		this._actions.addAll(values);
		return this;
	}

	public CanvasNode removeActions(CanvasNodeAction value) {
		this._actions.remove(value);
		return this;
	}

	public CanvasNode removeActions(int index) {
		this._actions.remove(index);
		return this;
	}

	public java.util.List<CanvasNodeAction> getActions() {
		return this._actions;
	} 

	public CanvasNode addMethods(Object value) {
		this._methods.add(value);
		return this;
	}

	public CanvasNode setMethods(Object[] value) {
		this._methods.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public CanvasNode setMethods(java.util.Collection<Object> values) {
		this._methods.addAll(values);
		return this;
	}

	public CanvasNode removeMethods(Object value) {
		this._methods.remove(value);
		return this;
	}

	public CanvasNode removeMethods(int index) {
		this._methods.remove(index);
		return this;
	}

	public java.util.List<Object> getMethods() {
		return this._methods;
	} 

	public CanvasNode addAddedToCanvasStatements(Object value) {
		this._addedToCanvasStatements.add(value);
		return this;
	}

	public CanvasNode setAddedToCanvasStatements(Object[] value) {
		this._addedToCanvasStatements.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public CanvasNode setAddedToCanvasStatements(java.util.Collection<Object> values) {
		this._addedToCanvasStatements.addAll(values);
		return this;
	}

	public CanvasNode removeAddedToCanvasStatements(Object value) {
		this._addedToCanvasStatements.remove(value);
		return this;
	}

	public CanvasNode removeAddedToCanvasStatements(int index) {
		this._addedToCanvasStatements.remove(index);
		return this;
	}

	public java.util.List<Object> getAddedToCanvasStatements() {
		return this._addedToCanvasStatements;
	} 

	public CanvasNode addRightClickActions(Object _name) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		this._rightClickActions.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getRightClickActions() {
		return this._rightClickActions;
	}

	public CanvasNode addRightClickActions(CanvasNode_RightClickActions value) {
		return addRightClickActions(value._name);
	}

	public java.util.stream.Stream<CanvasNode_RightClickActions> streamRightClickActions() {
		return this._rightClickActions.stream().map(CanvasNode_RightClickActions::new);
	}

	public java.util.List<Object> getRightClickActions_Name() {
		return streamRightClickActions().map(CanvasNode_RightClickActions::getName).collect(java.util.stream.Collectors.toList());
	}


	public static final class CanvasNode_RightClickActions {

		Object _name;

		public CanvasNode_RightClickActions(Object _name) {
			this._name = _name;
		}

		private CanvasNode_RightClickActions(java.util.Map<String, Object> map) {
			this._name = (Object) map.get("name");
		}

		public Object getName() {
			return this._name;
		}

	}  

	public CanvasNode addKeyPressActions(Object _key, Object _name) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("key", _key);
		map.put("name", _name);
		this._keyPressActions.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getKeyPressActions() {
		return this._keyPressActions;
	}

	public CanvasNode addKeyPressActions(CanvasNode_KeyPressActions value) {
		return addKeyPressActions(value._key, value._name);
	}

	public java.util.stream.Stream<CanvasNode_KeyPressActions> streamKeyPressActions() {
		return this._keyPressActions.stream().map(CanvasNode_KeyPressActions::new);
	}

	public java.util.List<Object> getKeyPressActions_Key() {
		return streamKeyPressActions().map(CanvasNode_KeyPressActions::getKey).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getKeyPressActions_Name() {
		return streamKeyPressActions().map(CanvasNode_KeyPressActions::getName).collect(java.util.stream.Collectors.toList());
	}


	public static final class CanvasNode_KeyPressActions {

		Object _key;
		Object _name;

		public CanvasNode_KeyPressActions(Object _key, Object _name) {
			this._key = _key;
			this._name = _name;
		}

		private CanvasNode_KeyPressActions(java.util.Map<String, Object> map) {
			this._key = (Object) map.get("key");
			this._name = (Object) map.get("name");
		}

		public Object getKey() {
			return this._key;
		}

		public Object getName() {
			return this._name;
		}

	}  

	public CanvasNode addFields(Object _type, Object _name) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("type", _type);
		map.put("name", _name);
		this._fields.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getFields() {
		return this._fields;
	}

	public CanvasNode addFields(CanvasNode_Fields value) {
		return addFields(value._type, value._name);
	}

	public java.util.stream.Stream<CanvasNode_Fields> streamFields() {
		return this._fields.stream().map(CanvasNode_Fields::new);
	}

	public java.util.List<Object> getFields_Type() {
		return streamFields().map(CanvasNode_Fields::getType).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getFields_Name() {
		return streamFields().map(CanvasNode_Fields::getName).collect(java.util.stream.Collectors.toList());
	}


	public static final class CanvasNode_Fields {

		Object _type;
		Object _name;

		public CanvasNode_Fields(Object _type, Object _name) {
			this._type = _type;
			this._name = _name;
		}

		private CanvasNode_Fields(java.util.Map<String, Object> map) {
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
		CanvasNode that = (CanvasNode) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "CanvasNode(rightClickActions,newNodeAddedStatements,rightClickStatements,leftClickStatements,keyPressActions,actions,methods,fields,modelType,name,addedToCanvasStatements,labelExpression,uuidExpression) ::= <<final class ~name~ extends BaseCanvasNode<~modelType~> {\n" + 
				"\n" + 
				"	~fields:{it|private ~it.type~ ~it.name~;};separator=\"\\n\"~\n" + 
				"\n" + 
				"	public ~name~(~modelType~ model~if(uuidExpression)~~else~, String uuid~endif~~if(labelExpression)~~else~, String label~endif~~if(fields)~, ~fields:{it|~it.type~ ~it.name~};separator=\", \"~~endif~) {\n" + 
				"		super(model, ~if(uuidExpression)~~uuidExpression~~else~uuid~endif~, ~if(labelExpression)~~labelExpression~~else~label~endif~);\n" + 
				"		~fields:{it|this.~it.name~ = ~it.name~;};separator=\"\\n\"~\n" + 
				"	}\n" + 
				"~if(addedToCanvasStatements)~\n" + 
				"	\n" + 
				"	@Override\n" + 
				"	public void addedToCanvas() {\n" + 
				"		~addedToCanvasStatements:{it|~it~};separator=\"\\n\"~\n" + 
				"	}\n" + 
				"	\n" + 
				"~endif~\n" + 
				"~if(newNodeAddedStatements)~\n" + 
				"	\n" + 
				"	@Override\n" + 
				"	public void newNodeAdded(BaseCanvasNode<?> node) {\n" + 
				"		~newNodeAddedStatements:{it|~it~};separator=\"\\n\"~\n" + 
				"	}\n" + 
				"	\n" + 
				"~endif~\n" + 
				"	@Override\n" + 
				"	protected void onNodeRightClick(PInputEvent event, JPopupMenu pop) {\n" + 
				"		~rightClickStatements:{it|~it~};separator=\"\\n\"~\n" + 
				"		~rightClickActions:{it|pop.add(new ~it.name~(event));};separator=\"\\n\"~\n" + 
				"		super.onNodeRightClick(event, pop);\n" + 
				"	}\n" + 
				"~if(leftClickStatements)~\n" + 
				"\n" + 
				"	@Override\n" + 
				"	protected void onNodeLeftClick(PInputEvent event) {\n" + 
				"		super.onNodeLeftClick(event);\n" + 
				"		~leftClickStatements:{it|~it~};separator=\"\\n\"~\n" + 
				"	}\n" + 
				"	\n" + 
				"~endif~\n" + 
				"~if(keyPressActions)~\n" + 
				"\n" + 
				"	@Override\n" + 
				"	protected void onNodeKeyPressed(PInputEvent event) {\n" + 
				"		switch (event.getKeyCode()) {\n" + 
				"~keyPressActions:{it|\n" + 
				"			case VK_~it.key~:\n" + 
				"				~it.name~;\n" + 
				"				break;\n" + 
				"};separator=\"\\n\"~\n" + 
				"		}\n" + 
				"		super.onNodeKeyPressed(event);\n" + 
				"	}\n" + 
				"	\n" + 
				"~endif~\n" + 
				"	\n" + 
				"	~actions:{it|~it~};separator=\"\\n\\n\"~\n" + 
				"\n" + 
				"	~methods:{it|~it~};separator=\"\\n\\n\"~\n" + 
				"}\n" + 
				"\n" + 
				"private void add~name~(~modelType~ model~if(uuidExpression)~~else~, String uuid~endif~~if(labelExpression)~~else~, String label~endif~~if(fields)~, ~fields:{it|~it.type~ ~it.name~};separator=\", \"~~endif~) {\n" + 
				"	addNode(~if(uuidExpression)~~uuidExpression~~else~uuid~endif~, new~name~(model~if(uuidExpression)~~else~, uuid~endif~~if(labelExpression)~~else~, label~endif~~if(fields)~, ~fields:{it|~it.name~};separator=\", \"~~endif~));\n" + 
				"}\n" + 
				"\n" + 
				"public java.util.function.Supplier<~name~> new~name~(~modelType~ model~if(uuidExpression)~~else~, String uuid~endif~~if(labelExpression)~~else~, String label~endif~~if(fields)~, ~fields:{it|~it.type~ ~it.name~};separator=\", \"~~endif~) {\n" + 
				"	return () -> new ~name~(model~if(uuidExpression)~~else~, uuid~endif~~if(labelExpression)~~else~, label~endif~~if(fields)~, ~fields:{it|~it.name~};separator=\", \"~~endif~);\n" + 
				"}\n" + 
				"\n" + 
				"public Stream<~name~> getAll~name;format=\"capitalize\"~() {\n" + 
				"	return getAllNodes()\n" + 
				"				.filter(baseCanvasNode -> baseCanvasNode instanceof ~name~)\n" + 
				"				.map(baseCanvasNode -> (~name~) baseCanvasNode);\n" + 
				"}\n" + 
				"\n" + 
				"public void forEach~name;format=\"capitalize\"~(java.util.function.Consumer<~name~> consumer) {\n" + 
				"	getAllNodes()\n" + 
				"			.filter(baseCanvasNode -> baseCanvasNode instanceof ~name~)\n" + 
				"			.map(baseCanvasNode -> (~name~) baseCanvasNode)\n" + 
				"			.forEach(consumer);\n" + 
				"}\n" + 
				"\n" + 
				"public Optional<~name~> isInstanceOf~name~(BaseCanvasNode<?> canvasNode) {\n" + 
				"	return Optional.ofNullable((canvasNode instanceof ~name~) ? (~name~) canvasNode : null);\n" + 
				"} >>";
}  