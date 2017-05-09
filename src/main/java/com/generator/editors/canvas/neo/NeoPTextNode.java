package com.generator.editors.canvas.neo;

import com.generator.editors.BaseDomainVisitor;
import com.generator.editors.NeoModel;
import org.neo4j.graphdb.*;
import org.neo4j.graphdb.Label;
import org.piccolo2d.nodes.PText;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

import static com.generator.editors.BaseDomainVisitor.other;

/**
 * goe on 11/16/16.
 */
public class NeoPTextNode extends NeoPNode<PText> {

   public NeoPTextNode(Node node, NeoEditor editor, String nodetype) {
      super(node, new PText(NeoModel.getNameOrLabelFrom(node)), nodetype, editor);
   }

   public NeoPTextNode(Node node, String value, NeoEditor editor) {
      super(node, new PText(value), "Text", editor);
   }

   @Override
   public void expand() {

      final Point2D centerPosition = getCenterPosition();
      final Map<UUID, org.neo4j.graphdb.Label> pNodes = new LinkedHashMap<>();

      for (Relationship relationship : node.getRelationships(Direction.OUTGOING)) {

         final Node otherNode = other(node, relationship);

         // no need to expand a node to itself (if relationship is to self)
         if (NeoModel.uuidOf(node).equals(NeoModel.uuidOf(otherNode))) return;

         final Iterator<Label> labels = node.getLabels().iterator();
         final AtomicInteger count = new AtomicInteger();
         final StringBuilder lbl = new StringBuilder();
         while (labels.hasNext()) {
            if (count.get() > 1) lbl.append(" ");
            lbl.append(labels.next());
            count.incrementAndGet();
         }

         if (count.get() == 1) {
            pNodes.put(NeoModel.uuidOf(node), () -> lbl.toString().trim());
         } else {
            pNodes.put(NeoModel.uuidOf(node), null);
         }
      }

      editor.showAndLayout(pNodes, centerPosition);
   }

   @Override
   public void showDependents() {

   }

   @Override
   public void updateView() {
      pNode.setText(NeoModel.getNameOrLabelFrom(node));
   }

   @Override
   public void onSelect() {
      pNode.setTextPaint(Color.RED);
   }

   @Override
   public void onUnselect() {
      pNode.setTextPaint(Color.BLACK);
   }

   @Override
   public void onStartHighlight() {
      pNode.setTextPaint(Color.ORANGE);
   }

   @Override
   public void onEndHighlight() {
      pNode.setTextPaint(selected.get() ? Color.RED : Color.BLACK);
   }
}