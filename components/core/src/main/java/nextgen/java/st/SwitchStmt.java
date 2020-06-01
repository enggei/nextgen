package nextgen.java.st;


public class SwitchStmt implements Statement, LambdaBody {

	private java.util.List<java.lang.Object> entries = new java.util.ArrayList<>();
	private java.lang.Object selector;
	private final java.util.UUID uuid;

	public java.util.List<java.lang.Object> getEntries() { 
		return entries;
	}

	public SwitchStmt addEntries(java.lang.Object entries) { 
		this.entries.add(entries);
		return this;
	}

	public SwitchStmt removeEntries(java.lang.Object entries) { 
		this.entries.remove(entries);
		return this;
	}

	public java.lang.Object getSelector() { 
		return selector;
	}

	public SwitchStmt setSelector(java.lang.Object selector) { 
		this.selector = selector;
		return this;
	}

	public SwitchStmt removeSelector() { 
		this.selector = null;
		return this;
	}

	@Override
	public java.lang.String toString() { 
		return "SwitchStmt";
	}

	public SwitchStmt() { 
		this.uuid = java.util.UUID.randomUUID();
	}

	public SwitchStmt(java.util.UUID uuid) { 
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() { 
		return this.uuid;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final SwitchStmt other = (SwitchStmt) o;
		return uuid != null ? uuid.equals(other.uuid) : other.uuid == null;
	}

	@Override
	public int hashCode() { 
		int result = uuid != null ? uuid.hashCode() : 0;
		return result;
	}
}