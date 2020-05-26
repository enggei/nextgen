package nextgen.domain.domain;


public class Entity {

	private final java.util.UUID uuid;
	private String name;
	private Boolean isPrimitive;
	private Boolean isEnum;
	private Boolean isExternal;
	private final java.util.List<String> enumValues = new java.util.ArrayList<>();

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

	public Entity setName(String name) { 
		this.name = name;
		return this;
	}

	public String getName() { 
		return this.name;
	}

	@Override
	public java.lang.String toString() { 
		return name;
	}

	public Entity setIsPrimitive(Boolean isPrimitive) { 
		this.isPrimitive = isPrimitive;
		return this;
	}

	public Boolean getIsPrimitive() { 
		return this.isPrimitive;
	}

	public Entity setIsEnum(Boolean isEnum) { 
		this.isEnum = isEnum;
		return this;
	}

	public Boolean getIsEnum() { 
		return this.isEnum;
	}

	public Entity setIsExternal(Boolean isExternal) { 
		this.isExternal = isExternal;
		return this;
	}

	public Boolean getIsExternal() { 
		return this.isExternal;
	}

	public Entity addEnumValues(String value) { 
		enumValues.add(value);
		return this;
	}

	public java.util.List<String> getEnumValues() { 
		return this.enumValues;
	}
}