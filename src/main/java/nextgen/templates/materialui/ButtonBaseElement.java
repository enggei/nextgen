package nextgen.templates.materialui;

public class ButtonBaseElement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _action;
	private Object _centerRipple;
	private Object _classes;
	private Object _className;
	private Object _component;
	private Object _disabled;
	private Object _disableRipple;
	private Object _disableTouchRipple;
	private Object _focusRipple;
	private Object _focusVisibleClassName;
	private Object _id;
	private Object _key;
	private Object _onFocusVisible;
	private Object _style;
	private Object _TouchRippleProps;
	private java.util.List<Object> _children = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _attribute = new java.util.ArrayList<>();

	ButtonBaseElement(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("ButtonBaseElement");
		st.add("action", _action);
		st.add("centerRipple", _centerRipple);
		st.add("classes", _classes);
		st.add("className", _className);
		st.add("component", _component);
		st.add("disabled", _disabled);
		st.add("disableRipple", _disableRipple);
		st.add("disableTouchRipple", _disableTouchRipple);
		st.add("focusRipple", _focusRipple);
		st.add("focusVisibleClassName", _focusVisibleClassName);
		st.add("id", _id);
		st.add("key", _key);
		st.add("onFocusVisible", _onFocusVisible);
		st.add("style", _style);
		st.add("TouchRippleProps", _TouchRippleProps);
		for (Object o : _children) st.add("children", o);
		for (java.util.Map<String, Object> map : _attribute) st.addAggr("attribute.{name,value}", map.get("name"), map.get("value"));
		return st.render().trim();
	}

	public ButtonBaseElement setAction(Object value) {
		this._action = value;
		return this;
	}

	public Object getAction() {
		return this._action;
	}

	public Object getAction(Object defaultValue) {
		return this._action == null ? defaultValue : this._action;
	}

	public boolean hasAction() {
		return this._action != null;
	}

	public ButtonBaseElement removeAction() {
		this._action = null;
		return this;
	} 

	public ButtonBaseElement setCenterRipple(Object value) {
		this._centerRipple = value;
		return this;
	}

	public Object getCenterRipple() {
		return this._centerRipple;
	}

	public Object getCenterRipple(Object defaultValue) {
		return this._centerRipple == null ? defaultValue : this._centerRipple;
	}

	public boolean hasCenterRipple() {
		return this._centerRipple != null;
	}

	public ButtonBaseElement removeCenterRipple() {
		this._centerRipple = null;
		return this;
	} 

	public ButtonBaseElement setClasses(Object value) {
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

	public ButtonBaseElement removeClasses() {
		this._classes = null;
		return this;
	} 

	public ButtonBaseElement setClassName(Object value) {
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

	public ButtonBaseElement removeClassName() {
		this._className = null;
		return this;
	} 

	public ButtonBaseElement setComponent(Object value) {
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

	public ButtonBaseElement removeComponent() {
		this._component = null;
		return this;
	} 

	public ButtonBaseElement setDisabled(Object value) {
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

	public ButtonBaseElement removeDisabled() {
		this._disabled = null;
		return this;
	} 

	public ButtonBaseElement setDisableRipple(Object value) {
		this._disableRipple = value;
		return this;
	}

	public Object getDisableRipple() {
		return this._disableRipple;
	}

	public Object getDisableRipple(Object defaultValue) {
		return this._disableRipple == null ? defaultValue : this._disableRipple;
	}

	public boolean hasDisableRipple() {
		return this._disableRipple != null;
	}

	public ButtonBaseElement removeDisableRipple() {
		this._disableRipple = null;
		return this;
	} 

	public ButtonBaseElement setDisableTouchRipple(Object value) {
		this._disableTouchRipple = value;
		return this;
	}

	public Object getDisableTouchRipple() {
		return this._disableTouchRipple;
	}

	public Object getDisableTouchRipple(Object defaultValue) {
		return this._disableTouchRipple == null ? defaultValue : this._disableTouchRipple;
	}

	public boolean hasDisableTouchRipple() {
		return this._disableTouchRipple != null;
	}

	public ButtonBaseElement removeDisableTouchRipple() {
		this._disableTouchRipple = null;
		return this;
	} 

	public ButtonBaseElement setFocusRipple(Object value) {
		this._focusRipple = value;
		return this;
	}

	public Object getFocusRipple() {
		return this._focusRipple;
	}

	public Object getFocusRipple(Object defaultValue) {
		return this._focusRipple == null ? defaultValue : this._focusRipple;
	}

	public boolean hasFocusRipple() {
		return this._focusRipple != null;
	}

	public ButtonBaseElement removeFocusRipple() {
		this._focusRipple = null;
		return this;
	} 

	public ButtonBaseElement setFocusVisibleClassName(Object value) {
		this._focusVisibleClassName = value;
		return this;
	}

	public Object getFocusVisibleClassName() {
		return this._focusVisibleClassName;
	}

	public Object getFocusVisibleClassName(Object defaultValue) {
		return this._focusVisibleClassName == null ? defaultValue : this._focusVisibleClassName;
	}

	public boolean hasFocusVisibleClassName() {
		return this._focusVisibleClassName != null;
	}

	public ButtonBaseElement removeFocusVisibleClassName() {
		this._focusVisibleClassName = null;
		return this;
	} 

	public ButtonBaseElement setId(Object value) {
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

	public ButtonBaseElement removeId() {
		this._id = null;
		return this;
	} 

	public ButtonBaseElement setKey(Object value) {
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

	public ButtonBaseElement removeKey() {
		this._key = null;
		return this;
	} 

	public ButtonBaseElement setOnFocusVisible(Object value) {
		this._onFocusVisible = value;
		return this;
	}

	public Object getOnFocusVisible() {
		return this._onFocusVisible;
	}

	public Object getOnFocusVisible(Object defaultValue) {
		return this._onFocusVisible == null ? defaultValue : this._onFocusVisible;
	}

	public boolean hasOnFocusVisible() {
		return this._onFocusVisible != null;
	}

	public ButtonBaseElement removeOnFocusVisible() {
		this._onFocusVisible = null;
		return this;
	} 

	public ButtonBaseElement setStyle(Object value) {
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

	public ButtonBaseElement removeStyle() {
		this._style = null;
		return this;
	} 

	public ButtonBaseElement setTouchRippleProps(Object value) {
		this._TouchRippleProps = value;
		return this;
	}

	public Object getTouchRippleProps() {
		return this._TouchRippleProps;
	}

	public Object getTouchRippleProps(Object defaultValue) {
		return this._TouchRippleProps == null ? defaultValue : this._TouchRippleProps;
	}

	public boolean hasTouchRippleProps() {
		return this._TouchRippleProps != null;
	}

	public ButtonBaseElement removeTouchRippleProps() {
		this._TouchRippleProps = null;
		return this;
	} 

	public ButtonBaseElement addChildren(Object value) {
		this._children.add(value);
		return this;
	}

	public ButtonBaseElement setChildren(Object[] value) {
		this._children.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public ButtonBaseElement setChildren(java.util.Collection<Object> values) {
		this._children.addAll(values);
		return this;
	}

	public ButtonBaseElement removeChildren(Object value) {
		this._children.remove(value);
		return this;
	}

	public ButtonBaseElement removeChildren(int index) {
		this._children.remove(index);
		return this;
	}

	public java.util.List<Object> getChildren() {
		return this._children;
	} 

	public ButtonBaseElement addAttribute(Object _name, Object _value) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		map.put("value", _value);
		this._attribute.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getAttribute() {
		return this._attribute;
	}

	public ButtonBaseElement addAttribute(ButtonBaseElement_Attribute value) {
		return addAttribute(value._name, value._value);
	}

	public java.util.stream.Stream<ButtonBaseElement_Attribute> streamAttribute() {
		return this._attribute.stream().map(ButtonBaseElement_Attribute::new);
	}

	public java.util.List<Object> getAttribute_Name() {
		return streamAttribute().map(ButtonBaseElement_Attribute::getName).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getAttribute_Value() {
		return streamAttribute().map(ButtonBaseElement_Attribute::getValue).collect(java.util.stream.Collectors.toList());
	}


	public static final class ButtonBaseElement_Attribute {

		Object _name;
		Object _value;

		public ButtonBaseElement_Attribute(Object _name, Object _value) {
			this._name = _name;
			this._value = _value;
		}

		private ButtonBaseElement_Attribute(java.util.Map<String, Object> map) {
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
		ButtonBaseElement that = (ButtonBaseElement) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "ButtonBaseElement(action,centerRipple,classes,className,component,disabled,disableRipple,disableTouchRipple,focusRipple,focusVisibleClassName,id,key,onFocusVisible,style,TouchRippleProps,attribute,children) ::= <<<ButtonBase~if(action)~\n" + 
				"	action=~action~~endif~~if(centerRipple)~\n" + 
				"	centerRipple~endif~~if(classes)~\n" + 
				"	classes=~classes~~endif~~if(className)~\n" + 
				"	className=~className~~endif~~if(component)~\n" + 
				"	component=~component~~endif~~if(disabled)~\n" + 
				"	disabled~endif~~if(disableRipple)~\n" + 
				"	disableRipple~endif~~if(disableTouchRipple)~\n" + 
				"	disableTouchRipple~endif~~if(focusRipple)~\n" + 
				"	focusRipple~endif~~if(focusVisibleClassName)~\n" + 
				"	focusVisibleClassName=\"~focusVisibleClassName~\"~endif~~if(id)~\n" + 
				"	id=\"~id~\"~endif~~if(key)~\n" + 
				"	key=~key~~endif~~if(onFocusVisible)~\n" + 
				"	onFocusVisible=~onFocusVisible~~endif~~if(style)~\n" + 
				"	style=~style~~endif~~if(TouchRippleProps)~\n" + 
				"	TouchRippleProps=~TouchRippleProps~~endif~~attribute:{it|\n" + 
				"	\n" + 
				"	~it.name~=~it.value~}~~if(children)~>\n" + 
				"	~children:{it|~it~};separator=\"\\n\"~\n" + 
				"</ButtonBase>~else~ />~endif~ >>";
}  