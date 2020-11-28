package nextgen.templates.materialui;

public class ListItemElement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _alignItems;
	private Object _autoFocus;
	private Object _button;
	private Object _classes;
	private Object _className;
	private Object _component;
	private Object _ContainerComponent;
	private Object _ContainerProps;
	private Object _dense;
	private Object _disabled;
	private Object _disableGutters;
	private Object _divider;
	private Object _id;
	private Object _key;
	private Object _selected;
	private Object _style;
	private java.util.List<Object> _children = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _attribute = new java.util.ArrayList<>();

	ListItemElement(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("ListItemElement");
		st.add("alignItems", _alignItems);
		st.add("autoFocus", _autoFocus);
		st.add("button", _button);
		st.add("classes", _classes);
		st.add("className", _className);
		st.add("component", _component);
		st.add("ContainerComponent", _ContainerComponent);
		st.add("ContainerProps", _ContainerProps);
		st.add("dense", _dense);
		st.add("disabled", _disabled);
		st.add("disableGutters", _disableGutters);
		st.add("divider", _divider);
		st.add("id", _id);
		st.add("key", _key);
		st.add("selected", _selected);
		st.add("style", _style);
		for (Object o : _children) st.add("children", o);
		for (java.util.Map<String, Object> map : _attribute) st.addAggr("attribute.{name,value}", map.get("name"), map.get("value"));
		return st.render().trim();
	}

	public ListItemElement setAlignItems(Object value) {
		this._alignItems = value;
		return this;
	}

	public Object getAlignItems() {
		return this._alignItems;
	}

	public Object getAlignItems(Object defaultValue) {
		return this._alignItems == null ? defaultValue : this._alignItems;
	}

	public boolean hasAlignItems() {
		return this._alignItems != null;
	}

	public ListItemElement removeAlignItems() {
		this._alignItems = null;
		return this;
	} 

	public ListItemElement setAutoFocus(Object value) {
		this._autoFocus = value;
		return this;
	}

	public Object getAutoFocus() {
		return this._autoFocus;
	}

	public Object getAutoFocus(Object defaultValue) {
		return this._autoFocus == null ? defaultValue : this._autoFocus;
	}

	public boolean hasAutoFocus() {
		return this._autoFocus != null;
	}

	public ListItemElement removeAutoFocus() {
		this._autoFocus = null;
		return this;
	} 

	public ListItemElement setButton(Object value) {
		this._button = value;
		return this;
	}

	public Object getButton() {
		return this._button;
	}

	public Object getButton(Object defaultValue) {
		return this._button == null ? defaultValue : this._button;
	}

	public boolean hasButton() {
		return this._button != null;
	}

	public ListItemElement removeButton() {
		this._button = null;
		return this;
	} 

	public ListItemElement setClasses(Object value) {
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

	public ListItemElement removeClasses() {
		this._classes = null;
		return this;
	} 

	public ListItemElement setClassName(Object value) {
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

	public ListItemElement removeClassName() {
		this._className = null;
		return this;
	} 

	public ListItemElement setComponent(Object value) {
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

	public ListItemElement removeComponent() {
		this._component = null;
		return this;
	} 

	public ListItemElement setContainerComponent(Object value) {
		this._ContainerComponent = value;
		return this;
	}

	public Object getContainerComponent() {
		return this._ContainerComponent;
	}

	public Object getContainerComponent(Object defaultValue) {
		return this._ContainerComponent == null ? defaultValue : this._ContainerComponent;
	}

	public boolean hasContainerComponent() {
		return this._ContainerComponent != null;
	}

	public ListItemElement removeContainerComponent() {
		this._ContainerComponent = null;
		return this;
	} 

	public ListItemElement setContainerProps(Object value) {
		this._ContainerProps = value;
		return this;
	}

	public Object getContainerProps() {
		return this._ContainerProps;
	}

	public Object getContainerProps(Object defaultValue) {
		return this._ContainerProps == null ? defaultValue : this._ContainerProps;
	}

	public boolean hasContainerProps() {
		return this._ContainerProps != null;
	}

	public ListItemElement removeContainerProps() {
		this._ContainerProps = null;
		return this;
	} 

	public ListItemElement setDense(Object value) {
		this._dense = value;
		return this;
	}

	public Object getDense() {
		return this._dense;
	}

	public Object getDense(Object defaultValue) {
		return this._dense == null ? defaultValue : this._dense;
	}

	public boolean hasDense() {
		return this._dense != null;
	}

	public ListItemElement removeDense() {
		this._dense = null;
		return this;
	} 

	public ListItemElement setDisabled(Object value) {
		this._disabled = value;
		return this;
	}

	public Object getDisabled() {
		return this._disabled;
	}

	public Object getDisabled(Object defaultValue) {
		return this._disabled == null ? defaultValue : this._disabled;
	}

	public boolean hasDisabled() {
		return this._disabled != null;
	}

	public ListItemElement removeDisabled() {
		this._disabled = null;
		return this;
	} 

	public ListItemElement setDisableGutters(Object value) {
		this._disableGutters = value;
		return this;
	}

	public Object getDisableGutters() {
		return this._disableGutters;
	}

	public Object getDisableGutters(Object defaultValue) {
		return this._disableGutters == null ? defaultValue : this._disableGutters;
	}

	public boolean hasDisableGutters() {
		return this._disableGutters != null;
	}

	public ListItemElement removeDisableGutters() {
		this._disableGutters = null;
		return this;
	} 

	public ListItemElement setDivider(Object value) {
		this._divider = value;
		return this;
	}

	public Object getDivider() {
		return this._divider;
	}

	public Object getDivider(Object defaultValue) {
		return this._divider == null ? defaultValue : this._divider;
	}

	public boolean hasDivider() {
		return this._divider != null;
	}

	public ListItemElement removeDivider() {
		this._divider = null;
		return this;
	} 

	public ListItemElement setId(Object value) {
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

	public ListItemElement removeId() {
		this._id = null;
		return this;
	} 

	public ListItemElement setKey(Object value) {
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

	public ListItemElement removeKey() {
		this._key = null;
		return this;
	} 

	public ListItemElement setSelected(Object value) {
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

	public ListItemElement removeSelected() {
		this._selected = null;
		return this;
	} 

	public ListItemElement setStyle(Object value) {
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

	public ListItemElement removeStyle() {
		this._style = null;
		return this;
	} 

	public ListItemElement addChildren(Object value) {
		this._children.add(value);
		return this;
	}

	public ListItemElement setChildren(Object[] value) {
		this._children.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public ListItemElement setChildren(java.util.Collection<Object> values) {
		this._children.addAll(values);
		return this;
	}

	public ListItemElement removeChildren(Object value) {
		this._children.remove(value);
		return this;
	}

	public ListItemElement removeChildren(int index) {
		this._children.remove(index);
		return this;
	}

	public java.util.List<Object> getChildren() {
		return this._children;
	} 

	public ListItemElement addAttribute(Object _name, Object _value) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		map.put("value", _value);
		this._attribute.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getAttribute() {
		return this._attribute;
	}

	public ListItemElement addAttribute(ListItemElement_Attribute value) {
		return addAttribute(value._name, value._value);
	}

	public java.util.stream.Stream<ListItemElement_Attribute> streamAttribute() {
		return this._attribute.stream().map(ListItemElement_Attribute::new);
	}

	public java.util.List<Object> getAttribute_Name() {
		return streamAttribute().map(ListItemElement_Attribute::getName).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getAttribute_Value() {
		return streamAttribute().map(ListItemElement_Attribute::getValue).collect(java.util.stream.Collectors.toList());
	}


	public static final class ListItemElement_Attribute {

		Object _name;
		Object _value;

		public ListItemElement_Attribute(Object _name, Object _value) {
			this._name = _name;
			this._value = _value;
		}

		private ListItemElement_Attribute(java.util.Map<String, Object> map) {
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
		ListItemElement that = (ListItemElement) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "ListItemElement(alignItems,autoFocus,button,classes,className,component,ContainerComponent,ContainerProps,dense,disabled,disableGutters,divider,id,key,selected,style,attribute,children) ::= <<<ListItem~if(alignItems)~\n" + 
				"	alignItems=~alignItems~~endif~~if(autoFocus)~\n" + 
				"	autoFocus~endif~~if(button)~\n" + 
				"	button~endif~~if(classes)~\n" + 
				"	classes=~classes~~endif~~if(className)~\n" + 
				"	className=~className~~endif~~if(component)~\n" + 
				"	component=~component~~endif~~if(ContainerComponent)~\n" + 
				"	ContainerComponent=~ContainerComponent~~endif~~if(ContainerProps)~\n" + 
				"	ContainerProps=~ContainerProps~~endif~~if(dense)~\n" + 
				"	dense~endif~~if(disabled)~\n" + 
				"	disabled~endif~~if(disableGutters)~\n" + 
				"	disableGutters~endif~~if(divider)~\n" + 
				"	divider~endif~~if(id)~\n" + 
				"	id=\"~id~\"~endif~~if(key)~\n" + 
				"	key=~key~~endif~~if(selected)~\n" + 
				"	selected~endif~~if(style)~\n" + 
				"	style=~style~~endif~~attribute:{it|\n" + 
				"	\n" + 
				"	~it.name~=~it.value~}~~if(children)~>\n" + 
				"	~children:{it|~it~};separator=\"\\n\"~\n" + 
				"</ListItem>~else~ />~endif~ >>";
}  