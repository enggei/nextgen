package com.generator.generators.turtle;

import com.generator.ProjectConstants;
import com.generator.generators.turtle.parser.TurtleLexer;
import com.generator.generators.turtle.parser.TurtleNodeListener;
import com.generator.generators.turtle.parser.TurtleParser;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;

import static com.generator.util.AntlrTestUtil.testLexer;
import static com.generator.util.AntlrTestUtil.testParserRule;

public class Tests {

	private static final FileSystem fileSystem = FileSystems.getDefault();
	private static final String workDir = ProjectConstants.MAIN_ROOT + "/com/generator/generators/turtle/";
//	private static final String workDir = ProjectConstants.TEST_RESOURCES_ROOT + "/stardog/";

	@Test
	public void testTurtleLexer() throws IOException {
//		testLexer(TurtleLexer.class, fileSystem.getPath(workDir + "movies.ttl"));
		testLexer(TurtleLexer.class, fileSystem.getPath(workDir + "Vehicle.ttl"));
	}

	@Test
	@SuppressWarnings("unchecked")
	public void testTurtleParser() throws IOException {

		Class nlc = TurtleNodeListener.class;
		Class lc = TurtleLexer.class;
		Class pc = TurtleParser.class;

		testParserRule(nlc, lc, pc, parser -> ((TurtleParser)parser).turtleDoc(),
			fileSystem.getPath(workDir + "Test.scala"),
			true);
	}
}
