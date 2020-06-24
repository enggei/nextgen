package nextgen.templates.maven;

public class DependencyManagement {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;

	private java.util.List<Dependency> _dependencies = new java.util.ArrayList<>();

	DependencyManagement(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("dependencyManagement");
		for (Object o : _dependencies) st.add("dependencies", o);
		return st.render().trim();
	}


	public DependencyManagement addDependencies(Dependency value) {
		this._dependencies.add(value);
		return this;
	}

	public DependencyManagement setDependencies(Dependency[] value) {
		this._dependencies.addAll(java.util.Arrays.asList(value));
		return this;
	}

	public DependencyManagement setDependencies(java.util.Collection<Dependency> values) {
		this._dependencies.addAll(values);
		return this;
	}

	public DependencyManagement removeDependencies(Dependency value) {
		this._dependencies.remove(value);
		return this;
	}

	public DependencyManagement removeDependencies(int index) {
		this._dependencies.remove(index);
		return this;
	}

	public java.util.List<Dependency> getDependencies() {
		return this._dependencies;
	} 


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		DependencyManagement that = (DependencyManagement) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "dependencyManagement(dependencies) ::= <<<dependencyManagement>\n" + 
				"	<dependencies>\n" + 
				"		~dependencies:{it|~it~};separator=\"\\n\"~\n" + 
				"	</dependencies>\n" + 
				"</dependencyManagement> >>";
} 