package nextgen.templates.materialui;

public class TimelineOppositeContentElement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _classes;
	private Object _className;
	private java.util.List<Object> _children = new java.util.ArrayList<>();

	TimelineOppositeContentElement(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("TimelineOppositeContentElement");
		st.add("classes", _classes);
		st.add("className", _className);
		for (Object o : _children) st.add("children", o);
		return st.render().trim();
	}

	public TimelineOppositeContentElement setClasses(Object value) {
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

	public TimelineOppositeContentElement removeClasses() {
		this._classes = null;
		return this;
	} 

	public TimelineOppositeContentElement setClassName(Object value) {
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

	public TimelineOppositeContentElement removeClassName() {
		this._className = null;
		return this;
	} 

	public TimelineOppositeContentElement addChildren(Object value) {
		this._children.add(value);
		return this;
	}

	public TimelineOppositeContentElement setChildren(Object[] value) {
		this._children.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public TimelineOppositeContentElement setChildren(java.util.Collection<Object> values) {
		this._children.addAll(values);
		return this;
	}

	public TimelineOppositeContentElement removeChildren(Object value) {
		this._children.remove(value);
		return this;
	}

	public TimelineOppositeContentElement removeChildren(int index) {
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
		TimelineOppositeContentElement that = (TimelineOppositeContentElement) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "TimelineOppositeContentElement(classes,className,children) ::= <<<TimelineOppositeContent~if(classes)~\n" + 
				"	classes=~classes~~endif~~if(className)~\n" + 
				"	className=~className~~endif~~if(children)~>\n" + 
				"	~children:{it|~it~};separator=\"\\n\"~\n" + 
				"</TimelineOppositeContent>~else~ />~endif~ >>";
}  