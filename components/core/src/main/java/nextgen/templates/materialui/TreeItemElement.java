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
	private Object _label;
	private Object _nodeId;
	private Object _onIconClick;
	private Object _onLabelClick;
	private Object _TransitionComponent;
	private Object _TransitionProps;
	private java.util.List<Object> _children = new java.util.ArrayList<>();

	TreeItemElement(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
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
		st.add("label", _label);
		st.add("nodeId", _nodeId);
		st.add("onIconClick", _onIconClick);
		st.add("onLabelClick", _onLabelClick);
		st.add("TransitionComponent", _TransitionComponent);
		st.add("TransitionProps", _TransitionProps);
		for (Object o : _children) st.add("children", o);
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

	static final String st = "TreeItemElement(classes,className,collapseIcon,endIcon,expandIcon,icon,label,nodeId,onIconClick,onLabelClick,TransitionComponent,TransitionProps,children) ::= <<<TreeItem~if(classes)~\n" + 
				"	classes=~classes~~endif~~if(className)~\n" + 
				"	className=~className~~endif~~if(collapseIcon)~\n" + 
				"	collapseIcon=~collapseIcon~~endif~~if(endIcon)~\n" + 
				"	endIcon=~endIcon~~endif~~if(expandIcon)~\n" + 
				"	expandIcon=~expandIcon~~endif~~if(icon)~\n" + 
				"	icon=~icon~~endif~~if(label)~\n" + 
				"	label=~label~~endif~\n" + 
				"	nodeId=\"~nodeId~\"~if(onIconClick)~\n" + 
				"	onIconClick=~onIconClick~~endif~~if(onLabelClick)~\n" + 
				"	onLabelClick=~onLabelClick~~endif~~if(TransitionComponent)~\n" + 
				"	TransitionComponent=~TransitionComponent~~endif~~if(TransitionProps)~\n" + 
				"	TransitionProps=~TransitionProps~~endif~~if(children)~>\n" + 
				"	~children:{it|~it~};separator=\"\\n\"~\n" + 
				"</TreeItem>~else~ />~endif~ >>";
}  