package nextgen.templates.kotlin;

public class KotlinStringTemplateSingleValue implements KotlinStringTemplate {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private String _name;

	KotlinStringTemplateSingleValue(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("KotlinStringTemplateSingleValue");
		st.add("name", _name);
		return st.render().trim();
	}

	public KotlinStringTemplateSingleValue setName(String value) {
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

	public KotlinStringTemplateSingleValue removeName() {
		this._name = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		KotlinStringTemplateSingleValue that = (KotlinStringTemplateSingleValue) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "KotlinStringTemplateSingleValue(name) ::= <<$~name~ >>";
}  