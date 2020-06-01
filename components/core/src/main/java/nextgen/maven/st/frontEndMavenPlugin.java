package nextgen.maven.st;


public class frontEndMavenPlugin {

	private java.lang.Object nodeVersion;
	private java.lang.Object installDirectory;
	private java.lang.Object pluginVersion;
	private final java.util.UUID uuid;

	public java.lang.Object getNodeVersion() { 
		return nodeVersion;
	}

	public frontEndMavenPlugin setNodeVersion(java.lang.Object nodeVersion) { 
		this.nodeVersion = nodeVersion;
		return this;
	}

	public frontEndMavenPlugin removeNodeVersion() { 
		this.nodeVersion = null;
		return this;
	}

	public java.lang.Object getInstallDirectory() { 
		return installDirectory;
	}

	public frontEndMavenPlugin setInstallDirectory(java.lang.Object installDirectory) { 
		this.installDirectory = installDirectory;
		return this;
	}

	public frontEndMavenPlugin removeInstallDirectory() { 
		this.installDirectory = null;
		return this;
	}

	public java.lang.Object getPluginVersion() { 
		return pluginVersion;
	}

	public frontEndMavenPlugin setPluginVersion(java.lang.Object pluginVersion) { 
		this.pluginVersion = pluginVersion;
		return this;
	}

	public frontEndMavenPlugin removePluginVersion() { 
		this.pluginVersion = null;
		return this;
	}

	@Override
	public java.lang.String toString() { 
		return "frontEndMavenPlugin";
	}

	public frontEndMavenPlugin() { 
		this.uuid = java.util.UUID.randomUUID();
	}

	public frontEndMavenPlugin(java.util.UUID uuid) { 
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() { 
		return this.uuid;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final frontEndMavenPlugin other = (frontEndMavenPlugin) o;
		return uuid != null ? uuid.equals(other.uuid) : other.uuid == null;
	}

	@Override
	public int hashCode() { 
		int result = uuid != null ? uuid.hashCode() : 0;
		return result;
	}
}