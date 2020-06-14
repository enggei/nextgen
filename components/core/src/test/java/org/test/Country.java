package org.test;

public class Country {

	private final java.util.UUID uuid;
	private String _name;
	private Long _id;
	private java.io.File _map;
	private java.util.concurrent.atomic.AtomicInteger _population;
	private Capitol _capitol;
	private java.util.List<City> _cities = new java.util.ArrayList<>();

	public Country() {
		this.uuid = java.util.UUID.randomUUID();
	}

	public Country(java.util.UUID uuid) {
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() {
		return this.uuid;
	}	

	public String getName() {
		return this._name;
	}

	public Country setName(String value) {
		this._name = value;
		return this;
	}

	public Long getId() {
		return this._id;
	}

	public Country setId(Long value) {
		this._id = value;
		return this;
	}

	public java.io.File getMap() {
		return this._map;
	}

	public Country setMap(java.io.File value) {
		this._map = value;
		return this;
	}

	public Country removeMap() {
		this._map = null;
		return this;
	}

	public java.util.concurrent.atomic.AtomicInteger getPopulation() {
		return this._population;
	}

	public Country setPopulation(java.util.concurrent.atomic.AtomicInteger value) {
		this._population = value;
		return this;
	}

	public Country removePopulation() {
		this._population = null;
		return this;
	}

	public Capitol getCapitol() {
		return this._capitol;
	}

	public Country setCapitol(Capitol value) {
		this._capitol = value;
		return this;
	}

	public Country removeCapitol() {
		this._capitol = null;
		return this;
	}

	public java.util.List<City> getCities() {
		return this._cities;
	}

	public Country addCities(City value) {
		this._cities.add(value);
		return this;
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
}