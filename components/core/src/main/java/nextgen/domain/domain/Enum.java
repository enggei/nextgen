package nextgen.domain.domain;


public class Enum {

	private final java.util.UUID uuid;
	private java.lang.String name;
	private final java.util.List<String> values = new java.util.ArrayList<>();

	public Enum() { 
		this.uuid = java.util.UUID.randomUUID();
	}

	public Enum(java.util.UUID uuid) { 
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() { 
		return uuid;
	}

	@Override
	public int hashCode() { 
		return java.util.Objects.hash(uuid);
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final Enum other = (Enum) o;
		return uuid.equals(other.uuid);
	}

	public Enum setName(java.lang.String name) { 
		this.name = name;
		return this;
	}

	public java.lang.String getName() { 
		return this.name;
	}

	public boolean hasName() { 
		return name != null;
	}

	@Override
	public java.lang.String toString() { 
		return name;
	}

	public Enum addValues(String value) { 
		values.add(value);
		return this;
	}

	public java.util.List<String> getValues() { 
		return this.values;
	}
}