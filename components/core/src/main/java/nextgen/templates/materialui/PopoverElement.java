package nextgen.templates.materialui;

public class PopoverElement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _action;
	private Object _anchorEl;
	private Object _anchorOrigin;
	private Object _anchorPosition;
	private Object _anchorReference;
	private Object _classes;
	private Object _className;
	private Object _container;
	private Object _elevation;
	private Object _getContentAnchorEl;
	private Object _id;
	private Object _marginThreshold;
	private Object _onClose;
	private Object _onEnter;
	private Object _onEntered;
	private Object _onEntering;
	private Object _onExit;
	private Object _onExited;
	private Object _onExiting;
	private Object _PaperProps;
	private Object _transformOrigin;
	private Object _TransitionComponent;
	private Object _transitionDuration;
	private Object _TransitionProps;
	private java.util.List<Object> _children = new java.util.ArrayList<>();

	PopoverElement(org.stringtemplate.v4.STGroup stGroup) {
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
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("PopoverElement");
		st.add("action", _action);
		st.add("anchorEl", _anchorEl);
		st.add("anchorOrigin", _anchorOrigin);
		st.add("anchorPosition", _anchorPosition);
		st.add("anchorReference", _anchorReference);
		st.add("classes", _classes);
		st.add("className", _className);
		st.add("container", _container);
		st.add("elevation", _elevation);
		st.add("getContentAnchorEl", _getContentAnchorEl);
		st.add("id", _id);
		st.add("marginThreshold", _marginThreshold);
		st.add("onClose", _onClose);
		st.add("onEnter", _onEnter);
		st.add("onEntered", _onEntered);
		st.add("onEntering", _onEntering);
		st.add("onExit", _onExit);
		st.add("onExited", _onExited);
		st.add("onExiting", _onExiting);
		st.add("PaperProps", _PaperProps);
		st.add("transformOrigin", _transformOrigin);
		st.add("TransitionComponent", _TransitionComponent);
		st.add("transitionDuration", _transitionDuration);
		st.add("TransitionProps", _TransitionProps);
		for (Object o : _children) st.add("children", o);
		return st.render().trim();
	}

	public PopoverElement setAction(Object value) {
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

	public PopoverElement removeAction() {
		this._action = null;
		return this;
	} 

	public PopoverElement setAnchorEl(Object value) {
		this._anchorEl = value;
		return this;
	}

	public Object getAnchorEl() {
		return this._anchorEl;
	}

	public Object getAnchorEl(Object defaultValue) {
		return this._anchorEl == null ? defaultValue : this._anchorEl;
	}

	public boolean hasAnchorEl() {
		return this._anchorEl != null;
	}

	public PopoverElement removeAnchorEl() {
		this._anchorEl = null;
		return this;
	} 

	public PopoverElement setAnchorOrigin(Object value) {
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

	public PopoverElement removeAnchorOrigin() {
		this._anchorOrigin = null;
		return this;
	} 

	public PopoverElement setAnchorPosition(Object value) {
		this._anchorPosition = value;
		return this;
	}

	public Object getAnchorPosition() {
		return this._anchorPosition;
	}

	public Object getAnchorPosition(Object defaultValue) {
		return this._anchorPosition == null ? defaultValue : this._anchorPosition;
	}

	public boolean hasAnchorPosition() {
		return this._anchorPosition != null;
	}

	public PopoverElement removeAnchorPosition() {
		this._anchorPosition = null;
		return this;
	} 

	public PopoverElement setAnchorReference(Object value) {
		this._anchorReference = value;
		return this;
	}

	public Object getAnchorReference() {
		return this._anchorReference;
	}

	public Object getAnchorReference(Object defaultValue) {
		return this._anchorReference == null ? defaultValue : this._anchorReference;
	}

	public boolean hasAnchorReference() {
		return this._anchorReference != null;
	}

	public PopoverElement removeAnchorReference() {
		this._anchorReference = null;
		return this;
	} 

	public PopoverElement setClasses(Object value) {
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

	public PopoverElement removeClasses() {
		this._classes = null;
		return this;
	} 

	public PopoverElement setClassName(Object value) {
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

	public PopoverElement removeClassName() {
		this._className = null;
		return this;
	} 

	public PopoverElement setContainer(Object value) {
		this._container = value;
		return this;
	}

	public Object getContainer() {
		return this._container;
	}

	public Object getContainer(Object defaultValue) {
		return this._container == null ? defaultValue : this._container;
	}

	public boolean hasContainer() {
		return this._container != null;
	}

	public PopoverElement removeContainer() {
		this._container = null;
		return this;
	} 

	public PopoverElement setElevation(Object value) {
		this._elevation = value;
		return this;
	}

	public Object getElevation() {
		return this._elevation;
	}

	public Object getElevation(Object defaultValue) {
		return this._elevation == null ? defaultValue : this._elevation;
	}

	public boolean hasElevation() {
		return this._elevation != null;
	}

	public PopoverElement removeElevation() {
		this._elevation = null;
		return this;
	} 

	public PopoverElement setGetContentAnchorEl(Object value) {
		this._getContentAnchorEl = value;
		return this;
	}

	public Object getGetContentAnchorEl() {
		return this._getContentAnchorEl;
	}

	public Object getGetContentAnchorEl(Object defaultValue) {
		return this._getContentAnchorEl == null ? defaultValue : this._getContentAnchorEl;
	}

	public boolean hasGetContentAnchorEl() {
		return this._getContentAnchorEl != null;
	}

	public PopoverElement removeGetContentAnchorEl() {
		this._getContentAnchorEl = null;
		return this;
	} 

	public PopoverElement setId(Object value) {
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

	public PopoverElement removeId() {
		this._id = null;
		return this;
	} 

	public PopoverElement setMarginThreshold(Object value) {
		this._marginThreshold = value;
		return this;
	}

	public Object getMarginThreshold() {
		return this._marginThreshold;
	}

	public Object getMarginThreshold(Object defaultValue) {
		return this._marginThreshold == null ? defaultValue : this._marginThreshold;
	}

	public boolean hasMarginThreshold() {
		return this._marginThreshold != null;
	}

	public PopoverElement removeMarginThreshold() {
		this._marginThreshold = null;
		return this;
	} 

	public PopoverElement setOnClose(Object value) {
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

	public PopoverElement removeOnClose() {
		this._onClose = null;
		return this;
	} 

	public PopoverElement setOnEnter(Object value) {
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

	public PopoverElement removeOnEnter() {
		this._onEnter = null;
		return this;
	} 

	public PopoverElement setOnEntered(Object value) {
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

	public PopoverElement removeOnEntered() {
		this._onEntered = null;
		return this;
	} 

	public PopoverElement setOnEntering(Object value) {
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

	public PopoverElement removeOnEntering() {
		this._onEntering = null;
		return this;
	} 

	public PopoverElement setOnExit(Object value) {
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

	public PopoverElement removeOnExit() {
		this._onExit = null;
		return this;
	} 

	public PopoverElement setOnExited(Object value) {
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

	public PopoverElement removeOnExited() {
		this._onExited = null;
		return this;
	} 

	public PopoverElement setOnExiting(Object value) {
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

	public PopoverElement removeOnExiting() {
		this._onExiting = null;
		return this;
	} 

	public PopoverElement setPaperProps(Object value) {
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

	public PopoverElement removePaperProps() {
		this._PaperProps = null;
		return this;
	} 

	public PopoverElement setTransformOrigin(Object value) {
		this._transformOrigin = value;
		return this;
	}

	public Object getTransformOrigin() {
		return this._transformOrigin;
	}

	public Object getTransformOrigin(Object defaultValue) {
		return this._transformOrigin == null ? defaultValue : this._transformOrigin;
	}

	public boolean hasTransformOrigin() {
		return this._transformOrigin != null;
	}

	public PopoverElement removeTransformOrigin() {
		this._transformOrigin = null;
		return this;
	} 

	public PopoverElement setTransitionComponent(Object value) {
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

	public PopoverElement removeTransitionComponent() {
		this._TransitionComponent = null;
		return this;
	} 

	public PopoverElement setTransitionDuration(Object value) {
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

	public PopoverElement removeTransitionDuration() {
		this._transitionDuration = null;
		return this;
	} 

	public PopoverElement setTransitionProps(Object value) {
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

	public PopoverElement removeTransitionProps() {
		this._TransitionProps = null;
		return this;
	} 

	public PopoverElement addChildren(Object value) {
		this._children.add(value);
		return this;
	}

	public PopoverElement setChildren(Object[] value) {
		this._children.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public PopoverElement setChildren(java.util.Collection<Object> values) {
		this._children.addAll(values);
		return this;
	}

	public PopoverElement removeChildren(Object value) {
		this._children.remove(value);
		return this;
	}

	public PopoverElement removeChildren(int index) {
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
		PopoverElement that = (PopoverElement) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "PopoverElement(action,anchorEl,anchorOrigin,anchorPosition,anchorReference,classes,className,container,elevation,getContentAnchorEl,id,marginThreshold,onClose,onEnter,onEntered,onEntering,onExit,onExited,onExiting,PaperProps,transformOrigin,TransitionComponent,transitionDuration,TransitionProps,children) ::= <<<Popover~if(action)~\n" + 
				"	action=~action~~endif~~if(anchorEl)~\n" + 
				"	anchorEl=~anchorEl~~endif~~if(anchorOrigin)~\n" + 
				"	anchorOrigin=\"~anchorOrigin~\"~endif~~if(anchorPosition)~\n" + 
				"	anchorPosition=~anchorPosition~~endif~~if(anchorReference)~\n" + 
				"	anchorReference=\"~anchorReference~\"~endif~~if(classes)~\n" + 
				"	classes=~classes~~endif~~if(className)~\n" + 
				"	className=~className~~endif~~if(container)~\n" + 
				"	container=~container~~endif~~if(elevation)~\n" + 
				"	elevation=~elevation~~endif~~if(getContentAnchorEl)~\n" + 
				"	getContentAnchorEl=~getContentAnchorEl~~endif~~if(id)~\n" + 
				"	id=\"~id~\"~endif~~if(marginThreshold)~\n" + 
				"	marginThreshold=~marginThreshold~~endif~~if(onClose)~\n" + 
				"	onClose=~onClose~~endif~~if(onEnter)~\n" + 
				"	onEnter=~onEnter~~endif~~if(onEntered)~\n" + 
				"	onEntered=~onEntered~~endif~~if(onEntering)~\n" + 
				"	onEntering=~onEntering~~endif~~if(onExit)~\n" + 
				"	onExit=~onExit~~endif~~if(onExited)~\n" + 
				"	onExited=~onExited~~endif~~if(onExiting)~\n" + 
				"	onExiting=~onExiting~~endif~\n" + 
				"	open~if(PaperProps)~\n" + 
				"	PaperProps=~PaperProps~~endif~~if(transformOrigin)~\n" + 
				"	transformOrigin=\"~transformOrigin~\"~endif~~if(TransitionComponent)~\n" + 
				"	TransitionComponent=~TransitionComponent~~endif~~if(transitionDuration)~\n" + 
				"	transitionDuration=\"~transitionDuration~\"~endif~~if(TransitionProps)~\n" + 
				"	TransitionProps=~TransitionProps~~endif~~if(children)~>\n" + 
				"	~children:{it|~it~};separator=\"\\n\"~\n" + 
				"</Popover>~else~ />~endif~ >>";
}  