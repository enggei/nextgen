package nextgen.java.st;


public class LabeledStmt implements Statement, LambdaBody {

	private java.lang.Object label;
	private java.lang.Object statement;
	private final java.util.UUID uuid;

	public java.lang.Object getLabel() { 
		return label;
	}

	public LabeledStmt setLabel(java.lang.Object label) { 
		this.label = label;
		return this;
	}

	public LabeledStmt removeLabel() { 
		this.label = null;
		return this;
	}

	public java.lang.Object getStatement() { 
		return statement;
	}

	public LabeledStmt setStatement(java.lang.Object statement) { 
		this.statement = statement;
		return this;
	}

	public LabeledStmt removeStatement() { 
		this.statement = null;
		return this;
	}

	@Override
	public java.lang.String toString() { 
		return "LabeledStmt";
	}

	public LabeledStmt() { 
		this.uuid = java.util.UUID.randomUUID();
	}

	public LabeledStmt(java.util.UUID uuid) { 
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() { 
		return this.uuid;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final LabeledStmt other = (LabeledStmt) o;
		return uuid != null ? uuid.equals(other.uuid) : other.uuid == null;
	}

	@Override
	public int hashCode() { 
		int result = uuid != null ? uuid.hashCode() : 0;
		return result;
	}
}