package nextgen.templates.materialui;

public class IconElement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _classes;
	private Object _className;
	private Object _color;
	private Object _component;
	private Object _fontSize;
	private java.util.List<Object> _children = new java.util.ArrayList<>();

	IconElement(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("IconElement");
		st.add("classes", _classes);
		st.add("className", _className);
		st.add("color", _color);
		st.add("component", _component);
		st.add("fontSize", _fontSize);
		for (Object o : _children) st.add("children", o);
		return st.render().trim();
	}

	public IconElement setClasses(Object value) {
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

	public IconElement removeClasses() {
		this._classes = null;
		return this;
	} 

	public IconElement setClassName(Object value) {
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

	public IconElement removeClassName() {
		this._className = null;
		return this;
	} 

	public IconElement setColor(Object value) {
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

	public IconElement removeColor() {
		this._color = null;
		return this;
	} 

	public IconElement setComponent(Object value) {
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

	public IconElement removeComponent() {
		this._component = null;
		return this;
	} 

	public IconElement setFontSize(Object value) {
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

	public IconElement removeFontSize() {
		this._fontSize = null;
		return this;
	} 

	public IconElement addChildren(Object value) {
		this._children.add(value);
		return this;
	}

	public IconElement setChildren(Object[] value) {
		this._children.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public IconElement setChildren(java.util.Collection<Object> values) {
		this._children.addAll(values);
		return this;
	}

	public IconElement removeChildren(Object value) {
		this._children.remove(value);
		return this;
	}

	public IconElement removeChildren(int index) {
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
		IconElement that = (IconElement) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "IconElement(classes,className,color,component,fontSize,children) ::= <<<Icon~if(classes)~\n" + 
				"	classes=~classes~~endif~~if(className)~\n" + 
				"	className=~className~~endif~~if(color)~\n" + 
				"	color=\"~color~\"~endif~~if(component)~\n" + 
				"	component=~component~~endif~~if(fontSize)~\n" + 
				"	fontSize=\"~fontSize~\"~endif~~if(children)~>\n" + 
				"	~children:{it|~it~};separator=\"\\n\"~\n" + 
				"</Icon>~else~ />~endif~ >>";
}  