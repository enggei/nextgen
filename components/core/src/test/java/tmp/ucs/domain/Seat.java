package tmp.ucs.domain;

public class Seat {

	private final java.util.UUID uuid;
	private Integer _no;
	private SeatStatus _status;

	public Seat() {
		this.uuid = java.util.UUID.randomUUID();
	}

	public Seat(java.util.UUID uuid) {
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() {
		return this.uuid;
	}	

	public Integer getNo() {
		return this._no;
	}

	public Seat setNo(Integer value) {
		this._no = value;
		return this;
	}

	public SeatStatus getStatus() {
		return this._status;
	}

	public Seat setStatus(SeatStatus value) {
		this._status = value;
		return this;
	}
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Seat that = (Seat) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}
}