package nextgen.templates.materialui;

public class RootRefElement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _className;
	private Object _id;
	private Object _rootRef;
	private Object _style;
	private java.util.List<Object> _children = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _attribute = new java.util.ArrayList<>();

	RootRefElement(org.stringtemplate.v4.STGroup stGroup) {
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
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("RootRefElement");
		st.add("className", _className);
		st.add("id", _id);
		st.add("rootRef", _rootRef);
		st.add("style", _style);
		for (Object o : _children) st.add("children", o);
		for (java.util.Map<String, Object> map : _attribute) st.addAggr("attribute.{name,value}", map.get("name"), map.get("value"));
		return st.render().trim();
	}

	public RootRefElement setClassName(Object value) {
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

	public RootRefElement removeClassName() {
		this._className = null;
		return this;
	} 

	public RootRefElement setId(Object value) {
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

	public RootRefElement removeId() {
		this._id = null;
		return this;
	} 

	public RootRefElement setRootRef(Object value) {
		this._rootRef = value;
		return this;
	}

	public Object getRootRef() {
		return this._rootRef;
	}

	public Object getRootRef(Object defaultValue) {
		return this._rootRef == null ? defaultValue : this._rootRef;
	}

	public boolean hasRootRef() {
		return this._rootRef != null;
	}

	public RootRefElement removeRootRef() {
		this._rootRef = null;
		return this;
	} 

	public RootRefElement setStyle(Object value) {
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

	public RootRefElement removeStyle() {
		this._style = null;
		return this;
	} 

	public RootRefElement addChildren(Object value) {
		this._children.add(value);
		return this;
	}

	public RootRefElement setChildren(Object[] value) {
		this._children.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public RootRefElement setChildren(java.util.Collection<Object> values) {
		this._children.addAll(values);
		return this;
	}

	public RootRefElement removeChildren(Object value) {
		this._children.remove(value);
		return this;
	}

	public RootRefElement removeChildren(int index) {
		this._children.remove(index);
		return this;
	}

	public java.util.List<Object> getChildren() {
		return this._children;
	} 

	public RootRefElement addAttribute(Object _name, Object _value) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		map.put("value", _value);
		this._attribute.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getAttribute() {
		return this._attribute;
	}

	public RootRefElement addAttribute(RootRefElement_Attribute value) {
		return addAttribute(value._name, value._value);
	}

	public java.util.stream.Stream<RootRefElement_Attribute> streamAttribute() {
		return this._attribute.stream().map(RootRefElement_Attribute::new);
	}

	public static final class RootRefElement_Attribute {

		Object _name;
		Object _value;

		public RootRefElement_Attribute(Object _name, Object _value) {
			this._name = _name;
			this._value = _value;
		}

		private RootRefElement_Attribute(java.util.Map<String, Object> map) {
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
		RootRefElement that = (RootRefElement) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "RootRefElement(className,id,rootRef,style,attribute,children) ::= <<<RootRef~if(className)~\n" + 
				"	className=~className~~endif~~if(id)~\n" + 
				"	id=\"~id~\"~endif~\n" + 
				"	rootRef=~rootRef~~if(style)~\n" + 
				"	style=~style~~endif~~attribute:{it|\n" + 
				"	\n" + 
				"	~it.name~=~it.value~}~~if(children)~>\n" + 
				"	~children:{it|~it~};separator=\"\\n\"~\n" + 
				"</RootRef>~else~ />~endif~ >>";
}  