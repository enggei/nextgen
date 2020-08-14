package nextgen.templates.javascript;

public class Reaction {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _dataFunction;
	private Object _effectFunction;

	Reaction(org.stringtemplate.v4.STGroup stGroup) {
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
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("reaction");
		st.add("dataFunction", _dataFunction);
		st.add("effectFunction", _effectFunction);
		return st.render().trim();
	}

	public Reaction setDataFunction(Object value) {
		this._dataFunction = value;
		return this;
	}

	public Object getDataFunction() {
		return this._dataFunction;
	}

	public Object getDataFunction(Object defaultValue) {
		return this._dataFunction == null ? defaultValue : this._dataFunction;
	}

	public boolean hasDataFunction() {
		return this._dataFunction != null;
	}

	public Reaction removeDataFunction() {
		this._dataFunction = null;
		return this;
	} 

	public Reaction setEffectFunction(Object value) {
		this._effectFunction = value;
		return this;
	}

	public Object getEffectFunction() {
		return this._effectFunction;
	}

	public Object getEffectFunction(Object defaultValue) {
		return this._effectFunction == null ? defaultValue : this._effectFunction;
	}

	public boolean hasEffectFunction() {
		return this._effectFunction != null;
	}

	public Reaction removeEffectFunction() {
		this._effectFunction = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Reaction that = (Reaction) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "reaction(dataFunction,effectFunction) ::= <<reaction(~dataFunction~, ~effectFunction~); >>";
}  