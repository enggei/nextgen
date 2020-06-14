package nextgen.templates.maven;

public class Repository {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _id;
	private Object _name;
	private Object _url;

	Repository(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("repository");
		st.add("id", _id);
		st.add("name", _name);
		st.add("url", _url);
		return st.render().trim();
	}

	public Repository setId(Object value) {
		this._id = value;
		return this;
	}

	public Object getId() {
		return this._id;
	}

	public Object getId(Object defaultValue) {
		return this._id == null ? defaultValue : this._id;
	}

	public boolean hasId() {
		return this._id != null;
	}

	public Repository removeId() {
		this._id = null;
		return this;
	}

	public Repository setName(Object value) {
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

	public Repository removeName() {
		this._name = null;
		return this;
	}

	public Repository setUrl(Object value) {
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

	public Repository removeUrl() {
		this._url = null;
		return this;
	}



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Repository that = (Repository) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "repository(id,name,url) ::= <<<repository>\n" + 
				"	<id>~id~</id>\n" + 
				"	<name>~name~</name>\n" + 
				"	<url>~url~</url>\n" + 
				"</repository> >>";
} 