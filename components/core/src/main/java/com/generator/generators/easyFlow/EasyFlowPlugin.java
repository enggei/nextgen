package com.generator.generators.easyFlow;

import com.generator.app.App;
import com.generator.app.nodes.NeoNode;
import com.generator.util.GeneratedFile;
import com.generator.util.SwingUtil;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.Transaction;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.util.Set;

import static com.generator.generators.project.ProjectDomainPlugin.getPackageNameProperty;
import static com.generator.generators.project.ProjectPlugin.getFile;
import static com.generator.generators.project.ProjectPlugin.incomingRENDERER;
import static com.generator.util.NeoUtil.other;

/**
 * Created 03.08.17.
 */
public class EasyFlowPlugin extends EasyFlowDomainPlugin {

   public EasyFlowPlugin(App app) {
      super(app);
   }

   @Override
   protected void addActionsTo(JMenu menu) {

      addShowMenu(menu, Entities.Flow);

      menu.add(new App.TransactionAction("New Flow", app) {
         @Override
         public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

            final String name = SwingUtil.showInputDialog("Name", app);
            if (name == null || name.length() == 0) return;

            fireNodesLoaded(newFlow(name, null, false));
         }
      });
   }

   @Override
   protected void handleFlow(JPopupMenu pop, NeoNode flowNode, Set<NeoNode> selectedNodes) {
      incomingRENDERER(flowNode.getNode(), (rendererRelationship, other) -> pop.add(new App.TransactionAction("Generate FSM", app) {
         @Override
         protected void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
            renderEasyFlow(rendererRelationship, flowNode.getNode());
         }
      }));
      super.handleFlow(pop, flowNode, selectedNodes);
   }

   public static void renderEasyFlow(Relationship rendererRelationship, Node node) {

      final String packageName = getPackageNameProperty(rendererRelationship);
      final String name = getNameProperty(node);
      final File targetDir = getFile(other(node, rendererRelationship));

      final EasyFlowGenerator javaGenerator = new EasyFlowGenerator(packageName);
      javaGenerator.visit(node);
      final String javaClass = javaGenerator.getResult();

      try {
         GeneratedFile.newJavaFile(targetDir.getPath(), packageName, name).write(javaClass);
      } catch (IOException ex) {
         ex.printStackTrace();
      }
   }
}