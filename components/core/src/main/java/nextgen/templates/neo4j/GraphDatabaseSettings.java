package nextgen.templates.neo4j;

public class GraphDatabaseSettings {

	private final java.util.UUID uuid = java.util.UUID.randomUUID();
	private final org.stringtemplate.v4.STGroup stGroup;


	GraphDatabaseSettings(org.stringtemplate.v4.STGroup stGroup) {
		this.stGroup = stGroup;
	}

	@Override
	public String toString() {
		final org.stringtemplate.v4.ST st = stGroup.getInstanceOf("GraphDatabaseSettings");
		return st.render().trim();
	}


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		GraphDatabaseSettings that = (GraphDatabaseSettings) o;
		return uuid.equals(that.uuid);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(uuid);
	}

	static final String st = "GraphDatabaseSettings() ::= <<org.neo4j.graphdb.factory.GraphDatabaseSettings>> ";
}  