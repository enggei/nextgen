package com.generator.generators.antlr;

import com.generator.ProjectConstants;
import com.generator.generators.antlr.parser.ANTLRv4Lexer;
import com.generator.generators.antlr.parser.ANTLRv4Parser;
import com.generator.generators.antlr.parser.ANTLRv4ParserNodeListener;
import com.generator.generators.stringtemplate.TemplateGroupGroup;
import com.generator.generators.stringtemplate.GeneratedFile;
import com.generator.util.StringUtil;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Test;

import java.io.IOException;
import java.util.*;

/**
 * Created 25.08.17.
 */
public class Tests {

   @Test
   public void testG4ToStringTemplate() throws IOException {

      final TemplateGroupGroup group = new TemplateGroupGroup();

      final TemplateGroupGroup.stgST stgST = group.newstg().setDelimiter("~");

      final ANTLRv4ParserNodeListener listener = new ANTLRv4ParserNodeListener(true) {

         final Stack<TemplateGroupGroup.templateST> templateStack = new Stack<>();
         StringBuilder templateContent = new StringBuilder();

         @Override
         public void enterParserRuleSpec(ANTLRv4Parser.ParserRuleSpecContext arg) {
            super.enterParserRuleSpec(arg);

            final TemplateGroupGroup.templateST templateST = group.newtemplate().setName(arg.getStart().getText());
            templateStack.push(templateST);

            templateContent = new StringBuilder();

            stgST.addTemplatesValue(templateST);
         }

         @Override
         public void enterRuleref(ANTLRv4Parser.RulerefContext arg) {
            super.enterRuleref(arg);
            templateContent.append("~" + arg.getText() + "~");
         }

         @Override
         public void enterTerminal(ANTLRv4Parser.TerminalContext arg) {
            super.enterTerminal(arg);
            templateContent.append(arg.getText().startsWith("'") ? StringUtil.trimEnds(1, arg.getText()) : (""));
         }

         @Override
         public void enterEbnfSuffix(ANTLRv4Parser.EbnfSuffixContext arg) {
            super.enterEbnfSuffix(arg);

            templateContent.append(arg.getText());
            // ~list:{it|};separator="\n"~

//            if (grammarStack.peek() instanceof BlockSuffix) {
//               final AntlrGrammarNode blockSuffix = grammarStack.pop();
//               grammarStack.peek().ebnf = startToken;
//               grammarStack.push(blockSuffix);
//            } else {
//               grammarStack.peek().ebnf = startToken;
//            }
         }

         @Override
         public void exitParserRuleSpec(ANTLRv4Parser.ParserRuleSpecContext arg) {
            super.exitParserRuleSpec(arg);
            templateStack.pop().setContent(templateContent.toString());
         }
      };

      new ParseTreeWalker().walk(listener, new ANTLRv4Parser(new CommonTokenStream(new ANTLRv4Lexer(CharStreams.fromFileName(ProjectConstants.GENERATORS_ROOT + "csv/parser/CSV.g4")))).grammarSpec());

      System.out.println(stgST);
   }

   private class GrammarSymbol {

      private String name;
      private final Set<Relation> relations = new LinkedHashSet<>();

      GrammarSymbol(String name) {
         this.name = name;
      }

      public String toString(Map<String, GrammarSymbol> symbolMap) {
         final StringBuilder out = new StringBuilder(name);
         for (Relation relation : relations) {
            out.append("\n\t").append(relation);
         }
         return out.toString();
      }
   }

   public static class Relation {

      private final String src;
      private String ebnf = "";
      private String dst;

      Relation(String src, String dst) {
         this.src = src;
         this.dst = dst;
      }

      @Override
      public String toString() {
         return ebnf + " -> " + dst;
      }

      @Override
      public boolean equals(Object o) {
         if (this == o) return true;
         if (o == null || getClass() != o.getClass()) return false;
         Relation relation = (Relation) o;
         return src.equals(relation.src) && ebnf.equals(relation.ebnf) && dst.equals(relation.dst);
      }

      @Override
      public int hashCode() {
         int result = src.hashCode();
         result = 31 * result + ebnf.hashCode();
         result = 31 * result + dst.hashCode();
         return result;
      }
   }

