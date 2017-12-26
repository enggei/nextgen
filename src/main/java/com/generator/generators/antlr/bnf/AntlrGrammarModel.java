package com.generator.generators.antlr.bnf;

import com.generator.ProjectConstants;
import com.generator.generators.antlr.parser.*;
import com.generator.generators.csv.parser.CSVListener;
import com.generator.generators.csv.parser.CSVNodeListener;
import com.generator.generators.csv.parser.CSVParser;
import com.generator.generators.json.parser.JSONLexer;
import com.generator.generators.json.parser.JSONNodeListener;
import com.generator.generators.json.parser.JSONParser;
import com.generator.util.FileUtil;
import com.generator.util.StringUtil;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.neo4j.graphdb.Node;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created 09.10.17.
 * BNF model for Antlr-grammar
 */
public class AntlrGrammarModel extends ANTLRv4ParserDomain {
   private final static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(AntlrGrammarModel.class);
   // todo testing lexer-token values
   private final Set<String> tokenValues = new LinkedHashSet<>();
   private final Map<String, AntlrGrammarNode> ruleSpecs = new ConcurrentHashMap<>();
   private final Map<String, Set<Relation>> relationMap = new ConcurrentHashMap<>();

   private static final Random random = new Random(System.currentTimeMillis());

   public AntlrGrammarModel() {
      grammarStack.push(newGrammarSpec("", "", ""));
   }

   public AntlrGrammarModel(Node node) {
      getANTLRv4ParserDomainVisitor().visit(node);
   }

   public AntlrGrammarModel(File file) throws IOException {
      final File[] grammarFiles = FileUtil.list(file.getParent(), ".g4");
      final ANTLRv4ParserNodeListener parserListener = getANTLRv4ParserNodeListener(false);
      for (File grammarFile : grammarFiles)
         new ParseTreeWalker().walk(parserListener, new ANTLRv4Parser(new CommonTokenStream(new ANTLRv4Lexer(CharStreams.fromFileName(grammarFile.getAbsolutePath())))).grammarSpec());
   }

   public void showDistinct() {

      for (Map.Entry<String, Set<Relation>> entry : relationMap.entrySet()) {
         log.info(entry.getKey());
         for (Relation relation : entry.getValue()) {
            log.info("\t" + relation.toString());
         }
      }

      for (String tokenValue : tokenValues) {
         log.info(tokenValue);
      }

      for (Map.Entry<String, AntlrGrammarNode> entry : ruleSpecs.entrySet()) {
         log.info(entry.getKey() + " -> " + entry.getValue());
      }
   }

   public Map<String, Set<Relation>> getRelationMap() {
      return relationMap;
   }

   @Override
   public void onNode(AntlrGrammarNode grammarNode) {
      if (!grammarStack.isEmpty()) {
         final Set<Relation> children = relationMap.computeIfAbsent(grammarStack.peek().type(), k -> new LinkedHashSet<>());
         children.add(new Relation(grammarStack.peek().type(), grammarNode.type()));
      }
   }

   @Override
   public Rules newRules(String text, String startToken, String endToken) {
      return new Rules(text, startToken, endToken) {
         @Override
         public String generateOutput(String delim) {
            // assumes the first rule is the entry-point for parser:
            return children.iterator().next().generateOutput(delim + "\t");
         }
      };
   }

   @Override
   public EbnfSuffix newEbnfSuffix(String text, String startToken, String endToken) {
      if (grammarStack.peek() instanceof BlockSuffix) {
         final AntlrGrammarNode blockSuffix = grammarStack.pop();
         grammarStack.peek().ebnf = startToken;
         grammarStack.push(blockSuffix);
      } else {
         grammarStack.peek().ebnf = startToken;
      }

      return super.newEbnfSuffix(text, startToken, endToken);
   }

   @Override
   public RuleSpec newRuleSpec(String text, String startToken, String endToken) {
      if (startToken.equals("fragment")) {
         grammarStack.peek().label = startToken + " " + text.substring("fragment".length(), text.indexOf(":"));
      }
      return super.newRuleSpec(text, startToken, endToken);
   }

   @Override
   public RuleAltList newRuleAltList(String text, String startToken, String endToken) {
      return new RuleAltList(text, startToken, endToken) {
         @Override
         public String generateOutput(String delim) {
            final String s = children.get(random.nextInt(children.size())).generateOutput(delim + "\t");
//            log.info(type + " " + s);
            return s;
         }
      };
   }

   @Override
   public ParserRuleSpec newParserRuleSpec(String text, String startToken, String endToken) {
      ruleSpecs.put(grammarStack.peek().label, grammarStack.peek());
      return new ParserRuleSpec(text, startToken, endToken);
   }

