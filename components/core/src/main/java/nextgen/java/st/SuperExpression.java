package nextgen.java.st;


public class SuperExpression implements Expression, LambdaBody {

	private java.lang.Object typeName;
	private final java.util.UUID uuid;

	public java.lang.Object getTypeName() { 
		return typeName;
	}

	public SuperExpression setTypeName(java.lang.Object typeName) { 
		this.typeName = typeName;
		return this;
	}

	public SuperExpression removeTypeName() { 
		this.typeName = null;
		return this;
	}

	@Override
	public java.lang.String toString() { 
		return "SuperExpression";
	}

	public SuperExpression() { 
		this.uuid = java.util.UUID.randomUUID();
	}

	public SuperExpression(java.util.UUID uuid) { 
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() { 
		return this.uuid;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final SuperExpression other = (SuperExpression) o;
		return uuid != null ? uuid.equals(other.uuid) : other.uuid == null;
	}

	@Override
	public int hashCode() { 
		int result = uuid != null ? uuid.hashCode() : 0;
		return result;
	}
}