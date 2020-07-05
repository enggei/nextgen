package nextgen.templates.kotlin;

public class PropertyAccessorExpression implements Expression {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Expression _object;
	private Expression _property;

	PropertyAccessorExpression(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("PropertyAccessorExpression");
		st.add("object", _object);
		st.add("property", _property);
		return st.render().trim();
	}

	public PropertyAccessorExpression setObject(Expression value) {
		this._object = value;
		return this;
	}

	public Expression getObject() {
		return this._object;
	}

	public Expression getObject(Expression defaultValue) {
		return this._object == null ? defaultValue : this._object;
	}

	public boolean hasObject() {
		return this._object != null;
	}

	public PropertyAccessorExpression removeObject() {
		this._object = null;
		return this;
	} 

	public PropertyAccessorExpression setProperty(Expression value) {
		this._property = value;
		return this;
	}

	public Expression getProperty() {
		return this._property;
	}

	public Expression getProperty(Expression defaultValue) {
		return this._property == null ? defaultValue : this._property;
	}

	public boolean hasProperty() {
		return this._property != null;
	}

	public PropertyAccessorExpression removeProperty() {
		this._property = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		PropertyAccessorExpression that = (PropertyAccessorExpression) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "PropertyAccessorExpression(object,property) ::= <<~object~.~property~ >>";
}  