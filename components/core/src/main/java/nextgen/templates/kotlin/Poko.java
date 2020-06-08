package nextgen.templates.kotlin;

public class Poko {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private Object _packageDeclaration;
	private Object _classDeclaration;

	Poko(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
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

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("Poko");
		st.add("packageDeclaration", _packageDeclaration);
		st.add("classDeclaration", _classDeclaration);
		return st.render().trim();
	}

	public Poko setPackageDeclaration(Object value) {
		this._packageDeclaration = value;
		return this;
	}

	public Object getPackageDeclaration() {
		return this._packageDeclaration;
	}

	public boolean hasPackageDeclaration() {
		return this._packageDeclaration != null;
	}

	public Poko removePackageDeclaration() {
		this._packageDeclaration = null;
		return this;
	} 

	public Poko setClassDeclaration(Object value) {
		this._classDeclaration = value;
		return this;
	}

	public Object getClassDeclaration() {
		return this._classDeclaration;
	}

	public boolean hasClassDeclaration() {
		return this._classDeclaration != null;
	}

	public Poko removeClassDeclaration() {
		this._classDeclaration = null;
		return this;
	} 

	static final String st = "Poko(packageDeclaration,classDeclaration) ::= <<~packageDeclaration~\n" + 
				"\n" + 
				"~classDeclaration~>> ";
} 