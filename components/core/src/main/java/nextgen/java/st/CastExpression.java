package nextgen.java.st;


public class CastExpression implements Expression, LambdaBody {

	private Expression expression;
	private ClassOrInterfaceType type;
	private final java.util.UUID uuid;

	public Expression getExpression() { 
		return expression;
	}

	public CastExpression setExpression(Expression expression) { 
		this.expression = expression;
		return this;
	}

	public CastExpression removeExpression() { 
		this.expression = null;
		return this;
	}

	public ClassOrInterfaceType getType() { 
		return type;
	}

	public CastExpression setType(ClassOrInterfaceType type) { 
		this.type = type;
		return this;
	}

	public CastExpression removeType() { 
		this.type = null;
		return this;
	}

	@Override
	public java.lang.String toString() { 
		return "CastExpression";
	}

	public CastExpression() { 
		this.uuid = java.util.UUID.randomUUID();
	}

	public CastExpression(java.util.UUID uuid) { 
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() { 
		return this.uuid;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final CastExpression other = (CastExpression) o;
		return uuid != null ? uuid.equals(other.uuid) : other.uuid == null;
	}

	@Override
	public int hashCode() { 
		int result = uuid != null ? uuid.hashCode() : 0;
		return result;
	}
}