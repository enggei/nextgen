package nextgen.templates.javascript;

public class Function {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _name;
	private java.util.List<Object> _parameters = new java.util.ArrayList<>();
	private java.util.List<Object> _statements = new java.util.ArrayList<>();

	Function(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("Function");
		st.add("name", _name);
		for (Object o : _parameters) st.add("parameters", o);
		for (Object o : _statements) st.add("statements", o);
		return st.render().trim();
	}

	public Function setName(Object value) {
		this._name = value;
		return this;
	}

	public Object getName() {
		return this._name;
	}

	public Object getName(Object defaultValue) {
		return this._name == null ? defaultValue : this._name;
	}

	public boolean hasName() {
		return this._name != null;
	}

	public Function removeName() {
		this._name = null;
		return this;
	} 

	public Function addParameters(Object value) {
		this._parameters.add(value);
		return this;
	}

	public Function removeParameters(Object value) {
		this._parameters.remove(value);
		return this;
	}

	public Function removeParameters(int index) {
		this._parameters.remove(index);
		return this;
	}

	public java.util.List<Object> getParameters() {
		return this._parameters;
	} 

	public Function addStatements(Object value) {
		this._statements.add(value);
		return this;
	}

	public Function removeStatements(Object value) {
		this._statements.remove(value);
		return this;
	}

	public Function removeStatements(int index) {
		this._statements.remove(index);
		return this;
	}

	public java.util.List<Object> getStatements() {
		return this._statements;
	} 


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Function that = (Function) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "Function(name,parameters,statements) ::= <<function ~name~(~parameters:{it|~it~};separator=\",\"~) {\n" + 
				"	~statements:{it|~it~};separator=\"\\n\"~\n" + 
				"}>> ";
}  