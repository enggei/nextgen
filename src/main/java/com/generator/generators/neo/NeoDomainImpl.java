package com.generator.generators.neo;

import com.generator.editors.canvas.neo.NeoEditor;
import com.generator.editors.canvas.neo.NeoPNode;
import org.neo4j.graphdb.*;
import org.piccolo2d.event.PInputEvent;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import java.util.function.Consumer;

import static com.generator.editors.BaseDomainVisitor.getString;
import static com.generator.editors.BaseDomainVisitor.labelsFor;
import static com.generator.editors.NeoModel.uuidOf;

/**
 * Created 28.04.17.
 */
public class NeoDomainImpl extends NeoDomain {

   // introspection of itself...

   @Override
   public void addToDomainMenu(PInputEvent event, NeoEditor editor, JMenu domainMenu) {

      domainMenu.add(new NeoEditor.TransactionAction("Show all Labels in use", editor) {
         @Override
         public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

            final Map<String, Node> map = new HashMap<>();
            graph.getAll(Entities.label.name()).forEach(node -> map.put(getString(node, Properties.label.name()), node));

            final Map<UUID, Label> pNodes = new LinkedHashMap<>();
            graph.getGraphDb().getAllLabelsInUse().forEach(label -> {

               // merge labels found with the existing LabelPNodes:
               Node node = map.get(label.name());
               if (node == null) {
                  node = graph.newNode(Entities.label);
                  node.setProperty(Properties.name.name(), label.name());
               }
               pNodes.put(uuidOf(node), Entities.label);
            });

            editor.showAndLayout(pNodes, event.getCanvasPosition());
         }
      });

      domainMenu.add(new NeoEditor.TransactionAction("Show all Relations in use", editor) {
         @Override
         public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

            final Map<String, Node> map = new HashMap<>();
            graph.getAll(Entities.relation.name()).forEach(node -> map.put(getString(node, Properties.name.name()), node));

            final Map<UUID, Label> pNodes = new LinkedHashMap<>();
            graph.getGraphDb().getAllRelationshipTypesInUse().forEach(relationtype -> {

               // merge relationtypes found with the existing LabelPNodes:
               Node node = map.get(relationtype.name());
               if (node == null) {
                  node = graph.newNode(Entities.relation);
                  node.setProperty(Properties.name.name(), relationtype.name());
               }
               pNodes.put(uuidOf(node), Entities.relation);
            });

            editor.showAndLayout(pNodes, event.getCanvasPosition());
         }
      });
   }


   @Override
   protected NeoPNode newDatabasePNode(Node node, NeoEditor editor) {
      return new DatabasePNode(node, editor) {
         @Override
         public void showNodeActions(JPopupMenu pop, PInputEvent event) {
            super.showNodeActions(pop, event);
         }
      };
   }

   @Override
   protected NeoPNode newNodePNode(Node node, NeoEditor editor) {
      return new NodePNode(node, editor) {
         @Override
         public void showNodeActions(JPopupMenu pop, PInputEvent event) {
            super.showNodeActions(pop, event);
         }
      };
   }

   @Override
   protected NeoPNode newRelationPNode(Node node, NeoEditor editor) {
      return new RelationPNode(node, editor) {
         @Override
         public void showNodeActions(JPopupMenu pop, PInputEvent event) {

            pop.add(new NeoEditor.TransactionAction("Show all relations", editor) {
               @Override
               public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                  final Map<UUID, Label> pNodes = new LinkedHashMap<>();
                  final RelationshipType type = RelationshipType.withName(getString(node, Properties.name.name()));
                  editor.getGraph().getGraphDb().getAllRelationships().forEach(new Consumer<Relationship>() {
                     @Override
                     public void accept(Relationship relationship) {
                        if (!type.equals(relationship.getType())) return;

                        final Node src = relationship.getStartNode();
                        final Node dst = relationship.getEndNode();

                        // find first label
                        final Label srcLabel = src.getLabels().iterator().next();
                        final Label dstLabel = dst.getLabels().iterator().next();

                        System.out.println(srcLabel + " -> " + type + " -> " + dstLabel);

                        pNodes.put(uuidOf(src), srcLabel);
                        pNodes.put(uuidOf(dst), dstLabel);
                     }
                  });

                  editor.showAndLayout(pNodes, event.getCanvasPosition());
               }
            });
         }
      };
   }

   @Override
   protected NeoPNode newPropertyPNode(Node node, NeoEditor editor) {
      return new PropertyPNode(node, editor) {
         @Override
         public void showNodeActions(JPopupMenu pop, PInputEvent event) {
            super.showNodeActions(pop, event);
         }
      };
   }

   @Override
   protected NeoPNode newLabelPNode(Node node, NeoEditor editor) {
      return new LabelPNode(node, editor) {
         @Override
         public void showNodeActions(JPopupMenu pop, PInputEvent event) {
            pop.add(editor.showAllNodesByLabel(Label.label(getString(node, Properties.name.name())), event));
         }
      };
   }

   @Override
   protected NeoPNode new_layoutPNode(Node node, NeoEditor editor) {
      return new _layoutPNode(node, editor) {
         @Override
         public void showNodeActions(JPopupMenu pop, PInputEvent event) {
            super.showNodeActions(pop, event);
         }
      };
   }

   @Override
   public void deleteNode(Node node) throws NeoEditor.ReferenceException {
      super.deleteNode(node);
   }
}