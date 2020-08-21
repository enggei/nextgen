package nextgen.templates.materialui;

public class AccordionSummaryElement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _classes;
	private Object _className;
	private Object _expandIcon;
	private Object _IconButtonProps;
	private Object _id;
	private Object _style;
	private java.util.List<Object> _children = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _attribute = new java.util.ArrayList<>();

	AccordionSummaryElement(org.stringtemplate.v4.STGroup stGroup) {
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
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("AccordionSummaryElement");
		st.add("classes", _classes);
		st.add("className", _className);
		st.add("expandIcon", _expandIcon);
		st.add("IconButtonProps", _IconButtonProps);
		st.add("id", _id);
		st.add("style", _style);
		for (Object o : _children) st.add("children", o);
		for (java.util.Map<String, Object> map : _attribute) st.addAggr("attribute.{name,value}", map.get("name"), map.get("value"));
		return st.render().trim();
	}

	public AccordionSummaryElement setClasses(Object value) {
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

	public AccordionSummaryElement removeClasses() {
		this._classes = null;
		return this;
	} 

	public AccordionSummaryElement setClassName(Object value) {
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

	public AccordionSummaryElement removeClassName() {
		this._className = null;
		return this;
	} 

	public AccordionSummaryElement setExpandIcon(Object value) {
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

	public AccordionSummaryElement removeExpandIcon() {
		this._expandIcon = null;
		return this;
	} 

	public AccordionSummaryElement setIconButtonProps(Object value) {
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

	public AccordionSummaryElement removeIconButtonProps() {
		this._IconButtonProps = null;
		return this;
	} 

	public AccordionSummaryElement setId(Object value) {
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

	public AccordionSummaryElement removeId() {
		this._id = null;
		return this;
	} 

	public AccordionSummaryElement setStyle(Object value) {
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

	public AccordionSummaryElement removeStyle() {
		this._style = null;
		return this;
	} 

	public AccordionSummaryElement addChildren(Object value) {
		this._children.add(value);
		return this;
	}

	public AccordionSummaryElement setChildren(Object[] value) {
		this._children.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public AccordionSummaryElement setChildren(java.util.Collection<Object> values) {
		this._children.addAll(values);
		return this;
	}

	public AccordionSummaryElement removeChildren(Object value) {
		this._children.remove(value);
		return this;
	}

	public AccordionSummaryElement removeChildren(int index) {
		this._children.remove(index);
		return this;
	}

	public java.util.List<Object> getChildren() {
		return this._children;
	} 

	public AccordionSummaryElement addAttribute(Object _name, Object _value) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		map.put("value", _value);
		this._attribute.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getAttribute() {
		return this._attribute;
	}

	public AccordionSummaryElement addAttribute(AccordionSummaryElement_Attribute value) {
		return addAttribute(value._name, value._value);
	}

	public java.util.stream.Stream<AccordionSummaryElement_Attribute> streamAttribute() {
		return this._attribute.stream().map(AccordionSummaryElement_Attribute::new);
	}

	public static final class AccordionSummaryElement_Attribute {

		Object _name;
		Object _value;

		public AccordionSummaryElement_Attribute(Object _name, Object _value) {
			this._name = _name;
			this._value = _value;
		}

		private AccordionSummaryElement_Attribute(java.util.Map<String, Object> map) {
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
		AccordionSummaryElement that = (AccordionSummaryElement) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "AccordionSummaryElement(classes,className,expandIcon,IconButtonProps,id,style,attribute,children) ::= <<<AccordionSummary~if(classes)~\n" + 
				"	classes=~classes~~endif~~if(className)~\n" + 
				"	className=~className~~endif~~if(expandIcon)~\n" + 
				"	expandIcon=~expandIcon~~endif~~if(IconButtonProps)~\n" + 
				"	IconButtonProps=~IconButtonProps~~endif~~if(id)~\n" + 
				"	id=\"~id~\"~endif~~if(style)~\n" + 
				"	style=~style~~endif~~attribute:{it|\n" + 
				"	\n" + 
				"	~it.name~=~it.value~}~~if(children)~>\n" + 
				"	~children:{it|~it~};separator=\"\\n\"~\n" + 
				"</AccordionSummary>~else~ />~endif~ >>";
}  