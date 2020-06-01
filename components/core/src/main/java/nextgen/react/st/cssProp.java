package nextgen.react.st;


public class cssProp {

	private java.lang.Object value;
	private java.lang.Object name;
	private final java.util.UUID uuid;

	public java.lang.Object getValue() { 
		return value;
	}

	public cssProp setValue(java.lang.Object value) { 
		this.value = value;
		return this;
	}

	public cssProp removeValue() { 
		this.value = null;
		return this;
	}

	public java.lang.Object getName() { 
		return name;
	}

	public cssProp setName(java.lang.Object name) { 
		this.name = name;
		return this;
	}

	public cssProp removeName() { 
		this.name = null;
		return this;
	}

	@Override
	public java.lang.String toString() { 
		return "cssProp";
	}

	public cssProp() { 
		this.uuid = java.util.UUID.randomUUID();
	}

	public cssProp(java.util.UUID uuid) { 
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() { 
		return this.uuid;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final cssProp other = (cssProp) o;
		return uuid != null ? uuid.equals(other.uuid) : other.uuid == null;
	}

	@Override
	public int hashCode() { 
		int result = uuid != null ? uuid.hashCode() : 0;
		return result;
	}
}