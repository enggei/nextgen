package nextgen.templates.javascript;

public class IndexHtml {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _title;
	private Object _src;

	IndexHtml(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("indexHtml");
		st.add("title", _title);
		st.add("src", _src);
		return st.render().trim();
	}

	public IndexHtml setTitle(Object value) {
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

	public IndexHtml removeTitle() {
		this._title = null;
		return this;
	} 

	public IndexHtml setSrc(Object value) {
		this._src = value;
		return this;
	}

	public Object getSrc() {
		return this._src;
	}

	public Object getSrc(Object defaultValue) {
		return this._src == null ? defaultValue : this._src;
	}

	public boolean hasSrc() {
		return this._src != null;
	}

	public IndexHtml removeSrc() {
		this._src = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		IndexHtml that = (IndexHtml) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "indexHtml(title,src) ::= <<<!DOCTYPE html>\n" + 
				"<html lang=\"en\">\n" + 
				"<head>\n" + 
				"    <meta charset=\"UTF-8\">\n" + 
				"    <meta name=\"viewport\" content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\">\n" + 
				"    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n" + 
				"\n" + 
				"    <link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Roboto:300,400,500\"/>\n" + 
				"\n" + 
				"    <title>~title~</title>\n" + 
				"</head>\n" + 
				"<body>\n" + 
				"<noscript>\n" + 
				"    You need to enable JavaScript to run ~title~.\n" + 
				"</noscript>\n" + 
				"<div id=\"root\"></div>\n" + 
				"<script type=\"text/javascript\" src=\"~src~.js\"></script>\n" + 
				"</body>\n" + 
				"</html> >>";
} 