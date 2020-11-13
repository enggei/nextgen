package nextgen.templates.materialdesignlight;

public class MiniFooter {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _heading;
	private java.util.List<Object> _buttons = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _linkList = new java.util.ArrayList<>();

	MiniFooter(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("MiniFooter");
		st.add("heading", _heading);
		for (Object o : _buttons) st.add("buttons", o);
		for (java.util.Map<String, Object> map : _linkList) st.addAggr("linkList.{href,name}", map.get("href"), map.get("name"));
		return st.render().trim();
	}

	public MiniFooter setHeading(Object value) {
		this._heading = value;
		return this;
	}

	public Object getHeading() {
		return this._heading;
	}

	public Object getHeading(Object defaultValue) {
		return this._heading == null ? defaultValue : this._heading;
	}

	public boolean hasHeading() {
		return this._heading != null;
	}

	public MiniFooter removeHeading() {
		this._heading = null;
		return this;
	} 

	public MiniFooter addButtons(Object value) {
		this._buttons.add(value);
		return this;
	}

	public MiniFooter setButtons(Object[] value) {
		this._buttons.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public MiniFooter setButtons(java.util.Collection<Object> values) {
		this._buttons.addAll(values);
		return this;
	}

	public MiniFooter removeButtons(Object value) {
		this._buttons.remove(value);
		return this;
	}

	public MiniFooter removeButtons(int index) {
		this._buttons.remove(index);
		return this;
	}

	public java.util.List<Object> getButtons() {
		return this._buttons;
	} 

	public MiniFooter addLinkList(Object _href, Object _name) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("href", _href);
		map.put("name", _name);
		this._linkList.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getLinkList() {
		return this._linkList;
	}

	public MiniFooter addLinkList(MiniFooter_LinkList value) {
		return addLinkList(value._href, value._name);
	}

	public java.util.stream.Stream<MiniFooter_LinkList> streamLinkList() {
		return this._linkList.stream().map(MiniFooter_LinkList::new);
	}

	public java.util.List<Object> getLinkList_Href() {
		return streamLinkList().map(MiniFooter_LinkList::getHref).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getLinkList_Name() {
		return streamLinkList().map(MiniFooter_LinkList::getName).collect(java.util.stream.Collectors.toList());
	}


	public static final class MiniFooter_LinkList {

		Object _href;
		Object _name;

		public MiniFooter_LinkList(Object _href, Object _name) {
			this._href = _href;
			this._name = _name;
		}

		private MiniFooter_LinkList(java.util.Map<String, Object> map) {
			this._href = (Object) map.get("href");
			this._name = (Object) map.get("name");
		}

		public Object getHref() {
			return this._href;
		}

		public Object getName() {
			return this._name;
		}

	}  

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		MiniFooter that = (MiniFooter) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "MiniFooter(heading,linkList,buttons) ::= <<<footer class=\"mdl-mini-footer\">\n" + 
				"	<div class=\"mdl-mini-footer__left-section\">\n" + 
				"		<div class=\"mdl-logo\">\n" + 
				"			~heading~\n" + 
				"		</div>\n" + 
				"		<ul class=\"mdl-mini-footer__link-list\">\n" + 
				"			~linkList:{it|<li><a href=\"~it.href~\">~it.name~</a></li>};separator=\"\\n\"~\n" + 
				"		</ul>\n" + 
				"	</div>\n" + 
				"	<div class=\"mdl-mini-footer__right-section\">\n" + 
				"		~buttons:{it|<button class=\"mdl-mini-footer__social-btn\"></button>};separator=\"\\n\"~\n" + 
				"	</div>\n" + 
				"</footer> >>";
}  