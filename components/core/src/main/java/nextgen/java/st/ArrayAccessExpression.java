package nextgen.java.st;


public class ArrayAccessExpression implements Expression, LambdaBody {

	private java.lang.Object index;
	private Expression name;
	private final java.util.UUID uuid;

	public java.lang.Object getIndex() { 
		return index;
	}

	public ArrayAccessExpression setIndex(java.lang.Object index) { 
		this.index = index;
		return this;
	}

	public ArrayAccessExpression removeIndex() { 
		this.index = null;
		return this;
	}

	public Expression getName() { 
		return name;
	}

	public ArrayAccessExpression setName(Expression name) { 
		this.name = name;
		return this;
	}

	public ArrayAccessExpression removeName() { 
		this.name = null;
		return this;
	}

	@Override
	public java.lang.String toString() { 
		return "ArrayAccessExpression";
	}

	public ArrayAccessExpression() { 
		this.uuid = java.util.UUID.randomUUID();
	}

	public ArrayAccessExpression(java.util.UUID uuid) { 
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() { 
		return this.uuid;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final ArrayAccessExpression other = (ArrayAccessExpression) o;
		return uuid != null ? uuid.equals(other.uuid) : other.uuid == null;
	}

	@Override
	public int hashCode() { 
		int result = uuid != null ? uuid.hashCode() : 0;
		return result;
	}
}