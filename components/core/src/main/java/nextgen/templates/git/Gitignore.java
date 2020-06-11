package nextgen.templates.git;

public class Gitignore {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private java.util.List<Object> _exclude = new java.util.ArrayList<>();

	Gitignore(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("gitignore");
		for (Object o : _exclude) st.add("exclude", o);
		return st.render().trim();
	}


	public Gitignore addExclude(Object value) {
		this._exclude.add(value);
		return this;
	}

	public Gitignore removeExclude(Object value) {
		this._exclude.remove(value);
		return this;
	}

	public Gitignore removeExclude(int index) {
		this._exclude.remove(index);
		return this;
	}

	public java.util.List<Object> getExclude() {
		return this._exclude;
	} 


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Gitignore that = (Gitignore) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "gitignore(exclude) ::= <<~exclude:{it|/~it~/};separator=\"\\n\"~>> ";
}  