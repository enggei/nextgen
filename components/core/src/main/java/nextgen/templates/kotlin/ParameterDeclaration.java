package nextgen.templates.kotlin;

public class ParameterDeclaration implements ParameterDefinition {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private String _name;
	private TypeDeclaration _type;
	private Expression _initializer;

	ParameterDeclaration(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("ParameterDeclaration");
		st.add("name", _name);
		st.add("type", _type);
		st.add("initializer", _initializer);
		return st.render().trim();
	}

	public ParameterDeclaration setName(String value) {
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

	public ParameterDeclaration removeName() {
		this._name = null;
		return this;
	} 

	public ParameterDeclaration setType(TypeDeclaration value) {
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

	public ParameterDeclaration removeType() {
		this._type = null;
		return this;
	} 

	public ParameterDeclaration setInitializer(Expression value) {
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

	public ParameterDeclaration removeInitializer() {
		this._initializer = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ParameterDeclaration that = (ParameterDeclaration) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "ParameterDeclaration(name,type,initializer) ::= <<~name~~if(type)~: ~type~~endif~~if(initializer)~ = ~initializer~~endif~ >>";
}  