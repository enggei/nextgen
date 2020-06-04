package nextgen.java.st;


public class ObjectCreationExpression implements Expression, LambdaBody {

	private java.util.List<java.lang.Object> anonymousClassBodies = new java.util.ArrayList<>();
	private java.util.List<ClassOrInterfaceType> typeArguments = new java.util.ArrayList<>();
	private java.util.List<java.lang.Object> arguments = new java.util.ArrayList<>();
	private ClassOrInterfaceType type;
	private java.lang.Object scope;
	private final java.util.UUID uuid;

	public java.util.List<java.lang.Object> getAnonymousClassBodies() { 
		return anonymousClassBodies;
	}

	public ObjectCreationExpression addAnonymousClassBodies(java.lang.Object anonymousClassBodies) { 
		this.anonymousClassBodies.add(anonymousClassBodies);
		return this;
	}

	public ObjectCreationExpression removeAnonymousClassBodies(java.lang.Object anonymousClassBodies) { 
		this.anonymousClassBodies.remove(anonymousClassBodies);
		return this;
	}

	public java.util.List<ClassOrInterfaceType> getTypeArguments() { 
		return typeArguments;
	}

	public ObjectCreationExpression addTypeArguments(ClassOrInterfaceType typeArguments) { 
		this.typeArguments.add(typeArguments);
		return this;
	}

	public ObjectCreationExpression removeTypeArguments(ClassOrInterfaceType typeArguments) { 
		this.typeArguments.remove(typeArguments);
		return this;
	}

	public java.util.List<java.lang.Object> getArguments() { 
		return arguments;
	}

	public ObjectCreationExpression addArguments(java.lang.Object arguments) { 
		this.arguments.add(arguments);
		return this;
	}

	public ObjectCreationExpression removeArguments(java.lang.Object arguments) { 
		this.arguments.remove(arguments);
		return this;
	}

	public ClassOrInterfaceType getType() { 
		return type;
	}

	public ObjectCreationExpression setType(ClassOrInterfaceType type) { 
		this.type = type;
		return this;
	}

	public ObjectCreationExpression removeType() { 
		this.type = null;
		return this;
	}

	public java.lang.Object getScope() { 
		return scope;
	}

	public ObjectCreationExpression setScope(java.lang.Object scope) { 
		this.scope = scope;
		return this;
	}

	public ObjectCreationExpression removeScope() { 
		this.scope = null;
		return this;
	}

	@Override
	public java.lang.String toString() { 
		return "ObjectCreationExpression";
	}

	public ObjectCreationExpression() { 
		this.uuid = java.util.UUID.randomUUID();
	}

	public ObjectCreationExpression(java.util.UUID uuid) { 
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() { 
		return this.uuid;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final ObjectCreationExpression other = (ObjectCreationExpression) o;
		return uuid != null ? uuid.equals(other.uuid) : other.uuid == null;
	}

	@Override
	public int hashCode() { 
		int result = uuid != null ? uuid.hashCode() : 0;
		return result;
	}
}