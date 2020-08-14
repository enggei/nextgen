package nextgen.templates.materialui;

public class MenuItemElement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _classes;
	private Object _className;
	private Object _component;
	private Object _dense;
	private Object _disableGutters;
	private Object _id;
	private Object _ListItemClasses;
	private Object _onClick;
	private java.util.List<Object> _children = new java.util.ArrayList<>();

	MenuItemElement(org.stringtemplate.v4.STGroup stGroup) {
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
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("MenuItemElement");
		st.add("classes", _classes);
		st.add("className", _className);
		st.add("component", _component);
		st.add("dense", _dense);
		st.add("disableGutters", _disableGutters);
		st.add("id", _id);
		st.add("ListItemClasses", _ListItemClasses);
		st.add("onClick", _onClick);
		for (Object o : _children) st.add("children", o);
		return st.render().trim();
	}

	public MenuItemElement setClasses(Object value) {
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

	public MenuItemElement removeClasses() {
		this._classes = null;
		return this;
	} 

	public MenuItemElement setClassName(Object value) {
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

	public MenuItemElement removeClassName() {
		this._className = null;
		return this;
	} 

	public MenuItemElement setComponent(Object value) {
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

	public MenuItemElement removeComponent() {
		this._component = null;
		return this;
	} 

	public MenuItemElement setDense(Object value) {
		this._dense = value;
		return this;
	}

	public Object getDense() {
		return this._dense;
	}

	public Object getDense(Object defaultValue) {
		return this._dense == null ? defaultValue : this._dense;
	}

	public boolean hasDense() {
		return this._dense != null;
	}

	public MenuItemElement removeDense() {
		this._dense = null;
		return this;
	} 

	public MenuItemElement setDisableGutters(Object value) {
		this._disableGutters = value;
		return this;
	}

	public Object getDisableGutters() {
		return this._disableGutters;
	}

	public Object getDisableGutters(Object defaultValue) {
		return this._disableGutters == null ? defaultValue : this._disableGutters;
	}

	public boolean hasDisableGutters() {
		return this._disableGutters != null;
	}

	public MenuItemElement removeDisableGutters() {
		this._disableGutters = null;
		return this;
	} 

	public MenuItemElement setId(Object value) {
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

	public MenuItemElement removeId() {
		this._id = null;
		return this;
	} 

	public MenuItemElement setListItemClasses(Object value) {
		this._ListItemClasses = value;
		return this;
	}

	public Object getListItemClasses() {
		return this._ListItemClasses;
	}

	public Object getListItemClasses(Object defaultValue) {
		return this._ListItemClasses == null ? defaultValue : this._ListItemClasses;
	}

	public boolean hasListItemClasses() {
		return this._ListItemClasses != null;
	}

	public MenuItemElement removeListItemClasses() {
		this._ListItemClasses = null;
		return this;
	} 

	public MenuItemElement setOnClick(Object value) {
		this._onClick = value;
		return this;
	}

	public Object getOnClick() {
		return this._onClick;
	}

	public Object getOnClick(Object defaultValue) {
		return this._onClick == null ? defaultValue : this._onClick;
	}

	public boolean hasOnClick() {
		return this._onClick != null;
	}

	public MenuItemElement removeOnClick() {
		this._onClick = null;
		return this;
	} 

	public MenuItemElement addChildren(Object value) {
		this._children.add(value);
		return this;
	}

	public MenuItemElement setChildren(Object[] value) {
		this._children.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public MenuItemElement setChildren(java.util.Collection<Object> values) {
		this._children.addAll(values);
		return this;
	}

	public MenuItemElement removeChildren(Object value) {
		this._children.remove(value);
		return this;
	}

	public MenuItemElement removeChildren(int index) {
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
		MenuItemElement that = (MenuItemElement) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "MenuItemElement(classes,className,component,dense,disableGutters,id,ListItemClasses,onClick,children) ::= <<<MenuItem~if(classes)~\n" + 
				"	classes=~classes~~endif~~if(className)~\n" + 
				"	className=~className~~endif~~if(component)~\n" + 
				"	component=~component~~endif~~if(dense)~\n" + 
				"	dense~endif~~if(disableGutters)~\n" + 
				"	disableGutters~endif~~if(id)~\n" + 
				"	id=\"~id~\"~endif~~if(ListItemClasses)~\n" + 
				"	ListItemClasses=~ListItemClasses~~endif~~if(onClick)~\n" + 
				"	onClick=~onClick~~endif~~if(children)~>\n" + 
				"	~children:{it|~it~};separator=\"\\n\"~\n" + 
				"</MenuItem>~else~ />~endif~ >>";
}  