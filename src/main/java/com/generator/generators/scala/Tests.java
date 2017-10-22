package com.generator.generators.scala;

import com.generator.ProjectConstants;
import com.generator.generators.scala.parser.ScalaLexer;
import com.generator.generators.scala.parser.ScalaNodeListener;
import com.generator.generators.scala.parser.ScalaParser;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;

import static com.generator.util.AntlrTestUtil.testLexer;
import static com.generator.util.AntlrTestUtil.testParserRule;

public class Tests {

	private static final FileSystem fileSystem = FileSystems.getDefault();
	private static final String workDir = ProjectConstants.MAIN_ROOT + "/com/generator/generators/scala/";

	@Test
	public void testScalaLexer() throws IOException {
		testLexer(ScalaLexer.class, fileSystem.getPath(workDir + "Test.scala"));
//		testLexer(ScalaLexer.class, "xx_=");
//		testLexer(ScalaLexer.class, "package P {  object X { val x = 1; val y = 2 } }");
//		testLexer(ScalaLexer.class, "x, Object, maxIndex, p2p, empty_?, `yield`, αρετη, _y, dot_product_*, __system, _MAX_LEN_");
	}

	@Test
	public void testScalaParser() throws IOException {

//		testParserRule(ScalaNodeListener.class, ScalaLexer.class, ScalaParser.class, parser -> ((ScalaParser)parser).qualId(),
//			"xx_=",
//			true);
//
//		testParserRule(ScalaNodeListener.class, ScalaLexer.class, ScalaParser.class, parser -> ((ScalaParser)parser).compilationUnit(),
//			fileSystem.getPath(workDir + "Test.scala"),
//			true);
//
//		testParserRule(ScalaNodeListener.class, ScalaLexer.class, ScalaParser.class, parser -> ((ScalaParser)parser).dcl(),
//			"def xx_= (yy: TT): Unit { }",
//			true);
//
//		testParserRule(ScalaNodeListener.class, ScalaLexer.class, ScalaParser.class, parser -> ((ScalaParser)parser).compilationUnit(),
//			"package P {  object X { val x = 1; val y = 2 } }",
//			true);
//
//		testParserRule(ScalaNodeListener.class, ScalaLexer.class, ScalaParser.class, parser -> ((ScalaParser)parser).templateBody(),
//			"{ val x = 1; val y = 2 }",
//			true);
//
//		testParserRule(ScalaNodeListener.class, ScalaLexer.class, ScalaParser.class, parser -> ((ScalaParser)parser).ids(),
//			"x, Object, maxIndex, p2p, empty_?, `yield`, αρετη, _y, dot_product_*, __system, _MAX_LEN_",
//			true);

		testParserRule(ScalaNodeListener.class, ScalaLexer.class, ScalaParser.class, parser -> ((ScalaParser)parser).compilationUnit(),
			"object Test { def main(args: Array[String]): Unit = { print(\"Hello world!\"); } }",
			true);
	}
}
