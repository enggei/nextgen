package nextgen.templates.materialui;

public class BadgeElement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _anchorOrigin;
	private Object _badgeContent;
	private Object _classes;
	private Object _className;
	private Object _color;
	private Object _component;
	private Object _id;
	private Object _invisible;
	private Object _max;
	private Object _overlap;
	private Object _showZero;
	private Object _style;
	private Object _variant;
	private java.util.List<Object> _children = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _attribute = new java.util.ArrayList<>();

	BadgeElement(org.stringtemplate.v4.STGroup stGroup) {
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
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("BadgeElement");
		st.add("anchorOrigin", _anchorOrigin);
		st.add("badgeContent", _badgeContent);
		st.add("classes", _classes);
		st.add("className", _className);
		st.add("color", _color);
		st.add("component", _component);
		st.add("id", _id);
		st.add("invisible", _invisible);
		st.add("max", _max);
		st.add("overlap", _overlap);
		st.add("showZero", _showZero);
		st.add("style", _style);
		st.add("variant", _variant);
		for (Object o : _children) st.add("children", o);
		for (java.util.Map<String, Object> map : _attribute) st.addAggr("attribute.{name,value}", map.get("name"), map.get("value"));
		return st.render().trim();
	}

	public BadgeElement setAnchorOrigin(Object value) {
		this._anchorOrigin = value;
		return this;
	}

	public Object getAnchorOrigin() {
		return this._anchorOrigin;
	}

	public Object getAnchorOrigin(Object defaultValue) {
		return this._anchorOrigin == null ? defaultValue : this._anchorOrigin;
	}

	public boolean hasAnchorOrigin() {
		return this._anchorOrigin != null;
	}

	public BadgeElement removeAnchorOrigin() {
		this._anchorOrigin = null;
		return this;
	} 

	public BadgeElement setBadgeContent(Object value) {
		this._badgeContent = value;
		return this;
	}

	public Object getBadgeContent() {
		return this._badgeContent;
	}

	public Object getBadgeContent(Object defaultValue) {
		return this._badgeContent == null ? defaultValue : this._badgeContent;
	}

	public boolean hasBadgeContent() {
		return this._badgeContent != null;
	}

	public BadgeElement removeBadgeContent() {
		this._badgeContent = null;
		return this;
	} 

	public BadgeElement setClasses(Object value) {
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

	public BadgeElement removeClasses() {
		this._classes = null;
		return this;
	} 

	public BadgeElement setClassName(Object value) {
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

	public BadgeElement removeClassName() {
		this._className = null;
		return this;
	} 

	public BadgeElement setColor(Object value) {
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

	public BadgeElement removeColor() {
		this._color = null;
		return this;
	} 

	public BadgeElement setComponent(Object value) {
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

	public BadgeElement removeComponent() {
		this._component = null;
		return this;
	} 

	public BadgeElement setId(Object value) {
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

	public BadgeElement removeId() {
		this._id = null;
		return this;
	} 

	public BadgeElement setInvisible(Object value) {
		this._invisible = value;
		return this;
	}

	public Object getInvisible() {
		return this._invisible;
	}

	public Object getInvisible(Object defaultValue) {
		return this._invisible == null ? defaultValue : this._invisible;
	}

	public boolean hasInvisible() {
		return this._invisible != null;
	}

	public BadgeElement removeInvisible() {
		this._invisible = null;
		return this;
	} 

	public BadgeElement setMax(Object value) {
		this._max = value;
		return this;
	}

	public Object getMax() {
		return this._max;
	}

	public Object getMax(Object defaultValue) {
		return this._max == null ? defaultValue : this._max;
	}

	public boolean hasMax() {
		return this._max != null;
	}

	public BadgeElement removeMax() {
		this._max = null;
		return this;
	} 

	public BadgeElement setOverlap(Object value) {
		this._overlap = value;
		return this;
	}

	public Object getOverlap() {
		return this._overlap;
	}

	public Object getOverlap(Object defaultValue) {
		return this._overlap == null ? defaultValue : this._overlap;
	}

	public boolean hasOverlap() {
		return this._overlap != null;
	}

	public BadgeElement removeOverlap() {
		this._overlap = null;
		return this;
	} 

	public BadgeElement setShowZero(Object value) {
		this._showZero = value;
		return this;
	}

	public Object getShowZero() {
		return this._showZero;
	}

	public Object getShowZero(Object defaultValue) {
		return this._showZero == null ? defaultValue : this._showZero;
	}

	public boolean hasShowZero() {
		return this._showZero != null;
	}

	public BadgeElement removeShowZero() {
		this._showZero = null;
		return this;
	} 

	public BadgeElement setStyle(Object value) {
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

	public BadgeElement removeStyle() {
		this._style = null;
		return this;
	} 

	public BadgeElement setVariant(Object value) {
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

	public BadgeElement removeVariant() {
		this._variant = null;
		return this;
	} 

	public BadgeElement addChildren(Object value) {
		this._children.add(value);
		return this;
	}

	public BadgeElement setChildren(Object[] value) {
		this._children.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public BadgeElement setChildren(java.util.Collection<Object> values) {
		this._children.addAll(values);
		return this;
	}

	public BadgeElement removeChildren(Object value) {
		this._children.remove(value);
		return this;
	}

	public BadgeElement removeChildren(int index) {
		this._children.remove(index);
		return this;
	}

	public java.util.List<Object> getChildren() {
		return this._children;
	} 

	public BadgeElement addAttribute(Object _name, Object _value) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		map.put("value", _value);
		this._attribute.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getAttribute() {
		return this._attribute;
	}

	public BadgeElement addAttribute(BadgeElement_Attribute value) {
		return addAttribute(value._name, value._value);
	}

	public java.util.stream.Stream<BadgeElement_Attribute> streamAttribute() {
		return this._attribute.stream().map(BadgeElement_Attribute::new);
	}

	public static final class BadgeElement_Attribute {

		Object _name;
		Object _value;

		public BadgeElement_Attribute(Object _name, Object _value) {
			this._name = _name;
			this._value = _value;
		}

		private BadgeElement_Attribute(java.util.Map<String, Object> map) {
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
		BadgeElement that = (BadgeElement) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "BadgeElement(anchorOrigin,badgeContent,classes,className,color,component,id,invisible,max,overlap,showZero,style,variant,attribute,children) ::= <<<Badge~if(anchorOrigin)~\n" + 
				"	anchorOrigin=\"~anchorOrigin~\"~endif~~if(badgeContent)~\n" + 
				"	badgeContent=~badgeContent~~endif~~if(classes)~\n" + 
				"	classes=~classes~~endif~~if(className)~\n" + 
				"	className=~className~~endif~~if(color)~\n" + 
				"	color=\"~color~\"~endif~~if(component)~\n" + 
				"	component=~component~~endif~~if(id)~\n" + 
				"	id=\"~id~\"~endif~~if(invisible)~\n" + 
				"	invisible~endif~~if(max)~\n" + 
				"	max=~max~~endif~~if(overlap)~\n" + 
				"	overlap=\"~overlap~\"~endif~~if(showZero)~\n" + 
				"	showZero~endif~~if(style)~\n" + 
				"	style=~style~~endif~~if(variant)~\n" + 
				"	variant=\"~variant~\"~endif~~attribute:{it|\n" + 
				"	\n" + 
				"	~it.name~=~it.value~}~~if(children)~>\n" + 
				"	~children:{it|~it~};separator=\"\\n\"~\n" + 
				"</Badge>~else~ />~endif~ >>";
}  