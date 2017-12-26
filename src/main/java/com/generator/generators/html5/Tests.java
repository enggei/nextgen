package com.generator.generators.html5;

import com.generator.ProjectConstants;
import com.generator.generators.html5.parser.HTMLLexer;
import com.generator.generators.html5.parser.HTMLParser;
import com.generator.generators.html5.parser.HTMLParserNodeListener;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static com.generator.util.FileUtil.write;

public class Tests {
   private final static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(Tests.class);

   //@Test
   public void testParser() throws IOException {
      final HTMLParser parser = new HTMLParser(new CommonTokenStream(new HTMLLexer(CharStreams.fromFileName(ProjectConstants.MAIN_ROOT + "/com/generator/generators/html5/example.html"))));

      final HTMLParserNodeListener listener = new HTMLParserNodeListener();
      new ParseTreeWalker().walk(listener, parser.htmlDocument());

      visitAll("", listener.getRoot());
   }

   private void visitAll(String delim, HTMLParserNodeListener.Node node) {
      log.info(delim + node.name + " (" + node.startToken + ")");
      for (HTMLParserNodeListener.Node child : node.children) {
         visitAll(delim + "\t", child);
      }
   }


   //@Test
   public void testHtml5Group() {

      final Html5Group group = new Html5Group();

      write(group.newpage().
                  setHead(group.newhead().
                        addContentValue(group.newlink().setRel("stylesheet").setType("text/css").setHref("mystyle.css")).
                        addContentValue(group.newscript().setType("text/css"))).
                  setBody(group.newbody().
                        addContentValue(group.newa().setHref("www.vg.no").setId("VG").setAccesskey("h").setAccesskey("V")).
                        addContentValue(group.newabbr().setTitle("TITLE")).
                        addContentValue(group.newcomment().setComment("This is a comment")).
                        addContentValue(group.newaddress().setTitle("Address")).
                        addContentValue(group.newarea().setTitle("Area").setShape("rect").setCoords("0,0,82,126")).
                        addContentValue(group.newarticle().setTitle("Article")).
                        addContentValue(group.newaside().setTitle("Aside")).
                        addContentValue(group.newaudio().setTitle("Audio").setLoop("loop").setControls("controls").setSrc("www.vg.no")).
                        addContentValue(group.newdiv().addContentValue(group.newblock().
                              addContentValue(group.newh2().addContentValue("HEADER")).
                              addContentValue(group.newp().addContentValue(group.newblock().
                                    addContentValue(group.newb().addContentValue("Bold")))))
                        )
                  ),
            new File(ProjectConstants.MAIN_ROOT + "/com/generator/generators/html5/example.html"));
   }
}