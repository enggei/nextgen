package com.generator.generators.go;

import com.generator.ProjectConstants;
import com.generator.generators.go.parser.GolangLexer;
import com.generator.generators.go.parser.GolangNodeListener;
import com.generator.generators.go.parser.GolangParser;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;

import static com.generator.util.AntlrTestUtil.testLexer;
import static com.generator.util.AntlrTestUtil.testParserRule;

/**
 * Created 15.09.17.
 */
public class Tests {

   private static final FileSystem fileSystem = FileSystems.getDefault();
   private static final String workDir = ProjectConstants.MAIN_ROOT + "/com/generator/generators/go/";

   //@Test
   public void testGoLexer() throws IOException {
      testLexer(GolangLexer.class, fileSystem.getPath(workDir + "Test.go"));
   }

   //@Test
   public void testGoParser() throws IOException {
      testParserRule(GolangNodeListener.class, GolangLexer.class, GolangParser.class,
         parser -> ((GolangParser)parser).sourceFile(),
         fileSystem.getPath(workDir + "Test.go"),
         true);
   }
}
