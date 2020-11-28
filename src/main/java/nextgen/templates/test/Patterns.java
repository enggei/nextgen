package nextgen.templates.test;

public class Patterns {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _isPublic;
	private Object _isPrivate;
	private Object _scope;

	Patterns(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("Patterns");
		st.add("isPublic", _isPublic);
		st.add("isPrivate", _isPrivate);
		st.add("scope", _scope);
		return st.render().trim();
	}

	public Patterns setIsPublic(Object value) {
		this._isPublic = value;
		return this;
	}

	public Object getIsPublic() {
		return this._isPublic;
	}

	public Object getIsPublic(Object defaultValue) {
		return this._isPublic == null ? defaultValue : this._isPublic;
	}

	public boolean hasIsPublic() {
		return this._isPublic != null;
	}

	public Patterns removeIsPublic() {
		this._isPublic = null;
		return this;
	} 

	public Patterns setIsPrivate(Object value) {
		this._isPrivate = value;
		return this;
	}

	public Object getIsPrivate() {
		return this._isPrivate;
	}

	public Object getIsPrivate(Object defaultValue) {
		return this._isPrivate == null ? defaultValue : this._isPrivate;
	}

	public boolean hasIsPrivate() {
		return this._isPrivate != null;
	}

	public Patterns removeIsPrivate() {
		this._isPrivate = null;
		return this;
	} 

	public Patterns setScope(Object value) {
		this._scope = value;
		return this;
	}

	public Object getScope() {
		return this._scope;
	}

	public Object getScope(Object defaultValue) {
		return this._scope == null ? defaultValue : this._scope;
	}

	public boolean hasScope() {
		return this._scope != null;
	}

	public Patterns removeScope() {
		this._scope = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Patterns that = (Patterns) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "Patterns(isPublic,isPrivate,scope) ::= <<Patterns for templates:\n" + 
				"\n" + 
				"Avoid to many if-elseifs:\n" + 
				"\n" + 
				"~if(isPublic)~public ~elseif(isPrivate)~private ~endif~ class {}\n" + 
				"\n" + 
				"cleaner solution:\n" + 
				"\n" + 
				"~scope~ class {}\n" + 
				"\n" + 
				"and set scope = \"public\"|\"private\" in generator (Use of STEnums is perfect for this:)\n" + 
				"\n" + 
				"STEnumExample:\n" + 
				"\n" + 
				"classDeclaration.addModifiers(Modifiers.PUBLIC).addModifiers(Modifiers.PRIVATE)\n" + 
				"\n" + 
				"With static imports:\n" + 
				"\n" + 
				"classDeclaration.addModifiers(PUBLIC).addModifiers(PRIVATE) >>";
}  