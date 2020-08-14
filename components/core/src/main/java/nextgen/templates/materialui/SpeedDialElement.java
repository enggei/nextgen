package nextgen.templates.materialui;

public class SpeedDialElement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _ariaLabel;
	private Object _classes;
	private Object _className;
	private Object _direction;
	private Object _FabProps;
	private Object _hidden;
	private Object _icon;
	private Object _id;
	private Object _onClose;
	private Object _onOpen;
	private Object _openIcon;
	private Object _TransitionComponent;
	private Object _transitionDuration;
	private Object _TransitionProps;
	private java.util.List<Object> _children = new java.util.ArrayList<>();

	SpeedDialElement(org.stringtemplate.v4.STGroup stGroup) {
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
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("SpeedDialElement");
		st.add("ariaLabel", _ariaLabel);
		st.add("classes", _classes);
		st.add("className", _className);
		st.add("direction", _direction);
		st.add("FabProps", _FabProps);
		st.add("hidden", _hidden);
		st.add("icon", _icon);
		st.add("id", _id);
		st.add("onClose", _onClose);
		st.add("onOpen", _onOpen);
		st.add("openIcon", _openIcon);
		st.add("TransitionComponent", _TransitionComponent);
		st.add("transitionDuration", _transitionDuration);
		st.add("TransitionProps", _TransitionProps);
		for (Object o : _children) st.add("children", o);
		return st.render().trim();
	}

	public SpeedDialElement setAriaLabel(Object value) {
		this._ariaLabel = value;
		return this;
	}

	public Object getAriaLabel() {
		return this._ariaLabel;
	}

	public Object getAriaLabel(Object defaultValue) {
		return this._ariaLabel == null ? defaultValue : this._ariaLabel;
	}

	public boolean hasAriaLabel() {
		return this._ariaLabel != null;
	}

	public SpeedDialElement removeAriaLabel() {
		this._ariaLabel = null;
		return this;
	} 

	public SpeedDialElement setClasses(Object value) {
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

	public SpeedDialElement removeClasses() {
		this._classes = null;
		return this;
	} 

	public SpeedDialElement setClassName(Object value) {
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

	public SpeedDialElement removeClassName() {
		this._className = null;
		return this;
	} 

	public SpeedDialElement setDirection(Object value) {
		this._direction = value;
		return this;
	}

	public Object getDirection() {
		return this._direction;
	}

	public Object getDirection(Object defaultValue) {
		return this._direction == null ? defaultValue : this._direction;
	}

	public boolean hasDirection() {
		return this._direction != null;
	}

	public SpeedDialElement removeDirection() {
		this._direction = null;
		return this;
	} 

	public SpeedDialElement setFabProps(Object value) {
		this._FabProps = value;
		return this;
	}

	public Object getFabProps() {
		return this._FabProps;
	}

	public Object getFabProps(Object defaultValue) {
		return this._FabProps == null ? defaultValue : this._FabProps;
	}

	public boolean hasFabProps() {
		return this._FabProps != null;
	}

	public SpeedDialElement removeFabProps() {
		this._FabProps = null;
		return this;
	} 

	public SpeedDialElement setHidden(Object value) {
		this._hidden = value;
		return this;
	}

	public Object getHidden() {
		return this._hidden;
	}

	public Object getHidden(Object defaultValue) {
		return this._hidden == null ? defaultValue : this._hidden;
	}

	public boolean hasHidden() {
		return this._hidden != null;
	}

	public SpeedDialElement removeHidden() {
		this._hidden = null;
		return this;
	} 

	public SpeedDialElement setIcon(Object value) {
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

	public SpeedDialElement removeIcon() {
		this._icon = null;
		return this;
	} 

	public SpeedDialElement setId(Object value) {
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

	public SpeedDialElement removeId() {
		this._id = null;
		return this;
	} 

	public SpeedDialElement setOnClose(Object value) {
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

	public SpeedDialElement removeOnClose() {
		this._onClose = null;
		return this;
	} 

	public SpeedDialElement setOnOpen(Object value) {
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

	public SpeedDialElement removeOnOpen() {
		this._onOpen = null;
		return this;
	} 

	public SpeedDialElement setOpenIcon(Object value) {
		this._openIcon = value;
		return this;
	}

	public Object getOpenIcon() {
		return this._openIcon;
	}

	public Object getOpenIcon(Object defaultValue) {
		return this._openIcon == null ? defaultValue : this._openIcon;
	}

	public boolean hasOpenIcon() {
		return this._openIcon != null;
	}

	public SpeedDialElement removeOpenIcon() {
		this._openIcon = null;
		return this;
	} 

	public SpeedDialElement setTransitionComponent(Object value) {
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

	public SpeedDialElement removeTransitionComponent() {
		this._TransitionComponent = null;
		return this;
	} 

	public SpeedDialElement setTransitionDuration(Object value) {
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

	public SpeedDialElement removeTransitionDuration() {
		this._transitionDuration = null;
		return this;
	} 

	public SpeedDialElement setTransitionProps(Object value) {
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

	public SpeedDialElement removeTransitionProps() {
		this._TransitionProps = null;
		return this;
	} 

	public SpeedDialElement addChildren(Object value) {
		this._children.add(value);
		return this;
	}

	public SpeedDialElement setChildren(Object[] value) {
		this._children.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public SpeedDialElement setChildren(java.util.Collection<Object> values) {
		this._children.addAll(values);
		return this;
	}

	public SpeedDialElement removeChildren(Object value) {
		this._children.remove(value);
		return this;
	}

	public SpeedDialElement removeChildren(int index) {
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
		SpeedDialElement that = (SpeedDialElement) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "SpeedDialElement(ariaLabel,classes,className,direction,FabProps,hidden,icon,id,onClose,onOpen,openIcon,TransitionComponent,transitionDuration,TransitionProps,children) ::= <<<SpeedDial\n" + 
				"	ariaLabel=\"~ariaLabel~\"~if(classes)~\n" + 
				"	classes=~classes~~endif~~if(className)~\n" + 
				"	className=~className~~endif~~if(direction)~\n" + 
				"	direction=\"~direction~\"~endif~~if(FabProps)~\n" + 
				"	FabProps=~FabProps~~endif~~if(hidden)~\n" + 
				"	hidden~endif~~if(icon)~\n" + 
				"	icon=~icon~~endif~~if(id)~\n" + 
				"	id=\"~id~\"~endif~~if(onClose)~\n" + 
				"	onClose=~onClose~~endif~~if(onOpen)~\n" + 
				"	onOpen=~onOpen~~endif~\n" + 
				"	open~if(openIcon)~\n" + 
				"	openIcon=~openIcon~~endif~~if(TransitionComponent)~\n" + 
				"	TransitionComponent=~TransitionComponent~~endif~~if(transitionDuration)~\n" + 
				"	transitionDuration=~transitionDuration~~endif~~if(TransitionProps)~\n" + 
				"	TransitionProps=~TransitionProps~~endif~~if(children)~>\n" + 
				"	~children:{it|~it~};separator=\"\\n\"~\n" + 
				"</SpeedDial>~else~ />~endif~ >>";
}  