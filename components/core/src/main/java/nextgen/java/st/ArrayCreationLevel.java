package nextgen.java.st;


public class ArrayCreationLevel {

	private java.lang.Object dimension;
	private final java.util.UUID uuid;

	public java.lang.Object getDimension() { 
		return dimension;
	}

	public ArrayCreationLevel setDimension(java.lang.Object dimension) { 
		this.dimension = dimension;
		return this;
	}

	public ArrayCreationLevel removeDimension() { 
		this.dimension = null;
		return this;
	}

	@Override
	public java.lang.String toString() { 
		return "ArrayCreationLevel";
	}

	public ArrayCreationLevel() { 
		this.uuid = java.util.UUID.randomUUID();
	}

	public ArrayCreationLevel(java.util.UUID uuid) { 
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() { 
		return this.uuid;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final ArrayCreationLevel other = (ArrayCreationLevel) o;
		return uuid != null ? uuid.equals(other.uuid) : other.uuid == null;
	}

	@Override
	public int hashCode() { 
		int result = uuid != null ? uuid.hashCode() : 0;
		return result;
	}
}