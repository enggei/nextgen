package nextgen.java.st;


public class PackageDeclaration {

	private java.lang.String name;
	private final java.util.UUID uuid;

	public java.lang.String getName() { 
		return name;
	}

	public PackageDeclaration setName(java.lang.String name) { 
		this.name = name;
		return this;
	}

	public PackageDeclaration removeName() { 
		this.name = null;
		return this;
	}

	@Override
	public java.lang.String toString() { 
		return name;
	}

	public PackageDeclaration() { 
		this.uuid = java.util.UUID.randomUUID();
	}

	public PackageDeclaration(java.util.UUID uuid) { 
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() { 
		return this.uuid;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final PackageDeclaration other = (PackageDeclaration) o;
		return uuid != null ? uuid.equals(other.uuid) : other.uuid == null;
	}

	@Override
	public int hashCode() { 
		int result = uuid != null ? uuid.hashCode() : 0;
		return result;
	}
}