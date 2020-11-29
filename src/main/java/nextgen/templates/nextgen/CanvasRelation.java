package nextgen.templates.nextgen;

public class CanvasRelation {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _name;
	private Object _labelExpression;
	private Object _uuidExpression;
	private java.util.List<Object> _actions = new java.util.ArrayList<>();
	private java.util.List<Object> _rightClickStatements = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _fields = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _rightClickActions = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _keyPressActions = new java.util.ArrayList<>();

	CanvasRelation(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("CanvasRelation");
		st.add("name", _name);
		st.add("labelExpression", _labelExpression);
		st.add("uuidExpression", _uuidExpression);
		for (Object o : _actions) st.add("actions", o);
		for (Object o : _rightClickStatements) st.add("rightClickStatements", o);
		for (java.util.Map<String, Object> map : _fields) st.addAggr("fields.{type,name}", map.get("type"), map.get("name"));
		for (java.util.Map<String, Object> map : _rightClickActions) st.addAggr("rightClickActions.{name}", map.get("name"));
		for (java.util.Map<String, Object> map : _keyPressActions) st.addAggr("keyPressActions.{name,key}", map.get("name"), map.get("key"));
		return st.render().trim();
	}

	public CanvasRelation setName(Object value) {
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

	public CanvasRelation removeName() {
		this._name = null;
		return this;
	} 

	public CanvasRelation setLabelExpression(Object value) {
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

	public CanvasRelation removeLabelExpression() {
		this._labelExpression = null;
		return this;
	} 

	public CanvasRelation setUuidExpression(Object value) {
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

	public CanvasRelation removeUuidExpression() {
		this._uuidExpression = null;
		return this;
	} 

	public CanvasRelation addActions(Object value) {
		this._actions.add(value);
		return this;
	}

	public CanvasRelation setActions(Object[] value) {
		this._actions.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public CanvasRelation setActions(java.util.Collection<Object> values) {
		this._actions.addAll(values);
		return this;
	}

	public CanvasRelation removeActions(Object value) {
		this._actions.remove(value);
		return this;
	}

	public CanvasRelation removeActions(int index) {
		this._actions.remove(index);
		return this;
	}

	public java.util.List<Object> getActions() {
		return this._actions;
	} 

	public CanvasRelation addRightClickStatements(Object value) {
		this._rightClickStatements.add(value);
		return this;
	}

	public CanvasRelation setRightClickStatements(Object[] value) {
		this._rightClickStatements.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public CanvasRelation setRightClickStatements(java.util.Collection<Object> values) {
		this._rightClickStatements.addAll(values);
		return this;
	}

	public CanvasRelation removeRightClickStatements(Object value) {
		this._rightClickStatements.remove(value);
		return this;
	}

	public CanvasRelation removeRightClickStatements(int index) {
		this._rightClickStatements.remove(index);
		return this;
	}

	public java.util.List<Object> getRightClickStatements() {
		return this._rightClickStatements;
	} 

	public CanvasRelation addFields(Object _type, Object _name) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("type", _type);
		map.put("name", _name);
		this._fields.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getFields() {
		return this._fields;
	}

	public CanvasRelation addFields(CanvasRelation_Fields value) {
		return addFields(value._type, value._name);
	}

	public java.util.stream.Stream<CanvasRelation_Fields> streamFields() {
		return this._fields.stream().map(CanvasRelation_Fields::new);
	}

	public java.util.List<Object> getFields_Type() {
		return streamFields().map(CanvasRelation_Fields::getType).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getFields_Name() {
		return streamFields().map(CanvasRelation_Fields::getName).collect(java.util.stream.Collectors.toList());
	}


	public static final class CanvasRelation_Fields {

		Object _type;
		Object _name;

		public CanvasRelation_Fields(Object _type, Object _name) {
			this._type = _type;
			this._name = _name;
		}

		private CanvasRelation_Fields(java.util.Map<String, Object> map) {
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

	public CanvasRelation addRightClickActions(Object _name) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		this._rightClickActions.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getRightClickActions() {
		return this._rightClickActions;
	}

	public CanvasRelation addRightClickActions(CanvasRelation_RightClickActions value) {
		return addRightClickActions(value._name);
	}

	public java.util.stream.Stream<CanvasRelation_RightClickActions> streamRightClickActions() {
		return this._rightClickActions.stream().map(CanvasRelation_RightClickActions::new);
	}

	public java.util.List<Object> getRightClickActions_Name() {
		return streamRightClickActions().map(CanvasRelation_RightClickActions::getName).collect(java.util.stream.Collectors.toList());
	}


	public static final class CanvasRelation_RightClickActions {

		Object _name;

		public CanvasRelation_RightClickActions(Object _name) {
			this._name = _name;
		}

		private CanvasRelation_RightClickActions(java.util.Map<String, Object> map) {
			this._name = (Object) map.get("name");
		}

		public Object getName() {
			return this._name;
		}

	}  

	public CanvasRelation addKeyPressActions(Object _name, Object _key) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		map.put("key", _key);
		this._keyPressActions.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getKeyPressActions() {
		return this._keyPressActions;
	}

	public CanvasRelation addKeyPressActions(CanvasRelation_KeyPressActions value) {
		return addKeyPressActions(value._name, value._key);
	}

	public java.util.stream.Stream<CanvasRelation_KeyPressActions> streamKeyPressActions() {
		return this._keyPressActions.stream().map(CanvasRelation_KeyPressActions::new);
	}

	public java.util.List<Object> getKeyPressActions_Name() {
		return streamKeyPressActions().map(CanvasRelation_KeyPressActions::getName).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getKeyPressActions_Key() {
		return streamKeyPressActions().map(CanvasRelation_KeyPressActions::getKey).collect(java.util.stream.Collectors.toList());
	}


	public static final class CanvasRelation_KeyPressActions {

		Object _name;
		Object _key;

		public CanvasRelation_KeyPressActions(Object _name, Object _key) {
			this._name = _name;
			this._key = _key;
		}

		private CanvasRelation_KeyPressActions(java.util.Map<String, Object> map) {
			this._name = (Object) map.get("name");
			this._key = (Object) map.get("key");
		}

		public Object getName() {
			return this._name;
		}

		public Object getKey() {
			return this._key;
		}

	}  

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		CanvasRelation that = (CanvasRelation) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "CanvasRelation(actions,name,labelExpression,uuidExpression,fields,rightClickStatements,rightClickActions,keyPressActions) ::= <<public java.util.function.Supplier<STModelCanvas.~name~> new~name~(BaseCanvasNode<?> src, BaseCanvasNode<?> dst~if(uuidExpression)~~else~, String uuid~endif~~if(labelExpression)~~else~, String label~endif~~if(fields)~, ~fields:{it|~it.type~ ~it.name~};separator=\", \"~~endif~) {\n" + 
				"	return () -> new STModelCanvas.~name~(src, dst~if(uuidExpression)~~else~, uuid~endif~~if(labelExpression)~~else~, label~endif~~if(fields)~, ~fields:{it|~it.name~};separator=\", \"~~endif~);\n" + 
				"}\n" + 
				"\n" + 
				"public void add~name~(BaseCanvasNode<?> src, BaseCanvasNode<?> dst~if(labelExpression)~~else~, String label~endif~~if(fields)~, ~fields:{it|~it.type~ ~it.name~};separator=\", \"~~endif~) {\n" + 
				"	addRelation(~if(uuidExpression)~~uuidExpression~~else~src.getUuid() + dst.getUuid()~endif~, new~name~(src, dst~if(uuidExpression)~~else~, src.getUuid() + dst.getUuid()~endif~~if(labelExpression)~~else~, label~endif~~if(fields)~, ~fields:{it|~it.name~};separator=\", \"~~endif~));\n" + 
				"}\n" + 
				"\n" + 
				"final class ~name~ extends BaseCanvasRelation {\n" + 
				"\n" + 
				"	~fields:{it|private ~it.type~ ~it.name~;};separator=\"\\n\"~\n" + 
				"\n" + 
				"	public ~name~(BaseCanvasNode<?> src, BaseCanvasNode<?> dst~if(uuidExpression)~~else~, String uuid~endif~~if(labelExpression)~~else~, String label~endif~~if(fields)~, ~fields:{it|~it.type~ ~it.name~};separator=\", \"~~endif~) {\n" + 
				"		super(src, dst, ~if(uuidExpression)~~uuidExpression~~else~uuid~endif~, ~if(labelExpression)~~labelExpression~~else~label~endif~);\n" + 
				"		~fields:{it|this.~it.name~ = ~it.name~;};separator=\"\\n\"~\n" + 
				"	}\n" + 
				"\n" + 
				"	@Override\n" + 
				"	protected void onRelationRightClick(PInputEvent event, JPopupMenu pop) {\n" + 
				"		~rightClickStatements:{it|~it~};separator=\"\\n\"~\n" + 
				"\n" + 
				"		~rightClickActions:{it|pop.add(new ~it.name~(event));};separator=\"\\n\"~\n" + 
				"	}\n" + 
				"~if(keyPressActions)~\n" + 
				"	\n" + 
				"	@Override\n" + 
				"	protected void onRelationKeyPressed(PInputEvent event) {\n" + 
				"		switch (event.getKeyCode()) {\n" + 
				"~keyPressActions:{it|\n" + 
				"			case VK_~it.key~:\n" + 
				"				new ~it.name~(event).actionPerformed(null);\n" + 
				"				break;\n" + 
				"};separator=\"\\n\"~\n" + 
				"		}\n" + 
				"		super.onRelationKeyPressed(event);\n" + 
				"	}\n" + 
				"~endif~\n" + 
				"\n" + 
				"	~actions:{it|~it~};separator=\"\\n\\n\"~\n" + 
				"} >>";
}  