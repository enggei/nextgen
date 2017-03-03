package com.generator.generators.easyFlow;

import com.generator.editors.NeoModel;
import com.generator.editors.canvas.neo.NeoEditor;
import com.generator.editors.canvas.neo.NeoPNode;
import com.generator.util.SwingUtil;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.*;
import org.piccolo2d.event.PInputEvent;
import org.piccolo2d.nodes.PText;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.*;
import java.util.function.Consumer;

import static com.generator.editors.BaseDomainVisitor.*;
import static com.generator.editors.NeoModel.getNameOrLabelFrom;
import static com.generator.editors.NeoModel.uuidOf;
import static com.generator.generators.easyFlow.EasyFlowDomain.Entities.*;
import static com.generator.generators.easyFlow.EasyFlowDomain.Relations.FROM;
import static com.generator.generators.easyFlow.EasyFlowDomain.Relations.PROPERTY;
import static org.neo4j.graphdb.Direction.INCOMING;

/**
 * Created 23.02.17.
 */
public class EasyFlowDomain {

   public enum Entities implements Label {
      Flow, ContextProperty, State, Event, SuperParameter
   }

   public enum Properties implements Label {
      name, extending, packageName, templateFile, contextGeneric, type, modifier, comment, value
   }

   public enum Relations implements RelationshipType {
      FROM, ON, TO, FINISH, PROPERTY, SUPERPARAMETERS
   }

   public static NeoPNode newPNode(Node node, String nodetype, NeoEditor neoEditor) {
      switch (Entities.valueOf(nodetype)) {
         case Flow:
            return new FlowPNode(node, neoEditor);
         case State:
            return new StatePNode(node, neoEditor);
         case Event:
            return new EventPNode(node, neoEditor);
         case ContextProperty:
            return new ContextPropertyPNode(node, neoEditor);
      }

      throw new IllegalArgumentException("unsupported TemplateDomain nodetype " + nodetype + " for node " + NeoModel.debugNode(node));
   }

   public static void addToMenu(JPopupMenu pop, PInputEvent event, NeoEditor editor) {
      final JMenu newMenu = new JMenu("EasyFlow");
      newMenu.add(new NewFlow(event, editor));
      pop.add(newMenu);
   }

   public static void deleteNode(Node node) {
      // todo enforce constraints
      final Set<Relationship> constraints = new LinkedHashSet<>();
      final Consumer<Relationship> constraintVisitor = relationship -> {
         if (NeoEditor.isAppRelated(relationship)) return;
         constraints.add(relationship);
      };

      if (node.hasLabel(ContextProperty)) {
         node.getRelationships(INCOMING, PROPERTY).forEach(Relationship::delete);
         node.getRelationships(INCOMING, FROM).forEach(Relationship::delete);

      }

      // delete from layouts:
      NeoEditor.removeFromLayouts(node);

      node.delete();
   }

   public static class FlowPNode extends EasyFlowDomainPNode {

      FlowPNode(Node node, NeoEditor editor) {
         super(node, Flow, EasyFlowDomain.Properties.name.name(), "64, 64, 64".split(", "), editor);
      }

      @Override
      public void showNodeActions(JPopupMenu pop, PInputEvent event) {

         pop.add(new NeoEditor.TransactionAction("Add From", editor) {
            @Override
            public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

               final String name = SwingUtil.showInputDialog("Name", canvas);
               if (name == null) return;

               final Node newNode = graph.newNode(State);
               newNode.setProperty(Properties.name.name(), name);
               node.createRelationshipTo(newNode, Relations.FROM);

               editor.show(NeoModel.uuidOf(newNode), Entities.State.name()).setOffset(event);
            }
         });

         pop.add(new NeoEditor.TransactionAction("Add ContextProperty", editor) {
            @Override
            public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

               final Node newNode = graph.newNode(ContextProperty);
               //newNode.setProperty(Properties.name.name(), name);
               node.createRelationshipTo(newNode, PROPERTY);

               editor.show(NeoModel.uuidOf(newNode), Entities.ContextProperty.name()).setOffset(event);
            }
         });

