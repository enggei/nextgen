package nextgen.react.st;


public class If {

	private java.lang.Object blockStmt;
	private java.lang.Object condition;
	private final java.util.UUID uuid;

	public java.lang.Object getBlockStmt() { 
		return blockStmt;
	}

	public If setBlockStmt(java.lang.Object blockStmt) { 
		this.blockStmt = blockStmt;
		return this;
	}

	public If removeBlockStmt() { 
		this.blockStmt = null;
		return this;
	}

	public java.lang.Object getCondition() { 
		return condition;
	}

	public If setCondition(java.lang.Object condition) { 
		this.condition = condition;
		return this;
	}

	public If removeCondition() { 
		this.condition = null;
		return this;
	}

	@Override
	public java.lang.String toString() { 
		return "If";
	}

	public If() { 
		this.uuid = java.util.UUID.randomUUID();
	}

	public If(java.util.UUID uuid) { 
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() { 
		return this.uuid;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final If other = (If) o;
		return uuid != null ? uuid.equals(other.uuid) : other.uuid == null;
	}

	@Override
	public int hashCode() { 
		int result = uuid != null ? uuid.hashCode() : 0;
		return result;
	}
}