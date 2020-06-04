package nextgen.react.st;


public class Style {

	private java.util.List<StyleProperties> properties = new java.util.ArrayList<>();
	private java.lang.Object name;
	private final java.util.UUID uuid;

	public java.util.List<StyleProperties> getProperties() { 
		return properties;
	}

	public Style addProperties(StyleProperties properties) { 
		this.properties.add(properties);
		return this;
	}

	public Style removeProperties(StyleProperties properties) { 
		this.properties.remove(properties);
		return this;
	}

	public java.lang.Object getName() { 
		return name;
	}

	public Style setName(java.lang.Object name) { 
		this.name = name;
		return this;
	}

	public Style removeName() { 
		this.name = null;
		return this;
	}

	@Override
	public java.lang.String toString() { 
		return "Style";
	}

	public Style() { 
		this.uuid = java.util.UUID.randomUUID();
	}

	public Style(java.util.UUID uuid) { 
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() { 
		return this.uuid;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final Style other = (Style) o;
		return uuid != null ? uuid.equals(other.uuid) : other.uuid == null;
	}

	@Override
	public int hashCode() { 
		int result = uuid != null ? uuid.hashCode() : 0;
		return result;
	}
}