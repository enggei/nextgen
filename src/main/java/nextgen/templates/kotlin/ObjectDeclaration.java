package nextgen.templates.kotlin;

public class ObjectDeclaration implements CompilationUnit {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private String _name;
	private java.util.List<Extending> _extends = new java.util.ArrayList<>();
	private java.util.List<PropertyDeclaration> _fields = new java.util.ArrayList<>();
	private java.util.List<FunctionDeclaration> _members = new java.util.ArrayList<>();

	ObjectDeclaration(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("ObjectDeclaration");
		st.add("name", _name);
		for (Object o : _extends) st.add("extends", o);
		for (Object o : _fields) st.add("fields", o);
		for (Object o : _members) st.add("members", o);
		return st.render().trim();
	}

	public ObjectDeclaration setName(String value) {
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

	public ObjectDeclaration removeName() {
		this._name = null;
		return this;
	} 

	public ObjectDeclaration addExtends(Extending value) {
		this._extends.add(value);
		return this;
	}

	public ObjectDeclaration setExtends(Extending[] value) {
		this._extends.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public ObjectDeclaration setExtends(java.util.Collection<Extending> values) {
		this._extends.addAll(values);
		return this;
	}

	public ObjectDeclaration removeExtends(Extending value) {
		this._extends.remove(value);
		return this;
	}

	public ObjectDeclaration removeExtends(int index) {
		this._extends.remove(index);
		return this;
	}

	public java.util.List<Extending> getExtends() {
		return this._extends;
	} 

	public ObjectDeclaration addFields(PropertyDeclaration value) {
		this._fields.add(value);
		return this;
	}

	public ObjectDeclaration setFields(PropertyDeclaration[] value) {
		this._fields.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public ObjectDeclaration setFields(java.util.Collection<PropertyDeclaration> values) {
		this._fields.addAll(values);
		return this;
	}

	public ObjectDeclaration removeFields(PropertyDeclaration value) {
		this._fields.remove(value);
		return this;
	}

	public ObjectDeclaration removeFields(int index) {
		this._fields.remove(index);
		return this;
	}

	public java.util.List<PropertyDeclaration> getFields() {
		return this._fields;
	} 

	public ObjectDeclaration addMembers(FunctionDeclaration value) {
		this._members.add(value);
		return this;
	}

	public ObjectDeclaration setMembers(FunctionDeclaration[] value) {
		this._members.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public ObjectDeclaration setMembers(java.util.Collection<FunctionDeclaration> values) {
		this._members.addAll(values);
		return this;
	}

	public ObjectDeclaration removeMembers(FunctionDeclaration value) {
		this._members.remove(value);
		return this;
	}

	public ObjectDeclaration removeMembers(int index) {
		this._members.remove(index);
		return this;
	}

	public java.util.List<FunctionDeclaration> getMembers() {
		return this._members;
	} 


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ObjectDeclaration that = (ObjectDeclaration) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "ObjectDeclaration(name,extends,fields,members) ::= <<object~if(name)~ ~name~~endif~~if(extends)~ : ~extends:{it|~it~};separator=\", \"~~endif~ {\n" + 
				"	~fields:{it|~it~};separator=\"\\n\"~\n" + 
				"\n" + 
				"	~members:{it|~it~};separator=\"\\n\"~\n" + 
				"} >>";
}  