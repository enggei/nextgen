package nextgen.st.stringtemplate;

public class EntitySingleAccessors {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _entity;
	private Object _name;
	private Object _type;

	EntitySingleAccessors(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("entitySingleAccessors");
		st.add("entity", _entity);
		st.add("name", _name);
		st.add("type", _type);
		return st.render().trim();
	}

	public EntitySingleAccessors setEntity(Object value) {
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

	public EntitySingleAccessors removeEntity() {
		this._entity = null;
		return this;
	} 

	public EntitySingleAccessors setName(Object value) {
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

	public EntitySingleAccessors removeName() {
		this._name = null;
		return this;
	} 

	public EntitySingleAccessors setType(Object value) {
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

	public EntitySingleAccessors removeType() {
		this._type = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		EntitySingleAccessors that = (EntitySingleAccessors) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "entitySingleAccessors(entity,name,type) ::= <<public ~entity~ set~name;format=\"capitalize\"~(~if(type)~~type~~else~Object~endif~ value) {\n" + 
				"	this._~name~ = value;\n" + 
				"	return this;\n" + 
				"}\n" + 
				"\n" + 
				"public ~if(type)~~type~~else~Object~endif~ get~name;format=\"capitalize\"~() {\n" + 
				"	return this._~name~;\n" + 
				"}\n" + 
				"\n" + 
				"public ~if(type)~~type~~else~Object~endif~ get~name;format=\"capitalize\"~(~if(type)~~type~~else~Object~endif~ defaultValue) {\n" + 
				"	return this._~name~ == null ? defaultValue : this._~name~;\n" + 
				"}\n" + 
				"\n" + 
				"public boolean has~name;format=\"capitalize\"~() {\n" + 
				"	return this._~name~ != null;\n" + 
				"}\n" + 
				"\n" + 
				"public ~entity~ remove~name;format=\"capitalize\"~() {\n" + 
				"	this._~name~ = null;\n" + 
				"	return this;\n" + 
				"} >>";
}  