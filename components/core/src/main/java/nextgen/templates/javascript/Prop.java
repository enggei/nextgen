package nextgen.templates.javascript;

public class Prop {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _name;
	private Object _value;
	private Object _stringValue;
	private Object _expression;

	Prop(org.stringtemplate.v4.STGroup stGroup) {
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
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("Prop");
		st.add("name", _name);
		st.add("value", _value);
		st.add("stringValue", _stringValue);
		st.add("expression", _expression);
		return st.render().trim();
	}

	public Prop setName(Object value) {
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

	public Prop removeName() {
		this._name = null;
		return this;
	} 

	public Prop setValue(Object value) {
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

	public Prop removeValue() {
		this._value = null;
		return this;
	} 

	public Prop setStringValue(Object value) {
		this._stringValue = value;
		return this;
	}

	public Object getStringValue() {
		return this._stringValue;
	}

	public Object getStringValue(Object defaultValue) {
		return this._stringValue == null ? defaultValue : this._stringValue;
	}

	public boolean hasStringValue() {
		return this._stringValue != null;
	}

	public Prop removeStringValue() {
		this._stringValue = null;
		return this;
	} 

	public Prop setExpression(Object value) {
		this._expression = value;
		return this;
	}

	public Object getExpression() {
		return this._expression;
	}

	public Object getExpression(Object defaultValue) {
		return this._expression == null ? defaultValue : this._expression;
	}

	public boolean hasExpression() {
		return this._expression != null;
	}

	public Prop removeExpression() {
		this._expression = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Prop that = (Prop) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "Prop(name,value,stringValue,expression) ::= <<~name~~if(value)~=~value~~elseif(stringValue)~=\"~stringValue~\"~else~={ ~expression~ }~endif~ >>";
}  