package com.generator.generators.stringtemplate;

import org.junit.Test;

import java.io.IOException;

import static com.generator.generators.stringtemplate.StringTemplatePlugin.escape;

/**
 * Created 07.09.17.
 */
public class Tests {

   @Test
   public void testTemplateGroupGroup() {

      final TemplateGroupGroup templateGroupGroup = new TemplateGroupGroup();


      // must close template with >> because of stringtemplate-issue
      System.out.println(templateGroupGroup.newstg().
            setDelimiter("~").
            addTemplatesValue(templateGroupGroup.newtemplate().
                  setName("enum").
                  addParamsValue("comments").
                  addParamsValue("name").
                  addParamsValue("properties").setContent("~if(comments)~\n" +
                  "//~comments~\n" +
                  "~endif~\n" +
                  "enum ~name~ {\n" +
                  "\t~properties:{it|~it;format=\"humpToCap\"~ = ~i~;}; separator=\"\\n\"~\n" +
                  "} \n>>")));

   }

   @Test
   public void teSTGParser() throws IOException {

      // todo STGParser from g4 grammars not working... why ?

      final String[] filenames = new String[]{
            "/home/goe/projects/nextgen/src/main/java/com/generator/generators/cypher/cypher.stg",
      };

//      for (String fileName : filenames) {
////         final STGParser parserg4 = new STGParser(new CommonTokenStream(new STLexer(CharStreams.fromFileName(fileName, Charset.forName("UTF-8")))));
//         final STGParser parser = new STGParser(new CommonTokenStream(new STLexer(CharStreams.fromString("delimiters \"~\",\"~\"\n" +
//               "\n" +
//               "eom() ::= <<}>>"))));
//
//         final STGBaseListener listener = new STGBaseListener();
//         new ParseTreeWalker().walk(listener, parser.group());
//
//         visitAll("", listener.getRoot());
//      }
   }

//   private void visitAll(String delim, STGBaseListener.Node node) {
//      System.out.println(delim + node.name + " (" + node.startToken + ")");
//      for (STGBaseListener.Node child : node.children) {
//         visitAll(delim + "\t", child);
//      }
//   }
}