package nextgen.templates.piccolo2d;

public class RelationAction {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _name;
	private Object _relationType;
	private Object _canvasName;
	private Object _title;
	private java.util.List<Object> _statements = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _fields = new java.util.ArrayList<>();

	RelationAction(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("RelationAction");
		st.add("name", _name);
		st.add("relationType", _relationType);
		st.add("canvasName", _canvasName);
		st.add("title", _title);
		for (Object o : _statements) st.add("statements", o);
		for (java.util.Map<String, Object> map : _fields) st.addAggr("fields.{type,name}", map.get("type"), map.get("name"));
		return st.render().trim();
	}

	public RelationAction setName(Object value) {
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

	public RelationAction removeName() {
		this._name = null;
		return this;
	} 

	public RelationAction setRelationType(Object value) {
		this._relationType = value;
		return this;
	}

	public Object getRelationType() {
		return this._relationType;
	}

	public Object getRelationType(Object defaultValue) {
		return this._relationType == null ? defaultValue : this._relationType;
	}

	public boolean hasRelationType() {
		return this._relationType != null;
	}

	public RelationAction removeRelationType() {
		this._relationType = null;
		return this;
	} 

	public RelationAction setCanvasName(Object value) {
		this._canvasName = value;
		return this;
	}

	public Object getCanvasName() {
		return this._canvasName;
	}

	public Object getCanvasName(Object defaultValue) {
		return this._canvasName == null ? defaultValue : this._canvasName;
	}

	public boolean hasCanvasName() {
		return this._canvasName != null;
	}

	public RelationAction removeCanvasName() {
		this._canvasName = null;
		return this;
	} 

	public RelationAction setTitle(Object value) {
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

	public RelationAction removeTitle() {
		this._title = null;
		return this;
	} 

	public RelationAction addStatements(Object value) {
		this._statements.add(value);
		return this;
	}

	public RelationAction setStatements(Object[] value) {
		this._statements.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public RelationAction setStatements(java.util.Collection<Object> values) {
		this._statements.addAll(values);
		return this;
	}

	public RelationAction removeStatements(Object value) {
		this._statements.remove(value);
		return this;
	}

	public RelationAction removeStatements(int index) {
		this._statements.remove(index);
		return this;
	}

	public java.util.List<Object> getStatements() {
		return this._statements;
	} 

	public RelationAction addFields(Object _type, Object _name) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("type", _type);
		map.put("name", _name);
		this._fields.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getFields() {
		return this._fields;
	}

	public RelationAction addFields(RelationAction_Fields value) {
		return addFields(value._type, value._name);
	}

	public java.util.stream.Stream<RelationAction_Fields> streamFields() {
		return this._fields.stream().map(RelationAction_Fields::new);
	}

	public static final class RelationAction_Fields {

		Object _type;
		Object _name;

		public RelationAction_Fields(Object _type, Object _name) {
			this._type = _type;
			this._name = _name;
		}

		private RelationAction_Fields(java.util.Map<String, Object> map) {
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
		RelationAction that = (RelationAction) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "RelationAction(name,relationType,fields,canvasName,title,statements) ::= <<private static final class ~name~ extends RelationAction<~relationType~> {\n" + 
				"\n" + 
				"	~fields:{it|~it.type~ ~it.name~;};separator=\"\\n\"~\n" + 
				"	\n" + 
				"	~name~(~relationType~ relation, ~canvasName~ canvas, PInputEvent event~if(fields)~, ~endif~~fields:{it|~it.type~ ~it.name~};separator=\", \"~) {\n" + 
				"		super(\"~title~\", relation, canvas, event);\n" + 
				"		~fields:{it|this.~it.name~ = ~it.name~;};separator=\"\\n\"~\n" + 
				"	}\n" + 
				"\n" + 
				"	@Override\n" + 
				"	void actionPerformed(~relationType~ relation, ~canvasName~ canvas, PInputEvent event, ActionEvent e) {\n" + 
				"		~statements:{it|~it~};separator=\"\\n\"~\n" + 
				"	}\n" + 
				"} >>";
}  