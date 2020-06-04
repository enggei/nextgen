package nextgen.react.st;


public class ForwardRef {

	private java.lang.Object forward;
	private java.lang.Object name;
	private final java.util.UUID uuid;

	public java.lang.Object getForward() { 
		return forward;
	}

	public ForwardRef setForward(java.lang.Object forward) { 
		this.forward = forward;
		return this;
	}

	public ForwardRef removeForward() { 
		this.forward = null;
		return this;
	}

	public java.lang.Object getName() { 
		return name;
	}

	public ForwardRef setName(java.lang.Object name) { 
		this.name = name;
		return this;
	}

	public ForwardRef removeName() { 
		this.name = null;
		return this;
	}

	@Override
	public java.lang.String toString() { 
		return "ForwardRef";
	}

	public ForwardRef() { 
		this.uuid = java.util.UUID.randomUUID();
	}

	public ForwardRef(java.util.UUID uuid) { 
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() { 
		return this.uuid;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final ForwardRef other = (ForwardRef) o;
		return uuid != null ? uuid.equals(other.uuid) : other.uuid == null;
	}

	@Override
	public int hashCode() { 
		int result = uuid != null ? uuid.hashCode() : 0;
		return result;
	}
}