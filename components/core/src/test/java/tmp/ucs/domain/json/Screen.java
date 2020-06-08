package tmp.ucs.domain.json;


public class Screen {

	private final io.vertx.core.json.JsonObject jsonObject;

	public Screen() { 
		this.jsonObject = new io.vertx.core.json.JsonObject();
	}

	public Screen(io.vertx.core.json.JsonObject jsonObject) { 
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
		final Screen other = (Screen) o;
		return jsonObject.equals(other.jsonObject);
	}

	@Override
	public int hashCode() { 
		return java.util.Objects.hash(jsonObject);
	}

	public Screen setName(String value) { 
		jsonObject.put("name", value);
		return this;
	}

	public String getName() { 
		return jsonObject.getString("name");
	}

	public Screen setStatus(ScreenStatus value) { 
		jsonObject.put("status", value.name());
		return this;
	}

	public ScreenStatus getStatus() { 
		return jsonObject.getString("status") == null ? null : ScreenStatus.valueOf(jsonObject.getString("status"));
	}

	public Screen setActive(Boolean value) { 
		jsonObject.put("active", value);
		return this;
	}

	public Boolean getActive() { 
		return jsonObject.getBoolean("active");
	}

	public Screen addSeats(Seat value) { 
		io.vertx.core.json.JsonArray jsonArray = jsonObject.getJsonArray("seats");
		if (jsonArray == null) jsonObject.put("seats", jsonArray = new io.vertx.core.json.JsonArray());
		jsonArray.add(value.getJsonObject());
		return this;
	}

	public java.util.stream.Stream<Seat> getSeats() { 
		return jsonObject.getJsonArray("seats", new io.vertx.core.json.JsonArray()).stream().map((o) -> new Seat((io.vertx.core.json.JsonObject) o));
	}
}