package nextgen.st.model;

public class STArgument {

	private final java.util.UUID uuid;
	private nextgen.st.domain.STParameter _stParameter;
	private STValue _value;
	private java.util.List<STArgumentKV> _keyValues = new java.util.ArrayList<>();

	public STArgument() {
		this.uuid = java.util.UUID.randomUUID();
	}

	public STArgument(java.util.UUID uuid) {
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() {
		return this.uuid;
	}	

	public nextgen.st.domain.STParameter getStParameter() {
		return this._stParameter;
	}

	public STArgument setStParameter(nextgen.st.domain.STParameter value) {
		this._stParameter = value;
		return this;
	}

	public STArgument removeStParameter() {
		this._stParameter = null;
		return this;
	}

	public STValue getValue() {
		return this._value;
	}

	public STArgument setValue(STValue value) {
		this._value = value;
		return this;
	}

	public STArgument removeValue() {
		this._value = null;
		return this;
	}

	public java.util.List<STArgumentKV> getKeyValues() {
		return this._keyValues;
	}

	public STArgument addKeyValues(STArgumentKV value) {
		this._keyValues.add(value);
		return this;
	}

	public STArgument removeKeyValues(STArgumentKV value) {
		this._keyValues.remove(value);
		return this;
	}
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		STArgument that = (STArgument) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}
}