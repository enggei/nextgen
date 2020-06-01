package nextgen.java.st;


public class TypeParameter {

	private java.lang.String name;
	private java.util.List<java.lang.Object> typeBounds = new java.util.ArrayList<>();
	private final java.util.UUID uuid;

	public java.lang.String getName() { 
		return name;
	}

	public TypeParameter setName(java.lang.String name) { 
		this.name = name;
		return this;
	}

	public TypeParameter removeName() { 
		this.name = null;
		return this;
	}

	@Override
	public java.lang.String toString() { 
		return name;
	}

	public java.util.List<java.lang.Object> getTypeBounds() { 
		return typeBounds;
	}

	public TypeParameter addTypeBounds(java.lang.Object typeBounds) { 
		this.typeBounds.add(typeBounds);
		return this;
	}

	public TypeParameter removeTypeBounds(java.lang.Object typeBounds) { 
		this.typeBounds.remove(typeBounds);
		return this;
	}

	public TypeParameter() { 
		this.uuid = java.util.UUID.randomUUID();
	}

	public TypeParameter(java.util.UUID uuid) { 
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() { 
		return this.uuid;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final TypeParameter other = (TypeParameter) o;
		return uuid != null ? uuid.equals(other.uuid) : other.uuid == null;
	}

	@Override
	public int hashCode() { 
		int result = uuid != null ? uuid.hashCode() : 0;
		return result;
	}
}