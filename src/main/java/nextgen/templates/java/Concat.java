package nextgen.templates.java;

public class Concat {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _two;
	private Object _one;

	Concat(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("concat");
		st.add("two", _two);
		st.add("one", _one);
		return st.render().trim();
	}

	public Concat setTwo(Object value) {
		this._two = value;
		return this;
	}

	public Object getTwo() {
		return this._two;
	}

	public Object getTwo(Object defaultValue) {
		return this._two == null ? defaultValue : this._two;
	}

	public boolean hasTwo() {
		return this._two != null;
	}

	public Concat removeTwo() {
		this._two = null;
		return this;
	} 

	public Concat setOne(Object value) {
		this._one = value;
		return this;
	}

	public Object getOne() {
		return this._one;
	}

	public Object getOne(Object defaultValue) {
		return this._one == null ? defaultValue : this._one;
	}

	public boolean hasOne() {
		return this._one != null;
	}

	public Concat removeOne() {
		this._one = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Concat that = (Concat) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "concat(two,one) ::= <<concat(~one~,~two~) >>";
}  