package nextgen.java.st;


public class DoStmt implements Statement, LambdaBody {

	private java.lang.Object condition;
	private Statement body;
	private final java.util.UUID uuid;

	public java.lang.Object getCondition() { 
		return condition;
	}

	public DoStmt setCondition(java.lang.Object condition) { 
		this.condition = condition;
		return this;
	}

	public DoStmt removeCondition() { 
		this.condition = null;
		return this;
	}

	public Statement getBody() { 
		return body;
	}

	public DoStmt setBody(Statement body) { 
		this.body = body;
		return this;
	}

	public DoStmt removeBody() { 
		this.body = null;
		return this;
	}

	@Override
	public java.lang.String toString() { 
		return "DoStmt";
	}

	public DoStmt() { 
		this.uuid = java.util.UUID.randomUUID();
	}

	public DoStmt(java.util.UUID uuid) { 
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() { 
		return this.uuid;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final DoStmt other = (DoStmt) o;
		return uuid != null ? uuid.equals(other.uuid) : other.uuid == null;
	}

	@Override
	public int hashCode() { 
		int result = uuid != null ? uuid.hashCode() : 0;
		return result;
	}
}