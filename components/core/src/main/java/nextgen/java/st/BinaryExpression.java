package nextgen.java.st;


public class BinaryExpression implements Expression, LambdaBody {

	private java.lang.Object right;
	private java.lang.Object operator;
	private java.lang.Object left;
	private final java.util.UUID uuid;

	public java.lang.Object getRight() { 
		return right;
	}

	public BinaryExpression setRight(java.lang.Object right) { 
		this.right = right;
		return this;
	}

	public BinaryExpression removeRight() { 
		this.right = null;
		return this;
	}

	public java.lang.Object getOperator() { 
		return operator;
	}

	public BinaryExpression setOperator(java.lang.Object operator) { 
		this.operator = operator;
		return this;
	}

	public BinaryExpression removeOperator() { 
		this.operator = null;
		return this;
	}

	public java.lang.Object getLeft() { 
		return left;
	}

	public BinaryExpression setLeft(java.lang.Object left) { 
		this.left = left;
		return this;
	}

	public BinaryExpression removeLeft() { 
		this.left = null;
		return this;
	}

	@Override
	public java.lang.String toString() { 
		return "BinaryExpression";
	}

	public BinaryExpression() { 
		this.uuid = java.util.UUID.randomUUID();
	}

	public BinaryExpression(java.util.UUID uuid) { 
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() { 
		return this.uuid;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final BinaryExpression other = (BinaryExpression) o;
		return uuid != null ? uuid.equals(other.uuid) : other.uuid == null;
	}

	@Override
	public int hashCode() { 
		int result = uuid != null ? uuid.hashCode() : 0;
		return result;
	}
}