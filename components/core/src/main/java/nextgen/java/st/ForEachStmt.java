package nextgen.java.st;


public class ForEachStmt implements Statement, LambdaBody {

	private java.lang.Object iterable;
	private java.lang.Object variable;
	private Statement body;
	private final java.util.UUID uuid;

	public java.lang.Object getIterable() { 
		return iterable;
	}

	public ForEachStmt setIterable(java.lang.Object iterable) { 
		this.iterable = iterable;
		return this;
	}

	public ForEachStmt removeIterable() { 
		this.iterable = null;
		return this;
	}

	public java.lang.Object getVariable() { 
		return variable;
	}

	public ForEachStmt setVariable(java.lang.Object variable) { 
		this.variable = variable;
		return this;
	}

	public ForEachStmt removeVariable() { 
		this.variable = null;
		return this;
	}

	public Statement getBody() { 
		return body;
	}

	public ForEachStmt setBody(Statement body) { 
		this.body = body;
		return this;
	}

	public ForEachStmt removeBody() { 
		this.body = null;
		return this;
	}

	@Override
	public java.lang.String toString() { 
		return "ForEachStmt";
	}

	public ForEachStmt() { 
		this.uuid = java.util.UUID.randomUUID();
	}

	public ForEachStmt(java.util.UUID uuid) { 
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() { 
		return this.uuid;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final ForEachStmt other = (ForEachStmt) o;
		return uuid != null ? uuid.equals(other.uuid) : other.uuid == null;
	}

	@Override
	public int hashCode() { 
		int result = uuid != null ? uuid.hashCode() : 0;
		return result;
	}
}