package nextgen.templates.materialui;

public class RadioGroupElement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _className;
	private Object _defaultValue;
	private Object _name;
	private Object _onChange;
	private Object _value;
	private java.util.List<Object> _children = new java.util.ArrayList<>();

	RadioGroupElement(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("RadioGroupElement");
		st.add("className", _className);
		st.add("defaultValue", _defaultValue);
		st.add("name", _name);
		st.add("onChange", _onChange);
		st.add("value", _value);
		for (Object o : _children) st.add("children", o);
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

	static final String st = "RadioGroupElement(className,defaultValue,name,onChange,value,children) ::= <<<RadioGroup~if(className)~\n" + 
				"	className=~className~~endif~~if(defaultValue)~\n" + 
				"	defaultValue=~defaultValue~~endif~~if(name)~\n" + 
				"	name=\"~name~\"~endif~~if(onChange)~\n" + 
				"	onChange=~onChange~~endif~~if(value)~\n" + 
				"	value=~value~~endif~~if(children)~>\n" + 
				"	~children:{it|~it~};separator=\"\\n\"~\n" + 
				"</RadioGroup>~else~ />~endif~ >>";
}  