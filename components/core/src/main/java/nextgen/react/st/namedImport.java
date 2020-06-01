package nextgen.react.st;


public class namedImport {

	private java.util.List<java.lang.Object> names = new java.util.ArrayList<>();
	private final java.util.UUID uuid;

	public java.util.List<java.lang.Object> getNames() { 
		return names;
	}

	public namedImport addNames(java.lang.Object names) { 
		this.names.add(names);
		return this;
	}

	public namedImport removeNames(java.lang.Object names) { 
		this.names.remove(names);
		return this;
	}

	@Override
	public java.lang.String toString() { 
		return "namedImport";
	}

	public namedImport() { 
		this.uuid = java.util.UUID.randomUUID();
	}

	public namedImport(java.util.UUID uuid) { 
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() { 
		return this.uuid;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final namedImport other = (namedImport) o;
		return uuid != null ? uuid.equals(other.uuid) : other.uuid == null;
	}

	@Override
	public int hashCode() { 
		int result = uuid != null ? uuid.hashCode() : 0;
		return result;
	}
}