package nextgen.templates.html5;

public class Head {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private java.util.List<Object> _content = new java.util.ArrayList<>();

	Head(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("head");
		for (Object o : _content) st.add("content", o);
		return st.render().trim();
	}


	public Head addContent(Object value) {
		this._content.add(value);
		return this;
	}

	public Head setContent(Object[] value) {
		this._content.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public Head setContent(java.util.Collection<Object> values) {
		this._content.addAll(values);
		return this;
	}

	public Head removeContent(Object value) {
		this._content.remove(value);
		return this;
	}

	public Head removeContent(int index) {
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
		Head that = (Head) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "head(content) ::= <<<head>\n" + 
				"    ~content:{it|~it~};separator=\"\\n\"~\n" + 
				"</head> >>";
}  