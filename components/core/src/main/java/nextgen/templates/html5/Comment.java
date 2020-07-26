package nextgen.templates.html5;

public class Comment {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _comment;

	Comment(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("comment");
		st.add("comment", _comment);
		return st.render().trim();
	}

	public Comment setComment(Object value) {
		this._comment = value;
		return this;
	}

	public Object getComment() {
		return this._comment;
	}

	public Object getComment(Object defaultValue) {
		return this._comment == null ? defaultValue : this._comment;
	}

	public boolean hasComment() {
		return this._comment != null;
	}

	public Comment removeComment() {
		this._comment = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Comment that = (Comment) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "comment(comment) ::= <<<!-- ~comment~ --> >>";
}  