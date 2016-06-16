package com.generator.generators.templateGroup;

import org.junit.Test;

public class TemplateGroupTests {

	@Test
	public void testTemplateGroupGroup() {

		System.setProperty("generator.path", "src/main/java/com/generator/generators");
		final TemplateGroupGroup group = new TemplateGroupGroup();

		// todo add TemplateGroupGroup- tests here;

		System.out.println(group.newGroupClassDeclaration().
			setName("Name").
			setDomain("Domain").
			setPackageName("com.test.gen"));
	}

	@Test
	public void testTemplateGroupNeo() {

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
}