package nextgen.java.st;


public class ArrayCreationExpression implements Expression, LambdaBody {

	private ClassOrInterfaceType type;
	private java.lang.Object initializer;
	private java.util.List<java.lang.Object> levels = new java.util.ArrayList<>();
	private final java.util.UUID uuid;

	public ClassOrInterfaceType getType() { 
		return type;
	}

	public ArrayCreationExpression setType(ClassOrInterfaceType type) { 
		this.type = type;
		return this;
	}

	public ArrayCreationExpression removeType() { 
		this.type = null;
		return this;
	}

	public java.lang.Object getInitializer() { 
		return initializer;
	}

	public ArrayCreationExpression setInitializer(java.lang.Object initializer) { 
		this.initializer = initializer;
		return this;
	}

	public ArrayCreationExpression removeInitializer() { 
		this.initializer = null;
		return this;
	}

	public java.util.List<java.lang.Object> getLevels() { 
		return levels;
	}

	public ArrayCreationExpression addLevels(java.lang.Object levels) { 
		this.levels.add(levels);
		return this;
	}

	public ArrayCreationExpression removeLevels(java.lang.Object levels) { 
		this.levels.remove(levels);
		return this;
	}

	@Override
	public java.lang.String toString() { 
		return "ArrayCreationExpression";
	}

	public ArrayCreationExpression() { 
		this.uuid = java.util.UUID.randomUUID();
	}

	public ArrayCreationExpression(java.util.UUID uuid) { 
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() { 
		return this.uuid;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final ArrayCreationExpression other = (ArrayCreationExpression) o;
		return uuid != null ? uuid.equals(other.uuid) : other.uuid == null;
	}

	@Override
	public int hashCode() { 
		int result = uuid != null ? uuid.hashCode() : 0;
		return result;
	}
}