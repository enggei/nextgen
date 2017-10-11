package com.generator.generators.scala;

import com.generator.ProjectConstants;
import com.generator.generators.scala.parser.ScalaLexer;
import com.generator.generators.scala.parser.ScalaNodeListener;
import com.generator.generators.scala.parser.ScalaParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Test;

import java.io.IOException;

public class Tests {

	@Test
	public void testScala() throws IOException {
		final ScalaNodeListener listener = new ScalaNodeListener(true);
		ScalaParser scalaParser = new ScalaParser(new CommonTokenStream(new ScalaLexer(CharStreams.fromFileName(ProjectConstants.MAIN_ROOT + "/com/generator/generators/scala/Test.scala"))));
		new ParseTreeWalker().walk(listener, scalaParser.compilationUnit());
	}
}
