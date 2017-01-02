 package com.generator.generators.templatesSwing;
import com.generator.editors.NeoModel;
import org.junit.Test;

public class TemplatesSwingTests {

    @Test
   public void testTemplatesSwingGroup() {

      System.setProperty("generator.path", "src/main/java/com/generator/generators");
      final TemplatesSwingGroup group = new TemplatesSwingGroup();

   	// todo add TemplatesSwingGroup- tests here;


   } ;

    @Test
   public void testTemplatesSwingNeo() {

   	final org.neo4j.graphdb.GraphDatabaseService db = new org.neo4j.graphdb.factory.GraphDatabaseFactory().newEmbeddedDatabase(new java.io.File("src/test/tests/db"));
   	final NeoModel model = new NeoModel(db);

   	model.doInTransaction(new NeoModel.Committer() {
   		@Override
   		public void doAction(org.neo4j.graphdb.Transaction tx) throws Throwable {
   		}

   		@Override
   		public void exception(Throwable throwable) {
   			throw new RuntimeException(throwable);
   		}
   	});
   } ;
} 