package nextgen.react.st;


public class MethodDeclaration {

	private java.lang.Object name;
	private java.lang.Object parameter;
	private java.util.List<java.lang.Object> statements = new java.util.ArrayList<>();
	private final java.util.UUID uuid;

	public java.lang.Object getName() { 
		return name;
	}

	public MethodDeclaration setName(java.lang.Object name) { 
		this.name = name;
		return this;
	}

	public MethodDeclaration removeName() { 
		this.name = null;
		return this;
	}

	public java.lang.Object getParameter() { 
		return parameter;
	}

	public MethodDeclaration setParameter(java.lang.Object parameter) { 
		this.parameter = parameter;
		return this;
	}

	public MethodDeclaration removeParameter() { 
		this.parameter = null;
		return this;
	}

	public java.util.List<java.lang.Object> getStatements() { 
		return statements;
	}

	public MethodDeclaration addStatements(java.lang.Object statements) { 
		this.statements.add(statements);
		return this;
	}

	public MethodDeclaration removeStatements(java.lang.Object statements) { 
		this.statements.remove(statements);
		return this;
	}

	@Override
	public java.lang.String toString() { 
		return "MethodDeclaration";
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
}