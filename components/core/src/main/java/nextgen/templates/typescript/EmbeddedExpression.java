package nextgen.templates.typescript;

public class EmbeddedExpression {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _ref;

	EmbeddedExpression(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("embeddedExpression");
		st.add("ref", _ref);
		return st.render().trim();
	}

	public EmbeddedExpression setRef(Object value) {
		this._ref = value;
		return this;
	}

	public Object getRef() {
		return this._ref;
	}

	public Object getRef(Object defaultValue) {
		return this._ref == null ? defaultValue : this._ref;
	}

	public boolean hasRef() {
		return this._ref != null;
	}

	public EmbeddedExpression removeRef() {
		this._ref = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		EmbeddedExpression that = (EmbeddedExpression) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "embeddedExpression(ref) ::= <<${ ~ref~ } >>";
} 