package nextgen.react.st;


public class Inject {

	private java.util.List<java.lang.Object> values = new java.util.ArrayList<>();
	private final java.util.UUID uuid;

	public java.util.List<java.lang.Object> getValues() { 
		return values;
	}

	public Inject addValues(java.lang.Object values) { 
		this.values.add(values);
		return this;
	}

	public Inject removeValues(java.lang.Object values) { 
		this.values.remove(values);
		return this;
	}

	@Override
	public java.lang.String toString() { 
		return "Inject";
	}

	public Inject() { 
		this.uuid = java.util.UUID.randomUUID();
	}

	public Inject(java.util.UUID uuid) { 
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() { 
		return this.uuid;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final Inject other = (Inject) o;
		return uuid != null ? uuid.equals(other.uuid) : other.uuid == null;
	}

	@Override
	public int hashCode() { 
		int result = uuid != null ? uuid.hashCode() : 0;
		return result;
	}
}