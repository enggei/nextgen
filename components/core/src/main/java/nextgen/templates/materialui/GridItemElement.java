package nextgen.templates.materialui;

public class GridItemElement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _xs;
	private Object _key;
	private Object _className;
	private java.util.List<Object> _children = new java.util.ArrayList<>();

	GridItemElement(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("GridItemElement");
		st.add("xs", _xs);
		st.add("key", _key);
		st.add("className", _className);
		for (Object o : _children) st.add("children", o);
		return st.render().trim();
	}

	public GridItemElement setXs(Object value) {
		this._xs = value;
		return this;
	}

	public Object getXs() {
		return this._xs;
	}

	public Object getXs(Object defaultValue) {
		return this._xs == null ? defaultValue : this._xs;
	}

	public boolean hasXs() {
		return this._xs != null;
	}

	public GridItemElement removeXs() {
		this._xs = null;
		return this;
	} 

	public GridItemElement setKey(Object value) {
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

	public GridItemElement removeKey() {
		this._key = null;
		return this;
	} 

	public GridItemElement setClassName(Object value) {
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

	public GridItemElement removeClassName() {
		this._className = null;
		return this;
	} 

	public GridItemElement addChildren(Object value) {
		this._children.add(value);
		return this;
	}

	public GridItemElement setChildren(Object[] value) {
		this._children.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public GridItemElement setChildren(java.util.Collection<Object> values) {
		this._children.addAll(values);
		return this;
	}

	public GridItemElement removeChildren(Object value) {
		this._children.remove(value);
		return this;
	}

	public GridItemElement removeChildren(int index) {
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
		GridItemElement that = (GridItemElement) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "GridItemElement(xs,key,className,children) ::= <<<Grid item~if(xs)~ xs={~xs~}~endif~~if(key)~ key=~key~~endif~~if(className)~ className={classes.~className~}~endif~>\n" + 
				"	~children:{it|~it~};separator=\"\\n\"~\n" + 
				"</Grid> >>";
} 