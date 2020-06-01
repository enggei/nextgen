package nextgen.java.st;


public class MethodReferenceExpression implements Expression, LambdaBody {

	private java.lang.Object identifier;
	private java.lang.Object scope;
	private final java.util.UUID uuid;

	public java.lang.Object getIdentifier() { 
		return identifier;
	}

	public MethodReferenceExpression setIdentifier(java.lang.Object identifier) { 
		this.identifier = identifier;
		return this;
	}

	public MethodReferenceExpression removeIdentifier() { 
		this.identifier = null;
		return this;
	}

	public java.lang.Object getScope() { 
		return scope;
	}

	public MethodReferenceExpression setScope(java.lang.Object scope) { 
		this.scope = scope;
		return this;
	}

	public MethodReferenceExpression removeScope() { 
		this.scope = null;
		return this;
	}

	@Override
	public java.lang.String toString() { 
		return "MethodReferenceExpression";
	}

	public MethodReferenceExpression() { 
		this.uuid = java.util.UUID.randomUUID();
	}

	public MethodReferenceExpression(java.util.UUID uuid) { 
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() { 
		return this.uuid;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final MethodReferenceExpression other = (MethodReferenceExpression) o;
		return uuid != null ? uuid.equals(other.uuid) : other.uuid == null;
	}

	@Override
	public int hashCode() { 
		int result = uuid != null ? uuid.hashCode() : 0;
		return result;
	}
}