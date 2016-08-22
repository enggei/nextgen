 package com.generator.generators.generatorDomain;
import org.junit.Test;

import java.io.File;

 public class GeneratorDomainTests {

    @Test
   public void testGeneratorDomainGroup() {

      System.setProperty("generator.path", "src/main/java/com/generator/generators");
      final GeneratorDomainGroup group = new GeneratorDomainGroup();

   	// todo add GeneratorDomainGroup- tests here;


   } ;

    @Test
   public void testGeneratorDomainNeo() {

   	final org.neo4j.graphdb.GraphDatabaseService db = new org.neo4j.graphdb.factory.GraphDatabaseFactory().newEmbeddedDatabase(new File("src/test/tests/db"));
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