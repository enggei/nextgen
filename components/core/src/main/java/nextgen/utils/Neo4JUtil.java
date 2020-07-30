package nextgen.utils;

import org.neo4j.graphdb.Direction;
import org.neo4j.graphdb.Node;

public class Neo4JUtil {

    public static String toString(Node node) {
        final StringBuilder out = new StringBuilder();
        out.append("Node : ");
        node.getLabels().forEach(label -> out.append(label.name()).append(" "));
        node.getPropertyKeys().forEach(s -> out.append("\n\t").append(s).append(":").append(node.getProperty(s)));
        node.getRelationships(Direction.OUTGOING).forEach(relationship -> relationship.getPropertyKeys().forEach(s -> out.append("\n\t\t -> ").append(s).append(":").append(relationship.getProperty(s))));
        node.getRelationships(Direction.INCOMING).forEach(relationship -> relationship.getPropertyKeys().forEach(s -> out.append("\n\t\t <- ").append(s).append(":").append(relationship.getProperty(s))));
        return out.toString().trim();
    }
}
