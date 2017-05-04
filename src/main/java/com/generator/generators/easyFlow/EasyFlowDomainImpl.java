package com.generator.generators.easyFlow;

import com.generator.editors.canvas.neo.NeoEditor;
import com.generator.editors.canvas.neo.NeoPNode;
import com.generator.generators.templates.domain.GeneratedFile;
import com.generator.util.SwingUtil;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.Transaction;
import org.piccolo2d.event.PInputEvent;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.Collection;

import static com.generator.editors.BaseDomainVisitor.getString;
import static com.generator.editors.BaseDomainVisitor.hasOutgoing;
import static com.generator.editors.NeoModel.uuidOf;
import static com.generator.generators.easyFlow.EasyFlowDomain.Entities.ContextProperty;
import static com.generator.generators.easyFlow.EasyFlowDomain.Entities.Event;
import static com.generator.generators.easyFlow.EasyFlowDomain.Entities.State;
import static com.generator.generators.easyFlow.EasyFlowDomain.Relations.FROM;

/**
 * Created 18.03.17.
 */
public class EasyFlowDomainImpl extends EasyFlowDomain {

   @Override
   public void addToDomainMenu(PInputEvent event, NeoEditor editor, JMenu domainMenu) {
      domainMenu.add(editor.newAddNodeAction(Entities.Flow, "name", event));
   }

   @Override
   protected NeoPNode newFlowPNode(Node node, NeoEditor editor) {
      return new FlowPNode(node, editor) {
         @Override
         public void showNodeActions(JPopupMenu pop, PInputEvent event) {

            pop.add(editor.newSetNodePropertyAction(Properties.name.name(), this));
            pop.add(editor.newSetNodePropertyAction(Properties.packageName.name(), this));
            pop.add(editor.newSetNodePropertyAction(Properties.root.name(), this));
            pop.add(editor.newAddNodeAction(Entities.State, "From", Properties.name.name(), Relations.FROM, this, event));
            pop.add(editor.newAddNodeAction(Entities.ContextProperty, Relations.PROPERTY, this, event));

            if (hasOutgoing(node, FROM)) {
               pop.add(new NeoEditor.TransactionAction("Generate Java", editor) {
                  @Override
                  public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

                     final String root = getString(node, Properties.root.name());
                     final String packageName = getString(node, Properties.packageName.name());
                     final String name = getString(node, Properties.name.name());

                     if (root == null || packageName == null || name == null) {
                        SwingUtil.showMessage("Flow must have 'root', 'packageName' and 'name' to generate java-file", editor.getCanvas());
                        return;
                     }

                     final String javaClass = new EasyFlowJavaGenerator(new EasyFlowGroup()).visitFlow(node);
                     GeneratedFile.newJavaFile(root, packageName, name).write(javaClass);
                  }
               });
            }
         }
      };
   }

   @Override
   protected NeoPNode newStatePNode(Node node, NeoEditor editor) {
      return new StatePNode(node, editor) {

         @Override
         public void showNodeActions(JPopupMenu pop, PInputEvent event) {
            pop.add(editor.newSetNodePropertyAction(Properties.name.name(), this));
            pop.add(editor.newAddNodeAction(Event, Properties.name.name(), Relations.ON, this, event));
            super.showNodeActions(pop, event);

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
      };
   }

   @Override
   protected NeoPNode newEventPNode(Node node, NeoEditor editor) {
      return new EventPNode(node, editor) {
         @Override
         public void showNodeActions(JPopupMenu pop, PInputEvent event) {
            pop.add(editor.newSetNodePropertyAction(Properties.name.name(), this));
            pop.add(editor.newAddNodeAction(State, Properties.name.name(), Relations.TO, this, event));
            pop.add(editor.newAddNodeAction(State, "Finish", Properties.name.name(), Relations.FINISH, this, event));
            super.showNodeActions(pop, event);
         }
      };
   }

   @Override
   protected NeoPNode newContextPropertyPNode(Node node, NeoEditor editor) {
      return new ContextPropertyPNode(node, editor) {
         @Override
         public void showNodeActions(JPopupMenu pop, PInputEvent event) {
            pop.add(new NeoEditor.TransactionAction("Edit", editor) {
               @Override
               public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                  showContextPropertyEditor(node, editor, event);
               }
            });

            super.showNodeActions(pop, event);
         }
      };
   }
}
