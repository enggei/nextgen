package nextgen.react.st;


public class JsonObject {

	private java.util.List<java.lang.Object> values = new java.util.ArrayList<>();
	private final java.util.UUID uuid;

	public java.util.List<java.lang.Object> getValues() { 
		return values;
	}

	public JsonObject addValues(java.lang.Object values) { 
		this.values.add(values);
		return this;
	}

	public JsonObject removeValues(java.lang.Object values) { 
		this.values.remove(values);
		return this;
	}

	@Override
	public java.lang.String toString() { 
		return "JsonObject";
	}

	public JsonObject() { 
		this.uuid = java.util.UUID.randomUUID();
	}

	public JsonObject(java.util.UUID uuid) { 
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() { 
		return this.uuid;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final JsonObject other = (JsonObject) o;
		return uuid != null ? uuid.equals(other.uuid) : other.uuid == null;
	}

	@Override
	public int hashCode() { 
		int result = uuid != null ? uuid.hashCode() : 0;
		return result;
	}
}