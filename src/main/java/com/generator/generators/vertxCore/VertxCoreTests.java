 package com.generator.generators.vertxCore;
import com.generator.editors.NeoModel;
import org.junit.Test;

public class VertxCoreTests {

    @Test
   public void testVertxCoreGroup() {

      System.setProperty("generator.path", "src/main/java/com/generator/generators");
      final VertxCoreGroup group = new VertxCoreGroup();

   	// todo add VertxCoreGroup- tests here;


   } ;

    @Test
   public void testVertxCoreNeo() {

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