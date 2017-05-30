package com.generator.generators.project;

import com.generator.editors.BaseDomainVisitor;
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
import java.util.function.Consumer;

import static com.generator.editors.BaseDomainVisitor.getString;
import static com.generator.editors.BaseDomainVisitor.other;
import static com.generator.editors.BaseDomainVisitor.outgoing;
import static com.generator.editors.NeoModel.uuidOf;
import static com.generator.generators.project.ProjectDomain.Entities.Project;

/**
 * Created 24.03.17.
 */
public class ProjectDomainImpl extends ProjectDomain {

   @Override
   public void addToDomainMenu(PInputEvent event, NeoEditor editor, JMenu domainMenu) {

      domainMenu.add(new NeoEditor.TransactionAction("New Project", editor) {
         @Override
         public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

            final String name = SwingUtil.showInputDialog("Name", canvas);
            if (name == null) return;

            final Node newNode = graph.newNode(Project.name());
            newNode.setProperty(Properties.name.name(), name);

            editor.show(uuidOf(newNode), Project.name()).setOffset(event);
         }
      });
   }

   @Override
   protected NeoPNode newProjectPNode(Node node, NeoEditor editor) {
      return new ProjectPNode(node, editor) {
         @Override
         public void showNodeActions(JPopupMenu pop, PInputEvent event) {

            pop.add(new NeoEditor.TransactionAction("Generate", editor) {
               @Override
               public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

                  final ProjectDomainGroup projectGroup = new ProjectDomainGroup();

                  final String packageName = getString(node, Properties.packageName.name());
                  final String name = getString(node, Properties.name.name());

                  final ProjectDomainGroup.projectST projectST = projectGroup.newproject().
                        setName(name).
                        setPackageName(packageName);

                  outgoing(node,Relations.GROUPS).forEach(new Consumer<Relationship>() {
                     @Override
                     public void accept(Relationship relationship) {
                        final Node groupNode = other(node,relationship);
                        projectST.addGroupsValue(getString(groupNode,Properties.name.name()), getString(groupNode,Properties.packageName.name()),getString(groupNode,Properties.reference.name()));
                     }
                  });

                  GeneratedFile.newJavaFile(getString(node, Properties.root.name()), packageName, name);
                  System.out.println(projectST);
               }
            });

            super.showNodeActions(pop, event);
         }
      };
   }
}