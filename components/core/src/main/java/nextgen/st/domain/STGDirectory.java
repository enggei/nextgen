package nextgen.st.domain;

public class STGDirectory {

	private final io.vertx.core.json.JsonObject jsonObject;

	public STGDirectory() { 
		this.jsonObject = new io.vertx.core.json.JsonObject();
		jsonObject.put("uuid", java.util.UUID.randomUUID().toString());
	}

	public STGDirectory(io.vertx.core.json.JsonObject jsonObject) { 
		this.jsonObject = jsonObject;
		java.lang.String uuidString = jsonObject.getString("uuid");
		if (uuidString == null) jsonObject.put("uuid", java.util.UUID.randomUUID().toString());
	}

	public io.vertx.core.json.JsonObject getJsonObject() { 
		return this.jsonObject;
	}

	public STGDirectory removeUuid() {
		this.jsonObject.remove("uuid");
		return this;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final STGDirectory other = (STGDirectory) o;
		return jsonObject.getString("uuid").equals(other.getJsonObject().getString("uuid"));
	}

	@Override
	public int hashCode() { 
		return java.util.Objects.hash(jsonObject.getString("uuid"));
	}

	public STGDirectory setPath(String value) { 
		jsonObject.put("path", value);
		return this;
	}

	public String getPath() { 
		return jsonObject.getString("path");
	}

	public String getPath(String defaultValue) { 
		return jsonObject.getString("path", defaultValue);
	}

	public STGDirectory setOutputPackage(String value) { 
		jsonObject.put("outputPackage", value);
		return this;
	}

	public String getOutputPackage() { 
		return jsonObject.getString("outputPackage");
	}

	public String getOutputPackage(String defaultValue) { 
		return jsonObject.getString("outputPackage", defaultValue);
	}

	public STGDirectory setOutputPath(String value) { 
		jsonObject.put("outputPath", value);
		return this;
	}

	public String getOutputPath() { 
		return jsonObject.getString("outputPath");
	}

	public String getOutputPath(String defaultValue) { 
		return jsonObject.getString("outputPath", defaultValue);
	}

	public STGDirectory addGroups(STGroupModel value) { 
		io.vertx.core.json.JsonArray jsonArray = jsonObject.getJsonArray("groups");
		if (jsonArray == null) jsonObject.put("groups", jsonArray = new io.vertx.core.json.JsonArray());
		jsonArray.add(value.getJsonObject());
		return this;
	}

	public java.util.stream.Stream<STGroupModel> getGroups() { 
		return jsonObject.getJsonArray("groups", new io.vertx.core.json.JsonArray()).stream().map((o) -> new STGroupModel((io.vertx.core.json.JsonObject) o));
	}

	public STGDirectory removeGroups(STGroupModel value) { 
		final io.vertx.core.json.JsonArray jsonArray = jsonObject.getJsonArray("groups", new io.vertx.core.json.JsonArray());
		for (int i = 0; i < jsonArray.size(); i++)  { 
			final io.vertx.core.json.JsonObject o = jsonArray.getJsonObject(i);
			if (value.getJsonObject().getString("uuid").equals(o.getString("uuid")))  { 
				jsonArray.remove(i);
				return this;
			}
		}
		return this;
	}

	public STGDirectory clearGroups() { 
		jsonObject.put("groups", new io.vertx.core.json.JsonArray());
		return this;
	}


	@Override
	public java.lang.String toString() { 
		return jsonObject.encode();
	}
}