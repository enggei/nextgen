package tmp.ucs.domain.json;


public class Seat {

	private final io.vertx.core.json.JsonObject jsonObject;

	public Seat() { 
		this.jsonObject = new io.vertx.core.json.JsonObject();
	}

	public Seat(io.vertx.core.json.JsonObject jsonObject) { 
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
		final Seat other = (Seat) o;
		return jsonObject.equals(other.jsonObject);
	}

	@Override
	public int hashCode() { 
		return java.util.Objects.hash(jsonObject);
	}

	public Seat setNo(Integer value) { 
		jsonObject.put("no", value);
		return this;
	}

	public Integer getNo() { 
		return jsonObject.getInteger("no");
	}

	public Seat setStatus(SeatStatus value) { 
		jsonObject.put("status", value.name());
		return this;
	}

	public SeatStatus getStatus() { 
		return jsonObject.getString("status") == null ? null : SeatStatus.valueOf(jsonObject.getString("status"));
	}
}