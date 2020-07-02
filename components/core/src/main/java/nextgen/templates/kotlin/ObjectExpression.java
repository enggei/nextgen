package nextgen.templates.kotlin;

public class ObjectExpression implements Expression {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private java.util.List<Extending> _extends = new java.util.ArrayList<>();
	private java.util.List<PropertyDeclaration> _fields = new java.util.ArrayList<>();
	private java.util.List<FunctionDeclaration> _members = new java.util.ArrayList<>();

	ObjectExpression(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("ObjectExpression");
		for (Object o : _extends) st.add("extends", o);
		for (Object o : _fields) st.add("fields", o);
		for (Object o : _members) st.add("members", o);
		return st.render().trim();
	}


	public ObjectExpression addExtends(Extending value) {
		this._extends.add(value);
		return this;
	}

	public ObjectExpression setExtends(Extending[] value) {
		this._extends.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public ObjectExpression setExtends(java.util.Collection<Extending> values) {
		this._extends.addAll(values);
		return this;
	}

	public ObjectExpression removeExtends(Extending value) {
		this._extends.remove(value);
		return this;
	}

	public ObjectExpression removeExtends(int index) {
		this._extends.remove(index);
		return this;
	}

	public java.util.List<Extending> getExtends() {
		return this._extends;
	} 

	public ObjectExpression addFields(PropertyDeclaration value) {
		this._fields.add(value);
		return this;
	}

	public ObjectExpression setFields(PropertyDeclaration[] value) {
		this._fields.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public ObjectExpression setFields(java.util.Collection<PropertyDeclaration> values) {
		this._fields.addAll(values);
		return this;
	}

	public ObjectExpression removeFields(PropertyDeclaration value) {
		this._fields.remove(value);
		return this;
	}

	public ObjectExpression removeFields(int index) {
		this._fields.remove(index);
		return this;
	}

	public java.util.List<PropertyDeclaration> getFields() {
		return this._fields;
	} 

	public ObjectExpression addMembers(FunctionDeclaration value) {
		this._members.add(value);
		return this;
	}

	public ObjectExpression setMembers(FunctionDeclaration[] value) {
		this._members.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public ObjectExpression setMembers(java.util.Collection<FunctionDeclaration> values) {
		this._members.addAll(values);
		return this;
	}

	public ObjectExpression removeMembers(FunctionDeclaration value) {
		this._members.remove(value);
		return this;
	}

	public ObjectExpression removeMembers(int index) {
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
		ObjectExpression that = (ObjectExpression) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "ObjectExpression(extends,fields,members) ::= <<object~if(extends)~ : ~extends:{it|~it~};separator=\", \"~~endif~ {\n" + 
				"	~fields:{it|~it~};separator=\"\\n\"~\n" + 
				"\n" + 
				"	~members:{it|~it~};separator=\"\\n\"~\n" + 
				"} >>";
}  