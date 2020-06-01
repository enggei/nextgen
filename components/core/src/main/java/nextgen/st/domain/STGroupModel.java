package nextgen.st.domain;


public class STGroupModel {

	private final java.util.UUID uuid;
	private String name;
	private String delimiter;
	private java.io.File stgFile;
	private final java.util.List<STTemplate> templates = new java.util.ArrayList<>();

	public STGroupModel() { 
		this.uuid = java.util.UUID.randomUUID();
	}

	public STGroupModel(java.util.UUID uuid) { 
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
		final STGroupModel other = (STGroupModel) o;
		return uuid.equals(other.uuid);
	}

	public STGroupModel setName(String name) { 
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

	public STGroupModel setDelimiter(String delimiter) { 
		this.delimiter = delimiter;
		return this;
	}

	public String getDelimiter() { 
		return this.delimiter;
	}

	public STGroupModel setStgFile(java.io.File stgFile) { 
		this.stgFile = stgFile;
		return this;
	}

	public java.io.File getStgFile() { 
		return this.stgFile;
	}

	public STGroupModel addTemplates(STTemplate value) { 
		templates.add(value);
		return this;
	}

	public java.util.List<STTemplate> getTemplates() { 
		return this.templates;
	}
}