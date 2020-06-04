package nextgen.java.st;


public class EnumConstant {

	private java.util.List<java.lang.Object> methods = new java.util.ArrayList<>();
	private java.lang.String name;
	private java.util.List<java.lang.Object> arguments = new java.util.ArrayList<>();
	private java.util.List<AnnotationExpression> annotations = new java.util.ArrayList<>();
	private final java.util.UUID uuid;

	public java.util.List<java.lang.Object> getMethods() { 
		return methods;
	}

	public EnumConstant addMethods(java.lang.Object methods) { 
		this.methods.add(methods);
		return this;
	}

	public EnumConstant removeMethods(java.lang.Object methods) { 
		this.methods.remove(methods);
		return this;
	}

	public java.lang.String getName() { 
		return name;
	}

	public EnumConstant setName(java.lang.String name) { 
		this.name = name;
		return this;
	}

	public EnumConstant removeName() { 
		this.name = null;
		return this;
	}

	@Override
	public java.lang.String toString() { 
		return name;
	}

	public java.util.List<java.lang.Object> getArguments() { 
		return arguments;
	}

	public EnumConstant addArguments(java.lang.Object arguments) { 
		this.arguments.add(arguments);
		return this;
	}

	public EnumConstant removeArguments(java.lang.Object arguments) { 
		this.arguments.remove(arguments);
		return this;
	}

	public java.util.List<AnnotationExpression> getAnnotations() { 
		return annotations;
	}

	public EnumConstant addAnnotations(AnnotationExpression annotations) { 
		this.annotations.add(annotations);
		return this;
	}

	public EnumConstant removeAnnotations(AnnotationExpression annotations) { 
		this.annotations.remove(annotations);
		return this;
	}

	public EnumConstant() { 
		this.uuid = java.util.UUID.randomUUID();
	}

	public EnumConstant(java.util.UUID uuid) { 
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() { 
		return this.uuid;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final EnumConstant other = (EnumConstant) o;
		return uuid != null ? uuid.equals(other.uuid) : other.uuid == null;
	}

	@Override
	public int hashCode() { 
		int result = uuid != null ? uuid.hashCode() : 0;
		return result;
	}
}