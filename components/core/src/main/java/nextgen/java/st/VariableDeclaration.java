package nextgen.java.st;


public class VariableDeclaration implements Expression {

	private java.lang.String name;
	private ClassOrInterfaceType type;
	private java.lang.Object initializer;
	private final java.util.UUID uuid;

	public java.lang.String getName() { 
		return name;
	}

	public VariableDeclaration setName(java.lang.String name) { 
		this.name = name;
		return this;
	}

	public VariableDeclaration removeName() { 
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

	public VariableDeclaration setType(ClassOrInterfaceType type) { 
		this.type = type;
		return this;
	}

	public VariableDeclaration removeType() { 
		this.type = null;
		return this;
	}

	public java.lang.Object getInitializer() { 
		return initializer;
	}

	public VariableDeclaration setInitializer(java.lang.Object initializer) { 
		this.initializer = initializer;
		return this;
	}

	public VariableDeclaration removeInitializer() { 
		this.initializer = null;
		return this;
	}

	public VariableDeclaration() { 
		this.uuid = java.util.UUID.randomUUID();
	}

	public VariableDeclaration(java.util.UUID uuid) { 
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() { 
		return this.uuid;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final VariableDeclaration other = (VariableDeclaration) o;
		return uuid != null ? uuid.equals(other.uuid) : other.uuid == null;
	}

	@Override
	public int hashCode() { 
		int result = uuid != null ? uuid.hashCode() : 0;
		return result;
	}
}