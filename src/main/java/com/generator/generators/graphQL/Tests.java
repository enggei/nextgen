package com.generator.generators.graphQL;

import com.generator.ProjectConstants;
import com.generator.generators.graphQL.parser.GraphQLLexer;
import com.generator.generators.graphQL.parser.GraphQLNodeListener;
import com.generator.generators.graphQL.parser.GraphQLParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Test;

import java.io.IOException;

/**
 * Created 13.12.17.
 */
public class Tests {

   @Test
   public void testGraphQL() throws IOException {

      final GraphQLParser parser = new GraphQLParser(new CommonTokenStream(new GraphQLLexer(CharStreams.fromFileName(ProjectConstants.GENERATORS_ROOT+"graphQL/test.gql"))));
      final GraphQLNodeListener listener = new GraphQLNodeListener(true);
      new ParseTreeWalker().walk(listener, parser.document());
   }
}
