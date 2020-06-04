package nextgen.java.st;


public class AnnotationDeclaration {

	private java.util.List<java.lang.Object> members = new java.util.ArrayList<>();
	private java.util.List<Modifier> modifiers = new java.util.ArrayList<>();
	private java.util.List<AnnotationExpression> annotations = new java.util.ArrayList<>();
	private java.lang.String name;
	private final java.util.UUID uuid;

	public java.util.List<java.lang.Object> getMembers() { 
		return members;
	}

	public AnnotationDeclaration addMembers(java.lang.Object members) { 
		this.members.add(members);
		return this;
	}

	public AnnotationDeclaration removeMembers(java.lang.Object members) { 
		this.members.remove(members);
		return this;
	}

	public java.util.List<Modifier> getModifiers() { 
		return modifiers;
	}

	public AnnotationDeclaration addModifiers(Modifier modifiers) { 
		this.modifiers.add(modifiers);
		return this;
	}

	public AnnotationDeclaration removeModifiers(Modifier modifiers) { 
		this.modifiers.remove(modifiers);
		return this;
	}

	public java.util.List<AnnotationExpression> getAnnotations() { 
		return annotations;
	}

	public AnnotationDeclaration addAnnotations(AnnotationExpression annotations) { 
		this.annotations.add(annotations);
		return this;
	}

	public AnnotationDeclaration removeAnnotations(AnnotationExpression annotations) { 
		this.annotations.remove(annotations);
		return this;
	}

	public java.lang.String getName() { 
		return name;
	}

	public AnnotationDeclaration setName(java.lang.String name) { 
		this.name = name;
		return this;
	}

	public AnnotationDeclaration removeName() { 
		this.name = null;
		return this;
	}

	@Override
	public java.lang.String toString() { 
		return name;
	}

	public AnnotationDeclaration() { 
		this.uuid = java.util.UUID.randomUUID();
	}

	public AnnotationDeclaration(java.util.UUID uuid) { 
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() { 
		return this.uuid;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final AnnotationDeclaration other = (AnnotationDeclaration) o;
		return uuid != null ? uuid.equals(other.uuid) : other.uuid == null;
	}

	@Override
	public int hashCode() { 
		int result = uuid != null ? uuid.hashCode() : 0;
		return result;
	}
}