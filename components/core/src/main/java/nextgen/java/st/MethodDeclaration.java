package nextgen.java.st;


public class MethodDeclaration implements ClassOrInterfaceMember {

	private java.util.List<AnnotationExpression> annotations = new java.util.ArrayList<>();
	private ClassOrInterfaceType type;
	private java.util.List<Modifier> modifiers = new java.util.ArrayList<>();
	private java.util.List<ClassOrInterfaceType> typeParameters = new java.util.ArrayList<>();
	private java.util.List<Parameter> parameters = new java.util.ArrayList<>();
	private java.util.List<ClassOrInterfaceType> thrownExceptions = new java.util.ArrayList<>();
	private java.lang.String name;
	private BlockStmt blockStmt;
	private java.lang.Boolean isInterfaceDeclaration;
	private final java.util.UUID uuid;
	java.lang.Boolean isGetter = false;
	java.lang.Boolean isSetter = false;

	public java.util.List<AnnotationExpression> getAnnotations() { 
		return annotations;
	}

	public MethodDeclaration addAnnotations(AnnotationExpression annotations) { 
		this.annotations.add(annotations);
		return this;
	}

	public MethodDeclaration removeAnnotations(AnnotationExpression annotations) { 
		this.annotations.remove(annotations);
		return this;
	}

	public ClassOrInterfaceType getType() { 
		return type;
	}

	public MethodDeclaration setType(ClassOrInterfaceType type) { 
		this.type = type;
		return this;
	}

	public MethodDeclaration removeType() { 
		this.type = null;
		return this;
	}

	public java.util.List<Modifier> getModifiers() { 
		return modifiers;
	}

	public MethodDeclaration addModifiers(Modifier modifiers) { 
		this.modifiers.add(modifiers);
		return this;
	}

	public MethodDeclaration removeModifiers(Modifier modifiers) { 
		this.modifiers.remove(modifiers);
		return this;
	}

	public java.util.List<ClassOrInterfaceType> getTypeParameters() { 
		return typeParameters;
	}

	public MethodDeclaration addTypeParameters(ClassOrInterfaceType typeParameters) { 
		this.typeParameters.add(typeParameters);
		return this;
	}

	public MethodDeclaration removeTypeParameters(ClassOrInterfaceType typeParameters) { 
		this.typeParameters.remove(typeParameters);
		return this;
	}

	public java.util.List<Parameter> getParameters() { 
		return parameters;
	}

	public MethodDeclaration addParameters(Parameter parameters) { 
		this.parameters.add(parameters);
		return this;
	}

	public MethodDeclaration removeParameters(Parameter parameters) { 
		this.parameters.remove(parameters);
		return this;
	}

	public java.util.List<ClassOrInterfaceType> getThrownExceptions() { 
		return thrownExceptions;
	}

	public MethodDeclaration addThrownExceptions(ClassOrInterfaceType thrownExceptions) { 
		this.thrownExceptions.add(thrownExceptions);
		return this;
	}

	public MethodDeclaration removeThrownExceptions(ClassOrInterfaceType thrownExceptions) { 
		this.thrownExceptions.remove(thrownExceptions);
		return this;
	}

	public java.lang.String getName() { 
		return name;
	}

	public MethodDeclaration setName(java.lang.String name) { 
		this.name = name;
		return this;
	}

	public MethodDeclaration removeName() { 
		this.name = null;
		return this;
	}

	@Override
	public java.lang.String toString() { 
		return name;
	}

	public BlockStmt getBlockStmt() { 
		return blockStmt;
	}

	public MethodDeclaration setBlockStmt(BlockStmt blockStmt) { 
		this.blockStmt = blockStmt;
		return this;
	}

	public MethodDeclaration removeBlockStmt() { 
		this.blockStmt = null;
		return this;
	}

	public java.lang.Boolean isInterfaceDeclaration() { 
		return isInterfaceDeclaration;
	}

	public MethodDeclaration setIsInterfaceDeclaration(java.lang.Boolean isInterfaceDeclaration) { 
		this.isInterfaceDeclaration = isInterfaceDeclaration;
		return this;
	}

	public MethodDeclaration removeIsInterfaceDeclaration() { 
		this.isInterfaceDeclaration = null;
		return this;
	}

	public MethodDeclaration() { 
		this.uuid = java.util.UUID.randomUUID();
	}

	public MethodDeclaration(java.util.UUID uuid) { 
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() { 
		return this.uuid;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final MethodDeclaration other = (MethodDeclaration) o;
		return uuid != null ? uuid.equals(other.uuid) : other.uuid == null;
	}

	@Override
	public int hashCode() { 
		int result = uuid != null ? uuid.hashCode() : 0;
		return result;
	}

	public java.lang.Boolean isGetter() { 
		return isGetter;
	}

	public MethodDeclaration setIsGetter(java.lang.Boolean isGetter) { 
		this.isGetter = isGetter;
		return this;
	}

	public java.lang.Boolean isSetter() { 
		return isSetter;
	}

	public MethodDeclaration setIsSetter(java.lang.Boolean isSetter) { 
		this.isSetter = isSetter;
		return this;
	}
}