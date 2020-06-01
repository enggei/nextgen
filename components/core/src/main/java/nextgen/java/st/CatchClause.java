package nextgen.java.st;


public class CatchClause {

	private Statement body;
	private Parameter parameter;
	private final java.util.UUID uuid;

	public Statement getBody() { 
		return body;
	}

	public CatchClause setBody(Statement body) { 
		this.body = body;
		return this;
	}

	public CatchClause removeBody() { 
		this.body = null;
		return this;
	}

	public Parameter getParameter() { 
		return parameter;
	}

	public CatchClause setParameter(Parameter parameter) { 
		this.parameter = parameter;
		return this;
	}

	public CatchClause removeParameter() { 
		this.parameter = null;
		return this;
	}

	@Override
	public java.lang.String toString() { 
		return "CatchClause";
	}

	public CatchClause() { 
		this.uuid = java.util.UUID.randomUUID();
	}

	public CatchClause(java.util.UUID uuid) { 
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() { 
		return this.uuid;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final CatchClause other = (CatchClause) o;
		return uuid != null ? uuid.equals(other.uuid) : other.uuid == null;
	}

	@Override
	public int hashCode() { 
		int result = uuid != null ? uuid.hashCode() : 0;
		return result;
	}
}