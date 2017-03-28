package com.generator.generators.maven;

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
import static com.generator.generators.maven.MavenDomain.Entities.*;
import static com.generator.generators.maven.MavenDomain.Relations.*;
import static org.neo4j.graphdb.Direction.INCOMING;

/**
 * Created 23.02.17.
 */
public abstract class MavenDomain implements IDomain {

   public enum Entities implements Label {
      Pom, Library
   }

   public enum Relations implements RelationshipType {
      DEPENDENCY
   }

   public enum Properties {
      groupId, version, name, artifactId, scope
   }

   @Override
   public String getName() {
      return "Maven";
   }

   @Override
   public final Label[] values() {
      return Entities.values();
   }

   @Override
   public final NeoPNode newPNode(Node node, String nodetype, NeoEditor editor) {
      switch (Entities.valueOf(nodetype)) {
         case Pom:
         	return newPomPNode(node, editor);
         case Library:
         	return newLibraryPNode(node, editor);
      }

      throw new IllegalArgumentException("unsupported MavenDomain nodetype " + nodetype + " for node " + NeoModel.debugNode(node));
   }

	@Override
   public void deleteNode(Node node) {
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

   protected NeoPNode newPomPNode(Node node, NeoEditor editor) {
      return new PomPNode(node, editor);
   }

   protected static class PomPNode extends MavenDomainPNode {

      PomPNode(Node node, NeoEditor editor) {
         super(node, Pom, "name", "#b35806", editor);
      }

      @Override
      public void expand() {
         final Map<UUID, Label> pNodes = new LinkedHashMap<>();
//         outgoing(node, Relations.FROM).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.State));
//         outgoing(node, PROPERTY).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.ContextProperty));
         editor.showAndLayout(pNodes, pNode);
      }
   }

   protected NeoPNode newLibraryPNode(Node node, NeoEditor editor) {
      return new LibraryPNode(node, editor);
   }

   protected static class LibraryPNode extends MavenDomainPNode {

      LibraryPNode(Node node, NeoEditor editor) {
         super(node, Library, "name", "#d8daeb", editor);
      }

      @Override
      public void expand() {
         final Map<UUID, Label> pNodes = new LinkedHashMap<>();
//         outgoing(node, Relations.FROM).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.State));
//         outgoing(node, PROPERTY).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.ContextProperty));
         editor.showAndLayout(pNodes, pNode);
      }
   }


   private static class MavenDomainPNode extends NeoPNode<PText> {

      final Color selectedColor = Color.RED;
      private final Color defaultColor;
      private final String property;
      private final MavenDomain.Entities nodeType;

      MavenDomainPNode(Node node, MavenDomain.Entities nodeType, String property, String defaultColor, NeoEditor editor) {
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

	static class PomPropertyEditor extends SwingUtil.FormPanel {

			private final JTextField _groupId = new JTextField();
			private final JTextField _version = new JTextField();
			private final JTextField _name = new JTextField();
			private final JTextField _artifactId = new JTextField();
	//      private final JComboBox<String> cboModifier = new JComboBox<>();

	      PomPropertyEditor(Node node) {
	         super("50dlu, 4dlu, 350dlu", "pref, 4dlu, pref, 4dlu, pref, 4dlu, pref, 4dlu");

	         int row = -1;
	         row += 2;
	         addLabel("GroupId", 1, row);
	         add(_groupId, 3, row);
	         _groupId.setText(node.hasProperty(Properties.groupId.name()) ? getString(node, Properties.groupId.name()) : "");

	         row += 2;
	         addLabel("Version", 1, row);
	         add(_version, 3, row);
	         _version.setText(node.hasProperty(Properties.version.name()) ? getString(node, Properties.version.name()) : "");

	         row += 2;
	         addLabel("Name", 1, row);
	         add(_name, 3, row);
	         _name.setText(node.hasProperty(Properties.name.name()) ? getString(node, Properties.name.name()) : "");

	         row += 2;
	         addLabel("ArtifactId", 1, row);
	         add(_artifactId, 3, row);
	         _artifactId.setText(node.hasProperty(Properties.artifactId.name()) ? getString(node, Properties.artifactId.name()) : "");


	//         row += 2;
	//         addLabel("Modifier", 1, row);
	//         add(cboModifier, 3, row);
	//         setModifier(cboModifier, node);
	      }

	      private void setModifier(JComboBox<String> cboModifier, Node node) {
	         final String[] items = {"", "private", "protected", "public"};
	         cboModifier.setModel(new DefaultComboBoxModel<>(items));
	         if (node.hasProperty("modifier"))
	            cboModifier.setSelectedItem(getString(node, "modifier"));
	      }

	      void commit(Node node) throws Exception {
				node.setProperty("groupId", _groupId.getText().trim());
				node.setProperty("version", _version.getText().trim());
				node.setProperty("name", _name.getText().trim());
				node.setProperty("artifactId", _artifactId.getText().trim());
	//         node.setProperty("modifier", cboModifier.getSelectedItem() + "");
	      }
	   }

	static class LibraryPropertyEditor extends SwingUtil.FormPanel {

			private final JTextField _groupId = new JTextField();
			private final JTextField _artifactId = new JTextField();
			private final JTextField _version = new JTextField();
			private final JTextField _scope = new JTextField();
	//      private final JComboBox<String> cboModifier = new JComboBox<>();

	      LibraryPropertyEditor(Node node) {
	         super("50dlu, 4dlu, 350dlu", "pref, 4dlu, pref, 4dlu, pref, 4dlu, pref, 4dlu");

	         int row = -1;
	         row += 2;
	         addLabel("GroupId", 1, row);
	         add(_groupId, 3, row);
	         _groupId.setText(node.hasProperty(Properties.groupId.name()) ? getString(node, Properties.groupId.name()) : "");

	         row += 2;
	         addLabel("ArtifactId", 1, row);
	         add(_artifactId, 3, row);
	         _artifactId.setText(node.hasProperty(Properties.artifactId.name()) ? getString(node, Properties.artifactId.name()) : "");

	         row += 2;
	         addLabel("Version", 1, row);
	         add(_version, 3, row);
	         _version.setText(node.hasProperty(Properties.version.name()) ? getString(node, Properties.version.name()) : "");

	         row += 2;
	         addLabel("Scope", 1, row);
	         add(_scope, 3, row);
	         _scope.setText(node.hasProperty(Properties.scope.name()) ? getString(node, Properties.scope.name()) : "");


	//         row += 2;
	//         addLabel("Modifier", 1, row);
	//         add(cboModifier, 3, row);
	//         setModifier(cboModifier, node);
	      }

	      private void setModifier(JComboBox<String> cboModifier, Node node) {
	         final String[] items = {"", "private", "protected", "public"};
	         cboModifier.setModel(new DefaultComboBoxModel<>(items));
	         if (node.hasProperty("modifier"))
	            cboModifier.setSelectedItem(getString(node, "modifier"));
	      }

	      void commit(Node node) throws Exception {
				node.setProperty("groupId", _groupId.getText().trim());
				node.setProperty("artifactId", _artifactId.getText().trim());
				node.setProperty("version", _version.getText().trim());
				node.setProperty("scope", _scope.getText().trim());
	//         node.setProperty("modifier", cboModifier.getSelectedItem() + "");
	      }
	   }

   public static abstract class MavenDomainVisitor implements com.generator.domain.IDomainVisitor {

		@Override
      public <T> T visit(Node node) {
         if (node == null) return null;
		  if (BaseDomainVisitor.hasLabel(node, Pom.name())) return visitPom(node);
		  if (BaseDomainVisitor.hasLabel(node, Library.name())) return visitLibrary(node);
         return null;
      }

		<T> T visitPom(Node node) {
         return null;
      }

		<T> T visitLibrary(Node node) {
         return null;
      }

   }
}