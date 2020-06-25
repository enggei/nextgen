package nextgen.st.model;

public class STModule {

	private final io.vertx.core.json.JsonObject jsonObject;

	public STModule() { 
		this.jsonObject = new io.vertx.core.json.JsonObject();
		jsonObject.put("uuid", java.util.UUID.randomUUID().toString());
	}

	public STModule(io.vertx.core.json.JsonObject jsonObject) { 
		this.jsonObject = jsonObject;
		java.lang.String uuidString = jsonObject.getString("uuid");
		if (uuidString == null) jsonObject.put("uuid", java.util.UUID.randomUUID().toString());
	}

	public io.vertx.core.json.JsonObject getJsonObject() { 
		return this.jsonObject;
	}

	public String uuid() {
		return this.jsonObject.getString("uuid");
	}

	public STModule removeUuid() {
		this.jsonObject.remove("uuid");
		return this;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final STModule other = (STModule) o;
		return jsonObject.getString("uuid").equals(other.getJsonObject().getString("uuid"));
	}

	@Override
	public int hashCode() { 
		return java.util.Objects.hash(jsonObject.getString("uuid"));
	}

	public STModule setName(String value) { 
		jsonObject.put("name", value);
		return this;
	}

	public String getName() { 
		return jsonObject.getString("name");
	}

	public String getName(String defaultValue) { 
		return jsonObject.getString("name", defaultValue);
	}

	public STModule addStGroups(String value) { 
		io.vertx.core.json.JsonArray jsonArray = jsonObject.getJsonArray("stGroups");
		if (jsonArray == null) jsonObject.put("stGroups", jsonArray = new io.vertx.core.json.JsonArray());
		jsonArray.add(value);
		return this;
	}

	public java.util.stream.Stream<String> getStGroups() { 
		return jsonObject.getJsonArray("stGroups", new io.vertx.core.json.JsonArray()).stream().map((o) -> (String)o);
	}

	public STModule removeStGroups(String value) { 
		final io.vertx.core.json.JsonArray jsonArray = jsonObject.getJsonArray("stGroups", new io.vertx.core.json.JsonArray());
		for (int i = 0; i < jsonArray.size(); i++)  { 
			final io.vertx.core.json.JsonObject o = jsonArray.getJsonObject(i);
			if (value.equals(o))  { 
				jsonArray.remove(i);
				return this;
			}
		}
		return this;
	}

	public STModule clearStGroups() { 
		jsonObject.put("stGroups", new io.vertx.core.json.JsonArray());
		return this;
	}

	public STModule addModels(STModel value) { 
		io.vertx.core.json.JsonArray jsonArray = jsonObject.getJsonArray("models");
		if (jsonArray == null) jsonObject.put("models", jsonArray = new io.vertx.core.json.JsonArray());
		jsonArray.add(value.getJsonObject());
		return this;
	}

	public java.util.stream.Stream<STModel> getModels() { 
		return jsonObject.getJsonArray("models", new io.vertx.core.json.JsonArray()).stream().map((o) -> new STModel((io.vertx.core.json.JsonObject) o));
	}

	public STModule removeModels(STModel value) { 
		final io.vertx.core.json.JsonArray jsonArray = jsonObject.getJsonArray("models", new io.vertx.core.json.JsonArray());
		for (int i = 0; i < jsonArray.size(); i++)  { 
			final io.vertx.core.json.JsonObject o = jsonArray.getJsonObject(i);
			if (value.getJsonObject().getString("uuid").equals(o.getString("uuid")))  { 
				jsonArray.remove(i);
				return this;
			}
		}
		return this;
	}

	public STModule clearModels() { 
		jsonObject.put("models", new io.vertx.core.json.JsonArray());
		return this;
	}

	public STModule addValues(STValue value) { 
		io.vertx.core.json.JsonArray jsonArray = jsonObject.getJsonArray("values");
		if (jsonArray == null) jsonObject.put("values", jsonArray = new io.vertx.core.json.JsonArray());
		jsonArray.add(value.getJsonObject());
		return this;
	}

	public java.util.stream.Stream<STValue> getValues() { 
		return jsonObject.getJsonArray("values", new io.vertx.core.json.JsonArray()).stream().map((o) -> new STValue((io.vertx.core.json.JsonObject) o));
	}

	public STModule removeValues(STValue value) { 
		final io.vertx.core.json.JsonArray jsonArray = jsonObject.getJsonArray("values", new io.vertx.core.json.JsonArray());
		for (int i = 0; i < jsonArray.size(); i++)  { 
			final io.vertx.core.json.JsonObject o = jsonArray.getJsonObject(i);
			if (value.getJsonObject().getString("uuid").equals(o.getString("uuid")))  { 
				jsonArray.remove(i);
				return this;
			}
		}
		return this;
	}

	public STModule clearValues() { 
		jsonObject.put("values", new io.vertx.core.json.JsonArray());
		return this;
	}


	@Override
	public java.lang.String toString() { 
		return jsonObject.encode();
	}
}