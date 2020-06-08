package tmp.ucs.domain;


public class City {

	private final java.util.UUID uuid;
	private String name;
	private final java.util.List<Address> addresses = new java.util.ArrayList<>();

	public City() { 
		this.uuid = java.util.UUID.randomUUID();
	}

	public City(java.util.UUID uuid) { 
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
		final City other = (City) o;
		return uuid.equals(other.uuid);
	}

	public City setName(String name) { 
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

	public City addAddresses(Address value) { 
		addresses.add(value);
		return this;
	}

	public java.util.List<Address> getAddresses() { 
		return this.addresses;
	}
}