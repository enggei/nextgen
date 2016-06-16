package com.generator.generators.knockout;

import org.junit.Test;

public class KnockoutTests {

	@Test
	public void testKnockoutGroup() {

		System.setProperty("generator.path", "src/main/java/com/generator/generators");
		final KnockoutGroup group = new KnockoutGroup();

		// todo add KnockoutGroup- tests here;
		System.out.println(group.newobservable().setInit("test").setReference("reference"));
	}

	@Test
	public void testKnockoutNeo() {

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
	}

	;
} 