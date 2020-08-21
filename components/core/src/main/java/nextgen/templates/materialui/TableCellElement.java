package nextgen.templates.materialui;

public class TableCellElement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _align;
	private Object _classes;
	private Object _className;
	private Object _component;
	private Object _id;
	private Object _key;
	private Object _padding;
	private Object _scope;
	private Object _size;
	private Object _sortDirection;
	private Object _style;
	private Object _variant;
	private java.util.List<Object> _children = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _attribute = new java.util.ArrayList<>();

	TableCellElement(org.stringtemplate.v4.STGroup stGroup) {
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
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("TableCellElement");
		st.add("align", _align);
		st.add("classes", _classes);
		st.add("className", _className);
		st.add("component", _component);
		st.add("id", _id);
		st.add("key", _key);
		st.add("padding", _padding);
		st.add("scope", _scope);
		st.add("size", _size);
		st.add("sortDirection", _sortDirection);
		st.add("style", _style);
		st.add("variant", _variant);
		for (Object o : _children) st.add("children", o);
		for (java.util.Map<String, Object> map : _attribute) st.addAggr("attribute.{name,value}", map.get("name"), map.get("value"));
		return st.render().trim();
	}

	public TableCellElement setAlign(Object value) {
		this._align = value;
		return this;
	}

	public Object getAlign() {
		return this._align;
	}

	public Object getAlign(Object defaultValue) {
		return this._align == null ? defaultValue : this._align;
	}

	public boolean hasAlign() {
		return this._align != null;
	}

	public TableCellElement removeAlign() {
		this._align = null;
		return this;
	} 

	public TableCellElement setClasses(Object value) {
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

	public TableCellElement removeClasses() {
		this._classes = null;
		return this;
	} 

	public TableCellElement setClassName(Object value) {
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

	public TableCellElement removeClassName() {
		this._className = null;
		return this;
	} 

	public TableCellElement setComponent(Object value) {
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

	public TableCellElement removeComponent() {
		this._component = null;
		return this;
	} 

	public TableCellElement setId(Object value) {
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

	public TableCellElement removeId() {
		this._id = null;
		return this;
	} 

	public TableCellElement setKey(Object value) {
		this._key = value;
		return this;
	}

	public Object getKey() {
		return this._key;
	}

	public Object getKey(Object defaultValue) {
		return this._key == null ? defaultValue : this._key;
	}

	public boolean hasKey() {
		return this._key != null;
	}

	public TableCellElement removeKey() {
		this._key = null;
		return this;
	} 

	public TableCellElement setPadding(Object value) {
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

	public TableCellElement removePadding() {
		this._padding = null;
		return this;
	} 

	public TableCellElement setScope(Object value) {
		this._scope = value;
		return this;
	}

	public Object getScope() {
		return this._scope;
	}

	public Object getScope(Object defaultValue) {
		return this._scope == null ? defaultValue : this._scope;
	}

	public boolean hasScope() {
		return this._scope != null;
	}

	public TableCellElement removeScope() {
		this._scope = null;
		return this;
	} 

	public TableCellElement setSize(Object value) {
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

	public TableCellElement removeSize() {
		this._size = null;
		return this;
	} 

	public TableCellElement setSortDirection(Object value) {
		this._sortDirection = value;
		return this;
	}

	public Object getSortDirection() {
		return this._sortDirection;
	}

	public Object getSortDirection(Object defaultValue) {
		return this._sortDirection == null ? defaultValue : this._sortDirection;
	}

	public boolean hasSortDirection() {
		return this._sortDirection != null;
	}

	public TableCellElement removeSortDirection() {
		this._sortDirection = null;
		return this;
	} 

	public TableCellElement setStyle(Object value) {
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

	public TableCellElement removeStyle() {
		this._style = null;
		return this;
	} 

	public TableCellElement setVariant(Object value) {
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

	public TableCellElement removeVariant() {
		this._variant = null;
		return this;
	} 

	public TableCellElement addChildren(Object value) {
		this._children.add(value);
		return this;
	}

	public TableCellElement setChildren(Object[] value) {
		this._children.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public TableCellElement setChildren(java.util.Collection<Object> values) {
		this._children.addAll(values);
		return this;
	}

	public TableCellElement removeChildren(Object value) {
		this._children.remove(value);
		return this;
	}

	public TableCellElement removeChildren(int index) {
		this._children.remove(index);
		return this;
	}

	public java.util.List<Object> getChildren() {
		return this._children;
	} 

	public TableCellElement addAttribute(Object _name, Object _value) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		map.put("value", _value);
		this._attribute.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getAttribute() {
		return this._attribute;
	}

	public TableCellElement addAttribute(TableCellElement_Attribute value) {
		return addAttribute(value._name, value._value);
	}

	public java.util.stream.Stream<TableCellElement_Attribute> streamAttribute() {
		return this._attribute.stream().map(TableCellElement_Attribute::new);
	}

	public static final class TableCellElement_Attribute {

		Object _name;
		Object _value;

		public TableCellElement_Attribute(Object _name, Object _value) {
			this._name = _name;
			this._value = _value;
		}

		private TableCellElement_Attribute(java.util.Map<String, Object> map) {
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
		TableCellElement that = (TableCellElement) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "TableCellElement(align,classes,className,component,id,key,padding,scope,size,sortDirection,style,variant,attribute,children) ::= <<<TableCell~if(align)~\n" + 
				"	align=\"~align~\"~endif~~if(classes)~\n" + 
				"	classes=~classes~~endif~~if(className)~\n" + 
				"	className=~className~~endif~~if(component)~\n" + 
				"	component=~component~~endif~~if(id)~\n" + 
				"	id=\"~id~\"~endif~~if(key)~\n" + 
				"	key=~key~~endif~~if(padding)~\n" + 
				"	padding=\"~padding~\"~endif~~if(scope)~\n" + 
				"	scope=\"~scope~\"~endif~~if(size)~\n" + 
				"	size=\"~size~\"~endif~~if(sortDirection)~\n" + 
				"	sortDirection=\"~sortDirection~\"~endif~~if(style)~\n" + 
				"	style=~style~~endif~~if(variant)~\n" + 
				"	variant=\"~variant~\"~endif~~attribute:{it|\n" + 
				"	\n" + 
				"	~it.name~=~it.value~}~~if(children)~>\n" + 
				"	~children:{it|~it~};separator=\"\\n\"~\n" + 
				"</TableCell>~else~ />~endif~ >>";
}  