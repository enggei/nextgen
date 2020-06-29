package nextgen.templates.kotlin;

public class OverrideToString {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private String _className;
	private java.util.List<ToStringExpression> _fields = new java.util.ArrayList<>();

	OverrideToString(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("OverrideToString");
		st.add("className", _className);
		for (Object o : _fields) st.add("fields", o);
		return st.render().trim();
	}

	public OverrideToString setClassName(String value) {
		this._className = value;
		return this;
	}

	public String getClassName() {
		return this._className;
	}

	public String getClassName(String defaultValue) {
		return this._className == null ? defaultValue : this._className;
	}

	public boolean hasClassName() {
		return this._className != null;
	}

	public OverrideToString removeClassName() {
		this._className = null;
		return this;
	} 

	public OverrideToString addFields(ToStringExpression value) {
		this._fields.add(value);
		return this;
	}

	public OverrideToString setFields(ToStringExpression[] value) {
		this._fields.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public OverrideToString setFields(java.util.Collection<ToStringExpression> values) {
		this._fields.addAll(values);
		return this;
	}

	public OverrideToString removeFields(ToStringExpression value) {
		this._fields.remove(value);
		return this;
	}

	public OverrideToString removeFields(int index) {
		this._fields.remove(index);
		return this;
	}

	public java.util.List<ToStringExpression> getFields() {
		return this._fields;
	} 


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		OverrideToString that = (OverrideToString) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "OverrideToString(className,fields) ::= <<override fun toString(): String {\n" + 
				"	return \"~className~(~fields:{it|~it~};separator=\", \"~)\"\n" + 
				"} >>";
}  