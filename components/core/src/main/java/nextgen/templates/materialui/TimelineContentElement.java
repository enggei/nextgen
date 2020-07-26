package nextgen.templates.materialui;

public class TimelineContentElement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _classes;
	private Object _className;
	private java.util.List<Object> _children = new java.util.ArrayList<>();

	TimelineContentElement(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("TimelineContentElement");
		st.add("classes", _classes);
		st.add("className", _className);
		for (Object o : _children) st.add("children", o);
		return st.render().trim();
	}

	public TimelineContentElement setClasses(Object value) {
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

	public TimelineContentElement removeClasses() {
		this._classes = null;
		return this;
	} 

	public TimelineContentElement setClassName(Object value) {
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

	public TimelineContentElement removeClassName() {
		this._className = null;
		return this;
	} 

	public TimelineContentElement addChildren(Object value) {
		this._children.add(value);
		return this;
	}

	public TimelineContentElement setChildren(Object[] value) {
		this._children.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public TimelineContentElement setChildren(java.util.Collection<Object> values) {
		this._children.addAll(values);
		return this;
	}

	public TimelineContentElement removeChildren(Object value) {
		this._children.remove(value);
		return this;
	}

	public TimelineContentElement removeChildren(int index) {
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
		TimelineContentElement that = (TimelineContentElement) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "TimelineContentElement(classes,className,children) ::= <<<TimelineContent~if(classes)~\n" + 
				"	classes=~classes~~endif~~if(className)~\n" + 
				"	className=~className~~endif~~if(children)~>\n" + 
				"	~children:{it|~it~};separator=\"\\n\"~\n" + 
				"</TimelineContent>~else~ />~endif~ >>";
}  