package tmp.ucs.domain;


public class World {

	private final java.util.UUID uuid;
	private final java.util.List<Region> regions = new java.util.ArrayList<>();

	public World() { 
		this.uuid = java.util.UUID.randomUUID();
	}

	public World(java.util.UUID uuid) { 
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
		final World other = (World) o;
		return uuid.equals(other.uuid);
	}

	public World addRegions(Region value) { 
		regions.add(value);
		return this;
	}

	public java.util.List<Region> getRegions() { 
		return this.regions;
	}
}