package nextgen.templates.materialui;

public class ExpansionPanelSummaryElement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _classes;
	private Object _className;
	private Object _expandIcon;
	private Object _IconButtonProps;
	private Object _id;
	private Object _onFocusVisible;
	private Object _style;
	private java.util.List<Object> _children = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _attribute = new java.util.ArrayList<>();

	ExpansionPanelSummaryElement(org.stringtemplate.v4.STGroup stGroup) {
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
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("ExpansionPanelSummaryElement");
		st.add("classes", _classes);
		st.add("className", _className);
		st.add("expandIcon", _expandIcon);
		st.add("IconButtonProps", _IconButtonProps);
		st.add("id", _id);
		st.add("onFocusVisible", _onFocusVisible);
		st.add("style", _style);
		for (Object o : _children) st.add("children", o);
		for (java.util.Map<String, Object> map : _attribute) st.addAggr("attribute.{name,value}", map.get("name"), map.get("value"));
		return st.render().trim();
	}

	public ExpansionPanelSummaryElement setClasses(Object value) {
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

	public ExpansionPanelSummaryElement removeClasses() {
		this._classes = null;
		return this;
	} 

	public ExpansionPanelSummaryElement setClassName(Object value) {
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

	public ExpansionPanelSummaryElement removeClassName() {
		this._className = null;
		return this;
	} 

	public ExpansionPanelSummaryElement setExpandIcon(Object value) {
		this._expandIcon = value;
		return this;
	}

	public Object getExpandIcon() {
		return this._expandIcon;
	}

	public Object getExpandIcon(Object defaultValue) {
		return this._expandIcon == null ? defaultValue : this._expandIcon;
	}

	public boolean hasExpandIcon() {
		return this._expandIcon != null;
	}

	public ExpansionPanelSummaryElement removeExpandIcon() {
		this._expandIcon = null;
		return this;
	} 

	public ExpansionPanelSummaryElement setIconButtonProps(Object value) {
		this._IconButtonProps = value;
		return this;
	}

	public Object getIconButtonProps() {
		return this._IconButtonProps;
	}

	public Object getIconButtonProps(Object defaultValue) {
		return this._IconButtonProps == null ? defaultValue : this._IconButtonProps;
	}

	public boolean hasIconButtonProps() {
		return this._IconButtonProps != null;
	}

	public ExpansionPanelSummaryElement removeIconButtonProps() {
		this._IconButtonProps = null;
		return this;
	} 

	public ExpansionPanelSummaryElement setId(Object value) {
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

	public ExpansionPanelSummaryElement removeId() {
		this._id = null;
		return this;
	} 

	public ExpansionPanelSummaryElement setOnFocusVisible(Object value) {
		this._onFocusVisible = value;
		return this;
	}

	public Object getOnFocusVisible() {
		return this._onFocusVisible;
	}

	public Object getOnFocusVisible(Object defaultValue) {
		return this._onFocusVisible == null ? defaultValue : this._onFocusVisible;
	}

	public boolean hasOnFocusVisible() {
		return this._onFocusVisible != null;
	}

	public ExpansionPanelSummaryElement removeOnFocusVisible() {
		this._onFocusVisible = null;
		return this;
	} 

	public ExpansionPanelSummaryElement setStyle(Object value) {
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

	public ExpansionPanelSummaryElement removeStyle() {
		this._style = null;
		return this;
	} 

	public ExpansionPanelSummaryElement addChildren(Object value) {
		this._children.add(value);
		return this;
	}

	public ExpansionPanelSummaryElement setChildren(Object[] value) {
		this._children.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public ExpansionPanelSummaryElement setChildren(java.util.Collection<Object> values) {
		this._children.addAll(values);
		return this;
	}

	public ExpansionPanelSummaryElement removeChildren(Object value) {
		this._children.remove(value);
		return this;
	}

	public ExpansionPanelSummaryElement removeChildren(int index) {
		this._children.remove(index);
		return this;
	}

	public java.util.List<Object> getChildren() {
		return this._children;
	} 

	public ExpansionPanelSummaryElement addAttribute(Object _name, Object _value) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		map.put("value", _value);
		this._attribute.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getAttribute() {
		return this._attribute;
	}

	public ExpansionPanelSummaryElement addAttribute(ExpansionPanelSummaryElement_Attribute value) {
		return addAttribute(value._name, value._value);
	}

	public java.util.stream.Stream<ExpansionPanelSummaryElement_Attribute> streamAttribute() {
		return this._attribute.stream().map(ExpansionPanelSummaryElement_Attribute::new);
	}

	public static final class ExpansionPanelSummaryElement_Attribute {

		Object _name;
		Object _value;

		public ExpansionPanelSummaryElement_Attribute(Object _name, Object _value) {
			this._name = _name;
			this._value = _value;
		}

		private ExpansionPanelSummaryElement_Attribute(java.util.Map<String, Object> map) {
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
		ExpansionPanelSummaryElement that = (ExpansionPanelSummaryElement) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "ExpansionPanelSummaryElement(classes,className,expandIcon,IconButtonProps,id,onFocusVisible,style,attribute,children) ::= <<<ExpansionPanelSummary~if(classes)~\n" + 
				"	classes=~classes~~endif~~if(className)~\n" + 
				"	className=~className~~endif~~if(expandIcon)~\n" + 
				"	expandIcon=~expandIcon~~endif~~if(IconButtonProps)~\n" + 
				"	IconButtonProps=~IconButtonProps~~endif~~if(id)~\n" + 
				"	id=\"~id~\"~endif~~if(onFocusVisible)~\n" + 
				"	onFocusVisible=~onFocusVisible~~endif~~if(style)~\n" + 
				"	style=~style~~endif~~attribute:{it|\n" + 
				"	\n" + 
				"	~it.name~=~it.value~}~~if(children)~>\n" + 
				"	~children:{it|~it~};separator=\"\\n\"~\n" + 
				"</ExpansionPanelSummary>~else~ />~endif~ >>";
}  