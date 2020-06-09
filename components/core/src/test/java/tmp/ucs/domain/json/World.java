package tmp.ucs.domain.json;

public class World {

	private final io.vertx.core.json.JsonObject jsonObject;

	public World() { 
		this.jsonObject = new io.vertx.core.json.JsonObject();
		jsonObject.put("uuid", java.util.UUID.randomUUID().toString());
	}

	public World(io.vertx.core.json.JsonObject jsonObject) { 
		this.jsonObject = jsonObject;
		java.lang.String uuidString = jsonObject.getString("uuid");
		if (uuidString == null) jsonObject.put("uuid", java.util.UUID.randomUUID().toString());
	}

	public io.vertx.core.json.JsonObject getJsonObject() { 
		return this.jsonObject;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final World other = (World) o;
		return jsonObject.getString("uuid").equals(other.getJsonObject().getString("uuid"));
	}

	@Override
	public int hashCode() { 
		return java.util.Objects.hash(jsonObject.getString("uuid"));
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

	public World removeRegions(Region value) { 
		final io.vertx.core.json.JsonArray jsonArray = jsonObject.getJsonArray("regions", new io.vertx.core.json.JsonArray());
		for (int i = 0; i < jsonArray.size(); i++)  { 
			final io.vertx.core.json.JsonObject o = jsonArray.getJsonObject(i);
			if (value.getJsonObject().getString("uuid").equals(o.getString("uuid")))  { 
				jsonArray.remove(i);
				return this;
			}
		}
		return this;
	}

	public World clearRegions() { 
		jsonObject.put("regions", new io.vertx.core.json.JsonArray());
		return this;
	}

	@Override
	public java.lang.String toString() { 
		return jsonObject.encode();
	}
}