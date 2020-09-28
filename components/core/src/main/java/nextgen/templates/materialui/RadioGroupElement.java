package nextgen.templates.materialui;

public class RadioGroupElement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _className;
	private Object _defaultValue;
	private Object _id;
	private Object _key;
	private Object _name;
	private Object _onChange;
	private Object _style;
	private Object _value;
	private java.util.List<Object> _children = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _attribute = new java.util.ArrayList<>();

	RadioGroupElement(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("RadioGroupElement");
		st.add("className", _className);
		st.add("defaultValue", _defaultValue);
		st.add("id", _id);
		st.add("key", _key);
		st.add("name", _name);
		st.add("onChange", _onChange);
		st.add("style", _style);
		st.add("value", _value);
		for (Object o : _children) st.add("children", o);
		for (java.util.Map<String, Object> map : _attribute) st.addAggr("attribute.{name,value}", map.get("name"), map.get("value"));
		return st.render().trim();
	}

	public RadioGroupElement setClassName(Object value) {
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

	public RadioGroupElement removeClassName() {
		this._className = null;
		return this;
	} 

	public RadioGroupElement setDefaultValue(Object value) {
		this._defaultValue = value;
		return this;
	}

	public Object getDefaultValue() {
		return this._defaultValue;
	}

	public Object getDefaultValue(Object defaultValue) {
		return this._defaultValue == null ? defaultValue : this._defaultValue;
	}

	public boolean hasDefaultValue() {
		return this._defaultValue != null;
	}

	public RadioGroupElement removeDefaultValue() {
		this._defaultValue = null;
		return this;
	} 

	public RadioGroupElement setId(Object value) {
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

	public RadioGroupElement removeId() {
		this._id = null;
		return this;
	} 

	public RadioGroupElement setKey(Object value) {
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

	public RadioGroupElement removeKey() {
		this._key = null;
		return this;
	} 

	public RadioGroupElement setName(Object value) {
		this._name = value;
		return this;
	}

	public Object getName() {
		return this._name;
	}

	public Object getName(Object defaultValue) {
		return this._name == null ? defaultValue : this._name;
	}

	public boolean hasName() {
		return this._name != null;
	}

	public RadioGroupElement removeName() {
		this._name = null;
		return this;
	} 

	public RadioGroupElement setOnChange(Object value) {
		this._onChange = value;
		return this;
	}

	public Object getOnChange() {
		return this._onChange;
	}

	public Object getOnChange(Object defaultValue) {
		return this._onChange == null ? defaultValue : this._onChange;
	}

	public boolean hasOnChange() {
		return this._onChange != null;
	}

	public RadioGroupElement removeOnChange() {
		this._onChange = null;
		return this;
	} 

	public RadioGroupElement setStyle(Object value) {
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

	public RadioGroupElement removeStyle() {
		this._style = null;
		return this;
	} 

	public RadioGroupElement setValue(Object value) {
		this._value = value;
		return this;
	}

	public Object getValue() {
		return this._value;
	}

	public Object getValue(Object defaultValue) {
		return this._value == null ? defaultValue : this._value;
	}

	public boolean hasValue() {
		return this._value != null;
	}

	public RadioGroupElement removeValue() {
		this._value = null;
		return this;
	} 

	public RadioGroupElement addChildren(Object value) {
		this._children.add(value);
		return this;
	}

	public RadioGroupElement setChildren(Object[] value) {
		this._children.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public RadioGroupElement setChildren(java.util.Collection<Object> values) {
		this._children.addAll(values);
		return this;
	}

	public RadioGroupElement removeChildren(Object value) {
		this._children.remove(value);
		return this;
	}

	public RadioGroupElement removeChildren(int index) {
		this._children.remove(index);
		return this;
	}

	public java.util.List<Object> getChildren() {
		return this._children;
	} 

	public RadioGroupElement addAttribute(Object _name, Object _value) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		map.put("value", _value);
		this._attribute.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getAttribute() {
		return this._attribute;
	}

	public RadioGroupElement addAttribute(RadioGroupElement_Attribute value) {
		return addAttribute(value._name, value._value);
	}

	public java.util.stream.Stream<RadioGroupElement_Attribute> streamAttribute() {
		return this._attribute.stream().map(RadioGroupElement_Attribute::new);
	}

	public java.util.List<Object> getAttribute_Name() {
		return streamAttribute().map(RadioGroupElement_Attribute::getName).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getAttribute_Value() {
		return streamAttribute().map(RadioGroupElement_Attribute::getValue).collect(java.util.stream.Collectors.toList());
	}


	public static final class RadioGroupElement_Attribute {

		Object _name;
		Object _value;

		public RadioGroupElement_Attribute(Object _name, Object _value) {
			this._name = _name;
			this._value = _value;
		}

		private RadioGroupElement_Attribute(java.util.Map<String, Object> map) {
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
		RadioGroupElement that = (RadioGroupElement) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "RadioGroupElement(className,defaultValue,id,key,name,onChange,style,value,attribute,children) ::= <<<RadioGroup~if(className)~\n" + 
				"	className=~className~~endif~~if(defaultValue)~\n" + 
				"	defaultValue=~defaultValue~~endif~~if(id)~\n" + 
				"	id=\"~id~\"~endif~~if(key)~\n" + 
				"	key=~key~~endif~~if(name)~\n" + 
				"	name=\"~name~\"~endif~~if(onChange)~\n" + 
				"	onChange=~onChange~~endif~~if(style)~\n" + 
				"	style=~style~~endif~~if(value)~\n" + 
				"	value=~value~~endif~~attribute:{it|\n" + 
				"	\n" + 
				"	~it.name~=~it.value~}~~if(children)~>\n" + 
				"	~children:{it|~it~};separator=\"\\n\"~\n" + 
				"</RadioGroup>~else~ />~endif~ >>";
}  