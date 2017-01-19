package com.generator.generators.project;

import com.generator.editors.NeoModel;
import com.generator.util.FileUtil;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.RelationshipType;

import java.io.File;

import static com.generator.generators.project.ProjectDomain.LABELS.*;
import static com.generator.generators.project.ProjectDomain.RELATIONS.DIRECTORY;
import static com.generator.generators.project.ProjectDomain.RELATIONS.FILE;
import static com.generator.generators.templates.editor.TemplateDomain.TemplateRelations.PROJECT_DIRECTORY;

/**
 * Created 19.01.17.
 */
public class ProjectDomain {

   public enum LABELS implements Label {
      ProjectRoot, JavaSrc, Resources, TestJavaSrc, TestResources,
      Pom
   }

   public enum RELATIONS implements RelationshipType {
      DIRECTORY, FILE
   }

   public static Node newJavaProject(NeoModel db, File root, Node project) {

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
      project.createRelationshipTo(node, DIRECTORY);
      return node;
   }

   private static Node newFile(NeoModel db, Node project, String name, LABELS type) {
      final Node node = db.newNode(type);
      node.setProperty("name", name);
      project.createRelationshipTo(node, FILE);
      return node;
   }
}