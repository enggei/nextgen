package nextgen.templates.java;

public class MethodDeclaration {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _type;
	private Object _name;
	private Object _isInterfaceDeclaration;
	private Object _blockStmt;
	private java.util.List<Object> _annotations = new java.util.ArrayList<>();
	private java.util.List<Object> _modifiers = new java.util.ArrayList<>();
	private java.util.List<Object> _typeParameters = new java.util.ArrayList<>();
	private java.util.List<Object> _parameters = new java.util.ArrayList<>();
	private java.util.List<Object> _thrownExceptions = new java.util.ArrayList<>();

	MethodDeclaration(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("MethodDeclaration");
		st.add("type", _type);
		st.add("name", _name);
		st.add("isInterfaceDeclaration", _isInterfaceDeclaration);
		st.add("blockStmt", _blockStmt);
		for (Object o : _annotations) st.add("annotations", o);
		for (Object o : _modifiers) st.add("modifiers", o);
		for (Object o : _typeParameters) st.add("typeParameters", o);
		for (Object o : _parameters) st.add("parameters", o);
		for (Object o : _thrownExceptions) st.add("thrownExceptions", o);
		return st.render().trim();
	}

	public MethodDeclaration setType(Object value) {
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

	public MethodDeclaration removeType() {
		this._type = null;
		return this;
	} 

	public MethodDeclaration setName(Object value) {
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

	public MethodDeclaration removeName() {
		this._name = null;
		return this;
	} 

	public MethodDeclaration setIsInterfaceDeclaration(Object value) {
		this._isInterfaceDeclaration = value;
		return this;
	}

	public Object getIsInterfaceDeclaration() {
		return this._isInterfaceDeclaration;
	}

	public Object getIsInterfaceDeclaration(Object defaultValue) {
		return this._isInterfaceDeclaration == null ? defaultValue : this._isInterfaceDeclaration;
	}

	public boolean hasIsInterfaceDeclaration() {
		return this._isInterfaceDeclaration != null;
	}

	public MethodDeclaration removeIsInterfaceDeclaration() {
		this._isInterfaceDeclaration = null;
		return this;
	} 

	public MethodDeclaration setBlockStmt(Object value) {
		this._blockStmt = value;
		return this;
	}

	public Object getBlockStmt() {
		return this._blockStmt;
	}

	public Object getBlockStmt(Object defaultValue) {
		return this._blockStmt == null ? defaultValue : this._blockStmt;
	}

	public boolean hasBlockStmt() {
		return this._blockStmt != null;
	}

	public MethodDeclaration removeBlockStmt() {
		this._blockStmt = null;
		return this;
	} 

	public MethodDeclaration addAnnotations(Object value) {
		this._annotations.add(value);
		return this;
	}

	public MethodDeclaration setAnnotations(Object[] value) {
		this._annotations.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public MethodDeclaration setAnnotations(java.util.Collection<Object> values) {
		this._annotations.addAll(values);
		return this;
	}

	public MethodDeclaration removeAnnotations(Object value) {
		this._annotations.remove(value);
		return this;
	}

	public MethodDeclaration removeAnnotations(int index) {
		this._annotations.remove(index);
		return this;
	}

	public java.util.List<Object> getAnnotations() {
		return this._annotations;
	} 

	public MethodDeclaration addModifiers(Object value) {
		this._modifiers.add(value);
		return this;
	}

	public MethodDeclaration setModifiers(Object[] value) {
		this._modifiers.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public MethodDeclaration setModifiers(java.util.Collection<Object> values) {
		this._modifiers.addAll(values);
		return this;
	}

	public MethodDeclaration removeModifiers(Object value) {
		this._modifiers.remove(value);
		return this;
	}

	public MethodDeclaration removeModifiers(int index) {
		this._modifiers.remove(index);
		return this;
	}

	public java.util.List<Object> getModifiers() {
		return this._modifiers;
	} 

	public MethodDeclaration addTypeParameters(Object value) {
		this._typeParameters.add(value);
		return this;
	}

	public MethodDeclaration setTypeParameters(Object[] value) {
		this._typeParameters.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public MethodDeclaration setTypeParameters(java.util.Collection<Object> values) {
		this._typeParameters.addAll(values);
		return this;
	}

	public MethodDeclaration removeTypeParameters(Object value) {
		this._typeParameters.remove(value);
		return this;
	}

	public MethodDeclaration removeTypeParameters(int index) {
		this._typeParameters.remove(index);
		return this;
	}

	public java.util.List<Object> getTypeParameters() {
		return this._typeParameters;
	} 

	public MethodDeclaration addParameters(Object value) {
		this._parameters.add(value);
		return this;
	}

	public MethodDeclaration setParameters(Object[] value) {
		this._parameters.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public MethodDeclaration setParameters(java.util.Collection<Object> values) {
		this._parameters.addAll(values);
		return this;
	}

	public MethodDeclaration removeParameters(Object value) {
		this._parameters.remove(value);
		return this;
	}

	public MethodDeclaration removeParameters(int index) {
		this._parameters.remove(index);
		return this;
	}

	public java.util.List<Object> getParameters() {
		return this._parameters;
	} 

	public MethodDeclaration addThrownExceptions(Object value) {
		this._thrownExceptions.add(value);
		return this;
	}

	public MethodDeclaration setThrownExceptions(Object[] value) {
		this._thrownExceptions.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public MethodDeclaration setThrownExceptions(java.util.Collection<Object> values) {
		this._thrownExceptions.addAll(values);
		return this;
	}

	public MethodDeclaration removeThrownExceptions(Object value) {
		this._thrownExceptions.remove(value);
		return this;
	}

	public MethodDeclaration removeThrownExceptions(int index) {
		this._thrownExceptions.remove(index);
		return this;
	}

	public java.util.List<Object> getThrownExceptions() {
		return this._thrownExceptions;
	} 


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		MethodDeclaration that = (MethodDeclaration) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "MethodDeclaration(annotations,modifiers,type,typeParameters,name,parameters,thrownExceptions,isInterfaceDeclaration,blockStmt) ::= <<~annotations:{it|~it~};separator=\"\\n\"~~if(annotations)~\n" + 
				"~endif~~modifiers:{it|~it~};separator=\" \"~~if(modifiers)~ ~endif~~if(type)~~if(typeParameters)~<~typeParameters:{it|~it~};separator=\", \"~>~endif~~type~ ~else~void ~endif~~name~(~parameters:{it|~it~};separator=\", \"~)~if(thrownExceptions)~ throws ~thrownExceptions:{it|~it~};separator=\", \"~~endif~~if(isInterfaceDeclaration)~;~else~~if(blockStmt)~~blockStmt~~else~ { }~endif~~endif~ >>";
}  