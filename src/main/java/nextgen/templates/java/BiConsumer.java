package nextgen.templates.java;

public class BiConsumer {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _expression;
	private Object _U;
	private String _name;
	private Object _packageName;
	private Object _T;
	private Object _extending;

	BiConsumer(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("BiConsumer");
		st.add("expression", _expression);
		st.add("U", _U);
		st.add("name", _name);
		st.add("packageName", _packageName);
		st.add("T", _T);
		st.add("extending", _extending);
		return st.render().trim();
	}

	public BiConsumer setExpression(Object value) {
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

	public BiConsumer removeExpression() {
		this._expression = null;
		return this;
	} 

	public BiConsumer setU(Object value) {
		this._U = value;
		return this;
	}

	public Object getU() {
		return this._U;
	}

	public Object getU(Object defaultValue) {
		return this._U == null ? defaultValue : this._U;
	}

	public boolean hasU() {
		return this._U != null;
	}

	public BiConsumer removeU() {
		this._U = null;
		return this;
	} 

	public BiConsumer setName(String value) {
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

	public BiConsumer removeName() {
		this._name = null;
		return this;
	} 

	public BiConsumer setPackageName(Object value) {
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

	public BiConsumer removePackageName() {
		this._packageName = null;
		return this;
	} 

	public BiConsumer setT(Object value) {
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

	public BiConsumer removeT() {
		this._T = null;
		return this;
	} 

	public BiConsumer setExtending(Object value) {
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

	public BiConsumer removeExtending() {
		this._extending = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		BiConsumer that = (BiConsumer) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "BiConsumer(expression,U,name,packageName,T,extending) ::= <<package ~packageName~;\n" + 
				"\n" + 
				"public final class ~name~~if(extending)~ extends ~extending~~endif~ implements java.util.function.BiConsumer<~T~, ~U~> {\n" + 
				"	\n" + 
				"	@Override\n" + 
				"	public void accept(~T~ t, ~U~ u) {\n" + 
				"		~expression~\n" + 
				"	}\n" + 
				"} >>";
}  