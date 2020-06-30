package nextgen.st.model;

public class STArgumentKV {

	private final java.util.UUID uuid;
	private nextgen.st.domain.STParameterKey _stParameterKey;
	private STValue _value;

	public STArgumentKV() {
		this.uuid = java.util.UUID.randomUUID();
	}

	public STArgumentKV(java.util.UUID uuid) {
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() {
		return this.uuid;
	}	

	public nextgen.st.domain.STParameterKey getStParameterKey() {
		return this._stParameterKey;
	}

	public STArgumentKV setStParameterKey(nextgen.st.domain.STParameterKey value) {
		this._stParameterKey = value;
		return this;
	}

	public STArgumentKV removeStParameterKey() {
		this._stParameterKey = null;
		return this;
	}

	public STValue getValue() {
		return this._value;
	}

	public STArgumentKV setValue(STValue value) {
		this._value = value;
		return this;
	}

	public STArgumentKV removeValue() {
		this._value = null;
		return this;
	}
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		STArgumentKV that = (STArgumentKV) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}
}