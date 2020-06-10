package tmp.ucs.domain.json;

public class Cinema {

	private final io.vertx.core.json.JsonObject jsonObject;

	public Cinema() { 
		this.jsonObject = new io.vertx.core.json.JsonObject();
		jsonObject.put("uuid", java.util.UUID.randomUUID().toString());
	}

	public Cinema(io.vertx.core.json.JsonObject jsonObject) { 
		this.jsonObject = jsonObject;
		java.lang.String uuidString = jsonObject.getString("uuid");
		if (uuidString == null) jsonObject.put("uuid", java.util.UUID.randomUUID().toString());
	}

	public io.vertx.core.json.JsonObject getJsonObject() { 
		return this.jsonObject;
	}

	public Cinema removeUuid() {
		this.jsonObject.remove("uuid");
		return this;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final Cinema other = (Cinema) o;
		return jsonObject.getString("uuid").equals(other.getJsonObject().getString("uuid"));
	}

	@Override
	public int hashCode() { 
		return java.util.Objects.hash(jsonObject.getString("uuid"));
	}

	public Cinema setName(String value) { 
		jsonObject.put("name", value);
		return this;
	}

	public String getName() { 
		return jsonObject.getString("name");
	}

	public String getName(String defaultValue) { 
		return jsonObject.getString("name", defaultValue);
	}

	public Cinema addAliases(String value) { 
		io.vertx.core.json.JsonArray jsonArray = jsonObject.getJsonArray("aliases");
		if (jsonArray == null) jsonObject.put("aliases", jsonArray = new io.vertx.core.json.JsonArray());
		jsonArray.add(value);
		return this;
	}

	public java.util.stream.Stream<String> getAliases() { 
		return jsonObject.getJsonArray("aliases", new io.vertx.core.json.JsonArray()).stream().map((o) -> (String)o);
	}

	public Cinema removeAliases(String value) { 
		final io.vertx.core.json.JsonArray jsonArray = jsonObject.getJsonArray("aliases", new io.vertx.core.json.JsonArray());
		for (int i = 0; i < jsonArray.size(); i++)  { 
			final io.vertx.core.json.JsonObject o = jsonArray.getJsonObject(i);
			if (value.equals(o))  { 
				jsonArray.remove(i);
				return this;
			}
		}
		return this;
	}

	public Cinema clearAliases() { 
		jsonObject.put("aliases", new io.vertx.core.json.JsonArray());
		return this;
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

	public Cinema removeScreens(Screen value) { 
		final io.vertx.core.json.JsonArray jsonArray = jsonObject.getJsonArray("screens", new io.vertx.core.json.JsonArray());
		for (int i = 0; i < jsonArray.size(); i++)  { 
			final io.vertx.core.json.JsonObject o = jsonArray.getJsonObject(i);
			if (value.getJsonObject().getString("uuid").equals(o.getString("uuid")))  { 
				jsonArray.remove(i);
				return this;
			}
		}
		return this;
	}

	public Cinema clearScreens() { 
		jsonObject.put("screens", new io.vertx.core.json.JsonArray());
		return this;
	}

	@Override
	public java.lang.String toString() { 
		return jsonObject.encode();
	}
}