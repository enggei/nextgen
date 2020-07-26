package nextgen.templates.materialui;

public class FormGroupElement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _classes;
	private Object _className;
	private Object _row;
	private java.util.List<Object> _children = new java.util.ArrayList<>();

	FormGroupElement(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("FormGroupElement");
		st.add("classes", _classes);
		st.add("className", _className);
		st.add("row", _row);
		for (Object o : _children) st.add("children", o);
		return st.render().trim();
	}

	public FormGroupElement setClasses(Object value) {
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

	public FormGroupElement removeClasses() {
		this._classes = null;
		return this;
	} 

	public FormGroupElement setClassName(Object value) {
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

	public FormGroupElement removeClassName() {
		this._className = null;
		return this;
	} 

	public FormGroupElement setRow(Object value) {
		this._row = value;
		return this;
	}

	public Object getRow() {
		return this._row;
	}

	public Object getRow(Object defaultValue) {
		return this._row == null ? defaultValue : this._row;
	}

	public boolean hasRow() {
		return this._row != null;
	}

	public FormGroupElement removeRow() {
		this._row = null;
		return this;
	} 

	public FormGroupElement addChildren(Object value) {
		this._children.add(value);
		return this;
	}

	public FormGroupElement setChildren(Object[] value) {
		this._children.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public FormGroupElement setChildren(java.util.Collection<Object> values) {
		this._children.addAll(values);
		return this;
	}

	public FormGroupElement removeChildren(Object value) {
		this._children.remove(value);
		return this;
	}

	public FormGroupElement removeChildren(int index) {
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
		FormGroupElement that = (FormGroupElement) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "FormGroupElement(classes,className,row,children) ::= <<<FormGroup~if(classes)~\n" + 
				"	classes=~classes~~endif~~if(className)~\n" + 
				"	className=~className~~endif~~if(row)~\n" + 
				"	row~endif~~if(children)~>\n" + 
				"	~children:{it|~it~};separator=\"\\n\"~\n" + 
				"</FormGroup>~else~ />~endif~ >>";
}  