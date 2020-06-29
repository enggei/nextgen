package nextgen.templates.materialui;

public class TypographyElement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _key;
	private Object _className;
	private Object _variant;
	private Object _component;
	private Object _gutter;
	private Object _text;

	TypographyElement(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("TypographyElement");
		st.add("key", _key);
		st.add("className", _className);
		st.add("variant", _variant);
		st.add("component", _component);
		st.add("gutter", _gutter);
		st.add("text", _text);
		return st.render().trim();
	}

	public TypographyElement setKey(Object value) {
		this._key = value;
		return this;
	}

	public Object getKey() {
		return this._key;
	}

	public Object getKey(Object defaultValue) {
		return this._key == null ? defaultValue : this._key;
	}

	public boolean hasKey() {
		return this._key != null;
	}

	public TypographyElement removeKey() {
		this._key = null;
		return this;
	} 

	public TypographyElement setClassName(Object value) {
		this._className = value;
		return this;
	}

	public Object getClassName() {
		return this._className;
	}

	public Object getClassName(Object defaultValue) {
		return this._className == null ? defaultValue : this._className;
	}

	public boolean hasClassName() {
		return this._className != null;
	}

	public TypographyElement removeClassName() {
		this._className = null;
		return this;
	} 

	public TypographyElement setVariant(Object value) {
		this._variant = value;
		return this;
	}

	public Object getVariant() {
		return this._variant;
	}

	public Object getVariant(Object defaultValue) {
		return this._variant == null ? defaultValue : this._variant;
	}

	public boolean hasVariant() {
		return this._variant != null;
	}

	public TypographyElement removeVariant() {
		this._variant = null;
		return this;
	} 

	public TypographyElement setComponent(Object value) {
		this._component = value;
		return this;
	}

	public Object getComponent() {
		return this._component;
	}

	public Object getComponent(Object defaultValue) {
		return this._component == null ? defaultValue : this._component;
	}

	public boolean hasComponent() {
		return this._component != null;
	}

	public TypographyElement removeComponent() {
		this._component = null;
		return this;
	} 

	public TypographyElement setGutter(Object value) {
		this._gutter = value;
		return this;
	}

	public Object getGutter() {
		return this._gutter;
	}

	public Object getGutter(Object defaultValue) {
		return this._gutter == null ? defaultValue : this._gutter;
	}

	public boolean hasGutter() {
		return this._gutter != null;
	}

	public TypographyElement removeGutter() {
		this._gutter = null;
		return this;
	} 

	public TypographyElement setText(Object value) {
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

	public TypographyElement removeText() {
		this._text = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		TypographyElement that = (TypographyElement) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "TypographyElement(key,className,variant,component,gutter,text) ::= <<<Typography~if(key)~ key=~key~~endif~~if(className)~ className={classes.~className~}~endif~~if(variant)~ variant=\"~variant~\"~endif~~if(component)~ component=\"~component~\"~endif~~if(gutter)~ ~gutter~~endif~>\n" + 
				"	~text~\n" + 
				"</Typography> >>";
}  