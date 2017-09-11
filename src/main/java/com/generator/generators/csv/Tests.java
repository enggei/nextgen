package com.generator.generators.csv;

import com.generator.generators.csv.parser.CSVLexer;
import com.generator.generators.csv.parser.CSVNodeListener;
import com.generator.generators.csv.parser.CSVParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Test;

import java.io.IOException;

/**
 * Created 10.09.17.
 */
public class Tests {

   @Test
   public void testParser() throws IOException {
      final CSVParser parser = new CSVParser(new CommonTokenStream(new CSVLexer(CharStreams.fromFileName("/home/goe/projects/nextgen/src/main/java/com/generator/generators/csv/test.csv"))));
      final CSVNodeListener listener = new CSVNodeListener(true);
      new ParseTreeWalker().walk(listener, parser.csvFile());
   }
}
