package nextgen.templates.domain;

public class ReferenceList {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private String _name;
	private Entity _entity;
	private Boolean _self;

	ReferenceList(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ReferenceList that = (ReferenceList) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("ReferenceList");
		st.add("name", _name);
		st.add("entity", _entity);
		st.add("self", _self);
		return st.render().trim();
	}

	public ReferenceList setName(String value) {
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

	public ReferenceList removeName() {
		this._name = null;
		return this;
	} 

	public ReferenceList setEntity(Entity value) {
		this._entity = value;
		return this;
	}

	public Entity getEntity() {
		return this._entity;
	}

	public Entity getEntity(Entity defaultValue) {
		return this._entity == null ? defaultValue : this._entity;
	}

	public boolean hasEntity() {
		return this._entity != null;
	}

	public ReferenceList removeEntity() {
		this._entity = null;
		return this;
	} 

	public ReferenceList setSelf(Boolean value) {
		this._self = value;
		return this;
	}

	public Boolean getSelf() {
		return this._self;
	}

	public Boolean getSelf(Boolean defaultValue) {
		return this._self == null ? defaultValue : this._self;
	}

	public boolean hasSelf() {
		return this._self != null;
	}

	public ReferenceList removeSelf() {
		this._self = null;
		return this;
	} 

	static final String st = "ReferenceList(name,entity,self) ::= <<One-to-many ~name~ ~entity~~if(self)~ self~endif~>> ";
} 