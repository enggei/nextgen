package nextgen.templates.materialui;

public class DialogElement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _ariaDescribedby;
	private Object _ariaLabelledby;
	private Object _classes;
	private Object _className;
	private Object _disableBackdropClick;
	private Object _disableEscapeKeyDown;
	private Object _fullScreen;
	private Object _fullWidth;
	private Object _id;
	private Object _key;
	private Object _maxWidth;
	private Object _onBackdropClick;
	private Object _onClose;
	private Object _onEnter;
	private Object _onEntered;
	private Object _onEntering;
	private Object _onEscapeKeyDown;
	private Object _onExit;
	private Object _onExited;
	private Object _onExiting;
	private Object _PaperComponent;
	private Object _PaperProps;
	private Object _scroll;
	private Object _style;
	private Object _TransitionComponent;
	private Object _transitionDuration;
	private Object _TransitionProps;
	private java.util.List<Object> _children = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _attribute = new java.util.ArrayList<>();

	DialogElement(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("DialogElement");
		st.add("ariaDescribedby", _ariaDescribedby);
		st.add("ariaLabelledby", _ariaLabelledby);
		st.add("classes", _classes);
		st.add("className", _className);
		st.add("disableBackdropClick", _disableBackdropClick);
		st.add("disableEscapeKeyDown", _disableEscapeKeyDown);
		st.add("fullScreen", _fullScreen);
		st.add("fullWidth", _fullWidth);
		st.add("id", _id);
		st.add("key", _key);
		st.add("maxWidth", _maxWidth);
		st.add("onBackdropClick", _onBackdropClick);
		st.add("onClose", _onClose);
		st.add("onEnter", _onEnter);
		st.add("onEntered", _onEntered);
		st.add("onEntering", _onEntering);
		st.add("onEscapeKeyDown", _onEscapeKeyDown);
		st.add("onExit", _onExit);
		st.add("onExited", _onExited);
		st.add("onExiting", _onExiting);
		st.add("PaperComponent", _PaperComponent);
		st.add("PaperProps", _PaperProps);
		st.add("scroll", _scroll);
		st.add("style", _style);
		st.add("TransitionComponent", _TransitionComponent);
		st.add("transitionDuration", _transitionDuration);
		st.add("TransitionProps", _TransitionProps);
		for (Object o : _children) st.add("children", o);
		for (java.util.Map<String, Object> map : _attribute) st.addAggr("attribute.{name,value}", map.get("name"), map.get("value"));
		return st.render().trim();
	}

	public DialogElement setAriaDescribedby(Object value) {
		this._ariaDescribedby = value;
		return this;
	}

	public Object getAriaDescribedby() {
		return this._ariaDescribedby;
	}

	public Object getAriaDescribedby(Object defaultValue) {
		return this._ariaDescribedby == null ? defaultValue : this._ariaDescribedby;
	}

	public boolean hasAriaDescribedby() {
		return this._ariaDescribedby != null;
	}

	public DialogElement removeAriaDescribedby() {
		this._ariaDescribedby = null;
		return this;
	} 

	public DialogElement setAriaLabelledby(Object value) {
		this._ariaLabelledby = value;
		return this;
	}

	public Object getAriaLabelledby() {
		return this._ariaLabelledby;
	}

	public Object getAriaLabelledby(Object defaultValue) {
		return this._ariaLabelledby == null ? defaultValue : this._ariaLabelledby;
	}

	public boolean hasAriaLabelledby() {
		return this._ariaLabelledby != null;
	}

	public DialogElement removeAriaLabelledby() {
		this._ariaLabelledby = null;
		return this;
	} 

	public DialogElement setClasses(Object value) {
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

	public DialogElement removeClasses() {
		this._classes = null;
		return this;
	} 

	public DialogElement setClassName(Object value) {
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

	public DialogElement removeClassName() {
		this._className = null;
		return this;
	} 

	public DialogElement setDisableBackdropClick(Object value) {
		this._disableBackdropClick = value;
		return this;
	}

	public Object getDisableBackdropClick() {
		return this._disableBackdropClick;
	}

	public Object getDisableBackdropClick(Object defaultValue) {
		return this._disableBackdropClick == null ? defaultValue : this._disableBackdropClick;
	}

	public boolean hasDisableBackdropClick() {
		return this._disableBackdropClick != null;
	}

	public DialogElement removeDisableBackdropClick() {
		this._disableBackdropClick = null;
		return this;
	} 

	public DialogElement setDisableEscapeKeyDown(Object value) {
		this._disableEscapeKeyDown = value;
		return this;
	}

	public Object getDisableEscapeKeyDown() {
		return this._disableEscapeKeyDown;
	}

	public Object getDisableEscapeKeyDown(Object defaultValue) {
		return this._disableEscapeKeyDown == null ? defaultValue : this._disableEscapeKeyDown;
	}

	public boolean hasDisableEscapeKeyDown() {
		return this._disableEscapeKeyDown != null;
	}

	public DialogElement removeDisableEscapeKeyDown() {
		this._disableEscapeKeyDown = null;
		return this;
	} 

	public DialogElement setFullScreen(Object value) {
		this._fullScreen = value;
		return this;
	}

	public Object getFullScreen() {
		return this._fullScreen;
	}

	public Object getFullScreen(Object defaultValue) {
		return this._fullScreen == null ? defaultValue : this._fullScreen;
	}

	public boolean hasFullScreen() {
		return this._fullScreen != null;
	}

	public DialogElement removeFullScreen() {
		this._fullScreen = null;
		return this;
	} 

	public DialogElement setFullWidth(Object value) {
		this._fullWidth = value;
		return this;
	}

	public Object getFullWidth() {
		return this._fullWidth;
	}

	public Object getFullWidth(Object defaultValue) {
		return this._fullWidth == null ? defaultValue : this._fullWidth;
	}

	public boolean hasFullWidth() {
		return this._fullWidth != null;
	}

	public DialogElement removeFullWidth() {
		this._fullWidth = null;
		return this;
	} 

	public DialogElement setId(Object value) {
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

	public DialogElement removeId() {
		this._id = null;
		return this;
	} 

	public DialogElement setKey(Object value) {
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

	public DialogElement removeKey() {
		this._key = null;
		return this;
	} 

	public DialogElement setMaxWidth(Object value) {
		this._maxWidth = value;
		return this;
	}

	public Object getMaxWidth() {
		return this._maxWidth;
	}

	public Object getMaxWidth(Object defaultValue) {
		return this._maxWidth == null ? defaultValue : this._maxWidth;
	}

	public boolean hasMaxWidth() {
		return this._maxWidth != null;
	}

	public DialogElement removeMaxWidth() {
		this._maxWidth = null;
		return this;
	} 

	public DialogElement setOnBackdropClick(Object value) {
		this._onBackdropClick = value;
		return this;
	}

	public Object getOnBackdropClick() {
		return this._onBackdropClick;
	}

	public Object getOnBackdropClick(Object defaultValue) {
		return this._onBackdropClick == null ? defaultValue : this._onBackdropClick;
	}

	public boolean hasOnBackdropClick() {
		return this._onBackdropClick != null;
	}

	public DialogElement removeOnBackdropClick() {
		this._onBackdropClick = null;
		return this;
	} 

	public DialogElement setOnClose(Object value) {
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

	public DialogElement removeOnClose() {
		this._onClose = null;
		return this;
	} 

	public DialogElement setOnEnter(Object value) {
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

	public DialogElement removeOnEnter() {
		this._onEnter = null;
		return this;
	} 

	public DialogElement setOnEntered(Object value) {
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

	public DialogElement removeOnEntered() {
		this._onEntered = null;
		return this;
	} 

	public DialogElement setOnEntering(Object value) {
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

	public DialogElement removeOnEntering() {
		this._onEntering = null;
		return this;
	} 

	public DialogElement setOnEscapeKeyDown(Object value) {
		this._onEscapeKeyDown = value;
		return this;
	}

	public Object getOnEscapeKeyDown() {
		return this._onEscapeKeyDown;
	}

	public Object getOnEscapeKeyDown(Object defaultValue) {
		return this._onEscapeKeyDown == null ? defaultValue : this._onEscapeKeyDown;
	}

	public boolean hasOnEscapeKeyDown() {
		return this._onEscapeKeyDown != null;
	}

	public DialogElement removeOnEscapeKeyDown() {
		this._onEscapeKeyDown = null;
		return this;
	} 

	public DialogElement setOnExit(Object value) {
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

	public DialogElement removeOnExit() {
		this._onExit = null;
		return this;
	} 

	public DialogElement setOnExited(Object value) {
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

	public DialogElement removeOnExited() {
		this._onExited = null;
		return this;
	} 

	public DialogElement setOnExiting(Object value) {
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

	public DialogElement removeOnExiting() {
		this._onExiting = null;
		return this;
	} 

	public DialogElement setPaperComponent(Object value) {
		this._PaperComponent = value;
		return this;
	}

	public Object getPaperComponent() {
		return this._PaperComponent;
	}

	public Object getPaperComponent(Object defaultValue) {
		return this._PaperComponent == null ? defaultValue : this._PaperComponent;
	}

	public boolean hasPaperComponent() {
		return this._PaperComponent != null;
	}

	public DialogElement removePaperComponent() {
		this._PaperComponent = null;
		return this;
	} 

	public DialogElement setPaperProps(Object value) {
		this._PaperProps = value;
		return this;
	}

	public Object getPaperProps() {
		return this._PaperProps;
	}

	public Object getPaperProps(Object defaultValue) {
		return this._PaperProps == null ? defaultValue : this._PaperProps;
	}

	public boolean hasPaperProps() {
		return this._PaperProps != null;
	}

	public DialogElement removePaperProps() {
		this._PaperProps = null;
		return this;
	} 

	public DialogElement setScroll(Object value) {
		this._scroll = value;
		return this;
	}

	public Object getScroll() {
		return this._scroll;
	}

	public Object getScroll(Object defaultValue) {
		return this._scroll == null ? defaultValue : this._scroll;
	}

	public boolean hasScroll() {
		return this._scroll != null;
	}

	public DialogElement removeScroll() {
		this._scroll = null;
		return this;
	} 

	public DialogElement setStyle(Object value) {
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

	public DialogElement removeStyle() {
		this._style = null;
		return this;
	} 

	public DialogElement setTransitionComponent(Object value) {
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

	public DialogElement removeTransitionComponent() {
		this._TransitionComponent = null;
		return this;
	} 

	public DialogElement setTransitionDuration(Object value) {
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

	public DialogElement removeTransitionDuration() {
		this._transitionDuration = null;
		return this;
	} 

	public DialogElement setTransitionProps(Object value) {
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

	public DialogElement removeTransitionProps() {
		this._TransitionProps = null;
		return this;
	} 

	public DialogElement addChildren(Object value) {
		this._children.add(value);
		return this;
	}

	public DialogElement setChildren(Object[] value) {
		this._children.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public DialogElement setChildren(java.util.Collection<Object> values) {
		this._children.addAll(values);
		return this;
	}

	public DialogElement removeChildren(Object value) {
		this._children.remove(value);
		return this;
	}

	public DialogElement removeChildren(int index) {
		this._children.remove(index);
		return this;
	}

	public java.util.List<Object> getChildren() {
		return this._children;
	} 

	public DialogElement addAttribute(Object _name, Object _value) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		map.put("value", _value);
		this._attribute.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getAttribute() {
		return this._attribute;
	}

	public DialogElement addAttribute(DialogElement_Attribute value) {
		return addAttribute(value._name, value._value);
	}

	public java.util.stream.Stream<DialogElement_Attribute> streamAttribute() {
		return this._attribute.stream().map(DialogElement_Attribute::new);
	}

	public java.util.List<Object> getAttribute_Name() {
		return streamAttribute().map(DialogElement_Attribute::getName).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getAttribute_Value() {
		return streamAttribute().map(DialogElement_Attribute::getValue).collect(java.util.stream.Collectors.toList());
	}


	public static final class DialogElement_Attribute {

		Object _name;
		Object _value;

		public DialogElement_Attribute(Object _name, Object _value) {
			this._name = _name;
			this._value = _value;
		}

		private DialogElement_Attribute(java.util.Map<String, Object> map) {
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
		DialogElement that = (DialogElement) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "DialogElement(ariaDescribedby,ariaLabelledby,classes,className,disableBackdropClick,disableEscapeKeyDown,fullScreen,fullWidth,id,key,maxWidth,onBackdropClick,onClose,onEnter,onEntered,onEntering,onEscapeKeyDown,onExit,onExited,onExiting,PaperComponent,PaperProps,scroll,style,TransitionComponent,transitionDuration,TransitionProps,attribute,children) ::= <<<Dialog~if(ariaDescribedby)~\n" + 
				"	ariaDescribedby=\"~ariaDescribedby~\"~endif~~if(ariaLabelledby)~\n" + 
				"	ariaLabelledby=\"~ariaLabelledby~\"~endif~~if(classes)~\n" + 
				"	classes=~classes~~endif~~if(className)~\n" + 
				"	className=~className~~endif~~if(disableBackdropClick)~\n" + 
				"	disableBackdropClick~endif~~if(disableEscapeKeyDown)~\n" + 
				"	disableEscapeKeyDown~endif~~if(fullScreen)~\n" + 
				"	fullScreen~endif~~if(fullWidth)~\n" + 
				"	fullWidth~endif~~if(id)~\n" + 
				"	id=\"~id~\"~endif~~if(key)~\n" + 
				"	key=~key~~endif~~if(maxWidth)~\n" + 
				"	maxWidth=~maxWidth~~endif~~if(onBackdropClick)~\n" + 
				"	onBackdropClick=~onBackdropClick~~endif~~if(onClose)~\n" + 
				"	onClose=~onClose~~endif~~if(onEnter)~\n" + 
				"	onEnter=~onEnter~~endif~~if(onEntered)~\n" + 
				"	onEntered=~onEntered~~endif~~if(onEntering)~\n" + 
				"	onEntering=~onEntering~~endif~~if(onEscapeKeyDown)~\n" + 
				"	onEscapeKeyDown=~onEscapeKeyDown~~endif~~if(onExit)~\n" + 
				"	onExit=~onExit~~endif~~if(onExited)~\n" + 
				"	onExited=~onExited~~endif~~if(onExiting)~\n" + 
				"	onExiting=~onExiting~~endif~\n" + 
				"	open~if(PaperComponent)~\n" + 
				"	PaperComponent=~PaperComponent~~endif~~if(PaperProps)~\n" + 
				"	PaperProps=~PaperProps~~endif~~if(scroll)~\n" + 
				"	scroll=~scroll~~endif~~if(style)~\n" + 
				"	style=~style~~endif~~if(TransitionComponent)~\n" + 
				"	TransitionComponent=~TransitionComponent~~endif~~if(transitionDuration)~\n" + 
				"	transitionDuration=~transitionDuration~~endif~~if(TransitionProps)~\n" + 
				"	TransitionProps=~TransitionProps~~endif~~attribute:{it|\n" + 
				"	\n" + 
				"	~it.name~=~it.value~}~~if(children)~>\n" + 
				"	~children:{it|~it~};separator=\"\\n\"~\n" + 
				"</Dialog>~else~ />~endif~ >>";
}  