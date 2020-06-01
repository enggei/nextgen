package nextgen.java.st;


public class ContinueStmt implements Statement, LambdaBody {

	private java.lang.Object label;
	private final java.util.UUID uuid;

	public java.lang.Object getLabel() { 
		return label;
	}

	public ContinueStmt setLabel(java.lang.Object label) { 
		this.label = label;
		return this;
	}

	public ContinueStmt removeLabel() { 
		this.label = null;
		return this;
	}

	@Override
	public java.lang.String toString() { 
		return "ContinueStmt";
	}

	public ContinueStmt() { 
		this.uuid = java.util.UUID.randomUUID();
	}

	public ContinueStmt(java.util.UUID uuid) { 
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() { 
		return this.uuid;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final ContinueStmt other = (ContinueStmt) o;
		return uuid != null ? uuid.equals(other.uuid) : other.uuid == null;
	}

	@Override
	public int hashCode() { 
		int result = uuid != null ? uuid.hashCode() : 0;
		return result;
	}
}