package tmp.ucs.domain.json;


public class Exhibitor {

	private final io.vertx.core.json.JsonObject jsonObject;

	public Exhibitor() { 
		this.jsonObject = new io.vertx.core.json.JsonObject();
	}

	public Exhibitor(io.vertx.core.json.JsonObject jsonObject) { 
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
		final Exhibitor other = (Exhibitor) o;
		return jsonObject.equals(other.jsonObject);
	}

	@Override
	public int hashCode() { 
		return java.util.Objects.hash(jsonObject);
	}

	public Exhibitor setName(String value) { 
		jsonObject.put("name", value);
		return this;
	}

	public String getName() { 
		return jsonObject.getString("name");
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
}