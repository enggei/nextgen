package nextgen.templates.materialui;

public class TooltipElement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _arrow;
	private Object _classes;
	private Object _className;
	private Object _disableFocusListener;
	private Object _disableHoverListener;
	private Object _disableTouchListener;
	private Object _enterDelay;
	private Object _enterNextDelay;
	private Object _enterTouchDelay;
	private Object _id;
	private Object _interactive;
	private Object _leaveDelay;
	private Object _leaveTouchDelay;
	private Object _onClose;
	private Object _onOpen;
	private Object _open;
	private Object _placement;
	private Object _PopperComponent;
	private Object _PopperProps;
	private Object _style;
	private Object _title;
	private Object _TransitionComponent;
	private Object _TransitionProps;
	private java.util.List<Object> _children = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _attribute = new java.util.ArrayList<>();

	TooltipElement(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Deprecated
	public java.util.UUID uuid() {
		return uuid;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("TooltipElement");
		st.add("arrow", _arrow);
		st.add("classes", _classes);
		st.add("className", _className);
		st.add("disableFocusListener", _disableFocusListener);
		st.add("disableHoverListener", _disableHoverListener);
		st.add("disableTouchListener", _disableTouchListener);
		st.add("enterDelay", _enterDelay);
		st.add("enterNextDelay", _enterNextDelay);
		st.add("enterTouchDelay", _enterTouchDelay);
		st.add("id", _id);
		st.add("interactive", _interactive);
		st.add("leaveDelay", _leaveDelay);
		st.add("leaveTouchDelay", _leaveTouchDelay);
		st.add("onClose", _onClose);
		st.add("onOpen", _onOpen);
		st.add("open", _open);
		st.add("placement", _placement);
		st.add("PopperComponent", _PopperComponent);
		st.add("PopperProps", _PopperProps);
		st.add("style", _style);
		st.add("title", _title);
		st.add("TransitionComponent", _TransitionComponent);
		st.add("TransitionProps", _TransitionProps);
		for (Object o : _children) st.add("children", o);
		for (java.util.Map<String, Object> map : _attribute) st.addAggr("attribute.{name,value}", map.get("name"), map.get("value"));
		return st.render().trim();
	}

	public TooltipElement setArrow(Object value) {
		this._arrow = value;
		return this;
	}

	public Object getArrow() {
		return this._arrow;
	}

	public Object getArrow(Object defaultValue) {
		return this._arrow == null ? defaultValue : this._arrow;
	}

	public boolean hasArrow() {
		return this._arrow != null;
	}

	public TooltipElement removeArrow() {
		this._arrow = null;
		return this;
	} 

	public TooltipElement setClasses(Object value) {
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

	public TooltipElement removeClasses() {
		this._classes = null;
		return this;
	} 

	public TooltipElement setClassName(Object value) {
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

	public TooltipElement removeClassName() {
		this._className = null;
		return this;
	} 

	public TooltipElement setDisableFocusListener(Object value) {
		this._disableFocusListener = value;
		return this;
	}

	public Object getDisableFocusListener() {
		return this._disableFocusListener;
	}

	public Object getDisableFocusListener(Object defaultValue) {
		return this._disableFocusListener == null ? defaultValue : this._disableFocusListener;
	}

	public boolean hasDisableFocusListener() {
		return this._disableFocusListener != null;
	}

	public TooltipElement removeDisableFocusListener() {
		this._disableFocusListener = null;
		return this;
	} 

	public TooltipElement setDisableHoverListener(Object value) {
		this._disableHoverListener = value;
		return this;
	}

	public Object getDisableHoverListener() {
		return this._disableHoverListener;
	}

	public Object getDisableHoverListener(Object defaultValue) {
		return this._disableHoverListener == null ? defaultValue : this._disableHoverListener;
	}

	public boolean hasDisableHoverListener() {
		return this._disableHoverListener != null;
	}

	public TooltipElement removeDisableHoverListener() {
		this._disableHoverListener = null;
		return this;
	} 

	public TooltipElement setDisableTouchListener(Object value) {
		this._disableTouchListener = value;
		return this;
	}

	public Object getDisableTouchListener() {
		return this._disableTouchListener;
	}

	public Object getDisableTouchListener(Object defaultValue) {
		return this._disableTouchListener == null ? defaultValue : this._disableTouchListener;
	}

	public boolean hasDisableTouchListener() {
		return this._disableTouchListener != null;
	}

	public TooltipElement removeDisableTouchListener() {
		this._disableTouchListener = null;
		return this;
	} 

	public TooltipElement setEnterDelay(Object value) {
		this._enterDelay = value;
		return this;
	}

	public Object getEnterDelay() {
		return this._enterDelay;
	}

	public Object getEnterDelay(Object defaultValue) {
		return this._enterDelay == null ? defaultValue : this._enterDelay;
	}

	public boolean hasEnterDelay() {
		return this._enterDelay != null;
	}

	public TooltipElement removeEnterDelay() {
		this._enterDelay = null;
		return this;
	} 

	public TooltipElement setEnterNextDelay(Object value) {
		this._enterNextDelay = value;
		return this;
	}

	public Object getEnterNextDelay() {
		return this._enterNextDelay;
	}

	public Object getEnterNextDelay(Object defaultValue) {
		return this._enterNextDelay == null ? defaultValue : this._enterNextDelay;
	}

	public boolean hasEnterNextDelay() {
		return this._enterNextDelay != null;
	}

	public TooltipElement removeEnterNextDelay() {
		this._enterNextDelay = null;
		return this;
	} 

	public TooltipElement setEnterTouchDelay(Object value) {
		this._enterTouchDelay = value;
		return this;
	}

	public Object getEnterTouchDelay() {
		return this._enterTouchDelay;
	}

	public Object getEnterTouchDelay(Object defaultValue) {
		return this._enterTouchDelay == null ? defaultValue : this._enterTouchDelay;
	}

	public boolean hasEnterTouchDelay() {
		return this._enterTouchDelay != null;
	}

	public TooltipElement removeEnterTouchDelay() {
		this._enterTouchDelay = null;
		return this;
	} 

	public TooltipElement setId(Object value) {
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

	public TooltipElement removeId() {
		this._id = null;
		return this;
	} 

	public TooltipElement setInteractive(Object value) {
		this._interactive = value;
		return this;
	}

	public Object getInteractive() {
		return this._interactive;
	}

	public Object getInteractive(Object defaultValue) {
		return this._interactive == null ? defaultValue : this._interactive;
	}

	public boolean hasInteractive() {
		return this._interactive != null;
	}

	public TooltipElement removeInteractive() {
		this._interactive = null;
		return this;
	} 

	public TooltipElement setLeaveDelay(Object value) {
		this._leaveDelay = value;
		return this;
	}

	public Object getLeaveDelay() {
		return this._leaveDelay;
	}

	public Object getLeaveDelay(Object defaultValue) {
		return this._leaveDelay == null ? defaultValue : this._leaveDelay;
	}

	public boolean hasLeaveDelay() {
		return this._leaveDelay != null;
	}

	public TooltipElement removeLeaveDelay() {
		this._leaveDelay = null;
		return this;
	} 

	public TooltipElement setLeaveTouchDelay(Object value) {
		this._leaveTouchDelay = value;
		return this;
	}

	public Object getLeaveTouchDelay() {
		return this._leaveTouchDelay;
	}

	public Object getLeaveTouchDelay(Object defaultValue) {
		return this._leaveTouchDelay == null ? defaultValue : this._leaveTouchDelay;
	}

	public boolean hasLeaveTouchDelay() {
		return this._leaveTouchDelay != null;
	}

	public TooltipElement removeLeaveTouchDelay() {
		this._leaveTouchDelay = null;
		return this;
	} 

	public TooltipElement setOnClose(Object value) {
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

	public TooltipElement removeOnClose() {
		this._onClose = null;
		return this;
	} 

	public TooltipElement setOnOpen(Object value) {
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

	public TooltipElement removeOnOpen() {
		this._onOpen = null;
		return this;
	} 

	public TooltipElement setOpen(Object value) {
		this._open = value;
		return this;
	}

	public Object getOpen() {
		return this._open;
	}

	public Object getOpen(Object defaultValue) {
		return this._open == null ? defaultValue : this._open;
	}

	public boolean hasOpen() {
		return this._open != null;
	}

	public TooltipElement removeOpen() {
		this._open = null;
		return this;
	} 

	public TooltipElement setPlacement(Object value) {
		this._placement = value;
		return this;
	}

	public Object getPlacement() {
		return this._placement;
	}

	public Object getPlacement(Object defaultValue) {
		return this._placement == null ? defaultValue : this._placement;
	}

	public boolean hasPlacement() {
		return this._placement != null;
	}

	public TooltipElement removePlacement() {
		this._placement = null;
		return this;
	} 

	public TooltipElement setPopperComponent(Object value) {
		this._PopperComponent = value;
		return this;
	}

	public Object getPopperComponent() {
		return this._PopperComponent;
	}

	public Object getPopperComponent(Object defaultValue) {
		return this._PopperComponent == null ? defaultValue : this._PopperComponent;
	}

	public boolean hasPopperComponent() {
		return this._PopperComponent != null;
	}

	public TooltipElement removePopperComponent() {
		this._PopperComponent = null;
		return this;
	} 

	public TooltipElement setPopperProps(Object value) {
		this._PopperProps = value;
		return this;
	}

	public Object getPopperProps() {
		return this._PopperProps;
	}

	public Object getPopperProps(Object defaultValue) {
		return this._PopperProps == null ? defaultValue : this._PopperProps;
	}

	public boolean hasPopperProps() {
		return this._PopperProps != null;
	}

	public TooltipElement removePopperProps() {
		this._PopperProps = null;
		return this;
	} 

	public TooltipElement setStyle(Object value) {
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

	public TooltipElement removeStyle() {
		this._style = null;
		return this;
	} 

	public TooltipElement setTitle(Object value) {
		this._title = value;
		return this;
	}

	public Object getTitle() {
		return this._title;
	}

	public Object getTitle(Object defaultValue) {
		return this._title == null ? defaultValue : this._title;
	}

	public boolean hasTitle() {
		return this._title != null;
	}

	public TooltipElement removeTitle() {
		this._title = null;
		return this;
	} 

	public TooltipElement setTransitionComponent(Object value) {
		this._TransitionComponent = value;
		return this;
	}

	public Object getTransitionComponent() {
		return this._TransitionComponent;
	}

	public Object getTransitionComponent(Object defaultValue) {
		return this._TransitionComponent == null ? defaultValue : this._TransitionComponent;
	}

	public boolean hasTransitionComponent() {
		return this._TransitionComponent != null;
	}

	public TooltipElement removeTransitionComponent() {
		this._TransitionComponent = null;
		return this;
	} 

	public TooltipElement setTransitionProps(Object value) {
		this._TransitionProps = value;
		return this;
	}

	public Object getTransitionProps() {
		return this._TransitionProps;
	}

	public Object getTransitionProps(Object defaultValue) {
		return this._TransitionProps == null ? defaultValue : this._TransitionProps;
	}

	public boolean hasTransitionProps() {
		return this._TransitionProps != null;
	}

	public TooltipElement removeTransitionProps() {
		this._TransitionProps = null;
		return this;
	} 

	public TooltipElement addChildren(Object value) {
		this._children.add(value);
		return this;
	}

	public TooltipElement setChildren(Object[] value) {
		this._children.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public TooltipElement setChildren(java.util.Collection<Object> values) {
		this._children.addAll(values);
		return this;
	}

	public TooltipElement removeChildren(Object value) {
		this._children.remove(value);
		return this;
	}

	public TooltipElement removeChildren(int index) {
		this._children.remove(index);
		return this;
	}

	public java.util.List<Object> getChildren() {
		return this._children;
	} 

	public TooltipElement addAttribute(Object _name, Object _value) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		map.put("value", _value);
		this._attribute.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getAttribute() {
		return this._attribute;
	}

	public TooltipElement addAttribute(TooltipElement_Attribute value) {
		return addAttribute(value._name, value._value);
	}

	public java.util.stream.Stream<TooltipElement_Attribute> streamAttribute() {
		return this._attribute.stream().map(TooltipElement_Attribute::new);
	}

	public static final class TooltipElement_Attribute {

		Object _name;
		Object _value;

		public TooltipElement_Attribute(Object _name, Object _value) {
			this._name = _name;
			this._value = _value;
		}

		private TooltipElement_Attribute(java.util.Map<String, Object> map) {
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
		TooltipElement that = (TooltipElement) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "TooltipElement(arrow,classes,className,disableFocusListener,disableHoverListener,disableTouchListener,enterDelay,enterNextDelay,enterTouchDelay,id,interactive,leaveDelay,leaveTouchDelay,onClose,onOpen,open,placement,PopperComponent,PopperProps,style,title,TransitionComponent,TransitionProps,attribute,children) ::= <<<Tooltip~if(arrow)~\n" + 
				"	arrow~endif~~if(classes)~\n" + 
				"	classes=~classes~~endif~~if(className)~\n" + 
				"	className=~className~~endif~~if(disableFocusListener)~\n" + 
				"	disableFocusListener~endif~~if(disableHoverListener)~\n" + 
				"	disableHoverListener~endif~~if(disableTouchListener)~\n" + 
				"	disableTouchListener~endif~~if(enterDelay)~\n" + 
				"	enterDelay=~enterDelay~~endif~~if(enterNextDelay)~\n" + 
				"	enterNextDelay=~enterNextDelay~~endif~~if(enterTouchDelay)~\n" + 
				"	enterTouchDelay=~enterTouchDelay~~endif~~if(id)~\n" + 
				"	id=\"~id~\"~endif~~if(interactive)~\n" + 
				"	interactive~endif~~if(leaveDelay)~\n" + 
				"	leaveDelay=~leaveDelay~~endif~~if(leaveTouchDelay)~\n" + 
				"	leaveTouchDelay=~leaveTouchDelay~~endif~~if(onClose)~\n" + 
				"	onClose=~onClose~~endif~~if(onOpen)~\n" + 
				"	onOpen=~onOpen~~endif~~if(open)~\n" + 
				"	open~endif~~if(placement)~\n" + 
				"	placement=\"~placement~\"~endif~~if(PopperComponent)~\n" + 
				"	PopperComponent=~PopperComponent~~endif~~if(PopperProps)~\n" + 
				"	PopperProps=~PopperProps~~endif~~if(style)~\n" + 
				"	style=~style~~endif~\n" + 
				"	title=~title~~if(TransitionComponent)~\n" + 
				"	TransitionComponent=~TransitionComponent~~endif~~if(TransitionProps)~\n" + 
				"	TransitionProps=~TransitionProps~~endif~~attribute:{it|\n" + 
				"	\n" + 
				"	~it.name~=~it.value~}~~if(children)~>\n" + 
				"	~children:{it|~it~};separator=\"\\n\"~\n" + 
				"</Tooltip>~else~ />~endif~ >>";
}  