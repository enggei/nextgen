package nextgen.maven.st;


public class parent {

	private java.lang.String artifactId;
	private java.lang.String groupId;
	private java.lang.Object version;
	private final java.util.UUID uuid;

	public java.lang.String getArtifactId() { 
		return artifactId;
	}

	public parent setArtifactId(java.lang.String artifactId) { 
		this.artifactId = artifactId;
		return this;
	}

	public parent removeArtifactId() { 
		this.artifactId = null;
		return this;
	}

	public java.lang.String getGroupId() { 
		return groupId;
	}

	public parent setGroupId(java.lang.String groupId) { 
		this.groupId = groupId;
		return this;
	}

	public parent removeGroupId() { 
		this.groupId = null;
		return this;
	}

	public java.lang.Object getVersion() { 
		return version;
	}

	public parent setVersion(java.lang.Object version) { 
		this.version = version;
		return this;
	}

	public parent removeVersion() { 
		this.version = null;
		return this;
	}

	@Override
	public java.lang.String toString() { 
		return "parent";
	}

	public parent() { 
		this.uuid = java.util.UUID.randomUUID();
	}

	public parent(java.util.UUID uuid) { 
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() { 
		return this.uuid;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final parent other = (parent) o;
		return uuid != null ? uuid.equals(other.uuid) : other.uuid == null;
	}

	@Override
	public int hashCode() { 
		int result = uuid != null ? uuid.hashCode() : 0;
		return result;
	}
}