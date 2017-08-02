package com.generator.generators.project;

import com.generator.editors.canvas.neo.NeoEditor;
import com.generator.editors.canvas.neo.NeoPNode;
import com.generator.util.SwingUtil;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;
import org.piccolo2d.event.PInputEvent;

import javax.swing.*;
import java.awt.event.ActionEvent;

import static com.generator.editors.NeoModel.uuidOf;

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

            final Node newNode = graph.newNode(Entities.ROOT.name());
            newNode.setProperty(Properties.path.name(), name);

            editor.show(uuidOf(newNode), Entities.ROOT.name()).setOffset(event);
         }
      });
   }

   @Override
   protected NeoPNode newROOTPNode(Node node, NeoEditor editor) {
      return new ROOTPNode(node, editor) {
         @Override
         public void showNodeActions(JPopupMenu pop, PInputEvent event) {

//            pop.add(new NeoEditor.TransactionAction("Generate", editor) {
//               @Override
//               public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
//
//                  final ProjectDomainGroup projectGroup = new ProjectDomainGroup();
//
//                  final String packageName = getString(node, Properties.packageName.name());
//                  final String name = getString(node, Properties.name.name());
//
//                  final ProjectDomainGroup.projectST projectST = projectGroup.newproject().
//                        setName(name).
//                        setPackageName(packageName);
//
//                  outgoing(node,Relations.GROUPS).forEach(new Consumer<Relationship>() {
//                     @Override
//                     public void accept(Relationship relationship) {
//                        final Node groupNode = other(node,relationship);
//                        projectST.addGroupsValue(getString(groupNode,Properties.name.name()), getString(groupNode,Properties.packageName.name()),getString(groupNode,Properties.reference.name()));
//                     }
//                  });
//
//                  GeneratedFile.newJavaFile(getString(node, Properties.root.name()), packageName, name);
//                  System.out.println(projectST);
//               }
//            });
            super.showNodeActions(pop, event);
         }
      };
   }
}