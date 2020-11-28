package nextgen.templates.materialui;

public class StepLabelElement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _classes;
	private Object _className;
	private Object _disabled;
	private Object _error;
	private Object _icon;
	private Object _id;
	private Object _key;
	private Object _optional;
	private Object _StepIconComponent;
	private Object _StepIconProps;
	private Object _style;
	private java.util.List<Object> _children = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _attribute = new java.util.ArrayList<>();

	StepLabelElement(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("StepLabelElement");
		st.add("classes", _classes);
		st.add("className", _className);
		st.add("disabled", _disabled);
		st.add("error", _error);
		st.add("icon", _icon);
		st.add("id", _id);
		st.add("key", _key);
		st.add("optional", _optional);
		st.add("StepIconComponent", _StepIconComponent);
		st.add("StepIconProps", _StepIconProps);
		st.add("style", _style);
		for (Object o : _children) st.add("children", o);
		for (java.util.Map<String, Object> map : _attribute) st.addAggr("attribute.{name,value}", map.get("name"), map.get("value"));
		return st.render().trim();
	}

	public StepLabelElement setClasses(Object value) {
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

	public StepLabelElement removeClasses() {
		this._classes = null;
		return this;
	} 

	public StepLabelElement setClassName(Object value) {
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

	public StepLabelElement removeClassName() {
		this._className = null;
		return this;
	} 

	public StepLabelElement setDisabled(Object value) {
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

	public StepLabelElement removeDisabled() {
		this._disabled = null;
		return this;
	} 

	public StepLabelElement setError(Object value) {
		this._error = value;
		return this;
	}

	public Object getError() {
		return this._error;
	}

	public Object getError(Object defaultValue) {
		return this._error == null ? defaultValue : this._error;
	}

	public boolean hasError() {
		return this._error != null;
	}

	public StepLabelElement removeError() {
		this._error = null;
		return this;
	} 

	public StepLabelElement setIcon(Object value) {
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

	public StepLabelElement removeIcon() {
		this._icon = null;
		return this;
	} 

	public StepLabelElement setId(Object value) {
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

	public StepLabelElement removeId() {
		this._id = null;
		return this;
	} 

	public StepLabelElement setKey(Object value) {
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

	public StepLabelElement removeKey() {
		this._key = null;
		return this;
	} 

	public StepLabelElement setOptional(Object value) {
		this._optional = value;
		return this;
	}

	public Object getOptional() {
		return this._optional;
	}

	public Object getOptional(Object defaultValue) {
		return this._optional == null ? defaultValue : this._optional;
	}

	public boolean hasOptional() {
		return this._optional != null;
	}

	public StepLabelElement removeOptional() {
		this._optional = null;
		return this;
	} 

	public StepLabelElement setStepIconComponent(Object value) {
		this._StepIconComponent = value;
		return this;
	}

	public Object getStepIconComponent() {
		return this._StepIconComponent;
	}

	public Object getStepIconComponent(Object defaultValue) {
		return this._StepIconComponent == null ? defaultValue : this._StepIconComponent;
	}

	public boolean hasStepIconComponent() {
		return this._StepIconComponent != null;
	}

	public StepLabelElement removeStepIconComponent() {
		this._StepIconComponent = null;
		return this;
	} 

	public StepLabelElement setStepIconProps(Object value) {
		this._StepIconProps = value;
		return this;
	}

	public Object getStepIconProps() {
		return this._StepIconProps;
	}

	public Object getStepIconProps(Object defaultValue) {
		return this._StepIconProps == null ? defaultValue : this._StepIconProps;
	}

	public boolean hasStepIconProps() {
		return this._StepIconProps != null;
	}

	public StepLabelElement removeStepIconProps() {
		this._StepIconProps = null;
		return this;
	} 

	public StepLabelElement setStyle(Object value) {
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

	public StepLabelElement removeStyle() {
		this._style = null;
		return this;
	} 

	public StepLabelElement addChildren(Object value) {
		this._children.add(value);
		return this;
	}

	public StepLabelElement setChildren(Object[] value) {
		this._children.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public StepLabelElement setChildren(java.util.Collection<Object> values) {
		this._children.addAll(values);
		return this;
	}

	public StepLabelElement removeChildren(Object value) {
		this._children.remove(value);
		return this;
	}

	public StepLabelElement removeChildren(int index) {
		this._children.remove(index);
		return this;
	}

	public java.util.List<Object> getChildren() {
		return this._children;
	} 

	public StepLabelElement addAttribute(Object _name, Object _value) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		map.put("value", _value);
		this._attribute.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getAttribute() {
		return this._attribute;
	}

	public StepLabelElement addAttribute(StepLabelElement_Attribute value) {
		return addAttribute(value._name, value._value);
	}

	public java.util.stream.Stream<StepLabelElement_Attribute> streamAttribute() {
		return this._attribute.stream().map(StepLabelElement_Attribute::new);
	}

	public java.util.List<Object> getAttribute_Name() {
		return streamAttribute().map(StepLabelElement_Attribute::getName).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getAttribute_Value() {
		return streamAttribute().map(StepLabelElement_Attribute::getValue).collect(java.util.stream.Collectors.toList());
	}


	public static final class StepLabelElement_Attribute {

		Object _name;
		Object _value;

		public StepLabelElement_Attribute(Object _name, Object _value) {
			this._name = _name;
			this._value = _value;
		}

		private StepLabelElement_Attribute(java.util.Map<String, Object> map) {
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
		StepLabelElement that = (StepLabelElement) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "StepLabelElement(classes,className,disabled,error,icon,id,key,optional,StepIconComponent,StepIconProps,style,attribute,children) ::= <<<StepLabel~if(classes)~\n" + 
				"	classes=~classes~~endif~~if(className)~\n" + 
				"	className=~className~~endif~~if(disabled)~\n" + 
				"	disabled~endif~~if(error)~\n" + 
				"	error~endif~~if(icon)~\n" + 
				"	icon=~icon~~endif~~if(id)~\n" + 
				"	id=\"~id~\"~endif~~if(key)~\n" + 
				"	key=~key~~endif~~if(optional)~\n" + 
				"	optional=~optional~~endif~~if(StepIconComponent)~\n" + 
				"	StepIconComponent=~StepIconComponent~~endif~~if(StepIconProps)~\n" + 
				"	StepIconProps=~StepIconProps~~endif~~if(style)~\n" + 
				"	style=~style~~endif~~attribute:{it|\n" + 
				"	\n" + 
				"	~it.name~=~it.value~}~~if(children)~>\n" + 
				"	~children:{it|~it~};separator=\"\\n\"~\n" + 
				"</StepLabel>~else~ />~endif~ >>";
}  