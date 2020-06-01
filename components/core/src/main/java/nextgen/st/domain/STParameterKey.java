package nextgen.st.domain;


public class STParameterKey {

	private final java.util.UUID uuid;
	private String name;
	private final java.util.List<String> argumentTypes = new java.util.ArrayList<>();

	public STParameterKey() { 
		this.uuid = java.util.UUID.randomUUID();
	}

	public STParameterKey(java.util.UUID uuid) { 
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
		final STParameterKey other = (STParameterKey) o;
		return uuid.equals(other.uuid);
	}

	public STParameterKey setName(String name) { 
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

	public STParameterKey addArgumentTypes(String value) { 
		argumentTypes.add(value);
		return this;
	}

	public java.util.List<String> getArgumentTypes() { 
		return this.argumentTypes;
	}
}