package nextgen.java.st;


public class ForStmt implements Statement, LambdaBody {

	private java.lang.Object compare;
	private java.util.List<java.lang.Object> update = new java.util.ArrayList<>();
	private java.util.List<java.lang.Object> initialization = new java.util.ArrayList<>();
	private Statement body;
	private final java.util.UUID uuid;

	public java.lang.Object getCompare() { 
		return compare;
	}

	public ForStmt setCompare(java.lang.Object compare) { 
		this.compare = compare;
		return this;
	}

	public ForStmt removeCompare() { 
		this.compare = null;
		return this;
	}

	public java.util.List<java.lang.Object> getUpdate() { 
		return update;
	}

	public ForStmt addUpdate(java.lang.Object update) { 
		this.update.add(update);
		return this;
	}

	public ForStmt removeUpdate(java.lang.Object update) { 
		this.update.remove(update);
		return this;
	}

	public java.util.List<java.lang.Object> getInitialization() { 
		return initialization;
	}

	public ForStmt addInitialization(java.lang.Object initialization) { 
		this.initialization.add(initialization);
		return this;
	}

	public ForStmt removeInitialization(java.lang.Object initialization) { 
		this.initialization.remove(initialization);
		return this;
	}

	public Statement getBody() { 
		return body;
	}

	public ForStmt setBody(Statement body) { 
		this.body = body;
		return this;
	}

	public ForStmt removeBody() { 
		this.body = null;
		return this;
	}

	@Override
	public java.lang.String toString() { 
		return "ForStmt";
	}

	public ForStmt() { 
		this.uuid = java.util.UUID.randomUUID();
	}

	public ForStmt(java.util.UUID uuid) { 
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() { 
		return this.uuid;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final ForStmt other = (ForStmt) o;
		return uuid != null ? uuid.equals(other.uuid) : other.uuid == null;
	}

	@Override
	public int hashCode() { 
		int result = uuid != null ? uuid.hashCode() : 0;
		return result;
	}
}