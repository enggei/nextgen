package nextgen.java.st;


public class InstanceOfExpression implements Expression, LambdaBody {

	private Expression expression;
	private ClassOrInterfaceType type;
	private final java.util.UUID uuid;

	public Expression getExpression() { 
		return expression;
	}

	public InstanceOfExpression setExpression(Expression expression) { 
		this.expression = expression;
		return this;
	}

	public InstanceOfExpression removeExpression() { 
		this.expression = null;
		return this;
	}

	public ClassOrInterfaceType getType() { 
		return type;
	}

	public InstanceOfExpression setType(ClassOrInterfaceType type) { 
		this.type = type;
		return this;
	}

	public InstanceOfExpression removeType() { 
		this.type = null;
		return this;
	}

	@Override
	public java.lang.String toString() { 
		return "InstanceOfExpression";
	}

	public InstanceOfExpression() { 
		this.uuid = java.util.UUID.randomUUID();
	}

	public InstanceOfExpression(java.util.UUID uuid) { 
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() { 
		return this.uuid;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final InstanceOfExpression other = (InstanceOfExpression) o;
		return uuid != null ? uuid.equals(other.uuid) : other.uuid == null;
	}

	@Override
	public int hashCode() { 
		int result = uuid != null ? uuid.hashCode() : 0;
		return result;
	}
}