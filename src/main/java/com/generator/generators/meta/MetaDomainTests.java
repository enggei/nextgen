package com.generator.generators.meta;

import com.generator.editors.NeoModel;
import com.generator.editors.canvas.neo.NeoEditor;
import org.junit.Test;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;

/**
 * Created 27.03.17.
 */
public class MetaDomainTests {

   static {
      System.setProperty("generator.path", "src/main/java/com/generator/generators");
   }

   @Test
   public void programmaticallyCreateDomain() {

      final NeoModel neoModel = NeoEditor.newEmbeddedDatabase("/home/goe/dbMetaTest");

      neoModel.doInTransaction(new NeoModel.Committer() {
         @Override
         public void doAction(Transaction tx) throws Throwable {
            final Node domainNode = neoModel.newNode(MetaDomain.Entities.Domain,
                  MetaDomain.Properties.name.name(), "JavaParserDomain",
                  MetaDomain.Properties.packageName.name(), "com.nextgen.meta",
                  MetaDomain.Properties.root.name(), "/home/goe/projects/nextgen/src/test/java");

            final Node packageNode = neoModel.newNode(MetaDomain.Entities.Entity, MetaDomain.Properties.name.name(), "Package", MetaDomain.Properties.color.name(), "#a6cee3");
            final Node classNode = neoModel.newNode(MetaDomain.Entities.Entity, MetaDomain.Properties.name.name(), "Class", MetaDomain.Properties.color.name(), "#1f78b4");
            final Node fieldNode = neoModel.newNode(MetaDomain.Entities.Entity, MetaDomain.Properties.name.name(), "Field", MetaDomain.Properties.color.name(), "#b2df8a");

            final Node packageMember = neoModel.newNode(MetaDomain.Entities.Relation, MetaDomain.Properties.name.name(), "MEMBER");
            packageMember.createRelationshipTo(packageNode, MetaDomain.Relations.SRC);
            packageMember.createRelationshipTo(classNode, MetaDomain.Relations.DST);

            final Node classField = neoModel.newNode(MetaDomain.Entities.Relation, MetaDomain.Properties.name.name(), "FIELD");
            classField.createRelationshipTo(classNode, MetaDomain.Relations.SRC);
            classField.createRelationshipTo(fieldNode, MetaDomain.Relations.DST);

            domainNode.createRelationshipTo(packageNode, MetaDomain.Relations.ENTITY);
            domainNode.createRelationshipTo(classNode, MetaDomain.Relations.ENTITY);
            domainNode.createRelationshipTo(fieldNode, MetaDomain.Relations.ENTITY);

            domainNode.createRelationshipTo(packageMember, MetaDomain.Relations.RELATION);
            domainNode.createRelationshipTo(classField, MetaDomain.Relations.RELATION);

         }

         @Override
         public void exception(Throwable throwable) {

         }
      });
   }
}