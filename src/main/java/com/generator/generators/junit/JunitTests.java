package com.generator.generators.junit;

import com.generator.editors.NeoModel;
import org.junit.Test;

import java.io.File;

public class JunitTests {

	static {
		System.setProperty("generator.path", "src/main/java/com/generator/generators");
	}

	@Test
	public void testJunitGroup() {

		final JunitGroup group = new JunitGroup();

		// todo add JunitGroup- tests here;
		System.out.println(group.
			newtests().setPackageName("packageName").
			addTestsValue(group.newtest().
				setName("TestONE").
				addStatementsValue("System.out.println(\"TEST ONE\");")));

	}

	;

	@Test
	public void testJunitNeo() {

		final org.neo4j.graphdb.GraphDatabaseService db = new org.neo4j.graphdb.factory.GraphDatabaseFactory().newEmbeddedDatabase(new File("src/test/tests/db"));
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
	}

	;
} 