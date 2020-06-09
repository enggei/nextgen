package tmp.ucs.domain.json;

public class Screen {

	private final io.vertx.core.json.JsonObject jsonObject;

	public Screen() { 
		this.jsonObject = new io.vertx.core.json.JsonObject();
		jsonObject.put("uuid", java.util.UUID.randomUUID().toString());
	}

	public Screen(io.vertx.core.json.JsonObject jsonObject) { 
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
		final Screen other = (Screen) o;
		return jsonObject.getString("uuid").equals(other.getJsonObject().getString("uuid"));
	}

	@Override
	public int hashCode() { 
		return java.util.Objects.hash(jsonObject.getString("uuid"));
	}

	public Screen setName(String value) { 
		jsonObject.put("name", value);
		return this;
	}

	public String getName() { 
		return jsonObject.getString("name");
	}

	public String getName(String defaultValue) { 
		return jsonObject.getString("name", defaultValue);
	}

	public Screen setStatus(ScreenStatus value) { 
		if (value == null) return this;
		jsonObject.put("status", value.name());
		return this;
	}

	public ScreenStatus getStatus() { 
		return getStatus(null);
	}

	public ScreenStatus getStatus(ScreenStatus defaultValue) { 
		return jsonObject.getString("status") == null ? defaultValue : ScreenStatus.valueOf(jsonObject.getString("status"));
	}

	public Screen setActive(Boolean value) { 
		jsonObject.put("active", value);
		return this;
	}

	public Boolean getActive() { 
		return jsonObject.getBoolean("active");
	}

	public Boolean getActive(Boolean defaultValue) { 
		return jsonObject.getBoolean("active", defaultValue);
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

	public Screen removeSeats(Seat value) { 
		final io.vertx.core.json.JsonArray jsonArray = jsonObject.getJsonArray("seats", new io.vertx.core.json.JsonArray());
		for (int i = 0; i < jsonArray.size(); i++)  { 
			final io.vertx.core.json.JsonObject o = jsonArray.getJsonObject(i);
			if (value.getJsonObject().getString("uuid").equals(o.getString("uuid")))  { 
				jsonArray.remove(i);
				return this;
			}
		}
		return this;
	}

	public Screen clearSeats() { 
		jsonObject.put("seats", new io.vertx.core.json.JsonArray());
		return this;
	}

	@Override
	public java.lang.String toString() { 
		return jsonObject.encode();
	}
}