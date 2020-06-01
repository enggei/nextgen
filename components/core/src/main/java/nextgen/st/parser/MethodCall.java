package nextgen.st.parser;


public class MethodCall {

	private String name;
	private final java.util.Set<String> arguments = new java.util.LinkedHashSet<>();
	private final java.util.UUID uuid;

	@Override
	public String toString() {
		return name;
	}

	public String getName() {
		return name;
	}

	public Boolean hasName() {
		return name != null;
	}

	public MethodCall setName(String name) {
		this.name = name;
		return this;
	}

	public java.util.Set<String> getArguments() {
		return arguments;
	}

	public MethodCall addArguments(String arguments) {
		this.arguments.add(arguments);
		return this;
	}

	public MethodCall() {
		this.uuid = java.util.UUID.randomUUID();
	}

	public MethodCall(java.util.UUID uuid) {
		this.uuid = uuid;
	}

	public java.util.UUID getUuid() {
		return this.uuid;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final MethodCall other = (MethodCall) o;
		return uuid != null ? uuid.equals(other.uuid) : other.uuid == null;
	}

	@Override
	public int hashCode() { 
		int result = uuid != null ? uuid.hashCode() : 0;
		return result;
	}
}