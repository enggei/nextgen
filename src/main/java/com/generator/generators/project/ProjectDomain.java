package com.generator.generators.project;

import com.generator.editors.NeoModel;
import com.generator.editors.canvas.neo.NeoEditor;
import com.generator.editors.canvas.neo.NeoPNode;
import com.generator.util.FileUtil;
import com.generator.util.SwingUtil;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.RelationshipType;
import org.neo4j.graphdb.Transaction;
import org.piccolo2d.PNode;
import org.piccolo2d.event.PInputEvent;
import org.piccolo2d.nodes.PText;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

import static com.generator.editors.NeoModel.uuidOf;
import static com.generator.generators.project.ProjectDomain.Entities.*;
import static com.generator.generators.project.ProjectDomain.RELATIONS.FILE;
import static com.generator.generators.project.ProjectDomain.RELATIONS.SUBDIR;

/**
 * Created 19.01.17.
 */
public class ProjectDomain {

   //todo refactor all PNodes into DomainPNode

   public static NeoPNode newPNode(Node node, String nodetype, NeoEditor neoEditor) {
      switch (Entities.valueOf(nodetype)) {
         case ProjectRoot:
            return new ProjectRootPNode(node,neoEditor);
         case JavaSrc:
            return new JavaSrcPNode(node,neoEditor);
         case Resources:
            return new ResourcesPNode(node,neoEditor);
         case TestJavaSrc:
            return new TestJavaSourcePNode(node,neoEditor);
         case TestResources:
            return new TestResourcesPNode(node,neoEditor);
         case Pom:
            return new PomPNode(node, neoEditor);
         default:
            return null;
      }
   }

   public static void deleteNode(Node node) {
      // todo enforce constraints
   }

   public enum Entities implements Label {
      JavaProject,ProjectRoot, JavaSrc, Resources, TestJavaSrc, TestResources,
      Pom
   }

   public enum RELATIONS implements RelationshipType {
      SUBDIR, FILE
   }

   public static void addToMenu(JPopupMenu pop, PInputEvent event, NeoEditor editor) {
      final JMenu newMenu = new JMenu("Project");
      newMenu.add(new JavaProject(event, editor));
      pop.add(newMenu);
   }

   public static Node newJavaProject(NeoModel db, File root) {

      // this creates nodes representing the project-directories (not the directories themselves:)
      final Node projectRoot = db.newNode(JavaProject);
      projectRoot.setProperty("name", FileUtil.tryToCreateDirIfNotExists(root).getAbsolutePath());

      newDirectory(db, projectRoot, "src/main/java", JavaSrc);
      newDirectory(db, projectRoot, "src/main/resources", Resources);
      newDirectory(db, projectRoot, "src/test/java", TestJavaSrc);
      newDirectory(db, projectRoot, "src/test/resources", TestResources);

      newFile(db, projectRoot, "pom.xml", Pom);

      return projectRoot;
   }

   private static Node newDirectory(NeoModel db, Node project, String subPath, Entities type) {
      final Node node = db.newNode(type);
      node.setProperty("name", subPath);
      project.createRelationshipTo(node, SUBDIR);
      return node;
   }

   private static Node newFile(NeoModel db, Node project, String name, Entities type) {
      final Node node = db.newNode(type);
      node.setProperty("name", name);
      project.createRelationshipTo(node, FILE);
      return node;
   }

   public static class DomainPNode<T extends PNode> extends NeoPNode<PText> {

      protected final Color selectedColor = Color.RED;
      protected final Color defaultColor;
      private final String property;
      private final org.neo4j.graphdb.Label nodeType;

      public DomainPNode(Node node, Label nodeType, String property, String[] defaultColor, NeoEditor editor) {
         super(node, new PText(node.getProperty(property).toString()), nodeType.name(), editor);
         this.defaultColor = new Color(Integer.valueOf(defaultColor[0]), Integer.valueOf(defaultColor[1]), Integer.valueOf(defaultColor[2]));
         this.property = property;
         this.nodeType = nodeType;
//      pNode.setTextPaint(this.defaultColor);
//      pNode.setFont(new Font("Hack", Font.BOLD, 12));
      }

