package nextgen.java.st;


public class ReturnStmt implements Statement, LambdaBody {

	private Expression expression;
	private final java.util.UUID uuid;

	public Expression getExpression() { 
		return expression;
	}

	public ReturnStmt setExpression(Expression expression) { 
		this.expression = expression;
		return this;
	}

	public ReturnStmt removeExpression() { 
		this.expression = null;
		return this;
	}

	@Override
	public java.lang.String toString() { 
		return "ReturnStmt";
	}

	public ReturnStmt() { 
		this.uuid = java.util.UUID.randomUUID();
	}

	public ReturnStmt(java.util.UUID uuid) { 
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() { 
		return this.uuid;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final ReturnStmt other = (ReturnStmt) o;
		return uuid != null ? uuid.equals(other.uuid) : other.uuid == null;
	}

	@Override
	public int hashCode() { 
		int result = uuid != null ? uuid.hashCode() : 0;
		return result;
	}
}