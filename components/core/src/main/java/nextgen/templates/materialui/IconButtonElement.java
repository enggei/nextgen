package nextgen.templates.materialui;

public class IconButtonElement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _classes;
	private Object _className;
	private Object _color;
	private Object _disabled;
	private Object _disableFocusRipple;
	private Object _disableRipple;
	private Object _edge;
	private Object _id;
	private Object _onClick;
	private Object _size;
	private Object _style;
	private java.util.List<Object> _children = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _attribute = new java.util.ArrayList<>();

	IconButtonElement(org.stringtemplate.v4.STGroup stGroup) {
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
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("IconButtonElement");
		st.add("classes", _classes);
		st.add("className", _className);
		st.add("color", _color);
		st.add("disabled", _disabled);
		st.add("disableFocusRipple", _disableFocusRipple);
		st.add("disableRipple", _disableRipple);
		st.add("edge", _edge);
		st.add("id", _id);
		st.add("onClick", _onClick);
		st.add("size", _size);
		st.add("style", _style);
		for (Object o : _children) st.add("children", o);
		for (java.util.Map<String, Object> map : _attribute) st.addAggr("attribute.{name,value}", map.get("name"), map.get("value"));
		return st.render().trim();
	}

	public IconButtonElement setClasses(Object value) {
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

	public IconButtonElement removeClasses() {
		this._classes = null;
		return this;
	} 

	public IconButtonElement setClassName(Object value) {
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

	public IconButtonElement removeClassName() {
		this._className = null;
		return this;
	} 

	public IconButtonElement setColor(Object value) {
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

	public IconButtonElement removeColor() {
		this._color = null;
		return this;
	} 

	public IconButtonElement setDisabled(Object value) {
		this._disabled = value;
		return this;
	}

	public Object getDisabled() {
		return this._disabled;
	}

	public Object getDisabled(Object defaultValue) {
		return this._disabled == null ? defaultValue : this._disabled;
	}

	public boolean hasDisabled() {
		return this._disabled != null;
	}

	public IconButtonElement removeDisabled() {
		this._disabled = null;
		return this;
	} 

	public IconButtonElement setDisableFocusRipple(Object value) {
		this._disableFocusRipple = value;
		return this;
	}

	public Object getDisableFocusRipple() {
		return this._disableFocusRipple;
	}

	public Object getDisableFocusRipple(Object defaultValue) {
		return this._disableFocusRipple == null ? defaultValue : this._disableFocusRipple;
	}

	public boolean hasDisableFocusRipple() {
		return this._disableFocusRipple != null;
	}

	public IconButtonElement removeDisableFocusRipple() {
		this._disableFocusRipple = null;
		return this;
	} 

	public IconButtonElement setDisableRipple(Object value) {
		this._disableRipple = value;
		return this;
	}

	public Object getDisableRipple() {
		return this._disableRipple;
	}

	public Object getDisableRipple(Object defaultValue) {
		return this._disableRipple == null ? defaultValue : this._disableRipple;
	}

	public boolean hasDisableRipple() {
		return this._disableRipple != null;
	}

	public IconButtonElement removeDisableRipple() {
		this._disableRipple = null;
		return this;
	} 

	public IconButtonElement setEdge(Object value) {
		this._edge = value;
		return this;
	}

	public Object getEdge() {
		return this._edge;
	}

	public Object getEdge(Object defaultValue) {
		return this._edge == null ? defaultValue : this._edge;
	}

	public boolean hasEdge() {
		return this._edge != null;
	}

	public IconButtonElement removeEdge() {
		this._edge = null;
		return this;
	} 

	public IconButtonElement setId(Object value) {
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

	public IconButtonElement removeId() {
		this._id = null;
		return this;
	} 

	public IconButtonElement setOnClick(Object value) {
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

	public IconButtonElement removeOnClick() {
		this._onClick = null;
		return this;
	} 

	public IconButtonElement setSize(Object value) {
		this._size = value;
		return this;
	}

	public Object getSize() {
		return this._size;
	}

	public Object getSize(Object defaultValue) {
		return this._size == null ? defaultValue : this._size;
	}

	public boolean hasSize() {
		return this._size != null;
	}

	public IconButtonElement removeSize() {
		this._size = null;
		return this;
	} 

	public IconButtonElement setStyle(Object value) {
		this._style = value;
		return this;
	}

	public Object getStyle() {
		return this._style;
	}

	public Object getStyle(Object defaultValue) {
		return this._style == null ? defaultValue : this._style;
	}

	public boolean hasStyle() {
		return this._style != null;
	}

	public IconButtonElement removeStyle() {
		this._style = null;
		return this;
	} 

	public IconButtonElement addChildren(Object value) {
		this._children.add(value);
		return this;
	}

	public IconButtonElement setChildren(Object[] value) {
		this._children.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public IconButtonElement setChildren(java.util.Collection<Object> values) {
		this._children.addAll(values);
		return this;
	}

	public IconButtonElement removeChildren(Object value) {
		this._children.remove(value);
		return this;
	}

	public IconButtonElement removeChildren(int index) {
		this._children.remove(index);
		return this;
	}

	public java.util.List<Object> getChildren() {
		return this._children;
	} 

	public IconButtonElement addAttribute(Object _name, Object _value) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		map.put("value", _value);
		this._attribute.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getAttribute() {
		return this._attribute;
	}

	public IconButtonElement addAttribute(IconButtonElement_Attribute value) {
		return addAttribute(value._name, value._value);
	}

	public java.util.stream.Stream<IconButtonElement_Attribute> streamAttribute() {
		return this._attribute.stream().map(IconButtonElement_Attribute::new);
	}

	public static final class IconButtonElement_Attribute {

		Object _name;
		Object _value;

		public IconButtonElement_Attribute(Object _name, Object _value) {
			this._name = _name;
			this._value = _value;
		}

		private IconButtonElement_Attribute(java.util.Map<String, Object> map) {
			this._name = (Object) map.get("name");
			this._value = (Object) map.get("value");
		}

		public Object getName() {
			return this._name;
		}

		public Object getValue() {
			return this._value;
		}

	} 

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		IconButtonElement that = (IconButtonElement) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "IconButtonElement(classes,className,color,disabled,disableFocusRipple,disableRipple,edge,id,onClick,size,style,attribute,children) ::= <<<IconButton~if(classes)~\n" + 
				"	classes=~classes~~endif~~if(className)~\n" + 
				"	className=~className~~endif~~if(color)~\n" + 
				"	color=\"~color~\"~endif~~if(disabled)~\n" + 
				"	disabled~endif~~if(disableFocusRipple)~\n" + 
				"	disableFocusRipple~endif~~if(disableRipple)~\n" + 
				"	disableRipple~endif~~if(edge)~\n" + 
				"	edge=\"~edge~\"~endif~~if(id)~\n" + 
				"	id=\"~id~\"~endif~~if(onClick)~\n" + 
				"	onClick=~onClick~~endif~~if(size)~\n" + 
				"	size=\"~size~\"~endif~~if(style)~\n" + 
				"	style=~style~~endif~~attribute:{it|\n" + 
				"	\n" + 
				"	~it.name~=~it.value~}~~if(children)~>\n" + 
				"	~children:{it|~it~};separator=\"\\n\"~\n" + 
				"</IconButton>~else~ />~endif~ >>";
}  