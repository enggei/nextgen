package com.generator.generators.templatesSwing;

import com.generator.util.FileUtil;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class TemplatesSwingTests {

	@Test
	public void testTemplatesSwingGroup() throws IOException {

		System.setProperty("generator.path", "src/main/java/com/generator/generators");
		final TemplatesSwingGroup group = new TemplatesSwingGroup();

		// add this as generator, when completed:
		String groupName = "TemplatesNeo";
		String packageName = "com.generator.generators.templatesNeo";
		final TemplatesSwingGroup.TemplatesSwingST swingST = group.newTemplatesSwing().setPackageName(packageName).setGroupName(groupName);

		swingST.addStatementsValue("NeoGroupClassDeclaration",group.newnewAction().setGroupName(groupName).setName("NeoGroupClassDeclaration"));

		FileUtil.writeFile(swingST, new File("/media/storage/nextgen/src/main/java/com/generator/generators/templatesNeo/TemplatesNeoSwing.java"));

	}

	;

	@Test
	public void testTemplatesSwingNeo() {

		final org.neo4j.graphdb.GraphDatabaseService db = new org.neo4j.graphdb.factory.GraphDatabaseFactory().newEmbeddedDatabase(new java.io.File("src/test/tests/db"));
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