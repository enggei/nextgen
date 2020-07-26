package nextgen.templates.materialui;

public class CardElement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _classes;
	private Object _className;
	private Object _raised;
	private java.util.List<Object> _children = new java.util.ArrayList<>();

	CardElement(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("CardElement");
		st.add("classes", _classes);
		st.add("className", _className);
		st.add("raised", _raised);
		for (Object o : _children) st.add("children", o);
		return st.render().trim();
	}

	public CardElement setClasses(Object value) {
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

	public CardElement removeClasses() {
		this._classes = null;
		return this;
	} 

	public CardElement setClassName(Object value) {
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

	public CardElement removeClassName() {
		this._className = null;
		return this;
	} 

	public CardElement setRaised(Object value) {
		this._raised = value;
		return this;
	}

	public Object getRaised() {
		return this._raised;
	}

	public Object getRaised(Object defaultValue) {
		return this._raised == null ? defaultValue : this._raised;
	}

	public boolean hasRaised() {
		return this._raised != null;
	}

	public CardElement removeRaised() {
		this._raised = null;
		return this;
	} 

	public CardElement addChildren(Object value) {
		this._children.add(value);
		return this;
	}

	public CardElement setChildren(Object[] value) {
		this._children.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public CardElement setChildren(java.util.Collection<Object> values) {
		this._children.addAll(values);
		return this;
	}

	public CardElement removeChildren(Object value) {
		this._children.remove(value);
		return this;
	}

	public CardElement removeChildren(int index) {
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
		CardElement that = (CardElement) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "CardElement(classes,className,raised,children) ::= <<<Card~if(classes)~\n" + 
				"	classes=~classes~~endif~~if(className)~\n" + 
				"	className=~className~~endif~~if(raised)~\n" + 
				"	raised~endif~~if(children)~>\n" + 
				"	~children:{it|~it~};separator=\"\\n\"~\n" + 
				"</Card>~else~ />~endif~ >>";
}  