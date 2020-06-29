package nextgen.templates.kotlin;

public class VarDeclarationStatement implements Statement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Boolean _isMutable;
	private String _name;
	private TypeDeclaration _type;
	private Expression _initializer;

	VarDeclarationStatement(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("VarDeclarationStatement");
		st.add("isMutable", _isMutable);
		st.add("name", _name);
		st.add("type", _type);
		st.add("initializer", _initializer);
		return st.render().trim();
	}

	public VarDeclarationStatement setIsMutable(Boolean value) {
		this._isMutable = value;
		return this;
	}

	public Boolean getIsMutable() {
		return this._isMutable;
	}

	public Boolean getIsMutable(Boolean defaultValue) {
		return this._isMutable == null ? defaultValue : this._isMutable;
	}

	public boolean hasIsMutable() {
		return this._isMutable != null;
	}

	public VarDeclarationStatement removeIsMutable() {
		this._isMutable = null;
		return this;
	} 

	public VarDeclarationStatement setName(String value) {
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

	public VarDeclarationStatement removeName() {
		this._name = null;
		return this;
	} 

	public VarDeclarationStatement setType(TypeDeclaration value) {
		this._type = value;
		return this;
	}

	public TypeDeclaration getType() {
		return this._type;
	}

	public TypeDeclaration getType(TypeDeclaration defaultValue) {
		return this._type == null ? defaultValue : this._type;
	}

	public boolean hasType() {
		return this._type != null;
	}

	public VarDeclarationStatement removeType() {
		this._type = null;
		return this;
	} 

	public VarDeclarationStatement setInitializer(Expression value) {
		this._initializer = value;
		return this;
	}

	public Expression getInitializer() {
		return this._initializer;
	}

	public Expression getInitializer(Expression defaultValue) {
		return this._initializer == null ? defaultValue : this._initializer;
	}

	public boolean hasInitializer() {
		return this._initializer != null;
	}

	public VarDeclarationStatement removeInitializer() {
		this._initializer = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		VarDeclarationStatement that = (VarDeclarationStatement) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "VarDeclarationStatement(isMutable,name,type,initializer) ::= <<~if(isMutable)~var ~else~val ~endif~~name~: ~type~~if(initializer)~ = ~initializer~~endif~ >>";
}  