package nextgen.templates.java;

public class AssignExpression implements Expression {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _value;
	private Object _target;
	private Object _operator;

	AssignExpression(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("AssignExpression");
		st.add("value", _value);
		st.add("target", _target);
		st.add("operator", _operator);
		return st.render().trim();
	}

	public AssignExpression setValue(Object value) {
		this._value = value;
		return this;
	}

	public Object getValue() {
		return this._value;
	}

	public Object getValue(Object defaultValue) {
		return this._value == null ? defaultValue : this._value;
	}

	public boolean hasValue() {
		return this._value != null;
	}

	public AssignExpression removeValue() {
		this._value = null;
		return this;
	} 

	public AssignExpression setTarget(Object value) {
		this._target = value;
		return this;
	}

	public Object getTarget() {
		return this._target;
	}

	public Object getTarget(Object defaultValue) {
		return this._target == null ? defaultValue : this._target;
	}

	public boolean hasTarget() {
		return this._target != null;
	}

	public AssignExpression removeTarget() {
		this._target = null;
		return this;
	} 

	public AssignExpression setOperator(Object value) {
		this._operator = value;
		return this;
	}

	public Object getOperator() {
		return this._operator;
	}

	public Object getOperator(Object defaultValue) {
		return this._operator == null ? defaultValue : this._operator;
	}

	public boolean hasOperator() {
		return this._operator != null;
	}

	public AssignExpression removeOperator() {
		this._operator = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		AssignExpression that = (AssignExpression) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "AssignExpression(value,target,operator) ::= <<~target~ ~operator~ ~value~ >>";
} 