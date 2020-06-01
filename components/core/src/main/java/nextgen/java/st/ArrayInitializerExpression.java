package nextgen.java.st;


public class ArrayInitializerExpression implements Expression, LambdaBody {

	private java.util.List<java.lang.Object> values = new java.util.ArrayList<>();
	private final java.util.UUID uuid;

	public java.util.List<java.lang.Object> getValues() { 
		return values;
	}

	public ArrayInitializerExpression addValues(java.lang.Object values) { 
		this.values.add(values);
		return this;
	}

	public ArrayInitializerExpression removeValues(java.lang.Object values) { 
		this.values.remove(values);
		return this;
	}

	@Override
	public java.lang.String toString() { 
		return "ArrayInitializerExpression";
	}

	public ArrayInitializerExpression() { 
		this.uuid = java.util.UUID.randomUUID();
	}

	public ArrayInitializerExpression(java.util.UUID uuid) { 
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() { 
		return this.uuid;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final ArrayInitializerExpression other = (ArrayInitializerExpression) o;
		return uuid != null ? uuid.equals(other.uuid) : other.uuid == null;
	}

	@Override
	public int hashCode() { 
		int result = uuid != null ? uuid.hashCode() : 0;
		return result;
	}
}