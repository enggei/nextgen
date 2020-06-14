package nextgen.st.stringtemplate;

public class TemplateTestMethod {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _template;

	TemplateTestMethod(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("templateTestMethod");
		st.add("template", _template);
		return st.render().trim();
	}

	public TemplateTestMethod setTemplate(Object value) {
		this._template = value;
		return this;
	}

	public Object getTemplate() {
		return this._template;
	}

	public Object getTemplate(Object defaultValue) {
		return this._template == null ? defaultValue : this._template;
	}

	public boolean hasTemplate() {
		return this._template != null;
	}

	public TemplateTestMethod removeTemplate() {
		this._template = null;
		return this;
	}



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		TemplateTestMethod that = (TemplateTestMethod) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "templateTestMethod(template) ::= <<@org.junit.Test\n" + 
				"public void test~template;format=\"capitalize\"~() {\n" + 
				"	System.out.println(\"\\n--- TEST ~template~:\\n\" + new~template;format=\"capitalize\"~());\n" + 
				"} >>";
}