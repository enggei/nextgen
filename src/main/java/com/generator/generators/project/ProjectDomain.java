package com.generator.generators.project;

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
import static com.generator.generators.project.ProjectDomain.Entities.*;
import static com.generator.generators.project.ProjectDomain.Relations.*;
import static org.neo4j.graphdb.Direction.INCOMING;

/**
 * Created 23.02.17.
 */
public abstract class ProjectDomain implements IDomain {

   public enum Entities implements Label {
      Project, Directory, Renderer, File
   }

   public enum Relations implements RelationshipType {
      MEMBER, TARGET
   }

   public enum Properties {
      name, path, generator, outputFormat, type, root
   }

   @Override
   public String getName() {
      return "Project";
   }

   @Override
   public final Label[] values() {
      return Entities.values();
   }

   @Override
   public final NeoPNode newPNode(Node node, String nodetype, NeoEditor editor) {
      switch (Entities.valueOf(nodetype)) {
         case Project:
         	return newProjectPNode(node, editor);
         case Directory:
         	return newDirectoryPNode(node, editor);
         case Renderer:
         	return newRendererPNode(node, editor);
         case File:
         	return newFilePNode(node, editor);
      }

      throw new IllegalArgumentException("unsupported ProjectDomain nodetype " + nodetype + " for node " + NeoModel.debugNode(node));
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

   protected NeoPNode newProjectPNode(Node node, NeoEditor editor) {
      return new ProjectPNode(node, editor);
   }

   protected static class ProjectPNode extends ProjectDomainPNode {

      ProjectPNode(Node node, NeoEditor editor) {
         super(node, Project, ProjectDomain.Properties.name.name(), "#377eb8", editor);
      }

      @Override
      public void expand() {
         final Map<UUID, Label> pNodes = new LinkedHashMap<>();
//         outgoing(node, Relations.FROM).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.State));
//         outgoing(node, PROPERTY).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.ContextProperty));
         editor.showAndLayout(pNodes, pNode);
      }
   }

   protected NeoPNode newDirectoryPNode(Node node, NeoEditor editor) {
      return new DirectoryPNode(node, editor);
   }

   protected static class DirectoryPNode extends ProjectDomainPNode {

      DirectoryPNode(Node node, NeoEditor editor) {
         super(node, Directory, ProjectDomain.Properties.path.name(), "#4daf4a", editor);
      }

      @Override
      public void expand() {
         final Map<UUID, Label> pNodes = new LinkedHashMap<>();
//         outgoing(node, Relations.FROM).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.State));
//         outgoing(node, PROPERTY).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.ContextProperty));
         editor.showAndLayout(pNodes, pNode);
      }
   }

   protected NeoPNode newRendererPNode(Node node, NeoEditor editor) {
      return new RendererPNode(node, editor);
   }

   protected static class RendererPNode extends ProjectDomainPNode {

      RendererPNode(Node node, NeoEditor editor) {
         super(node, Renderer, "name", "", editor);
      }

      @Override
      public void expand() {
         final Map<UUID, Label> pNodes = new LinkedHashMap<>();
//         outgoing(node, Relations.FROM).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.State));
//         outgoing(node, PROPERTY).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.ContextProperty));
         editor.showAndLayout(pNodes, pNode);
      }
   }

   protected NeoPNode newFilePNode(Node node, NeoEditor editor) {
      return new FilePNode(node, editor);
   }

   protected static class FilePNode extends ProjectDomainPNode {

      FilePNode(Node node, NeoEditor editor) {
         super(node, File, ProjectDomain.Properties.name.name(), "#984ea3", editor);
      }

      @Override
      public void expand() {
         final Map<UUID, Label> pNodes = new LinkedHashMap<>();
//         outgoing(node, Relations.FROM).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.State));
//         outgoing(node, PROPERTY).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.ContextProperty));
         editor.showAndLayout(pNodes, pNode);
      }
   }


   private static class ProjectDomainPNode extends NeoPNode<PText> {

      final Color selectedColor = Color.RED;
      private final Color defaultColor;
      private final String property;
      private final ProjectDomain.Entities nodeType;

      ProjectDomainPNode(Node node, ProjectDomain.Entities nodeType, String property, String defaultColor, NeoEditor editor) {
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

	static class ProjectPropertyEditor extends SwingUtil.FormPanel {

			private final JTextField _name = new JTextField();
	//      private final JComboBox<String> cboModifier = new JComboBox<>();

	      ProjectPropertyEditor(Node node) {
	         super("50dlu, 4dlu, 350dlu", "pref, 4dlu");

	         int row = -1;
	         row += 2;
	         addLabel("Name", 1, row);
	         add(_name, 3, row);
	         _name.setText(node.hasProperty(Properties.name.name()) ? getString(node, Properties.name.name()) : "");


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
				node.setProperty("name", _name.getText().trim());
	//         node.setProperty("modifier", cboModifier.getSelectedItem() + "");
	      }
	   }

	static class DirectoryPropertyEditor extends SwingUtil.FormPanel {

			private final JTextField _path = new JTextField();
	//      private final JComboBox<String> cboModifier = new JComboBox<>();

	      DirectoryPropertyEditor(Node node) {
	         super("50dlu, 4dlu, 350dlu", "pref, 4dlu");

	         int row = -1;
	         row += 2;
	         addLabel("Path", 1, row);
	         add(_path, 3, row);
	         _path.setText(node.hasProperty(Properties.path.name()) ? getString(node, Properties.path.name()) : "");


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
				node.setProperty("path", _path.getText().trim());
	//         node.setProperty("modifier", cboModifier.getSelectedItem() + "");
	      }
	   }

	static class RendererPropertyEditor extends SwingUtil.FormPanel {

	//      private final JComboBox<String> cboModifier = new JComboBox<>();

	      RendererPropertyEditor(Node node) {
	         super("50dlu, 4dlu, 350dlu", "");

	         int row = -1;

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
	//         node.setProperty("modifier", cboModifier.getSelectedItem() + "");
	      }
	   }

	static class FilePropertyEditor extends SwingUtil.FormPanel {

			private final JTextField _generator = new JTextField();
			private final JTextField _outputFormat = new JTextField();
			private final JTextField _type = new JTextField();
	//      private final JComboBox<String> cboModifier = new JComboBox<>();

	      FilePropertyEditor(Node node) {
	         super("50dlu, 4dlu, 350dlu", "pref, 4dlu, pref, 4dlu, pref, 4dlu");

	         int row = -1;
	         row += 2;
	         addLabel("Generator", 1, row);
	         add(_generator, 3, row);
	         _generator.setText(node.hasProperty(Properties.generator.name()) ? getString(node, Properties.generator.name()) : "");

	         row += 2;
	         addLabel("OutputFormat", 1, row);
	         add(_outputFormat, 3, row);
	         _outputFormat.setText(node.hasProperty(Properties.outputFormat.name()) ? getString(node, Properties.outputFormat.name()) : "");

	         row += 2;
	         addLabel("Type", 1, row);
	         add(_type, 3, row);
	         _type.setText(node.hasProperty(Properties.type.name()) ? getString(node, Properties.type.name()) : "");


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
				node.setProperty("generator", _generator.getText().trim());
				node.setProperty("outputFormat", _outputFormat.getText().trim());
				node.setProperty("type", _type.getText().trim());
	//         node.setProperty("modifier", cboModifier.getSelectedItem() + "");
	      }
	   }

   public static abstract class ProjectDomainVisitor implements com.generator.domain.IDomainVisitor {

		@Override
      public <T> T visit(Node node) {
         if (node == null) return null;
		  if (BaseDomainVisitor.hasLabel(node, Project.name())) return visitProject(node);
		  if (BaseDomainVisitor.hasLabel(node, Directory.name())) return visitDirectory(node);
		  if (BaseDomainVisitor.hasLabel(node, Renderer.name())) return visitRenderer(node);
		  if (BaseDomainVisitor.hasLabel(node, File.name())) return visitFile(node);
         return null;
      }

		<T> T visitProject(Node node) {
         return null;
      }

		<T> T visitDirectory(Node node) {
         return null;
      }

		<T> T visitRenderer(Node node) {
         return null;
      }

		<T> T visitFile(Node node) {
         return null;
      }

   }
}