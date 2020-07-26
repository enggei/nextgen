package nextgen.templates.materialui;

public class SpeedDialIconElement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _classes;
	private Object _className;
	private Object _icon;
	private Object _openIcon;

	SpeedDialIconElement(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("SpeedDialIconElement");
		st.add("classes", _classes);
		st.add("className", _className);
		st.add("icon", _icon);
		st.add("openIcon", _openIcon);
		return st.render().trim();
	}

	public SpeedDialIconElement setClasses(Object value) {
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

	public SpeedDialIconElement removeClasses() {
		this._classes = null;
		return this;
	} 

	public SpeedDialIconElement setClassName(Object value) {
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

	public SpeedDialIconElement removeClassName() {
		this._className = null;
		return this;
	} 

	public SpeedDialIconElement setIcon(Object value) {
		this._icon = value;
		return this;
	}

	public Object getIcon() {
		return this._icon;
	}

	public Object getIcon(Object defaultValue) {
		return this._icon == null ? defaultValue : this._icon;
	}

	public boolean hasIcon() {
		return this._icon != null;
	}

	public SpeedDialIconElement removeIcon() {
		this._icon = null;
		return this;
	} 

	public SpeedDialIconElement setOpenIcon(Object value) {
		this._openIcon = value;
		return this;
	}

	public Object getOpenIcon() {
		return this._openIcon;
	}

	public Object getOpenIcon(Object defaultValue) {
		return this._openIcon == null ? defaultValue : this._openIcon;
	}

	public boolean hasOpenIcon() {
		return this._openIcon != null;
	}

	public SpeedDialIconElement removeOpenIcon() {
		this._openIcon = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		SpeedDialIconElement that = (SpeedDialIconElement) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "SpeedDialIconElement(classes,className,icon,openIcon) ::= <<<SpeedDialIcon~if(classes)~\n" + 
				"	classes=~classes~~endif~~if(className)~\n" + 
				"	className=~className~~endif~~if(icon)~\n" + 
				"	icon=~icon~~endif~~if(openIcon)~\n" + 
				"	openIcon=~openIcon~~endif~ /> >>";
}  