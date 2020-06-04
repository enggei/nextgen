package nextgen.java.st;


public class ClassOrInterfaceDeclaration implements CompilationUnitMember, ClassOrInterfaceMember {

	private java.util.List<ClassOrInterfaceType> implementedTypes = new java.util.ArrayList<>();
	private java.util.List<java.lang.String> comments = new java.util.ArrayList<>();
	private java.util.List<ClassOrInterfaceType> typeParameters = new java.util.ArrayList<>();
	private java.lang.String name;
	private java.util.List<ClassOrInterfaceType> extend = new java.util.ArrayList<>();
	private java.util.List<java.lang.Object> fields = new java.util.ArrayList<>();
	private java.util.List<AnnotationExpression> annotations = new java.util.ArrayList<>();
	private java.util.List<ClassOrInterfaceMember> members = new java.util.ArrayList<>();
	private java.util.List<Modifier> modifiers = new java.util.ArrayList<>();
	private java.lang.Boolean isInterface;
	private final java.util.UUID uuid;

	public java.util.List<ClassOrInterfaceType> getImplementedTypes() { 
		return implementedTypes;
	}

	public ClassOrInterfaceDeclaration addImplementedTypes(ClassOrInterfaceType implementedTypes) { 
		this.implementedTypes.add(implementedTypes);
		return this;
	}

	public ClassOrInterfaceDeclaration removeImplementedTypes(ClassOrInterfaceType implementedTypes) { 
		this.implementedTypes.remove(implementedTypes);
		return this;
	}

	public java.util.List<java.lang.String> getComments() { 
		return comments;
	}

	public ClassOrInterfaceDeclaration addComments(java.lang.String comments) { 
		this.comments.add(comments);
		return this;
	}

	public ClassOrInterfaceDeclaration removeComments(java.lang.String comments) { 
		this.comments.remove(comments);
		return this;
	}

	public java.util.List<ClassOrInterfaceType> getTypeParameters() { 
		return typeParameters;
	}

	public ClassOrInterfaceDeclaration addTypeParameters(ClassOrInterfaceType typeParameters) { 
		this.typeParameters.add(typeParameters);
		return this;
	}

	public ClassOrInterfaceDeclaration removeTypeParameters(ClassOrInterfaceType typeParameters) { 
		this.typeParameters.remove(typeParameters);
		return this;
	}

	public java.lang.String getName() { 
		return name;
	}

	public ClassOrInterfaceDeclaration setName(java.lang.String name) { 
		this.name = name;
		return this;
	}

	public ClassOrInterfaceDeclaration removeName() { 
		this.name = null;
		return this;
	}

	@Override
	public java.lang.String toString() { 
		return name;
	}

	public java.util.List<ClassOrInterfaceType> getExtend() { 
		return extend;
	}

	public ClassOrInterfaceDeclaration addExtend(ClassOrInterfaceType extend) { 
		this.extend.add(extend);
		return this;
	}

	public ClassOrInterfaceDeclaration removeExtend(ClassOrInterfaceType extend) { 
		this.extend.remove(extend);
		return this;
	}

	public java.util.List<java.lang.Object> getFields() { 
		return fields;
	}

	public ClassOrInterfaceDeclaration addFields(java.lang.Object fields) { 
		this.fields.add(fields);
		return this;
	}

	public ClassOrInterfaceDeclaration removeFields(java.lang.Object fields) { 
		this.fields.remove(fields);
		return this;
	}

	public java.util.List<AnnotationExpression> getAnnotations() { 
		return annotations;
	}

	public ClassOrInterfaceDeclaration addAnnotations(AnnotationExpression annotations) { 
		this.annotations.add(annotations);
		return this;
	}

	public ClassOrInterfaceDeclaration removeAnnotations(AnnotationExpression annotations) { 
		this.annotations.remove(annotations);
		return this;
	}

	public java.util.List<ClassOrInterfaceMember> getMembers() { 
		return members;
	}

	public ClassOrInterfaceDeclaration addMembers(ClassOrInterfaceMember members) { 
		this.members.add(members);
		return this;
	}

	public ClassOrInterfaceDeclaration removeMembers(ClassOrInterfaceMember members) { 
		this.members.remove(members);
		return this;
	}

	public java.util.List<Modifier> getModifiers() { 
		return modifiers;
	}

	public ClassOrInterfaceDeclaration addModifiers(Modifier modifiers) { 
		this.modifiers.add(modifiers);
		return this;
	}

	public ClassOrInterfaceDeclaration removeModifiers(Modifier modifiers) { 
		this.modifiers.remove(modifiers);
		return this;
	}

	public java.lang.Boolean isInterface() { 
		return isInterface;
	}

	public ClassOrInterfaceDeclaration setIsInterface(java.lang.Boolean isInterface) { 
		this.isInterface = isInterface;
		return this;
	}

	public ClassOrInterfaceDeclaration removeIsInterface() { 
		this.isInterface = null;
		return this;
	}

	public ClassOrInterfaceDeclaration() { 
		this.uuid = java.util.UUID.randomUUID();
	}

	public ClassOrInterfaceDeclaration(java.util.UUID uuid) { 
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() { 
		return this.uuid;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final ClassOrInterfaceDeclaration other = (ClassOrInterfaceDeclaration) o;
		return uuid != null ? uuid.equals(other.uuid) : other.uuid == null;
	}

	@Override
	public int hashCode() { 
		int result = uuid != null ? uuid.hashCode() : 0;
		return result;
	}
}