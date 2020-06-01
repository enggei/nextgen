package nextgen.java.st;


public class ExplicitConstructorInvocationStmt implements Statement, LambdaBody {

	private java.util.List<java.lang.Object> arguments = new java.util.ArrayList<>();
	private java.lang.Boolean isThis;
	private final java.util.UUID uuid;

	public java.util.List<java.lang.Object> getArguments() { 
		return arguments;
	}

	public ExplicitConstructorInvocationStmt addArguments(java.lang.Object arguments) { 
		this.arguments.add(arguments);
		return this;
	}

	public ExplicitConstructorInvocationStmt removeArguments(java.lang.Object arguments) { 
		this.arguments.remove(arguments);
		return this;
	}

	public java.lang.Boolean isThis() { 
		return isThis;
	}

	public ExplicitConstructorInvocationStmt setIsThis(java.lang.Boolean isThis) { 
		this.isThis = isThis;
		return this;
	}

	public ExplicitConstructorInvocationStmt removeIsThis() { 
		this.isThis = null;
		return this;
	}

	@Override
	public java.lang.String toString() { 
		return "ExplicitConstructorInvocationStmt";
	}

	public ExplicitConstructorInvocationStmt() { 
		this.uuid = java.util.UUID.randomUUID();
	}

	public ExplicitConstructorInvocationStmt(java.util.UUID uuid) { 
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() { 
		return this.uuid;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final ExplicitConstructorInvocationStmt other = (ExplicitConstructorInvocationStmt) o;
		return uuid != null ? uuid.equals(other.uuid) : other.uuid == null;
	}

	@Override
	public int hashCode() { 
		int result = uuid != null ? uuid.hashCode() : 0;
		return result;
	}
}