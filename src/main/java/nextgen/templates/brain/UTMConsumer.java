package nextgen.templates.brain;

public class UTMConsumer {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _type;
	private Object _expression;

	UTMConsumer(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("UTMConsumer");
		st.add("type", _type);
		st.add("expression", _expression);
		return st.render().trim();
	}

	public UTMConsumer setType(Object value) {
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

	public UTMConsumer removeType() {
		this._type = null;
		return this;
	} 

	public UTMConsumer setExpression(Object value) {
		this._expression = value;
		return this;
	}

	public Object getExpression() {
		return this._expression;
	}

	public Object getExpression(Object defaultValue) {
		return this._expression == null ? defaultValue : this._expression;
	}

	public boolean hasExpression() {
		return this._expression != null;
	}

	public UTMConsumer removeExpression() {
		this._expression = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		UTMConsumer that = (UTMConsumer) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "UTMConsumer(type,expression) ::= <<package utm;\n" + 
				"\n" + 
				"public class UTMConsumer<~type~> extends UTM<~type~> {\n" + 
				"\n" + 
				"   @Override\n" + 
				"   public void accept(~type~ type) {\n" + 
				"		~expression~\n" + 
				"   }\n" + 
				"} >>";
}  