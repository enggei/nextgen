package com.generator.generators.ecmascript;

import com.generator.ProjectConstants;
import com.generator.generators.ecmascript.parser.ECMAScriptLexer;
import com.generator.generators.ecmascript.parser.ECMAScriptNodeListener;
import com.generator.generators.ecmascript.parser.ECMAScriptParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Test;

import java.io.IOException;

/**
 * Created 08.09.17.
 */
public class Tests {
   private final static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(Tests.class);
   //@Test
   public void testParser() throws IOException {
      final ECMAScriptParser parser = new ECMAScriptParser(new CommonTokenStream(new ECMAScriptLexer(CharStreams.fromFileName(ProjectConstants.MAIN_ROOT + "/com/generator/generators/ecmascript/example.js"))));

      final ECMAScriptNodeListener listener = new ECMAScriptNodeListener();
      new ParseTreeWalker().walk(listener, parser.program());

      visitAll("", listener.getRoot());
   }

   private void visitAll(String delim, ECMAScriptNodeListener.Node node) {
      log.info(delim + node.name + " (" + node.startToken + ")");
      for (ECMAScriptNodeListener.Node child : node.children) {
         visitAll(delim + "\t", child);
      }
   }
}
