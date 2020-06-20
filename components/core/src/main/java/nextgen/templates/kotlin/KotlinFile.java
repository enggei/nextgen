package nextgen.templates.kotlin;

public class KotlinFile {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private PackageDeclaration _packageDeclaration;
	private java.util.List<java.util.Collection<CompilationUnit>> _compilationUnit = new java.util.ArrayList<>();

	KotlinFile(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("KotlinFile");
		st.add("packageDeclaration", _packageDeclaration);
		for (Object o : _compilationUnit) st.add("compilationUnit", o);
		return st.render().trim();
	}

	public KotlinFile setPackageDeclaration(PackageDeclaration value) {
		this._packageDeclaration = value;
		return this;
	}

	public PackageDeclaration getPackageDeclaration() {
		return this._packageDeclaration;
	}

	public PackageDeclaration getPackageDeclaration(PackageDeclaration defaultValue) {
		return this._packageDeclaration == null ? defaultValue : this._packageDeclaration;
	}

	public boolean hasPackageDeclaration() {
		return this._packageDeclaration != null;
	}

	public KotlinFile removePackageDeclaration() {
		this._packageDeclaration = null;
		return this;
	} 

	public KotlinFile addCompilationUnit(java.util.Collection<CompilationUnit> value) {
		this._compilationUnit.add(value);
		return this;
	}

	public KotlinFile setCompilationUnit(java.util.Collection<CompilationUnit>[] value) {
		this._compilationUnit.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public KotlinFile setCompilationUnit(java.util.Collection<java.util.Collection<CompilationUnit>> values) {
		this._compilationUnit.addAll(values);
		return this;
	}

	public KotlinFile removeCompilationUnit(java.util.Collection<CompilationUnit> value) {
		this._compilationUnit.remove(value);
		return this;
	}

	public KotlinFile removeCompilationUnit(int index) {
		this._compilationUnit.remove(index);
		return this;
	}

	public java.util.List<java.util.Collection<CompilationUnit>> getCompilationUnit() {
		return this._compilationUnit;
	} 


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		KotlinFile that = (KotlinFile) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "KotlinFile(packageDeclaration,compilationUnit) ::= <<~packageDeclaration~\n" + 
				"\n" + 
				"~compilationUnit:{it|~it~};separator=\"\\n\\n\"~ >>";
} 