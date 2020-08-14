package nextgen.templates.javascript;

public class Inject {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private java.util.List<Object> _values = new java.util.ArrayList<>();

	Inject(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Deprecated
	public java.util.UUID uuid() {
		return uuid;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("Inject");
		for (Object o : _values) st.add("values", o);
		return st.render().trim();
	}


	public Inject addValues(Object value) {
		this._values.add(value);
		return this;
	}

	public Inject setValues(Object[] value) {
		this._values.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public Inject setValues(java.util.Collection<Object> values) {
		this._values.addAll(values);
		return this;
	}

	public Inject removeValues(Object value) {
		this._values.remove(value);
		return this;
	}

	public Inject removeValues(int index) {
		this._values.remove(index);
		return this;
	}

	public java.util.List<Object> getValues() {
		return this._values;
	} 


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Inject that = (Inject) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "Inject(values) ::= <<@inject(~values:{it|~it~};separator=\", \"~) >>";
}  