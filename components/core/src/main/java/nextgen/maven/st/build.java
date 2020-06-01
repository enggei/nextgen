package nextgen.maven.st;


public class build {

	private java.util.List<java.lang.Object> plugin = new java.util.ArrayList<>();
	private java.util.List<buildTestResources> testResources = new java.util.ArrayList<>();
	private final java.util.UUID uuid;

	public java.util.List<java.lang.Object> getPlugin() { 
		return plugin;
	}

	public build addPlugin(java.lang.Object plugin) { 
		this.plugin.add(plugin);
		return this;
	}

	public build removePlugin(java.lang.Object plugin) { 
		this.plugin.remove(plugin);
		return this;
	}

	public java.util.List<buildTestResources> getTestResources() { 
		return testResources;
	}

	public build addTestResources(buildTestResources testResources) { 
		this.testResources.add(testResources);
		return this;
	}

	public build removeTestResources(buildTestResources testResources) { 
		this.testResources.remove(testResources);
		return this;
	}

	@Override
	public java.lang.String toString() { 
		return "build";
	}

	public build() { 
		this.uuid = java.util.UUID.randomUUID();
	}

	public build(java.util.UUID uuid) { 
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() { 
		return this.uuid;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final build other = (build) o;
		return uuid != null ? uuid.equals(other.uuid) : other.uuid == null;
	}

	@Override
	public int hashCode() { 
		int result = uuid != null ? uuid.hashCode() : 0;
		return result;
	}
}