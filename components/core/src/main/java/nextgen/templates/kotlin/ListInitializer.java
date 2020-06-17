package nextgen.templates.kotlin;

public class ListInitializer implements Initializer {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private java.util.List<String> _statements = new java.util.ArrayList<>();

	ListInitializer(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("ListInitializer");
		for (Object o : _statements) st.add("statements", o);
		return st.render().trim();
	}


	public ListInitializer addStatements(String value) {
		this._statements.add(value);
		return this;
	}

	public ListInitializer setStatements(String[] value) {
		this._statements.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public ListInitializer setStatements(java.util.Collection<String> values) {
		this._statements.addAll(values);
		return this;
	}

	public ListInitializer removeStatements(String value) {
		this._statements.remove(value);
		return this;
	}

	public ListInitializer removeStatements(int index) {
		this._statements.remove(index);
		return this;
	}

	public java.util.List<String> getStatements() {
		return this._statements;
	} 


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ListInitializer that = (ListInitializer) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "ListInitializer(statements) ::= <<listOf(~statements:{it|~it~};separator=\", \"~) >>";
} 