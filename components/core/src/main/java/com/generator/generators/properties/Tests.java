package com.generator.generators.properties;

import com.generator.ProjectConstants;
import com.generator.generators.properties.parser.propertiesLexer;
import com.generator.generators.properties.parser.propertiesNodeListener;
import com.generator.generators.properties.parser.propertiesParser;
import com.generator.util.FileUtil;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * Created 15.09.17.
 */
public class Tests {

   //@Test
   public void testParser() throws IOException {

      final File[] properties = FileUtil.list(ProjectConstants.MAIN_ROOT + "/com/generator/generators/properties", "properties");
      for (File property : properties) {
         final propertiesNodeListener listener = new propertiesNodeListener(true);
         new ParseTreeWalker().walk(listener, new propertiesParser(new CommonTokenStream(new propertiesLexer(CharStreams.fromFileName(property.getAbsolutePath())))).propertiesFile());
      }


   }
}
