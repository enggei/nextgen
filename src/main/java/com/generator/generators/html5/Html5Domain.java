package com.generator.generators.html5;

import com.generator.editors.NeoModel;
import com.generator.editors.canvas.neo.NeoEditor;
import com.generator.editors.canvas.neo.NeoPNode;
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
 * Created 27.01.17.
 */
public class Html5Domain {

   // todo work on this, and allow to make a web-page from nodes

   public static NeoPNode newPNode(Node node, String nodetype, NeoEditor neoEditor) {
      switch (Entities.valueOf(nodetype)) {
         case Html:
            return new HtmlPNode(node, neoEditor);
         case Head:
            return new HeadPNode(node, neoEditor);
         case Body:
            return new BodyPNode(node, neoEditor);
         default:
            return null;
      }
   }

   public enum Entities implements Label {
      Html, Head, Body
   }

   public enum RELATIONS implements RelationshipType {
      CHILD,PARENT
   }

   public static Node newHtmlNode(NeoModel db) {
      final Node newNode = db.newNode(Entities.Html);
      return newNode;
   }

   public static void deleteNode(Node node) {
      // todo enforce constraints
   }

   public static void addToMenu(JPopupMenu pop, PInputEvent event, NeoEditor editor) {
      final JMenu newMenu = new JMenu("HtmlPage");
      newMenu.add(new NewHtmlPageAction(event, editor));
      pop.add(newMenu);
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

   public static class HtmlPNode extends DomainPNode<PText> {

      public HtmlPNode(Node node, NeoEditor editor) {
         super(node, Entities.Html, "name", "153, 52, 4".split(", "), editor);
      }

      @Override
      public void showNodeActions(JPopupMenu pop, PInputEvent event) {

         pop.add(new NeoEditor.TransactionAction("Set head", editor) {
            @Override
            public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

            }
         });


         super.showNodeActions(pop, event);
      }
   }

   public static class BodyPNode extends DomainPNode<PText> {

      public BodyPNode(Node node, NeoEditor editor) {
         super(node, Entities.Html, "name", "153, 52, 4".split(", "), editor);
      }
   }

   public static class HeadPNode extends DomainPNode<PText> {

      public HeadPNode(Node node, NeoEditor editor) {
         super(node, Entities.Html, "name", "153, 52, 4".split(", "), editor);
      }
   }


   private static class NewHtmlPageAction extends NeoEditor.TransactionAction {

      private final PInputEvent event;

      NewHtmlPageAction(PInputEvent event, NeoEditor editor) {
         super("New Html Page", editor);
         this.event = event;
      }

      @Override
      public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

         final Node project = newHtmlNode(editor.getGraph());

         editor.show(uuidOf(project), Entities.Html.name()).
               setOffset(event);
      }
   }
}
