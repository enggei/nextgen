package nextgen.react.st;


public class FunctionalComponent {

	private java.util.List<java.lang.Object> dependencies = new java.util.ArrayList<>();
	private java.lang.Object name;
	private java.util.List<java.lang.Object> localImports = new java.util.ArrayList<>();
	private java.util.List<java.lang.Object> inject = new java.util.ArrayList<>();
	private java.lang.Object element;
	private java.lang.Object wrapper;
	private final java.util.UUID uuid;

	public java.util.List<java.lang.Object> getDependencies() { 
		return dependencies;
	}

	public FunctionalComponent addDependencies(java.lang.Object dependencies) { 
		this.dependencies.add(dependencies);
		return this;
	}

	public FunctionalComponent removeDependencies(java.lang.Object dependencies) { 
		this.dependencies.remove(dependencies);
		return this;
	}

	public java.lang.Object getName() { 
		return name;
	}

	public FunctionalComponent setName(java.lang.Object name) { 
		this.name = name;
		return this;
	}

	public FunctionalComponent removeName() { 
		this.name = null;
		return this;
	}

	public java.util.List<java.lang.Object> getLocalImports() { 
		return localImports;
	}

	public FunctionalComponent addLocalImports(java.lang.Object localImports) { 
		this.localImports.add(localImports);
		return this;
	}

	public FunctionalComponent removeLocalImports(java.lang.Object localImports) { 
		this.localImports.remove(localImports);
		return this;
	}

	public java.util.List<java.lang.Object> getInject() { 
		return inject;
	}

	public FunctionalComponent addInject(java.lang.Object inject) { 
		this.inject.add(inject);
		return this;
	}

	public FunctionalComponent removeInject(java.lang.Object inject) { 
		this.inject.remove(inject);
		return this;
	}

	public java.lang.Object getElement() { 
		return element;
	}

	public FunctionalComponent setElement(java.lang.Object element) { 
		this.element = element;
		return this;
	}

	public FunctionalComponent removeElement() { 
		this.element = null;
		return this;
	}

	public java.lang.Object getWrapper() { 
		return wrapper;
	}

	public FunctionalComponent setWrapper(java.lang.Object wrapper) { 
		this.wrapper = wrapper;
		return this;
	}

	public FunctionalComponent removeWrapper() { 
		this.wrapper = null;
		return this;
	}

	@Override
	public java.lang.String toString() { 
		return "FunctionalComponent";
	}

	public FunctionalComponent() { 
		this.uuid = java.util.UUID.randomUUID();
	}

	public FunctionalComponent(java.util.UUID uuid) { 
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() { 
		return this.uuid;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final FunctionalComponent other = (FunctionalComponent) o;
		return uuid != null ? uuid.equals(other.uuid) : other.uuid == null;
	}

	@Override
	public int hashCode() { 
		int result = uuid != null ? uuid.hashCode() : 0;
		return result;
	}
}