package nextgen.java.st;


public class LongExpression implements Expression, LambdaBody {

	private java.lang.Object value;
	private final java.util.UUID uuid;

	public java.lang.Object getValue() { 
		return value;
	}

	public LongExpression setValue(java.lang.Object value) { 
		this.value = value;
		return this;
	}

	public LongExpression removeValue() { 
		this.value = null;
		return this;
	}

	@Override
	public java.lang.String toString() { 
		return "LongExpression";
	}

	public LongExpression() { 
		this.uuid = java.util.UUID.randomUUID();
	}

	public LongExpression(java.util.UUID uuid) { 
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() { 
		return this.uuid;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final LongExpression other = (LongExpression) o;
		return uuid != null ? uuid.equals(other.uuid) : other.uuid == null;
	}

	@Override
	public int hashCode() { 
		int result = uuid != null ? uuid.hashCode() : 0;
		return result;
	}
}