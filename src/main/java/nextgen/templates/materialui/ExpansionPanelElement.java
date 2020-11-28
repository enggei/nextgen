package nextgen.templates.materialui;

public class ExpansionPanelElement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _classes;
	private Object _className;
	private Object _defaultExpanded;
	private Object _disabled;
	private Object _expanded;
	private Object _id;
	private Object _key;
	private Object _onChange;
	private Object _square;
	private Object _style;
	private Object _TransitionComponent;
	private Object _TransitionProps;
	private java.util.List<Object> _children = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _attribute = new java.util.ArrayList<>();

	ExpansionPanelElement(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("ExpansionPanelElement");
		st.add("classes", _classes);
		st.add("className", _className);
		st.add("defaultExpanded", _defaultExpanded);
		st.add("disabled", _disabled);
		st.add("expanded", _expanded);
		st.add("id", _id);
		st.add("key", _key);
		st.add("onChange", _onChange);
		st.add("square", _square);
		st.add("style", _style);
		st.add("TransitionComponent", _TransitionComponent);
		st.add("TransitionProps", _TransitionProps);
		for (Object o : _children) st.add("children", o);
		for (java.util.Map<String, Object> map : _attribute) st.addAggr("attribute.{name,value}", map.get("name"), map.get("value"));
		return st.render().trim();
	}

	public ExpansionPanelElement setClasses(Object value) {
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

	public ExpansionPanelElement removeClasses() {
		this._classes = null;
		return this;
	} 

	public ExpansionPanelElement setClassName(Object value) {
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

	public ExpansionPanelElement removeClassName() {
		this._className = null;
		return this;
	} 

	public ExpansionPanelElement setDefaultExpanded(Object value) {
		this._defaultExpanded = value;
		return this;
	}

	public Object getDefaultExpanded() {
		return this._defaultExpanded;
	}

	public Object getDefaultExpanded(Object defaultValue) {
		return this._defaultExpanded == null ? defaultValue : this._defaultExpanded;
	}

	public boolean hasDefaultExpanded() {
		return this._defaultExpanded != null;
	}

	public ExpansionPanelElement removeDefaultExpanded() {
		this._defaultExpanded = null;
		return this;
	} 

	public ExpansionPanelElement setDisabled(Object value) {
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

	public ExpansionPanelElement removeDisabled() {
		this._disabled = null;
		return this;
	} 

	public ExpansionPanelElement setExpanded(Object value) {
		this._expanded = value;
		return this;
	}

	public Object getExpanded() {
		return this._expanded;
	}

	public Object getExpanded(Object defaultValue) {
		return this._expanded == null ? defaultValue : this._expanded;
	}

	public boolean hasExpanded() {
		return this._expanded != null;
	}

	public ExpansionPanelElement removeExpanded() {
		this._expanded = null;
		return this;
	} 

	public ExpansionPanelElement setId(Object value) {
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

	public ExpansionPanelElement removeId() {
		this._id = null;
		return this;
	} 

	public ExpansionPanelElement setKey(Object value) {
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

	public ExpansionPanelElement removeKey() {
		this._key = null;
		return this;
	} 

	public ExpansionPanelElement setOnChange(Object value) {
		this._onChange = value;
		return this;
	}

	public Object getOnChange() {
		return this._onChange;
	}

	public Object getOnChange(Object defaultValue) {
		return this._onChange == null ? defaultValue : this._onChange;
	}

	public boolean hasOnChange() {
		return this._onChange != null;
	}

	public ExpansionPanelElement removeOnChange() {
		this._onChange = null;
		return this;
	} 

	public ExpansionPanelElement setSquare(Object value) {
		this._square = value;
		return this;
	}

	public Object getSquare() {
		return this._square;
	}

	public Object getSquare(Object defaultValue) {
		return this._square == null ? defaultValue : this._square;
	}

	public boolean hasSquare() {
		return this._square != null;
	}

	public ExpansionPanelElement removeSquare() {
		this._square = null;
		return this;
	} 

	public ExpansionPanelElement setStyle(Object value) {
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

	public ExpansionPanelElement removeStyle() {
		this._style = null;
		return this;
	} 

	public ExpansionPanelElement setTransitionComponent(Object value) {
		this._TransitionComponent = value;
		return this;
	}

	public Object getTransitionComponent() {
		return this._TransitionComponent;
	}

	public Object getTransitionComponent(Object defaultValue) {
		return this._TransitionComponent == null ? defaultValue : this._TransitionComponent;
	}

	public boolean hasTransitionComponent() {
		return this._TransitionComponent != null;
	}

	public ExpansionPanelElement removeTransitionComponent() {
		this._TransitionComponent = null;
		return this;
	} 

	public ExpansionPanelElement setTransitionProps(Object value) {
		this._TransitionProps = value;
		return this;
	}

	public Object getTransitionProps() {
		return this._TransitionProps;
	}

	public Object getTransitionProps(Object defaultValue) {
		return this._TransitionProps == null ? defaultValue : this._TransitionProps;
	}

	public boolean hasTransitionProps() {
		return this._TransitionProps != null;
	}

	public ExpansionPanelElement removeTransitionProps() {
		this._TransitionProps = null;
		return this;
	} 

	public ExpansionPanelElement addChildren(Object value) {
		this._children.add(value);
		return this;
	}

	public ExpansionPanelElement setChildren(Object[] value) {
		this._children.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public ExpansionPanelElement setChildren(java.util.Collection<Object> values) {
		this._children.addAll(values);
		return this;
	}

	public ExpansionPanelElement removeChildren(Object value) {
		this._children.remove(value);
		return this;
	}

	public ExpansionPanelElement removeChildren(int index) {
		this._children.remove(index);
		return this;
	}

	public java.util.List<Object> getChildren() {
		return this._children;
	} 

	public ExpansionPanelElement addAttribute(Object _name, Object _value) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		map.put("value", _value);
		this._attribute.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getAttribute() {
		return this._attribute;
	}

	public ExpansionPanelElement addAttribute(ExpansionPanelElement_Attribute value) {
		return addAttribute(value._name, value._value);
	}

	public java.util.stream.Stream<ExpansionPanelElement_Attribute> streamAttribute() {
		return this._attribute.stream().map(ExpansionPanelElement_Attribute::new);
	}

	public java.util.List<Object> getAttribute_Name() {
		return streamAttribute().map(ExpansionPanelElement_Attribute::getName).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getAttribute_Value() {
		return streamAttribute().map(ExpansionPanelElement_Attribute::getValue).collect(java.util.stream.Collectors.toList());
	}


	public static final class ExpansionPanelElement_Attribute {

		Object _name;
		Object _value;

		public ExpansionPanelElement_Attribute(Object _name, Object _value) {
			this._name = _name;
			this._value = _value;
		}

		private ExpansionPanelElement_Attribute(java.util.Map<String, Object> map) {
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
		ExpansionPanelElement that = (ExpansionPanelElement) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "ExpansionPanelElement(classes,className,defaultExpanded,disabled,expanded,id,key,onChange,square,style,TransitionComponent,TransitionProps,attribute,children) ::= <<<ExpansionPanel~if(classes)~\n" + 
				"	classes=~classes~~endif~~if(className)~\n" + 
				"	className=~className~~endif~~if(defaultExpanded)~\n" + 
				"	defaultExpanded~endif~~if(disabled)~\n" + 
				"	disabled~endif~~if(expanded)~\n" + 
				"	expanded~endif~~if(id)~\n" + 
				"	id=\"~id~\"~endif~~if(key)~\n" + 
				"	key=~key~~endif~~if(onChange)~\n" + 
				"	onChange=~onChange~~endif~~if(square)~\n" + 
				"	square~endif~~if(style)~\n" + 
				"	style=~style~~endif~~if(TransitionComponent)~\n" + 
				"	TransitionComponent=~TransitionComponent~~endif~~if(TransitionProps)~\n" + 
				"	TransitionProps=~TransitionProps~~endif~~attribute:{it|\n" + 
				"	\n" + 
				"	~it.name~=~it.value~}~~if(children)~>\n" + 
				"	~children:{it|~it~};separator=\"\\n\"~\n" + 
				"</ExpansionPanel>~else~ />~endif~ >>";
}  