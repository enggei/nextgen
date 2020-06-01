package nextgen.maven.st;


public class shadePlugin {

	private java.lang.Object className;
	private java.lang.Object packageName;
	private final java.util.UUID uuid;

	public java.lang.Object getClassName() { 
		return className;
	}

	public shadePlugin setClassName(java.lang.Object className) { 
		this.className = className;
		return this;
	}

	public shadePlugin removeClassName() { 
		this.className = null;
		return this;
	}

	public java.lang.Object getPackageName() { 
		return packageName;
	}

	public shadePlugin setPackageName(java.lang.Object packageName) { 
		this.packageName = packageName;
		return this;
	}

	public shadePlugin removePackageName() { 
		this.packageName = null;
		return this;
	}

	@Override
	public java.lang.String toString() { 
		return "shadePlugin";
	}

	public shadePlugin() { 
		this.uuid = java.util.UUID.randomUUID();
	}

	public shadePlugin(java.util.UUID uuid) { 
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() { 
		return this.uuid;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final shadePlugin other = (shadePlugin) o;
		return uuid != null ? uuid.equals(other.uuid) : other.uuid == null;
	}

	@Override
	public int hashCode() { 
		int result = uuid != null ? uuid.hashCode() : 0;
		return result;
	}
}