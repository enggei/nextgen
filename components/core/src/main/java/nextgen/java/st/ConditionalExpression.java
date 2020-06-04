package nextgen.java.st;


public class ConditionalExpression implements Expression, LambdaBody {

	private java.lang.Object elseExpression;
	private java.lang.Object thenExpression;
	private java.lang.Object condition;
	private final java.util.UUID uuid;

	public java.lang.Object getElseExpression() { 
		return elseExpression;
	}

	public ConditionalExpression setElseExpression(java.lang.Object elseExpression) { 
		this.elseExpression = elseExpression;
		return this;
	}

	public ConditionalExpression removeElseExpression() { 
		this.elseExpression = null;
		return this;
	}

	public java.lang.Object getThenExpression() { 
		return thenExpression;
	}

	public ConditionalExpression setThenExpression(java.lang.Object thenExpression) { 
		this.thenExpression = thenExpression;
		return this;
	}

	public ConditionalExpression removeThenExpression() { 
		this.thenExpression = null;
		return this;
	}

	public java.lang.Object getCondition() { 
		return condition;
	}

	public ConditionalExpression setCondition(java.lang.Object condition) { 
		this.condition = condition;
		return this;
	}

	public ConditionalExpression removeCondition() { 
		this.condition = null;
		return this;
	}

	@Override
	public java.lang.String toString() { 
		return "ConditionalExpression";
	}

	public ConditionalExpression() { 
		this.uuid = java.util.UUID.randomUUID();
	}

	public ConditionalExpression(java.util.UUID uuid) { 
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() { 
		return this.uuid;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final ConditionalExpression other = (ConditionalExpression) o;
		return uuid != null ? uuid.equals(other.uuid) : other.uuid == null;
	}

	@Override
	public int hashCode() { 
		int result = uuid != null ? uuid.hashCode() : 0;
		return result;
	}
}