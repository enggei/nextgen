package nextgen.templates.kotlin;

public class FunctionDeclaration implements CompilationUnit {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Boolean _override;
	private String _name;
	private TypeDeclaration _returnType;
	private Expression _expressionBody;
	private java.util.List<AnnotationDeclaration> _annotations = new java.util.ArrayList<>();
	private java.util.List<FunctionParam> _params = new java.util.ArrayList<>();
	private java.util.List<Statement> _statements = new java.util.ArrayList<>();

	FunctionDeclaration(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("FunctionDeclaration");
		st.add("override", _override);
		st.add("name", _name);
		st.add("returnType", _returnType);
		st.add("expressionBody", _expressionBody);
		for (Object o : _annotations) st.add("annotations", o);
		for (Object o : _params) st.add("params", o);
		for (Object o : _statements) st.add("statements", o);
		return st.render().trim();
	}

	public FunctionDeclaration setOverride(Boolean value) {
		this._override = value;
		return this;
	}

	public Boolean getOverride() {
		return this._override;
	}

	public Boolean getOverride(Boolean defaultValue) {
		return this._override == null ? defaultValue : this._override;
	}

	public boolean hasOverride() {
		return this._override != null;
	}

	public FunctionDeclaration removeOverride() {
		this._override = null;
		return this;
	} 

	public FunctionDeclaration setName(String value) {
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

	public FunctionDeclaration removeName() {
		this._name = null;
		return this;
	} 

	public FunctionDeclaration setReturnType(TypeDeclaration value) {
		this._returnType = value;
		return this;
	}

	public TypeDeclaration getReturnType() {
		return this._returnType;
	}

	public TypeDeclaration getReturnType(TypeDeclaration defaultValue) {
		return this._returnType == null ? defaultValue : this._returnType;
	}

	public boolean hasReturnType() {
		return this._returnType != null;
	}

	public FunctionDeclaration removeReturnType() {
		this._returnType = null;
		return this;
	} 

	public FunctionDeclaration setExpressionBody(Expression value) {
		this._expressionBody = value;
		return this;
	}

	public Expression getExpressionBody() {
		return this._expressionBody;
	}

	public Expression getExpressionBody(Expression defaultValue) {
		return this._expressionBody == null ? defaultValue : this._expressionBody;
	}

	public boolean hasExpressionBody() {
		return this._expressionBody != null;
	}

	public FunctionDeclaration removeExpressionBody() {
		this._expressionBody = null;
		return this;
	} 

	public FunctionDeclaration addAnnotations(AnnotationDeclaration value) {
		this._annotations.add(value);
		return this;
	}

	public FunctionDeclaration setAnnotations(AnnotationDeclaration[] value) {
		this._annotations.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public FunctionDeclaration setAnnotations(java.util.Collection<AnnotationDeclaration> values) {
		this._annotations.addAll(values);
		return this;
	}

	public FunctionDeclaration removeAnnotations(AnnotationDeclaration value) {
		this._annotations.remove(value);
		return this;
	}

	public FunctionDeclaration removeAnnotations(int index) {
		this._annotations.remove(index);
		return this;
	}

	public java.util.List<AnnotationDeclaration> getAnnotations() {
		return this._annotations;
	} 

	public FunctionDeclaration addParams(FunctionParam value) {
		this._params.add(value);
		return this;
	}

	public FunctionDeclaration setParams(FunctionParam[] value) {
		this._params.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public FunctionDeclaration setParams(java.util.Collection<FunctionParam> values) {
		this._params.addAll(values);
		return this;
	}

	public FunctionDeclaration removeParams(FunctionParam value) {
		this._params.remove(value);
		return this;
	}

	public FunctionDeclaration removeParams(int index) {
		this._params.remove(index);
		return this;
	}

	public java.util.List<FunctionParam> getParams() {
		return this._params;
	} 

	public FunctionDeclaration addStatements(Statement value) {
		this._statements.add(value);
		return this;
	}

	public FunctionDeclaration setStatements(Statement[] value) {
		this._statements.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public FunctionDeclaration setStatements(java.util.Collection<Statement> values) {
		this._statements.addAll(values);
		return this;
	}

	public FunctionDeclaration removeStatements(Statement value) {
		this._statements.remove(value);
		return this;
	}

	public FunctionDeclaration removeStatements(int index) {
		this._statements.remove(index);
		return this;
	}

	public java.util.List<Statement> getStatements() {
		return this._statements;
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

	static final String st = "FunctionDeclaration(annotations,override,name,params,returnType,expressionBody,statements) ::= <<~annotations:{it|~it~};separator=\"\\n\"~\n" + 
				"~if(override)~override ~endif~fun ~name~(~params:{it|~it~};separator=\", \"~)~if(returnType)~: ~returnType~~endif~~if(expressionBody)~ =\n" + 
				"	~expressionBody~~else~ {\n" + 
				"	~statements:{it|~it~};separator=\"\\n\"~\n" + 
				"}~endif~ >>";
}  