package nextgen.templates.java;

public class JavaPackageInfo {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _packageName;
	private java.util.List<Object> _interfaces = new java.util.ArrayList<>();
	private java.util.List<Object> _classes = new java.util.ArrayList<>();

	JavaPackageInfo(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("JavaPackageInfo");
		st.add("packageName", _packageName);
		for (Object o : _interfaces) st.add("interfaces", o);
		for (Object o : _classes) st.add("classes", o);
		return st.render().trim();
	}

	public JavaPackageInfo setPackageName(Object value) {
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

	public JavaPackageInfo removePackageName() {
		this._packageName = null;
		return this;
	} 

	public JavaPackageInfo addInterfaces(Object value) {
		this._interfaces.add(value);
		return this;
	}

	public JavaPackageInfo setInterfaces(Object[] value) {
		this._interfaces.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public JavaPackageInfo setInterfaces(java.util.Collection<Object> values) {
		this._interfaces.addAll(values);
		return this;
	}

	public JavaPackageInfo removeInterfaces(Object value) {
		this._interfaces.remove(value);
		return this;
	}

	public JavaPackageInfo removeInterfaces(int index) {
		this._interfaces.remove(index);
		return this;
	}

	public java.util.List<Object> getInterfaces() {
		return this._interfaces;
	} 

	public JavaPackageInfo addClasses(Object value) {
		this._classes.add(value);
		return this;
	}

	public JavaPackageInfo setClasses(Object[] value) {
		this._classes.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public JavaPackageInfo setClasses(java.util.Collection<Object> values) {
		this._classes.addAll(values);
		return this;
	}

	public JavaPackageInfo removeClasses(Object value) {
		this._classes.remove(value);
		return this;
	}

	public JavaPackageInfo removeClasses(int index) {
		this._classes.remove(index);
		return this;
	}

	public java.util.List<Object> getClasses() {
		return this._classes;
	} 


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		JavaPackageInfo that = (JavaPackageInfo) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "JavaPackageInfo(packageName,interfaces,classes) ::= <<~packageName~\n" + 
				"\n" + 
				"interfaces:\n" + 
				"	~interfaces:{it|~it.name~};separator=\"\\n\"~\n" + 
				"\n" + 
				"classes:\n" + 
				"	~classes:{it|~it.name~};separator=\"\\n\"~ >>";
} 