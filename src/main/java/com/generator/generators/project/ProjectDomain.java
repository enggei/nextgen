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
      TemplateGroup, Project
   }

   public enum Relations implements RelationshipType {
      GROUPS
   }

   public enum Properties {
      templatePath, reference, name, packageName, root, javaVersion, artifactId, groupId, version
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
         case TemplateGroup:
         	return newTemplateGroupPNode(node, editor);
         case Project:
         	return newProjectPNode(node, editor);
      }

      throw new IllegalArgumentException("unsupported ProjectDomain nodetype " + nodetype + " for node " + NeoModel.debugNode(node));
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

   protected NeoPNode newTemplateGroupPNode(Node node, NeoEditor editor) {
         return new TemplateGroupPNode(node, editor);
      }

   protected static class TemplateGroupPNode extends ProjectDomainPNode {

      TemplateGroupPNode(Node node, NeoEditor editor) {
         super(node, Entities.TemplateGroup, "name", "#1b7837", editor);
      }

   	@Override
   	public void showNodeActions(JPopupMenu pop, PInputEvent event) {
   		pop.add(new NeoEditor.TransactionAction("Edit", editor) {
   			@Override
   			public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
   				showTemplateGroupPropertyEditor(node, editor, event);
   			}
   		});
   		pop.add(editor.newSetNodePropertyAction(ProjectDomain.Properties.templatePath.name(), this));
   		pop.add(editor.newSetNodePropertyAction(ProjectDomain.Properties.reference.name(), this));
   		pop.add(editor.newSetNodePropertyAction(ProjectDomain.Properties.name.name(), this));


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

   protected NeoPNode newProjectPNode(Node node, NeoEditor editor) {
         return new ProjectPNode(node, editor);
      }

   protected static class ProjectPNode extends ProjectDomainPNode {

      ProjectPNode(Node node, NeoEditor editor) {
         super(node, Entities.Project, "name", "#762a83", editor);
      }

   	@Override
   	public void showNodeActions(JPopupMenu pop, PInputEvent event) {
   		pop.add(new NeoEditor.TransactionAction("Edit", editor) {
   			@Override
   			public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
   				showProjectPropertyEditor(node, editor, event);
   			}
   		});
   		pop.add(editor.newSetNodePropertyAction(ProjectDomain.Properties.packageName.name(), this));
   		pop.add(editor.newSetNodePropertyAction(ProjectDomain.Properties.root.name(), this));
   		pop.add(editor.newSetNodePropertyAction(ProjectDomain.Properties.javaVersion.name(), this));
   		pop.add(editor.newSetNodePropertyAction(ProjectDomain.Properties.artifactId.name(), this));
   		pop.add(editor.newSetNodePropertyAction(ProjectDomain.Properties.groupId.name(), this));
   		pop.add(editor.newSetNodePropertyAction(ProjectDomain.Properties.version.name(), this));
   		pop.add(editor.newSetNodePropertyAction(ProjectDomain.Properties.name.name(), this));
   		pop.add(editor.newAddNodeAction(Entities.TemplateGroup, Relations.GROUPS, this, event));


   		super.showNodeActions(pop, event);
   	}

   	@Override
      public void showTargetActions(JPopupMenu pop, PInputEvent event) {

         final Collection<NeoPNode> selectedNodes = editor.getSelectedNodes();
         if (selectedNodes.isEmpty()) return;

         final Map<String, Set<Node>> outgoing = new TreeMap<>();

         selectedNodes.forEach(selectedNode -> {
            // outgoing
            if (selectedNode.node.hasLabel(Entities.TemplateGroup)) {
               final Set<Node> set = outgoing.computeIfAbsent(Entities.TemplateGroup.name(), k -> new LinkedHashSet<>());
               //todo: add constraint and add if allowed (control circular constraints, one-to-many, only-one etc.)
               set.add(selectedNode.node);
   			}

         });

         // outgoing
         if (outgoing.containsKey(Entities.TemplateGroup.name())) {
            final Set<Node> nodes = outgoing.get(Entities.TemplateGroup.name());
            pop.add(new NeoEditor.TransactionAction("Add -> " + Relations.GROUPS, editor) {
               @Override
               public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                  for (Node dst : nodes) {
                     final Relationship newRelation = node.createRelationshipTo(dst, Relations.GROUPS);
                     editor.addRelation(newRelation);
                  }
                  updateView();
               }
            });
         }

      }

      @Override
      public void expand() {
         final Map<UUID, Label> pNodes = new LinkedHashMap<>();
   		outgoing(node, Relations.GROUPS).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.TemplateGroup));
         editor.showAndLayout(pNodes, pNode);
      }

   	@Override
      public void showDependents() {
         final Map<UUID, Label> pNodes = new LinkedHashMap<>();
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

	static class TemplateGroupPropertyEditor extends SwingUtil.FormPanel {

			private final JTextField _templatePath = new JTextField();
			private final JTextField _reference = new JTextField();
			private final JTextField _name = new JTextField();

	      TemplateGroupPropertyEditor(PropertyContainer container) {
	         super("50dlu, 4dlu, 350dlu", "pref, 4dlu, pref, 4dlu, pref, 4dlu");

	         int row = -1;
	         row += 2;
	         addLabel("TemplatePath", 1, row);
	         add(_templatePath, 3, row);
				setValue(_templatePath, container, Properties.templatePath.name(), new String[] { });

	         row += 2;
	         addLabel("Reference", 1, row);
	         add(_reference, 3, row);
				setValue(_reference, container, Properties.reference.name(), new String[] { });

	         row += 2;
	         addLabel("Name", 1, row);
	         add(_name, 3, row);
				setValue(_name, container, Properties.name.name(), new String[] { });

	      }

			private void setValue(JTextField component, PropertyContainer container, String property, String[] values) {
	         component.setText(container.hasProperty(property) ? getString(container, property) : "");
	      }

			private void setValue(JCheckBox component, PropertyContainer container, String property, String[] values) {
	         component.setSelected(container.hasProperty(property) ? getString(container, property).toLowerCase().startsWith("boo") : false);
	      }

	      private void setValue(JComboBox<String> component, PropertyContainer container, String property, String[] values) {
	         component.setModel(new DefaultComboBoxModel<>(values));
	       	final String value = container.hasProperty(property) ? getString(container, property) : null;
		      if (value == null) return;
		      component.setSelectedItem(value);
		   }

	      void commit(PropertyContainer container) throws Exception {
				getValue(container, "templatePath", _templatePath); 
				getValue(container, "reference", _reference); 
				getValue(container, "name", _name); 
	      }

			private void getValue(PropertyContainer container, String property, JTextField component) {
	         container.setProperty(property, component.getText().trim());
	      }

	      private void getValue(PropertyContainer container, String property, JComboBox<String> component) {
	         container.setProperty(property, component.getSelectedItem() == null ? null : component.getSelectedItem().toString());
	      }
	   }

	static void showTemplateGroupPropertyEditor(PropertyContainer container, NeoEditor editor, PInputEvent event) {
	   final TemplateGroupPropertyEditor form = new TemplateGroupPropertyEditor(container);
	   SwingUtil.showDialogNoDefaultButton(form, editor.canvas, "TemplateGroup", () -> {
	      editor.doInTransaction(tx1 -> {
	         form.commit(container);
	      });
	   });
	}

	static class ProjectPropertyEditor extends SwingUtil.FormPanel {

			private final JTextField _packageName = new JTextField();
			private final JTextField _root = new JTextField();
			private final JTextField _javaVersion = new JTextField();
			private final JTextField _artifactId = new JTextField();
			private final JTextField _groupId = new JTextField();
			private final JTextField _version = new JTextField();
			private final JTextField _name = new JTextField();

	      ProjectPropertyEditor(PropertyContainer container) {
	         super("50dlu, 4dlu, 350dlu", "pref, 4dlu, pref, 4dlu, pref, 4dlu, pref, 4dlu, pref, 4dlu, pref, 4dlu, pref, 4dlu");

	         int row = -1;
	         row += 2;
	         addLabel("PackageName", 1, row);
	         add(_packageName, 3, row);
				setValue(_packageName, container, Properties.packageName.name(), new String[] { });

	         row += 2;
	         addLabel("Root", 1, row);
	         add(_root, 3, row);
				setValue(_root, container, Properties.root.name(), new String[] { });

	         row += 2;
	         addLabel("JavaVersion", 1, row);
	         add(_javaVersion, 3, row);
				setValue(_javaVersion, container, Properties.javaVersion.name(), new String[] { });

	         row += 2;
	         addLabel("ArtifactId", 1, row);
	         add(_artifactId, 3, row);
				setValue(_artifactId, container, Properties.artifactId.name(), new String[] { });

	         row += 2;
	         addLabel("GroupId", 1, row);
	         add(_groupId, 3, row);
				setValue(_groupId, container, Properties.groupId.name(), new String[] { });

	         row += 2;
	         addLabel("Version", 1, row);
	         add(_version, 3, row);
				setValue(_version, container, Properties.version.name(), new String[] { });

	         row += 2;
	         addLabel("Name", 1, row);
	         add(_name, 3, row);
				setValue(_name, container, Properties.name.name(), new String[] { });

	      }

			private void setValue(JTextField component, PropertyContainer container, String property, String[] values) {
	         component.setText(container.hasProperty(property) ? getString(container, property) : "");
	      }

			private void setValue(JCheckBox component, PropertyContainer container, String property, String[] values) {
	         component.setSelected(container.hasProperty(property) ? getString(container, property).toLowerCase().startsWith("boo") : false);
	      }

	      private void setValue(JComboBox<String> component, PropertyContainer container, String property, String[] values) {
	         component.setModel(new DefaultComboBoxModel<>(values));
	       	final String value = container.hasProperty(property) ? getString(container, property) : null;
		      if (value == null) return;
		      component.setSelectedItem(value);
		   }

	      void commit(PropertyContainer container) throws Exception {
				getValue(container, "packageName", _packageName); 
				getValue(container, "root", _root); 
				getValue(container, "javaVersion", _javaVersion); 
				getValue(container, "artifactId", _artifactId); 
				getValue(container, "groupId", _groupId); 
				getValue(container, "version", _version); 
				getValue(container, "name", _name); 
	      }

			private void getValue(PropertyContainer container, String property, JTextField component) {
	         container.setProperty(property, component.getText().trim());
	      }

	      private void getValue(PropertyContainer container, String property, JComboBox<String> component) {
	         container.setProperty(property, component.getSelectedItem() == null ? null : component.getSelectedItem().toString());
	      }
	   }

	static void showProjectPropertyEditor(PropertyContainer container, NeoEditor editor, PInputEvent event) {
	   final ProjectPropertyEditor form = new ProjectPropertyEditor(container);
	   SwingUtil.showDialogNoDefaultButton(form, editor.canvas, "Project", () -> {
	      editor.doInTransaction(tx1 -> {
	         form.commit(container);
	      });
	   });
	}


   public static abstract class ProjectDomainVisitor implements com.generator.domain.IDomainVisitor {

		@Override
      public <T> T visit(Node n) {
         if (n == null) return null;
		  if (BaseDomainVisitor.hasLabel(n, TemplateGroup.name())) return visitTemplateGroup(n);
		  if (BaseDomainVisitor.hasLabel(n, Project.name())) return visitProject(n);
         return null;
      }

		<T> T visitTemplateGroup(Node node) {
         return null;
      }

		<T> T visitProject(Node node) {
         return null;
      }

   }
}