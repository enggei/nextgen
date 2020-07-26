package nextgen.templates.materialui;

public class SvgIconElement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _classes;
	private Object _className;
	private Object _color;
	private Object _component;
	private Object _fontSize;
	private Object _htmlColor;
	private Object _shapeRendering;
	private Object _titleAccess;
	private Object _viewBox;
	private java.util.List<Object> _children = new java.util.ArrayList<>();

	SvgIconElement(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("SvgIconElement");
		st.add("classes", _classes);
		st.add("className", _className);
		st.add("color", _color);
		st.add("component", _component);
		st.add("fontSize", _fontSize);
		st.add("htmlColor", _htmlColor);
		st.add("shapeRendering", _shapeRendering);
		st.add("titleAccess", _titleAccess);
		st.add("viewBox", _viewBox);
		for (Object o : _children) st.add("children", o);
		return st.render().trim();
	}

	public SvgIconElement setClasses(Object value) {
		this._classes = value;
		return this;
	}

	public Object getClasses() {
		return this._classes;
	}

	public Object getClasses(Object defaultValue) {
		return this._classes == null ? defaultValue : this._classes;
	}

	public boolean hasClasses() {
		return this._classes != null;
	}

	public SvgIconElement removeClasses() {
		this._classes = null;
		return this;
	} 

	public SvgIconElement setClassName(Object value) {
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

	public SvgIconElement removeClassName() {
		this._className = null;
		return this;
	} 

	public SvgIconElement setColor(Object value) {
		this._color = value;
		return this;
	}

	public Object getColor() {
		return this._color;
	}

	public Object getColor(Object defaultValue) {
		return this._color == null ? defaultValue : this._color;
	}

	public boolean hasColor() {
		return this._color != null;
	}

	public SvgIconElement removeColor() {
		this._color = null;
		return this;
	} 

	public SvgIconElement setComponent(Object value) {
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

	public SvgIconElement removeComponent() {
		this._component = null;
		return this;
	} 

	public SvgIconElement setFontSize(Object value) {
		this._fontSize = value;
		return this;
	}

	public Object getFontSize() {
		return this._fontSize;
	}

	public Object getFontSize(Object defaultValue) {
		return this._fontSize == null ? defaultValue : this._fontSize;
	}

	public boolean hasFontSize() {
		return this._fontSize != null;
	}

	public SvgIconElement removeFontSize() {
		this._fontSize = null;
		return this;
	} 

	public SvgIconElement setHtmlColor(Object value) {
		this._htmlColor = value;
		return this;
	}

	public Object getHtmlColor() {
		return this._htmlColor;
	}

	public Object getHtmlColor(Object defaultValue) {
		return this._htmlColor == null ? defaultValue : this._htmlColor;
	}

	public boolean hasHtmlColor() {
		return this._htmlColor != null;
	}

	public SvgIconElement removeHtmlColor() {
		this._htmlColor = null;
		return this;
	} 

	public SvgIconElement setShapeRendering(Object value) {
		this._shapeRendering = value;
		return this;
	}

	public Object getShapeRendering() {
		return this._shapeRendering;
	}

	public Object getShapeRendering(Object defaultValue) {
		return this._shapeRendering == null ? defaultValue : this._shapeRendering;
	}

	public boolean hasShapeRendering() {
		return this._shapeRendering != null;
	}

	public SvgIconElement removeShapeRendering() {
		this._shapeRendering = null;
		return this;
	} 

	public SvgIconElement setTitleAccess(Object value) {
		this._titleAccess = value;
		return this;
	}

	public Object getTitleAccess() {
		return this._titleAccess;
	}

	public Object getTitleAccess(Object defaultValue) {
		return this._titleAccess == null ? defaultValue : this._titleAccess;
	}

	public boolean hasTitleAccess() {
		return this._titleAccess != null;
	}

	public SvgIconElement removeTitleAccess() {
		this._titleAccess = null;
		return this;
	} 

	public SvgIconElement setViewBox(Object value) {
		this._viewBox = value;
		return this;
	}

	public Object getViewBox() {
		return this._viewBox;
	}

	public Object getViewBox(Object defaultValue) {
		return this._viewBox == null ? defaultValue : this._viewBox;
	}

	public boolean hasViewBox() {
		return this._viewBox != null;
	}

	public SvgIconElement removeViewBox() {
		this._viewBox = null;
		return this;
	} 

	public SvgIconElement addChildren(Object value) {
		this._children.add(value);
		return this;
	}

	public SvgIconElement setChildren(Object[] value) {
		this._children.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public SvgIconElement setChildren(java.util.Collection<Object> values) {
		this._children.addAll(values);
		return this;
	}

	public SvgIconElement removeChildren(Object value) {
		this._children.remove(value);
		return this;
	}

	public SvgIconElement removeChildren(int index) {
		this._children.remove(index);
		return this;
	}

	public java.util.List<Object> getChildren() {
		return this._children;
	} 


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		SvgIconElement that = (SvgIconElement) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "SvgIconElement(classes,className,color,component,fontSize,htmlColor,shapeRendering,titleAccess,viewBox,children) ::= <<<SvgIcon~if(classes)~\n" + 
				"	classes=~classes~~endif~~if(className)~\n" + 
				"	className=~className~~endif~~if(color)~\n" + 
				"	color=\"~color~\"~endif~~if(component)~\n" + 
				"	component=~component~~endif~~if(fontSize)~\n" + 
				"	fontSize=\"~fontSize~\"~endif~~if(htmlColor)~\n" + 
				"	htmlColor=\"~htmlColor~\"~endif~~if(shapeRendering)~\n" + 
				"	shapeRendering=\"~shapeRendering~\"~endif~~if(titleAccess)~\n" + 
				"	titleAccess=\"~titleAccess~\"~endif~~if(viewBox)~\n" + 
				"	viewBox=\"~viewBox~\"~endif~~if(children)~>\n" + 
				"	~children:{it|~it~};separator=\"\\n\"~\n" + 
				"</SvgIcon>~else~ />~endif~ >>";
}  