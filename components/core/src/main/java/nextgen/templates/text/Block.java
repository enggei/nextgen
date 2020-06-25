package nextgen.templates.text;

public class Block {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private java.util.List<Object> _lines = new java.util.ArrayList<>();

	Block(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("Block");
		for (Object o : _lines) st.add("lines", o);
		return st.render().trim();
	}


	public Block addLines(Object value) {
		this._lines.add(value);
		return this;
	}

	public Block setLines(Object[] value) {
		this._lines.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public Block setLines(java.util.Collection<Object> values) {
		this._lines.addAll(values);
		return this;
	}

	public Block removeLines(Object value) {
		this._lines.remove(value);
		return this;
	}

	public Block removeLines(int index) {
		this._lines.remove(index);
		return this;
	}

	public java.util.List<Object> getLines() {
		return this._lines;
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

	static final String st = "Block(lines) ::= <<~lines:{it|~it~};separator=\"\\n\"~ >>";
}  