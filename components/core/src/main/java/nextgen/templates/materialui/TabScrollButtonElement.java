package nextgen.templates.materialui;

public class TabScrollButtonElement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _classes;
	private Object _className;
	private Object _direction;
	private Object _disabled;
	private Object _id;
	private Object _key;
	private Object _orientation;
	private Object _style;
	private java.util.List<Object> _children = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _attribute = new java.util.ArrayList<>();

	TabScrollButtonElement(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("TabScrollButtonElement");
		st.add("classes", _classes);
		st.add("className", _className);
		st.add("direction", _direction);
		st.add("disabled", _disabled);
		st.add("id", _id);
		st.add("key", _key);
		st.add("orientation", _orientation);
		st.add("style", _style);
		for (Object o : _children) st.add("children", o);
		for (java.util.Map<String, Object> map : _attribute) st.addAggr("attribute.{name,value}", map.get("name"), map.get("value"));
		return st.render().trim();
	}

	public TabScrollButtonElement setClasses(Object value) {
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

	public TabScrollButtonElement removeClasses() {
		this._classes = null;
		return this;
	} 

	public TabScrollButtonElement setClassName(Object value) {
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

	public TabScrollButtonElement removeClassName() {
		this._className = null;
		return this;
	} 

	public TabScrollButtonElement setDirection(Object value) {
		this._direction = value;
		return this;
	}

	public Object getDirection() {
		return this._direction;
	}

	public Object getDirection(Object defaultValue) {
		return this._direction == null ? defaultValue : this._direction;
	}

	public boolean hasDirection() {
		return this._direction != null;
	}

	public TabScrollButtonElement removeDirection() {
		this._direction = null;
		return this;
	} 

	public TabScrollButtonElement setDisabled(Object value) {
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

	public TabScrollButtonElement removeDisabled() {
		this._disabled = null;
		return this;
	} 

	public TabScrollButtonElement setId(Object value) {
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

	public TabScrollButtonElement removeId() {
		this._id = null;
		return this;
	} 

	public TabScrollButtonElement setKey(Object value) {
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

	public TabScrollButtonElement removeKey() {
		this._key = null;
		return this;
	} 

	public TabScrollButtonElement setOrientation(Object value) {
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

	public TabScrollButtonElement removeOrientation() {
		this._orientation = null;
		return this;
	} 

	public TabScrollButtonElement setStyle(Object value) {
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

	public TabScrollButtonElement removeStyle() {
		this._style = null;
		return this;
	} 

	public TabScrollButtonElement addChildren(Object value) {
		this._children.add(value);
		return this;
	}

	public TabScrollButtonElement setChildren(Object[] value) {
		this._children.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public TabScrollButtonElement setChildren(java.util.Collection<Object> values) {
		this._children.addAll(values);
		return this;
	}

	public TabScrollButtonElement removeChildren(Object value) {
		this._children.remove(value);
		return this;
	}

	public TabScrollButtonElement removeChildren(int index) {
		this._children.remove(index);
		return this;
	}

	public java.util.List<Object> getChildren() {
		return this._children;
	} 

	public TabScrollButtonElement addAttribute(Object _name, Object _value) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		map.put("value", _value);
		this._attribute.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getAttribute() {
		return this._attribute;
	}

	public TabScrollButtonElement addAttribute(TabScrollButtonElement_Attribute value) {
		return addAttribute(value._name, value._value);
	}

	public java.util.stream.Stream<TabScrollButtonElement_Attribute> streamAttribute() {
		return this._attribute.stream().map(TabScrollButtonElement_Attribute::new);
	}

	public java.util.List<Object> getAttribute_Name() {
		return streamAttribute().map(TabScrollButtonElement_Attribute::getName).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getAttribute_Value() {
		return streamAttribute().map(TabScrollButtonElement_Attribute::getValue).collect(java.util.stream.Collectors.toList());
	}


	public static final class TabScrollButtonElement_Attribute {

		Object _name;
		Object _value;

		public TabScrollButtonElement_Attribute(Object _name, Object _value) {
			this._name = _name;
			this._value = _value;
		}

		private TabScrollButtonElement_Attribute(java.util.Map<String, Object> map) {
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
		TabScrollButtonElement that = (TabScrollButtonElement) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "TabScrollButtonElement(classes,className,direction,disabled,id,key,orientation,style,attribute,children) ::= <<<TabScrollButton~if(classes)~\n" + 
				"	classes=~classes~~endif~~if(className)~\n" + 
				"	className=~className~~endif~\n" + 
				"	direction=~direction~~if(disabled)~\n" + 
				"	disabled~endif~~if(id)~\n" + 
				"	id=\"~id~\"~endif~~if(key)~\n" + 
				"	key=~key~~endif~\n" + 
				"	orientation=~orientation~~if(style)~\n" + 
				"	style=~style~~endif~~attribute:{it|\n" + 
				"	\n" + 
				"	~it.name~=~it.value~}~~if(children)~>\n" + 
				"	~children:{it|~it~};separator=\"\\n\"~\n" + 
				"</TabScrollButton>~else~ />~endif~ >>";
}  