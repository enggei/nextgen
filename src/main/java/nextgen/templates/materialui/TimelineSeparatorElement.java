package nextgen.templates.materialui;

public class TimelineSeparatorElement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _classes;
	private Object _className;
	private Object _id;
	private Object _key;
	private Object _style;
	private java.util.List<Object> _children = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _attribute = new java.util.ArrayList<>();

	TimelineSeparatorElement(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("TimelineSeparatorElement");
		st.add("classes", _classes);
		st.add("className", _className);
		st.add("id", _id);
		st.add("key", _key);
		st.add("style", _style);
		for (Object o : _children) st.add("children", o);
		for (java.util.Map<String, Object> map : _attribute) st.addAggr("attribute.{name,value}", map.get("name"), map.get("value"));
		return st.render().trim();
	}

	public TimelineSeparatorElement setClasses(Object value) {
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

	public TimelineSeparatorElement removeClasses() {
		this._classes = null;
		return this;
	} 

	public TimelineSeparatorElement setClassName(Object value) {
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

	public TimelineSeparatorElement removeClassName() {
		this._className = null;
		return this;
	} 

	public TimelineSeparatorElement setId(Object value) {
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

	public TimelineSeparatorElement removeId() {
		this._id = null;
		return this;
	} 

	public TimelineSeparatorElement setKey(Object value) {
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

	public TimelineSeparatorElement removeKey() {
		this._key = null;
		return this;
	} 

	public TimelineSeparatorElement setStyle(Object value) {
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

	public TimelineSeparatorElement removeStyle() {
		this._style = null;
		return this;
	} 

	public TimelineSeparatorElement addChildren(Object value) {
		this._children.add(value);
		return this;
	}

	public TimelineSeparatorElement setChildren(Object[] value) {
		this._children.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public TimelineSeparatorElement setChildren(java.util.Collection<Object> values) {
		this._children.addAll(values);
		return this;
	}

	public TimelineSeparatorElement removeChildren(Object value) {
		this._children.remove(value);
		return this;
	}

	public TimelineSeparatorElement removeChildren(int index) {
		this._children.remove(index);
		return this;
	}

	public java.util.List<Object> getChildren() {
		return this._children;
	} 

	public TimelineSeparatorElement addAttribute(Object _name, Object _value) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		map.put("value", _value);
		this._attribute.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getAttribute() {
		return this._attribute;
	}

	public TimelineSeparatorElement addAttribute(TimelineSeparatorElement_Attribute value) {
		return addAttribute(value._name, value._value);
	}

	public java.util.stream.Stream<TimelineSeparatorElement_Attribute> streamAttribute() {
		return this._attribute.stream().map(TimelineSeparatorElement_Attribute::new);
	}

	public java.util.List<Object> getAttribute_Name() {
		return streamAttribute().map(TimelineSeparatorElement_Attribute::getName).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getAttribute_Value() {
		return streamAttribute().map(TimelineSeparatorElement_Attribute::getValue).collect(java.util.stream.Collectors.toList());
	}


	public static final class TimelineSeparatorElement_Attribute {

		Object _name;
		Object _value;

		public TimelineSeparatorElement_Attribute(Object _name, Object _value) {
			this._name = _name;
			this._value = _value;
		}

		private TimelineSeparatorElement_Attribute(java.util.Map<String, Object> map) {
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
		TimelineSeparatorElement that = (TimelineSeparatorElement) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "TimelineSeparatorElement(classes,className,id,key,style,attribute,children) ::= <<<TimelineSeparator~if(classes)~\n" + 
				"	classes=~classes~~endif~~if(className)~\n" + 
				"	className=~className~~endif~~if(id)~\n" + 
				"	id=\"~id~\"~endif~~if(key)~\n" + 
				"	key=~key~~endif~~if(style)~\n" + 
				"	style=~style~~endif~~attribute:{it|\n" + 
				"	\n" + 
				"	~it.name~=~it.value~}~~if(children)~>\n" + 
				"	~children:{it|~it~};separator=\"\\n\"~\n" + 
				"</TimelineSeparator>~else~ />~endif~ >>";
}  