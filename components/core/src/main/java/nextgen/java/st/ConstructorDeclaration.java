package nextgen.java.st;


public class ConstructorDeclaration implements ClassOrInterfaceMember {

	private java.util.List<AnnotationExpression> annotations = new java.util.ArrayList<>();
	private BlockStmt blockStmt;
	private java.util.List<ClassOrInterfaceType> typeParameters = new java.util.ArrayList<>();
	private java.util.List<Parameter> parameters = new java.util.ArrayList<>();
	private java.lang.String name;
	private java.util.List<Modifier> modifiers = new java.util.ArrayList<>();
	private java.util.List<ClassOrInterfaceType> thrownExceptions = new java.util.ArrayList<>();
	private final java.util.UUID uuid;

	public java.util.List<AnnotationExpression> getAnnotations() { 
		return annotations;
	}

	public ConstructorDeclaration addAnnotations(AnnotationExpression annotations) { 
		this.annotations.add(annotations);
		return this;
	}

	public ConstructorDeclaration removeAnnotations(AnnotationExpression annotations) { 
		this.annotations.remove(annotations);
		return this;
	}

	public BlockStmt getBlockStmt() { 
		return blockStmt;
	}

	public ConstructorDeclaration setBlockStmt(BlockStmt blockStmt) { 
		this.blockStmt = blockStmt;
		return this;
	}

	public ConstructorDeclaration removeBlockStmt() { 
		this.blockStmt = null;
		return this;
	}

	public java.util.List<ClassOrInterfaceType> getTypeParameters() { 
		return typeParameters;
	}

	public ConstructorDeclaration addTypeParameters(ClassOrInterfaceType typeParameters) { 
		this.typeParameters.add(typeParameters);
		return this;
	}

	public ConstructorDeclaration removeTypeParameters(ClassOrInterfaceType typeParameters) { 
		this.typeParameters.remove(typeParameters);
		return this;
	}

	public java.util.List<Parameter> getParameters() { 
		return parameters;
	}

	public ConstructorDeclaration addParameters(Parameter parameters) { 
		this.parameters.add(parameters);
		return this;
	}

	public ConstructorDeclaration removeParameters(Parameter parameters) { 
		this.parameters.remove(parameters);
		return this;
	}

	public java.lang.String getName() { 
		return name;
	}

	public ConstructorDeclaration setName(java.lang.String name) { 
		this.name = name;
		return this;
	}

	public ConstructorDeclaration removeName() { 
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

	public ConstructorDeclaration addModifiers(Modifier modifiers) { 
		this.modifiers.add(modifiers);
		return this;
	}

	public ConstructorDeclaration removeModifiers(Modifier modifiers) { 
		this.modifiers.remove(modifiers);
		return this;
	}

	public java.util.List<ClassOrInterfaceType> getThrownExceptions() { 
		return thrownExceptions;
	}

	public ConstructorDeclaration addThrownExceptions(ClassOrInterfaceType thrownExceptions) { 
		this.thrownExceptions.add(thrownExceptions);
		return this;
	}

	public ConstructorDeclaration removeThrownExceptions(ClassOrInterfaceType thrownExceptions) { 
		this.thrownExceptions.remove(thrownExceptions);
		return this;
	}

	public ConstructorDeclaration() { 
		this.uuid = java.util.UUID.randomUUID();
	}

	public ConstructorDeclaration(java.util.UUID uuid) { 
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() { 
		return this.uuid;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final ConstructorDeclaration other = (ConstructorDeclaration) o;
		return uuid != null ? uuid.equals(other.uuid) : other.uuid == null;
	}

	@Override
	public int hashCode() { 
		int result = uuid != null ? uuid.hashCode() : 0;
		return result;
	}
}