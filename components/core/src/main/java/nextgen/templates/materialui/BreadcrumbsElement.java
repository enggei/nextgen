package nextgen.templates.materialui;

public class BreadcrumbsElement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _classes;
	private Object _className;
	private Object _component;
	private Object _expandText;
	private Object _id;
	private Object _itemsAfterCollapse;
	private Object _itemsBeforeCollapse;
	private Object _key;
	private Object _maxItems;
	private Object _separator;
	private Object _style;
	private java.util.List<Object> _children = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _attribute = new java.util.ArrayList<>();

	BreadcrumbsElement(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("BreadcrumbsElement");
		st.add("classes", _classes);
		st.add("className", _className);
		st.add("component", _component);
		st.add("expandText", _expandText);
		st.add("id", _id);
		st.add("itemsAfterCollapse", _itemsAfterCollapse);
		st.add("itemsBeforeCollapse", _itemsBeforeCollapse);
		st.add("key", _key);
		st.add("maxItems", _maxItems);
		st.add("separator", _separator);
		st.add("style", _style);
		for (Object o : _children) st.add("children", o);
		for (java.util.Map<String, Object> map : _attribute) st.addAggr("attribute.{name,value}", map.get("name"), map.get("value"));
		return st.render().trim();
	}

	public BreadcrumbsElement setClasses(Object value) {
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

	public BreadcrumbsElement removeClasses() {
		this._classes = null;
		return this;
	} 

	public BreadcrumbsElement setClassName(Object value) {
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

	public BreadcrumbsElement removeClassName() {
		this._className = null;
		return this;
	} 

	public BreadcrumbsElement setComponent(Object value) {
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

	public BreadcrumbsElement removeComponent() {
		this._component = null;
		return this;
	} 

	public BreadcrumbsElement setExpandText(Object value) {
		this._expandText = value;
		return this;
	}

	public Object getExpandText() {
		return this._expandText;
	}

	public Object getExpandText(Object defaultValue) {
		return this._expandText == null ? defaultValue : this._expandText;
	}

	public boolean hasExpandText() {
		return this._expandText != null;
	}

	public BreadcrumbsElement removeExpandText() {
		this._expandText = null;
		return this;
	} 

	public BreadcrumbsElement setId(Object value) {
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

	public BreadcrumbsElement removeId() {
		this._id = null;
		return this;
	} 

	public BreadcrumbsElement setItemsAfterCollapse(Object value) {
		this._itemsAfterCollapse = value;
		return this;
	}

	public Object getItemsAfterCollapse() {
		return this._itemsAfterCollapse;
	}

	public Object getItemsAfterCollapse(Object defaultValue) {
		return this._itemsAfterCollapse == null ? defaultValue : this._itemsAfterCollapse;
	}

	public boolean hasItemsAfterCollapse() {
		return this._itemsAfterCollapse != null;
	}

	public BreadcrumbsElement removeItemsAfterCollapse() {
		this._itemsAfterCollapse = null;
		return this;
	} 

	public BreadcrumbsElement setItemsBeforeCollapse(Object value) {
		this._itemsBeforeCollapse = value;
		return this;
	}

	public Object getItemsBeforeCollapse() {
		return this._itemsBeforeCollapse;
	}

	public Object getItemsBeforeCollapse(Object defaultValue) {
		return this._itemsBeforeCollapse == null ? defaultValue : this._itemsBeforeCollapse;
	}

	public boolean hasItemsBeforeCollapse() {
		return this._itemsBeforeCollapse != null;
	}

	public BreadcrumbsElement removeItemsBeforeCollapse() {
		this._itemsBeforeCollapse = null;
		return this;
	} 

	public BreadcrumbsElement setKey(Object value) {
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

	public BreadcrumbsElement removeKey() {
		this._key = null;
		return this;
	} 

	public BreadcrumbsElement setMaxItems(Object value) {
		this._maxItems = value;
		return this;
	}

	public Object getMaxItems() {
		return this._maxItems;
	}

	public Object getMaxItems(Object defaultValue) {
		return this._maxItems == null ? defaultValue : this._maxItems;
	}

	public boolean hasMaxItems() {
		return this._maxItems != null;
	}

	public BreadcrumbsElement removeMaxItems() {
		this._maxItems = null;
		return this;
	} 

	public BreadcrumbsElement setSeparator(Object value) {
		this._separator = value;
		return this;
	}

	public Object getSeparator() {
		return this._separator;
	}

	public Object getSeparator(Object defaultValue) {
		return this._separator == null ? defaultValue : this._separator;
	}

	public boolean hasSeparator() {
		return this._separator != null;
	}

	public BreadcrumbsElement removeSeparator() {
		this._separator = null;
		return this;
	} 

	public BreadcrumbsElement setStyle(Object value) {
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

	public BreadcrumbsElement removeStyle() {
		this._style = null;
		return this;
	} 

	public BreadcrumbsElement addChildren(Object value) {
		this._children.add(value);
		return this;
	}

	public BreadcrumbsElement setChildren(Object[] value) {
		this._children.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public BreadcrumbsElement setChildren(java.util.Collection<Object> values) {
		this._children.addAll(values);
		return this;
	}

	public BreadcrumbsElement removeChildren(Object value) {
		this._children.remove(value);
		return this;
	}

	public BreadcrumbsElement removeChildren(int index) {
		this._children.remove(index);
		return this;
	}

	public java.util.List<Object> getChildren() {
		return this._children;
	} 

	public BreadcrumbsElement addAttribute(Object _name, Object _value) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		map.put("value", _value);
		this._attribute.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getAttribute() {
		return this._attribute;
	}

	public BreadcrumbsElement addAttribute(BreadcrumbsElement_Attribute value) {
		return addAttribute(value._name, value._value);
	}

	public java.util.stream.Stream<BreadcrumbsElement_Attribute> streamAttribute() {
		return this._attribute.stream().map(BreadcrumbsElement_Attribute::new);
	}

	public java.util.List<Object> getAttribute_Name() {
		return streamAttribute().map(BreadcrumbsElement_Attribute::getName).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getAttribute_Value() {
		return streamAttribute().map(BreadcrumbsElement_Attribute::getValue).collect(java.util.stream.Collectors.toList());
	}


	public static final class BreadcrumbsElement_Attribute {

		Object _name;
		Object _value;

		public BreadcrumbsElement_Attribute(Object _name, Object _value) {
			this._name = _name;
			this._value = _value;
		}

		private BreadcrumbsElement_Attribute(java.util.Map<String, Object> map) {
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
		BreadcrumbsElement that = (BreadcrumbsElement) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "BreadcrumbsElement(classes,className,component,expandText,id,itemsAfterCollapse,itemsBeforeCollapse,key,maxItems,separator,style,attribute,children) ::= <<<Breadcrumbs~if(classes)~\n" + 
				"	classes=~classes~~endif~~if(className)~\n" + 
				"	className=~className~~endif~~if(component)~\n" + 
				"	component=~component~~endif~~if(expandText)~\n" + 
				"	expandText=\"~expandText~\"~endif~~if(id)~\n" + 
				"	id=\"~id~\"~endif~~if(itemsAfterCollapse)~\n" + 
				"	itemsAfterCollapse=~itemsAfterCollapse~~endif~~if(itemsBeforeCollapse)~\n" + 
				"	itemsBeforeCollapse=~itemsBeforeCollapse~~endif~~if(key)~\n" + 
				"	key=~key~~endif~~if(maxItems)~\n" + 
				"	maxItems=~maxItems~~endif~~if(separator)~\n" + 
				"	separator=~separator~~endif~~if(style)~\n" + 
				"	style=~style~~endif~~attribute:{it|\n" + 
				"	\n" + 
				"	~it.name~=~it.value~}~~if(children)~>\n" + 
				"	~children:{it|~it~};separator=\"\\n\"~\n" + 
				"</Breadcrumbs>~else~ />~endif~ >>";
}  