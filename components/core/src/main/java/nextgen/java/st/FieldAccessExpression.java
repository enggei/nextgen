package nextgen.java.st;


public class FieldAccessExpression implements Expression, LambdaBody {

	private java.lang.String name;
	private java.lang.Object scope;
	private final java.util.UUID uuid;

	public java.lang.String getName() { 
		return name;
	}

	public FieldAccessExpression setName(java.lang.String name) { 
		this.name = name;
		return this;
	}

	public FieldAccessExpression removeName() { 
		this.name = null;
		return this;
	}

	@Override
	public java.lang.String toString() { 
		return name;
	}

	public java.lang.Object getScope() { 
		return scope;
	}

	public FieldAccessExpression setScope(java.lang.Object scope) { 
		this.scope = scope;
		return this;
	}

	public FieldAccessExpression removeScope() { 
		this.scope = null;
		return this;
	}

	public FieldAccessExpression() { 
		this.uuid = java.util.UUID.randomUUID();
	}

	public FieldAccessExpression(java.util.UUID uuid) { 
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() { 
		return this.uuid;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final FieldAccessExpression other = (FieldAccessExpression) o;
		return uuid != null ? uuid.equals(other.uuid) : other.uuid == null;
	}

	@Override
	public int hashCode() { 
		int result = uuid != null ? uuid.hashCode() : 0;
		return result;
	}
}