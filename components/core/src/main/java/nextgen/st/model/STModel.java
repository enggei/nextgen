package nextgen.st.model;

public class STModel implements java.beans.PropertyChangeListener {

	private final java.util.UUID uuid;
	private STFile _file;
	private nextgen.st.domain.STTemplate _stTemplate;
	private java.util.List<STArgument> _arguments = new java.util.ArrayList<>();

	private final java.beans.PropertyChangeSupport pcs = new java.beans.PropertyChangeSupport(this);

	public STModel() {
		this.uuid = java.util.UUID.randomUUID();
	}

	public STModel(java.util.UUID uuid) {
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() {
		return this.uuid;
	}	

	public STFile getFile() {
		return this._file;
	}

	public STModel setFile(STFile value) {
		STFile oldValue = this._file;
		if (oldValue != null) oldValue.removePropertyChangeListener(this);
		this._file = value;
		if (value != null) value.addPropertyChangeListener(this);
		this.pcs.firePropertyChange("file", oldValue, value);
		return this;
	}

	public STModel removeFile() {
		STFile oldValue = this._file;
		this._file = null;
		if (oldValue != null) oldValue.removePropertyChangeListener(this);
		this.pcs.firePropertyChange("file", oldValue, null);
		return this;
	}

	public nextgen.st.domain.STTemplate getStTemplate() {
		return this._stTemplate;
	}

	public STModel setStTemplate(nextgen.st.domain.STTemplate value) {
		nextgen.st.domain.STTemplate oldValue = this._stTemplate;
		this._stTemplate = value;
		this.pcs.firePropertyChange("stTemplate", oldValue, value);
		return this;
	}

	public STModel removeStTemplate() {
		nextgen.st.domain.STTemplate oldValue = this._stTemplate;
		this._stTemplate = null;
		this.pcs.firePropertyChange("stTemplate", oldValue, null);
		return this;
	}

	public java.util.List<STArgument> getArguments() {
		return this._arguments;
	}

	public STModel addArguments(STArgument value) {
		this._arguments.add(value);
		value.addPropertyChangeListener(this);
		this.pcs.firePropertyChange("arguments", null, value);
		return this;
	}

	public STModel removeArguments(STArgument value) {
		this._arguments.remove(value);
		if (value != null) value.removePropertyChangeListener(this);
		this.pcs.firePropertyChange("arguments", value, null);
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		STModel that = (STModel) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	@Override
	public void propertyChange(java.beans.PropertyChangeEvent evt) {
		System.out.println("STModel updated");
		this.pcs.firePropertyChange("STModel", null, this);
	}

	public void addPropertyChangeListener(java.beans.PropertyChangeListener listener) {
		System.out.println("STModel add " + listener.getClass().getSimpleName());
		this.pcs.addPropertyChangeListener(listener);
	}

	public void removePropertyChangeListener(java.beans.PropertyChangeListener listener) {
		System.out.println("STModel del " + listener.getClass().getSimpleName());
		this.pcs.removePropertyChangeListener(listener);
	}
}