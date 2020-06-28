package nextgen.templates.kotlin;

public class MutableListType implements TypeDeclaration {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private TypeDeclaration _type;

	MutableListType(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("MutableListType");
		st.add("type", _type);
		return st.render().trim();
	}

	public MutableListType setType(TypeDeclaration value) {
		this._type = value;
		return this;
	}

	public TypeDeclaration getType() {
		return this._type;
	}

	public TypeDeclaration getType(TypeDeclaration defaultValue) {
		return this._type == null ? defaultValue : this._type;
	}

	public boolean hasType() {
		return this._type != null;
	}

	public MutableListType removeType() {
		this._type = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		MutableListType that = (MutableListType) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "MutableListType(type) ::= <<MutableList<~type~> >>";
}  