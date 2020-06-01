package nextgen.domain.domain;


public class Entity {

	private final java.util.UUID uuid;
	private EntityType type;
	private final java.util.List<String> enumValues = new java.util.ArrayList<>();
	private String name;

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

	public Entity setType(EntityType type) { 
		this.type = type;
		return this;
	}

	public EntityType getType() { 
		return this.type;
	}

	public Entity addEnumValues(String value) { 
		enumValues.add(value);
		return this;
	}

	public java.util.List<String> getEnumValues() { 
		return this.enumValues;
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
		return name == null ? null : name;
	}
}