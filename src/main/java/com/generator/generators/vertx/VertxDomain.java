package com.generator.generators.vertx;

import com.generator.editors.NeoModel;
import com.generator.editors.canvas.neo.NeoEditor;
import com.generator.editors.canvas.neo.NeoPNode;
import com.generator.generators.html5.Html5Domain;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.RelationshipType;
import org.neo4j.graphdb.Transaction;
import org.piccolo2d.PNode;
import org.piccolo2d.event.PInputEvent;
import org.piccolo2d.nodes.PText;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

import static com.generator.editors.NeoModel.uuidOf;

/**
 * Created 24.02.17.
 */
public class VertxDomain {

   public enum Entities implements Label {
      Verticle, Server, Client, Router
   }

   public enum RELATIONS implements RelationshipType {
   }

   public static NeoPNode newPNode(Node node, String nodetype, NeoEditor neoEditor) {
      switch (Entities.valueOf(nodetype)) {
         case Verticle:
            return new VerticlePNode(node, neoEditor);

            // todo add rest
         default:
            return null;
      }
   }

   public static Node newVerticle(NeoModel db) {
      final Node newNode = db.newNode(Entities.Verticle);
      return newNode;
   }

   public static void addToMenu(JPopupMenu pop, PInputEvent event, NeoEditor editor) {
      final JMenu newMenu = new JMenu("Vertx");
      newMenu.add(new NewVerticleAction(event, editor));
      pop.add(newMenu);
   }

   public static void deleteNode(Node node) {
      // todo enforce constraints
   }

   public static class DomainPNode<T extends PNode> extends NeoPNode<T> {

      protected final Color selectedColor = Color.RED;
      protected final Color defaultColor;
      private final String property;
      private final org.neo4j.graphdb.Label nodeType;

      public DomainPNode(Node node, Label nodeType, String property, String[] defaultColor, NeoEditor editor) {
         super(node, (T) new PText(node.hasProperty(property) ? node.getProperty(property).toString() : nodeType.name()), nodeType.name(), editor);
         this.defaultColor = new Color(Integer.valueOf(defaultColor[0]), Integer.valueOf(defaultColor[1]), Integer.valueOf(defaultColor[2]));
         this.property = property;
         this.nodeType = nodeType;
//      pNode.setTextPaint(this.defaultColor);
//      pNode.setFont(new Font("Hack", Font.BOLD, 12));
      }

      public DomainPNode(Node node, PText representation, Label nodeType, String[] defaultColor, NeoEditor editor) {
         super(node, (T) representation, nodeType.name(), editor);
         this.defaultColor = new Color(Integer.valueOf(defaultColor[0]), Integer.valueOf(defaultColor[1]), Integer.valueOf(defaultColor[2]));
         this.property = null;
         this.nodeType = nodeType;
//      pNode.setTextPaint(this.defaultColor);
//      pNode.setFont(new Font("Hack", Font.PLAIN, 12));
      }

      @Override
      public String getNodeType() {
         return nodeType.name();
      }

      @Override
      public void expand() {

      }

      @Override
      public void showDependents() {

      }

      @Override
      public void keyPressed(PInputEvent event) {
         super.keyPressed(event);
      }

      @Override
      public void updateView() {
         if (property == null) System.out.println("override updateView: property not set");
//      pNode.setText(property == null ? "?" : node.getProperty(property).toString());
      }

      @Override
      public void onSelect() {
//      pNode.setTextPaint(selectedColor);
      }

      @Override
      public void onUnselect() {
//      pNode.setTextPaint(defaultColor);
      }

      @Override
      public void onStartHighlight() {
//      pNode.setTextPaint(Color.ORANGE);
      }

      @Override
      public void onEndHighlight() {
//      pNode.setTextPaint(selected.get() ? selectedColor : defaultColor);
      }

      @Override
      public void showNodeActions(JPopupMenu pop, PInputEvent event) {

         pop.add(new NeoEditor.TransactionAction("Select all " + nodeType, editor) {
            @Override
            public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
               editor.getAllNodes().forEach(neoPNode -> {
                  if (neoPNode.getNodeType().equals(nodeType.name()) && !neoPNode.selected.get())
                     neoPNode.select();
               });
            }
         });
         pop.add(new NeoEditor.TransactionAction("Hide all " + nodeType, editor) {
            @Override
            public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
               final Set<UUID> hide = new LinkedHashSet<>();
               editor.getAllNodes().forEach(pNode -> {
                  if (pNode.getNodeType().equals(nodeType.name())) hide.add(pNode.uuid);
               });
               hide.forEach(editor::removeNodeFromCanvas);
            }
         });

         pop.add(retainNode());
         pop.add(hideNode());
         pop.add(deleteNode());
      }
   }

   public static class VerticlePNode extends Html5Domain.DomainPNode<PText> {

      public VerticlePNode(Node node, NeoEditor editor) {
         super(node, Entities.Verticle, "name", "153, 52, 4".split(", "), editor);
      }

      @Override
      public void showNodeActions(JPopupMenu pop, PInputEvent event) {

         pop.add(new NeoEditor.TransactionAction("Set Startup Task", editor) {
            @Override
            public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

            }
         });

         pop.add(new NeoEditor.TransactionAction("Add EventBus Handler", editor) {
            @Override
            public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

            }
         });

         super.showNodeActions(pop, event);
      }
   }

   private static class NewVerticleAction extends NeoEditor.TransactionAction {

      private final PInputEvent event;

      NewVerticleAction(PInputEvent event, NeoEditor editor) {
         super("New Verticle Action", editor);
         this.event = event;
      }

      @Override
      public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

         final Node project = newVerticle(editor.getGraph());

         editor.show(uuidOf(project), Entities.Verticle.name()).
               setOffset(event);
      }
   }
}