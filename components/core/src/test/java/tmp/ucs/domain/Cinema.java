package tmp.ucs.domain;

public class Cinema {

	private final java.util.UUID uuid;
	private String _name;
	private java.util.List<String> _aliases;
	private Address _address;
	private java.util.List<Screen> _screens = new java.util.ArrayList<>();

	public Cinema() {
		this.uuid = java.util.UUID.randomUUID();
	}

	public Cinema(java.util.UUID uuid) {
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() {
		return this.uuid;
	}	

	public String getName() {
		return this._name;
	}

	public Cinema setName(String value) {
		this._name = value;
		return this;
	}

	public java.util.List<String> getAliases() {
		return this._aliases;
	}

	public Cinema addAliases(String value) {
		this._aliases.add(value);
		return this;
	}

	public Address getAddress() {
		return this._address;
	}

	public Cinema setAddress(Address value) {
		this._address = value;
		return this;
	}

	public Cinema removeAddress() {
		this._address = null;
		return this;
	}

	public java.util.List<Screen> getScreens() {
		return this._screens;
	}

	public Cinema addScreens(Screen value) {
		this._screens.add(value);
		return this;
	}
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Cinema that = (Cinema) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}
}