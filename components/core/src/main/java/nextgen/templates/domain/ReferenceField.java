package nextgen.templates.domain;

public class ReferenceField {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private String _name;
	private Entity _entity;
	private Boolean _lexical;
	private Boolean _self;

	ReferenceField(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ReferenceField that = (ReferenceField) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("ReferenceField");
		st.add("name", _name);
		st.add("entity", _entity);
		st.add("lexical", _lexical);
		st.add("self", _self);
		return st.render().trim();
	}

	public ReferenceField setName(String value) {
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

	public ReferenceField removeName() {
		this._name = null;
		return this;
	} 

	public ReferenceField setEntity(Entity value) {
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

	public ReferenceField removeEntity() {
		this._entity = null;
		return this;
	} 

	public ReferenceField setLexical(Boolean value) {
		this._lexical = value;
		return this;
	}

	public Boolean getLexical() {
		return this._lexical;
	}

	public Boolean getLexical(Boolean defaultValue) {
		return this._lexical == null ? defaultValue : this._lexical;
	}

	public boolean hasLexical() {
		return this._lexical != null;
	}

	public ReferenceField removeLexical() {
		this._lexical = null;
		return this;
	} 

	public ReferenceField setSelf(Boolean value) {
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

	public ReferenceField removeSelf() {
		this._self = null;
		return this;
	} 

	static final String st = "ReferenceField(name,entity,lexical,self) ::= <<Entity field : ~name~ ~entity~~if(lexical)~ lexical~endif~~if(self)~ self-referential~endif~>> ";
} 