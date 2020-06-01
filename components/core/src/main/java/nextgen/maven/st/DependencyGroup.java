package nextgen.maven.st;


public class DependencyGroup {

	private java.lang.String name;
	private java.lang.String groupId;
	private final java.util.List<java.lang.String> artifacts = new java.util.ArrayList<>();
	private java.lang.String version;
	private final java.util.UUID uuid;

	@Override
	public java.lang.String toString() { 
		return name;
	}

	public java.lang.String getName() { 
		return name;
	}

	public java.lang.Boolean hasName() { 
		return name != null;
	}

	public DependencyGroup setName(java.lang.String name) { 
		this.name = name;
		return this;
	}

	public java.lang.String getGroupId() { 
		return groupId;
	}

	public java.lang.Boolean hasGroupId() { 
		return groupId != null;
	}

	public DependencyGroup setGroupId(java.lang.String groupId) { 
		this.groupId = groupId;
		return this;
	}

	public java.util.List<java.lang.String> getArtifacts() { 
		return artifacts;
	}

	public DependencyGroup addArtifacts(java.lang.String artifacts) { 
		this.artifacts.add(artifacts);
		return this;
	}

	public java.lang.String getVersion() { 
		return version;
	}

	public java.lang.Boolean hasVersion() { 
		return version != null;
	}

	public DependencyGroup setVersion(java.lang.String version) { 
		this.version = version;
		return this;
	}

	public DependencyGroup() { 
		this.uuid = java.util.UUID.randomUUID();
	}

	public DependencyGroup(java.util.UUID uuid) { 
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() { 
		return this.uuid;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final DependencyGroup other = (DependencyGroup) o;
		return uuid != null ? uuid.equals(other.uuid) : other.uuid == null;
	}

	@Override
	public int hashCode() { 
		int result = uuid != null ? uuid.hashCode() : 0;
		return result;
	}
}