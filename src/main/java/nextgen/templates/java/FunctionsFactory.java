package nextgen.templates.java;

public class FunctionsFactory {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _packageName;
	private String _name;
	private Object _extending;
	private java.util.List<Object> _types = new java.util.ArrayList<>();
	private java.util.List<Object> _methods = new java.util.ArrayList<>();

	FunctionsFactory(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("FunctionsFactory");
		st.add("packageName", _packageName);
		st.add("name", _name);
		st.add("extending", _extending);
		for (Object o : _types) st.add("types", o);
		for (Object o : _methods) st.add("methods", o);
		return st.render().trim();
	}

	public FunctionsFactory setPackageName(Object value) {
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

	public FunctionsFactory removePackageName() {
		this._packageName = null;
		return this;
	} 

	public FunctionsFactory setName(String value) {
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

	public FunctionsFactory removeName() {
		this._name = null;
		return this;
	} 

	public FunctionsFactory setExtending(Object value) {
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

	public FunctionsFactory removeExtending() {
		this._extending = null;
		return this;
	} 

	public FunctionsFactory addTypes(Object value) {
		this._types.add(value);
		return this;
	}

	public FunctionsFactory setTypes(Object[] value) {
		this._types.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public FunctionsFactory setTypes(java.util.Collection<Object> values) {
		this._types.addAll(values);
		return this;
	}

	public FunctionsFactory removeTypes(Object value) {
		this._types.remove(value);
		return this;
	}

	public FunctionsFactory removeTypes(int index) {
		this._types.remove(index);
		return this;
	}

	public java.util.List<Object> getTypes() {
		return this._types;
	} 

	public FunctionsFactory addMethods(Object value) {
		this._methods.add(value);
		return this;
	}

	public FunctionsFactory setMethods(Object[] value) {
		this._methods.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public FunctionsFactory setMethods(java.util.Collection<Object> values) {
		this._methods.addAll(values);
		return this;
	}

	public FunctionsFactory removeMethods(Object value) {
		this._methods.remove(value);
		return this;
	}

	public FunctionsFactory removeMethods(int index) {
		this._methods.remove(index);
		return this;
	}

	public java.util.List<Object> getMethods() {
		return this._methods;
	} 


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		FunctionsFactory that = (FunctionsFactory) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "FunctionsFactory(packageName,name,types,extending,methods) ::= <<package ~packageName~;\n" + 
				"\n" + 
				"public final class ~name~~if(extending)~ extends ~extending~~endif~ {\n" + 
				"\n" + 
				"	~types:{it|~it~};separator=\"\\n\\n\"~\n" + 
				"	\n" + 
				"	~methods:{it|~it~};separator=\"\\n\\n\"~\n" + 
				"} >>";
}  