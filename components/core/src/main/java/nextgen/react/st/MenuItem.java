package nextgen.react.st;


public class MenuItem {

	private java.lang.Object title;
	private java.lang.Object name;
	private final java.util.UUID uuid;

	public java.lang.Object getTitle() { 
		return title;
	}

	public MenuItem setTitle(java.lang.Object title) { 
		this.title = title;
		return this;
	}

	public MenuItem removeTitle() { 
		this.title = null;
		return this;
	}

	public java.lang.Object getName() { 
		return name;
	}

	public MenuItem setName(java.lang.Object name) { 
		this.name = name;
		return this;
	}

	public MenuItem removeName() { 
		this.name = null;
		return this;
	}

	@Override
	public java.lang.String toString() { 
		return "MenuItem";
	}

	public MenuItem() { 
		this.uuid = java.util.UUID.randomUUID();
	}

	public MenuItem(java.util.UUID uuid) { 
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() { 
		return this.uuid;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final MenuItem other = (MenuItem) o;
		return uuid != null ? uuid.equals(other.uuid) : other.uuid == null;
	}

	@Override
	public int hashCode() { 
		int result = uuid != null ? uuid.hashCode() : 0;
		return result;
	}
}