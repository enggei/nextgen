package nextgen.domain.domain;


public class Entity {

	private final java.util.UUID uuid;
	private java.lang.String name;
	private java.lang.Boolean isPrimitive;
	private java.lang.Boolean isEnum;
	private java.lang.Boolean isExternal;
	private PropertyType type;
	private final java.util.List<Property> properties = new java.util.ArrayList<>();

	public Entity() { 
		this.uuid = java.util.UUID.randomUUID();
	}

	public Entity(java.util.UUID uuid) { 
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
		final Entity other = (Entity) o;
		return uuid.equals(other.uuid);
	}

	public Entity setName(java.lang.String name) { 
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

	public Entity setIsPrimitive(java.lang.Boolean isPrimitive) { 
		this.isPrimitive = isPrimitive;
		return this;
	}

	public java.lang.Boolean getIsPrimitive() { 
		return this.isPrimitive;
	}

	public boolean hasIsPrimitive() { 
		return isPrimitive != null;
	}

	public Entity setIsEnum(java.lang.Boolean isEnum) { 
		this.isEnum = isEnum;
		return this;
	}

	public java.lang.Boolean getIsEnum() { 
		return this.isEnum;
	}

	public boolean hasIsEnum() { 
		return isEnum != null;
	}

	public Entity setIsExternal(java.lang.Boolean isExternal) { 
		this.isExternal = isExternal;
		return this;
	}

	public java.lang.Boolean getIsExternal() { 
		return this.isExternal;
	}

	public boolean hasIsExternal() { 
		return isExternal != null;
	}

	public Entity setType(PropertyType type) { 
		this.type = type;
		return this;
	}

	public PropertyType getType() { 
		return this.type;
	}

	public boolean hasType() { 
		return type != null;
	}

	public Entity addProperties(Property value) { 
		properties.add(value);
		return this;
	}

	public java.util.List<Property> getProperties() { 
		return this.properties;
	}
}