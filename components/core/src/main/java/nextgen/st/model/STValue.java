package nextgen.st.model;

public class STValue {

	private final java.util.UUID uuid;
	private STValueType _type;
	private java.lang.Object _value;

	public STValue() {
		this.uuid = java.util.UUID.randomUUID();
	}

	public STValue(java.util.UUID uuid) {
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() {
		return this.uuid;
	}	

	public STValueType getType() {
		return this._type;
	}

	public STValue setType(STValueType value) {
		this._type = value;
		return this;
	}

	public java.lang.Object getValue() {
		return this._value;
	}

	public STValue setValue(java.lang.Object value) {
		this._value = value;
		return this;
	}

	public STValue removeValue() {
		this._value = null;
		return this;
	}
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		STValue that = (STValue) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}
}