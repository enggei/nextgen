package nextgen.java.st;


public class MethodCallExpression implements Expression, LambdaBody {

	private java.lang.String name;
	private java.lang.Object scope;
	private java.util.List<java.lang.Object> arguments = new java.util.ArrayList<>();
	private java.util.List<ClassOrInterfaceType> typeArguments = new java.util.ArrayList<>();
	private final java.util.UUID uuid;

	public java.lang.String getName() { 
		return name;
	}

	public MethodCallExpression setName(java.lang.String name) { 
		this.name = name;
		return this;
	}

	public MethodCallExpression removeName() { 
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

	public MethodCallExpression setScope(java.lang.Object scope) { 
		this.scope = scope;
		return this;
	}

	public MethodCallExpression removeScope() { 
		this.scope = null;
		return this;
	}

	public java.util.List<java.lang.Object> getArguments() { 
		return arguments;
	}

	public MethodCallExpression addArguments(java.lang.Object arguments) { 
		this.arguments.add(arguments);
		return this;
	}

	public MethodCallExpression removeArguments(java.lang.Object arguments) { 
		this.arguments.remove(arguments);
		return this;
	}

	public java.util.List<ClassOrInterfaceType> getTypeArguments() { 
		return typeArguments;
	}

	public MethodCallExpression addTypeArguments(ClassOrInterfaceType typeArguments) { 
		this.typeArguments.add(typeArguments);
		return this;
	}

	public MethodCallExpression removeTypeArguments(ClassOrInterfaceType typeArguments) { 
		this.typeArguments.remove(typeArguments);
		return this;
	}

	public MethodCallExpression() { 
		this.uuid = java.util.UUID.randomUUID();
	}

	public MethodCallExpression(java.util.UUID uuid) { 
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() { 
		return this.uuid;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final MethodCallExpression other = (MethodCallExpression) o;
		return uuid != null ? uuid.equals(other.uuid) : other.uuid == null;
	}

	@Override
	public int hashCode() { 
		int result = uuid != null ? uuid.hashCode() : 0;
		return result;
	}
}