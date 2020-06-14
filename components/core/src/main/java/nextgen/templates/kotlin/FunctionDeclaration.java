package nextgen.templates.kotlin;

public class FunctionDeclaration {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _annotations;
	private Object _override;
	private Object _name;
	private Object _returnType;

	FunctionDeclaration(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("FunctionDeclaration");
		st.add("annotations", _annotations);
		st.add("override", _override);
		st.add("name", _name);
		st.add("returnType", _returnType);
		return st.render().trim();
	}

	public FunctionDeclaration setAnnotations(Object value) {
		this._annotations = value;
		return this;
	}

	public Object getAnnotations() {
		return this._annotations;
	}

	public Object getAnnotations(Object defaultValue) {
		return this._annotations == null ? defaultValue : this._annotations;
	}

	public boolean hasAnnotations() {
		return this._annotations != null;
	}

	public FunctionDeclaration removeAnnotations() {
		this._annotations = null;
		return this;
	}

	public FunctionDeclaration setOverride(Object value) {
		this._override = value;
		return this;
	}

	public Object getOverride() {
		return this._override;
	}

	public Object getOverride(Object defaultValue) {
		return this._override == null ? defaultValue : this._override;
	}

	public boolean hasOverride() {
		return this._override != null;
	}

	public FunctionDeclaration removeOverride() {
		this._override = null;
		return this;
	}

	public FunctionDeclaration setName(Object value) {
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

	public FunctionDeclaration removeName() {
		this._name = null;
		return this;
	}

	public FunctionDeclaration setReturnType(Object value) {
		this._returnType = value;
		return this;
	}

	public Object getReturnType() {
		return this._returnType;
	}

	public Object getReturnType(Object defaultValue) {
		return this._returnType == null ? defaultValue : this._returnType;
	}

	public boolean hasReturnType() {
		return this._returnType != null;
	}

	public FunctionDeclaration removeReturnType() {
		this._returnType = null;
		return this;
	}



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		FunctionDeclaration that = (FunctionDeclaration) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "FunctionDeclaration(annotations,override,name,returnType) ::= <<~annotations~~if(override)~override ~endif~fun ~name~(): ~returnType~ {\n" + 
				"	// TODO: Expression body / expression statememt\n" + 
				"}>>";
} 