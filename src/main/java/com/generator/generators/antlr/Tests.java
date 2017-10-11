package com.generator.generators.antlr;

import com.generator.ProjectConstants;
import com.generator.generators.antlr.parser.ANTLRv4Lexer;
import com.generator.generators.antlr.parser.ANTLRv4Parser;
import com.generator.generators.antlr.parser.ANTLRv4ParserNodeListener;
import com.generator.generators.domain.NeoVisitorGroup;
import com.generator.generators.stringtemplate.domain.GeneratedFile;
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

            if(!relationStack.isEmpty())
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

      final AntlrGroup.AntlrDomainGrammarVisitorST grammarVisitor = antlrGroup.newAntlrDomainGrammarVisitor().
            setPackage("com.generator.generators.antlr.parser").
            setName("ANTLRv4ParserGrammarVisitor");

      for (GrammarSymbol grammarSymbol : symbolMap.values()) {
         System.out.println(grammarSymbol.toString(symbolMap));

         final AntlrGroup.AntlrNodeST nodeST = antlrGroup.newAntlrNode().
               setName(grammarSymbol.name);

         grammarVisitor.addNodesValue(grammarSymbol.name);

         for (Relation child : grammarSymbol.relations)
            nodeST.addChildrenValue(child.dst);

         antlrDomainST.addNodesValue(nodeST, grammarSymbol.name);
      }

      GeneratedFile.newJavaFile(ProjectConstants.MAIN_ROOT, grammarVisitor.getPackage(), grammarVisitor.getName()).write(grammarVisitor);
      GeneratedFile.newJavaFile(ProjectConstants.MAIN_ROOT, antlrDomainST.getPackage(), antlrDomainST.getName()).write(antlrDomainST);
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
            "properties/parser/properties.g4"
      };

      for (String fileName : grammarFiles) {
         final ANTLRv4Parser parser = new ANTLRv4Parser(new CommonTokenStream(new ANTLRv4Lexer(CharStreams.fromFileName(ProjectConstants.GENERATORS_ROOT + fileName))));
         final ANTLRv4ParserNodeListener listener = new ANTLRv4ParserNodeListener(true);
         new ParseTreeWalker().walk(listener, parser.grammarSpec());
      }
   }
}