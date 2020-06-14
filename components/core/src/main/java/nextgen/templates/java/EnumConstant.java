package nextgen.templates.java;

public class EnumConstant {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _name;
	private java.util.List<Object> _methods = new java.util.ArrayList<>();
	private java.util.List<Object> _arguments = new java.util.ArrayList<>();
	private java.util.List<Object> _annotations = new java.util.ArrayList<>();

	EnumConstant(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("EnumConstant");
		st.add("name", _name);
		for (Object o : _methods) st.add("methods", o);
		for (Object o : _arguments) st.add("arguments", o);
		for (Object o : _annotations) st.add("annotations", o);
		return st.render().trim();
	}

	public EnumConstant setName(Object value) {
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

	public EnumConstant removeName() {
		this._name = null;
		return this;
	}

	public EnumConstant addMethods(Object value) {
		this._methods.add(value);
		return this;
	}

	public EnumConstant setMethods(Object[] value) {
		this._methods.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public EnumConstant setMethods(java.util.Collection<Object> values) {
		this._methods.addAll(values);
		return this;
	}

	public EnumConstant removeMethods(Object value) {
		this._methods.remove(value);
		return this;
	}

	public EnumConstant removeMethods(int index) {
		this._methods.remove(index);
		return this;
	}

	public java.util.List<Object> getMethods() {
		return this._methods;
	}

	public EnumConstant addArguments(Object value) {
		this._arguments.add(value);
		return this;
	}

	public EnumConstant setArguments(Object[] value) {
		this._arguments.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public EnumConstant setArguments(java.util.Collection<Object> values) {
		this._arguments.addAll(values);
		return this;
	}

	public EnumConstant removeArguments(Object value) {
		this._arguments.remove(value);
		return this;
	}

	public EnumConstant removeArguments(int index) {
		this._arguments.remove(index);
		return this;
	}

	public java.util.List<Object> getArguments() {
		return this._arguments;
	}

	public EnumConstant addAnnotations(Object value) {
		this._annotations.add(value);
		return this;
	}

	public EnumConstant setAnnotations(Object[] value) {
		this._annotations.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public EnumConstant setAnnotations(java.util.Collection<Object> values) {
		this._annotations.addAll(values);
		return this;
	}

	public EnumConstant removeAnnotations(Object value) {
		this._annotations.remove(value);
		return this;
	}

	public EnumConstant removeAnnotations(int index) {
		this._annotations.remove(index);
		return this;
	}

	public java.util.List<Object> getAnnotations() {
		return this._annotations;
	}


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		EnumConstant that = (EnumConstant) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "EnumConstant(methods,arguments,name,annotations) ::= <<~annotations:{it|~it~};separator=\"\\n\"~~if(annotations)~\n" + 
				"~endif~~name~~if(arguments)~(~arguments:{it|~it~};separator=\",\"~)~endif~~if(methods)~ {\n" + 
				"	~methods:{it|~it~};separator=\"\\n\"~\n" + 
				"}~endif~>>";
}