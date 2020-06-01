package nextgen.react.st;


public class Link {

	private java.lang.Object to;
	private final java.util.UUID uuid;

	public java.lang.Object getTo() { 
		return to;
	}

	public Link setTo(java.lang.Object to) { 
		this.to = to;
		return this;
	}

	public Link removeTo() { 
		this.to = null;
		return this;
	}

	@Override
	public java.lang.String toString() { 
		return "Link";
	}

	public Link() { 
		this.uuid = java.util.UUID.randomUUID();
	}

	public Link(java.util.UUID uuid) { 
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() { 
		return this.uuid;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final Link other = (Link) o;
		return uuid != null ? uuid.equals(other.uuid) : other.uuid == null;
	}

	@Override
	public int hashCode() { 
		int result = uuid != null ? uuid.hashCode() : 0;
		return result;
	}
}