package nextgen.react.st;


public class State {

	private java.util.List<StateValues> values = new java.util.ArrayList<>();
	private final java.util.UUID uuid;

	public java.util.List<StateValues> getValues() { 
		return values;
	}

	public State addValues(StateValues values) { 
		this.values.add(values);
		return this;
	}

	public State removeValues(StateValues values) { 
		this.values.remove(values);
		return this;
	}

	@Override
	public java.lang.String toString() { 
		return "State";
	}

	public State() { 
		this.uuid = java.util.UUID.randomUUID();
	}

	public State(java.util.UUID uuid) { 
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() { 
		return this.uuid;
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final State other = (State) o;
		return uuid != null ? uuid.equals(other.uuid) : other.uuid == null;
	}

	@Override
	public int hashCode() { 
		int result = uuid != null ? uuid.hashCode() : 0;
		return result;
	}
}