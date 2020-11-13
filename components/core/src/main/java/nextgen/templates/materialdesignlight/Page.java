package nextgen.templates.materialdesignlight;

public class Page {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _description;
	private Object _title;
	private Object _body;

	Page(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("Page");
		st.add("description", _description);
		st.add("title", _title);
		st.add("body", _body);
		return st.render().trim();
	}

	public Page setDescription(Object value) {
		this._description = value;
		return this;
	}

	public Object getDescription() {
		return this._description;
	}

	public Object getDescription(Object defaultValue) {
		return this._description == null ? defaultValue : this._description;
	}

	public boolean hasDescription() {
		return this._description != null;
	}

	public Page removeDescription() {
		this._description = null;
		return this;
	} 

	public Page setTitle(Object value) {
		this._title = value;
		return this;
	}

	public Object getTitle() {
		return this._title;
	}

	public Object getTitle(Object defaultValue) {
		return this._title == null ? defaultValue : this._title;
	}

	public boolean hasTitle() {
		return this._title != null;
	}

	public Page removeTitle() {
		this._title = null;
		return this;
	} 

	public Page setBody(Object value) {
		this._body = value;
		return this;
	}

	public Object getBody() {
		return this._body;
	}

	public Object getBody(Object defaultValue) {
		return this._body == null ? defaultValue : this._body;
	}

	public boolean hasBody() {
		return this._body != null;
	}

	public Page removeBody() {
		this._body = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Page that = (Page) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "Page(description,title,body) ::= <<<!doctype html>\n" + 
				"<html lang=\"en\">\n" + 
				"<head>\n" + 
				"	<meta charset=\"utf-8\">\n" + 
				"	<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" + 
				"	<meta name=\"description\" content=\"~description~\">\n" + 
				"	<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, minimum-scale=1.0\">\n" + 
				"	<title>~title~</title>\n" + 
				"	<link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Roboto:regular,bold,italic,thin,light,bolditalic,black,medium&amp;lang=en\">\n" + 
				"	<link rel=\"stylesheet\" href=\"https://code.getmdl.io/1.3.0/material.grey-pink.min.css\" />\n" + 
				"	<link rel=\"stylesheet\" href=\"styles.css\" />\n" + 
				"	<link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/icon?family=Material+Icons\">\n" + 
				"</head>\n" + 
				"\n" + 
				"<body>\n" + 
				"	~body~\n" + 
				"	<script src=\"https://code.getmdl.io/1.3.0/material.min.js\"></script>\n" + 
				"</body>\n" + 
				"\n" + 
				"</html> >>";
}  