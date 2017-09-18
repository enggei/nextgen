package com.generator.generators.antlr;

import com.generator.ProjectConstants;
import com.generator.generators.antlr.parser.ANTLRv4Lexer;
import com.generator.generators.antlr.parser.ANTLRv4Parser;
import com.generator.generators.antlr.parser.ANTLRv4ParserNodeListener;
import com.generator.util.StringUtil;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Test;

import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created 25.08.17.
 */
public class Tests {

   @Test
   public void testAntlrGrammar() {

      final AntlrGroup group = new AntlrGroup();
      final AntlrGroup.grammarST grammarST = group.newgrammar().
            setName("ANTLRv4Parser");

      grammarST.addOptionsValue("tokenVocab", "ANTLRv4Lexer");

      grammarST.addRulesValue(group.newrule().
            setName("grammarSpec").
            addCommentsValue("The main entry point for parsing a v4 grammar.").
            addAlternativesValue("DOC_COMMENT* grammarType identifier SEMI prequelConstruct* rules modeSpec* EOF"));

      grammarST.addRulesValue(group.newrule().setName("grammarType").
            addAlternativesValue("(LEXER GRAMMAR | PARSER GRAMMAR | GRAMMAR)"));

      grammarST.addRulesValue(group.newrule().
            setName("prequelConstruct").
            addCommentsValue("This is the list of all constructs that can be declared before").
            addCommentsValue("the set of rules that compose the grammar, and is invoked 0..n").
            addCommentsValue("times by the grammarPrequel rule.").
            addAlternativesValue("optionsSpec").
            addAlternativesValue("delegateGrammars").
            addAlternativesValue("tokensSpec").
            addAlternativesValue("channelsSpec").
            addAlternativesValue("action"));

      grammarST.addFragmentsValue(group.newfragment().
            setName("WS").
            addAlternativesValue("[ \\n\\r\\t,]"));

      System.out.println(grammarST);
   }

   @Test
   public void testGrammarToSTG() throws IOException {

      // todo
      final String[] grammarFiles = new String[]{
//            "antlr/parser/ANTLRv4Parser.g4",
//            "java/parser/JavaParser.g4",
//            "java/parser/JavaLexer.g4",
            "csv/parser/CSV.g4"
      };

      for (String fileName : grammarFiles) {

         final Set<String> terminals = new LinkedHashSet<>();

         final ANTLRv4Parser parser = new ANTLRv4Parser(new CommonTokenStream(new ANTLRv4Lexer(CharStreams.fromFileName(ProjectConstants.GENERATORS_ROOT + fileName))));
         final ANTLRv4ParserNodeListener listener = new ANTLRv4ParserNodeListener(true) {
            @Override
            public void enterRuleSpec(ANTLRv4Parser.RuleSpecContext arg) {
               super.enterRuleSpec(arg);

               System.out.println(delim + "Rule name " + nodeStack.peek().startToken);
            }

            @Override
            public void enterTerminal(ANTLRv4Parser.TerminalContext arg) {
               super.enterTerminal(arg);

               terminals.add(arg.getText());
            }
         };
         new ParseTreeWalker().walk(listener, parser.grammarSpec());

         System.out.println("terminals: ");
         for (String terminal : terminals) {
            System.out.print(" " + terminal);
         }
      }
   }

   @Test
   public void testAntlrGroup() {
      System.out.println(new AntlrGroup().newBaseNodeVisitor().
            setPackageName("com.").
            setName("nam").
            setParser("Parser"));
   }

   @Test
   public void testParser() throws IOException {

      final String[] grammarFiles = new String[]{
            "properties/parser/properties.g4"
      };

      for (String fileName : grammarFiles) {
         final ANTLRv4Parser parser = new ANTLRv4Parser(new CommonTokenStream(new ANTLRv4Lexer(CharStreams.fromFileName(ProjectConstants.GENERATORS_ROOT + fileName))));
         final ANTLRv4ParserNodeListener listener = new ANTLRv4ParserNodeListener(true);
         new ParseTreeWalker().walk(listener, parser.grammarSpec());
      }
   }
}