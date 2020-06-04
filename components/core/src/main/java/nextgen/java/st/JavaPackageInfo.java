package nextgen.java.st;


public class JavaPackageInfo {

	private java.util.List<java.lang.Object> interfaces = new java.util.ArrayList<>();
	private java.lang.Object packageName;
	private java.util.List<java.lang.Object> classes = new java.util.ArrayList<>();
	private final java.util.UUID uuid;

	public java.util.List<java.lang.Object> getInterfaces() { 
		return interfaces;
	}

	public JavaPackageInfo addInterfaces(java.lang.Object interfaces) { 
		this.interfaces.add(interfaces);
		return this;
	}

	public JavaPackageInfo removeInterfaces(java.lang.Object interfaces) { 
		this.interfaces.remove(interfaces);
		return this;
	}

	public java.lang.Object getPackageName() { 
		return packageName;
	}

	public JavaPackageInfo setPackageName(java.lang.Object packageName) { 
		this.packageName = packageName;
		return this;
	}

	public JavaPackageInfo removePackageName() { 
		this.packageName = null;
		return this;
	}

	public java.util.List<java.lang.Object> getClasses() { 
		return classes;
	}

	public JavaPackageInfo addClasses(java.lang.Object classes) { 
		this.classes.add(classes);
		return this;
	}

	public JavaPackageInfo removeClasses(java.lang.Object classes) { 
		this.classes.remove(classes);
		return this;
	}

	@Override
	public java.lang.String toString() { 
		return "JavaPackageInfo";
	}

	public JavaPackageInfo() { 
		this.uuid = java.util.UUID.randomUUID();
	}

	public JavaPackageInfo(java.util.UUID uuid) { 
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() { 
		return this.uuid;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final JavaPackageInfo other = (JavaPackageInfo) o;
		return uuid != null ? uuid.equals(other.uuid) : other.uuid == null;
	}

	@Override
	public int hashCode() { 
		int result = uuid != null ? uuid.hashCode() : 0;
		return result;
	}
}