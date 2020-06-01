package nextgen.java.st;


public class UnaryExpression implements Expression, LambdaBody {

	private java.lang.Object operator;
	private Expression expression;
	private java.lang.Boolean isPostfix;
	private java.lang.Boolean isPrefix;
	private final java.util.UUID uuid;

	public java.lang.Object getOperator() { 
		return operator;
	}

	public UnaryExpression setOperator(java.lang.Object operator) { 
		this.operator = operator;
		return this;
	}

	public UnaryExpression removeOperator() { 
		this.operator = null;
		return this;
	}

	public Expression getExpression() { 
		return expression;
	}

	public UnaryExpression setExpression(Expression expression) { 
		this.expression = expression;
		return this;
	}

	public UnaryExpression removeExpression() { 
		this.expression = null;
		return this;
	}

	public java.lang.Boolean isPostfix() { 
		return isPostfix;
	}

	public UnaryExpression setIsPostfix(java.lang.Boolean isPostfix) { 
		this.isPostfix = isPostfix;
		return this;
	}

	public UnaryExpression removeIsPostfix() { 
		this.isPostfix = null;
		return this;
	}

	public java.lang.Boolean isPrefix() { 
		return isPrefix;
	}

	public UnaryExpression setIsPrefix(java.lang.Boolean isPrefix) { 
		this.isPrefix = isPrefix;
		return this;
	}

	public UnaryExpression removeIsPrefix() { 
		this.isPrefix = null;
		return this;
	}

	@Override
	public java.lang.String toString() { 
		return "UnaryExpression";
	}

	public UnaryExpression() { 
		this.uuid = java.util.UUID.randomUUID();
	}

	public UnaryExpression(java.util.UUID uuid) { 
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() { 
		return this.uuid;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final UnaryExpression other = (UnaryExpression) o;
		return uuid != null ? uuid.equals(other.uuid) : other.uuid == null;
	}

	@Override
	public int hashCode() { 
		int result = uuid != null ? uuid.hashCode() : 0;
		return result;
	}
}