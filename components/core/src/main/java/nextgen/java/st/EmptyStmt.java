package nextgen.java.st;


public class EmptyStmt implements Statement, LambdaBody {

	private final java.util.UUID uuid;

	@Override
	public java.lang.String toString() { 
		return "EmptyStmt";
	}

	public EmptyStmt() { 
		this.uuid = java.util.UUID.randomUUID();
	}

	public EmptyStmt(java.util.UUID uuid) { 
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() { 
		return this.uuid;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final EmptyStmt other = (EmptyStmt) o;
		return uuid != null ? uuid.equals(other.uuid) : other.uuid == null;
	}

	@Override
	public int hashCode() { 
		int result = uuid != null ? uuid.hashCode() : 0;
		return result;
	}
}