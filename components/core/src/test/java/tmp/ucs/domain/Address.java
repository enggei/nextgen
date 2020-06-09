package tmp.ucs.domain;

public class Address {

	private final java.util.UUID uuid;
	private java.lang.String _street;
	private java.lang.Integer _no;
	private java.lang.String _letter;

	public Address() {
		this.uuid = java.util.UUID.randomUUID();
	}

	public Address(java.util.UUID uuid) {
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() {
		return this.uuid;
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

	public java.lang.String getStreet() {
		return this._street;
	}

	public Address setStreet(java.lang.String value) {
		this._street = value;
		return this;
	}

	public java.lang.Integer getNo() {
		return this._no;
	}

	public Address setNo(java.lang.Integer value) {
		this._no = value;
		return this;
	}

	public java.lang.String getLetter() {
		return this._letter;
	}

	public Address setLetter(java.lang.String value) {
		this._letter = value;
		return this;
	}
}