package tmp.ucs.domain.json;

public class Exhibitor {

	private final io.vertx.core.json.JsonObject jsonObject;

	public Exhibitor() { 
		this.jsonObject = new io.vertx.core.json.JsonObject();
		jsonObject.put("uuid", java.util.UUID.randomUUID().toString());
	}

	public Exhibitor(io.vertx.core.json.JsonObject jsonObject) { 
		this.jsonObject = jsonObject;
		java.lang.String uuidString = jsonObject.getString("uuid");
		if (uuidString == null) jsonObject.put("uuid", java.util.UUID.randomUUID().toString());
	}

	public io.vertx.core.json.JsonObject getJsonObject() { 
		return this.jsonObject;
	}

	public Exhibitor removeUuid() {
		this.jsonObject.remove("uuid");
		return this;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final Exhibitor other = (Exhibitor) o;
		return jsonObject.getString("uuid").equals(other.getJsonObject().getString("uuid"));
	}

	@Override
	public int hashCode() { 
		return java.util.Objects.hash(jsonObject.getString("uuid"));
	}

	public Exhibitor setName(String value) { 
		jsonObject.put("name", value);
		return this;
	}

	public String getName() { 
		return jsonObject.getString("name");
	}

	public String getName(String defaultValue) { 
		return jsonObject.getString("name", defaultValue);
	}

	public Exhibitor addCinemas(Cinema value) { 
		io.vertx.core.json.JsonArray jsonArray = jsonObject.getJsonArray("cinemas");
		if (jsonArray == null) jsonObject.put("cinemas", jsonArray = new io.vertx.core.json.JsonArray());
		jsonArray.add(value.getJsonObject());
		return this;
	}

	public java.util.stream.Stream<Cinema> getCinemas() { 
		return jsonObject.getJsonArray("cinemas", new io.vertx.core.json.JsonArray()).stream().map((o) -> new Cinema((io.vertx.core.json.JsonObject) o));
	}

	public Exhibitor removeCinemas(Cinema value) { 
		final io.vertx.core.json.JsonArray jsonArray = jsonObject.getJsonArray("cinemas", new io.vertx.core.json.JsonArray());
		for (int i = 0; i < jsonArray.size(); i++)  { 
			final io.vertx.core.json.JsonObject o = jsonArray.getJsonObject(i);
			if (value.getJsonObject().getString("uuid").equals(o.getString("uuid")))  { 
				jsonArray.remove(i);
				return this;
			}
		}
		return this;
	}

	public Exhibitor clearCinemas() { 
		jsonObject.put("cinemas", new io.vertx.core.json.JsonArray());
		return this;
	}

	@Override
	public java.lang.String toString() { 
		return jsonObject.encode();
	}
}