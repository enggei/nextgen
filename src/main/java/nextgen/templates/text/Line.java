package nextgen.templates.text;

public class Line {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _line;
	private Object _end;
	private Object _next;
	private java.util.List<Object> _children = new java.util.ArrayList<>();

	Line(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("Line");
		st.add("line", _line);
		st.add("end", _end);
		st.add("next", _next);
		for (Object o : _children) st.add("children", o);
		return st.render().trim();
	}

	public Line setLine(Object value) {
		this._line = value;
		return this;
	}

	public Object getLine() {
		return this._line;
	}

	public Object getLine(Object defaultValue) {
		return this._line == null ? defaultValue : this._line;
	}

	public boolean hasLine() {
		return this._line != null;
	}

	public Line removeLine() {
		this._line = null;
		return this;
	} 

	public Line setEnd(Object value) {
		this._end = value;
		return this;
	}

	public Object getEnd() {
		return this._end;
	}

	public Object getEnd(Object defaultValue) {
		return this._end == null ? defaultValue : this._end;
	}

	public boolean hasEnd() {
		return this._end != null;
	}

	public Line removeEnd() {
		this._end = null;
		return this;
	} 

	public Line setNext(Object value) {
		this._next = value;
		return this;
	}

	public Object getNext() {
		return this._next;
	}

	public Object getNext(Object defaultValue) {
		return this._next == null ? defaultValue : this._next;
	}

	public boolean hasNext() {
		return this._next != null;
	}

	public Line removeNext() {
		this._next = null;
		return this;
	} 

	public Line addChildren(Object value) {
		this._children.add(value);
		return this;
	}

	public Line setChildren(Object[] value) {
		this._children.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public Line setChildren(java.util.Collection<Object> values) {
		this._children.addAll(values);
		return this;
	}

	public Line removeChildren(Object value) {
		this._children.remove(value);
		return this;
	}

	public Line removeChildren(int index) {
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
		Line that = (Line) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "Line(line,children,end,next) ::= <<~line~~if(children)~\n" + 
				"	~children:{it|~it~};separator=\"\\n\"~~endif~~if(end)~\n" + 
				"~end~~endif~\n" + 
				"~next~ >>";
}  