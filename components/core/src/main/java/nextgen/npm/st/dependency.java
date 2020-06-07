package nextgen.npm.st;


public class dependency {

	private java.lang.Object version;
	private java.lang.Object name;
	private final java.util.UUID uuid;

	public java.lang.Object getVersion() { 
		return version;
	}

	public dependency setVersion(java.lang.Object version) { 
		this.version = version;
		return this;
	}

	public dependency removeVersion() { 
		this.version = null;
		return this;
	}

	public java.lang.Object getName() { 
		return name;
	}

	public dependency setName(java.lang.Object name) { 
		this.name = name;
		return this;
	}

	public dependency removeName() { 
		this.name = null;
		return this;
	}

	@Override
	public java.lang.String toString() { 
		return "dependency";
	}

	public dependency() { 
		this.uuid = java.util.UUID.randomUUID();
	}

	public dependency(java.util.UUID uuid) { 
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() { 
		return this.uuid;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final dependency other = (dependency) o;
		return uuid != null ? uuid.equals(other.uuid) : other.uuid == null;
	}

	@Override
	public int hashCode() { 
		int result = uuid != null ? uuid.hashCode() : 0;
		return result;
	}
}