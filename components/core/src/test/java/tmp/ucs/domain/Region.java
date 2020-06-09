package tmp.ucs.domain;

public class Region {

	private final java.util.UUID uuid;
	private java.lang.String _name;
	private java.util.List<Country> _countries;

	public Region() {
		this.uuid = java.util.UUID.randomUUID();
	}

	public Region(java.util.UUID uuid) {
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() {
		return this.uuid;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Region that = (Region) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	public java.lang.String getName() {
		return this._name;
	}

	public Region setName(java.lang.String value) {
		this._name = value;
		return this;
	}

	public java.util.List<Country> getCountries() {
		return this._countries;
	}

	public Region addCountries(Country value) {
		this._countries.add(value);
		return this;
	}
}