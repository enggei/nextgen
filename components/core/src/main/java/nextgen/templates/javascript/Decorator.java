package nextgen.templates.javascript;

public class Decorator {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _name;
	private java.util.List<Object> _parameters = new java.util.ArrayList<>();

	Decorator(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("Decorator");
		st.add("name", _name);
		for (Object o : _parameters) st.add("parameters", o);
		return st.render().trim();
	}

	public Decorator setName(Object value) {
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

	public Decorator removeName() {
		this._name = null;
		return this;
	} 

	public Decorator addParameters(Object value) {
		this._parameters.add(value);
		return this;
	}

	public Decorator removeParameters(Object value) {
		this._parameters.remove(value);
		return this;
	}

	public Decorator removeParameters(int index) {
		this._parameters.remove(index);
		return this;
	}

	public java.util.List<Object> getParameters() {
		return this._parameters;
	} 


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Decorator that = (Decorator) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "Decorator(name,parameters) ::= <<@~name~~if(parameters)~(~parameters:{it|~it~};separator=\", \"~)~endif~>> ";
}  