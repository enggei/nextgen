package nextgen.templates.java;

public class LongExpression implements Expression {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _value;

	LongExpression(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("LongExpression");
		st.add("value", _value);
		return st.render().trim();
	}

	public LongExpression setValue(Object value) {
		this._value = value;
		return this;
	}

	public Object getValue() {
		return this._value;
	}

	public Object getValue(Object defaultValue) {
		return this._value == null ? defaultValue : this._value;
	}

	public boolean hasValue() {
		return this._value != null;
	}

	public LongExpression removeValue() {
		this._value = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		LongExpression that = (LongExpression) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "LongExpression(value) ::= <<~value~ >>";
}  