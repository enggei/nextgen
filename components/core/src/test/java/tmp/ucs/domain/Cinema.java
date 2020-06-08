package tmp.ucs.domain;


public class Cinema {

	private final java.util.UUID uuid;
	private String name;
	private final java.util.List<String> aliases = new java.util.ArrayList<>();
	private Address address;
	private final java.util.List<Screen> screens = new java.util.ArrayList<>();

	public Cinema() { 
		this.uuid = java.util.UUID.randomUUID();
	}

	public Cinema(java.util.UUID uuid) { 
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
		final Cinema other = (Cinema) o;
		return uuid.equals(other.uuid);
	}

	public Cinema setName(String name) { 
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

	public Cinema addAliases(String value) { 
		aliases.add(value);
		return this;
	}

	public java.util.List<String> getAliases() { 
		return this.aliases;
	}

	public Cinema setAddress(Address address) { 
		this.address = address;
		return this;
	}

	public Address getAddress() { 
		return this.address;
	}

	public Cinema addScreens(Screen value) { 
		screens.add(value);
		return this;
	}

	public java.util.List<Screen> getScreens() { 
		return this.screens;
	}
}