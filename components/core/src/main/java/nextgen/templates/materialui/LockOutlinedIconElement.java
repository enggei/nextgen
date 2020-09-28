package nextgen.templates.materialui;

public class LockOutlinedIconElement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _className;
	private Object _id;
	private Object _key;
	private Object _style;
	private java.util.List<java.util.Map<String, Object>> _attribute = new java.util.ArrayList<>();

	LockOutlinedIconElement(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("LockOutlinedIconElement");
		st.add("className", _className);
		st.add("id", _id);
		st.add("key", _key);
		st.add("style", _style);
		for (java.util.Map<String, Object> map : _attribute) st.addAggr("attribute.{name,value}", map.get("name"), map.get("value"));
		return st.render().trim();
	}

	public LockOutlinedIconElement setClassName(Object value) {
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

	public LockOutlinedIconElement removeClassName() {
		this._className = null;
		return this;
	} 

	public LockOutlinedIconElement setId(Object value) {
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

	public LockOutlinedIconElement removeId() {
		this._id = null;
		return this;
	} 

	public LockOutlinedIconElement setKey(Object value) {
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

	public LockOutlinedIconElement removeKey() {
		this._key = null;
		return this;
	} 

	public LockOutlinedIconElement setStyle(Object value) {
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

	public LockOutlinedIconElement removeStyle() {
		this._style = null;
		return this;
	} 


	public LockOutlinedIconElement addAttribute(Object _name, Object _value) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		map.put("value", _value);
		this._attribute.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getAttribute() {
		return this._attribute;
	}

	public LockOutlinedIconElement addAttribute(LockOutlinedIconElement_Attribute value) {
		return addAttribute(value._name, value._value);
	}

	public java.util.stream.Stream<LockOutlinedIconElement_Attribute> streamAttribute() {
		return this._attribute.stream().map(LockOutlinedIconElement_Attribute::new);
	}

	public java.util.List<Object> getAttribute_Name() {
		return streamAttribute().map(LockOutlinedIconElement_Attribute::getName).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getAttribute_Value() {
		return streamAttribute().map(LockOutlinedIconElement_Attribute::getValue).collect(java.util.stream.Collectors.toList());
	}


	public static final class LockOutlinedIconElement_Attribute {

		Object _name;
		Object _value;

		public LockOutlinedIconElement_Attribute(Object _name, Object _value) {
			this._name = _name;
			this._value = _value;
		}

		private LockOutlinedIconElement_Attribute(java.util.Map<String, Object> map) {
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
		LockOutlinedIconElement that = (LockOutlinedIconElement) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "LockOutlinedIconElement(className,id,key,style,attribute) ::= <<<LockOutlinedIcon~if(className)~\n" + 
				"	className=~className~~endif~~if(id)~\n" + 
				"	id=\"~id~\"~endif~~if(key)~\n" + 
				"	key=~key~~endif~~if(style)~\n" + 
				"	style=~style~~endif~~attribute:{it|\n" + 
				"	\n" + 
				"	~it.name~=~it.value~}~ /> >>";
}  