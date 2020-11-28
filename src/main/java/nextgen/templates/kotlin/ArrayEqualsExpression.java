package nextgen.templates.kotlin;

public class ArrayEqualsExpression implements Expression {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Expression _leftArray;
	private Expression _rightArray;

	ArrayEqualsExpression(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("ArrayEqualsExpression");
		st.add("leftArray", _leftArray);
		st.add("rightArray", _rightArray);
		return st.render().trim();
	}

	public ArrayEqualsExpression setLeftArray(Expression value) {
		this._leftArray = value;
		return this;
	}

	public Expression getLeftArray() {
		return this._leftArray;
	}

	public Expression getLeftArray(Expression defaultValue) {
		return this._leftArray == null ? defaultValue : this._leftArray;
	}

	public boolean hasLeftArray() {
		return this._leftArray != null;
	}

	public ArrayEqualsExpression removeLeftArray() {
		this._leftArray = null;
		return this;
	} 

	public ArrayEqualsExpression setRightArray(Expression value) {
		this._rightArray = value;
		return this;
	}

	public Expression getRightArray() {
		return this._rightArray;
	}

	public Expression getRightArray(Expression defaultValue) {
		return this._rightArray == null ? defaultValue : this._rightArray;
	}

	public boolean hasRightArray() {
		return this._rightArray != null;
	}

	public ArrayEqualsExpression removeRightArray() {
		this._rightArray = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ArrayEqualsExpression that = (ArrayEqualsExpression) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "ArrayEqualsExpression(leftArray,rightArray) ::= <<~leftArray~.contentEquals(~rightArray~) >>";
}  