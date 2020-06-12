package nextgen.templates.git;

public class RemoveFile {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _path;

	RemoveFile(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("removeFile");
		st.add("path", _path);
		return st.render().trim();
	}

	public RemoveFile setPath(Object value) {
		this._path = value;
		return this;
	}

	public Object getPath() {
		return this._path;
	}

	public Object getPath(Object defaultValue) {
		return this._path == null ? defaultValue : this._path;
	}

	public boolean hasPath() {
		return this._path != null;
	}

	public RemoveFile removePath() {
		this._path = null;
		return this;
	}



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		RemoveFile that = (RemoveFile) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "removeFile(path) ::= <<git rm --cached ~path~>>";
} 