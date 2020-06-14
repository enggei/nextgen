package nextgen.templates.java;

public class ArrayCreationExpression implements Expression {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _initializer;
	private Object _type;
	private java.util.List<Object> _levels = new java.util.ArrayList<>();

	ArrayCreationExpression(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("ArrayCreationExpression");
		st.add("initializer", _initializer);
		st.add("type", _type);
		for (Object o : _levels) st.add("levels", o);
		return st.render().trim();
	}

	public ArrayCreationExpression setInitializer(Object value) {
		this._initializer = value;
		return this;
	}

	public Object getInitializer() {
		return this._initializer;
	}

	public Object getInitializer(Object defaultValue) {
		return this._initializer == null ? defaultValue : this._initializer;
	}

	public boolean hasInitializer() {
		return this._initializer != null;
	}

	public ArrayCreationExpression removeInitializer() {
		this._initializer = null;
		return this;
	} 

	public ArrayCreationExpression setType(Object value) {
		this._type = value;
		return this;
	}

	public Object getType() {
		return this._type;
	}

	public Object getType(Object defaultValue) {
		return this._type == null ? defaultValue : this._type;
	}

	public boolean hasType() {
		return this._type != null;
	}

	public ArrayCreationExpression removeType() {
		this._type = null;
		return this;
	} 

	public ArrayCreationExpression addLevels(Object value) {
		this._levels.add(value);
		return this;
	}

	public ArrayCreationExpression setLevels(Object[] value) {
		this._levels.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public ArrayCreationExpression setLevels(java.util.Collection<Object> values) {
		this._levels.addAll(values);
		return this;
	}

	public ArrayCreationExpression removeLevels(Object value) {
		this._levels.remove(value);
		return this;
	}

	public ArrayCreationExpression removeLevels(int index) {
		this._levels.remove(index);
		return this;
	}

	public java.util.List<Object> getLevels() {
		return this._levels;
	} 


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ArrayCreationExpression that = (ArrayCreationExpression) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "ArrayCreationExpression(initializer,type,levels) ::= <<new ~type~~levels:{it|~it~}~~if(initializer)~ ~initializer~~endif~ >>";
} 