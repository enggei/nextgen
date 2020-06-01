package nextgen.java.st;


public class IfStmt implements Statement, LambdaBody {

	private java.lang.Object elseStmt;
	private java.lang.Object then;
	private java.lang.Object condition;
	private final java.util.UUID uuid;

	public java.lang.Object getElseStmt() { 
		return elseStmt;
	}

	public IfStmt setElseStmt(java.lang.Object elseStmt) { 
		this.elseStmt = elseStmt;
		return this;
	}

	public IfStmt removeElseStmt() { 
		this.elseStmt = null;
		return this;
	}

	public java.lang.Object getThen() { 
		return then;
	}

	public IfStmt setThen(java.lang.Object then) { 
		this.then = then;
		return this;
	}

	public IfStmt removeThen() { 
		this.then = null;
		return this;
	}

	public java.lang.Object getCondition() { 
		return condition;
	}

	public IfStmt setCondition(java.lang.Object condition) { 
		this.condition = condition;
		return this;
	}

	public IfStmt removeCondition() { 
		this.condition = null;
		return this;
	}

	@Override
	public java.lang.String toString() { 
		return "IfStmt";
	}

	public IfStmt() { 
		this.uuid = java.util.UUID.randomUUID();
	}

	public IfStmt(java.util.UUID uuid) { 
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() { 
		return this.uuid;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final IfStmt other = (IfStmt) o;
		return uuid != null ? uuid.equals(other.uuid) : other.uuid == null;
	}

	@Override
	public int hashCode() { 
		int result = uuid != null ? uuid.hashCode() : 0;
		return result;
	}
}