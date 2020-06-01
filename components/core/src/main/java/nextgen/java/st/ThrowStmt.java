package nextgen.java.st;


public class ThrowStmt implements Statement, LambdaBody {

	private Expression expression;
	private final java.util.UUID uuid;

	public Expression getExpression() { 
		return expression;
	}

	public ThrowStmt setExpression(Expression expression) { 
		this.expression = expression;
		return this;
	}

	public ThrowStmt removeExpression() { 
		this.expression = null;
		return this;
	}

	@Override
	public java.lang.String toString() { 
		return "ThrowStmt";
	}

	public ThrowStmt() { 
		this.uuid = java.util.UUID.randomUUID();
	}

	public ThrowStmt(java.util.UUID uuid) { 
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() { 
		return this.uuid;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final ThrowStmt other = (ThrowStmt) o;
		return uuid != null ? uuid.equals(other.uuid) : other.uuid == null;
	}

	@Override
	public int hashCode() { 
		int result = uuid != null ? uuid.hashCode() : 0;
		return result;
	}
}