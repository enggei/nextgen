package tmp.ucs.domain.json;

public class Seat {

	private final io.vertx.core.json.JsonObject jsonObject;

	public Seat() { 
		this.jsonObject = new io.vertx.core.json.JsonObject();
		jsonObject.put("uuid", java.util.UUID.randomUUID().toString());
	}

	public Seat(io.vertx.core.json.JsonObject jsonObject) { 
		this.jsonObject = jsonObject;
		java.lang.String uuidString = jsonObject.getString("uuid");
		if (uuidString == null) jsonObject.put("uuid", java.util.UUID.randomUUID().toString());
	}

	public io.vertx.core.json.JsonObject getJsonObject() { 
		return this.jsonObject;
	}

	public Seat removeUuid() {
		this.jsonObject.remove("uuid");
		return this;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final Seat other = (Seat) o;
		return jsonObject.getString("uuid").equals(other.getJsonObject().getString("uuid"));
	}

	@Override
	public int hashCode() { 
		return java.util.Objects.hash(jsonObject.getString("uuid"));
	}

	public Seat setNo(Integer value) { 
		jsonObject.put("no", value);
		return this;
	}

	public Integer getNo() { 
		return jsonObject.getInteger("no");
	}

	public Integer getNo(Integer defaultValue) { 
		return jsonObject.getInteger("no", defaultValue);
	}

	public Seat setStatus(SeatStatus value) { 
		if (value == null) return this;
		jsonObject.put("status", value.name());
		return this;
	}

	public SeatStatus getStatus() { 
		return getStatus(null);
	}

	public SeatStatus getStatus(SeatStatus defaultValue) { 
		return jsonObject.getString("status") == null ? defaultValue : SeatStatus.valueOf(jsonObject.getString("status"));
	}

	@Override
	public java.lang.String toString() { 
		return jsonObject.encode();
	}
}