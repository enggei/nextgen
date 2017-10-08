package com.generator.generators.antlr;

import com.generator.ProjectConstants;
import com.generator.generators.antlr.parser.ANTLRv4Lexer;
import com.generator.generators.antlr.parser.ANTLRv4Parser;
import com.generator.generators.antlr.parser.ANTLRv4ParserDomain;
import com.generator.generators.antlr.parser.ANTLRv4ParserNodeListener;
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

   @Test
   public void testJSONDomain() throws Exception {

      final AntlrGroup antlrGroup = new AntlrGroup();

      final AntlrGroup.AntlrDomainST domainST = antlrGroup.newAntlrDomain().
            setName("JSON" + "Domain").
            setPackage("com.generator.generators.json.parser");

      final Stack<ANTLRv4ParserDomain.ANTLRv4ParserDomainNode> domainStack = new Stack<>();

      final ANTLRv4Parser parser = new ANTLRv4Parser(new CommonTokenStream(new ANTLRv4Lexer(CharStreams.fromFileName(ProjectConstants.GENERATORS_ROOT + "json/parser/JSON.g4"))));
      final ANTLRv4ParserNodeListener listener = new ANTLRv4ParserNodeListener(true) {

//         @Override
//         public void enterGrammarSpec(ANTLRv4Parser.GrammarSpecContext arg) {
//            super.enterGrammarSpec(arg);
//            domainStack.push(new ANTLRv4ParserDomain.GrammarSpec());
//         }
//
//         @Override
//         public void exitGrammarSpec(ANTLRv4Parser.GrammarSpecContext arg) {
//            super.exitGrammarSpec(arg);
//         }
//
//         @Override
//         public void enterIdentifier(ANTLRv4Parser.IdentifierContext arg) {
//            super.enterIdentifier(arg);
//            domainStack.push(new ANTLRv4ParserDomain.Identifier());
//         }
//
//         @Override
//         public void exitIdentifier(ANTLRv4Parser.IdentifierContext arg) {
//            super.exitIdentifier(arg);
//            if (domainStack.size() > 0) {
//               final ANTLRv4ParserDomain.ANTLRv4ParserDomainNode pop = domainStack.pop();
//               if (domainStack.size() > 0) domainStack.peek().addChild(pop);
//            }
//         }
//
//         @Override
//         public void enterRuleSpec(ANTLRv4Parser.RuleSpecContext arg) {
//            super.enterRuleSpec(arg);
//
//            final Node node = nodeStack.peek();
//
//            String name = node.startToken;
//            if (name.startsWith("fragment")) {
//               name = node.value.substring("fragment".length(), node.value.indexOf(":"));
//            }
//
//            final AntlrGroup.AntlrNodeST nodeST = antlrGroup.newAntlrNode().
//                  setDomain(domainST.getName()).
//                  setName("_" + name);
//
//            domainST.addNodesValue(nodeST);
//         }
//
//         @Override
//         public void enterRuleref(ANTLRv4Parser.RulerefContext arg) {
//            super.enterRuleref(arg);
//         }
      };

      new ParseTreeWalker().walk(listener, parser.grammarSpec());

//      GeneratedFile.newJavaFile(ProjectConstants.MAIN_ROOT, domainST.getPackage(), domainST.getName()).write(domainST);

      final ANTLRv4ParserDomain.GrammarSpec pop = (ANTLRv4ParserDomain.GrammarSpec) domainStack.pop();

//      System.out.println(pop._Identifier);
//      final ANTLRv4ParserDomain.Rules rules = pop._Rules;
//      for (ANTLRv4ParserDomain.RuleSpec ruleSpec : rules._RuleSpec) {
//         System.out.println(ruleSpec.);
//      }
   }

   @Test
   public void createAntlrDomain() throws Exception {

      final Map<String, MetaNode> visitedNodes = new LinkedHashMap<>();

      final Map<String, MetaNode> distinctMap = new LinkedHashMap<>();
      visit(parse(visitedNodes, new ANTLRv4Parser(new CommonTokenStream(new ANTLRv4Lexer(CharStreams.fromFileName(ProjectConstants.GENERATORS_ROOT + "antlr/parser/ANTLRv4Parser.g4"))))), distinctMap);
      visit(parse(visitedNodes, new ANTLRv4Parser(new CommonTokenStream(new ANTLRv4Lexer(CharStreams.fromFileName(ProjectConstants.GENERATORS_ROOT + "antlr/parser/ANTLRv4Lexer.g4"))))), distinctMap);
      visit(parse(visitedNodes, new ANTLRv4Parser(new CommonTokenStream(new ANTLRv4Lexer(CharStreams.fromFileName(ProjectConstants.GENERATORS_ROOT + "antlr/parser/LexBasic.g4"))))), distinctMap);

      final AntlrGroup antlrGroup = new AntlrGroup();

      final AntlrGroup.AntlrDomainST antlrDomainST = antlrGroup.newAntlrDomain().
            setName("ANTLRv4Parser" + "Domain").
            setPackage("com.generator.generators.antlr.parser");

      for (Map.Entry<String, MetaNode> entry : distinctMap.entrySet()) {
         final MetaNode metaNode = entry.getValue();
         System.out.println(entry.getKey() + " has " + metaNode.children.size() + " entries: " + StringUtil.toString(metaNode.children.values(), ","));

         final AntlrGroup.AntlrNodeST nodeST = antlrGroup.newAntlrNode().
               setName(entry.getKey()).
               setDomain(antlrDomainST.getName());

         for (MetaRelation relation : metaNode.children.values()) {
            final String childName = relation.dst.name;
            switch (relation.ebnf) {
               case REQUIRED:
                  nodeST.addChildrenValue(relation.ebnf, "void set" + childName + "(" + childName + " value) { this._" + childName + " = value; }", childName + " " + "_" + childName);
                  break;
               case OPTIONAL:
                  nodeST.addChildrenValue(relation.ebnf, "void set" + childName + "(" + childName + " value) { this._" + childName + " = value; }", childName + " " + "_" + childName);
                  break;
               case ONE_OR_MORE:
                  nodeST.addChildrenValue(relation.ebnf, "void add" + childName + "(" + childName + " value) { this._" + childName + ".add(value); }", "java.util.List<" + childName + "> _" + childName + " = new ArrayList<>();");
                  break;
               case ZERO_OR_MORE:
                  nodeST.addChildrenValue(relation.ebnf, "void add" + childName + "(" + childName + " value) { this._" + childName + ".add(value); }", "java.util.List<" + childName + "> _" + childName + " = new ArrayList<>();");
                  break;
            }
         }

         antlrDomainST.addNodesValue(nodeST);
      }

      System.out.println(antlrDomainST);

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

         if (!src.equals(that.src)) return false;
         if (!dst.equals(that.dst)) return false;
         return ebnf == that.ebnf;
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
   public void testDomainBuilder() throws IOException {


      final Map<String, StringBuilder> nodeDeclarations = new LinkedHashMap<>();
      final Map<String, StringBuilder> nodeInstantiations = new LinkedHashMap<>();

//      final ANTLRv4Parser parser = new ANTLRv4Parser(new CommonTokenStream(new ANTLRv4Lexer(CharStreams.fromFileName(ProjectConstants.GENERATORS_ROOT + "csv/parser/CSV.g4"))));
      final ANTLRv4Parser parser = new ANTLRv4Parser(new CommonTokenStream(new ANTLRv4Lexer(CharStreams.fromFileName(ProjectConstants.GENERATORS_ROOT + "antlr/parser/ANTLRv4Parser.g4"))));
//      final ANTLRv4Parser parser = new ANTLRv4Parser(new CommonTokenStream(new ANTLRv4Lexer(CharStreams.fromFileName(ProjectConstants.GENERATORS_ROOT + "json/parser/JSON.g4"))));
      final ANTLRv4ParserNodeListener listener = new ANTLRv4ParserNodeListener() {

         final Stack<String> currentRuleSpecName = new Stack<>();
         final Stack<StringBuilder> currentRuleSpec = new Stack<>();

         @Override
         public void enterParserRuleSpec(ANTLRv4Parser.ParserRuleSpecContext arg) {
            super.enterParserRuleSpec(arg);

            String startToken = nodeStack.peek().startToken;

            currentRuleSpecName.push(startToken);

            final StringBuilder x = new StringBuilder("class " + startToken + "Node extends RuleNode {\n");
            nodeDeclarations.put(startToken, x);

            final String y = startToken + "Node new" + StringUtil.capitalize(startToken) + "Node() { return new " + startToken + "Node(); }";
            nodeInstantiations.put(startToken, new StringBuilder(y));

            currentRuleSpec.push(x);
         }

         @Override
         public void enterLexerRuleSpec(ANTLRv4Parser.LexerRuleSpecContext arg) {
            super.enterLexerRuleSpec(arg);

            String startToken = nodeStack.peek().startToken;

            if ("fragment".equals(startToken)) {
               final String value = nodeStack.peek().value;
               final int beginIndex = "fragment".length();
               startToken = value.substring(beginIndex, value.indexOf(":", beginIndex));
            }
            currentRuleSpecName.push(startToken);

            final StringBuilder x = new StringBuilder("class " + startToken + "Node extends LexerNode {\n");
            nodeDeclarations.put(startToken, x);

            final String y = startToken + "Node new" + StringUtil.capitalize(startToken) + "Node() { return new " + startToken + "Node(); }";
            nodeInstantiations.put(startToken, new StringBuilder(y));

            currentRuleSpec.push(x);
         }

         @Override
         public void exitParserRuleSpec(ANTLRv4Parser.ParserRuleSpecContext arg) {
            super.exitParserRuleSpec(arg);
            currentRuleSpec.pop();
            currentRuleSpecName.pop();
         }

         @Override
         public void exitLexerRuleSpec(ANTLRv4Parser.LexerRuleSpecContext arg) {
            super.exitLexerRuleSpec(arg);
            currentRuleSpec.pop();
            currentRuleSpecName.pop();
         }

         @Override
         public void exitRuleAltList(ANTLRv4Parser.RuleAltListContext arg) {

            final Node altListNode = nodeStack.peek();

            String startToken = nodeStack.peek().startToken;

            if (altListNode.children.size() == 1) {
               final String childName = altListNode.children.iterator().next().startToken;
               currentRuleSpec.peek().append("\n\t").append(currentRuleSpecName.peek()).append("Node set").append(StringUtil.capitalize(childName)).append("(").append(childName).append("Node child) {\n\t\taddChild(child);\n\t\treturn this;\n\t}");
            } else {
//               for (Node child : altListNode.children) {
//                  final String childName = child.startToken;
//                  currentRuleSpec.peek().append("\n\t").append(currentRuleSpecName.peek()).append("Node add").append(StringUtil.capitalize(childName)).append("(").append(startToken).append("Node child) {\n\t\taddChild(child);\n\t\treturn this;\n\t}");
//               }
            }
            super.exitRuleAltList(arg);
         }

         @Override
         public void exitLexerAltList(ANTLRv4Parser.LexerAltListContext arg) {

            final Node altListNode = nodeStack.peek();

            String startToken = nodeStack.peek().startToken;

            if (altListNode.children.size() == 1) {
               currentRuleSpec.peek().append("\n\t").append(currentRuleSpecName.peek()).append("Node set").append("Value").append("(").append("String").append(" child) {\n\t\taddChild(child);\n\t\treturn this;\n\t}");
            } else {
//               System.out.println("Multiple alternatives ");
               for (Node child : altListNode.children) {
                  currentRuleSpec.peek().append("\n\t").append(currentRuleSpecName.peek()).append("Node add").append("Value").append("(").append("String").append(" child) {\n\t\taddChild(child);\n\t\treturn this;\n\t}");

               }
            }

            super.exitLexerAltList(arg);
         }
      };
      new ParseTreeWalker().walk(listener, parser.grammarSpec());

      for (StringBuilder stringBuilder : nodeDeclarations.values()) {
         System.out.println(stringBuilder.toString() + "\n}");
      }

      for (StringBuilder stringBuilder : nodeInstantiations.values()) {
         System.out.println(stringBuilder.toString() + "\n");
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