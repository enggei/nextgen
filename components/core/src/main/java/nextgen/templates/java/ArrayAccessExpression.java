package nextgen.templates.java;

public class ArrayAccessExpression {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _index;
	private Object _name;

	ArrayAccessExpression(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ArrayAccessExpression that = (ArrayAccessExpression) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("ArrayAccessExpression");
		st.add("index", _index);
		st.add("name", _name);
		return st.render().trim();
	}

	public ArrayAccessExpression setIndex(Object value) {
		this._index = value;
		return this;
	}

	public Object getIndex() {
		return this._index;
	}

	public boolean hasIndex() {
		return this._index != null;
	}

	public ArrayAccessExpression removeIndex() {
		this._index = null;
		return this;
	} 

	public ArrayAccessExpression setName(Object value) {
		this._name = value;
		return this;
	}

	public Object getName() {
		return this._name;
	}

	public boolean hasName() {
		return this._name != null;
	}

	public ArrayAccessExpression removeName() {
		this._name = null;
		return this;
	} 

	static final String st = "ArrayAccessExpression(index,name) ::= <<~name~[~index~]>> ";
} 