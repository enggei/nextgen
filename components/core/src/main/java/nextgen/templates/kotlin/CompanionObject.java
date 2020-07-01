package nextgen.templates.kotlin;

public class CompanionObject {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private ObjectDeclaration _objectDeclaration;

	CompanionObject(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("CompanionObject");
		st.add("objectDeclaration", _objectDeclaration);
		return st.render().trim();
	}

	public CompanionObject setObjectDeclaration(ObjectDeclaration value) {
		this._objectDeclaration = value;
		return this;
	}

	public ObjectDeclaration getObjectDeclaration() {
		return this._objectDeclaration;
	}

	public ObjectDeclaration getObjectDeclaration(ObjectDeclaration defaultValue) {
		return this._objectDeclaration == null ? defaultValue : this._objectDeclaration;
	}

	public boolean hasObjectDeclaration() {
		return this._objectDeclaration != null;
	}

	public CompanionObject removeObjectDeclaration() {
		this._objectDeclaration = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		CompanionObject that = (CompanionObject) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "CompanionObject(objectDeclaration) ::= <<companion ~objectDeclaration~ >>";
}  