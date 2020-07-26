package nextgen.templates.materialui;

public class TableElement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _classes;
	private Object _className;
	private Object _component;
	private Object _padding;
	private Object _size;
	private Object _stickyHeader;
	private java.util.List<Object> _children = new java.util.ArrayList<>();

	TableElement(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("TableElement");
		st.add("classes", _classes);
		st.add("className", _className);
		st.add("component", _component);
		st.add("padding", _padding);
		st.add("size", _size);
		st.add("stickyHeader", _stickyHeader);
		for (Object o : _children) st.add("children", o);
		return st.render().trim();
	}

	public TableElement setClasses(Object value) {
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

	public TableElement removeClasses() {
		this._classes = null;
		return this;
	} 

	public TableElement setClassName(Object value) {
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

	public TableElement removeClassName() {
		this._className = null;
		return this;
	} 

	public TableElement setComponent(Object value) {
		this._component = value;
		return this;
	}

	public Object getComponent() {
		return this._component;
	}

	public Object getComponent(Object defaultValue) {
		return this._component == null ? defaultValue : this._component;
	}

	public boolean hasComponent() {
		return this._component != null;
	}

	public TableElement removeComponent() {
		this._component = null;
		return this;
	} 

	public TableElement setPadding(Object value) {
		this._padding = value;
		return this;
	}

	public Object getPadding() {
		return this._padding;
	}

	public Object getPadding(Object defaultValue) {
		return this._padding == null ? defaultValue : this._padding;
	}

	public boolean hasPadding() {
		return this._padding != null;
	}

	public TableElement removePadding() {
		this._padding = null;
		return this;
	} 

	public TableElement setSize(Object value) {
		this._size = value;
		return this;
	}

	public Object getSize() {
		return this._size;
	}

	public Object getSize(Object defaultValue) {
		return this._size == null ? defaultValue : this._size;
	}

	public boolean hasSize() {
		return this._size != null;
	}

	public TableElement removeSize() {
		this._size = null;
		return this;
	} 

	public TableElement setStickyHeader(Object value) {
		this._stickyHeader = value;
		return this;
	}

	public Object getStickyHeader() {
		return this._stickyHeader;
	}

	public Object getStickyHeader(Object defaultValue) {
		return this._stickyHeader == null ? defaultValue : this._stickyHeader;
	}

	public boolean hasStickyHeader() {
		return this._stickyHeader != null;
	}

	public TableElement removeStickyHeader() {
		this._stickyHeader = null;
		return this;
	} 

	public TableElement addChildren(Object value) {
		this._children.add(value);
		return this;
	}

	public TableElement setChildren(Object[] value) {
		this._children.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public TableElement setChildren(java.util.Collection<Object> values) {
		this._children.addAll(values);
		return this;
	}

	public TableElement removeChildren(Object value) {
		this._children.remove(value);
		return this;
	}

	public TableElement removeChildren(int index) {
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
		TableElement that = (TableElement) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "TableElement(classes,className,component,padding,size,stickyHeader,children) ::= <<<Table~if(classes)~\n" + 
				"	classes=~classes~~endif~~if(className)~\n" + 
				"	className=~className~~endif~~if(component)~\n" + 
				"	component=~component~~endif~~if(padding)~\n" + 
				"	padding=\"~padding~\"~endif~~if(size)~\n" + 
				"	size=\"~size~\"~endif~~if(stickyHeader)~\n" + 
				"	stickyHeader~endif~~if(children)~>\n" + 
				"	~children:{it|~it~};separator=\"\\n\"~\n" + 
				"</Table>~else~ />~endif~ >>";
}  