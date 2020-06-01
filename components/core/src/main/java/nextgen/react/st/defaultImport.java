package nextgen.react.st;


public class defaultImport {

	private java.lang.Object name;
	private final java.util.UUID uuid;

	public java.lang.Object getName() { 
		return name;
	}

	public defaultImport setName(java.lang.Object name) { 
		this.name = name;
		return this;
	}

	public defaultImport removeName() { 
		this.name = null;
		return this;
	}

	@Override
	public java.lang.String toString() { 
		return "defaultImport";
	}

	public defaultImport() { 
		this.uuid = java.util.UUID.randomUUID();
	}

	public defaultImport(java.util.UUID uuid) { 
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() { 
		return this.uuid;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final defaultImport other = (defaultImport) o;
		return uuid != null ? uuid.equals(other.uuid) : other.uuid == null;
	}

	@Override
	public int hashCode() { 
		int result = uuid != null ? uuid.hashCode() : 0;
		return result;
	}
}