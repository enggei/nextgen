package nextgen.templates.nextgen;

public class TransactionAction {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _name;
	private Object _title;
	private Object _titleExpression;
	private java.util.List<Object> _statements = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _staticFields = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _fields = new java.util.ArrayList<>();

	TransactionAction(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("TransactionAction");
		st.add("name", _name);
		st.add("title", _title);
		st.add("titleExpression", _titleExpression);
		for (Object o : _statements) st.add("statements", o);
		for (java.util.Map<String, Object> map : _staticFields) st.addAggr("staticFields.{type,name,init}", map.get("type"), map.get("name"), map.get("init"));
		for (java.util.Map<String, Object> map : _fields) st.addAggr("fields.{type,name}", map.get("type"), map.get("name"));
		return st.render().trim();
	}

	public TransactionAction setName(Object value) {
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

	public TransactionAction removeName() {
		this._name = null;
		return this;
	} 

	public TransactionAction setTitle(Object value) {
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

	public TransactionAction removeTitle() {
		this._title = null;
		return this;
	} 

	public TransactionAction setTitleExpression(Object value) {
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

	public TransactionAction removeTitleExpression() {
		this._titleExpression = null;
		return this;
	} 

	public TransactionAction addStatements(Object value) {
		this._statements.add(value);
		return this;
	}

	public TransactionAction setStatements(Object[] value) {
		this._statements.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public TransactionAction setStatements(java.util.Collection<Object> values) {
		this._statements.addAll(values);
		return this;
	}

	public TransactionAction removeStatements(Object value) {
		this._statements.remove(value);
		return this;
	}

	public TransactionAction removeStatements(int index) {
		this._statements.remove(index);
		return this;
	}

	public java.util.List<Object> getStatements() {
		return this._statements;
	} 

	public TransactionAction addStaticFields(Object _type, Object _name, Object _init) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("type", _type);
		map.put("name", _name);
		map.put("init", _init);
		this._staticFields.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getStaticFields() {
		return this._staticFields;
	}

	public TransactionAction addStaticFields(TransactionAction_StaticFields value) {
		return addStaticFields(value._type, value._name, value._init);
	}

	public java.util.stream.Stream<TransactionAction_StaticFields> streamStaticFields() {
		return this._staticFields.stream().map(TransactionAction_StaticFields::new);
	}

	public java.util.List<Object> getStaticFields_Type() {
		return streamStaticFields().map(TransactionAction_StaticFields::getType).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getStaticFields_Name() {
		return streamStaticFields().map(TransactionAction_StaticFields::getName).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getStaticFields_Init() {
		return streamStaticFields().map(TransactionAction_StaticFields::getInit).collect(java.util.stream.Collectors.toList());
	}


	public static final class TransactionAction_StaticFields {

		Object _type;
		Object _name;
		Object _init;

		public TransactionAction_StaticFields(Object _type, Object _name, Object _init) {
			this._type = _type;
			this._name = _name;
			this._init = _init;
		}

		private TransactionAction_StaticFields(java.util.Map<String, Object> map) {
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

	public TransactionAction addFields(Object _type, Object _name) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("type", _type);
		map.put("name", _name);
		this._fields.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getFields() {
		return this._fields;
	}

	public TransactionAction addFields(TransactionAction_Fields value) {
		return addFields(value._type, value._name);
	}

	public java.util.stream.Stream<TransactionAction_Fields> streamFields() {
		return this._fields.stream().map(TransactionAction_Fields::new);
	}

	public java.util.List<Object> getFields_Type() {
		return streamFields().map(TransactionAction_Fields::getType).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getFields_Name() {
		return streamFields().map(TransactionAction_Fields::getName).collect(java.util.stream.Collectors.toList());
	}


	public static final class TransactionAction_Fields {

		Object _type;
		Object _name;

		public TransactionAction_Fields(Object _type, Object _name) {
			this._type = _type;
			this._name = _name;
		}

		private TransactionAction_Fields(java.util.Map<String, Object> map) {
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
		TransactionAction that = (TransactionAction) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "TransactionAction(name,staticFields,fields,title,titleExpression,statements) ::= <<package nextgen.actions;\n" + 
				"\n" + 
				"public class ~name~ extends TransactionAction {\n" + 
				"\n" + 
				"   ~staticFields:{it|private static final ~it.type~ ~it.name~ = ~it.init~;};separator=\"\\n\"~\n" + 
				"   \n" + 
				"   ~fields:{it|private final ~it.type~ ~it.name~;};separator=\"\\n\"~\n" + 
				"~if(title)~\n" + 
				"\n" + 
				"	public ~name~(~fields:{it|~it.type~ ~it.name~};separator=\", \"~) {\n" + 
				"		super(\"~title~\");\n" + 
				"		~fields:{it|this.~it.name~ = ~it.name~;};separator=\"\\n\"~\n" + 
				"	}\n" + 
				"\n" + 
				"~elseif(titleExpression)~\n" + 
				"\n" + 
				"	public ~name~(~fields:{it|~it.type~ ~it.name~};separator=\", \"~) {\n" + 
				"		super(~titleExpression~);\n" + 
				"		~fields:{it|this.~it.name~ = ~it.name~;};separator=\"\\n\"~\n" + 
				"	}\n" + 
				"\n" + 
				"~else~\n" + 
				"\n" + 
				"	public ~name~(String name~if(fields)~, ~endif~~fields:{it|~it.type~ ~it.name~};separator=\", \"~) {\n" + 
				"      super(name);\n" + 
				"      ~fields:{it|this.~it.name~ = ~it.name~;};separator=\"\\n\"~\n" + 
				"   }\n" + 
				"\n" + 
				"~endif~\n" + 
				"   @Override\n" + 
				"   protected void actionPerformed(java.awt.event.ActionEvent actionEvent, org.neo4j.graphdb.Transaction transaction) {\n" + 
				"      ~statements:{it|~it~};separator=\"\\n\"~\n" + 
				"   }\n" + 
				"} >>";
}  