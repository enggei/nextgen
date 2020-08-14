package nextgen.templates.javascript;

public class Form {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _className;
	private Object _onSubmit;
	private Object _noValidate;
	private java.util.List<Object> _children = new java.util.ArrayList<>();

	Form(org.stringtemplate.v4.STGroup stGroup) {
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
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("form");
		st.add("className", _className);
		st.add("onSubmit", _onSubmit);
		st.add("noValidate", _noValidate);
		for (Object o : _children) st.add("children", o);
		return st.render().trim();
	}

	public Form setClassName(Object value) {
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

	public Form removeClassName() {
		this._className = null;
		return this;
	} 

	public Form setOnSubmit(Object value) {
		this._onSubmit = value;
		return this;
	}

	public Object getOnSubmit() {
		return this._onSubmit;
	}

	public Object getOnSubmit(Object defaultValue) {
		return this._onSubmit == null ? defaultValue : this._onSubmit;
	}

	public boolean hasOnSubmit() {
		return this._onSubmit != null;
	}

	public Form removeOnSubmit() {
		this._onSubmit = null;
		return this;
	} 

	public Form setNoValidate(Object value) {
		this._noValidate = value;
		return this;
	}

	public Object getNoValidate() {
		return this._noValidate;
	}

	public Object getNoValidate(Object defaultValue) {
		return this._noValidate == null ? defaultValue : this._noValidate;
	}

	public boolean hasNoValidate() {
		return this._noValidate != null;
	}

	public Form removeNoValidate() {
		this._noValidate = null;
		return this;
	} 

	public Form addChildren(Object value) {
		this._children.add(value);
		return this;
	}

	public Form setChildren(Object[] value) {
		this._children.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public Form setChildren(java.util.Collection<Object> values) {
		this._children.addAll(values);
		return this;
	}

	public Form removeChildren(Object value) {
		this._children.remove(value);
		return this;
	}

	public Form removeChildren(int index) {
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
		Form that = (Form) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "form(className,onSubmit,noValidate,children) ::= <<<form ~if(className)~className=~className~ ~endif~onSubmit=~onSubmit~~if(noValidate)~ noValidate~endif~~if(children)~>\n" + 
				"	~children:{it|~it~};separator=\"\\n\"~\n" + 
				"</form>~else~ />~endif~ >>";
}  