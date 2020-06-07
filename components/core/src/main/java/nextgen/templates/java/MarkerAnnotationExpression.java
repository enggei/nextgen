package nextgen.templates.java;

public class MarkerAnnotationExpression {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _name;

	MarkerAnnotationExpression(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		MarkerAnnotationExpression that = (MarkerAnnotationExpression) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("MarkerAnnotationExpression");
		st.add("name", _name);
		return st.render().trim();
	}

	public MarkerAnnotationExpression setName(Object value) {
		this._name = value;
		return this;
	}

	public Object getName() {
		return this._name;
	}

	public boolean hasName() {
		return this._name != null;
	}

	public MarkerAnnotationExpression removeName() {
		this._name = null;
		return this;
	} 

	static final String st = "MarkerAnnotationExpression(name) ::= <<@~name~>> ";
} 