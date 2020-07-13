package nextgen.templates.domain;

public class ExtendedNameEntity {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _name;
	private Object _packageName;
	private Object _variableName;
	private java.util.List<Object> _methods = new java.util.ArrayList<>();

	ExtendedNameEntity(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("ExtendedNameEntity");
		st.add("name", _name);
		st.add("packageName", _packageName);
		st.add("variableName", _variableName);
		for (Object o : _methods) st.add("methods", o);
		return st.render().trim();
	}

	public ExtendedNameEntity setName(Object value) {
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

	public ExtendedNameEntity removeName() {
		this._name = null;
		return this;
	} 

	public ExtendedNameEntity setPackageName(Object value) {
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

	public ExtendedNameEntity removePackageName() {
		this._packageName = null;
		return this;
	} 

	public ExtendedNameEntity setVariableName(Object value) {
		this._variableName = value;
		return this;
	}

	public Object getVariableName() {
		return this._variableName;
	}

	public Object getVariableName(Object defaultValue) {
		return this._variableName == null ? defaultValue : this._variableName;
	}

	public boolean hasVariableName() {
		return this._variableName != null;
	}

	public ExtendedNameEntity removeVariableName() {
		this._variableName = null;
		return this;
	} 

	public ExtendedNameEntity addMethods(Object value) {
		this._methods.add(value);
		return this;
	}

	public ExtendedNameEntity setMethods(Object[] value) {
		this._methods.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public ExtendedNameEntity setMethods(java.util.Collection<Object> values) {
		this._methods.addAll(values);
		return this;
	}

	public ExtendedNameEntity removeMethods(Object value) {
		this._methods.remove(value);
		return this;
	}

	public ExtendedNameEntity removeMethods(int index) {
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
		ExtendedNameEntity that = (ExtendedNameEntity) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "ExtendedNameEntity(name,methods,packageName,variableName) ::= <<static final class ~name~Entity extends NamedEntity {\n" + 
				"	~name~Entity(String name, PackageDeclaration packageDeclaration) {\n" + 
				"		super(name, packageDeclaration);\n" + 
				"	}\n" + 
				"\n" + 
				"	~methods:{it|~it~};separator=\"\\n\"~\n" + 
				"}\n" + 
				"\n" + 
				"final ~name~Entity ~name~ = new ~name~Entity(\"~name~\", ~packageName~~if(variableName)~, \"~variableName~\"~endif~); >>";
}  