package nextgen.templates.domain;

public class JavaPackage {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _comments;
	private Object _name;
	private Object _parent;
	private Object _packageName;
	private java.util.List<Object> _methods = new java.util.ArrayList<>();
	private java.util.List<Object> _subPackages = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _entities = new java.util.ArrayList<>();

	JavaPackage(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("JavaPackage");
		st.add("comments", _comments);
		st.add("name", _name);
		st.add("parent", _parent);
		st.add("packageName", _packageName);
		for (Object o : _methods) st.add("methods", o);
		for (Object o : _subPackages) st.add("subPackages", o);
		for (java.util.Map<String, Object> map : _entities) st.addAggr("entities.{name,variableName,ref,isPrimitive}", map.get("name"), map.get("variableName"), map.get("ref"), map.get("isPrimitive"));
		return st.render().trim();
	}

	public JavaPackage setComments(Object value) {
		this._comments = value;
		return this;
	}

	public Object getComments() {
		return this._comments;
	}

	public Object getComments(Object defaultValue) {
		return this._comments == null ? defaultValue : this._comments;
	}

	public boolean hasComments() {
		return this._comments != null;
	}

	public JavaPackage removeComments() {
		this._comments = null;
		return this;
	} 

	public JavaPackage setName(Object value) {
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

	public JavaPackage removeName() {
		this._name = null;
		return this;
	} 

	public JavaPackage setParent(Object value) {
		this._parent = value;
		return this;
	}

	public Object getParent() {
		return this._parent;
	}

	public Object getParent(Object defaultValue) {
		return this._parent == null ? defaultValue : this._parent;
	}

	public boolean hasParent() {
		return this._parent != null;
	}

	public JavaPackage removeParent() {
		this._parent = null;
		return this;
	} 

	public JavaPackage setPackageName(Object value) {
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

	public JavaPackage removePackageName() {
		this._packageName = null;
		return this;
	} 

	public JavaPackage addMethods(Object value) {
		this._methods.add(value);
		return this;
	}

	public JavaPackage setMethods(Object[] value) {
		this._methods.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public JavaPackage setMethods(java.util.Collection<Object> values) {
		this._methods.addAll(values);
		return this;
	}

	public JavaPackage removeMethods(Object value) {
		this._methods.remove(value);
		return this;
	}

	public JavaPackage removeMethods(int index) {
		this._methods.remove(index);
		return this;
	}

	public java.util.List<Object> getMethods() {
		return this._methods;
	} 

	public JavaPackage addSubPackages(Object value) {
		this._subPackages.add(value);
		return this;
	}

	public JavaPackage setSubPackages(Object[] value) {
		this._subPackages.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public JavaPackage setSubPackages(java.util.Collection<Object> values) {
		this._subPackages.addAll(values);
		return this;
	}

	public JavaPackage removeSubPackages(Object value) {
		this._subPackages.remove(value);
		return this;
	}

	public JavaPackage removeSubPackages(int index) {
		this._subPackages.remove(index);
		return this;
	}

	public java.util.List<Object> getSubPackages() {
		return this._subPackages;
	} 

	public JavaPackage addEntities(Object _name, Object _variableName, Object _ref, Boolean _isPrimitive) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		map.put("variableName", _variableName);
		map.put("ref", _ref);
		map.put("isPrimitive", _isPrimitive);
		this._entities.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getEntities() {
		return this._entities;
	}

	public JavaPackage addEntities(JavaPackage_Entities value) {
		return addEntities(value._name, value._variableName, value._ref, value._isPrimitive);
	}

	public java.util.stream.Stream<JavaPackage_Entities> streamEntities() {
		return this._entities.stream().map(JavaPackage_Entities::new);
	}

	public static final class JavaPackage_Entities {

		Object _name;
		Object _variableName;
		Object _ref;
		Boolean _isPrimitive;

		public JavaPackage_Entities(Object _name, Object _variableName, Object _ref, Boolean _isPrimitive) {
			this._name = _name;
			this._variableName = _variableName;
			this._ref = _ref;
			this._isPrimitive = _isPrimitive;
		}

		private JavaPackage_Entities(java.util.Map<String, Object> map) {
			this._name = (Object) map.get("name");
			this._variableName = (Object) map.get("variableName");
			this._ref = (Object) map.get("ref");
			this._isPrimitive = (Boolean) map.get("isPrimitive");
		}

		public Object getName() {
			return this._name;
		}

		public Object getVariableName() {
			return this._variableName;
		}

		public Object getRef() {
			return this._ref;
		}

		public Boolean getIsPrimitive() {
			return this._isPrimitive;
		}

	} 

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		JavaPackage that = (JavaPackage) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "JavaPackage(comments,name,parent,packageName,entities,methods,subPackages) ::= <<~if(comments)~\n" + 
				"// ~comments~\n" + 
				"~endif~\n" + 
				"final PackageDeclaration ~name~ = newPackageDeclaration(~if(parent)~~parent~, ~endif~\"~packageName~\");\n" + 
				"~entities:{it|final NamedEntity ~if(it.ref)~~it.ref~~else~~it.name~~endif~ = new NamedEntity(\"~it.name~\", ~if(it.isPrimitive)~null~else~~name~~endif~~if(it.variableName)~, \"~it.variableName~\"~endif~);};separator=\"\\n\"~\n" + 
				"\n" + 
				"~methods:{it|~it~};separator=\"\\n\\n\"~\n" + 
				"\n" + 
				"~subPackages:{it|~it~};separator=\"\\n\\n\"~ >>";
}  