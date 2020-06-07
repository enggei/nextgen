package nextgen.templates.java;

public class QualifierName {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private java.util.List<Object> _value = new java.util.ArrayList<>();

	QualifierName(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		QualifierName that = (QualifierName) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("QualifierName");
		for (Object o : _value) st.add("value", o);
		return st.render().trim();
	}

	public QualifierName addValue(Object value) {
		this._value.add(value);
		return this;
	}

	public QualifierName removeValue(Object value) {
		this._value.remove(value);
		return this;
	}

	public QualifierName removeValue(int index) {
		this._value.remove(index);
		return this;
	}

	public java.util.List<Object> getValue() {
		return this._value;
	} 

	static final String st = "QualifierName(value) ::= <<~value:{it|~it~};separator=\".\"~>> ";
} 