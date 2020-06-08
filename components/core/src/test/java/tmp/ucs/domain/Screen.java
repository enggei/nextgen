package tmp.ucs.domain;


public class Screen {

	private final java.util.UUID uuid;
	private String name;
	private ScreenStatus status;
	private Boolean active;
	private final java.util.List<Seat> seats = new java.util.ArrayList<>();

	public Screen() { 
		this.uuid = java.util.UUID.randomUUID();
	}

	public Screen(java.util.UUID uuid) { 
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
		final Screen other = (Screen) o;
		return uuid.equals(other.uuid);
	}

	public Screen setName(String name) { 
		this.name = name;
		return this;
	}

	public String getName() { 
		return this.name;
	}

	@Override
	public java.lang.String toString() { 
		return name == null ? null : name;
	}

	public Screen setStatus(ScreenStatus status) { 
		this.status = status;
		return this;
	}

	public ScreenStatus getStatus() { 
		return this.status;
	}

	public Screen setActive(Boolean active) { 
		this.active = active;
		return this;
	}

	public Boolean getActive() { 
		return this.active;
	}

	public Screen addSeats(Seat value) { 
		seats.add(value);
		return this;
	}

	public java.util.List<Seat> getSeats() { 
		return this.seats;
	}
}