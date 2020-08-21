package nextgen.templates.materialui;

public class SpeedDialIconElement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _classes;
	private Object _className;
	private Object _icon;
	private Object _id;
	private Object _openIcon;
	private Object _style;
	private java.util.List<java.util.Map<String, Object>> _attribute = new java.util.ArrayList<>();

	SpeedDialIconElement(org.stringtemplate.v4.STGroup stGroup) {
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
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("SpeedDialIconElement");
		st.add("classes", _classes);
		st.add("className", _className);
		st.add("icon", _icon);
		st.add("id", _id);
		st.add("openIcon", _openIcon);
		st.add("style", _style);
		for (java.util.Map<String, Object> map : _attribute) st.addAggr("attribute.{name,value}", map.get("name"), map.get("value"));
		return st.render().trim();
	}

	public SpeedDialIconElement setClasses(Object value) {
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

	public SpeedDialIconElement removeClasses() {
		this._classes = null;
		return this;
	} 

	public SpeedDialIconElement setClassName(Object value) {
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

	public SpeedDialIconElement removeClassName() {
		this._className = null;
		return this;
	} 

	public SpeedDialIconElement setIcon(Object value) {
		this._icon = value;
		return this;
	}

	public Object getIcon() {
		return this._icon;
	}

	public Object getIcon(Object defaultValue) {
		return this._icon == null ? defaultValue : this._icon;
	}

	public boolean hasIcon() {
		return this._icon != null;
	}

	public SpeedDialIconElement removeIcon() {
		this._icon = null;
		return this;
	} 

	public SpeedDialIconElement setId(Object value) {
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

	public SpeedDialIconElement removeId() {
		this._id = null;
		return this;
	} 

	public SpeedDialIconElement setOpenIcon(Object value) {
		this._openIcon = value;
		return this;
	}

	public Object getOpenIcon() {
		return this._openIcon;
	}

	public Object getOpenIcon(Object defaultValue) {
		return this._openIcon == null ? defaultValue : this._openIcon;
	}

	public boolean hasOpenIcon() {
		return this._openIcon != null;
	}

	public SpeedDialIconElement removeOpenIcon() {
		this._openIcon = null;
		return this;
	} 

	public SpeedDialIconElement setStyle(Object value) {
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

	public SpeedDialIconElement removeStyle() {
		this._style = null;
		return this;
	} 


	public SpeedDialIconElement addAttribute(Object _name, Object _value) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		map.put("value", _value);
		this._attribute.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getAttribute() {
		return this._attribute;
	}

	public SpeedDialIconElement addAttribute(SpeedDialIconElement_Attribute value) {
		return addAttribute(value._name, value._value);
	}

	public java.util.stream.Stream<SpeedDialIconElement_Attribute> streamAttribute() {
		return this._attribute.stream().map(SpeedDialIconElement_Attribute::new);
	}

	public static final class SpeedDialIconElement_Attribute {

		Object _name;
		Object _value;

		public SpeedDialIconElement_Attribute(Object _name, Object _value) {
			this._name = _name;
			this._value = _value;
		}

		private SpeedDialIconElement_Attribute(java.util.Map<String, Object> map) {
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
		SpeedDialIconElement that = (SpeedDialIconElement) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "SpeedDialIconElement(classes,className,icon,id,openIcon,style,attribute) ::= <<<SpeedDialIcon~if(classes)~\n" + 
				"	classes=~classes~~endif~~if(className)~\n" + 
				"	className=~className~~endif~~if(icon)~\n" + 
				"	icon=~icon~~endif~~if(id)~\n" + 
				"	id=\"~id~\"~endif~~if(openIcon)~\n" + 
				"	openIcon=~openIcon~~endif~~if(style)~\n" + 
				"	style=~style~~endif~~attribute:{it|\n" + 
				"	\n" + 
				"	~it.name~=~it.value~}~ /> >>";
}  