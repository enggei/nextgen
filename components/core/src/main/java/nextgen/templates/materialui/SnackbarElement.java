package nextgen.templates.materialui;

public class SnackbarElement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _action;
	private Object _anchorOrigin;
	private Object _autoHideDuration;
	private Object _classes;
	private Object _className;
	private Object _ClickAwayListenerProps;
	private Object _ContentProps;
	private Object _disableWindowBlurListener;
	private Object _id;
	private Object _key;
	private Object _message;
	private Object _onClose;
	private Object _onEnter;
	private Object _onEntered;
	private Object _onEntering;
	private Object _onExit;
	private Object _onExited;
	private Object _onExiting;
	private Object _open;
	private Object _resumeHideDuration;
	private Object _style;
	private Object _TransitionComponent;
	private Object _transitionDuration;
	private Object _TransitionProps;
	private java.util.List<Object> _children = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _attribute = new java.util.ArrayList<>();

	SnackbarElement(org.stringtemplate.v4.STGroup stGroup) {
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
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("SnackbarElement");
		st.add("action", _action);
		st.add("anchorOrigin", _anchorOrigin);
		st.add("autoHideDuration", _autoHideDuration);
		st.add("classes", _classes);
		st.add("className", _className);
		st.add("ClickAwayListenerProps", _ClickAwayListenerProps);
		st.add("ContentProps", _ContentProps);
		st.add("disableWindowBlurListener", _disableWindowBlurListener);
		st.add("id", _id);
		st.add("key", _key);
		st.add("message", _message);
		st.add("onClose", _onClose);
		st.add("onEnter", _onEnter);
		st.add("onEntered", _onEntered);
		st.add("onEntering", _onEntering);
		st.add("onExit", _onExit);
		st.add("onExited", _onExited);
		st.add("onExiting", _onExiting);
		st.add("open", _open);
		st.add("resumeHideDuration", _resumeHideDuration);
		st.add("style", _style);
		st.add("TransitionComponent", _TransitionComponent);
		st.add("transitionDuration", _transitionDuration);
		st.add("TransitionProps", _TransitionProps);
		for (Object o : _children) st.add("children", o);
		for (java.util.Map<String, Object> map : _attribute) st.addAggr("attribute.{name,value}", map.get("name"), map.get("value"));
		return st.render().trim();
	}

	public SnackbarElement setAction(Object value) {
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

	public SnackbarElement removeAction() {
		this._action = null;
		return this;
	} 

	public SnackbarElement setAnchorOrigin(Object value) {
		this._anchorOrigin = value;
		return this;
	}

	public Object getAnchorOrigin() {
		return this._anchorOrigin;
	}

	public Object getAnchorOrigin(Object defaultValue) {
		return this._anchorOrigin == null ? defaultValue : this._anchorOrigin;
	}

	public boolean hasAnchorOrigin() {
		return this._anchorOrigin != null;
	}

	public SnackbarElement removeAnchorOrigin() {
		this._anchorOrigin = null;
		return this;
	} 

	public SnackbarElement setAutoHideDuration(Object value) {
		this._autoHideDuration = value;
		return this;
	}

	public Object getAutoHideDuration() {
		return this._autoHideDuration;
	}

	public Object getAutoHideDuration(Object defaultValue) {
		return this._autoHideDuration == null ? defaultValue : this._autoHideDuration;
	}

	public boolean hasAutoHideDuration() {
		return this._autoHideDuration != null;
	}

	public SnackbarElement removeAutoHideDuration() {
		this._autoHideDuration = null;
		return this;
	} 

	public SnackbarElement setClasses(Object value) {
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

	public SnackbarElement removeClasses() {
		this._classes = null;
		return this;
	} 

	public SnackbarElement setClassName(Object value) {
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

	public SnackbarElement removeClassName() {
		this._className = null;
		return this;
	} 

	public SnackbarElement setClickAwayListenerProps(Object value) {
		this._ClickAwayListenerProps = value;
		return this;
	}

	public Object getClickAwayListenerProps() {
		return this._ClickAwayListenerProps;
	}

	public Object getClickAwayListenerProps(Object defaultValue) {
		return this._ClickAwayListenerProps == null ? defaultValue : this._ClickAwayListenerProps;
	}

	public boolean hasClickAwayListenerProps() {
		return this._ClickAwayListenerProps != null;
	}

	public SnackbarElement removeClickAwayListenerProps() {
		this._ClickAwayListenerProps = null;
		return this;
	} 

	public SnackbarElement setContentProps(Object value) {
		this._ContentProps = value;
		return this;
	}

	public Object getContentProps() {
		return this._ContentProps;
	}

	public Object getContentProps(Object defaultValue) {
		return this._ContentProps == null ? defaultValue : this._ContentProps;
	}

	public boolean hasContentProps() {
		return this._ContentProps != null;
	}

	public SnackbarElement removeContentProps() {
		this._ContentProps = null;
		return this;
	} 

	public SnackbarElement setDisableWindowBlurListener(Object value) {
		this._disableWindowBlurListener = value;
		return this;
	}

	public Object getDisableWindowBlurListener() {
		return this._disableWindowBlurListener;
	}

	public Object getDisableWindowBlurListener(Object defaultValue) {
		return this._disableWindowBlurListener == null ? defaultValue : this._disableWindowBlurListener;
	}

	public boolean hasDisableWindowBlurListener() {
		return this._disableWindowBlurListener != null;
	}

	public SnackbarElement removeDisableWindowBlurListener() {
		this._disableWindowBlurListener = null;
		return this;
	} 

	public SnackbarElement setId(Object value) {
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

	public SnackbarElement removeId() {
		this._id = null;
		return this;
	} 

	public SnackbarElement setKey(Object value) {
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

	public SnackbarElement removeKey() {
		this._key = null;
		return this;
	} 

	public SnackbarElement setMessage(Object value) {
		this._message = value;
		return this;
	}

	public Object getMessage() {
		return this._message;
	}

	public Object getMessage(Object defaultValue) {
		return this._message == null ? defaultValue : this._message;
	}

	public boolean hasMessage() {
		return this._message != null;
	}

	public SnackbarElement removeMessage() {
		this._message = null;
		return this;
	} 

	public SnackbarElement setOnClose(Object value) {
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

	public SnackbarElement removeOnClose() {
		this._onClose = null;
		return this;
	} 

	public SnackbarElement setOnEnter(Object value) {
		this._onEnter = value;
		return this;
	}

	public Object getOnEnter() {
		return this._onEnter;
	}

	public Object getOnEnter(Object defaultValue) {
		return this._onEnter == null ? defaultValue : this._onEnter;
	}

	public boolean hasOnEnter() {
		return this._onEnter != null;
	}

	public SnackbarElement removeOnEnter() {
		this._onEnter = null;
		return this;
	} 

	public SnackbarElement setOnEntered(Object value) {
		this._onEntered = value;
		return this;
	}

	public Object getOnEntered() {
		return this._onEntered;
	}

	public Object getOnEntered(Object defaultValue) {
		return this._onEntered == null ? defaultValue : this._onEntered;
	}

	public boolean hasOnEntered() {
		return this._onEntered != null;
	}

	public SnackbarElement removeOnEntered() {
		this._onEntered = null;
		return this;
	} 

	public SnackbarElement setOnEntering(Object value) {
		this._onEntering = value;
		return this;
	}

	public Object getOnEntering() {
		return this._onEntering;
	}

	public Object getOnEntering(Object defaultValue) {
		return this._onEntering == null ? defaultValue : this._onEntering;
	}

	public boolean hasOnEntering() {
		return this._onEntering != null;
	}

	public SnackbarElement removeOnEntering() {
		this._onEntering = null;
		return this;
	} 

	public SnackbarElement setOnExit(Object value) {
		this._onExit = value;
		return this;
	}

	public Object getOnExit() {
		return this._onExit;
	}

	public Object getOnExit(Object defaultValue) {
		return this._onExit == null ? defaultValue : this._onExit;
	}

	public boolean hasOnExit() {
		return this._onExit != null;
	}

	public SnackbarElement removeOnExit() {
		this._onExit = null;
		return this;
	} 

	public SnackbarElement setOnExited(Object value) {
		this._onExited = value;
		return this;
	}

	public Object getOnExited() {
		return this._onExited;
	}

	public Object getOnExited(Object defaultValue) {
		return this._onExited == null ? defaultValue : this._onExited;
	}

	public boolean hasOnExited() {
		return this._onExited != null;
	}

	public SnackbarElement removeOnExited() {
		this._onExited = null;
		return this;
	} 

	public SnackbarElement setOnExiting(Object value) {
		this._onExiting = value;
		return this;
	}

	public Object getOnExiting() {
		return this._onExiting;
	}

	public Object getOnExiting(Object defaultValue) {
		return this._onExiting == null ? defaultValue : this._onExiting;
	}

	public boolean hasOnExiting() {
		return this._onExiting != null;
	}

	public SnackbarElement removeOnExiting() {
		this._onExiting = null;
		return this;
	} 

	public SnackbarElement setOpen(Object value) {
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

	public SnackbarElement removeOpen() {
		this._open = null;
		return this;
	} 

	public SnackbarElement setResumeHideDuration(Object value) {
		this._resumeHideDuration = value;
		return this;
	}

	public Object getResumeHideDuration() {
		return this._resumeHideDuration;
	}

	public Object getResumeHideDuration(Object defaultValue) {
		return this._resumeHideDuration == null ? defaultValue : this._resumeHideDuration;
	}

	public boolean hasResumeHideDuration() {
		return this._resumeHideDuration != null;
	}

	public SnackbarElement removeResumeHideDuration() {
		this._resumeHideDuration = null;
		return this;
	} 

	public SnackbarElement setStyle(Object value) {
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

	public SnackbarElement removeStyle() {
		this._style = null;
		return this;
	} 

	public SnackbarElement setTransitionComponent(Object value) {
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

	public SnackbarElement removeTransitionComponent() {
		this._TransitionComponent = null;
		return this;
	} 

	public SnackbarElement setTransitionDuration(Object value) {
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

	public SnackbarElement removeTransitionDuration() {
		this._transitionDuration = null;
		return this;
	} 

	public SnackbarElement setTransitionProps(Object value) {
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

	public SnackbarElement removeTransitionProps() {
		this._TransitionProps = null;
		return this;
	} 

	public SnackbarElement addChildren(Object value) {
		this._children.add(value);
		return this;
	}

	public SnackbarElement setChildren(Object[] value) {
		this._children.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public SnackbarElement setChildren(java.util.Collection<Object> values) {
		this._children.addAll(values);
		return this;
	}

	public SnackbarElement removeChildren(Object value) {
		this._children.remove(value);
		return this;
	}

	public SnackbarElement removeChildren(int index) {
		this._children.remove(index);
		return this;
	}

	public java.util.List<Object> getChildren() {
		return this._children;
	} 

	public SnackbarElement addAttribute(Object _name, Object _value) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		map.put("value", _value);
		this._attribute.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getAttribute() {
		return this._attribute;
	}

	public SnackbarElement addAttribute(SnackbarElement_Attribute value) {
		return addAttribute(value._name, value._value);
	}

	public java.util.stream.Stream<SnackbarElement_Attribute> streamAttribute() {
		return this._attribute.stream().map(SnackbarElement_Attribute::new);
	}

	public static final class SnackbarElement_Attribute {

		Object _name;
		Object _value;

		public SnackbarElement_Attribute(Object _name, Object _value) {
			this._name = _name;
			this._value = _value;
		}

		private SnackbarElement_Attribute(java.util.Map<String, Object> map) {
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
		SnackbarElement that = (SnackbarElement) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "SnackbarElement(action,anchorOrigin,autoHideDuration,classes,className,ClickAwayListenerProps,ContentProps,disableWindowBlurListener,id,key,message,onClose,onEnter,onEntered,onEntering,onExit,onExited,onExiting,open,resumeHideDuration,style,TransitionComponent,transitionDuration,TransitionProps,attribute,children) ::= <<<Snackbar~if(action)~\n" + 
				"	action=~action~~endif~~if(anchorOrigin)~\n" + 
				"	anchorOrigin=\"~anchorOrigin~\"~endif~~if(autoHideDuration)~\n" + 
				"	autoHideDuration=~autoHideDuration~~endif~~if(classes)~\n" + 
				"	classes=~classes~~endif~~if(className)~\n" + 
				"	className=~className~~endif~~if(ClickAwayListenerProps)~\n" + 
				"	ClickAwayListenerProps=~ClickAwayListenerProps~~endif~~if(ContentProps)~\n" + 
				"	ContentProps=~ContentProps~~endif~~if(disableWindowBlurListener)~\n" + 
				"	disableWindowBlurListener~endif~~if(id)~\n" + 
				"	id=\"~id~\"~endif~~if(key)~\n" + 
				"	key=~key~~endif~~if(message)~\n" + 
				"	message=~message~~endif~~if(onClose)~\n" + 
				"	onClose=~onClose~~endif~~if(onEnter)~\n" + 
				"	onEnter=~onEnter~~endif~~if(onEntered)~\n" + 
				"	onEntered=~onEntered~~endif~~if(onEntering)~\n" + 
				"	onEntering=~onEntering~~endif~~if(onExit)~\n" + 
				"	onExit=~onExit~~endif~~if(onExited)~\n" + 
				"	onExited=~onExited~~endif~~if(onExiting)~\n" + 
				"	onExiting=~onExiting~~endif~~if(open)~\n" + 
				"	open~endif~~if(resumeHideDuration)~\n" + 
				"	resumeHideDuration=~resumeHideDuration~~endif~~if(style)~\n" + 
				"	style=~style~~endif~~if(TransitionComponent)~\n" + 
				"	TransitionComponent=~TransitionComponent~~endif~~if(transitionDuration)~\n" + 
				"	transitionDuration=~transitionDuration~~endif~~if(TransitionProps)~\n" + 
				"	TransitionProps=~TransitionProps~~endif~~attribute:{it|\n" + 
				"	\n" + 
				"	~it.name~=~it.value~}~~if(children)~>\n" + 
				"	~children:{it|~it~};separator=\"\\n\"~\n" + 
				"</Snackbar>~else~ />~endif~ >>";
}  