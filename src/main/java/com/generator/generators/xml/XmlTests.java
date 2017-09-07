package com.generator.generators.xml;

import com.generator.generators.xml.parser.XMLBaseListener;
import com.generator.generators.xml.parser.XMLLexer;
import com.generator.generators.xml.parser.XMLParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Test;

import java.io.IOException;

public class XmlTests {

	@Test
	public void testXMLParser() throws IOException {
		final XMLParser parser = new XMLParser(new CommonTokenStream(new XMLLexer(CharStreams.fromFileName("/home/goe/projects/nextgen/pom.xml"))));

		final XMLBaseListener listener = new XMLBaseListener();
		new ParseTreeWalker().walk(listener, parser.document());
		visit("", listener.getRoot());
	}

	private void visit(String delim, XMLBaseListener.Node node) {
		System.out.println(delim + node.name + " (" + node.value + ")");
		for (XMLBaseListener.Node child : node.children) {
			visit(delim + "\t", child);
		}
	}

	@Test
	public void testXMLGenerator() {

		final XMLGroup xmlGroup = new XMLGroup();
		System.out.println(xmlGroup.newdocument().
				setContent(xmlGroup.
						newelement().
						setName("project").
						addAttributesValue("xmlns","http://maven.apache.org/POM/4.0.0")));

	}
}