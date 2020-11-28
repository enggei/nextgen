package nextgen.templates.kotlin;

public class IfExpression implements Expression {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private LogicalExpression _logicalExpression;
	private Expression _whenTrue;
	private Expression _whenFalse;

	IfExpression(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("IfExpression");
		st.add("logicalExpression", _logicalExpression);
		st.add("whenTrue", _whenTrue);
		st.add("whenFalse", _whenFalse);
		return st.render().trim();
	}

	public IfExpression setLogicalExpression(LogicalExpression value) {
		this._logicalExpression = value;
		return this;
	}

	public LogicalExpression getLogicalExpression() {
		return this._logicalExpression;
	}

	public LogicalExpression getLogicalExpression(LogicalExpression defaultValue) {
		return this._logicalExpression == null ? defaultValue : this._logicalExpression;
	}

	public boolean hasLogicalExpression() {
		return this._logicalExpression != null;
	}

	public IfExpression removeLogicalExpression() {
		this._logicalExpression = null;
		return this;
	} 

	public IfExpression setWhenTrue(Expression value) {
		this._whenTrue = value;
		return this;
	}

	public Expression getWhenTrue() {
		return this._whenTrue;
	}

	public Expression getWhenTrue(Expression defaultValue) {
		return this._whenTrue == null ? defaultValue : this._whenTrue;
	}

	public boolean hasWhenTrue() {
		return this._whenTrue != null;
	}

	public IfExpression removeWhenTrue() {
		this._whenTrue = null;
		return this;
	} 

	public IfExpression setWhenFalse(Expression value) {
		this._whenFalse = value;
		return this;
	}

	public Expression getWhenFalse() {
		return this._whenFalse;
	}

	public Expression getWhenFalse(Expression defaultValue) {
		return this._whenFalse == null ? defaultValue : this._whenFalse;
	}

	public boolean hasWhenFalse() {
		return this._whenFalse != null;
	}

	public IfExpression removeWhenFalse() {
		this._whenFalse = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		IfExpression that = (IfExpression) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "IfExpression(logicalExpression,whenTrue,whenFalse) ::= <<if(~logicalExpression~) ~whenTrue~ else ~whenFalse~ >>";
}  