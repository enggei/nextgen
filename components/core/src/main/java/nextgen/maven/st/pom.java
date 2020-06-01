package nextgen.maven.st;


public class pom {

	private java.lang.String name;
	private java.util.List<java.lang.Object> distributionManagement = new java.util.ArrayList<>();
	private java.lang.Object build;
	private java.lang.String groupId;
	private java.lang.String artifactId;
	private java.util.List<dependency> dependencies = new java.util.ArrayList<>();
	private java.lang.Object version;
	private java.lang.Object parent;
	private Packaging packaging;
	private java.util.List<pomProperties> properties = new java.util.ArrayList<>();
	private java.util.List<java.lang.Object> modules = new java.util.ArrayList<>();
	private java.util.List<repository> repositories = new java.util.ArrayList<>();
	private final java.util.UUID uuid;

	public java.lang.String getName() { 
		return name;
	}

	public pom setName(java.lang.String name) { 
		this.name = name;
		return this;
	}

	public pom removeName() { 
		this.name = null;
		return this;
	}

	@Override
	public java.lang.String toString() { 
		return name;
	}

	public java.util.List<java.lang.Object> getDistributionManagement() { 
		return distributionManagement;
	}

	public pom addDistributionManagement(java.lang.Object distributionManagement) { 
		this.distributionManagement.add(distributionManagement);
		return this;
	}

	public pom removeDistributionManagement(java.lang.Object distributionManagement) { 
		this.distributionManagement.remove(distributionManagement);
		return this;
	}

	public java.lang.Object getBuild() { 
		return build;
	}

	public pom setBuild(java.lang.Object build) { 
		this.build = build;
		return this;
	}

	public pom removeBuild() { 
		this.build = null;
		return this;
	}

	public java.lang.String getGroupId() { 
		return groupId;
	}

	public pom setGroupId(java.lang.String groupId) { 
		this.groupId = groupId;
		return this;
	}

	public pom removeGroupId() { 
		this.groupId = null;
		return this;
	}

	public java.lang.String getArtifactId() { 
		return artifactId;
	}

	public pom setArtifactId(java.lang.String artifactId) { 
		this.artifactId = artifactId;
		return this;
	}

	public pom removeArtifactId() { 
		this.artifactId = null;
		return this;
	}

	public java.util.List<dependency> getDependencies() { 
		return dependencies;
	}

	public pom addDependencies(dependency dependencies) { 
		this.dependencies.add(dependencies);
		return this;
	}

	public pom removeDependencies(dependency dependencies) { 
		this.dependencies.remove(dependencies);
		return this;
	}

	public java.lang.Object getVersion() { 
		return version;
	}

	public pom setVersion(java.lang.Object version) { 
		this.version = version;
		return this;
	}

	public pom removeVersion() { 
		this.version = null;
		return this;
	}

	public java.lang.Object getParent() { 
		return parent;
	}

	public pom setParent(java.lang.Object parent) { 
		this.parent = parent;
		return this;
	}

	public pom removeParent() { 
		this.parent = null;
		return this;
	}

	public Packaging getPackaging() { 
		return packaging;
	}

	public pom setPackaging(Packaging packaging) { 
		this.packaging = packaging;
		return this;
	}

	public pom removePackaging() { 
		this.packaging = null;
		return this;
	}

	public java.util.List<pomProperties> getProperties() { 
		return properties;
	}

	public pom addProperties(pomProperties properties) { 
		this.properties.add(properties);
		return this;
	}

	public pom removeProperties(pomProperties properties) { 
		this.properties.remove(properties);
		return this;
	}

	public java.util.List<java.lang.Object> getModules() { 
		return modules;
	}

	public pom addModules(java.lang.Object modules) { 
		this.modules.add(modules);
		return this;
	}

	public pom removeModules(java.lang.Object modules) { 
		this.modules.remove(modules);
		return this;
	}

	public java.util.List<repository> getRepositories() { 
		return repositories;
	}

	public pom addRepositories(repository repositories) { 
		this.repositories.add(repositories);
		return this;
	}

	public pom removeRepositories(repository repositories) { 
		this.repositories.remove(repositories);
		return this;
	}

	public pom() { 
		this.uuid = java.util.UUID.randomUUID();
	}

	public pom(java.util.UUID uuid) { 
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() { 
		return this.uuid;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final pom other = (pom) o;
		return uuid != null ? uuid.equals(other.uuid) : other.uuid == null;
	}

	@Override
	public int hashCode() { 
		int result = uuid != null ? uuid.hashCode() : 0;
		return result;
	}
}