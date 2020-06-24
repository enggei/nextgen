package nextgen.templates.git;

public class Clone {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _url;

	Clone(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("clone");
		st.add("url", _url);
		return st.render().trim();
	}

	public Clone setUrl(Object value) {
		this._url = value;
		return this;
	}

	public Object getUrl() {
		return this._url;
	}

	public Object getUrl(Object defaultValue) {
		return this._url == null ? defaultValue : this._url;
	}

	public boolean hasUrl() {
		return this._url != null;
	}

	public Clone removeUrl() {
		this._url = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Clone that = (Clone) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "clone(url) ::= <<git clone ~url~ >>";
} 