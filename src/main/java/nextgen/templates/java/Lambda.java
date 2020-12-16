package nextgen.templates.java;

public class Lambda {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _expression;
	private java.util.List<Object> _input = new java.util.ArrayList<>();

	Lambda(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("Lambda");
		st.add("expression", _expression);
		for (Object o : _input) st.add("input", o);
		return st.render().trim();
	}

	public Lambda setExpression(Object value) {
		this._expression = value;
		return this;
	}

	public Object getExpression() {
		return this._expression;
	}

	public Object getExpression(Object defaultValue) {
		return this._expression == null ? defaultValue : this._expression;
	}

	public boolean hasExpression() {
		return this._expression != null;
	}

	public Lambda removeExpression() {
		this._expression = null;
		return this;
	} 

	public Lambda addInput(Object value) {
		this._input.add(value);
		return this;
	}

	public Lambda setInput(Object[] value) {
		this._input.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public Lambda setInput(java.util.Collection<Object> values) {
		this._input.addAll(values);
		return this;
	}

	public Lambda removeInput(Object value) {
		this._input.remove(value);
		return this;
	}

	public Lambda removeInput(int index) {
		this._input.remove(index);
		return this;
	}

	public java.util.List<Object> getInput() {
		return this._input;
	} 


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Lambda that = (Lambda) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "Lambda(input,expression) ::= <<(~input:{it|~it~};separator=\", \"~) -> ~expression~ >>";
}  