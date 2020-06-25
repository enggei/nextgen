package nextgen.st.model;

public class STModel {

	private final io.vertx.core.json.JsonObject jsonObject;

	public STModel() { 
		this.jsonObject = new io.vertx.core.json.JsonObject();
		jsonObject.put("uuid", java.util.UUID.randomUUID().toString());
	}

	public STModel(io.vertx.core.json.JsonObject jsonObject) { 
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

	public STModel removeUuid() {
		this.jsonObject.remove("uuid");
		return this;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final STModel other = (STModel) o;
		return jsonObject.getString("uuid").equals(other.getJsonObject().getString("uuid"));
	}

	@Override
	public int hashCode() { 
		return java.util.Objects.hash(jsonObject.getString("uuid"));
	}

	public STModel setStTemplate(String value) { 
		jsonObject.put("stTemplate", value);
		return this;
	}

	public String getStTemplate() { 
		return jsonObject.getString("stTemplate");
	}

	public String getStTemplate(String defaultValue) { 
		return jsonObject.getString("stTemplate", defaultValue);
	}

	public STModel addArguments(STArgument value) { 
		io.vertx.core.json.JsonArray jsonArray = jsonObject.getJsonArray("arguments");
		if (jsonArray == null) jsonObject.put("arguments", jsonArray = new io.vertx.core.json.JsonArray());
		jsonArray.add(value.getJsonObject());
		return this;
	}

	public java.util.stream.Stream<STArgument> getArguments() { 
		return jsonObject.getJsonArray("arguments", new io.vertx.core.json.JsonArray()).stream().map((o) -> new STArgument((io.vertx.core.json.JsonObject) o));
	}

	public STModel removeArguments(STArgument value) { 
		final io.vertx.core.json.JsonArray jsonArray = jsonObject.getJsonArray("arguments", new io.vertx.core.json.JsonArray());
		for (int i = 0; i < jsonArray.size(); i++)  { 
			final io.vertx.core.json.JsonObject o = jsonArray.getJsonObject(i);
			if (value.getJsonObject().getString("uuid").equals(o.getString("uuid")))  { 
				jsonArray.remove(i);
				return this;
			}
		}
		return this;
	}

	public STModel clearArguments() { 
		jsonObject.put("arguments", new io.vertx.core.json.JsonArray());
		return this;
	}


	@Override
	public java.lang.String toString() { 
		return jsonObject.encode();
	}
}