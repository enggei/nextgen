package nextgen.templates.materialui;

public class ChipElement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _avatar;
	private Object _classes;
	private Object _className;
	private Object _clickable;
	private Object _color;
	private Object _component;
	private Object _deleteIcon;
	private Object _disabled;
	private Object _icon;
	private Object _label;
	private Object _onDelete;
	private Object _size;
	private Object _variant;
	private java.util.List<Object> _children = new java.util.ArrayList<>();

	ChipElement(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("ChipElement");
		st.add("avatar", _avatar);
		st.add("classes", _classes);
		st.add("className", _className);
		st.add("clickable", _clickable);
		st.add("color", _color);
		st.add("component", _component);
		st.add("deleteIcon", _deleteIcon);
		st.add("disabled", _disabled);
		st.add("icon", _icon);
		st.add("label", _label);
		st.add("onDelete", _onDelete);
		st.add("size", _size);
		st.add("variant", _variant);
		for (Object o : _children) st.add("children", o);
		return st.render().trim();
	}

	public ChipElement setAvatar(Object value) {
		this._avatar = value;
		return this;
	}

	public Object getAvatar() {
		return this._avatar;
	}

	public Object getAvatar(Object defaultValue) {
		return this._avatar == null ? defaultValue : this._avatar;
	}

	public boolean hasAvatar() {
		return this._avatar != null;
	}

	public ChipElement removeAvatar() {
		this._avatar = null;
		return this;
	} 

	public ChipElement setClasses(Object value) {
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

	public ChipElement removeClasses() {
		this._classes = null;
		return this;
	} 

	public ChipElement setClassName(Object value) {
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

	public ChipElement removeClassName() {
		this._className = null;
		return this;
	} 

	public ChipElement setClickable(Object value) {
		this._clickable = value;
		return this;
	}

	public Object getClickable() {
		return this._clickable;
	}

	public Object getClickable(Object defaultValue) {
		return this._clickable == null ? defaultValue : this._clickable;
	}

	public boolean hasClickable() {
		return this._clickable != null;
	}

	public ChipElement removeClickable() {
		this._clickable = null;
		return this;
	} 

	public ChipElement setColor(Object value) {
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

	public ChipElement removeColor() {
		this._color = null;
		return this;
	} 

	public ChipElement setComponent(Object value) {
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

	public ChipElement removeComponent() {
		this._component = null;
		return this;
	} 

	public ChipElement setDeleteIcon(Object value) {
		this._deleteIcon = value;
		return this;
	}

	public Object getDeleteIcon() {
		return this._deleteIcon;
	}

	public Object getDeleteIcon(Object defaultValue) {
		return this._deleteIcon == null ? defaultValue : this._deleteIcon;
	}

	public boolean hasDeleteIcon() {
		return this._deleteIcon != null;
	}

	public ChipElement removeDeleteIcon() {
		this._deleteIcon = null;
		return this;
	} 

	public ChipElement setDisabled(Object value) {
		this._disabled = value;
		return this;
	}

	public Object getDisabled() {
		return this._disabled;
	}

	public Object getDisabled(Object defaultValue) {
		return this._disabled == null ? defaultValue : this._disabled;
	}

	public boolean hasDisabled() {
		return this._disabled != null;
	}

	public ChipElement removeDisabled() {
		this._disabled = null;
		return this;
	} 

	public ChipElement setIcon(Object value) {
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

	public ChipElement removeIcon() {
		this._icon = null;
		return this;
	} 

	public ChipElement setLabel(Object value) {
		this._label = value;
		return this;
	}

	public Object getLabel() {
		return this._label;
	}

	public Object getLabel(Object defaultValue) {
		return this._label == null ? defaultValue : this._label;
	}

	public boolean hasLabel() {
		return this._label != null;
	}

	public ChipElement removeLabel() {
		this._label = null;
		return this;
	} 

	public ChipElement setOnDelete(Object value) {
		this._onDelete = value;
		return this;
	}

	public Object getOnDelete() {
		return this._onDelete;
	}

	public Object getOnDelete(Object defaultValue) {
		return this._onDelete == null ? defaultValue : this._onDelete;
	}

	public boolean hasOnDelete() {
		return this._onDelete != null;
	}

	public ChipElement removeOnDelete() {
		this._onDelete = null;
		return this;
	} 

	public ChipElement setSize(Object value) {
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

	public ChipElement removeSize() {
		this._size = null;
		return this;
	} 

	public ChipElement setVariant(Object value) {
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

	public ChipElement removeVariant() {
		this._variant = null;
		return this;
	} 

	public ChipElement addChildren(Object value) {
		this._children.add(value);
		return this;
	}

	public ChipElement setChildren(Object[] value) {
		this._children.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public ChipElement setChildren(java.util.Collection<Object> values) {
		this._children.addAll(values);
		return this;
	}

	public ChipElement removeChildren(Object value) {
		this._children.remove(value);
		return this;
	}

	public ChipElement removeChildren(int index) {
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
		ChipElement that = (ChipElement) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "ChipElement(avatar,classes,className,clickable,color,component,deleteIcon,disabled,icon,label,onDelete,size,variant,children) ::= <<<Chip~if(avatar)~\n" + 
				"	avatar=~avatar~~endif~~if(classes)~\n" + 
				"	classes=~classes~~endif~~if(className)~\n" + 
				"	className=~className~~endif~~if(clickable)~\n" + 
				"	clickable~endif~~if(color)~\n" + 
				"	color=\"~color~\"~endif~~if(component)~\n" + 
				"	component=~component~~endif~~if(deleteIcon)~\n" + 
				"	deleteIcon=~deleteIcon~~endif~~if(disabled)~\n" + 
				"	disabled~endif~~if(icon)~\n" + 
				"	icon=~icon~~endif~~if(label)~\n" + 
				"	label=~label~~endif~~if(onDelete)~\n" + 
				"	onDelete=~onDelete~~endif~~if(size)~\n" + 
				"	size=\"~size~\"~endif~~if(variant)~\n" + 
				"	variant=\"~variant~\"~endif~~if(children)~>\n" + 
				"	~children:{it|~it~};separator=\"\\n\"~\n" + 
				"</Chip>~else~ />~endif~ >>";
}  