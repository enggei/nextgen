package tmp.ucs.domain;


public class Country {

	private final java.util.UUID uuid;
	private String name;
	private final java.util.List<City> cities = new java.util.ArrayList<>();

	public Country() { 
		this.uuid = java.util.UUID.randomUUID();
	}

	public Country(java.util.UUID uuid) { 
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
		final Country other = (Country) o;
		return uuid.equals(other.uuid);
	}

	public Country setName(String name) { 
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

	public Country addCities(City value) { 
		cities.add(value);
		return this;
	}

	public java.util.List<City> getCities() { 
		return this.cities;
	}
}