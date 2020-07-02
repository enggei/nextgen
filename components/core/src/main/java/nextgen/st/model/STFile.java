package nextgen.st.model;

public class STFile {

	private final java.util.UUID uuid;
	private String _name;
	private String _type;
	private String _packageName;
	private String _path;

	private final java.beans.PropertyChangeSupport pcs = new java.beans.PropertyChangeSupport(this);

	public STFile() {
		this.uuid = java.util.UUID.randomUUID();
	}

	public STFile(java.util.UUID uuid) {
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() {
		return this.uuid;
	}	

	public String getName() {
		return this._name;
	}

	public STFile setName(String value) {
		String oldValue = this._name;
		this._name = value;
		this.pcs.firePropertyChange("name", oldValue, value);
		return this;
	}

	public String getType() {
		return this._type;
	}

	public STFile setType(String value) {
		String oldValue = this._type;
		this._type = value;
		this.pcs.firePropertyChange("type", oldValue, value);
		return this;
	}

	public String getPackageName() {
		return this._packageName;
	}

	public STFile setPackageName(String value) {
		String oldValue = this._packageName;
		this._packageName = value;
		this.pcs.firePropertyChange("packageName", oldValue, value);
		return this;
	}

	public String getPath() {
		return this._path;
	}

	public STFile setPath(String value) {
		String oldValue = this._path;
		this._path = value;
		this.pcs.firePropertyChange("path", oldValue, value);
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		STFile that = (STFile) o;
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