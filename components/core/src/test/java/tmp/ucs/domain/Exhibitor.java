package tmp.ucs.domain;


public class Exhibitor {

	private final java.util.UUID uuid;
	private String name;
	private final java.util.List<Cinema> cinemas = new java.util.ArrayList<>();

	public Exhibitor() { 
		this.uuid = java.util.UUID.randomUUID();
	}

	public Exhibitor(java.util.UUID uuid) { 
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
		final Exhibitor other = (Exhibitor) o;
		return uuid.equals(other.uuid);
	}

	public Exhibitor setName(String name) { 
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

	public Exhibitor addCinemas(Cinema value) { 
		cinemas.add(value);
		return this;
	}

	public java.util.List<Cinema> getCinemas() { 
		return this.cinemas;
	}
}