package nextgen.templates.nextgen;

public class CanvasNodeAction {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _name;
	private Object _titleExpression;
	private Object _title;
	private Object _transactional;
	private java.util.List<Object> _statements = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _fields = new java.util.ArrayList<>();

	CanvasNodeAction(org.stringtemplate.v4.STGroup stGroup) {
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
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("CanvasNodeAction");
		st.add("name", _name);
		st.add("titleExpression", _titleExpression);
		st.add("title", _title);
		st.add("transactional", _transactional);
		for (Object o : _statements) st.add("statements", o);
		for (java.util.Map<String, Object> map : _fields) st.addAggr("fields.{type,name}", map.get("type"), map.get("name"));
		return st.render().trim();
	}

	public CanvasNodeAction setName(Object value) {
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

	public CanvasNodeAction removeName() {
		this._name = null;
		return this;
	} 

	public CanvasNodeAction setTitleExpression(Object value) {
		this._titleExpression = value;
		return this;
	}

	public Object getTitleExpression() {
		return this._titleExpression;
	}

	public Object getTitleExpression(Object defaultValue) {
		return this._titleExpression == null ? defaultValue : this._titleExpression;
	}

	public boolean hasTitleExpression() {
		return this._titleExpression != null;
	}

	public CanvasNodeAction removeTitleExpression() {
		this._titleExpression = null;
		return this;
	} 

	public CanvasNodeAction setTitle(Object value) {
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

	public CanvasNodeAction removeTitle() {
		this._title = null;
		return this;
	} 

	public CanvasNodeAction setTransactional(Object value) {
		this._transactional = value;
		return this;
	}

	public Object getTransactional() {
		return this._transactional;
	}

	public Object getTransactional(Object defaultValue) {
		return this._transactional == null ? defaultValue : this._transactional;
	}

	public boolean hasTransactional() {
		return this._transactional != null;
	}

	public CanvasNodeAction removeTransactional() {
		this._transactional = null;
		return this;
	} 

	public CanvasNodeAction addStatements(Object value) {
		this._statements.add(value);
		return this;
	}

	public CanvasNodeAction setStatements(Object[] value) {
		this._statements.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public CanvasNodeAction setStatements(java.util.Collection<Object> values) {
		this._statements.addAll(values);
		return this;
	}

	public CanvasNodeAction removeStatements(Object value) {
		this._statements.remove(value);
		return this;
	}

	public CanvasNodeAction removeStatements(int index) {
		this._statements.remove(index);
		return this;
	}

	public java.util.List<Object> getStatements() {
		return this._statements;
	} 

	public CanvasNodeAction addFields(Object _type, Object _name) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("type", _type);
		map.put("name", _name);
		this._fields.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getFields() {
		return this._fields;
	}

	public CanvasNodeAction addFields(CanvasNodeAction_Fields value) {
		return addFields(value._type, value._name);
	}

	public java.util.stream.Stream<CanvasNodeAction_Fields> streamFields() {
		return this._fields.stream().map(CanvasNodeAction_Fields::new);
	}

	public static final class CanvasNodeAction_Fields {

		Object _type;
		Object _name;

		public CanvasNodeAction_Fields(Object _type, Object _name) {
			this._type = _type;
			this._name = _name;
		}

		private CanvasNodeAction_Fields(java.util.Map<String, Object> map) {
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
		CanvasNodeAction that = (CanvasNodeAction) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "CanvasNodeAction(name,fields,titleExpression,title,transactional,statements) ::= <<final class ~name~ extends NodeAction {\n" + 
				"\n" + 
				"	~fields:{it|private ~it.type~ ~it.name~;};separator=\"\\n\"~\n" + 
				"\n" + 
				"	~name~(PInputEvent event~if(fields)~, ~fields:{it|~it.type~ ~it.name~};separator=\", \"~~endif~) {\n" + 
				"		super(~if(titleExpression)~~titleExpression~~else~\"~title~\"~endif~, event);\n" + 
				"		~fields:{it|this.~it.name~ = ~it.name~;};separator=\"\\n\"~\n" + 
				"	}\n" + 
				"\n" + 
				"	@Override\n" + 
				"	void actionPerformed(PInputEvent event, ActionEvent e) {\n" + 
				"~if(transactional)~\n" + 
				"		presentationModel.doLaterInTransaction(transaction -> {\n" + 
				"			~statements:{it|~it~};separator=\"\\n\"~\n" + 
				"		});\n" + 
				"~else~\n" + 
				"		~statements:{it|~it~};separator=\"\\n\"~\n" + 
				"~endif~\n" + 
				"	}\n" + 
				"} >>";
}  