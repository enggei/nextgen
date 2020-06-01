package nextgen.react.st;


public class Element {

	private java.util.List<java.lang.Object> props = new java.util.ArrayList<>();
	private java.util.List<java.lang.Object> children = new java.util.ArrayList<>();
	private java.lang.Object name;
	private final java.util.UUID uuid;

	public java.util.List<java.lang.Object> getProps() { 
		return props;
	}

	public Element addProps(java.lang.Object props) { 
		this.props.add(props);
		return this;
	}

	public Element removeProps(java.lang.Object props) { 
		this.props.remove(props);
		return this;
	}

	public java.util.List<java.lang.Object> getChildren() { 
		return children;
	}

	public Element addChildren(java.lang.Object children) { 
		this.children.add(children);
		return this;
	}

	public Element removeChildren(java.lang.Object children) { 
		this.children.remove(children);
		return this;
	}

	public java.lang.Object getName() { 
		return name;
	}

	public Element setName(java.lang.Object name) { 
		this.name = name;
		return this;
	}

	public Element removeName() { 
		this.name = null;
		return this;
	}

	@Override
	public java.lang.String toString() { 
		return "Element";
	}

	public Element() { 
		this.uuid = java.util.UUID.randomUUID();
	}

	public Element(java.util.UUID uuid) { 
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() { 
		return this.uuid;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final Element other = (Element) o;
		return uuid != null ? uuid.equals(other.uuid) : other.uuid == null;
	}

	@Override
	public int hashCode() { 
		int result = uuid != null ? uuid.hashCode() : 0;
		return result;
	}
}