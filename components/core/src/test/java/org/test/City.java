package org.test;

public class City {

	private final java.util.UUID uuid;
	private String _name;
	private Long _population;

	public City() {
		this.uuid = java.util.UUID.randomUUID();
	}

	public City(java.util.UUID uuid) {
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() {
		return this.uuid;
	}	

	public String getName() {
		return this._name;
	}

	public City setName(String value) {
		this._name = value;
		return this;
	}

	public Long getPopulation() {
		return this._population;
	}

	public City setPopulation(Long value) {
		this._population = value;
		return this;
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
}