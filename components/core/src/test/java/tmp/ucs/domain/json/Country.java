package tmp.ucs.domain.json;


public class Country {

	private final io.vertx.core.json.JsonObject jsonObject;

	public Country() { 
		this.jsonObject = new io.vertx.core.json.JsonObject();
	}

	public Country(io.vertx.core.json.JsonObject jsonObject) { 
		this.jsonObject = jsonObject;
	}

	public io.vertx.core.json.JsonObject getJsonObject() { 
		return this.jsonObject;
	}

	@Override
	public java.lang.String toString() { 
		return jsonObject.encode();
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final Country other = (Country) o;
		return jsonObject.equals(other.jsonObject);
	}

	@Override
	public int hashCode() { 
		return java.util.Objects.hash(jsonObject);
	}

	public Country setName(String value) { 
		jsonObject.put("name", value);
		return this;
	}

	public String getName() { 
		return jsonObject.getString("name");
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
}