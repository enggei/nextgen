package nextgen.st.model;

public class STValue {

	private final java.util.UUID uuid;
	private STValueType _type;
	private java.lang.Object _value;

	private final java.beans.PropertyChangeSupport pcs = new java.beans.PropertyChangeSupport(this);

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
		STValueType oldValue = this._type;
		this._type = value;
		this.pcs.firePropertyChange("type", oldValue, value);
		return this;
	}

	public java.lang.Object getValue() {
		return this._value;
	}

	public STValue setValue(java.lang.Object value) {
		java.lang.Object oldValue = this._value;
		this._value = value;
		this.pcs.firePropertyChange("value", oldValue, value);
		return this;
	}

	public STValue removeValue() {
		java.lang.Object oldValue = this._value;
		this._value = null;
		this.pcs.firePropertyChange("value", oldValue, null);
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

	public void addPropertyChangeListener(java.beans.PropertyChangeListener listener) {
		this.pcs.addPropertyChangeListener(listener);
	}

	public void removePropertyChangeListener(java.beans.PropertyChangeListener listener) {
		this.pcs.removePropertyChangeListener(listener);
	}
}