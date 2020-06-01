package nextgen.java.st;


public class EnclosedExpression implements Expression, LambdaBody {

	private Expression expression;
	private final java.util.UUID uuid;

	public Expression getExpression() { 
		return expression;
	}

	public EnclosedExpression setExpression(Expression expression) { 
		this.expression = expression;
		return this;
	}

	public EnclosedExpression removeExpression() { 
		this.expression = null;
		return this;
	}

	@Override
	public java.lang.String toString() { 
		return "EnclosedExpression";
	}

	public EnclosedExpression() { 
		this.uuid = java.util.UUID.randomUUID();
	}

	public EnclosedExpression(java.util.UUID uuid) { 
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() { 
		return this.uuid;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final EnclosedExpression other = (EnclosedExpression) o;
		return uuid != null ? uuid.equals(other.uuid) : other.uuid == null;
	}

	@Override
	public int hashCode() { 
		int result = uuid != null ? uuid.hashCode() : 0;
		return result;
	}
}