package nextgen.templates.java;

public class VariableDeclarationExpression {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private java.util.List<Object> _variables = new java.util.ArrayList<>();
	private java.util.List<Object> _modifiers = new java.util.ArrayList<>();

	VariableDeclarationExpression(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("VariableDeclarationExpression");
		for (Object o : _variables) st.add("variables", o);
		for (Object o : _modifiers) st.add("modifiers", o);
		return st.render().trim();
	}


	public VariableDeclarationExpression addVariables(Object value) {
		this._variables.add(value);
		return this;
	}

	public VariableDeclarationExpression removeVariables(Object value) {
		this._variables.remove(value);
		return this;
	}

	public VariableDeclarationExpression removeVariables(int index) {
		this._variables.remove(index);
		return this;
	}

	public java.util.List<Object> getVariables() {
		return this._variables;
	} 

	public VariableDeclarationExpression addModifiers(Object value) {
		this._modifiers.add(value);
		return this;
	}

	public VariableDeclarationExpression removeModifiers(Object value) {
		this._modifiers.remove(value);
		return this;
	}

	public VariableDeclarationExpression removeModifiers(int index) {
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
		VariableDeclarationExpression that = (VariableDeclarationExpression) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "VariableDeclarationExpression(variables,modifiers) ::= <<~modifiers:{it|~it~};separator=\" \"~~if(modifiers)~ ~endif~~variables:{it|~it~};separator=\", \"~>> ";
}  