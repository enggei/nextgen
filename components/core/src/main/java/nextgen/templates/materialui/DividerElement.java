package nextgen.templates.materialui;

public class DividerElement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _absolute;
	private Object _classes;
	private Object _className;
	private Object _component;
	private Object _flexItem;
	private Object _id;
	private Object _key;
	private Object _light;
	private Object _orientation;
	private Object _style;
	private Object _variant;
	private java.util.List<java.util.Map<String, Object>> _attribute = new java.util.ArrayList<>();

	DividerElement(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("DividerElement");
		st.add("absolute", _absolute);
		st.add("classes", _classes);
		st.add("className", _className);
		st.add("component", _component);
		st.add("flexItem", _flexItem);
		st.add("id", _id);
		st.add("key", _key);
		st.add("light", _light);
		st.add("orientation", _orientation);
		st.add("style", _style);
		st.add("variant", _variant);
		for (java.util.Map<String, Object> map : _attribute) st.addAggr("attribute.{name,value}", map.get("name"), map.get("value"));
		return st.render().trim();
	}

	public DividerElement setAbsolute(Object value) {
		this._absolute = value;
		return this;
	}

	public Object getAbsolute() {
		return this._absolute;
	}

	public Object getAbsolute(Object defaultValue) {
		return this._absolute == null ? defaultValue : this._absolute;
	}

	public boolean hasAbsolute() {
		return this._absolute != null;
	}

	public DividerElement removeAbsolute() {
		this._absolute = null;
		return this;
	} 

	public DividerElement setClasses(Object value) {
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

	public DividerElement removeClasses() {
		this._classes = null;
		return this;
	} 

	public DividerElement setClassName(Object value) {
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

	public DividerElement removeClassName() {
		this._className = null;
		return this;
	} 

	public DividerElement setComponent(Object value) {
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

	public DividerElement removeComponent() {
		this._component = null;
		return this;
	} 

	public DividerElement setFlexItem(Object value) {
		this._flexItem = value;
		return this;
	}

	public Object getFlexItem() {
		return this._flexItem;
	}

	public Object getFlexItem(Object defaultValue) {
		return this._flexItem == null ? defaultValue : this._flexItem;
	}

	public boolean hasFlexItem() {
		return this._flexItem != null;
	}

	public DividerElement removeFlexItem() {
		this._flexItem = null;
		return this;
	} 

	public DividerElement setId(Object value) {
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

	public DividerElement removeId() {
		this._id = null;
		return this;
	} 

	public DividerElement setKey(Object value) {
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

	public DividerElement removeKey() {
		this._key = null;
		return this;
	} 

	public DividerElement setLight(Object value) {
		this._light = value;
		return this;
	}

	public Object getLight() {
		return this._light;
	}

	public Object getLight(Object defaultValue) {
		return this._light == null ? defaultValue : this._light;
	}

	public boolean hasLight() {
		return this._light != null;
	}

	public DividerElement removeLight() {
		this._light = null;
		return this;
	} 

	public DividerElement setOrientation(Object value) {
		this._orientation = value;
		return this;
	}

	public Object getOrientation() {
		return this._orientation;
	}

	public Object getOrientation(Object defaultValue) {
		return this._orientation == null ? defaultValue : this._orientation;
	}

	public boolean hasOrientation() {
		return this._orientation != null;
	}

	public DividerElement removeOrientation() {
		this._orientation = null;
		return this;
	} 

	public DividerElement setStyle(Object value) {
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

	public DividerElement removeStyle() {
		this._style = null;
		return this;
	} 

	public DividerElement setVariant(Object value) {
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

	public DividerElement removeVariant() {
		this._variant = null;
		return this;
	} 


	public DividerElement addAttribute(Object _name, Object _value) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		map.put("value", _value);
		this._attribute.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getAttribute() {
		return this._attribute;
	}

	public DividerElement addAttribute(DividerElement_Attribute value) {
		return addAttribute(value._name, value._value);
	}

	public java.util.stream.Stream<DividerElement_Attribute> streamAttribute() {
		return this._attribute.stream().map(DividerElement_Attribute::new);
	}

	public java.util.List<Object> getAttribute_Name() {
		return streamAttribute().map(DividerElement_Attribute::getName).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getAttribute_Value() {
		return streamAttribute().map(DividerElement_Attribute::getValue).collect(java.util.stream.Collectors.toList());
	}


	public static final class DividerElement_Attribute {

		Object _name;
		Object _value;

		public DividerElement_Attribute(Object _name, Object _value) {
			this._name = _name;
			this._value = _value;
		}

		private DividerElement_Attribute(java.util.Map<String, Object> map) {
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
		DividerElement that = (DividerElement) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "DividerElement(absolute,classes,className,component,flexItem,id,key,light,orientation,style,variant,attribute) ::= <<<Divider~if(absolute)~\n" + 
				"	absolute~endif~~if(classes)~\n" + 
				"	classes=~classes~~endif~~if(className)~\n" + 
				"	className=~className~~endif~~if(component)~\n" + 
				"	component=~component~~endif~~if(flexItem)~\n" + 
				"	flexItem~endif~~if(id)~\n" + 
				"	id=\"~id~\"~endif~~if(key)~\n" + 
				"	key=~key~~endif~~if(light)~\n" + 
				"	light~endif~~if(orientation)~\n" + 
				"	orientation=~orientation~~endif~~if(style)~\n" + 
				"	style=~style~~endif~~if(variant)~\n" + 
				"	variant=\"~variant~\"~endif~~attribute:{it|\n" + 
				"	\n" + 
				"	~it.name~=~it.value~}~ /> >>";
}  