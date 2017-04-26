package com.generator.generators.project;

import com.generator.editors.NeoModel;
import com.generator.editors.canvas.neo.NeoEditor;
import com.generator.editors.canvas.neo.NeoPNode;
import com.generator.generators.cypher.CypherGroup;
import com.generator.generators.maven.MavenDomain;
import com.generator.generators.maven.PomGenerator;
import com.generator.util.FileUtil;
import com.generator.util.SwingUtil;
import org.jetbrains.annotations.NotNull;
import org.neo4j.graphdb.*;
import org.piccolo2d.event.PInputEvent;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.*;
import java.util.function.Consumer;

import static com.generator.editors.BaseDomainVisitor.*;
import static com.generator.editors.NeoModel.*;
import static com.generator.generators.maven.MavenDomain.Entities.Pom;
import static com.generator.generators.project.ProjectDomain.Entities.Directory;
import static com.generator.generators.project.ProjectDomain.Entities.Project;
import static com.generator.generators.project.ProjectDomain.Relations.MEMBER;

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
      domainMenu.add(new NeoEditor.TransactionAction("New Java POM Project", editor) {
         @Override
         public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

            final String name = SwingUtil.showInputDialog("Name", canvas);
            if (name == null) return;

            final Node newNode = graph.newNode(Project.name());
            newNode.setProperty(Properties.name.name(), name);

            final Node javaSrcNode = graph.newNode(Directory.name());
            javaSrcNode.setProperty(Properties.path.name(), "src/main/java");
            final Relationship javaSrcRel = newNode.createRelationshipTo(javaSrcNode, MEMBER);
            javaSrcRel.setProperty(Properties.type.name(), Directory.name());

            final Node resourcesNode = graph.newNode(Directory.name());
            resourcesNode.setProperty(Properties.path.name(), "src/main/resources");
            final Relationship resourcesRel = newNode.createRelationshipTo(resourcesNode, MEMBER);
            resourcesRel.setProperty(Properties.type.name(), Directory.name());

            final Node javaTestSrcNode = graph.newNode(Directory.name());
            javaTestSrcNode.setProperty(Properties.path.name(), "src/test/java");
            final Relationship javaTestRel = newNode.createRelationshipTo(javaTestSrcNode, MEMBER);
            javaTestRel.setProperty(Properties.type.name(), Directory.name());

            final Node testResourcesNode = graph.newNode(Directory.name());
            testResourcesNode.setProperty(Properties.path.name(), "src/test/resources");
            final Relationship testResourcesRel = newNode.createRelationshipTo(testResourcesNode, MEMBER);
            testResourcesRel.setProperty(Properties.type.name(), Directory.name());

            final Node pomNode = graph.newNode(Pom.name());
            pomNode.setProperty(MavenDomain.Properties.name.name(), name);
            final Relationship pomFile = newNode.createRelationshipTo(testResourcesNode, MEMBER);
            pomFile.setProperty(Properties.type.name(), Entities.File.name());

            editor.show(uuidOf(newNode), Project.name()).setOffset(event);
         }
      });
   }

   @Override
   protected NeoPNode newProjectPNode(Node node, NeoEditor editor) {
      return new ProjectPNode(node, editor) {
         @Override
         public void showNodeActions(JPopupMenu pop, PInputEvent event) {

            pop.add(editor.newSetNodePropertyAction(Properties.name.name(), this));
//            pop.add(editor.newSetNodePropertyAction(Properties.root.name(), this));

            pop.add(new NeoEditor.TransactionAction("Add Directory", editor) {
               @Override
               public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

                  final String path = SwingUtil.showInputDialog(Properties.path.name(), canvas);
                  if (path == null) return;

                  final Node newNode = graph.newNode(Directory.name());
                  newNode.setProperty(Properties.path.name(), path);
                  final Relationship memberRelation = node.createRelationshipTo(newNode, MEMBER);
                  memberRelation.setProperty(Properties.type.name(), Directory.name());
               }
            });

            pop.add(new NeoEditor.TransactionAction("Add File / Generator.. ?", editor) {
               @Override
               public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
                  // add a type of file (java, pom. etc) ??
               }
            });

            pop.add(new NeoEditor.TransactionAction("Render", editor) {
               @Override
               public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

//                  if (get(node, Properties.root.name()) == null) {
//                     final String root = SwingUtil.showInputDialog(Properties.root.name(), canvas);
//                     if (root == null) return;
//
//                     node.setProperty(Properties.root.name(), root);
//                  }
//
//                  final File root = FileUtil.tryToCreateDirIfNotExists(new File(getString(node, Properties.root.name())));
//                  System.out.println(root.getAbsolutePath());
//
//                  render(root);
               }
            });

//            if (has(node, Properties.root.name())) {
//               pop.add(new NeoEditor.TransactionAction("Copy Path", editor) {
//                  @Override
//                  public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {
//                     SwingUtil.toClipboard(getString(node, Properties.root.name()));
//                  }
//               });
//            }



            super.showNodeActions(pop, event);
         }

         @Override
         public void expand() {
            final Map<UUID, Label> pNodes = new LinkedHashMap<>();
            outgoing(node, Relations.MEMBER).forEach(relationship -> pNodes.put(uuidOf(other(node, relationship)), Entities.valueOf(relationship.getProperty(Properties.type.name()).toString())));
            editor.showAndLayout(pNodes, pNode);
         }
      };
   }

   @Override
   protected NeoPNode newDirectoryPNode(Node node, NeoEditor editor) {
      return new DirectoryPNode(node, editor) {

         @Override
         public void showNodeActions(JPopupMenu pop, PInputEvent event) {

            pop.add(new NeoEditor.TransactionAction("Render", editor) {
               @Override
               public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

//                  final File root = FileUtil.tryToCreateDirIfNotExists(new File(getString(other(node, singleIncoming(node, MEMBER)), Properties.root.name())));
//                  System.out.println(root.getAbsolutePath());

//                  render(node, root);
               }
            });
            super.showNodeActions(pop, event);
         }

         @Override
         public void showTargetActions(JPopupMenu pop, PInputEvent event) {

            // use templateDomain and DomainVisitor to create file-renderers to this directory
            final NeoPNode selectedNode = editor.getSelectedNodes().iterator().next();

            // supported generators:
            if (hasLabel(selectedNode.node, MavenDomain.Entities.Pom.name())) {

               final Node newFileNode = editor.getGraph().newNode(Entities.File.name());
               newFileNode.setProperty(Properties.outputFormat.name(), "xml");
               newFileNode.setProperty(Properties.generator.name(), PomGenerator.class.getName());
               newFileNode.createRelationshipTo(selectedNode.node, Relations.TARGET);
               node.createRelationshipTo(newFileNode, MEMBER);

               editor.show(uuidOf(newFileNode), Entities.File.name()).setOffset(event);
            }
         }
      };
   }

   private static void render(final Node node, final File parent) {

      outgoing(node, MEMBER).forEach(new Consumer<Relationship>() {
         @Override
         public void accept(Relationship relationship) {
            switch (Entities.valueOf(relationship.getProperty(Properties.type.name()).toString())) {
               case Directory:
                  final File dir = FileUtil.tryToCreateDirIfNotExists(new File(parent, getString(other(node, relationship), Properties.path.name())));
                  System.out.println("\t" + dir.getAbsolutePath());
                  render(other(node, relationship), dir);
                  break;
               case File:
                  new FileGenerator().visit(other(node, relationship));
                  break;
            }
         }
      });
   }
}