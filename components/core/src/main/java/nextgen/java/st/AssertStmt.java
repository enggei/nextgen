package nextgen.java.st;


public class AssertStmt implements Statement, LambdaBody {

	private Expression expression;
	private java.lang.Object message;
	private final java.util.UUID uuid;

	public Expression getExpression() { 
		return expression;
	}

	public AssertStmt setExpression(Expression expression) { 
		this.expression = expression;
		return this;
	}

	public AssertStmt removeExpression() { 
		this.expression = null;
		return this;
	}

	public java.lang.Object getMessage() { 
		return message;
	}

	public AssertStmt setMessage(java.lang.Object message) { 
		this.message = message;
		return this;
	}

	public AssertStmt removeMessage() { 
		this.message = null;
		return this;
	}

	@Override
	public java.lang.String toString() { 
		return "AssertStmt";
	}

	public AssertStmt() { 
		this.uuid = java.util.UUID.randomUUID();
	}

	public AssertStmt(java.util.UUID uuid) { 
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() { 
		return this.uuid;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final AssertStmt other = (AssertStmt) o;
		return uuid != null ? uuid.equals(other.uuid) : other.uuid == null;
	}

	@Override
	public int hashCode() { 
		int result = uuid != null ? uuid.hashCode() : 0;
		return result;
	}
}