package nextgen.templates.vertx;

public class Page {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _model;
	private String _name;
	private Object _packageName;
	private java.util.List<Object> _body = new java.util.ArrayList<>();

	Page(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("Page");
		st.add("model", _model);
		st.add("name", _name);
		st.add("packageName", _packageName);
		for (Object o : _body) st.add("body", o);
		return st.render().trim();
	}

	public Page setModel(Object value) {
		this._model = value;
		return this;
	}

	public Object getModel() {
		return this._model;
	}

	public Object getModel(Object defaultValue) {
		return this._model == null ? defaultValue : this._model;
	}

	public boolean hasModel() {
		return this._model != null;
	}

	public Page removeModel() {
		this._model = null;
		return this;
	} 

	public Page setName(String value) {
		this._name = value;
		return this;
	}

	public String getName() {
		return this._name;
	}

	public String getName(String defaultValue) {
		return this._name == null ? defaultValue : this._name;
	}

	public boolean hasName() {
		return this._name != null;
	}

	public Page removeName() {
		this._name = null;
		return this;
	} 

	public Page setPackageName(Object value) {
		this._packageName = value;
		return this;
	}

	public Object getPackageName() {
		return this._packageName;
	}

	public Object getPackageName(Object defaultValue) {
		return this._packageName == null ? defaultValue : this._packageName;
	}

	public boolean hasPackageName() {
		return this._packageName != null;
	}

	public Page removePackageName() {
		this._packageName = null;
		return this;
	} 

	public Page addBody(Object value) {
		this._body.add(value);
		return this;
	}

	public Page setBody(Object[] value) {
		this._body.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public Page setBody(java.util.Collection<Object> values) {
		this._body.addAll(values);
		return this;
	}

	public Page removeBody(Object value) {
		this._body.remove(value);
		return this;
	}

	public Page removeBody(int index) {
		this._body.remove(index);
		return this;
	}

	public java.util.List<Object> getBody() {
		return this._body;
	} 


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Page that = (Page) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "Page(model,body,name,packageName) ::= <<package ~packageName~;\n" + 
				"\n" + 
				"import io.vertx.core.buffer.Buffer;\n" + 
				"import munster.models.~model~;\n" + 
				"import ui.materialdesignlight.Page;\n" + 
				"\n" + 
				"public class ~name~ extends BasePage {\n" + 
				"\n" + 
				"	private final String render;\n" + 
				"\n" + 
				"	public ~name~(Buffer buffer) {\n" + 
				"		\n" + 
				"		final ~model~ model = new ~model~(buffer);\n" + 
				"		final Page page = newStandardPage(model);\n" + 
				"\n" + 
				"		~body:{it|~it~};separator=\"\\n\"~\n" + 
				"\n" + 
				"		render = page.toString().trim();\n" + 
				"	}\n" + 
				"\n" + 
				"	@Override\n" + 
				"	public String toString() {\n" + 
				"		return render;\n" + 
				"	}\n" + 
				"} >>";
}  