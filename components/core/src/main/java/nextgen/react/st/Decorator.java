package nextgen.react.st;


public class Decorator {

	private java.util.List<java.lang.Object> parameters = new java.util.ArrayList<>();
	private java.lang.Object name;
	private final java.util.UUID uuid;

	public java.util.List<java.lang.Object> getParameters() { 
		return parameters;
	}

	public Decorator addParameters(java.lang.Object parameters) { 
		this.parameters.add(parameters);
		return this;
	}

	public Decorator removeParameters(java.lang.Object parameters) { 
		this.parameters.remove(parameters);
		return this;
	}

	public java.lang.Object getName() { 
		return name;
	}

	public Decorator setName(java.lang.Object name) { 
		this.name = name;
		return this;
	}

	public Decorator removeName() { 
		this.name = null;
		return this;
	}

	@Override
	public java.lang.String toString() { 
		return "Decorator";
	}

	public Decorator() { 
		this.uuid = java.util.UUID.randomUUID();
	}

	public Decorator(java.util.UUID uuid) { 
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() { 
		return this.uuid;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final Decorator other = (Decorator) o;
		return uuid != null ? uuid.equals(other.uuid) : other.uuid == null;
	}

	@Override
	public int hashCode() { 
		int result = uuid != null ? uuid.hashCode() : 0;
		return result;
	}
}