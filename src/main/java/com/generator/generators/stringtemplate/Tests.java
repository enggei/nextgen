package com.generator.generators.stringtemplate;

import com.generator.generators.stringtemplate.parser.STGBaseListener;
import com.generator.generators.stringtemplate.parser.STGParser;
import com.generator.generators.stringtemplate.parser.STLexer;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Test;

import java.io.IOException;

/**
 * Created 07.09.17.
 */
public class Tests {

   @Test
   public void testTemplateGroupGroup() {

      final TemplateGroupGroup templateGroupGroup = new TemplateGroupGroup();

      System.out.println(templateGroupGroup.newstg().
            addTemplatesValue(templateGroupGroup.newtemplate().
                  setName("enum").
                  addParamsValue("comments").
                  addParamsValue("name").
                  addParamsValue("properties").setContent("~if(comments)~\n" +
                  "//~comments~\n" +
                  "~endif~\n" +
                  "enum ~name~ {\n" +
                  "\t~properties:{it|~it;format=\"humpToCap\"~ = ~i~;}; separator=\"\\n\"~\n" +
                  "} \n")));

   }

   @Test
   public void teSTGParser() throws IOException {

      // todo STGParser from g4 grammars not working... why ?

      final String[] filenames = new String[]{
            "/home/goe/projects/nextgen/src/main/java/com/generator/generators/cypher/cypher.stg",
      };

      for (String fileName : filenames) {
//         final STGParser parser = new STGParser(new CommonTokenStream(new STLexer(CharStreams.fromFileName(fileName, Charset.forName("UTF-8")))));
         final STGParser parser = new STGParser(new CommonTokenStream(new STLexer(CharStreams.fromString("delimiters \"~\",\"~\"\n" +
               "\n" +
               "eom() ::= <<}>>"))));

         final STGBaseListener listener = new STGBaseListener();
         new ParseTreeWalker().walk(listener, parser.group());

         visitAll("", listener.getRoot());
      }
   }

   private void visitAll(String delim, STGBaseListener.Node node) {
      System.out.println(delim + node.name + " (" + node.startToken + ")");
      for (STGBaseListener.Node child : node.children) {
         visitAll(delim + "\t", child);
      }
   }
}