package com.generator.app;

import org.neo4j.graphdb.*;

import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

import static com.generator.editors.BaseDomainVisitor.incoming;
import static com.generator.editors.BaseDomainVisitor.other;
import static com.generator.editors.BaseDomainVisitor.outgoing;

/**
 * Created 18.07.17.
 */
final class AppMotif {

   enum Entities implements Label {
      _Layout, _Color, _RegexpPattern
   }

   enum Relations implements RelationshipType {
      _LAYOUT_MEMBER
   }

   enum Properties {
      name, _color, _lastLayout, _x, _y
   }

   enum RelationPaintStrategy {
      showLines, showLinesAndLabels, showNothing
   }

   enum NodePaintStrategy {
      showNameAndLabels, showName, showLabels
   }

   enum RelationPathStrategy {
      straightLines, rectangularLines, bezierLines, quadLines
   }

   enum PropertiesToShow {
      all, hasValue
   }

   static void saveLayout(Node layoutNode, Set<Workspace.NodeCanvas.NeoNode> nodes) {

      outgoing(layoutNode).forEach(Relationship::delete);

      for (Workspace.NodeCanvas.NeoNode neoNode : nodes) {
         final Relationship layoutMembership = layoutNode.createRelationshipTo(neoNode.getNode(), AppMotif.Relations._LAYOUT_MEMBER);
         final Rectangle2D rectangle2D = neoNode.getFullBoundsReference().getBounds2D();
         layoutMembership.setProperty(AppMotif.Properties._x.name(), rectangle2D.getX());
         layoutMembership.setProperty(AppMotif.Properties._y.name(), rectangle2D.getY());
      }
   }

   static void saveLayout(App app, String layoutName, Set<Workspace.NodeCanvas.NeoNode> nodes) {
      final Node existingLayoutNode = app.model.graph().findNode(Entities._Layout, Properties.name.name(), layoutName);
      saveLayout(existingLayoutNode == null ? app.model.graph().newNode(Entities._Layout, Properties.name.name(), layoutName) : existingLayoutNode, nodes);
   }

   static Node getLayoutNode(App app, String name) {
      return app.model.graph().findNode(AppMotif.Entities._Layout, Properties.name.name(), name);
   }

   static Set<AppEvents.NodeLoadEvent> getLayoutNodes(Node layoutNode) {
      final Set<AppEvents.NodeLoadEvent> nodes = new LinkedHashSet<>();
      outgoing(layoutNode, AppMotif.Relations._LAYOUT_MEMBER).forEach(relationship -> {
         final Double x = Double.valueOf(relationship.getProperty(AppMotif.Properties._x.name()).toString());
         final Double y = Double.valueOf(relationship.getProperty(AppMotif.Properties._y.name()).toString());
         nodes.add(new AppEvents.NodeLoadEvent(other(layoutNode, relationship), new Point2D.Double(x, y)));
      });
      return nodes;
   }

   static Set<Node> getAllLayouts(App app) {
      return app.model.graph().getAll(AppMotif.Entities._Layout.name());
   }

   static void deleteLayout(Node layoutNode) {
      outgoing(layoutNode, AppMotif.Relations._LAYOUT_MEMBER).forEach(Relationship::delete);
      layoutNode.delete();
   }

   static void tryToDeleteValueNode(Node oldValueNode) {

      // if oldValueNode is only used by node, delete this as well
      final AtomicBoolean isOnlyUsedByNode = new AtomicBoolean(true);

      incoming(oldValueNode).forEach(valueNodeDependency -> {
         if (AppMotif.Relations._LAYOUT_MEMBER.name().equals(valueNodeDependency.getType().name()))
            return;
         isOnlyUsedByNode.set(false);
      });

      if (isOnlyUsedByNode.get()) {
         incoming(oldValueNode).forEach(Relationship::delete);
         outgoing(oldValueNode).forEach(Relationship::delete);
         oldValueNode.delete();
      }
   }
}