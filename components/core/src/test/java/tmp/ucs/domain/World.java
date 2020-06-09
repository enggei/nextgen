package tmp.ucs.domain;

public class World {

	private final java.util.UUID uuid;
	private java.util.List<Region> _regions;

	public World() {
		this.uuid = java.util.UUID.randomUUID();
	}

	public World(java.util.UUID uuid) {
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() {
		return this.uuid;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		World that = (World) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	public java.util.List<Region> getRegions() {
		return this._regions;
	}

	public World addRegions(Region value) {
		this._regions.add(value);
		return this;
	}
}