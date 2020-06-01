package nextgen.react.st;


public class returnStatement {

	private java.lang.Object element;
	private java.lang.Object condition;
	private final java.util.UUID uuid;

	public java.lang.Object getElement() { 
		return element;
	}

	public returnStatement setElement(java.lang.Object element) { 
		this.element = element;
		return this;
	}

	public returnStatement removeElement() { 
		this.element = null;
		return this;
	}

	public java.lang.Object getCondition() { 
		return condition;
	}

	public returnStatement setCondition(java.lang.Object condition) { 
		this.condition = condition;
		return this;
	}

	public returnStatement removeCondition() { 
		this.condition = null;
		return this;
	}

	@Override
	public java.lang.String toString() { 
		return "returnStatement";
	}

	public returnStatement() { 
		this.uuid = java.util.UUID.randomUUID();
	}

	public returnStatement(java.util.UUID uuid) { 
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() { 
		return this.uuid;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final returnStatement other = (returnStatement) o;
		return uuid != null ? uuid.equals(other.uuid) : other.uuid == null;
	}

	@Override
	public int hashCode() { 
		int result = uuid != null ? uuid.hashCode() : 0;
		return result;
	}
}