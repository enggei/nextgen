package tmp.ucs.domain;

public class Address {

	private final java.util.UUID uuid;
	private String _street;
	private Integer _no;
	private String _letter;

	public Address() {
		this.uuid = java.util.UUID.randomUUID();
	}

	public Address(java.util.UUID uuid) {
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() {
		return this.uuid;
	}	

	public String getStreet() {
		return this._street;
	}

	public Address setStreet(String value) {
		this._street = value;
		return this;
	}

	public Integer getNo() {
		return this._no;
	}

	public Address setNo(Integer value) {
		this._no = value;
		return this;
	}

	public String getLetter() {
		return this._letter;
	}

	public Address setLetter(String value) {
		this._letter = value;
		return this;
	}
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Address that = (Address) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}
}