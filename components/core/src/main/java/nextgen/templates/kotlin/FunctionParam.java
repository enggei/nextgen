package nextgen.templates.kotlin;

public class FunctionParam {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private String _name;
	private TypeDeclaration _typeDeclaration;
	private Expression _defaultValue;

	FunctionParam(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("FunctionParam");
		st.add("name", _name);
		st.add("typeDeclaration", _typeDeclaration);
		st.add("defaultValue", _defaultValue);
		return st.render().trim();
	}

	public FunctionParam setName(String value) {
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

	public FunctionParam removeName() {
		this._name = null;
		return this;
	} 

	public FunctionParam setTypeDeclaration(TypeDeclaration value) {
		this._typeDeclaration = value;
		return this;
	}

	public TypeDeclaration getTypeDeclaration() {
		return this._typeDeclaration;
	}

	public TypeDeclaration getTypeDeclaration(TypeDeclaration defaultValue) {
		return this._typeDeclaration == null ? defaultValue : this._typeDeclaration;
	}

	public boolean hasTypeDeclaration() {
		return this._typeDeclaration != null;
	}

	public FunctionParam removeTypeDeclaration() {
		this._typeDeclaration = null;
		return this;
	} 

	public FunctionParam setDefaultValue(Expression value) {
		this._defaultValue = value;
		return this;
	}

	public Expression getDefaultValue() {
		return this._defaultValue;
	}

	public Expression getDefaultValue(Expression defaultValue) {
		return this._defaultValue == null ? defaultValue : this._defaultValue;
	}

	public boolean hasDefaultValue() {
		return this._defaultValue != null;
	}

	public FunctionParam removeDefaultValue() {
		this._defaultValue = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		FunctionParam that = (FunctionParam) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "FunctionParam(name,typeDeclaration,defaultValue) ::= <<~name~: ~typeDeclaration~~if(defaultValue)~ = ~defaultValue~~endif~ >>";
} 