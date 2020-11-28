package nextgen.templates.javascript;

public class MethodDeclaration {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _const;
	private Object _name;
	private java.util.List<Object> _parameters = new java.util.ArrayList<>();
	private java.util.List<Object> _statements = new java.util.ArrayList<>();

	MethodDeclaration(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("MethodDeclaration");
		st.add("const", _const);
		st.add("name", _name);
		for (Object o : _parameters) st.add("parameters", o);
		for (Object o : _statements) st.add("statements", o);
		return st.render().trim();
	}

	public MethodDeclaration setConst(Object value) {
		this._const = value;
		return this;
	}

	public Object getConst() {
		return this._const;
	}

	public Object getConst(Object defaultValue) {
		return this._const == null ? defaultValue : this._const;
	}

	public boolean hasConst() {
		return this._const != null;
	}

	public MethodDeclaration removeConst() {
		this._const = null;
		return this;
	} 

	public MethodDeclaration setName(Object value) {
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

	public MethodDeclaration removeName() {
		this._name = null;
		return this;
	} 

	public MethodDeclaration addParameters(Object value) {
		this._parameters.add(value);
		return this;
	}

	public MethodDeclaration setParameters(Object[] value) {
		this._parameters.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public MethodDeclaration setParameters(java.util.Collection<Object> values) {
		this._parameters.addAll(values);
		return this;
	}

	public MethodDeclaration removeParameters(Object value) {
		this._parameters.remove(value);
		return this;
	}

	public MethodDeclaration removeParameters(int index) {
		this._parameters.remove(index);
		return this;
	}

	public java.util.List<Object> getParameters() {
		return this._parameters;
	} 

	public MethodDeclaration addStatements(Object value) {
		this._statements.add(value);
		return this;
	}

	public MethodDeclaration setStatements(Object[] value) {
		this._statements.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public MethodDeclaration setStatements(java.util.Collection<Object> values) {
		this._statements.addAll(values);
		return this;
	}

	public MethodDeclaration removeStatements(Object value) {
		this._statements.remove(value);
		return this;
	}

	public MethodDeclaration removeStatements(int index) {
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
		MethodDeclaration that = (MethodDeclaration) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "MethodDeclaration(const,name,parameters,statements) ::= <<~if(const)~const ~endif~~name~ = (~parameters:{it|~it~};separator=\",\"~) => {\n" + 
				"	console.info(\"call ~name~\");\n" + 
				"	~statements:{it|~it~};separator=\"\\n\"~\n" + 
				"} >>";
}  