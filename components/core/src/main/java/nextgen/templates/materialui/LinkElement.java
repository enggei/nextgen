package nextgen.templates.materialui;

public class LinkElement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _href;
	private Object _onClick;
	private Object _text;

	LinkElement(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("LinkElement");
		st.add("href", _href);
		st.add("onClick", _onClick);
		st.add("text", _text);
		return st.render().trim();
	}

	public LinkElement setHref(Object value) {
		this._href = value;
		return this;
	}

	public Object getHref() {
		return this._href;
	}

	public Object getHref(Object defaultValue) {
		return this._href == null ? defaultValue : this._href;
	}

	public boolean hasHref() {
		return this._href != null;
	}

	public LinkElement removeHref() {
		this._href = null;
		return this;
	} 

	public LinkElement setOnClick(Object value) {
		this._onClick = value;
		return this;
	}

	public Object getOnClick() {
		return this._onClick;
	}

	public Object getOnClick(Object defaultValue) {
		return this._onClick == null ? defaultValue : this._onClick;
	}

	public boolean hasOnClick() {
		return this._onClick != null;
	}

	public LinkElement removeOnClick() {
		this._onClick = null;
		return this;
	} 

	public LinkElement setText(Object value) {
		this._text = value;
		return this;
	}

	public Object getText() {
		return this._text;
	}

	public Object getText(Object defaultValue) {
		return this._text == null ? defaultValue : this._text;
	}

	public boolean hasText() {
		return this._text != null;
	}

	public LinkElement removeText() {
		this._text = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		LinkElement that = (LinkElement) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "LinkElement(href,onClick,text) ::= <<<Link href=\"~href~\" onClick=~onClick~>\n" + 
				"	~text~\n" + 
				"</Link> >>";
} 