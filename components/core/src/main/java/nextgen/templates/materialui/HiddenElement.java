package nextgen.templates.materialui;

public class HiddenElement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _className;
	private Object _id;
	private Object _implementation;
	private Object _initialWidth;
	private Object _lgDown;
	private Object _lgUp;
	private Object _mdDown;
	private Object _mdUp;
	private Object _only;
	private Object _smDown;
	private Object _smUp;
	private Object _style;
	private Object _xlDown;
	private Object _xlUp;
	private Object _xsDown;
	private Object _xsUp;
	private java.util.List<Object> _children = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _attribute = new java.util.ArrayList<>();

	HiddenElement(org.stringtemplate.v4.STGroup stGroup) {
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
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("HiddenElement");
		st.add("className", _className);
		st.add("id", _id);
		st.add("implementation", _implementation);
		st.add("initialWidth", _initialWidth);
		st.add("lgDown", _lgDown);
		st.add("lgUp", _lgUp);
		st.add("mdDown", _mdDown);
		st.add("mdUp", _mdUp);
		st.add("only", _only);
		st.add("smDown", _smDown);
		st.add("smUp", _smUp);
		st.add("style", _style);
		st.add("xlDown", _xlDown);
		st.add("xlUp", _xlUp);
		st.add("xsDown", _xsDown);
		st.add("xsUp", _xsUp);
		for (Object o : _children) st.add("children", o);
		for (java.util.Map<String, Object> map : _attribute) st.addAggr("attribute.{name,value}", map.get("name"), map.get("value"));
		return st.render().trim();
	}

	public HiddenElement setClassName(Object value) {
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

	public HiddenElement removeClassName() {
		this._className = null;
		return this;
	} 

	public HiddenElement setId(Object value) {
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

	public HiddenElement removeId() {
		this._id = null;
		return this;
	} 

	public HiddenElement setImplementation(Object value) {
		this._implementation = value;
		return this;
	}

	public Object getImplementation() {
		return this._implementation;
	}

	public Object getImplementation(Object defaultValue) {
		return this._implementation == null ? defaultValue : this._implementation;
	}

	public boolean hasImplementation() {
		return this._implementation != null;
	}

	public HiddenElement removeImplementation() {
		this._implementation = null;
		return this;
	} 

	public HiddenElement setInitialWidth(Object value) {
		this._initialWidth = value;
		return this;
	}

	public Object getInitialWidth() {
		return this._initialWidth;
	}

	public Object getInitialWidth(Object defaultValue) {
		return this._initialWidth == null ? defaultValue : this._initialWidth;
	}

	public boolean hasInitialWidth() {
		return this._initialWidth != null;
	}

	public HiddenElement removeInitialWidth() {
		this._initialWidth = null;
		return this;
	} 

	public HiddenElement setLgDown(Object value) {
		this._lgDown = value;
		return this;
	}

	public Object getLgDown() {
		return this._lgDown;
	}

	public Object getLgDown(Object defaultValue) {
		return this._lgDown == null ? defaultValue : this._lgDown;
	}

	public boolean hasLgDown() {
		return this._lgDown != null;
	}

	public HiddenElement removeLgDown() {
		this._lgDown = null;
		return this;
	} 

	public HiddenElement setLgUp(Object value) {
		this._lgUp = value;
		return this;
	}

	public Object getLgUp() {
		return this._lgUp;
	}

	public Object getLgUp(Object defaultValue) {
		return this._lgUp == null ? defaultValue : this._lgUp;
	}

	public boolean hasLgUp() {
		return this._lgUp != null;
	}

	public HiddenElement removeLgUp() {
		this._lgUp = null;
		return this;
	} 

	public HiddenElement setMdDown(Object value) {
		this._mdDown = value;
		return this;
	}

	public Object getMdDown() {
		return this._mdDown;
	}

	public Object getMdDown(Object defaultValue) {
		return this._mdDown == null ? defaultValue : this._mdDown;
	}

	public boolean hasMdDown() {
		return this._mdDown != null;
	}

	public HiddenElement removeMdDown() {
		this._mdDown = null;
		return this;
	} 

	public HiddenElement setMdUp(Object value) {
		this._mdUp = value;
		return this;
	}

	public Object getMdUp() {
		return this._mdUp;
	}

	public Object getMdUp(Object defaultValue) {
		return this._mdUp == null ? defaultValue : this._mdUp;
	}

	public boolean hasMdUp() {
		return this._mdUp != null;
	}

	public HiddenElement removeMdUp() {
		this._mdUp = null;
		return this;
	} 

	public HiddenElement setOnly(Object value) {
		this._only = value;
		return this;
	}

	public Object getOnly() {
		return this._only;
	}

	public Object getOnly(Object defaultValue) {
		return this._only == null ? defaultValue : this._only;
	}

	public boolean hasOnly() {
		return this._only != null;
	}

	public HiddenElement removeOnly() {
		this._only = null;
		return this;
	} 

	public HiddenElement setSmDown(Object value) {
		this._smDown = value;
		return this;
	}

	public Object getSmDown() {
		return this._smDown;
	}

	public Object getSmDown(Object defaultValue) {
		return this._smDown == null ? defaultValue : this._smDown;
	}

	public boolean hasSmDown() {
		return this._smDown != null;
	}

	public HiddenElement removeSmDown() {
		this._smDown = null;
		return this;
	} 

	public HiddenElement setSmUp(Object value) {
		this._smUp = value;
		return this;
	}

	public Object getSmUp() {
		return this._smUp;
	}

	public Object getSmUp(Object defaultValue) {
		return this._smUp == null ? defaultValue : this._smUp;
	}

	public boolean hasSmUp() {
		return this._smUp != null;
	}

	public HiddenElement removeSmUp() {
		this._smUp = null;
		return this;
	} 

	public HiddenElement setStyle(Object value) {
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

	public HiddenElement removeStyle() {
		this._style = null;
		return this;
	} 

	public HiddenElement setXlDown(Object value) {
		this._xlDown = value;
		return this;
	}

	public Object getXlDown() {
		return this._xlDown;
	}

	public Object getXlDown(Object defaultValue) {
		return this._xlDown == null ? defaultValue : this._xlDown;
	}

	public boolean hasXlDown() {
		return this._xlDown != null;
	}

	public HiddenElement removeXlDown() {
		this._xlDown = null;
		return this;
	} 

	public HiddenElement setXlUp(Object value) {
		this._xlUp = value;
		return this;
	}

	public Object getXlUp() {
		return this._xlUp;
	}

	public Object getXlUp(Object defaultValue) {
		return this._xlUp == null ? defaultValue : this._xlUp;
	}

	public boolean hasXlUp() {
		return this._xlUp != null;
	}

	public HiddenElement removeXlUp() {
		this._xlUp = null;
		return this;
	} 

	public HiddenElement setXsDown(Object value) {
		this._xsDown = value;
		return this;
	}

	public Object getXsDown() {
		return this._xsDown;
	}

	public Object getXsDown(Object defaultValue) {
		return this._xsDown == null ? defaultValue : this._xsDown;
	}

	public boolean hasXsDown() {
		return this._xsDown != null;
	}

	public HiddenElement removeXsDown() {
		this._xsDown = null;
		return this;
	} 

	public HiddenElement setXsUp(Object value) {
		this._xsUp = value;
		return this;
	}

	public Object getXsUp() {
		return this._xsUp;
	}

	public Object getXsUp(Object defaultValue) {
		return this._xsUp == null ? defaultValue : this._xsUp;
	}

	public boolean hasXsUp() {
		return this._xsUp != null;
	}

	public HiddenElement removeXsUp() {
		this._xsUp = null;
		return this;
	} 

	public HiddenElement addChildren(Object value) {
		this._children.add(value);
		return this;
	}

	public HiddenElement setChildren(Object[] value) {
		this._children.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public HiddenElement setChildren(java.util.Collection<Object> values) {
		this._children.addAll(values);
		return this;
	}

	public HiddenElement removeChildren(Object value) {
		this._children.remove(value);
		return this;
	}

	public HiddenElement removeChildren(int index) {
		this._children.remove(index);
		return this;
	}

	public java.util.List<Object> getChildren() {
		return this._children;
	} 

	public HiddenElement addAttribute(Object _name, Object _value) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		map.put("value", _value);
		this._attribute.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getAttribute() {
		return this._attribute;
	}

	public HiddenElement addAttribute(HiddenElement_Attribute value) {
		return addAttribute(value._name, value._value);
	}

	public java.util.stream.Stream<HiddenElement_Attribute> streamAttribute() {
		return this._attribute.stream().map(HiddenElement_Attribute::new);
	}

	public static final class HiddenElement_Attribute {

		Object _name;
		Object _value;

		public HiddenElement_Attribute(Object _name, Object _value) {
			this._name = _name;
			this._value = _value;
		}

		private HiddenElement_Attribute(java.util.Map<String, Object> map) {
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
		HiddenElement that = (HiddenElement) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "HiddenElement(className,id,implementation,initialWidth,lgDown,lgUp,mdDown,mdUp,only,smDown,smUp,style,xlDown,xlUp,xsDown,xsUp,attribute,children) ::= <<<Hidden~if(className)~\n" + 
				"	className=~className~~endif~~if(id)~\n" + 
				"	id=\"~id~\"~endif~~if(implementation)~\n" + 
				"	implementation=\"~implementation~\"~endif~~if(initialWidth)~\n" + 
				"	initialWidth=\"~initialWidth~\"~endif~~if(lgDown)~\n" + 
				"	lgDown~endif~~if(lgUp)~\n" + 
				"	lgUp~endif~~if(mdDown)~\n" + 
				"	mdDown~endif~~if(mdUp)~\n" + 
				"	mdUp~endif~~if(only)~\n" + 
				"	only=\"~only~\"~endif~~if(smDown)~\n" + 
				"	smDown~endif~~if(smUp)~\n" + 
				"	smUp~endif~~if(style)~\n" + 
				"	style=~style~~endif~~if(xlDown)~\n" + 
				"	xlDown~endif~~if(xlUp)~\n" + 
				"	xlUp~endif~~if(xsDown)~\n" + 
				"	xsDown~endif~~if(xsUp)~\n" + 
				"	xsUp~endif~~attribute:{it|\n" + 
				"	\n" + 
				"	~it.name~=~it.value~}~~if(children)~>\n" + 
				"	~children:{it|~it~};separator=\"\\n\"~\n" + 
				"</Hidden>~else~ />~endif~ >>";
}  