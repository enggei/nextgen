package nextgen.java.st;


public class NormalAnnotationExpression implements AnnotationExpression, Expression, LambdaBody {

	private java.lang.String name;
	private java.util.List<java.lang.Object> memberValues = new java.util.ArrayList<>();
	private final java.util.UUID uuid;

	public java.lang.String getName() { 
		return name;
	}

	public NormalAnnotationExpression setName(java.lang.String name) { 
		this.name = name;
		return this;
	}

	public NormalAnnotationExpression removeName() { 
		this.name = null;
		return this;
	}

	@Override
	public java.lang.String toString() { 
		return name;
	}

	public java.util.List<java.lang.Object> getMemberValues() { 
		return memberValues;
	}

	public NormalAnnotationExpression addMemberValues(java.lang.Object memberValues) { 
		this.memberValues.add(memberValues);
		return this;
	}

	public NormalAnnotationExpression removeMemberValues(java.lang.Object memberValues) { 
		this.memberValues.remove(memberValues);
		return this;
	}

	public NormalAnnotationExpression() { 
		this.uuid = java.util.UUID.randomUUID();
	}

	public NormalAnnotationExpression(java.util.UUID uuid) { 
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() { 
		return this.uuid;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final NormalAnnotationExpression other = (NormalAnnotationExpression) o;
		return uuid != null ? uuid.equals(other.uuid) : other.uuid == null;
	}

	@Override
	public int hashCode() { 
		int result = uuid != null ? uuid.hashCode() : 0;
		return result;
	}
}