package nextgen.templates.kotlin;

public class ExtendingClass implements Extending {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private TypeDeclaration _name;
	private java.util.List<Expression> _params = new java.util.ArrayList<>();

	ExtendingClass(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("ExtendingClass");
		st.add("name", _name);
		for (Object o : _params) st.add("params", o);
		return st.render().trim();
	}

	public ExtendingClass setName(TypeDeclaration value) {
		this._name = value;
		return this;
	}

	public TypeDeclaration getName() {
		return this._name;
	}

	public TypeDeclaration getName(TypeDeclaration defaultValue) {
		return this._name == null ? defaultValue : this._name;
	}

	public boolean hasName() {
		return this._name != null;
	}

	public ExtendingClass removeName() {
		this._name = null;
		return this;
	} 

	public ExtendingClass addParams(Expression value) {
		this._params.add(value);
		return this;
	}

	public ExtendingClass setParams(Expression[] value) {
		this._params.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public ExtendingClass setParams(java.util.Collection<Expression> values) {
		this._params.addAll(values);
		return this;
	}

	public ExtendingClass removeParams(Expression value) {
		this._params.remove(value);
		return this;
	}

	public ExtendingClass removeParams(int index) {
		this._params.remove(index);
		return this;
	}

	public java.util.List<Expression> getParams() {
		return this._params;
	} 


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ExtendingClass that = (ExtendingClass) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "ExtendingClass(name,params) ::= <<~name~(~params:{it|~it~};separator=\", \"~) >>";
}  