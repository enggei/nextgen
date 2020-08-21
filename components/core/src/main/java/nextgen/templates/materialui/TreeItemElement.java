package nextgen.templates.materialui;

public class TreeItemElement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _classes;
	private Object _className;
	private Object _collapseIcon;
	private Object _endIcon;
	private Object _expandIcon;
	private Object _icon;
	private Object _id;
	private Object _key;
	private Object _label;
	private Object _nodeId;
	private Object _onIconClick;
	private Object _onLabelClick;
	private Object _style;
	private Object _TransitionComponent;
	private Object _TransitionProps;
	private java.util.List<Object> _children = new java.util.ArrayList<>();
	private java.util.List<java.util.Map<String, Object>> _attribute = new java.util.ArrayList<>();

	TreeItemElement(org.stringtemplate.v4.STGroup stGroup) {
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
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("TreeItemElement");
		st.add("classes", _classes);
		st.add("className", _className);
		st.add("collapseIcon", _collapseIcon);
		st.add("endIcon", _endIcon);
		st.add("expandIcon", _expandIcon);
		st.add("icon", _icon);
		st.add("id", _id);
		st.add("key", _key);
		st.add("label", _label);
		st.add("nodeId", _nodeId);
		st.add("onIconClick", _onIconClick);
		st.add("onLabelClick", _onLabelClick);
		st.add("style", _style);
		st.add("TransitionComponent", _TransitionComponent);
		st.add("TransitionProps", _TransitionProps);
		for (Object o : _children) st.add("children", o);
		for (java.util.Map<String, Object> map : _attribute) st.addAggr("attribute.{name,value}", map.get("name"), map.get("value"));
		return st.render().trim();
	}

	public TreeItemElement setClasses(Object value) {
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

	public TreeItemElement removeClasses() {
		this._classes = null;
		return this;
	} 

	public TreeItemElement setClassName(Object value) {
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

	public TreeItemElement removeClassName() {
		this._className = null;
		return this;
	} 

	public TreeItemElement setCollapseIcon(Object value) {
		this._collapseIcon = value;
		return this;
	}

	public Object getCollapseIcon() {
		return this._collapseIcon;
	}

	public Object getCollapseIcon(Object defaultValue) {
		return this._collapseIcon == null ? defaultValue : this._collapseIcon;
	}

	public boolean hasCollapseIcon() {
		return this._collapseIcon != null;
	}

	public TreeItemElement removeCollapseIcon() {
		this._collapseIcon = null;
		return this;
	} 

	public TreeItemElement setEndIcon(Object value) {
		this._endIcon = value;
		return this;
	}

	public Object getEndIcon() {
		return this._endIcon;
	}

	public Object getEndIcon(Object defaultValue) {
		return this._endIcon == null ? defaultValue : this._endIcon;
	}

	public boolean hasEndIcon() {
		return this._endIcon != null;
	}

	public TreeItemElement removeEndIcon() {
		this._endIcon = null;
		return this;
	} 

	public TreeItemElement setExpandIcon(Object value) {
		this._expandIcon = value;
		return this;
	}

	public Object getExpandIcon() {
		return this._expandIcon;
	}

	public Object getExpandIcon(Object defaultValue) {
		return this._expandIcon == null ? defaultValue : this._expandIcon;
	}

	public boolean hasExpandIcon() {
		return this._expandIcon != null;
	}

	public TreeItemElement removeExpandIcon() {
		this._expandIcon = null;
		return this;
	} 

	public TreeItemElement setIcon(Object value) {
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

	public TreeItemElement removeIcon() {
		this._icon = null;
		return this;
	} 

	public TreeItemElement setId(Object value) {
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

	public TreeItemElement removeId() {
		this._id = null;
		return this;
	} 

	public TreeItemElement setKey(Object value) {
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

	public TreeItemElement removeKey() {
		this._key = null;
		return this;
	} 

	public TreeItemElement setLabel(Object value) {
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

	public TreeItemElement removeLabel() {
		this._label = null;
		return this;
	} 

	public TreeItemElement setNodeId(Object value) {
		this._nodeId = value;
		return this;
	}

	public Object getNodeId() {
		return this._nodeId;
	}

	public Object getNodeId(Object defaultValue) {
		return this._nodeId == null ? defaultValue : this._nodeId;
	}

	public boolean hasNodeId() {
		return this._nodeId != null;
	}

	public TreeItemElement removeNodeId() {
		this._nodeId = null;
		return this;
	} 

	public TreeItemElement setOnIconClick(Object value) {
		this._onIconClick = value;
		return this;
	}

	public Object getOnIconClick() {
		return this._onIconClick;
	}

	public Object getOnIconClick(Object defaultValue) {
		return this._onIconClick == null ? defaultValue : this._onIconClick;
	}

	public boolean hasOnIconClick() {
		return this._onIconClick != null;
	}

	public TreeItemElement removeOnIconClick() {
		this._onIconClick = null;
		return this;
	} 

	public TreeItemElement setOnLabelClick(Object value) {
		this._onLabelClick = value;
		return this;
	}

	public Object getOnLabelClick() {
		return this._onLabelClick;
	}

	public Object getOnLabelClick(Object defaultValue) {
		return this._onLabelClick == null ? defaultValue : this._onLabelClick;
	}

	public boolean hasOnLabelClick() {
		return this._onLabelClick != null;
	}

	public TreeItemElement removeOnLabelClick() {
		this._onLabelClick = null;
		return this;
	} 

	public TreeItemElement setStyle(Object value) {
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

	public TreeItemElement removeStyle() {
		this._style = null;
		return this;
	} 

	public TreeItemElement setTransitionComponent(Object value) {
		this._TransitionComponent = value;
		return this;
	}

	public Object getTransitionComponent() {
		return this._TransitionComponent;
	}

	public Object getTransitionComponent(Object defaultValue) {
		return this._TransitionComponent == null ? defaultValue : this._TransitionComponent;
	}

	public boolean hasTransitionComponent() {
		return this._TransitionComponent != null;
	}

	public TreeItemElement removeTransitionComponent() {
		this._TransitionComponent = null;
		return this;
	} 

	public TreeItemElement setTransitionProps(Object value) {
		this._TransitionProps = value;
		return this;
	}

	public Object getTransitionProps() {
		return this._TransitionProps;
	}

	public Object getTransitionProps(Object defaultValue) {
		return this._TransitionProps == null ? defaultValue : this._TransitionProps;
	}

	public boolean hasTransitionProps() {
		return this._TransitionProps != null;
	}

	public TreeItemElement removeTransitionProps() {
		this._TransitionProps = null;
		return this;
	} 

	public TreeItemElement addChildren(Object value) {
		this._children.add(value);
		return this;
	}

	public TreeItemElement setChildren(Object[] value) {
		this._children.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public TreeItemElement setChildren(java.util.Collection<Object> values) {
		this._children.addAll(values);
		return this;
	}

	public TreeItemElement removeChildren(Object value) {
		this._children.remove(value);
		return this;
	}

	public TreeItemElement removeChildren(int index) {
		this._children.remove(index);
		return this;
	}

	public java.util.List<Object> getChildren() {
		return this._children;
	} 

	public TreeItemElement addAttribute(Object _name, Object _value) {
		final java.util.Map<String, Object> map = new java.util.HashMap<>();
		map.put("name", _name);
		map.put("value", _value);
		this._attribute.add(map);
		return this;
	}

	public java.util.List<java.util.Map<String, Object>> getAttribute() {
		return this._attribute;
	}

	public TreeItemElement addAttribute(TreeItemElement_Attribute value) {
		return addAttribute(value._name, value._value);
	}

	public java.util.stream.Stream<TreeItemElement_Attribute> streamAttribute() {
		return this._attribute.stream().map(TreeItemElement_Attribute::new);
	}

	public static final class TreeItemElement_Attribute {

		Object _name;
		Object _value;

		public TreeItemElement_Attribute(Object _name, Object _value) {
			this._name = _name;
			this._value = _value;
		}

		private TreeItemElement_Attribute(java.util.Map<String, Object> map) {
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
		TreeItemElement that = (TreeItemElement) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "TreeItemElement(classes,className,collapseIcon,endIcon,expandIcon,icon,id,key,label,nodeId,onIconClick,onLabelClick,style,TransitionComponent,TransitionProps,attribute,children) ::= <<<TreeItem~if(classes)~\n" + 
				"	classes=~classes~~endif~~if(className)~\n" + 
				"	className=~className~~endif~~if(collapseIcon)~\n" + 
				"	collapseIcon=~collapseIcon~~endif~~if(endIcon)~\n" + 
				"	endIcon=~endIcon~~endif~~if(expandIcon)~\n" + 
				"	expandIcon=~expandIcon~~endif~~if(icon)~\n" + 
				"	icon=~icon~~endif~~if(id)~\n" + 
				"	id=\"~id~\"~endif~~if(key)~\n" + 
				"	key=~key~~endif~~if(label)~\n" + 
				"	label=~label~~endif~\n" + 
				"	nodeId=\"~nodeId~\"~if(onIconClick)~\n" + 
				"	onIconClick=~onIconClick~~endif~~if(onLabelClick)~\n" + 
				"	onLabelClick=~onLabelClick~~endif~~if(style)~\n" + 
				"	style=~style~~endif~~if(TransitionComponent)~\n" + 
				"	TransitionComponent=~TransitionComponent~~endif~~if(TransitionProps)~\n" + 
				"	TransitionProps=~TransitionProps~~endif~~attribute:{it|\n" + 
				"	\n" + 
				"	~it.name~=~it.value~}~~if(children)~>\n" + 
				"	~children:{it|~it~};separator=\"\\n\"~\n" + 
				"</TreeItem>~else~ />~endif~ >>";
}  