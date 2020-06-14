package nextgen.templates.neo4j;

public class NeoFactoryPropertyAccessors {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _entity;
	private String _propertyName;
	private Object _propertyType;
	private Boolean _isEnum;

	NeoFactoryPropertyAccessors(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("NeoFactoryPropertyAccessors");
		st.add("entity", _entity);
		st.add("propertyName", _propertyName);
		st.add("propertyType", _propertyType);
		st.add("isEnum", _isEnum);
		return st.render().trim();
	}

	public NeoFactoryPropertyAccessors setEntity(Object value) {
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

	public NeoFactoryPropertyAccessors removeEntity() {
		this._entity = null;
		return this;
	} 

	public NeoFactoryPropertyAccessors setPropertyName(String value) {
		this._propertyName = value;
		return this;
	}

	public String getPropertyName() {
		return this._propertyName;
	}

	public String getPropertyName(String defaultValue) {
		return this._propertyName == null ? defaultValue : this._propertyName;
	}

	public boolean hasPropertyName() {
		return this._propertyName != null;
	}

	public NeoFactoryPropertyAccessors removePropertyName() {
		this._propertyName = null;
		return this;
	} 

	public NeoFactoryPropertyAccessors setPropertyType(Object value) {
		this._propertyType = value;
		return this;
	}

	public Object getPropertyType() {
		return this._propertyType;
	}

	public Object getPropertyType(Object defaultValue) {
		return this._propertyType == null ? defaultValue : this._propertyType;
	}

	public boolean hasPropertyType() {
		return this._propertyType != null;
	}

	public NeoFactoryPropertyAccessors removePropertyType() {
		this._propertyType = null;
		return this;
	} 

	public NeoFactoryPropertyAccessors setIsEnum(Boolean value) {
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

	public NeoFactoryPropertyAccessors removeIsEnum() {
		this._isEnum = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		NeoFactoryPropertyAccessors that = (NeoFactoryPropertyAccessors) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "NeoFactoryPropertyAccessors(entity,propertyName,propertyType,isEnum) ::= <<public ~entity;format=\"capitalize\"~ find~entity;format=\"capitalize\"~By~propertyName;format=\"capitalize\"~(~propertyType~ value) {\n" + 
				"	final org.neo4j.graphdb.Node node = db.findNode(org.neo4j.graphdb.Label.label(\"~entity~\"), \"~propertyName~\", value~if(isEnum)~.name()~endif~);\n" + 
				"	return node == null ? null : new ~entity;format=\"capitalize\"~(node);\n" + 
				"}\n" + 
				"\n" + 
				"public ~entity;format=\"capitalize\"~ findOrCreate~entity;format=\"capitalize\"~By~propertyName;format=\"capitalize\"~(~propertyType~ value) {\n" + 
				"	final ~entity;format=\"capitalize\"~ existing = find~entity;format=\"capitalize\"~By~propertyName;format=\"capitalize\"~(value);\n" + 
				"	return existing == null ? new~entity;format=\"capitalize\"~().set~propertyName;format=\"capitalize\"~(value) : existing;\n" + 
				"}\n" + 
				"\n" + 
				"public java.util.stream.Stream<~entity;format=\"capitalize\"~> findAll~entity;format=\"capitalize\"~By~propertyName;format=\"capitalize\"~(~propertyType~ value) {\n" + 
				"	return db.findNodes(org.neo4j.graphdb.Label.label(\"~entity~\"), \"~propertyName~\", value~if(isEnum)~.name()~endif~).stream().map(this::new~entity;format=\"capitalize\"~);\n" + 
				"} >>";
} 