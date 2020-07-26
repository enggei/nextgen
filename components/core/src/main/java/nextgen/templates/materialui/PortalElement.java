package nextgen.templates.materialui;

public class PortalElement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _className;
	private Object _container;
	private Object _disablePortal;
	private Object _onRendered;
	private java.util.List<Object> _children = new java.util.ArrayList<>();

	PortalElement(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("PortalElement");
		st.add("className", _className);
		st.add("container", _container);
		st.add("disablePortal", _disablePortal);
		st.add("onRendered", _onRendered);
		for (Object o : _children) st.add("children", o);
		return st.render().trim();
	}

	public PortalElement setClassName(Object value) {
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

	public PortalElement removeClassName() {
		this._className = null;
		return this;
	} 

	public PortalElement setContainer(Object value) {
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

	public PortalElement removeContainer() {
		this._container = null;
		return this;
	} 

	public PortalElement setDisablePortal(Object value) {
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

	public PortalElement removeDisablePortal() {
		this._disablePortal = null;
		return this;
	} 

	public PortalElement setOnRendered(Object value) {
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

	public PortalElement removeOnRendered() {
		this._onRendered = null;
		return this;
	} 

	public PortalElement addChildren(Object value) {
		this._children.add(value);
		return this;
	}

	public PortalElement setChildren(Object[] value) {
		this._children.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public PortalElement setChildren(java.util.Collection<Object> values) {
		this._children.addAll(values);
		return this;
	}

	public PortalElement removeChildren(Object value) {
		this._children.remove(value);
		return this;
	}

	public PortalElement removeChildren(int index) {
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
		PortalElement that = (PortalElement) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "PortalElement(className,container,disablePortal,onRendered,children) ::= <<<Portal~if(className)~\n" + 
				"	className=~className~~endif~~if(container)~\n" + 
				"	container=~container~~endif~~if(disablePortal)~\n" + 
				"	disablePortal~endif~~if(onRendered)~\n" + 
				"	onRendered=~onRendered~~endif~~if(children)~>\n" + 
				"	~children:{it|~it~};separator=\"\\n\"~\n" + 
				"</Portal>~else~ />~endif~ >>";
}  