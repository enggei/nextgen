package nextgen.templates.javascript;

public class FunctionExpression {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _name;
	private Object _function;

	FunctionExpression(org.stringtemplate.v4.STGroup stGroup) {
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
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("FunctionExpression");
		st.add("name", _name);
		st.add("function", _function);
		return st.render().trim();
	}

	public FunctionExpression setName(Object value) {
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

	public FunctionExpression removeName() {
		this._name = null;
		return this;
	} 

	public FunctionExpression setFunction(Object value) {
		this._function = value;
		return this;
	}

	public Object getFunction() {
		return this._function;
	}

	public Object getFunction(Object defaultValue) {
		return this._function == null ? defaultValue : this._function;
	}

	public boolean hasFunction() {
		return this._function != null;
	}

	public FunctionExpression removeFunction() {
		this._function = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		FunctionExpression that = (FunctionExpression) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "FunctionExpression(name,function) ::= <<let ~name~ = ~function~; >>";
}  