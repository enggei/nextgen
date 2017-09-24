package com.generator.generators.clojure;

import com.generator.ProjectConstants;
import com.generator.generators.clojure.parser.ClojureLexer;
import com.generator.generators.clojure.parser.ClojureNodeListener;
import com.generator.generators.clojure.parser.ClojureParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Test;

import java.io.IOException;

/**
 * Created 14.09.17.
 */
public class Tests {

   @Test
   public void testClojure() throws IOException {
      final ClojureNodeListener listener = new ClojureNodeListener(true);
      new ParseTreeWalker().walk(listener, new ClojureParser(new CommonTokenStream(new ClojureLexer(CharStreams.fromFileName(ProjectConstants.MAIN_ROOT + "/com/generator/generators/clojure/test.clj")))).file());
   }
}
