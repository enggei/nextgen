package nextgen.templates.materialui;

public class CardMediaElement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _classes;
	private Object _className;
	private Object _component;
	private Object _id;
	private Object _image;
	private Object _key;
	private Object _src;
	private Object _style;
	private java.util.List<Object> _children = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _attribute = new java.util.ArrayList<>();

	CardMediaElement(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("CardMediaElement");
		st.add("classes", _classes);
		st.add("className", _className);
		st.add("component", _component);
		st.add("id", _id);
		st.add("image", _image);
		st.add("key", _key);
		st.add("src", _src);
		st.add("style", _style);
		for (Object o : _children) st.add("children", o);
		for (java.util.Map<String, Object> map : _attribute) st.addAggr("attribute.{name,value}", map.get("name"), map.get("value"));
		return st.render().trim();
	}

	public CardMediaElement setClasses(Object value) {
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

	public CardMediaElement removeClasses() {
		this._classes = null;
		return this;
	} 

	public CardMediaElement setClassName(Object value) {
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

	public CardMediaElement removeClassName() {
		this._className = null;
		return this;
	} 

	public CardMediaElement setComponent(Object value) {
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

	public CardMediaElement removeComponent() {
		this._component = null;
		return this;
	} 

	public CardMediaElement setId(Object value) {
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

	public CardMediaElement removeId() {
		this._id = null;
		return this;
	} 

	public CardMediaElement setImage(Object value) {
		this._image = value;
		return this;
	}

	public Object getImage() {
		return this._image;
	}

	public Object getImage(Object defaultValue) {
		return this._image == null ? defaultValue : this._image;
	}

	public boolean hasImage() {
		return this._image != null;
	}

	public CardMediaElement removeImage() {
		this._image = null;
		return this;
	} 

	public CardMediaElement setKey(Object value) {
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

	public CardMediaElement removeKey() {
		this._key = null;
		return this;
	} 

	public CardMediaElement setSrc(Object value) {
		this._src = value;
		return this;
	}

	public Object getSrc() {
		return this._src;
	}

	public Object getSrc(Object defaultValue) {
		return this._src == null ? defaultValue : this._src;
	}

	public boolean hasSrc() {
		return this._src != null;
	}

	public CardMediaElement removeSrc() {
		this._src = null;
		return this;
	} 

	public CardMediaElement setStyle(Object value) {
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

	public CardMediaElement removeStyle() {
		this._style = null;
		return this;
	} 

	public CardMediaElement addChildren(Object value) {
		this._children.add(value);
		return this;
	}

	public CardMediaElement setChildren(Object[] value) {
		this._children.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public CardMediaElement setChildren(java.util.Collection<Object> values) {
		this._children.addAll(values);
		return this;
	}

	public CardMediaElement removeChildren(Object value) {
		this._children.remove(value);
		return this;
	}

	public CardMediaElement removeChildren(int index) {
		this._children.remove(index);
		return this;
	}

	public java.util.List<Object> getChildren() {
		return this._children;
	} 

	public CardMediaElement addAttribute(Object _name, Object _value) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		map.put("value", _value);
		this._attribute.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getAttribute() {
		return this._attribute;
	}

	public CardMediaElement addAttribute(CardMediaElement_Attribute value) {
		return addAttribute(value._name, value._value);
	}

	public java.util.stream.Stream<CardMediaElement_Attribute> streamAttribute() {
		return this._attribute.stream().map(CardMediaElement_Attribute::new);
	}

	public java.util.List<Object> getAttribute_Name() {
		return streamAttribute().map(CardMediaElement_Attribute::getName).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getAttribute_Value() {
		return streamAttribute().map(CardMediaElement_Attribute::getValue).collect(java.util.stream.Collectors.toList());
	}


	public static final class CardMediaElement_Attribute {

		Object _name;
		Object _value;

		public CardMediaElement_Attribute(Object _name, Object _value) {
			this._name = _name;
			this._value = _value;
		}

		private CardMediaElement_Attribute(java.util.Map<String, Object> map) {
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
		CardMediaElement that = (CardMediaElement) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "CardMediaElement(classes,className,component,id,image,key,src,style,attribute,children) ::= <<<CardMedia~if(classes)~\n" + 
				"	classes=~classes~~endif~~if(className)~\n" + 
				"	className=~className~~endif~~if(component)~\n" + 
				"	component=~component~~endif~~if(id)~\n" + 
				"	id=\"~id~\"~endif~~if(image)~\n" + 
				"	image=\"~image~\"~endif~~if(key)~\n" + 
				"	key=~key~~endif~~if(src)~\n" + 
				"	src=\"~src~\"~endif~~if(style)~\n" + 
				"	style=~style~~endif~~attribute:{it|\n" + 
				"	\n" + 
				"	~it.name~=~it.value~}~~if(children)~>\n" + 
				"	~children:{it|~it~};separator=\"\\n\"~\n" + 
				"</CardMedia>~else~ />~endif~ >>";
}  