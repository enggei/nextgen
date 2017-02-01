package com.generator.generators.meta;

import com.generator.editors.NeoModel;
import com.generator.editors.canvas.neo.NeoEditor;
import com.generator.editors.canvas.neo.NeoPNode;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.RelationshipType;

import java.io.File;

import static com.generator.generators.meta.MetaDomain.RELATIONS.DOMAIN;
import static com.generator.generators.meta.MetaDomain.RELATIONS.LABEL;

/**
 * Created 30.01.17.
 */
public class MetaDomain {

   public static NeoPNode newPNode(Node node, String nodetype, NeoEditor neoEditor) {
      switch (MetaDomain.LABELS.valueOf(nodetype)) {
         case DOMAIN:
            return new MetaDomainPNode(node, neoEditor);
         case LABEL:
            return new LabelPNode(node, neoEditor);
         case RELATION:
            return new RelationNode(node, neoEditor);
         default:
            return null;
      }
   }

   public enum LABELS implements Label {
      DOMAIN, LABEL, RELATION
   }

   public enum RELATIONS implements RelationshipType {
      DOMAIN, LABEL, RELATIONS
   }

   public static Node newDomainNode(NeoModel db, File root, Node projectNode) {
      final Node newNode = db.newNode(LABELS.DOMAIN);
      newNode.setProperty("root", root.getAbsolutePath());
      newNode.setProperty("name", root.getName());

      projectNode.createRelationshipTo(newNode, DOMAIN);
      return newNode;
   }

   public static Node newLabelNode(NeoModel db, String name, Node domainNode) {
      final Node newNode = db.newNode(LABELS.LABEL);
      newNode.setProperty("name", name);

      domainNode.createRelationshipTo(newNode, LABEL);
      return newNode;
   }

}