package org.test;

public class Capitol {

	private final java.util.UUID uuid;
	private String _name;

	public Capitol() {
		this.uuid = java.util.UUID.randomUUID();
	}

	public Capitol(java.util.UUID uuid) {
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() {
		return this.uuid;
	}	

	public String getName() {
		return this._name;
	}

	public Capitol setName(String value) {
		this._name = value;
		return this;
	}
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Capitol that = (Capitol) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}
}