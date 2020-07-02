package nextgen.st.model;

public class STArgumentKV {

	private final java.util.UUID uuid;
	private nextgen.st.domain.STParameterKey _stParameterKey;
	private STValue _value;

	private final java.beans.PropertyChangeSupport pcs = new java.beans.PropertyChangeSupport(this);

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
		nextgen.st.domain.STParameterKey oldValue = this._stParameterKey;
		this._stParameterKey = value;
		this.pcs.firePropertyChange("stParameterKey", oldValue, value);
		return this;
	}

	public STArgumentKV removeStParameterKey() {
		nextgen.st.domain.STParameterKey oldValue = this._stParameterKey;
		this._stParameterKey = null;
		this.pcs.firePropertyChange("stParameterKey", oldValue, null);
		return this;
	}

	public STValue getValue() {
		return this._value;
	}

	public STArgumentKV setValue(STValue value) {
		STValue oldValue = this._value;
		this._value = value;
		this.pcs.firePropertyChange("value", oldValue, value);
		return this;
	}

	public STArgumentKV removeValue() {
		STValue oldValue = this._value;
		this._value = null;
		this.pcs.firePropertyChange("value", oldValue, null);
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

	public void addPropertyChangeListener(java.beans.PropertyChangeListener listener) {
		this.pcs.addPropertyChangeListener(listener);
	}

	public void removePropertyChangeListener(java.beans.PropertyChangeListener listener) {
		this.pcs.removePropertyChangeListener(listener);
	}
}