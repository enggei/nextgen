package tmp.ucs.domain;


public class Region {

	private final java.util.UUID uuid;
	private String name;
	private final java.util.List<Country> countries = new java.util.ArrayList<>();

	public Region() { 
		this.uuid = java.util.UUID.randomUUID();
	}

	public Region(java.util.UUID uuid) { 
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
		final Region other = (Region) o;
		return uuid.equals(other.uuid);
	}

	public Region setName(String name) { 
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

	public Region addCountries(Country value) { 
		countries.add(value);
		return this;
	}

	public java.util.List<Country> getCountries() { 
		return this.countries;
	}
}