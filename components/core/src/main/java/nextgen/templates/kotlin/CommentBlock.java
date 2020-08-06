package nextgen.templates.kotlin;

public class CommentBlock implements Statement, Comment {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private String _comment;

	CommentBlock(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Deprecated
	public java.util.UUID uuid() {
		return uuid;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("CommentBlock");
		st.add("comment", _comment);
		return st.render().trim();
	}

	public CommentBlock setComment(String value) {
		this._comment = value;
		return this;
	}

	public String getComment() {
		return this._comment;
	}

	public String getComment(String defaultValue) {
		return this._comment == null ? defaultValue : this._comment;
	}

	public boolean hasComment() {
		return this._comment != null;
	}

	public CommentBlock removeComment() {
		this._comment = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		CommentBlock that = (CommentBlock) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "CommentBlock(comment) ::= <</*\n" + 
				"~comment~\n" + 
				"*/ >>";
}  