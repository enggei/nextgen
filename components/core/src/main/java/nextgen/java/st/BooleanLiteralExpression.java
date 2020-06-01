package nextgen.java.st;


public class BooleanLiteralExpression implements Expression, LambdaBody {

	private java.lang.Object value;
	private final java.util.UUID uuid;

	public java.lang.Object getValue() { 
		return value;
	}

	public BooleanLiteralExpression setValue(java.lang.Object value) { 
		this.value = value;
		return this;
	}

	public BooleanLiteralExpression removeValue() { 
		this.value = null;
		return this;
	}

	@Override
	public java.lang.String toString() { 
		return "BooleanLiteralExpression";
	}

	public BooleanLiteralExpression() { 
		this.uuid = java.util.UUID.randomUUID();
	}

	public BooleanLiteralExpression(java.util.UUID uuid) { 
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() { 
		return this.uuid;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final BooleanLiteralExpression other = (BooleanLiteralExpression) o;
		return uuid != null ? uuid.equals(other.uuid) : other.uuid == null;
	}

	@Override
	public int hashCode() { 
		int result = uuid != null ? uuid.hashCode() : 0;
		return result;
	}
}