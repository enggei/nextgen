package nextgen.java.st;


public class BlockStmt implements Statement, LambdaBody {

	private java.util.List<Statement> statements = new java.util.ArrayList<>();
	private final java.util.UUID uuid;

	public java.util.List<Statement> getStatements() { 
		return statements;
	}

	public BlockStmt addStatements(Statement statements) { 
		this.statements.add(statements);
		return this;
	}

	public BlockStmt removeStatements(Statement statements) { 
		this.statements.remove(statements);
		return this;
	}

	@Override
	public java.lang.String toString() { 
		return "BlockStmt";
	}

	public BlockStmt() { 
		this.uuid = java.util.UUID.randomUUID();
	}

	public BlockStmt(java.util.UUID uuid) { 
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() { 
		return this.uuid;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final BlockStmt other = (BlockStmt) o;
		return uuid != null ? uuid.equals(other.uuid) : other.uuid == null;
	}

	@Override
	public int hashCode() { 
		int result = uuid != null ? uuid.hashCode() : 0;
		return result;
	}
}