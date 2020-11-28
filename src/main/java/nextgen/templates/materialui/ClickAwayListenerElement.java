package nextgen.templates.materialui;

public class ClickAwayListenerElement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _className;
	private Object _disableReactTree;
	private Object _id;
	private Object _key;
	private Object _mouseEvent;
	private Object _onClickAway;
	private Object _style;
	private Object _touchEvent;
	private java.util.List<Object> _children = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _attribute = new java.util.ArrayList<>();

	ClickAwayListenerElement(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("ClickAwayListenerElement");
		st.add("className", _className);
		st.add("disableReactTree", _disableReactTree);
		st.add("id", _id);
		st.add("key", _key);
		st.add("mouseEvent", _mouseEvent);
		st.add("onClickAway", _onClickAway);
		st.add("style", _style);
		st.add("touchEvent", _touchEvent);
		for (Object o : _children) st.add("children", o);
		for (java.util.Map<String, Object> map : _attribute) st.addAggr("attribute.{name,value}", map.get("name"), map.get("value"));
		return st.render().trim();
	}

	public ClickAwayListenerElement setClassName(Object value) {
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

	public ClickAwayListenerElement removeClassName() {
		this._className = null;
		return this;
	} 

	public ClickAwayListenerElement setDisableReactTree(Object value) {
		this._disableReactTree = value;
		return this;
	}

	public Object getDisableReactTree() {
		return this._disableReactTree;
	}

	public Object getDisableReactTree(Object defaultValue) {
		return this._disableReactTree == null ? defaultValue : this._disableReactTree;
	}

	public boolean hasDisableReactTree() {
		return this._disableReactTree != null;
	}

	public ClickAwayListenerElement removeDisableReactTree() {
		this._disableReactTree = null;
		return this;
	} 

	public ClickAwayListenerElement setId(Object value) {
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

	public ClickAwayListenerElement removeId() {
		this._id = null;
		return this;
	} 

	public ClickAwayListenerElement setKey(Object value) {
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

	public ClickAwayListenerElement removeKey() {
		this._key = null;
		return this;
	} 

	public ClickAwayListenerElement setMouseEvent(Object value) {
		this._mouseEvent = value;
		return this;
	}

	public Object getMouseEvent() {
		return this._mouseEvent;
	}

	public Object getMouseEvent(Object defaultValue) {
		return this._mouseEvent == null ? defaultValue : this._mouseEvent;
	}

	public boolean hasMouseEvent() {
		return this._mouseEvent != null;
	}

	public ClickAwayListenerElement removeMouseEvent() {
		this._mouseEvent = null;
		return this;
	} 

	public ClickAwayListenerElement setOnClickAway(Object value) {
		this._onClickAway = value;
		return this;
	}

	public Object getOnClickAway() {
		return this._onClickAway;
	}

	public Object getOnClickAway(Object defaultValue) {
		return this._onClickAway == null ? defaultValue : this._onClickAway;
	}

	public boolean hasOnClickAway() {
		return this._onClickAway != null;
	}

	public ClickAwayListenerElement removeOnClickAway() {
		this._onClickAway = null;
		return this;
	} 

	public ClickAwayListenerElement setStyle(Object value) {
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

	public ClickAwayListenerElement removeStyle() {
		this._style = null;
		return this;
	} 

	public ClickAwayListenerElement setTouchEvent(Object value) {
		this._touchEvent = value;
		return this;
	}

	public Object getTouchEvent() {
		return this._touchEvent;
	}

	public Object getTouchEvent(Object defaultValue) {
		return this._touchEvent == null ? defaultValue : this._touchEvent;
	}

	public boolean hasTouchEvent() {
		return this._touchEvent != null;
	}

	public ClickAwayListenerElement removeTouchEvent() {
		this._touchEvent = null;
		return this;
	} 

	public ClickAwayListenerElement addChildren(Object value) {
		this._children.add(value);
		return this;
	}

	public ClickAwayListenerElement setChildren(Object[] value) {
		this._children.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public ClickAwayListenerElement setChildren(java.util.Collection<Object> values) {
		this._children.addAll(values);
		return this;
	}

	public ClickAwayListenerElement removeChildren(Object value) {
		this._children.remove(value);
		return this;
	}

	public ClickAwayListenerElement removeChildren(int index) {
		this._children.remove(index);
		return this;
	}

	public java.util.List<Object> getChildren() {
		return this._children;
	} 

	public ClickAwayListenerElement addAttribute(Object _name, Object _value) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		map.put("value", _value);
		this._attribute.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getAttribute() {
		return this._attribute;
	}

	public ClickAwayListenerElement addAttribute(ClickAwayListenerElement_Attribute value) {
		return addAttribute(value._name, value._value);
	}

	public java.util.stream.Stream<ClickAwayListenerElement_Attribute> streamAttribute() {
		return this._attribute.stream().map(ClickAwayListenerElement_Attribute::new);
	}

	public java.util.List<Object> getAttribute_Name() {
		return streamAttribute().map(ClickAwayListenerElement_Attribute::getName).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getAttribute_Value() {
		return streamAttribute().map(ClickAwayListenerElement_Attribute::getValue).collect(java.util.stream.Collectors.toList());
	}


	public static final class ClickAwayListenerElement_Attribute {

		Object _name;
		Object _value;

		public ClickAwayListenerElement_Attribute(Object _name, Object _value) {
			this._name = _name;
			this._value = _value;
		}

		private ClickAwayListenerElement_Attribute(java.util.Map<String, Object> map) {
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
		ClickAwayListenerElement that = (ClickAwayListenerElement) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "ClickAwayListenerElement(className,disableReactTree,id,key,mouseEvent,onClickAway,style,touchEvent,attribute,children) ::= <<<ClickAwayListener~if(className)~\n" + 
				"	className=~className~~endif~~if(disableReactTree)~\n" + 
				"	disableReactTree~endif~~if(id)~\n" + 
				"	id=\"~id~\"~endif~~if(key)~\n" + 
				"	key=~key~~endif~~if(mouseEvent)~\n" + 
				"	mouseEvent=~mouseEvent~~endif~\n" + 
				"	onClickAway=~onClickAway~~if(style)~\n" + 
				"	style=~style~~endif~~if(touchEvent)~\n" + 
				"	touchEvent=~touchEvent~~endif~~attribute:{it|\n" + 
				"	\n" + 
				"	~it.name~=~it.value~}~~if(children)~>\n" + 
				"	~children:{it|~it~};separator=\"\\n\"~\n" + 
				"</ClickAwayListener>~else~ />~endif~ >>";
}  