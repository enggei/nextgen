package tmp.ucs.domain;

public class Screen {

	private final java.util.UUID uuid;
	private String _name;
	private ScreenStatus _status;
	private Boolean _active;
	private java.util.List<Seat> _seats = new java.util.ArrayList<>();

	public Screen() {
		this.uuid = java.util.UUID.randomUUID();
	}

	public Screen(java.util.UUID uuid) {
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() {
		return this.uuid;
	}	

	public String getName() {
		return this._name;
	}

	public Screen setName(String value) {
		this._name = value;
		return this;
	}

	public ScreenStatus getStatus() {
		return this._status;
	}

	public Screen setStatus(ScreenStatus value) {
		this._status = value;
		return this;
	}

	public Boolean getActive() {
		return this._active;
	}

	public Screen setActive(Boolean value) {
		this._active = value;
		return this;
	}

	public java.util.List<Seat> getSeats() {
		return this._seats;
	}

	public Screen addSeats(Seat value) {
		this._seats.add(value);
		return this;
	}
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Screen that = (Screen) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}
}