package nextgen.templates.text;

public class Encapsulation {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _prefix;
	private Object _content;
	private Object _postfix;

	Encapsulation(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("Encapsulation");
		st.add("prefix", _prefix);
		st.add("content", _content);
		st.add("postfix", _postfix);
		return st.render().trim();
	}

	public Encapsulation setPrefix(Object value) {
		this._prefix = value;
		return this;
	}

	public Object getPrefix() {
		return this._prefix;
	}

	public Object getPrefix(Object defaultValue) {
		return this._prefix == null ? defaultValue : this._prefix;
	}

	public boolean hasPrefix() {
		return this._prefix != null;
	}

	public Encapsulation removePrefix() {
		this._prefix = null;
		return this;
	} 

	public Encapsulation setContent(Object value) {
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

	public Encapsulation removeContent() {
		this._content = null;
		return this;
	} 

	public Encapsulation setPostfix(Object value) {
		this._postfix = value;
		return this;
	}

	public Object getPostfix() {
		return this._postfix;
	}

	public Object getPostfix(Object defaultValue) {
		return this._postfix == null ? defaultValue : this._postfix;
	}

	public boolean hasPostfix() {
		return this._postfix != null;
	}

	public Encapsulation removePostfix() {
		this._postfix = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Encapsulation that = (Encapsulation) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "Encapsulation(prefix,content,postfix) ::= <<~prefix~~content~~postfix~ >>";
}  