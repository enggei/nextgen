package com.generator.app;

import com.generator.app.nodes.NeoNode;
import com.generator.generators.domain.DomainPlugin;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.RelationshipType;

import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

import static com.generator.util.NeoUtil.*;

/**
 * Created 18.07.17.
 */
public final class AppMotif {

   private final static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(AppMotif.class);

   public static Font getDefaultFont() {
      return new Font("Hack", Font.PLAIN, 10);
   }

   public enum Entities implements Label {
      _Layout, _Color, _RegexpPattern, _Motif
   }

   public enum Relations implements RelationshipType {
      _LAYOUT_MEMBER
   }

   public enum Properties {
      name, _color, _lastLayout, x, y
   }

   public enum RelationPaintStrategy {
      showLines, showLinesAndLabels, showNothing, showLinesAndProperties
   }

   public enum NodePaintStrategy {
      showNameAndLabels, showName, showLabels, showProperties, showValues
   }

   public enum RelationPathStrategy {
      straightLines, rectangularLines, bezierLines, quadLines
   }

   enum PropertiesToShow {
      all, hasValue
   }

   static void saveLayout(Node layoutNode, Set<NeoNode> nodes) {

      outgoing(layoutNode).forEach(Relationship::delete);

      for (NeoNode neoNode : nodes) {
         final Relationship layoutMembership = layoutNode.createRelationshipTo(neoNode.getNode(), AppMotif.Relations._LAYOUT_MEMBER);
         final Rectangle2D rectangle2D = neoNode.getFullBoundsReference().getBounds2D();
         layoutMembership.setProperty(AppMotif.Properties.x.name(), rectangle2D.getX());
         layoutMembership.setProperty(AppMotif.Properties.y.name(), rectangle2D.getY());
      }
   }

   static void saveLayout(App app, String layoutName, Set<NeoNode> nodes) {
      final Node existingLayoutNode = app.model.graph().findNode(Entities._Layout, Properties.name.name(), layoutName);
      saveLayout(existingLayoutNode == null ? app.model.graph().newNode(Entities._Layout, Properties.name.name(), layoutName) : existingLayoutNode, nodes);
   }

   public static boolean isLayout(Node node) {
      return hasLabel(node, AppMotif.Entities._Layout);
   }

   static Node getLayoutNode(App app, String name) {
      return app.model.graph().findNode(AppMotif.Entities._Layout, Properties.name.name(), name);
   }

   static Set<AppEvents.NodeLoadEvent> getLayoutNodes(Node layoutNode) {
      log.info("getLayoutNodes ");
      final Set<AppEvents.NodeLoadEvent> nodes = new LinkedHashSet<>();
      outgoing(layoutNode, AppMotif.Relations._LAYOUT_MEMBER).forEach(relationship -> {
         final Double x = Double.valueOf(relationship.getProperty(AppMotif.Properties.x.name()).toString());
         final Double y = Double.valueOf(relationship.getProperty(AppMotif.Properties.y.name()).toString());
         nodes.add(new AppEvents.NodeLoadEvent(other(layoutNode, relationship), new Point2D.Double(x, y)));
      });
      log.info("getLayoutNodes done");
      return nodes;
   }

   static Set<Node> getAllLayouts(App app) {
      return app.model.graph().getAll(AppMotif.Entities._Layout.name());
   }

   public static void tryToDeleteValueNode(Node oldValueNode) {

      final AtomicBoolean notInUse = new AtomicBoolean(true);

      // if there are not any nodes (except LAYOUT and INSTANCES) linked to this node, delete it
      incoming(oldValueNode).forEach(valueNodeDependency -> {
         if (AppMotif.Relations._LAYOUT_MEMBER.name().equals(valueNodeDependency.getType().name())) return;
         if (DomainPlugin.Relations.INSTANCE.name().equals(valueNodeDependency.getType().name())) return;
         notInUse.set(false);
      });

      if (notInUse.get()) {
         incoming(oldValueNode).forEach(Relationship::delete);
         outgoing(oldValueNode).forEach(Relationship::delete);
         oldValueNode.delete();
      }
   }
}
