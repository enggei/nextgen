package nextgen.st.domain;


public class STGDirectory {

	private final java.util.UUID uuid;
	private java.io.File path;
	private final java.util.List<STGroupModel> groups = new java.util.ArrayList<>();

	public STGDirectory() { 
		this.uuid = java.util.UUID.randomUUID();
	}

	public STGDirectory(java.util.UUID uuid) { 
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
		final STGDirectory other = (STGDirectory) o;
		return uuid.equals(other.uuid);
	}

	public STGDirectory setPath(java.io.File path) { 
		this.path = path;
		return this;
	}

	public java.io.File getPath() { 
		return this.path;
	}

	public STGDirectory addGroups(STGroupModel value) { 
		groups.add(value);
		return this;
	}

	public java.util.List<STGroupModel> getGroups() { 
		return this.groups;
	}
}