package nextgen.templates.materialui;

public class CardActionAreaElement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _classes;
	private Object _className;
	private java.util.List<Object> _children = new java.util.ArrayList<>();

	CardActionAreaElement(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("CardActionAreaElement");
		st.add("classes", _classes);
		st.add("className", _className);
		for (Object o : _children) st.add("children", o);
		return st.render().trim();
	}

	public CardActionAreaElement setClasses(Object value) {
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

	public CardActionAreaElement removeClasses() {
		this._classes = null;
		return this;
	} 

	public CardActionAreaElement setClassName(Object value) {
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

	public CardActionAreaElement removeClassName() {
		this._className = null;
		return this;
	} 

	public CardActionAreaElement addChildren(Object value) {
		this._children.add(value);
		return this;
	}

	public CardActionAreaElement setChildren(Object[] value) {
		this._children.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public CardActionAreaElement setChildren(java.util.Collection<Object> values) {
		this._children.addAll(values);
		return this;
	}

	public CardActionAreaElement removeChildren(Object value) {
		this._children.remove(value);
		return this;
	}

	public CardActionAreaElement removeChildren(int index) {
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
		CardActionAreaElement that = (CardActionAreaElement) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "CardActionAreaElement(classes,className,children) ::= <<<CardActionArea~if(classes)~\n" + 
				"	classes=~classes~~endif~~if(className)~\n" + 
				"	className=~className~~endif~~if(children)~>\n" + 
				"	~children:{it|~it~};separator=\"\\n\"~\n" + 
				"</CardActionArea>~else~ />~endif~ >>";
}  