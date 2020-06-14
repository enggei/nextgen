package org.test.json;

public class Country {

	private final io.vertx.core.json.JsonObject jsonObject;
	private java.io.File _map;
	private java.util.concurrent.atomic.AtomicInteger _population;

	public Country() { 
		this.jsonObject = new io.vertx.core.json.JsonObject();
		jsonObject.put("uuid", java.util.UUID.randomUUID().toString());
	}

	public Country(io.vertx.core.json.JsonObject jsonObject) { 
		this.jsonObject = jsonObject;
		java.lang.String uuidString = jsonObject.getString("uuid");
		if (uuidString == null) jsonObject.put("uuid", java.util.UUID.randomUUID().toString());
	}

	public io.vertx.core.json.JsonObject getJsonObject() { 
		return this.jsonObject;
	}

	public Country removeUuid() {
		this.jsonObject.remove("uuid");
		return this;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final Country other = (Country) o;
		return jsonObject.getString("uuid").equals(other.getJsonObject().getString("uuid"));
	}

	@Override
	public int hashCode() { 
		return java.util.Objects.hash(jsonObject.getString("uuid"));
	}

	public Country setName(String value) { 
		jsonObject.put("name", value);
		return this;
	}

	public String getName() { 
		return jsonObject.getString("name");
	}

	public String getName(String defaultValue) { 
		return jsonObject.getString("name", defaultValue);
	}

	public Country setId(Long value) { 
		jsonObject.put("id", value);
		return this;
	}

	public Long getId() { 
		return jsonObject.getLong("id");
	}

	public Long getId(Long defaultValue) { 
		return jsonObject.getLong("id", defaultValue);
	}

	public Country setMap(java.io.File value) { 
		this._map = value;
		return this;
	}

	public java.io.File getMap() { 
		return this._map;
	}

	public java.io.File getMap(java.io.File defaultValue) { 
		return this._map == null ? defaultValue : this._map;
	}

	public Country setPopulation(java.util.concurrent.atomic.AtomicInteger value) { 
		this._population = value;
		return this;
	}

	public java.util.concurrent.atomic.AtomicInteger getPopulation() { 
		return this._population;
	}

	public java.util.concurrent.atomic.AtomicInteger getPopulation(java.util.concurrent.atomic.AtomicInteger defaultValue) { 
		return this._population == null ? defaultValue : this._population;
	}

	public Country setCapitol(Capitol value) { 
		jsonObject.put("capitol", value.getJsonObject());
		return this;
	}

	public Capitol getCapitol() { 
		return jsonObject.getJsonObject("capitol") == null ? null : new Capitol(jsonObject.getJsonObject("capitol"));
	}

	public Country addCities(City value) { 
		io.vertx.core.json.JsonArray jsonArray = jsonObject.getJsonArray("cities");
		if (jsonArray == null) jsonObject.put("cities", jsonArray = new io.vertx.core.json.JsonArray());
		jsonArray.add(value.getJsonObject());
		return this;
	}

	public java.util.stream.Stream<City> getCities() { 
		return jsonObject.getJsonArray("cities", new io.vertx.core.json.JsonArray()).stream().map((o) -> new City((io.vertx.core.json.JsonObject) o));
	}

	public Country removeCities(City value) { 
		final io.vertx.core.json.JsonArray jsonArray = jsonObject.getJsonArray("cities", new io.vertx.core.json.JsonArray());
		for (int i = 0; i < jsonArray.size(); i++)  { 
			final io.vertx.core.json.JsonObject o = jsonArray.getJsonObject(i);
			if (value.getJsonObject().getString("uuid").equals(o.getString("uuid")))  { 
				jsonArray.remove(i);
				return this;
			}
		}
		return this;
	}

	public Country clearCities() { 
		jsonObject.put("cities", new io.vertx.core.json.JsonArray());
		return this;
	}

	@Override
	public java.lang.String toString() { 
		return jsonObject.encode();
	}
}