package nextgen.templates.git;

public class Gitignore {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private java.util.List<Object> _excludeDirs = new java.util.ArrayList<>();
	private java.util.List<Object> _excludeFiles = new java.util.ArrayList<>();

	Gitignore(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("gitignore");
		for (Object o : _excludeDirs) st.add("excludeDirs", o);
		for (Object o : _excludeFiles) st.add("excludeFiles", o);
		return st.render().trim();
	}


	public Gitignore addExcludeDirs(Object value) {
		this._excludeDirs.add(value);
		return this;
	}

	public Gitignore setExcludeDirs(Object[] value) {
		this._excludeDirs.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public Gitignore setExcludeDirs(java.util.Collection<Object> values) {
		this._excludeDirs.addAll(values);
		return this;
	}

	public Gitignore removeExcludeDirs(Object value) {
		this._excludeDirs.remove(value);
		return this;
	}

	public Gitignore removeExcludeDirs(int index) {
		this._excludeDirs.remove(index);
		return this;
	}

	public java.util.List<Object> getExcludeDirs() {
		return this._excludeDirs;
	} 

	public Gitignore addExcludeFiles(Object value) {
		this._excludeFiles.add(value);
		return this;
	}

	public Gitignore setExcludeFiles(Object[] value) {
		this._excludeFiles.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public Gitignore setExcludeFiles(java.util.Collection<Object> values) {
		this._excludeFiles.addAll(values);
		return this;
	}

	public Gitignore removeExcludeFiles(Object value) {
		this._excludeFiles.remove(value);
		return this;
	}

	public Gitignore removeExcludeFiles(int index) {
		this._excludeFiles.remove(index);
		return this;
	}

	public java.util.List<Object> getExcludeFiles() {
		return this._excludeFiles;
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

	static final String st = "gitignore(excludeDirs,excludeFiles) ::= <<~excludeDirs:{it|/~it~/};separator=\"\\n\"~\n" + 
				"~excludeFiles:{it|/~it~};separator=\"\\n\"~ >>";
}  