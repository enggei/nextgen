package nextgen.java.st;


public class FieldDeclaration {

	private java.util.List<VariableDeclaration> variables = new java.util.ArrayList<>();
	private java.util.List<Modifier> modifiers = new java.util.ArrayList<>();
	private java.util.List<AnnotationExpression> annotations = new java.util.ArrayList<>();
	private final java.util.UUID uuid;

	public java.util.List<VariableDeclaration> getVariables() { 
		return variables;
	}

	public FieldDeclaration addVariables(VariableDeclaration variables) { 
		this.variables.add(variables);
		return this;
	}

	public FieldDeclaration removeVariables(VariableDeclaration variables) { 
		this.variables.remove(variables);
		return this;
	}

	public java.util.List<Modifier> getModifiers() { 
		return modifiers;
	}

	public FieldDeclaration addModifiers(Modifier modifiers) { 
		this.modifiers.add(modifiers);
		return this;
	}

	public FieldDeclaration removeModifiers(Modifier modifiers) { 
		this.modifiers.remove(modifiers);
		return this;
	}

	public java.util.List<AnnotationExpression> getAnnotations() { 
		return annotations;
	}

	public FieldDeclaration addAnnotations(AnnotationExpression annotations) { 
		this.annotations.add(annotations);
		return this;
	}

	public FieldDeclaration removeAnnotations(AnnotationExpression annotations) { 
		this.annotations.remove(annotations);
		return this;
	}

	@Override
	public java.lang.String toString() { 
		return "FieldDeclaration";
	}

	public FieldDeclaration() { 
		this.uuid = java.util.UUID.randomUUID();
	}

	public FieldDeclaration(java.util.UUID uuid) { 
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() { 
		return this.uuid;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final FieldDeclaration other = (FieldDeclaration) o;
		return uuid != null ? uuid.equals(other.uuid) : other.uuid == null;
	}

	@Override
	public int hashCode() { 
		int result = uuid != null ? uuid.hashCode() : 0;
		return result;
	}
}