package tmp.ucs.domain;

public class Country {

	private final java.util.UUID uuid;
	private java.lang.String _name;
	private java.util.List<City> _cities;

	public Country() {
		this.uuid = java.util.UUID.randomUUID();
	}

	public Country(java.util.UUID uuid) {
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() {
		return this.uuid;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Country that = (Country) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	public java.lang.String getName() {
		return this._name;
	}

	public Country setName(java.lang.String value) {
		this._name = value;
		return this;
	}

	public java.util.List<City> getCities() {
		return this._cities;
	}

	public Country addCities(City value) {
		this._cities.add(value);
		return this;
	}
}