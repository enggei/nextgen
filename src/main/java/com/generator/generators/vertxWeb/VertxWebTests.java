 package com.generator.generators.vertxWeb;
import org.junit.Test;

public class VertxWebTests {

    @Test
   public void testVertxWebGroup() {

      System.setProperty("generator.path", "src/main/java/com/generator/generators");
      final VertxWebGroup group = new VertxWebGroup();

   	// todo add VertxWebGroup- tests here;


   } ;

    @Test
   public void testVertxWebNeo() {

   	final org.neo4j.graphdb.GraphDatabaseService db = new org.neo4j.graphdb.factory.GraphDatabaseFactory().newEmbeddedDatabase("src/test/tests/db");
   	final com.generator.editors.domain.NeoModel model = new com.generator.editors.domain.NeoModel(db);

   	model.doInTransaction(new com.generator.editors.domain.NeoModel.Committer() {
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