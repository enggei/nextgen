package nextgen.templates.materialui;

public class BackdropElement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _classes;
	private Object _className;
	private Object _id;
	private Object _invisible;
	private Object _style;
	private Object _transitionDuration;
	private java.util.List<Object> _children = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _attribute = new java.util.ArrayList<>();

	BackdropElement(org.stringtemplate.v4.STGroup stGroup) {
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
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("BackdropElement");
		st.add("classes", _classes);
		st.add("className", _className);
		st.add("id", _id);
		st.add("invisible", _invisible);
		st.add("style", _style);
		st.add("transitionDuration", _transitionDuration);
		for (Object o : _children) st.add("children", o);
		for (java.util.Map<String, Object> map : _attribute) st.addAggr("attribute.{name,value}", map.get("name"), map.get("value"));
		return st.render().trim();
	}

	public BackdropElement setClasses(Object value) {
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

	public BackdropElement removeClasses() {
		this._classes = null;
		return this;
	} 

	public BackdropElement setClassName(Object value) {
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

	public BackdropElement removeClassName() {
		this._className = null;
		return this;
	} 

	public BackdropElement setId(Object value) {
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

	public BackdropElement removeId() {
		this._id = null;
		return this;
	} 

	public BackdropElement setInvisible(Object value) {
		this._invisible = value;
		return this;
	}

	public Object getInvisible() {
		return this._invisible;
	}

	public Object getInvisible(Object defaultValue) {
		return this._invisible == null ? defaultValue : this._invisible;
	}

	public boolean hasInvisible() {
		return this._invisible != null;
	}

	public BackdropElement removeInvisible() {
		this._invisible = null;
		return this;
	} 

	public BackdropElement setStyle(Object value) {
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

	public BackdropElement removeStyle() {
		this._style = null;
		return this;
	} 

	public BackdropElement setTransitionDuration(Object value) {
		this._transitionDuration = value;
		return this;
	}

	public Object getTransitionDuration() {
		return this._transitionDuration;
	}

	public Object getTransitionDuration(Object defaultValue) {
		return this._transitionDuration == null ? defaultValue : this._transitionDuration;
	}

	public boolean hasTransitionDuration() {
		return this._transitionDuration != null;
	}

	public BackdropElement removeTransitionDuration() {
		this._transitionDuration = null;
		return this;
	} 

	public BackdropElement addChildren(Object value) {
		this._children.add(value);
		return this;
	}

	public BackdropElement setChildren(Object[] value) {
		this._children.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public BackdropElement setChildren(java.util.Collection<Object> values) {
		this._children.addAll(values);
		return this;
	}

	public BackdropElement removeChildren(Object value) {
		this._children.remove(value);
		return this;
	}

	public BackdropElement removeChildren(int index) {
		this._children.remove(index);
		return this;
	}

	public java.util.List<Object> getChildren() {
		return this._children;
	} 

	public BackdropElement addAttribute(Object _name, Object _value) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		map.put("value", _value);
		this._attribute.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getAttribute() {
		return this._attribute;
	}

	public BackdropElement addAttribute(BackdropElement_Attribute value) {
		return addAttribute(value._name, value._value);
	}

	public java.util.stream.Stream<BackdropElement_Attribute> streamAttribute() {
		return this._attribute.stream().map(BackdropElement_Attribute::new);
	}

	public static final class BackdropElement_Attribute {

		Object _name;
		Object _value;

		public BackdropElement_Attribute(Object _name, Object _value) {
			this._name = _name;
			this._value = _value;
		}

		private BackdropElement_Attribute(java.util.Map<String, Object> map) {
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
		BackdropElement that = (BackdropElement) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "BackdropElement(classes,className,id,invisible,style,transitionDuration,attribute,children) ::= <<<Backdrop~if(classes)~\n" + 
				"	classes=~classes~~endif~~if(className)~\n" + 
				"	className=~className~~endif~~if(id)~\n" + 
				"	id=\"~id~\"~endif~~if(invisible)~\n" + 
				"	invisible~endif~\n" + 
				"	open~if(style)~\n" + 
				"	style=~style~~endif~~if(transitionDuration)~\n" + 
				"	transitionDuration=~transitionDuration~~endif~~attribute:{it|\n" + 
				"	\n" + 
				"	~it.name~=~it.value~}~~if(children)~>\n" + 
				"	~children:{it|~it~};separator=\"\\n\"~\n" + 
				"</Backdrop>~else~ />~endif~ >>";
}  