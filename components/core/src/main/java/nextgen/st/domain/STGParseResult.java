package nextgen.st.domain;


public class STGParseResult {

	private final java.util.UUID uuid;
	private STGroupModel parsed;
	private final java.util.List<STGError> errors = new java.util.ArrayList<>();

	public STGParseResult() { 
		this.uuid = java.util.UUID.randomUUID();
	}

	public STGParseResult(java.util.UUID uuid) { 
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() { 
		return uuid;
	}

	@Override
	public int hashCode() { 
		return java.util.Objects.hash(uuid);
	}

	@Override
	public boolean equals(java.lang.Object o) { 
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final STGParseResult other = (STGParseResult) o;
		return uuid.equals(other.uuid);
	}

	public STGParseResult setParsed(STGroupModel parsed) { 
		this.parsed = parsed;
		return this;
	}

	public STGroupModel getParsed() { 
		return this.parsed;
	}

	public STGParseResult addErrors(STGError value) { 
		errors.add(value);
		return this;
	}

	public java.util.List<STGError> getErrors() { 
		return this.errors;
	}
}