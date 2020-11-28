package nextgen.templates.materialui;

public class LinkElement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _classes;
	private Object _className;
	private Object _color;
	private Object _component;
	private Object _id;
	private Object _key;
	private Object _style;
	private Object _TypographyClasses;
	private Object _underline;
	private Object _variant;
	private java.util.List<Object> _children = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _attribute = new java.util.ArrayList<>();

	LinkElement(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("LinkElement");
		st.add("classes", _classes);
		st.add("className", _className);
		st.add("color", _color);
		st.add("component", _component);
		st.add("id", _id);
		st.add("key", _key);
		st.add("style", _style);
		st.add("TypographyClasses", _TypographyClasses);
		st.add("underline", _underline);
		st.add("variant", _variant);
		for (Object o : _children) st.add("children", o);
		for (java.util.Map<String, Object> map : _attribute) st.addAggr("attribute.{name,value}", map.get("name"), map.get("value"));
		return st.render().trim();
	}

	public LinkElement setClasses(Object value) {
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

	public LinkElement removeClasses() {
		this._classes = null;
		return this;
	} 

	public LinkElement setClassName(Object value) {
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

	public LinkElement removeClassName() {
		this._className = null;
		return this;
	} 

	public LinkElement setColor(Object value) {
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

	public LinkElement removeColor() {
		this._color = null;
		return this;
	} 

	public LinkElement setComponent(Object value) {
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

	public LinkElement removeComponent() {
		this._component = null;
		return this;
	} 

	public LinkElement setId(Object value) {
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

	public LinkElement removeId() {
		this._id = null;
		return this;
	} 

	public LinkElement setKey(Object value) {
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

	public LinkElement removeKey() {
		this._key = null;
		return this;
	} 

	public LinkElement setStyle(Object value) {
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

	public LinkElement removeStyle() {
		this._style = null;
		return this;
	} 

	public LinkElement setTypographyClasses(Object value) {
		this._TypographyClasses = value;
		return this;
	}

	public Object getTypographyClasses() {
		return this._TypographyClasses;
	}

	public Object getTypographyClasses(Object defaultValue) {
		return this._TypographyClasses == null ? defaultValue : this._TypographyClasses;
	}

	public boolean hasTypographyClasses() {
		return this._TypographyClasses != null;
	}

	public LinkElement removeTypographyClasses() {
		this._TypographyClasses = null;
		return this;
	} 

	public LinkElement setUnderline(Object value) {
		this._underline = value;
		return this;
	}

	public Object getUnderline() {
		return this._underline;
	}

	public Object getUnderline(Object defaultValue) {
		return this._underline == null ? defaultValue : this._underline;
	}

	public boolean hasUnderline() {
		return this._underline != null;
	}

	public LinkElement removeUnderline() {
		this._underline = null;
		return this;
	} 

	public LinkElement setVariant(Object value) {
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

	public LinkElement removeVariant() {
		this._variant = null;
		return this;
	} 

	public LinkElement addChildren(Object value) {
		this._children.add(value);
		return this;
	}

	public LinkElement setChildren(Object[] value) {
		this._children.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public LinkElement setChildren(java.util.Collection<Object> values) {
		this._children.addAll(values);
		return this;
	}

	public LinkElement removeChildren(Object value) {
		this._children.remove(value);
		return this;
	}

	public LinkElement removeChildren(int index) {
		this._children.remove(index);
		return this;
	}

	public java.util.List<Object> getChildren() {
		return this._children;
	} 

	public LinkElement addAttribute(Object _name, Object _value) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		map.put("value", _value);
		this._attribute.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getAttribute() {
		return this._attribute;
	}

	public LinkElement addAttribute(LinkElement_Attribute value) {
		return addAttribute(value._name, value._value);
	}

	public java.util.stream.Stream<LinkElement_Attribute> streamAttribute() {
		return this._attribute.stream().map(LinkElement_Attribute::new);
	}

	public java.util.List<Object> getAttribute_Name() {
		return streamAttribute().map(LinkElement_Attribute::getName).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getAttribute_Value() {
		return streamAttribute().map(LinkElement_Attribute::getValue).collect(java.util.stream.Collectors.toList());
	}


	public static final class LinkElement_Attribute {

		Object _name;
		Object _value;

		public LinkElement_Attribute(Object _name, Object _value) {
			this._name = _name;
			this._value = _value;
		}

		private LinkElement_Attribute(java.util.Map<String, Object> map) {
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
		LinkElement that = (LinkElement) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "LinkElement(classes,className,color,component,id,key,style,TypographyClasses,underline,variant,attribute,children) ::= <<<Link~if(classes)~\n" + 
				"	classes=~classes~~endif~~if(className)~\n" + 
				"	className=~className~~endif~~if(color)~\n" + 
				"	color=\"~color~\"~endif~~if(component)~\n" + 
				"	component=~component~~endif~~if(id)~\n" + 
				"	id=\"~id~\"~endif~~if(key)~\n" + 
				"	key=~key~~endif~~if(style)~\n" + 
				"	style=~style~~endif~~if(TypographyClasses)~\n" + 
				"	TypographyClasses=~TypographyClasses~~endif~~if(underline)~\n" + 
				"	underline=~underline~~endif~~if(variant)~\n" + 
				"	variant=\"~variant~\"~endif~~attribute:{it|\n" + 
				"	\n" + 
				"	~it.name~=~it.value~}~~if(children)~>\n" + 
				"	~children:{it|~it~};separator=\"\\n\"~\n" + 
				"</Link>~else~ />~endif~ >>";
}  