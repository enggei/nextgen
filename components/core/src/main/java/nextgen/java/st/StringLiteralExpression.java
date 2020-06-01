package nextgen.java.st;


public class StringLiteralExpression implements Expression, LambdaBody {

	private java.lang.Object value;
	private final java.util.UUID uuid;

	public java.lang.Object getValue() { 
		return value;
	}

	public StringLiteralExpression setValue(java.lang.Object value) { 
		this.value = value;
		return this;
	}

	public StringLiteralExpression removeValue() { 
		this.value = null;
		return this;
	}

	@Override
	public java.lang.String toString() { 
		return "StringLiteralExpression";
	}

	public StringLiteralExpression() { 
		this.uuid = java.util.UUID.randomUUID();
	}

	public StringLiteralExpression(java.util.UUID uuid) { 
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() { 
		return this.uuid;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final StringLiteralExpression other = (StringLiteralExpression) o;
		return uuid != null ? uuid.equals(other.uuid) : other.uuid == null;
	}

	@Override
	public int hashCode() { 
		int result = uuid != null ? uuid.hashCode() : 0;
		return result;
	}
}