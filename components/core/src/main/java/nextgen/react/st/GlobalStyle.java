package nextgen.react.st;


public class GlobalStyle {

	private java.lang.Object name;
	private java.util.List<GlobalStyleProperties> properties = new java.util.ArrayList<>();
	private final java.util.UUID uuid;

	public java.lang.Object getName() { 
		return name;
	}

	public GlobalStyle setName(java.lang.Object name) { 
		this.name = name;
		return this;
	}

	public GlobalStyle removeName() { 
		this.name = null;
		return this;
	}

	public java.util.List<GlobalStyleProperties> getProperties() { 
		return properties;
	}

	public GlobalStyle addProperties(GlobalStyleProperties properties) { 
		this.properties.add(properties);
		return this;
	}

	public GlobalStyle removeProperties(GlobalStyleProperties properties) { 
		this.properties.remove(properties);
		return this;
	}

	@Override
	public java.lang.String toString() { 
		return "GlobalStyle";
	}

	public GlobalStyle() { 
		this.uuid = java.util.UUID.randomUUID();
	}

	public GlobalStyle(java.util.UUID uuid) { 
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() { 
		return this.uuid;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final GlobalStyle other = (GlobalStyle) o;
		return uuid != null ? uuid.equals(other.uuid) : other.uuid == null;
	}

	@Override
	public int hashCode() { 
		int result = uuid != null ? uuid.hashCode() : 0;
		return result;
	}
}