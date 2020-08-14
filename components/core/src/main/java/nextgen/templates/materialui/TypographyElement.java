package nextgen.templates.materialui;

public class TypographyElement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _align;
	private Object _classes;
	private Object _className;
	private Object _color;
	private Object _component;
	private Object _display;
	private Object _gutterBottom;
	private Object _id;
	private Object _noWrap;
	private Object _paragraph;
	private Object _variant;
	private Object _variantMapping;
	private java.util.List<Object> _children = new java.util.ArrayList<>();

	TypographyElement(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Deprecated
	public java.util.UUID uuid() {
		return uuid;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("TypographyElement");
		st.add("align", _align);
		st.add("classes", _classes);
		st.add("className", _className);
		st.add("color", _color);
		st.add("component", _component);
		st.add("display", _display);
		st.add("gutterBottom", _gutterBottom);
		st.add("id", _id);
		st.add("noWrap", _noWrap);
		st.add("paragraph", _paragraph);
		st.add("variant", _variant);
		st.add("variantMapping", _variantMapping);
		for (Object o : _children) st.add("children", o);
		return st.render().trim();
	}

	public TypographyElement setAlign(Object value) {
		this._align = value;
		return this;
	}

	public Object getAlign() {
		return this._align;
	}

	public Object getAlign(Object defaultValue) {
		return this._align == null ? defaultValue : this._align;
	}

	public boolean hasAlign() {
		return this._align != null;
	}

	public TypographyElement removeAlign() {
		this._align = null;
		return this;
	} 

	public TypographyElement setClasses(Object value) {
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

	public TypographyElement removeClasses() {
		this._classes = null;
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

	public TypographyElement setColor(Object value) {
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

	public TypographyElement removeColor() {
		this._color = null;
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

	public TypographyElement setDisplay(Object value) {
		this._display = value;
		return this;
	}

	public Object getDisplay() {
		return this._display;
	}

	public Object getDisplay(Object defaultValue) {
		return this._display == null ? defaultValue : this._display;
	}

	public boolean hasDisplay() {
		return this._display != null;
	}

	public TypographyElement removeDisplay() {
		this._display = null;
		return this;
	} 

	public TypographyElement setGutterBottom(Object value) {
		this._gutterBottom = value;
		return this;
	}

	public Object getGutterBottom() {
		return this._gutterBottom;
	}

	public Object getGutterBottom(Object defaultValue) {
		return this._gutterBottom == null ? defaultValue : this._gutterBottom;
	}

	public boolean hasGutterBottom() {
		return this._gutterBottom != null;
	}

	public TypographyElement removeGutterBottom() {
		this._gutterBottom = null;
		return this;
	} 

	public TypographyElement setId(Object value) {
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

	public TypographyElement removeId() {
		this._id = null;
		return this;
	} 

	public TypographyElement setNoWrap(Object value) {
		this._noWrap = value;
		return this;
	}

	public Object getNoWrap() {
		return this._noWrap;
	}

	public Object getNoWrap(Object defaultValue) {
		return this._noWrap == null ? defaultValue : this._noWrap;
	}

	public boolean hasNoWrap() {
		return this._noWrap != null;
	}

	public TypographyElement removeNoWrap() {
		this._noWrap = null;
		return this;
	} 

	public TypographyElement setParagraph(Object value) {
		this._paragraph = value;
		return this;
	}

	public Object getParagraph() {
		return this._paragraph;
	}

	public Object getParagraph(Object defaultValue) {
		return this._paragraph == null ? defaultValue : this._paragraph;
	}

	public boolean hasParagraph() {
		return this._paragraph != null;
	}

	public TypographyElement removeParagraph() {
		this._paragraph = null;
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

	public TypographyElement setVariantMapping(Object value) {
		this._variantMapping = value;
		return this;
	}

	public Object getVariantMapping() {
		return this._variantMapping;
	}

	public Object getVariantMapping(Object defaultValue) {
		return this._variantMapping == null ? defaultValue : this._variantMapping;
	}

	public boolean hasVariantMapping() {
		return this._variantMapping != null;
	}

	public TypographyElement removeVariantMapping() {
		this._variantMapping = null;
		return this;
	} 

	public TypographyElement addChildren(Object value) {
		this._children.add(value);
		return this;
	}

	public TypographyElement setChildren(Object[] value) {
		this._children.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public TypographyElement setChildren(java.util.Collection<Object> values) {
		this._children.addAll(values);
		return this;
	}

	public TypographyElement removeChildren(Object value) {
		this._children.remove(value);
		return this;
	}

	public TypographyElement removeChildren(int index) {
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
		TypographyElement that = (TypographyElement) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "TypographyElement(align,classes,className,color,component,display,gutterBottom,id,noWrap,paragraph,variant,variantMapping,children) ::= <<<Typography~if(align)~\n" + 
				"	align=\"~align~\"~endif~~if(classes)~\n" + 
				"	classes=~classes~~endif~~if(className)~\n" + 
				"	className=~className~~endif~~if(color)~\n" + 
				"	color=\"~color~\"~endif~~if(component)~\n" + 
				"	component=~component~~endif~~if(display)~\n" + 
				"	display=\"~display~\"~endif~~if(gutterBottom)~\n" + 
				"	gutterBottom~endif~~if(id)~\n" + 
				"	id=\"~id~\"~endif~~if(noWrap)~\n" + 
				"	noWrap~endif~~if(paragraph)~\n" + 
				"	paragraph~endif~~if(variant)~\n" + 
				"	variant=\"~variant~\"~endif~~if(variantMapping)~\n" + 
				"	variantMapping=~variantMapping~~endif~~if(children)~>\n" + 
				"	~children:{it|~it~};separator=\"\\n\"~\n" + 
				"</Typography>~else~ />~endif~ >>";
}  