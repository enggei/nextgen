 package com.generator.generators.webapp;
import com.generator.editors.NeoModel;
import org.junit.Test;

public class WebappTests {

    @Test
   public void testWebappGroup() {

      System.setProperty("generator.path", "src/main/java/com/generator/generators");
      final WebappGroup group = new WebappGroup();

   	// todo add WebappGroup- tests here;
		 System.out.println(group.newappHtml().setAppname("T E S T"));
		 System.out.println(group.newappJs().setAppname("T E S T"));

		 System.out.println(group.newshellJs());
		 System.out.println(group.newshellHtml());

   } ;

    @Test
   public void testWebappNeo() {

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