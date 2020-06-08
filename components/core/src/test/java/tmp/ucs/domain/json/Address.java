package tmp.ucs.domain.json;


public class Address {

	private final io.vertx.core.json.JsonObject jsonObject;

	public Address() { 
		this.jsonObject = new io.vertx.core.json.JsonObject();
	}

	public Address(io.vertx.core.json.JsonObject jsonObject) { 
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
		final Address other = (Address) o;
		return jsonObject.equals(other.jsonObject);
	}

	@Override
	public int hashCode() { 
		return java.util.Objects.hash(jsonObject);
	}

	public Address setStreet(String value) { 
		jsonObject.put("street", value);
		return this;
	}

	public String getStreet() { 
		return jsonObject.getString("street");
	}

	public Address setNo(Integer value) { 
		jsonObject.put("no", value);
		return this;
	}

	public Integer getNo() { 
		return jsonObject.getInteger("no");
	}

	public Address setLetter(String value) { 
		jsonObject.put("letter", value);
		return this;
	}

	public String getLetter() { 
		return jsonObject.getString("letter");
	}
}