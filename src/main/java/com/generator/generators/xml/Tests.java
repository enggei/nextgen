package com.generator.generators.xml;

import com.generator.generators.xml.parser.XMLLexer;
import com.generator.generators.xml.parser.XMLParser;
import com.generator.generators.xml.parser.XMLParserNodeListener;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Test;

import java.io.IOException;

public class Tests {

   @Test
   public void testXMLParser() throws IOException {
      final XMLParser parser = new XMLParser(new CommonTokenStream(new XMLLexer(CharStreams.fromFileName("pom.xml"))));

      final XMLParserNodeListener listener = new XMLParserNodeListener();
      new ParseTreeWalker().walk(listener, parser.document());
      visit("", listener.getRoot());
   }

   private void visit(String delim, XMLParserNodeListener.Node node) {
      System.out.println(delim + node.name + " (" + node.value + ")");
      for (XMLParserNodeListener.Node child : node.children) {
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
                  addAttributesValue("xmlns", "http://maven.apache.org/POM/4.0.0").
                  addAttributesValue("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance").
                  addAttributesValue("xsi:schemaLocation", "http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd").
                  addChildrenValue(xmlGroup.newelement().
                        setName("modelVersion").
                        addChildrenValue("4.0.0")).
                  addChildrenValue(xmlGroup.newelement().
                        setName("groupId").
                        addChildrenValue("com.nextgen"))));

   }
}