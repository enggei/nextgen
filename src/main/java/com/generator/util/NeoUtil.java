package com.generator.util;

import org.neo4j.graphdb.*;

import java.util.*;
import java.util.function.Consumer;

import static java.util.Comparator.comparingLong;
import static org.neo4j.graphdb.Direction.INCOMING;
import static org.neo4j.graphdb.Direction.OUTGOING;

/**
 * goe on 4/23/15.
 */
public abstract class NeoUtil {
   private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(NeoUtil.class);

   public static final String TAG_UUID = "_uuid";

   public static boolean isRelated(Node node, Node target, RelationshipType relationshipType) {
      for (Relationship relationship : outgoing(node, relationshipType))
         if (target.getId() == other(node, relationship).getId()) return true;
      return false;
   }

   public static boolean hasOutgoing(Node node, RelationshipType type) {
      return node != null && node.hasRelationship(type, OUTGOING);
   }

   public static boolean hasLabel(Node node, String label) {
      for (org.neo4j.graphdb.Label lbl : node.getLabels())
         if (lbl.name().equals(label)) return true;
      return false;
   }

   public static boolean hasLabel(Node node, org.neo4j.graphdb.Label label) {
      if (node == null) return false;
      for (org.neo4j.graphdb.Label lbl : node.getLabels())
         if (lbl.name().equals(label.name())) return true;
      return false;
   }

   public static String propertiesFor(PropertyContainer propertyContainer) {
      final StringBuilder out = new StringBuilder();
      boolean first = true;
      for (String key : propertyContainer.getPropertyKeys()) {
         if (!first) out.append(", ");
         out.append(key).append(": '").append(propertyContainer.getProperty(key)).append("'");
         first = false;
      }
      return out.toString();
   }

   public static String labelsFor(Node node) {
      return labelsFor(node, " ");
   }

   public static String labelsFor(Node node, String delimiter) {
      final StringBuilder lbl = new StringBuilder();
      for (org.neo4j.graphdb.Label label : node.getLabels()) lbl.append(label).append(delimiter);
      return lbl.toString().trim();
   }

   public static Iterable<Relationship> outgoing(Node node) {
      return node == null ? Collections.emptyList() : node.getRelationships(OUTGOING);
   }

   public static Iterable<Relationship> outgoing(Node node, RelationshipType type) {
      return node == null ? Collections.emptyList() : sort(node.getRelationships(OUTGOING, type));
   }

   public static Relationship singleOutgoing(Node node, RelationshipType type) {
      try {
         return node == null ? null : node.hasRelationship(type) ? node.getSingleRelationship(type, OUTGOING) : null;
      } catch (Throwable t) {
         if (t instanceof org.neo4j.graphdb.NotFoundException) {
            log.warn("node " + node.getId() + "(" + NeoUtil.labelsFor(node) + ") has more outgoing nodes of type " + type.name() + ". Returning first");
            return outgoing(node, type).iterator().next();
         }
      }
      return null;
   }

   public static Iterable<Relationship> incoming(Node node, RelationshipType type) {
      return node == null ? Collections.emptySet() : sort(node.getRelationships(INCOMING, type));
   }

   public static Iterable<Relationship> incoming(Node node) {
      return node == null ? Collections.emptySet() : sort(node.getRelationships(INCOMING));
   }

   public static Relationship singleIncoming(Node node, RelationshipType type) {
      try {
         return node == null ? null : (node.hasRelationship(type) ? node.getSingleRelationship(type, INCOMING) : null);
      } catch (Throwable t) {
         if (t instanceof org.neo4j.graphdb.NotFoundException) {
            log.warn("node " + node.getId() + "(" + NeoUtil.labelsFor(node) + ") has more incoming nodes of type " + type.name() + ". Returning first");
            return incoming(node, type).iterator().next();
         }
      }
      return null;
   }

   public static Iterable<Relationship> all(Node node, RelationshipType type) {
      return node.getRelationships(type);
   }

   public static Node other(Node node, Relationship relationship) {
      return relationship == null ? null : relationship.getOtherNode(node);
   }

   public static Node otherOutgoing(Node node, RelationshipType type) {
      return other(node, singleOutgoing(node, type));
   }

   @SuppressWarnings("unchecked")
   public static <T> T get(PropertyContainer node, String property) {
      return (T) (has(node, property) ? node.getProperty(property) : null);
   }

   public static String getString(PropertyContainer node, String property) {
      return has(node, property) ? String.valueOf(node.getProperty(property)) : null;
   }

