package nextgen.react.st;


public class BlockStmt {

	private java.util.List<java.lang.Object> children = new java.util.ArrayList<>();
	private java.lang.Object stmt;
	private final java.util.UUID uuid;

	public java.util.List<java.lang.Object> getChildren() { 
		return children;
	}

	public BlockStmt addChildren(java.lang.Object children) { 
		this.children.add(children);
		return this;
	}

	public BlockStmt removeChildren(java.lang.Object children) { 
		this.children.remove(children);
		return this;
	}

	public java.lang.Object getStmt() { 
		return stmt;
	}

	public BlockStmt setStmt(java.lang.Object stmt) { 
		this.stmt = stmt;
		return this;
	}

	public BlockStmt removeStmt() { 
		this.stmt = null;
		return this;
	}

	@Override
	public java.lang.String toString() { 
		return "BlockStmt";
	}

	public BlockStmt() { 
		this.uuid = java.util.UUID.randomUUID();
	}

	public BlockStmt(java.util.UUID uuid) { 
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() { 
		return this.uuid;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final BlockStmt other = (BlockStmt) o;
		return uuid != null ? uuid.equals(other.uuid) : other.uuid == null;
	}

	@Override
	public int hashCode() { 
		int result = uuid != null ? uuid.hashCode() : 0;
		return result;
	}
}