package nextgen.templates.java;

public class FieldDeclaration {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private java.util.List<Object> _variables = new java.util.ArrayList<>();
	private java.util.List<Object> _annotations = new java.util.ArrayList<>();
	private java.util.List<Object> _modifiers = new java.util.ArrayList<>();

	FieldDeclaration(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("FieldDeclaration");
		for (Object o : _variables) st.add("variables", o);
		for (Object o : _annotations) st.add("annotations", o);
		for (Object o : _modifiers) st.add("modifiers", o);
		return st.render().trim();
	}


	public FieldDeclaration addVariables(Object value) {
		this._variables.add(value);
		return this;
	}

	public FieldDeclaration removeVariables(Object value) {
		this._variables.remove(value);
		return this;
	}

	public FieldDeclaration removeVariables(int index) {
		this._variables.remove(index);
		return this;
	}

	public java.util.List<Object> getVariables() {
		return this._variables;
	} 

	public FieldDeclaration addAnnotations(Object value) {
		this._annotations.add(value);
		return this;
	}

	public FieldDeclaration removeAnnotations(Object value) {
		this._annotations.remove(value);
		return this;
	}

	public FieldDeclaration removeAnnotations(int index) {
		this._annotations.remove(index);
		return this;
	}

	public java.util.List<Object> getAnnotations() {
		return this._annotations;
	} 

	public FieldDeclaration addModifiers(Object value) {
		this._modifiers.add(value);
		return this;
	}

	public FieldDeclaration removeModifiers(Object value) {
		this._modifiers.remove(value);
		return this;
	}

	public FieldDeclaration removeModifiers(int index) {
		this._modifiers.remove(index);
		return this;
	}

	public java.util.List<Object> getModifiers() {
		return this._modifiers;
	} 


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		FieldDeclaration that = (FieldDeclaration) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "FieldDeclaration(variables,annotations,modifiers) ::= <<~annotations:{it|~it~};separator=\"\\n\"~~if(annotations)~\n" + 
				"~endif~~modifiers:{it|~it~};separator=\" \"~~if(modifiers)~ ~endif~~variables:{it|~it~};separator=\", \"~;>> ";
}  