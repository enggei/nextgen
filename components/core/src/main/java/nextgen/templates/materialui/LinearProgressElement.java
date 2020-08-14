package nextgen.templates.materialui;

public class LinearProgressElement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _classes;
	private Object _className;
	private Object _color;
	private Object _id;
	private Object _value;
	private Object _valueBuffer;
	private Object _variant;

	LinearProgressElement(org.stringtemplate.v4.STGroup stGroup) {
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
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("LinearProgressElement");
		st.add("classes", _classes);
		st.add("className", _className);
		st.add("color", _color);
		st.add("id", _id);
		st.add("value", _value);
		st.add("valueBuffer", _valueBuffer);
		st.add("variant", _variant);
		return st.render().trim();
	}

	public LinearProgressElement setClasses(Object value) {
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

	public LinearProgressElement removeClasses() {
		this._classes = null;
		return this;
	} 

	public LinearProgressElement setClassName(Object value) {
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

	public LinearProgressElement removeClassName() {
		this._className = null;
		return this;
	} 

	public LinearProgressElement setColor(Object value) {
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

	public LinearProgressElement removeColor() {
		this._color = null;
		return this;
	} 

	public LinearProgressElement setId(Object value) {
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

	public LinearProgressElement removeId() {
		this._id = null;
		return this;
	} 

	public LinearProgressElement setValue(Object value) {
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

	public LinearProgressElement removeValue() {
		this._value = null;
		return this;
	} 

	public LinearProgressElement setValueBuffer(Object value) {
		this._valueBuffer = value;
		return this;
	}

	public Object getValueBuffer() {
		return this._valueBuffer;
	}

	public Object getValueBuffer(Object defaultValue) {
		return this._valueBuffer == null ? defaultValue : this._valueBuffer;
	}

	public boolean hasValueBuffer() {
		return this._valueBuffer != null;
	}

	public LinearProgressElement removeValueBuffer() {
		this._valueBuffer = null;
		return this;
	} 

	public LinearProgressElement setVariant(Object value) {
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

	public LinearProgressElement removeVariant() {
		this._variant = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		LinearProgressElement that = (LinearProgressElement) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "LinearProgressElement(classes,className,color,id,value,valueBuffer,variant) ::= <<<LinearProgress~if(classes)~\n" + 
				"	classes=~classes~~endif~~if(className)~\n" + 
				"	className=~className~~endif~~if(color)~\n" + 
				"	color=\"~color~\"~endif~~if(id)~\n" + 
				"	id=\"~id~\"~endif~~if(value)~\n" + 
				"	value=~value~~endif~~if(valueBuffer)~\n" + 
				"	valueBuffer=~valueBuffer~~endif~~if(variant)~\n" + 
				"	variant=\"~variant~\"~endif~ /> >>";
}  