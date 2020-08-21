package nextgen.templates.materialui;

public class SelectElement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _autoWidth;
	private Object _classes;
	private Object _className;
	private Object _defaultValue;
	private Object _displayEmpty;
	private Object _IconComponent;
	private Object _id;
	private Object _input;
	private Object _inputProps;
	private Object _label;
	private Object _labelId;
	private Object _labelWidth;
	private Object _MenuProps;
	private Object _multiple;
	private Object _native;
	private Object _onChange;
	private Object _onClose;
	private Object _onOpen;
	private Object _open;
	private Object _renderValue;
	private Object _SelectDisplayProps;
	private Object _style;
	private Object _value;
	private Object _variant;
	private java.util.List<Object> _children = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _attribute = new java.util.ArrayList<>();

	SelectElement(org.stringtemplate.v4.STGroup stGroup) {
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
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("SelectElement");
		st.add("autoWidth", _autoWidth);
		st.add("classes", _classes);
		st.add("className", _className);
		st.add("defaultValue", _defaultValue);
		st.add("displayEmpty", _displayEmpty);
		st.add("IconComponent", _IconComponent);
		st.add("id", _id);
		st.add("input", _input);
		st.add("inputProps", _inputProps);
		st.add("label", _label);
		st.add("labelId", _labelId);
		st.add("labelWidth", _labelWidth);
		st.add("MenuProps", _MenuProps);
		st.add("multiple", _multiple);
		st.add("native", _native);
		st.add("onChange", _onChange);
		st.add("onClose", _onClose);
		st.add("onOpen", _onOpen);
		st.add("open", _open);
		st.add("renderValue", _renderValue);
		st.add("SelectDisplayProps", _SelectDisplayProps);
		st.add("style", _style);
		st.add("value", _value);
		st.add("variant", _variant);
		for (Object o : _children) st.add("children", o);
		for (java.util.Map<String, Object> map : _attribute) st.addAggr("attribute.{name,value}", map.get("name"), map.get("value"));
		return st.render().trim();
	}

	public SelectElement setAutoWidth(Object value) {
		this._autoWidth = value;
		return this;
	}

	public Object getAutoWidth() {
		return this._autoWidth;
	}

	public Object getAutoWidth(Object defaultValue) {
		return this._autoWidth == null ? defaultValue : this._autoWidth;
	}

	public boolean hasAutoWidth() {
		return this._autoWidth != null;
	}

	public SelectElement removeAutoWidth() {
		this._autoWidth = null;
		return this;
	} 

	public SelectElement setClasses(Object value) {
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

	public SelectElement removeClasses() {
		this._classes = null;
		return this;
	} 

	public SelectElement setClassName(Object value) {
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

	public SelectElement removeClassName() {
		this._className = null;
		return this;
	} 

	public SelectElement setDefaultValue(Object value) {
		this._defaultValue = value;
		return this;
	}

	public Object getDefaultValue() {
		return this._defaultValue;
	}

	public Object getDefaultValue(Object defaultValue) {
		return this._defaultValue == null ? defaultValue : this._defaultValue;
	}

	public boolean hasDefaultValue() {
		return this._defaultValue != null;
	}

	public SelectElement removeDefaultValue() {
		this._defaultValue = null;
		return this;
	} 

	public SelectElement setDisplayEmpty(Object value) {
		this._displayEmpty = value;
		return this;
	}

	public Object getDisplayEmpty() {
		return this._displayEmpty;
	}

	public Object getDisplayEmpty(Object defaultValue) {
		return this._displayEmpty == null ? defaultValue : this._displayEmpty;
	}

	public boolean hasDisplayEmpty() {
		return this._displayEmpty != null;
	}

	public SelectElement removeDisplayEmpty() {
		this._displayEmpty = null;
		return this;
	} 

	public SelectElement setIconComponent(Object value) {
		this._IconComponent = value;
		return this;
	}

	public Object getIconComponent() {
		return this._IconComponent;
	}

	public Object getIconComponent(Object defaultValue) {
		return this._IconComponent == null ? defaultValue : this._IconComponent;
	}

	public boolean hasIconComponent() {
		return this._IconComponent != null;
	}

	public SelectElement removeIconComponent() {
		this._IconComponent = null;
		return this;
	} 

	public SelectElement setId(Object value) {
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

	public SelectElement removeId() {
		this._id = null;
		return this;
	} 

	public SelectElement setInput(Object value) {
		this._input = value;
		return this;
	}

	public Object getInput() {
		return this._input;
	}

	public Object getInput(Object defaultValue) {
		return this._input == null ? defaultValue : this._input;
	}

	public boolean hasInput() {
		return this._input != null;
	}

	public SelectElement removeInput() {
		this._input = null;
		return this;
	} 

	public SelectElement setInputProps(Object value) {
		this._inputProps = value;
		return this;
	}

	public Object getInputProps() {
		return this._inputProps;
	}

	public Object getInputProps(Object defaultValue) {
		return this._inputProps == null ? defaultValue : this._inputProps;
	}

	public boolean hasInputProps() {
		return this._inputProps != null;
	}

	public SelectElement removeInputProps() {
		this._inputProps = null;
		return this;
	} 

	public SelectElement setLabel(Object value) {
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

	public SelectElement removeLabel() {
		this._label = null;
		return this;
	} 

	public SelectElement setLabelId(Object value) {
		this._labelId = value;
		return this;
	}

	public Object getLabelId() {
		return this._labelId;
	}

	public Object getLabelId(Object defaultValue) {
		return this._labelId == null ? defaultValue : this._labelId;
	}

	public boolean hasLabelId() {
		return this._labelId != null;
	}

	public SelectElement removeLabelId() {
		this._labelId = null;
		return this;
	} 

	public SelectElement setLabelWidth(Object value) {
		this._labelWidth = value;
		return this;
	}

	public Object getLabelWidth() {
		return this._labelWidth;
	}

	public Object getLabelWidth(Object defaultValue) {
		return this._labelWidth == null ? defaultValue : this._labelWidth;
	}

	public boolean hasLabelWidth() {
		return this._labelWidth != null;
	}

	public SelectElement removeLabelWidth() {
		this._labelWidth = null;
		return this;
	} 

	public SelectElement setMenuProps(Object value) {
		this._MenuProps = value;
		return this;
	}

	public Object getMenuProps() {
		return this._MenuProps;
	}

	public Object getMenuProps(Object defaultValue) {
		return this._MenuProps == null ? defaultValue : this._MenuProps;
	}

	public boolean hasMenuProps() {
		return this._MenuProps != null;
	}

	public SelectElement removeMenuProps() {
		this._MenuProps = null;
		return this;
	} 

	public SelectElement setMultiple(Object value) {
		this._multiple = value;
		return this;
	}

	public Object getMultiple() {
		return this._multiple;
	}

	public Object getMultiple(Object defaultValue) {
		return this._multiple == null ? defaultValue : this._multiple;
	}

	public boolean hasMultiple() {
		return this._multiple != null;
	}

	public SelectElement removeMultiple() {
		this._multiple = null;
		return this;
	} 

	public SelectElement setNative(Object value) {
		this._native = value;
		return this;
	}

	public Object getNative() {
		return this._native;
	}

	public Object getNative(Object defaultValue) {
		return this._native == null ? defaultValue : this._native;
	}

	public boolean hasNative() {
		return this._native != null;
	}

	public SelectElement removeNative() {
		this._native = null;
		return this;
	} 

	public SelectElement setOnChange(Object value) {
		this._onChange = value;
		return this;
	}

	public Object getOnChange() {
		return this._onChange;
	}

	public Object getOnChange(Object defaultValue) {
		return this._onChange == null ? defaultValue : this._onChange;
	}

	public boolean hasOnChange() {
		return this._onChange != null;
	}

	public SelectElement removeOnChange() {
		this._onChange = null;
		return this;
	} 

	public SelectElement setOnClose(Object value) {
		this._onClose = value;
		return this;
	}

	public Object getOnClose() {
		return this._onClose;
	}

	public Object getOnClose(Object defaultValue) {
		return this._onClose == null ? defaultValue : this._onClose;
	}

	public boolean hasOnClose() {
		return this._onClose != null;
	}

	public SelectElement removeOnClose() {
		this._onClose = null;
		return this;
	} 

	public SelectElement setOnOpen(Object value) {
		this._onOpen = value;
		return this;
	}

	public Object getOnOpen() {
		return this._onOpen;
	}

	public Object getOnOpen(Object defaultValue) {
		return this._onOpen == null ? defaultValue : this._onOpen;
	}

	public boolean hasOnOpen() {
		return this._onOpen != null;
	}

	public SelectElement removeOnOpen() {
		this._onOpen = null;
		return this;
	} 

	public SelectElement setOpen(Object value) {
		this._open = value;
		return this;
	}

	public Object getOpen() {
		return this._open;
	}

	public Object getOpen(Object defaultValue) {
		return this._open == null ? defaultValue : this._open;
	}

	public boolean hasOpen() {
		return this._open != null;
	}

	public SelectElement removeOpen() {
		this._open = null;
		return this;
	} 

	public SelectElement setRenderValue(Object value) {
		this._renderValue = value;
		return this;
	}

	public Object getRenderValue() {
		return this._renderValue;
	}

	public Object getRenderValue(Object defaultValue) {
		return this._renderValue == null ? defaultValue : this._renderValue;
	}

	public boolean hasRenderValue() {
		return this._renderValue != null;
	}

	public SelectElement removeRenderValue() {
		this._renderValue = null;
		return this;
	} 

	public SelectElement setSelectDisplayProps(Object value) {
		this._SelectDisplayProps = value;
		return this;
	}

	public Object getSelectDisplayProps() {
		return this._SelectDisplayProps;
	}

	public Object getSelectDisplayProps(Object defaultValue) {
		return this._SelectDisplayProps == null ? defaultValue : this._SelectDisplayProps;
	}

	public boolean hasSelectDisplayProps() {
		return this._SelectDisplayProps != null;
	}

	public SelectElement removeSelectDisplayProps() {
		this._SelectDisplayProps = null;
		return this;
	} 

	public SelectElement setStyle(Object value) {
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

	public SelectElement removeStyle() {
		this._style = null;
		return this;
	} 

	public SelectElement setValue(Object value) {
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

	public SelectElement removeValue() {
		this._value = null;
		return this;
	} 

	public SelectElement setVariant(Object value) {
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

	public SelectElement removeVariant() {
		this._variant = null;
		return this;
	} 

	public SelectElement addChildren(Object value) {
		this._children.add(value);
		return this;
	}

	public SelectElement setChildren(Object[] value) {
		this._children.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public SelectElement setChildren(java.util.Collection<Object> values) {
		this._children.addAll(values);
		return this;
	}

	public SelectElement removeChildren(Object value) {
		this._children.remove(value);
		return this;
	}

	public SelectElement removeChildren(int index) {
		this._children.remove(index);
		return this;
	}

	public java.util.List<Object> getChildren() {
		return this._children;
	} 

	public SelectElement addAttribute(Object _name, Object _value) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		map.put("value", _value);
		this._attribute.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getAttribute() {
		return this._attribute;
	}

	public SelectElement addAttribute(SelectElement_Attribute value) {
		return addAttribute(value._name, value._value);
	}

	public java.util.stream.Stream<SelectElement_Attribute> streamAttribute() {
		return this._attribute.stream().map(SelectElement_Attribute::new);
	}

	public static final class SelectElement_Attribute {

		Object _name;
		Object _value;

		public SelectElement_Attribute(Object _name, Object _value) {
			this._name = _name;
			this._value = _value;
		}

		private SelectElement_Attribute(java.util.Map<String, Object> map) {
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
		SelectElement that = (SelectElement) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "SelectElement(autoWidth,classes,className,defaultValue,displayEmpty,IconComponent,id,input,inputProps,label,labelId,labelWidth,MenuProps,multiple,native,onChange,onClose,onOpen,open,renderValue,SelectDisplayProps,style,value,variant,attribute,children) ::= <<<Select~if(autoWidth)~\n" + 
				"	autoWidth~endif~~if(classes)~\n" + 
				"	classes=~classes~~endif~~if(className)~\n" + 
				"	className=~className~~endif~~if(defaultValue)~\n" + 
				"	defaultValue=~defaultValue~~endif~~if(displayEmpty)~\n" + 
				"	displayEmpty~endif~~if(IconComponent)~\n" + 
				"	IconComponent=~IconComponent~~endif~~if(id)~\n" + 
				"	id=\"~id~\"~endif~~if(input)~\n" + 
				"	input=~input~~endif~~if(inputProps)~\n" + 
				"	inputProps=~inputProps~~endif~~if(label)~\n" + 
				"	label=~label~~endif~~if(labelId)~\n" + 
				"	labelId=\"~labelId~\"~endif~~if(labelWidth)~\n" + 
				"	labelWidth=~labelWidth~~endif~~if(MenuProps)~\n" + 
				"	MenuProps=~MenuProps~~endif~~if(multiple)~\n" + 
				"	multiple~endif~~if(native)~\n" + 
				"	native~endif~~if(onChange)~\n" + 
				"	onChange=~onChange~~endif~~if(onClose)~\n" + 
				"	onClose=~onClose~~endif~~if(onOpen)~\n" + 
				"	onOpen=~onOpen~~endif~~if(open)~\n" + 
				"	open~endif~~if(renderValue)~\n" + 
				"	renderValue=~renderValue~~endif~~if(SelectDisplayProps)~\n" + 
				"	SelectDisplayProps=~SelectDisplayProps~~endif~~if(style)~\n" + 
				"	style=~style~~endif~~if(value)~\n" + 
				"	value=~value~~endif~~if(variant)~\n" + 
				"	variant=\"~variant~\"~endif~~attribute:{it|\n" + 
				"	\n" + 
				"	~it.name~=~it.value~}~~if(children)~>\n" + 
				"	~children:{it|~it~};separator=\"\\n\"~\n" + 
				"</Select>~else~ />~endif~ >>";
}  