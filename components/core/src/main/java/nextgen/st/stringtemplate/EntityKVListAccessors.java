package nextgen.st.stringtemplate;

public class EntityKVListAccessors {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _entity;
	private Object _name;
	private java.util.List<java.util.Map<String, Object>> _keys = new java.util.ArrayList<>();

	EntityKVListAccessors(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		EntityKVListAccessors that = (EntityKVListAccessors) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("entityKVListAccessors");
		st.add("entity", _entity);
		st.add("name", _name);
		for (java.util.Map<String, Object> map : _keys) st.addAggr("keys.{type,name}", map.get("type"), map.get("name"));
		return st.render().trim();
	}

	public EntityKVListAccessors setEntity(Object value) {
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

	public EntityKVListAccessors removeEntity() {
		this._entity = null;
		return this;
	} 

	public EntityKVListAccessors setName(Object value) {
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

	public EntityKVListAccessors removeName() {
		this._name = null;
		return this;
	} 
	public EntityKVListAccessors addKeys(Object _type, Object _name) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("type", _type);
		map.put("name", _name);
		this._keys.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getKeys() {
		return this._keys;
	}

	public EntityKVListAccessors addKeys(EntityKVListAccessors_Keys value) {
		return addKeys(value._type, value._name);
	}

	public java.util.stream.Stream<EntityKVListAccessors_Keys> streamKeys() {
		return this._keys.stream().map(EntityKVListAccessors_Keys::new);
	}

	public static final class EntityKVListAccessors_Keys {

		Object _type;
		Object _name;

		public EntityKVListAccessors_Keys(Object _type, Object _name) {
			this._type = _type;
			this._name = _name;
		}

		private EntityKVListAccessors_Keys(java.util.Map<String, Object> map) {
			this._type = (Object) map.get("type");
			this._name = (Object) map.get("name");
		}

		public Object getType() {
			return this._type;
		}

		public Object getName() {
			return this._name;
		}

	} 

	static final String st = "entityKVListAccessors(entity,name,keys) ::= <<public ~entity~ add~name;format=\"capitalize\"~(~keys:{it|~if(it.type)~~it.type~~else~Object~endif~ _~it.name~};separator=\", \"~) {\n" + 
				"	final java.util.Map<String, Object> map = new java.util.HashMap<>();\n" + 
				"	~keys:{it|map.put(\"~it.name~\", _~it.name~);};separator=\"\\n\"~\n" + 
				"	this._~name~.add(map);\n" + 
				"	return this;\n" + 
				"}\n" + 
				"\n" + 
				"public java.util.List<java.util.Map<String, Object~gt()~> get~name;format=\"capitalize\"~() {\n" + 
				"	return this._~name~;\n" + 
				"}\n" + 
				"\n" + 
				"public ~entity~ add~name;format=\"capitalize\"~(~entity~_~name;format=\"capitalize\"~ value) {\n" + 
				"	return add~name;format=\"capitalize\"~(~keys:{it|value._~it.name~};separator=\", \"~);\n" + 
				"}\n" + 
				"\n" + 
				"public java.util.stream.Stream<~entity~_~name;format=\"capitalize\"~> stream~name;format=\"capitalize\"~() {\n" + 
				"	return this._~name~.stream().map(~entity~_~name;format=\"capitalize\"~::new);\n" + 
				"}\n" + 
				"\n" + 
				"public static final class ~entity~_~name;format=\"capitalize\"~ {\n" + 
				"\n" + 
				"	~keys:{it|~if(it.type)~~it.type~~else~Object~endif~ _~it.name~;};separator=\"\\n\"~\n" + 
				"\n" + 
				"	public ~entity~_~name;format=\"capitalize\"~(~keys:{it|~if(it.type)~~it.type~~else~Object~endif~ _~it.name~};separator=\", \"~) {\n" + 
				"		~keys:{it|this._~it.name~ = _~it.name~;};separator=\"\\n\"~\n" + 
				"	}\n" + 
				"\n" + 
				"	private ~entity~_~name;format=\"capitalize\"~(java.util.Map<String, Object> map) {\n" + 
				"		~keys:{it|this._~it.name~ = (~it.type~) map.get(\"~it.name~\");};separator=\"\\n\"~\n" + 
				"	}\n" + 
				"\n" + 
				"	~keys:{it|public ~if(it.type)~~it.type~~else~Object~endif~ get~it.name;format=\"capitalize\"~() {\n" + 
				"	return this._~it.name~;\n" + 
				"~eom()~\n" + 
				"	};separator=\"\\n\"~\n" + 
				"}>> ";
} 