package nextgen.java.st;


public class BreakStmt implements Statement, LambdaBody {

	private java.lang.Object label;
	private final java.util.UUID uuid;

	public java.lang.Object getLabel() { 
		return label;
	}

	public BreakStmt setLabel(java.lang.Object label) { 
		this.label = label;
		return this;
	}

	public BreakStmt removeLabel() { 
		this.label = null;
		return this;
	}

	@Override
	public java.lang.String toString() { 
		return "BreakStmt";
	}

	public BreakStmt() { 
		this.uuid = java.util.UUID.randomUUID();
	}

	public BreakStmt(java.util.UUID uuid) { 
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() { 
		return this.uuid;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final BreakStmt other = (BreakStmt) o;
		return uuid != null ? uuid.equals(other.uuid) : other.uuid == null;
	}

	@Override
	public int hashCode() { 
		int result = uuid != null ? uuid.hashCode() : 0;
		return result;
	}
}