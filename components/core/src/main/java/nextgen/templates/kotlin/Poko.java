package nextgen.templates.kotlin;

public class Poko {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private PackageDeclaration _packageDeclaration;
	private ClassDeclaration _classDeclaration;

	Poko(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("Poko");
		st.add("packageDeclaration", _packageDeclaration);
		st.add("classDeclaration", _classDeclaration);
		return st.render().trim();
	}

	public Poko setPackageDeclaration(PackageDeclaration value) {
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

	public Poko removePackageDeclaration() {
		this._packageDeclaration = null;
		return this;
	} 

	public Poko setClassDeclaration(ClassDeclaration value) {
		this._classDeclaration = value;
		return this;
	}

	public ClassDeclaration getClassDeclaration() {
		return this._classDeclaration;
	}

	public ClassDeclaration getClassDeclaration(ClassDeclaration defaultValue) {
		return this._classDeclaration == null ? defaultValue : this._classDeclaration;
	}

	public boolean hasClassDeclaration() {
		return this._classDeclaration != null;
	}

	public Poko removeClassDeclaration() {
		this._classDeclaration = null;
		return this;
	} 



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Poko that = (Poko) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "Poko(packageDeclaration,classDeclaration) ::= <<~packageDeclaration~\n" + 
				"\n" + 
				"~classDeclaration~ >>";
} 