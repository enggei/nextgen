package nextgen.maven.st;


public class dependency {

	private java.lang.Object version;
	private java.lang.String artifactId;
	private java.lang.Object systemPath;
	private java.lang.Object scope;
	private java.lang.String groupId;
	private final java.util.UUID uuid;

	public java.lang.Object getVersion() { 
		return version;
	}

	public dependency setVersion(java.lang.Object version) { 
		this.version = version;
		return this;
	}

	public dependency removeVersion() { 
		this.version = null;
		return this;
	}

	public java.lang.String getArtifactId() { 
		return artifactId;
	}

	public dependency setArtifactId(java.lang.String artifactId) { 
		this.artifactId = artifactId;
		return this;
	}

	public dependency removeArtifactId() { 
		this.artifactId = null;
		return this;
	}

	public java.lang.Object getSystemPath() { 
		return systemPath;
	}

	public dependency setSystemPath(java.lang.Object systemPath) { 
		this.systemPath = systemPath;
		return this;
	}

	public dependency removeSystemPath() { 
		this.systemPath = null;
		return this;
	}

	public java.lang.Object getScope() { 
		return scope;
	}

	public dependency setScope(java.lang.Object scope) { 
		this.scope = scope;
		return this;
	}

	public dependency removeScope() { 
		this.scope = null;
		return this;
	}

	public java.lang.String getGroupId() { 
		return groupId;
	}

	public dependency setGroupId(java.lang.String groupId) { 
		this.groupId = groupId;
		return this;
	}

	public dependency removeGroupId() { 
		this.groupId = null;
		return this;
	}

	@Override
	public java.lang.String toString() { 
		return "dependency";
	}

	public dependency() { 
		this.uuid = java.util.UUID.randomUUID();
	}

	public dependency(java.util.UUID uuid) { 
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() { 
		return this.uuid;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final dependency other = (dependency) o;
		return uuid != null ? uuid.equals(other.uuid) : other.uuid == null;
	}

	@Override
	public int hashCode() { 
		int result = uuid != null ? uuid.hashCode() : 0;
		return result;
	}
}