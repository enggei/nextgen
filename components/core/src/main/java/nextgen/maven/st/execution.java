package nextgen.maven.st;


public class execution {

	private final java.util.UUID uuid;

	@Override
	public java.lang.String toString() { 
		return "execution";
	}

	public execution() { 
		this.uuid = java.util.UUID.randomUUID();
	}

	public execution(java.util.UUID uuid) { 
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() { 
		return this.uuid;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final execution other = (execution) o;
		return uuid != null ? uuid.equals(other.uuid) : other.uuid == null;
	}

	@Override
	public int hashCode() { 
		int result = uuid != null ? uuid.hashCode() : 0;
		return result;
	}
}