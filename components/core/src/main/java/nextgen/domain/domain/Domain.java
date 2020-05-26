package nextgen.domain.domain;


public class Domain {

	private final java.util.UUID uuid;
	private java.lang.String name;
	private final java.util.List<Enum> enums = new java.util.ArrayList<>();
	private final java.util.List<Entity> entities = new java.util.ArrayList<>();
	private final java.util.List<Relation> relations = new java.util.ArrayList<>();

	public Domain() { 
		this.uuid = java.util.UUID.randomUUID();
	}

	public Domain(java.util.UUID uuid) { 
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
		final Domain other = (Domain) o;
		return uuid.equals(other.uuid);
	}

	public Domain setName(java.lang.String name) { 
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

	public Domain addEnums(Enum value) { 
		enums.add(value);
		return this;
	}

	public java.util.List<Enum> getEnums() { 
		return this.enums;
	}

	public Domain addEntities(Entity value) { 
		entities.add(value);
		return this;
	}

	public java.util.List<Entity> getEntities() { 
		return this.entities;
	}

	public Domain addRelations(Relation value) { 
		relations.add(value);
		return this;
	}

	public java.util.List<Relation> getRelations() { 
		return this.relations;
	}
}