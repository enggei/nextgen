package nextgen.java.st;


public class ImportDeclaration {

	private java.lang.String name;
	private java.lang.Boolean isAsterisk;
	private java.lang.Boolean isStatic;
	private final java.util.UUID uuid;

	public java.lang.String getName() { 
		return name;
	}

	public ImportDeclaration setName(java.lang.String name) { 
		this.name = name;
		return this;
	}

	public ImportDeclaration removeName() { 
		this.name = null;
		return this;
	}

	@Override
	public java.lang.String toString() { 
		return name;
	}

	public java.lang.Boolean isAsterisk() { 
		return isAsterisk;
	}

	public ImportDeclaration setIsAsterisk(java.lang.Boolean isAsterisk) { 
		this.isAsterisk = isAsterisk;
		return this;
	}

	public ImportDeclaration removeIsAsterisk() { 
		this.isAsterisk = null;
		return this;
	}

	public java.lang.Boolean isStatic() { 
		return isStatic;
	}

	public ImportDeclaration setIsStatic(java.lang.Boolean isStatic) { 
		this.isStatic = isStatic;
		return this;
	}

	public ImportDeclaration removeIsStatic() { 
		this.isStatic = null;
		return this;
	}

	public ImportDeclaration() { 
		this.uuid = java.util.UUID.randomUUID();
	}

	public ImportDeclaration(java.util.UUID uuid) { 
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() { 
		return this.uuid;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final ImportDeclaration other = (ImportDeclaration) o;
		return uuid != null ? uuid.equals(other.uuid) : other.uuid == null;
	}

	@Override
	public int hashCode() { 
		int result = uuid != null ? uuid.hashCode() : 0;
		return result;
	}
}