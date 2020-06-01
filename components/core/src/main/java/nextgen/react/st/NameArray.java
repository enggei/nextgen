package nextgen.react.st;


public class NameArray {

	private java.util.List<java.lang.Object> values = new java.util.ArrayList<>();
	private java.lang.Object name;
	private final java.util.UUID uuid;

	public java.util.List<java.lang.Object> getValues() { 
		return values;
	}

	public NameArray addValues(java.lang.Object values) { 
		this.values.add(values);
		return this;
	}

	public NameArray removeValues(java.lang.Object values) { 
		this.values.remove(values);
		return this;
	}

	public java.lang.Object getName() { 
		return name;
	}

	public NameArray setName(java.lang.Object name) { 
		this.name = name;
		return this;
	}

	public NameArray removeName() { 
		this.name = null;
		return this;
	}

	@Override
	public java.lang.String toString() { 
		return "NameArray";
	}

	public NameArray() { 
		this.uuid = java.util.UUID.randomUUID();
	}

	public NameArray(java.util.UUID uuid) { 
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() { 
		return this.uuid;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final NameArray other = (NameArray) o;
		return uuid != null ? uuid.equals(other.uuid) : other.uuid == null;
	}

	@Override
	public int hashCode() { 
		int result = uuid != null ? uuid.hashCode() : 0;
		return result;
	}
}