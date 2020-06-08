package tmp.ucs.domain.json;


public class World {

	private final io.vertx.core.json.JsonObject jsonObject;

	public World() { 
		this.jsonObject = new io.vertx.core.json.JsonObject();
	}

	public World(io.vertx.core.json.JsonObject jsonObject) { 
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
		final World other = (World) o;
		return jsonObject.equals(other.jsonObject);
	}

	@Override
	public int hashCode() { 
		return java.util.Objects.hash(jsonObject);
	}

	public World addRegions(Region value) { 
		io.vertx.core.json.JsonArray jsonArray = jsonObject.getJsonArray("regions");
		if (jsonArray == null) jsonObject.put("regions", jsonArray = new io.vertx.core.json.JsonArray());
		jsonArray.add(value.getJsonObject());
		return this;
	}

	public java.util.stream.Stream<Region> getRegions() { 
		return jsonObject.getJsonArray("regions", new io.vertx.core.json.JsonArray()).stream().map((o) -> new Region((io.vertx.core.json.JsonObject) o));
	}
}