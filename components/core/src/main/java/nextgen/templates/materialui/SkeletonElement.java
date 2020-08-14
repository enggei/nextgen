package nextgen.templates.materialui;

public class SkeletonElement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _animation;
	private Object _classes;
	private Object _className;
	private Object _component;
	private Object _height;
	private Object _id;
	private Object _variant;
	private Object _width;
	private java.util.List<Object> _children = new java.util.ArrayList<>();

	SkeletonElement(org.stringtemplate.v4.STGroup stGroup) {
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
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("SkeletonElement");
		st.add("animation", _animation);
		st.add("classes", _classes);
		st.add("className", _className);
		st.add("component", _component);
		st.add("height", _height);
		st.add("id", _id);
		st.add("variant", _variant);
		st.add("width", _width);
		for (Object o : _children) st.add("children", o);
		return st.render().trim();
	}

	public SkeletonElement setAnimation(Object value) {
		this._animation = value;
		return this;
	}

	public Object getAnimation() {
		return this._animation;
	}

	public Object getAnimation(Object defaultValue) {
		return this._animation == null ? defaultValue : this._animation;
	}

	public boolean hasAnimation() {
		return this._animation != null;
	}

	public SkeletonElement removeAnimation() {
		this._animation = null;
		return this;
	} 

	public SkeletonElement setClasses(Object value) {
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

	public SkeletonElement removeClasses() {
		this._classes = null;
		return this;
	} 

	public SkeletonElement setClassName(Object value) {
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

	public SkeletonElement removeClassName() {
		this._className = null;
		return this;
	} 

	public SkeletonElement setComponent(Object value) {
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

	public SkeletonElement removeComponent() {
		this._component = null;
		return this;
	} 

	public SkeletonElement setHeight(Object value) {
		this._height = value;
		return this;
	}

	public Object getHeight() {
		return this._height;
	}

	public Object getHeight(Object defaultValue) {
		return this._height == null ? defaultValue : this._height;
	}

	public boolean hasHeight() {
		return this._height != null;
	}

	public SkeletonElement removeHeight() {
		this._height = null;
		return this;
	} 

	public SkeletonElement setId(Object value) {
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

	public SkeletonElement removeId() {
		this._id = null;
		return this;
	} 

	public SkeletonElement setVariant(Object value) {
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

	public SkeletonElement removeVariant() {
		this._variant = null;
		return this;
	} 

	public SkeletonElement setWidth(Object value) {
		this._width = value;
		return this;
	}

	public Object getWidth() {
		return this._width;
	}

	public Object getWidth(Object defaultValue) {
		return this._width == null ? defaultValue : this._width;
	}

	public boolean hasWidth() {
		return this._width != null;
	}

	public SkeletonElement removeWidth() {
		this._width = null;
		return this;
	} 

	public SkeletonElement addChildren(Object value) {
		this._children.add(value);
		return this;
	}

	public SkeletonElement setChildren(Object[] value) {
		this._children.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public SkeletonElement setChildren(java.util.Collection<Object> values) {
		this._children.addAll(values);
		return this;
	}

	public SkeletonElement removeChildren(Object value) {
		this._children.remove(value);
		return this;
	}

	public SkeletonElement removeChildren(int index) {
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
		SkeletonElement that = (SkeletonElement) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "SkeletonElement(animation,classes,className,component,height,id,variant,width,children) ::= <<<Skeleton~if(animation)~\n" + 
				"	animation=\"~animation~\"~endif~~if(classes)~\n" + 
				"	classes=~classes~~endif~~if(className)~\n" + 
				"	className=~className~~endif~~if(component)~\n" + 
				"	component=~component~~endif~~if(height)~\n" + 
				"	height=~height~~endif~~if(id)~\n" + 
				"	id=\"~id~\"~endif~~if(variant)~\n" + 
				"	variant=\"~variant~\"~endif~~if(width)~\n" + 
				"	width=~width~~endif~~if(children)~>\n" + 
				"	~children:{it|~it~};separator=\"\\n\"~\n" + 
				"</Skeleton>~else~ />~endif~ >>";
}  