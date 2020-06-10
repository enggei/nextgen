package nextgen.templates.java;

public class ConditionalExpression {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _thenExpression;
	private Object _elseExpression;
	private Object _condition;

	ConditionalExpression(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("ConditionalExpression");
		st.add("thenExpression", _thenExpression);
		st.add("elseExpression", _elseExpression);
		st.add("condition", _condition);
		return st.render().trim();
	}

	public ConditionalExpression setThenExpression(Object value) {
		this._thenExpression = value;
		return this;
	}

	public Object getThenExpression() {
		return this._thenExpression;
	}

	public Object getThenExpression(Object defaultValue) {
		return this._thenExpression == null ? defaultValue : this._thenExpression;
	}

	public boolean hasThenExpression() {
		return this._thenExpression != null;
	}

	public ConditionalExpression removeThenExpression() {
		this._thenExpression = null;
		return this;
	} 

	public ConditionalExpression setElseExpression(Object value) {
		this._elseExpression = value;
		return this;
	}

	public Object getElseExpression() {
		return this._elseExpression;
	}

	public Object getElseExpression(Object defaultValue) {
		return this._elseExpression == null ? defaultValue : this._elseExpression;
	}

	public boolean hasElseExpression() {
		return this._elseExpression != null;
	}

	public ConditionalExpression removeElseExpression() {
		this._elseExpression = null;
		return this;
	} 

	public ConditionalExpression setCondition(Object value) {
		this._condition = value;
		return this;
	}

	public Object getCondition() {
		return this._condition;
	}

	public Object getCondition(Object defaultValue) {
		return this._condition == null ? defaultValue : this._condition;
	}

	public boolean hasCondition() {
		return this._condition != null;
	}

	public ConditionalExpression removeCondition() {
		this._condition = null;
		return this;
	} 

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ConditionalExpression that = (ConditionalExpression) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "ConditionalExpression(thenExpression,elseExpression,condition) ::= <<~condition~ ? ~thenExpression~ : ~elseExpression~>> ";
}  