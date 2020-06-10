package nextgen.templates.java;

public class LambdaExpression {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _body;
	private java.util.List<Object> _parameters = new java.util.ArrayList<>();

	LambdaExpression(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("LambdaExpression");
		st.add("body", _body);
		for (Object o : _parameters) st.add("parameters", o);
		return st.render().trim();
	}

	public LambdaExpression setBody(Object value) {
		this._body = value;
		return this;
	}

	public Object getBody() {
		return this._body;
	}

	public Object getBody(Object defaultValue) {
		return this._body == null ? defaultValue : this._body;
	}

	public boolean hasBody() {
		return this._body != null;
	}

	public LambdaExpression removeBody() {
		this._body = null;
		return this;
	} 
	public LambdaExpression addParameters(Object value) {
		this._parameters.add(value);
		return this;
	}

	public LambdaExpression removeParameters(Object value) {
		this._parameters.remove(value);
		return this;
	}

	public LambdaExpression removeParameters(int index) {
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
		LambdaExpression that = (LambdaExpression) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "LambdaExpression(body,parameters) ::= <<(~parameters:{it|~it~};separator=\", \"~) -> ~body~>> ";
}  