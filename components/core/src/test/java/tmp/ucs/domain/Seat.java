package tmp.ucs.domain;


public class Seat {

	private final java.util.UUID uuid;
	private Integer no;
	private SeatStatus status;

	public Seat() { 
		this.uuid = java.util.UUID.randomUUID();
	}

	public Seat(java.util.UUID uuid) { 
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() { 
		return uuid;
	}

	@Override
	public int hashCode() { 
		return java.util.Objects.hash(uuid);
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final Seat other = (Seat) o;
		return uuid.equals(other.uuid);
	}

	public Seat setNo(Integer no) { 
		this.no = no;
		return this;
	}

	public Integer getNo() { 
		return this.no;
	}

	public Seat setStatus(SeatStatus status) { 
		this.status = status;
		return this;
	}

	public SeatStatus getStatus() { 
		return this.status;
	}
}