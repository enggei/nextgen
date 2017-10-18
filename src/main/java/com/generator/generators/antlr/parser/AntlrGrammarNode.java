package com.generator.generators.antlr.parser;

import com.generator.generators.antlr.AntlrGroup;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created 16.10.17.
 */
public class AntlrGrammarNode {

   private final UUID uuid = UUID.randomUUID();

   protected String type;
   public AntlrGrammarNode parent;
   public String label;
   public String text;
   public String startToken;
   public String endToken;
   public String ebnf = "";
   public final java.util.List<AntlrGrammarNode> children = new ArrayList<>();

   public AntlrGrammarNode(String type, String label, String value, String startToken, String endToken) {
      this.type = type;
      this.label = label;
      this.text = value;
      this.startToken = startToken;
      this.endToken = endToken;
   }

   public String getText() {
      return text;
   }

   public String getStartToken() {
      return startToken;
   }

   public String getEndToken() {
      return endToken;
   }

   public String type() {
      return type;
   }

   public AntlrGrammarNode setChild(AntlrGrammarNode grammarNode) {
      children.clear();
      children.add(grammarNode);
      grammarNode.parent = this;
      //visit(this, "");
      return this;
   }

   public AntlrGrammarNode addChild(AntlrGrammarNode grammarNode) {
      children.add(grammarNode);
      grammarNode.parent = this;
      //visit(this, "");
      return this;
   }

   @Override
   public String toString() {
      return type;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;

      AntlrGrammarNode grammarNode = (AntlrGrammarNode) o;

      return uuid.equals(grammarNode.uuid);
   }

   @Override
   public int hashCode() {
      return uuid.hashCode();
   }

   public Object toGrammar(AntlrGroup antlrGroup) {
      final StringBuilder out = new StringBuilder();
      for (AntlrGrammarNode grammarNode : children) {
         final Object grammar = grammarNode.toGrammar(antlrGroup);
         if (grammar == null) continue;
         out.append(grammar);
      }
      return out.length() == 0 ? null : out.toString();
   }

   public String generateOutput(String delim) {
      final StringBuilder out = new StringBuilder(delim);

      if ("*".equals(ebnf) || "*?".equals(ebnf)) {
         if (ANTLRv4ParserDomain.random.nextBoolean()) {
            int n = ANTLRv4ParserDomain.random.nextInt(10);
            int i = 0;

            do {
               for (AntlrGrammarNode grammarNode : children)
                  out.append(grammarNode.generateOutput(delim + "\t"));
               i++;
            } while (i < n);
         }

      } else if ("?".equals(ebnf)) {

         if (ANTLRv4ParserDomain.random.nextBoolean()) {
            for (AntlrGrammarNode grammarNode : children)
               out.append(grammarNode.generateOutput(delim + "\t"));
         }

      } else if ("+".equals(ebnf)) {

         int n = ANTLRv4ParserDomain.random.nextInt(10);
         int i = 0;

         do {
            for (AntlrGrammarNode grammarNode : children)
               out.append(grammarNode.generateOutput(delim + "\t"));
            i++;
         } while (i < n);
      } else {
         for (AntlrGrammarNode grammarNode : children)
            out.append(grammarNode.generateOutput(delim + "\t"));
      }

      System.out.println(out.toString().trim());
      return out.toString().trim();
   }
}
