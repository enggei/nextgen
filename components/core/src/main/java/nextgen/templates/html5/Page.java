package nextgen.templates.html5;

public class Page {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _head;
	private Object _body;
	private java.util.List<java.util.Map<String, Object>> _xmlns = new java.util.ArrayList<>();

	Page(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("page");
		st.add("head", _head);
		st.add("body", _body);
		for (java.util.Map<String, Object> map : _xmlns) st.addAggr("xmlns.{name,url}", map.get("name"), map.get("url"));
		return st.render().trim();
	}

	public Page setHead(Object value) {
		this._head = value;
		return this;
	}

	public Object getHead() {
		return this._head;
	}

	public Object getHead(Object defaultValue) {
		return this._head == null ? defaultValue : this._head;
	}

	public boolean hasHead() {
		return this._head != null;
	}

	public Page removeHead() {
		this._head = null;
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


	public Page addXmlns(Object _name, Object _url) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		map.put("url", _url);
		this._xmlns.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getXmlns() {
		return this._xmlns;
	}

	public Page addXmlns(Page_Xmlns value) {
		return addXmlns(value._name, value._url);
	}

	public java.util.stream.Stream<Page_Xmlns> streamXmlns() {
		return this._xmlns.stream().map(Page_Xmlns::new);
	}

	public static final class Page_Xmlns {

		Object _name;
		Object _url;

		public Page_Xmlns(Object _name, Object _url) {
			this._name = _name;
			this._url = _url;
		}

		private Page_Xmlns(java.util.Map<String, Object> map) {
			this._name = (Object) map.get("name");
			this._url = (Object) map.get("url");
		}

		public Object getName() {
			return this._name;
		}

		public Object getUrl() {
			return this._url;
		}

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

	static final String st = "page(xmlns,head,body) ::= <<<!DOCTYPE HTML>~xmlns:{it|\n" + 
				"<html xmlns:~it.name~=\"~it.url~\">};separator=\"\\n\"~\n" + 
				"~head~\n" + 
				"~body~ >>";
}  