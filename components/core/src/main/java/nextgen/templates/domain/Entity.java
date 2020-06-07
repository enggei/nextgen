package nextgen.templates.domain;

public class Entity {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _name;
	private java.util.List<java.util.Map<String, Object>> _fields = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _relations = new java.util.ArrayList<>();

	Entity(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Entity that = (Entity) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("Entity");
		st.add("name", _name);
		for (java.util.Map<String, Object> map : _fields) st.addAggr("fields.{name,type,lexical}", map.get("name"), map.get("type"), map.get("lexical"));
		for (java.util.Map<String, Object> map : _relations) st.addAggr("relations.{name,type,target}", map.get("name"), map.get("type"), map.get("target"));
		return st.render().trim();
	}

	public Entity setName(Object value) {
		this._name = value;
		return this;
	}

	public Object getName() {
		return this._name;
	}

	public boolean hasName() {
		return this._name != null;
	}

	public Entity removeName() {
		this._name = null;
		return this;
	} 
	public Entity addFields(Object _name, Object _type, Object _lexical) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		map.put("type", _type);
		map.put("lexical", _lexical);
		this._fields.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getFields() {
		return this._fields;
	}

	public Entity addFields(Entity_Fields value) {
		return addFields(value._name, value._type, value._lexical);
	}

	public java.util.stream.Stream<Entity_Fields> streamFields() {
		return this._fields.stream().map(Entity_Fields::new);
	}

	public static final class Entity_Fields {

		Object _name;
		Object _type;
		Object _lexical;

		public Entity_Fields(Object _name, Object _type, Object _lexical) {
			this._name = _name;
			this._type = _type;
			this._lexical = _lexical;
		}

		private Entity_Fields(java.util.Map<String, Object> map) {
			this._name = (Object) map.get("name");
			this._type = (Object) map.get("type");
			this._lexical = (Object) map.get("lexical");
		}

		public Object getName() {
			return this._name;
		}

		public Object getType() {
			return this._type;
		}

		public Object getLexical() {
			return this._lexical;
		}

	} 

	public Entity addRelations(Object _name, Object _type, Object _target) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		map.put("type", _type);
		map.put("target", _target);
		this._relations.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getRelations() {
		return this._relations;
	}

	public Entity addRelations(Entity_Relations value) {
		return addRelations(value._name, value._type, value._target);
	}

	public java.util.stream.Stream<Entity_Relations> streamRelations() {
		return this._relations.stream().map(Entity_Relations::new);
	}

	public static final class Entity_Relations {

		Object _name;
		Object _type;
		Object _target;

		public Entity_Relations(Object _name, Object _type, Object _target) {
			this._name = _name;
			this._type = _type;
			this._target = _target;
		}

		private Entity_Relations(java.util.Map<String, Object> map) {
			this._name = (Object) map.get("name");
			this._type = (Object) map.get("type");
			this._target = (Object) map.get("target");
		}

		public Object getName() {
			return this._name;
		}

		public Object getType() {
			return this._type;
		}

		public Object getTarget() {
			return this._target;
		}

	} 

	static final String st = "Entity(name,fields,relations) ::= <<~name~\n" + 
				"\n" + 
				"Fields:\n" + 
				"~fields:{it|~it.name~ ~it.type~ ~if(it.lexical)~lexical~endif~};separator=\"\\n\"~\n" + 
				"\n" + 
				"Relations:\n" + 
				"~relations:{it|~it.name~ ~it.type~ ~it.target~};separator=\"\\n\"~>> ";
} 