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

//   @Test
//   public void testStatementAndRender() throws IOException {
//      final TemplateGroupGroup group = new TemplateGroupGroup();
//
//      final TemplateGroupGroup.templateST templateST = group.newtemplate().
//            setName("Test").
//            addParamsValue("package").
//            addParamsValue("name").
//            addParamsValue("elements").
//            setContent("package ~package~;\n" +
//                  "\n" +
//                  "public class ~name~ {\n" +
//                  "\n" +
//                  "   ~elements:{it|private ~it.type~ ~it.name~~if(it.init)~ = ~it.init~~endif~;};separator=\"\n\"~\n" +
//                  "\n" +
//                  "}");
//
//      final TemplateFile templateFile = TemplateFileParser.parseStatement("~", templateST.toString(), new STErrorListener() {
//         @Override
//         public void compileTimeError(STMessage stMessage) {
//            if (stMessage instanceof STCompiletimeMessage) {
//               final Token token = ((STCompiletimeMessage) stMessage).token;
//               System.out.println(token);
//            }
//         }
//
//         @Override
//         public void runTimeError(STMessage stMessage) {
//         }
//
//         @Override
//         public void IOError(STMessage stMessage) {
//         }
//
//         @Override
//         public void internalError(STMessage stMessage) {
//         }
//      });
//
//      final Statement statement = new Statement("Test");
//      statement.add(new StringProperty("package", "PACKAGE"));
//      List<List<Property>> kvProperties = new ArrayList<>();
//      kvProperties.add(createProperty("Integer", "id", null));
//      kvProperties.add(createProperty("String", "name", "TEST"));
//      statement.add(new KeyValueListProperty("elements", kvProperties));
//
//      final String render = templateFile.render(statement);
//      System.out.println(render);
//   }
//
//   @NotNull
//   public static List<Property> createProperty(String type, String name, String init) {
//      final List<Property> kvProperty = new ArrayList<>();
//      kvProperty.add(new StringProperty("type", type));
//      kvProperty.add(new StringProperty("name", name));
//      kvProperty.add(new StringProperty("init", init));
//      return kvProperty;
//   }

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
            setDelimiter("%").
            addTemplatesValue(templateGroupGroup.newtemplate().
                  setName("hello").
                  setContent("Hello %name%!").
                  addParamsValue("name"));
      System.out.println(stgST);

      final STGParser parser = new STGParser(new CommonTokenStream(new STGLexer(CharStreams.fromString(stgST.toString()))));
      final STGParserBaseListener listener = new STGParserBaseListener();
      new ParseTreeWalker().walk(listener, parser.group());
   }

   @Test
   public void testSTParser() throws IOException {

      final TemplateGroupGroup templateGroupGroup = new TemplateGroupGroup();

      final String content = " Hello ~name~! ~elements:{it|~it.name~};~";

      final TemplateGroupGroup.templateST templateST = templateGroupGroup.newtemplate().
            setName("hello");

      final STParser parser = new STParser(new CommonTokenStream(new STLexer(CharStreams.fromString(content))));
      final STParserNodeListener listener = new STParserNodeListener(true) {
         @Override
         public void enterSingleElement(STParser.SingleElementContext arg) {
            super.enterSingleElement(arg);
            templateST.addParamsValue(arg.getText());
         }
      };
      new ParseTreeWalker().walk(listener, parser.template());

      System.out.println(templateST.setContent(content));
   }
}