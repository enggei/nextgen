package nextgen.templates.html5;

public class Block {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private java.util.List<Object> _content = new java.util.ArrayList<>();

	Block(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("block");
		for (Object o : _content) st.add("content", o);
		return st.render().trim();
	}


	public Block addContent(Object value) {
		this._content.add(value);
		return this;
	}

	public Block setContent(Object[] value) {
		this._content.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public Block setContent(java.util.Collection<Object> values) {
		this._content.addAll(values);
		return this;
	}

	public Block removeContent(Object value) {
		this._content.remove(value);
		return this;
	}

	public Block removeContent(int index) {
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
		Block that = (Block) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "block(content) ::= <<~content:{it|~it~};separator=\"\\n\"~ >>";
}  