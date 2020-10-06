package nextgen.templates.projects;

public class JavaProjectPackage {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _fullPath;
	private String _name;
	private java.util.List<JavaProjectPackage> _children = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _types = new java.util.ArrayList<>();

	JavaProjectPackage(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("JavaProjectPackage");
		st.add("fullPath", _fullPath);
		st.add("name", _name);
		for (Object o : _children) st.add("children", o);
		for (java.util.Map<String, Object> map : _types) st.addAggr("types.{type,entity}", map.get("type"), map.get("entity"));
		return st.render().trim();
	}

	public JavaProjectPackage setFullPath(Object value) {
		this._fullPath = value;
		return this;
	}

	public Object getFullPath() {
		return this._fullPath;
	}

	public Object getFullPath(Object defaultValue) {
		return this._fullPath == null ? defaultValue : this._fullPath;
	}

	public boolean hasFullPath() {
		return this._fullPath != null;
	}

	public JavaProjectPackage removeFullPath() {
		this._fullPath = null;
		return this;
	} 

	public JavaProjectPackage setName(String value) {
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

	public JavaProjectPackage removeName() {
		this._name = null;
		return this;
	} 

	public JavaProjectPackage addChildren(JavaProjectPackage value) {
		this._children.add(value);
		return this;
	}

	public JavaProjectPackage setChildren(JavaProjectPackage[] value) {
		this._children.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public JavaProjectPackage setChildren(java.util.Collection<JavaProjectPackage> values) {
		this._children.addAll(values);
		return this;
	}

	public JavaProjectPackage removeChildren(JavaProjectPackage value) {
		this._children.remove(value);
		return this;
	}

	public JavaProjectPackage removeChildren(int index) {
		this._children.remove(index);
		return this;
	}

	public java.util.List<JavaProjectPackage> getChildren() {
		return this._children;
	} 

	public JavaProjectPackage addTypes(Object _type, Object _entity) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("type", _type);
		map.put("entity", _entity);
		this._types.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getTypes() {
		return this._types;
	}

	public JavaProjectPackage addTypes(JavaProjectPackage_Types value) {
		return addTypes(value._type, value._entity);
	}

	public java.util.stream.Stream<JavaProjectPackage_Types> streamTypes() {
		return this._types.stream().map(JavaProjectPackage_Types::new);
	}

	public java.util.List<Object> getTypes_Type() {
		return streamTypes().map(JavaProjectPackage_Types::getType).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getTypes_Entity() {
		return streamTypes().map(JavaProjectPackage_Types::getEntity).collect(java.util.stream.Collectors.toList());
	}


	public static final class JavaProjectPackage_Types {

		Object _type;
		Object _entity;

		public JavaProjectPackage_Types(Object _type, Object _entity) {
			this._type = _type;
			this._entity = _entity;
		}

		private JavaProjectPackage_Types(java.util.Map<String, Object> map) {
			this._type = (Object) map.get("type");
			this._entity = (Object) map.get("entity");
		}

		public Object getType() {
			return this._type;
		}

		public Object getEntity() {
			return this._entity;
		}

	}  

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		JavaProjectPackage that = (JavaProjectPackage) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "JavaProjectPackage(fullPath,name,types,children) ::= <<~fullPath~\n" + 
				"~name~\n" + 
				"\n" + 
				"~types:{it|~it.entity~ ~it.type~};separator=\"\\n\"~\n" + 
				"\n" + 
				"~children:{it|~it~};separator=\"\\n\"~ >>";
}  