      public DomainPNode(Node node, PText representation, Label nodeType, String[] defaultColor, NeoEditor editor) {
         super(node, representation, nodeType.name(), editor);
         this.defaultColor = new Color(Integer.valueOf(defaultColor[0]), Integer.valueOf(defaultColor[1]), Integer.valueOf(defaultColor[2]));
         this.property = null;
         this.nodeType = nodeType;
//      pNode.setTextPaint(this.defaultColor);
//      pNode.setFont(new Font("Hack", Font.PLAIN, 12));
      }

      @Override
      public String getNodeType() {
         return nodeType.name();
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
//      pNode.setText(property == null ? "?" : node.getProperty(property).toString());
      }

      @Override
      public void onSelect() {
         pNode.setTextPaint(selectedColor);
      }

      @Override
      public void onUnselect() {
//      pNode.setTextPaint(defaultColor);
      }

      @Override
      public void onStartHighlight() {
//      pNode.setTextPaint(Color.ORANGE);
      }

      @Override
      public void onEndHighlight() {
//      pNode.setTextPaint(selected.get() ? selectedColor : defaultColor);
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

      @Override
      public void expand() {

      }
   }

   private static class JavaProject extends NeoEditor.TransactionAction {

      private final PInputEvent event;

      private String lastDir = System.getProperty("user.home");

      JavaProject(PInputEvent event, NeoEditor editor) {
         super("New Java Project", editor);
         this.event = event;
      }

      @Override
      public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

         final File root = SwingUtil.showOpenDir(editor.canvas, lastDir);
         if (root == null) return;

         final Node project = ProjectDomain.newJavaProject(editor.getGraph(), root);

         editor.show(uuidOf(project), ProjectDomain.Entities.ProjectRoot.name()).
               setOffset(event);

         lastDir = root.getAbsolutePath();
      }
   }

   static class ProjectDomainPNode extends DomainPNode<PText> {

      ProjectDomainPNode(Node node, ProjectDomain.Entities nodeType, String property, String[] defaultColor, NeoEditor editor) {
         super(node, new PText(node.getProperty(property).toString()), nodeType, defaultColor, editor);
      }

      @Override
      public void showNodeActions(JPopupMenu pop, PInputEvent event) {

         pop.add(new NeoEditor.TransactionAction("Render ", editor) {
            @Override
            public void actionPerformed(ActionEvent e, Transaction tx) throws Exception {

            }
         });

         super.showNodeActions(pop, event);
      }
   }

   static class ProjectRootPNode extends ProjectDomainPNode {

      ProjectRootPNode(Node node, NeoEditor editor) {
         super(node, ProjectDomain.Entities.ProjectRoot, "name", "153, 52, 4".split(", "), editor);
         pNode.setFont(new Font("Hack", Font.BOLD, 12));
      }
   }

   static class JavaSrcPNode extends ProjectDomainPNode {

      JavaSrcPNode(Node node, NeoEditor editor) {
         super(node, ProjectDomain.Entities.JavaSrc, "name", "153, 52, 4".split(", "), editor);
         pNode.setFont(new Font("Hack", Font.BOLD, 12));
      }
   }

   static class ResourcesPNode extends ProjectDomainPNode {

      ResourcesPNode(Node node, NeoEditor editor) {
         super(node, ProjectDomain.Entities.Resources, "name", "153, 52, 4".split(", "), editor);
         pNode.setFont(new Font("Hack", Font.BOLD, 12));
      }
   }

   static class TestJavaSourcePNode extends ProjectDomainPNode {

      TestJavaSourcePNode(Node node, NeoEditor editor) {
         super(node, ProjectDomain.Entities.TestResources, "name", "153, 52, 4".split(", "), editor);
         pNode.setFont(new Font("Hack", Font.BOLD, 12));
      }
   }

   static class TestResourcesPNode extends ProjectDomainPNode {

      TestResourcesPNode(Node node, NeoEditor editor) {
         super(node, ProjectDomain.Entities.TestResources, "name", "153, 52, 4".split(", "), editor);
         pNode.setFont(new Font("Hack", Font.BOLD, 12));
      }
   }

   static class PomPNode extends ProjectDomainPNode {

      PomPNode(Node node, NeoEditor editor) {
         super(node, ProjectDomain.Entities.Pom, "name", "153, 52, 4".split(", "), editor);
         pNode.setFont(new Font("Hack", Font.BOLD, 12));
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
   }
}