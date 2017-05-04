package com.generator.generators.vertx;

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
import static com.generator.generators.vertx.VertxDomain.Entities.*;
import static com.generator.generators.vertx.VertxDomain.Relations.*;
import static org.neo4j.graphdb.Direction.INCOMING;

/**
 * Created 23.02.17.
 */
public abstract class VertxDomain implements IDomain {

   public enum Entities implements Label {
      Server, Verticle, Router
   }

   public enum Relations implements RelationshipType {
      VERTICLES, ROUTER
   }

   public enum Properties {
      port, name
   }

   @Override
   public String getName() {
      return "Vertx";
   }

   @Override
   public final Label[] values() {
      return Entities.values();
   }

   @Override
   public final NeoPNode newPNode(Node node, String nodetype, NeoEditor editor) {
      switch (Entities.valueOf(nodetype)) {
         case Server:
         	return newServerPNode(node, editor);
         case Verticle:
         	return newVerticlePNode(node, editor);
         case Router:
         	return newRouterPNode(node, editor);
      }

      throw new IllegalArgumentException("unsupported VertxDomain nodetype " + nodetype + " for node " + NeoModel.debugNode(node));
   }

	@Override
   public void deleteNode(Node node) throws NeoEditor.ReferenceException {
      // todo enforce constraints
      final Set<Relationship> constraints = new LinkedHashSet<>();

      final Consumer<Relationship> constraintVisitor = relationship -> {
         if (NeoEditor.isAppRelated(relationship)) return;
         constraints.add(relationship);
      };

      //if (node.hasLabel(ContextProperty)) {
         //node.getRelationships(INCOMING, PROPERTY).forEach(Relationship::delete);
         //node.getRelationships(INCOMING, FROM).forEach(Relationship::delete);
      //}

      // delete from layouts:
      NeoEditor.removeFromLayouts(node);

      node.delete();
   }

   protected NeoPNode newServerPNode(Node node, NeoEditor editor) {
         return new ServerPNode(node, editor);
      }

      protected static class ServerPNode extends VertxDomainPNode {

         ServerPNode(Node node, NeoEditor editor) {
            super(node, Entities.Server, "name", "#49006a", editor);
         }

