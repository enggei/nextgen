package nextgen.st.domain;


public class STParameter {

	private final java.util.UUID uuid;
	private String name;
	private STParameterType type;
	private final java.util.List<STParameterKey> keys = new java.util.ArrayList<>();
	private final java.util.List<String> argumentTypes = new java.util.ArrayList<>();

	public STParameter() { 
		this.uuid = java.util.UUID.randomUUID();
	}

	public STParameter(java.util.UUID uuid) { 
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() { 
		return uuid;
	}

	@Override
	public int hashCode() { 
		return java.util.Objects.hash(uuid);
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final STParameter other = (STParameter) o;
		return uuid.equals(other.uuid);
	}

	public STParameter setName(String name) { 
		this.name = name;
		return this;
	}

	public String getName() { 
		return this.name;
	}

	@Override
	public java.lang.String toString() { 
		return name == null ? null : name;
	}

	public STParameter setType(STParameterType type) { 
		this.type = type;
		return this;
	}

	public STParameterType getType() { 
		return this.type;
	}

	public STParameter addKeys(STParameterKey value) { 
		keys.add(value);
		return this;
	}

	public java.util.List<STParameterKey> getKeys() { 
		return this.keys;
	}

	public STParameter addArgumentTypes(String value) { 
		argumentTypes.add(value);
		return this;
	}

	public java.util.List<String> getArgumentTypes() { 
		return this.argumentTypes;
	}
}