   public static Double getDouble(PropertyContainer node, String property) {
      return has(node, property) ? Double.valueOf(getString(node, property)) : null;
   }

   public static String getString(PropertyContainer node, String property, String defaultValue) {
      return has(node, property) ? String.valueOf(node.getProperty(property)) : defaultValue;
   }

   public static <T> T get(PropertyContainer nodePropertyNode, String property, T defaultValue) {
      if (defaultValue instanceof Boolean)
         return (T) getBoolean(nodePropertyNode, property, (Boolean) defaultValue);
      return has(nodePropertyNode, property) ? (T) nodePropertyNode.getProperty(property) : defaultValue;
   }

   private static Boolean getBoolean(PropertyContainer nodePropertyNode, String property, Boolean defaultValue) {
      return nodePropertyNode.hasProperty(property) ? Boolean.valueOf(nodePropertyNode.getProperty(property).toString()) : defaultValue;
   }

   public static boolean has(PropertyContainer node, String property) {
      return node != null && node.hasProperty(property) && (!"null".equals(node.getProperty(property)));
   }

   public static String types(Iterable<Relationship> relationships) {
      final StringBuilder out = new StringBuilder();
      boolean first = true;
      for (Relationship item : relationships) {
         if (!first) out.append(",");
         first = false;
         out.append(item.getType().name());
      }
      return out.toString();
   }

   private static Iterable<Relationship> sort(Iterable<Relationship> relationships) {
      final Set<Relationship> relations = new TreeSet<>(comparingLong(Relationship::getId));
      for (Relationship relationship : relationships)
         relations.add(relationship);
      return relations;
   }

   public static UUID uuidOf(Node node) {
      return node == null ? null : hasUUID(node) ? UUID.fromString(node.getProperty(TAG_UUID).toString()) : null;
   }

   public static String getNameOrLabelFrom(Node node) {
      if (node == null) return "NULL";
      if (node.hasProperty("name") && !"".equals(node.getProperty("name").toString())) {
         return node.getProperty("name").toString();
      } else {
         // if node has labels, show all
         final StringBuilder lbl = new StringBuilder();
         for (Label label : node.getLabels()) lbl.append(label).append(" ");
         if (lbl.length() > 0) return lbl.toString().trim();
         // if no labels, show uuid:
         return hasUUID(node) ? uuidOf(node).toString() : "[" + node.getPropertyKeys() + "]";
      }
   }

   public static String getNameAndLabelsFrom(Node node) {
      final StringBuilder lbl = new StringBuilder();

      if (node == null) {
         lbl.append("NULL");
      } else {
         String name = getString(node, "name", "");
         if (name.length() == 0) {
            // check if there is an outgoing "name" relation and use this if it exists
            final Node nameNode = other(node, singleOutgoing(node, RelationshipType.withName("name")));
            name = nameNode == null ? "" : getString(nameNode, "name");

         } else {
            name = name.length() > 20 ? (name.substring(0, 20) + "...") : name;
         }
         lbl.append(name);
         lbl.append(name==null ||name.length() == 0 ? "(" : " (");
         for (Label label : node.getLabels()) lbl.append(label).append(" ");
         lbl.append(")");
      }
      return lbl.toString();
   }

   public static String getNameOrTypeFrom(Relationship relationship) {
      if (relationship == null) return "NULL";
      if (relationship.hasProperty("name") && !"".equals(relationship.getProperty("name").toString())) {
         return relationship.getProperty("name").toString();
      } else {
         return relationship.getType().name();
      }
   }

   public static Object getProperty(String name, Node node, Object defaultValue) {
      return node.hasProperty(name) ? node.getProperty(name) : defaultValue;
   }

   public static Relationship relate(Node source, Node target, RelationshipType relationshipType, Object... properties) {

      // if already related, merge properties:
      for (Relationship relationship : outgoing(source, relationshipType))
         if (target.equals(other(source, relationship))) {
            for (int i = 0; i < properties.length; i += 2)
               relationship.setProperty(properties[i].toString(), properties[i + 1]);
            return relationship;
         }

      final Relationship relationship = source.createRelationshipTo(target, relationshipType);
      for (int i = 0; i < properties.length; i += 2)
         relationship.setProperty(properties[i].toString(), properties[i + 1]);

      return relationship;
   }

   private static boolean hasUUID(Node node) {
      return node.hasProperty(TAG_UUID);
   }

   public interface RelationConsumer {
      void accept(Relationship relationship, Node other);
   }
}