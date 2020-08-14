package nextgen.templates.materialui;

public class GridElement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _alignContent;
	private Object _alignItems;
	private Object _classes;
	private Object _className;
	private Object _component;
	private Object _container;
	private Object _direction;
	private Object _id;
	private Object _item;
	private Object _justify;
	private Object _lg;
	private Object _md;
	private Object _sm;
	private Object _spacing;
	private Object _wrap;
	private Object _xl;
	private Object _xs;
	private Object _zeroMinWidth;
	private java.util.List<Object> _children = new java.util.ArrayList<>();

	GridElement(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Deprecated
	public java.util.UUID uuid() {
		return uuid;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("GridElement");
		st.add("alignContent", _alignContent);
		st.add("alignItems", _alignItems);
		st.add("classes", _classes);
		st.add("className", _className);
		st.add("component", _component);
		st.add("container", _container);
		st.add("direction", _direction);
		st.add("id", _id);
		st.add("item", _item);
		st.add("justify", _justify);
		st.add("lg", _lg);
		st.add("md", _md);
		st.add("sm", _sm);
		st.add("spacing", _spacing);
		st.add("wrap", _wrap);
		st.add("xl", _xl);
		st.add("xs", _xs);
		st.add("zeroMinWidth", _zeroMinWidth);
		for (Object o : _children) st.add("children", o);
		return st.render().trim();
	}

	public GridElement setAlignContent(Object value) {
		this._alignContent = value;
		return this;
	}

	public Object getAlignContent() {
		return this._alignContent;
	}

	public Object getAlignContent(Object defaultValue) {
		return this._alignContent == null ? defaultValue : this._alignContent;
	}

	public boolean hasAlignContent() {
		return this._alignContent != null;
	}

	public GridElement removeAlignContent() {
		this._alignContent = null;
		return this;
	} 

	public GridElement setAlignItems(Object value) {
		this._alignItems = value;
		return this;
	}

	public Object getAlignItems() {
		return this._alignItems;
	}

	public Object getAlignItems(Object defaultValue) {
		return this._alignItems == null ? defaultValue : this._alignItems;
	}

	public boolean hasAlignItems() {
		return this._alignItems != null;
	}

	public GridElement removeAlignItems() {
		this._alignItems = null;
		return this;
	} 

	public GridElement setClasses(Object value) {
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

	public GridElement removeClasses() {
		this._classes = null;
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

	public GridElement setComponent(Object value) {
		this._component = value;
		return this;
	}

	public Object getComponent() {
		return this._component;
	}

	public Object getComponent(Object defaultValue) {
		return this._component == null ? defaultValue : this._component;
	}

	public boolean hasComponent() {
		return this._component != null;
	}

	public GridElement removeComponent() {
		this._component = null;
		return this;
	} 

	public GridElement setContainer(Object value) {
		this._container = value;
		return this;
	}

	public Object getContainer() {
		return this._container;
	}

	public Object getContainer(Object defaultValue) {
		return this._container == null ? defaultValue : this._container;
	}

	public boolean hasContainer() {
		return this._container != null;
	}

	public GridElement removeContainer() {
		this._container = null;
		return this;
	} 

	public GridElement setDirection(Object value) {
		this._direction = value;
		return this;
	}

	public Object getDirection() {
		return this._direction;
	}

	public Object getDirection(Object defaultValue) {
		return this._direction == null ? defaultValue : this._direction;
	}

	public boolean hasDirection() {
		return this._direction != null;
	}

	public GridElement removeDirection() {
		this._direction = null;
		return this;
	} 

	public GridElement setId(Object value) {
		this._id = value;
		return this;
	}

	public Object getId() {
		return this._id;
	}

	public Object getId(Object defaultValue) {
		return this._id == null ? defaultValue : this._id;
	}

	public boolean hasId() {
		return this._id != null;
	}

	public GridElement removeId() {
		this._id = null;
		return this;
	} 

	public GridElement setItem(Object value) {
		this._item = value;
		return this;
	}

	public Object getItem() {
		return this._item;
	}

	public Object getItem(Object defaultValue) {
		return this._item == null ? defaultValue : this._item;
	}

	public boolean hasItem() {
		return this._item != null;
	}

	public GridElement removeItem() {
		this._item = null;
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

	public GridElement setLg(Object value) {
		this._lg = value;
		return this;
	}

	public Object getLg() {
		return this._lg;
	}

	public Object getLg(Object defaultValue) {
		return this._lg == null ? defaultValue : this._lg;
	}

	public boolean hasLg() {
		return this._lg != null;
	}

	public GridElement removeLg() {
		this._lg = null;
		return this;
	} 

	public GridElement setMd(Object value) {
		this._md = value;
		return this;
	}

	public Object getMd() {
		return this._md;
	}

	public Object getMd(Object defaultValue) {
		return this._md == null ? defaultValue : this._md;
	}

	public boolean hasMd() {
		return this._md != null;
	}

	public GridElement removeMd() {
		this._md = null;
		return this;
	} 

	public GridElement setSm(Object value) {
		this._sm = value;
		return this;
	}

	public Object getSm() {
		return this._sm;
	}

	public Object getSm(Object defaultValue) {
		return this._sm == null ? defaultValue : this._sm;
	}

	public boolean hasSm() {
		return this._sm != null;
	}

	public GridElement removeSm() {
		this._sm = null;
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

	public GridElement setWrap(Object value) {
		this._wrap = value;
		return this;
	}

	public Object getWrap() {
		return this._wrap;
	}

	public Object getWrap(Object defaultValue) {
		return this._wrap == null ? defaultValue : this._wrap;
	}

	public boolean hasWrap() {
		return this._wrap != null;
	}

	public GridElement removeWrap() {
		this._wrap = null;
		return this;
	} 

	public GridElement setXl(Object value) {
		this._xl = value;
		return this;
	}

	public Object getXl() {
		return this._xl;
	}

	public Object getXl(Object defaultValue) {
		return this._xl == null ? defaultValue : this._xl;
	}

	public boolean hasXl() {
		return this._xl != null;
	}

	public GridElement removeXl() {
		this._xl = null;
		return this;
	} 

	public GridElement setXs(Object value) {
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

	public GridElement removeXs() {
		this._xs = null;
		return this;
	} 

	public GridElement setZeroMinWidth(Object value) {
		this._zeroMinWidth = value;
		return this;
	}

	public Object getZeroMinWidth() {
		return this._zeroMinWidth;
	}

	public Object getZeroMinWidth(Object defaultValue) {
		return this._zeroMinWidth == null ? defaultValue : this._zeroMinWidth;
	}

	public boolean hasZeroMinWidth() {
		return this._zeroMinWidth != null;
	}

	public GridElement removeZeroMinWidth() {
		this._zeroMinWidth = null;
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

	static final String st = "GridElement(alignContent,alignItems,classes,className,component,container,direction,id,item,justify,lg,md,sm,spacing,wrap,xl,xs,zeroMinWidth,children) ::= <<<Grid~if(alignContent)~\n" + 
				"	alignContent=\"~alignContent~\"~endif~~if(alignItems)~\n" + 
				"	alignItems=\"~alignItems~\"~endif~~if(classes)~\n" + 
				"	classes=~classes~~endif~~if(className)~\n" + 
				"	className=~className~~endif~~if(component)~\n" + 
				"	component=~component~~endif~~if(container)~\n" + 
				"	container~endif~~if(direction)~\n" + 
				"	direction=\"~direction~\"~endif~~if(id)~\n" + 
				"	id=\"~id~\"~endif~~if(item)~\n" + 
				"	item~endif~~if(justify)~\n" + 
				"	justify=\"~justify~\"~endif~~if(lg)~\n" + 
				"	lg=\"~lg~\"~endif~~if(md)~\n" + 
				"	md=\"~md~\"~endif~~if(sm)~\n" + 
				"	sm=\"~sm~\"~endif~~if(spacing)~\n" + 
				"	spacing=\"~spacing~\"~endif~~if(wrap)~\n" + 
				"	wrap=\"~wrap~\"~endif~~if(xl)~\n" + 
				"	xl=\"~xl~\"~endif~~if(xs)~\n" + 
				"	xs=\"~xs~\"~endif~~if(zeroMinWidth)~\n" + 
				"	zeroMinWidth~endif~~if(children)~>\n" + 
				"	~children:{it|~it~};separator=\"\\n\"~\n" + 
				"</Grid>~else~ />~endif~ >>";
}  