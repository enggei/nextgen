package nextgen.templates.materialui;

public class ListItemTextElement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _classes;
	private Object _className;
	private Object _disableTypography;
	private Object _id;
	private Object _inset;
	private Object _key;
	private Object _primary;
	private Object _primaryTypographyProps;
	private Object _secondary;
	private Object _secondaryTypographyProps;
	private Object _style;
	private java.util.List<Object> _children = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _attribute = new java.util.ArrayList<>();

	ListItemTextElement(org.stringtemplate.v4.STGroup stGroup) {
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
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("ListItemTextElement");
		st.add("classes", _classes);
		st.add("className", _className);
		st.add("disableTypography", _disableTypography);
		st.add("id", _id);
		st.add("inset", _inset);
		st.add("key", _key);
		st.add("primary", _primary);
		st.add("primaryTypographyProps", _primaryTypographyProps);
		st.add("secondary", _secondary);
		st.add("secondaryTypographyProps", _secondaryTypographyProps);
		st.add("style", _style);
		for (Object o : _children) st.add("children", o);
		for (java.util.Map<String, Object> map : _attribute) st.addAggr("attribute.{name,value}", map.get("name"), map.get("value"));
		return st.render().trim();
	}

	public ListItemTextElement setClasses(Object value) {
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

	public ListItemTextElement removeClasses() {
		this._classes = null;
		return this;
	} 

	public ListItemTextElement setClassName(Object value) {
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

	public ListItemTextElement removeClassName() {
		this._className = null;
		return this;
	} 

	public ListItemTextElement setDisableTypography(Object value) {
		this._disableTypography = value;
		return this;
	}

	public Object getDisableTypography() {
		return this._disableTypography;
	}

	public Object getDisableTypography(Object defaultValue) {
		return this._disableTypography == null ? defaultValue : this._disableTypography;
	}

	public boolean hasDisableTypography() {
		return this._disableTypography != null;
	}

	public ListItemTextElement removeDisableTypography() {
		this._disableTypography = null;
		return this;
	} 

	public ListItemTextElement setId(Object value) {
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

	public ListItemTextElement removeId() {
		this._id = null;
		return this;
	} 

	public ListItemTextElement setInset(Object value) {
		this._inset = value;
		return this;
	}

	public Object getInset() {
		return this._inset;
	}

	public Object getInset(Object defaultValue) {
		return this._inset == null ? defaultValue : this._inset;
	}

	public boolean hasInset() {
		return this._inset != null;
	}

	public ListItemTextElement removeInset() {
		this._inset = null;
		return this;
	} 

	public ListItemTextElement setKey(Object value) {
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

	public ListItemTextElement removeKey() {
		this._key = null;
		return this;
	} 

	public ListItemTextElement setPrimary(Object value) {
		this._primary = value;
		return this;
	}

	public Object getPrimary() {
		return this._primary;
	}

	public Object getPrimary(Object defaultValue) {
		return this._primary == null ? defaultValue : this._primary;
	}

	public boolean hasPrimary() {
		return this._primary != null;
	}

	public ListItemTextElement removePrimary() {
		this._primary = null;
		return this;
	} 

	public ListItemTextElement setPrimaryTypographyProps(Object value) {
		this._primaryTypographyProps = value;
		return this;
	}

	public Object getPrimaryTypographyProps() {
		return this._primaryTypographyProps;
	}

	public Object getPrimaryTypographyProps(Object defaultValue) {
		return this._primaryTypographyProps == null ? defaultValue : this._primaryTypographyProps;
	}

	public boolean hasPrimaryTypographyProps() {
		return this._primaryTypographyProps != null;
	}

	public ListItemTextElement removePrimaryTypographyProps() {
		this._primaryTypographyProps = null;
		return this;
	} 

	public ListItemTextElement setSecondary(Object value) {
		this._secondary = value;
		return this;
	}

	public Object getSecondary() {
		return this._secondary;
	}

	public Object getSecondary(Object defaultValue) {
		return this._secondary == null ? defaultValue : this._secondary;
	}

	public boolean hasSecondary() {
		return this._secondary != null;
	}

	public ListItemTextElement removeSecondary() {
		this._secondary = null;
		return this;
	} 

	public ListItemTextElement setSecondaryTypographyProps(Object value) {
		this._secondaryTypographyProps = value;
		return this;
	}

	public Object getSecondaryTypographyProps() {
		return this._secondaryTypographyProps;
	}

	public Object getSecondaryTypographyProps(Object defaultValue) {
		return this._secondaryTypographyProps == null ? defaultValue : this._secondaryTypographyProps;
	}

	public boolean hasSecondaryTypographyProps() {
		return this._secondaryTypographyProps != null;
	}

	public ListItemTextElement removeSecondaryTypographyProps() {
		this._secondaryTypographyProps = null;
		return this;
	} 

	public ListItemTextElement setStyle(Object value) {
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

	public ListItemTextElement removeStyle() {
		this._style = null;
		return this;
	} 

	public ListItemTextElement addChildren(Object value) {
		this._children.add(value);
		return this;
	}

	public ListItemTextElement setChildren(Object[] value) {
		this._children.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public ListItemTextElement setChildren(java.util.Collection<Object> values) {
		this._children.addAll(values);
		return this;
	}

	public ListItemTextElement removeChildren(Object value) {
		this._children.remove(value);
		return this;
	}

	public ListItemTextElement removeChildren(int index) {
		this._children.remove(index);
		return this;
	}

	public java.util.List<Object> getChildren() {
		return this._children;
	} 

	public ListItemTextElement addAttribute(Object _name, Object _value) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		map.put("value", _value);
		this._attribute.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getAttribute() {
		return this._attribute;
	}

	public ListItemTextElement addAttribute(ListItemTextElement_Attribute value) {
		return addAttribute(value._name, value._value);
	}

	public java.util.stream.Stream<ListItemTextElement_Attribute> streamAttribute() {
		return this._attribute.stream().map(ListItemTextElement_Attribute::new);
	}

	public static final class ListItemTextElement_Attribute {

		Object _name;
		Object _value;

		public ListItemTextElement_Attribute(Object _name, Object _value) {
			this._name = _name;
			this._value = _value;
		}

		private ListItemTextElement_Attribute(java.util.Map<String, Object> map) {
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
		ListItemTextElement that = (ListItemTextElement) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "ListItemTextElement(classes,className,disableTypography,id,inset,key,primary,primaryTypographyProps,secondary,secondaryTypographyProps,style,attribute,children) ::= <<<ListItemText~if(classes)~\n" + 
				"	classes=~classes~~endif~~if(className)~\n" + 
				"	className=~className~~endif~~if(disableTypography)~\n" + 
				"	disableTypography~endif~~if(id)~\n" + 
				"	id=\"~id~\"~endif~~if(inset)~\n" + 
				"	inset~endif~~if(key)~\n" + 
				"	key=~key~~endif~~if(primary)~\n" + 
				"	primary=~primary~~endif~~if(primaryTypographyProps)~\n" + 
				"	primaryTypographyProps=~primaryTypographyProps~~endif~~if(secondary)~\n" + 
				"	secondary=~secondary~~endif~~if(secondaryTypographyProps)~\n" + 
				"	secondaryTypographyProps=~secondaryTypographyProps~~endif~~if(style)~\n" + 
				"	style=~style~~endif~~attribute:{it|\n" + 
				"	\n" + 
				"	~it.name~=~it.value~}~~if(children)~>\n" + 
				"	~children:{it|~it~};separator=\"\\n\"~\n" + 
				"</ListItemText>~else~ />~endif~ >>";
}  