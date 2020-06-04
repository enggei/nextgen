package nextgen.java.st;


public class MemberValuePair {

	private java.lang.String name;
	private java.lang.Object value;
	private final java.util.UUID uuid;

	public java.lang.String getName() { 
		return name;
	}

	public MemberValuePair setName(java.lang.String name) { 
		this.name = name;
		return this;
	}

	public MemberValuePair removeName() { 
		this.name = null;
		return this;
	}

	@Override
	public java.lang.String toString() { 
		return name;
	}

	public java.lang.Object getValue() { 
		return value;
	}

	public MemberValuePair setValue(java.lang.Object value) { 
		this.value = value;
		return this;
	}

	public MemberValuePair removeValue() { 
		this.value = null;
		return this;
	}

	public MemberValuePair() { 
		this.uuid = java.util.UUID.randomUUID();
	}

	public MemberValuePair(java.util.UUID uuid) { 
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() { 
		return this.uuid;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final MemberValuePair other = (MemberValuePair) o;
		return uuid != null ? uuid.equals(other.uuid) : other.uuid == null;
	}

	@Override
	public int hashCode() { 
		int result = uuid != null ? uuid.hashCode() : 0;
		return result;
	}
}