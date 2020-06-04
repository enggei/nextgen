package nextgen.java.st;


public class AssignExpression implements Expression, LambdaBody {

	private java.lang.Object value;
	private java.lang.Object operator;
	private java.lang.Object target;
	private final java.util.UUID uuid;

	public java.lang.Object getValue() { 
		return value;
	}

	public AssignExpression setValue(java.lang.Object value) { 
		this.value = value;
		return this;
	}

	public AssignExpression removeValue() { 
		this.value = null;
		return this;
	}

	public java.lang.Object getOperator() { 
		return operator;
	}

	public AssignExpression setOperator(java.lang.Object operator) { 
		this.operator = operator;
		return this;
	}

	public AssignExpression removeOperator() { 
		this.operator = null;
		return this;
	}

	public java.lang.Object getTarget() { 
		return target;
	}

	public AssignExpression setTarget(java.lang.Object target) { 
		this.target = target;
		return this;
	}

	public AssignExpression removeTarget() { 
		this.target = null;
		return this;
	}

	@Override
	public java.lang.String toString() { 
		return "AssignExpression";
	}

	public AssignExpression() { 
		this.uuid = java.util.UUID.randomUUID();
	}

	public AssignExpression(java.util.UUID uuid) { 
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() { 
		return this.uuid;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final AssignExpression other = (AssignExpression) o;
		return uuid != null ? uuid.equals(other.uuid) : other.uuid == null;
	}

	@Override
	public int hashCode() { 
		int result = uuid != null ? uuid.hashCode() : 0;
		return result;
	}
}