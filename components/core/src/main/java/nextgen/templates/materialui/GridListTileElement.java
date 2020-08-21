package nextgen.templates.materialui;

public class GridListTileElement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _classes;
	private Object _className;
	private Object _cols;
	private Object _component;
	private Object _id;
	private Object _rows;
	private Object _style;
	private java.util.List<Object> _children = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _attribute = new java.util.ArrayList<>();

	GridListTileElement(org.stringtemplate.v4.STGroup stGroup) {
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
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("GridListTileElement");
		st.add("classes", _classes);
		st.add("className", _className);
		st.add("cols", _cols);
		st.add("component", _component);
		st.add("id", _id);
		st.add("rows", _rows);
		st.add("style", _style);
		for (Object o : _children) st.add("children", o);
		for (java.util.Map<String, Object> map : _attribute) st.addAggr("attribute.{name,value}", map.get("name"), map.get("value"));
		return st.render().trim();
	}

	public GridListTileElement setClasses(Object value) {
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

	public GridListTileElement removeClasses() {
		this._classes = null;
		return this;
	} 

	public GridListTileElement setClassName(Object value) {
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

	public GridListTileElement removeClassName() {
		this._className = null;
		return this;
	} 

	public GridListTileElement setCols(Object value) {
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

	public GridListTileElement removeCols() {
		this._cols = null;
		return this;
	} 

	public GridListTileElement setComponent(Object value) {
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

	public GridListTileElement removeComponent() {
		this._component = null;
		return this;
	} 

	public GridListTileElement setId(Object value) {
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

	public GridListTileElement removeId() {
		this._id = null;
		return this;
	} 

	public GridListTileElement setRows(Object value) {
		this._rows = value;
		return this;
	}

	public Object getRows() {
		return this._rows;
	}

	public Object getRows(Object defaultValue) {
		return this._rows == null ? defaultValue : this._rows;
	}

	public boolean hasRows() {
		return this._rows != null;
	}

	public GridListTileElement removeRows() {
		this._rows = null;
		return this;
	} 

	public GridListTileElement setStyle(Object value) {
		this._style = value;
		return this;
	}

	public Object getStyle() {
		return this._style;
	}

	public Object getStyle(Object defaultValue) {
		return this._style == null ? defaultValue : this._style;
	}

	public boolean hasStyle() {
		return this._style != null;
	}

	public GridListTileElement removeStyle() {
		this._style = null;
		return this;
	} 

	public GridListTileElement addChildren(Object value) {
		this._children.add(value);
		return this;
	}

	public GridListTileElement setChildren(Object[] value) {
		this._children.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public GridListTileElement setChildren(java.util.Collection<Object> values) {
		this._children.addAll(values);
		return this;
	}

	public GridListTileElement removeChildren(Object value) {
		this._children.remove(value);
		return this;
	}

	public GridListTileElement removeChildren(int index) {
		this._children.remove(index);
		return this;
	}

	public java.util.List<Object> getChildren() {
		return this._children;
	} 

	public GridListTileElement addAttribute(Object _name, Object _value) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		map.put("value", _value);
		this._attribute.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getAttribute() {
		return this._attribute;
	}

	public GridListTileElement addAttribute(GridListTileElement_Attribute value) {
		return addAttribute(value._name, value._value);
	}

	public java.util.stream.Stream<GridListTileElement_Attribute> streamAttribute() {
		return this._attribute.stream().map(GridListTileElement_Attribute::new);
	}

	public static final class GridListTileElement_Attribute {

		Object _name;
		Object _value;

		public GridListTileElement_Attribute(Object _name, Object _value) {
			this._name = _name;
			this._value = _value;
		}

		private GridListTileElement_Attribute(java.util.Map<String, Object> map) {
			this._name = (Object) map.get("name");
			this._value = (Object) map.get("value");
		}

		public Object getName() {
			return this._name;
		}

		public Object getValue() {
			return this._value;
		}

	} 

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		GridListTileElement that = (GridListTileElement) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "GridListTileElement(classes,className,cols,component,id,rows,style,attribute,children) ::= <<<GridListTile~if(classes)~\n" + 
				"	classes=~classes~~endif~~if(className)~\n" + 
				"	className=~className~~endif~~if(cols)~\n" + 
				"	cols=~cols~~endif~~if(component)~\n" + 
				"	component=~component~~endif~~if(id)~\n" + 
				"	id=\"~id~\"~endif~~if(rows)~\n" + 
				"	rows=~rows~~endif~~if(style)~\n" + 
				"	style=~style~~endif~~attribute:{it|\n" + 
				"	\n" + 
				"	~it.name~=~it.value~}~~if(children)~>\n" + 
				"	~children:{it|~it~};separator=\"\\n\"~\n" + 
				"</GridListTile>~else~ />~endif~ >>";
}  