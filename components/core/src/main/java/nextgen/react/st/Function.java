package nextgen.react.st;


public class Function {

	private java.lang.Object name;
	private java.lang.Object body;
	private java.util.List<java.lang.Object> parameters = new java.util.ArrayList<>();
	private final java.util.UUID uuid;

	public java.lang.Object getName() { 
		return name;
	}

	public Function setName(java.lang.Object name) { 
		this.name = name;
		return this;
	}

	public Function removeName() { 
		this.name = null;
		return this;
	}

	public java.lang.Object getBody() { 
		return body;
	}

	public Function setBody(java.lang.Object body) { 
		this.body = body;
		return this;
	}

	public Function removeBody() { 
		this.body = null;
		return this;
	}

	public java.util.List<java.lang.Object> getParameters() { 
		return parameters;
	}

	public Function addParameters(java.lang.Object parameters) { 
		this.parameters.add(parameters);
		return this;
	}

	public Function removeParameters(java.lang.Object parameters) { 
		this.parameters.remove(parameters);
		return this;
	}

	@Override
	public java.lang.String toString() { 
		return "Function";
	}

	public Function() { 
		this.uuid = java.util.UUID.randomUUID();
	}

	public Function(java.util.UUID uuid) { 
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() { 
		return this.uuid;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final Function other = (Function) o;
		return uuid != null ? uuid.equals(other.uuid) : other.uuid == null;
	}

	@Override
	public int hashCode() { 
		int result = uuid != null ? uuid.hashCode() : 0;
		return result;
	}
}