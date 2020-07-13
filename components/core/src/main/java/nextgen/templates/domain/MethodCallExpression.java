package nextgen.templates.domain;

public class MethodCallExpression {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _name;
	private Boolean _isStatic;

	MethodCallExpression(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("MethodCallExpression");
		st.add("name", _name);
		st.add("isStatic", _isStatic);
		return st.render().trim();
	}

	public MethodCallExpression setName(Object value) {
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

	public MethodCallExpression removeName() {
		this._name = null;
		return this;
	} 

	public MethodCallExpression setIsStatic(Boolean value) {
		this._isStatic = value;
		return this;
	}

	public Boolean getIsStatic() {
		return this._isStatic;
	}

	public Boolean getIsStatic(Boolean defaultValue) {
		return this._isStatic == null ? defaultValue : this._isStatic;
	}

	public boolean hasIsStatic() {
		return this._isStatic != null;
	}

	public MethodCallExpression removeIsStatic() {
		this._isStatic = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		MethodCallExpression that = (MethodCallExpression) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "MethodCallExpression(name,isStatic) ::= <<MethodCallExpression ~name~(Object argument) {\n" + 
				"	return ~if(isStatic)~static~endif~MethodCall(\"~name~\", argument);\n" + 
				"} >>";
}  