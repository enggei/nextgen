package nextgen.templates.test;

public class Single {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private String _value;

	Single(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("single");
		st.add("value", _value);
		return st.render().trim();
	}

	public Single setValue(String value) {
		this._value = value;
		return this;
	}

	public String getValue() {
		return this._value;
	}

	public String getValue(String defaultValue) {
		return this._value == null ? defaultValue : this._value;
	}

	public boolean hasValue() {
		return this._value != null;
	}

	public Single removeValue() {
		this._value = null;
		return this;
	} 

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Single that = (Single) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "single(value) ::= <<single : ~value~>> ";
}  