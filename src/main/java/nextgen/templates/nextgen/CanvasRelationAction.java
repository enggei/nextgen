package nextgen.templates.nextgen;

public class CanvasRelationAction {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _name;
	private Object _title;
	private java.util.List<Object> _statements = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _fields = new java.util.ArrayList<>();

	CanvasRelationAction(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("CanvasRelationAction");
		st.add("name", _name);
		st.add("title", _title);
		for (Object o : _statements) st.add("statements", o);
		for (java.util.Map<String, Object> map : _fields) st.addAggr("fields.{type,name}", map.get("type"), map.get("name"));
		return st.render().trim();
	}

	public CanvasRelationAction setName(Object value) {
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

	public CanvasRelationAction removeName() {
		this._name = null;
		return this;
	} 

	public CanvasRelationAction setTitle(Object value) {
		this._title = value;
		return this;
	}

	public Object getTitle() {
		return this._title;
	}

	public Object getTitle(Object defaultValue) {
		return this._title == null ? defaultValue : this._title;
	}

	public boolean hasTitle() {
		return this._title != null;
	}

	public CanvasRelationAction removeTitle() {
		this._title = null;
		return this;
	} 

	public CanvasRelationAction addStatements(Object value) {
		this._statements.add(value);
		return this;
	}

	public CanvasRelationAction setStatements(Object[] value) {
		this._statements.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public CanvasRelationAction setStatements(java.util.Collection<Object> values) {
		this._statements.addAll(values);
		return this;
	}

	public CanvasRelationAction removeStatements(Object value) {
		this._statements.remove(value);
		return this;
	}

	public CanvasRelationAction removeStatements(int index) {
		this._statements.remove(index);
		return this;
	}

	public java.util.List<Object> getStatements() {
		return this._statements;
	} 

	public CanvasRelationAction setFields(java.util.Collection<CanvasRelationAction_Fields> values) {
			this._fields.clear();
			values.stream().map(CanvasRelationAction_Fields::asMap).forEach(map -> _fields.add(map));
			return this;
		}

	public CanvasRelationAction addFields(Object _type, Object _name) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("type", _type);
		map.put("name", _name);
		this._fields.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getFields() {
		return this._fields;
	}

	public CanvasRelationAction addFields(CanvasRelationAction_Fields value) {
		return addFields(value._type, value._name);
	}

	public java.util.stream.Stream<CanvasRelationAction_Fields> streamFields() {
		return this._fields.stream().map(CanvasRelationAction_Fields::new);
	}

	public java.util.List<Object> getFields_Type() {
		return streamFields().map(CanvasRelationAction_Fields::getType).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getFields_Name() {
		return streamFields().map(CanvasRelationAction_Fields::getName).collect(java.util.stream.Collectors.toList());
	}


	public static final class CanvasRelationAction_Fields {

		Object _type;
		Object _name;

		public CanvasRelationAction_Fields(Object _type, Object _name) {
			this._type = _type;
			this._name = _name;
		}

		private CanvasRelationAction_Fields(java.util.Map<String, Object> map) {
			this._type = (Object) map.get("type");
			this._name = (Object) map.get("name");
		}

		public Object getType() {
			return this._type;
		}

		public Object getName() {
			return this._name;
		}


		public java.util.Map<String, Object> asMap() {
			java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
			map.put("type", _type);
			map.put("name", _name);
			return map;
		}

	}  

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		CanvasRelationAction that = (CanvasRelationAction) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "CanvasRelationAction(name,fields,title,statements) ::= <<final class ~name~ extends RelationAction {\n" + 
				"\n" + 
				"	~fields:{it|private ~it.type~ ~it.name~;};separator=\"\\n\"~\n" + 
				"	\n" + 
				"	~name~(PInputEvent event~if(fields)~, ~fields:{it|~it.type~ ~it.name~};separator=\",\"~~endif~) {\n" + 
				"		super(\"~title~\", event);\n" + 
				"		~fields:{it|this.~it.name~ = ~it.name~;};separator=\"\\n\"~\n" + 
				"	}\n" + 
				"\n" + 
				"	@Override\n" + 
				"	void actionPerformed(PInputEvent event, ActionEvent e) {\n" + 
				"		~statements:{it|~it~};separator=\"\\n\"~\n" + 
				"	}\n" + 
				"} >>";
}  