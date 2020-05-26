package nextgen.domain.domain;


public class Property {

	private final java.util.UUID uuid;
	private java.lang.String name;
	private PropertyType type;
	private Enum enumType;
	private String externalType;

	public Property() { 
		this.uuid = java.util.UUID.randomUUID();
	}

	public Property(java.util.UUID uuid) { 
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
		final Property other = (Property) o;
		return uuid.equals(other.uuid);
	}

	public Property setName(java.lang.String name) { 
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

	public Property setType(PropertyType type) { 
		this.type = type;
		return this;
	}

	public PropertyType getType() { 
		return this.type;
	}

	public boolean hasType() { 
		return type != null;
	}

	public Property setEnumType(Enum enumType) { 
		this.enumType = enumType;
		return this;
	}

	public Enum getEnumType() { 
		return this.enumType;
	}

	public Property setExternalType(String externalType) { 
		this.externalType = externalType;
		return this;
	}

	public String getExternalType() { 
		return this.externalType;
	}
}