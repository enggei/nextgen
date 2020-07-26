package nextgen.templates.materialui;

public class PaginationItemElement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _className;
	private Object _color;
	private Object _component;
	private Object _disabled;
	private Object _page;
	private Object _selected;
	private Object _shape;
	private Object _size;
	private Object _type;
	private Object _variant;

	PaginationItemElement(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("PaginationItemElement");
		st.add("className", _className);
		st.add("color", _color);
		st.add("component", _component);
		st.add("disabled", _disabled);
		st.add("page", _page);
		st.add("selected", _selected);
		st.add("shape", _shape);
		st.add("size", _size);
		st.add("type", _type);
		st.add("variant", _variant);
		return st.render().trim();
	}

	public PaginationItemElement setClassName(Object value) {
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

	public PaginationItemElement removeClassName() {
		this._className = null;
		return this;
	} 

	public PaginationItemElement setColor(Object value) {
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

	public PaginationItemElement removeColor() {
		this._color = null;
		return this;
	} 

	public PaginationItemElement setComponent(Object value) {
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

	public PaginationItemElement removeComponent() {
		this._component = null;
		return this;
	} 

	public PaginationItemElement setDisabled(Object value) {
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

	public PaginationItemElement removeDisabled() {
		this._disabled = null;
		return this;
	} 

	public PaginationItemElement setPage(Object value) {
		this._page = value;
		return this;
	}

	public Object getPage() {
		return this._page;
	}

	public Object getPage(Object defaultValue) {
		return this._page == null ? defaultValue : this._page;
	}

	public boolean hasPage() {
		return this._page != null;
	}

	public PaginationItemElement removePage() {
		this._page = null;
		return this;
	} 

	public PaginationItemElement setSelected(Object value) {
		this._selected = value;
		return this;
	}

	public Object getSelected() {
		return this._selected;
	}

	public Object getSelected(Object defaultValue) {
		return this._selected == null ? defaultValue : this._selected;
	}

	public boolean hasSelected() {
		return this._selected != null;
	}

	public PaginationItemElement removeSelected() {
		this._selected = null;
		return this;
	} 

	public PaginationItemElement setShape(Object value) {
		this._shape = value;
		return this;
	}

	public Object getShape() {
		return this._shape;
	}

	public Object getShape(Object defaultValue) {
		return this._shape == null ? defaultValue : this._shape;
	}

	public boolean hasShape() {
		return this._shape != null;
	}

	public PaginationItemElement removeShape() {
		this._shape = null;
		return this;
	} 

	public PaginationItemElement setSize(Object value) {
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

	public PaginationItemElement removeSize() {
		this._size = null;
		return this;
	} 

	public PaginationItemElement setType(Object value) {
		this._type = value;
		return this;
	}

	public Object getType() {
		return this._type;
	}

	public Object getType(Object defaultValue) {
		return this._type == null ? defaultValue : this._type;
	}

	public boolean hasType() {
		return this._type != null;
	}

	public PaginationItemElement removeType() {
		this._type = null;
		return this;
	} 

	public PaginationItemElement setVariant(Object value) {
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

	public PaginationItemElement removeVariant() {
		this._variant = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		PaginationItemElement that = (PaginationItemElement) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "PaginationItemElement(className,color,component,disabled,page,selected,shape,size,type,variant) ::= <<<PaginationItem~if(className)~\n" + 
				"	className=~className~~endif~~if(color)~\n" + 
				"	color=\"~color~\"~endif~~if(component)~\n" + 
				"	component=~component~~endif~~if(disabled)~\n" + 
				"	disabled~endif~~if(page)~\n" + 
				"	page=~page~~endif~~if(selected)~\n" + 
				"	selected~endif~~if(shape)~\n" + 
				"	shape=\"~shape~\"~endif~~if(size)~\n" + 
				"	size=\"~size~\"~endif~~if(type)~\n" + 
				"	type=\"~type~\"~endif~~if(variant)~\n" + 
				"	variant=\"~variant~\"~endif~ /> >>";
}  