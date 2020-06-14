package nextgen.templates.java;

public class BinaryExpression {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _left;
	private Object _operator;
	private Object _right;

	BinaryExpression(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("BinaryExpression");
		st.add("left", _left);
		st.add("operator", _operator);
		st.add("right", _right);
		return st.render().trim();
	}

	public BinaryExpression setLeft(Object value) {
		this._left = value;
		return this;
	}

	public Object getLeft() {
		return this._left;
	}

	public Object getLeft(Object defaultValue) {
		return this._left == null ? defaultValue : this._left;
	}

	public boolean hasLeft() {
		return this._left != null;
	}

	public BinaryExpression removeLeft() {
		this._left = null;
		return this;
	}

	public BinaryExpression setOperator(Object value) {
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

	public BinaryExpression removeOperator() {
		this._operator = null;
		return this;
	}

	public BinaryExpression setRight(Object value) {
		this._right = value;
		return this;
	}

	public Object getRight() {
		return this._right;
	}

	public Object getRight(Object defaultValue) {
		return this._right == null ? defaultValue : this._right;
	}

	public boolean hasRight() {
		return this._right != null;
	}

	public BinaryExpression removeRight() {
		this._right = null;
		return this;
	}



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		BinaryExpression that = (BinaryExpression) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "BinaryExpression(left,operator,right) ::= <<~left~ ~operator~ ~right~>>";
}