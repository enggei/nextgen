package nextgen.react.st;


public class MaterialUIGroup {

	private java.util.List<java.lang.Object> elements = new java.util.ArrayList<>();
	private java.lang.Object packageName;
	private final java.util.UUID uuid;

	public java.util.List<java.lang.Object> getElements() { 
		return elements;
	}

	public MaterialUIGroup addElements(java.lang.Object elements) { 
		this.elements.add(elements);
		return this;
	}

	public MaterialUIGroup removeElements(java.lang.Object elements) { 
		this.elements.remove(elements);
		return this;
	}

	public java.lang.Object getPackageName() { 
		return packageName;
	}

	public MaterialUIGroup setPackageName(java.lang.Object packageName) { 
		this.packageName = packageName;
		return this;
	}

	public MaterialUIGroup removePackageName() { 
		this.packageName = null;
		return this;
	}

	@Override
	public java.lang.String toString() { 
		return "MaterialUIGroup";
	}

	public MaterialUIGroup() { 
		this.uuid = java.util.UUID.randomUUID();
	}

	public MaterialUIGroup(java.util.UUID uuid) { 
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() { 
		return this.uuid;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final MaterialUIGroup other = (MaterialUIGroup) o;
		return uuid != null ? uuid.equals(other.uuid) : other.uuid == null;
	}

	@Override
	public int hashCode() { 
		int result = uuid != null ? uuid.hashCode() : 0;
		return result;
	}
}