package nextgen.npm.st;


public class packageJson {

	private java.lang.Object description;
	private java.lang.Object bugsUrl;
	private java.lang.Object repositoryType;
	private java.util.List<java.lang.Object> devDependencies = new java.util.ArrayList<>();
	private java.lang.Object name;
	private java.util.List<java.lang.Object> scripts = new java.util.ArrayList<>();
	private java.lang.Object license;
	private java.lang.Object author;
	private java.util.List<java.lang.Object> dependencies = new java.util.ArrayList<>();
	private java.lang.Object repositoryUrl;
	private java.lang.Object version;
	private java.lang.Object homepage;
	private java.lang.Object main;
	private final java.util.UUID uuid;

	public java.lang.Object getDescription() { 
		return description;
	}

	public packageJson setDescription(java.lang.Object description) { 
		this.description = description;
		return this;
	}

	public packageJson removeDescription() { 
		this.description = null;
		return this;
	}

	public java.lang.Object getBugsUrl() { 
		return bugsUrl;
	}

	public packageJson setBugsUrl(java.lang.Object bugsUrl) { 
		this.bugsUrl = bugsUrl;
		return this;
	}

	public packageJson removeBugsUrl() { 
		this.bugsUrl = null;
		return this;
	}

	public java.lang.Object getRepositoryType() { 
		return repositoryType;
	}

	public packageJson setRepositoryType(java.lang.Object repositoryType) { 
		this.repositoryType = repositoryType;
		return this;
	}

	public packageJson removeRepositoryType() { 
		this.repositoryType = null;
		return this;
	}

	public java.util.List<java.lang.Object> getDevDependencies() { 
		return devDependencies;
	}

	public packageJson addDevDependencies(java.lang.Object devDependencies) { 
		this.devDependencies.add(devDependencies);
		return this;
	}

	public packageJson removeDevDependencies(java.lang.Object devDependencies) { 
		this.devDependencies.remove(devDependencies);
		return this;
	}

	public java.lang.Object getName() { 
		return name;
	}

	public packageJson setName(java.lang.Object name) { 
		this.name = name;
		return this;
	}

	public packageJson removeName() { 
		this.name = null;
		return this;
	}

	public java.util.List<java.lang.Object> getScripts() { 
		return scripts;
	}

	public packageJson addScripts(java.lang.Object scripts) { 
		this.scripts.add(scripts);
		return this;
	}

	public packageJson removeScripts(java.lang.Object scripts) { 
		this.scripts.remove(scripts);
		return this;
	}

	public java.lang.Object getLicense() { 
		return license;
	}

	public packageJson setLicense(java.lang.Object license) { 
		this.license = license;
		return this;
	}

	public packageJson removeLicense() { 
		this.license = null;
		return this;
	}

	public java.lang.Object getAuthor() { 
		return author;
	}

	public packageJson setAuthor(java.lang.Object author) { 
		this.author = author;
		return this;
	}

	public packageJson removeAuthor() { 
		this.author = null;
		return this;
	}

	public java.util.List<java.lang.Object> getDependencies() { 
		return dependencies;
	}

	public packageJson addDependencies(java.lang.Object dependencies) { 
		this.dependencies.add(dependencies);
		return this;
	}

	public packageJson removeDependencies(java.lang.Object dependencies) { 
		this.dependencies.remove(dependencies);
		return this;
	}

	public java.lang.Object getRepositoryUrl() { 
		return repositoryUrl;
	}

	public packageJson setRepositoryUrl(java.lang.Object repositoryUrl) { 
		this.repositoryUrl = repositoryUrl;
		return this;
	}

	public packageJson removeRepositoryUrl() { 
		this.repositoryUrl = null;
		return this;
	}

	public java.lang.Object getVersion() { 
		return version;
	}

	public packageJson setVersion(java.lang.Object version) { 
		this.version = version;
		return this;
	}

	public packageJson removeVersion() { 
		this.version = null;
		return this;
	}

	public java.lang.Object getHomepage() { 
		return homepage;
	}

	public packageJson setHomepage(java.lang.Object homepage) { 
		this.homepage = homepage;
		return this;
	}

	public packageJson removeHomepage() { 
		this.homepage = null;
		return this;
	}

	public java.lang.Object getMain() { 
		return main;
	}

	public packageJson setMain(java.lang.Object main) { 
		this.main = main;
		return this;
	}

	public packageJson removeMain() { 
		this.main = null;
		return this;
	}

	@Override
	public java.lang.String toString() { 
		return "packageJson";
	}

	public packageJson() { 
		this.uuid = java.util.UUID.randomUUID();
	}

	public packageJson(java.util.UUID uuid) { 
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() { 
		return this.uuid;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final packageJson other = (packageJson) o;
		return uuid != null ? uuid.equals(other.uuid) : other.uuid == null;
	}

	@Override
	public int hashCode() { 
		int result = uuid != null ? uuid.hashCode() : 0;
		return result;
	}
}