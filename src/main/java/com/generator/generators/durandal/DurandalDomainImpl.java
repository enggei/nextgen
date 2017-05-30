package com.generator.generators.durandal;

import com.generator.editors.BaseDomainVisitor;
import com.generator.editors.canvas.neo.NeoEditor;
import com.generator.editors.canvas.neo.NeoPNode;
import com.generator.util.FileUtil;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.Transaction;
import org.piccolo2d.event.PInputEvent;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.function.Consumer;

import static com.generator.editors.BaseDomainVisitor.*;
import static com.generator.editors.BaseDomainVisitor.other;

/**
 * Created 08.05.17.
 */
public class DurandalDomainImpl extends DurandalDomain {

   @Override
   public void addToDomainMenu(PInputEvent event, NeoEditor editor, JMenu domainMenu) {
      domainMenu.add(editor.newAddNodeAction(Entities.App, "name", event));
   }

   @Override
   protected NeoPNode newModulePNode(Node node, NeoEditor editor) {
      return new ModulePNode(node, editor) {

      };
   }

   @Override
   protected NeoPNode newAppPNode(Node node, NeoEditor editor) {
      return new AppPNode(node, editor) {
         @Override
         public void showNodeActions(JPopupMenu pop, PInputEvent event) {
            pop.add(new NeoEditor.TransactionAction("Generate", editor) {
               @Override
               public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

                  final String appName = getString(node, Properties.name.name());
                  final String root = getString(node, Properties.root.name());

                  final DurandalDomainGroup group = new DurandalDomainGroup();
                  final DurandalDomainGroup.appHTMLST appHTMLST = group.newappHTML().
                        setSplashTitle(appName);

                  final DurandalDomainGroup.mainJSST mainJSST = group.newmainJS().
                        setAppTitle(appName);

                  final DurandalDomainGroup.shellJSST shellJSST = group.newshellJS();

                  final DurandalDomainGroup.shellHTMLST shellHTMLST = group.newshellHTML();

                  outgoing(node).forEach(relationship -> {

                     final Node moduleNode = other(node, relationship);
                     final String moduleName = getString(moduleNode, Properties.name.name());

                     final DurandalDomainGroup.moduleJSST moduleJSST = group.newmoduleJS();
//                     final DurandalDomainGroup.moduleHTMLST moduleHTMLST = group.newmoduleHTML();

                     outgoing(moduleNode, Relations.DEPENDENCY).forEach(dependencyRelation -> {
                        final Object dependencyName = get(other(moduleNode, dependencyRelation), Properties.name.name());
                        moduleJSST.addDependenciesValue(dependencyName, dependencyName);
                     });

                     outgoing(moduleNode, Relations.VIEW).forEach(viewRelation -> {

                     });

                     shellJSST.addRoutesValue(moduleName, false, getString(relationship, Properties.route.name()), getString(relationship, Properties.title.name()));

//                     FileUtil.write(moduleHTMLST, new File(root + File.separator + moduleName, moduleName + ".html"));
                     FileUtil.write(moduleJSST, new File(root + File.separator + moduleName, moduleName + ".js"));
                  });

                  FileUtil.write(shellHTMLST, new File(root, "shell.html"));
                  FileUtil.write(shellJSST, new File(root, "shell.js"));
                  FileUtil.write(mainJSST, new File(root, "main.js"));
                  FileUtil.write(appHTMLST, new File(root, "index.html"));
               }
            });
            super.showNodeActions(pop, event);
         }
      };
   }

   @Override
   protected NeoPNode newViewPNode(Node node, NeoEditor editor) {
      return super.newViewPNode(node, editor);
   }
}