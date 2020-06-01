package nextgen.react.st;


public class Prop {

	private java.lang.Object name;
	private java.lang.Object value;
	private final java.util.UUID uuid;

	public java.lang.Object getName() { 
		return name;
	}

	public Prop setName(java.lang.Object name) { 
		this.name = name;
		return this;
	}

	public Prop removeName() { 
		this.name = null;
		return this;
	}

	public java.lang.Object getValue() { 
		return value;
	}

	public Prop setValue(java.lang.Object value) { 
		this.value = value;
		return this;
	}

	public Prop removeValue() { 
		this.value = null;
		return this;
	}

	@Override
	public java.lang.String toString() { 
		return "Prop";
	}

	public Prop() { 
		this.uuid = java.util.UUID.randomUUID();
	}

	public Prop(java.util.UUID uuid) { 
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() { 
		return this.uuid;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final Prop other = (Prop) o;
		return uuid != null ? uuid.equals(other.uuid) : other.uuid == null;
	}

	@Override
	public int hashCode() { 
		int result = uuid != null ? uuid.hashCode() : 0;
		return result;
	}
}