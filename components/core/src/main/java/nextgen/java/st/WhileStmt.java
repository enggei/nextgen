package nextgen.java.st;


public class WhileStmt implements Statement, LambdaBody {

	private Statement body;
	private java.lang.Object condition;
	private final java.util.UUID uuid;

	public Statement getBody() { 
		return body;
	}

	public WhileStmt setBody(Statement body) { 
		this.body = body;
		return this;
	}

	public WhileStmt removeBody() { 
		this.body = null;
		return this;
	}

	public java.lang.Object getCondition() { 
		return condition;
	}

	public WhileStmt setCondition(java.lang.Object condition) { 
		this.condition = condition;
		return this;
	}

	public WhileStmt removeCondition() { 
		this.condition = null;
		return this;
	}

	@Override
	public java.lang.String toString() { 
		return "WhileStmt";
	}

	public WhileStmt() { 
		this.uuid = java.util.UUID.randomUUID();
	}

	public WhileStmt(java.util.UUID uuid) { 
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() { 
		return this.uuid;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final WhileStmt other = (WhileStmt) o;
		return uuid != null ? uuid.equals(other.uuid) : other.uuid == null;
	}

	@Override
	public int hashCode() { 
		int result = uuid != null ? uuid.hashCode() : 0;
		return result;
	}
}