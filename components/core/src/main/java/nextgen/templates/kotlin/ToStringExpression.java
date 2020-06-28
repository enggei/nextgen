package nextgen.templates.kotlin;

public class ToStringExpression implements Expression {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private String _name;
	private StringExpression _stringExpression;

	ToStringExpression(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("ToStringExpression");
		st.add("name", _name);
		st.add("stringExpression", _stringExpression);
		return st.render().trim();
	}

	public ToStringExpression setName(String value) {
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

	public ToStringExpression removeName() {
		this._name = null;
		return this;
	} 

	public ToStringExpression setStringExpression(StringExpression value) {
		this._stringExpression = value;
		return this;
	}

	public StringExpression getStringExpression() {
		return this._stringExpression;
	}

	public StringExpression getStringExpression(StringExpression defaultValue) {
		return this._stringExpression == null ? defaultValue : this._stringExpression;
	}

	public boolean hasStringExpression() {
		return this._stringExpression != null;
	}

	public ToStringExpression removeStringExpression() {
		this._stringExpression = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ToStringExpression that = (ToStringExpression) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "ToStringExpression(name,stringExpression) ::= <<~name~='~stringExpression~' >>";
}  