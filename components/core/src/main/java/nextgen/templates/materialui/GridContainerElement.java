package nextgen.templates.materialui;

public class GridContainerElement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _key;
	private String _className;
	private Justify _justify;
	private Object _spacing;
	private java.util.List<Object> _children = new java.util.ArrayList<>();

	GridContainerElement(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("GridContainerElement");
		st.add("key", _key);
		st.add("className", _className);
		st.add("justify", _justify);
		st.add("spacing", _spacing);
		for (Object o : _children) st.add("children", o);
		return st.render().trim();
	}

	public GridContainerElement setKey(Object value) {
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

	public GridContainerElement removeKey() {
		this._key = null;
		return this;
	} 

	public GridContainerElement setClassName(String value) {
		this._className = value;
		return this;
	}

	public String getClassName() {
		return this._className;
	}

	public String getClassName(String defaultValue) {
		return this._className == null ? defaultValue : this._className;
	}

	public boolean hasClassName() {
		return this._className != null;
	}

	public GridContainerElement removeClassName() {
		this._className = null;
		return this;
	} 

	public GridContainerElement setJustify(Justify value) {
		this._justify = value;
		return this;
	}

	public Justify getJustify() {
		return this._justify;
	}

	public Justify getJustify(Justify defaultValue) {
		return this._justify == null ? defaultValue : this._justify;
	}

	public boolean hasJustify() {
		return this._justify != null;
	}

	public GridContainerElement removeJustify() {
		this._justify = null;
		return this;
	} 

	public GridContainerElement setSpacing(Object value) {
		this._spacing = value;
		return this;
	}

	public Object getSpacing() {
		return this._spacing;
	}

	public Object getSpacing(Object defaultValue) {
		return this._spacing == null ? defaultValue : this._spacing;
	}

	public boolean hasSpacing() {
		return this._spacing != null;
	}

	public GridContainerElement removeSpacing() {
		this._spacing = null;
		return this;
	} 

	public GridContainerElement addChildren(Object value) {
		this._children.add(value);
		return this;
	}

	public GridContainerElement setChildren(Object[] value) {
		this._children.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public GridContainerElement setChildren(java.util.Collection<Object> values) {
		this._children.addAll(values);
		return this;
	}

	public GridContainerElement removeChildren(Object value) {
		this._children.remove(value);
		return this;
	}

	public GridContainerElement removeChildren(int index) {
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
		GridContainerElement that = (GridContainerElement) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "GridContainerElement(key,className,justify,spacing,children) ::= <<<Grid container~if(key)~ key=~key~~endif~~if(className)~ className={classes.~className~}~endif~~if(justify)~ justify=\"~justify~\"~endif~~if(spacing)~ spacing={~spacing~}~endif~>\n" + 
				"	~children:{it|~it~};separator=\"\\n\"~\n" + 
				"</Grid> >>";
}  