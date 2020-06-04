package nextgen.java.st;


public class TryStmt implements Statement, LambdaBody {

	private java.util.List<java.lang.Object> resources = new java.util.ArrayList<>();
	private java.lang.Object finalClause;
	private java.lang.Object tryBlock;
	private java.util.List<java.lang.Object> catchClauses = new java.util.ArrayList<>();
	private final java.util.UUID uuid;

	public java.util.List<java.lang.Object> getResources() { 
		return resources;
	}

	public TryStmt addResources(java.lang.Object resources) { 
		this.resources.add(resources);
		return this;
	}

	public TryStmt removeResources(java.lang.Object resources) { 
		this.resources.remove(resources);
		return this;
	}

	public java.lang.Object getFinalClause() { 
		return finalClause;
	}

	public TryStmt setFinalClause(java.lang.Object finalClause) { 
		this.finalClause = finalClause;
		return this;
	}

	public TryStmt removeFinalClause() { 
		this.finalClause = null;
		return this;
	}

	public java.lang.Object getTryBlock() { 
		return tryBlock;
	}

	public TryStmt setTryBlock(java.lang.Object tryBlock) { 
		this.tryBlock = tryBlock;
		return this;
	}

	public TryStmt removeTryBlock() { 
		this.tryBlock = null;
		return this;
	}

	public java.util.List<java.lang.Object> getCatchClauses() { 
		return catchClauses;
	}

	public TryStmt addCatchClauses(java.lang.Object catchClauses) { 
		this.catchClauses.add(catchClauses);
		return this;
	}

	public TryStmt removeCatchClauses(java.lang.Object catchClauses) { 
		this.catchClauses.remove(catchClauses);
		return this;
	}

	@Override
	public java.lang.String toString() { 
		return "TryStmt";
	}

	public TryStmt() { 
		this.uuid = java.util.UUID.randomUUID();
	}

	public TryStmt(java.util.UUID uuid) { 
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() { 
		return this.uuid;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final TryStmt other = (TryStmt) o;
		return uuid != null ? uuid.equals(other.uuid) : other.uuid == null;
	}

	@Override
	public int hashCode() { 
		int result = uuid != null ? uuid.hashCode() : 0;
		return result;
	}
}