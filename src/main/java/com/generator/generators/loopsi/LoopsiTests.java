package com.generator.generators.loopsi;

import com.generator.editors.NeoModel;
import org.junit.Test;

public class LoopsiTests {

	@Test
	public void testLoopsiGroup() {

		System.setProperty("generator.path", "src/main/java/com/generator/generators");
		final LoopsiGroup group = new LoopsiGroup();

		// todo add LoopsiGroup- tests here;

		final String packageName = "com.udc.loopsi.api";
		final String name = "BaseGameAPI";

	}

	@Test
	public void testLoopsiNeo() {

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
	}

	;
} 