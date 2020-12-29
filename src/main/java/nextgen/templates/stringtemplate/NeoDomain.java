package nextgen.templates.stringtemplate;

public class NeoDomain {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _name;
	private Object _package;
	private java.util.List<Object> _finders = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _entities = new java.util.ArrayList<>();

	NeoDomain(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("NeoDomain");
		st.add("name", _name);
		st.add("package", _package);
		for (Object o : _finders) st.add("finders", o);
		for (java.util.Map<String, Object> map : _entities) st.addAggr("entities.{name}", map.get("name"));
		return st.render().trim();
	}

	public NeoDomain setName(Object value) {
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

	public NeoDomain removeName() {
		this._name = null;
		return this;
	} 

	public NeoDomain setPackage(Object value) {
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

	public NeoDomain removePackage() {
		this._package = null;
		return this;
	} 

	public NeoDomain addFinders(Object value) {
		this._finders.add(value);
		return this;
	}

	public NeoDomain setFinders(Object[] value) {
		this._finders.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public NeoDomain setFinders(java.util.Collection<Object> values) {
		this._finders.addAll(values);
		return this;
	}

	public NeoDomain removeFinders(Object value) {
		this._finders.remove(value);
		return this;
	}

	public NeoDomain removeFinders(int index) {
		this._finders.remove(index);
		return this;
	}

	public java.util.List<Object> getFinders() {
		return this._finders;
	} 

	public NeoDomain setEntities(java.util.Collection<NeoDomain_Entities> values) {
			this._entities.clear();
			values.stream().map(NeoDomain_Entities::asMap).forEach(map -> _entities.add(map));
			return this;
		}

	public NeoDomain addEntities(Object _name) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		this._entities.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getEntities() {
		return this._entities;
	}

	public NeoDomain addEntities(NeoDomain_Entities value) {
		return addEntities(value._name);
	}

	public java.util.stream.Stream<NeoDomain_Entities> streamEntities() {
		return this._entities.stream().map(NeoDomain_Entities::new);
	}

	public java.util.List<Object> getEntities_Name() {
		return streamEntities().map(NeoDomain_Entities::getName).collect(java.util.stream.Collectors.toList());
	}


	public static final class NeoDomain_Entities {

		Object _name;

		public NeoDomain_Entities(Object _name) {
			this._name = _name;
		}

		private NeoDomain_Entities(java.util.Map<String, Object> map) {
			this._name = (Object) map.get("name");
		}

		public Object getName() {
			return this._name;
		}


		public java.util.Map<String, Object> asMap() {
			java.util.Map<String, Object> map = new java.util.LinkedHashMap<>();
			map.put("name", _name);
			return map;
		}

	}  

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		NeoDomain that = (NeoDomain) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "NeoDomain(name,package,finders,entities) ::= <<package ~package~;\n" + 
				"\n" + 
				"import nextgen.st.model.*;\n" + 
				"import org.neo4j.graphdb.Node;\n" + 
				"import java.util.Optional;\n" + 
				"import java.util.stream.Stream;\n" + 
				"\n" + 
				"public class ~name;format=\"capitalize\"~ {\n" + 
				"\n" + 
				"	private final STModelDB db;\n" + 
				"\n" + 
				"	public ~name;format=\"capitalize\"~(STModelDB db) {\n" + 
				"		this.db = db;\n" + 
				"	}\n" + 
				"\n" + 
				"~entities:{it|\n" + 
				"	public ~it.name;format=\"capitalize\"~ new~it.name;format=\"capitalize\"~() {\n" + 
				"		return new ~it.name;format=\"capitalize\"~(db);\n" + 
				"	~eom()~\n" + 
				"\n" + 
				"	public ~it.name;format=\"capitalize\"~ new~it.name;format=\"capitalize\"~(STModel stModel) {\n" + 
				"		return new ~it.name;format=\"capitalize\"~(db, stModel);\n" + 
				"	~eom()~\n" + 
				"\n" + 
				"	public ~it.name;format=\"capitalize\"~ new~it.name;format=\"capitalize\"~(Node node) {\n" + 
				"		return new ~it.name;format=\"capitalize\"~(db, node);\n" + 
				"	~eom()~\n" + 
				"\n" + 
				"	public Stream<~it.name;format=\"capitalize\"~> findAll~it.name;format=\"capitalize\"~() {\n" + 
				"		return db.findAllSTModelByStTemplate(~it.name;format=\"capitalize\"~.stTemplateUuid)\n" + 
				"				.map(stModel -> new ~it.name;format=\"capitalize\"~(db, stModel));\n" + 
				"	~eom()~\n" + 
				"\n" + 
				"	public ~it.name;format=\"capitalize\"~ find~it.name;format=\"capitalize\"~(String uuid) {\n" + 
				"		final STModel stModel = db.findSTModelByUuid(uuid);\n" + 
				"		return stModel == null ? new ~it.name;format=\"capitalize\"~(db, uuid) : new ~it.name;format=\"capitalize\"~(db, stModel);\n" + 
				"	~eom()~\n" + 
				"};separator=\"\\n\\n\"~\n" + 
				"\n" + 
				"	~finders:{it|~it~};separator=\"\\n\\n\"~\n" + 
				"} >>";
}  