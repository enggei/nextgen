package com.generator.generators.templatesNeo;

import org.junit.Test;

import java.io.File;

public class TemplatesNeoTests {

	static {
		System.setProperty("generator.path", "src/main/java/com/generator/generators");
	}

	final TemplatesNeoGroup group = new TemplatesNeoGroup();

	@Test
	public void testTemplatesNeoGroup() {
		// todo add TemplatesNeoGroup- tests here;
	}

	;

	@Test
	public void testTemplatesNeoNeo() {

		final org.neo4j.graphdb.GraphDatabaseService db = new org.neo4j.graphdb.factory.GraphDatabaseFactory().newEmbeddedDatabase(new File("src/test/tests/db"));
		final com.generator.editors.domain.NeoModel model = new com.generator.editors.domain.NeoModel(db);

		model.doInTransaction(new com.generator.editors.domain.NeoModel.Committer() {
			@Override
			public void doAction(org.neo4j.graphdb.Transaction tx) throws Throwable {


				final TemplatesNeoNeo neoTemplateDomain = new TemplatesNeoNeo(model);
				final TemplatesNeoGroup templatesNeoGroup = new TemplatesNeoGroup();

// add group
				final TemplatesNeoNeo.NeoGroupClassDeclarationNode neoGroupClassDeclarationNode = neoTemplateDomain.newNeoGroupClassDeclaration().
					setDomain("DOMAIN").
					setName("NAME").
					setPackageName("PACKAGE");

				final TemplatesNeoGroup.declarationST declaration_ = templatesNeoGroup.newdeclaration().
					setName("DECLARATION").
					addPropertiesValue("PROP", neoTemplateDomain.newstringSetter().
						setPropertyName("PROP").
						setStatementName("STMTNAME").toString());

				final TemplatesNeoNeo.newInstanceNode newInstance_ = neoTemplateDomain.newnewInstance().
					setName("INSTANCE");

				neoGroupClassDeclarationNode.addStatementsValue(declaration_.toString(), newInstance_.toString());

				final TemplatesNeoNeo.keyValueListSetterNode keyValueListSetterNode = neoTemplateDomain.newkeyValueListSetter().
					setGroupName("GROUP").
					setPropertyName("PROPERTY").
					setStatementName("STATEMENT").
					addKvNamesValue("VALONE").
					addKvNamesValue("VALTWO");

				final TemplatesNeoGroup.keyValueListSetterST keyValueListSetterST = group.newkeyValueListSetter();
				keyValueListSetterNode.fill(keyValueListSetterST);
				System.out.println(keyValueListSetterST);

				// get group class declaration from database:
				final TemplatesNeoNeo.NeoGroupClassDeclarationNode neoGroupClassDeclaration = neoTemplateDomain.getNeoGroupClassDeclaration(neoGroupClassDeclarationNode.getUUID());

				final TemplatesNeoGroup.NeoGroupClassDeclarationST neoGroupClassDeclarationST = templatesNeoGroup.newNeoGroupClassDeclaration();
				neoGroupClassDeclarationNode.fill(neoGroupClassDeclarationST);

				System.out.println(neoGroupClassDeclarationST);

			}

			@Override
			public void exception(Throwable throwable) {
				throw new RuntimeException(throwable);
			}
		});
	}

	;
} 