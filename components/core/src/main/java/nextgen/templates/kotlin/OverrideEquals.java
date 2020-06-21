package nextgen.templates.kotlin;

public class OverrideEquals {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private String _className;
	private java.util.List<Expression> _fields = new java.util.ArrayList<>();

	OverrideEquals(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("OverrideEquals");
		st.add("className", _className);
		for (Object o : _fields) st.add("fields", o);
		return st.render().trim();
	}

	public OverrideEquals setClassName(String value) {
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

	public OverrideEquals removeClassName() {
		this._className = null;
		return this;
	} 

	public OverrideEquals addFields(Expression value) {
		this._fields.add(value);
		return this;
	}

	public OverrideEquals setFields(Expression[] value) {
		this._fields.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public OverrideEquals setFields(java.util.Collection<Expression> values) {
		this._fields.addAll(values);
		return this;
	}

	public OverrideEquals removeFields(Expression value) {
		this._fields.remove(value);
		return this;
	}

	public OverrideEquals removeFields(int index) {
		this._fields.remove(index);
		return this;
	}

	public java.util.List<Expression> getFields() {
		return this._fields;
	} 


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		OverrideEquals that = (OverrideEquals) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "OverrideEquals(className,fields) ::= <<override fun equals(other: Any?): Boolean {\n" + 
				"	if (other !is ~className~) return false\n" + 
				"	return if (other === this) true\n" + 
				"	else\n" + 
				"		~fields:{it|~it~};separator=\" && \"~\n" + 
				"} >>";
} 