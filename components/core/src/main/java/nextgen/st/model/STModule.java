package nextgen.st.model;

public class STModule {

	public static boolean debug = false;

	private final java.util.UUID uuid;
	private String _name;
	private java.util.List<String> _stGroups = new java.util.ArrayList<>();
	private java.util.List<STModel> _models = new java.util.ArrayList<>();
	private java.util.List<STValue> _values = new java.util.ArrayList<>();

	private final java.beans.PropertyChangeSupport pcs = new java.beans.PropertyChangeSupport(this);

	public STModule() {
		this.uuid = java.util.UUID.randomUUID();
	}

	public STModule(java.util.UUID uuid) {
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() {
		return this.uuid;
	}	

	public String getName() {
		return this._name;
	}

	public STModule setName(String value) {
		String oldValue = this._name;
		this._name = value;
		this.pcs.firePropertyChange("name", oldValue, value);
		return this;
	}

	public java.util.List<String> getStGroups() {
		return this._stGroups;
	}

	public STModule addStGroups(String value) {
		this._stGroups.add(value);
		this.pcs.firePropertyChange("stGroups", null, value);
		return this;
	}

	public STModule removeStGroups(String value) {
		this._stGroups.remove(value);
		this.pcs.firePropertyChange("stGroups", value, null);
		return this;
	}

	public java.util.List<STModel> getModels() {
		return this._models;
	}

	public STModule addModels(STModel value) {
		this._models.add(value);
		this.pcs.firePropertyChange("models", null, value);
		return this;
	}

	public STModule removeModels(STModel value) {
		this._models.remove(value);
		this.pcs.firePropertyChange("models", value, null);
		return this;
	}

	public java.util.List<STValue> getValues() {
		return this._values;
	}

	public STModule addValues(STValue value) {
		this._values.add(value);
		this.pcs.firePropertyChange("values", null, value);
		return this;
	}

	public STModule removeValues(STValue value) {
		this._values.remove(value);
		this.pcs.firePropertyChange("values", value, null);
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		STModule that = (STModule) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	public void addPropertyChangeListener(java.beans.PropertyChangeListener listener) {
		if (debug) System.out.println("STModule add listener " + listener.getClass().getSimpleName());
		this.pcs.addPropertyChangeListener(listener);
	}

	public void removePropertyChangeListener(java.beans.PropertyChangeListener listener) {
		if (debug) System.out.println("STModule rem listener " + listener.getClass().getSimpleName());
		this.pcs.removePropertyChangeListener(listener);
	}
}