package nextgen.st.stringtemplate;

public class Template {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _name;
	private Object _content;
	private java.util.List<Object> _params = new java.util.ArrayList<>();

	Template(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("Template");
		st.add("name", _name);
		st.add("content", _content);
		for (Object o : _params) st.add("params", o);
		return st.render().trim();
	}

	public Template setName(Object value) {
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

	public Template removeName() {
		this._name = null;
		return this;
	} 

	public Template setContent(Object value) {
		this._content = value;
		return this;
	}

	public Object getContent() {
		return this._content;
	}

	public Object getContent(Object defaultValue) {
		return this._content == null ? defaultValue : this._content;
	}

	public boolean hasContent() {
		return this._content != null;
	}

	public Template removeContent() {
		this._content = null;
		return this;
	} 
	public Template addParams(Object value) {
		this._params.add(value);
		return this;
	}

	public Template removeParams(Object value) {
		this._params.remove(value);
		return this;
	}

	public Template removeParams(int index) {
		this._params.remove(index);
		return this;
	}

	public java.util.List<Object> getParams() {
		return this._params;
	} 

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Template that = (Template) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "Template(name,params,content) ::= <<~name~(~params:{it|~it~};separator=\",\"~) ::= <<~content~>\\> >> ";
}  