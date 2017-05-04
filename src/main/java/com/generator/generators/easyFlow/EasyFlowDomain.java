package com.generator.generators.easyFlow;

import com.generator.domain.IDomain;
import com.generator.editors.BaseDomainVisitor;
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
import static com.generator.generators.easyFlow.EasyFlowDomain.Relations.*;
import static org.neo4j.graphdb.Direction.INCOMING;

/**
 * Created 23.02.17.
 */
public abstract class EasyFlowDomain implements IDomain {

   public enum Entities implements Label {
      Flow, ContextProperty, State, Event, SuperParameter
   }

   public enum Relations implements RelationshipType {
      FROM, ON, TO, FINISH, PROPERTY, SUPERPARAMETERS
   }

   public enum Properties {
      name, extending, packageName, templateFile, contextGeneric, type, modifier, comment, value, root
   }

   @Override
   public String getName() {
      return "EasyFlow";
   }

   @Override
   public final Label[] values() {
      return Entities.values();
   }

   @Override
   public final NeoPNode newPNode(Node node, String nodetype, NeoEditor editor) {
      switch (Entities.valueOf(nodetype)) {
         case Flow:
            return newFlowPNode(node, editor);
         case State:
            return newStatePNode(node, editor);
         case Event:
            return newEventPNode(node, editor);
         case ContextProperty:
            return newContextPropertyPNode(node, editor);
      }

      throw new IllegalArgumentException("unsupported TemplateDomain nodetype " + nodetype + " for node " + NeoModel.debugNode(node));
   }

   protected NeoPNode newFlowPNode(Node node, NeoEditor editor) {
      return new FlowPNode(node, editor);
   }

   protected NeoPNode newStatePNode(Node node, NeoEditor editor) {
      return new StatePNode(node, editor);
   }

   protected NeoPNode newEventPNode(Node node, NeoEditor editor) {
      return new EventPNode(node, editor);
   }

   protected NeoPNode newContextPropertyPNode(Node node, NeoEditor editor) {
      return new ContextPropertyPNode(node, editor);
   }

   @Override
   public void deleteNode(Node node) {
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

   protected static class FlowPNode extends EasyFlowDomainPNode {

      FlowPNode(Node node, NeoEditor editor) {
         super(node, Flow, EasyFlowDomain.Properties.name.name(), "64, 64, 64".split(", "), editor);
      }

      @Override
      public void expand() {
         final Map<UUID, Label> pNodes = new LinkedHashMap<>();
         outgoing(node, Relations.FROM).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.State));
         outgoing(node, PROPERTY).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.ContextProperty));
         editor.showAndLayout(pNodes, pNode);
      }
   }

   protected static class ContextPropertyPNode extends EasyFlowDomainPNode {

      ContextPropertyPNode(Node node, NeoEditor editor) {
         super(node, ContextProperty, EasyFlowDomain.Properties.name.name(), "64, 64, 64".split(", "), editor);
      }
   }

   protected static class StatePNode extends EasyFlowDomainPNode {

      StatePNode(Node node, NeoEditor editor) {
         super(node, State, EasyFlowDomain.Properties.name.name(), "64, 64, 64".split(", "), editor);
      }

      @Override
      public void expand() {
         final Map<UUID, Label> pNodes = new LinkedHashMap<>();
         outgoing(node, Relations.ON).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.Event));
         editor.showAndLayout(pNodes, pNode);
      }
   }

   protected static class EventPNode extends EasyFlowDomainPNode {

      EventPNode(Node node, NeoEditor editor) {
         super(node, Entities.Event, EasyFlowDomain.Properties.name.name(), "128, 64, 255".split(", "), editor);
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
         super(node, new PText(getNodeLabel(node, property)), nodeType.name(), editor);
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
         pNode.setText(getNodeLabel(node,property));
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

   static class ContextPropertyEditor extends SwingUtil.FormPanel {

      private final JTextField txtName = new JTextField();
      private final JTextField txtType = new JTextField();
      private final JComboBox<String> cboModifier = new JComboBox<>();
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

      void commit(Node node) throws Exception {
         node.setProperty("name", txtName.getText().trim());
         node.setProperty("type", txtType.getText().trim());
         node.setProperty("modifier", cboModifier.getSelectedItem() + "");
         node.setProperty("comment", txtComment.getText().trim());
         node.setProperty("value", txtValue.getText().trim());
      }
   }

   protected void showContextPropertyEditor(Node node, NeoEditor editor, PInputEvent event) {
      final ContextPropertyEditor form = new ContextPropertyEditor(node);
      SwingUtil.showDialogNoDefaultButton(form, editor.canvas, "ContextPropery", () -> {
         editor.doInTransaction(tx1 -> {
            form.commit(node);
            editor.show(uuidOf(node), ContextProperty.name()).
                  setOffset(event);
         });
      });
   }

   public static abstract class EasyFlowDomainVisitor {

      public <T> T visit(Node node) {
         if (node == null) return null;
         if (BaseDomainVisitor.hasLabel(node, Flow.name())) return visitFlow(node);
         if (BaseDomainVisitor.hasLabel(node, ContextProperty.name())) return visitFlow(node);
         if (BaseDomainVisitor.hasLabel(node, State.name())) return visitFlow(node);
         if (BaseDomainVisitor.hasLabel(node, Event.name())) return visitFlow(node);
         if (BaseDomainVisitor.hasLabel(node, SuperParameter.name())) return visitFlow(node);
         return null;
      }

      <T> T visitFlow(Node node) {
         return null;
      }

      <T> T visitContextProperty(Node node) {
         return null;
      }

      <T> T visitState(Node node) {
         return null;
      }

      <T> T visitEvent(Node node) {
         return null;
      }

      <T> T visitSuperParameter(Node node) {
         return null;
      }
   }
}