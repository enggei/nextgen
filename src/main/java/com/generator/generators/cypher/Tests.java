package com.generator.generators.cypher;

import com.generator.generators.cypher.parser.CypherLexer;
import com.generator.generators.cypher.parser.CypherNodeListener;
import com.generator.generators.cypher.parser.CypherParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Test;

public class Tests {


   @Test
   public void testParser() {
      final CypherParser parser = new CypherParser(new CommonTokenStream(new CypherLexer(CharStreams.fromString("MATCH (node1:Label1)-->(node2:Label2)\n" +
            "WHERE node1.propertyA = {value}\n" +
            "RETURN node2.propertyA, node2.propertyB"))));
      final CypherNodeListener listener = new CypherNodeListener(true);
      new ParseTreeWalker().walk(listener, parser.cypher());

   }

   @Test
   public void testCypher() {

      final CypherGroup group = new CypherGroup();

      System.out.println(group.newcreateNode().
            setId("ID").
            addLabelsValue("Entities"));

      System.out.println(
            group.newcreateNodes().
                  addNodesValue(group.newstringProperty().
                        setValue("VALUE").
                        setName("NAME")));

   }
}