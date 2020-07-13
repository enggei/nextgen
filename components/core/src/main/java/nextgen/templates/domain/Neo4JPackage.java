package nextgen.templates.domain;

public class Neo4JPackage {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;


	Neo4JPackage(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	public java.util.UUID uuid() {
		return uuid;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("Neo4JPackage");
		return st.render().trim();
	}




	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Neo4JPackage that = (Neo4JPackage) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "Neo4JPackage() ::= <<final PackageDeclaration neo4jGraphdb = newPackageDeclaration(\"org.neo4j.graphdb\");\n" + 
				"final NamedEntity NeoTransaction = new NamedEntity(\"Transaction\", neo4jGraphdb); >>";
}  