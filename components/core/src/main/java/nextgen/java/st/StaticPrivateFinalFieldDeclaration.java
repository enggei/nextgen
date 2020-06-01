package nextgen.java.st;


public class StaticPrivateFinalFieldDeclaration {

	private java.lang.Object initializer;
	private java.lang.String name;
	private ClassOrInterfaceType type;
	private final java.util.UUID uuid;

	public java.lang.Object getInitializer() { 
		return initializer;
	}

	public StaticPrivateFinalFieldDeclaration setInitializer(java.lang.Object initializer) { 
		this.initializer = initializer;
		return this;
	}

	public StaticPrivateFinalFieldDeclaration removeInitializer() { 
		this.initializer = null;
		return this;
	}

	public java.lang.String getName() { 
		return name;
	}

	public StaticPrivateFinalFieldDeclaration setName(java.lang.String name) { 
		this.name = name;
		return this;
	}

	public StaticPrivateFinalFieldDeclaration removeName() { 
		this.name = null;
		return this;
	}

	@Override
	public java.lang.String toString() { 
		return name;
	}

	public ClassOrInterfaceType getType() { 
		return type;
	}

	public StaticPrivateFinalFieldDeclaration setType(ClassOrInterfaceType type) { 
		this.type = type;
		return this;
	}

	public StaticPrivateFinalFieldDeclaration removeType() { 
		this.type = null;
		return this;
	}

	public StaticPrivateFinalFieldDeclaration() { 
		this.uuid = java.util.UUID.randomUUID();
	}

	public StaticPrivateFinalFieldDeclaration(java.util.UUID uuid) { 
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() { 
		return this.uuid;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final StaticPrivateFinalFieldDeclaration other = (StaticPrivateFinalFieldDeclaration) o;
		return uuid != null ? uuid.equals(other.uuid) : other.uuid == null;
	}

	@Override
	public int hashCode() { 
		int result = uuid != null ? uuid.hashCode() : 0;
		return result;
	}
}