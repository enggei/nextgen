package com.nextgen.core;

import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import org.neo4j.graphdb.*;

import java.util.*;

public class ImportExportManager {

    public static JsonArray importGraph(GraphDatabaseService db, JsonArray relations, JsonArray nodes) {

        final JsonArray result = new JsonArray();
        final Map<String, Node> nodeMap = new LinkedHashMap<>();
        for (Object n : nodes) {
            final JsonObject node = (JsonObject) n;
            final Node newNode = db.createNode(Label.label(node.getString("Label")));
            for (Object p : node.getJsonArray("properties")) {
                final JsonObject property = (JsonObject) p;

                // replace existing _uuid with new _uuid, and map old _uuid with new node, to ensure relations are connected correctly
                if ("_uuid".equals(property.getString("name"))) {
                    nodeMap.put(property.getString("value"), newNode);
                    continue;
                }

                newNode.setProperty(property.getString("name"), property.getValue("value"));
            }

            // set new uuid
            newNode.setProperty("_uuid", UUID.randomUUID().toString());

            result.add(new JsonObject().put("node", newNode.getProperty("_uuid").toString()));
        }

        for (Object r : relations) {
            final JsonObject relation = (JsonObject) r;
            final Node src = nodeMap.get(relation.getString("src"));
            final Node dst = nodeMap.get(relation.getString("dst"));

            final Relationship newRelationship = src.createRelationshipTo(dst, RelationshipType.withName(relation.getString("RelationshipType")));
            for (Object p : relation.getJsonArray("properties")) {
                final JsonObject property = (JsonObject) p;
                newRelationship.setProperty(property.getString("name"), property.getValue("value"));
            }

            // set new uuid
            newRelationship.setProperty("_uuid", UUID.randomUUID().toString());

            result.add(new JsonObject().put("relation", newRelationship.getProperty("_uuid")).put("type", newRelationship.getType().name()));
        }

        return result;
    }

    public static JsonObject exportGraph(Node node) {

        final JsonObject result = new JsonObject();
        final JsonArray nodes = new JsonArray();
        final JsonArray relations = new JsonArray();

        visitNode(node, nodes, relations, new LinkedHashSet<>());

        result.put("nodes", nodes);
        result.put("relations", relations);

        return result;
    }

    private static void visitNode(Node node, JsonArray nodes, JsonArray relations, Set<PropertyContainer> visited) {

        if (visited.contains(node)) return;
        visited.add(node);

        nodes.add(toJsonObject(node, node.getLabels().iterator().next().name()));   // note, assumes only one label, and uses first

        node.getRelationships(Direction.OUTGOING).forEach(relationship -> {
            visitNode(relationship.getOtherNode(node), nodes, relations, visited);
            if (visited.contains(relationship)) return;
            visited.add(relationship);
            relations.add(toJsonObject(relationship, relationship.getType().name()));
        });
    }

    private static JsonObject toJsonObject(Node node, String label) {
        final JsonObject jsonObject = new JsonObject();
        jsonObject.put("Label", label);

        if (!node.hasProperty("_uuid")) node.setProperty("_uuid", UUID.randomUUID().toString());

        final JsonArray properties = new JsonArray();
        for (Map.Entry<String, Object> entry : node.getAllProperties().entrySet())
            properties.add(new JsonObject().put("name", entry.getKey()).put("value", entry.getValue()));
        jsonObject.put("properties", properties);
        return jsonObject;
    }

    private static JsonObject toJsonObject(Relationship relationship, String type) {
        final JsonObject jsonObject = new JsonObject();
        jsonObject.put("RelationshipType", type);
        jsonObject.put("src", relationship.getStartNode().getProperty("_uuid"));
        jsonObject.put("dst", relationship.getEndNode().getProperty("_uuid"));
        final JsonArray properties = new JsonArray();
        for (Map.Entry<String, Object> entry : relationship.getAllProperties().entrySet())
            properties.add(new JsonObject().put("name", entry.getKey()).put("value", entry.getValue()));
        jsonObject.put("properties", properties);
        return jsonObject;
    }
}