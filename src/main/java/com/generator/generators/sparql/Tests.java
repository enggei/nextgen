package com.generator.generators.sparql;

import com.generator.ProjectConstants;
import com.generator.generators.sparql.parser.SparqlLexer;
import com.generator.generators.sparql.parser.SparqlNodeListener;
import com.generator.generators.sparql.parser.SparqlParser;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.util.Arrays;
import java.util.List;

import static com.generator.util.AntlrTestUtil.testLexer;
import static com.generator.util.AntlrTestUtil.testParserRule;

public class Tests {

	private static final FileSystem fileSystem = FileSystems.getDefault();
	private static final String workDir = ProjectConstants.MAIN_ROOT + "/com/generator/generators/sparql/";
	private static final List<String> testFiles = Arrays.asList(
		"Test1.sparql",
		"Test2.sparql",
		"Test3.sparql",
		"Test4.sparql"
	);

	@Test
	public void testSparqlLexer() throws IOException {
		testLexer(SparqlLexer.class, fileSystem.getPath(workDir + "Test3.sparql"));
	}

	@Test
	@SuppressWarnings("unchecked")
	public void testSparqlParser() throws IOException {

		Class nlc = SparqlNodeListener.class;
		Class lc = SparqlLexer.class;
		Class pc = SparqlParser.class;

		for (String testFile : testFiles) {
			testParserRule(nlc, lc, pc, parser -> ((SparqlParser)parser).query(),
				fileSystem.getPath(workDir + testFile),
				true);
		}
	}
}
