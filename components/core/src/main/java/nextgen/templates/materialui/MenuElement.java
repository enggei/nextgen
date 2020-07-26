package nextgen.templates.materialui;

public class MenuElement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _anchorEl;
	private Object _autoFocus;
	private Object _classes;
	private Object _className;
	private Object _disableAutoFocusItem;
	private Object _MenuListProps;
	private Object _onClose;
	private Object _onEnter;
	private Object _onEntered;
	private Object _onEntering;
	private Object _onExit;
	private Object _onExited;
	private Object _onExiting;
	private Object _PopoverClasses;
	private Object _transitionDuration;
	private Object _variant;
	private java.util.List<Object> _children = new java.util.ArrayList<>();

	MenuElement(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("MenuElement");
		st.add("anchorEl", _anchorEl);
		st.add("autoFocus", _autoFocus);
		st.add("classes", _classes);
		st.add("className", _className);
		st.add("disableAutoFocusItem", _disableAutoFocusItem);
		st.add("MenuListProps", _MenuListProps);
		st.add("onClose", _onClose);
		st.add("onEnter", _onEnter);
		st.add("onEntered", _onEntered);
		st.add("onEntering", _onEntering);
		st.add("onExit", _onExit);
		st.add("onExited", _onExited);
		st.add("onExiting", _onExiting);
		st.add("PopoverClasses", _PopoverClasses);
		st.add("transitionDuration", _transitionDuration);
		st.add("variant", _variant);
		for (Object o : _children) st.add("children", o);
		return st.render().trim();
	}

	public MenuElement setAnchorEl(Object value) {
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

	public MenuElement removeAnchorEl() {
		this._anchorEl = null;
		return this;
	} 

	public MenuElement setAutoFocus(Object value) {
		this._autoFocus = value;
		return this;
	}

	public Object getAutoFocus() {
		return this._autoFocus;
	}

	public Object getAutoFocus(Object defaultValue) {
		return this._autoFocus == null ? defaultValue : this._autoFocus;
	}

	public boolean hasAutoFocus() {
		return this._autoFocus != null;
	}

	public MenuElement removeAutoFocus() {
		this._autoFocus = null;
		return this;
	} 

	public MenuElement setClasses(Object value) {
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

	public MenuElement removeClasses() {
		this._classes = null;
		return this;
	} 

	public MenuElement setClassName(Object value) {
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

	public MenuElement removeClassName() {
		this._className = null;
		return this;
	} 

	public MenuElement setDisableAutoFocusItem(Object value) {
		this._disableAutoFocusItem = value;
		return this;
	}

	public Object getDisableAutoFocusItem() {
		return this._disableAutoFocusItem;
	}

	public Object getDisableAutoFocusItem(Object defaultValue) {
		return this._disableAutoFocusItem == null ? defaultValue : this._disableAutoFocusItem;
	}

	public boolean hasDisableAutoFocusItem() {
		return this._disableAutoFocusItem != null;
	}

	public MenuElement removeDisableAutoFocusItem() {
		this._disableAutoFocusItem = null;
		return this;
	} 

	public MenuElement setMenuListProps(Object value) {
		this._MenuListProps = value;
		return this;
	}

	public Object getMenuListProps() {
		return this._MenuListProps;
	}

	public Object getMenuListProps(Object defaultValue) {
		return this._MenuListProps == null ? defaultValue : this._MenuListProps;
	}

	public boolean hasMenuListProps() {
		return this._MenuListProps != null;
	}

	public MenuElement removeMenuListProps() {
		this._MenuListProps = null;
		return this;
	} 

	public MenuElement setOnClose(Object value) {
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

	public MenuElement removeOnClose() {
		this._onClose = null;
		return this;
	} 

	public MenuElement setOnEnter(Object value) {
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

	public MenuElement removeOnEnter() {
		this._onEnter = null;
		return this;
	} 

	public MenuElement setOnEntered(Object value) {
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

	public MenuElement removeOnEntered() {
		this._onEntered = null;
		return this;
	} 

	public MenuElement setOnEntering(Object value) {
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

	public MenuElement removeOnEntering() {
		this._onEntering = null;
		return this;
	} 

	public MenuElement setOnExit(Object value) {
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

	public MenuElement removeOnExit() {
		this._onExit = null;
		return this;
	} 

	public MenuElement setOnExited(Object value) {
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

	public MenuElement removeOnExited() {
		this._onExited = null;
		return this;
	} 

	public MenuElement setOnExiting(Object value) {
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

	public MenuElement removeOnExiting() {
		this._onExiting = null;
		return this;
	} 

	public MenuElement setPopoverClasses(Object value) {
		this._PopoverClasses = value;
		return this;
	}

	public Object getPopoverClasses() {
		return this._PopoverClasses;
	}

	public Object getPopoverClasses(Object defaultValue) {
		return this._PopoverClasses == null ? defaultValue : this._PopoverClasses;
	}

	public boolean hasPopoverClasses() {
		return this._PopoverClasses != null;
	}

	public MenuElement removePopoverClasses() {
		this._PopoverClasses = null;
		return this;
	} 

	public MenuElement setTransitionDuration(Object value) {
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

	public MenuElement removeTransitionDuration() {
		this._transitionDuration = null;
		return this;
	} 

	public MenuElement setVariant(Object value) {
		this._variant = value;
		return this;
	}

	public Object getVariant() {
		return this._variant;
	}

	public Object getVariant(Object defaultValue) {
		return this._variant == null ? defaultValue : this._variant;
	}

	public boolean hasVariant() {
		return this._variant != null;
	}

	public MenuElement removeVariant() {
		this._variant = null;
		return this;
	} 

	public MenuElement addChildren(Object value) {
		this._children.add(value);
		return this;
	}

	public MenuElement setChildren(Object[] value) {
		this._children.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public MenuElement setChildren(java.util.Collection<Object> values) {
		this._children.addAll(values);
		return this;
	}

	public MenuElement removeChildren(Object value) {
		this._children.remove(value);
		return this;
	}

	public MenuElement removeChildren(int index) {
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
		MenuElement that = (MenuElement) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "MenuElement(anchorEl,autoFocus,classes,className,disableAutoFocusItem,MenuListProps,onClose,onEnter,onEntered,onEntering,onExit,onExited,onExiting,PopoverClasses,transitionDuration,variant,children) ::= <<<Menu~if(anchorEl)~\n" + 
				"	anchorEl=~anchorEl~~endif~~if(autoFocus)~\n" + 
				"	autoFocus~endif~~if(classes)~\n" + 
				"	classes=~classes~~endif~~if(className)~\n" + 
				"	className=~className~~endif~~if(disableAutoFocusItem)~\n" + 
				"	disableAutoFocusItem~endif~~if(MenuListProps)~\n" + 
				"	MenuListProps=~MenuListProps~~endif~~if(onClose)~\n" + 
				"	onClose=~onClose~~endif~~if(onEnter)~\n" + 
				"	onEnter=~onEnter~~endif~~if(onEntered)~\n" + 
				"	onEntered=~onEntered~~endif~~if(onEntering)~\n" + 
				"	onEntering=~onEntering~~endif~~if(onExit)~\n" + 
				"	onExit=~onExit~~endif~~if(onExited)~\n" + 
				"	onExited=~onExited~~endif~~if(onExiting)~\n" + 
				"	onExiting=~onExiting~~endif~\n" + 
				"	open~if(PopoverClasses)~\n" + 
				"	PopoverClasses=~PopoverClasses~~endif~~if(transitionDuration)~\n" + 
				"	transitionDuration=\"~transitionDuration~\"~endif~~if(variant)~\n" + 
				"	variant=\"~variant~\"~endif~~if(children)~>\n" + 
				"	~children:{it|~it~};separator=\"\\n\"~\n" + 
				"</Menu>~else~ />~endif~ >>";
}  