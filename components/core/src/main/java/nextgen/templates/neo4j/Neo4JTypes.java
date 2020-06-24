package nextgen.templates.neo4j;

public enum Neo4JTypes {

	GraphDatabaseFactory() {
		@Override
		public String toString() { return "org.neo4j.graphdb.factory.GraphDatabaseFactory"; }
	},
	GraphDatabaseSettings() {
		@Override
		public String toString() { return "org.neo4j.graphdb.factory.GraphDatabaseSettings"; }
	},
	GraphDatabaseService() {
		@Override
		public String toString() { return "org.neo4j.graphdb.GraphDatabaseService"; }
	},
	Node() {
		@Override
		public String toString() { return "org.neo4j.graphdb.Node"; }
	},
	Label() {
		@Override
		public String toString() { return "org.neo4j.graphdb.Label"; }
	},
	Direction() {
		@Override
		public String toString() { return "org.neo4j.graphdb.Direction"; }
	},
	Relationship() {
		@Override
		public String toString() { return "org.neo4j.graphdb.Relationship"; }
	},
	RelationshipType() {
		@Override
		public String toString() { return "org.neo4j.graphdb.RelationshipType"; }
	},
	Transaction() {
		@Override
		public String toString() { return "org.neo4j.graphdb.Transaction"; }
	}
}  