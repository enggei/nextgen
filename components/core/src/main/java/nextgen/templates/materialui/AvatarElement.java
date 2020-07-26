package nextgen.templates.materialui;

public class AvatarElement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _alt;
	private Object _classes;
	private Object _className;
	private Object _component;
	private Object _imgProps;
	private Object _sizes;
	private Object _src;
	private Object _srcSet;
	private Object _variant;
	private java.util.List<Object> _children = new java.util.ArrayList<>();

	AvatarElement(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("AvatarElement");
		st.add("alt", _alt);
		st.add("classes", _classes);
		st.add("className", _className);
		st.add("component", _component);
		st.add("imgProps", _imgProps);
		st.add("sizes", _sizes);
		st.add("src", _src);
		st.add("srcSet", _srcSet);
		st.add("variant", _variant);
		for (Object o : _children) st.add("children", o);
		return st.render().trim();
	}

	public AvatarElement setAlt(Object value) {
		this._alt = value;
		return this;
	}

	public Object getAlt() {
		return this._alt;
	}

	public Object getAlt(Object defaultValue) {
		return this._alt == null ? defaultValue : this._alt;
	}

	public boolean hasAlt() {
		return this._alt != null;
	}

	public AvatarElement removeAlt() {
		this._alt = null;
		return this;
	} 

	public AvatarElement setClasses(Object value) {
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

	public AvatarElement removeClasses() {
		this._classes = null;
		return this;
	} 

	public AvatarElement setClassName(Object value) {
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

	public AvatarElement removeClassName() {
		this._className = null;
		return this;
	} 

	public AvatarElement setComponent(Object value) {
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

	public AvatarElement removeComponent() {
		this._component = null;
		return this;
	} 

	public AvatarElement setImgProps(Object value) {
		this._imgProps = value;
		return this;
	}

	public Object getImgProps() {
		return this._imgProps;
	}

	public Object getImgProps(Object defaultValue) {
		return this._imgProps == null ? defaultValue : this._imgProps;
	}

	public boolean hasImgProps() {
		return this._imgProps != null;
	}

	public AvatarElement removeImgProps() {
		this._imgProps = null;
		return this;
	} 

	public AvatarElement setSizes(Object value) {
		this._sizes = value;
		return this;
	}

	public Object getSizes() {
		return this._sizes;
	}

	public Object getSizes(Object defaultValue) {
		return this._sizes == null ? defaultValue : this._sizes;
	}

	public boolean hasSizes() {
		return this._sizes != null;
	}

	public AvatarElement removeSizes() {
		this._sizes = null;
		return this;
	} 

	public AvatarElement setSrc(Object value) {
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

	public AvatarElement removeSrc() {
		this._src = null;
		return this;
	} 

	public AvatarElement setSrcSet(Object value) {
		this._srcSet = value;
		return this;
	}

	public Object getSrcSet() {
		return this._srcSet;
	}

	public Object getSrcSet(Object defaultValue) {
		return this._srcSet == null ? defaultValue : this._srcSet;
	}

	public boolean hasSrcSet() {
		return this._srcSet != null;
	}

	public AvatarElement removeSrcSet() {
		this._srcSet = null;
		return this;
	} 

	public AvatarElement setVariant(Object value) {
		this._variant = value;
		return this;
	}

	public Object getVariant() {
		return this._variant;
	}

	public Object getVariant(Object defaultValue) {
		return this._variant == null ? defaultValue : this._variant;
	}

	public boolean hasVariant() {
		return this._variant != null;
	}

	public AvatarElement removeVariant() {
		this._variant = null;
		return this;
	} 

	public AvatarElement addChildren(Object value) {
		this._children.add(value);
		return this;
	}

	public AvatarElement setChildren(Object[] value) {
		this._children.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public AvatarElement setChildren(java.util.Collection<Object> values) {
		this._children.addAll(values);
		return this;
	}

	public AvatarElement removeChildren(Object value) {
		this._children.remove(value);
		return this;
	}

	public AvatarElement removeChildren(int index) {
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
		AvatarElement that = (AvatarElement) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "AvatarElement(alt,classes,className,component,imgProps,sizes,src,srcSet,variant,children) ::= <<<Avatar~if(alt)~\n" + 
				"	alt=\"~alt~\"~endif~~if(classes)~\n" + 
				"	classes=~classes~~endif~~if(className)~\n" + 
				"	className=~className~~endif~~if(component)~\n" + 
				"	component=~component~~endif~~if(imgProps)~\n" + 
				"	imgProps=~imgProps~~endif~~if(sizes)~\n" + 
				"	sizes=\"~sizes~\"~endif~~if(src)~\n" + 
				"	src=\"~src~\"~endif~~if(srcSet)~\n" + 
				"	srcSet=\"~srcSet~\"~endif~~if(variant)~\n" + 
				"	variant=\"~variant~\"~endif~~if(children)~>\n" + 
				"	~children:{it|~it~};separator=\"\\n\"~\n" + 
				"</Avatar>~else~ />~endif~ >>";
}  