package nextgen.templates.java;

public class Function {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private String _name;
	private Object _O;
	private Object _packageName;
	private Object _expression;
	private Object _extending;
	private Object _I;

	Function(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("Function");
		st.add("name", _name);
		st.add("O", _O);
		st.add("packageName", _packageName);
		st.add("expression", _expression);
		st.add("extending", _extending);
		st.add("I", _I);
		return st.render().trim();
	}

	public Function setName(String value) {
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

	public Function removeName() {
		this._name = null;
		return this;
	} 

	public Function setO(Object value) {
		this._O = value;
		return this;
	}

	public Object getO() {
		return this._O;
	}

	public Object getO(Object defaultValue) {
		return this._O == null ? defaultValue : this._O;
	}

	public boolean hasO() {
		return this._O != null;
	}

	public Function removeO() {
		this._O = null;
		return this;
	} 

	public Function setPackageName(Object value) {
		this._packageName = value;
		return this;
	}

	public Object getPackageName() {
		return this._packageName;
	}

	public Object getPackageName(Object defaultValue) {
		return this._packageName == null ? defaultValue : this._packageName;
	}

	public boolean hasPackageName() {
		return this._packageName != null;
	}

	public Function removePackageName() {
		this._packageName = null;
		return this;
	} 

	public Function setExpression(Object value) {
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

	public Function removeExpression() {
		this._expression = null;
		return this;
	} 

	public Function setExtending(Object value) {
		this._extending = value;
		return this;
	}

	public Object getExtending() {
		return this._extending;
	}

	public Object getExtending(Object defaultValue) {
		return this._extending == null ? defaultValue : this._extending;
	}

	public boolean hasExtending() {
		return this._extending != null;
	}

	public Function removeExtending() {
		this._extending = null;
		return this;
	} 

	public Function setI(Object value) {
		this._I = value;
		return this;
	}

	public Object getI() {
		return this._I;
	}

	public Object getI(Object defaultValue) {
		return this._I == null ? defaultValue : this._I;
	}

	public boolean hasI() {
		return this._I != null;
	}

	public Function removeI() {
		this._I = null;
		return this;
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

	static final String st = "Function(name,O,packageName,expression,extending,I) ::= <<package ~packageName~;\n" + 
				"\n" + 
				"public final class ~name~~if(extending)~ extends ~extending~~endif~ implements java.util.function.Function<~I~, ~O~> {\n" + 
				"	\n" + 
				"	@Override\n" + 
				"	public ~O~ apply(~I~ input) {\n" + 
				"		~expression~\n" + 
				"	}\n" + 
				"} >>";
}  