package nextgen.st.model;

public class STArgument implements java.beans.PropertyChangeListener {

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
		if (oldValue != null) oldValue.removePropertyChangeListener(this);
		this._value = value;
		if (value != null) value.addPropertyChangeListener(this);
		this.pcs.firePropertyChange("value", oldValue, value);
		return this;
	}

	public STArgument removeValue() {
		STValue oldValue = this._value;
		this._value = null;
		if (oldValue != null) oldValue.removePropertyChangeListener(this);
		this.pcs.firePropertyChange("value", oldValue, null);
		return this;
	}

	public java.util.List<STArgumentKV> getKeyValues() {
		return this._keyValues;
	}

	public STArgument addKeyValues(STArgumentKV value) {
		this._keyValues.add(value);
		value.addPropertyChangeListener(this);
		this.pcs.firePropertyChange("keyValues", null, value);
		return this;
	}

	public STArgument removeKeyValues(STArgumentKV value) {
		this._keyValues.remove(value);
		if (value != null) value.removePropertyChangeListener(this);
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

	@Override
	public void propertyChange(java.beans.PropertyChangeEvent evt) {
		System.out.println("STArgument updated");
		this.pcs.firePropertyChange("STArgument", null, this);
	}

	public void addPropertyChangeListener(java.beans.PropertyChangeListener listener) {
		System.out.println("STArgument add " + listener.getClass().getSimpleName());
		this.pcs.addPropertyChangeListener(listener);
	}

	public void removePropertyChangeListener(java.beans.PropertyChangeListener listener) {
		System.out.println("STArgument del " + listener.getClass().getSimpleName());
		this.pcs.removePropertyChangeListener(listener);
	}
}