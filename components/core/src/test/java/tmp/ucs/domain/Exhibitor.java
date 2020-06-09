package tmp.ucs.domain;

public class Exhibitor {

	private final java.util.UUID uuid;
	private java.lang.String _name;
	private java.util.List<Cinema> _cinemas;

	public Exhibitor() {
		this.uuid = java.util.UUID.randomUUID();
	}

	public Exhibitor(java.util.UUID uuid) {
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() {
		return this.uuid;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Exhibitor that = (Exhibitor) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	public java.lang.String getName() {
		return this._name;
	}

	public Exhibitor setName(java.lang.String value) {
		this._name = value;
		return this;
	}

	public java.util.List<Cinema> getCinemas() {
		return this._cinemas;
	}

	public Exhibitor addCinemas(Cinema value) {
		this._cinemas.add(value);
		return this;
	}
}