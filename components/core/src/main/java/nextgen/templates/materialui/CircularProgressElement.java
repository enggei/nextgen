package nextgen.templates.materialui;

public class CircularProgressElement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _classes;
	private Object _className;
	private Object _color;
	private Object _disableShrink;
	private Object _id;
	private Object _size;
	private Object _thickness;
	private Object _value;
	private Object _variant;

	CircularProgressElement(org.stringtemplate.v4.STGroup stGroup) {
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
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("CircularProgressElement");
		st.add("classes", _classes);
		st.add("className", _className);
		st.add("color", _color);
		st.add("disableShrink", _disableShrink);
		st.add("id", _id);
		st.add("size", _size);
		st.add("thickness", _thickness);
		st.add("value", _value);
		st.add("variant", _variant);
		return st.render().trim();
	}

	public CircularProgressElement setClasses(Object value) {
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

	public CircularProgressElement removeClasses() {
		this._classes = null;
		return this;
	} 

	public CircularProgressElement setClassName(Object value) {
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

	public CircularProgressElement removeClassName() {
		this._className = null;
		return this;
	} 

	public CircularProgressElement setColor(Object value) {
		this._color = value;
		return this;
	}

	public Object getColor() {
		return this._color;
	}

	public Object getColor(Object defaultValue) {
		return this._color == null ? defaultValue : this._color;
	}

	public boolean hasColor() {
		return this._color != null;
	}

	public CircularProgressElement removeColor() {
		this._color = null;
		return this;
	} 

	public CircularProgressElement setDisableShrink(Object value) {
		this._disableShrink = value;
		return this;
	}

	public Object getDisableShrink() {
		return this._disableShrink;
	}

	public Object getDisableShrink(Object defaultValue) {
		return this._disableShrink == null ? defaultValue : this._disableShrink;
	}

	public boolean hasDisableShrink() {
		return this._disableShrink != null;
	}

	public CircularProgressElement removeDisableShrink() {
		this._disableShrink = null;
		return this;
	} 

	public CircularProgressElement setId(Object value) {
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

	public CircularProgressElement removeId() {
		this._id = null;
		return this;
	} 

	public CircularProgressElement setSize(Object value) {
		this._size = value;
		return this;
	}

	public Object getSize() {
		return this._size;
	}

	public Object getSize(Object defaultValue) {
		return this._size == null ? defaultValue : this._size;
	}

	public boolean hasSize() {
		return this._size != null;
	}

	public CircularProgressElement removeSize() {
		this._size = null;
		return this;
	} 

	public CircularProgressElement setThickness(Object value) {
		this._thickness = value;
		return this;
	}

	public Object getThickness() {
		return this._thickness;
	}

	public Object getThickness(Object defaultValue) {
		return this._thickness == null ? defaultValue : this._thickness;
	}

	public boolean hasThickness() {
		return this._thickness != null;
	}

	public CircularProgressElement removeThickness() {
		this._thickness = null;
		return this;
	} 

	public CircularProgressElement setValue(Object value) {
		this._value = value;
		return this;
	}

	public Object getValue() {
		return this._value;
	}

	public Object getValue(Object defaultValue) {
		return this._value == null ? defaultValue : this._value;
	}

	public boolean hasValue() {
		return this._value != null;
	}

	public CircularProgressElement removeValue() {
		this._value = null;
		return this;
	} 

	public CircularProgressElement setVariant(Object value) {
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

	public CircularProgressElement removeVariant() {
		this._variant = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		CircularProgressElement that = (CircularProgressElement) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "CircularProgressElement(classes,className,color,disableShrink,id,size,thickness,value,variant) ::= <<<CircularProgress~if(classes)~\n" + 
				"	classes=~classes~~endif~~if(className)~\n" + 
				"	className=~className~~endif~~if(color)~\n" + 
				"	color=\"~color~\"~endif~~if(disableShrink)~\n" + 
				"	disableShrink~endif~~if(id)~\n" + 
				"	id=\"~id~\"~endif~~if(size)~\n" + 
				"	size=~size~~endif~~if(thickness)~\n" + 
				"	thickness=~thickness~~endif~~if(value)~\n" + 
				"	value=~value~~endif~~if(variant)~\n" + 
				"	variant=\"~variant~\"~endif~ /> >>";
}  