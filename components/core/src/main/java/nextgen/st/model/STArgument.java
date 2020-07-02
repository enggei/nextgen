package nextgen.st.model;

public class STArgument {

	private final java.util.UUID uuid;
	private nextgen.st.domain.STParameter _stParameter;
	private STValue _value;
	private java.util.List<STArgumentKV> _keyValues = new java.util.ArrayList<>();

	private final java.beans.PropertyChangeSupport pcs = new java.beans.PropertyChangeSupport(this);

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
		nextgen.st.domain.STParameter oldValue = this._stParameter;
		this._stParameter = value;
		this.pcs.firePropertyChange("stParameter", oldValue, value);
		return this;
	}

	public STArgument removeStParameter() {
		nextgen.st.domain.STParameter oldValue = this._stParameter;
		this._stParameter = null;
		this.pcs.firePropertyChange("stParameter", oldValue, null);
		return this;
	}

	public STValue getValue() {
		return this._value;
	}

	public STArgument setValue(STValue value) {
		STValue oldValue = this._value;
		this._value = value;
		this.pcs.firePropertyChange("value", oldValue, value);
		return this;
	}

	public STArgument removeValue() {
		STValue oldValue = this._value;
		this._value = null;
		this.pcs.firePropertyChange("value", oldValue, null);
		return this;
	}

	public java.util.List<STArgumentKV> getKeyValues() {
		return this._keyValues;
	}

	public STArgument addKeyValues(STArgumentKV value) {
		this._keyValues.add(value);
		this.pcs.firePropertyChange("keyValues", null, value);
		return this;
	}

	public STArgument removeKeyValues(STArgumentKV value) {
		this._keyValues.remove(value);
		this.pcs.firePropertyChange("keyValues", value, null);
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

	public void addPropertyChangeListener(java.beans.PropertyChangeListener listener) {
		this.pcs.addPropertyChangeListener(listener);
	}

	public void removePropertyChangeListener(java.beans.PropertyChangeListener listener) {
		this.pcs.removePropertyChangeListener(listener);
	}
}