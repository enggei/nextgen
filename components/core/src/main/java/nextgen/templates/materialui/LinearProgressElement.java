package nextgen.templates.materialui;

public class LinearProgressElement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _classes;
	private Object _className;
	private Object _color;
	private Object _id;
	private Object _key;
	private Object _style;
	private Object _value;
	private Object _valueBuffer;
	private Object _variant;
	private java.util.List<java.util.Map<String, Object>> _attribute = new java.util.ArrayList<>();

	LinearProgressElement(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("LinearProgressElement");
		st.add("classes", _classes);
		st.add("className", _className);
		st.add("color", _color);
		st.add("id", _id);
		st.add("key", _key);
		st.add("style", _style);
		st.add("value", _value);
		st.add("valueBuffer", _valueBuffer);
		st.add("variant", _variant);
		for (java.util.Map<String, Object> map : _attribute) st.addAggr("attribute.{name,value}", map.get("name"), map.get("value"));
		return st.render().trim();
	}

	public LinearProgressElement setClasses(Object value) {
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

	public LinearProgressElement removeClasses() {
		this._classes = null;
		return this;
	} 

	public LinearProgressElement setClassName(Object value) {
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

	public LinearProgressElement removeClassName() {
		this._className = null;
		return this;
	} 

	public LinearProgressElement setColor(Object value) {
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

	public LinearProgressElement removeColor() {
		this._color = null;
		return this;
	} 

	public LinearProgressElement setId(Object value) {
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

	public LinearProgressElement removeId() {
		this._id = null;
		return this;
	} 

	public LinearProgressElement setKey(Object value) {
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

	public LinearProgressElement removeKey() {
		this._key = null;
		return this;
	} 

	public LinearProgressElement setStyle(Object value) {
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

	public LinearProgressElement removeStyle() {
		this._style = null;
		return this;
	} 

	public LinearProgressElement setValue(Object value) {
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

	public LinearProgressElement removeValue() {
		this._value = null;
		return this;
	} 

	public LinearProgressElement setValueBuffer(Object value) {
		this._valueBuffer = value;
		return this;
	}

	public Object getValueBuffer() {
		return this._valueBuffer;
	}

	public Object getValueBuffer(Object defaultValue) {
		return this._valueBuffer == null ? defaultValue : this._valueBuffer;
	}

	public boolean hasValueBuffer() {
		return this._valueBuffer != null;
	}

	public LinearProgressElement removeValueBuffer() {
		this._valueBuffer = null;
		return this;
	} 

	public LinearProgressElement setVariant(Object value) {
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

	public LinearProgressElement removeVariant() {
		this._variant = null;
		return this;
	} 


	public LinearProgressElement addAttribute(Object _name, Object _value) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		map.put("value", _value);
		this._attribute.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getAttribute() {
		return this._attribute;
	}

	public LinearProgressElement addAttribute(LinearProgressElement_Attribute value) {
		return addAttribute(value._name, value._value);
	}

	public java.util.stream.Stream<LinearProgressElement_Attribute> streamAttribute() {
		return this._attribute.stream().map(LinearProgressElement_Attribute::new);
	}

	public java.util.List<Object> getAttribute_Name() {
		return streamAttribute().map(LinearProgressElement_Attribute::getName).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getAttribute_Value() {
		return streamAttribute().map(LinearProgressElement_Attribute::getValue).collect(java.util.stream.Collectors.toList());
	}


	public static final class LinearProgressElement_Attribute {

		Object _name;
		Object _value;

		public LinearProgressElement_Attribute(Object _name, Object _value) {
			this._name = _name;
			this._value = _value;
		}

		private LinearProgressElement_Attribute(java.util.Map<String, Object> map) {
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
		LinearProgressElement that = (LinearProgressElement) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "LinearProgressElement(classes,className,color,id,key,style,value,valueBuffer,variant,attribute) ::= <<<LinearProgress~if(classes)~\n" + 
				"	classes=~classes~~endif~~if(className)~\n" + 
				"	className=~className~~endif~~if(color)~\n" + 
				"	color=\"~color~\"~endif~~if(id)~\n" + 
				"	id=\"~id~\"~endif~~if(key)~\n" + 
				"	key=~key~~endif~~if(style)~\n" + 
				"	style=~style~~endif~~if(value)~\n" + 
				"	value=~value~~endif~~if(valueBuffer)~\n" + 
				"	valueBuffer=~valueBuffer~~endif~~if(variant)~\n" + 
				"	variant=\"~variant~\"~endif~~attribute:{it|\n" + 
				"	\n" + 
				"	~it.name~=~it.value~}~ /> >>";
}  