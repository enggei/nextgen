package nextgen.templates.materialui;

public class PaperElement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _key;
	private Object _className;
	private java.util.List<Object> _children = new java.util.ArrayList<>();

	PaperElement(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("PaperElement");
		st.add("key", _key);
		st.add("className", _className);
		for (Object o : _children) st.add("children", o);
		return st.render().trim();
	}

	public PaperElement setKey(Object value) {
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

	public PaperElement removeKey() {
		this._key = null;
		return this;
	} 

	public PaperElement setClassName(Object value) {
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

	public PaperElement removeClassName() {
		this._className = null;
		return this;
	} 

	public PaperElement addChildren(Object value) {
		this._children.add(value);
		return this;
	}

	public PaperElement setChildren(Object[] value) {
		this._children.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public PaperElement setChildren(java.util.Collection<Object> values) {
		this._children.addAll(values);
		return this;
	}

	public PaperElement removeChildren(Object value) {
		this._children.remove(value);
		return this;
	}

	public PaperElement removeChildren(int index) {
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
		PaperElement that = (PaperElement) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "PaperElement(key,className,children) ::= <<<Paper~if(key)~ key=~key~~endif~~if(className)~ className={classes.~className~}~endif~>\n" + 
				"	~children:{it|~it~};separator=\"\\n\"~\n" + 
				"</Paper> >>";
}  