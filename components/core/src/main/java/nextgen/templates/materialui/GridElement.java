package nextgen.templates.materialui;

public class GridElement implements Element {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _key;
	private Object _className;
	private Object _isContainer;
	private Object _justify;
	private Object _spacing;
	private java.util.List<Object> _children = new java.util.ArrayList<>();

	GridElement(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("GridElement");
		st.add("key", _key);
		st.add("className", _className);
		st.add("isContainer", _isContainer);
		st.add("justify", _justify);
		st.add("spacing", _spacing);
		for (Object o : _children) st.add("children", o);
		return st.render().trim();
	}

	public GridElement setKey(Object value) {
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

	public GridElement removeKey() {
		this._key = null;
		return this;
	} 

	public GridElement setClassName(Object value) {
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

	public GridElement removeClassName() {
		this._className = null;
		return this;
	} 

	public GridElement setIsContainer(Object value) {
		this._isContainer = value;
		return this;
	}

	public Object getIsContainer() {
		return this._isContainer;
	}

	public Object getIsContainer(Object defaultValue) {
		return this._isContainer == null ? defaultValue : this._isContainer;
	}

	public boolean hasIsContainer() {
		return this._isContainer != null;
	}

	public GridElement removeIsContainer() {
		this._isContainer = null;
		return this;
	} 

	public GridElement setJustify(Object value) {
		this._justify = value;
		return this;
	}

	public Object getJustify() {
		return this._justify;
	}

	public Object getJustify(Object defaultValue) {
		return this._justify == null ? defaultValue : this._justify;
	}

	public boolean hasJustify() {
		return this._justify != null;
	}

	public GridElement removeJustify() {
		this._justify = null;
		return this;
	} 

	public GridElement setSpacing(Object value) {
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

	public GridElement removeSpacing() {
		this._spacing = null;
		return this;
	} 

	public GridElement addChildren(Object value) {
		this._children.add(value);
		return this;
	}

	public GridElement setChildren(Object[] value) {
		this._children.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public GridElement setChildren(java.util.Collection<Object> values) {
		this._children.addAll(values);
		return this;
	}

	public GridElement removeChildren(Object value) {
		this._children.remove(value);
		return this;
	}

	public GridElement removeChildren(int index) {
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
		GridElement that = (GridElement) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "GridElement(key,className,isContainer,justify,spacing,children) ::= <<<Grid~if(key)~ key=~key~~endif~~if(className)~ className={classes.~className~}~endif~~if(isContainer)~ container~endif~~if(justify)~ justify=\"~justify~\"~endif~~if(spacing)~ spacing={~spacing~}~endif~>\n" + 
				"	~children:{it|~it~};separator=\"\\n\"~\n" + 
				"</Grid> >>";
} 