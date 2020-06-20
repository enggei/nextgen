package nextgen.templates.kotlin;

public class ThisExpression implements Expression {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Expression _value;

	ThisExpression(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("ThisExpression");
		st.add("value", _value);
		return st.render().trim();
	}

	public ThisExpression setValue(Expression value) {
		this._value = value;
		return this;
	}

	public Expression getValue() {
		return this._value;
	}

	public Expression getValue(Expression defaultValue) {
		return this._value == null ? defaultValue : this._value;
	}

	public boolean hasValue() {
		return this._value != null;
	}

	public ThisExpression removeValue() {
		this._value = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ThisExpression that = (ThisExpression) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "ThisExpression(value) ::= <<this.~value~ >>";
} 