package nextgen.templates.java;

public class FieldDeclaration {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private java.util.List<Object> _modifiers = new java.util.ArrayList<>();
	private java.util.List<Object> _variables = new java.util.ArrayList<>();
	private java.util.List<Object> _annotations = new java.util.ArrayList<>();

	FieldDeclaration(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("FieldDeclaration");
		for (Object o : _modifiers) st.add("modifiers", o);
		for (Object o : _variables) st.add("variables", o);
		for (Object o : _annotations) st.add("annotations", o);
		return st.render().trim();
	}


	public FieldDeclaration addModifiers(Object value) {
		this._modifiers.add(value);
		return this;
	}

	public FieldDeclaration setModifiers(Object[] value) {
		this._modifiers.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public FieldDeclaration setModifiers(java.util.Collection<Object> values) {
		this._modifiers.addAll(values);
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

	public FieldDeclaration addVariables(Object value) {
		this._variables.add(value);
		return this;
	}

	public FieldDeclaration setVariables(Object[] value) {
		this._variables.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public FieldDeclaration setVariables(java.util.Collection<Object> values) {
		this._variables.addAll(values);
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

	public FieldDeclaration setAnnotations(Object[] value) {
		this._annotations.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public FieldDeclaration setAnnotations(java.util.Collection<Object> values) {
		this._annotations.addAll(values);
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

	static final String st = "FieldDeclaration(modifiers,variables,annotations) ::= <<~annotations:{it|~it~};separator=\"\\n\"~~if(annotations)~\n" + 
				"~endif~~modifiers:{it|~it~};separator=\" \"~~if(modifiers)~ ~endif~~variables:{it|~it~};separator=\", \"~; >>";
}  