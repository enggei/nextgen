package nextgen.templates.java;

public class Consumer {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _T;
	private Object _extending;
	private Object _expression;
	private String _name;
	private Object _packageName;

	Consumer(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("Consumer");
		st.add("T", _T);
		st.add("extending", _extending);
		st.add("expression", _expression);
		st.add("name", _name);
		st.add("packageName", _packageName);
		return st.render().trim();
	}

	public Consumer setT(Object value) {
		this._T = value;
		return this;
	}

	public Object getT() {
		return this._T;
	}

	public Object getT(Object defaultValue) {
		return this._T == null ? defaultValue : this._T;
	}

	public boolean hasT() {
		return this._T != null;
	}

	public Consumer removeT() {
		this._T = null;
		return this;
	} 

	public Consumer setExtending(Object value) {
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

	public Consumer removeExtending() {
		this._extending = null;
		return this;
	} 

	public Consumer setExpression(Object value) {
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

	public Consumer removeExpression() {
		this._expression = null;
		return this;
	} 

	public Consumer setName(String value) {
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

	public Consumer removeName() {
		this._name = null;
		return this;
	} 

	public Consumer setPackageName(Object value) {
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

	public Consumer removePackageName() {
		this._packageName = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Consumer that = (Consumer) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "Consumer(T,extending,expression,name,packageName) ::= <<package ~packageName~;\n" + 
				"\n" + 
				"public final class ~name~~if(extending)~ extends ~extending~~endif~ implements java.util.function.Consumer<~T~> {\n" + 
				"	\n" + 
				"	@Override\n" + 
				"	public void accept(~T~ t) {\n" + 
				"		~expression~\n" + 
				"	}\n" + 
				"} >>";
}  