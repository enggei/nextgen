package nextgen.templates.materialui;

public class TableRowElement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _classes;
	private Object _className;
	private Object _component;
	private Object _hover;
	private Object _selected;
	private java.util.List<Object> _children = new java.util.ArrayList<>();

	TableRowElement(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("TableRowElement");
		st.add("classes", _classes);
		st.add("className", _className);
		st.add("component", _component);
		st.add("hover", _hover);
		st.add("selected", _selected);
		for (Object o : _children) st.add("children", o);
		return st.render().trim();
	}

	public TableRowElement setClasses(Object value) {
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

	public TableRowElement removeClasses() {
		this._classes = null;
		return this;
	} 

	public TableRowElement setClassName(Object value) {
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

	public TableRowElement removeClassName() {
		this._className = null;
		return this;
	} 

	public TableRowElement setComponent(Object value) {
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

	public TableRowElement removeComponent() {
		this._component = null;
		return this;
	} 

	public TableRowElement setHover(Object value) {
		this._hover = value;
		return this;
	}

	public Object getHover() {
		return this._hover;
	}

	public Object getHover(Object defaultValue) {
		return this._hover == null ? defaultValue : this._hover;
	}

	public boolean hasHover() {
		return this._hover != null;
	}

	public TableRowElement removeHover() {
		this._hover = null;
		return this;
	} 

	public TableRowElement setSelected(Object value) {
		this._selected = value;
		return this;
	}

	public Object getSelected() {
		return this._selected;
	}

	public Object getSelected(Object defaultValue) {
		return this._selected == null ? defaultValue : this._selected;
	}

	public boolean hasSelected() {
		return this._selected != null;
	}

	public TableRowElement removeSelected() {
		this._selected = null;
		return this;
	} 

	public TableRowElement addChildren(Object value) {
		this._children.add(value);
		return this;
	}

	public TableRowElement setChildren(Object[] value) {
		this._children.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public TableRowElement setChildren(java.util.Collection<Object> values) {
		this._children.addAll(values);
		return this;
	}

	public TableRowElement removeChildren(Object value) {
		this._children.remove(value);
		return this;
	}

	public TableRowElement removeChildren(int index) {
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
		TableRowElement that = (TableRowElement) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "TableRowElement(classes,className,component,hover,selected,children) ::= <<<TableRow~if(classes)~\n" + 
				"	classes=~classes~~endif~~if(className)~\n" + 
				"	className=~className~~endif~~if(component)~\n" + 
				"	component=~component~~endif~~if(hover)~\n" + 
				"	hover~endif~~if(selected)~\n" + 
				"	selected~endif~~if(children)~>\n" + 
				"	~children:{it|~it~};separator=\"\\n\"~\n" + 
				"</TableRow>~else~ />~endif~ >>";
}  