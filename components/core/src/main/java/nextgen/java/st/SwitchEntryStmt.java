package nextgen.java.st;


public class SwitchEntryStmt implements Statement, LambdaBody {

	private java.util.List<java.lang.Object> labels = new java.util.ArrayList<>();
	private java.util.List<Statement> statements = new java.util.ArrayList<>();
	private final java.util.UUID uuid;

	public java.util.List<java.lang.Object> getLabels() { 
		return labels;
	}

	public SwitchEntryStmt addLabels(java.lang.Object labels) { 
		this.labels.add(labels);
		return this;
	}

	public SwitchEntryStmt removeLabels(java.lang.Object labels) { 
		this.labels.remove(labels);
		return this;
	}

	public java.util.List<Statement> getStatements() { 
		return statements;
	}

	public SwitchEntryStmt addStatements(Statement statements) { 
		this.statements.add(statements);
		return this;
	}

	public SwitchEntryStmt removeStatements(Statement statements) { 
		this.statements.remove(statements);
		return this;
	}

	@Override
	public java.lang.String toString() { 
		return "SwitchEntryStmt";
	}

	public SwitchEntryStmt() { 
		this.uuid = java.util.UUID.randomUUID();
	}

	public SwitchEntryStmt(java.util.UUID uuid) { 
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() { 
		return this.uuid;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final SwitchEntryStmt other = (SwitchEntryStmt) o;
		return uuid != null ? uuid.equals(other.uuid) : other.uuid == null;
	}

	@Override
	public int hashCode() { 
		int result = uuid != null ? uuid.hashCode() : 0;
		return result;
	}
}