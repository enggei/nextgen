package nextgen.templates.materialui;

public class CardMediaElement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _classes;
	private Object _className;
	private Object _component;
	private Object _image;
	private Object _src;
	private java.util.List<Object> _children = new java.util.ArrayList<>();

	CardMediaElement(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("CardMediaElement");
		st.add("classes", _classes);
		st.add("className", _className);
		st.add("component", _component);
		st.add("image", _image);
		st.add("src", _src);
		for (Object o : _children) st.add("children", o);
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

	static final String st = "CardMediaElement(classes,className,component,image,src,children) ::= <<<CardMedia~if(classes)~\n" + 
				"	classes=~classes~~endif~~if(className)~\n" + 
				"	className=~className~~endif~~if(component)~\n" + 
				"	component=~component~~endif~~if(image)~\n" + 
				"	image=\"~image~\"~endif~~if(src)~\n" + 
				"	src=\"~src~\"~endif~~if(children)~>\n" + 
				"	~children:{it|~it~};separator=\"\\n\"~\n" + 
				"</CardMedia>~else~ />~endif~ >>";
}  