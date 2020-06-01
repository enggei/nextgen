package nextgen.st.domain;


public class STGError {

	private final java.util.UUID uuid;
	private STGErrorType type;
	private org.stringtemplate.v4.misc.STMessage message;

	public STGError() { 
		this.uuid = java.util.UUID.randomUUID();
	}

	public STGError(java.util.UUID uuid) { 
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() { 
		return uuid;
	}

	@Override
	public int hashCode() { 
		return java.util.Objects.hash(uuid);
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final STGError other = (STGError) o;
		return uuid.equals(other.uuid);
	}

	public STGError setType(STGErrorType type) { 
		this.type = type;
		return this;
	}

	public STGErrorType getType() { 
		return this.type;
	}

	public STGError setMessage(org.stringtemplate.v4.misc.STMessage message) { 
		this.message = message;
		return this;
	}

	public org.stringtemplate.v4.misc.STMessage getMessage() { 
		return this.message;
	}
}