package nextgen.templates.materialui;

public class UnstableTrapFocusElement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _className;
	private Object _disableAutoFocus;
	private Object _disableEnforceFocus;
	private Object _disableRestoreFocus;
	private Object _getDoc;
	private Object _id;
	private Boolean _isEnabled;
	private Object _key;
	private Object _style;
	private java.util.List<Object> _children = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _attribute = new java.util.ArrayList<>();

	UnstableTrapFocusElement(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("UnstableTrapFocusElement");
		st.add("className", _className);
		st.add("disableAutoFocus", _disableAutoFocus);
		st.add("disableEnforceFocus", _disableEnforceFocus);
		st.add("disableRestoreFocus", _disableRestoreFocus);
		st.add("getDoc", _getDoc);
		st.add("id", _id);
		st.add("isEnabled", _isEnabled);
		st.add("key", _key);
		st.add("style", _style);
		for (Object o : _children) st.add("children", o);
		for (java.util.Map<String, Object> map : _attribute) st.addAggr("attribute.{name,value}", map.get("name"), map.get("value"));
		return st.render().trim();
	}

	public UnstableTrapFocusElement setClassName(Object value) {
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

	public UnstableTrapFocusElement removeClassName() {
		this._className = null;
		return this;
	} 

	public UnstableTrapFocusElement setDisableAutoFocus(Object value) {
		this._disableAutoFocus = value;
		return this;
	}

	public Object getDisableAutoFocus() {
		return this._disableAutoFocus;
	}

	public Object getDisableAutoFocus(Object defaultValue) {
		return this._disableAutoFocus == null ? defaultValue : this._disableAutoFocus;
	}

	public boolean hasDisableAutoFocus() {
		return this._disableAutoFocus != null;
	}

	public UnstableTrapFocusElement removeDisableAutoFocus() {
		this._disableAutoFocus = null;
		return this;
	} 

	public UnstableTrapFocusElement setDisableEnforceFocus(Object value) {
		this._disableEnforceFocus = value;
		return this;
	}

	public Object getDisableEnforceFocus() {
		return this._disableEnforceFocus;
	}

	public Object getDisableEnforceFocus(Object defaultValue) {
		return this._disableEnforceFocus == null ? defaultValue : this._disableEnforceFocus;
	}

	public boolean hasDisableEnforceFocus() {
		return this._disableEnforceFocus != null;
	}

	public UnstableTrapFocusElement removeDisableEnforceFocus() {
		this._disableEnforceFocus = null;
		return this;
	} 

	public UnstableTrapFocusElement setDisableRestoreFocus(Object value) {
		this._disableRestoreFocus = value;
		return this;
	}

	public Object getDisableRestoreFocus() {
		return this._disableRestoreFocus;
	}

	public Object getDisableRestoreFocus(Object defaultValue) {
		return this._disableRestoreFocus == null ? defaultValue : this._disableRestoreFocus;
	}

	public boolean hasDisableRestoreFocus() {
		return this._disableRestoreFocus != null;
	}

	public UnstableTrapFocusElement removeDisableRestoreFocus() {
		this._disableRestoreFocus = null;
		return this;
	} 

	public UnstableTrapFocusElement setGetDoc(Object value) {
		this._getDoc = value;
		return this;
	}

	public Object getGetDoc() {
		return this._getDoc;
	}

	public Object getGetDoc(Object defaultValue) {
		return this._getDoc == null ? defaultValue : this._getDoc;
	}

	public boolean hasGetDoc() {
		return this._getDoc != null;
	}

	public UnstableTrapFocusElement removeGetDoc() {
		this._getDoc = null;
		return this;
	} 

	public UnstableTrapFocusElement setId(Object value) {
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

	public UnstableTrapFocusElement removeId() {
		this._id = null;
		return this;
	} 

	public UnstableTrapFocusElement setIsEnabled(Boolean value) {
		this._isEnabled = value;
		return this;
	}

	public Boolean getIsEnabled() {
		return this._isEnabled;
	}

	public Boolean getIsEnabled(Boolean defaultValue) {
		return this._isEnabled == null ? defaultValue : this._isEnabled;
	}

	public boolean hasIsEnabled() {
		return this._isEnabled != null;
	}

	public UnstableTrapFocusElement removeIsEnabled() {
		this._isEnabled = null;
		return this;
	} 

	public UnstableTrapFocusElement setKey(Object value) {
		this._key = value;
		return this;
	}

	public Object getKey() {
		return this._key;
	}

	public Object getKey(Object defaultValue) {
		return this._key == null ? defaultValue : this._key;
	}

	public boolean hasKey() {
		return this._key != null;
	}

	public UnstableTrapFocusElement removeKey() {
		this._key = null;
		return this;
	} 

	public UnstableTrapFocusElement setStyle(Object value) {
		this._style = value;
		return this;
	}

	public Object getStyle() {
		return this._style;
	}

	public Object getStyle(Object defaultValue) {
		return this._style == null ? defaultValue : this._style;
	}

	public boolean hasStyle() {
		return this._style != null;
	}

	public UnstableTrapFocusElement removeStyle() {
		this._style = null;
		return this;
	} 

	public UnstableTrapFocusElement addChildren(Object value) {
		this._children.add(value);
		return this;
	}

	public UnstableTrapFocusElement setChildren(Object[] value) {
		this._children.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public UnstableTrapFocusElement setChildren(java.util.Collection<Object> values) {
		this._children.addAll(values);
		return this;
	}

	public UnstableTrapFocusElement removeChildren(Object value) {
		this._children.remove(value);
		return this;
	}

	public UnstableTrapFocusElement removeChildren(int index) {
		this._children.remove(index);
		return this;
	}

	public java.util.List<Object> getChildren() {
		return this._children;
	} 

	public UnstableTrapFocusElement addAttribute(Object _name, Object _value) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		map.put("value", _value);
		this._attribute.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getAttribute() {
		return this._attribute;
	}

	public UnstableTrapFocusElement addAttribute(UnstableTrapFocusElement_Attribute value) {
		return addAttribute(value._name, value._value);
	}

	public java.util.stream.Stream<UnstableTrapFocusElement_Attribute> streamAttribute() {
		return this._attribute.stream().map(UnstableTrapFocusElement_Attribute::new);
	}

	public java.util.List<Object> getAttribute_Name() {
		return streamAttribute().map(UnstableTrapFocusElement_Attribute::getName).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getAttribute_Value() {
		return streamAttribute().map(UnstableTrapFocusElement_Attribute::getValue).collect(java.util.stream.Collectors.toList());
	}


	public static final class UnstableTrapFocusElement_Attribute {

		Object _name;
		Object _value;

		public UnstableTrapFocusElement_Attribute(Object _name, Object _value) {
			this._name = _name;
			this._value = _value;
		}

		private UnstableTrapFocusElement_Attribute(java.util.Map<String, Object> map) {
			this._name = (Object) map.get("name");
			this._value = (Object) map.get("value");
		}

		public Object getName() {
			return this._name;
		}

		public Object getValue() {
			return this._value;
		}

	}  

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		UnstableTrapFocusElement that = (UnstableTrapFocusElement) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "UnstableTrapFocusElement(className,disableAutoFocus,disableEnforceFocus,disableRestoreFocus,getDoc,id,isEnabled,key,style,attribute,children) ::= <<<UnstableTrapFocus~if(className)~\n" + 
				"	className=~className~~endif~~if(disableAutoFocus)~\n" + 
				"	disableAutoFocus~endif~~if(disableEnforceFocus)~\n" + 
				"	disableEnforceFocus~endif~~if(disableRestoreFocus)~\n" + 
				"	disableRestoreFocus~endif~\n" + 
				"	getDoc=~getDoc~~if(id)~\n" + 
				"	id=\"~id~\"~endif~\n" + 
				"	isEnabled=~isEnabled~~if(key)~\n" + 
				"	key=~key~~endif~\n" + 
				"	open~if(style)~\n" + 
				"	style=~style~~endif~~attribute:{it|\n" + 
				"	\n" + 
				"	~it.name~=~it.value~}~~if(children)~>\n" + 
				"	~children:{it|~it~};separator=\"\\n\"~\n" + 
				"</UnstableTrapFocus>~else~ />~endif~ >>";
}  