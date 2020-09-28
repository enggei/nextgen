package nextgen.templates.materialui;

public class TableSortLabelElement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _active;
	private Object _classes;
	private Object _className;
	private Object _direction;
	private Object _hideSortIcon;
	private Object _IconComponent;
	private Object _id;
	private Object _key;
	private Object _style;
	private java.util.List<Object> _children = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _attribute = new java.util.ArrayList<>();

	TableSortLabelElement(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("TableSortLabelElement");
		st.add("active", _active);
		st.add("classes", _classes);
		st.add("className", _className);
		st.add("direction", _direction);
		st.add("hideSortIcon", _hideSortIcon);
		st.add("IconComponent", _IconComponent);
		st.add("id", _id);
		st.add("key", _key);
		st.add("style", _style);
		for (Object o : _children) st.add("children", o);
		for (java.util.Map<String, Object> map : _attribute) st.addAggr("attribute.{name,value}", map.get("name"), map.get("value"));
		return st.render().trim();
	}

	public TableSortLabelElement setActive(Object value) {
		this._active = value;
		return this;
	}

	public Object getActive() {
		return this._active;
	}

	public Object getActive(Object defaultValue) {
		return this._active == null ? defaultValue : this._active;
	}

	public boolean hasActive() {
		return this._active != null;
	}

	public TableSortLabelElement removeActive() {
		this._active = null;
		return this;
	} 

	public TableSortLabelElement setClasses(Object value) {
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

	public TableSortLabelElement removeClasses() {
		this._classes = null;
		return this;
	} 

	public TableSortLabelElement setClassName(Object value) {
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

	public TableSortLabelElement removeClassName() {
		this._className = null;
		return this;
	} 

	public TableSortLabelElement setDirection(Object value) {
		this._direction = value;
		return this;
	}

	public Object getDirection() {
		return this._direction;
	}

	public Object getDirection(Object defaultValue) {
		return this._direction == null ? defaultValue : this._direction;
	}

	public boolean hasDirection() {
		return this._direction != null;
	}

	public TableSortLabelElement removeDirection() {
		this._direction = null;
		return this;
	} 

	public TableSortLabelElement setHideSortIcon(Object value) {
		this._hideSortIcon = value;
		return this;
	}

	public Object getHideSortIcon() {
		return this._hideSortIcon;
	}

	public Object getHideSortIcon(Object defaultValue) {
		return this._hideSortIcon == null ? defaultValue : this._hideSortIcon;
	}

	public boolean hasHideSortIcon() {
		return this._hideSortIcon != null;
	}

	public TableSortLabelElement removeHideSortIcon() {
		this._hideSortIcon = null;
		return this;
	} 

	public TableSortLabelElement setIconComponent(Object value) {
		this._IconComponent = value;
		return this;
	}

	public Object getIconComponent() {
		return this._IconComponent;
	}

	public Object getIconComponent(Object defaultValue) {
		return this._IconComponent == null ? defaultValue : this._IconComponent;
	}

	public boolean hasIconComponent() {
		return this._IconComponent != null;
	}

	public TableSortLabelElement removeIconComponent() {
		this._IconComponent = null;
		return this;
	} 

	public TableSortLabelElement setId(Object value) {
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

	public TableSortLabelElement removeId() {
		this._id = null;
		return this;
	} 

	public TableSortLabelElement setKey(Object value) {
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

	public TableSortLabelElement removeKey() {
		this._key = null;
		return this;
	} 

	public TableSortLabelElement setStyle(Object value) {
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

	public TableSortLabelElement removeStyle() {
		this._style = null;
		return this;
	} 

	public TableSortLabelElement addChildren(Object value) {
		this._children.add(value);
		return this;
	}

	public TableSortLabelElement setChildren(Object[] value) {
		this._children.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public TableSortLabelElement setChildren(java.util.Collection<Object> values) {
		this._children.addAll(values);
		return this;
	}

	public TableSortLabelElement removeChildren(Object value) {
		this._children.remove(value);
		return this;
	}

	public TableSortLabelElement removeChildren(int index) {
		this._children.remove(index);
		return this;
	}

	public java.util.List<Object> getChildren() {
		return this._children;
	} 

	public TableSortLabelElement addAttribute(Object _name, Object _value) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		map.put("value", _value);
		this._attribute.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getAttribute() {
		return this._attribute;
	}

	public TableSortLabelElement addAttribute(TableSortLabelElement_Attribute value) {
		return addAttribute(value._name, value._value);
	}

	public java.util.stream.Stream<TableSortLabelElement_Attribute> streamAttribute() {
		return this._attribute.stream().map(TableSortLabelElement_Attribute::new);
	}

	public java.util.List<Object> getAttribute_Name() {
		return streamAttribute().map(TableSortLabelElement_Attribute::getName).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getAttribute_Value() {
		return streamAttribute().map(TableSortLabelElement_Attribute::getValue).collect(java.util.stream.Collectors.toList());
	}


	public static final class TableSortLabelElement_Attribute {

		Object _name;
		Object _value;

		public TableSortLabelElement_Attribute(Object _name, Object _value) {
			this._name = _name;
			this._value = _value;
		}

		private TableSortLabelElement_Attribute(java.util.Map<String, Object> map) {
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
		TableSortLabelElement that = (TableSortLabelElement) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "TableSortLabelElement(active,classes,className,direction,hideSortIcon,IconComponent,id,key,style,attribute,children) ::= <<<TableSortLabel~if(active)~\n" + 
				"	active~endif~~if(classes)~\n" + 
				"	classes=~classes~~endif~~if(className)~\n" + 
				"	className=~className~~endif~~if(direction)~\n" + 
				"	direction=~direction~~endif~~if(hideSortIcon)~\n" + 
				"	hideSortIcon~endif~~if(IconComponent)~\n" + 
				"	IconComponent=~IconComponent~~endif~~if(id)~\n" + 
				"	id=\"~id~\"~endif~~if(key)~\n" + 
				"	key=~key~~endif~~if(style)~\n" + 
				"	style=~style~~endif~~attribute:{it|\n" + 
				"	\n" + 
				"	~it.name~=~it.value~}~~if(children)~>\n" + 
				"	~children:{it|~it~};separator=\"\\n\"~\n" + 
				"</TableSortLabel>~else~ />~endif~ >>";
}  