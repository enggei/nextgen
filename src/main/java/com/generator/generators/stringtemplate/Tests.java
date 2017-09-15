package com.generator.generators.stringtemplate;

import com.generator.generators.stringtemplate.parserg4.*;
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
   public void testTemplateGroupGroup() throws IOException {

      final TemplateGroupGroup templateGroupGroup = new TemplateGroupGroup();

      // create an STG-document, using TemplateGroupGroup
      final TemplateGroupGroup.templateST templateST = templateGroupGroup.newtemplate().
            setName("enum").
            addParamsValue("comments").
            addParamsValue("name").
            addParamsValue("properties").
            setContent("~if(comments)~\n" +
                  "//~comments~\n" +
                  "~endif~\n" +
                  "enum ~name~ {\n" +
                  "\t~properties:{it|~it;format=\"humpToCap\"~ = ~i~;}; separator=\"\\n\"~\n" +
                  "}");
      final TemplateGroupGroup.stgST x = templateGroupGroup.newstg().
            setDelimiter("~").
            addTemplatesValue(templateST);
      System.out.println(x);
   }

   @Test
   public void teSTGParser() throws IOException {

      // todo STGParser from g4 grammars not working... why ?
      final TemplateGroupGroup templateGroupGroup = new TemplateGroupGroup();

      final TemplateGroupGroup.stgST stgST = templateGroupGroup.newstg().
            setDelimiter("~").
            addTemplatesValue(templateGroupGroup.newtemplate().
                  setName("hello").
                  setContent("Hello ~name~!").
                  addParamsValue("name"));
      System.out.println(stgST);

      final STGParser parser = new STGParser(new CommonTokenStream(new STGLexer(CharStreams.fromString(stgST.toString()))));
      final STGParserBaseListener listener = new STGParserBaseListener();
      new ParseTreeWalker().walk(listener, parser.group());
   }

   @Test
   public void testSTParser() throws IOException {

      final TemplateGroupGroup templateGroupGroup = new TemplateGroupGroup();

      final TemplateGroupGroup.templateST templateST = templateGroupGroup.newtemplate().
            setName("hello").
            setContent(" Hello ~name~! ").
            addParamsValue("name");
      System.out.println(templateST);

      final STParser parser = new STParser(new CommonTokenStream(new STLexer(CharStreams.fromString(templateST.toString()))));
      final STParserBaseListener listener = new STParserBaseListener();
      new ParseTreeWalker().walk(listener, parser.template());
   }
}