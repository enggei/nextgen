package nextgen.maven.st;


public class plugin {

	private java.lang.String groupId;
	private java.lang.String artifactId;
	private java.util.List<pluginConfiguration> configuration = new java.util.ArrayList<>();
	private java.util.List<java.lang.Object> executions = new java.util.ArrayList<>();
	private java.lang.Object version;
	private final java.util.UUID uuid;

	public java.lang.String getGroupId() { 
		return groupId;
	}

	public plugin setGroupId(java.lang.String groupId) { 
		this.groupId = groupId;
		return this;
	}

	public plugin removeGroupId() { 
		this.groupId = null;
		return this;
	}

	public java.lang.String getArtifactId() { 
		return artifactId;
	}

	public plugin setArtifactId(java.lang.String artifactId) { 
		this.artifactId = artifactId;
		return this;
	}

	public plugin removeArtifactId() { 
		this.artifactId = null;
		return this;
	}

	public java.util.List<pluginConfiguration> getConfiguration() { 
		return configuration;
	}

	public plugin addConfiguration(pluginConfiguration configuration) { 
		this.configuration.add(configuration);
		return this;
	}

	public plugin removeConfiguration(pluginConfiguration configuration) { 
		this.configuration.remove(configuration);
		return this;
	}

	public java.util.List<java.lang.Object> getExecutions() { 
		return executions;
	}

	public plugin addExecutions(java.lang.Object executions) { 
		this.executions.add(executions);
		return this;
	}

	public plugin removeExecutions(java.lang.Object executions) { 
		this.executions.remove(executions);
		return this;
	}

	public java.lang.Object getVersion() { 
		return version;
	}

	public plugin setVersion(java.lang.Object version) { 
		this.version = version;
		return this;
	}

	public plugin removeVersion() { 
		this.version = null;
		return this;
	}

	@Override
	public java.lang.String toString() { 
		return "plugin";
	}

	public plugin() { 
		this.uuid = java.util.UUID.randomUUID();
	}

	public plugin(java.util.UUID uuid) { 
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() { 
		return this.uuid;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final plugin other = (plugin) o;
		return uuid != null ? uuid.equals(other.uuid) : other.uuid == null;
	}

	@Override
	public int hashCode() { 
		int result = uuid != null ? uuid.hashCode() : 0;
		return result;
	}
}