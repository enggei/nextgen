package nextgen.react.st;


public class App {

	private java.util.List<AppComponents> components = new java.util.ArrayList<>();
	private final java.util.UUID uuid;

	public java.util.List<AppComponents> getComponents() { 
		return components;
	}

	public App addComponents(AppComponents components) { 
		this.components.add(components);
		return this;
	}

	public App removeComponents(AppComponents components) { 
		this.components.remove(components);
		return this;
	}

	@Override
	public java.lang.String toString() { 
		return "App";
	}

	public App() { 
		this.uuid = java.util.UUID.randomUUID();
	}

	public App(java.util.UUID uuid) { 
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() { 
		return this.uuid;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final App other = (App) o;
		return uuid != null ? uuid.equals(other.uuid) : other.uuid == null;
	}

	@Override
	public int hashCode() { 
		int result = uuid != null ? uuid.hashCode() : 0;
		return result;
	}
}