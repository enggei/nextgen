package nextgen.st.stringtemplate;

public class EntityListAccessors {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _entity;
	private Object _name;
	private Object _type;

	EntityListAccessors(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("entityListAccessors");
		st.add("entity", _entity);
		st.add("name", _name);
		st.add("type", _type);
		return st.render().trim();
	}

	public EntityListAccessors setEntity(Object value) {
		this._entity = value;
		return this;
	}

	public Object getEntity() {
		return this._entity;
	}

	public Object getEntity(Object defaultValue) {
		return this._entity == null ? defaultValue : this._entity;
	}

	public boolean hasEntity() {
		return this._entity != null;
	}

	public EntityListAccessors removeEntity() {
		this._entity = null;
		return this;
	} 

	public EntityListAccessors setName(Object value) {
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

	public EntityListAccessors removeName() {
		this._name = null;
		return this;
	} 

	public EntityListAccessors setType(Object value) {
		this._type = value;
		return this;
	}

	public Object getType() {
		return this._type;
	}

	public Object getType(Object defaultValue) {
		return this._type == null ? defaultValue : this._type;
	}

	public boolean hasType() {
		return this._type != null;
	}

	public EntityListAccessors removeType() {
		this._type = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		EntityListAccessors that = (EntityListAccessors) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "entityListAccessors(entity,name,type) ::= <<public ~entity~ add~name;format=\"capitalize\"~(~if(type)~~type~~else~Object~endif~ value) {\n" + 
				"	this._~name~.add(value);\n" + 
				"	return this;\n" + 
				"}\n" + 
				"\n" + 
				"public ~entity~ set~name;format=\"capitalize\"~(~if(type)~~type~~else~Object~endif~[] value) {\n" + 
				"	this._~name~.addAll(java.util.Arrays.asList(value));\n" + 
				"	return this;\n" + 
				"}\n" + 
				"\n" + 
				"public ~entity~ set~name;format=\"capitalize\"~(java.util.Collection<~if(type)~~type~~else~Object~endif~> values) {\n" + 
				"	this._~name~.addAll(values);\n" + 
				"	return this;\n" + 
				"}\n" + 
				"\n" + 
				"public ~entity~ remove~name;format=\"capitalize\"~(~if(type)~~type~~else~Object~endif~ value) {\n" + 
				"	this._~name~.remove(value);\n" + 
				"	return this;\n" + 
				"}\n" + 
				"\n" + 
				"public ~entity~ remove~name;format=\"capitalize\"~(int index) {\n" + 
				"	this._~name~.remove(index);\n" + 
				"	return this;\n" + 
				"}\n" + 
				"\n" + 
				"public java.util.List<~if(type)~~type~~else~Object~endif~> get~name;format=\"capitalize\"~() {\n" + 
				"	return this._~name~;\n" + 
				"} >>";
}  