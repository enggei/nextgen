package nextgen.templates.kotlin;

public class EnumField {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private String _name;
	private java.util.List<Expression> _inputs = new java.util.ArrayList<>();

	EnumField(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Deprecated
	public java.util.UUID uuid() {
		return uuid;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("EnumField");
		st.add("name", _name);
		for (Object o : _inputs) st.add("inputs", o);
		return st.render().trim();
	}

	public EnumField setName(String value) {
		this._name = value;
		return this;
	}

	public String getName() {
		return this._name;
	}

	public String getName(String defaultValue) {
		return this._name == null ? defaultValue : this._name;
	}

	public boolean hasName() {
		return this._name != null;
	}

	public EnumField removeName() {
		this._name = null;
		return this;
	} 

	public EnumField addInputs(Expression value) {
		this._inputs.add(value);
		return this;
	}

	public EnumField setInputs(Expression[] value) {
		this._inputs.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public EnumField setInputs(java.util.Collection<Expression> values) {
		this._inputs.addAll(values);
		return this;
	}

	public EnumField removeInputs(Expression value) {
		this._inputs.remove(value);
		return this;
	}

	public EnumField removeInputs(int index) {
		this._inputs.remove(index);
		return this;
	}

	public java.util.List<Expression> getInputs() {
		return this._inputs;
	} 


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		EnumField that = (EnumField) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "EnumField(name,inputs) ::= <<~name~~if(inputs)~(~inputs:{it|~it~};separator=\", \"~)~endif~ >>";
}  