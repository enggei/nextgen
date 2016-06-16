package com.generator.generators.javascript;

import org.junit.Test;

public class JavascriptTests {

	@Test
	public void testJavascriptGroup() {

		System.setProperty("generator.path", "src/main/java/com/generator/generators");
		final JavascriptGroup group = new JavascriptGroup();

		// todo add JavascriptGroup- tests here;
		System.out.println(group.newfunction().
			setName("getTree").
			addStatementsValue("var tree = [\n" +
				"  {\n" +
				"    text: \"Parent 1\",\n" +
				"    nodes: [\n" +
				"      {\n" +
				"        text: \"Child 1\",\n" +
				"        nodes: [\n" +
				"          {\n" +
				"            text: \"Grandchild 1\"\n" +
				"          },\n" +
				"          {\n" +
				"            text: \"Grandchild 2\"\n" +
				"          }\n" +
				"        ]\n" +
				"      },\n" +
				"      {\n" +
				"        text: \"Child 2\"\n" +
				"      }\n" +
				"    ]\n" +
				"  },\n" +
				"  {\n" +
				"    text: \"Parent 2\"\n" +
				"  },\n" +
				"  {\n" +
				"    text: \"Parent 3\"\n" +
				"  },\n" +
				"  {\n" +
				"    text: \"Parent 4\"\n" +
				"  },\n" +
				"  {\n" +
				"    text: \"Parent 5\"\n" +
				"  }\n" +
				"];").
			addStatementsValue("return tree"));

	}

	;

	@Test
	public void testJavascriptNeo() {

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