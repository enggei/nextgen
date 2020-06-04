package nextgen.java.st;


public class ModuleDeclaration {

	private java.lang.String name;
	private java.util.List<java.lang.Object> exportsDirective = new java.util.ArrayList<>();
	private java.util.List<java.lang.Object> providesDirective = new java.util.ArrayList<>();
	private java.util.List<java.lang.Object> opens = new java.util.ArrayList<>();
	private java.util.List<java.lang.Object> requiresDirective = new java.util.ArrayList<>();
	private java.util.List<java.lang.Object> usesDirective = new java.util.ArrayList<>();
	private final java.util.UUID uuid;

	public java.lang.String getName() { 
		return name;
	}

	public ModuleDeclaration setName(java.lang.String name) { 
		this.name = name;
		return this;
	}

	public ModuleDeclaration removeName() { 
		this.name = null;
		return this;
	}

	@Override
	public java.lang.String toString() { 
		return name;
	}

	public java.util.List<java.lang.Object> getExportsDirective() { 
		return exportsDirective;
	}

	public ModuleDeclaration addExportsDirective(java.lang.Object exportsDirective) { 
		this.exportsDirective.add(exportsDirective);
		return this;
	}

	public ModuleDeclaration removeExportsDirective(java.lang.Object exportsDirective) { 
		this.exportsDirective.remove(exportsDirective);
		return this;
	}

	public java.util.List<java.lang.Object> getProvidesDirective() { 
		return providesDirective;
	}

	public ModuleDeclaration addProvidesDirective(java.lang.Object providesDirective) { 
		this.providesDirective.add(providesDirective);
		return this;
	}

	public ModuleDeclaration removeProvidesDirective(java.lang.Object providesDirective) { 
		this.providesDirective.remove(providesDirective);
		return this;
	}

	public java.util.List<java.lang.Object> getOpens() { 
		return opens;
	}

	public ModuleDeclaration addOpens(java.lang.Object opens) { 
		this.opens.add(opens);
		return this;
	}

	public ModuleDeclaration removeOpens(java.lang.Object opens) { 
		this.opens.remove(opens);
		return this;
	}

	public java.util.List<java.lang.Object> getRequiresDirective() { 
		return requiresDirective;
	}

	public ModuleDeclaration addRequiresDirective(java.lang.Object requiresDirective) { 
		this.requiresDirective.add(requiresDirective);
		return this;
	}

	public ModuleDeclaration removeRequiresDirective(java.lang.Object requiresDirective) { 
		this.requiresDirective.remove(requiresDirective);
		return this;
	}

	public java.util.List<java.lang.Object> getUsesDirective() { 
		return usesDirective;
	}

	public ModuleDeclaration addUsesDirective(java.lang.Object usesDirective) { 
		this.usesDirective.add(usesDirective);
		return this;
	}

	public ModuleDeclaration removeUsesDirective(java.lang.Object usesDirective) { 
		this.usesDirective.remove(usesDirective);
		return this;
	}

	public ModuleDeclaration() { 
		this.uuid = java.util.UUID.randomUUID();
	}

	public ModuleDeclaration(java.util.UUID uuid) { 
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() { 
		return this.uuid;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final ModuleDeclaration other = (ModuleDeclaration) o;
		return uuid != null ? uuid.equals(other.uuid) : other.uuid == null;
	}

	@Override
	public int hashCode() { 
		int result = uuid != null ? uuid.hashCode() : 0;
		return result;
	}
}