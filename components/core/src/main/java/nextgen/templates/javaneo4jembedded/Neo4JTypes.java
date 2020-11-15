package nextgen.templates.javaneo4jembedded;

public enum Neo4JTypes {

	RelationshipType() {
		@Override
		public String toString() { return "org.neo4j.graphdb.RelationshipType"; }
	},
	Transaction() {
		@Override
		public String toString() { return "org.neo4j.graphdb.Transaction"; }
	},
	Direction() {
		@Override
		public String toString() { return "org.neo4j.graphdb.Direction"; }
	},
	Relationship() {
		@Override
		public String toString() { return "org.neo4j.graphdb.Relationship"; }
	},
	Node() {
		@Override
		public String toString() { return "org.neo4j.graphdb.Node"; }
	},
	Label() {
		@Override
		public String toString() { return "org.neo4j.graphdb.Label"; }
	},
	GraphDatabaseSettings() {
		@Override
		public String toString() { return "org.neo4j.graphdb.factory.GraphDatabaseSettings"; }
	},
	GraphDatabaseService() {
		@Override
		public String toString() { return "org.neo4j.graphdb.GraphDatabaseService"; }
	},
	GraphDatabaseFactory() {
		@Override
		public String toString() { return "org.neo4j.graphdb.factory.GraphDatabaseFactory"; }
	}
}  