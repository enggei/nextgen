package nextgen.st.model;

public class STModule {

	private final java.util.UUID uuid;
	private String _name;
	private java.util.List<String> _stGroups = new java.util.ArrayList<>();
	private java.util.List<STModel> _models = new java.util.ArrayList<>();
	private java.util.List<STValue> _values = new java.util.ArrayList<>();

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
		this._name = value;
		return this;
	}

	public java.util.List<String> getStGroups() {
		return this._stGroups;
	}

	public STModule addStGroups(String value) {
		this._stGroups.add(value);
		return this;
	}

	public STModule removeStGroups(String value) {
		this._stGroups.remove(value);
		return this;
	}

	public java.util.List<STModel> getModels() {
		return this._models;
	}

	public STModule addModels(STModel value) {
		this._models.add(value);
		return this;
	}

	public STModule removeModels(STModel value) {
		this._models.remove(value);
		return this;
	}

	public java.util.List<STValue> getValues() {
		return this._values;
	}

	public STModule addValues(STValue value) {
		this._values.add(value);
		return this;
	}

	public STModule removeValues(STValue value) {
		this._values.remove(value);
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
}