package nextgen.templates.javascript;

public class Prop {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _name;
	private Object _value;

	Prop(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("Prop");
		st.add("name", _name);
		st.add("value", _value);
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

	static final String st = "Prop(name,value) ::= <<~name~~if(value)~=~value~~endif~ >>";
} 