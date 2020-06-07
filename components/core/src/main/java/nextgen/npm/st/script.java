package nextgen.npm.st;


public class script {

	private java.lang.Object name;
	private java.lang.Object command;
	private final java.util.UUID uuid;

	public java.lang.Object getName() { 
		return name;
	}

	public script setName(java.lang.Object name) { 
		this.name = name;
		return this;
	}

	public script removeName() { 
		this.name = null;
		return this;
	}

	public java.lang.Object getCommand() { 
		return command;
	}

	public script setCommand(java.lang.Object command) { 
		this.command = command;
		return this;
	}

	public script removeCommand() { 
		this.command = null;
		return this;
	}

	@Override
	public java.lang.String toString() { 
		return "script";
	}

	public script() { 
		this.uuid = java.util.UUID.randomUUID();
	}

	public script(java.util.UUID uuid) { 
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() { 
		return this.uuid;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final script other = (script) o;
		return uuid != null ? uuid.equals(other.uuid) : other.uuid == null;
	}

	@Override
	public int hashCode() { 
		int result = uuid != null ? uuid.hashCode() : 0;
		return result;
	}
}