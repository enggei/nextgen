package nextgen.templates.java;

public class CompilationUnit {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _packageDeclaration;
	private java.util.List<Object> _types = new java.util.ArrayList<>();
	private java.util.List<Object> _importDeclaration = new java.util.ArrayList<>();

	CompilationUnit(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID getUuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("CompilationUnit");
		st.add("packageDeclaration", _packageDeclaration);
		for (Object o : _types) st.add("types", o);
		for (Object o : _importDeclaration) st.add("importDeclaration", o);
		return st.render().trim();
	}

	public CompilationUnit setPackageDeclaration(Object value) {
		this._packageDeclaration = value;
		return this;
	}

	public Object getPackageDeclaration() {
		return this._packageDeclaration;
	}

	public Object getPackageDeclaration(Object defaultValue) {
		return this._packageDeclaration == null ? defaultValue : this._packageDeclaration;
	}

	public boolean hasPackageDeclaration() {
		return this._packageDeclaration != null;
	}

	public CompilationUnit removePackageDeclaration() {
		this._packageDeclaration = null;
		return this;
	} 

	public CompilationUnit addTypes(Object value) {
		this._types.add(value);
		return this;
	}

	public CompilationUnit setTypes(Object[] value) {
		this._types.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public CompilationUnit setTypes(java.util.Collection<Object> values) {
		this._types.addAll(values);
		return this;
	}

	public CompilationUnit removeTypes(Object value) {
		this._types.remove(value);
		return this;
	}

	public CompilationUnit removeTypes(int index) {
		this._types.remove(index);
		return this;
	}

	public java.util.List<Object> getTypes() {
		return this._types;
	} 

	public CompilationUnit addImportDeclaration(Object value) {
		this._importDeclaration.add(value);
		return this;
	}

	public CompilationUnit setImportDeclaration(Object[] value) {
		this._importDeclaration.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public CompilationUnit setImportDeclaration(java.util.Collection<Object> values) {
		this._importDeclaration.addAll(values);
		return this;
	}

	public CompilationUnit removeImportDeclaration(Object value) {
		this._importDeclaration.remove(value);
		return this;
	}

	public CompilationUnit removeImportDeclaration(int index) {
		this._importDeclaration.remove(index);
		return this;
	}

	public java.util.List<Object> getImportDeclaration() {
		return this._importDeclaration;
	} 


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		CompilationUnit that = (CompilationUnit) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "CompilationUnit(packageDeclaration,types,importDeclaration) ::= <<~packageDeclaration~\n" + 
				"\n" + 
				"~importDeclaration:{it|~it~};separator=\"\\n\"~\n" + 
				"\n" + 
				"~types:{it|~it~};separator=\"\\n\\n\"~ >>";
}  