         super.showNodeActions(pop, event);
      }

      @Override
      public void expand() {
         final Map<UUID, Label> pNodes = new LinkedHashMap<>();
         outgoing(node, Relations.FROM).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.State));
         outgoing(node, PROPERTY).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.ContextProperty));
         editor.showAndLayout(pNodes, pNode);
      }
   }

   public static class ContextPropertyPNode extends EasyFlowDomainPNode {

      ContextPropertyPNode(Node node, NeoEditor editor) {
         super(node, ContextProperty, EasyFlowDomain.Properties.name.name(), "64, 64, 64".split(", "), editor);
      }

      @Override
      public void showNodeActions(JPopupMenu pop, PInputEvent event) {

         pop.add(new NeoEditor.TransactionAction("Edit", editor) {
            @Override
            public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

               final ContextPropertyEditor form = new ContextPropertyEditor(node);
               SwingUtil.showDialogNoDefaultButton(form, editor.canvas, "ContextPropery", () -> {
                  editor.doInTransaction(tx1 -> {
                     form.commit(node);
                     editor.show(uuidOf(node), ContextProperty.name()).
                           setOffset(event);
                  });
               });

            }
         });

         super.showNodeActions(pop, event);
      }
   }

   public static class StatePNode extends EasyFlowDomainPNode {

      StatePNode(Node node, NeoEditor editor) {
         super(node, State, EasyFlowDomain.Properties.name.name(), "64, 64, 64".split(", "), editor);
      }

      @Override
      public void showNodeActions(JPopupMenu pop, PInputEvent event) {

         pop.add(new NeoEditor.TransactionAction("Set name", editor) {
            @Override
            public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

               final String name = SwingUtil.showInputDialog("Name", canvas, node.hasProperty(Properties.name.name()) ? getString(node, Properties.name.name()) : "");
               if (name == null) return;

               node.setProperty(Properties.name.name(), name);
               updateView();
            }
         });

         pop.add(new NeoEditor.TransactionAction("Add Event", editor) {
            @Override
            public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

               final String name = SwingUtil.showInputDialog("Name", canvas);
               if (name == null) return;

               final Node newNode = graph.newNode(Event);
               newNode.setProperty(Properties.name.name(), name);
               node.createRelationshipTo(newNode, Relations.ON);

               editor.show(NeoModel.uuidOf(newNode), Entities.Event.name()).setOffset(event);
            }
         });

         super.showNodeActions(pop, event);
      }

      @Override
      public void expand() {
         final Map<UUID, Label> pNodes = new LinkedHashMap<>();
         outgoing(node, Relations.ON).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.Event));
         editor.showAndLayout(pNodes, pNode);
      }

      @Override
      public void showTargetActions(JPopupMenu pop, PInputEvent event) {

         final Collection<NeoPNode> selectedNodes = editor.getSelectedNodes();

         if (selectedNodes.size() != 1) return;

         final Node selectedNode = selectedNodes.iterator().next().node;
         if (!selectedNode.hasLabel(Event)) return;

         pop.add(new NeoEditor.TransactionAction("Add To", editor) {
            @Override
            public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

               final Relationship newRelation = selectedNode.createRelationshipTo(node, Relations.TO);
               editor.addRelation(newRelation);
               updateView();
            }
         });

         pop.add(new NeoEditor.TransactionAction("Add Finish", editor) {
            @Override
            public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

               final Relationship newRelation = selectedNode.createRelationshipTo(node, Relations.FINISH);
               editor.addRelation(newRelation);
               updateView();
            }
         });

         SwingUtilities.invokeLater(editor.canvas::repaint);
      }
   }

   public static class EventPNode extends EasyFlowDomainPNode {

      EventPNode(Node node, NeoEditor editor) {
         super(node, Entities.Event, EasyFlowDomain.Properties.name.name(), "128, 64, 255".split(", "), editor);
      }

      @Override
      public void showNodeActions(JPopupMenu pop, PInputEvent event) {

         pop.add(new NeoEditor.TransactionAction("Set name", editor) {
            @Override
            public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

               final String name = SwingUtil.showInputDialog("Name", canvas, node.hasProperty(Properties.name.name()) ? getString(node, Properties.name.name()) : "");
               if (name == null) return;

               node.setProperty(Properties.name.name(), name);
               updateView();
            }
         });

         pop.add(new NeoEditor.TransactionAction("Add To", editor) {
            @Override
            public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

               final String name = SwingUtil.showInputDialog("Name", canvas);
               if (name == null) return;

               final Node newNode = graph.newNode(State);
               newNode.setProperty(Properties.name.name(), name);
               node.createRelationshipTo(newNode, Relations.TO);

               editor.show(NeoModel.uuidOf(newNode), Entities.State.name()).setOffset(event);
            }
         });

         pop.add(new NeoEditor.TransactionAction("Add Finish", editor) {
            @Override
            public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

               final String name = SwingUtil.showInputDialog("Name", canvas);
               if (name == null) return;

               final Node newNode = graph.newNode(State);
               newNode.setProperty(Properties.name.name(), name);
               node.createRelationshipTo(newNode, Relations.FINISH);

               editor.show(NeoModel.uuidOf(newNode), Entities.State.name()).setOffset(event);
            }
         });

         super.showNodeActions(pop, event);
      }

      @Override
      public void expand() {
         final Map<UUID, Label> pNodes = new LinkedHashMap<>();
         outgoing(node, Relations.TO).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.State));
         outgoing(node, Relations.FINISH).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.State));
         editor.showAndLayout(pNodes, pNode);
      }
   }

   private static class EasyFlowDomainPNode extends NeoPNode<PText> {

      final Color selectedColor = Color.RED;
      private final Color defaultColor;
      private final String property;
      private final EasyFlowDomain.Entities nodeType;

      EasyFlowDomainPNode(Node node, EasyFlowDomain.Entities nodeType, String property, String[] defaultColor, NeoEditor editor) {
         super(node, new PText(node.hasProperty(property) ? node.getProperty(property).toString() : getNameOrLabelFrom(node)), nodeType.name(), editor);
         this.defaultColor = new Color(Integer.valueOf(defaultColor[0]), Integer.valueOf(defaultColor[1]), Integer.valueOf(defaultColor[2]));
         this.property = property;
         this.nodeType = nodeType;
         pNode.setTextPaint(this.defaultColor);
         pNode.setFont(new Font("Hack", Font.BOLD, 12));
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
         pNode.setText(property == null ? "?" : node.getProperty(property).toString());
      }

      @Override
      public void onSelect() {
         pNode.setTextPaint(selectedColor);
      }

      @Override
      public void onUnselect() {
         pNode.setTextPaint(defaultColor);
      }

      @Override
      public void onStartHighlight() {
         pNode.setTextPaint(Color.ORANGE);
      }

      @Override
      public void onEndHighlight() {
         pNode.setTextPaint(selected.get() ? selectedColor : defaultColor);
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

   private static class NewFlow extends NeoEditor.TransactionAction {

      private final PInputEvent event;

      NewFlow(PInputEvent event, NeoEditor editor) {
         super("New Flow", editor);
         this.event = event;
      }

      @Override
      public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

         final String name = SwingUtil.showInputDialog("Name", canvas);
         if (name == null) return;

         final Node node = graph.newNode(Flow);
         node.setProperty(Properties.name.name(), name);

         editor.show(NeoModel.uuidOf(node), Flow.name()).setOffset(event);
      }
   }

   static class ContextPropertyEditor extends SwingUtil.FormPanel {

      private final JTextField txtName = new JTextField();
      private final JTextField txtType = new JTextField();
      private final JComboBox cboModifier = new JComboBox();
      private final JTextField txtComment = new JTextField();
      private final JTextField txtValue = new JTextField();

      ContextPropertyEditor(Node node) {
         super("50dlu, 4dlu, 350dlu", "pref, 4dlu, pref, 4dlu, pref, 4dlu, pref, 4dlu, pref");

         int row = 1;
         addLabel("Name", 1, row);
         add(txtName, 3, row);
         txtName.setText(node.hasProperty(Properties.name.name()) ? getString(node, Properties.name.name()) : "");

         row += 2;
         addLabel("Type", 1, row);
         add(txtType, 3, row);
         txtType.setText(node.hasProperty(Properties.type.name()) ? getString(node, Properties.type.name()) : "");

         row += 2;
         addLabel("Modifier", 1, row);
         add(cboModifier, 3, row);
         setModifier(cboModifier, node);

         row += 2;
         addLabel("Comment", 1, row);
         add(txtComment, 3, row);
         txtComment.setText(node.hasProperty(Properties.comment.name()) ? getString(node, Properties.comment.name()) : "");

         row += 2;
         addLabel("Value", 1, row);
         add(txtValue, 3, row);
         txtValue.setText(node.hasProperty(Properties.value.name()) ? getString(node, Properties.value.name()) : "");
      }

      private void setModifier(JComboBox<String> cboModifier, Node node) {
         final String[] items = {"", "private", "protected", "public"};
         cboModifier.setModel(new DefaultComboBoxModel<>(items));
         if (node.hasProperty("modifier"))
            cboModifier.setSelectedItem(getString(node, "modifier"));
      }

      private void commit(Node node) throws Exception {

         node.setProperty("name", txtName.getText().trim());
         node.setProperty("type", txtName.getText().trim());
         node.setProperty("modifier", txtName.getText().trim());
         node.setProperty("comment", txtName.getText().trim());
         node.setProperty("value", txtName.getText().trim());

      }
   }
}