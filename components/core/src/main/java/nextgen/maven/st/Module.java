package nextgen.maven.st;


public class Module {

	private java.lang.String name;
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

	public Module setName(java.lang.String name) { 
		this.name = name;
		return this;
	}

	public pom getPom() { 
		return pom;
	}

	public java.lang.Boolean hasPom() { 
		return pom != null;
	}

	public Module setPom(pom pom) { 
		this.pom = pom;
		return this;
	}

	public java.util.List<Module> getModules() { 
		return modules;
	}

	public Module addModules(Module modules) { 
		this.modules.add(modules);
		return this;
	}

	public Module() { 
		this.uuid = java.util.UUID.randomUUID();
	}

	public Module(java.util.UUID uuid) { 
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() { 
		return this.uuid;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final Module other = (Module) o;
		return uuid != null ? uuid.equals(other.uuid) : other.uuid == null;
	}

	@Override
	public int hashCode() { 
		int result = uuid != null ? uuid.hashCode() : 0;
		return result;
	}
}