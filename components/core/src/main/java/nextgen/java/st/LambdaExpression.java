package nextgen.java.st;


public class LambdaExpression implements Expression, LambdaBody {

	private java.util.List<Parameter> parameters = new java.util.ArrayList<>();
	private LambdaBody body;
	private final java.util.UUID uuid;

	public java.util.List<Parameter> getParameters() { 
		return parameters;
	}

	public LambdaExpression addParameters(Parameter parameters) { 
		this.parameters.add(parameters);
		return this;
	}

	public LambdaExpression removeParameters(Parameter parameters) { 
		this.parameters.remove(parameters);
		return this;
	}

	public LambdaBody getBody() { 
		return body;
	}

	public LambdaExpression setBody(LambdaBody body) { 
		this.body = body;
		return this;
	}

	public LambdaExpression removeBody() { 
		this.body = null;
		return this;
	}

	@Override
	public java.lang.String toString() { 
		return "LambdaExpression";
	}

	public LambdaExpression() { 
		this.uuid = java.util.UUID.randomUUID();
	}

	public LambdaExpression(java.util.UUID uuid) { 
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() { 
		return this.uuid;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final LambdaExpression other = (LambdaExpression) o;
		return uuid != null ? uuid.equals(other.uuid) : other.uuid == null;
	}

	@Override
	public int hashCode() { 
		int result = uuid != null ? uuid.hashCode() : 0;
		return result;
	}
}