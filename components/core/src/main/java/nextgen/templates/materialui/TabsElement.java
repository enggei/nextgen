package nextgen.templates.materialui;

public class TabsElement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _action;
	private Object _ariaLabel;
	private Object _ariaLabelledby;
	private Object _centered;
	private Object _classes;
	private Object _className;
	private Object _component;
	private Object _id;
	private Object _indicatorColor;
	private Object _key;
	private Object _onChange;
	private Object _orientation;
	private Object _ScrollButtonComponent;
	private Object _scrollButtons;
	private Object _selectionFollowsFocus;
	private Object _style;
	private Object _TabIndicatorProps;
	private Object _TabScrollButtonProps;
	private Object _textColor;
	private Object _value;
	private Object _variant;
	private java.util.List<Object> _children = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _attribute = new java.util.ArrayList<>();

	TabsElement(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("TabsElement");
		st.add("action", _action);
		st.add("ariaLabel", _ariaLabel);
		st.add("ariaLabelledby", _ariaLabelledby);
		st.add("centered", _centered);
		st.add("classes", _classes);
		st.add("className", _className);
		st.add("component", _component);
		st.add("id", _id);
		st.add("indicatorColor", _indicatorColor);
		st.add("key", _key);
		st.add("onChange", _onChange);
		st.add("orientation", _orientation);
		st.add("ScrollButtonComponent", _ScrollButtonComponent);
		st.add("scrollButtons", _scrollButtons);
		st.add("selectionFollowsFocus", _selectionFollowsFocus);
		st.add("style", _style);
		st.add("TabIndicatorProps", _TabIndicatorProps);
		st.add("TabScrollButtonProps", _TabScrollButtonProps);
		st.add("textColor", _textColor);
		st.add("value", _value);
		st.add("variant", _variant);
		for (Object o : _children) st.add("children", o);
		for (java.util.Map<String, Object> map : _attribute) st.addAggr("attribute.{name,value}", map.get("name"), map.get("value"));
		return st.render().trim();
	}

	public TabsElement setAction(Object value) {
		this._action = value;
		return this;
	}

	public Object getAction() {
		return this._action;
	}

	public Object getAction(Object defaultValue) {
		return this._action == null ? defaultValue : this._action;
	}

	public boolean hasAction() {
		return this._action != null;
	}

	public TabsElement removeAction() {
		this._action = null;
		return this;
	} 

	public TabsElement setAriaLabel(Object value) {
		this._ariaLabel = value;
		return this;
	}

	public Object getAriaLabel() {
		return this._ariaLabel;
	}

	public Object getAriaLabel(Object defaultValue) {
		return this._ariaLabel == null ? defaultValue : this._ariaLabel;
	}

	public boolean hasAriaLabel() {
		return this._ariaLabel != null;
	}

	public TabsElement removeAriaLabel() {
		this._ariaLabel = null;
		return this;
	} 

	public TabsElement setAriaLabelledby(Object value) {
		this._ariaLabelledby = value;
		return this;
	}

	public Object getAriaLabelledby() {
		return this._ariaLabelledby;
	}

	public Object getAriaLabelledby(Object defaultValue) {
		return this._ariaLabelledby == null ? defaultValue : this._ariaLabelledby;
	}

	public boolean hasAriaLabelledby() {
		return this._ariaLabelledby != null;
	}

	public TabsElement removeAriaLabelledby() {
		this._ariaLabelledby = null;
		return this;
	} 

	public TabsElement setCentered(Object value) {
		this._centered = value;
		return this;
	}

	public Object getCentered() {
		return this._centered;
	}

	public Object getCentered(Object defaultValue) {
		return this._centered == null ? defaultValue : this._centered;
	}

	public boolean hasCentered() {
		return this._centered != null;
	}

	public TabsElement removeCentered() {
		this._centered = null;
		return this;
	} 

	public TabsElement setClasses(Object value) {
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

	public TabsElement removeClasses() {
		this._classes = null;
		return this;
	} 

	public TabsElement setClassName(Object value) {
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

	public TabsElement removeClassName() {
		this._className = null;
		return this;
	} 

	public TabsElement setComponent(Object value) {
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

	public TabsElement removeComponent() {
		this._component = null;
		return this;
	} 

	public TabsElement setId(Object value) {
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

	public TabsElement removeId() {
		this._id = null;
		return this;
	} 

	public TabsElement setIndicatorColor(Object value) {
		this._indicatorColor = value;
		return this;
	}

	public Object getIndicatorColor() {
		return this._indicatorColor;
	}

	public Object getIndicatorColor(Object defaultValue) {
		return this._indicatorColor == null ? defaultValue : this._indicatorColor;
	}

	public boolean hasIndicatorColor() {
		return this._indicatorColor != null;
	}

	public TabsElement removeIndicatorColor() {
		this._indicatorColor = null;
		return this;
	} 

	public TabsElement setKey(Object value) {
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

	public TabsElement removeKey() {
		this._key = null;
		return this;
	} 

	public TabsElement setOnChange(Object value) {
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

	public TabsElement removeOnChange() {
		this._onChange = null;
		return this;
	} 

	public TabsElement setOrientation(Object value) {
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

	public TabsElement removeOrientation() {
		this._orientation = null;
		return this;
	} 

	public TabsElement setScrollButtonComponent(Object value) {
		this._ScrollButtonComponent = value;
		return this;
	}

	public Object getScrollButtonComponent() {
		return this._ScrollButtonComponent;
	}

	public Object getScrollButtonComponent(Object defaultValue) {
		return this._ScrollButtonComponent == null ? defaultValue : this._ScrollButtonComponent;
	}

	public boolean hasScrollButtonComponent() {
		return this._ScrollButtonComponent != null;
	}

	public TabsElement removeScrollButtonComponent() {
		this._ScrollButtonComponent = null;
		return this;
	} 

	public TabsElement setScrollButtons(Object value) {
		this._scrollButtons = value;
		return this;
	}

	public Object getScrollButtons() {
		return this._scrollButtons;
	}

	public Object getScrollButtons(Object defaultValue) {
		return this._scrollButtons == null ? defaultValue : this._scrollButtons;
	}

	public boolean hasScrollButtons() {
		return this._scrollButtons != null;
	}

	public TabsElement removeScrollButtons() {
		this._scrollButtons = null;
		return this;
	} 

	public TabsElement setSelectionFollowsFocus(Object value) {
		this._selectionFollowsFocus = value;
		return this;
	}

	public Object getSelectionFollowsFocus() {
		return this._selectionFollowsFocus;
	}

	public Object getSelectionFollowsFocus(Object defaultValue) {
		return this._selectionFollowsFocus == null ? defaultValue : this._selectionFollowsFocus;
	}

	public boolean hasSelectionFollowsFocus() {
		return this._selectionFollowsFocus != null;
	}

	public TabsElement removeSelectionFollowsFocus() {
		this._selectionFollowsFocus = null;
		return this;
	} 

	public TabsElement setStyle(Object value) {
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

	public TabsElement removeStyle() {
		this._style = null;
		return this;
	} 

	public TabsElement setTabIndicatorProps(Object value) {
		this._TabIndicatorProps = value;
		return this;
	}

	public Object getTabIndicatorProps() {
		return this._TabIndicatorProps;
	}

	public Object getTabIndicatorProps(Object defaultValue) {
		return this._TabIndicatorProps == null ? defaultValue : this._TabIndicatorProps;
	}

	public boolean hasTabIndicatorProps() {
		return this._TabIndicatorProps != null;
	}

	public TabsElement removeTabIndicatorProps() {
		this._TabIndicatorProps = null;
		return this;
	} 

	public TabsElement setTabScrollButtonProps(Object value) {
		this._TabScrollButtonProps = value;
		return this;
	}

	public Object getTabScrollButtonProps() {
		return this._TabScrollButtonProps;
	}

	public Object getTabScrollButtonProps(Object defaultValue) {
		return this._TabScrollButtonProps == null ? defaultValue : this._TabScrollButtonProps;
	}

	public boolean hasTabScrollButtonProps() {
		return this._TabScrollButtonProps != null;
	}

	public TabsElement removeTabScrollButtonProps() {
		this._TabScrollButtonProps = null;
		return this;
	} 

	public TabsElement setTextColor(Object value) {
		this._textColor = value;
		return this;
	}

	public Object getTextColor() {
		return this._textColor;
	}

	public Object getTextColor(Object defaultValue) {
		return this._textColor == null ? defaultValue : this._textColor;
	}

	public boolean hasTextColor() {
		return this._textColor != null;
	}

	public TabsElement removeTextColor() {
		this._textColor = null;
		return this;
	} 

	public TabsElement setValue(Object value) {
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

	public TabsElement removeValue() {
		this._value = null;
		return this;
	} 

	public TabsElement setVariant(Object value) {
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

	public TabsElement removeVariant() {
		this._variant = null;
		return this;
	} 

	public TabsElement addChildren(Object value) {
		this._children.add(value);
		return this;
	}

	public TabsElement setChildren(Object[] value) {
		this._children.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public TabsElement setChildren(java.util.Collection<Object> values) {
		this._children.addAll(values);
		return this;
	}

	public TabsElement removeChildren(Object value) {
		this._children.remove(value);
		return this;
	}

	public TabsElement removeChildren(int index) {
		this._children.remove(index);
		return this;
	}

	public java.util.List<Object> getChildren() {
		return this._children;
	} 

	public TabsElement addAttribute(Object _name, Object _value) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		map.put("value", _value);
		this._attribute.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getAttribute() {
		return this._attribute;
	}

	public TabsElement addAttribute(TabsElement_Attribute value) {
		return addAttribute(value._name, value._value);
	}

	public java.util.stream.Stream<TabsElement_Attribute> streamAttribute() {
		return this._attribute.stream().map(TabsElement_Attribute::new);
	}

	public java.util.List<Object> getAttribute_Name() {
		return streamAttribute().map(TabsElement_Attribute::getName).collect(java.util.stream.Collectors.toList());
	}


	public java.util.List<Object> getAttribute_Value() {
		return streamAttribute().map(TabsElement_Attribute::getValue).collect(java.util.stream.Collectors.toList());
	}


	public static final class TabsElement_Attribute {

		Object _name;
		Object _value;

		public TabsElement_Attribute(Object _name, Object _value) {
			this._name = _name;
			this._value = _value;
		}

		private TabsElement_Attribute(java.util.Map<String, Object> map) {
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
		TabsElement that = (TabsElement) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "TabsElement(action,ariaLabel,ariaLabelledby,centered,classes,className,component,id,indicatorColor,key,onChange,orientation,ScrollButtonComponent,scrollButtons,selectionFollowsFocus,style,TabIndicatorProps,TabScrollButtonProps,textColor,value,variant,attribute,children) ::= <<<Tabs~if(action)~\n" + 
				"	action=~action~~endif~~if(ariaLabel)~\n" + 
				"	ariaLabel=\"~ariaLabel~\"~endif~~if(ariaLabelledby)~\n" + 
				"	ariaLabelledby=\"~ariaLabelledby~\"~endif~~if(centered)~\n" + 
				"	centered~endif~~if(classes)~\n" + 
				"	classes=~classes~~endif~~if(className)~\n" + 
				"	className=~className~~endif~~if(component)~\n" + 
				"	component=~component~~endif~~if(id)~\n" + 
				"	id=\"~id~\"~endif~~if(indicatorColor)~\n" + 
				"	indicatorColor=~indicatorColor~~endif~~if(key)~\n" + 
				"	key=~key~~endif~~if(onChange)~\n" + 
				"	onChange=~onChange~~endif~~if(orientation)~\n" + 
				"	orientation=~orientation~~endif~~if(ScrollButtonComponent)~\n" + 
				"	ScrollButtonComponent=~ScrollButtonComponent~~endif~~if(scrollButtons)~\n" + 
				"	scrollButtons=~scrollButtons~~endif~~if(selectionFollowsFocus)~\n" + 
				"	selectionFollowsFocus~endif~~if(style)~\n" + 
				"	style=~style~~endif~~if(TabIndicatorProps)~\n" + 
				"	TabIndicatorProps=~TabIndicatorProps~~endif~~if(TabScrollButtonProps)~\n" + 
				"	TabScrollButtonProps=~TabScrollButtonProps~~endif~~if(textColor)~\n" + 
				"	textColor=~textColor~~endif~~if(value)~\n" + 
				"	value=~value~~endif~~if(variant)~\n" + 
				"	variant=\"~variant~\"~endif~~attribute:{it|\n" + 
				"	\n" + 
				"	~it.name~=~it.value~}~~if(children)~>\n" + 
				"	~children:{it|~it~};separator=\"\\n\"~\n" + 
				"</Tabs>~else~ />~endif~ >>";
}  