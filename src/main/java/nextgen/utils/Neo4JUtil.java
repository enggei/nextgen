package nextgen.utils;


public class Neo4JUtil {

public static String toString(org.neo4j.graphdb.Node node) {
    final StringBuilder out = new StringBuilder();
    out.append("Node : ").append(node.getId()).append(" ");
    node.getLabels().forEach(label -> out.append(label.name()).append(" "));
    out.append("(");
    node.getPropertyKeys().forEach(s -> out.append(" ").append(s).append(":").append(node.getProperty(s)));
    out.append(")");
    node.getRelationships(org.neo4j.graphdb.Direction.OUTGOING).forEach(relationship -> relationship.getPropertyKeys().forEach(s -> out.append("\n\t\t -> ").append(s).append(":").append(relationship.getProperty(s))));
    node.getRelationships(org.neo4j.graphdb.Direction.INCOMING).forEach(relationship -> relationship.getPropertyKeys().forEach(s -> out.append("\n\t\t <- ").append(s).append(":").append(relationship.getProperty(s))));
    return out.toString().trim();
}

public static String toString(org.neo4j.graphdb.Relationship relationship) {
    final StringBuilder out = new StringBuilder();
    out.append("Relationship : ").append(relationship.getType()).append(" ");
    out.append("(");
    relationship.getPropertyKeys().forEach(s -> out.append(" ").append(s).append(":").append(relationship.getProperty(s)));
    out.append(")");
    out.append(" ").append(toString(relationship.getStartNode())).append(" -> ").append(toString(relationship.getEndNode()));
    return out.toString().trim();
}

}
