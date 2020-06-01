package nextgen.java.st;


public class VariableDeclarationExpression implements Expression, LambdaBody {

	private java.util.List<Modifier> modifiers = new java.util.ArrayList<>();
	private java.util.List<VariableDeclaration> variables = new java.util.ArrayList<>();
	private final java.util.UUID uuid;

	public java.util.List<Modifier> getModifiers() { 
		return modifiers;
	}

	public VariableDeclarationExpression addModifiers(Modifier modifiers) { 
		this.modifiers.add(modifiers);
		return this;
	}

	public VariableDeclarationExpression removeModifiers(Modifier modifiers) { 
		this.modifiers.remove(modifiers);
		return this;
	}

	public java.util.List<VariableDeclaration> getVariables() { 
		return variables;
	}

	public VariableDeclarationExpression addVariables(VariableDeclaration variables) { 
		this.variables.add(variables);
		return this;
	}

	public VariableDeclarationExpression removeVariables(VariableDeclaration variables) { 
		this.variables.remove(variables);
		return this;
	}

	@Override
	public java.lang.String toString() { 
		return "VariableDeclarationExpression";
	}

	public VariableDeclarationExpression() { 
		this.uuid = java.util.UUID.randomUUID();
	}

	public VariableDeclarationExpression(java.util.UUID uuid) { 
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() { 
		return this.uuid;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final VariableDeclarationExpression other = (VariableDeclarationExpression) o;
		return uuid != null ? uuid.equals(other.uuid) : other.uuid == null;
	}

	@Override
	public int hashCode() { 
		int result = uuid != null ? uuid.hashCode() : 0;
		return result;
	}
}