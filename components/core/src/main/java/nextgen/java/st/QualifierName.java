package nextgen.java.st;


public class QualifierName {

	private java.util.List<java.lang.Object> value = new java.util.ArrayList<>();
	private final java.util.UUID uuid;

	public java.util.List<java.lang.Object> getValue() { 
		return value;
	}

	public QualifierName addValue(java.lang.Object value) { 
		this.value.add(value);
		return this;
	}

	public QualifierName removeValue(java.lang.Object value) { 
		this.value.remove(value);
		return this;
	}

	@Override
	public java.lang.String toString() { 
		return "QualifierName";
	}

	public QualifierName() { 
		this.uuid = java.util.UUID.randomUUID();
	}

	public QualifierName(java.util.UUID uuid) { 
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() { 
		return this.uuid;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final QualifierName other = (QualifierName) o;
		return uuid != null ? uuid.equals(other.uuid) : other.uuid == null;
	}

	@Override
	public int hashCode() { 
		int result = uuid != null ? uuid.hashCode() : 0;
		return result;
	}
}