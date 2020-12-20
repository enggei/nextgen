package nextgen.templates.jgoodies;

public class ConstantSize implements Size {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _unit;
	private Object _value;

	ConstantSize(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("constantSize");
		st.add("unit", _unit);
		st.add("value", _value);
		return st.render().trim();
	}

	public ConstantSize setUnit(Object value) {
		this._unit = value;
		return this;
	}

	public Object getUnit() {
		return this._unit;
	}

	public Object getUnit(Object defaultValue) {
		return this._unit == null ? defaultValue : this._unit;
	}

	public boolean hasUnit() {
		return this._unit != null;
	}

	public ConstantSize removeUnit() {
		this._unit = null;
		return this;
	} 

	public ConstantSize setValue(Object value) {
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

	public ConstantSize removeValue() {
		this._value = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ConstantSize that = (ConstantSize) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "constantSize(unit,value) ::= <<~value~~unit~ >>";
}  