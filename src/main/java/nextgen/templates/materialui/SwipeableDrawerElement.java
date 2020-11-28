package nextgen.templates.materialui;

public class SwipeableDrawerElement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _className;
	private Object _disableBackdropTransition;
	private Object _disableDiscovery;
	private Object _disableSwipeToOpen;
	private Object _hysteresis;
	private Object _id;
	private Object _key;
	private Object _minFlingVelocity;
	private Object _onClose;
	private Object _onOpen;
	private Object _style;
	private Object _SwipeAreaProps;
	private Object _swipeAreaWidth;
	private Object _transitionDuration;
	private java.util.List<Object> _children = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _attribute = new java.util.ArrayList<>();

	SwipeableDrawerElement(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("SwipeableDrawerElement");
		st.add("className", _className);
		st.add("disableBackdropTransition", _disableBackdropTransition);
		st.add("disableDiscovery", _disableDiscovery);
		st.add("disableSwipeToOpen", _disableSwipeToOpen);
		st.add("hysteresis", _hysteresis);
		st.add("id", _id);
		st.add("key", _key);
		st.add("minFlingVelocity", _minFlingVelocity);
		st.add("onClose", _onClose);
		st.add("onOpen", _onOpen);
		st.add("style", _style);
		st.add("SwipeAreaProps", _SwipeAreaProps);
		st.add("swipeAreaWidth", _swipeAreaWidth);
		st.add("transitionDuration", _transitionDuration);
		for (Object o : _children) st.add("children", o);
		for (java.util.Map<String, Object> map : _attribute) st.addAggr("attribute.{name,value}", map.get("name"), map.get("value"));
		return st.render().trim();
	}

	public SwipeableDrawerElement setClassName(Object value) {
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

	public SwipeableDrawerElement removeClassName() {
		this._className = null;
		return this;
	} 

	public SwipeableDrawerElement setDisableBackdropTransition(Object value) {
		this._disableBackdropTransition = value;
		return this;
	}

	public Object getDisableBackdropTransition() {
		return this._disableBackdropTransition;
	}

	public Object getDisableBackdropTransition(Object defaultValue) {
		return this._disableBackdropTransition == null ? defaultValue : this._disableBackdropTransition;
	}

	public boolean hasDisableBackdropTransition() {
		return this._disableBackdropTransition != null;
	}

	public SwipeableDrawerElement removeDisableBackdropTransition() {
		this._disableBackdropTransition = null;
		return this;
	} 

	public SwipeableDrawerElement setDisableDiscovery(Object value) {
		this._disableDiscovery = value;
		return this;
	}

	public Object getDisableDiscovery() {
		return this._disableDiscovery;
	}

	public Object getDisableDiscovery(Object defaultValue) {
		return this._disableDiscovery == null ? defaultValue : this._disableDiscovery;
	}

	public boolean hasDisableDiscovery() {
		return this._disableDiscovery != null;
	}

	public SwipeableDrawerElement removeDisableDiscovery() {
		this._disableDiscovery = null;
		return this;
	} 

	public SwipeableDrawerElement setDisableSwipeToOpen(Object value) {
		this._disableSwipeToOpen = value;
		return this;
	}

	public Object getDisableSwipeToOpen() {
		return this._disableSwipeToOpen;
	}

	public Object getDisableSwipeToOpen(Object defaultValue) {
		return this._disableSwipeToOpen == null ? defaultValue : this._disableSwipeToOpen;
	}

	public boolean hasDisableSwipeToOpen() {
		return this._disableSwipeToOpen != null;
	}

	public SwipeableDrawerElement removeDisableSwipeToOpen() {
		this._disableSwipeToOpen = null;
		return this;
	} 

	public SwipeableDrawerElement setHysteresis(Object value) {
		this._hysteresis = value;
		return this;
	}

	public Object getHysteresis() {
		return this._hysteresis;
	}

	public Object getHysteresis(Object defaultValue) {
		return this._hysteresis == null ? defaultValue : this._hysteresis;
	}

	public boolean hasHysteresis() {
		return this._hysteresis != null;
	}

	public SwipeableDrawerElement removeHysteresis() {
		this._hysteresis = null;
		return this;
	} 

	public SwipeableDrawerElement setId(Object value) {
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

	public SwipeableDrawerElement removeId() {
		this._id = null;
		return this;
	} 

	public SwipeableDrawerElement setKey(Object value) {
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

	public SwipeableDrawerElement removeKey() {
		this._key = null;
		return this;
	} 

	public SwipeableDrawerElement setMinFlingVelocity(Object value) {
		this._minFlingVelocity = value;
		return this;
	}

	public Object getMinFlingVelocity() {
		return this._minFlingVelocity;
	}

	public Object getMinFlingVelocity(Object defaultValue) {
		return this._minFlingVelocity == null ? defaultValue : this._minFlingVelocity;
	}

	public boolean hasMinFlingVelocity() {
		return this._minFlingVelocity != null;
	}

	public SwipeableDrawerElement removeMinFlingVelocity() {
		this._minFlingVelocity = null;
		return this;
	} 

	public SwipeableDrawerElement setOnClose(Object value) {
		this._onClose = value;
		return this;
	}

	public Object getOnClose() {
		return this._onClose;
	}

	public Object getOnClose(Object defaultValue) {
		return this._onClose == null ? defaultValue : this._onClose;
	}

	public boolean hasOnClose() {
		return this._onClose != null;
	}

	public SwipeableDrawerElement removeOnClose() {
		this._onClose = null;
		return this;
	} 

	public SwipeableDrawerElement setOnOpen(Object value) {
		this._onOpen = value;
		return this;
	}

	public Object getOnOpen() {
		return this._onOpen;
	}

	public Object getOnOpen(Object defaultValue) {
		return this._onOpen == null ? defaultValue : this._onOpen;
	}

	public boolean hasOnOpen() {
		return this._onOpen != null;
	}

	public SwipeableDrawerElement removeOnOpen() {
		this._onOpen = null;
		return this;
	} 

	public SwipeableDrawerElement setStyle(Object value) {
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

	public SwipeableDrawerElement removeStyle() {
		this._style = null;
		return this;
	} 

	public SwipeableDrawerElement setSwipeAreaProps(Object value) {
		this._SwipeAreaProps = value;
		return this;
	}

	public Object getSwipeAreaProps() {
		return this._SwipeAreaProps;
	}

	public Object getSwipeAreaProps(Object defaultValue) {
		return this._SwipeAreaProps == null ? defaultValue : this._SwipeAreaProps;
	}

	public boolean hasSwipeAreaProps() {
		return this._SwipeAreaProps != null;
	}

	public SwipeableDrawerElement removeSwipeAreaProps() {
		this._SwipeAreaProps = null;
		return this;
	} 

	public SwipeableDrawerElement setSwipeAreaWidth(Object value) {
		this._swipeAreaWidth = value;
		return this;
	}

	public Object getSwipeAreaWidth() {
		return this._swipeAreaWidth;
	}

	public Object getSwipeAreaWidth(Object defaultValue) {
		return this._swipeAreaWidth == null ? defaultValue : this._swipeAreaWidth;
	}

	public boolean hasSwipeAreaWidth() {
		return this._swipeAreaWidth != null;
	}

	public SwipeableDrawerElement removeSwipeAreaWidth() {
		this._swipeAreaWidth = null;
		return this;
	} 

	public SwipeableDrawerElement setTransitionDuration(Object value) {
		this._transitionDuration = value;
		return this;
	}

	public Object getTransitionDuration() {
		return this._transitionDuration;
	}

	public Object getTransitionDuration(Object defaultValue) {
		return this._transitionDuration == null ? defaultValue : this._transitionDuration;
	}

	public boolean hasTransitionDuration() {
		return this._transitionDuration != null;
	}

	public SwipeableDrawerElement removeTransitionDuration() {
		this._transitionDuration = null;
		return this;
	} 

	public SwipeableDrawerElement addChildren(Object value) {
		this._children.add(value);
		return this;
	}

	public SwipeableDrawerElement setChildren(Object[] value) {
		this._children.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public SwipeableDrawerElement setChildren(java.util.Collection<Object> values) {
		this._children.addAll(values);
		return this;
	}

	public SwipeableDrawerElement removeChildren(Object value) {
		this._children.remove(value);
		return this;
	}

	public SwipeableDrawerElement removeChildren(int index) {
		this._children.remove(index);
		return this;
	}

	public java.util.List<Object> getChildren() {
		return this._children;
	} 

	public SwipeableDrawerElement addAttribute(Object _name, Object _value) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		map.put("value", _value);
		this._attribute.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getAttribute() {
		return this._attribute;
	}

	public SwipeableDrawerElement addAttribute(SwipeableDrawerElement_Attribute value) {
		return addAttribute(value._name, value._value);
	}

	public java.util.stream.Stream<SwipeableDrawerElement_Attribute> streamAttribute() {
		return this._attribute.stream().map(SwipeableDrawerElement_Attribute::new);
	}

	public java.util.List<Object> getAttribute_Name() {
		return streamAttribute().map(SwipeableDrawerElement_Attribute::getName).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getAttribute_Value() {
		return streamAttribute().map(SwipeableDrawerElement_Attribute::getValue).collect(java.util.stream.Collectors.toList());
	}


	public static final class SwipeableDrawerElement_Attribute {

		Object _name;
		Object _value;

		public SwipeableDrawerElement_Attribute(Object _name, Object _value) {
			this._name = _name;
			this._value = _value;
		}

		private SwipeableDrawerElement_Attribute(java.util.Map<String, Object> map) {
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
		SwipeableDrawerElement that = (SwipeableDrawerElement) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "SwipeableDrawerElement(className,disableBackdropTransition,disableDiscovery,disableSwipeToOpen,hysteresis,id,key,minFlingVelocity,onClose,onOpen,style,SwipeAreaProps,swipeAreaWidth,transitionDuration,attribute,children) ::= <<<SwipeableDrawer~if(className)~\n" + 
				"	className=~className~~endif~~if(disableBackdropTransition)~\n" + 
				"	disableBackdropTransition~endif~~if(disableDiscovery)~\n" + 
				"	disableDiscovery~endif~~if(disableSwipeToOpen)~\n" + 
				"	disableSwipeToOpen~endif~~if(hysteresis)~\n" + 
				"	hysteresis=~hysteresis~~endif~~if(id)~\n" + 
				"	id=\"~id~\"~endif~~if(key)~\n" + 
				"	key=~key~~endif~~if(minFlingVelocity)~\n" + 
				"	minFlingVelocity=~minFlingVelocity~~endif~\n" + 
				"	onClose=~onClose~\n" + 
				"	onOpen=~onOpen~\n" + 
				"	open~if(style)~\n" + 
				"	style=~style~~endif~~if(SwipeAreaProps)~\n" + 
				"	SwipeAreaProps=~SwipeAreaProps~~endif~~if(swipeAreaWidth)~\n" + 
				"	swipeAreaWidth=~swipeAreaWidth~~endif~~if(transitionDuration)~\n" + 
				"	transitionDuration=~transitionDuration~~endif~~attribute:{it|\n" + 
				"	\n" + 
				"	~it.name~=~it.value~}~~if(children)~>\n" + 
				"	~children:{it|~it~};separator=\"\\n\"~\n" + 
				"</SwipeableDrawer>~else~ />~endif~ >>";
}  