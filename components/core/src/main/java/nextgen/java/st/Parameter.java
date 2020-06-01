package nextgen.java.st;


public class Parameter {

	private java.util.List<AnnotationExpression> annotations = new java.util.ArrayList<>();
	private java.lang.String name;
	private java.util.List<Modifier> modifiers = new java.util.ArrayList<>();
	private ClassOrInterfaceType type;
	private java.lang.Boolean isVarargs;
	private final java.util.UUID uuid;

	public java.util.List<AnnotationExpression> getAnnotations() { 
		return annotations;
	}

	public Parameter addAnnotations(AnnotationExpression annotations) { 
		this.annotations.add(annotations);
		return this;
	}

	public Parameter removeAnnotations(AnnotationExpression annotations) { 
		this.annotations.remove(annotations);
		return this;
	}

	public java.lang.String getName() { 
		return name;
	}

	public Parameter setName(java.lang.String name) { 
		this.name = name;
		return this;
	}

	public Parameter removeName() { 
		this.name = null;
		return this;
	}

	@Override
	public java.lang.String toString() { 
		return name;
	}

	public java.util.List<Modifier> getModifiers() { 
		return modifiers;
	}

	public Parameter addModifiers(Modifier modifiers) { 
		this.modifiers.add(modifiers);
		return this;
	}

	public Parameter removeModifiers(Modifier modifiers) { 
		this.modifiers.remove(modifiers);
		return this;
	}

	public ClassOrInterfaceType getType() { 
		return type;
	}

	public Parameter setType(ClassOrInterfaceType type) { 
		this.type = type;
		return this;
	}

	public Parameter removeType() { 
		this.type = null;
		return this;
	}

	public java.lang.Boolean isVarargs() { 
		return isVarargs;
	}

	public Parameter setIsVarargs(java.lang.Boolean isVarargs) { 
		this.isVarargs = isVarargs;
		return this;
	}

	public Parameter removeIsVarargs() { 
		this.isVarargs = null;
		return this;
	}

	public Parameter() { 
		this.uuid = java.util.UUID.randomUUID();
	}

	public Parameter(java.util.UUID uuid) { 
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() { 
		return this.uuid;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final Parameter other = (Parameter) o;
		return uuid != null ? uuid.equals(other.uuid) : other.uuid == null;
	}

	@Override
	public int hashCode() { 
		int result = uuid != null ? uuid.hashCode() : 0;
		return result;
	}
}