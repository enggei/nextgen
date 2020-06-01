package nextgen.java.st;


public class ClassExpression implements Expression, LambdaBody {

	private ClassOrInterfaceType type;
	private final java.util.UUID uuid;

	public ClassOrInterfaceType getType() { 
		return type;
	}

	public ClassExpression setType(ClassOrInterfaceType type) { 
		this.type = type;
		return this;
	}

	public ClassExpression removeType() { 
		this.type = null;
		return this;
	}

	@Override
	public java.lang.String toString() { 
		return "ClassExpression";
	}

	public ClassExpression() { 
		this.uuid = java.util.UUID.randomUUID();
	}

	public ClassExpression(java.util.UUID uuid) { 
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() { 
		return this.uuid;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final ClassExpression other = (ClassExpression) o;
		return uuid != null ? uuid.equals(other.uuid) : other.uuid == null;
	}

	@Override
	public int hashCode() { 
		int result = uuid != null ? uuid.hashCode() : 0;
		return result;
	}
}