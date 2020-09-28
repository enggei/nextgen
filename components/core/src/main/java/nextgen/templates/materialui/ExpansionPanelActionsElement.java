package nextgen.templates.materialui;

public class ExpansionPanelActionsElement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _classes;
	private Object _className;
	private Object _disableSpacing;
	private Object _id;
	private Object _key;
	private Object _style;
	private java.util.List<Object> _children = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _attribute = new java.util.ArrayList<>();

	ExpansionPanelActionsElement(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("ExpansionPanelActionsElement");
		st.add("classes", _classes);
		st.add("className", _className);
		st.add("disableSpacing", _disableSpacing);
		st.add("id", _id);
		st.add("key", _key);
		st.add("style", _style);
		for (Object o : _children) st.add("children", o);
		for (java.util.Map<String, Object> map : _attribute) st.addAggr("attribute.{name,value}", map.get("name"), map.get("value"));
		return st.render().trim();
	}

	public ExpansionPanelActionsElement setClasses(Object value) {
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

	public ExpansionPanelActionsElement removeClasses() {
		this._classes = null;
		return this;
	} 

	public ExpansionPanelActionsElement setClassName(Object value) {
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

	public ExpansionPanelActionsElement removeClassName() {
		this._className = null;
		return this;
	} 

	public ExpansionPanelActionsElement setDisableSpacing(Object value) {
		this._disableSpacing = value;
		return this;
	}

	public Object getDisableSpacing() {
		return this._disableSpacing;
	}

	public Object getDisableSpacing(Object defaultValue) {
		return this._disableSpacing == null ? defaultValue : this._disableSpacing;
	}

	public boolean hasDisableSpacing() {
		return this._disableSpacing != null;
	}

	public ExpansionPanelActionsElement removeDisableSpacing() {
		this._disableSpacing = null;
		return this;
	} 

	public ExpansionPanelActionsElement setId(Object value) {
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

	public ExpansionPanelActionsElement removeId() {
		this._id = null;
		return this;
	} 

	public ExpansionPanelActionsElement setKey(Object value) {
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

	public ExpansionPanelActionsElement removeKey() {
		this._key = null;
		return this;
	} 

	public ExpansionPanelActionsElement setStyle(Object value) {
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

	public ExpansionPanelActionsElement removeStyle() {
		this._style = null;
		return this;
	} 

	public ExpansionPanelActionsElement addChildren(Object value) {
		this._children.add(value);
		return this;
	}

	public ExpansionPanelActionsElement setChildren(Object[] value) {
		this._children.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public ExpansionPanelActionsElement setChildren(java.util.Collection<Object> values) {
		this._children.addAll(values);
		return this;
	}

	public ExpansionPanelActionsElement removeChildren(Object value) {
		this._children.remove(value);
		return this;
	}

	public ExpansionPanelActionsElement removeChildren(int index) {
		this._children.remove(index);
		return this;
	}

	public java.util.List<Object> getChildren() {
		return this._children;
	} 

	public ExpansionPanelActionsElement addAttribute(Object _name, Object _value) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		map.put("value", _value);
		this._attribute.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getAttribute() {
		return this._attribute;
	}

	public ExpansionPanelActionsElement addAttribute(ExpansionPanelActionsElement_Attribute value) {
		return addAttribute(value._name, value._value);
	}

	public java.util.stream.Stream<ExpansionPanelActionsElement_Attribute> streamAttribute() {
		return this._attribute.stream().map(ExpansionPanelActionsElement_Attribute::new);
	}

	public java.util.List<Object> getAttribute_Name() {
		return streamAttribute().map(ExpansionPanelActionsElement_Attribute::getName).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getAttribute_Value() {
		return streamAttribute().map(ExpansionPanelActionsElement_Attribute::getValue).collect(java.util.stream.Collectors.toList());
	}


	public static final class ExpansionPanelActionsElement_Attribute {

		Object _name;
		Object _value;

		public ExpansionPanelActionsElement_Attribute(Object _name, Object _value) {
			this._name = _name;
			this._value = _value;
		}

		private ExpansionPanelActionsElement_Attribute(java.util.Map<String, Object> map) {
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
		ExpansionPanelActionsElement that = (ExpansionPanelActionsElement) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "ExpansionPanelActionsElement(classes,className,disableSpacing,id,key,style,attribute,children) ::= <<<ExpansionPanelActions~if(classes)~\n" + 
				"	classes=~classes~~endif~~if(className)~\n" + 
				"	className=~className~~endif~~if(disableSpacing)~\n" + 
				"	disableSpacing~endif~~if(id)~\n" + 
				"	id=\"~id~\"~endif~~if(key)~\n" + 
				"	key=~key~~endif~~if(style)~\n" + 
				"	style=~style~~endif~~attribute:{it|\n" + 
				"	\n" + 
				"	~it.name~=~it.value~}~~if(children)~>\n" + 
				"	~children:{it|~it~};separator=\"\\n\"~\n" + 
				"</ExpansionPanelActions>~else~ />~endif~ >>";
}  