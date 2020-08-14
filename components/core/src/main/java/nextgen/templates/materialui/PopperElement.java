package nextgen.templates.materialui;

public class PopperElement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _anchorEl;
	private Object _className;
	private Object _container;
	private Object _disablePortal;
	private Object _id;
	private Object _keepMounted;
	private Object _modifiers;
	private Object _placement;
	private Object _popperOptions;
	private Object _popperRef;
	private Object _transition;
	private java.util.List<Object> _children = new java.util.ArrayList<>();

	PopperElement(org.stringtemplate.v4.STGroup stGroup) {
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
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("PopperElement");
		st.add("anchorEl", _anchorEl);
		st.add("className", _className);
		st.add("container", _container);
		st.add("disablePortal", _disablePortal);
		st.add("id", _id);
		st.add("keepMounted", _keepMounted);
		st.add("modifiers", _modifiers);
		st.add("placement", _placement);
		st.add("popperOptions", _popperOptions);
		st.add("popperRef", _popperRef);
		st.add("transition", _transition);
		for (Object o : _children) st.add("children", o);
		return st.render().trim();
	}

	public PopperElement setAnchorEl(Object value) {
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

	public PopperElement removeAnchorEl() {
		this._anchorEl = null;
		return this;
	} 

	public PopperElement setClassName(Object value) {
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

	public PopperElement removeClassName() {
		this._className = null;
		return this;
	} 

	public PopperElement setContainer(Object value) {
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

	public PopperElement removeContainer() {
		this._container = null;
		return this;
	} 

	public PopperElement setDisablePortal(Object value) {
		this._disablePortal = value;
		return this;
	}

	public Object getDisablePortal() {
		return this._disablePortal;
	}

	public Object getDisablePortal(Object defaultValue) {
		return this._disablePortal == null ? defaultValue : this._disablePortal;
	}

	public boolean hasDisablePortal() {
		return this._disablePortal != null;
	}

	public PopperElement removeDisablePortal() {
		this._disablePortal = null;
		return this;
	} 

	public PopperElement setId(Object value) {
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

	public PopperElement removeId() {
		this._id = null;
		return this;
	} 

	public PopperElement setKeepMounted(Object value) {
		this._keepMounted = value;
		return this;
	}

	public Object getKeepMounted() {
		return this._keepMounted;
	}

	public Object getKeepMounted(Object defaultValue) {
		return this._keepMounted == null ? defaultValue : this._keepMounted;
	}

	public boolean hasKeepMounted() {
		return this._keepMounted != null;
	}

	public PopperElement removeKeepMounted() {
		this._keepMounted = null;
		return this;
	} 

	public PopperElement setModifiers(Object value) {
		this._modifiers = value;
		return this;
	}

	public Object getModifiers() {
		return this._modifiers;
	}

	public Object getModifiers(Object defaultValue) {
		return this._modifiers == null ? defaultValue : this._modifiers;
	}

	public boolean hasModifiers() {
		return this._modifiers != null;
	}

	public PopperElement removeModifiers() {
		this._modifiers = null;
		return this;
	} 

	public PopperElement setPlacement(Object value) {
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

	public PopperElement removePlacement() {
		this._placement = null;
		return this;
	} 

	public PopperElement setPopperOptions(Object value) {
		this._popperOptions = value;
		return this;
	}

	public Object getPopperOptions() {
		return this._popperOptions;
	}

	public Object getPopperOptions(Object defaultValue) {
		return this._popperOptions == null ? defaultValue : this._popperOptions;
	}

	public boolean hasPopperOptions() {
		return this._popperOptions != null;
	}

	public PopperElement removePopperOptions() {
		this._popperOptions = null;
		return this;
	} 

	public PopperElement setPopperRef(Object value) {
		this._popperRef = value;
		return this;
	}

	public Object getPopperRef() {
		return this._popperRef;
	}

	public Object getPopperRef(Object defaultValue) {
		return this._popperRef == null ? defaultValue : this._popperRef;
	}

	public boolean hasPopperRef() {
		return this._popperRef != null;
	}

	public PopperElement removePopperRef() {
		this._popperRef = null;
		return this;
	} 

	public PopperElement setTransition(Object value) {
		this._transition = value;
		return this;
	}

	public Object getTransition() {
		return this._transition;
	}

	public Object getTransition(Object defaultValue) {
		return this._transition == null ? defaultValue : this._transition;
	}

	public boolean hasTransition() {
		return this._transition != null;
	}

	public PopperElement removeTransition() {
		this._transition = null;
		return this;
	} 

	public PopperElement addChildren(Object value) {
		this._children.add(value);
		return this;
	}

	public PopperElement setChildren(Object[] value) {
		this._children.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public PopperElement setChildren(java.util.Collection<Object> values) {
		this._children.addAll(values);
		return this;
	}

	public PopperElement removeChildren(Object value) {
		this._children.remove(value);
		return this;
	}

	public PopperElement removeChildren(int index) {
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
		PopperElement that = (PopperElement) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "PopperElement(anchorEl,className,container,disablePortal,id,keepMounted,modifiers,placement,popperOptions,popperRef,transition,children) ::= <<<Popper~if(anchorEl)~\n" + 
				"	anchorEl=~anchorEl~~endif~~if(className)~\n" + 
				"	className=~className~~endif~~if(container)~\n" + 
				"	container=~container~~endif~~if(disablePortal)~\n" + 
				"	disablePortal~endif~~if(id)~\n" + 
				"	id=\"~id~\"~endif~~if(keepMounted)~\n" + 
				"	keepMounted~endif~~if(modifiers)~\n" + 
				"	modifiers=~modifiers~~endif~\n" + 
				"	open~if(placement)~\n" + 
				"	placement=\"~placement~\"~endif~~if(popperOptions)~\n" + 
				"	popperOptions=~popperOptions~~endif~~if(popperRef)~\n" + 
				"	popperRef=~popperRef~~endif~~if(transition)~\n" + 
				"	transition~endif~~if(children)~>\n" + 
				"	~children:{it|~it~};separator=\"\\n\"~\n" + 
				"</Popper>~else~ />~endif~ >>";
}  