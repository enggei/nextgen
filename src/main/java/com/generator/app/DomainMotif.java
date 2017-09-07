package com.generator.app;

import com.generator.generators.domain.DomainPlugin;
import com.generator.editors.NeoModel;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.RelationshipType;

import java.util.LinkedHashSet;
import java.util.Set;

import static com.generator.editors.BaseDomainVisitor.*;

/**
 * Created 25.08.17.
 */
public class DomainMotif {

   public static Node newEntityRelation(NeoModel graph, Node srcEntity, String name, DomainPlugin.RelationCardinality relationCardinality, Node... dstEntities) {

      if (dstEntities.length == 0) throw new IllegalArgumentException("must have at least 1 dstEntity");

      // check if already related
      for (Relationship relationship : outgoing(srcEntity, DomainPlugin.Relations.SRC)) {
         final Node existingRelationNode = other(srcEntity, relationship);
         if (!name.equals(getString(existingRelationNode, AppMotif.Properties.name.name()))) continue;

         // same name on relation, merge any new dst to it
         final Set<Node> existingDst = new LinkedHashSet<>();
         for (Relationship dstRelation : outgoing(existingRelationNode, DomainPlugin.Relations.DST)) {
            final Node existingDstEntity = other(existingRelationNode, dstRelation);
            for (Node dstEntity : dstEntities) {
               final String existingName = getString(existingDstEntity, AppMotif.Properties.name.name());
               final String newName = getString(dstEntity, AppMotif.Properties.name.name());
               if (existingName == null || newName == null) continue;
               if (existingName.equals(newName)) existingDst.add(dstEntity);
            }
         }

         // set relation
         existingRelationNode.setProperty(DomainPlugin.Properties.relationCardinality.name(), relationCardinality.name());

         // add any new dstEntities
         for (Node dstEntity : dstEntities) {
            if (existingDst.contains(dstEntity)) continue;
            existingRelationNode.createRelationshipTo(dstEntity, DomainPlugin.Relations.DST);
         }

         return existingRelationNode;
      }

      // not related, create new
      final Node newRelationNode = graph.newNode(DomainPlugin.Entities.Relation,
            AppMotif.Properties.name.name(), name,
            DomainPlugin.Properties.relationCardinality.name(), relationCardinality.name());
      srcEntity.createRelationshipTo(newRelationNode, DomainPlugin.Relations.SRC);

      for (Node dstEntity : dstEntities) newRelationNode.createRelationshipTo(dstEntity, DomainPlugin.Relations.DST);

      return newRelationNode;
   }

   public static boolean hasPropertyValue(Node node, String propertyName) {
      final Relationship valueRelation = singleOutgoing(node, RelationshipType.withName(propertyName));
      return valueRelation != null && getString(other(node, valueRelation), AppMotif.Properties.name.name()) != null;
   }

   public static String getPropertyValue(Node node, String propertyName) {
      final Relationship valueRelation = singleOutgoing(node, RelationshipType.withName(propertyName));
      if (valueRelation == null) return null;
      return getString(other(node, valueRelation), AppMotif.Properties.name.name());
   }

   protected Set<Node> findNodes(NeoModel graph, Label label) {
      final Set<Node> nodes = new LinkedHashSet<>();
      graph.findNodes(label).forEachRemaining(nodes::add);
      return nodes;
   }

   protected Set<Node> findNodes(NeoModel graph, Label label, String property, String value) {
      final Set<Node> nodes = new LinkedHashSet<>();
      graph.findNodes(label, property, value).forEachRemaining(nodes::add);
      return nodes;
   }

   protected Node findNode(NeoModel graph, Label label, String property, String value) {
      return graph.findNode(label, property, value);
   }

   protected Node findOrCreate(NeoModel graph, Label label, String name, Object... properties) {
      return graph.findOrCreate(label, name, properties);
   }

   protected void doInTransaction(NeoModel graph, NeoModel.Committer committer) {
      graph.doInTransaction(committer);
   }

   protected Node getProperty(Workspace.NodeCanvas.NeoNode neoNode, String propertyName) {
      return other(neoNode.getNode(), singleOutgoing(neoNode.getNode(), RelationshipType.withName(propertyName)));
   }

   public static boolean hasProperty(Workspace.NodeCanvas.NeoNode neoNode, String propertyName) {
      return hasProperty(neoNode.getNode(), propertyName);
   }

   public static boolean hasProperty(Node node, String propertyName) {
      return hasOutgoing(node, RelationshipType.withName(propertyName));
   }
}