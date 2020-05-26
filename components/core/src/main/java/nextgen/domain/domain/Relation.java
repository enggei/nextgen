package nextgen.domain.domain;


public class Relation {

	private final java.util.UUID uuid;
	private String name;
	private RelationType type;
	private Entity src;
	private Entity dst;

	public Relation() { 
		this.uuid = java.util.UUID.randomUUID();
	}

	public Relation(java.util.UUID uuid) { 
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
		final Relation other = (Relation) o;
		return uuid.equals(other.uuid);
	}

	public Relation setName(String name) { 
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

	public Relation setType(RelationType type) { 
		this.type = type;
		return this;
	}

	public RelationType getType() { 
		return this.type;
	}

	public Relation setSrc(Entity src) { 
		this.src = src;
		return this;
	}

	public Entity getSrc() { 
		return this.src;
	}

	public Relation setDst(Entity dst) { 
		this.dst = dst;
		return this;
	}

	public Entity getDst() { 
		return this.dst;
	}
}