   @Override
   public LexerRuleSpec newLexerRuleSpec(String text, String startToken, String endToken) {

      if (startToken.equals("fragment")) {
         grammarStack.peek().label = text.substring("fragment".length(), text.indexOf(":"));
      }
      ruleSpecs.put(grammarStack.peek().label, grammarStack.peek());

      return new LexerRuleSpec(text, startToken, endToken) {
         @Override
         public String generateOutput(String delim) {
            return super.generateOutput(delim + "\t");
         }
      };
   }

   @Override
   public LexerAltList newLexerAltList(String text, String startToken, String endToken) {
      return new LexerAltList(text, startToken, endToken) {
         @Override
         public String generateOutput(String delim) {
            final String s = children.get(random.nextInt(children.size())).generateOutput(delim + "\t");
//            log.info(type + " " + s);
            return s;
         }
      };
   }

   @Override
   public LexerAtom newLexerAtom(String text, String startToken, String endToken) {

      final Map<String, String> ranges = new HashMap<>();

      if (text.startsWith("[")) {
         log.info(text);
         final String tmp = StringUtil.trimEnds(1, text);

         // look for non-digit-range
         Pattern pattern = Pattern.compile("((\\D)-(\\D))");
         Matcher matcher = pattern.matcher(tmp);
         while (matcher.find()) ranges.put(matcher.group(2), matcher.group(3));

         // look for digit-range
         pattern = Pattern.compile("((\\d)-(\\d))");
         matcher = pattern.matcher(tmp);
         while (matcher.find()) ranges.put(matcher.group(2), matcher.group(3));

         return new LexerAtom(text, startToken, endToken) {
            @Override
            public String generateOutput(String delim) {
               if (children.size() > 0) return super.generateOutput(delim + "\t");

               if (ranges.isEmpty()) {
                  final char c = tmp.toCharArray()[random.nextInt(tmp.toCharArray().length)];

                  log.info(label + " " + c);

                  if (c == '\\') {
                     return "";
                  } else if (c == '"')
                     return "\\\"";

                  return "" + c;

               } else {

                  final int n = random.nextInt(ranges.size());
                  final String randomValue = (String) ranges.keySet().toArray()[n];
                  final Character c = StringUtil.randomCharacter(Character.codePointAt(randomValue.toCharArray(), 0), Character.codePointAt(ranges.get(randomValue).toCharArray(), 0));

                  log.info(label + " " + c);

                  return "" + c;
               }

            }
         };
      }

      return new LexerAtom(text, startToken, endToken);
   }

   @Override
   public Ruleref newRuleref(String text, String startToken, String endToken) {
      return new Ruleref(text, startToken, endToken) {
         @Override
         public String generateOutput(String delim) {
            final String s = ruleSpecs.get(text).generateOutput(delim + "\t");
//            log.info(type + " " + s);
            return s;
         }
      };
   }

   @Override
   public CharacterRange newCharacterRange(String text, String startToken, String endToken) {

      final String[] split = text.split("[.]{2}");
      final String first = StringUtil.trimEnds(1, split[0]);
      final String last = StringUtil.trimEnds(1, split[1]);

      int tmpStart;
      int tmpEnd;
      if (first.startsWith("\\u")) {
         tmpStart = Integer.parseInt(first.substring(2), 16);
         tmpEnd = Integer.parseInt(last.substring(2), 16);
         final StringBuilder test = new StringBuilder();
         for (int i = tmpStart; i <= tmpEnd; i++)
            test.append(Character.toChars(i)[0]);
         tokenValues.add("Character Range " + text + " => " + test);
      } else {

         tmpStart = Character.codePointAt(first.toCharArray(), 0);
         tmpEnd = Character.codePointAt(last.toCharArray(), 0);
         final StringBuilder test = new StringBuilder();
         for (int i = tmpStart; i <= tmpEnd; i++)
            test.append(Character.toChars(i)[0]);
         tokenValues.add("Character Range " + text + " => " + test);
      }

      final int startOfRange = tmpStart;
      final int endOfRange = tmpEnd;
      return new CharacterRange(text, startToken, endToken) {
         @Override
         public String generateOutput(String delim) {
            return "" + StringUtil.randomCharacter(startOfRange, endOfRange);
         }
      };
   }

