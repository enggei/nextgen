package nextgen.st.domain;


public class STTemplate {

	private final java.util.UUID uuid;
	private String name;
	private String text;
	private final java.util.List<STParameter> parameters = new java.util.ArrayList<>();

	public STTemplate() { 
		this.uuid = java.util.UUID.randomUUID();
	}

	public STTemplate(java.util.UUID uuid) { 
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
		final STTemplate other = (STTemplate) o;
		return uuid.equals(other.uuid);
	}

	public STTemplate setName(String name) { 
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

	public STTemplate setText(String text) { 
		this.text = text;
		return this;
	}

	public String getText() { 
		return this.text;
	}

	public STTemplate addParameters(STParameter value) { 
		parameters.add(value);
		return this;
	}

	public java.util.List<STParameter> getParameters() { 
		return this.parameters;
	}
}