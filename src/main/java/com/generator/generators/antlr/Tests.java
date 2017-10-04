package com.generator.generators.antlr;

import com.generator.ProjectConstants;
import com.generator.generators.antlr.parser.ANTLRv4Lexer;
import com.generator.generators.antlr.parser.ANTLRv4Parser;
import com.generator.generators.antlr.parser.ANTLRv4ParserNodeListener;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Test;

import java.io.IOException;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

/**
 * Created 25.08.17.
 */
public class Tests {

   @Test
   public void testDomainBuilder() throws IOException {

      final AntlrGroup antlrGroup = new AntlrGroup();

      final AntlrGroup.grammarST grammarST = antlrGroup.newgrammar();
      final AntlrGroup.domainGrammarST domainST = antlrGroup.newdomainGrammar().
            setPackage("com.generator.generators.csv.parser");

      final Map<String, AntlrGroup.domainContextST> distinct = new TreeMap<>();

//      final ANTLRv4Parser parser = new ANTLRv4Parser(new CommonTokenStream(new ANTLRv4Lexer(CharStreams.fromFileName(ProjectConstants.GENERATORS_ROOT + "csv/parser/CSV.g4"))));
      final ANTLRv4Parser parser = new ANTLRv4Parser(new CommonTokenStream(new ANTLRv4Lexer(CharStreams.fromFileName(ProjectConstants.GENERATORS_ROOT + "antlr/parser/ANTLRv4Parser.g4"))));
      final ANTLRv4ParserNodeListener listener = new ANTLRv4ParserNodeListener(true) {

         @Override
         protected void onEnter(Node node) {
            super.onEnter(node);

            if (distinct.containsKey(node.name)) {

            } else {

               final AntlrGroup.domainContextST domainContextST = antlrGroup.newdomainContext().
                     setDomain("Antlr").
                     setName(node.name);
               distinct.put(node.name, domainContextST);

            }
         }
      };
      new ParseTreeWalker().walk(listener, parser.grammarSpec());

      final ANTLRv4ParserNodeListener.Node root = listener.getRoot();
      visit(root, "");

      for (Map.Entry<String, AntlrGroup.domainContextST> entry : distinct.entrySet()) {
         System.out.println(entry.getValue());
      }

//      System.out.println(grammarST.toString());
//      System.out.println(domainST.toString());
   }

   private void visit(ANTLRv4ParserNodeListener.Node node, String delim) {
      System.out.println(delim + node.startToken + " " + node.value);
      for (ANTLRv4ParserNodeListener.Node child : node.children) {
         visit(child, delim + "\t");
      }
   }

   @Test
   public void testAntlrGrammar() {

      final AntlrGroup group = new AntlrGroup();
      final AntlrGroup.grammarST grammarST = group.newgrammar().
            setName("ANTLRv4Parser");

      grammarST.addOptionsValue("tokenVocab", "ANTLRv4Lexer");

      grammarST.addRulesValue(group.newgrammarParserRuleSpec().
            setName("grammarSpec").
            addCommentsValue("The main entry point for parsing a v4 grammar.").
            addAlternativesValue("DOC_COMMENT* grammarType identifier SEMI prequelConstruct* rules modeSpec* EOF"));

      grammarST.addRulesValue(group.newgrammarParserRuleSpec().setName("grammarType").
            addAlternativesValue("(LEXER GRAMMAR | PARSER GRAMMAR | GRAMMAR)"));

      grammarST.addRulesValue(group.newgrammarParserRuleSpec().
            setName("prequelConstruct").
            addCommentsValue("This is the list of all constructs that can be declared before").
            addCommentsValue("the set of rules that compose the grammar, and is invoked 0..n").
            addCommentsValue("times by the grammarPrequel rule.").
            addAlternativesValue("optionsSpec").
            addAlternativesValue("delegateGrammars").
            addAlternativesValue("tokensSpec").
            addAlternativesValue("channelsSpec").
            addAlternativesValue("action"));
      System.out.println(grammarST);
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