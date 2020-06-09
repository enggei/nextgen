package tmp.ucs.domain;

public class City {

	private final java.util.UUID uuid;
	private java.lang.String _name;
	private java.util.List<Address> _addresses;

	public City() {
		this.uuid = java.util.UUID.randomUUID();
	}

	public City(java.util.UUID uuid) {
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() {
		return this.uuid;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		City that = (City) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	public java.lang.String getName() {
		return this._name;
	}

	public City setName(java.lang.String value) {
		this._name = value;
		return this;
	}

	public java.util.List<Address> getAddresses() {
		return this._addresses;
	}

	public City addAddresses(Address value) {
		this._addresses.add(value);
		return this;
	}
}