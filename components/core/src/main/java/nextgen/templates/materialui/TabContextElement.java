package nextgen.templates.materialui;

public class TabContextElement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _className;
	private Object _id;
	private Object _key;
	private Object _style;
	private Object _value;
	private java.util.List<Object> _children = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _attribute = new java.util.ArrayList<>();

	TabContextElement(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("TabContextElement");
		st.add("className", _className);
		st.add("id", _id);
		st.add("key", _key);
		st.add("style", _style);
		st.add("value", _value);
		for (Object o : _children) st.add("children", o);
		for (java.util.Map<String, Object> map : _attribute) st.addAggr("attribute.{name,value}", map.get("name"), map.get("value"));
		return st.render().trim();
	}

	public TabContextElement setClassName(Object value) {
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

	public TabContextElement removeClassName() {
		this._className = null;
		return this;
	} 

	public TabContextElement setId(Object value) {
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

	public TabContextElement removeId() {
		this._id = null;
		return this;
	} 

	public TabContextElement setKey(Object value) {
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

	public TabContextElement removeKey() {
		this._key = null;
		return this;
	} 

	public TabContextElement setStyle(Object value) {
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

	public TabContextElement removeStyle() {
		this._style = null;
		return this;
	} 

	public TabContextElement setValue(Object value) {
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

	public TabContextElement removeValue() {
		this._value = null;
		return this;
	} 

	public TabContextElement addChildren(Object value) {
		this._children.add(value);
		return this;
	}

	public TabContextElement setChildren(Object[] value) {
		this._children.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public TabContextElement setChildren(java.util.Collection<Object> values) {
		this._children.addAll(values);
		return this;
	}

	public TabContextElement removeChildren(Object value) {
		this._children.remove(value);
		return this;
	}

	public TabContextElement removeChildren(int index) {
		this._children.remove(index);
		return this;
	}

	public java.util.List<Object> getChildren() {
		return this._children;
	} 

	public TabContextElement addAttribute(Object _name, Object _value) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		map.put("value", _value);
		this._attribute.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getAttribute() {
		return this._attribute;
	}

	public TabContextElement addAttribute(TabContextElement_Attribute value) {
		return addAttribute(value._name, value._value);
	}

	public java.util.stream.Stream<TabContextElement_Attribute> streamAttribute() {
		return this._attribute.stream().map(TabContextElement_Attribute::new);
	}

	public java.util.List<Object> getAttribute_Name() {
		return streamAttribute().map(TabContextElement_Attribute::getName).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getAttribute_Value() {
		return streamAttribute().map(TabContextElement_Attribute::getValue).collect(java.util.stream.Collectors.toList());
	}


	public static final class TabContextElement_Attribute {

		Object _name;
		Object _value;

		public TabContextElement_Attribute(Object _name, Object _value) {
			this._name = _name;
			this._value = _value;
		}

		private TabContextElement_Attribute(java.util.Map<String, Object> map) {
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
		TabContextElement that = (TabContextElement) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "TabContextElement(className,id,key,style,value,attribute,children) ::= <<<TabContext~if(className)~\n" + 
				"	className=~className~~endif~~if(id)~\n" + 
				"	id=\"~id~\"~endif~~if(key)~\n" + 
				"	key=~key~~endif~~if(style)~\n" + 
				"	style=~style~~endif~\n" + 
				"	value=\"~value~\"~attribute:{it|\n" + 
				"	\n" + 
				"	~it.name~=~it.value~}~~if(children)~>\n" + 
				"	~children:{it|~it~};separator=\"\\n\"~\n" + 
				"</TabContext>~else~ />~endif~ >>";
}  