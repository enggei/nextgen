package nextgen.utils;

import org.neo4j.graphdb.Direction;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;

public class Neo4JUtil {

    public static String toString(Node node) {
        final StringBuilder out = new StringBuilder();
        out.append("Node : ");
        node.getLabels().forEach(label -> out.append(label.name()).append(" "));
        out.append("(");
        node.getPropertyKeys().forEach(s -> out.append(" ").append(s).append(":").append(node.getProperty(s)));
        out.append(")");
        node.getRelationships(Direction.OUTGOING).forEach(relationship -> relationship.getPropertyKeys().forEach(s -> out.append("\n\t\t -> ").append(s).append(":").append(relationship.getProperty(s))));
        node.getRelationships(Direction.INCOMING).forEach(relationship -> relationship.getPropertyKeys().forEach(s -> out.append("\n\t\t <- ").append(s).append(":").append(relationship.getProperty(s))));
        return out.toString().trim();
    }

    public static String toString(Relationship relationship) {
        final StringBuilder out = new StringBuilder();
        out.append("Relationship : ").append(relationship.getType()).append(" ");
        out.append("(");
        relationship.getPropertyKeys().forEach(s -> out.append(" ").append(s).append(":").append(relationship.getProperty(s)));
        out.append(")");
        out.append(" ").append(toString(relationship.getStartNode())).append(" -> ").append(toString(relationship.getEndNode()));
        return out.toString().trim();
    }

}
