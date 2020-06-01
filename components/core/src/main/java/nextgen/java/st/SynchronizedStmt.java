package nextgen.java.st;


public class SynchronizedStmt implements Statement, LambdaBody {

	private Statement body;
	private Expression expression;
	private final java.util.UUID uuid;

	public Statement getBody() { 
		return body;
	}

	public SynchronizedStmt setBody(Statement body) { 
		this.body = body;
		return this;
	}

	public SynchronizedStmt removeBody() { 
		this.body = null;
		return this;
	}

	public Expression getExpression() { 
		return expression;
	}

	public SynchronizedStmt setExpression(Expression expression) { 
		this.expression = expression;
		return this;
	}

	public SynchronizedStmt removeExpression() { 
		this.expression = null;
		return this;
	}

	@Override
	public java.lang.String toString() { 
		return "SynchronizedStmt";
	}

	public SynchronizedStmt() { 
		this.uuid = java.util.UUID.randomUUID();
	}

	public SynchronizedStmt(java.util.UUID uuid) { 
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() { 
		return this.uuid;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final SynchronizedStmt other = (SynchronizedStmt) o;
		return uuid != null ? uuid.equals(other.uuid) : other.uuid == null;
	}

	@Override
	public int hashCode() { 
		int result = uuid != null ? uuid.hashCode() : 0;
		return result;
	}
}