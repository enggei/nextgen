package nextgen.templates.java;

public class DoubleLiteralExpression {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _value;

	DoubleLiteralExpression(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		DoubleLiteralExpression that = (DoubleLiteralExpression) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("DoubleLiteralExpression");
		st.add("value", _value);
		return st.render().trim();
	}

	public DoubleLiteralExpression setValue(Object value) {
		this._value = value;
		return this;
	}

	public Object getValue() {
		return this._value;
	}

	public boolean hasValue() {
		return this._value != null;
	}

	public DoubleLiteralExpression removeValue() {
		this._value = null;
		return this;
	} 

	static final String st = "DoubleLiteralExpression(value) ::= <<~value~>> ";
} 