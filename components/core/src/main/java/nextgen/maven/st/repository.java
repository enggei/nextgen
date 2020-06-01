package nextgen.maven.st;


public class repository {

	private java.lang.Object url;
	private java.lang.Object id;
	private java.lang.String name;
	private final java.util.UUID uuid;

	public java.lang.Object getUrl() { 
		return url;
	}

	public repository setUrl(java.lang.Object url) { 
		this.url = url;
		return this;
	}

	public repository removeUrl() { 
		this.url = null;
		return this;
	}

	public java.lang.Object getId() { 
		return id;
	}

	public repository setId(java.lang.Object id) { 
		this.id = id;
		return this;
	}

	public repository removeId() { 
		this.id = null;
		return this;
	}

	public java.lang.String getName() { 
		return name;
	}

	public repository setName(java.lang.String name) { 
		this.name = name;
		return this;
	}

	public repository removeName() { 
		this.name = null;
		return this;
	}

	@Override
	public java.lang.String toString() { 
		return name;
	}

	public repository() { 
		this.uuid = java.util.UUID.randomUUID();
	}

	public repository(java.util.UUID uuid) { 
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() { 
		return this.uuid;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final repository other = (repository) o;
		return uuid != null ? uuid.equals(other.uuid) : other.uuid == null;
	}

	@Override
	public int hashCode() { 
		int result = uuid != null ? uuid.hashCode() : 0;
		return result;
	}
}