   @Test
   public void createSymbolGrammar() throws Exception {

      final Map<String, GrammarSymbol> symbolMap = new LinkedHashMap<>();

      final ANTLRv4ParserNodeListener listener = new ANTLRv4ParserNodeListener(true) {

         final Stack<Relation> relationStack = new Stack<>();

         @Override
         protected void onEnter(Node node) {

            final String name = node.name;
            symbolMap.computeIfAbsent(name, k -> new GrammarSymbol(name));

            if (!nodeStack.isEmpty()) {
               final Relation relation = new Relation(nodeStack.peek().name, name);
               relationStack.push(relation);
            }

            super.onEnter(node);
         }

         @Override
         protected void onExit() {
            super.onExit();

            if (!relationStack.isEmpty())
               symbolMap.get(nodeStack.peek().name).relations.add(relationStack.peek());

            if (!relationStack.isEmpty()) relationStack.pop();
         }
      };

      new ParseTreeWalker().walk(listener, new ANTLRv4Parser(new CommonTokenStream(new ANTLRv4Lexer(CharStreams.fromFileName(ProjectConstants.GENERATORS_ROOT + "antlr/parser/ANTLRv4Parser.g4")))).grammarSpec());
      new ParseTreeWalker().walk(listener, new ANTLRv4Parser(new CommonTokenStream(new ANTLRv4Lexer(CharStreams.fromFileName(ProjectConstants.GENERATORS_ROOT + "antlr/parser/ANTLRv4Lexer.g4")))).grammarSpec());
      new ParseTreeWalker().walk(listener, new ANTLRv4Parser(new CommonTokenStream(new ANTLRv4Lexer(CharStreams.fromFileName(ProjectConstants.GENERATORS_ROOT + "antlr/parser/LexBasic.g4")))).grammarSpec());

      final AntlrGroup antlrGroup = new AntlrGroup();

      final AntlrGroup.AntlrDomainST antlrDomainST = antlrGroup.newAntlrDomain().
            setName("ANTLRv4Parser" + "Domain").
            setPackage("com.generator.generators.antlr.parser");

      // grammar-bnf renderer
      final AntlrGroup.AntlrBnfRendererST antlrBnfRendererST = antlrGroup.newAntlrBnfRenderer().
            setName("ANTLRv4Parser" + "Renderer").
            setPackage("com.generator.generators.antlr.bnf");

      for (GrammarSymbol grammarSymbol : symbolMap.values()) {
         System.out.println(grammarSymbol.toString(symbolMap));

         final AntlrGroup.AntlrGrammarNodeST antlrGrammarNodeST = antlrGroup.newAntlrGrammarNode().setName(grammarSymbol.name);

         final AntlrGroup.AntlrSymbolNodeST nodeST = antlrGroup.newAntlrSymbolNode().
               setName(grammarSymbol.name);

         for (Relation child : grammarSymbol.relations) {
            antlrGrammarNodeST.addChildrenValue(child.dst);
            nodeST.addChildrenValue(child.dst);
         }

         antlrBnfRendererST.addNodesValue(grammarSymbol.name, nodeST);
         antlrDomainST.addNodesValue(antlrGrammarNodeST, grammarSymbol.name);
      }

      GeneratedFile.newJavaFile(ProjectConstants.MAIN_ROOT, antlrDomainST.getPackage(), antlrDomainST.getName()).write(antlrDomainST);
      GeneratedFile.newJavaFile(ProjectConstants.MAIN_ROOT, antlrBnfRendererST.getPackage(), antlrBnfRendererST.getName()).write(antlrBnfRendererST);
   }

   private void visit(ANTLRv4ParserNodeListener.Node node, Map<String, MetaNode> distinctMap) {

      final MetaNode metaNode = new MetaNode(node);

      if (!distinctMap.containsKey(node.name)) distinctMap.put(node.name, metaNode);

      for (ANTLRv4ParserNodeListener.Node child : node.children) {
         final MetaNode dst = new MetaNode(child);
         final MetaRelation metaRelation = new MetaRelation(metaNode, dst, Ebnf.REQUIRED);
         distinctMap.get(node.name).children.put(child.name, metaRelation);
         visit(child, distinctMap);
      }
   }

   public ANTLRv4ParserNodeListener.Node parse(Map<String, MetaNode> visitedNodes, ANTLRv4Parser parser) {
      ANTLRv4ParserNodeListener listener = new ANTLRv4ParserNodeListener(true) {

         @Override
         protected void onEnter(Node node) {
            super.onEnter(node);

            if (!visitedNodes.containsKey(node.name))
               visitedNodes.put(node.name, new MetaNode(node));
         }

         @Override
         protected void onExit() {
            final Node node = nodeStack.peek();

            final MetaNode metaNode = visitedNodes.get(node.name);
            for (Node child : node.children) {
               if (metaNode.children.containsKey(child.name)) continue;
               metaNode.children.put(child.name, new MetaRelation(metaNode, visitedNodes.get(child.name), Ebnf.REQUIRED));
            }
            super.onExit();
         }
      };

      new ParseTreeWalker().walk(listener, parser.grammarSpec());
      return listener.getRoot();
   }

   private final class MetaNode {

      private final String name;
      private final Map<String, MetaRelation> children = new LinkedHashMap<>();

      MetaNode(ANTLRv4ParserNodeListener.Node node) {
         this.name = node.name;
      }

      @Override
      public boolean equals(Object o) {
         if (this == o) return true;
         if (o == null || getClass() != o.getClass()) return false;

         MetaNode metaNode = (MetaNode) o;

         return name.equals(metaNode.name);
      }

      @Override
      public int hashCode() {
         return name.hashCode();
      }

      @Override
      public String toString() {
         return name;
      }
   }

   enum Ebnf {
      REQUIRED, OPTIONAL, ONE_OR_MORE, ZERO_OR_MORE
   }

   private final class MetaRelation {

      private final MetaNode src;
      private final MetaNode dst;
      private final Ebnf ebnf;

      MetaRelation(MetaNode src, MetaNode dst, Ebnf ebnf) {
         this.src = src;
         this.dst = dst;
         this.ebnf = ebnf;
      }

      @Override
      public boolean equals(Object o) {
         if (this == o) return true;
         if (o == null || getClass() != o.getClass()) return false;

         MetaRelation that = (MetaRelation) o;
         return src.equals(that.src) && dst.equals(that.dst) && ebnf == that.ebnf;
      }

      @Override
      public int hashCode() {
         int result = src.hashCode();
         result = 31 * result + dst.hashCode();
         result = 31 * result + ebnf.hashCode();
         return result;
      }

      @Override
      public String toString() {
         return src + " " + ebnf + " " + dst;
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
   public void testParser() throws IOException {

      final String[] grammarFiles = new String[]{
            "mysql/parser/MySqlLexer.g4"
      };

      for (String fileName : grammarFiles) {
         final ANTLRv4Parser parser = new ANTLRv4Parser(new CommonTokenStream(new ANTLRv4Lexer(CharStreams.fromFileName(ProjectConstants.GENERATORS_ROOT + fileName))));
         final ANTLRv4ParserNodeListener listener = new ANTLRv4ParserNodeListener(true);
         new ParseTreeWalker().walk(listener, parser.grammarSpec());
      }
   }
}