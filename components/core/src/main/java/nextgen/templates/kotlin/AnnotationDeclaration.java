package nextgen.templates.kotlin;

public class AnnotationDeclaration {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private String _scope;
	private String _name;
	private java.util.List<Expression> _params = new java.util.ArrayList<>();

	AnnotationDeclaration(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("AnnotationDeclaration");
		st.add("scope", _scope);
		st.add("name", _name);
		for (Object o : _params) st.add("params", o);
		return st.render().trim();
	}

	public AnnotationDeclaration setScope(String value) {
		this._scope = value;
		return this;
	}

	public String getScope() {
		return this._scope;
	}

	public String getScope(String defaultValue) {
		return this._scope == null ? defaultValue : this._scope;
	}

	public boolean hasScope() {
		return this._scope != null;
	}

	public AnnotationDeclaration removeScope() {
		this._scope = null;
		return this;
	} 

	public AnnotationDeclaration setName(String value) {
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

	public AnnotationDeclaration removeName() {
		this._name = null;
		return this;
	} 

	public AnnotationDeclaration addParams(Expression value) {
		this._params.add(value);
		return this;
	}

	public AnnotationDeclaration setParams(Expression[] value) {
		this._params.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public AnnotationDeclaration setParams(java.util.Collection<Expression> values) {
		this._params.addAll(values);
		return this;
	}

	public AnnotationDeclaration removeParams(Expression value) {
		this._params.remove(value);
		return this;
	}

	public AnnotationDeclaration removeParams(int index) {
		this._params.remove(index);
		return this;
	}

	public java.util.List<Expression> getParams() {
		return this._params;
	} 


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		AnnotationDeclaration that = (AnnotationDeclaration) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "AnnotationDeclaration(scope,name,params) ::= <<@~if(scope)~~scope~.~endif~~name~~if(params)~(~params:{it|~it~};separator=\", \"~)~endif~ >>";
}  