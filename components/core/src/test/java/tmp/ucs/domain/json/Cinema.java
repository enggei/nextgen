package tmp.ucs.domain.json;


public class Cinema {

	private final io.vertx.core.json.JsonObject jsonObject;

	public Cinema() { 
		this.jsonObject = new io.vertx.core.json.JsonObject();
	}

	public Cinema(io.vertx.core.json.JsonObject jsonObject) { 
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
		final Cinema other = (Cinema) o;
		return jsonObject.equals(other.jsonObject);
	}

	@Override
	public int hashCode() { 
		return java.util.Objects.hash(jsonObject);
	}

	public Cinema setName(String value) { 
		jsonObject.put("name", value);
		return this;
	}

	public String getName() { 
		return jsonObject.getString("name");
	}

	public Cinema addAliases(String value) { 
		io.vertx.core.json.JsonArray jsonArray = jsonObject.getJsonArray("aliases");
		if (jsonArray == null) jsonObject.put("aliases", jsonArray = new io.vertx.core.json.JsonArray());
		jsonArray.add(value);
		return this;
	}

	public java.util.stream.Stream<String> getAliases() { 
		return jsonObject.getJsonArray("aliases", new io.vertx.core.json.JsonArray()).stream().map((o) -> (String) o);
	}

	public Cinema setAddress(Address value) { 
		jsonObject.put("address", value.getJsonObject());
		return this;
	}

	public Address getAddress() { 
		return jsonObject.getJsonObject("address") == null ? null : new Address(jsonObject.getJsonObject("address"));
	}

	public Cinema addScreens(Screen value) { 
		io.vertx.core.json.JsonArray jsonArray = jsonObject.getJsonArray("screens");
		if (jsonArray == null) jsonObject.put("screens", jsonArray = new io.vertx.core.json.JsonArray());
		jsonArray.add(value.getJsonObject());
		return this;
	}

	public java.util.stream.Stream<Screen> getScreens() { 
		return jsonObject.getJsonArray("screens", new io.vertx.core.json.JsonArray()).stream().map((o) -> new Screen((io.vertx.core.json.JsonObject) o));
	}
}