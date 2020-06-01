package nextgen.maven.st;


public class Project {

	private java.lang.String name;
	private java.lang.String root;
	private pom pom;
	private final java.util.List<Module> modules = new java.util.ArrayList<>();
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

	public Project setName(java.lang.String name) { 
		this.name = name;
		return this;
	}

	public java.lang.String getRoot() { 
		return root;
	}

	public java.lang.Boolean hasRoot() { 
		return root != null;
	}

	public Project setRoot(java.lang.String root) { 
		this.root = root;
		return this;
	}

	public pom getPom() { 
		return pom;
	}

	public java.lang.Boolean hasPom() { 
		return pom != null;
	}

	public Project setPom(pom pom) { 
		this.pom = pom;
		return this;
	}

	public java.util.List<Module> getModules() { 
		return modules;
	}

	public Project addModules(Module modules) { 
		this.modules.add(modules);
		return this;
	}

	public Project() { 
		this.uuid = java.util.UUID.randomUUID();
	}

	public Project(java.util.UUID uuid) { 
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() { 
		return this.uuid;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final Project other = (Project) o;
		return uuid != null ? uuid.equals(other.uuid) : other.uuid == null;
	}

	@Override
	public int hashCode() { 
		int result = uuid != null ? uuid.hashCode() : 0;
		return result;
	}
}