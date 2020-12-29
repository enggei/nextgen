package nextgen.templates.javaswing;

public class EntityAction {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _title;
	private Object _appModelType;
	private Object _name;
	private Object _packageName;
	private java.util.List<Object> _members = new java.util.ArrayList<>();
	private java.util.List<Object> _statements = new java.util.ArrayList<>();
	private java.util.List<Object> _imports = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _fields = new java.util.ArrayList<>();

	EntityAction(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("EntityAction");
		st.add("title", _title);
		st.add("appModelType", _appModelType);
		st.add("name", _name);
		st.add("packageName", _packageName);
		for (Object o : _members) st.add("members", o);
		for (Object o : _statements) st.add("statements", o);
		for (Object o : _imports) st.add("imports", o);
		for (java.util.Map<String, Object> map : _fields) st.addAggr("fields.{name,type}", map.get("name"), map.get("type"));
		return st.render().trim();
	}

	public EntityAction setTitle(Object value) {
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

	public EntityAction removeTitle() {
		this._title = null;
		return this;
	} 

	public EntityAction setAppModelType(Object value) {
		this._appModelType = value;
		return this;
	}

	public Object getAppModelType() {
		return this._appModelType;
	}

	public Object getAppModelType(Object defaultValue) {
		return this._appModelType == null ? defaultValue : this._appModelType;
	}

	public boolean hasAppModelType() {
		return this._appModelType != null;
	}

	public EntityAction removeAppModelType() {
		this._appModelType = null;
		return this;
	} 

	public EntityAction setName(Object value) {
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

	public EntityAction removeName() {
		this._name = null;
		return this;
	} 

	public EntityAction setPackageName(Object value) {
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

	public EntityAction removePackageName() {
		this._packageName = null;
		return this;
	} 

	public EntityAction addMembers(Object value) {
		this._members.add(value);
		return this;
	}

	public EntityAction setMembers(Object[] value) {
		this._members.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public EntityAction setMembers(java.util.Collection<Object> values) {
		this._members.addAll(values);
		return this;
	}

	public EntityAction removeMembers(Object value) {
		this._members.remove(value);
		return this;
	}

	public EntityAction removeMembers(int index) {
		this._members.remove(index);
		return this;
	}

	public java.util.List<Object> getMembers() {
		return this._members;
	} 

	public EntityAction addStatements(Object value) {
		this._statements.add(value);
		return this;
	}

	public EntityAction setStatements(Object[] value) {
		this._statements.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public EntityAction setStatements(java.util.Collection<Object> values) {
		this._statements.addAll(values);
		return this;
	}

	public EntityAction removeStatements(Object value) {
		this._statements.remove(value);
		return this;
	}

	public EntityAction removeStatements(int index) {
		this._statements.remove(index);
		return this;
	}

	public java.util.List<Object> getStatements() {
		return this._statements;
	} 

	public EntityAction addImports(Object value) {
		this._imports.add(value);
		return this;
	}

	public EntityAction setImports(Object[] value) {
		this._imports.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public EntityAction setImports(java.util.Collection<Object> values) {
		this._imports.addAll(values);
		return this;
	}

	public EntityAction removeImports(Object value) {
		this._imports.remove(value);
		return this;
	}

	public EntityAction removeImports(int index) {
		this._imports.remove(index);
		return this;
	}

	public java.util.List<Object> getImports() {
		return this._imports;
	} 

	public EntityAction addFields(Object _name, Object _type) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		map.put("type", _type);
		this._fields.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getFields() {
		return this._fields;
	}

	public EntityAction addFields(EntityAction_Fields value) {
		return addFields(value._name, value._type);
	}

	public java.util.stream.Stream<EntityAction_Fields> streamFields() {
		return this._fields.stream().map(EntityAction_Fields::new);
	}

	public java.util.List<Object> getFields_Name() {
		return streamFields().map(EntityAction_Fields::getName).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getFields_Type() {
		return streamFields().map(EntityAction_Fields::getType).collect(java.util.stream.Collectors.toList());
	}


	public static final class EntityAction_Fields {

		Object _name;
		Object _type;

		public EntityAction_Fields(Object _name, Object _type) {
			this._name = _name;
			this._type = _type;
		}

		private EntityAction_Fields(java.util.Map<String, Object> map) {
			this._name = (Object) map.get("name");
			this._type = (Object) map.get("type");
		}

		public Object getName() {
			return this._name;
		}

		public Object getType() {
			return this._type;
		}

	}  

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		EntityAction that = (EntityAction) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "EntityAction(members,title,statements,appModelType,name,imports,fields,packageName) ::= <<package ~packageName~;\n" + 
				"\n" + 
				"import nextgen.swing.SwingUtil;\n" + 
				"import org.neo4j.graphdb.Transaction;\n" + 
				"\n" + 
				"import java.awt.event.ActionEvent;\n" + 
				"~imports:{it|~it~};separator=\"\\n\"~\n" + 
				"\n" + 
				"public class ~name~ extends TransactionAction {\n" + 
				"\n" + 
				"	~fields:{it|~it.type~ ~it.name~;};separator=\"\\n\"~\n" + 
				"	\n" + 
				"	public ~name~(~fields:{it|~it.type~ ~it.name~};separator=\", \"~) {\n" + 
				"		super(\"~title~\");\n" + 
				"		~fields:{it|this.~it.name~ = ~it.name~;};separator=\"\\n\"~\n" + 
				"	}\n" + 
				"\n" + 
				"	@Override\n" + 
				"	protected void actionPerformed(ActionEvent actionEvent, Transaction transaction, ~appModelType~ appModel) {\n" + 
				"		~statements:{it|~it~};separator=\"\\n\"~\n" + 
				"	}\n" + 
				"\n" + 
				"	~members:{it|~it~};separator=\"\\n\\n\"~\n" + 
				"} >>";
}  