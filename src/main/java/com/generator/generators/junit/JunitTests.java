package com.generator.generators.junit;

import org.junit.Test;

import java.io.File;

public class JunitTests {

	public static void main(String[] args) {
		new JunitTests().testJunitGroup();
	}

	@Test
	public void testJunitGroup() {

		System.setProperty("generator.path", "src/main/java/com/generator/generators");
		final JunitGroup group = new JunitGroup();

		// todo add JunitGroup- tests here;
		System.out.println(group.
			newtests().
			addTestsValue(group.newtest().
				setName("TestONE").
				addStatementsValue("System.out.println(\"TEST ONE\");")));

	}

	;

	@Test
	public void testJunitNeo() {

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
	}

	;
} 