package nextgen.java.st;


public class ClassOrInterfaceType {

	private java.util.List<java.lang.String> names = new java.util.ArrayList<>();
	private java.lang.Object scope;
	private java.util.List<ClassOrInterfaceType> typeArguments = new java.util.ArrayList<>();
	private java.lang.Boolean isTyped;
	private java.lang.Boolean isArrayType;
	private final java.util.UUID uuid;
	java.lang.Boolean isCollection = false;
	java.lang.Boolean isPrimitive = false;
	java.lang.Boolean isEnum = false;
	java.lang.Boolean isInterface = false;

	public java.util.List<java.lang.String> getNames() { 
		return names;
	}

	public ClassOrInterfaceType addNames(java.lang.String names) { 
		this.names.add(names);
		return this;
	}

	public ClassOrInterfaceType removeNames(java.lang.String names) { 
		this.names.remove(names);
		return this;
	}

	public java.lang.Object getScope() { 
		return scope;
	}

	public ClassOrInterfaceType setScope(java.lang.Object scope) { 
		this.scope = scope;
		return this;
	}

	public ClassOrInterfaceType removeScope() { 
		this.scope = null;
		return this;
	}

	public java.util.List<ClassOrInterfaceType> getTypeArguments() { 
		return typeArguments;
	}

	public ClassOrInterfaceType addTypeArguments(ClassOrInterfaceType typeArguments) { 
		this.typeArguments.add(typeArguments);
		return this;
	}

	public ClassOrInterfaceType removeTypeArguments(ClassOrInterfaceType typeArguments) { 
		this.typeArguments.remove(typeArguments);
		return this;
	}

	public java.lang.Boolean isTyped() { 
		return isTyped;
	}

	public ClassOrInterfaceType setIsTyped(java.lang.Boolean isTyped) { 
		this.isTyped = isTyped;
		return this;
	}

	public ClassOrInterfaceType removeIsTyped() { 
		this.isTyped = null;
		return this;
	}

	public java.lang.Boolean isArrayType() { 
		return isArrayType;
	}

	public ClassOrInterfaceType setIsArrayType(java.lang.Boolean isArrayType) { 
		this.isArrayType = isArrayType;
		return this;
	}

	public ClassOrInterfaceType removeIsArrayType() { 
		this.isArrayType = null;
		return this;
	}

	@Override
	public java.lang.String toString() { 
		return "ClassOrInterfaceType";
	}

	public ClassOrInterfaceType() { 
		this.uuid = java.util.UUID.randomUUID();
	}

	public ClassOrInterfaceType(java.util.UUID uuid) { 
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() { 
		return this.uuid;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final ClassOrInterfaceType other = (ClassOrInterfaceType) o;
		return uuid != null ? uuid.equals(other.uuid) : other.uuid == null;
	}

	@Override
	public int hashCode() { 
		int result = uuid != null ? uuid.hashCode() : 0;
		return result;
	}

	public java.lang.Boolean isCollection() { 
		return isCollection;
	}

	public ClassOrInterfaceType setIsCollection(java.lang.Boolean isCollection) { 
		this.isCollection = isCollection;
		return this;
	}

	public java.lang.Boolean isPrimitive() { 
		return isPrimitive;
	}

	public ClassOrInterfaceType setIsPrimitive(java.lang.Boolean isPrimitive) { 
		this.isPrimitive = isPrimitive;
		return this;
	}

	public java.lang.Boolean isEnum() { 
		return isEnum;
	}

	public ClassOrInterfaceType setIsEnum(java.lang.Boolean isEnum) { 
		this.isEnum = isEnum;
		return this;
	}

	public java.lang.Boolean isInterface() { 
		return isInterface;
	}

	public ClassOrInterfaceType setIsInterface(java.lang.Boolean isInterface) { 
		this.isInterface = isInterface;
		return this;
	}
}