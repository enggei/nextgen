package nextgen.templates.html5;

public class Body {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private java.util.List<Object> _content = new java.util.ArrayList<>();

	Body(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("body");
		for (Object o : _content) st.add("content", o);
		return st.render().trim();
	}


	public Body addContent(Object value) {
		this._content.add(value);
		return this;
	}

	public Body setContent(Object[] value) {
		this._content.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public Body setContent(java.util.Collection<Object> values) {
		this._content.addAll(values);
		return this;
	}

	public Body removeContent(Object value) {
		this._content.remove(value);
		return this;
	}

	public Body removeContent(int index) {
		this._content.remove(index);
		return this;
	}

	public java.util.List<Object> getContent() {
		return this._content;
	} 


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Body that = (Body) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "body(content) ::= <<<body>\n" + 
				"    ~content:{it|~it~};separator=\"\\n\"~\n" + 
				"</body> >>";
}  