package nextgen.java.st;


public class ExpressionStmt implements Statement, LambdaBody {

	private java.lang.String comment;
	private Expression expression;
	private final java.util.UUID uuid;

	public java.lang.String getComment() { 
		return comment;
	}

	public ExpressionStmt setComment(java.lang.String comment) { 
		this.comment = comment;
		return this;
	}

	public ExpressionStmt removeComment() { 
		this.comment = null;
		return this;
	}

	public Expression getExpression() { 
		return expression;
	}

	public ExpressionStmt setExpression(Expression expression) { 
		this.expression = expression;
		return this;
	}

	public ExpressionStmt removeExpression() { 
		this.expression = null;
		return this;
	}

	@Override
	public java.lang.String toString() { 
		return "ExpressionStmt";
	}

	public ExpressionStmt() { 
		this.uuid = java.util.UUID.randomUUID();
	}

	public ExpressionStmt(java.util.UUID uuid) { 
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() { 
		return this.uuid;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final ExpressionStmt other = (ExpressionStmt) o;
		return uuid != null ? uuid.equals(other.uuid) : other.uuid == null;
	}

	@Override
	public int hashCode() { 
		int result = uuid != null ? uuid.hashCode() : 0;
		return result;
	}
}