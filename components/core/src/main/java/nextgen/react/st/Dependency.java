package nextgen.react.st;


public class Dependency {

	private java.lang.Object value;
	private java.lang.Object packageName;
	private final java.util.UUID uuid;

	public java.lang.Object getValue() { 
		return value;
	}

	public Dependency setValue(java.lang.Object value) { 
		this.value = value;
		return this;
	}

	public Dependency removeValue() { 
		this.value = null;
		return this;
	}

	public java.lang.Object getPackageName() { 
		return packageName;
	}

	public Dependency setPackageName(java.lang.Object packageName) { 
		this.packageName = packageName;
		return this;
	}

	public Dependency removePackageName() { 
		this.packageName = null;
		return this;
	}

	@Override
	public java.lang.String toString() { 
		return "Dependency";
	}

	public Dependency() { 
		this.uuid = java.util.UUID.randomUUID();
	}

	public Dependency(java.util.UUID uuid) { 
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() { 
		return this.uuid;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final Dependency other = (Dependency) o;
		return uuid != null ? uuid.equals(other.uuid) : other.uuid == null;
	}

	@Override
	public int hashCode() { 
		int result = uuid != null ? uuid.hashCode() : 0;
		return result;
	}
}