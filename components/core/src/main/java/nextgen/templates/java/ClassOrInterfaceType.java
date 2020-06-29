package nextgen.templates.java;

public class ClassOrInterfaceType {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _scope;
	private Object _isTyped;
	private Object _isArrayType;
	private java.util.List<Object> _names = new java.util.ArrayList<>();
	private java.util.List<Object> _typeArguments = new java.util.ArrayList<>();

	ClassOrInterfaceType(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("ClassOrInterfaceType");
		st.add("scope", _scope);
		st.add("isTyped", _isTyped);
		st.add("isArrayType", _isArrayType);
		for (Object o : _names) st.add("names", o);
		for (Object o : _typeArguments) st.add("typeArguments", o);
		return st.render().trim();
	}

	public ClassOrInterfaceType setScope(Object value) {
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

	public ClassOrInterfaceType removeScope() {
		this._scope = null;
		return this;
	} 

	public ClassOrInterfaceType setIsTyped(Object value) {
		this._isTyped = value;
		return this;
	}

	public Object getIsTyped() {
		return this._isTyped;
	}

	public Object getIsTyped(Object defaultValue) {
		return this._isTyped == null ? defaultValue : this._isTyped;
	}

	public boolean hasIsTyped() {
		return this._isTyped != null;
	}

	public ClassOrInterfaceType removeIsTyped() {
		this._isTyped = null;
		return this;
	} 

	public ClassOrInterfaceType setIsArrayType(Object value) {
		this._isArrayType = value;
		return this;
	}

	public Object getIsArrayType() {
		return this._isArrayType;
	}

	public Object getIsArrayType(Object defaultValue) {
		return this._isArrayType == null ? defaultValue : this._isArrayType;
	}

	public boolean hasIsArrayType() {
		return this._isArrayType != null;
	}

	public ClassOrInterfaceType removeIsArrayType() {
		this._isArrayType = null;
		return this;
	} 

	public ClassOrInterfaceType addNames(Object value) {
		this._names.add(value);
		return this;
	}

	public ClassOrInterfaceType setNames(Object[] value) {
		this._names.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public ClassOrInterfaceType setNames(java.util.Collection<Object> values) {
		this._names.addAll(values);
		return this;
	}

	public ClassOrInterfaceType removeNames(Object value) {
		this._names.remove(value);
		return this;
	}

	public ClassOrInterfaceType removeNames(int index) {
		this._names.remove(index);
		return this;
	}

	public java.util.List<Object> getNames() {
		return this._names;
	} 

	public ClassOrInterfaceType addTypeArguments(Object value) {
		this._typeArguments.add(value);
		return this;
	}

	public ClassOrInterfaceType setTypeArguments(Object[] value) {
		this._typeArguments.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public ClassOrInterfaceType setTypeArguments(java.util.Collection<Object> values) {
		this._typeArguments.addAll(values);
		return this;
	}

	public ClassOrInterfaceType removeTypeArguments(Object value) {
		this._typeArguments.remove(value);
		return this;
	}

	public ClassOrInterfaceType removeTypeArguments(int index) {
		this._typeArguments.remove(index);
		return this;
	}

	public java.util.List<Object> getTypeArguments() {
		return this._typeArguments;
	} 


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ClassOrInterfaceType that = (ClassOrInterfaceType) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "ClassOrInterfaceType(scope,names,typeArguments,isTyped,isArrayType) ::= <<~if(scope)~~scope~.~endif~~names:{it|~it~};separator=\" | \"~~if(typeArguments)~<~typeArguments:{it|~it~};separator=\", \"~>~else~~if(isTyped)~<>~endif~~endif~~if(isArrayType)~[]~endif~ >>";
}  