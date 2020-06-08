package tmp.ucs.domain;


public class Address {

	private final java.util.UUID uuid;
	private String street;
	private Integer no;
	private String letter;

	public Address() { 
		this.uuid = java.util.UUID.randomUUID();
	}

	public Address(java.util.UUID uuid) { 
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
		final Address other = (Address) o;
		return uuid.equals(other.uuid);
	}

	public Address setStreet(String street) { 
		this.street = street;
		return this;
	}

	public String getStreet() { 
		return this.street;
	}

	public Address setNo(Integer no) { 
		this.no = no;
		return this;
	}

	public Integer getNo() { 
		return this.no;
	}

	public Address setLetter(String letter) { 
		this.letter = letter;
		return this;
	}

	public String getLetter() { 
		return this.letter;
	}
}