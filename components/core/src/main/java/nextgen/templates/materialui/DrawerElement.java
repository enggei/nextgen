package nextgen.templates.materialui;

public class DrawerElement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _anchor;
	private Object _classes;
	private Object _className;
	private Object _elevation;
	private Object _ModalProps;
	private Object _onClose;
	private Object _open;
	private Object _PaperProps;
	private Object _SlideProps;
	private Object _transitionDuration;
	private Object _variant;
	private java.util.List<Object> _children = new java.util.ArrayList<>();

	DrawerElement(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("DrawerElement");
		st.add("anchor", _anchor);
		st.add("classes", _classes);
		st.add("className", _className);
		st.add("elevation", _elevation);
		st.add("ModalProps", _ModalProps);
		st.add("onClose", _onClose);
		st.add("open", _open);
		st.add("PaperProps", _PaperProps);
		st.add("SlideProps", _SlideProps);
		st.add("transitionDuration", _transitionDuration);
		st.add("variant", _variant);
		for (Object o : _children) st.add("children", o);
		return st.render().trim();
	}

	public DrawerElement setAnchor(Object value) {
		this._anchor = value;
		return this;
	}

	public Object getAnchor() {
		return this._anchor;
	}

	public Object getAnchor(Object defaultValue) {
		return this._anchor == null ? defaultValue : this._anchor;
	}

	public boolean hasAnchor() {
		return this._anchor != null;
	}

	public DrawerElement removeAnchor() {
		this._anchor = null;
		return this;
	} 

	public DrawerElement setClasses(Object value) {
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

	public DrawerElement removeClasses() {
		this._classes = null;
		return this;
	} 

	public DrawerElement setClassName(Object value) {
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

	public DrawerElement removeClassName() {
		this._className = null;
		return this;
	} 

	public DrawerElement setElevation(Object value) {
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

	public DrawerElement removeElevation() {
		this._elevation = null;
		return this;
	} 

	public DrawerElement setModalProps(Object value) {
		this._ModalProps = value;
		return this;
	}

	public Object getModalProps() {
		return this._ModalProps;
	}

	public Object getModalProps(Object defaultValue) {
		return this._ModalProps == null ? defaultValue : this._ModalProps;
	}

	public boolean hasModalProps() {
		return this._ModalProps != null;
	}

	public DrawerElement removeModalProps() {
		this._ModalProps = null;
		return this;
	} 

	public DrawerElement setOnClose(Object value) {
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

	public DrawerElement removeOnClose() {
		this._onClose = null;
		return this;
	} 

	public DrawerElement setOpen(Object value) {
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

	public DrawerElement removeOpen() {
		this._open = null;
		return this;
	} 

	public DrawerElement setPaperProps(Object value) {
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

	public DrawerElement removePaperProps() {
		this._PaperProps = null;
		return this;
	} 

	public DrawerElement setSlideProps(Object value) {
		this._SlideProps = value;
		return this;
	}

	public Object getSlideProps() {
		return this._SlideProps;
	}

	public Object getSlideProps(Object defaultValue) {
		return this._SlideProps == null ? defaultValue : this._SlideProps;
	}

	public boolean hasSlideProps() {
		return this._SlideProps != null;
	}

	public DrawerElement removeSlideProps() {
		this._SlideProps = null;
		return this;
	} 

	public DrawerElement setTransitionDuration(Object value) {
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

	public DrawerElement removeTransitionDuration() {
		this._transitionDuration = null;
		return this;
	} 

	public DrawerElement setVariant(Object value) {
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

	public DrawerElement removeVariant() {
		this._variant = null;
		return this;
	} 

	public DrawerElement addChildren(Object value) {
		this._children.add(value);
		return this;
	}

	public DrawerElement setChildren(Object[] value) {
		this._children.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public DrawerElement setChildren(java.util.Collection<Object> values) {
		this._children.addAll(values);
		return this;
	}

	public DrawerElement removeChildren(Object value) {
		this._children.remove(value);
		return this;
	}

	public DrawerElement removeChildren(int index) {
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
		DrawerElement that = (DrawerElement) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "DrawerElement(anchor,classes,className,elevation,ModalProps,onClose,open,PaperProps,SlideProps,transitionDuration,variant,children) ::= <<<Drawer~if(anchor)~\n" + 
				"	anchor=\"~anchor~\"~endif~~if(classes)~\n" + 
				"	classes=~classes~~endif~~if(className)~\n" + 
				"	className=~className~~endif~~if(elevation)~\n" + 
				"	elevation=~elevation~~endif~~if(ModalProps)~\n" + 
				"	ModalProps=~ModalProps~~endif~~if(onClose)~\n" + 
				"	onClose=~onClose~~endif~~if(open)~\n" + 
				"	open~endif~~if(PaperProps)~\n" + 
				"	PaperProps=~PaperProps~~endif~~if(SlideProps)~\n" + 
				"	SlideProps=~SlideProps~~endif~~if(transitionDuration)~\n" + 
				"	transitionDuration=~transitionDuration~~endif~~if(variant)~\n" + 
				"	variant=\"~variant~\"~endif~~if(children)~>\n" + 
				"	~children:{it|~it~};separator=\"\\n\"~\n" + 
				"</Drawer>~else~ />~endif~ >>";
}  