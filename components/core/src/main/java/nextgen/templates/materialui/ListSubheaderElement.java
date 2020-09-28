package nextgen.templates.materialui;

public class ListSubheaderElement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _classes;
	private Object _className;
	private Object _color;
	private Object _component;
	private Object _disableGutters;
	private Object _disableSticky;
	private Object _id;
	private Object _inset;
	private Object _key;
	private Object _style;
	private java.util.List<Object> _children = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _attribute = new java.util.ArrayList<>();

	ListSubheaderElement(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("ListSubheaderElement");
		st.add("classes", _classes);
		st.add("className", _className);
		st.add("color", _color);
		st.add("component", _component);
		st.add("disableGutters", _disableGutters);
		st.add("disableSticky", _disableSticky);
		st.add("id", _id);
		st.add("inset", _inset);
		st.add("key", _key);
		st.add("style", _style);
		for (Object o : _children) st.add("children", o);
		for (java.util.Map<String, Object> map : _attribute) st.addAggr("attribute.{name,value}", map.get("name"), map.get("value"));
		return st.render().trim();
	}

	public ListSubheaderElement setClasses(Object value) {
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

	public ListSubheaderElement removeClasses() {
		this._classes = null;
		return this;
	} 

	public ListSubheaderElement setClassName(Object value) {
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

	public ListSubheaderElement removeClassName() {
		this._className = null;
		return this;
	} 

	public ListSubheaderElement setColor(Object value) {
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

	public ListSubheaderElement removeColor() {
		this._color = null;
		return this;
	} 

	public ListSubheaderElement setComponent(Object value) {
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

	public ListSubheaderElement removeComponent() {
		this._component = null;
		return this;
	} 

	public ListSubheaderElement setDisableGutters(Object value) {
		this._disableGutters = value;
		return this;
	}

	public Object getDisableGutters() {
		return this._disableGutters;
	}

	public Object getDisableGutters(Object defaultValue) {
		return this._disableGutters == null ? defaultValue : this._disableGutters;
	}

	public boolean hasDisableGutters() {
		return this._disableGutters != null;
	}

	public ListSubheaderElement removeDisableGutters() {
		this._disableGutters = null;
		return this;
	} 

	public ListSubheaderElement setDisableSticky(Object value) {
		this._disableSticky = value;
		return this;
	}

	public Object getDisableSticky() {
		return this._disableSticky;
	}

	public Object getDisableSticky(Object defaultValue) {
		return this._disableSticky == null ? defaultValue : this._disableSticky;
	}

	public boolean hasDisableSticky() {
		return this._disableSticky != null;
	}

	public ListSubheaderElement removeDisableSticky() {
		this._disableSticky = null;
		return this;
	} 

	public ListSubheaderElement setId(Object value) {
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

	public ListSubheaderElement removeId() {
		this._id = null;
		return this;
	} 

	public ListSubheaderElement setInset(Object value) {
		this._inset = value;
		return this;
	}

	public Object getInset() {
		return this._inset;
	}

	public Object getInset(Object defaultValue) {
		return this._inset == null ? defaultValue : this._inset;
	}

	public boolean hasInset() {
		return this._inset != null;
	}

	public ListSubheaderElement removeInset() {
		this._inset = null;
		return this;
	} 

	public ListSubheaderElement setKey(Object value) {
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

	public ListSubheaderElement removeKey() {
		this._key = null;
		return this;
	} 

	public ListSubheaderElement setStyle(Object value) {
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

	public ListSubheaderElement removeStyle() {
		this._style = null;
		return this;
	} 

	public ListSubheaderElement addChildren(Object value) {
		this._children.add(value);
		return this;
	}

	public ListSubheaderElement setChildren(Object[] value) {
		this._children.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public ListSubheaderElement setChildren(java.util.Collection<Object> values) {
		this._children.addAll(values);
		return this;
	}

	public ListSubheaderElement removeChildren(Object value) {
		this._children.remove(value);
		return this;
	}

	public ListSubheaderElement removeChildren(int index) {
		this._children.remove(index);
		return this;
	}

	public java.util.List<Object> getChildren() {
		return this._children;
	} 

	public ListSubheaderElement addAttribute(Object _name, Object _value) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		map.put("value", _value);
		this._attribute.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getAttribute() {
		return this._attribute;
	}

	public ListSubheaderElement addAttribute(ListSubheaderElement_Attribute value) {
		return addAttribute(value._name, value._value);
	}

	public java.util.stream.Stream<ListSubheaderElement_Attribute> streamAttribute() {
		return this._attribute.stream().map(ListSubheaderElement_Attribute::new);
	}

	public java.util.List<Object> getAttribute_Name() {
		return streamAttribute().map(ListSubheaderElement_Attribute::getName).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getAttribute_Value() {
		return streamAttribute().map(ListSubheaderElement_Attribute::getValue).collect(java.util.stream.Collectors.toList());
	}


	public static final class ListSubheaderElement_Attribute {

		Object _name;
		Object _value;

		public ListSubheaderElement_Attribute(Object _name, Object _value) {
			this._name = _name;
			this._value = _value;
		}

		private ListSubheaderElement_Attribute(java.util.Map<String, Object> map) {
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
		ListSubheaderElement that = (ListSubheaderElement) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "ListSubheaderElement(classes,className,color,component,disableGutters,disableSticky,id,inset,key,style,attribute,children) ::= <<<ListSubheader~if(classes)~\n" + 
				"	classes=~classes~~endif~~if(className)~\n" + 
				"	className=~className~~endif~~if(color)~\n" + 
				"	color=\"~color~\"~endif~~if(component)~\n" + 
				"	component=~component~~endif~~if(disableGutters)~\n" + 
				"	disableGutters~endif~~if(disableSticky)~\n" + 
				"	disableSticky~endif~~if(id)~\n" + 
				"	id=\"~id~\"~endif~~if(inset)~\n" + 
				"	inset~endif~~if(key)~\n" + 
				"	key=~key~~endif~~if(style)~\n" + 
				"	style=~style~~endif~~attribute:{it|\n" + 
				"	\n" + 
				"	~it.name~=~it.value~}~~if(children)~>\n" + 
				"	~children:{it|~it~};separator=\"\\n\"~\n" + 
				"</ListSubheader>~else~ />~endif~ >>";
}  