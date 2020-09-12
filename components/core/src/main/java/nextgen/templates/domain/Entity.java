package nextgen.templates.domain;

public class Entity {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private String _name;
	private Boolean _isEnum;
	private java.util.List<String> _enumValues = new java.util.ArrayList<>();
	private java.util.List<Relation> _relations = new java.util.ArrayList<>();

	Entity(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("Entity");
		st.add("name", _name);
		st.add("isEnum", _isEnum);
		for (Object o : _enumValues) st.add("enumValues", o);
		for (Object o : _relations) st.add("relations", o);
		return st.render().trim();
	}

	public Entity setName(String value) {
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

	public Entity removeName() {
		this._name = null;
		return this;
	} 

	public Entity setIsEnum(Boolean value) {
		this._isEnum = value;
		return this;
	}

	public Boolean getIsEnum() {
		return this._isEnum;
	}

	public Boolean getIsEnum(Boolean defaultValue) {
		return this._isEnum == null ? defaultValue : this._isEnum;
	}

	public boolean hasIsEnum() {
		return this._isEnum != null;
	}

	public Entity removeIsEnum() {
		this._isEnum = null;
		return this;
	} 

	public Entity addEnumValues(String value) {
		this._enumValues.add(value);
		return this;
	}

	public Entity setEnumValues(String[] value) {
		this._enumValues.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public Entity setEnumValues(java.util.Collection<String> values) {
		this._enumValues.addAll(values);
		return this;
	}

	public Entity removeEnumValues(String value) {
		this._enumValues.remove(value);
		return this;
	}

	public Entity removeEnumValues(int index) {
		this._enumValues.remove(index);
		return this;
	}

	public java.util.List<String> getEnumValues() {
		return this._enumValues;
	} 

	public Entity addRelations(Relation value) {
		this._relations.add(value);
		return this;
	}

	public Entity setRelations(Relation[] value) {
		this._relations.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public Entity setRelations(java.util.Collection<Relation> values) {
		this._relations.addAll(values);
		return this;
	}

	public Entity removeRelations(Relation value) {
		this._relations.remove(value);
		return this;
	}

	public Entity removeRelations(int index) {
		this._relations.remove(index);
		return this;
	}

	public java.util.List<Relation> getRelations() {
		return this._relations;
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

	static final String st = "Entity(name,isEnum,enumValues,relations) ::= <<Entity: ~name~ ~if(isEnum)~Enum : ~enumValues:{it|~it~};separator=\",\"~~endif~\n" + 
				"~relations:{it|~it~};separator=\"\\n\"~ >>";
}  