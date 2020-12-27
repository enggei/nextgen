package nextgen.model;
public class ParameterArguments {

	private final java.util.UUID uuid;
	private STParameter parameter;
	private java.util.List<STArgument> arguments = new java.util.ArrayList<>();

	public ParameterArguments() {
		this.uuid = java.util.UUID.randomUUID();
	}

	public ParameterArguments(java.util.UUID uuid) {
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() {
		return this.uuid;
	}	

	public ParameterArguments setParameter(STParameter value) {
		this.parameter = value;
		return this;
	}

	public STParameter parameter() {
		return parameter;
	}


	public ParameterArguments setArguments(java.util.List<STArgument> value) {
		this.arguments = value;
		return this;
	}

	public java.util.List<STArgument> arguments() {
		return arguments;
	}


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ParameterArguments that = (ParameterArguments) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}
}