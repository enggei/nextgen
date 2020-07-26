package nextgen.templates.materialui;

public class CardActionsElement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _classes;
	private Object _className;
	private Object _disableSpacing;
	private java.util.List<Object> _children = new java.util.ArrayList<>();

	CardActionsElement(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("CardActionsElement");
		st.add("classes", _classes);
		st.add("className", _className);
		st.add("disableSpacing", _disableSpacing);
		for (Object o : _children) st.add("children", o);
		return st.render().trim();
	}

	public CardActionsElement setClasses(Object value) {
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

	public CardActionsElement removeClasses() {
		this._classes = null;
		return this;
	} 

	public CardActionsElement setClassName(Object value) {
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

	public CardActionsElement removeClassName() {
		this._className = null;
		return this;
	} 

	public CardActionsElement setDisableSpacing(Object value) {
		this._disableSpacing = value;
		return this;
	}

	public Object getDisableSpacing() {
		return this._disableSpacing;
	}

	public Object getDisableSpacing(Object defaultValue) {
		return this._disableSpacing == null ? defaultValue : this._disableSpacing;
	}

	public boolean hasDisableSpacing() {
		return this._disableSpacing != null;
	}

	public CardActionsElement removeDisableSpacing() {
		this._disableSpacing = null;
		return this;
	} 

	public CardActionsElement addChildren(Object value) {
		this._children.add(value);
		return this;
	}

	public CardActionsElement setChildren(Object[] value) {
		this._children.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public CardActionsElement setChildren(java.util.Collection<Object> values) {
		this._children.addAll(values);
		return this;
	}

	public CardActionsElement removeChildren(Object value) {
		this._children.remove(value);
		return this;
	}

	public CardActionsElement removeChildren(int index) {
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
		CardActionsElement that = (CardActionsElement) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "CardActionsElement(classes,className,disableSpacing,children) ::= <<<CardActions~if(classes)~\n" + 
				"	classes=~classes~~endif~~if(className)~\n" + 
				"	className=~className~~endif~~if(disableSpacing)~\n" + 
				"	disableSpacing~endif~~if(children)~>\n" + 
				"	~children:{it|~it~};separator=\"\\n\"~\n" + 
				"</CardActions>~else~ />~endif~ >>";
}  