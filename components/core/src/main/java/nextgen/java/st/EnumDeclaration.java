package nextgen.java.st;


public class EnumDeclaration implements CompilationUnitMember, ClassOrInterfaceMember {

	private java.util.List<ClassOrInterfaceType> extend = new java.util.ArrayList<>();
	private java.util.List<AnnotationExpression> annotations = new java.util.ArrayList<>();
	private java.util.List<Modifier> modifiers = new java.util.ArrayList<>();
	private java.util.List<ClassOrInterfaceType> implementedTypes = new java.util.ArrayList<>();
	private java.lang.String name;
	private java.util.List<java.lang.Object> members = new java.util.ArrayList<>();
	private java.util.List<java.lang.Object> entries = new java.util.ArrayList<>();
	private final java.util.UUID uuid;

	public java.util.List<ClassOrInterfaceType> getExtend() { 
		return extend;
	}

	public EnumDeclaration addExtend(ClassOrInterfaceType extend) { 
		this.extend.add(extend);
		return this;
	}

	public EnumDeclaration removeExtend(ClassOrInterfaceType extend) { 
		this.extend.remove(extend);
		return this;
	}

	public java.util.List<AnnotationExpression> getAnnotations() { 
		return annotations;
	}

	public EnumDeclaration addAnnotations(AnnotationExpression annotations) { 
		this.annotations.add(annotations);
		return this;
	}

	public EnumDeclaration removeAnnotations(AnnotationExpression annotations) { 
		this.annotations.remove(annotations);
		return this;
	}

	public java.util.List<Modifier> getModifiers() { 
		return modifiers;
	}

	public EnumDeclaration addModifiers(Modifier modifiers) { 
		this.modifiers.add(modifiers);
		return this;
	}

	public EnumDeclaration removeModifiers(Modifier modifiers) { 
		this.modifiers.remove(modifiers);
		return this;
	}

	public java.util.List<ClassOrInterfaceType> getImplementedTypes() { 
		return implementedTypes;
	}

	public EnumDeclaration addImplementedTypes(ClassOrInterfaceType implementedTypes) { 
		this.implementedTypes.add(implementedTypes);
		return this;
	}

	public EnumDeclaration removeImplementedTypes(ClassOrInterfaceType implementedTypes) { 
		this.implementedTypes.remove(implementedTypes);
		return this;
	}

	public java.lang.String getName() { 
		return name;
	}

	public EnumDeclaration setName(java.lang.String name) { 
		this.name = name;
		return this;
	}

	public EnumDeclaration removeName() { 
		this.name = null;
		return this;
	}

	@Override
	public java.lang.String toString() { 
		return name;
	}

	public java.util.List<java.lang.Object> getMembers() { 
		return members;
	}

	public EnumDeclaration addMembers(java.lang.Object members) { 
		this.members.add(members);
		return this;
	}

	public EnumDeclaration removeMembers(java.lang.Object members) { 
		this.members.remove(members);
		return this;
	}

	public java.util.List<java.lang.Object> getEntries() { 
		return entries;
	}

	public EnumDeclaration addEntries(java.lang.Object entries) { 
		this.entries.add(entries);
		return this;
	}

	public EnumDeclaration removeEntries(java.lang.Object entries) { 
		this.entries.remove(entries);
		return this;
	}

	public EnumDeclaration() { 
		this.uuid = java.util.UUID.randomUUID();
	}

	public EnumDeclaration(java.util.UUID uuid) { 
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() { 
		return this.uuid;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final EnumDeclaration other = (EnumDeclaration) o;
		return uuid != null ? uuid.equals(other.uuid) : other.uuid == null;
	}

	@Override
	public int hashCode() { 
		int result = uuid != null ? uuid.hashCode() : 0;
		return result;
	}
}