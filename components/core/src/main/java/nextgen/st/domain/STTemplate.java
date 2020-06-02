package nextgen.st.domain;


public class STTemplate {

	private final io.vertx.core.json.JsonObject jsonObject;

	public STTemplate() { 
		this.jsonObject = new io.vertx.core.json.JsonObject();
		jsonObject.put("uuid", java.util.UUID.randomUUID().toString());
	}

	public STTemplate(io.vertx.core.json.JsonObject jsonObject) { 
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
		final STTemplate other = (STTemplate) o;
		return jsonObject.getString("uuid").equals(other.getJsonObject().getString("uuid"));
	}

	@Override
	public int hashCode() { 
		return java.util.Objects.hash(jsonObject.getString("uuid"));
	}

	public STTemplate setName(String value) { 
		jsonObject.put("name", value);
		return this;
	}

	public String getName() { 
		return jsonObject.getString("name");
	}

	public String getName(String defaultValue) { 
		return jsonObject.getString("name", defaultValue);
	}

	@Override
	public java.lang.String toString() { 
		return jsonObject.getString("name");
	}

	public STTemplate setText(String value) { 
		jsonObject.put("text", value);
		return this;
	}

	public String getText() { 
		return jsonObject.getString("text");
	}

	public String getText(String defaultValue) { 
		return jsonObject.getString("text", defaultValue);
	}

	public STTemplate addParameters(STParameter value) { 
		io.vertx.core.json.JsonArray jsonArray = jsonObject.getJsonArray("parameters");
		if (jsonArray == null) jsonObject.put("parameters", jsonArray = new io.vertx.core.json.JsonArray());
		jsonArray.add(value.getJsonObject());
		return this;
	}

	public java.util.stream.Stream<STParameter> getParameters() { 
		return jsonObject.getJsonArray("parameters", new io.vertx.core.json.JsonArray()).stream().map((o) -> new STParameter((io.vertx.core.json.JsonObject) o));
	}

	public STTemplate removeParameters(STParameter value) { 
		final io.vertx.core.json.JsonArray jsonArray = jsonObject.getJsonArray("parameters", new io.vertx.core.json.JsonArray());
		for (int i = 0; i < jsonArray.size(); i++)  { 
			final io.vertx.core.json.JsonObject o = jsonArray.getJsonObject(i);
			if (value.getJsonObject().getString("uuid").equals(o.getString("uuid")))  { 
				jsonArray.remove(i);
				return this;
			}
		}
		return this;
	}

	public STTemplate clearParameters() { 
		jsonObject.put("parameters", new io.vertx.core.json.JsonArray());
		return this;
	}

	public STTemplate addChildren(STTemplate value) { 
		io.vertx.core.json.JsonArray jsonArray = jsonObject.getJsonArray("children");
		if (jsonArray == null) jsonObject.put("children", jsonArray = new io.vertx.core.json.JsonArray());
		jsonArray.add(value.getJsonObject());
		return this;
	}

	public java.util.stream.Stream<STTemplate> getChildren() { 
		return jsonObject.getJsonArray("children", new io.vertx.core.json.JsonArray()).stream().map((o) -> new STTemplate((io.vertx.core.json.JsonObject) o));
	}

	public STTemplate removeChildren(STTemplate value) { 
		final io.vertx.core.json.JsonArray jsonArray = jsonObject.getJsonArray("children", new io.vertx.core.json.JsonArray());
		for (int i = 0; i < jsonArray.size(); i++)  { 
			final io.vertx.core.json.JsonObject o = jsonArray.getJsonObject(i);
			if (value.getJsonObject().getString("uuid").equals(o.getString("uuid")))  { 
				jsonArray.remove(i);
				return this;
			}
		}
		return this;
	}

	public STTemplate clearChildren() { 
		jsonObject.put("children", new io.vertx.core.json.JsonArray());
		return this;
	}
}