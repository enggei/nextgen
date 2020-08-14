package nextgen.templates.materialui;

public class ModalElement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _BackdropComponent;
	private Object _BackdropProps;
	private Object _className;
	private Object _closeAfterTransition;
	private Object _container;
	private Object _disableAutoFocus;
	private Object _disableBackdropClick;
	private Object _disableEnforceFocus;
	private Object _disableEscapeKeyDown;
	private Object _disablePortal;
	private Object _disableRestoreFocus;
	private Object _disableScrollLock;
	private Object _hideBackdrop;
	private Object _id;
	private Object _keepMounted;
	private Object _onBackdropClick;
	private Object _onClose;
	private Object _onEscapeKeyDown;
	private Object _onRendered;
	private java.util.List<Object> _children = new java.util.ArrayList<>();

	ModalElement(org.stringtemplate.v4.STGroup stGroup) {
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
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("ModalElement");
		st.add("BackdropComponent", _BackdropComponent);
		st.add("BackdropProps", _BackdropProps);
		st.add("className", _className);
		st.add("closeAfterTransition", _closeAfterTransition);
		st.add("container", _container);
		st.add("disableAutoFocus", _disableAutoFocus);
		st.add("disableBackdropClick", _disableBackdropClick);
		st.add("disableEnforceFocus", _disableEnforceFocus);
		st.add("disableEscapeKeyDown", _disableEscapeKeyDown);
		st.add("disablePortal", _disablePortal);
		st.add("disableRestoreFocus", _disableRestoreFocus);
		st.add("disableScrollLock", _disableScrollLock);
		st.add("hideBackdrop", _hideBackdrop);
		st.add("id", _id);
		st.add("keepMounted", _keepMounted);
		st.add("onBackdropClick", _onBackdropClick);
		st.add("onClose", _onClose);
		st.add("onEscapeKeyDown", _onEscapeKeyDown);
		st.add("onRendered", _onRendered);
		for (Object o : _children) st.add("children", o);
		return st.render().trim();
	}

	public ModalElement setBackdropComponent(Object value) {
		this._BackdropComponent = value;
		return this;
	}

	public Object getBackdropComponent() {
		return this._BackdropComponent;
	}

	public Object getBackdropComponent(Object defaultValue) {
		return this._BackdropComponent == null ? defaultValue : this._BackdropComponent;
	}

	public boolean hasBackdropComponent() {
		return this._BackdropComponent != null;
	}

	public ModalElement removeBackdropComponent() {
		this._BackdropComponent = null;
		return this;
	} 

	public ModalElement setBackdropProps(Object value) {
		this._BackdropProps = value;
		return this;
	}

	public Object getBackdropProps() {
		return this._BackdropProps;
	}

	public Object getBackdropProps(Object defaultValue) {
		return this._BackdropProps == null ? defaultValue : this._BackdropProps;
	}

	public boolean hasBackdropProps() {
		return this._BackdropProps != null;
	}

	public ModalElement removeBackdropProps() {
		this._BackdropProps = null;
		return this;
	} 

	public ModalElement setClassName(Object value) {
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

	public ModalElement removeClassName() {
		this._className = null;
		return this;
	} 

	public ModalElement setCloseAfterTransition(Object value) {
		this._closeAfterTransition = value;
		return this;
	}

	public Object getCloseAfterTransition() {
		return this._closeAfterTransition;
	}

	public Object getCloseAfterTransition(Object defaultValue) {
		return this._closeAfterTransition == null ? defaultValue : this._closeAfterTransition;
	}

	public boolean hasCloseAfterTransition() {
		return this._closeAfterTransition != null;
	}

	public ModalElement removeCloseAfterTransition() {
		this._closeAfterTransition = null;
		return this;
	} 

	public ModalElement setContainer(Object value) {
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

	public ModalElement removeContainer() {
		this._container = null;
		return this;
	} 

	public ModalElement setDisableAutoFocus(Object value) {
		this._disableAutoFocus = value;
		return this;
	}

	public Object getDisableAutoFocus() {
		return this._disableAutoFocus;
	}

	public Object getDisableAutoFocus(Object defaultValue) {
		return this._disableAutoFocus == null ? defaultValue : this._disableAutoFocus;
	}

	public boolean hasDisableAutoFocus() {
		return this._disableAutoFocus != null;
	}

	public ModalElement removeDisableAutoFocus() {
		this._disableAutoFocus = null;
		return this;
	} 

	public ModalElement setDisableBackdropClick(Object value) {
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

	public ModalElement removeDisableBackdropClick() {
		this._disableBackdropClick = null;
		return this;
	} 

	public ModalElement setDisableEnforceFocus(Object value) {
		this._disableEnforceFocus = value;
		return this;
	}

	public Object getDisableEnforceFocus() {
		return this._disableEnforceFocus;
	}

	public Object getDisableEnforceFocus(Object defaultValue) {
		return this._disableEnforceFocus == null ? defaultValue : this._disableEnforceFocus;
	}

	public boolean hasDisableEnforceFocus() {
		return this._disableEnforceFocus != null;
	}

	public ModalElement removeDisableEnforceFocus() {
		this._disableEnforceFocus = null;
		return this;
	} 

	public ModalElement setDisableEscapeKeyDown(Object value) {
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

	public ModalElement removeDisableEscapeKeyDown() {
		this._disableEscapeKeyDown = null;
		return this;
	} 

	public ModalElement setDisablePortal(Object value) {
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

	public ModalElement removeDisablePortal() {
		this._disablePortal = null;
		return this;
	} 

	public ModalElement setDisableRestoreFocus(Object value) {
		this._disableRestoreFocus = value;
		return this;
	}

	public Object getDisableRestoreFocus() {
		return this._disableRestoreFocus;
	}

	public Object getDisableRestoreFocus(Object defaultValue) {
		return this._disableRestoreFocus == null ? defaultValue : this._disableRestoreFocus;
	}

	public boolean hasDisableRestoreFocus() {
		return this._disableRestoreFocus != null;
	}

	public ModalElement removeDisableRestoreFocus() {
		this._disableRestoreFocus = null;
		return this;
	} 

	public ModalElement setDisableScrollLock(Object value) {
		this._disableScrollLock = value;
		return this;
	}

	public Object getDisableScrollLock() {
		return this._disableScrollLock;
	}

	public Object getDisableScrollLock(Object defaultValue) {
		return this._disableScrollLock == null ? defaultValue : this._disableScrollLock;
	}

	public boolean hasDisableScrollLock() {
		return this._disableScrollLock != null;
	}

	public ModalElement removeDisableScrollLock() {
		this._disableScrollLock = null;
		return this;
	} 

	public ModalElement setHideBackdrop(Object value) {
		this._hideBackdrop = value;
		return this;
	}

	public Object getHideBackdrop() {
		return this._hideBackdrop;
	}

	public Object getHideBackdrop(Object defaultValue) {
		return this._hideBackdrop == null ? defaultValue : this._hideBackdrop;
	}

	public boolean hasHideBackdrop() {
		return this._hideBackdrop != null;
	}

	public ModalElement removeHideBackdrop() {
		this._hideBackdrop = null;
		return this;
	} 

	public ModalElement setId(Object value) {
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

	public ModalElement removeId() {
		this._id = null;
		return this;
	} 

	public ModalElement setKeepMounted(Object value) {
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

	public ModalElement removeKeepMounted() {
		this._keepMounted = null;
		return this;
	} 

	public ModalElement setOnBackdropClick(Object value) {
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

	public ModalElement removeOnBackdropClick() {
		this._onBackdropClick = null;
		return this;
	} 

	public ModalElement setOnClose(Object value) {
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

	public ModalElement removeOnClose() {
		this._onClose = null;
		return this;
	} 

	public ModalElement setOnEscapeKeyDown(Object value) {
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

	public ModalElement removeOnEscapeKeyDown() {
		this._onEscapeKeyDown = null;
		return this;
	} 

	public ModalElement setOnRendered(Object value) {
		this._onRendered = value;
		return this;
	}

	public Object getOnRendered() {
		return this._onRendered;
	}

	public Object getOnRendered(Object defaultValue) {
		return this._onRendered == null ? defaultValue : this._onRendered;
	}

	public boolean hasOnRendered() {
		return this._onRendered != null;
	}

	public ModalElement removeOnRendered() {
		this._onRendered = null;
		return this;
	} 

	public ModalElement addChildren(Object value) {
		this._children.add(value);
		return this;
	}

	public ModalElement setChildren(Object[] value) {
		this._children.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public ModalElement setChildren(java.util.Collection<Object> values) {
		this._children.addAll(values);
		return this;
	}

	public ModalElement removeChildren(Object value) {
		this._children.remove(value);
		return this;
	}

	public ModalElement removeChildren(int index) {
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
		ModalElement that = (ModalElement) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "ModalElement(BackdropComponent,BackdropProps,className,closeAfterTransition,container,disableAutoFocus,disableBackdropClick,disableEnforceFocus,disableEscapeKeyDown,disablePortal,disableRestoreFocus,disableScrollLock,hideBackdrop,id,keepMounted,onBackdropClick,onClose,onEscapeKeyDown,onRendered,children) ::= <<<Modal~if(BackdropComponent)~\n" + 
				"	BackdropComponent=~BackdropComponent~~endif~~if(BackdropProps)~\n" + 
				"	BackdropProps=~BackdropProps~~endif~~if(className)~\n" + 
				"	className=~className~~endif~~if(closeAfterTransition)~\n" + 
				"	closeAfterTransition~endif~~if(container)~\n" + 
				"	container=~container~~endif~~if(disableAutoFocus)~\n" + 
				"	disableAutoFocus~endif~~if(disableBackdropClick)~\n" + 
				"	disableBackdropClick~endif~~if(disableEnforceFocus)~\n" + 
				"	disableEnforceFocus~endif~~if(disableEscapeKeyDown)~\n" + 
				"	disableEscapeKeyDown~endif~~if(disablePortal)~\n" + 
				"	disablePortal~endif~~if(disableRestoreFocus)~\n" + 
				"	disableRestoreFocus~endif~~if(disableScrollLock)~\n" + 
				"	disableScrollLock~endif~~if(hideBackdrop)~\n" + 
				"	hideBackdrop~endif~~if(id)~\n" + 
				"	id=\"~id~\"~endif~~if(keepMounted)~\n" + 
				"	keepMounted~endif~~if(onBackdropClick)~\n" + 
				"	onBackdropClick=~onBackdropClick~~endif~~if(onClose)~\n" + 
				"	onClose=~onClose~~endif~~if(onEscapeKeyDown)~\n" + 
				"	onEscapeKeyDown=~onEscapeKeyDown~~endif~~if(onRendered)~\n" + 
				"	onRendered=~onRendered~~endif~\n" + 
				"	open~if(children)~>\n" + 
				"	~children:{it|~it~};separator=\"\\n\"~\n" + 
				"</Modal>~else~ />~endif~ >>";
}  