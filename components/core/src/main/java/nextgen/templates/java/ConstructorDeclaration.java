package nextgen.templates.java;

public class ConstructorDeclaration {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _name;
	private Object _blockStmt;
	private java.util.List<Object> _modifiers = new java.util.ArrayList<>();
	private java.util.List<Object> _annotations = new java.util.ArrayList<>();
	private java.util.List<Object> _thrownExceptions = new java.util.ArrayList<>();
	private java.util.List<Object> _typeParameters = new java.util.ArrayList<>();
	private java.util.List<Object> _parameters = new java.util.ArrayList<>();

	ConstructorDeclaration(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ConstructorDeclaration that = (ConstructorDeclaration) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("ConstructorDeclaration");
		st.add("name", _name);
		st.add("blockStmt", _blockStmt);
		for (Object o : _modifiers) st.add("modifiers", o);
		for (Object o : _annotations) st.add("annotations", o);
		for (Object o : _thrownExceptions) st.add("thrownExceptions", o);
		for (Object o : _typeParameters) st.add("typeParameters", o);
		for (Object o : _parameters) st.add("parameters", o);
		return st.render().trim();
	}

	public ConstructorDeclaration setName(Object value) {
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

	public ConstructorDeclaration removeName() {
		this._name = null;
		return this;
	} 

	public ConstructorDeclaration setBlockStmt(Object value) {
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

	public ConstructorDeclaration removeBlockStmt() {
		this._blockStmt = null;
		return this;
	} 
	public ConstructorDeclaration addModifiers(Object value) {
		this._modifiers.add(value);
		return this;
	}

	public ConstructorDeclaration removeModifiers(Object value) {
		this._modifiers.remove(value);
		return this;
	}

	public ConstructorDeclaration removeModifiers(int index) {
		this._modifiers.remove(index);
		return this;
	}

	public java.util.List<Object> getModifiers() {
		return this._modifiers;
	} 

	public ConstructorDeclaration addAnnotations(Object value) {
		this._annotations.add(value);
		return this;
	}

	public ConstructorDeclaration removeAnnotations(Object value) {
		this._annotations.remove(value);
		return this;
	}

	public ConstructorDeclaration removeAnnotations(int index) {
		this._annotations.remove(index);
		return this;
	}

	public java.util.List<Object> getAnnotations() {
		return this._annotations;
	} 

	public ConstructorDeclaration addThrownExceptions(Object value) {
		this._thrownExceptions.add(value);
		return this;
	}

	public ConstructorDeclaration removeThrownExceptions(Object value) {
		this._thrownExceptions.remove(value);
		return this;
	}

	public ConstructorDeclaration removeThrownExceptions(int index) {
		this._thrownExceptions.remove(index);
		return this;
	}

	public java.util.List<Object> getThrownExceptions() {
		return this._thrownExceptions;
	} 

	public ConstructorDeclaration addTypeParameters(Object value) {
		this._typeParameters.add(value);
		return this;
	}

	public ConstructorDeclaration removeTypeParameters(Object value) {
		this._typeParameters.remove(value);
		return this;
	}

	public ConstructorDeclaration removeTypeParameters(int index) {
		this._typeParameters.remove(index);
		return this;
	}

	public java.util.List<Object> getTypeParameters() {
		return this._typeParameters;
	} 

	public ConstructorDeclaration addParameters(Object value) {
		this._parameters.add(value);
		return this;
	}

	public ConstructorDeclaration removeParameters(Object value) {
		this._parameters.remove(value);
		return this;
	}

	public ConstructorDeclaration removeParameters(int index) {
		this._parameters.remove(index);
		return this;
	}

	public java.util.List<Object> getParameters() {
		return this._parameters;
	} 

	static final String st = "ConstructorDeclaration(name,blockStmt,modifiers,annotations,thrownExceptions,typeParameters,parameters) ::= <<~annotations:{it|~it~};separator=\"\\n\"~~if(annotations)~\n" + 
				"~endif~~modifiers:{it|~it~};separator=\" \"~~if(modifiers)~ ~endif~~if(typeParameters)~~typeParameters:{it|<~it~>};separator=\" \"~ ~endif~~name~(~parameters:{it|~it~};separator=\", \"~)~if(thrownExceptions)~ throws ~thrownExceptions:{it|~it~};separator=\", \"~ ~endif~~if(blockStmt)~~blockStmt~~else~ { }~endif~>> ";
} 