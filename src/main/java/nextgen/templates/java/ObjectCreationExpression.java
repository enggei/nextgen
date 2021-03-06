package nextgen.templates.java;

public class ObjectCreationExpression implements Expression {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _emptyClassBody;
	private Object _type;
	private Object _scope;
	private java.util.List<Object> _typeArguments = new java.util.ArrayList<>();
	private java.util.List<Object> _anonymousClassBodies = new java.util.ArrayList<>();
	private java.util.List<Object> _arguments = new java.util.ArrayList<>();

	ObjectCreationExpression(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("ObjectCreationExpression");
		st.add("emptyClassBody", _emptyClassBody);
		st.add("type", _type);
		st.add("scope", _scope);
		for (Object o : _typeArguments) st.add("typeArguments", o);
		for (Object o : _anonymousClassBodies) st.add("anonymousClassBodies", o);
		for (Object o : _arguments) st.add("arguments", o);
		return st.render().trim();
	}

	public ObjectCreationExpression setEmptyClassBody(Object value) {
		this._emptyClassBody = value;
		return this;
	}

	public Object getEmptyClassBody() {
		return this._emptyClassBody;
	}

	public Object getEmptyClassBody(Object defaultValue) {
		return this._emptyClassBody == null ? defaultValue : this._emptyClassBody;
	}

	public boolean hasEmptyClassBody() {
		return this._emptyClassBody != null;
	}

	public ObjectCreationExpression removeEmptyClassBody() {
		this._emptyClassBody = null;
		return this;
	} 

	public ObjectCreationExpression setType(Object value) {
		this._type = value;
		return this;
	}

	public Object getType() {
		return this._type;
	}

	public Object getType(Object defaultValue) {
		return this._type == null ? defaultValue : this._type;
	}

	public boolean hasType() {
		return this._type != null;
	}

	public ObjectCreationExpression removeType() {
		this._type = null;
		return this;
	} 

	public ObjectCreationExpression setScope(Object value) {
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

	public ObjectCreationExpression removeScope() {
		this._scope = null;
		return this;
	} 

	public ObjectCreationExpression addTypeArguments(Object value) {
		this._typeArguments.add(value);
		return this;
	}

	public ObjectCreationExpression setTypeArguments(Object[] value) {
		this._typeArguments.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public ObjectCreationExpression setTypeArguments(java.util.Collection<Object> values) {
		this._typeArguments.addAll(values);
		return this;
	}

	public ObjectCreationExpression removeTypeArguments(Object value) {
		this._typeArguments.remove(value);
		return this;
	}

	public ObjectCreationExpression removeTypeArguments(int index) {
		this._typeArguments.remove(index);
		return this;
	}

	public java.util.List<Object> getTypeArguments() {
		return this._typeArguments;
	} 

	public ObjectCreationExpression addAnonymousClassBodies(Object value) {
		this._anonymousClassBodies.add(value);
		return this;
	}

	public ObjectCreationExpression setAnonymousClassBodies(Object[] value) {
		this._anonymousClassBodies.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public ObjectCreationExpression setAnonymousClassBodies(java.util.Collection<Object> values) {
		this._anonymousClassBodies.addAll(values);
		return this;
	}

	public ObjectCreationExpression removeAnonymousClassBodies(Object value) {
		this._anonymousClassBodies.remove(value);
		return this;
	}

	public ObjectCreationExpression removeAnonymousClassBodies(int index) {
		this._anonymousClassBodies.remove(index);
		return this;
	}

	public java.util.List<Object> getAnonymousClassBodies() {
		return this._anonymousClassBodies;
	} 

	public ObjectCreationExpression addArguments(Object value) {
		this._arguments.add(value);
		return this;
	}

	public ObjectCreationExpression setArguments(Object[] value) {
		this._arguments.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public ObjectCreationExpression setArguments(java.util.Collection<Object> values) {
		this._arguments.addAll(values);
		return this;
	}

	public ObjectCreationExpression removeArguments(Object value) {
		this._arguments.remove(value);
		return this;
	}

	public ObjectCreationExpression removeArguments(int index) {
		this._arguments.remove(index);
		return this;
	}

	public java.util.List<Object> getArguments() {
		return this._arguments;
	} 


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ObjectCreationExpression that = (ObjectCreationExpression) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "ObjectCreationExpression(emptyClassBody,typeArguments,type,anonymousClassBodies,arguments,scope) ::= <<new ~if(scope)~~scope~.~endif~~type~~if(typeArguments)~<~typeArguments:{it|~it~};separator=\", \"~>~endif~(~arguments:{it|~it~};separator=\", \"~)~if(anonymousClassBodies)~ {\n" + 
				"\n" + 
				"	~anonymousClassBodies:{it|~it~};separator=\"\\n\"~\n" + 
				"\n" + 
				"}~elseif(emptyClassBody)~ {\n" + 
				"}~endif~ >>";
}  