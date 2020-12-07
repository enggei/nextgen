package nextgen.templates.java;

public class ArrayAccessExpression implements Expression {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _name;
	private Object _index;

	ArrayAccessExpression(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("ArrayAccessExpression");
		st.add("name", _name);
		st.add("index", _index);
		return st.render().trim();
	}

	public ArrayAccessExpression setName(Object value) {
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

	public ArrayAccessExpression removeName() {
		this._name = null;
		return this;
	} 

	public ArrayAccessExpression setIndex(Object value) {
		this._index = value;
		return this;
	}

	public Object getIndex() {
		return this._index;
	}

	public Object getIndex(Object defaultValue) {
		return this._index == null ? defaultValue : this._index;
	}

	public boolean hasIndex() {
		return this._index != null;
	}

	public ArrayAccessExpression removeIndex() {
		this._index = null;
		return this;
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

	static final String st = "ArrayAccessExpression(name,index) ::= <<~name~[~index~] >>";
}  