   @Override
   public NotSet newNotSet(String text, String startToken, String endToken) {
      return new NotSet(text, startToken, endToken) {
         @Override
         public String generateOutput(String delim) {
            final StringBuilder out = new StringBuilder();

            for (AntlrGrammarNode child : children) {
               final SetElement setElement = (SetElement) child;

               final char[] chars = setElement.text.toCharArray();

               int length = 1;//random.nextInt(5) + 2;
               for (int i = 0; i < length; i++) {
                  boolean excluded = true;
                  while (excluded) {
                     final Character candidate = StringUtil.randomCharacter();

                     boolean allowed = true;
                     for (char aChar : chars) {
                        if (aChar == candidate) {
                           allowed = false;
                           break;
                        }
                     }

                     if (allowed) {
                        excluded = false;
                        out.append(candidate);
                     }
                  }
               }
            }
            //log.info(label + " " + out.toString());

            return out.toString();
         }
      };
   }

   @Override
   public Terminal newTerminal(String text, String startToken, String endToken) {

      tokenValues.add("Terminal " + text);

      if (text.startsWith("'")) {

         final String t = StringUtil.trimEnds(1, text);

         return new Terminal(text, startToken, endToken) {
            @Override
            public String generateOutput(String delim) {
               return t.equals("\\r") ? "\r" : (t.equals("\\n") ? "\n" : (t.equals("\\t") ? "\t" : t));
            }
         };
      }

      return new Terminal(text, startToken, endToken) {
         @Override
         public String generateOutput(String delim) {
            final AntlrGrammarNode antlrGrammarNode = ruleSpecs.get(text);
            if (antlrGrammarNode == null) log.info(text);
            return antlrGrammarNode.generateOutput(delim + "\t");
         }
      };
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

   public static void main(String[] grammarNodes) throws IOException {
      final AntlrGrammarModel model = new AntlrGrammarModel();
      final boolean debug = true;

      //      new ParseTreeWalker().walk(model.getParserListener(debug), new ANTLRv4Parser(new CommonTokenStream(new ANTLRv4Lexer(CharStreams.fromFileName(ProjectConstants.GENERATORS_ROOT + "antlr/parser/ANTLRv4Parser.g4")))).grammarSpec());
//      new ParseTreeWalker().walk(model.getParserListener(debug), new ANTLRv4Parser(new CommonTokenStream(new ANTLRv4Lexer(CharStreams.fromFileName(ProjectConstants.GENERATORS_ROOT + "antlr/parser/ANTLRv4Lexer.g4")))).grammarSpec());
//      new ParseTreeWalker().walk(model.getParserListener(debug), new ANTLRv4Parser(new CommonTokenStream(new ANTLRv4Lexer(CharStreams.fromFileName(ProjectConstants.GENERATORS_ROOT + "antlr/parser/LexBasic.g4")))).grammarSpec());
//
      testCSV(model, debug);
//      testJSON(model, debug);
   }

   public static void testCSV(AntlrGrammarModel model, boolean debug) throws IOException {
      new ParseTreeWalker().walk(model.getANTLRv4ParserNodeListener(debug), new ANTLRv4Parser(new CommonTokenStream(new ANTLRv4Lexer(CharStreams.fromFileName(ProjectConstants.GENERATORS_ROOT + "csv/parser/CSV.g4")))).grammarSpec());
      model.showDistinct();
      final String[] generate = generate(model, 1);
      for (String s : generate) parseCSV(s);
   }

   public static void testJSON(AntlrGrammarModel model, boolean debug) throws IOException {
      new ParseTreeWalker().walk(model.getANTLRv4ParserNodeListener(debug), new ANTLRv4Parser(new CommonTokenStream(new ANTLRv4Lexer(CharStreams.fromFileName(ProjectConstants.GENERATORS_ROOT + "json/parser/JSON.g4")))).grammarSpec());
      model.showDistinct();
      final String[] generate = generate(model, 1);
      for (String s : generate) parseJSON(s);
   }

   public static void parseJSON(String output) {
      log.info("Output " + output);
      final JSONNodeListener listener = new JSONNodeListener(true);
      new ParseTreeWalker().walk(listener, new JSONParser(new CommonTokenStream(new JSONLexer(CharStreams.fromString(output)))).json());
   }

   public static void parseCSV(String output) {
      log.info("Output " + output);
      final CSVListener listener = new CSVNodeListener(true);
      new ParseTreeWalker().walk(listener, new CSVParser(new CommonTokenStream(new JSONLexer(CharStreams.fromString(output)))).csvFile());
   }

   public static String[] generate(AntlrGrammarModel model, int samples) {
      String[] array = new String[samples];
      for (int i = 0; i < samples; i++)
         array[i] = model.getGrammarSpec().generateOutput("");
      return array;
   }
}