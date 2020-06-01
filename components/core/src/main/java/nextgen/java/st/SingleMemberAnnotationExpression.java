package nextgen.java.st;


public class SingleMemberAnnotationExpression implements AnnotationExpression, Expression, LambdaBody {

	private ClassOrInterfaceType name;
	private java.util.List<java.lang.Object> members = new java.util.ArrayList<>();
	private final java.util.UUID uuid;

	public ClassOrInterfaceType getName() { 
		return name;
	}

	public SingleMemberAnnotationExpression setName(ClassOrInterfaceType name) { 
		this.name = name;
		return this;
	}

	public SingleMemberAnnotationExpression removeName() { 
		this.name = null;
		return this;
	}

	public java.util.List<java.lang.Object> getMembers() { 
		return members;
	}

	public SingleMemberAnnotationExpression addMembers(java.lang.Object members) { 
		this.members.add(members);
		return this;
	}

	public SingleMemberAnnotationExpression removeMembers(java.lang.Object members) { 
		this.members.remove(members);
		return this;
	}

	@Override
	public java.lang.String toString() { 
		return "SingleMemberAnnotationExpression";
	}

	public SingleMemberAnnotationExpression() { 
		this.uuid = java.util.UUID.randomUUID();
	}

	public SingleMemberAnnotationExpression(java.util.UUID uuid) { 
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() { 
		return this.uuid;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final SingleMemberAnnotationExpression other = (SingleMemberAnnotationExpression) o;
		return uuid != null ? uuid.equals(other.uuid) : other.uuid == null;
	}

	@Override
	public int hashCode() { 
		int result = uuid != null ? uuid.hashCode() : 0;
		return result;
	}
}