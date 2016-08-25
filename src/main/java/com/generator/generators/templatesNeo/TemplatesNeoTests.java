package com.generator.generators.templatesNeo;

import org.junit.Test;
import org.neo4j.graphdb.Node;

import java.io.File;
import java.util.function.Consumer;

import static com.generator.generators.templatesNeo.TemplatesNeoNeo.*;

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

				final TemplatesNeoNeo neoTemplateDomain = new TemplatesNeoNeo(db);

				final NeoGroupClassDeclarationNode neoGroupClassDeclarationNode = neoTemplateDomain.newNeoGroupClassDeclaration();

				neoGroupClassDeclarationNode.
					setName(neoTemplateDomain.newStringNode("Simple")).	// string-node
					setPackageName(neoTemplateDomain.newStringNode("com.generator.simple"));

				// key-value node
				neoGroupClassDeclarationNode.addStatementsValue(
					neoTemplateDomain.newDeclaration().                             	// statement-node
						setGroupName(neoTemplateDomain.newStringNode("GroupName")).
						setName(neoTemplateDomain.newStringNode("Name")).node(),
					neoTemplateDomain.newStringNode("targetName"),							// string-node
					neoTemplateDomain.newNewInstance().											// value-node
						setGroupName(neoTemplateDomain.newStringNode("GroupName")).
						setName(neoTemplateDomain.newStringNode("Name")).node());

				// list node
				neoGroupClassDeclarationNode.
					addCommentsValue(neoTemplateDomain.newStringNode("StringComment")).
					addCommentsValue(neoTemplateDomain.newBugfix2().node());               // statement element

				neoTemplateDomain.forEachNeoGroupClassDeclarationNodes(neoGroupClassDeclarationNode1 -> {

					if(neoGroupClassDeclarationNode1.getPackageName()==null || neoGroupClassDeclarationNode1.getName()==null) {
						neoGroupClassDeclarationNode1.removeName();

						neoGroupClassDeclarationNode1.delete();
						return;
					}

					// stringvalues
					System.out.println(newStringNode(neoGroupClassDeclarationNode1.getName())+ " package name : " + newStringNode(neoGroupClassDeclarationNode1.getPackageName()));

					neoGroupClassDeclarationNode1.removePackageName();

					// list values
					neoGroupClassDeclarationNode1.forEachComments(node -> {

						if (isStringNode(node))
							System.out.println("String node: " + newStringNode(node).getValue());
						else if (isBugfix2(node))
							System.out.println("bugfix2: " + neoTemplateDomain.newBugfix2(node).getUuid());
						else
							System.out.println("other: " + newStringNode(node).getValue());
					});

					// key-value list

					neoGroupClassDeclarationNode1.forEachStatementsValue(new Consumer<NeoGroupClassDeclarationNode.StatementsKeyValue>() {
						@Override
						public void accept(NeoGroupClassDeclarationNode.StatementsKeyValue statementsKeyValue) {
							final Node declarationValue = statementsKeyValue.getDeclarationValue();
							if(isDeclaration(declarationValue)) {
								final Node declarationName = neoTemplateDomain.newDeclaration(declarationValue).getName();
								if(isStringNode(declarationName)) System.out.println("Declaration.name stringvalue: " + newStringNode(declarationName));
								else System.out.println("Declaration.name other: " + declarationName.getLabels());
							}
						}
					});
				});

				//neoTemplateDomain.forEachNeoGroupClassDeclarationNodes(node -> System.out.println(node + " : " + node.getPackageName() + " " + " " + node.getName()));
			}

			@Override
			public void exception(Throwable throwable) {
				throw new RuntimeException(throwable);
			}
		});
	}


}