package nextgen.templates.materialui;

public class TreeViewElement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _classes;
	private Object _className;
	private Object _defaultCollapseIcon;
	private Object _defaultEndIcon;
	private Object _defaultExpanded;
	private Object _defaultExpandIcon;
	private Object _defaultParentIcon;
	private Object _defaultSelected;
	private Object _disableSelection;
	private Object _expanded;
	private Object _id;
	private Object _multiSelect;
	private Object _onNodeSelect;
	private Object _onNodeToggle;
	private Object _selected;
	private Object _style;
	private java.util.List<Object> _children = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _attribute = new java.util.ArrayList<>();

	TreeViewElement(org.stringtemplate.v4.STGroup stGroup) {
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
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("TreeViewElement");
		st.add("classes", _classes);
		st.add("className", _className);
		st.add("defaultCollapseIcon", _defaultCollapseIcon);
		st.add("defaultEndIcon", _defaultEndIcon);
		st.add("defaultExpanded", _defaultExpanded);
		st.add("defaultExpandIcon", _defaultExpandIcon);
		st.add("defaultParentIcon", _defaultParentIcon);
		st.add("defaultSelected", _defaultSelected);
		st.add("disableSelection", _disableSelection);
		st.add("expanded", _expanded);
		st.add("id", _id);
		st.add("multiSelect", _multiSelect);
		st.add("onNodeSelect", _onNodeSelect);
		st.add("onNodeToggle", _onNodeToggle);
		st.add("selected", _selected);
		st.add("style", _style);
		for (Object o : _children) st.add("children", o);
		for (java.util.Map<String, Object> map : _attribute) st.addAggr("attribute.{name,value}", map.get("name"), map.get("value"));
		return st.render().trim();
	}

	public TreeViewElement setClasses(Object value) {
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

	public TreeViewElement removeClasses() {
		this._classes = null;
		return this;
	} 

	public TreeViewElement setClassName(Object value) {
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

	public TreeViewElement removeClassName() {
		this._className = null;
		return this;
	} 

	public TreeViewElement setDefaultCollapseIcon(Object value) {
		this._defaultCollapseIcon = value;
		return this;
	}

	public Object getDefaultCollapseIcon() {
		return this._defaultCollapseIcon;
	}

	public Object getDefaultCollapseIcon(Object defaultValue) {
		return this._defaultCollapseIcon == null ? defaultValue : this._defaultCollapseIcon;
	}

	public boolean hasDefaultCollapseIcon() {
		return this._defaultCollapseIcon != null;
	}

	public TreeViewElement removeDefaultCollapseIcon() {
		this._defaultCollapseIcon = null;
		return this;
	} 

	public TreeViewElement setDefaultEndIcon(Object value) {
		this._defaultEndIcon = value;
		return this;
	}

	public Object getDefaultEndIcon() {
		return this._defaultEndIcon;
	}

	public Object getDefaultEndIcon(Object defaultValue) {
		return this._defaultEndIcon == null ? defaultValue : this._defaultEndIcon;
	}

	public boolean hasDefaultEndIcon() {
		return this._defaultEndIcon != null;
	}

	public TreeViewElement removeDefaultEndIcon() {
		this._defaultEndIcon = null;
		return this;
	} 

	public TreeViewElement setDefaultExpanded(Object value) {
		this._defaultExpanded = value;
		return this;
	}

	public Object getDefaultExpanded() {
		return this._defaultExpanded;
	}

	public Object getDefaultExpanded(Object defaultValue) {
		return this._defaultExpanded == null ? defaultValue : this._defaultExpanded;
	}

	public boolean hasDefaultExpanded() {
		return this._defaultExpanded != null;
	}

	public TreeViewElement removeDefaultExpanded() {
		this._defaultExpanded = null;
		return this;
	} 

	public TreeViewElement setDefaultExpandIcon(Object value) {
		this._defaultExpandIcon = value;
		return this;
	}

	public Object getDefaultExpandIcon() {
		return this._defaultExpandIcon;
	}

	public Object getDefaultExpandIcon(Object defaultValue) {
		return this._defaultExpandIcon == null ? defaultValue : this._defaultExpandIcon;
	}

	public boolean hasDefaultExpandIcon() {
		return this._defaultExpandIcon != null;
	}

	public TreeViewElement removeDefaultExpandIcon() {
		this._defaultExpandIcon = null;
		return this;
	} 

	public TreeViewElement setDefaultParentIcon(Object value) {
		this._defaultParentIcon = value;
		return this;
	}

	public Object getDefaultParentIcon() {
		return this._defaultParentIcon;
	}

	public Object getDefaultParentIcon(Object defaultValue) {
		return this._defaultParentIcon == null ? defaultValue : this._defaultParentIcon;
	}

	public boolean hasDefaultParentIcon() {
		return this._defaultParentIcon != null;
	}

	public TreeViewElement removeDefaultParentIcon() {
		this._defaultParentIcon = null;
		return this;
	} 

	public TreeViewElement setDefaultSelected(Object value) {
		this._defaultSelected = value;
		return this;
	}

	public Object getDefaultSelected() {
		return this._defaultSelected;
	}

	public Object getDefaultSelected(Object defaultValue) {
		return this._defaultSelected == null ? defaultValue : this._defaultSelected;
	}

	public boolean hasDefaultSelected() {
		return this._defaultSelected != null;
	}

	public TreeViewElement removeDefaultSelected() {
		this._defaultSelected = null;
		return this;
	} 

	public TreeViewElement setDisableSelection(Object value) {
		this._disableSelection = value;
		return this;
	}

	public Object getDisableSelection() {
		return this._disableSelection;
	}

	public Object getDisableSelection(Object defaultValue) {
		return this._disableSelection == null ? defaultValue : this._disableSelection;
	}

	public boolean hasDisableSelection() {
		return this._disableSelection != null;
	}

	public TreeViewElement removeDisableSelection() {
		this._disableSelection = null;
		return this;
	} 

	public TreeViewElement setExpanded(Object value) {
		this._expanded = value;
		return this;
	}

	public Object getExpanded() {
		return this._expanded;
	}

	public Object getExpanded(Object defaultValue) {
		return this._expanded == null ? defaultValue : this._expanded;
	}

	public boolean hasExpanded() {
		return this._expanded != null;
	}

	public TreeViewElement removeExpanded() {
		this._expanded = null;
		return this;
	} 

	public TreeViewElement setId(Object value) {
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

	public TreeViewElement removeId() {
		this._id = null;
		return this;
	} 

	public TreeViewElement setMultiSelect(Object value) {
		this._multiSelect = value;
		return this;
	}

	public Object getMultiSelect() {
		return this._multiSelect;
	}

	public Object getMultiSelect(Object defaultValue) {
		return this._multiSelect == null ? defaultValue : this._multiSelect;
	}

	public boolean hasMultiSelect() {
		return this._multiSelect != null;
	}

	public TreeViewElement removeMultiSelect() {
		this._multiSelect = null;
		return this;
	} 

	public TreeViewElement setOnNodeSelect(Object value) {
		this._onNodeSelect = value;
		return this;
	}

	public Object getOnNodeSelect() {
		return this._onNodeSelect;
	}

	public Object getOnNodeSelect(Object defaultValue) {
		return this._onNodeSelect == null ? defaultValue : this._onNodeSelect;
	}

	public boolean hasOnNodeSelect() {
		return this._onNodeSelect != null;
	}

	public TreeViewElement removeOnNodeSelect() {
		this._onNodeSelect = null;
		return this;
	} 

	public TreeViewElement setOnNodeToggle(Object value) {
		this._onNodeToggle = value;
		return this;
	}

	public Object getOnNodeToggle() {
		return this._onNodeToggle;
	}

	public Object getOnNodeToggle(Object defaultValue) {
		return this._onNodeToggle == null ? defaultValue : this._onNodeToggle;
	}

	public boolean hasOnNodeToggle() {
		return this._onNodeToggle != null;
	}

	public TreeViewElement removeOnNodeToggle() {
		this._onNodeToggle = null;
		return this;
	} 

	public TreeViewElement setSelected(Object value) {
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

	public TreeViewElement removeSelected() {
		this._selected = null;
		return this;
	} 

	public TreeViewElement setStyle(Object value) {
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

	public TreeViewElement removeStyle() {
		this._style = null;
		return this;
	} 

	public TreeViewElement addChildren(Object value) {
		this._children.add(value);
		return this;
	}

	public TreeViewElement setChildren(Object[] value) {
		this._children.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public TreeViewElement setChildren(java.util.Collection<Object> values) {
		this._children.addAll(values);
		return this;
	}

	public TreeViewElement removeChildren(Object value) {
		this._children.remove(value);
		return this;
	}

	public TreeViewElement removeChildren(int index) {
		this._children.remove(index);
		return this;
	}

	public java.util.List<Object> getChildren() {
		return this._children;
	} 

	public TreeViewElement addAttribute(Object _name, Object _value) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		map.put("value", _value);
		this._attribute.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getAttribute() {
		return this._attribute;
	}

	public TreeViewElement addAttribute(TreeViewElement_Attribute value) {
		return addAttribute(value._name, value._value);
	}

	public java.util.stream.Stream<TreeViewElement_Attribute> streamAttribute() {
		return this._attribute.stream().map(TreeViewElement_Attribute::new);
	}

	public static final class TreeViewElement_Attribute {

		Object _name;
		Object _value;

		public TreeViewElement_Attribute(Object _name, Object _value) {
			this._name = _name;
			this._value = _value;
		}

		private TreeViewElement_Attribute(java.util.Map<String, Object> map) {
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
		TreeViewElement that = (TreeViewElement) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "TreeViewElement(classes,className,defaultCollapseIcon,defaultEndIcon,defaultExpanded,defaultExpandIcon,defaultParentIcon,defaultSelected,disableSelection,expanded,id,multiSelect,onNodeSelect,onNodeToggle,selected,style,attribute,children) ::= <<<TreeView~if(classes)~\n" + 
				"	classes=~classes~~endif~~if(className)~\n" + 
				"	className=~className~~endif~~if(defaultCollapseIcon)~\n" + 
				"	defaultCollapseIcon=~defaultCollapseIcon~~endif~~if(defaultEndIcon)~\n" + 
				"	defaultEndIcon=~defaultEndIcon~~endif~~if(defaultExpanded)~\n" + 
				"	defaultExpanded=~defaultExpanded~~endif~~if(defaultExpandIcon)~\n" + 
				"	defaultExpandIcon=~defaultExpandIcon~~endif~~if(defaultParentIcon)~\n" + 
				"	defaultParentIcon=~defaultParentIcon~~endif~~if(defaultSelected)~\n" + 
				"	defaultSelected=~defaultSelected~~endif~~if(disableSelection)~\n" + 
				"	disableSelection~endif~~if(expanded)~\n" + 
				"	expanded=~expanded~~endif~~if(id)~\n" + 
				"	id=\"~id~\"~endif~~if(multiSelect)~\n" + 
				"	multiSelect~endif~~if(onNodeSelect)~\n" + 
				"	onNodeSelect=~onNodeSelect~~endif~~if(onNodeToggle)~\n" + 
				"	onNodeToggle=~onNodeToggle~~endif~~if(selected)~\n" + 
				"	selected=~selected~~endif~~if(style)~\n" + 
				"	style=~style~~endif~~attribute:{it|\n" + 
				"	\n" + 
				"	~it.name~=~it.value~}~~if(children)~>\n" + 
				"	~children:{it|~it~};separator=\"\\n\"~\n" + 
				"</TreeView>~else~ />~endif~ >>";
}  