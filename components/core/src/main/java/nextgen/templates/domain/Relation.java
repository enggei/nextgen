package nextgen.templates.domain;

public class Relation {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private String _name;
	private RelationType _type;
	private Object _dst;
	private Boolean _lexical;
	private Boolean _self;

	Relation(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Deprecated
	public java.util.UUID uuid() {
		return uuid;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("Relation");
		st.add("name", _name);
		st.add("type", _type);
		st.add("dst", _dst);
		st.add("lexical", _lexical);
		st.add("self", _self);
		return st.render().trim();
	}

	public Relation setName(String value) {
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

	public Relation removeName() {
		this._name = null;
		return this;
	} 

	public Relation setType(RelationType value) {
		this._type = value;
		return this;
	}

	public RelationType getType() {
		return this._type;
	}

	public RelationType getType(RelationType defaultValue) {
		return this._type == null ? defaultValue : this._type;
	}

	public boolean hasType() {
		return this._type != null;
	}

	public Relation removeType() {
		this._type = null;
		return this;
	} 

	public Relation setDst(Object value) {
		this._dst = value;
		return this;
	}

	public Object getDst() {
		return this._dst;
	}

	public Object getDst(Object defaultValue) {
		return this._dst == null ? defaultValue : this._dst;
	}

	public boolean hasDst() {
		return this._dst != null;
	}

	public Relation removeDst() {
		this._dst = null;
		return this;
	} 

	public Relation setLexical(Boolean value) {
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

	public Relation removeLexical() {
		this._lexical = null;
		return this;
	} 

	public Relation setSelf(Boolean value) {
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

	public Relation removeSelf() {
		this._self = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Relation that = (Relation) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "Relation(name,type,dst,lexical,self) ::= <<~name~ ~type~ ~dst~~if(lexical)~ lexical~endif~~if(self)~ self-referential~endif~ >>";
}  