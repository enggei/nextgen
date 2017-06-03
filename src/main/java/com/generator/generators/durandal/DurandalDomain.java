package com.generator.generators.durandal;

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
import static com.generator.generators.durandal.DurandalDomain.Entities.*;
import static com.generator.generators.durandal.DurandalDomain.Relations.*;
import static org.neo4j.graphdb.Direction.INCOMING;

/**
 * Created 23.02.17.
 */
public abstract class DurandalDomain implements IDomain {

   public enum Entities implements Label {
      html, App, View, Module
   }

   public enum Relations implements RelationshipType {
      STATEMENTS, VIEW, MODULES, DEPENDENCY
   }

   public enum Properties {
      element, name, root, title, route
   }

   @Override
   public String getName() {
      return "Durandal";
   }

   @Override
   public final Label[] values() {
      return Entities.values();
   }

   @Override
   public final NeoPNode newPNode(Node node, String nodetype, NeoEditor editor) {
      switch (Entities.valueOf(nodetype)) {
         case html:
         	return newHtmlPNode(node, editor);
         case App:
         	return newAppPNode(node, editor);
         case View:
         	return newViewPNode(node, editor);
         case Module:
         	return newModulePNode(node, editor);
      }

      throw new IllegalArgumentException("unsupported DurandalDomain nodetype " + nodetype + " for node " + NeoModel.debugNode(node));
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

   protected NeoPNode newHtmlPNode(Node node, NeoEditor editor) {
         return new HtmlPNode(node, editor);
      }

   protected static class HtmlPNode extends DurandalDomainPNode {

      HtmlPNode(Node node, NeoEditor editor) {
         super(node, Entities.html, "name", "#a6d854", editor);
      }

   	@Override
   	public void showNodeActions(JPopupMenu pop, PInputEvent event) {
   		pop.add(new NeoEditor.TransactionAction("Edit", editor) {
   			@Override
   			public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
   				showHtmlPropertyEditor(node, editor, event);
   			}
   		});
   		pop.add(editor.newSetNodePropertyAction(DurandalDomain.Properties.element.name(), this));


   		super.showNodeActions(pop, event);
   	}

   	@Override
      public void showTargetActions(JPopupMenu pop, PInputEvent event) {

         final Collection<NeoPNode> selectedNodes = editor.getSelectedNodes();
         if (selectedNodes.isEmpty()) return;

         final Map<String, Set<Node>> incoming = new TreeMap<>();

         selectedNodes.forEach(selectedNode -> {
            // incoming
            if (selectedNode.node.hasLabel(Entities.View)) {
               final Set<Node> set = incoming.computeIfAbsent(Entities.View.name(), k -> new LinkedHashSet<>());
               set.add(selectedNode.node);
   			}

         });

         // incoming
         if (incoming.containsKey(Entities.View.name())) {
            final Set<Node> nodes = incoming.get(Entities.View.name());
            pop.add(new NeoEditor.TransactionAction("Add <- " + Relations.STATEMENTS, editor) {
               @Override
               public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                  for (Node src : nodes) {
                     final Relationship newRelation = src.createRelationshipTo(node, Relations.STATEMENTS);
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
         editor.showAndLayout(pNodes, pNode);
      }

   	@Override
      public void showDependents() {
         final Map<UUID, Label> pNodes = new LinkedHashMap<>();
   		incoming(node, Relations.STATEMENTS).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.View));
         editor.showAndLayout(pNodes, pNode);
      }
   }

   protected NeoPNode newAppPNode(Node node, NeoEditor editor) {
         return new AppPNode(node, editor);
      }

   protected static class AppPNode extends DurandalDomainPNode {

      AppPNode(Node node, NeoEditor editor) {
         super(node, Entities.App, "name", "#377eb8", editor);
      }

   	@Override
   	public void showNodeActions(JPopupMenu pop, PInputEvent event) {
   		pop.add(new NeoEditor.TransactionAction("Edit", editor) {
   			@Override
   			public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
   				showAppPropertyEditor(node, editor, event);
   			}
   		});
   		pop.add(editor.newSetNodePropertyAction(DurandalDomain.Properties.name.name(), this));
   		pop.add(editor.newSetNodePropertyAction(DurandalDomain.Properties.root.name(), this));
   		pop.add(editor.newAddNodeAction(Entities.Module, Relations.MODULES, this, event));

   		for (Relationship relationship : outgoing(node, Relations.MODULES)) {
               pop.add(new NeoEditor.TransactionAction("Edit " + relationship.getType() + "' -> '" + NeoModel.getNameOrLabelFrom(other(node, relationship)) + "'", editor) {
                  @Override
                  public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                     showModulesPropertyEditor(relationship, editor, event);
                  }
            	});
            }


   		super.showNodeActions(pop, event);
   	}

   	@Override
      public void showTargetActions(JPopupMenu pop, PInputEvent event) {

         final Collection<NeoPNode> selectedNodes = editor.getSelectedNodes();
         if (selectedNodes.isEmpty()) return;

         final Map<String, Set<Node>> outgoing = new TreeMap<>();

         selectedNodes.forEach(selectedNode -> {
            // outgoing
            if (selectedNode.node.hasLabel(Entities.Module)) {
               final Set<Node> set = outgoing.computeIfAbsent(Entities.Module.name(), k -> new LinkedHashSet<>());
               //todo: add constraint and add if allowed (control circular constraints, one-to-many, only-one etc.)
               set.add(selectedNode.node);
   			}

         });

         // outgoing
         if (outgoing.containsKey(Entities.Module.name())) {
            final Set<Node> nodes = outgoing.get(Entities.Module.name());
            pop.add(new NeoEditor.TransactionAction("Add -> " + Relations.MODULES, editor) {
               @Override
               public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                  for (Node dst : nodes) {
                     final Relationship newRelation = node.createRelationshipTo(dst, Relations.MODULES);
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
   		outgoing(node, Relations.MODULES).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.Module));
         editor.showAndLayout(pNodes, pNode);
      }

   	@Override
      public void showDependents() {
         final Map<UUID, Label> pNodes = new LinkedHashMap<>();
         editor.showAndLayout(pNodes, pNode);
      }
   }

   protected NeoPNode newViewPNode(Node node, NeoEditor editor) {
         return new ViewPNode(node, editor);
      }

   protected static class ViewPNode extends DurandalDomainPNode {

      ViewPNode(Node node, NeoEditor editor) {
         super(node, Entities.View, "name", "#4daf4a", editor);
      }

   	@Override
   	public void showNodeActions(JPopupMenu pop, PInputEvent event) {
   		pop.add(new NeoEditor.TransactionAction("Edit", editor) {
   			@Override
   			public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
   				showViewPropertyEditor(node, editor, event);
   			}
   		});
   		pop.add(editor.newSetNodePropertyAction(DurandalDomain.Properties.name.name(), this));
   		pop.add(editor.newAddNodeAction(Entities.html, Relations.STATEMENTS, this, event));


   		super.showNodeActions(pop, event);
   	}

   	@Override
      public void showTargetActions(JPopupMenu pop, PInputEvent event) {

         final Collection<NeoPNode> selectedNodes = editor.getSelectedNodes();
         if (selectedNodes.isEmpty()) return;

         final Map<String, Set<Node>> outgoing = new TreeMap<>();

         selectedNodes.forEach(selectedNode -> {
            // outgoing
            if (selectedNode.node.hasLabel(Entities.html)) {
               final Set<Node> set = outgoing.computeIfAbsent(Entities.html.name(), k -> new LinkedHashSet<>());
               //todo: add constraint and add if allowed (control circular constraints, one-to-many, only-one etc.)
               set.add(selectedNode.node);
   			}

         });

         // outgoing
         if (outgoing.containsKey(Entities.html.name())) {
            final Set<Node> nodes = outgoing.get(Entities.html.name());
            pop.add(new NeoEditor.TransactionAction("Add -> " + Relations.STATEMENTS, editor) {
               @Override
               public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                  for (Node dst : nodes) {
                     final Relationship newRelation = node.createRelationshipTo(dst, Relations.STATEMENTS);
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
   		outgoing(node, Relations.STATEMENTS).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.html));
         editor.showAndLayout(pNodes, pNode);
      }

   	@Override
      public void showDependents() {
         final Map<UUID, Label> pNodes = new LinkedHashMap<>();
         editor.showAndLayout(pNodes, pNode);
      }
   }

   protected NeoPNode newModulePNode(Node node, NeoEditor editor) {
         return new ModulePNode(node, editor);
      }

   protected static class ModulePNode extends DurandalDomainPNode {

      ModulePNode(Node node, NeoEditor editor) {
         super(node, Entities.Module, "name", "#984ea3", editor);
      }

   	@Override
   	public void showNodeActions(JPopupMenu pop, PInputEvent event) {
   		pop.add(new NeoEditor.TransactionAction("Edit", editor) {
   			@Override
   			public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
   				showModulePropertyEditor(node, editor, event);
   			}
   		});
   		pop.add(editor.newSetNodePropertyAction(DurandalDomain.Properties.name.name(), this));
   		pop.add(editor.newAddNodeAction(Entities.View, Relations.VIEW, this, event));
   		pop.add(editor.newAddNodeAction(Entities.Module, Relations.DEPENDENCY, this, event));


   		super.showNodeActions(pop, event);
   	}

   	@Override
      public void showTargetActions(JPopupMenu pop, PInputEvent event) {

         final Collection<NeoPNode> selectedNodes = editor.getSelectedNodes();
         if (selectedNodes.isEmpty()) return;

         final Map<String, Set<Node>> outgoing = new TreeMap<>();

         selectedNodes.forEach(selectedNode -> {
            // outgoing
            if (selectedNode.node.hasLabel(Entities.View)) {
               final Set<Node> set = outgoing.computeIfAbsent(Entities.View.name(), k -> new LinkedHashSet<>());
               //todo: add constraint and add if allowed (control circular constraints, one-to-many, only-one etc.)
               set.add(selectedNode.node);
   			}

            if (selectedNode.node.hasLabel(Entities.Module)) {
               final Set<Node> set = outgoing.computeIfAbsent(Entities.Module.name(), k -> new LinkedHashSet<>());
               //todo: add constraint and add if allowed (control circular constraints, one-to-many, only-one etc.)
               set.add(selectedNode.node);
   			}

         });

         // outgoing
         if (outgoing.containsKey(Entities.View.name())) {
            final Set<Node> nodes = outgoing.get(Entities.View.name());
            pop.add(new NeoEditor.TransactionAction("Add -> " + Relations.VIEW, editor) {
               @Override
               public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                  for (Node dst : nodes) {
                     final Relationship newRelation = node.createRelationshipTo(dst, Relations.VIEW);
                     editor.addRelation(newRelation);
                  }
                  updateView();
               }
            });
         }

         if (outgoing.containsKey(Entities.Module.name())) {
            final Set<Node> nodes = outgoing.get(Entities.Module.name());
            pop.add(new NeoEditor.TransactionAction("Add -> " + Relations.DEPENDENCY, editor) {
               @Override
               public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                  for (Node dst : nodes) {
                     final Relationship newRelation = node.createRelationshipTo(dst, Relations.DEPENDENCY);
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
   		outgoing(node, Relations.VIEW).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.View));
   		outgoing(node, Relations.DEPENDENCY).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.Module));
         editor.showAndLayout(pNodes, pNode);
      }

   	@Override
      public void showDependents() {
         final Map<UUID, Label> pNodes = new LinkedHashMap<>();
         editor.showAndLayout(pNodes, pNode);
      }
   }


   private static class DurandalDomainPNode extends NeoPNode<PText> {

      final Color selectedColor = Color.RED;
      protected final Color defaultColor;
      private final String property;
      private final DurandalDomain.Entities nodeType;

      DurandalDomainPNode(Node node, DurandalDomain.Entities nodeType, String property, String defaultColor, NeoEditor editor) {
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

	static class HtmlPropertyEditor extends SwingUtil.FormPanel {

			private final JTextField _element = new JTextField();

	      HtmlPropertyEditor(PropertyContainer container) {
	         super("50dlu, 4dlu, 350dlu", "pref, 4dlu");

	         int row = -1;
	         row += 2;
	         addLabel("Element", 1, row);
	         add(_element, 3, row);
				setValue(_element, container, Properties.element.name(), new String[] { });

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
				getValue(container, "element", _element); 
	      }

			private void getValue(PropertyContainer container, String property, JTextField component) {
	         container.setProperty(property, component.getText().trim());
	      }

	      private void getValue(PropertyContainer container, String property, JComboBox<String> component) {
	         container.setProperty(property, component.getSelectedItem() == null ? null : component.getSelectedItem().toString());
	      }
	   }

	static void showHtmlPropertyEditor(PropertyContainer container, NeoEditor editor, PInputEvent event) {
	   final HtmlPropertyEditor form = new HtmlPropertyEditor(container);
	   SwingUtil.showDialogNoDefaultButton(form, editor.canvas, "html", () -> {
	      editor.doInTransaction(tx1 -> {
	         form.commit(container);
	      });
	   });
	}

	static class AppPropertyEditor extends SwingUtil.FormPanel {

			private final JTextField _name = new JTextField();
			private final JTextField _root = new JTextField();

	      AppPropertyEditor(PropertyContainer container) {
	         super("50dlu, 4dlu, 350dlu", "pref, 4dlu, pref, 4dlu");

	         int row = -1;
	         row += 2;
	         addLabel("Name", 1, row);
	         add(_name, 3, row);
				setValue(_name, container, Properties.name.name(), new String[] { });

	         row += 2;
	         addLabel("Root", 1, row);
	         add(_root, 3, row);
				setValue(_root, container, Properties.root.name(), new String[] { });

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
				getValue(container, "name", _name); 
				getValue(container, "root", _root); 
	      }

			private void getValue(PropertyContainer container, String property, JTextField component) {
	         container.setProperty(property, component.getText().trim());
	      }

	      private void getValue(PropertyContainer container, String property, JComboBox<String> component) {
	         container.setProperty(property, component.getSelectedItem() == null ? null : component.getSelectedItem().toString());
	      }
	   }

	static void showAppPropertyEditor(PropertyContainer container, NeoEditor editor, PInputEvent event) {
	   final AppPropertyEditor form = new AppPropertyEditor(container);
	   SwingUtil.showDialogNoDefaultButton(form, editor.canvas, "App", () -> {
	      editor.doInTransaction(tx1 -> {
	         form.commit(container);
	      });
	   });
	}

	static class ViewPropertyEditor extends SwingUtil.FormPanel {

			private final JTextField _name = new JTextField();

	      ViewPropertyEditor(PropertyContainer container) {
	         super("50dlu, 4dlu, 350dlu", "pref, 4dlu");

	         int row = -1;
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
				getValue(container, "name", _name); 
	      }

			private void getValue(PropertyContainer container, String property, JTextField component) {
	         container.setProperty(property, component.getText().trim());
	      }

	      private void getValue(PropertyContainer container, String property, JComboBox<String> component) {
	         container.setProperty(property, component.getSelectedItem() == null ? null : component.getSelectedItem().toString());
	      }
	   }

	static void showViewPropertyEditor(PropertyContainer container, NeoEditor editor, PInputEvent event) {
	   final ViewPropertyEditor form = new ViewPropertyEditor(container);
	   SwingUtil.showDialogNoDefaultButton(form, editor.canvas, "View", () -> {
	      editor.doInTransaction(tx1 -> {
	         form.commit(container);
	      });
	   });
	}

	static class ModulePropertyEditor extends SwingUtil.FormPanel {

			private final JTextField _name = new JTextField();
			private final JTextField _title = new JTextField();
			private final JTextField _route = new JTextField();

	      ModulePropertyEditor(PropertyContainer container) {
	         super("50dlu, 4dlu, 350dlu", "pref, 4dlu, pref, 4dlu, pref, 4dlu");

	         int row = -1;
	         row += 2;
	         addLabel("Name", 1, row);
	         add(_name, 3, row);
				setValue(_name, container, Properties.name.name(), new String[] { });

	         row += 2;
	         addLabel("Title", 1, row);
	         add(_title, 3, row);
				setValue(_title, container, Properties.title.name(), new String[] { });

	         row += 2;
	         addLabel("Route", 1, row);
	         add(_route, 3, row);
				setValue(_route, container, Properties.route.name(), new String[] { });

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
				getValue(container, "name", _name); 
				getValue(container, "title", _title); 
				getValue(container, "route", _route); 
	      }

			private void getValue(PropertyContainer container, String property, JTextField component) {
	         container.setProperty(property, component.getText().trim());
	      }

	      private void getValue(PropertyContainer container, String property, JComboBox<String> component) {
	         container.setProperty(property, component.getSelectedItem() == null ? null : component.getSelectedItem().toString());
	      }
	   }

	static void showModulePropertyEditor(PropertyContainer container, NeoEditor editor, PInputEvent event) {
	   final ModulePropertyEditor form = new ModulePropertyEditor(container);
	   SwingUtil.showDialogNoDefaultButton(form, editor.canvas, "Module", () -> {
	      editor.doInTransaction(tx1 -> {
	         form.commit(container);
	      });
	   });
	}

	static class ModulesPropertyEditor extends SwingUtil.FormPanel {

			private final JTextField _title = new JTextField();
			private final JTextField _route = new JTextField();

	      ModulesPropertyEditor(PropertyContainer container) {
	         super("50dlu, 4dlu, 350dlu", "pref, 4dlu, pref, 4dlu");

	         int row = -1;
	         row += 2;
	         addLabel("Title", 1, row);
	         add(_title, 3, row);
				setValue(_title, container, Properties.title.name(), new String[] { });

	         row += 2;
	         addLabel("Route", 1, row);
	         add(_route, 3, row);
				setValue(_route, container, Properties.route.name(), new String[] { });

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
				getValue(container, "title", _title); 
				getValue(container, "route", _route); 
	      }

			private void getValue(PropertyContainer container, String property, JTextField component) {
	         container.setProperty(property, component.getText().trim());
	      }

	      private void getValue(PropertyContainer container, String property, JComboBox<String> component) {
	         container.setProperty(property, component.getSelectedItem() == null ? null : component.getSelectedItem().toString());
	      }
	   }

	static void showModulesPropertyEditor(PropertyContainer container, NeoEditor editor, PInputEvent event) {
	   final ModulesPropertyEditor form = new ModulesPropertyEditor(container);
	   SwingUtil.showDialogNoDefaultButton(form, editor.canvas, "modules", () -> {
	      editor.doInTransaction(tx1 -> {
	         form.commit(container);
	      });
	   });
	}



   public static abstract class DurandalDomainVisitor implements com.generator.domain.IDomainVisitor {

		@Override
      public <T> T visit(Node n) {
         if (n == null) return null;
		  if (BaseDomainVisitor.hasLabel(n, Entities.html.name())) return visitHtml(n);
		  if (BaseDomainVisitor.hasLabel(n, Entities.App.name())) return visitApp(n);
		  if (BaseDomainVisitor.hasLabel(n, Entities.View.name())) return visitView(n);
		  if (BaseDomainVisitor.hasLabel(n, Entities.Module.name())) return visitModule(n);
         return null;
      }

		<T> T visitHtml(Node node) {
         return null;
      }

		<T> T visitApp(Node node) {
         return null;
      }

		<T> T visitView(Node node) {
         return null;
      }

		<T> T visitModule(Node node) {
         return null;
      }

   }
}