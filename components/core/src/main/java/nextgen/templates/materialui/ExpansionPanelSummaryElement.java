package nextgen.templates.materialui;

public class ExpansionPanelSummaryElement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _classes;
	private Object _className;
	private Object _expandIcon;
	private Object _IconButtonProps;
	private Object _onFocusVisible;
	private java.util.List<Object> _children = new java.util.ArrayList<>();

	ExpansionPanelSummaryElement(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("ExpansionPanelSummaryElement");
		st.add("classes", _classes);
		st.add("className", _className);
		st.add("expandIcon", _expandIcon);
		st.add("IconButtonProps", _IconButtonProps);
		st.add("onFocusVisible", _onFocusVisible);
		for (Object o : _children) st.add("children", o);
		return st.render().trim();
	}

	public ExpansionPanelSummaryElement setClasses(Object value) {
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

	public ExpansionPanelSummaryElement removeClasses() {
		this._classes = null;
		return this;
	} 

	public ExpansionPanelSummaryElement setClassName(Object value) {
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

	public ExpansionPanelSummaryElement removeClassName() {
		this._className = null;
		return this;
	} 

	public ExpansionPanelSummaryElement setExpandIcon(Object value) {
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

	public ExpansionPanelSummaryElement removeExpandIcon() {
		this._expandIcon = null;
		return this;
	} 

	public ExpansionPanelSummaryElement setIconButtonProps(Object value) {
		this._IconButtonProps = value;
		return this;
	}

	public Object getIconButtonProps() {
		return this._IconButtonProps;
	}

	public Object getIconButtonProps(Object defaultValue) {
		return this._IconButtonProps == null ? defaultValue : this._IconButtonProps;
	}

	public boolean hasIconButtonProps() {
		return this._IconButtonProps != null;
	}

	public ExpansionPanelSummaryElement removeIconButtonProps() {
		this._IconButtonProps = null;
		return this;
	} 

	public ExpansionPanelSummaryElement setOnFocusVisible(Object value) {
		this._onFocusVisible = value;
		return this;
	}

	public Object getOnFocusVisible() {
		return this._onFocusVisible;
	}

	public Object getOnFocusVisible(Object defaultValue) {
		return this._onFocusVisible == null ? defaultValue : this._onFocusVisible;
	}

	public boolean hasOnFocusVisible() {
		return this._onFocusVisible != null;
	}

	public ExpansionPanelSummaryElement removeOnFocusVisible() {
		this._onFocusVisible = null;
		return this;
	} 

	public ExpansionPanelSummaryElement addChildren(Object value) {
		this._children.add(value);
		return this;
	}

	public ExpansionPanelSummaryElement setChildren(Object[] value) {
		this._children.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public ExpansionPanelSummaryElement setChildren(java.util.Collection<Object> values) {
		this._children.addAll(values);
		return this;
	}

	public ExpansionPanelSummaryElement removeChildren(Object value) {
		this._children.remove(value);
		return this;
	}

	public ExpansionPanelSummaryElement removeChildren(int index) {
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
		ExpansionPanelSummaryElement that = (ExpansionPanelSummaryElement) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "ExpansionPanelSummaryElement(classes,className,expandIcon,IconButtonProps,onFocusVisible,children) ::= <<<ExpansionPanelSummary~if(classes)~\n" + 
				"	classes=~classes~~endif~~if(className)~\n" + 
				"	className=~className~~endif~~if(expandIcon)~\n" + 
				"	expandIcon=~expandIcon~~endif~~if(IconButtonProps)~\n" + 
				"	IconButtonProps=~IconButtonProps~~endif~~if(onFocusVisible)~\n" + 
				"	onFocusVisible=~onFocusVisible~~endif~~if(children)~>\n" + 
				"	~children:{it|~it~};separator=\"\\n\"~\n" + 
				"</ExpansionPanelSummary>~else~ />~endif~ >>";
}  