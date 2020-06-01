package nextgen.react.st;


public class DestructorProp {

	private java.lang.Object child;
	private java.util.List<java.lang.Object> prop = new java.util.ArrayList<>();
	private final java.util.UUID uuid;

	public java.lang.Object getChild() { 
		return child;
	}

	public DestructorProp setChild(java.lang.Object child) { 
		this.child = child;
		return this;
	}

	public DestructorProp removeChild() { 
		this.child = null;
		return this;
	}

	public java.util.List<java.lang.Object> getProp() { 
		return prop;
	}

	public DestructorProp addProp(java.lang.Object prop) { 
		this.prop.add(prop);
		return this;
	}

	public DestructorProp removeProp(java.lang.Object prop) { 
		this.prop.remove(prop);
		return this;
	}

	@Override
	public java.lang.String toString() { 
		return "DestructorProp";
	}

	public DestructorProp() { 
		this.uuid = java.util.UUID.randomUUID();
	}

	public DestructorProp(java.util.UUID uuid) { 
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() { 
		return this.uuid;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final DestructorProp other = (DestructorProp) o;
		return uuid != null ? uuid.equals(other.uuid) : other.uuid == null;
	}

	@Override
	public int hashCode() { 
		int result = uuid != null ? uuid.hashCode() : 0;
		return result;
	}
}