package nextgen.templates.materialui;

public class DialogTitleElement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _classes;
	private Object _className;
	private Object _disableTypography;
	private java.util.List<Object> _children = new java.util.ArrayList<>();

	DialogTitleElement(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("DialogTitleElement");
		st.add("classes", _classes);
		st.add("className", _className);
		st.add("disableTypography", _disableTypography);
		for (Object o : _children) st.add("children", o);
		return st.render().trim();
	}

	public DialogTitleElement setClasses(Object value) {
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

	public DialogTitleElement removeClasses() {
		this._classes = null;
		return this;
	} 

	public DialogTitleElement setClassName(Object value) {
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

	public DialogTitleElement removeClassName() {
		this._className = null;
		return this;
	} 

	public DialogTitleElement setDisableTypography(Object value) {
		this._disableTypography = value;
		return this;
	}

	public Object getDisableTypography() {
		return this._disableTypography;
	}

	public Object getDisableTypography(Object defaultValue) {
		return this._disableTypography == null ? defaultValue : this._disableTypography;
	}

	public boolean hasDisableTypography() {
		return this._disableTypography != null;
	}

	public DialogTitleElement removeDisableTypography() {
		this._disableTypography = null;
		return this;
	} 

	public DialogTitleElement addChildren(Object value) {
		this._children.add(value);
		return this;
	}

	public DialogTitleElement setChildren(Object[] value) {
		this._children.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public DialogTitleElement setChildren(java.util.Collection<Object> values) {
		this._children.addAll(values);
		return this;
	}

	public DialogTitleElement removeChildren(Object value) {
		this._children.remove(value);
		return this;
	}

	public DialogTitleElement removeChildren(int index) {
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
		DialogTitleElement that = (DialogTitleElement) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "DialogTitleElement(classes,className,disableTypography,children) ::= <<<DialogTitle~if(classes)~\n" + 
				"	classes=~classes~~endif~~if(className)~\n" + 
				"	className=~className~~endif~~if(disableTypography)~\n" + 
				"	disableTypography~endif~~if(children)~>\n" + 
				"	~children:{it|~it~};separator=\"\\n\"~\n" + 
				"</DialogTitle>~else~ />~endif~ >>";
}  