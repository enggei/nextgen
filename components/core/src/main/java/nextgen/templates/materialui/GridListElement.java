package nextgen.templates.materialui;

public class GridListElement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _cellHeight;
	private Object _classes;
	private Object _className;
	private Object _cols;
	private Object _component;
	private Object _spacing;
	private java.util.List<Object> _children = new java.util.ArrayList<>();

	GridListElement(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("GridListElement");
		st.add("cellHeight", _cellHeight);
		st.add("classes", _classes);
		st.add("className", _className);
		st.add("cols", _cols);
		st.add("component", _component);
		st.add("spacing", _spacing);
		for (Object o : _children) st.add("children", o);
		return st.render().trim();
	}

	public GridListElement setCellHeight(Object value) {
		this._cellHeight = value;
		return this;
	}

	public Object getCellHeight() {
		return this._cellHeight;
	}

	public Object getCellHeight(Object defaultValue) {
		return this._cellHeight == null ? defaultValue : this._cellHeight;
	}

	public boolean hasCellHeight() {
		return this._cellHeight != null;
	}

	public GridListElement removeCellHeight() {
		this._cellHeight = null;
		return this;
	} 

	public GridListElement setClasses(Object value) {
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

	public GridListElement removeClasses() {
		this._classes = null;
		return this;
	} 

	public GridListElement setClassName(Object value) {
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

	public GridListElement removeClassName() {
		this._className = null;
		return this;
	} 

	public GridListElement setCols(Object value) {
		this._cols = value;
		return this;
	}

	public Object getCols() {
		return this._cols;
	}

	public Object getCols(Object defaultValue) {
		return this._cols == null ? defaultValue : this._cols;
	}

	public boolean hasCols() {
		return this._cols != null;
	}

	public GridListElement removeCols() {
		this._cols = null;
		return this;
	} 

	public GridListElement setComponent(Object value) {
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

	public GridListElement removeComponent() {
		this._component = null;
		return this;
	} 

	public GridListElement setSpacing(Object value) {
		this._spacing = value;
		return this;
	}

	public Object getSpacing() {
		return this._spacing;
	}

	public Object getSpacing(Object defaultValue) {
		return this._spacing == null ? defaultValue : this._spacing;
	}

	public boolean hasSpacing() {
		return this._spacing != null;
	}

	public GridListElement removeSpacing() {
		this._spacing = null;
		return this;
	} 

	public GridListElement addChildren(Object value) {
		this._children.add(value);
		return this;
	}

	public GridListElement setChildren(Object[] value) {
		this._children.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public GridListElement setChildren(java.util.Collection<Object> values) {
		this._children.addAll(values);
		return this;
	}

	public GridListElement removeChildren(Object value) {
		this._children.remove(value);
		return this;
	}

	public GridListElement removeChildren(int index) {
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
		GridListElement that = (GridListElement) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "GridListElement(cellHeight,classes,className,cols,component,spacing,children) ::= <<<GridList~if(cellHeight)~\n" + 
				"	cellHeight=\"~cellHeight~\"~endif~~if(classes)~\n" + 
				"	classes=~classes~~endif~~if(className)~\n" + 
				"	className=~className~~endif~~if(cols)~\n" + 
				"	cols=~cols~~endif~~if(component)~\n" + 
				"	component=~component~~endif~~if(spacing)~\n" + 
				"	spacing=~spacing~~endif~~if(children)~>\n" + 
				"	~children:{it|~it~};separator=\"\\n\"~\n" + 
				"</GridList>~else~ />~endif~ >>";
}  