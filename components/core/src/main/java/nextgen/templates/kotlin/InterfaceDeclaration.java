package nextgen.templates.kotlin;

public class InterfaceDeclaration implements InterfaceDefinition, CompilationUnit {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private String _name;
	private java.util.List<Extending> _extends = new java.util.ArrayList<>();

	InterfaceDeclaration(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("InterfaceDeclaration");
		st.add("name", _name);
		for (Object o : _extends) st.add("extends", o);
		return st.render().trim();
	}

	public InterfaceDeclaration setName(String value) {
		this._name = value;
		return this;
	}

	public String getName() {
		return this._name;
	}

	public String getName(String defaultValue) {
		return this._name == null ? defaultValue : this._name;
	}

	public boolean hasName() {
		return this._name != null;
	}

	public InterfaceDeclaration removeName() {
		this._name = null;
		return this;
	} 

	public InterfaceDeclaration addExtends(Extending value) {
		this._extends.add(value);
		return this;
	}

	public InterfaceDeclaration setExtends(Extending[] value) {
		this._extends.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public InterfaceDeclaration setExtends(java.util.Collection<Extending> values) {
		this._extends.addAll(values);
		return this;
	}

	public InterfaceDeclaration removeExtends(Extending value) {
		this._extends.remove(value);
		return this;
	}

	public InterfaceDeclaration removeExtends(int index) {
		this._extends.remove(index);
		return this;
	}

	public java.util.List<Extending> getExtends() {
		return this._extends;
	} 


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		InterfaceDeclaration that = (InterfaceDeclaration) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "InterfaceDeclaration(name,extends) ::= <<interface ~name~~if(extends)~: ~extends:{it|~it~};separator=\", \"~~endif~ >>";
}  