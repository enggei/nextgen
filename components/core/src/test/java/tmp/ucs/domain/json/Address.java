package tmp.ucs.domain.json;

public class Address {

	private final io.vertx.core.json.JsonObject jsonObject;

	public Address() { 
		this.jsonObject = new io.vertx.core.json.JsonObject();
		jsonObject.put("uuid", java.util.UUID.randomUUID().toString());
	}

	public Address(io.vertx.core.json.JsonObject jsonObject) { 
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
		final Address other = (Address) o;
		return jsonObject.getString("uuid").equals(other.getJsonObject().getString("uuid"));
	}

	@Override
	public int hashCode() { 
		return java.util.Objects.hash(jsonObject.getString("uuid"));
	}

	public Address setStreet(String value) { 
		jsonObject.put("street", value);
		return this;
	}

	public String getStreet() { 
		return jsonObject.getString("street");
	}

	public String getStreet(String defaultValue) { 
		return jsonObject.getString("street", defaultValue);
	}

	public Address setNo(Integer value) { 
		jsonObject.put("no", value);
		return this;
	}

	public Integer getNo() { 
		return jsonObject.getInteger("no");
	}

	public Integer getNo(Integer defaultValue) { 
		return jsonObject.getInteger("no", defaultValue);
	}

	public Address setLetter(String value) { 
		jsonObject.put("letter", value);
		return this;
	}

	public String getLetter() { 
		return jsonObject.getString("letter");
	}

	public String getLetter(String defaultValue) { 
		return jsonObject.getString("letter", defaultValue);
	}

	@Override
	public java.lang.String toString() { 
		return jsonObject.encode();
	}
}