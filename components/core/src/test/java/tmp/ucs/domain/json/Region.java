package tmp.ucs.domain.json;


public class Region {

	private final io.vertx.core.json.JsonObject jsonObject;

	public Region() { 
		this.jsonObject = new io.vertx.core.json.JsonObject();
	}

	public Region(io.vertx.core.json.JsonObject jsonObject) { 
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
		final Region other = (Region) o;
		return jsonObject.equals(other.jsonObject);
	}

	@Override
	public int hashCode() { 
		return java.util.Objects.hash(jsonObject);
	}

	public Region setName(String value) { 
		jsonObject.put("name", value);
		return this;
	}

	public String getName() { 
		return jsonObject.getString("name");
	}

	public Region addCountries(Country value) { 
		io.vertx.core.json.JsonArray jsonArray = jsonObject.getJsonArray("countries");
		if (jsonArray == null) jsonObject.put("countries", jsonArray = new io.vertx.core.json.JsonArray());
		jsonArray.add(value.getJsonObject());
		return this;
	}

	public java.util.stream.Stream<Country> getCountries() { 
		return jsonObject.getJsonArray("countries", new io.vertx.core.json.JsonArray()).stream().map((o) -> new Country((io.vertx.core.json.JsonObject) o));
	}
}