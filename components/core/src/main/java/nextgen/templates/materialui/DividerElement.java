package nextgen.templates.materialui;

public class DividerElement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _light;
	private Object _orientation;
	private Object _variant;
	private Object _className;

	DividerElement(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("DividerElement");
		st.add("light", _light);
		st.add("orientation", _orientation);
		st.add("variant", _variant);
		st.add("className", _className);
		return st.render().trim();
	}

	public DividerElement setLight(Object value) {
		this._light = value;
		return this;
	}

	public Object getLight() {
		return this._light;
	}

	public Object getLight(Object defaultValue) {
		return this._light == null ? defaultValue : this._light;
	}

	public boolean hasLight() {
		return this._light != null;
	}

	public DividerElement removeLight() {
		this._light = null;
		return this;
	} 

	public DividerElement setOrientation(Object value) {
		this._orientation = value;
		return this;
	}

	public Object getOrientation() {
		return this._orientation;
	}

	public Object getOrientation(Object defaultValue) {
		return this._orientation == null ? defaultValue : this._orientation;
	}

	public boolean hasOrientation() {
		return this._orientation != null;
	}

	public DividerElement removeOrientation() {
		this._orientation = null;
		return this;
	} 

	public DividerElement setVariant(Object value) {
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

	public DividerElement removeVariant() {
		this._variant = null;
		return this;
	} 

	public DividerElement setClassName(Object value) {
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

	public DividerElement removeClassName() {
		this._className = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		DividerElement that = (DividerElement) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "DividerElement(light,orientation,variant,className) ::= <<<Divider~if(light)~ light~endif~~if(orientation)~ orientation=\"~orientation~\"~endif~~if(variant)~ variant=\"~variant~\"~endif~~if(className)~ className={classes.~className~}~endif~ /> >>";
}  