package nextgen.templates.materialui;

public class PaperElement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _classes;
	private Object _className;
	private Object _component;
	private Object _elevation;
	private Object _square;
	private Object _variant;
	private java.util.List<Object> _children = new java.util.ArrayList<>();

	PaperElement(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("PaperElement");
		st.add("classes", _classes);
		st.add("className", _className);
		st.add("component", _component);
		st.add("elevation", _elevation);
		st.add("square", _square);
		st.add("variant", _variant);
		for (Object o : _children) st.add("children", o);
		return st.render().trim();
	}

	public PaperElement setClasses(Object value) {
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

	public PaperElement removeClasses() {
		this._classes = null;
		return this;
	} 

	public PaperElement setClassName(Object value) {
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

	public PaperElement removeClassName() {
		this._className = null;
		return this;
	} 

	public PaperElement setComponent(Object value) {
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

	public PaperElement removeComponent() {
		this._component = null;
		return this;
	} 

	public PaperElement setElevation(Object value) {
		this._elevation = value;
		return this;
	}

	public Object getElevation() {
		return this._elevation;
	}

	public Object getElevation(Object defaultValue) {
		return this._elevation == null ? defaultValue : this._elevation;
	}

	public boolean hasElevation() {
		return this._elevation != null;
	}

	public PaperElement removeElevation() {
		this._elevation = null;
		return this;
	} 

	public PaperElement setSquare(Object value) {
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

	public PaperElement removeSquare() {
		this._square = null;
		return this;
	} 

	public PaperElement setVariant(Object value) {
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

	public PaperElement removeVariant() {
		this._variant = null;
		return this;
	} 

	public PaperElement addChildren(Object value) {
		this._children.add(value);
		return this;
	}

	public PaperElement setChildren(Object[] value) {
		this._children.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public PaperElement setChildren(java.util.Collection<Object> values) {
		this._children.addAll(values);
		return this;
	}

	public PaperElement removeChildren(Object value) {
		this._children.remove(value);
		return this;
	}

	public PaperElement removeChildren(int index) {
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
		PaperElement that = (PaperElement) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "PaperElement(classes,className,component,elevation,square,variant,children) ::= <<<Paper~if(classes)~\n" + 
				"	classes=~classes~~endif~~if(className)~\n" + 
				"	className=~className~~endif~~if(component)~\n" + 
				"	component=~component~~endif~~if(elevation)~\n" + 
				"	elevation=~elevation~~endif~~if(square)~\n" + 
				"	square~endif~~if(variant)~\n" + 
				"	variant=\"~variant~\"~endif~~if(children)~>\n" + 
				"	~children:{it|~it~};separator=\"\\n\"~\n" + 
				"</Paper>~else~ />~endif~ >>";
}  