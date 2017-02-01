package com.generator.generators.project;

import com.generator.editors.NeoModel;
import com.generator.editors.canvas.neo.NeoEditor;
import com.generator.editors.canvas.neo.NeoPNode;
import com.generator.util.FileUtil;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.RelationshipType;

import java.io.File;

import static com.generator.generators.project.ProjectDomain.LABELS.*;
import static com.generator.generators.project.ProjectDomain.RELATIONS.FILE;
import static com.generator.generators.project.ProjectDomain.RELATIONS.SUBDIR;
import static com.generator.generators.templates.editor.TemplateDomain.TemplateRelations.PROJECT_DIRECTORY;

/**
 * Created 19.01.17.
 */
public class ProjectDomain {

   //todo refactor all PNodes into DomainPNode

   public static NeoPNode newPNode(Node node, String nodetype, NeoEditor neoEditor) {
      switch (ProjectDomain.LABELS.valueOf(nodetype)) {
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

   public enum LABELS implements Label {
      ProjectRoot, JavaSrc, Resources, TestJavaSrc, TestResources,
      Pom
   }

   public enum RELATIONS implements RelationshipType {
      SUBDIR, FILE
   }

   public static Node newJavaProject(NeoModel db, File root, Node project) {

      // this creates nodes representing the project-directories (not the directories themselves:)
      final Node projectRoot = db.newNode(ProjectRoot);
      project.createRelationshipTo(projectRoot, PROJECT_DIRECTORY);
      projectRoot.setProperty("name", FileUtil.tryToCreateDirIfNotExists(root).getAbsolutePath());

      newDirectory(db, project, "src/main/java", JavaSrc);
      newDirectory(db, project, "src/main/resources", Resources);
      newDirectory(db, project, "src/test/java", TestJavaSrc);
      newDirectory(db, project, "src/test/resources", TestResources);

      newFile(db, project, "pom.xml", Pom);

      return projectRoot;
   }

   private static Node newDirectory(NeoModel db, Node project, String subPath, LABELS type) {
      final Node node = db.newNode(type);
      node.setProperty("name", subPath);
      project.createRelationshipTo(node, SUBDIR);
      return node;
   }

   private static Node newFile(NeoModel db, Node project, String name, LABELS type) {
      final Node node = db.newNode(type);
      node.setProperty("name", name);
      project.createRelationshipTo(node, FILE);
      return node;
   }
}