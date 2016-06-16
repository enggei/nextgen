 package com.generator.generators.easyFlow;
import org.junit.Test;

public class EasyFlowTests {

    @Test
   public void testEasyFlowGroup() {

      System.setProperty("generator.path", "src/main/java/com/generator/generators");
      final EasyFlowGroup group = new EasyFlowGroup();

   	// todo add EasyFlowGroup- tests here;

		 EasyFlowGroup.easyFlowST easyFlowST = group.neweasyFlow();

		 addBinding(group, easyFlowST, "STATE1", "XXX");
		 addBinding(group, easyFlowST, "STATE2", "YYY");
		 addBinding(group, easyFlowST, "STATE3", "ZZZ");
		 System.out.println(easyFlowST);
	 }

	private static void addBinding(EasyFlowGroup group, EasyFlowGroup.easyFlowST easyFlowST, String state1, String yyy) {
		EasyFlowGroup.declarationST declaration_ = group.newdeclaration().setName(state1).setState(yyy);
		EasyFlowGroup.implST impl_ = group.newimpl().setName(state1).setState(yyy);
		easyFlowST.addBindingsValue(declaration_, impl_);
	}

	;

    @Test
   public void testEasyFlowNeo() {

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