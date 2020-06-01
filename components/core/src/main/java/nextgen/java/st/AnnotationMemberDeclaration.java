package nextgen.java.st;


public class AnnotationMemberDeclaration {

	private ClassOrInterfaceType type;
	private java.lang.String name;
	private java.lang.Object defaultValue;
	private final java.util.UUID uuid;

	public ClassOrInterfaceType getType() { 
		return type;
	}

	public AnnotationMemberDeclaration setType(ClassOrInterfaceType type) { 
		this.type = type;
		return this;
	}

	public AnnotationMemberDeclaration removeType() { 
		this.type = null;
		return this;
	}

	public java.lang.String getName() { 
		return name;
	}

	public AnnotationMemberDeclaration setName(java.lang.String name) { 
		this.name = name;
		return this;
	}

	public AnnotationMemberDeclaration removeName() { 
		this.name = null;
		return this;
	}

	@Override
	public java.lang.String toString() { 
		return name;
	}

	public java.lang.Object getDefaultValue() { 
		return defaultValue;
	}

	public AnnotationMemberDeclaration setDefaultValue(java.lang.Object defaultValue) { 
		this.defaultValue = defaultValue;
		return this;
	}

	public AnnotationMemberDeclaration removeDefaultValue() { 
		this.defaultValue = null;
		return this;
	}

	public AnnotationMemberDeclaration() { 
		this.uuid = java.util.UUID.randomUUID();
	}

	public AnnotationMemberDeclaration(java.util.UUID uuid) { 
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() { 
		return this.uuid;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final AnnotationMemberDeclaration other = (AnnotationMemberDeclaration) o;
		return uuid != null ? uuid.equals(other.uuid) : other.uuid == null;
	}

	@Override
	public int hashCode() { 
		int result = uuid != null ? uuid.hashCode() : 0;
		return result;
	}
}