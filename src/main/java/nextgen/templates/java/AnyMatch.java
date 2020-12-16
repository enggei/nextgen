package nextgen.templates.java;

public class AnyMatch {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _predicate;

	AnyMatch(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("anyMatch");
		st.add("predicate", _predicate);
		return st.render().trim();
	}

	public AnyMatch setPredicate(Object value) {
		this._predicate = value;
		return this;
	}

	public Object getPredicate() {
		return this._predicate;
	}

	public Object getPredicate(Object defaultValue) {
		return this._predicate == null ? defaultValue : this._predicate;
	}

	public boolean hasPredicate() {
		return this._predicate != null;
	}

	public AnyMatch removePredicate() {
		this._predicate = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		AnyMatch that = (AnyMatch) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "anyMatch(predicate) ::= <<anyMatch(~predicate~) >>";
}  