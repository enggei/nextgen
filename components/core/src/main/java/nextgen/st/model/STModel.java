package nextgen.st.model;

public class STModel {

	private final java.util.UUID uuid;
	private nextgen.st.domain.STTemplate _stTemplate;
	private java.util.List<STArgument> _arguments = new java.util.ArrayList<>();

	public STModel() {
		this.uuid = java.util.UUID.randomUUID();
	}

	public STModel(java.util.UUID uuid) {
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() {
		return this.uuid;
	}	

	public nextgen.st.domain.STTemplate getStTemplate() {
		return this._stTemplate;
	}

	public STModel setStTemplate(nextgen.st.domain.STTemplate value) {
		this._stTemplate = value;
		return this;
	}

	public STModel removeStTemplate() {
		this._stTemplate = null;
		return this;
	}

	public java.util.List<STArgument> getArguments() {
		return this._arguments;
	}

	public STModel addArguments(STArgument value) {
		this._arguments.add(value);
		return this;
	}

	public STModel removeArguments(STArgument value) {
		this._arguments.remove(value);
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
}