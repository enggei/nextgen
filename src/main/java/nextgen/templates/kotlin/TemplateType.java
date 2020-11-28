package nextgen.templates.kotlin;

public class TemplateType implements TypeDeclaration {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private String _name;
	private java.util.List<TypeDeclaration> _templates = new java.util.ArrayList<>();

	TemplateType(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("TemplateType");
		st.add("name", _name);
		for (Object o : _templates) st.add("templates", o);
		return st.render().trim();
	}

	public TemplateType setName(String value) {
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

	public TemplateType removeName() {
		this._name = null;
		return this;
	} 

	public TemplateType addTemplates(TypeDeclaration value) {
		this._templates.add(value);
		return this;
	}

	public TemplateType setTemplates(TypeDeclaration[] value) {
		this._templates.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public TemplateType setTemplates(java.util.Collection<TypeDeclaration> values) {
		this._templates.addAll(values);
		return this;
	}

	public TemplateType removeTemplates(TypeDeclaration value) {
		this._templates.remove(value);
		return this;
	}

	public TemplateType removeTemplates(int index) {
		this._templates.remove(index);
		return this;
	}

	public java.util.List<TypeDeclaration> getTemplates() {
		return this._templates;
	} 


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		TemplateType that = (TemplateType) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "TemplateType(name,templates) ::= <<~name~<~templates:{it|~it~};separator=\", \"~> >>";
}  