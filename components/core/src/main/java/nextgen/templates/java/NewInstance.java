package nextgen.templates.java;

public class NewInstance {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _type;
	private java.util.List<Object> _arguments = new java.util.ArrayList<>();

	NewInstance(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("NewInstance");
		st.add("type", _type);
		for (Object o : _arguments) st.add("arguments", o);
		return st.render().trim();
	}

	public NewInstance setType(Object value) {
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

	public NewInstance removeType() {
		this._type = null;
		return this;
	} 

	public NewInstance addArguments(Object value) {
		this._arguments.add(value);
		return this;
	}

	public NewInstance removeArguments(Object value) {
		this._arguments.remove(value);
		return this;
	}

	public NewInstance removeArguments(int index) {
		this._arguments.remove(index);
		return this;
	}

	public java.util.List<Object> getArguments() {
		return this._arguments;
	} 


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		NewInstance that = (NewInstance) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "NewInstance(type,arguments) ::= <<new ~type~(~arguments:{it|~it~};separator=\",\"~)>> ";
}  