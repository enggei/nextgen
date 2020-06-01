package nextgen.react.st;


public class StyleComponent {

	private java.util.List<java.lang.Object> elements = new java.util.ArrayList<>();
	private final java.util.UUID uuid;

	public java.util.List<java.lang.Object> getElements() { 
		return elements;
	}

	public StyleComponent addElements(java.lang.Object elements) { 
		this.elements.add(elements);
		return this;
	}

	public StyleComponent removeElements(java.lang.Object elements) { 
		this.elements.remove(elements);
		return this;
	}

	@Override
	public java.lang.String toString() { 
		return "StyleComponent";
	}

	public StyleComponent() { 
		this.uuid = java.util.UUID.randomUUID();
	}

	public StyleComponent(java.util.UUID uuid) { 
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() { 
		return this.uuid;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final StyleComponent other = (StyleComponent) o;
		return uuid != null ? uuid.equals(other.uuid) : other.uuid == null;
	}

	@Override
	public int hashCode() { 
		int result = uuid != null ? uuid.hashCode() : 0;
		return result;
	}
}