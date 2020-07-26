package nextgen.templates.materialui;

public class SlideElement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _className;
	private Object _direction;
	private Object _in;
	private Object _timeout;
	private java.util.List<Object> _children = new java.util.ArrayList<>();

	SlideElement(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("SlideElement");
		st.add("className", _className);
		st.add("direction", _direction);
		st.add("in", _in);
		st.add("timeout", _timeout);
		for (Object o : _children) st.add("children", o);
		return st.render().trim();
	}

	public SlideElement setClassName(Object value) {
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

	public SlideElement removeClassName() {
		this._className = null;
		return this;
	} 

	public SlideElement setDirection(Object value) {
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

	public SlideElement removeDirection() {
		this._direction = null;
		return this;
	} 

	public SlideElement setIn(Object value) {
		this._in = value;
		return this;
	}

	public Object getIn() {
		return this._in;
	}

	public Object getIn(Object defaultValue) {
		return this._in == null ? defaultValue : this._in;
	}

	public boolean hasIn() {
		return this._in != null;
	}

	public SlideElement removeIn() {
		this._in = null;
		return this;
	} 

	public SlideElement setTimeout(Object value) {
		this._timeout = value;
		return this;
	}

	public Object getTimeout() {
		return this._timeout;
	}

	public Object getTimeout(Object defaultValue) {
		return this._timeout == null ? defaultValue : this._timeout;
	}

	public boolean hasTimeout() {
		return this._timeout != null;
	}

	public SlideElement removeTimeout() {
		this._timeout = null;
		return this;
	} 

	public SlideElement addChildren(Object value) {
		this._children.add(value);
		return this;
	}

	public SlideElement setChildren(Object[] value) {
		this._children.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public SlideElement setChildren(java.util.Collection<Object> values) {
		this._children.addAll(values);
		return this;
	}

	public SlideElement removeChildren(Object value) {
		this._children.remove(value);
		return this;
	}

	public SlideElement removeChildren(int index) {
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
		SlideElement that = (SlideElement) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "SlideElement(className,direction,in,timeout,children) ::= <<<Slide~if(className)~\n" + 
				"	className=~className~~endif~~if(direction)~\n" + 
				"	direction=\"~direction~\"~endif~~if(in)~\n" + 
				"	in~endif~~if(timeout)~\n" + 
				"	timeout=~timeout~~endif~~if(children)~>\n" + 
				"	~children:{it|~it~};separator=\"\\n\"~\n" + 
				"</Slide>~else~ />~endif~ >>";
}  