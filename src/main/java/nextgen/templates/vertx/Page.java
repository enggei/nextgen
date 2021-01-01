package nextgen.templates.vertx;

public class Page {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private String _name;
	private Object _packageName;

	Page(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("Page");
		st.add("name", _name);
		st.add("packageName", _packageName);
		return st.render().trim();
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

	static final String st = "Page(name,packageName) ::= <<package ~packageName~;\n" + 
				"\n" + 
				"import io.vertx.core.buffer.Buffer;\n" + 
				"import munster.models.HomePageModel;\n" + 
				"import ui.materialdesignlight.Page;\n" + 
				"\n" + 
				"public class ~name~ extends BasePage {\n" + 
				"\n" + 
				"	private final String render;\n" + 
				"\n" + 
				"	public ~name~(Buffer buffer) {\n" + 
				"		\n" + 
				"		final HomePageModel model = new HomePageModel(buffer);\n" + 
				"		final Page page = newStandardPage(model);\n" + 
				"\n" + 
				"		model.cardModelStream().forEach(item -> page.addBody(newCard(item)));\n" + 
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