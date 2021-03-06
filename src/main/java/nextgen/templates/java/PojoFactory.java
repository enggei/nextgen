package nextgen.templates.java;

public class PojoFactory {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _name;
	private Object _package;
	private java.util.List<Object> _entities = new java.util.ArrayList<>();

	PojoFactory(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("PojoFactory");
		st.add("name", _name);
		st.add("package", _package);
		for (Object o : _entities) st.add("entities", o);
		return st.render().trim();
	}

	public PojoFactory setName(Object value) {
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

	public PojoFactory removeName() {
		this._name = null;
		return this;
	} 

	public PojoFactory setPackage(Object value) {
		this._package = value;
		return this;
	}

	public Object getPackage() {
		return this._package;
	}

	public Object getPackage(Object defaultValue) {
		return this._package == null ? defaultValue : this._package;
	}

	public boolean hasPackage() {
		return this._package != null;
	}

	public PojoFactory removePackage() {
		this._package = null;
		return this;
	} 

	public PojoFactory addEntities(Object value) {
		this._entities.add(value);
		return this;
	}

	public PojoFactory setEntities(Object[] value) {
		this._entities.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public PojoFactory setEntities(java.util.Collection<Object> values) {
		this._entities.addAll(values);
		return this;
	}

	public PojoFactory removeEntities(Object value) {
		this._entities.remove(value);
		return this;
	}

	public PojoFactory removeEntities(int index) {
		this._entities.remove(index);
		return this;
	}

	public java.util.List<Object> getEntities() {
		return this._entities;
	} 


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		PojoFactory that = (PojoFactory) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "PojoFactory(name,entities,package) ::= <<package ~package~;\n" + 
				"\n" + 
				"public class ~name;format=\"capitalize\"~ {\n" + 
				"\n" + 
				"~entities:{it|\n" + 
				"	public static ~it~ new~it~() { \n" + 
				"		return new ~it~();\n" + 
				"	~eom()~	\n" + 
				"};separator=\"\\n\"~\n" + 
				"} >>";
}  