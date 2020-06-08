package tmp.ucs.domain.json;


public class City {

	private final io.vertx.core.json.JsonObject jsonObject;

	public City() { 
		this.jsonObject = new io.vertx.core.json.JsonObject();
	}

	public City(io.vertx.core.json.JsonObject jsonObject) { 
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
		final City other = (City) o;
		return jsonObject.equals(other.jsonObject);
	}

	@Override
	public int hashCode() { 
		return java.util.Objects.hash(jsonObject);
	}

	public City setName(String value) { 
		jsonObject.put("name", value);
		return this;
	}

	public String getName() { 
		return jsonObject.getString("name");
	}

	public City addAddresses(Address value) { 
		io.vertx.core.json.JsonArray jsonArray = jsonObject.getJsonArray("addresses");
		if (jsonArray == null) jsonObject.put("addresses", jsonArray = new io.vertx.core.json.JsonArray());
		jsonArray.add(value.getJsonObject());
		return this;
	}

	public java.util.stream.Stream<Address> getAddresses() { 
		return jsonObject.getJsonArray("addresses", new io.vertx.core.json.JsonArray()).stream().map((o) -> new Address((io.vertx.core.json.JsonObject) o));
	}
}