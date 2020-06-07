package nextgen.npm.st;


public class babelrc {

	private final java.util.UUID uuid;

	@Override
	public java.lang.String toString() { 
		return "babelrc";
	}

	public babelrc() { 
		this.uuid = java.util.UUID.randomUUID();
	}

	public babelrc(java.util.UUID uuid) { 
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() { 
		return this.uuid;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final babelrc other = (babelrc) o;
		return uuid != null ? uuid.equals(other.uuid) : other.uuid == null;
	}

	@Override
	public int hashCode() { 
		int result = uuid != null ? uuid.hashCode() : 0;
		return result;
	}
}