         @Override
         public void expand() {
            final Map<UUID, Label> pNodes = new LinkedHashMap<>();
   			outgoing(node, Relations.ROUTER).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.Router));
   			outgoing(node, Relations.VERTICLES).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.Verticle));
            editor.showAndLayout(pNodes, pNode);
         }

   		@Override
         public void showDependents() {
            final Map<UUID, Label> pNodes = new LinkedHashMap<>();
            editor.showAndLayout(pNodes, pNode);
         }
      }

   protected NeoPNode newVerticlePNode(Node node, NeoEditor editor) {
         return new VerticlePNode(node, editor);
      }

      protected static class VerticlePNode extends VertxDomainPNode {

         VerticlePNode(Node node, NeoEditor editor) {
            super(node, Entities.Verticle, "name", "#ae017e", editor);
         }

         @Override
         public void expand() {
            final Map<UUID, Label> pNodes = new LinkedHashMap<>();
            editor.showAndLayout(pNodes, pNode);
         }

   		@Override
         public void showDependents() {
            final Map<UUID, Label> pNodes = new LinkedHashMap<>();
   			incoming(node, Relations.VERTICLES).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.Server));
            editor.showAndLayout(pNodes, pNode);
         }
      }

   protected NeoPNode newRouterPNode(Node node, NeoEditor editor) {
         return new RouterPNode(node, editor);
      }

      protected static class RouterPNode extends VertxDomainPNode {

         RouterPNode(Node node, NeoEditor editor) {
            super(node, Entities.Router, "name", "#7a0177", editor);
         }

         @Override
         public void expand() {
            final Map<UUID, Label> pNodes = new LinkedHashMap<>();
            editor.showAndLayout(pNodes, pNode);
         }

   		@Override
         public void showDependents() {
            final Map<UUID, Label> pNodes = new LinkedHashMap<>();
   			incoming(node, Relations.ROUTER).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.Server));
            editor.showAndLayout(pNodes, pNode);
         }
      }


   private static class VertxDomainPNode extends NeoPNode<PText> {

      final Color selectedColor = Color.RED;
      private final Color defaultColor;
      private final String property;
      private final VertxDomain.Entities nodeType;

      VertxDomainPNode(Node node, VertxDomain.Entities nodeType, String property, String defaultColor, NeoEditor editor) {
         super(node, new PText(node.hasProperty(property) ? node.getProperty(property).toString() : getNameOrLabelFrom(node)), nodeType.name(), editor);
         this.defaultColor = Color.decode(defaultColor);
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
			pNode.setText(property == null ? "?" : node.hasProperty(property) ? node.getProperty(property).toString() : getNameOrLabelFrom(node));
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

         editor.showDeleteOutgoingRelations(pop, node);

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

	static class ServerPropertyEditor extends SwingUtil.FormPanel {

			private final JTextField _port = new JTextField();

	      ServerPropertyEditor(Node node) {
	         super("50dlu, 4dlu, 350dlu", "pref, 4dlu");

	         int row = -1;
	         row += 2;
	         addLabel("Port", 1, row);
	         add(_port, 3, row);
				setValue(_port, node, Properties.port.name(), new String[] { });

	      }

			private void setValue(JTextField component, Node node, String property, String[] values) {
	         component.setText(node.hasProperty(property) ? getString(node, property) : "");
	      }

			private void setValue(JCheckBox component, Node node, String property, String[] values) {
	         component.setSelected(node.hasProperty(property) ? getString(node, property).toLowerCase().startsWith("boo") : false);
	      }

	      private void setValue(JComboBox<String> component, Node node, String property, String[] values) {
	         component.setModel(new DefaultComboBoxModel<>(values));
	       	final String value = node.hasProperty(property) ? getString(node, property) : null;
		      if (value == null) return;
		      component.setSelectedItem(value);
		   }

	      void commit(Node node) throws Exception {
				getValue(node, "port", _port); 
	      }

			private void getValue(Node node, String property, JTextField component) {
	         node.setProperty(property, component.getText().trim());
	      }

	      private void getValue(Node node, String property, JComboBox<String> component) {
	         node.setProperty(property, component.getSelectedItem() == null ? null : component.getSelectedItem().toString());
	      }
	   }

	static class VerticlePropertyEditor extends SwingUtil.FormPanel {

			private final JTextField _name = new JTextField();

	      VerticlePropertyEditor(Node node) {
	         super("50dlu, 4dlu, 350dlu", "pref, 4dlu");

	         int row = -1;
	         row += 2;
	         addLabel("Name", 1, row);
	         add(_name, 3, row);
				setValue(_name, node, Properties.name.name(), new String[] { });

	      }

			private void setValue(JTextField component, Node node, String property, String[] values) {
	         component.setText(node.hasProperty(property) ? getString(node, property) : "");
	      }

			private void setValue(JCheckBox component, Node node, String property, String[] values) {
	         component.setSelected(node.hasProperty(property) ? getString(node, property).toLowerCase().startsWith("boo") : false);
	      }

	      private void setValue(JComboBox<String> component, Node node, String property, String[] values) {
	         component.setModel(new DefaultComboBoxModel<>(values));
	       	final String value = node.hasProperty(property) ? getString(node, property) : null;
		      if (value == null) return;
		      component.setSelectedItem(value);
		   }

	      void commit(Node node) throws Exception {
				getValue(node, "name", _name); 
	      }

			private void getValue(Node node, String property, JTextField component) {
	         node.setProperty(property, component.getText().trim());
	      }

	      private void getValue(Node node, String property, JComboBox<String> component) {
	         node.setProperty(property, component.getSelectedItem() == null ? null : component.getSelectedItem().toString());
	      }
	   }

	static class RouterPropertyEditor extends SwingUtil.FormPanel {


	      RouterPropertyEditor(Node node) {
	         super("50dlu, 4dlu, 350dlu", "");

	         int row = -1;
	      }

			private void setValue(JTextField component, Node node, String property, String[] values) {
	         component.setText(node.hasProperty(property) ? getString(node, property) : "");
	      }

			private void setValue(JCheckBox component, Node node, String property, String[] values) {
	         component.setSelected(node.hasProperty(property) ? getString(node, property).toLowerCase().startsWith("boo") : false);
	      }

	      private void setValue(JComboBox<String> component, Node node, String property, String[] values) {
	         component.setModel(new DefaultComboBoxModel<>(values));
	       	final String value = node.hasProperty(property) ? getString(node, property) : null;
		      if (value == null) return;
		      component.setSelectedItem(value);
		   }

	      void commit(Node node) throws Exception {
	      }

			private void getValue(Node node, String property, JTextField component) {
	         node.setProperty(property, component.getText().trim());
	      }

	      private void getValue(Node node, String property, JComboBox<String> component) {
	         node.setProperty(property, component.getSelectedItem() == null ? null : component.getSelectedItem().toString());
	      }
	   }

   public static abstract class VertxDomainVisitor implements com.generator.domain.IDomainVisitor {

		@Override
      public <T> T visit(Node n) {
         if (n == null) return null;
		  if (BaseDomainVisitor.hasLabel(n, Server.name())) return visitServer(n);
		  if (BaseDomainVisitor.hasLabel(n, Verticle.name())) return visitVerticle(n);
		  if (BaseDomainVisitor.hasLabel(n, Router.name())) return visitRouter(n);
         return null;
      }

		<T> T visitServer(Node node) {
         return null;
      }

		<T> T visitVerticle(Node node) {
         return null;
      }

		<T> T visitRouter(Node node) {
         return null;
      }

   }
}