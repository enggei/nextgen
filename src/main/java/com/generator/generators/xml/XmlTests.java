package com.generator.generators.xml;

import com.generator.generators.xml.parser.XMLLexer;
import com.generator.generators.xml.parser.XMLParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static com.generator.util.FileUtil.write;

public class XmlTests {

	@Test
	public void testXMLParser() throws IOException {
		final ANTLRInputStream input = new ANTLRInputStream(new FileReader("src/main/java/com/generator/generators/xml/test.xml"));
		final XMLLexer lexer = new XMLLexer(input);
		CommonTokenStream tokenStream = new CommonTokenStream(lexer);
		XMLParser parser = new XMLParser(tokenStream);
		final XMLParser.DocumentContext documentContext = parser.document();
		System.out.println(documentContext.toStringTree());
	}

	@Test
	public void testXmlGroup() {

		System.setProperty("generator.path", "src/main/java/com/generator/generators");
		final XmlGroup group = new XmlGroup();

		final XmlGroup.fileST fileST = group.newfile().
			setEncoding("UTF-8").
			setVersion("1.0").
			setRoot(
				group.newtag().
					setName("VolumeIndex").
					addAttributesValue(
						group.newattribute().
							setName("xmlns").
							setValue("http://www.digicine.com/PROTO-ASDCP-VL-20040311#")
					).addElementsValue(
						group.newtag().
							setName("Index").
							setContents("1")
				)
			);

		write(fileST, new File("src/main/java/com/generator/generators/xml/" + File.separator + "test.xml"));
	}

	@Test
	public void testXmlNeo() {

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
}