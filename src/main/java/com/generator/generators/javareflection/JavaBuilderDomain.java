package com.generator.generators.javareflection;

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
import static com.generator.generators.javareflection.JavaBuilderDomain.Entities.*;
import static com.generator.generators.javareflection.JavaBuilderDomain.Relations.*;
import static org.neo4j.graphdb.Direction.INCOMING;

/**
 * Created 23.02.17.
 */
public abstract class JavaBuilderDomain implements IDomain {

   public enum Entities implements Label {
      CLASS, PACKAGE, METHOD, INSTANCE
   }

   public enum Relations implements RelationshipType {
      PARENT, PACKAGE, CONSTRUCTOR, PARAMETER, METHOD, INSTANCE_TYPE, INSTANCE_INITIALIZE
   }

   public enum Properties {
   }

   @Override
   public String getName() {
      return "JavaBuilder";
   }

   @Override
   public final Label[] values() {
      return Entities.values();
   }

   @Override
   public final NeoPNode newPNode(Node node, String nodetype, NeoEditor editor) {
      switch (Entities.valueOf(nodetype)) {
         case CLASS:
         	return newCLASSPNode(node, editor);
         case PACKAGE:
         	return newPACKAGEPNode(node, editor);
         case METHOD:
         	return newMETHODPNode(node, editor);
         case INSTANCE:
         	return newINSTANCEPNode(node, editor);
      }

      throw new IllegalArgumentException("unsupported JavaBuilderDomain nodetype " + nodetype + " for node " + NeoModel.debugNode(node));
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

   protected NeoPNode newCLASSPNode(Node node, NeoEditor editor) {
         return new CLASSPNode(node, editor);
      }

   protected static class CLASSPNode extends JavaBuilderDomainPNode {

      CLASSPNode(Node node, NeoEditor editor) {
         super(node, Entities.CLASS, "name", "#d8daeb", editor);
      }

   	@Override
   	public void showNodeActions(JPopupMenu pop, PInputEvent event) {


   		super.showNodeActions(pop, event);
   	}

   	@Override
      public void showTargetActions(JPopupMenu pop, PInputEvent event) {

         final Collection<NeoPNode> selectedNodes = editor.getSelectedNodes();
         if (selectedNodes.isEmpty()) return;


         selectedNodes.forEach(selectedNode -> {
         });

      }

      @Override
      public void expand() {
         final Map<UUID, Label> pNodes = new LinkedHashMap<>();
         editor.showAndLayout(pNodes, pNode);
      }

   	@Override
      public void showDependents() {
         final Map<UUID, Label> pNodes = new LinkedHashMap<>();
         editor.showAndLayout(pNodes, pNode);
      }
   }

   protected NeoPNode newPACKAGEPNode(Node node, NeoEditor editor) {
         return new PACKAGEPNode(node, editor);
      }

   protected static class PACKAGEPNode extends JavaBuilderDomainPNode {

      PACKAGEPNode(Node node, NeoEditor editor) {
         super(node, Entities.PACKAGE, "name", "#7f3b08", editor);
      }

   	@Override
   	public void showNodeActions(JPopupMenu pop, PInputEvent event) {


   		super.showNodeActions(pop, event);
   	}

   	@Override
      public void showTargetActions(JPopupMenu pop, PInputEvent event) {

         final Collection<NeoPNode> selectedNodes = editor.getSelectedNodes();
         if (selectedNodes.isEmpty()) return;


         selectedNodes.forEach(selectedNode -> {
         });

      }

      @Override
      public void expand() {
         final Map<UUID, Label> pNodes = new LinkedHashMap<>();
         editor.showAndLayout(pNodes, pNode);
      }

   	@Override
      public void showDependents() {
         final Map<UUID, Label> pNodes = new LinkedHashMap<>();
         editor.showAndLayout(pNodes, pNode);
      }
   }

   protected NeoPNode newMETHODPNode(Node node, NeoEditor editor) {
         return new METHODPNode(node, editor);
      }

   protected static class METHODPNode extends JavaBuilderDomainPNode {

      METHODPNode(Node node, NeoEditor editor) {
         super(node, Entities.METHOD, "name", "#b2abd2", editor);
      }

   	@Override
   	public void showNodeActions(JPopupMenu pop, PInputEvent event) {


   		super.showNodeActions(pop, event);
   	}

   	@Override
      public void showTargetActions(JPopupMenu pop, PInputEvent event) {

         final Collection<NeoPNode> selectedNodes = editor.getSelectedNodes();
         if (selectedNodes.isEmpty()) return;


         selectedNodes.forEach(selectedNode -> {
         });

      }

      @Override
      public void expand() {
         final Map<UUID, Label> pNodes = new LinkedHashMap<>();
         editor.showAndLayout(pNodes, pNode);
      }

   	@Override
      public void showDependents() {
         final Map<UUID, Label> pNodes = new LinkedHashMap<>();
         editor.showAndLayout(pNodes, pNode);
      }
   }

   protected NeoPNode newINSTANCEPNode(Node node, NeoEditor editor) {
         return new INSTANCEPNode(node, editor);
      }

   protected static class INSTANCEPNode extends JavaBuilderDomainPNode {

      INSTANCEPNode(Node node, NeoEditor editor) {
         super(node, Entities.INSTANCE, "name", "#542788", editor);
      }

   	@Override
   	public void showNodeActions(JPopupMenu pop, PInputEvent event) {


   		super.showNodeActions(pop, event);
   	}

   	@Override
      public void showTargetActions(JPopupMenu pop, PInputEvent event) {

         final Collection<NeoPNode> selectedNodes = editor.getSelectedNodes();
         if (selectedNodes.isEmpty()) return;


         selectedNodes.forEach(selectedNode -> {
         });

      }

      @Override
      public void expand() {
         final Map<UUID, Label> pNodes = new LinkedHashMap<>();
         editor.showAndLayout(pNodes, pNode);
      }

   	@Override
      public void showDependents() {
         final Map<UUID, Label> pNodes = new LinkedHashMap<>();
         editor.showAndLayout(pNodes, pNode);
      }
   }


   private static class JavaBuilderDomainPNode extends NeoPNode<PText> {

      final Color selectedColor = Color.RED;
      private final Color defaultColor;
      private final String property;
      private final JavaBuilderDomain.Entities nodeType;

      JavaBuilderDomainPNode(Node node, JavaBuilderDomain.Entities nodeType, String property, String defaultColor, NeoEditor editor) {
         super(node, new PText(node.hasProperty(property) ? node.getProperty(property).toString() : getNameOrLabelFrom(node)), nodeType.name(), editor);
         this.defaultColor = defaultColor==null || defaultColor.length()==0 ? Color.BLACK : Color.decode(defaultColor);
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



   public static abstract class JavaBuilderDomainVisitor implements com.generator.domain.IDomainVisitor {

		@Override
      public <T> T visit(Node n) {
         if (n == null) return null;
		  if (BaseDomainVisitor.hasLabel(n, Entities.CLASS.name())) return visitCLASS(n);
		  if (BaseDomainVisitor.hasLabel(n, Entities.PACKAGE.name())) return visitPACKAGE(n);
		  if (BaseDomainVisitor.hasLabel(n, Entities.METHOD.name())) return visitMETHOD(n);
		  if (BaseDomainVisitor.hasLabel(n, Entities.INSTANCE.name())) return visitINSTANCE(n);
         return null;
      }

		<T> T visitCLASS(Node node) {
         return null;
      }

		<T> T visitPACKAGE(Node node) {
         return null;
      }

		<T> T visitMETHOD(Node node) {
         return null;
      }

		<T> T visitINSTANCE(Node node) {
         return null;
      }

   }
}