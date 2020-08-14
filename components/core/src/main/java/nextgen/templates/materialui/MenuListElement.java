package nextgen.templates.materialui;

public class MenuListElement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _autoFocus;
	private Object _autoFocusItem;
	private Object _className;
	private Object _disabledItemsFocusable;
	private Object _disableListWrap;
	private Object _id;
	private Object _variant;
	private java.util.List<Object> _children = new java.util.ArrayList<>();

	MenuListElement(org.stringtemplate.v4.STGroup stGroup) {
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
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("MenuListElement");
		st.add("autoFocus", _autoFocus);
		st.add("autoFocusItem", _autoFocusItem);
		st.add("className", _className);
		st.add("disabledItemsFocusable", _disabledItemsFocusable);
		st.add("disableListWrap", _disableListWrap);
		st.add("id", _id);
		st.add("variant", _variant);
		for (Object o : _children) st.add("children", o);
		return st.render().trim();
	}

	public MenuListElement setAutoFocus(Object value) {
		this._autoFocus = value;
		return this;
	}

	public Object getAutoFocus() {
		return this._autoFocus;
	}

	public Object getAutoFocus(Object defaultValue) {
		return this._autoFocus == null ? defaultValue : this._autoFocus;
	}

	public boolean hasAutoFocus() {
		return this._autoFocus != null;
	}

	public MenuListElement removeAutoFocus() {
		this._autoFocus = null;
		return this;
	} 

	public MenuListElement setAutoFocusItem(Object value) {
		this._autoFocusItem = value;
		return this;
	}

	public Object getAutoFocusItem() {
		return this._autoFocusItem;
	}

	public Object getAutoFocusItem(Object defaultValue) {
		return this._autoFocusItem == null ? defaultValue : this._autoFocusItem;
	}

	public boolean hasAutoFocusItem() {
		return this._autoFocusItem != null;
	}

	public MenuListElement removeAutoFocusItem() {
		this._autoFocusItem = null;
		return this;
	} 

	public MenuListElement setClassName(Object value) {
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

	public MenuListElement removeClassName() {
		this._className = null;
		return this;
	} 

	public MenuListElement setDisabledItemsFocusable(Object value) {
		this._disabledItemsFocusable = value;
		return this;
	}

	public Object getDisabledItemsFocusable() {
		return this._disabledItemsFocusable;
	}

	public Object getDisabledItemsFocusable(Object defaultValue) {
		return this._disabledItemsFocusable == null ? defaultValue : this._disabledItemsFocusable;
	}

	public boolean hasDisabledItemsFocusable() {
		return this._disabledItemsFocusable != null;
	}

	public MenuListElement removeDisabledItemsFocusable() {
		this._disabledItemsFocusable = null;
		return this;
	} 

	public MenuListElement setDisableListWrap(Object value) {
		this._disableListWrap = value;
		return this;
	}

	public Object getDisableListWrap() {
		return this._disableListWrap;
	}

	public Object getDisableListWrap(Object defaultValue) {
		return this._disableListWrap == null ? defaultValue : this._disableListWrap;
	}

	public boolean hasDisableListWrap() {
		return this._disableListWrap != null;
	}

	public MenuListElement removeDisableListWrap() {
		this._disableListWrap = null;
		return this;
	} 

	public MenuListElement setId(Object value) {
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

	public MenuListElement removeId() {
		this._id = null;
		return this;
	} 

	public MenuListElement setVariant(Object value) {
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

	public MenuListElement removeVariant() {
		this._variant = null;
		return this;
	} 

	public MenuListElement addChildren(Object value) {
		this._children.add(value);
		return this;
	}

	public MenuListElement setChildren(Object[] value) {
		this._children.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public MenuListElement setChildren(java.util.Collection<Object> values) {
		this._children.addAll(values);
		return this;
	}

	public MenuListElement removeChildren(Object value) {
		this._children.remove(value);
		return this;
	}

	public MenuListElement removeChildren(int index) {
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
		MenuListElement that = (MenuListElement) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "MenuListElement(autoFocus,autoFocusItem,className,disabledItemsFocusable,disableListWrap,id,variant,children) ::= <<<MenuList~if(autoFocus)~\n" + 
				"	autoFocus~endif~~if(autoFocusItem)~\n" + 
				"	autoFocusItem~endif~~if(className)~\n" + 
				"	className=~className~~endif~~if(disabledItemsFocusable)~\n" + 
				"	disabledItemsFocusable~endif~~if(disableListWrap)~\n" + 
				"	disableListWrap~endif~~if(id)~\n" + 
				"	id=\"~id~\"~endif~~if(variant)~\n" + 
				"	variant=\"~variant~\"~endif~~if(children)~>\n" + 
				"	~children:{it|~it~};separator=\"\\n\"~\n" + 
				"</MenuList>~else~ />~endif~ >>";
}  