package com.generator.generators.maven;

import org.junit.Test;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Tests {
   private final static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(Tests.class);
   //@Test
   public void testMaven() {

      final MavenGroup mavenGroup = new MavenGroup();

      final MavenGroup.PomST pomST = mavenGroup.newPom().
            setArtifactId("artifactId").
            setGroupId("groupId").
            setVersion("version").
            setName("MyProject");

      log.info(pomST.toString());
   }

   ;

   //@Test
   public void testXMLDependencies() throws IOException, SAXException, ParserConfigurationException {

      final String xml = "<dependency>\n" +
            "            <groupId>commons-lang</groupId>\n" +
            "            <artifactId>commons-lang</artifactId>\n" +
            "            <version>2.6</version>\n" +
            "        </dependency>\n" +
            "        <dependency>\n" +
            "            <groupId>log4j</groupId>\n" +
            "            <artifactId>log4j</artifactId>\n" +
            "            <version>1.2.16</version>\n" +
            "        </dependency>\n" +
            "        <dependency>\n" +
            "            <groupId>org.apache.poi</groupId>\n" +
            "            <artifactId>poi</artifactId>\n" +
            "            <version>3.6</version>\n" +
            "        </dependency>\n" +
            "        <dependency>\n" +
            "            <groupId>javax.mail</groupId>\n" +
            "            <artifactId>mail</artifactId>\n" +
            "            <version>1.4</version>\n" +
            "        </dependency>\n" +
            "        <dependency>\n" +
            "            <groupId>javax.activation</groupId>\n" +
            "            <artifactId>activation</artifactId>\n" +
            "            <version>1.1.1</version>\n" +
            "        </dependency>\n" +
            "        <dependency>\n" +
            "            <groupId>com.fasterxml.jackson.core</groupId>\n" +
            "            <artifactId>jackson-databind</artifactId>\n" +
            "            <version>2.2.0</version>\n" +
            "        </dependency>";

      final Element dependenciesElement = MavenPlugin.parseXml("<dependencies>" + xml + "</dependencies>");
      final NodeList dependencyElements = dependenciesElement.getChildNodes();
      for (int i = 0; i < dependencyElements.getLength(); i++) {
         final Node dependencyNode = dependencyElements.item(i);
         switch (dependencyNode.getNodeType()) {

            case org.w3c.dom.Node.ELEMENT_NODE: {
               final Element childElement = (Element)dependencyNode;
               final NodeList dependencyChildren = childElement.getChildNodes();
               final Map<String, String> dependencyKeyValues = new HashMap<>();
               for (int j = 0; j < dependencyChildren.getLength(); j++) {

                  final org.w3c.dom.Node child = dependencyChildren.item(j);
                  switch (child.getNodeType()) {
                     case org.w3c.dom.Node.ELEMENT_NODE: {
                        final String tagName = ((Element)child).getTagName();
                        final String tagValue = child.getTextContent();
                        dependencyKeyValues.put(tagName, tagValue);
                        break;
                     }
                  }
               }

               for (Map.Entry<String, String> entry : dependencyKeyValues.entrySet()) {
                  log.info(entry.getKey() + " = " + entry.getValue());
               }

               break;
            }
         }
      }
   }
}