package com.generator.generators.json;

import com.generator.ProjectConstants;
import com.generator.generators.json.parser.JSONLexer;
import com.generator.generators.json.parser.JSONNodeListener;
import com.generator.generators.json.parser.JSONParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Test;

import java.io.IOException;

/**
 * Created 08.09.17.
 */
public class Tests {


   @Test
   public void testJsonGenerator() {

      final JsonGroup jsonGroup = new JsonGroup();

      System.out.println(jsonGroup.newdocument().
            addContentValue(jsonGroup.newobject().
                  addPairsValue("name","value")));

   }

   @Test
   public void testParser() throws IOException {
      final JSONParser parser = new JSONParser(new CommonTokenStream(new JSONLexer(CharStreams.fromFileName(ProjectConstants.GENERATORS_ROOT + "json/example.json"))));

      final JSONNodeListener listener = new JSONNodeListener(true);
      new ParseTreeWalker().walk(listener, parser.json());
   }
}