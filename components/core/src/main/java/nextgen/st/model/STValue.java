package nextgen.st.model;

public class STValue implements java.beans.PropertyChangeListener {

	private final java.util.UUID uuid;
	private STValueType _type;
	private java.lang.Object _value;
	private STModel _stModel;

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

	public STModel getStModel() {
		return this._stModel;
	}

	public STValue setStModel(STModel value) {
		STModel oldValue = this._stModel;
		if (oldValue != null) oldValue.removePropertyChangeListener(this);
		this._stModel = value;
		if (value != null) value.addPropertyChangeListener(this);
		this.pcs.firePropertyChange("stModel", oldValue, value);
		return this;
	}

	public STValue removeStModel() {
		STModel oldValue = this._stModel;
		this._stModel = null;
		if (oldValue != null) oldValue.removePropertyChangeListener(this);
		this.pcs.firePropertyChange("stModel", oldValue, null);
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

	@Override
	public void propertyChange(java.beans.PropertyChangeEvent evt) {
		System.out.println("STValue updated");
		this.pcs.firePropertyChange("STValue", null, this);
	}

	public void addPropertyChangeListener(java.beans.PropertyChangeListener listener) {
		System.out.println("STValue add " + listener.getClass().getSimpleName());
		this.pcs.addPropertyChangeListener(listener);
	}

	public void removePropertyChangeListener(java.beans.PropertyChangeListener listener) {
		System.out.println("STValue del " + listener.getClass().getSimpleName());
		this.pcs.removePropertyChangeListener(listener);
	}
}